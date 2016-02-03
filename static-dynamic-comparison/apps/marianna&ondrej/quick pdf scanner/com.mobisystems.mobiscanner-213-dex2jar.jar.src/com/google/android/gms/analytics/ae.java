package com.google.android.gms.analytics;

import android.util.Log;

class ae
  implements e
{
  private int nA = 1;
  
  private String ag(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }
  
  public void bb(int paramInt)
  {
    this.nA = paramInt;
  }
  
  public void info(String paramString)
  {
    if (this.nA <= 1) {
      Log.i("GAV3", ag(paramString));
    }
  }
  
  public int kL()
  {
    return this.nA;
  }
  
  public void o(String paramString)
  {
    if (this.nA <= 0) {
      Log.v("GAV3", ag(paramString));
    }
  }
  
  public void p(String paramString)
  {
    if (this.nA <= 2) {
      Log.w("GAV3", ag(paramString));
    }
  }
  
  public void q(String paramString)
  {
    if (this.nA <= 3) {
      Log.e("GAV3", ag(paramString));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */