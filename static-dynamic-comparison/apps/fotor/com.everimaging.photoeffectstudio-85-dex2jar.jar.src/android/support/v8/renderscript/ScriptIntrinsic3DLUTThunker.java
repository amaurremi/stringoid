package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;

class ScriptIntrinsic3DLUTThunker
        extends ScriptIntrinsic3DLUT {
    android.renderscript.ScriptIntrinsic3DLUT mN;

    private ScriptIntrinsic3DLUTThunker(int paramInt, RenderScript paramRenderScript, Element paramElement) {
        super(paramInt, paramRenderScript, paramElement);
    }

    public static ScriptIntrinsic3DLUTThunker create(RenderScript paramRenderScript, Element paramElement) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        ElementThunker localElementThunker = (ElementThunker) paramElement;
        paramRenderScript = new ScriptIntrinsic3DLUTThunker(0, paramRenderScript, paramElement);
        try {
            paramRenderScript.mN = android.renderscript.ScriptIntrinsic3DLUT.create(localRenderScriptThunker.mN, localElementThunker.getNObj());
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public void forEach(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEach(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public Script.KernelID getKernelID() {
        Script.KernelID localKernelID = createKernelID(0, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelID();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    android.renderscript.ScriptIntrinsic3DLUT getNObj() {
        return this.mN;
    }

    public void setLUT(Allocation paramAllocation) {
        paramAllocation = (AllocationThunker) paramAllocation;
        try {
            this.mN.setLUT(paramAllocation.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation) {
            throw ExceptionThunker.convertException(paramAllocation);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsic3DLUTThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */