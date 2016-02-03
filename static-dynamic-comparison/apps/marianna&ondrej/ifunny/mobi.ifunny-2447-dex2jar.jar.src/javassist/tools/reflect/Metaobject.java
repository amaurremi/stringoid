package javassist.tools.reflect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Metaobject
        implements Serializable {
    protected Metalevel baseobject;
    protected ClassMetaobject classmetaobject;
    protected Method[] methods;

    protected Metaobject() {
        this.baseobject = null;
        this.classmetaobject = null;
        this.methods = null;
    }

    public Metaobject(Object paramObject, Object[] paramArrayOfObject) {
        this.baseobject = ((Metalevel) paramObject);
        this.classmetaobject = this.baseobject._getClass();
        this.methods = this.classmetaobject.getReflectiveMethods();
    }

    private void readObject(ObjectInputStream paramObjectInputStream) {
        this.baseobject = ((Metalevel) paramObjectInputStream.readObject());
        this.classmetaobject = this.baseobject._getClass();
        this.methods = this.classmetaobject.getReflectiveMethods();
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream) {
        paramObjectOutputStream.writeObject(this.baseobject);
    }

    public final ClassMetaobject getClassMetaobject() {
        return this.classmetaobject;
    }

    public final String getMethodName(int paramInt) {
        String str = this.methods[paramInt].getName();
        int i;
        for (paramInt = 3; ; paramInt = i) {
            i = paramInt + 1;
            paramInt = str.charAt(paramInt);
            if ((paramInt < 48) || (57 < paramInt)) {
                return str.substring(i);
            }
        }
    }

    public final Object getObject() {
        return this.baseobject;
    }

    public final Class[] getParameterTypes(int paramInt) {
        return this.methods[paramInt].getParameterTypes();
    }

    public final Class getReturnType(int paramInt) {
        return this.methods[paramInt].getReturnType();
    }

    public final void setObject(Object paramObject) {
        this.baseobject = ((Metalevel) paramObject);
        this.classmetaobject = this.baseobject._getClass();
        this.methods = this.classmetaobject.getReflectiveMethods();
        this.baseobject._setMetaobject(this);
    }

    public Object trapFieldRead(String paramString) {
        Class localClass = getClassMetaobject().getJavaClass();
        try {
            paramString = localClass.getField(paramString).get(getObject());
            return paramString;
        } catch (NoSuchFieldException paramString) {
            throw new RuntimeException(paramString.toString());
        } catch (IllegalAccessException paramString) {
            throw new RuntimeException(paramString.toString());
        }
    }

    public void trapFieldWrite(String paramString, Object paramObject) {
        Class localClass = getClassMetaobject().getJavaClass();
        try {
            localClass.getField(paramString).set(getObject(), paramObject);
            return;
        } catch (NoSuchFieldException paramString) {
            throw new RuntimeException(paramString.toString());
        } catch (IllegalAccessException paramString) {
            throw new RuntimeException(paramString.toString());
        }
    }

    public Object trapMethodcall(int paramInt, Object[] paramArrayOfObject) {
        try {
            paramArrayOfObject = this.methods[paramInt].invoke(getObject(), paramArrayOfObject);
            return paramArrayOfObject;
        } catch (InvocationTargetException paramArrayOfObject) {
            throw paramArrayOfObject.getTargetException();
        } catch (IllegalAccessException paramArrayOfObject) {
            throw new CannotInvokeException(paramArrayOfObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/Metaobject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */