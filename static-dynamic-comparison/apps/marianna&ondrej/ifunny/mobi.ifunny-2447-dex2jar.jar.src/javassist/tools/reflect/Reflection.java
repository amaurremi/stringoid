package javassist.tools.reflect;

import java.util.Iterator;
import java.util.List;

import javassist.ClassPool;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtField.Initializer;
import javassist.CtMethod;
import javassist.CtMethod.ConstParameter;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.Translator;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.MethodInfo;

public class Reflection
        implements Translator {
    static final String classMetaobjectClassName = "javassist.tools.reflect.ClassMetaobject";
    static final String classobjectAccessor = "_getClass";
    static final String classobjectField = "_classobject";
    static final String metaobjectClassName = "javassist.tools.reflect.Metaobject";
    static final String metaobjectField = "_metaobject";
    static final String metaobjectGetter = "_getMetaobject";
    static final String metaobjectSetter = "_setMetaobject";
    static final String readPrefix = "_r_";
    static final String writePrefix = "_w_";
    protected ClassPool classPool = null;
    protected CodeConverter converter = new CodeConverter();
    protected CtClass[] readParam;
    protected CtMethod trapMethod;
    protected CtMethod trapRead;
    protected CtMethod trapStaticMethod;
    protected CtMethod trapWrite;

    private CtMethod findOriginal(CtMethod paramCtMethod, boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (; ; ) {
            return paramCtMethod;
            String str1 = paramCtMethod.getName();
            CtMethod[] arrayOfCtMethod = paramCtMethod.getDeclaringClass().getDeclaredMethods();
            int i = 0;
            while (i < arrayOfCtMethod.length) {
                String str2 = arrayOfCtMethod[i].getName();
                if ((str2.endsWith(str1)) && (str2.startsWith("_m_")) && (arrayOfCtMethod[i].getSignature().equals(paramCtMethod.getSignature()))) {
                    return arrayOfCtMethod[i];
                }
                i += 1;
            }
        }
    }

    private boolean isExcluded(String paramString) {
        return (paramString.startsWith("_m_")) || (paramString.equals("_getClass")) || (paramString.equals("_setMetaobject")) || (paramString.equals("_getMetaobject")) || (paramString.startsWith("_r_")) || (paramString.startsWith("_w_"));
    }

    private boolean modifyClassfile(CtClass paramCtClass1, CtClass paramCtClass2, CtClass paramCtClass3) {
        if (paramCtClass1.getAttribute("Reflective") != null) {
            return false;
        }
        paramCtClass1.setAttribute("Reflective", new byte[0]);
        Object localObject = this.classPool.get("javassist.tools.reflect.Metalevel");
        if (!paramCtClass1.subtypeOf((CtClass) localObject)) {
        }
        for (boolean bool = true; ; bool = false) {
            if (bool) {
                paramCtClass1.addInterface((CtClass) localObject);
            }
            processMethods(paramCtClass1, bool);
            processFields(paramCtClass1);
            if (bool) {
                localObject = new CtField(this.classPool.get("javassist.tools.reflect.Metaobject"), "_metaobject", paramCtClass1);
                ((CtField) localObject).setModifiers(4);
                paramCtClass1.addField((CtField) localObject, CtField.Initializer.byNewWithParams(paramCtClass2));
                paramCtClass1.addMethod(CtNewMethod.getter("_getMetaobject", (CtField) localObject));
                paramCtClass1.addMethod(CtNewMethod.setter("_setMetaobject", (CtField) localObject));
            }
            paramCtClass2 = new CtField(this.classPool.get("javassist.tools.reflect.ClassMetaobject"), "_classobject", paramCtClass1);
            paramCtClass2.setModifiers(10);
            paramCtClass1.addField(paramCtClass2, CtField.Initializer.byNew(paramCtClass3, new String[]{paramCtClass1.getName()}));
            paramCtClass1.addMethod(CtNewMethod.getter("_getClass", paramCtClass2));
            return true;
        }
    }

    private void processFields(CtClass paramCtClass) {
        CtField[] arrayOfCtField = paramCtClass.getDeclaredFields();
        int i = 0;
        while (i < arrayOfCtField.length) {
            Object localObject2 = arrayOfCtField[i];
            int j = ((CtField) localObject2).getModifiers();
            if (((j & 0x1) != 0) && ((j & 0x10) == 0)) {
                j |= 0x8;
                Object localObject1 = ((CtField) localObject2).getName();
                localObject2 = ((CtField) localObject2).getType();
                Object localObject3 = CtNewMethod.wrapped((CtClass) localObject2, "_r_" + (String) localObject1, this.readParam, null, this.trapRead, CtMethod.ConstParameter.string((String) localObject1), paramCtClass);
                ((CtMethod) localObject3).setModifiers(j);
                paramCtClass.addMethod((CtMethod) localObject3);
                localObject3 = this.classPool.get("java.lang.Object");
                CtClass localCtClass = CtClass.voidType;
                String str = "_w_" + (String) localObject1;
                CtMethod localCtMethod = this.trapWrite;
                localObject1 = CtMethod.ConstParameter.string((String) localObject1);
                localObject1 = CtNewMethod.wrapped(localCtClass, str, new CtClass[]{localObject3, localObject2}, null, localCtMethod, (CtMethod.ConstParameter) localObject1, paramCtClass);
                ((CtMethod) localObject1).setModifiers(j);
                paramCtClass.addMethod((CtMethod) localObject1);
            }
            i += 1;
        }
    }

    private void processMethods(CtClass paramCtClass, boolean paramBoolean) {
        CtMethod[] arrayOfCtMethod = paramCtClass.getMethods();
        int i = 0;
        while (i < arrayOfCtMethod.length) {
            CtMethod localCtMethod = arrayOfCtMethod[i];
            int j = localCtMethod.getModifiers();
            if ((Modifier.isPublic(j)) && (!Modifier.isAbstract(j))) {
                processMethods0(j, paramCtClass, localCtMethod, i, paramBoolean);
            }
            i += 1;
        }
    }

    private void processMethods0(int paramInt1, CtClass paramCtClass, CtMethod paramCtMethod, int paramInt2, boolean paramBoolean) {
        String str = paramCtMethod.getName();
        if (isExcluded(str)) {
        }
        do {
            return;
            if (paramCtMethod.getDeclaringClass() != paramCtClass) {
                break;
            }
        } while (Modifier.isNative(paramInt1));
        CtMethod localCtMethod;
        if (Modifier.isFinal(paramInt1)) {
            paramInt1 &= 0xFFFFFFEF;
            paramCtMethod.setModifiers(paramInt1);
            localCtMethod = paramCtMethod;
        }
        for (; ; ) {
            label51:
            localCtMethod.setName("_m_" + paramInt2 + "_" + str);
            if (Modifier.isStatic(paramInt1)) {
            }
            for (localCtMethod = this.trapStaticMethod; ; localCtMethod = this.trapMethod) {
                paramCtMethod = CtNewMethod.wrapped(paramCtMethod.getReturnType(), str, paramCtMethod.getParameterTypes(), paramCtMethod.getExceptionTypes(), localCtMethod, CtMethod.ConstParameter.integer(paramInt2), paramCtClass);
                paramCtMethod.setModifiers(paramInt1);
                paramCtClass.addMethod(paramCtMethod);
                return;
                if (Modifier.isFinal(paramInt1)) {
                    break;
                }
                paramInt1 &= 0xFEFF;
                localCtMethod = CtNewMethod.delegator(findOriginal(paramCtMethod, paramBoolean), paramCtClass);
                localCtMethod.setModifiers(paramInt1);
                paramCtClass.addMethod(localCtMethod);
                break label51;
            }
            localCtMethod = paramCtMethod;
        }
    }

    private void registerReflectiveClass(CtClass paramCtClass) {
        CtField[] arrayOfCtField = paramCtClass.getDeclaredFields();
        int i = 0;
        while (i < arrayOfCtField.length) {
            CtField localCtField = arrayOfCtField[i];
            int j = localCtField.getModifiers();
            if (((j & 0x1) != 0) && ((j & 0x10) == 0)) {
                String str = localCtField.getName();
                this.converter.replaceFieldRead(localCtField, paramCtClass, "_r_" + str);
                this.converter.replaceFieldWrite(localCtField, paramCtClass, "_w_" + str);
            }
            i += 1;
        }
    }

    public boolean makeReflective(Class paramClass1, Class paramClass2, Class paramClass3) {
        return makeReflective(paramClass1.getName(), paramClass2.getName(), paramClass3.getName());
    }

    public boolean makeReflective(String paramString1, String paramString2, String paramString3) {
        return makeReflective(this.classPool.get(paramString1), this.classPool.get(paramString2), this.classPool.get(paramString3));
    }

    public boolean makeReflective(CtClass paramCtClass1, CtClass paramCtClass2, CtClass paramCtClass3) {
        if (paramCtClass1.isInterface()) {
            throw new CannotReflectException("Cannot reflect an interface: " + paramCtClass1.getName());
        }
        if (paramCtClass1.subclassOf(this.classPool.get("javassist.tools.reflect.ClassMetaobject"))) {
            throw new CannotReflectException("Cannot reflect a subclass of ClassMetaobject: " + paramCtClass1.getName());
        }
        if (paramCtClass1.subclassOf(this.classPool.get("javassist.tools.reflect.Metaobject"))) {
            throw new CannotReflectException("Cannot reflect a subclass of Metaobject: " + paramCtClass1.getName());
        }
        registerReflectiveClass(paramCtClass1);
        return modifyClassfile(paramCtClass1, paramCtClass2, paramCtClass3);
    }

    public void onLoad(ClassPool paramClassPool, String paramString) {
        paramClassPool.get(paramString).instrument(this.converter);
    }

    public void rebuildClassFile(ClassFile paramClassFile) {
        if (ClassFile.MAJOR_VERSION < 50) {
        }
        for (; ; ) {
            return;
            paramClassFile = paramClassFile.getMethods().iterator();
            while (paramClassFile.hasNext()) {
                ((MethodInfo) paramClassFile.next()).rebuildStackMap(this.classPool);
            }
        }
    }

    public void start(ClassPool paramClassPool) {
        this.classPool = paramClassPool;
        try {
            paramClassPool = this.classPool.get("javassist.tools.reflect.Sample");
            rebuildClassFile(paramClassPool.getClassFile());
            this.trapMethod = paramClassPool.getDeclaredMethod("trap");
            this.trapStaticMethod = paramClassPool.getDeclaredMethod("trapStatic");
            this.trapRead = paramClassPool.getDeclaredMethod("trapRead");
            this.trapWrite = paramClassPool.getDeclaredMethod("trapWrite");
            this.readParam = new CtClass[]{this.classPool.get("java.lang.Object")};
            return;
        } catch (NotFoundException paramClassPool) {
            throw new RuntimeException("javassist.tools.reflect.Sample is not found or broken.");
        } catch (BadBytecode paramClassPool) {
            throw new RuntimeException("javassist.tools.reflect.Sample is not found or broken.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/Reflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */