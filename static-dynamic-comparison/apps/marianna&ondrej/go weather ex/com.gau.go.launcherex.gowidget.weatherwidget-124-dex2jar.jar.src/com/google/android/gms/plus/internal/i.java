package com.google.android.gms.plus.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

public class i
{
  private String[] Um;
  private String Un;
  private String Uo;
  private String Up;
  private PlusCommonExtras Ur;
  private final ArrayList<String> Us = new ArrayList();
  private String[] Ut;
  private String wG;
  
  public i(Context paramContext)
  {
    this.Uo = paramContext.getPackageName();
    this.Un = paramContext.getPackageName();
    this.Ur = new PlusCommonExtras();
    this.Us.add("https://www.googleapis.com/auth/plus.login");
  }
  
  public i bh(String paramString)
  {
    this.wG = paramString;
    return this;
  }
  
  public i e(String... paramVarArgs)
  {
    this.Us.clear();
    this.Us.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public i f(String... paramVarArgs)
  {
    this.Ut = paramVarArgs;
    return this;
  }
  
  public i iY()
  {
    this.Us.clear();
    return this;
  }
  
  public h iZ()
  {
    if (this.wG == null) {
      this.wG = "<<default account>>";
    }
    String[] arrayOfString = (String[])this.Us.toArray(new String[this.Us.size()]);
    return new h(this.wG, arrayOfString, this.Ut, this.Um, this.Un, this.Uo, this.Up, this.Ur);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/plus/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */