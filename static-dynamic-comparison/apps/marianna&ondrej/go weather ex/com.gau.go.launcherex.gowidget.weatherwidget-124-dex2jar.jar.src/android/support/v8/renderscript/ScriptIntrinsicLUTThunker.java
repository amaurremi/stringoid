package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;

class ScriptIntrinsicLUTThunker
  extends ScriptIntrinsicLUT
{
  android.renderscript.ScriptIntrinsicLUT mN;
  
  private ScriptIntrinsicLUTThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicLUTThunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicLUTThunker(0, paramRenderScript);
    try
    {
      paramRenderScript.mN = android.renderscript.ScriptIntrinsicLUT.create(localRenderScriptThunker.mN, paramElement.getNObj());
      return paramRenderScript;
    }
    catch (RSRuntimeException paramRenderScript)
    {
      throw ExceptionThunker.convertException(paramRenderScript);
    }
  }
  
  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    paramAllocation1 = (AllocationThunker)paramAllocation1;
    paramAllocation2 = (AllocationThunker)paramAllocation2;
    try
    {
      this.mN.forEach(paramAllocation1.getNObj(), paramAllocation2.getNObj());
      return;
    }
    catch (RSRuntimeException paramAllocation1)
    {
      throw ExceptionThunker.convertException(paramAllocation1);
    }
  }
  
  public Script.KernelID getKernelID()
  {
    Script.KernelID localKernelID = createKernelID(0, 3, null, null);
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
  
  android.renderscript.ScriptIntrinsicLUT getNObj()
  {
    return this.mN;
  }
  
  public void setAlpha(int paramInt1, int paramInt2)
  {
    try
    {
      this.mN.setAlpha(paramInt1, paramInt2);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  public void setBlue(int paramInt1, int paramInt2)
  {
    try
    {
      this.mN.setBlue(paramInt1, paramInt2);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  public void setGreen(int paramInt1, int paramInt2)
  {
    try
    {
      this.mN.setGreen(paramInt1, paramInt2);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  public void setRed(int paramInt1, int paramInt2)
  {
    try
    {
      this.mN.setRed(paramInt1, paramInt2);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsicLUTThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */