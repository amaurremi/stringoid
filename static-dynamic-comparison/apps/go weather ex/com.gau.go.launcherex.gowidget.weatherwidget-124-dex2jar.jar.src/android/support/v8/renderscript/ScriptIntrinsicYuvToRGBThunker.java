package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;

public class ScriptIntrinsicYuvToRGBThunker
  extends ScriptIntrinsicYuvToRGB
{
  android.renderscript.ScriptIntrinsicYuvToRGB mN;
  
  private ScriptIntrinsicYuvToRGBThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicYuvToRGBThunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicYuvToRGBThunker(0, paramRenderScript);
    try
    {
      paramRenderScript.mN = android.renderscript.ScriptIntrinsicYuvToRGB.create(localRenderScriptThunker.mN, paramElement.getNObj());
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
    Script.FieldID localFieldID = createFieldID(0, null);
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
  
  android.renderscript.ScriptIntrinsicYuvToRGB getNObj()
  {
    return this.mN;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsicYuvToRGBThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */