package android.support.v8.renderscript;

import android.content.Context;
import android.renderscript.RSRuntimeException;

class RenderScriptThunker
        extends RenderScript {
    android.renderscript.RenderScript mN;

    RenderScriptThunker(Context paramContext) {
        super(paramContext);
        isNative = true;
    }

    public static RenderScript create(Context paramContext, int paramInt) {
        try {
            RenderScriptThunker localRenderScriptThunker = new RenderScriptThunker(paramContext);
            localRenderScriptThunker.mN = android.renderscript.RenderScript.create(paramContext, paramInt);
            return localRenderScriptThunker;
        } catch (RSRuntimeException paramContext) {
            throw ExceptionThunker.convertException(paramContext);
        }
    }

    public void contextDump() {
        try {
            this.mN.contextDump();
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public void destroy() {
        try {
            this.mN.destroy();
            this.mN = null;
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public void finish() {
        try {
            this.mN.finish();
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public void setPriority(RenderScript.Priority paramPriority) {
        try {
            if (paramPriority == RenderScript.Priority.LOW) {
                this.mN.setPriority(android.renderscript.RenderScript.Priority.LOW);
            }
            if (paramPriority == RenderScript.Priority.NORMAL) {
                this.mN.setPriority(android.renderscript.RenderScript.Priority.NORMAL);
            }
            return;
        } catch (RSRuntimeException paramPriority) {
            throw ExceptionThunker.convertException(paramPriority);
        }
    }

    void validate() {
        if (this.mN == null) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/RenderScriptThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */