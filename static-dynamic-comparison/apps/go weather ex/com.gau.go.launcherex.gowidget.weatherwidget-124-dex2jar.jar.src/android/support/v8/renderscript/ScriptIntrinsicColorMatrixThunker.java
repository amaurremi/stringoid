package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;

class ScriptIntrinsicColorMatrixThunker
  extends ScriptIntrinsicColorMatrix
{
  android.renderscript.ScriptIntrinsicColorMatrix mN;
  
  private ScriptIntrinsicColorMatrixThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicColorMatrixThunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicColorMatrixThunker(0, paramRenderScript);
    try
    {
      paramRenderScript.mN = android.renderscript.ScriptIntrinsicColorMatrix.create(localRenderScriptThunker.mN, paramElement.getNObj());
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
  
  android.renderscript.ScriptIntrinsicColorMatrix getNObj()
  {
    return this.mN;
  }
  
  public void setColorMatrix(Matrix3f paramMatrix3f)
  {
    try
    {
      this.mN.setColorMatrix(new android.renderscript.Matrix3f(paramMatrix3f.getArray()));
      return;
    }
    catch (RSRuntimeException paramMatrix3f)
    {
      throw ExceptionThunker.convertException(paramMatrix3f);
    }
  }
  
  public void setColorMatrix(Matrix4f paramMatrix4f)
  {
    try
    {
      this.mN.setColorMatrix(new android.renderscript.Matrix4f(paramMatrix4f.getArray()));
      return;
    }
    catch (RSRuntimeException paramMatrix4f)
    {
      throw ExceptionThunker.convertException(paramMatrix4f);
    }
  }
  
  public void setGreyscale()
  {
    try
    {
      this.mN.setGreyscale();
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  public void setRGBtoYUV()
  {
    try
    {
      this.mN.setRGBtoYUV();
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  public void setYUVtoRGB()
  {
    try
    {
      this.mN.setYUVtoRGB();
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/ScriptIntrinsicColorMatrixThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */