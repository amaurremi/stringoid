package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;

class ScriptIntrinsicBlurThunker
        extends ScriptIntrinsicBlur {
    android.renderscript.ScriptIntrinsicBlur mN;

    protected ScriptIntrinsicBlurThunker(int paramInt, RenderScript paramRenderScript) {
        super(paramInt, paramRenderScript);
    }

    public static ScriptIntrinsicBlurThunker create(RenderScript paramRenderScript, Element paramElement) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        paramElement = (ElementThunker) paramElement;
        paramRenderScript = new ScriptIntrinsicBlurThunker(0, paramRenderScript);
        try {
            paramRenderScript.mN = android.renderscript.ScriptIntrinsicBlur.create(localRenderScriptThunker.mN, paramElement.getNObj());
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public void forEach(Allocation paramAllocation) {
        paramAllocation = (AllocationThunker) paramAllocation;
        if (paramAllocation != null) {
        }
        try {
            this.mN.forEach(paramAllocation.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation) {
            throw ExceptionThunker.convertException(paramAllocation);
        }
    }

    public Script.FieldID getFieldID_Input() {
        Script.FieldID localFieldID = createFieldID(1, null);
        try {
            localFieldID.mN = this.mN.getFieldID_Input();
            return localFieldID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelID() {
        Script.KernelID localKernelID = createKernelID(0, 2, null, null);
        try {
            localKernelID.mN = this.mN.getKernelID();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    android.renderscript.ScriptIntrinsicBlur getNObj() {
        return this.mN;
    }

    public void setInput(Allocation paramAllocation) {
        paramAllocation = (AllocationThunker) paramAllocation;
        try {
            this.mN.setInput(paramAllocation.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation) {
            throw ExceptionThunker.convertException(paramAllocation);
        }
    }

    public void setRadius(float paramFloat) {
        try {
            this.mN.setRadius(paramFloat);
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsicBlurThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */