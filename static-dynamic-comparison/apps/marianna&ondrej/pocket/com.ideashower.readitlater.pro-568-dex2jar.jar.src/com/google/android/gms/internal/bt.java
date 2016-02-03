package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

public class bt
{
  private String a;
  private ArrayList b = new ArrayList();
  private String[] c;
  private String d;
  private String e;
  private String[] f;
  private String g;
  private String h;
  
  public bt(Context paramContext)
  {
    this.e = paramContext.getPackageName();
    this.d = paramContext.getPackageName();
    this.b.add("https://www.googleapis.com/auth/plus.login");
  }
  
  public bt a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public bt a(String... paramVarArgs)
  {
    this.b.clear();
    this.b.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public fn a()
  {
    if (this.a == null) {
      this.a = "<<default account>>";
    }
    String[] arrayOfString = (String[])this.b.toArray(new String[this.b.size()]);
    return new fn(this.a, arrayOfString, this.c, this.f, this.d, this.e, this.g, this.h);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */