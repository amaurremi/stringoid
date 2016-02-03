package android.support.v8.renderscript;

public class ScriptIntrinsicBlur
        extends ScriptIntrinsic {
    private Allocation mInput;
    private final float[] mValues = new float[9];

    protected ScriptIntrinsicBlur(int paramInt, RenderScript paramRenderScript) {
        super(paramInt, paramRenderScript);
    }

    public static ScriptIntrinsicBlur create(RenderScript paramRenderScript, Element paramElement) {
        if (RenderScript.isNative) {
            RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
            return ScriptIntrinsicBlurThunker.create(paramRenderScript, paramElement);
        }
        if ((!paramElement.isCompatible(Element.U8_4(paramRenderScript))) && (!paramElement.isCompatible(Element.U8(paramRenderScript)))) {
            throw new RSIllegalArgumentException("Unsuported element type.");
        }
        paramRenderScript = new ScriptIntrinsicBlur(paramRenderScript.nScriptIntrinsicCreate(5, paramElement.getID(paramRenderScript)), paramRenderScript);
        paramRenderScript.setRadius(5.0F);
        return paramRenderScript;
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

    public void setInput(Allocation paramAllocation) {
        this.mInput = paramAllocation;
        setVar(1, paramAllocation);
    }

    public void setRadius(float paramFloat) {
        if ((paramFloat <= 0.0F) || (paramFloat > 25.0F)) {
            throw new RSIllegalArgumentException("Radius out of range (0 < r <= 25).");
        }
        setVar(0, paramFloat);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsicBlur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */