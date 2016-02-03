package com.google.android.gms.plus.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

public class i
{
  private String[] abV;
  private String abW;
  private String abX;
  private String abY;
  private PlusCommonExtras aca;
  private final ArrayList<String> acb = new ArrayList();
  private String[] acc;
  private String yQ;
  
  public i(Context paramContext)
  {
    this.abX = paramContext.getPackageName();
    this.abW = paramContext.getPackageName();
    this.aca = new PlusCommonExtras();
    this.acb.add("https://www.googleapis.com/auth/plus.login");
  }
  
  public i bz(String paramString)
  {
    this.yQ = paramString;
    return this;
  }
  
  public i e(String... paramVarArgs)
  {
    this.acb.clear();
    this.acb.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public i f(String... paramVarArgs)
  {
    this.acc = paramVarArgs;
    return this;
  }
  
  public i ki()
  {
    this.acb.clear();
    return this;
  }
  
  public h kj()
  {
    if (this.yQ == null) {
      this.yQ = "<<default account>>";
    }
    String[] arrayOfString = (String[])this.acb.toArray(new String[this.acb.size()]);
    return new h(this.yQ, arrayOfString, this.acc, this.abV, this.abW, this.abX, this.abY, this.aca);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */