package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;

class ScriptIntrinsicBlendThunker
        extends ScriptIntrinsicBlend {
    android.renderscript.ScriptIntrinsicBlend mN;

    ScriptIntrinsicBlendThunker(int paramInt, RenderScript paramRenderScript) {
        super(paramInt, paramRenderScript);
    }

    public static ScriptIntrinsicBlendThunker create(RenderScript paramRenderScript, Element paramElement) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        paramElement = (ElementThunker) paramElement;
        paramRenderScript = new ScriptIntrinsicBlendThunker(0, paramRenderScript);
        try {
            paramRenderScript.mN = android.renderscript.ScriptIntrinsicBlend.create(localRenderScriptThunker.mN, paramElement.getNObj());
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public void forEachAdd(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachAdd(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachClear(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachClear(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachDst(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachDst(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachDstAtop(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachDstAtop(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachDstIn(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachDstIn(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachDstOut(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachDstOut(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachDstOver(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachDstOver(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachMultiply(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachMultiply(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachSrc(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachSrc(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachSrcAtop(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachSrcAtop(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachSrcIn(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachSrcIn(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachSrcOut(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachSrcOut(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachSrcOver(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachSrcOver(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachSubtract(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachSubtract(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public void forEachXor(Allocation paramAllocation1, Allocation paramAllocation2) {
        paramAllocation1 = (AllocationThunker) paramAllocation1;
        paramAllocation2 = (AllocationThunker) paramAllocation2;
        try {
            this.mN.forEachXor(paramAllocation1.getNObj(), paramAllocation2.getNObj());
            return;
        } catch (RSRuntimeException paramAllocation1) {
            throw ExceptionThunker.convertException(paramAllocation1);
        }
    }

    public Script.KernelID getKernelIDAdd() {
        Script.KernelID localKernelID = createKernelID(34, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDAdd();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDClear() {
        Script.KernelID localKernelID = createKernelID(0, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDClear();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDDst() {
        Script.KernelID localKernelID = createKernelID(2, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDDst();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDDstAtop() {
        Script.KernelID localKernelID = createKernelID(10, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDDstAtop();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDDstIn() {
        Script.KernelID localKernelID = createKernelID(6, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDDstIn();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDDstOut() {
        Script.KernelID localKernelID = createKernelID(8, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDDstOut();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDDstOver() {
        Script.KernelID localKernelID = createKernelID(4, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDDstOver();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDMultiply() {
        Script.KernelID localKernelID = createKernelID(14, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDMultiply();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDSrc() {
        Script.KernelID localKernelID = createKernelID(1, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDSrc();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDSrcAtop() {
        Script.KernelID localKernelID = createKernelID(9, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDSrcAtop();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDSrcIn() {
        Script.KernelID localKernelID = createKernelID(5, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDSrcIn();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDSrcOut() {
        Script.KernelID localKernelID = createKernelID(7, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDSrcOut();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDSrcOver() {
        Script.KernelID localKernelID = createKernelID(3, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDSrcOver();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDSubtract() {
        Script.KernelID localKernelID = createKernelID(35, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDSubtract();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Script.KernelID getKernelIDXor() {
        Script.KernelID localKernelID = createKernelID(11, 3, null, null);
        try {
            localKernelID.mN = this.mN.getKernelIDXor();
            return localKernelID;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    android.renderscript.ScriptIntrinsicBlend getNObj() {
        return this.mN;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsicBlendThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */