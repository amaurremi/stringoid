package com.google.android.gms.plus.model.moments;

import com.google.android.gms.internal.kn;
import com.google.android.gms.internal.kp;
import java.util.HashSet;
import java.util.Set;

public class Moment$Builder
{
  private final Set<Integer> acs = new HashSet();
  private String adf;
  private kn adn;
  private kn ado;
  private String qX;
  private String xG;
  
  public Moment build()
  {
    return new kp(this.acs, this.xG, this.adn, this.adf, this.ado, this.qX);
  }
  
  public Builder setId(String paramString)
  {
    this.xG = paramString;
    this.acs.add(Integer.valueOf(2));
    return this;
  }
  
  public Builder setResult(ItemScope paramItemScope)
  {
    this.adn = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(4));
    return this;
  }
  
  public Builder setStartDate(String paramString)
  {
    this.adf = paramString;
    this.acs.add(Integer.valueOf(5));
    return this;
  }
  
  public Builder setTarget(ItemScope paramItemScope)
  {
    this.ado = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(6));
    return this;
  }
  
  public Builder setType(String paramString)
  {
    this.qX = paramString;
    this.acs.add(Integer.valueOf(7));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/model/moments/Moment$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */