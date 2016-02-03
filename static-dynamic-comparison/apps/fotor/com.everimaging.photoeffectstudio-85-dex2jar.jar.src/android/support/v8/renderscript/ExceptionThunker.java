package android.support.v8.renderscript;

class ExceptionThunker {
    static RuntimeException convertException(RuntimeException paramRuntimeException) {
        Object localObject;
        if ((paramRuntimeException instanceof android.renderscript.RSIllegalArgumentException)) {
            localObject = new RSIllegalArgumentException(paramRuntimeException.getMessage());
        }
        do {
            return (RuntimeException) localObject;
            if ((paramRuntimeException instanceof android.renderscript.RSInvalidStateException)) {
                return new RSInvalidStateException(paramRuntimeException.getMessage());
            }
            if ((paramRuntimeException instanceof android.renderscript.RSDriverException)) {
                return new RSDriverException(paramRuntimeException.getMessage());
            }
            localObject = paramRuntimeException;
        } while (!(paramRuntimeException instanceof android.renderscript.RSRuntimeException));
        return new RSRuntimeException(paramRuntimeException.getMessage());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ExceptionThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */