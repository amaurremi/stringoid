package javassist.tools.reflect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassMetaobject
        implements Serializable {
    static final String methodPrefix = "_m_";
    static final int methodPrefixLen = 3;
    public static boolean useContextClassLoader = false;
    private Constructor[] constructors;
    private Class javaClass;
    private Method[] methods;

    public ClassMetaobject(String[] paramArrayOfString) {
        try {
            this.javaClass = getClassObject(paramArrayOfString[0]);
            this.constructors = this.javaClass.getConstructors();
            this.methods = null;
            return;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new RuntimeException("not found: " + paramArrayOfString[0] + ", useContextClassLoader: " + Boolean.toString(useContextClassLoader), localClassNotFoundException);
        }
    }

    private Class getClassObject(String paramString) {
        if (useContextClassLoader) {
            return Thread.currentThread().getContextClassLoader().loadClass(paramString);
        }
        return Class.forName(paramString);
    }

    public static Object invoke(Object paramObject, int paramInt, Object[] paramArrayOfObject) {
        Method[] arrayOfMethod = paramObject.getClass().getMethods();
        int i = arrayOfMethod.length;
        String str = "_m_" + paramInt;
        paramInt = 0;
        while (paramInt < i) {
            if (arrayOfMethod[paramInt].getName().startsWith(str)) {
                try {
                    paramObject = arrayOfMethod[paramInt].invoke(paramObject, paramArrayOfObject);
                    return paramObject;
                } catch (InvocationTargetException paramObject) {
                    throw ((InvocationTargetException) paramObject).getTargetException();
                } catch (IllegalAccessException paramObject) {
                    throw new CannotInvokeException((IllegalAccessException) paramObject);
                }
            }
            paramInt += 1;
        }
        throw new CannotInvokeException("cannot find a method");
    }

    private void readObject(ObjectInputStream paramObjectInputStream) {
        this.javaClass = getClassObject(paramObjectInputStream.readUTF());
        this.constructors = this.javaClass.getConstructors();
        this.methods = null;
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream) {
        paramObjectOutputStream.writeUTF(this.javaClass.getName());
    }

    public final Class getJavaClass() {
        return this.javaClass;
    }

    public final Method getMethod(int paramInt) {
        return getReflectiveMethods()[paramInt];
    }

    public final int getMethodIndex(String paramString, Class[] paramArrayOfClass) {
        Method[] arrayOfMethod = getReflectiveMethods();
        int i = 0;
        if (i < arrayOfMethod.length) {
            if (arrayOfMethod[i] == null) {
            }
            while ((!getMethodName(i).equals(paramString)) || (!Arrays.equals(paramArrayOfClass, arrayOfMethod[i].getParameterTypes()))) {
                i += 1;
                break;
            }
            return i;
        }
        throw new NoSuchMethodException("Method " + paramString + " not found");
    }

    public final String getMethodName(int paramInt) {
        String str = getReflectiveMethods()[paramInt].getName();
        int i;
        for (paramInt = 3; ; paramInt = i) {
            i = paramInt + 1;
            paramInt = str.charAt(paramInt);
            if ((paramInt < 48) || (57 < paramInt)) {
                return str.substring(i);
            }
        }
    }

    public final String getName() {
        return this.javaClass.getName();
    }

    public final Class[] getParameterTypes(int paramInt) {
        return getReflectiveMethods()[paramInt].getParameterTypes();
    }

    public final Method[] getReflectiveMethods() {
        int n = 0;
        if (this.methods != null) {
            return this.methods;
        }
        Method[] arrayOfMethod = getJavaClass().getDeclaredMethods();
        int i1 = arrayOfMethod.length;
        int[] arrayOfInt = new int[i1];
        int j = 0;
        int i = 0;
        if (j < i1) {
            String str = arrayOfMethod[j].getName();
            if (!str.startsWith("_m_")) {
                break label186;
            }
            int k = 3;
            int m = 0;
            for (; ; ) {
                int i2 = str.charAt(k);
                if ((48 > i2) || (i2 > 57)) {
                    break;
                }
                m = m * 10 + i2 - 48;
                k += 1;
            }
            k = m + 1;
            arrayOfInt[j] = k;
            if (k <= i) {
                break label186;
            }
            i = k;
        }
        label186:
        for (; ; ) {
            j += 1;
            break;
            this.methods = new Method[i];
            i = n;
            while (i < i1) {
                if (arrayOfInt[i] > 0) {
                    this.methods[(arrayOfInt[i] - 1)] = arrayOfMethod[i];
                }
                i += 1;
            }
            return this.methods;
        }
    }

    public final Class getReturnType(int paramInt) {
        return getReflectiveMethods()[paramInt].getReturnType();
    }

    public final boolean isInstance(Object paramObject) {
        return this.javaClass.isInstance(paramObject);
    }

    public final Object newInstance(Object[] paramArrayOfObject) {
        int j = this.constructors.length;
        int i = 0;
        while (i < j) {
            try {
                Object localObject = this.constructors[i].newInstance(paramArrayOfObject);
                return localObject;
            } catch (InstantiationException paramArrayOfObject) {
                throw new CannotCreateException(paramArrayOfObject);
            } catch (IllegalAccessException paramArrayOfObject) {
                throw new CannotCreateException(paramArrayOfObject);
            } catch (InvocationTargetException paramArrayOfObject) {
                throw new CannotCreateException(paramArrayOfObject);
            } catch (IllegalArgumentException localIllegalArgumentException) {
                i += 1;
            }
        }
        throw new CannotCreateException("no constructor matches");
    }

    public Object trapFieldRead(String paramString) {
        Class localClass = getJavaClass();
        try {
            paramString = localClass.getField(paramString).get(null);
            return paramString;
        } catch (NoSuchFieldException paramString) {
            throw new RuntimeException(paramString.toString());
        } catch (IllegalAccessException paramString) {
            throw new RuntimeException(paramString.toString());
        }
    }

    public void trapFieldWrite(String paramString, Object paramObject) {
        Class localClass = getJavaClass();
        try {
            localClass.getField(paramString).set(null, paramObject);
            return;
        } catch (NoSuchFieldException paramString) {
            throw new RuntimeException(paramString.toString());
        } catch (IllegalAccessException paramString) {
            throw new RuntimeException(paramString.toString());
        }
    }

    public Object trapMethodcall(int paramInt, Object[] paramArrayOfObject) {
        try {
            paramArrayOfObject = getReflectiveMethods()[paramInt].invoke(null, paramArrayOfObject);
            return paramArrayOfObject;
        } catch (InvocationTargetException paramArrayOfObject) {
            throw paramArrayOfObject.getTargetException();
        } catch (IllegalAccessException paramArrayOfObject) {
            throw new CannotInvokeException(paramArrayOfObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/ClassMetaobject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */