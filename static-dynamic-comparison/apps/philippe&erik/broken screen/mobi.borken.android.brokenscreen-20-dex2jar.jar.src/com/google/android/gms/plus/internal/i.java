package com.google.android.gms.plus.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

public class i
{
  private String[] abS;
  private String abT;
  private String abU;
  private String abV;
  private PlusCommonExtras abX;
  private final ArrayList<String> abY = new ArrayList();
  private String[] abZ;
  private String yN;
  
  public i(Context paramContext)
  {
    this.abU = paramContext.getPackageName();
    this.abT = paramContext.getPackageName();
    this.abX = new PlusCommonExtras();
    this.abY.add("https://www.googleapis.com/auth/plus.login");
  }
  
  public i bz(String paramString)
  {
    this.yN = paramString;
    return this;
  }
  
  public i e(String... paramVarArgs)
  {
    this.abY.clear();
    this.abY.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public i f(String... paramVarArgs)
  {
    this.abZ = paramVarArgs;
    return this;
  }
  
  public i kd()
  {
    this.abY.clear();
    return this;
  }
  
  public h ke()
  {
    if (this.yN == null) {
      this.yN = "<<default account>>";
    }
    String[] arrayOfString = (String[])this.abY.toArray(new String[this.abY.size()]);
    return new h(this.yN, arrayOfString, this.abZ, this.abS, this.abT, this.abU, this.abV, this.abX);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */