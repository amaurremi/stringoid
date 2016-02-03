package android.support.v8.renderscript;

public class ScriptIntrinsicConvolve5x5
        extends ScriptIntrinsic {
    private Allocation mInput;
    private final float[] mValues = new float[25];

    ScriptIntrinsicConvolve5x5(int paramInt, RenderScript paramRenderScript) {
        super(paramInt, paramRenderScript);
    }

    public static ScriptIntrinsicConvolve5x5 create(RenderScript paramRenderScript, Element paramElement) {
        if (RenderScript.isNative) {
            RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
            return ScriptIntrinsicConvolve5x5Thunker.create(paramRenderScript, paramElement);
        }
        return new ScriptIntrinsicConvolve5x5(paramRenderScript.nScriptIntrinsicCreate(4, paramElement.getID(paramRenderScript)), paramRenderScript);
    }

    public void forEach(Allocation paramAllocation) {
        forEach(0, null, paramAllocation, null);
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(1, null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, null, null);
    }

    public void setCoefficients(float[] paramArrayOfFloat) {
        FieldPacker localFieldPacker = new FieldPacker(100);
        int i = 0;
        while (i < this.mValues.length) {
            this.mValues[i] = paramArrayOfFloat[i];
            localFieldPacker.addF32(this.mValues[i]);
            i += 1;
        }
        setVar(0, localFieldPacker);
    }

    public void setInput(Allocation paramAllocation) {
        this.mInput = paramAllocation;
        setVar(1, paramAllocation);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsicConvolve5x5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */