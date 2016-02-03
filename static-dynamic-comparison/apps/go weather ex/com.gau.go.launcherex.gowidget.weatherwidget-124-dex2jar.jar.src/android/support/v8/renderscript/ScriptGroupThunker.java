package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;
import android.renderscript.ScriptGroup.Builder;

class ScriptGroupThunker
  extends ScriptGroup
{
  android.renderscript.ScriptGroup mN;
  
  ScriptGroupThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public void execute()
  {
    try
    {
      this.mN.execute();
      return;
    }
    catch (RSRuntimeException localRSRuntimeException)
    {
      throw ExceptionThunker.convertException(localRSRuntimeException);
    }
  }
  
  android.renderscript.ScriptGroup getNObj()
  {
    return this.mN;
  }
  
  public void setInput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    try
    {
      this.mN.setInput(paramKernelID.mN, paramAllocation.getNObj());
      return;
    }
    catch (RSRuntimeException paramKernelID)
    {
      throw ExceptionThunker.convertException(paramKernelID);
    }
  }
  
  public void setOutput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    try
    {
      this.mN.setOutput(paramKernelID.mN, paramAllocation.getNObj());
      return;
    }
    catch (RSRuntimeException paramKernelID)
    {
      throw ExceptionThunker.convertException(paramKernelID);
    }
  }
  
  public static final class Builder
  {
    ScriptGroup.Builder bN;
    RenderScript mRS;
    
    Builder(RenderScript paramRenderScript)
    {
      RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
      this.mRS = paramRenderScript;
      try
      {
        this.bN = new ScriptGroup.Builder(localRenderScriptThunker.mN);
        return;
      }
      catch (RSRuntimeException paramRenderScript)
      {
        throw ExceptionThunker.convertException(paramRenderScript);
      }
    }
    
    public Builder addConnection(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
    {
      paramType = (TypeThunker)paramType;
      try
      {
        this.bN.addConnection(paramType.getNObj(), paramKernelID.mN, paramFieldID.mN);
        return this;
      }
      catch (RSRuntimeException paramType)
      {
        throw ExceptionThunker.convertException(paramType);
      }
    }
    
    public Builder addConnection(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
    {
      paramType = (TypeThunker)paramType;
      try
      {
        this.bN.addConnection(paramType.getNObj(), paramKernelID1.mN, paramKernelID2.mN);
        return this;
      }
      catch (RSRuntimeException paramType)
      {
        throw ExceptionThunker.convertException(paramType);
      }
    }
    
    public Builder addKernel(Script.KernelID paramKernelID)
    {
      try
      {
        this.bN.addKernel(paramKernelID.mN);
        return this;
      }
      catch (RSRuntimeException paramKernelID)
      {
        throw ExceptionThunker.convertException(paramKernelID);
      }
    }
    
    public ScriptGroupThunker create()
    {
      ScriptGroupThunker localScriptGroupThunker = new ScriptGroupThunker(0, this.mRS);
      try
      {
        localScriptGroupThunker.mN = this.bN.create();
        return localScriptGroupThunker;
      }
      catch (RSRuntimeException localRSRuntimeException)
      {
        throw ExceptionThunker.convertException(localRSRuntimeException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/ScriptGroupThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */