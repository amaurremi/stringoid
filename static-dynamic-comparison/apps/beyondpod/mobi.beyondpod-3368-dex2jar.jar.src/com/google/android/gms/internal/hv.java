package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

public class hv
{
  private String[] DT;
  private String DU;
  private String DV;
  private String DW;
  private ArrayList<String> DY = new ArrayList();
  private String[] DZ;
  private String jG;
  
  public hv(Context paramContext)
  {
    this.DV = paramContext.getPackageName();
    this.DU = paramContext.getPackageName();
    this.DY.add("https://www.googleapis.com/auth/plus.login");
  }
  
  public hv aA(String paramString)
  {
    this.jG = paramString;
    return this;
  }
  
  public hv d(String... paramVarArgs)
  {
    this.DY.clear();
    this.DY.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public hv e(String... paramVarArgs)
  {
    this.DZ = paramVarArgs;
    return this;
  }
  
  public hv eY()
  {
    this.DY.clear();
    return this;
  }
  
  public hu eZ()
  {
    if (this.jG == null) {
      this.jG = "<<default account>>";
    }
    String[] arrayOfString = (String[])this.DY.toArray(new String[this.DY.size()]);
    return new hu(this.jG, arrayOfString, this.DZ, this.DT, this.DU, this.DV, this.DW);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */