package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.RSRuntimeException;
import android.renderscript.Sampler.Builder;

class SamplerThunker
  extends Sampler
{
  android.renderscript.Sampler mN;
  
  protected SamplerThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  static android.renderscript.Sampler.Value convertValue(Sampler.Value paramValue)
  {
    switch (paramValue)
    {
    default: 
      return null;
    case ???: 
      return android.renderscript.Sampler.Value.NEAREST;
    case ???: 
      return android.renderscript.Sampler.Value.LINEAR;
    case ???: 
      return android.renderscript.Sampler.Value.LINEAR_MIP_LINEAR;
    case ???: 
      return android.renderscript.Sampler.Value.LINEAR_MIP_NEAREST;
    case ???: 
      return android.renderscript.Sampler.Value.WRAP;
    case ???: 
      return android.renderscript.Sampler.Value.CLAMP;
    }
    return android.renderscript.Sampler.Value.MIRRORED_REPEAT;
  }
  
  BaseObj getNObj()
  {
    return this.mN;
  }
  
  public static class Builder
  {
    float mAniso;
    Sampler.Value mMag;
    Sampler.Value mMin;
    RenderScriptThunker mRS;
    Sampler.Value mWrapR;
    Sampler.Value mWrapS;
    Sampler.Value mWrapT;
    
    public Builder(RenderScriptThunker paramRenderScriptThunker)
    {
      this.mRS = paramRenderScriptThunker;
      this.mMin = Sampler.Value.NEAREST;
      this.mMag = Sampler.Value.NEAREST;
      this.mWrapS = Sampler.Value.WRAP;
      this.mWrapT = Sampler.Value.WRAP;
      this.mWrapR = Sampler.Value.WRAP;
    }
    
    public Sampler create()
    {
      this.mRS.validate();
      try
      {
        Object localObject = new Sampler.Builder(this.mRS.mN);
        ((Sampler.Builder)localObject).setMinification(SamplerThunker.convertValue(this.mMin));
        ((Sampler.Builder)localObject).setMagnification(SamplerThunker.convertValue(this.mMag));
        ((Sampler.Builder)localObject).setWrapS(SamplerThunker.convertValue(this.mWrapS));
        ((Sampler.Builder)localObject).setWrapT(SamplerThunker.convertValue(this.mWrapT));
        ((Sampler.Builder)localObject).setAnisotropy(this.mAniso);
        localObject = ((Sampler.Builder)localObject).create();
        SamplerThunker localSamplerThunker = new SamplerThunker(0, this.mRS);
        localSamplerThunker.mMin = this.mMin;
        localSamplerThunker.mMag = this.mMag;
        localSamplerThunker.mWrapS = this.mWrapS;
        localSamplerThunker.mWrapT = this.mWrapT;
        localSamplerThunker.mWrapR = this.mWrapR;
        localSamplerThunker.mAniso = this.mAniso;
        localSamplerThunker.mN = ((android.renderscript.Sampler)localObject);
        return localSamplerThunker;
      }
      catch (RSRuntimeException localRSRuntimeException)
      {
        throw ExceptionThunker.convertException(localRSRuntimeException);
      }
    }
    
    public void setAnisotropy(float paramFloat)
    {
      if (paramFloat >= 0.0F)
      {
        this.mAniso = paramFloat;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }
    
    public void setMagnification(Sampler.Value paramValue)
    {
      if ((paramValue == Sampler.Value.NEAREST) || (paramValue == Sampler.Value.LINEAR))
      {
        this.mMag = paramValue;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }
    
    public void setMinification(Sampler.Value paramValue)
    {
      if ((paramValue == Sampler.Value.NEAREST) || (paramValue == Sampler.Value.LINEAR) || (paramValue == Sampler.Value.LINEAR_MIP_LINEAR) || (paramValue == Sampler.Value.LINEAR_MIP_NEAREST))
      {
        this.mMin = paramValue;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }
    
    public void setWrapS(Sampler.Value paramValue)
    {
      if ((paramValue == Sampler.Value.WRAP) || (paramValue == Sampler.Value.CLAMP) || (paramValue == Sampler.Value.MIRRORED_REPEAT))
      {
        this.mWrapS = paramValue;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }
    
    public void setWrapT(Sampler.Value paramValue)
    {
      if ((paramValue == Sampler.Value.WRAP) || (paramValue == Sampler.Value.CLAMP) || (paramValue == Sampler.Value.MIRRORED_REPEAT))
      {
        this.mWrapT = paramValue;
        return;
      }
      throw new IllegalArgumentException("Invalid value");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/SamplerThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */