package javassist.tools.reflect;

import java.lang.reflect.InvocationTargetException;

public class CannotInvokeException
        extends RuntimeException {
    private Throwable err = null;

    public CannotInvokeException(ClassNotFoundException paramClassNotFoundException) {
        super("by " + paramClassNotFoundException.toString());
        this.err = paramClassNotFoundException;
    }

    public CannotInvokeException(IllegalAccessException paramIllegalAccessException) {
        super("by " + paramIllegalAccessException.toString());
        this.err = paramIllegalAccessException;
    }

    public CannotInvokeException(String paramString) {
        super(paramString);
    }

    public CannotInvokeException(InvocationTargetException paramInvocationTargetException) {
        super("by " + paramInvocationTargetException.getTargetException().toString());
        this.err = paramInvocationTargetException.getTargetException();
    }

    public Throwable getReason() {
        return this.err;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/CannotInvokeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */