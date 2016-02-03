package javassist;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.security.ProtectionDomain;

import javassist.bytecode.ClassFile;
import javassist.bytecode.Descriptor;
import javassist.compiler.AccessorMaker;
import javassist.expr.ExprEditor;

public abstract class CtClass {
    public static CtClass booleanType;
    public static CtClass byteType;
    public static CtClass charType;
    public static String debugDump = null;
    public static CtClass doubleType;
    public static CtClass floatType;
    public static CtClass intType;
    static final String javaLangObject = "java.lang.Object";
    public static CtClass longType;
    static CtClass[] primitiveTypes = new CtClass[9];
    public static CtClass shortType;
    public static final String version = "3.16.1-GA";
    public static CtClass voidType;
    protected String qualifiedName;

    static {
        booleanType = new CtPrimitiveType("boolean", 'Z', "java.lang.Boolean", "booleanValue", "()Z", 172, 4, 1);
        primitiveTypes[0] = booleanType;
        charType = new CtPrimitiveType("char", 'C', "java.lang.Character", "charValue", "()C", 172, 5, 1);
        primitiveTypes[1] = charType;
        byteType = new CtPrimitiveType("byte", 'B', "java.lang.Byte", "byteValue", "()B", 172, 8, 1);
        primitiveTypes[2] = byteType;
        shortType = new CtPrimitiveType("short", 'S', "java.lang.Short", "shortValue", "()S", 172, 9, 1);
        primitiveTypes[3] = shortType;
        intType = new CtPrimitiveType("int", 'I', "java.lang.Integer", "intValue", "()I", 172, 10, 1);
        primitiveTypes[4] = intType;
        longType = new CtPrimitiveType("long", 'J', "java.lang.Long", "longValue", "()J", 173, 11, 2);
        primitiveTypes[5] = longType;
        floatType = new CtPrimitiveType("float", 'F', "java.lang.Float", "floatValue", "()F", 174, 6, 1);
        primitiveTypes[6] = floatType;
        doubleType = new CtPrimitiveType("double", 'D', "java.lang.Double", "doubleValue", "()D", 175, 7, 2);
        primitiveTypes[7] = doubleType;
        voidType = new CtPrimitiveType("void", 'V', "java.lang.Void", null, null, 177, 0, 0);
        primitiveTypes[8] = voidType;
    }

    protected CtClass(String paramString) {
        this.qualifiedName = paramString;
    }

    public static void main(String[] paramArrayOfString) {
        System.out.println("Javassist version 3.16.1-GA");
        System.out.println("Copyright (C) 1999-2012 Shigeru Chiba. All Rights Reserved.");
    }

    public void addConstructor(CtConstructor paramCtConstructor) {
        checkModify();
    }

    public void addField(CtField paramCtField) {
        addField(paramCtField, (CtField.Initializer) null);
    }

    public void addField(CtField paramCtField, String paramString) {
        checkModify();
    }

    public void addField(CtField paramCtField, CtField.Initializer paramInitializer) {
        checkModify();
    }

    public void addInterface(CtClass paramCtClass) {
        checkModify();
    }

    public void addMethod(CtMethod paramCtMethod) {
        checkModify();
    }

    void checkModify() {
        if (isFrozen()) {
            throw new RuntimeException(getName() + " class is frozen");
        }
    }

    void compress() {
    }

    public void debugWriteFile() {
        debugWriteFile(".");
    }

    public void debugWriteFile(String paramString) {
        try {
            boolean bool = stopPruning(true);
            writeFile(paramString);
            defrost();
            stopPruning(bool);
            return;
        } catch (Exception paramString) {
            throw new RuntimeException(paramString);
        }
    }

    public void defrost() {
        throw new RuntimeException("cannot defrost " + getName());
    }

    public void detach() {
        ClassPool localClassPool = getClassPool();
        CtClass localCtClass = localClassPool.removeCached(getName());
        if (localCtClass != this) {
            localClassPool.cacheCtClass(getName(), localCtClass, false);
        }
    }

    protected void extendToString(StringBuffer paramStringBuffer) {
        paramStringBuffer.append(getName());
    }

    public void freeze() {
    }

    public AccessorMaker getAccessorMaker() {
        return null;
    }

    public Object getAnnotation(Class paramClass) {
        return null;
    }

    public Object[] getAnnotations() {
        return new Object[0];
    }

    public byte[] getAttribute(String paramString) {
        return null;
    }

    public Object[] getAvailableAnnotations() {
        return new Object[0];
    }

    public ClassFile getClassFile() {
        checkModify();
        return getClassFile2();
    }

    public ClassFile getClassFile2() {
        return null;
    }

    public CtConstructor getClassInitializer() {
        return null;
    }

    public ClassPool getClassPool() {
        return null;
    }

    public CtClass getComponentType() {
        return null;
    }

    public CtConstructor getConstructor(String paramString) {
        throw new NotFoundException("no such constructor");
    }

    public CtConstructor[] getConstructors() {
        return new CtConstructor[0];
    }

    public CtBehavior[] getDeclaredBehaviors() {
        return new CtBehavior[0];
    }

    public CtClass[] getDeclaredClasses() {
        return getNestedClasses();
    }

    public CtConstructor getDeclaredConstructor(CtClass[] paramArrayOfCtClass) {
        return getConstructor(Descriptor.ofConstructor(paramArrayOfCtClass));
    }

    public CtConstructor[] getDeclaredConstructors() {
        return new CtConstructor[0];
    }

    public CtField getDeclaredField(String paramString) {
        throw new NotFoundException(paramString);
    }

    public CtField getDeclaredField(String paramString1, String paramString2) {
        throw new NotFoundException(paramString1);
    }

    public CtField[] getDeclaredFields() {
        return new CtField[0];
    }

    public CtMethod getDeclaredMethod(String paramString) {
        throw new NotFoundException(paramString);
    }

    public CtMethod getDeclaredMethod(String paramString, CtClass[] paramArrayOfCtClass) {
        throw new NotFoundException(paramString);
    }

    public CtMethod[] getDeclaredMethods() {
        return new CtMethod[0];
    }

    public CtClass getDeclaringClass() {
        return null;
    }

    public CtMethod getEnclosingMethod() {
        return null;
    }

    public CtField getField(String paramString) {
        return getField(paramString, null);
    }

    public CtField getField(String paramString1, String paramString2) {
        throw new NotFoundException(paramString1);
    }

    CtField getField2(String paramString1, String paramString2) {
        return null;
    }

    public CtField[] getFields() {
        return new CtField[0];
    }

    public CtClass[] getInterfaces() {
        return new CtClass[0];
    }

    public CtMethod getMethod(String paramString1, String paramString2) {
        throw new NotFoundException(paramString1);
    }

    public CtMethod[] getMethods() {
        return new CtMethod[0];
    }

    public int getModifiers() {
        return 0;
    }

    public String getName() {
        return this.qualifiedName;
    }

    public CtClass[] getNestedClasses() {
        return new CtClass[0];
    }

    public final String getPackageName() {
        String str = this.qualifiedName;
        int i = str.lastIndexOf('.');
        if (i < 0) {
            return null;
        }
        return str.substring(0, i);
    }

    /* Error */
    public java.util.Collection getRefClasses() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: invokevirtual 246	javassist/CtClass:getClassFile2	()Ljavassist/bytecode/ClassFile;
        //   6: astore_1
        //   7: aload_1
        //   8: ifnull +26 -> 34
        //   11: new 323	javassist/CtClass$1
        //   14: dup
        //   15: aload_0
        //   16: invokespecial 325	javassist/CtClass$1:<init>	(Ljavassist/CtClass;)V
        //   19: astore_2
        //   20: aload_1
        //   21: aload_2
        //   22: invokevirtual 330	javassist/bytecode/ClassFile:getRefClasses	(Ljava/util/Map;)V
        //   25: aload_2
        //   26: invokevirtual 335	javassist/ClassMap:values	()Ljava/util/Collection;
        //   29: astore_1
        //   30: aload_0
        //   31: monitorexit
        //   32: aload_1
        //   33: areturn
        //   34: aconst_null
        //   35: astore_1
        //   36: goto -6 -> 30
        //   39: astore_1
        //   40: aload_0
        //   41: monitorexit
        //   42: aload_1
        //   43: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	44	0	this	CtClass
        //   6	30	1	localObject1	Object
        //   39	4	1	localObject2	Object
        //   19	7	2	local1	CtClass.1
        // Exception table:
        //   from	to	target	type
        //   2	7	39	finally
        //   11	30	39	finally
    }

    public final String getSimpleName() {
        String str = this.qualifiedName;
        int i = str.lastIndexOf('.');
        if (i < 0) {
            return str;
        }
        return str.substring(i + 1);
    }

    public CtClass getSuperclass() {
        return null;
    }

    public URL getURL() {
        throw new NotFoundException(getName());
    }

    public boolean hasAnnotation(Class paramClass) {
        return false;
    }

    void incGetCounter() {
    }

    public void instrument(CodeConverter paramCodeConverter) {
        checkModify();
    }

    public void instrument(ExprEditor paramExprEditor) {
        checkModify();
    }

    public boolean isAnnotation() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isEnum() {
        return false;
    }

    public boolean isFrozen() {
        return true;
    }

    public boolean isInterface() {
        return false;
    }

    public boolean isModified() {
        return false;
    }

    public boolean isPrimitive() {
        return false;
    }

    public CtConstructor makeClassInitializer() {
        throw new CannotCompileException("not a class");
    }

    protected DataOutputStream makeFileOutput(String paramString) {
        String str = getName();
        paramString = paramString + File.separatorChar + str.replace('.', File.separatorChar) + ".class";
        int i = paramString.lastIndexOf(File.separatorChar);
        if (i > 0) {
            str = paramString.substring(0, i);
            if (!str.equals(".")) {
                new File(str).mkdirs();
            }
        }
        return new DataOutputStream(new BufferedOutputStream(new CtClass.DelayedFileOutputStream(paramString)));
    }

    public CtClass makeNestedClass(String paramString, boolean paramBoolean) {
        throw new RuntimeException(getName() + " is not a class");
    }

    public String makeUniqueName(String paramString) {
        throw new RuntimeException("not available in " + getName());
    }

    public void prune() {
    }

    public void rebuildClassFile() {
    }

    public void removeConstructor(CtConstructor paramCtConstructor) {
        checkModify();
    }

    public void removeField(CtField paramCtField) {
        checkModify();
    }

    public void removeMethod(CtMethod paramCtMethod) {
        checkModify();
    }

    public void replaceClassName(String paramString1, String paramString2) {
        checkModify();
    }

    public void replaceClassName(ClassMap paramClassMap) {
        checkModify();
    }

    public void setAttribute(String paramString, byte[] paramArrayOfByte) {
        checkModify();
    }

    public void setInterfaces(CtClass[] paramArrayOfCtClass) {
        checkModify();
    }

    public void setModifiers(int paramInt) {
        checkModify();
    }

    public void setName(String paramString) {
        checkModify();
        if (paramString != null) {
            this.qualifiedName = paramString;
        }
    }

    public void setSuperclass(CtClass paramCtClass) {
        checkModify();
    }

    public boolean stopPruning(boolean paramBoolean) {
        return true;
    }

    public boolean subclassOf(CtClass paramCtClass) {
        return false;
    }

    public boolean subtypeOf(CtClass paramCtClass) {
        return (this == paramCtClass) || (getName().equals(paramCtClass.getName()));
    }

    public void toBytecode(DataOutputStream paramDataOutputStream) {
        throw new CannotCompileException("not a class");
    }

    public byte[] toBytecode() {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        try {
            toBytecode(localDataOutputStream);
            return localByteArrayOutputStream.toByteArray();
        } finally {
            localDataOutputStream.close();
        }
    }

    public Class toClass() {
        return getClassPool().toClass(this);
    }

    public final Class toClass(ClassLoader paramClassLoader) {
        return getClassPool().toClass(this, paramClassLoader);
    }

    public Class toClass(ClassLoader paramClassLoader, ProtectionDomain paramProtectionDomain) {
        ClassPool localClassPool = getClassPool();
        ClassLoader localClassLoader = paramClassLoader;
        if (paramClassLoader == null) {
            localClassLoader = localClassPool.getClassLoader();
        }
        return localClassPool.toClass(this, localClassLoader, paramProtectionDomain);
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer(getClass().getName());
        localStringBuffer.append("@");
        localStringBuffer.append(Integer.toHexString(hashCode()));
        localStringBuffer.append("[");
        extendToString(localStringBuffer);
        localStringBuffer.append("]");
        return localStringBuffer.toString();
    }

    public void writeFile() {
        writeFile(".");
    }

    public void writeFile(String paramString) {
        paramString = makeFileOutput(paramString);
        try {
            toBytecode(paramString);
            return;
        } finally {
            paramString.close();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */