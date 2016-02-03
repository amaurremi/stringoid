package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.ic;
import com.google.android.gms.internal.ie;
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
    private String Rd;
    private final Set<Integer> UJ = new HashSet();
    private ic VE;
    private ic VF;
    private String Vw;
    private String wp;
    
    public Moment build()
    {
      return new ie(this.UJ, this.wp, this.VE, this.Vw, this.VF, this.Rd);
    }
    
    public Builder setId(String paramString)
    {
      this.wp = paramString;
      this.UJ.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setResult(ItemScope paramItemScope)
    {
      this.VE = ((ic)paramItemScope);
      this.UJ.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.Vw = paramString;
      this.UJ.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setTarget(ItemScope paramItemScope)
    {
      this.VF = ((ic)paramItemScope);
      this.UJ.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.Rd = paramString;
      this.UJ.add(Integer.valueOf(7));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/plus/model/moments/Moment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */