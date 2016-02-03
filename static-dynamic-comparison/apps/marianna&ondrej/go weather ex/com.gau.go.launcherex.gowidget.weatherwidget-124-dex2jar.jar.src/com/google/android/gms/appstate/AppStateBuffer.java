package com.google.android.gms.appstate;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class AppStateBuffer
  extends DataBuffer<AppState>
{
  public AppStateBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public AppState get(int paramInt)
  {
    return new b(this.BB, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/appstate/AppStateBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */