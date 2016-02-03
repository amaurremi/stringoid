package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.ko;
import com.google.android.gms.internal.kq;
import java.util.HashSet;
import java.util.Set;

public abstract interface Moment
  extends Freezable<Moment>
{
  public abstract String getId();
  
  public abstract ItemScope getResult();
  
  public abstract String getStartDate();
  
  public abstract ItemScope getTarget();
  
  public abstract String getType();
  
  public abstract boolean hasId();
  
  public abstract boolean hasResult();
  
  public abstract boolean hasStartDate();
  
  public abstract boolean hasTarget();
  
  public abstract boolean hasType();
  
  public static class Builder
  {
    private final Set<Integer> acp = new HashSet();
    private String adc;
    private ko adk;
    private ko adl;
    private String qU;
    private String xD;
    
    public Moment build()
    {
      return new kq(this.acp, this.xD, this.adk, this.adc, this.adl, this.qU);
    }
    
    public Builder setId(String paramString)
    {
      this.xD = paramString;
      this.acp.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setResult(ItemScope paramItemScope)
    {
      this.adk = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.adc = paramString;
      this.acp.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setTarget(ItemScope paramItemScope)
    {
      this.adl = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.qU = paramString;
      this.acp.add(Integer.valueOf(7));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/model/moments/Moment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */