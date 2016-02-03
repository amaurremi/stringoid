package com.vladium.emma.instr;

import com.vladium.emma.IAppConstants;
import com.vladium.emma.data.ClassDescriptor;
import com.vladium.emma.data.CoverageOptions;
import com.vladium.emma.data.MethodDescriptor;
import com.vladium.jcd.cls.AbstractClassDefVisitor;
import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.cls.ElementFactory;
import com.vladium.jcd.cls.Field_info;
import com.vladium.jcd.cls.IAttributeCollection;
import com.vladium.jcd.cls.IClassDefVisitor;
import com.vladium.jcd.cls.IConstantCollection;
import com.vladium.jcd.cls.IFieldCollection;
import com.vladium.jcd.cls.IInterfaceCollection;
import com.vladium.jcd.cls.IMethodCollection;
import com.vladium.jcd.cls.Method_info;
import com.vladium.jcd.cls.attribute.AttributeElementFactory;
import com.vladium.jcd.cls.attribute.Attribute_info;
import com.vladium.jcd.cls.attribute.BridgeAttribute_info;
import com.vladium.jcd.cls.attribute.CodeAttribute_info;
import com.vladium.jcd.cls.attribute.ConstantValueAttribute_info;
import com.vladium.jcd.cls.attribute.Exception_info;
import com.vladium.jcd.cls.attribute.ExceptionsAttribute_info;
import com.vladium.jcd.cls.attribute.GenericAttribute_info;
import com.vladium.jcd.cls.attribute.IAttributeVisitor;
import com.vladium.jcd.cls.attribute.IExceptionHandlerTable;
import com.vladium.jcd.cls.attribute.InnerClassesAttribute_info;
import com.vladium.jcd.cls.attribute.LineNumberTableAttribute_info;
import com.vladium.jcd.cls.attribute.LineNumber_info;
import com.vladium.jcd.cls.attribute.SourceFileAttribute_info;
import com.vladium.jcd.cls.attribute.SyntheticAttribute_info;
import com.vladium.jcd.cls.constant.CONSTANT_Class_info;
import com.vladium.jcd.cls.constant.CONSTANT_Long_info;
import com.vladium.jcd.cls.constant.CONSTANT_Methodref_info;
import com.vladium.jcd.cls.constant.CONSTANT_String_info;
import com.vladium.jcd.cls.constant.CONSTANT_Utf8_info;
import com.vladium.jcd.compiler.CodeGen;
import com.vladium.jcd.lib.Types;
import com.vladium.jcd.opcodes.IOpcodes;
import com.vladium.logging.Logger;
import com.vladium.util.ByteArrayOStream;
import com.vladium.util.IConstants;
import com.vladium.util.IntIntMap;
import com.vladium.util.IntObjectMap;
import com.vladium.util.IntSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class InstrVisitor
  extends AbstractClassDefVisitor
  implements IClassDefVisitor, IAttributeVisitor, IOpcodes, IConstants
{
  private static final String COVERAGE_FIELD_NAME = "$VRc";
  private static final int EMIT_CTX_MIN_INIT_CAPACITY = 64;
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private static final String JAVA_IO_EXTERNALIZABLE_NAME = "java/io/Externalizable";
  private static final String JAVA_IO_SERIALIZABLE_NAME = "java/io/Serializable";
  private static final LineNumberComparator LINE_NUMBER_COMPARATOR = new LineNumberComparator(null);
  private static final boolean MARK_ADDED_ELEMENTS_SYNTHETIC = true;
  private static final long NBEAST = 16661L;
  private static final int PRECLINIT_INIT_CAPACITY = 128;
  private static final String PRECLINIT_METHOD_NAME = "$VRi";
  private static final boolean SKIP_SYNTHETIC_CLASSES = false;
  private static final String SUID_FIELD_NAME = "serialVersionUID";
  int[] m_classBlockCounts;
  private int[][][] m_classBlockMetadata;
  int m_classInstrMethodCount;
  private MethodDescriptor[] m_classMethodDescriptors;
  private String m_className;
  int m_classNameConstantIndex;
  private String m_classPackageName;
  private long m_classSignature;
  private String m_classSrcFileName;
  private int m_clinitID;
  private int m_clinitStatus;
  ClassDef m_cls;
  int m_coverageFieldrefIndex;
  private final boolean m_doSUIDCompensation;
  private final boolean m_excludeBridgeMethods;
  private final boolean m_excludeSyntheticMethods;
  private boolean m_ignoreAlreadyInstrumented;
  private boolean m_instrument;
  private final Logger m_log;
  private boolean m_metadata;
  private int[] m_methodBlockOffsets;
  private int[] m_methodBlockSizes;
  private int m_methodFirstLine;
  int m_methodID;
  private int[] m_methodJumpAdjOffsets;
  private int[] m_methodJumpAdjValues;
  private String m_methodName;
  int m_preclinitMethodrefIndex;
  private int m_registerMethodrefIndex;
  private int m_stampIndex;
  private int m_syntheticStringIndex;
  private boolean m_warningIssued;
  
  public InstrVisitor(CoverageOptions paramCoverageOptions)
  {
    this.m_excludeSyntheticMethods = paramCoverageOptions.excludeSyntheticMethods();
    this.m_excludeBridgeMethods = paramCoverageOptions.excludeBridgeMethods();
    this.m_doSUIDCompensation = paramCoverageOptions.doSUIDCompensation();
    this.m_log = Logger.getLogger();
  }
  
  private void consumeSignatureData(int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    long l = this.m_classSignature * 16661L + (paramInt + 1) * i;
    paramInt = 1;
    while (paramInt < i)
    {
      l = 16661L * l + paramArrayOfInt[paramInt];
      paramInt += 1;
    }
    this.m_classSignature = l;
  }
  
  private static int lowbound(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length - 1;
    while (i <= j)
    {
      int k = i + j >> 1;
      int m = paramArrayOfInt[k];
      if (m == paramInt) {
        return k;
      }
      if (m < paramInt) {
        i = k + 1;
      } else {
        j = k - 1;
      }
    }
    return j;
  }
  
  private void reset()
  {
    this.m_instrument = false;
    this.m_metadata = false;
    this.m_ignoreAlreadyInstrumented = false;
    this.m_cls = null;
    this.m_classPackageName = null;
    this.m_className = null;
    this.m_classSrcFileName = null;
    this.m_classBlockMetadata = ((int[][][])null);
    this.m_classMethodDescriptors = null;
    this.m_syntheticStringIndex = -1;
    this.m_coverageFieldrefIndex = -1;
    this.m_registerMethodrefIndex = -1;
    this.m_preclinitMethodrefIndex = -1;
    this.m_classNameConstantIndex = -1;
    this.m_clinitID = -1;
    this.m_clinitStatus = 0;
    this.m_classInstrMethodCount = -1;
    this.m_classBlockCounts = null;
    this.m_classSignature = 0L;
    this.m_methodID = -1;
    this.m_methodName = null;
    this.m_methodFirstLine = 0;
    this.m_methodBlockOffsets = null;
    this.m_methodJumpAdjOffsets = null;
    this.m_methodJumpAdjValues = null;
  }
  
  private void setClassName(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    if (i < 0)
    {
      this.m_classPackageName = "";
      this.m_className = paramString;
      return;
    }
    this.m_classPackageName = paramString.substring(0, i);
    this.m_className = paramString.substring(i + 1);
  }
  
  public void process(ClassDef paramClassDef, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, InstrResult paramInstrResult)
  {
    paramInstrResult.m_instrumented = false;
    paramInstrResult.m_descriptor = null;
    if ((!paramBoolean2) && (!paramBoolean3)) {}
    while (paramClassDef.isInterface()) {
      return;
    }
    reset();
    this.m_cls = paramClassDef;
    this.m_instrument = paramBoolean2;
    this.m_metadata = paramBoolean3;
    this.m_ignoreAlreadyInstrumented = paramBoolean1;
    visit((ClassDef)null, null);
    if (this.m_metadata)
    {
      setClassName(paramClassDef.getName());
      paramInstrResult.m_descriptor = new ClassDescriptor(this.m_classPackageName, this.m_className, this.m_classSignature, this.m_classSrcFileName, this.m_classMethodDescriptors);
    }
    paramInstrResult.m_instrumented = this.m_instrument;
  }
  
  public Object visit(ClassDef paramClassDef, Object paramObject)
  {
    ClassDef localClassDef = this.m_cls;
    Object localObject1 = localClassDef.getName();
    paramClassDef = Types.vmNameToJavaName((String)localObject1);
    boolean bool = this.m_log.atTRACE1();
    if (bool) {
      this.m_log.trace1("visit", "class: [" + (String)localObject1 + "]");
    }
    if ((!this.m_warningIssued) && (paramClassDef.startsWith(IAppConstants.APP_PACKAGE)))
    {
      this.m_warningIssued = true;
      this.m_log.warning("EMMA classes appear to be included on the instrumentation");
      this.m_log.warning("path: this is not a correct way to use EMMA");
    }
    if (localClassDef.getFields("$VRc").length > 0)
    {
      this.m_instrument = false;
      this.m_metadata = false;
      if (this.m_ignoreAlreadyInstrumented)
      {
        if (bool) {
          this.m_log.trace1("visit", "skipping instrumented class");
        }
        return paramObject;
      }
      throw new IllegalStateException("class [" + paramClassDef + "] appears to be instrumented already");
    }
    IConstantCollection localIConstantCollection = localClassDef.getConstants();
    this.m_syntheticStringIndex = localClassDef.addCONSTANT_Utf8("Synthetic", true);
    Object localObject2 = ElementFactory.newAttributeCollection(1);
    localObject1 = new SyntheticAttribute_info(this.m_syntheticStringIndex);
    ((IAttributeCollection)localObject2).add((Attribute_info)localObject1);
    this.m_coverageFieldrefIndex = localClassDef.addFieldref(localClassDef.addField("$VRc", "[[Z", 26, (IAttributeCollection)localObject2));
    this.m_registerMethodrefIndex = localIConstantCollection.add(new CONSTANT_Methodref_info(localClassDef.addClassref("com/vladium/emma/rt/RT"), localClassDef.addNameType("r", "([[ZLjava/lang/String;J)V")));
    int i = localClassDef.addNameType("$VRi", "()[[Z");
    this.m_preclinitMethodrefIndex = localIConstantCollection.add(new CONSTANT_Methodref_info(localClassDef.getThisClassIndex(), i));
    this.m_classNameConstantIndex = localIConstantCollection.add(new CONSTANT_String_info(localClassDef.getThisClass().m_name_index));
    visit(localClassDef.getMethods(), paramObject);
    int m;
    int k;
    int n;
    int j;
    Object localObject3;
    label436:
    int i1;
    if (this.m_doSUIDCompensation)
    {
      if ((this.m_clinitStatus & 0x8) == 0) {
        break label770;
      }
      i = 1;
      m = 0;
      k = i;
      if (i != 0)
      {
        localObject2 = localClassDef.getFields("serialVersionUID");
        n = localObject2.length;
        j = i;
        if (n > 0)
        {
          localObject3 = localClassDef.getFields();
          k = 0;
          j = i;
          if (k < n)
          {
            if ((((IFieldCollection)localObject3).get(localObject2[k]).getAccessFlags() & 0x18) != 24) {
              break label775;
            }
            j = 0;
          }
        }
        k = j;
        m = n;
        if (j != 0)
        {
          k = j;
          m = n;
          if (localClassDef.getThisClassIndex() == 0)
          {
            m = 0;
            localObject2 = localClassDef.getInterfaces();
            k = 0;
            i1 = ((IInterfaceCollection)localObject2).size();
          }
        }
      }
    }
    for (;;)
    {
      i = m;
      if (k < i1)
      {
        localObject3 = ((CONSTANT_Class_info)localIConstantCollection.get(((IInterfaceCollection)localObject2).get(k))).getName(localClassDef);
        if (("java/io/Serializable".equals(localObject3)) || ("java/io/Externalizable".equals(localObject3))) {
          i = 1;
        }
      }
      else
      {
        k = j;
        m = n;
        if (i == 0)
        {
          k = 0;
          m = n;
        }
        if (k != 0)
        {
          if (m > 0)
          {
            this.m_log.warning("class [" + paramClassDef + "] declares a 'serialVersionUID'");
            this.m_log.warning("field that is not static and final: this is likely an implementation mistake");
            this.m_log.warning("and can interfere with EMMA's SUID compensation");
          }
          localObject2 = ElementFactory.newAttributeCollection(2);
          ((IAttributeCollection)localObject2).add(new ConstantValueAttribute_info(localClassDef.addCONSTANT_Utf8("ConstantValue", true), localIConstantCollection.add(new CONSTANT_Long_info(localClassDef.computeSUID(true)))));
          paramClassDef = (ClassDef)localObject1;
          if (localObject1 == null) {
            paramClassDef = new SyntheticAttribute_info(this.m_syntheticStringIndex);
          }
          ((IAttributeCollection)localObject2).add(paramClassDef);
          localClassDef.addField("serialVersionUID", "J", 26, (IAttributeCollection)localObject2);
        }
        visit(localClassDef.getAttributes(), paramObject);
        return paramObject;
        label770:
        i = 0;
        break;
        label775:
        k += 1;
        break label436;
      }
      k += 1;
    }
  }
  
  public Object visit(IAttributeCollection paramIAttributeCollection, Object paramObject)
  {
    int i = 0;
    int j = paramIAttributeCollection.size();
    while (i < j)
    {
      paramIAttributeCollection.get(i).accept(this, paramObject);
      i += 1;
    }
    return paramObject;
  }
  
  public Object visit(IMethodCollection paramIMethodCollection, Object paramObject)
  {
    ClassDef localClassDef = this.m_cls;
    boolean bool1 = this.m_log.atTRACE2();
    int m = paramIMethodCollection.size();
    boolean bool2 = this.m_metadata;
    this.m_classBlockCounts = new int[m + 1];
    if (bool2)
    {
      this.m_classBlockMetadata = new int[m + 1][][];
      this.m_classMethodDescriptors = new MethodDescriptor[m];
    }
    int j = 0;
    if (j < m)
    {
      localObject2 = paramIMethodCollection.get(j);
      this.m_methodName = ((Method_info)localObject2).getName(localClassDef);
      StringBuilder localStringBuilder;
      label128:
      boolean bool3;
      if (bool1)
      {
        localObject3 = this.m_log;
        localStringBuilder = new StringBuilder();
        if (((Method_info)localObject2).isSynthetic())
        {
          localObject1 = "synthetic ";
          ((Logger)localObject3).trace2("visit", (String)localObject1 + "method #" + j + ": [" + this.m_methodName + "]");
        }
      }
      else
      {
        bool3 = "<clinit>".equals(this.m_methodName);
        k = 0;
        i = k;
        if (!bool3)
        {
          if ((!this.m_excludeSyntheticMethods) || (!((Method_info)localObject2).isSynthetic())) {
            break label301;
          }
          k = 1;
          i = k;
          if (bool1)
          {
            this.m_log.trace2("visit", "skipped synthetic method");
            i = k;
          }
        }
        label241:
        if (i == 0) {
          break label352;
        }
        if (bool2) {
          this.m_classMethodDescriptors[j] = new MethodDescriptor(this.m_methodName, ((Method_info)localObject2).getDescriptor(localClassDef), 4, this.m_methodBlockSizes, (int[][])null, 0);
        }
      }
      label301:
      label352:
      label521:
      do
      {
        for (;;)
        {
          j += 1;
          break;
          localObject1 = "";
          break label128;
          i = k;
          if (!this.m_excludeBridgeMethods) {
            break label241;
          }
          i = k;
          if (!((Method_info)localObject2).isBridge()) {
            break label241;
          }
          k = 1;
          i = k;
          if (!bool1) {
            break label241;
          }
          this.m_log.trace2("visit", "skipped bridge method");
          i = k;
          break label241;
          if ((((Method_info)localObject2).getAccessFlags() & 0x500) != 0)
          {
            if (bool2) {
              this.m_classMethodDescriptors[j] = new MethodDescriptor(this.m_methodName, ((Method_info)localObject2).getDescriptor(localClassDef), 2, this.m_methodBlockSizes, (int[][])null, 0);
            }
            if (bool1)
            {
              localObject3 = this.m_log;
              localStringBuilder = new StringBuilder().append("skipped ");
              if (((Method_info)localObject2).isAbstract()) {}
              for (localObject1 = "abstract";; localObject1 = "native")
              {
                ((Logger)localObject3).trace2("visit", (String)localObject1 + " method");
                break;
              }
            }
          }
          else
          {
            this.m_methodFirstLine = 0;
            this.m_methodID = j;
            if (!bool3) {
              break label521;
            }
            this.m_clinitID = j;
            if (bool1) {
              this.m_log.trace2("visit", "<clinit> method delayed");
            }
          }
        }
        localObject1 = ((Method_info)localObject2).getAttributes();
        k = ((IAttributeCollection)localObject1).size();
        i = 0;
        while (i < k)
        {
          ((IAttributeCollection)localObject1).get(i).accept(this, paramObject);
          i += 1;
        }
      } while (!bool2);
      localObject1 = this.m_classBlockMetadata[this.m_methodID];
      if (localObject1 == null) {}
      for (i = 1;; i = 0)
      {
        this.m_classMethodDescriptors[j] = new MethodDescriptor(this.m_methodName, ((Method_info)localObject2).getDescriptor(localClassDef), i, this.m_methodBlockSizes, (int[][])localObject1, this.m_methodFirstLine);
        break;
      }
    }
    if (this.m_clinitID >= 0)
    {
      paramIMethodCollection = paramIMethodCollection.get(this.m_clinitID);
      this.m_classInstrMethodCount = m;
      this.m_methodFirstLine = 0;
      this.m_methodID = this.m_clinitID;
      if (bool1)
      {
        localObject2 = this.m_log;
        localObject3 = new StringBuilder();
        if (!paramIMethodCollection.isSynthetic()) {
          break label937;
        }
      }
    }
    label937:
    for (Object localObject1 = "synthetic ";; localObject1 = "")
    {
      ((Logger)localObject2).trace2("visit", (String)localObject1 + "method #" + this.m_methodID + ": [<clinit>]");
      localObject1 = paramIMethodCollection.getAttributes();
      j = ((IAttributeCollection)localObject1).size();
      i = 0;
      while (i < j)
      {
        ((IAttributeCollection)localObject1).get(i).accept(this, paramObject);
        i += 1;
      }
      this.m_clinitStatus = 8;
      i = localClassDef.addCONSTANT_Utf8("Code", true);
      j = localClassDef.addCONSTANT_Utf8("<clinit>", true);
      k = localClassDef.addCONSTANT_Utf8("()V", true);
      paramIMethodCollection = ElementFactory.newAttributeCollection(2);
      localObject1 = AttributeElementFactory.newExceptionHandlerTable(0);
      localObject2 = ElementFactory.newAttributeCollection(0);
      paramIMethodCollection.add(new CodeAttribute_info(i, 0, 0, new byte[] { -79 }, (IExceptionHandlerTable)localObject1, (IAttributeCollection)localObject2));
      paramIMethodCollection.add(new SyntheticAttribute_info(this.m_syntheticStringIndex));
      paramIMethodCollection = new Method_info(10, j, k, paramIMethodCollection);
      this.m_clinitID = localClassDef.addMethod(paramIMethodCollection);
      if (bool1) {
        this.m_log.trace2("visit", "added synthetic <clinit> method");
      }
      this.m_classInstrMethodCount = (m + 1);
      break;
    }
    j = localClassDef.addCONSTANT_Utf8("Code", true);
    int k = localClassDef.addCONSTANT_Utf8("$VRi", false);
    m = localClassDef.addCONSTANT_Utf8("()[[Z", false);
    localObject1 = ElementFactory.newAttributeCollection(2);
    Object localObject2 = new ByteArrayOStream(128);
    Object localObject3 = this.m_classBlockCounts;
    int n = this.m_classInstrMethodCount;
    CodeGen.push_int_value((ByteArrayOStream)localObject2, localClassDef, n);
    int i = localClassDef.addClassref("[[Z");
    ((ByteArrayOStream)localObject2).write4(197, i >>> 8, i, 1);
    ((ByteArrayOStream)localObject2).write4(89, 179, this.m_coverageFieldrefIndex >>> 8, this.m_coverageFieldrefIndex);
    i = 0;
    while (i < n)
    {
      int i1 = localObject3[i];
      if (i1 > 0)
      {
        ((ByteArrayOStream)localObject2).write(89);
        CodeGen.push_int_value((ByteArrayOStream)localObject2, localClassDef, i);
        CodeGen.push_int_value((ByteArrayOStream)localObject2, localClassDef, i1);
        ((ByteArrayOStream)localObject2).write3(188, 4, 83);
      }
      i += 1;
    }
    ((ByteArrayOStream)localObject2).write(89);
    CodeGen.push_constant_index((ByteArrayOStream)localObject2, this.m_classNameConstantIndex);
    ((ByteArrayOStream)localObject2).write3(20, this.m_stampIndex >>> 8, this.m_stampIndex);
    ((ByteArrayOStream)localObject2).write3(184, this.m_registerMethodrefIndex >>> 8, this.m_registerMethodrefIndex);
    ((ByteArrayOStream)localObject2).write(176);
    localObject3 = new CodeAttribute_info(j, 5, 0, EMPTY_BYTE_ARRAY, AttributeElementFactory.newExceptionHandlerTable(0), ElementFactory.newAttributeCollection(0));
    ((CodeAttribute_info)localObject3).setCode(((ByteArrayOStream)localObject2).getByteArray(), ((ByteArrayOStream)localObject2).size());
    ((IAttributeCollection)localObject1).add((Attribute_info)localObject3);
    ((IAttributeCollection)localObject1).add(new SyntheticAttribute_info(this.m_syntheticStringIndex));
    localClassDef.addMethod(new Method_info(10, k, m, (IAttributeCollection)localObject1));
    if (bool1) {
      this.m_log.trace2("visit", "added synthetic pre-<clinit> method");
    }
    if (bool2)
    {
      localObject1 = this.m_classBlockMetadata[this.m_methodID];
      j = this.m_clinitStatus;
      if (localObject1 != null) {
        break label1376;
      }
    }
    label1376:
    for (i = 1;; i = 0)
    {
      this.m_clinitStatus = (i | j);
      if ((this.m_clinitStatus & 0x8) == 0) {
        this.m_classMethodDescriptors[this.m_methodID] = new MethodDescriptor("<clinit>", paramIMethodCollection.getDescriptor(localClassDef), this.m_clinitStatus, this.m_methodBlockSizes, (int[][])localObject1, this.m_methodFirstLine);
      }
      return paramObject;
    }
  }
  
  public Object visit(BridgeAttribute_info paramBridgeAttribute_info, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(CodeAttribute_info paramCodeAttribute_info, Object paramObject)
  {
    boolean bool1 = this.m_log.atTRACE2();
    boolean bool2 = this.m_log.atTRACE3();
    Object localObject2 = paramCodeAttribute_info.getCode();
    int i3 = paramCodeAttribute_info.getCodeSize();
    if (bool1) {
      this.m_log.trace2("visit", "code attribute for method #" + this.m_methodID + ": size = " + i3);
    }
    Object localObject5 = new IntSet();
    Object localObject3 = new IntIntMap();
    ((IntSet)localObject5).add(0);
    Object localObject1 = paramCodeAttribute_info.getExceptionTable();
    int j = ((IExceptionHandlerTable)localObject1).size();
    int i = 0;
    while (i < j)
    {
      ((IntSet)localObject5).add(((IExceptionHandlerTable)localObject1).get(i).m_handler_pc);
      i += 1;
    }
    Object localObject4 = new IntObjectMap();
    i = 0;
    int i1 = 0;
    int m = 0;
    ((IntIntMap)localObject3).put(0, 0);
    int n = 0;
    int i2;
    label443:
    label458:
    label465:
    int i5;
    int i6;
    int i7;
    if (n < i3)
    {
      i4 = localObject2[n] & 0xFF;
      i2 = 0;
      j = i;
      if (i != 0)
      {
        ((IntSet)localObject5).add(n);
        j = 0;
      }
      i = j;
      k = i2;
      switch (i4)
      {
      default: 
        k = i2;
        i = j;
      case 178: 
      case 179: 
      case 180: 
      case 181: 
      case 182: 
      case 183: 
      case 184: 
      case 185: 
      case 186: 
      case 187: 
      case 188: 
      case 189: 
      case 190: 
      case 192: 
      case 193: 
      case 194: 
      case 195: 
      case 196: 
      case 197: 
        if (k == 0) {
          if (i1 != 0)
          {
            localObject1 = WIDE_SIZE;
            j = localObject1[i4];
            n += j;
            if (i4 != 196) {
              break label1722;
            }
          }
        }
        break;
      }
      label1722:
      for (j = 1;; j = 0)
      {
        m += 1;
        ((IntIntMap)localObject3).put(n, m);
        i1 = j;
        break;
        i = n + 1;
        i = n + (localObject2[i] << 8 | localObject2[(i + 1)] & 0xFF);
        ((IntSet)localObject5).add(i);
        ((IntObjectMap)localObject4).put(n, new IFJUMP2(i4, i));
        i = 1;
        k = i2;
        break label443;
        i = n + 1;
        i = n + (localObject2[i] << 8 | localObject2[(i + 1)] & 0xFF);
        ((IntSet)localObject5).add(i);
        ((IntObjectMap)localObject4).put(n, new JUMP2(i4, i));
        i = 1;
        k = i2;
        break label443;
        j = n + 4 - (n & 0x3);
        i = localObject2[j];
        k = j + 1;
        j = localObject2[k];
        i2 = k + 1;
        k = localObject2[i2];
        i2 += 1;
        i = i << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | localObject2[i2] & 0xFF;
        ((IntSet)localObject5).add(n + i);
        j = i2 + 1;
        k = localObject2[j];
        j += 1;
        i2 = localObject2[j];
        j += 1;
        i5 = localObject2[j];
        j += 1;
        k = (k & 0xFF) << 24 | (i2 & 0xFF) << 16 | (i5 & 0xFF) << 8 | localObject2[j] & 0xFF;
        localObject1 = new int[k];
        localObject6 = new int[k + 1];
        localObject6[0] = (n + i);
        i = 0;
        while (i < k)
        {
          i2 = j + 1;
          j = localObject2[i2];
          i5 = i2 + 1;
          i2 = localObject2[i5];
          i6 = i5 + 1;
          i5 = localObject2[i6];
          i6 += 1;
          localObject1[i] = (j << 24 | (i2 & 0xFF) << 16 | (i5 & 0xFF) << 8 | localObject2[i6] & 0xFF);
          j = i6 + 1;
          i2 = localObject2[j];
          j += 1;
          i5 = localObject2[j];
          j += 1;
          i6 = localObject2[j];
          j += 1;
          i2 = i2 << 24 | (i5 & 0xFF) << 16 | (i6 & 0xFF) << 8 | localObject2[j] & 0xFF;
          localObject6[(i + 1)] = (n + i2);
          ((IntSet)localObject5).add(n + i2);
          i += 1;
        }
        ((IntObjectMap)localObject4).put(n, new LOOKUPSWITCH((int[])localObject1, (int[])localObject6));
        i = 1;
        k = n - j - 1;
        break label443;
        j = n + 4 - (n & 0x3);
        i = localObject2[j];
        k = j + 1;
        j = localObject2[k];
        i2 = k + 1;
        k = localObject2[i2];
        i2 += 1;
        i = i << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | localObject2[i2] & 0xFF;
        ((IntSet)localObject5).add(n + i);
        k = i2 + 1;
        j = localObject2[k];
        i2 = k + 1;
        k = localObject2[i2];
        i5 = i2 + 1;
        i2 = localObject2[i5];
        i5 += 1;
        k = j << 24 | (k & 0xFF) << 16 | (i2 & 0xFF) << 8 | localObject2[i5] & 0xFF;
        j = i5 + 1;
        i2 = localObject2[j];
        j += 1;
        i5 = localObject2[j];
        j += 1;
        i6 = localObject2[j];
        j += 1;
        i2 = i2 << 24 | (i5 & 0xFF) << 16 | (i6 & 0xFF) << 8 | localObject2[j] & 0xFF;
        localObject1 = new int[i2 - k + 2];
        localObject1[0] = (n + i);
        i = k;
        while (i <= i2)
        {
          j += 1;
          i5 = localObject2[j];
          j += 1;
          i6 = localObject2[j];
          j += 1;
          i7 = localObject2[j];
          j += 1;
          i5 = i5 << 24 | (i6 & 0xFF) << 16 | (i7 & 0xFF) << 8 | localObject2[j] & 0xFF;
          localObject1[(i - k + 1)] = (n + i5);
          ((IntSet)localObject5).add(n + i5);
          i += 1;
        }
        ((IntObjectMap)localObject4).put(n, new TABLESWITCH(k, i2, (int[])localObject1));
        i = 1;
        k = n - j - 1;
        break label443;
        j = n + 1;
        i = localObject2[j];
        k = j + 1;
        j = localObject2[k];
        k += 1;
        i = n + (i << 24 | (j & 0xFF) << 16 | (localObject2[k] & 0xFF) << 8 | localObject2[(k + 1)] & 0xFF);
        ((IntSet)localObject5).add(i);
        ((IntObjectMap)localObject4).put(n, new JUMP4(i4, i));
        i = 1;
        k = i2;
        break label443;
        i = n + 1;
        if (i1 != 0) {}
        for (i = (localObject2[i] & 0xFF) << 8 | localObject2[(i + 1)] & 0xFF;; i = localObject2[i] & 0xFF)
        {
          ((IntObjectMap)localObject4).put(n, new RET(i4, i));
          i = 1;
          k = i2;
          break;
        }
        ((IntObjectMap)localObject4).put(n, new TERMINATE(i4));
        i = 1;
        k = i2;
        break label443;
        localObject1 = NARROW_SIZE;
        break label458;
        j = -k;
        break label465;
      }
    }
    int i4 = ((IntSet)localObject5).size();
    if (bool1) {
      this.m_log.trace2("visit", "method contains " + i4 + " basic blocks");
    }
    localObject1 = new BlockList(i4);
    Object localObject7 = new int[i4 + 1];
    ((IntSet)localObject5).values((int[])localObject7, 0);
    localObject7[i4] = i3;
    Arrays.sort((int[])localObject7);
    int[] arrayOfInt = ((IntObjectMap)localObject4).keys();
    Arrays.sort(arrayOfInt);
    localObject5 = new IntIntMap(localObject7.length);
    if (this.m_metadata)
    {
      this.m_methodBlockSizes = new int[i4];
      this.m_methodBlockOffsets = ((int[])localObject7);
    }
    consumeSignatureData(this.m_methodID, (int[])localObject7);
    Object localObject6 = new int[1];
    i = 0;
    j = 0;
    for (m = 0;; m = n)
    {
      k = i;
      if (j >= i4) {
        break;
      }
      Block localBlock = new Block(null);
      ((BlockList)localObject1).m_blocks.add(localBlock);
      i5 = localObject7[j];
      localBlock.m_first = i5;
      ((IntIntMap)localObject5).put(i5, j);
      i6 = localObject7[(j + 1)];
      i2 = 0;
      n = m;
      i1 = i2;
      i = k;
      if (arrayOfInt.length > m)
      {
        i7 = arrayOfInt[m];
        n = m;
        i1 = i2;
        i = k;
        if (i7 < i6)
        {
          i1 = 1;
          localBlock.m_length = (i7 - i5);
          ((IntIntMap)localObject3).get(i7, (int[])localObject6);
          i = localObject6[0] + 1;
          localBlock.m_branch = ((Branch)((IntObjectMap)localObject4).get(i7));
          localBlock.m_branch.m_parentBlockID = j;
          n = m + 1;
        }
      }
      if (i1 == 0)
      {
        localBlock.m_length = (i6 - i5);
        ((IntIntMap)localObject3).get(i6, (int[])localObject6);
        i = localObject6[0];
      }
      localBlock.m_instrCount = (i - k);
      if (this.m_metadata) {
        this.m_methodBlockSizes[j] = localBlock.m_instrCount;
      }
      j += 1;
    }
    localObject3 = (Block[])((BlockList)localObject1).m_blocks.toArray(new Block[i4]);
    i = 0;
    while (i < i4)
    {
      localObject4 = localObject3[i];
      if (((Block)localObject4).m_branch != null)
      {
        localObject4 = ((Block)localObject4).m_branch.m_targets;
        if (localObject4 != null)
        {
          j = 0;
          k = localObject4.length;
          while (j < k)
          {
            ((IntIntMap)localObject5).get(localObject4[j], (int[])localObject6);
            localObject4[j] = localObject6[0];
            j += 1;
          }
        }
      }
      i += 1;
    }
    this.m_classBlockCounts[this.m_methodID] = i4;
    if (bool1) {
      this.m_log.trace2("visit", "instrumenting... ");
    }
    i1 = paramCodeAttribute_info.m_max_locals;
    paramCodeAttribute_info.m_max_locals = (i1 + 1);
    if (this.m_methodID == this.m_clinitID) {
      this.m_stampIndex = this.m_cls.getConstants().add(new CONSTANT_Long_info(this.m_classSignature));
    }
    for (((BlockList)localObject1).m_header = new clinitHeader(this, i1);; ((BlockList)localObject1).m_header = new methodHeader(this, i1))
    {
      n = ((BlockList)localObject1).m_header.maxstack();
      i = 0;
      j = 0;
      while (j < i4)
      {
        localObject4 = localObject3[j];
        localObject5 = new BlockSegment(this, i1, j);
        ((Block)localObject4).m_insertion = ((CodeSegment)localObject5);
        m = ((CodeSegment)localObject5).maxstack();
        k = i;
        if (m > i) {
          k = m;
        }
        j += 1;
        i = k;
      }
    }
    j = paramCodeAttribute_info.m_max_stack;
    paramCodeAttribute_info.m_max_stack += i;
    if (n > paramCodeAttribute_info.m_max_stack) {
      paramCodeAttribute_info.m_max_stack = n;
    }
    if (bool2) {
      this.m_log.trace3("visit", "increasing maxstack by " + (paramCodeAttribute_info.m_max_stack - j));
    }
    if (bool1) {
      this.m_log.trace2("visit", "assembling... ");
    }
    j = i3 << 1;
    i = j;
    if (j < 64) {
      i = 64;
    }
    localObject6 = new ByteArrayOStream(i);
    localObject7 = new EmitCtx((BlockList)localObject1, (ByteArrayOStream)localObject6);
    localObject4 = new int[i4];
    localObject5 = new int[localObject4.length];
    ((BlockList)localObject1).m_header.emit((EmitCtx)localObject7);
    localObject5[0] = ((EmitCtx)localObject7).m_out.size();
    i = 0;
    while (i < i4)
    {
      localObject1 = localObject3[i];
      if (i + 1 < i4) {
        localObject4[(i + 1)] = (localObject3[i].m_first + localObject3[i].m_length);
      }
      ((Block)localObject1).emit((EmitCtx)localObject7, (byte[])localObject2);
      if (i + 1 < i4) {
        localObject5[(i + 1)] = (((EmitCtx)localObject7).m_out.size() - localObject3[(i + 1)].m_first);
      }
      i += 1;
    }
    this.m_methodJumpAdjOffsets = ((int[])localObject4);
    this.m_methodJumpAdjValues = ((int[])localObject5);
    if (bool2)
    {
      localObject1 = new StringBuffer("jump adjustment map:" + EOL);
      i = 0;
      while (i < localObject4.length)
      {
        ((StringBuffer)localObject1).append("    " + localObject4[i] + ": +" + localObject5[i]);
        if (i < localObject4.length - 1) {
          ((StringBuffer)localObject1).append(EOL);
        }
        i += 1;
      }
      this.m_log.trace3("visit", ((StringBuffer)localObject1).toString());
    }
    localObject1 = ((ByteArrayOStream)localObject6).getByteArray();
    int k = ((ByteArrayOStream)localObject6).size();
    if (bool2) {
      this.m_log.trace3("visit", "backpatching " + ((EmitCtx)localObject7).m_backpatchQueue.size() + " ip(s)");
    }
    localObject2 = ((EmitCtx)localObject7).m_backpatchQueue.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject6 = (int[])((Iterator)localObject2).next();
      j = localObject6[1];
      m = localObject3[localObject6[3]].m_first - localObject6[2];
      i = j;
      switch (localObject6[0])
      {
      case 3: 
      default: 
        break;
      case 2: 
      case 4: 
        for (;;)
        {
          localObject1[i] = ((byte)(m >>> 8));
          localObject1[(i + 1)] = ((byte)m);
          break;
          n = j + 1;
          localObject1[j] = ((byte)(m >>> 24));
          i = n + 1;
          localObject1[n] = ((byte)(m >>> 16));
        }
      }
    }
    paramCodeAttribute_info.setCode((byte[])localObject1, k);
    if (bool1) {
      this.m_log.trace2("visit", "method assembled into " + k + " code bytes");
    }
    localObject1 = paramCodeAttribute_info.getExceptionTable();
    i = 0;
    while (i < ((IExceptionHandlerTable)localObject1).size())
    {
      localObject2 = ((IExceptionHandlerTable)localObject1).get(i);
      j = lowbound((int[])localObject4, ((Exception_info)localObject2).m_start_pc);
      ((Exception_info)localObject2).m_start_pc += localObject5[j];
      j = lowbound((int[])localObject4, ((Exception_info)localObject2).m_end_pc);
      ((Exception_info)localObject2).m_end_pc += localObject5[j];
      j = lowbound((int[])localObject4, ((Exception_info)localObject2).m_handler_pc);
      ((Exception_info)localObject2).m_handler_pc += localObject5[j];
      i += 1;
    }
    paramCodeAttribute_info = paramCodeAttribute_info.getAttributes();
    j = paramCodeAttribute_info.size();
    i = 0;
    while (i < j)
    {
      paramCodeAttribute_info.get(i).accept(this, paramObject);
      i += 1;
    }
    return paramObject;
  }
  
  public Object visit(ConstantValueAttribute_info paramConstantValueAttribute_info, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(ExceptionsAttribute_info paramExceptionsAttribute_info, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(GenericAttribute_info paramGenericAttribute_info, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(InnerClassesAttribute_info paramInnerClassesAttribute_info, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(LineNumberTableAttribute_info paramLineNumberTableAttribute_info, Object paramObject)
  {
    boolean bool1 = this.m_log.atTRACE2();
    boolean bool2 = this.m_log.atTRACE3();
    if (bool1) {
      this.m_log.trace2("visit", "attribute: [" + paramLineNumberTableAttribute_info.getName(this.m_cls) + "]");
    }
    int m = paramLineNumberTableAttribute_info.size();
    int j;
    Object localObject1;
    if (this.m_metadata)
    {
      if (bool1) {
        this.m_log.trace2("visit", "processing line number table for metadata...");
      }
      int n = this.m_classBlockCounts[this.m_methodID];
      int[][] arrayOfInt = new int[n][];
      if (m == 0)
      {
        i = 0;
        while (i < n)
        {
          arrayOfInt[i] = EMPTY_INT_ARRAY;
          i += 1;
        }
      }
      LineNumber_info[] arrayOfLineNumber_info = new LineNumber_info[paramLineNumberTableAttribute_info.size()];
      i = 0;
      while (i < m)
      {
        arrayOfLineNumber_info[i] = paramLineNumberTableAttribute_info.get(i);
        i += 1;
      }
      Arrays.sort(arrayOfLineNumber_info, LINE_NUMBER_COMPARATOR);
      int[] arrayOfInt1 = this.m_methodBlockOffsets;
      Object localObject3 = arrayOfLineNumber_info[0];
      Object localObject2 = null;
      this.m_methodFirstLine = ((LineNumber_info)localObject3).m_line_number;
      i = 0;
      j = 0;
      if (i < n)
      {
        IntSet localIntSet = new IntSet();
        int k = j;
        localObject1 = localObject3;
        Object localObject4 = localObject2;
        if (localObject2 != null)
        {
          k = j;
          localObject1 = localObject3;
          localObject4 = localObject2;
          if (((LineNumber_info)localObject3).m_start_pc > arrayOfInt1[i])
          {
            localIntSet.add(((LineNumber_info)localObject2).m_line_number);
            localObject4 = localObject2;
            localObject1 = localObject3;
            k = j;
          }
        }
        for (;;)
        {
          if (((LineNumber_info)localObject1).m_start_pc < arrayOfInt1[(i + 1)])
          {
            localIntSet.add(((LineNumber_info)localObject1).m_line_number);
            if (k != m - 1) {}
          }
          else
          {
            arrayOfInt[i] = localIntSet.values();
            i += 1;
            j = k;
            localObject3 = localObject1;
            localObject2 = localObject4;
            break;
          }
          localObject4 = localObject1;
          k += 1;
          localObject1 = arrayOfLineNumber_info[k];
        }
      }
      this.m_classBlockMetadata[this.m_methodID] = arrayOfInt;
      if (bool2)
      {
        localObject1 = new StringBuffer("block-line map for method #" + this.m_methodID + ":");
        i = 0;
        while (i < n)
        {
          ((StringBuffer)localObject1).append(EOL);
          ((StringBuffer)localObject1).append("    block " + i + ": ");
          localObject2 = arrayOfInt[i];
          j = 0;
          while (j < localObject2.length)
          {
            if (j != 0) {
              ((StringBuffer)localObject1).append(", ");
            }
            ((StringBuffer)localObject1).append(localObject2[j]);
            j += 1;
          }
          i += 1;
        }
        this.m_log.trace3("visit", ((StringBuffer)localObject1).toString());
      }
    }
    int i = 0;
    while (i < m)
    {
      localObject1 = paramLineNumberTableAttribute_info.get(i);
      j = lowbound(this.m_methodJumpAdjOffsets, ((LineNumber_info)localObject1).m_start_pc);
      ((LineNumber_info)localObject1).m_start_pc += this.m_methodJumpAdjValues[j];
      i += 1;
    }
    return paramObject;
  }
  
  public Object visit(SourceFileAttribute_info paramSourceFileAttribute_info, Object paramObject)
  {
    this.m_classSrcFileName = paramSourceFileAttribute_info.getSourceFile(this.m_cls).m_value;
    return paramObject;
  }
  
  public Object visit(SyntheticAttribute_info paramSyntheticAttribute_info, Object paramObject)
  {
    return paramObject;
  }
  
  private static final class Block
  {
    public InstrVisitor.Branch m_branch;
    int m_first;
    public InstrVisitor.CodeSegment m_insertion;
    int m_instrCount;
    int m_length;
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx, byte[] paramArrayOfByte)
    {
      ByteArrayOStream localByteArrayOStream = paramEmitCtx.m_out;
      int j = this.m_first;
      this.m_first = localByteArrayOStream.size();
      int i = 0;
      int k = this.m_length;
      while (i < k)
      {
        localByteArrayOStream.write(paramArrayOfByte[(j + i)]);
        i += 1;
      }
      if (this.m_insertion != null) {
        this.m_insertion.emit(paramEmitCtx);
      }
      if (this.m_branch != null) {
        this.m_branch.emit(paramEmitCtx);
      }
    }
  }
  
  private static final class BlockList
  {
    final List m_blocks;
    InstrVisitor.CodeSegment m_header;
    
    BlockList()
    {
      this.m_blocks = new ArrayList();
    }
    
    BlockList(int paramInt)
    {
      this.m_blocks = new ArrayList(paramInt);
    }
  }
  
  static final class BlockSegment
    extends InstrVisitor.CodeSegment
  {
    private static final int BLOCK_INIT_CAPACITY = 16;
    private final ByteArrayOStream m_buf;
    
    public BlockSegment(InstrVisitor paramInstrVisitor, int paramInt1, int paramInt2)
    {
      super();
      ByteArrayOStream localByteArrayOStream = new ByteArrayOStream(16);
      this.m_buf = localByteArrayOStream;
      paramInstrVisitor = paramInstrVisitor.m_cls;
      CodeGen.load_local_object_var(localByteArrayOStream, paramInt1);
      CodeGen.push_int_value(localByteArrayOStream, paramInstrVisitor, paramInt2);
      localByteArrayOStream.write2(4, 84);
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      try
      {
        this.m_buf.writeTo(paramEmitCtx.m_out);
        return;
      }
      catch (IOException paramEmitCtx) {}
    }
    
    int length()
    {
      return this.m_buf.size();
    }
    
    int maxstack()
    {
      return 3;
    }
  }
  
  static abstract class Branch
  {
    final byte m_opcode;
    int m_parentBlockID;
    final int[] m_targets;
    
    protected Branch(int paramInt, int[] paramArrayOfInt)
    {
      this.m_opcode = ((byte)paramInt);
      this.m_targets = paramArrayOfInt;
    }
    
    abstract void emit(InstrVisitor.EmitCtx paramEmitCtx);
    
    protected final void emitJumpOffset2(InstrVisitor.EmitCtx paramEmitCtx, int paramInt1, int paramInt2)
    {
      ByteArrayOStream localByteArrayOStream = paramEmitCtx.m_out;
      if (paramInt2 <= this.m_parentBlockID)
      {
        paramInt1 = ((InstrVisitor.Block)paramEmitCtx.m_blocks.m_blocks.get(paramInt2)).m_first - paramInt1;
        localByteArrayOStream.write2(paramInt1 >>> 8, paramInt1);
        return;
      }
      int i = localByteArrayOStream.size();
      localByteArrayOStream.write2(0, 0);
      paramEmitCtx.m_backpatchQueue.add(new int[] { 2, i, paramInt1, paramInt2 });
    }
    
    protected final void emitJumpOffset4(InstrVisitor.EmitCtx paramEmitCtx, int paramInt1, int paramInt2)
    {
      ByteArrayOStream localByteArrayOStream = paramEmitCtx.m_out;
      if (paramInt2 <= this.m_parentBlockID)
      {
        paramInt1 = ((InstrVisitor.Block)paramEmitCtx.m_blocks.m_blocks.get(paramInt2)).m_first - paramInt1;
        localByteArrayOStream.write4(paramInt1 >>> 24, paramInt1 >>> 16, paramInt1 >>> 8, paramInt1);
        return;
      }
      int i = localByteArrayOStream.size();
      localByteArrayOStream.write4(0, 0, 0, 0);
      paramEmitCtx.m_backpatchQueue.add(new int[] { 4, i, paramInt1, paramInt2 });
    }
    
    int maxlength()
    {
      return 1;
    }
  }
  
  static abstract class CodeSegment
  {
    final InstrVisitor m_visitor;
    
    CodeSegment(InstrVisitor paramInstrVisitor)
    {
      this.m_visitor = paramInstrVisitor;
    }
    
    abstract void emit(InstrVisitor.EmitCtx paramEmitCtx);
    
    abstract int length();
    
    abstract int maxstack();
  }
  
  static final class EmitCtx
  {
    final List m_backpatchQueue;
    final InstrVisitor.BlockList m_blocks;
    final ByteArrayOStream m_out;
    
    EmitCtx(InstrVisitor.BlockList paramBlockList, ByteArrayOStream paramByteArrayOStream)
    {
      this.m_blocks = paramBlockList;
      this.m_out = paramByteArrayOStream;
      this.m_backpatchQueue = new ArrayList();
    }
  }
  
  static final class IFJUMP2
    extends InstrVisitor.Branch
  {
    IFJUMP2(int paramInt1, int paramInt2)
    {
      super(new int[] { paramInt2 });
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      ByteArrayOStream localByteArrayOStream = paramEmitCtx.m_out;
      int i = this.m_targets[0];
      int j = localByteArrayOStream.size();
      localByteArrayOStream.write(this.m_opcode);
      emitJumpOffset2(paramEmitCtx, j, i);
    }
    
    int maxlength()
    {
      return 8;
    }
  }
  
  public static final class InstrResult
  {
    public ClassDescriptor m_descriptor;
    public boolean m_instrumented;
  }
  
  static final class JUMP2
    extends InstrVisitor.Branch
  {
    JUMP2(int paramInt1, int paramInt2)
    {
      super(new int[] { paramInt2 });
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      ByteArrayOStream localByteArrayOStream = paramEmitCtx.m_out;
      int i = this.m_targets[0];
      int j = localByteArrayOStream.size();
      localByteArrayOStream.write(this.m_opcode);
      emitJumpOffset2(paramEmitCtx, j, i);
    }
    
    int maxlength()
    {
      return 5;
    }
  }
  
  static final class JUMP4
    extends InstrVisitor.Branch
  {
    JUMP4(int paramInt1, int paramInt2)
    {
      super(new int[] { paramInt2 });
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      ByteArrayOStream localByteArrayOStream = paramEmitCtx.m_out;
      int i = this.m_targets[0];
      int j = localByteArrayOStream.size();
      localByteArrayOStream.write(this.m_opcode);
      emitJumpOffset4(paramEmitCtx, j, i);
    }
    
    int maxlength()
    {
      return 5;
    }
  }
  
  static final class LOOKUPSWITCH
    extends InstrVisitor.Branch
  {
    final int[] m_keys;
    
    LOOKUPSWITCH(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      super(paramArrayOfInt2);
      this.m_keys = paramArrayOfInt1;
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      ByteArrayOStream localByteArrayOStream = paramEmitCtx.m_out;
      int j = localByteArrayOStream.size();
      localByteArrayOStream.write(this.m_opcode);
      int i = 0;
      while (i < 3 - (j & 0x3))
      {
        localByteArrayOStream.write(0);
        i += 1;
      }
      emitJumpOffset4(paramEmitCtx, j, this.m_targets[0]);
      i = this.m_keys.length;
      localByteArrayOStream.write4(i >>> 24, i >>> 16, i >>> 8, i);
      i = 1;
      while (i < this.m_targets.length)
      {
        int k = this.m_keys[(i - 1)];
        localByteArrayOStream.write4(k >>> 24, k >>> 16, k >>> 8, k);
        emitJumpOffset4(paramEmitCtx, j, this.m_targets[i]);
        i += 1;
      }
    }
    
    int maxlength()
    {
      return (this.m_keys.length << 3) + 12;
    }
  }
  
  private static final class LineNumberComparator
    implements Comparator
  {
    public final int compare(Object paramObject1, Object paramObject2)
    {
      return ((LineNumber_info)paramObject1).m_start_pc - ((LineNumber_info)paramObject2).m_start_pc;
    }
  }
  
  static final class RET
    extends InstrVisitor.Branch
  {
    final int m_varindex;
    
    RET(int paramInt1, int paramInt2)
    {
      super(null);
      this.m_varindex = paramInt2;
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      paramEmitCtx = paramEmitCtx.m_out;
      if (this.m_varindex <= 255)
      {
        paramEmitCtx.write2(this.m_opcode, this.m_varindex);
        return;
      }
      paramEmitCtx.write4(196, this.m_opcode, this.m_varindex >>> 8, this.m_varindex);
    }
    
    int length()
    {
      if (this.m_varindex <= 255) {
        return 2;
      }
      return 3;
    }
  }
  
  static final class TABLESWITCH
    extends InstrVisitor.Branch
  {
    final int m_high;
    final int m_low;
    
    TABLESWITCH(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
      this.m_low = paramInt1;
      this.m_high = paramInt2;
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      ByteArrayOStream localByteArrayOStream = paramEmitCtx.m_out;
      int j = localByteArrayOStream.size();
      localByteArrayOStream.write(this.m_opcode);
      int i = 0;
      while (i < 3 - (j & 0x3))
      {
        localByteArrayOStream.write(0);
        i += 1;
      }
      emitJumpOffset4(paramEmitCtx, j, this.m_targets[0]);
      i = this.m_low;
      localByteArrayOStream.write4(i >>> 24, i >>> 16, i >>> 8, i);
      i = this.m_high;
      localByteArrayOStream.write4(i >>> 24, i >>> 16, i >>> 8, i);
      i = 1;
      while (i < this.m_targets.length)
      {
        emitJumpOffset4(paramEmitCtx, j, this.m_targets[i]);
        i += 1;
      }
    }
    
    int maxlength()
    {
      return (this.m_targets.length << 2) + 12;
    }
  }
  
  static final class TERMINATE
    extends InstrVisitor.Branch
  {
    TERMINATE(int paramInt)
    {
      super(null);
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      paramEmitCtx.m_out.write(this.m_opcode);
    }
    
    int length()
    {
      return 1;
    }
  }
  
  static final class clinitHeader
    extends InstrVisitor.CodeSegment
  {
    private static final int CLINIT_HEADER_INIT_CAPACITY = 32;
    private final ByteArrayOStream m_buf;
    
    clinitHeader(InstrVisitor paramInstrVisitor, int paramInt)
    {
      super();
      ByteArrayOStream localByteArrayOStream = new ByteArrayOStream(32);
      this.m_buf = localByteArrayOStream;
      ClassDef localClassDef = paramInstrVisitor.m_cls;
      int[] arrayOfInt = paramInstrVisitor.m_classBlockCounts;
      int i = paramInstrVisitor.m_classInstrMethodCount;
      i = paramInstrVisitor.m_coverageFieldrefIndex;
      i = paramInstrVisitor.m_preclinitMethodrefIndex;
      int j = paramInstrVisitor.m_classNameConstantIndex;
      localByteArrayOStream.write3(184, i >>> 8, i);
      CodeGen.push_int_value(localByteArrayOStream, localClassDef, paramInstrVisitor.m_methodID);
      localByteArrayOStream.write(50);
      CodeGen.store_local_object_var(localByteArrayOStream, paramInt);
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      try
      {
        this.m_buf.writeTo(paramEmitCtx.m_out);
        return;
      }
      catch (IOException paramEmitCtx) {}
    }
    
    int length()
    {
      return this.m_buf.size();
    }
    
    int maxstack()
    {
      return 2;
    }
  }
  
  static final class methodHeader
    extends InstrVisitor.CodeSegment
  {
    private static final int HEADER_INIT_CAPACITY = 16;
    private final ByteArrayOStream m_buf;
    
    methodHeader(InstrVisitor paramInstrVisitor, int paramInt)
    {
      super();
      ByteArrayOStream localByteArrayOStream = new ByteArrayOStream(16);
      this.m_buf = localByteArrayOStream;
      ClassDef localClassDef = paramInstrVisitor.m_cls;
      int i = paramInstrVisitor.m_coverageFieldrefIndex;
      int j = paramInstrVisitor.m_preclinitMethodrefIndex;
      localByteArrayOStream.write4(178, i >>> 8, i, 89);
      localByteArrayOStream.write3(199, 0, 7);
      localByteArrayOStream.write4(87, 184, j >>> 8, j);
      CodeGen.push_int_value(localByteArrayOStream, localClassDef, paramInstrVisitor.m_methodID);
      localByteArrayOStream.write(50);
      CodeGen.store_local_object_var(localByteArrayOStream, paramInt);
    }
    
    void emit(InstrVisitor.EmitCtx paramEmitCtx)
    {
      try
      {
        this.m_buf.writeTo(paramEmitCtx.m_out);
        return;
      }
      catch (IOException paramEmitCtx) {}
    }
    
    int length()
    {
      return this.m_buf.size();
    }
    
    int maxstack()
    {
      return 2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/instr/InstrVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */