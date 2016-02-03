package javassist.tools.rmi;

import java.lang.reflect.Method;
import java.util.Hashtable;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtField.Initializer;
import javassist.CtMethod;
import javassist.CtMethod.ConstParameter;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.Translator;

public class StubGenerator
        implements Translator {
    private static final String accessorObjectId = "_getObjectId";
    private static final String fieldImporter = "importer";
    private static final String fieldObjectId = "objectId";
    private static final String sampleClass = "javassist.tools.rmi.Sample";
    private ClassPool classPool;
    private CtClass[] exceptionForProxy;
    private CtMethod forwardMethod;
    private CtMethod forwardStaticMethod;
    private CtClass[] interfacesForProxy;
    private Hashtable proxyClasses = new Hashtable();
    private CtClass[] proxyConstructorParamTypes;

    private void addMethods(CtClass paramCtClass, Method[] paramArrayOfMethod) {
        int i = 0;
        if (i < paramArrayOfMethod.length) {
            Method localMethod = paramArrayOfMethod[i];
            int j = localMethod.getModifiers();
            if ((localMethod.getDeclaringClass() != Object.class) && (!Modifier.isFinal(j))) {
                if (!Modifier.isPublic(j)) {
                    break label128;
                }
                if (!Modifier.isStatic(j)) {
                    break label119;
                }
                localCtMethod = this.forwardStaticMethod;
                localCtMethod = CtNewMethod.wrapped(toCtClass(localMethod.getReturnType()), localMethod.getName(), toCtClass(localMethod.getParameterTypes()), this.exceptionForProxy, localCtMethod, CtMethod.ConstParameter.integer(i), paramCtClass);
                localCtMethod.setModifiers(j);
                paramCtClass.addMethod(localCtMethod);
            }
            label119:
            label128:
            while ((Modifier.isProtected(j)) || (Modifier.isPrivate(j))) {
                for (; ; ) {
                    i += 1;
                    break;
                    CtMethod localCtMethod = this.forwardMethod;
                }
            }
            throw new CannotCompileException("the methods must be public, protected, or private.");
        }
    }

    private void modifySuperclass(CtClass paramCtClass) {
        for (; ; ) {
            paramCtClass = paramCtClass.getSuperclass();
            if (paramCtClass == null) {
                return;
            }
            try {
                paramCtClass.getDeclaredConstructor(null);
                return;
            } catch (NotFoundException localNotFoundException) {
                paramCtClass.addConstructor(CtNewConstructor.defaultConstructor(paramCtClass));
            }
        }
    }

    private CtClass produceProxyClass(CtClass paramCtClass, Class paramClass) {
        int i = paramCtClass.getModifiers();
        if ((Modifier.isAbstract(i)) || (Modifier.isNative(i)) || (!Modifier.isPublic(i))) {
            throw new CannotCompileException(paramCtClass.getName() + " must be public, non-native, and non-abstract.");
        }
        paramCtClass = this.classPool.makeClass(paramCtClass.getName(), paramCtClass.getSuperclass());
        paramCtClass.setInterfaces(this.interfacesForProxy);
        CtField localCtField = new CtField(this.classPool.get("javassist.tools.rmi.ObjectImporter"), "importer", paramCtClass);
        localCtField.setModifiers(2);
        paramCtClass.addField(localCtField, CtField.Initializer.byParameter(0));
        localCtField = new CtField(CtClass.intType, "objectId", paramCtClass);
        localCtField.setModifiers(2);
        paramCtClass.addField(localCtField, CtField.Initializer.byParameter(1));
        paramCtClass.addMethod(CtNewMethod.getter("_getObjectId", localCtField));
        paramCtClass.addConstructor(CtNewConstructor.defaultConstructor(paramCtClass));
        paramCtClass.addConstructor(CtNewConstructor.skeleton(this.proxyConstructorParamTypes, null, paramCtClass));
        try {
            addMethods(paramCtClass, paramClass.getMethods());
            return paramCtClass;
        } catch (SecurityException paramCtClass) {
            throw new CannotCompileException(paramCtClass);
        }
    }

    private CtClass toCtClass(Class paramClass) {
        if (!paramClass.isArray()) {
        }
        StringBuffer localStringBuffer;
        for (paramClass = paramClass.getName(); ; paramClass = localStringBuffer.toString()) {
            return this.classPool.get(paramClass);
            localStringBuffer = new StringBuffer();
            Class localClass;
            do {
                localStringBuffer.append("[]");
                localClass = paramClass.getComponentType();
                paramClass = localClass;
            } while (localClass.isArray());
            localStringBuffer.insert(0, localClass.getName());
        }
    }

    private CtClass[] toCtClass(Class[] paramArrayOfClass) {
        int j = paramArrayOfClass.length;
        CtClass[] arrayOfCtClass = new CtClass[j];
        int i = 0;
        while (i < j) {
            arrayOfCtClass[i] = toCtClass(paramArrayOfClass[i]);
            i += 1;
        }
        return arrayOfCtClass;
    }

    public boolean isProxyClass(String paramString) {
        return this.proxyClasses.get(paramString) != null;
    }

    /* Error */
    public boolean makeProxyClass(Class paramClass) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: invokevirtual 237	java/lang/Class:getName	()Ljava/lang/String;
        //   6: astore_3
        //   7: aload_0
        //   8: getfield 39	javassist/tools/rmi/StubGenerator:proxyClasses	Ljava/util/Hashtable;
        //   11: aload_3
        //   12: invokevirtual 258	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   15: astore 4
        //   17: aload 4
        //   19: ifnull +9 -> 28
        //   22: iconst_0
        //   23: istore_2
        //   24: aload_0
        //   25: monitorexit
        //   26: iload_2
        //   27: ireturn
        //   28: aload_0
        //   29: aload_0
        //   30: getfield 173	javassist/tools/rmi/StubGenerator:classPool	Ljavassist/ClassPool;
        //   33: aload_3
        //   34: invokevirtual 193	javassist/ClassPool:get	(Ljava/lang/String;)Ljavassist/CtClass;
        //   37: aload_1
        //   38: invokespecial 262	javassist/tools/rmi/StubGenerator:produceProxyClass	(Ljavassist/CtClass;Ljava/lang/Class;)Ljavassist/CtClass;
        //   41: astore_1
        //   42: aload_0
        //   43: getfield 39	javassist/tools/rmi/StubGenerator:proxyClasses	Ljava/util/Hashtable;
        //   46: aload_3
        //   47: aload_1
        //   48: invokevirtual 266	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   51: pop
        //   52: aload_0
        //   53: aload_1
        //   54: invokespecial 268	javassist/tools/rmi/StubGenerator:modifySuperclass	(Ljavassist/CtClass;)V
        //   57: iconst_1
        //   58: istore_2
        //   59: goto -35 -> 24
        //   62: astore_1
        //   63: aload_0
        //   64: monitorexit
        //   65: aload_1
        //   66: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	67	0	this	StubGenerator
        //   0	67	1	paramClass	Class
        //   23	36	2	bool	boolean
        //   6	41	3	str	String
        //   15	3	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	17	62	finally
        //   28	57	62	finally
    }

    public void onLoad(ClassPool paramClassPool, String paramString) {
    }

    public void start(ClassPool paramClassPool) {
        this.classPool = paramClassPool;
        CtClass localCtClass = paramClassPool.get("javassist.tools.rmi.Sample");
        this.forwardMethod = localCtClass.getDeclaredMethod("forward");
        this.forwardStaticMethod = localCtClass.getDeclaredMethod("forwardStatic");
        this.proxyConstructorParamTypes = paramClassPool.get(new String[]{"javassist.tools.rmi.ObjectImporter", "int"});
        this.interfacesForProxy = paramClassPool.get(new String[]{"java.io.Serializable", "javassist.tools.rmi.Proxy"});
        this.exceptionForProxy = new CtClass[]{paramClassPool.get("javassist.tools.rmi.RemoteException")};
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/rmi/StubGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */