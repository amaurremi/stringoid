package android.support.v8.renderscript;

import android.content.res.Resources;
import android.renderscript.RSRuntimeException;
import android.renderscript.Script.FieldID;
import android.renderscript.Script.KernelID;
import android.renderscript.ScriptC;

class ScriptCThunker
  extends ScriptC
{
  private static final String TAG = "ScriptC";
  
  protected ScriptCThunker(RenderScriptThunker paramRenderScriptThunker, Resources paramResources, int paramInt)
  {
    super(paramRenderScriptThunker.mN, paramResources, paramInt);
  }
  
  void thunkBindAllocation(Allocation paramAllocation, int paramInt)
  {
    android.renderscript.Allocation localAllocation = null;
    if (paramAllocation != null) {
      localAllocation = ((AllocationThunker)paramAllocation).mN;
    }
    try
    {
      bindAllocation(localAllocation, paramInt);
      return;
    }
    catch (RSRuntimeException paramAllocation)
    {
      throw ExceptionThunker.convertException(paramAllocation);
    }
  }
  
  Script.FieldID thunkCreateFieldID(int paramInt, Element paramElement)
  {
    try
    {
      paramElement = createFieldID(paramInt, ((ElementThunker)paramElement).getNObj());
      return paramElement;
    }
    catch (RSRuntimeException paramElement)
    {
      throw ExceptionThunker.convertException(paramElement);
    }
  }
  
  Script.KernelID thunkCreateKernelID(int paramInt1, int paramInt2, Element paramElement1, Element paramElement2)
  {
    android.renderscript.Element localElement = null;
    Object localObject = null;
    if (paramElement1 != null) {
      localElement = ((ElementThunker)paramElement1).mN;
    }
    paramElement1 = (Element)localObject;
    if (paramElement2 != null) {
      paramElement1 = ((ElementThunker)paramElement2).mN;
    }
    try
    {
      paramElement1 = createKernelID(paramInt1, paramInt2, localElement, paramElement1);
      return paramElement1;
    }
    catch (RSRuntimeException paramElement1)
    {
      throw ExceptionThunker.convertException(paramElement1);
    }
  }
  
  void thunkForEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker)
  {
    android.renderscript.Allocation localAllocation = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramAllocation1 != null) {
      localAllocation = ((AllocationThunker)paramAllocation1).mN;
    }
    paramAllocation1 = (Allocation)localObject2;
    if (paramAllocation2 != null) {
      paramAllocation1 = ((AllocationThunker)paramAllocation2).mN;
    }
    paramAllocation2 = (Allocation)localObject1;
    if (paramFieldPacker != null) {}
    try
    {
      paramAllocation2 = new android.renderscript.FieldPacker(paramFieldPacker.getData());
      forEach(paramInt, localAllocation, paramAllocation1, paramAllocation2);
      return;
    }
    catch (RSRuntimeException paramAllocation1)
    {
      throw ExceptionThunker.convertException(paramAllocation1);
    }
  }
  
  void thunkForEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker, Script.LaunchOptions paramLaunchOptions)
  {
    android.renderscript.Script.LaunchOptions localLaunchOptions = null;
    if (paramLaunchOptions != null) {}
    try
    {
      localLaunchOptions = new android.renderscript.Script.LaunchOptions();
      Object localObject2;
      Object localObject1;
      throw ExceptionThunker.convertException(paramAllocation1);
    }
    catch (RSRuntimeException paramAllocation1)
    {
      try
      {
        if (paramLaunchOptions.getXEnd() > 0) {
          localLaunchOptions.setX(paramLaunchOptions.getXStart(), paramLaunchOptions.getXEnd());
        }
        if (paramLaunchOptions.getYEnd() > 0) {
          localLaunchOptions.setY(paramLaunchOptions.getYStart(), paramLaunchOptions.getYEnd());
        }
        if (paramLaunchOptions.getZEnd() > 0) {
          localLaunchOptions.setZ(paramLaunchOptions.getZStart(), paramLaunchOptions.getZEnd());
        }
        paramLaunchOptions = null;
        localObject2 = null;
        localObject1 = null;
        if (paramAllocation1 != null) {
          paramLaunchOptions = ((AllocationThunker)paramAllocation1).mN;
        }
        paramAllocation1 = (Allocation)localObject2;
        if (paramAllocation2 != null) {
          paramAllocation1 = ((AllocationThunker)paramAllocation2).mN;
        }
        paramAllocation2 = (Allocation)localObject1;
        if (paramFieldPacker != null) {
          paramAllocation2 = new android.renderscript.FieldPacker(paramFieldPacker.getData());
        }
        forEach(paramInt, paramLaunchOptions, paramAllocation1, paramAllocation2, localLaunchOptions);
        return;
      }
      catch (RSRuntimeException paramAllocation1)
      {
        for (;;) {}
      }
      paramAllocation1 = paramAllocation1;
    }
  }
  
  void thunkInvoke(int paramInt)
  {
    try
    {
      invoke(paramInt);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  void thunkInvoke(int paramInt, FieldPacker paramFieldPacker)
  {
    try
    {
      invoke(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()));
      return;
    }
    catch (RSRuntimeException paramFieldPacker)
    {
      throw ExceptionThunker.convertException(paramFieldPacker);
    }
  }
  
  void thunkSetTimeZone(String paramString)
  {
    try
    {
      setTimeZone(paramString);
      return;
    }
    catch (RSRuntimeException paramString)
    {
      throw ExceptionThunker.convertException(paramString);
    }
  }
  
  void thunkSetVar(int paramInt, double paramDouble)
  {
    try
    {
      setVar(paramInt, paramDouble);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  void thunkSetVar(int paramInt, float paramFloat)
  {
    try
    {
      setVar(paramInt, paramFloat);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  void thunkSetVar(int paramInt1, int paramInt2)
  {
    try
    {
      setVar(paramInt1, paramInt2);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  void thunkSetVar(int paramInt, long paramLong)
  {
    try
    {
      setVar(paramInt, paramLong);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  void thunkSetVar(int paramInt, BaseObj paramBaseObj)
  {
    if (paramBaseObj == null) {
      try
      {
        setVar(paramInt, 0);
        return;
      }
      catch (RSRuntimeException paramBaseObj)
      {
        throw ExceptionThunker.convertException(paramBaseObj);
      }
    }
    try
    {
      setVar(paramInt, paramBaseObj.getNObj());
      return;
    }
    catch (RSRuntimeException paramBaseObj)
    {
      throw ExceptionThunker.convertException(paramBaseObj);
    }
  }
  
  void thunkSetVar(int paramInt, FieldPacker paramFieldPacker)
  {
    try
    {
      setVar(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()));
      return;
    }
    catch (RSRuntimeException paramFieldPacker)
    {
      throw ExceptionThunker.convertException(paramFieldPacker);
    }
  }
  
  void thunkSetVar(int paramInt, FieldPacker paramFieldPacker, Element paramElement, int[] paramArrayOfInt)
  {
    try
    {
      setVar(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()), ((ElementThunker)paramElement).mN, paramArrayOfInt);
      return;
    }
    catch (RSRuntimeException paramFieldPacker)
    {
      throw ExceptionThunker.convertException(paramFieldPacker);
    }
  }
  
  void thunkSetVar(int paramInt, boolean paramBoolean)
  {
    try
    {
      setVar(paramInt, paramBoolean);
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/ScriptCThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */