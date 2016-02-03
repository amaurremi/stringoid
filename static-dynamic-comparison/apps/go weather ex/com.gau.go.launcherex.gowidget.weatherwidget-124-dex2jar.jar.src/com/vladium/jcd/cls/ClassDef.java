package com.vladium.jcd.cls;

import com.vladium.jcd.cls.attribute.AttributeElementFactory;
import com.vladium.jcd.cls.attribute.CodeAttribute_info;
import com.vladium.jcd.cls.attribute.InnerClassesAttribute_info;
import com.vladium.jcd.cls.constant.CONSTANT_Class_info;
import com.vladium.jcd.cls.constant.CONSTANT_Fieldref_info;
import com.vladium.jcd.cls.constant.CONSTANT_NameAndType_info;
import com.vladium.jcd.cls.constant.CONSTANT_String_info;
import com.vladium.jcd.cls.constant.CONSTANT_Utf8_info;
import com.vladium.jcd.cls.constant.CONSTANT_info;
import com.vladium.jcd.compiler.IClassFormatOutput;
import com.vladium.jcd.lib.Types;
import com.vladium.jcd.lib.UDataOutputStream;
import com.vladium.util.ByteArrayOStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class ClassDef
  implements Cloneable, IAccessFlags, IClassFormatOutput
{
  private static final boolean DEBUG_SUID = false;
  private int m_access_flags;
  private IAttributeCollection m_attributes = ElementFactory.newAttributeCollection(-1);
  private IConstantCollection m_constants = ElementFactory.newConstantCollection(-1);
  private long m_declaredSUID;
  private IFieldCollection m_fields = ElementFactory.newFieldCollection(-1);
  private IInterfaceCollection m_interfaces = ElementFactory.newInterfaceCollection(-1);
  private long m_magic;
  private IMethodCollection m_methods = ElementFactory.newMethodCollection(-1);
  private int m_super_class_index;
  private int m_this_class_index;
  private int[] m_version = new int[2];
  
  public void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject)
  {
    paramIClassDefVisitor.visit(this, paramObject);
  }
  
  public int addCONSTANT_Utf8(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = this.m_constants.findCONSTANT_Utf8(paramString);
      if (i > 0) {
        return i;
      }
    }
    return this.m_constants.add(new CONSTANT_Utf8_info(paramString));
  }
  
  public int addClassref(String paramString)
  {
    int i = addCONSTANT_Utf8(paramString, true);
    return this.m_constants.add(new CONSTANT_Class_info(i));
  }
  
  public int addField(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = new Field_info(paramInt, addCONSTANT_Utf8(paramString1, true), addCONSTANT_Utf8(paramString2, true), ElementFactory.newAttributeCollection(0));
    return this.m_fields.add(paramString1);
  }
  
  public int addField(String paramString1, String paramString2, int paramInt, IAttributeCollection paramIAttributeCollection)
  {
    paramString1 = new Field_info(paramInt, addCONSTANT_Utf8(paramString1, true), addCONSTANT_Utf8(paramString2, true), paramIAttributeCollection);
    return this.m_fields.add(paramString1);
  }
  
  public int addFieldref(int paramInt)
  {
    Object localObject = this.m_fields.get(paramInt);
    localObject = new CONSTANT_NameAndType_info(((Field_info)localObject).m_name_index, ((Field_info)localObject).m_descriptor_index);
    paramInt = this.m_constants.add((CONSTANT_info)localObject);
    return this.m_constants.add(new CONSTANT_Fieldref_info(this.m_this_class_index, paramInt));
  }
  
  public int addFieldref(Field_info paramField_info)
  {
    paramField_info = new CONSTANT_NameAndType_info(paramField_info.m_name_index, paramField_info.m_descriptor_index);
    int i = this.m_constants.add(paramField_info);
    return this.m_constants.add(new CONSTANT_Fieldref_info(this.m_this_class_index, i));
  }
  
  public int addMethod(Method_info paramMethod_info)
  {
    return this.m_methods.add(paramMethod_info);
  }
  
  public int addNameType(String paramString1, String paramString2)
  {
    int i = addCONSTANT_Utf8(paramString1, true);
    int j = addCONSTANT_Utf8(paramString2, true);
    return this.m_constants.add(new CONSTANT_NameAndType_info(i, j));
  }
  
  public int addStringConstant(String paramString)
  {
    int i = addCONSTANT_Utf8(paramString, true);
    return this.m_constants.add(new CONSTANT_String_info(i));
  }
  
  public Object clone()
  {
    try
    {
      ClassDef localClassDef = (ClassDef)super.clone();
      localClassDef.m_version = ((int[])this.m_version.clone());
      localClassDef.m_constants = ((IConstantCollection)this.m_constants.clone());
      localClassDef.m_interfaces = ((IInterfaceCollection)this.m_interfaces.clone());
      localClassDef.m_fields = ((IFieldCollection)this.m_fields.clone());
      localClassDef.m_methods = ((IMethodCollection)this.m_methods.clone());
      localClassDef.m_attributes = ((IAttributeCollection)this.m_attributes.clone());
      return localClassDef;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public final long computeSUID(boolean paramBoolean)
  {
    long l = this.m_declaredSUID;
    if (l != 0L) {
      return l;
    }
    for (;;)
    {
      int k;
      try
      {
        Object localObject1 = new ByteArrayOStream(1024);
        Object localObject2 = new DataOutputStream((OutputStream)localObject1);
        ((DataOutputStream)localObject2).writeUTF(Types.vmNameToJavaName(getName()));
        Object localObject3 = new int[1];
        if (isNested((int[])localObject3))
        {
          i = localObject3[0];
          ((DataOutputStream)localObject2).writeInt(i & 0x611);
          localObject3 = getInterfaces();
          localObject4 = new String[((IInterfaceCollection)localObject3).size()];
          j = localObject4.length;
          i = 0;
          if (i < j)
          {
            localObject4[i] = Types.vmNameToJavaName(((CONSTANT_Class_info)this.m_constants.get(((IInterfaceCollection)localObject3).get(i))).getName(this));
            i += 1;
            continue;
          }
        }
        else
        {
          i = getAccessFlags();
          continue;
        }
        Arrays.sort((Object[])localObject4);
        i = 0;
        if (i < j)
        {
          ((DataOutputStream)localObject2).writeUTF(localObject4[i]);
          i += 1;
          continue;
        }
        Object localObject4 = getFields();
        localObject3 = new FieldDescriptor[((IFieldCollection)localObject4).size()];
        j = 0;
        int m = localObject3.length;
        i = 0;
        if (j < m)
        {
          localObject5 = ((IFieldCollection)localObject4).get(j);
          n = ((Field_info)localObject5).getAccessFlags();
          if (((n & 0x2) != 0) && ((n & 0x88) != 0)) {
            break label826;
          }
          k = i + 1;
          localObject3[i] = new FieldDescriptor(((Field_info)localObject5).getName(this), n, ((Field_info)localObject5).getDescriptor(this));
          i = k;
          break label826;
        }
        if (i > 0)
        {
          Arrays.sort((Object[])localObject3, 0, i);
          j = 0;
          if (j < i)
          {
            localObject4 = localObject3[j];
            ((DataOutputStream)localObject2).writeUTF(((FieldDescriptor)localObject4).m_name);
            ((DataOutputStream)localObject2).writeInt(((FieldDescriptor)localObject4).m_modifiers);
            ((DataOutputStream)localObject2).writeUTF(((FieldDescriptor)localObject4).m_descriptor);
            j += 1;
            continue;
          }
        }
        Object localObject5 = getMethods();
        m = 0;
        localObject4 = new ConstructorDescriptor[((IMethodCollection)localObject5).size()];
        localObject3 = new MethodDescriptor[localObject4.length];
        k = 0;
        int i1 = localObject4.length;
        i = 0;
        j = 0;
        if (k < i1)
        {
          Method_info localMethod_info = ((IMethodCollection)localObject5).get(k);
          String str = localMethod_info.getName(this);
          if ((m == 0) && ("<clinit>".equals(str)))
          {
            m = 1;
            n = i;
            i = j;
            j = n;
            break label833;
          }
          int i2 = localMethod_info.getAccessFlags();
          if ((i2 & 0x2) == 0)
          {
            if ("<init>".equals(str))
            {
              n = j + 1;
              localObject4[j] = new ConstructorDescriptor(i2, localMethod_info.getDescriptor(this));
              j = i;
              i = n;
              break label833;
            }
            n = i + 1;
            localObject3[i] = new MethodDescriptor(str, i2, localMethod_info.getDescriptor(this));
            i = j;
            j = n;
            break label833;
          }
        }
        else
        {
          if ((m != 0) && (!paramBoolean))
          {
            ((DataOutputStream)localObject2).writeUTF("<clinit>");
            ((DataOutputStream)localObject2).writeInt(8);
            ((DataOutputStream)localObject2).writeUTF("()V");
          }
          if (j > 0)
          {
            Arrays.sort((Object[])localObject4, 0, j);
            k = 0;
            if (k < j)
            {
              localObject5 = localObject4[k];
              ((DataOutputStream)localObject2).writeUTF("<init>");
              ((DataOutputStream)localObject2).writeInt(((ConstructorDescriptor)localObject5).m_modifiers);
              ((DataOutputStream)localObject2).writeUTF(((ConstructorDescriptor)localObject5).m_descriptor.replace('/', '.'));
              k += 1;
              continue;
            }
          }
          if (i > 0)
          {
            Arrays.sort((Object[])localObject3, 0, i);
            j = 0;
            if (j < i)
            {
              localObject4 = localObject3[j];
              ((DataOutputStream)localObject2).writeUTF(((MethodDescriptor)localObject4).m_name);
              ((DataOutputStream)localObject2).writeInt(((MethodDescriptor)localObject4).m_modifiers);
              ((DataOutputStream)localObject2).writeUTF(((MethodDescriptor)localObject4).m_descriptor.replace('/', '.'));
              j += 1;
              continue;
            }
          }
          ((DataOutputStream)localObject2).flush();
          localObject2 = MessageDigest.getInstance("SHA");
          ((MessageDigest)localObject2).update(((ByteArrayOStream)localObject1).getByteArray(), 0, ((ByteArrayOStream)localObject1).size());
          localObject1 = ((MessageDigest)localObject2).digest();
          i = Math.min(localObject1.length, 8) - 1;
          if (i >= 0)
          {
            j = localObject1[i];
            l = l << 8 | j & 0xFF;
            i -= 1;
            continue;
          }
          return l;
        }
      }
      catch (IOException localIOException)
      {
        throw new Error(localIOException.getMessage());
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new SecurityException(localNoSuchAlgorithmException.getMessage());
      }
      int n = i;
      int i = j;
      int j = n;
      break label833;
      label826:
      j += 1;
      continue;
      label833:
      k += 1;
      n = j;
      j = i;
      i = n;
    }
  }
  
  public final int getAccessFlags()
  {
    return this.m_access_flags;
  }
  
  public IAttributeCollection getAttributes()
  {
    return this.m_attributes;
  }
  
  public IConstantCollection getConstants()
  {
    return this.m_constants;
  }
  
  public final long getDeclaredSUID()
  {
    return this.m_declaredSUID;
  }
  
  public IFieldCollection getFields()
  {
    return this.m_fields;
  }
  
  public int[] getFields(String paramString)
  {
    return this.m_fields.get(this, paramString);
  }
  
  public IInterfaceCollection getInterfaces()
  {
    return this.m_interfaces;
  }
  
  public long getMagic()
  {
    return this.m_magic;
  }
  
  public IMethodCollection getMethods()
  {
    return this.m_methods;
  }
  
  public int[] getMethods(String paramString)
  {
    return this.m_methods.get(this, paramString);
  }
  
  public String getName()
  {
    return getThisClass().getName(this);
  }
  
  public CONSTANT_Class_info getSuperClass()
  {
    return (CONSTANT_Class_info)this.m_constants.get(this.m_super_class_index);
  }
  
  public int getSuperClassIndex()
  {
    return this.m_super_class_index;
  }
  
  public CONSTANT_Class_info getThisClass()
  {
    return (CONSTANT_Class_info)this.m_constants.get(this.m_this_class_index);
  }
  
  public int getThisClassIndex()
  {
    return this.m_this_class_index;
  }
  
  public int[] getVersion()
  {
    return this.m_version;
  }
  
  public boolean isInterface()
  {
    return (this.m_access_flags & 0x200) != 0;
  }
  
  public boolean isNested(int[] paramArrayOfInt)
  {
    InnerClassesAttribute_info localInnerClassesAttribute_info = this.m_attributes.getInnerClassesAttribute();
    if (localInnerClassesAttribute_info == null) {
      return false;
    }
    return localInnerClassesAttribute_info.makesClassNested(this.m_this_class_index, paramArrayOfInt);
  }
  
  public boolean isSynthetic()
  {
    return this.m_attributes.hasSynthetic();
  }
  
  public Method_info newEmptyMethod(String paramString1, String paramString2, int paramInt)
  {
    int i = addCONSTANT_Utf8("Code", true);
    int j = addCONSTANT_Utf8(paramString1, true);
    int k = addCONSTANT_Utf8(paramString2, true);
    paramString1 = ElementFactory.newAttributeCollection(0);
    paramString1.add(new CodeAttribute_info(i, 0, 0, CodeAttribute_info.EMPTY_BYTE_ARRAY, AttributeElementFactory.newExceptionHandlerTable(0), ElementFactory.newAttributeCollection(0)));
    return new Method_info(paramInt, j, k, paramString1);
  }
  
  public final void setAccessFlags(int paramInt)
  {
    this.m_access_flags = paramInt;
  }
  
  public final void setDeclaredSUID(long paramLong)
  {
    this.m_declaredSUID = paramLong;
  }
  
  public void setMagic(long paramLong)
  {
    this.m_magic = paramLong;
  }
  
  public void setSuperClassIndex(int paramInt)
  {
    this.m_super_class_index = paramInt;
  }
  
  public void setThisClassIndex(int paramInt)
  {
    this.m_this_class_index = paramInt;
  }
  
  public void setVersion(int[] paramArrayOfInt)
  {
    this.m_version[0] = paramArrayOfInt[0];
    this.m_version[1] = paramArrayOfInt[1];
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    if (paramUDataOutputStream == null) {
      throw new IllegalArgumentException("null input: out");
    }
    paramUDataOutputStream.writeU4(this.m_magic);
    paramUDataOutputStream.writeU2(this.m_version[1]);
    paramUDataOutputStream.writeU2(this.m_version[0]);
    this.m_constants.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeU2(this.m_access_flags);
    paramUDataOutputStream.writeU2(this.m_this_class_index);
    paramUDataOutputStream.writeU2(this.m_super_class_index);
    this.m_interfaces.writeInClassFormat(paramUDataOutputStream);
    this.m_fields.writeInClassFormat(paramUDataOutputStream);
    this.m_methods.writeInClassFormat(paramUDataOutputStream);
    this.m_attributes.writeInClassFormat(paramUDataOutputStream);
  }
  
  private static final class ConstructorDescriptor
    implements Comparable
  {
    final String m_descriptor;
    final int m_modifiers;
    
    ConstructorDescriptor(int paramInt, String paramString)
    {
      this.m_modifiers = paramInt;
      this.m_descriptor = paramString;
    }
    
    public final int compareTo(Object paramObject)
    {
      return this.m_descriptor.compareTo(((ConstructorDescriptor)paramObject).m_descriptor);
    }
  }
  
  private static final class FieldDescriptor
    implements Comparable
  {
    final String m_descriptor;
    final int m_modifiers;
    final String m_name;
    
    FieldDescriptor(String paramString1, int paramInt, String paramString2)
    {
      this.m_name = paramString1;
      this.m_modifiers = paramInt;
      this.m_descriptor = paramString2;
    }
    
    public final int compareTo(Object paramObject)
    {
      return this.m_name.compareTo(((FieldDescriptor)paramObject).m_name);
    }
  }
  
  private static final class MethodDescriptor
    implements Comparable
  {
    final String m_descriptor;
    final int m_modifiers;
    final String m_name;
    
    MethodDescriptor(String paramString1, int paramInt, String paramString2)
    {
      this.m_name = paramString1;
      this.m_modifiers = paramInt;
      this.m_descriptor = paramString2;
    }
    
    public final int compareTo(Object paramObject)
    {
      paramObject = (MethodDescriptor)paramObject;
      int j = this.m_name.compareTo(((MethodDescriptor)paramObject).m_name);
      int i = j;
      if (j == 0) {
        i = this.m_descriptor.compareTo(((MethodDescriptor)paramObject).m_descriptor);
      }
      return i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/ClassDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */