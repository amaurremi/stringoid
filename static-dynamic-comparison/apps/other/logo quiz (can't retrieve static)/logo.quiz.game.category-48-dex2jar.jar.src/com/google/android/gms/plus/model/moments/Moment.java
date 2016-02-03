package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.nt;
import com.google.android.gms.internal.nv;
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
    private String BL;
    private final Set<Integer> alR = new HashSet();
    private String amE;
    private nt amM;
    private nt amN;
    private String uO;
    
    public Moment build()
    {
      return new nv(this.alR, this.BL, this.amM, this.amE, this.amN, this.uO);
    }
    
    public Builder setId(String paramString)
    {
      this.BL = paramString;
      this.alR.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setResult(ItemScope paramItemScope)
    {
      this.amM = ((nt)paramItemScope);
      this.alR.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.amE = paramString;
      this.alR.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setTarget(ItemScope paramItemScope)
    {
      this.amN = ((nt)paramItemScope);
      this.alR.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.uO = paramString;
      this.alR.add(Integer.valueOf(7));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/plus/model/moments/Moment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */