package com.ideashower.readitlater.h;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class k
  extends l
{
  public k(SharedPreferences paramSharedPreferences1, SharedPreferences paramSharedPreferences2)
  {
    super(paramSharedPreferences1, paramSharedPreferences2);
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (this.c != null) {
      bool = this.c.commit();
    }
    if (this.d != null) {
      bool = this.d.commit();
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/h/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */