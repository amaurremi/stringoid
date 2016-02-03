package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;

class ScriptIntrinsicConvolve5x5Thunker
  extends ScriptIntrinsicConvolve5x5
{
  android.renderscript.ScriptIntrinsicConvolve5x5 mN;
  
  ScriptIntrinsicConvolve5x5Thunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicConvolve5x5Thunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicConvolve5x5Thunker(0, paramRenderScript);
    try
    {
      paramRenderScript.mN = android.renderscript.ScriptIntrinsicConvolve5x5.create(localRenderScriptThunker.mN, paramElement.getNObj());
      return paramRenderScript;
    }
    catch (RSRuntimeException paramRenderScript)
    {
      throw ExceptionThunker.convertException(paramRenderScript);
    }
  }
  
  public void forEach(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    try
    {
      this.mN.forEach(paramAllocation.getNObj());
      return;
    }
    catch (RSRuntimeException paramAllocation)
    {
      throw ExceptionThunker.convertException(paramAllocation);
    }
  }
  
  public Script.FieldID getFieldID_Input()
  {
    Script.FieldID localFieldID = createFieldID(1, null);
    try
    {
      localFieldID.mN = this.mN.getFieldID_Input();
      return localFieldID;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  public Script.KernelID getKernelID()
  {
    Script.KernelID localKernelID = createKernelID(0, 2, null, null);
    try
    {
      localKernelID.mN = this.mN.getKernelID();
      return localKernelID;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  android.renderscript.ScriptIntrinsicConvolve5x5 getNObj()
  {
    return this.mN;
  }
  
  public void setCoefficients(float[] paramArrayOfFloat)
  {
    try
    {
      this.mN.setCoefficients(paramArrayOfFloat);
      return;
    }
    catch (RSRuntimeException paramArrayOfFloat)
    {
      throw ExceptionThunker.convertException(paramArrayOfFloat);
    }
  }
  
  public void setInput(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    try
    {
      this.mN.setInput(paramAllocation.getNObj());
      return;
    }
    catch (RSRuntimeException paramAllocation)
    {
      throw ExceptionThunker.convertException(paramAllocation);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsicConvolve5x5Thunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */