package com.ideashower.readitlater.h;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@TargetApi(9)
public class j
  extends l
{
  public j(SharedPreferences paramSharedPreferences1, SharedPreferences paramSharedPreferences2)
  {
    super(paramSharedPreferences1, paramSharedPreferences2);
  }
  
  public boolean a()
  {
    if (this.c != null) {
      this.c.apply();
    }
    if (this.d != null) {
      this.d.apply();
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/h/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */