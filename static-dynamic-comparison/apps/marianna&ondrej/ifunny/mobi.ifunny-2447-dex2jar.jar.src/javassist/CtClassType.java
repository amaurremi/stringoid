package javassist;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javassist.bytecode.AccessFlag;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.ConstantAttribute;
import javassist.bytecode.Descriptor;
import javassist.bytecode.EnclosingMethodAttribute;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.InnerClassesAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.annotation.Annotation;
import javassist.compiler.AccessorMaker;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.expr.ExprEditor;

class CtClassType
        extends CtClass {
    private static final int GET_THRESHOLD = 2;
    private AccessorMaker accessors;
    ClassPool classPool;
    ClassFile classfile;
    private boolean doPruning = ClassPool.doPruning;
    private FieldInitLink fieldInitializers;
    boolean gcConstPool;
    private int getCount;
    private Hashtable hiddenMethods;
    private WeakReference memberCache;
    byte[] rawClassfile;
    private int uniqueNumberSeed;
    boolean wasChanged;
    private boolean wasFrozen;
    boolean wasPruned;

    CtClassType(InputStream paramInputStream, ClassPool paramClassPool) {
        this((String) null, paramClassPool);
        this.classfile = new ClassFile(new DataInputStream(paramInputStream));
        this.qualifiedName = this.classfile.getName();
    }

    CtClassType(String paramString, ClassPool paramClassPool) {
        super(paramString);
        this.classPool = paramClassPool;
        this.gcConstPool = false;
        this.wasPruned = false;
        this.wasFrozen = false;
        this.wasChanged = false;
        this.classfile = null;
        this.rawClassfile = null;
        this.memberCache = null;
        this.accessors = null;
        this.fieldInitializers = null;
        this.hiddenMethods = null;
        this.uniqueNumberSeed = 0;
        this.getCount = 0;
    }

    private CtField checkGetField(CtField paramCtField, String paramString1, String paramString2) {
        if (paramCtField == null) {
            paramString1 = "field: " + paramString1;
            paramCtField = paramString1;
            if (paramString2 != null) {
                paramCtField = paramString1 + " type " + paramString2;
            }
            throw new NotFoundException(paramCtField + " in " + getName());
        }
        return paramCtField;
    }

    private void checkPruned(String paramString) {
        if (this.wasPruned) {
            throw new RuntimeException(paramString + "(): " + getName() + " was pruned.");
        }
    }

    private void dumpClassFile(ClassFile paramClassFile) {
        DataOutputStream localDataOutputStream = makeFileOutput(debugDump);
        try {
            paramClassFile.write(localDataOutputStream);
            return;
        } finally {
            localDataOutputStream.close();
        }
    }

    private void exToString(StringBuffer paramStringBuffer, String paramString, CtMember paramCtMember1, CtMember paramCtMember2) {
        paramStringBuffer.append(paramString);
        while (paramCtMember1 != paramCtMember2) {
            paramCtMember1 = paramCtMember1.next();
            paramStringBuffer.append(paramCtMember1);
            paramStringBuffer.append(", ");
        }
    }

    static Object getAnnotationType(Class paramClass, ClassPool paramClassPool, AnnotationsAttribute paramAnnotationsAttribute1, AnnotationsAttribute paramAnnotationsAttribute2) {
        int j = 0;
        Object localObject = null;
        label18:
        String str;
        if (paramAnnotationsAttribute1 == null) {
            paramAnnotationsAttribute1 = null;
            if (paramAnnotationsAttribute2 != null) {
                break label72;
            }
            paramAnnotationsAttribute2 = null;
            str = paramClass.getName();
            if (paramAnnotationsAttribute1 == null) {
                break label89;
            }
            i = 0;
            label31:
            if (i >= paramAnnotationsAttribute1.length) {
                break label89;
            }
            if (!paramAnnotationsAttribute1[i].getTypeName().equals(str)) {
                break label80;
            }
            paramClass = toAnnoType(paramAnnotationsAttribute1[i], paramClassPool);
        }
        label72:
        label80:
        label89:
        do {
            return paramClass;
            paramAnnotationsAttribute1 = paramAnnotationsAttribute1.getAnnotations();
            break;
            paramAnnotationsAttribute2 = paramAnnotationsAttribute2.getAnnotations();
            break label18;
            i += 1;
            break label31;
            paramClass = (Class) localObject;
        } while (paramAnnotationsAttribute2 == null);
        int i = j;
        for (; ; ) {
            paramClass = (Class) localObject;
            if (i >= paramAnnotationsAttribute2.length) {
                break;
            }
            if (paramAnnotationsAttribute2[i].getTypeName().equals(str)) {
                return toAnnoType(paramAnnotationsAttribute2[i], paramClassPool);
            }
            i += 1;
        }
    }

    private Object[] getAnnotations(boolean paramBoolean) {
        Object localObject = getClassFile2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((ClassFile) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((ClassFile) localObject).getAttribute("RuntimeVisibleAnnotations");
        return toAnnotationType(paramBoolean, getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    private CtField getDeclaredField2(String paramString1, String paramString2) {
        Object localObject2 = getMembers();
        Object localObject1 = ((CtMember.Cache) localObject2).fieldHead();
        CtMember localCtMember = ((CtMember.Cache) localObject2).lastField();
        while (localObject1 != localCtMember) {
            localObject2 = ((CtMember) localObject1).next();
            localObject1 = localObject2;
            if (((CtMember) localObject2).getName().equals(paramString1)) {
                if (paramString2 != null) {
                    localObject1 = localObject2;
                    if (!paramString2.equals(((CtMember) localObject2).getSignature())) {
                        break;
                    }
                } else {
                    return (CtField) localObject2;
                }
            }
        }
        return null;
    }

    private static void getFields(ArrayList paramArrayList, CtClass paramCtClass) {
        if (paramCtClass == null) {
        }
        for (; ; ) {
            return;
            try {
                getFields(paramArrayList, paramCtClass.getSuperclass());
                Object localObject;
                try {
                    CtClass[] arrayOfCtClass = paramCtClass.getInterfaces();
                    int j = arrayOfCtClass.length;
                    int i = 0;
                    while (i < j) {
                        getFields(paramArrayList, arrayOfCtClass[i]);
                        i += 1;
                    }
                    CtMember localCtMember;
                    if (paramCtClass == localCtMember) {
                        continue;
                    }
                } catch (NotFoundException localNotFoundException1) {
                    localObject = ((CtClassType) paramCtClass).getMembers();
                    paramCtClass = ((CtMember.Cache) localObject).fieldHead();
                    localCtMember = ((CtMember.Cache) localObject).lastField();
                }
                for (; ; ) {
                    localObject = paramCtClass.next();
                    paramCtClass = (CtClass) localObject;
                    if (!Modifier.isPrivate(((CtMember) localObject).getModifiers())) {
                        paramArrayList.add(localObject);
                        paramCtClass = (CtClass) localObject;
                    }
                }
            } catch (NotFoundException localNotFoundException2) {
                for (; ; ) {
                }
            }
        }
    }

    private static CtMethod getMethod0(CtClass paramCtClass, String paramString1, String paramString2) {
        Object localObject2;
        Object localObject1;
        if ((paramCtClass instanceof CtClassType)) {
            localObject2 = ((CtClassType) paramCtClass).getMembers();
            localObject1 = ((CtMember.Cache) localObject2).methodHead();
            CtMember localCtMember = ((CtMember.Cache) localObject2).lastMethod();
            while (localObject1 != localCtMember) {
                localObject2 = ((CtMember) localObject1).next();
                localObject1 = localObject2;
                if (((CtMember) localObject2).getName().equals(paramString1)) {
                    localObject1 = localObject2;
                    if (((CtMethod) localObject2).getMethodInfo2().getDescriptor().equals(paramString2)) {
                        localObject1 = (CtMethod) localObject2;
                    }
                }
            }
        }
        for (; ; ) {
            return (CtMethod) localObject1;
            for (; ; ) {
                try {
                    localObject1 = paramCtClass.getSuperclass();
                    if (localObject1 != null) {
                        localObject2 = getMethod0((CtClass) localObject1, paramString1, paramString2);
                        localObject1 = localObject2;
                        if (localObject2 != null) {
                            break;
                        }
                    }
                } catch (NotFoundException localNotFoundException) {
                    int j;
                    int i;
                    continue;
                }
                try {
                    localObject2 = paramCtClass.getInterfaces();
                    j = localObject2.length;
                    i = 0;
                    if (i < j) {
                        paramCtClass = getMethod0(localObject2[i], paramString1, paramString2);
                        localObject1 = paramCtClass;
                        if (paramCtClass != null) {
                            break;
                        }
                        i += 1;
                        continue;
                    }
                    return null;
                } catch (NotFoundException paramCtClass) {
                }
            }
        }
    }

    private static void getMethods0(HashMap paramHashMap, CtClass paramCtClass) {
        try {
            CtClass[] arrayOfCtClass = paramCtClass.getInterfaces();
            int j = arrayOfCtClass.length;
            int i = 0;
            while (i < j) {
                getMethods0(paramHashMap, arrayOfCtClass[i]);
                i += 1;
            }
            try {
                localObject = paramCtClass.getSuperclass();
                if (localObject != null) {
                    getMethods0(paramHashMap, (CtClass) localObject);
                }
            } catch (NotFoundException localNotFoundException2) {
                Object localObject;
                CtMember localCtMember;
                for (; ; ) {
                }
            }
        } catch (NotFoundException localNotFoundException1) {
        }
        if ((paramCtClass instanceof CtClassType)) {
            localObject = ((CtClassType) paramCtClass).getMembers();
            paramCtClass = ((CtMember.Cache) localObject).methodHead();
            localCtMember = ((CtMember.Cache) localObject).lastMethod();
            while (paramCtClass != localCtMember) {
                localObject = paramCtClass.next();
                paramCtClass = (CtClass) localObject;
                if (!Modifier.isPrivate(((CtMember) localObject).getModifiers())) {
                    paramHashMap.put(((CtMethod) localObject).getStringRep(), localObject);
                    paramCtClass = (CtClass) localObject;
                }
            }
        }
    }

    static boolean hasAnnotationType(Class paramClass, ClassPool paramClassPool, AnnotationsAttribute paramAnnotationsAttribute1, AnnotationsAttribute paramAnnotationsAttribute2) {
        Object localObject = null;
        boolean bool2 = false;
        label19:
        label31:
        boolean bool1;
        if (paramAnnotationsAttribute1 == null) {
            paramClassPool = null;
            if (paramAnnotationsAttribute2 != null) {
                break label66;
            }
            paramAnnotationsAttribute1 = (AnnotationsAttribute) localObject;
            paramClass = paramClass.getName();
            if (paramClassPool == null) {
                break label83;
            }
            i = 0;
            if (i >= paramClassPool.length) {
                break label83;
            }
            if (!paramClassPool[i].getTypeName().equals(paramClass)) {
                break label74;
            }
            bool1 = true;
        }
        label66:
        label74:
        label83:
        do {
            return bool1;
            paramClassPool = paramAnnotationsAttribute1.getAnnotations();
            break;
            paramAnnotationsAttribute1 = paramAnnotationsAttribute2.getAnnotations();
            break label19;
            i += 1;
            break label31;
            bool1 = bool2;
        } while (paramAnnotationsAttribute1 == null);
        int i = 0;
        for (; ; ) {
            bool1 = bool2;
            if (i >= paramAnnotationsAttribute1.length) {
                break;
            }
            if (paramAnnotationsAttribute1[i].getTypeName().equals(paramClass)) {
                return true;
            }
            i += 1;
        }
    }

    private static void insertAuxInitializer(CodeAttribute paramCodeAttribute, Bytecode paramBytecode, int paramInt) {
        CodeIterator localCodeIterator = paramCodeAttribute.iterator();
        if ((localCodeIterator.skipSuperConstructor() < 0) && (localCodeIterator.skipThisConstructor() >= 0)) {
        }
        do {
            return;
            int i = localCodeIterator.insertEx(paramBytecode.get());
            localCodeIterator.insert(paramBytecode.getExceptionTable(), i);
        } while (paramCodeAttribute.getMaxStack() >= paramInt);
        paramCodeAttribute.setMaxStack(paramInt);
    }

    private static boolean isPubCons(CtConstructor paramCtConstructor) {
        return (!Modifier.isPrivate(paramCtConstructor.getModifiers())) && (paramCtConstructor.isConstructor());
    }

    private void makeBehaviorCache(CtMember.Cache paramCache) {
        List localList = getClassFile2().getMethods();
        int j = localList.size();
        int i = 0;
        if (i < j) {
            MethodInfo localMethodInfo = (MethodInfo) localList.get(i);
            if (localMethodInfo.isMethod()) {
                paramCache.addMethod(new CtMethod(localMethodInfo, this));
            }
            for (; ; ) {
                i += 1;
                break;
                paramCache.addConstructor(new CtConstructor(localMethodInfo, this));
            }
        }
    }

    private void makeFieldCache(CtMember.Cache paramCache) {
        List localList = getClassFile2().getFields();
        int j = localList.size();
        int i = 0;
        while (i < j) {
            paramCache.addField(new CtField((FieldInfo) localList.get(i), this));
            i += 1;
        }
    }

    private int makeFieldInitializer(Bytecode paramBytecode, CtClass[] paramArrayOfCtClass) {
        int i = 0;
        Javac localJavac = new Javac(paramBytecode, this);
        for (; ; ) {
            try {
                localJavac.recordParams(paramArrayOfCtClass, false);
                FieldInitLink localFieldInitLink = this.fieldInitializers;
                if (localFieldInitLink != null) {
                    CtField localCtField = localFieldInitLink.field;
                    if (!Modifier.isStatic(localCtField.getModifiers())) {
                        int j = localFieldInitLink.init.compile(localCtField.getType(), localCtField.getName(), paramBytecode, paramArrayOfCtClass, localJavac);
                        if (i < j) {
                            i = j;
                            localFieldInitLink = localFieldInitLink.next;
                        }
                    }
                } else {
                    return i;
                }
            } catch (CompileError paramBytecode) {
                throw new CannotCompileException(paramBytecode);
            }
        }
    }

    private void makeMemberList(HashMap paramHashMap) {
        int j = 0;
        int i = getModifiers();
        if ((Modifier.isAbstract(i)) || (Modifier.isInterface(i))) {
            try {
                CtClass[] arrayOfCtClass = getInterfaces();
                int k = arrayOfCtClass.length;
                i = 0;
                while (i < k) {
                    CtClass localCtClass = arrayOfCtClass[i];
                    if ((localCtClass != null) && ((localCtClass instanceof CtClassType))) {
                        ((CtClassType) localCtClass).makeMemberList(paramHashMap);
                    }
                    i += 1;
                }
                try {
                    localObject = getSuperclass();
                    if ((localObject != null) && ((localObject instanceof CtClassType))) {
                        ((CtClassType) localObject).makeMemberList(paramHashMap);
                    }
                } catch (NotFoundException localNotFoundException2) {
                    Object localObject;
                    for (; ; ) {
                    }
                }
            } catch (NotFoundException localNotFoundException1) {
            }
        }
        localObject = getClassFile2().getMethods();
        k = ((List) localObject).size();
        i = 0;
        while (i < k) {
            paramHashMap.put(((MethodInfo) ((List) localObject).get(i)).getName(), this);
            i += 1;
        }
        localObject = getClassFile2().getFields();
        k = ((List) localObject).size();
        i = j;
        while (i < k) {
            paramHashMap.put(((FieldInfo) ((List) localObject).get(i)).getName(), this);
            i += 1;
        }
    }

    private void modifyClassConstructor(ClassFile paramClassFile) {
        if (this.fieldInitializers == null) {
            return;
        }
        Bytecode localBytecode = new Bytecode(paramClassFile.getConstPool(), 0, 0);
        Javac localJavac = new Javac(localBytecode, this);
        FieldInitLink localFieldInitLink = this.fieldInitializers;
        int i = 0;
        int j = 0;
        label45:
        if (localFieldInitLink != null) {
            CtField localCtField = localFieldInitLink.field;
            if (!Modifier.isStatic(localCtField.getModifiers())) {
                break label133;
            }
            j = 1;
            int k = 1;
            int m = localFieldInitLink.init.compileIfStatic(localCtField.getType(), localCtField.getName(), localBytecode, localJavac);
            if (i >= m) {
                break label133;
            }
            i = m;
            j = k;
        }
        label133:
        for (; ; ) {
            localFieldInitLink = localFieldInitLink.next;
            break label45;
            if (j == 0) {
                break;
            }
            modifyClassConstructor(paramClassFile, localBytecode, i, 0);
            return;
        }
    }

    private void modifyClassConstructor(ClassFile paramClassFile, Bytecode paramBytecode, int paramInt1, int paramInt2) {
        MethodInfo localMethodInfo = paramClassFile.getStaticInitializer();
        Object localObject;
        if (localMethodInfo == null) {
            paramBytecode.add(177);
            paramBytecode.setMaxStack(paramInt1);
            paramBytecode.setMaxLocals(paramInt2);
            localMethodInfo = new MethodInfo(paramClassFile.getConstPool(), "<clinit>", "()V");
            localMethodInfo.setAccessFlags(8);
            localMethodInfo.setCodeAttribute(paramBytecode.toCodeAttribute());
            paramClassFile.addMethod(localMethodInfo);
            localObject = hasMemberCache();
            paramBytecode = localMethodInfo;
            if (localObject != null) {
                ((CtMember.Cache) localObject).addConstructor(new CtConstructor(localMethodInfo, this));
                paramBytecode = localMethodInfo;
            }
        }
        for (; ; ) {
            try {
                paramBytecode.rebuildStackMapIf6(this.classPool, paramClassFile);
                return;
            } catch (BadBytecode paramClassFile) {
                throw new CannotCompileException(paramClassFile);
            }
            localObject = localMethodInfo.getCodeAttribute();
            if (localObject == null) {
                throw new CannotCompileException("empty <clinit>");
            }
            try {
                CodeIterator localCodeIterator = ((CodeAttribute) localObject).iterator();
                int i = localCodeIterator.insertEx(paramBytecode.get());
                localCodeIterator.insert(paramBytecode.getExceptionTable(), i);
                if (((CodeAttribute) localObject).getMaxStack() < paramInt1) {
                    ((CodeAttribute) localObject).setMaxStack(paramInt1);
                }
                paramBytecode = localMethodInfo;
                if (((CodeAttribute) localObject).getMaxLocals() >= paramInt2) {
                    continue;
                }
                ((CodeAttribute) localObject).setMaxLocals(paramInt2);
                paramBytecode = localMethodInfo;
            } catch (BadBytecode paramClassFile) {
                throw new CannotCompileException(paramClassFile);
            }
        }
    }

    private void modifyConstructors(ClassFile paramClassFile) {
        if (this.fieldInitializers == null) {
            return;
        }
        ConstPool localConstPool = paramClassFile.getConstPool();
        List localList = paramClassFile.getMethods();
        int j = localList.size();
        int i = 0;
        while (i < j) {
            MethodInfo localMethodInfo = (MethodInfo) localList.get(i);
            CodeAttribute localCodeAttribute;
            if (localMethodInfo.isConstructor()) {
                localCodeAttribute = localMethodInfo.getCodeAttribute();
                if (localCodeAttribute == null) {
                }
            }
            try {
                Bytecode localBytecode = new Bytecode(localConstPool, 0, localCodeAttribute.getMaxLocals());
                insertAuxInitializer(localCodeAttribute, localBytecode, makeFieldInitializer(localBytecode, Descriptor.getParameterTypes(localMethodInfo.getDescriptor(), this.classPool)));
                localMethodInfo.rebuildStackMapIf6(this.classPool, paramClassFile);
                i += 1;
            } catch (BadBytecode paramClassFile) {
                throw new CannotCompileException(paramClassFile);
            }
        }
    }

    private void nameReplaced() {
        Object localObject = hasMemberCache();
        if (localObject != null) {
            CtMember localCtMember = ((CtMember.Cache) localObject).methodHead();
            localObject = ((CtMember.Cache) localObject).lastMethod();
            while (localCtMember != localObject) {
                localCtMember = localCtMember.next();
                localCtMember.nameReplaced();
            }
        }
    }

    private static boolean notFindInArray(String paramString, String[] paramArrayOfString) {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j) {
            if (paramArrayOfString[i].startsWith(paramString)) {
                return false;
            }
            i += 1;
        }
        return true;
    }

    private void removeClassFile() {
        try {
            if ((this.classfile != null) && (!isModified()) && (hasMemberCache() == null)) {
                this.classfile = null;
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    /* Error */
    private void saveClassFile() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 48	javassist/CtClassType:classfile	Ljavassist/bytecode/ClassFile;
        //   6: ifnull +12 -> 18
        //   9: aload_0
        //   10: invokevirtual 482	javassist/CtClassType:hasMemberCache	()Ljavassist/CtMember$Cache;
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +6 -> 21
        //   18: aload_0
        //   19: monitorexit
        //   20: return
        //   21: new 529	java/io/ByteArrayOutputStream
        //   24: dup
        //   25: invokespecial 530	java/io/ByteArrayOutputStream:<init>	()V
        //   28: astore_1
        //   29: new 136	java/io/DataOutputStream
        //   32: dup
        //   33: aload_1
        //   34: invokespecial 533	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   37: astore_2
        //   38: aload_0
        //   39: getfield 48	javassist/CtClassType:classfile	Ljavassist/bytecode/ClassFile;
        //   42: aload_2
        //   43: invokevirtual 134	javassist/bytecode/ClassFile:write	(Ljava/io/DataOutputStream;)V
        //   46: aload_1
        //   47: invokevirtual 534	java/io/ByteArrayOutputStream:close	()V
        //   50: aload_0
        //   51: aload_1
        //   52: invokevirtual 537	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   55: putfield 77	javassist/CtClassType:rawClassfile	[B
        //   58: aload_0
        //   59: aconst_null
        //   60: putfield 48	javassist/CtClassType:classfile	Ljavassist/bytecode/ClassFile;
        //   63: goto -45 -> 18
        //   66: astore_1
        //   67: goto -49 -> 18
        //   70: astore_1
        //   71: aload_0
        //   72: monitorexit
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	CtClassType
        //   13	39	1	localObject1	Object
        //   66	1	1	localIOException	java.io.IOException
        //   70	4	1	localObject2	Object
        //   37	6	2	localDataOutputStream	DataOutputStream
        // Exception table:
        //   from	to	target	type
        //   38	63	66	java/io/IOException
        //   2	14	70	finally
        //   21	38	70	finally
        //   38	63	70	finally
    }

    private static Object toAnnoType(Annotation paramAnnotation, ClassPool paramClassPool) {
        try {
            Object localObject = paramAnnotation.toAnnotationType(paramClassPool.getClassLoader(), paramClassPool);
            return localObject;
        } catch (ClassNotFoundException localClassNotFoundException) {
        }
        return paramAnnotation.toAnnotationType(paramClassPool.getClass().getClassLoader(), paramClassPool);
    }

    static Object[] toAnnotationType(boolean paramBoolean, ClassPool paramClassPool, AnnotationsAttribute paramAnnotationsAttribute1, AnnotationsAttribute paramAnnotationsAttribute2) {
        int n = 0;
        int j;
        int i;
        if (paramAnnotationsAttribute1 == null) {
            j = 0;
            paramAnnotationsAttribute1 = null;
            if (paramAnnotationsAttribute2 != null) {
                break label83;
            }
            i = 0;
            paramAnnotationsAttribute2 = null;
        }
        for (; ; ) {
            if (!paramBoolean) {
                localObject = new Object[j + i];
                k = 0;
                int m;
                for (; ; ) {
                    m = n;
                    if (k >= j) {
                        break;
                    }
                    localObject[k] = toAnnoType(paramAnnotationsAttribute1[k], paramClassPool);
                    k += 1;
                }
                paramAnnotationsAttribute1 = paramAnnotationsAttribute1.getAnnotations();
                j = paramAnnotationsAttribute1.length;
                break;
                label83:
                paramAnnotationsAttribute2 = paramAnnotationsAttribute2.getAnnotations();
                i = paramAnnotationsAttribute2.length;
                continue;
                for (; ; ) {
                    paramAnnotationsAttribute1 = (AnnotationsAttribute) localObject;
                    if (m >= i) {
                        break;
                    }
                    localObject[(m + j)] = toAnnoType(paramAnnotationsAttribute2[m], paramClassPool);
                    m += 1;
                }
            }
        }
        Object localObject = new ArrayList();
        int k = 0;
        for (; ; ) {
            if (k < j) {
            }
            try {
                ((ArrayList) localObject).add(toAnnoType(paramAnnotationsAttribute1[k], paramClassPool));
                k += 1;
                continue;
                j = 0;
                for (; ; ) {
                    if (j < i) {
                    }
                    try {
                        ((ArrayList) localObject).add(toAnnoType(paramAnnotationsAttribute2[j], paramClassPool));
                        j += 1;
                        continue;
                        paramAnnotationsAttribute1 = ((ArrayList) localObject).toArray();
                        return paramAnnotationsAttribute1;
                    } catch (ClassNotFoundException paramAnnotationsAttribute1) {
                        for (; ; ) {
                        }
                    }
                }
            } catch (ClassNotFoundException localClassNotFoundException) {
                for (; ; ) {
                }
            }
        }
    }

    static Object[][] toAnnotationType(boolean paramBoolean, ClassPool paramClassPool, ParameterAnnotationsAttribute paramParameterAnnotationsAttribute1, ParameterAnnotationsAttribute paramParameterAnnotationsAttribute2, MethodInfo paramMethodInfo) {
        int i;
        Object[][] arrayOfObject;
        int j;
        if (paramParameterAnnotationsAttribute1 != null) {
            i = paramParameterAnnotationsAttribute1.numParameters();
            arrayOfObject = new Object[i][];
            j = 0;
        }
        for (; ; ) {
            int k;
            label37:
            Annotation[] arrayOfAnnotation;
            int m;
            label47:
            int n;
            label143:
            ArrayList localArrayList;
            if (j < i) {
                if (paramParameterAnnotationsAttribute1 == null) {
                    k = 0;
                    paramMethodInfo = null;
                    if (paramParameterAnnotationsAttribute2 != null) {
                        break label143;
                    }
                    arrayOfAnnotation = null;
                    m = 0;
                }
                for (; ; ) {
                    if (!paramBoolean) {
                        arrayOfObject[j] = new Object[k + m];
                        n = 0;
                        for (; ; ) {
                            if (n < k) {
                                arrayOfObject[j][n] = toAnnoType(paramMethodInfo[n], paramClassPool);
                                n += 1;
                                continue;
                                if (paramParameterAnnotationsAttribute2 != null) {
                                    i = paramParameterAnnotationsAttribute2.numParameters();
                                    break;
                                }
                                i = Descriptor.numOfParameters(paramMethodInfo.getDescriptor());
                                break;
                                paramMethodInfo = paramParameterAnnotationsAttribute1.getAnnotations()[j];
                                k = paramMethodInfo.length;
                                break label37;
                                arrayOfAnnotation = paramParameterAnnotationsAttribute2.getAnnotations()[j];
                                m = arrayOfAnnotation.length;
                                break label47;
                            }
                        }
                        n = 0;
                        while (n < m) {
                            arrayOfObject[j][(n + k)] = toAnnoType(arrayOfAnnotation[n], paramClassPool);
                            n += 1;
                        }
                    }
                }
                localArrayList = new ArrayList();
                n = 0;
                label211:
                if (n >= k) {
                }
            }
            try {
                localArrayList.add(toAnnoType(paramMethodInfo[n], paramClassPool));
                n += 1;
                break label211;
                k = 0;
                label245:
                if (k < m) {
                }
                try {
                    localArrayList.add(toAnnoType(arrayOfAnnotation[k], paramClassPool));
                    k += 1;
                    break label245;
                    arrayOfObject[j] = localArrayList.toArray();
                    j += 1;
                    continue;
                    return arrayOfObject;
                } catch (ClassNotFoundException paramMethodInfo) {
                    for (; ; ) {
                    }
                }
            } catch (ClassNotFoundException localClassNotFoundException) {
                for (; ; ) {
                }
            }
        }
    }

    public void addConstructor(CtConstructor paramCtConstructor) {
        checkModify();
        if (paramCtConstructor.getDeclaringClass() != this) {
            throw new CannotCompileException("cannot add");
        }
        getMembers().addConstructor(paramCtConstructor);
        getClassFile2().addMethod(paramCtConstructor.getMethodInfo2());
    }

    public void addField(CtField paramCtField, String paramString) {
        addField(paramCtField, CtField.Initializer.byExpr(paramString));
    }

    public void addField(CtField paramCtField, CtField.Initializer paramInitializer) {
        checkModify();
        if (paramCtField.getDeclaringClass() != this) {
            throw new CannotCompileException("cannot add");
        }
        if (paramInitializer == null) {
            paramInitializer = paramCtField.getInit();
        }
        for (; ; ) {
            Object localObject = paramInitializer;
            int i;
            if (paramInitializer != null) {
                paramInitializer.check(paramCtField.getSignature());
                i = paramCtField.getModifiers();
                localObject = paramInitializer;
                if (Modifier.isStatic(i)) {
                    localObject = paramInitializer;
                    if (!Modifier.isFinal(i)) {
                    }
                }
            }
            try {
                ConstPool localConstPool = getClassFile2().getConstPool();
                i = paramInitializer.getConstantValue(localConstPool, paramCtField.getType());
                localObject = paramInitializer;
                if (i != 0) {
                    paramCtField.getFieldInfo2().addAttribute(new ConstantAttribute(localConstPool, i));
                    localObject = null;
                }
            } catch (NotFoundException localNotFoundException) {
                for (; ; ) {
                    CtField.Initializer localInitializer = paramInitializer;
                }
            }
            getMembers().addField(paramCtField);
            getClassFile2().addField(paramCtField.getFieldInfo2());
            if (localObject != null) {
                localObject = new FieldInitLink(paramCtField, (CtField.Initializer) localObject);
                paramInitializer = this.fieldInitializers;
                paramCtField = paramInitializer;
                if (paramInitializer == null) {
                    this.fieldInitializers = ((FieldInitLink) localObject);
                }
            } else {
                return;
            }
            while (paramCtField.next != null) {
                paramCtField = paramCtField.next;
            }
            paramCtField.next = ((FieldInitLink) localObject);
            return;
        }
    }

    public void addInterface(CtClass paramCtClass) {
        checkModify();
        if (paramCtClass != null) {
            getClassFile2().addInterface(paramCtClass.getName());
        }
    }

    public void addMethod(CtMethod paramCtMethod) {
        checkModify();
        if (paramCtMethod.getDeclaringClass() != this) {
            throw new CannotCompileException("bad declaring class");
        }
        int i = paramCtMethod.getModifiers();
        if ((getModifiers() & 0x200) != 0) {
            paramCtMethod.setModifiers(i | 0x1);
            if ((i & 0x400) == 0) {
                throw new CannotCompileException("an interface method must be abstract: " + paramCtMethod.toString());
            }
        }
        getMembers().addMethod(paramCtMethod);
        getClassFile2().addMethod(paramCtMethod.getMethodInfo2());
        if ((i & 0x400) != 0) {
            setModifiers(getModifiers() | 0x400);
        }
    }

    void checkModify() {
        if (isFrozen()) {
            String str2 = getName() + " class is frozen";
            String str1 = str2;
            if (this.wasPruned) {
                str1 = str2 + " and pruned";
            }
            throw new RuntimeException(str1);
        }
        this.wasChanged = true;
    }

    void compress() {
        if (this.getCount < 2) {
            if ((isModified()) || (!ClassPool.releaseUnmodifiedClassFile)) {
                break label31;
            }
            removeClassFile();
        }
        for (; ; ) {
            this.getCount = 0;
            return;
            label31:
            if ((isFrozen()) && (!this.wasPruned)) {
                saveClassFile();
            }
        }
    }

    public void defrost() {
        checkPruned("defrost");
        this.wasFrozen = false;
    }

    protected void extendToString(StringBuffer paramStringBuffer) {
        if (this.wasChanged) {
            paramStringBuffer.append("changed ");
        }
        if (this.wasFrozen) {
            paramStringBuffer.append("frozen ");
        }
        if (this.wasPruned) {
            paramStringBuffer.append("pruned ");
        }
        paramStringBuffer.append(Modifier.toString(getModifiers()));
        paramStringBuffer.append(" class ");
        paramStringBuffer.append(getName());
        for (; ; ) {
            int i;
            try {
                localObject = getSuperclass();
                if ((localObject != null) && (!((CtClass) localObject).getName().equals("java.lang.Object"))) {
                    paramStringBuffer.append(" extends " + ((CtClass) localObject).getName());
                }
            } catch (NotFoundException localNotFoundException1) {
                Object localObject;
                paramStringBuffer.append(" extends ??");
                continue;
            }
            try {
                localObject = getInterfaces();
                if (localObject.length <= 0) {
                    break label251;
                }
                paramStringBuffer.append(" implements ");
            } catch (NotFoundException localNotFoundException2) {
                paramStringBuffer.append(" extends ??");
                CtMember.Cache localCache = getMembers();
                exToString(paramStringBuffer, " fields=", localCache.fieldHead(), localCache.lastField());
                exToString(paramStringBuffer, " constructors=", localCache.consHead(), localCache.lastCons());
                exToString(paramStringBuffer, " methods=", localCache.methodHead(), localCache.lastMethod());
                return;
            }
            if (i < localObject.length) {
                paramStringBuffer.append(localObject[i].getName());
                paramStringBuffer.append(", ");
                i += 1;
            } else {
                label251:
                i = 0;
            }
        }
    }

    public void freeze() {
        this.wasFrozen = true;
    }

    public AccessorMaker getAccessorMaker() {
        if (this.accessors == null) {
            this.accessors = new AccessorMaker(this);
        }
        return this.accessors;
    }

    public Object getAnnotation(Class paramClass) {
        Object localObject = getClassFile2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((ClassFile) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((ClassFile) localObject).getAttribute("RuntimeVisibleAnnotations");
        return getAnnotationType(paramClass, getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    public Object[] getAnnotations() {
        return getAnnotations(false);
    }

    public byte[] getAttribute(String paramString) {
        paramString = getClassFile2().getAttribute(paramString);
        if (paramString == null) {
            return null;
        }
        return paramString.get();
    }

    public Object[] getAvailableAnnotations() {
        try {
            Object[] arrayOfObject = getAnnotations(true);
            return arrayOfObject;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new RuntimeException("Unexpected exception ", localClassNotFoundException);
        }
    }

    /* Error */
    public ClassFile getClassFile2() {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aload_0
        //   3: getfield 48	javassist/CtClassType:classfile	Ljavassist/bytecode/ClassFile;
        //   6: astore_1
        //   7: aload_1
        //   8: ifnull +5 -> 13
        //   11: aload_1
        //   12: areturn
        //   13: aload_0
        //   14: getfield 67	javassist/CtClassType:classPool	Ljavassist/ClassPool;
        //   17: invokevirtual 721	javassist/ClassPool:compress	()V
        //   20: aload_0
        //   21: getfield 77	javassist/CtClassType:rawClassfile	[B
        //   24: ifnull +63 -> 87
        //   27: aload_0
        //   28: new 38	javassist/bytecode/ClassFile
        //   31: dup
        //   32: new 40	java/io/DataInputStream
        //   35: dup
        //   36: new 723	java/io/ByteArrayInputStream
        //   39: dup
        //   40: aload_0
        //   41: getfield 77	javassist/CtClassType:rawClassfile	[B
        //   44: invokespecial 726	java/io/ByteArrayInputStream:<init>	([B)V
        //   47: invokespecial 43	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
        //   50: invokespecial 46	javassist/bytecode/ClassFile:<init>	(Ljava/io/DataInputStream;)V
        //   53: putfield 48	javassist/CtClassType:classfile	Ljavassist/bytecode/ClassFile;
        //   56: aload_0
        //   57: aconst_null
        //   58: putfield 77	javassist/CtClassType:rawClassfile	[B
        //   61: aload_0
        //   62: iconst_2
        //   63: putfield 89	javassist/CtClassType:getCount	I
        //   66: aload_0
        //   67: getfield 48	javassist/CtClassType:classfile	Ljavassist/bytecode/ClassFile;
        //   70: astore_1
        //   71: aload_1
        //   72: areturn
        //   73: astore_1
        //   74: new 116	java/lang/RuntimeException
        //   77: dup
        //   78: aload_1
        //   79: invokevirtual 727	java/io/IOException:toString	()Ljava/lang/String;
        //   82: aload_1
        //   83: invokespecial 719	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   86: athrow
        //   87: aload_0
        //   88: getfield 67	javassist/CtClassType:classPool	Ljavassist/ClassPool;
        //   91: aload_0
        //   92: invokevirtual 112	javassist/CtClassType:getName	()Ljava/lang/String;
        //   95: invokevirtual 731	javassist/ClassPool:openClassfile	(Ljava/lang/String;)Ljava/io/InputStream;
        //   98: astore_1
        //   99: aload_1
        //   100: ifnonnull +44 -> 144
        //   103: aload_1
        //   104: astore_3
        //   105: new 109	javassist/NotFoundException
        //   108: dup
        //   109: aload_0
        //   110: invokevirtual 112	javassist/CtClassType:getName	()Ljava/lang/String;
        //   113: invokespecial 113	javassist/NotFoundException:<init>	(Ljava/lang/String;)V
        //   116: athrow
        //   117: astore_1
        //   118: new 116	java/lang/RuntimeException
        //   121: dup
        //   122: aload_1
        //   123: invokevirtual 732	javassist/NotFoundException:toString	()Ljava/lang/String;
        //   126: aload_1
        //   127: invokespecial 719	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   130: athrow
        //   131: astore_1
        //   132: aload_3
        //   133: astore_2
        //   134: aload_2
        //   135: ifnull +7 -> 142
        //   138: aload_2
        //   139: invokevirtual 735	java/io/InputStream:close	()V
        //   142: aload_1
        //   143: athrow
        //   144: aload_1
        //   145: astore_3
        //   146: new 737	java/io/BufferedInputStream
        //   149: dup
        //   150: aload_1
        //   151: invokespecial 738	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   154: astore_2
        //   155: aload_2
        //   156: astore_3
        //   157: new 38	javassist/bytecode/ClassFile
        //   160: dup
        //   161: new 40	java/io/DataInputStream
        //   164: dup
        //   165: aload_2
        //   166: invokespecial 43	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
        //   169: invokespecial 46	javassist/bytecode/ClassFile:<init>	(Ljava/io/DataInputStream;)V
        //   172: astore 4
        //   174: aload_2
        //   175: astore_3
        //   176: aload 4
        //   178: invokevirtual 52	javassist/bytecode/ClassFile:getName	()Ljava/lang/String;
        //   181: aload_0
        //   182: getfield 56	javassist/CtClassType:qualifiedName	Ljava/lang/String;
        //   185: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   188: ifne +76 -> 264
        //   191: aload_2
        //   192: astore_3
        //   193: new 116	java/lang/RuntimeException
        //   196: dup
        //   197: new 93	java/lang/StringBuilder
        //   200: dup
        //   201: invokespecial 96	java/lang/StringBuilder:<init>	()V
        //   204: ldc_w 740
        //   207: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   210: aload_0
        //   211: getfield 56	javassist/CtClassType:qualifiedName	Ljava/lang/String;
        //   214: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   217: ldc_w 742
        //   220: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   223: aload 4
        //   225: invokevirtual 52	javassist/bytecode/ClassFile:getName	()Ljava/lang/String;
        //   228: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   231: ldc_w 744
        //   234: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   237: aload_0
        //   238: getfield 56	javassist/CtClassType:qualifiedName	Ljava/lang/String;
        //   241: bipush 46
        //   243: bipush 47
        //   245: invokevirtual 748	java/lang/String:replace	(CC)Ljava/lang/String;
        //   248: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   251: ldc_w 750
        //   254: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   257: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   260: invokespecial 121	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
        //   263: athrow
        //   264: aload_2
        //   265: astore_3
        //   266: aload_0
        //   267: aload 4
        //   269: putfield 48	javassist/CtClassType:classfile	Ljavassist/bytecode/ClassFile;
        //   272: aload 4
        //   274: astore_1
        //   275: aload_2
        //   276: ifnull -265 -> 11
        //   279: aload_2
        //   280: invokevirtual 735	java/io/InputStream:close	()V
        //   283: aload 4
        //   285: areturn
        //   286: astore_1
        //   287: aload 4
        //   289: areturn
        //   290: astore 4
        //   292: aconst_null
        //   293: astore_1
        //   294: aload_1
        //   295: astore_3
        //   296: new 116	java/lang/RuntimeException
        //   299: dup
        //   300: aload 4
        //   302: invokevirtual 727	java/io/IOException:toString	()Ljava/lang/String;
        //   305: aload 4
        //   307: invokespecial 719	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   310: athrow
        //   311: astore_1
        //   312: aload_3
        //   313: astore_2
        //   314: goto -180 -> 134
        //   317: astore_2
        //   318: goto -176 -> 142
        //   321: astore_1
        //   322: aconst_null
        //   323: astore_2
        //   324: goto -190 -> 134
        //   327: astore_3
        //   328: aload_1
        //   329: astore_2
        //   330: aload_3
        //   331: astore_1
        //   332: goto -198 -> 134
        //   335: astore 4
        //   337: goto -43 -> 294
        //   340: astore 4
        //   342: aload_2
        //   343: astore_1
        //   344: goto -50 -> 294
        //   347: astore_1
        //   348: aload_2
        //   349: astore_3
        //   350: goto -232 -> 118
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	353	0	this	CtClassType
        //   6	66	1	localClassFile1	ClassFile
        //   73	10	1	localIOException1	java.io.IOException
        //   98	6	1	localInputStream1	InputStream
        //   117	10	1	localNotFoundException1	NotFoundException
        //   131	20	1	localInputStream2	InputStream
        //   274	1	1	localObject1	Object
        //   286	1	1	localIOException2	java.io.IOException
        //   293	2	1	localObject2	Object
        //   311	1	1	localObject3	Object
        //   321	8	1	localObject4	Object
        //   331	13	1	localObject5	Object
        //   347	1	1	localNotFoundException2	NotFoundException
        //   133	181	2	localObject6	Object
        //   317	1	2	localIOException3	java.io.IOException
        //   323	26	2	localObject7	Object
        //   1	312	3	localObject8	Object
        //   327	4	3	localObject9	Object
        //   349	1	3	localObject10	Object
        //   172	116	4	localClassFile2	ClassFile
        //   290	16	4	localIOException4	java.io.IOException
        //   335	1	4	localIOException5	java.io.IOException
        //   340	1	4	localIOException6	java.io.IOException
        // Exception table:
        //   from	to	target	type
        //   27	71	73	java/io/IOException
        //   87	99	117	javassist/NotFoundException
        //   105	117	117	javassist/NotFoundException
        //   146	155	117	javassist/NotFoundException
        //   118	131	131	finally
        //   279	283	286	java/io/IOException
        //   87	99	290	java/io/IOException
        //   157	174	311	finally
        //   176	191	311	finally
        //   193	264	311	finally
        //   266	272	311	finally
        //   296	311	311	finally
        //   138	142	317	java/io/IOException
        //   87	99	321	finally
        //   105	117	327	finally
        //   146	155	327	finally
        //   105	117	335	java/io/IOException
        //   146	155	335	java/io/IOException
        //   157	174	340	java/io/IOException
        //   176	191	340	java/io/IOException
        //   193	264	340	java/io/IOException
        //   266	272	340	java/io/IOException
        //   157	174	347	javassist/NotFoundException
        //   176	191	347	javassist/NotFoundException
        //   193	264	347	javassist/NotFoundException
        //   266	272	347	javassist/NotFoundException
    }

    public CtConstructor getClassInitializer() {
        Object localObject = getMembers();
        CtMember localCtMember = ((CtMember.Cache) localObject).consHead();
        localObject = ((CtMember.Cache) localObject).lastCons();
        while (localCtMember != localObject) {
            localCtMember = localCtMember.next();
            CtConstructor localCtConstructor = (CtConstructor) localCtMember;
            if (localCtConstructor.isClassInitializer()) {
                return localCtConstructor;
            }
        }
        return null;
    }

    public ClassPool getClassPool() {
        return this.classPool;
    }

    public CtConstructor getConstructor(String paramString) {
        Object localObject2 = getMembers();
        Object localObject1 = ((CtMember.Cache) localObject2).consHead();
        CtMember localCtMember = ((CtMember.Cache) localObject2).lastCons();
        while (localObject1 != localCtMember) {
            localObject2 = ((CtMember) localObject1).next();
            CtConstructor localCtConstructor = (CtConstructor) localObject2;
            localObject1 = localObject2;
            if (localCtConstructor.getMethodInfo2().getDescriptor().equals(paramString)) {
                localObject1 = localObject2;
                if (localCtConstructor.isConstructor()) {
                    return localCtConstructor;
                }
            }
        }
        return super.getConstructor(paramString);
    }

    public CtConstructor[] getConstructors() {
        int j = 0;
        Object localObject1 = getMembers();
        CtMember localCtMember1 = ((CtMember.Cache) localObject1).consHead();
        CtMember localCtMember2 = ((CtMember.Cache) localObject1).lastCons();
        localObject1 = localCtMember1;
        int i = 0;
        Object localObject2;
        while (localObject1 != localCtMember2) {
            localObject2 = ((CtMember) localObject1).next();
            localObject1 = localObject2;
            if (isPubCons((CtConstructor) localObject2)) {
                i += 1;
                localObject1 = localObject2;
            }
        }
        localObject1 = new CtConstructor[i];
        i = j;
        if (localCtMember1 != localCtMember2) {
            localCtMember1 = localCtMember1.next();
            localObject2 = (CtConstructor) localCtMember1;
            if (!isPubCons((CtConstructor) localObject2)) {
                break label115;
            }
            localObject1[i] = localObject2;
            i += 1;
        }
        label115:
        for (; ; ) {
            break;
            return (CtConstructor[]) localObject1;
        }
    }

    public CtBehavior[] getDeclaredBehaviors() {
        Object localObject2 = getMembers();
        Object localObject1 = ((CtMember.Cache) localObject2).consHead();
        CtMember localCtMember2 = ((CtMember.Cache) localObject2).lastCons();
        int i = CtMember.Cache.count((CtMember) localObject1, localCtMember2);
        CtMember localCtMember1 = ((CtMember.Cache) localObject2).methodHead();
        localObject2 = ((CtMember.Cache) localObject2).lastMethod();
        CtBehavior[] arrayOfCtBehavior = new CtBehavior[CtMember.Cache.count(localCtMember1, (CtMember) localObject2) + i];
        i = 0;
        while (localObject1 != localCtMember2) {
            localObject1 = ((CtMember) localObject1).next();
            arrayOfCtBehavior[i] = ((CtBehavior) localObject1);
            i += 1;
        }
        for (; ; ) {
            if (localObject1 != localObject2) {
                localObject1 = ((CtMember) localObject1).next();
                arrayOfCtBehavior[i] = ((CtBehavior) localObject1);
                i += 1;
            } else {
                return arrayOfCtBehavior;
                localObject1 = localCtMember1;
            }
        }
    }

    public CtConstructor[] getDeclaredConstructors() {
        int j = 0;
        Object localObject = getMembers();
        CtMember localCtMember1 = ((CtMember.Cache) localObject).consHead();
        CtMember localCtMember2 = ((CtMember.Cache) localObject).lastCons();
        localObject = localCtMember1;
        int i = 0;
        if (localObject != localCtMember2) {
            localObject = ((CtMember) localObject).next();
            if (!((CtConstructor) localObject).isConstructor()) {
                break label110;
            }
            i += 1;
        }
        label107:
        label110:
        for (; ; ) {
            break;
            localObject = new CtConstructor[i];
            i = j;
            if (localCtMember1 != localCtMember2) {
                localCtMember1 = localCtMember1.next();
                CtConstructor localCtConstructor = (CtConstructor) localCtMember1;
                if (!localCtConstructor.isConstructor()) {
                    break label107;
                }
                localObject[i] = localCtConstructor;
                i += 1;
            }
            for (; ; ) {
                break;
                return (CtConstructor[]) localObject;
            }
        }
    }

    public CtField getDeclaredField(String paramString) {
        return getDeclaredField(paramString, null);
    }

    public CtField getDeclaredField(String paramString1, String paramString2) {
        return checkGetField(getDeclaredField2(paramString1, paramString2), paramString1, paramString2);
    }

    public CtField[] getDeclaredFields() {
        Object localObject = getMembers();
        CtMember localCtMember = ((CtMember.Cache) localObject).fieldHead();
        localObject = ((CtMember.Cache) localObject).lastField();
        CtField[] arrayOfCtField = new CtField[CtMember.Cache.count(localCtMember, (CtMember) localObject)];
        int i = 0;
        while (localCtMember != localObject) {
            localCtMember = localCtMember.next();
            arrayOfCtField[i] = ((CtField) localCtMember);
            i += 1;
        }
        return arrayOfCtField;
    }

    public CtMethod getDeclaredMethod(String paramString) {
        Object localObject2 = getMembers();
        Object localObject1 = ((CtMember.Cache) localObject2).methodHead();
        CtMember localCtMember = ((CtMember.Cache) localObject2).lastMethod();
        while (localObject1 != localCtMember) {
            localObject2 = ((CtMember) localObject1).next();
            localObject1 = localObject2;
            if (((CtMember) localObject2).getName().equals(paramString)) {
                return (CtMethod) localObject2;
            }
        }
        throw new NotFoundException(paramString + "(..) is not found in " + getName());
    }

    public CtMethod getDeclaredMethod(String paramString, CtClass[] paramArrayOfCtClass) {
        String str = Descriptor.ofParameters(paramArrayOfCtClass);
        Object localObject = getMembers();
        paramArrayOfCtClass = ((CtMember.Cache) localObject).methodHead();
        CtMember localCtMember = ((CtMember.Cache) localObject).lastMethod();
        while (paramArrayOfCtClass != localCtMember) {
            localObject = paramArrayOfCtClass.next();
            paramArrayOfCtClass = (CtClass[]) localObject;
            if (((CtMember) localObject).getName().equals(paramString)) {
                paramArrayOfCtClass = (CtClass[]) localObject;
                if (((CtMethod) localObject).getMethodInfo2().getDescriptor().startsWith(str)) {
                    return (CtMethod) localObject;
                }
            }
        }
        throw new NotFoundException(paramString + "(..) is not found in " + getName());
    }

    public CtMethod[] getDeclaredMethods() {
        Object localObject = getMembers();
        CtMember localCtMember = ((CtMember.Cache) localObject).methodHead();
        localObject = ((CtMember.Cache) localObject).lastMethod();
        CtMethod[] arrayOfCtMethod = new CtMethod[CtMember.Cache.count(localCtMember, (CtMember) localObject)];
        int i = 0;
        while (localCtMember != localObject) {
            localCtMember = localCtMember.next();
            arrayOfCtMethod[i] = ((CtMethod) localCtMember);
            i += 1;
        }
        return arrayOfCtMethod;
    }

    public CtClass getDeclaringClass() {
        ClassFile localClassFile = getClassFile2();
        InnerClassesAttribute localInnerClassesAttribute = (InnerClassesAttribute) localClassFile.getAttribute("InnerClasses");
        if (localInnerClassesAttribute == null) {
            return null;
        }
        String str = getName();
        int j = localInnerClassesAttribute.tableLength();
        int i = 0;
        while (i < j) {
            if (str.equals(localInnerClassesAttribute.innerClass(i))) {
                Object localObject = localInnerClassesAttribute.outerClass(i);
                if (localObject != null) {
                    return this.classPool.get((String) localObject);
                }
                localObject = (EnclosingMethodAttribute) localClassFile.getAttribute("EnclosingMethod");
                if (localObject != null) {
                    return this.classPool.get(((EnclosingMethodAttribute) localObject).className());
                }
            }
            i += 1;
        }
        return null;
    }

    public CtMethod getEnclosingMethod() {
        EnclosingMethodAttribute localEnclosingMethodAttribute = (EnclosingMethodAttribute) getClassFile2().getAttribute("EnclosingMethod");
        if (localEnclosingMethodAttribute != null) {
            return this.classPool.get(localEnclosingMethodAttribute.className()).getMethod(localEnclosingMethodAttribute.methodName(), localEnclosingMethodAttribute.methodDescriptor());
        }
        return null;
    }

    public CtField getField(String paramString1, String paramString2) {
        return checkGetField(getField2(paramString1, paramString2), paramString1, paramString2);
    }

    CtField getField2(String paramString1, String paramString2) {
        Object localObject = getDeclaredField2(paramString1, paramString2);
        if (localObject != null) {
        }
        for (; ; ) {
            return (CtField) localObject;
            try {
                CtClass[] arrayOfCtClass = getInterfaces();
                int j = arrayOfCtClass.length;
                int i = 0;
                for (; ; ) {
                    if (i >= j) {
                        break label62;
                    }
                    CtField localCtField = arrayOfCtClass[i].getField2(paramString1, paramString2);
                    localObject = localCtField;
                    if (localCtField != null) {
                        break;
                    }
                    i += 1;
                }
                label62:
                localObject = getSuperclass();
                if (localObject != null) {
                    paramString1 = ((CtClass) localObject).getField2(paramString1, paramString2);
                    return paramString1;
                }
            } catch (NotFoundException paramString1) {
            }
        }
        return null;
    }

    public CtField[] getFields() {
        ArrayList localArrayList = new ArrayList();
        getFields(localArrayList, this);
        return (CtField[]) localArrayList.toArray(new CtField[localArrayList.size()]);
    }

    Hashtable getHiddenMethods() {
        if (this.hiddenMethods == null) {
            this.hiddenMethods = new Hashtable();
        }
        return this.hiddenMethods;
    }

    public CtClass[] getInterfaces() {
        String[] arrayOfString = getClassFile2().getInterfaces();
        int j = arrayOfString.length;
        CtClass[] arrayOfCtClass = new CtClass[j];
        int i = 0;
        while (i < j) {
            arrayOfCtClass[i] = this.classPool.get(arrayOfString[i]);
            i += 1;
        }
        return arrayOfCtClass;
    }

    protected CtMember.Cache getMembers() {
        try {
            CtMember.Cache localCache1;
            if (this.memberCache != null) {
                CtMember.Cache localCache2 = (CtMember.Cache) this.memberCache.get();
                localCache1 = localCache2;
                if (localCache2 != null) {
                }
            } else {
                localCache1 = new CtMember.Cache(this);
                makeFieldCache(localCache1);
                makeBehaviorCache(localCache1);
                this.memberCache = new WeakReference(localCache1);
            }
            return localCache1;
        } finally {
        }
    }

    public CtMethod getMethod(String paramString1, String paramString2) {
        paramString2 = getMethod0(this, paramString1, paramString2);
        if (paramString2 != null) {
            return paramString2;
        }
        throw new NotFoundException(paramString1 + "(..) is not found in " + getName());
    }

    public CtMethod[] getMethods() {
        HashMap localHashMap = new HashMap();
        getMethods0(localHashMap, this);
        return (CtMethod[]) localHashMap.values().toArray(new CtMethod[localHashMap.size()]);
    }

    public int getModifiers() {
        ClassFile localClassFile = getClassFile2();
        int j = AccessFlag.clear(localClassFile.getAccessFlags(), 32);
        int k = localClassFile.getInnerAccessFlags();
        int i = j;
        if (k != -1) {
            i = j;
            if ((k & 0x8) != 0) {
                i = j | 0x8;
            }
        }
        return AccessFlag.toModifier(i);
    }

    public CtClass[] getNestedClasses() {
        int i = 0;
        Object localObject = getClassFile2();
        InnerClassesAttribute localInnerClassesAttribute = (InnerClassesAttribute) ((ClassFile) localObject).getAttribute("InnerClasses");
        if (localInnerClassesAttribute == null) {
            return new CtClass[0];
        }
        localObject = ((ClassFile) localObject).getName() + "$";
        int j = localInnerClassesAttribute.tableLength();
        ArrayList localArrayList = new ArrayList(j);
        while (i < j) {
            String str = localInnerClassesAttribute.innerClass(i);
            if ((str != null) && (str.startsWith((String) localObject)) && (str.lastIndexOf('$') < ((String) localObject).length())) {
                localArrayList.add(this.classPool.get(str));
            }
            i += 1;
        }
        return (CtClass[]) localArrayList.toArray(new CtClass[localArrayList.size()]);
    }

    public CtClass getSuperclass() {
        String str = getClassFile2().getSuperclass();
        if (str == null) {
            return null;
        }
        return this.classPool.get(str);
    }

    public URL getURL() {
        URL localURL = this.classPool.find(getName());
        if (localURL == null) {
            throw new NotFoundException(getName());
        }
        return localURL;
    }

    int getUniqueNumber() {
        int i = this.uniqueNumberSeed;
        this.uniqueNumberSeed = (i + 1);
        return i;
    }

    public boolean hasAnnotation(Class paramClass) {
        Object localObject = getClassFile2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((ClassFile) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((ClassFile) localObject).getAttribute("RuntimeVisibleAnnotations");
        return hasAnnotationType(paramClass, getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    protected CtMember.Cache hasMemberCache() {
        if (this.memberCache != null) {
            return (CtMember.Cache) this.memberCache.get();
        }
        return null;
    }

    final void incGetCounter() {
        this.getCount += 1;
    }

    public void instrument(CodeConverter paramCodeConverter) {
        checkModify();
        Object localObject = getClassFile2();
        ConstPool localConstPool = ((ClassFile) localObject).getConstPool();
        localObject = ((ClassFile) localObject).getMethods();
        int j = ((List) localObject).size();
        int i = 0;
        while (i < j) {
            paramCodeConverter.doit(this, (MethodInfo) ((List) localObject).get(i), localConstPool);
            i += 1;
        }
    }

    public void instrument(ExprEditor paramExprEditor) {
        checkModify();
        List localList = getClassFile2().getMethods();
        int j = localList.size();
        int i = 0;
        while (i < j) {
            paramExprEditor.doit(this, (MethodInfo) localList.get(i));
            i += 1;
        }
    }

    public boolean isAnnotation() {
        return Modifier.isAnnotation(getModifiers());
    }

    public boolean isEnum() {
        return Modifier.isEnum(getModifiers());
    }

    public boolean isFrozen() {
        return this.wasFrozen;
    }

    public boolean isInterface() {
        return Modifier.isInterface(getModifiers());
    }

    public boolean isModified() {
        return this.wasChanged;
    }

    public CtConstructor makeClassInitializer() {
        Object localObject = getClassInitializer();
        if (localObject != null) {
            return (CtConstructor) localObject;
        }
        checkModify();
        localObject = getClassFile2();
        modifyClassConstructor((ClassFile) localObject, new Bytecode(((ClassFile) localObject).getConstPool(), 0, 0), 0, 0);
        return getClassInitializer();
    }

    public CtClass makeNestedClass(String paramString, boolean paramBoolean) {
        if (!paramBoolean) {
            throw new RuntimeException("sorry, only nested static class is supported");
        }
        checkModify();
        CtClass localCtClass = this.classPool.makeNestedClass(getName() + "$" + paramString);
        ClassFile localClassFile1 = getClassFile2();
        ClassFile localClassFile2 = localCtClass.getClassFile2();
        InnerClassesAttribute localInnerClassesAttribute2 = (InnerClassesAttribute) localClassFile1.getAttribute("InnerClasses");
        InnerClassesAttribute localInnerClassesAttribute1 = localInnerClassesAttribute2;
        if (localInnerClassesAttribute2 == null) {
            localInnerClassesAttribute1 = new InnerClassesAttribute(localClassFile1.getConstPool());
            localClassFile1.addAttribute(localInnerClassesAttribute1);
        }
        localInnerClassesAttribute1.append(localCtClass.getName(), getName(), paramString, localClassFile2.getAccessFlags() & 0xFFFFFFDF | 0x8);
        localClassFile2.addAttribute(localInnerClassesAttribute1.copy(localClassFile2.getConstPool(), null));
        return localCtClass;
    }

    public String makeUniqueName(String paramString) {
        Object localObject1 = new HashMap();
        makeMemberList((HashMap) localObject1);
        Object localObject2 = ((HashMap) localObject1).keySet();
        localObject1 = new String[((Set) localObject2).size()];
        ((Set) localObject2).toArray((Object[]) localObject1);
        if (notFindInArray(paramString, (String[]) localObject1)) {
            return paramString;
        }
        int i = 100;
        for (; ; ) {
            if (i > 999) {
                throw new RuntimeException("too many unique name");
            }
            localObject2 = paramString + i;
            if (notFindInArray((String) localObject2, (String[]) localObject1)) {
                return (String) localObject2;
            }
            i += 1;
        }
    }

    public void prune() {
        if (this.wasPruned) {
            return;
        }
        this.wasFrozen = true;
        this.wasPruned = true;
        getClassFile2().prune();
    }

    public void rebuildClassFile() {
        this.gcConstPool = true;
    }

    public void removeConstructor(CtConstructor paramCtConstructor) {
        checkModify();
        MethodInfo localMethodInfo = paramCtConstructor.getMethodInfo2();
        if (getClassFile2().getMethods().remove(localMethodInfo)) {
            getMembers().remove(paramCtConstructor);
            this.gcConstPool = true;
            return;
        }
        throw new NotFoundException(paramCtConstructor.toString());
    }

    public void removeField(CtField paramCtField) {
        checkModify();
        FieldInfo localFieldInfo = paramCtField.getFieldInfo2();
        if (getClassFile2().getFields().remove(localFieldInfo)) {
            getMembers().remove(paramCtField);
            this.gcConstPool = true;
            return;
        }
        throw new NotFoundException(paramCtField.toString());
    }

    public void removeMethod(CtMethod paramCtMethod) {
        checkModify();
        MethodInfo localMethodInfo = paramCtMethod.getMethodInfo2();
        if (getClassFile2().getMethods().remove(localMethodInfo)) {
            getMembers().remove(paramCtMethod);
            this.gcConstPool = true;
            return;
        }
        throw new NotFoundException(paramCtMethod.toString());
    }

    public void replaceClassName(String paramString1, String paramString2) {
        if (getName().equals(paramString1)) {
            setName(paramString2);
            return;
        }
        super.replaceClassName(paramString1, paramString2);
        getClassFile2().renameClass(paramString1, paramString2);
        nameReplaced();
    }

    public void replaceClassName(ClassMap paramClassMap) {
        String str3 = getName();
        String str2 = (String) paramClassMap.get(Descriptor.toJvmName(str3));
        String str1 = str2;
        if (str2 != null) {
            str1 = Descriptor.toJavaName(str2);
            this.classPool.checkNotFrozen(str1);
        }
        super.replaceClassName(paramClassMap);
        getClassFile2().renameClass(paramClassMap);
        nameReplaced();
        if (str1 != null) {
            super.setName(str1);
            this.classPool.classNameChanged(str3, this);
        }
    }

    public void setAttribute(String paramString, byte[] paramArrayOfByte) {
        checkModify();
        ClassFile localClassFile = getClassFile2();
        localClassFile.addAttribute(new AttributeInfo(localClassFile.getConstPool(), paramString, paramArrayOfByte));
    }

    void setClassPool(ClassPool paramClassPool) {
        this.classPool = paramClassPool;
    }

    public void setInterfaces(CtClass[] paramArrayOfCtClass) {
        int i = 0;
        checkModify();
        Object localObject;
        if (paramArrayOfCtClass == null) {
            localObject = new String[0];
            getClassFile2().setInterfaces((String[]) localObject);
            return;
        }
        int j = paramArrayOfCtClass.length;
        String[] arrayOfString = new String[j];
        for (; ; ) {
            localObject = arrayOfString;
            if (i >= j) {
                break;
            }
            arrayOfString[i] = paramArrayOfCtClass[i].getName();
            i += 1;
        }
    }

    public void setModifiers(int paramInt) {
        ClassFile localClassFile = getClassFile2();
        int i = paramInt;
        if (Modifier.isStatic(paramInt)) {
            i = localClassFile.getInnerAccessFlags();
            if ((i != -1) && ((i & 0x8) != 0)) {
                i = paramInt & 0xFFFFFFF7;
            }
        } else {
            checkModify();
            localClassFile.setAccessFlags(AccessFlag.of(i));
            return;
        }
        throw new RuntimeException("cannot change " + getName() + " into a static class");
    }

    public void setName(String paramString) {
        String str = getName();
        if (paramString.equals(str)) {
            return;
        }
        this.classPool.checkNotFrozen(paramString);
        ClassFile localClassFile = getClassFile2();
        super.setName(paramString);
        localClassFile.setName(paramString);
        nameReplaced();
        this.classPool.classNameChanged(str, this);
    }

    public void setSuperclass(CtClass paramCtClass) {
        checkModify();
        if (isInterface()) {
            addInterface(paramCtClass);
            return;
        }
        getClassFile2().setSuperclass(paramCtClass.getName());
    }

    public boolean stopPruning(boolean paramBoolean) {
        boolean bool2 = true;
        boolean bool1;
        if (!this.doPruning) {
            bool1 = true;
            if (paramBoolean) {
                break label29;
            }
        }
        label29:
        for (paramBoolean = bool2; ; paramBoolean = false) {
            this.doPruning = paramBoolean;
            return bool1;
            bool1 = false;
            break;
        }
    }

    public boolean subclassOf(CtClass paramCtClass) {
        if (paramCtClass == null) {
            return false;
        }
        String str = paramCtClass.getName();
        paramCtClass = this;
        while (paramCtClass != null) {
            try {
                if (paramCtClass.getName().equals(str)) {
                    return true;
                }
                paramCtClass = paramCtClass.getSuperclass();
            } catch (Exception paramCtClass) {
            }
        }
        return false;
    }

    public boolean subtypeOf(CtClass paramCtClass) {
        String str1 = paramCtClass.getName();
        if ((this == paramCtClass) || (getName().equals(str1))) {
        }
        Object localObject;
        String str2;
        int j;
        label90:
        do {
            do {
                return true;
                localObject = getClassFile2();
                str2 = ((ClassFile) localObject).getSuperclass();
            } while ((str2 != null) && (str2.equals(str1)));
            localObject = ((ClassFile) localObject).getInterfaces();
            j = localObject.length;
            i = 0;
            for (; ; ) {
                if (i >= j) {
                    break label90;
                }
                if (localObject[i].equals(str1)) {
                    break;
                }
                i += 1;
            }
        } while ((str2 != null) && (this.classPool.get(str2).subtypeOf(paramCtClass)));
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label143;
            }
            if (this.classPool.get(localObject[i]).subtypeOf(paramCtClass)) {
                break;
            }
            i += 1;
        }
        label143:
        return false;
    }

    /* Error */
    public void toBytecode(DataOutputStream paramDataOutputStream) {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 524	javassist/CtClassType:isModified	()Z
        //   4: ifeq +93 -> 97
        //   7: aload_0
        //   8: ldc_w 1064
        //   11: invokespecial 661	javassist/CtClassType:checkPruned	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: invokevirtual 186	javassist/CtClassType:getClassFile2	()Ljavassist/bytecode/ClassFile;
        //   18: astore_2
        //   19: aload_0
        //   20: getfield 69	javassist/CtClassType:gcConstPool	Z
        //   23: ifeq +12 -> 35
        //   26: aload_2
        //   27: invokevirtual 1067	javassist/bytecode/ClassFile:compact	()V
        //   30: aload_0
        //   31: iconst_0
        //   32: putfield 69	javassist/CtClassType:gcConstPool	Z
        //   35: aload_0
        //   36: aload_2
        //   37: invokespecial 1069	javassist/CtClassType:modifyClassConstructor	(Ljavassist/bytecode/ClassFile;)V
        //   40: aload_0
        //   41: aload_2
        //   42: invokespecial 1071	javassist/CtClassType:modifyConstructors	(Ljavassist/bytecode/ClassFile;)V
        //   45: getstatic 126	javassist/CtClassType:debugDump	Ljava/lang/String;
        //   48: ifnull +8 -> 56
        //   51: aload_0
        //   52: aload_2
        //   53: invokespecial 1073	javassist/CtClassType:dumpClassFile	(Ljavassist/bytecode/ClassFile;)V
        //   56: aload_2
        //   57: aload_1
        //   58: invokevirtual 134	javassist/bytecode/ClassFile:write	(Ljava/io/DataOutputStream;)V
        //   61: aload_1
        //   62: invokevirtual 1076	java/io/DataOutputStream:flush	()V
        //   65: aload_0
        //   66: aconst_null
        //   67: putfield 83	javassist/CtClassType:fieldInitializers	Ljavassist/FieldInitLink;
        //   70: aload_0
        //   71: getfield 65	javassist/CtClassType:doPruning	Z
        //   74: ifeq +12 -> 86
        //   77: aload_2
        //   78: invokevirtual 977	javassist/bytecode/ClassFile:prune	()V
        //   81: aload_0
        //   82: iconst_1
        //   83: putfield 71	javassist/CtClassType:wasPruned	Z
        //   86: aload_0
        //   87: iconst_0
        //   88: putfield 89	javassist/CtClassType:getCount	I
        //   91: aload_0
        //   92: iconst_1
        //   93: putfield 73	javassist/CtClassType:wasFrozen	Z
        //   96: return
        //   97: aload_0
        //   98: getfield 67	javassist/CtClassType:classPool	Ljavassist/ClassPool;
        //   101: aload_0
        //   102: invokevirtual 112	javassist/CtClassType:getName	()Ljava/lang/String;
        //   105: aload_1
        //   106: invokevirtual 1080	javassist/ClassPool:writeClassfile	(Ljava/lang/String;Ljava/io/OutputStream;)V
        //   109: goto -23 -> 86
        //   112: astore_1
        //   113: new 415	javassist/CannotCompileException
        //   116: dup
        //   117: aload_1
        //   118: invokespecial 1083	javassist/CannotCompileException:<init>	(Ljavassist/NotFoundException;)V
        //   121: athrow
        //   122: astore_1
        //   123: new 415	javassist/CannotCompileException
        //   126: dup
        //   127: aload_1
        //   128: invokespecial 499	javassist/CannotCompileException:<init>	(Ljava/lang/Throwable;)V
        //   131: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	132	0	this	CtClassType
        //   0	132	1	paramDataOutputStream	DataOutputStream
        //   18	60	2	localClassFile	ClassFile
        // Exception table:
        //   from	to	target	type
        //   0	35	112	javassist/NotFoundException
        //   35	56	112	javassist/NotFoundException
        //   56	86	112	javassist/NotFoundException
        //   86	96	112	javassist/NotFoundException
        //   97	109	112	javassist/NotFoundException
        //   0	35	122	java/io/IOException
        //   35	56	122	java/io/IOException
        //   56	86	122	java/io/IOException
        //   86	96	122	java/io/IOException
        //   97	109	122	java/io/IOException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtClassType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */