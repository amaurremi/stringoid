package com.google.tagmanager;

import android.util.Log;

class d
  implements Logger
{
  private Logger.LogLevel aii = Logger.LogLevel.air;
  
  public void A(String paramString)
  {
    if (this.aii.ordinal() <= Logger.LogLevel.ais.ordinal()) {
      Log.e("GoogleTagManager", paramString);
    }
  }
  
  public void B(String paramString)
  {
    if (this.aii.ordinal() <= Logger.LogLevel.aiq.ordinal()) {
      Log.i("GoogleTagManager", paramString);
    }
  }
  
  public void C(String paramString)
  {
    if (this.aii.ordinal() <= Logger.LogLevel.aio.ordinal()) {
      Log.v("GoogleTagManager", paramString);
    }
  }
  
  public void D(String paramString)
  {
    if (this.aii.ordinal() <= Logger.LogLevel.air.ordinal()) {
      Log.w("GoogleTagManager", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */