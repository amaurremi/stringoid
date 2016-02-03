package com.google.android.gms.tagmanager;

import android.util.Log;

class aj
  implements k
{
  private int nA = 5;
  
  public void C(String paramString)
  {
    if (this.nA <= 2) {
      Log.v("GoogleTagManager", paramString);
    }
  }
  
  public void D(String paramString)
  {
    if (this.nA <= 5) {
      Log.w("GoogleTagManager", paramString);
    }
  }
  
  public void Z(String paramString)
  {
    if (this.nA <= 6) {
      Log.e("GoogleTagManager", paramString);
    }
  }
  
  public void aa(String paramString)
  {
    if (this.nA <= 4) {
      Log.i("GoogleTagManager", paramString);
    }
  }
  
  public void f(String paramString, Throwable paramThrowable)
  {
    if (this.nA <= 6) {
      Log.e("GoogleTagManager", paramString, paramThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */