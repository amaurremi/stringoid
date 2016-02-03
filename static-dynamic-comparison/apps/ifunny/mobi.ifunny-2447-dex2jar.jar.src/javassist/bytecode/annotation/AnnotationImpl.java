package javassist.bytecode.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationDefaultAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.MethodInfo;

public class AnnotationImpl
        implements InvocationHandler {
    private static final String JDK_ANNOTATION_CLASS_NAME = "java.lang.annotation.Annotation";
    private static Method JDK_ANNOTATION_TYPE_METHOD = null;
    private Annotation annotation;
    private transient Class annotationType;
    private transient int cachedHashCode = Integer.MIN_VALUE;
    private ClassLoader classLoader;
    private ClassPool pool;

    static {
        try {
            JDK_ANNOTATION_TYPE_METHOD = Class.forName("java.lang.annotation.Annotation").getMethod("annotationType", (Class[]) null);
            return;
        } catch (Exception localException) {
        }
    }

    private AnnotationImpl(Annotation paramAnnotation, ClassPool paramClassPool, ClassLoader paramClassLoader) {
        this.annotation = paramAnnotation;
        this.pool = paramClassPool;
        this.classLoader = paramClassLoader;
    }

    private static int arrayHashCode(Object paramObject) {
        if (paramObject == null) {
            return 0;
        }
        paramObject = (Object[]) paramObject;
        int j = 1;
        int i = 0;
        if (i < paramObject.length) {
            if (paramObject[i] == null) {
                break label53;
            }
        }
        label53:
        for (int k = paramObject[i].hashCode(); ; k = 0) {
            j = j * 31 + k;
            i += 1;
            break;
            return j;
        }
    }

    private boolean checkEquals(Object paramObject) {
        if (paramObject == null) {
        }
        Object localObject1;
        do {
            return false;
            if ((paramObject instanceof Proxy)) {
                localObject1 = Proxy.getInvocationHandler(paramObject);
                if ((localObject1 instanceof AnnotationImpl)) {
                    paramObject = (AnnotationImpl) localObject1;
                    return this.annotation.equals(((AnnotationImpl) paramObject).annotation);
                }
            }
            localObject1 = (Class) JDK_ANNOTATION_TYPE_METHOD.invoke(paramObject, (Object[]) null);
        } while (!getAnnotationType().equals(localObject1));
        Method[] arrayOfMethod = this.annotationType.getDeclaredMethods();
        int i = 0;
        String str;
        if (i < arrayOfMethod.length) {
            str = arrayOfMethod[i].getName();
            localObject1 = this.annotation.getMemberValue(str);
            if (localObject1 == null) {
                break label237;
            }
        }
        for (; ; ) {
            try {
                localObject1 = ((MemberValue) localObject1).getValue(this.classLoader, this.pool, arrayOfMethod[i]);
                if (localObject1 != null) {
                    break label234;
                }
                localObject1 = getDefault(str, arrayOfMethod[i]);
                Object localObject2 = arrayOfMethod[i].invoke(paramObject, (Object[]) null);
                if (((localObject1 == null) && (localObject2 != null)) || ((localObject1 != null) && (!localObject1.equals(localObject2)))) {
                    break;
                }
                i += 1;
            } catch (RuntimeException paramObject) {
                throw ((Throwable) paramObject);
            } catch (Exception paramObject) {
                throw new RuntimeException("Error retrieving value " + str + " for annotation " + this.annotation.getTypeName(), (Throwable) paramObject);
            }
            return true;
            label234:
            continue;
            label237:
            localObject1 = null;
        }
    }

    private Class getAnnotationType() {
        Object localObject;
        if (this.annotationType == null) {
            localObject = this.annotation.getTypeName();
        }
        try {
            this.annotationType = this.classLoader.loadClass((String) localObject);
            return this.annotationType;
        } catch (ClassNotFoundException localClassNotFoundException) {
            localObject = new NoClassDefFoundError("Error loading annotation class: " + (String) localObject);
            ((NoClassDefFoundError) localObject).setStackTrace(localClassNotFoundException.getStackTrace());
            throw ((Throwable) localObject);
        }
    }

    private Object getDefault(String paramString, Method paramMethod) {
        String str = this.annotation.getTypeName();
        if (this.pool != null) {
            try {
                Object localObject = this.pool.get(str).getClassFile2().getMethod(paramString);
                if (localObject != null) {
                    localObject = (AnnotationDefaultAttribute) ((MethodInfo) localObject).getAttribute("AnnotationDefault");
                    if (localObject != null) {
                        paramString = ((AnnotationDefaultAttribute) localObject).getDefaultValue().getValue(this.classLoader, this.pool, paramMethod);
                        return paramString;
                    }
                }
            } catch (NotFoundException paramString) {
                throw new RuntimeException("cannot find a class file: " + str);
            }
        }
        throw new RuntimeException("no default value: " + str + "." + paramString + "()");
    }

    public static Object make(ClassLoader paramClassLoader, Class paramClass, ClassPool paramClassPool, Annotation paramAnnotation) {
        paramClassPool = new AnnotationImpl(paramAnnotation, paramClassPool, paramClassLoader);
        return Proxy.newProxyInstance(paramClassLoader, new Class[]{paramClass}, paramClassPool);
    }

    public Annotation getAnnotation() {
        return this.annotation;
    }

    public String getTypeName() {
        return this.annotation.getTypeName();
    }

    public int hashCode() {
        Method[] arrayOfMethod;
        int j;
        int k;
        String str;
        Object localObject2;
        Object localObject1;
        if (this.cachedHashCode == Integer.MIN_VALUE) {
            getAnnotationType();
            arrayOfMethod = this.annotationType.getDeclaredMethods();
            j = 0;
            k = 0;
            if (j < arrayOfMethod.length) {
                str = arrayOfMethod[j].getName();
                localObject2 = this.annotation.getMemberValue(str);
                localObject1 = null;
                if (localObject2 == null) {
                }
            }
        }
        for (; ; ) {
            try {
                localObject1 = ((MemberValue) localObject2).getValue(this.classLoader, this.pool, arrayOfMethod[j]);
                localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = getDefault(str, arrayOfMethod[j]);
                }
                if (localObject2 == null) {
                    break label215;
                }
                if (localObject2.getClass().isArray()) {
                    i = arrayHashCode(localObject2);
                    k += (i ^ str.hashCode() * 127);
                    j += 1;
                }
            } catch (RuntimeException localRuntimeException) {
                throw localRuntimeException;
            } catch (Exception localException) {
                throw new RuntimeException("Error retrieving value " + str + " for annotation " + this.annotation.getTypeName(), localException);
            }
            int i = localObject2.hashCode();
            continue;
            this.cachedHashCode = k;
            return this.cachedHashCode;
            label215:
            i = 0;
        }
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
        paramObject = paramMethod.getName();
        if (Object.class == paramMethod.getDeclaringClass()) {
            if ("equals".equals(paramObject)) {
                return new Boolean(checkEquals(paramArrayOfObject[0]));
            }
            if ("toString".equals(paramObject)) {
                return this.annotation.toString();
            }
            if ("hashCode".equals(paramObject)) {
                return new Integer(hashCode());
            }
        } else if (("annotationType".equals(paramObject)) && (paramMethod.getParameterTypes().length == 0)) {
            return getAnnotationType();
        }
        paramArrayOfObject = this.annotation.getMemberValue((String) paramObject);
        if (paramArrayOfObject == null) {
            return getDefault((String) paramObject, paramMethod);
        }
        return paramArrayOfObject.getValue(this.classLoader, this.pool, paramMethod);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/AnnotationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */