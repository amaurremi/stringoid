package com.google.android.gms.tagmanager;

import android.util.Log;

class x
  implements bi
{
  private int tK = 5;
  
  public void A(String paramString)
  {
    if (this.tK <= 6) {
      Log.e("GoogleTagManager", paramString);
    }
  }
  
  public void B(String paramString)
  {
    if (this.tK <= 4) {
      Log.i("GoogleTagManager", paramString);
    }
  }
  
  public void C(String paramString)
  {
    if (this.tK <= 2) {
      Log.v("GoogleTagManager", paramString);
    }
  }
  
  public void D(String paramString)
  {
    if (this.tK <= 5) {
      Log.w("GoogleTagManager", paramString);
    }
  }
  
  public void b(String paramString, Throwable paramThrowable)
  {
    if (this.tK <= 6) {
      Log.e("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void c(String paramString, Throwable paramThrowable)
  {
    if (this.tK <= 5) {
      Log.w("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void setLogLevel(int paramInt)
  {
    this.tK = paramInt;
  }
  
  public void z(String paramString)
  {
    if (this.tK <= 3) {
      Log.d("GoogleTagManager", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */