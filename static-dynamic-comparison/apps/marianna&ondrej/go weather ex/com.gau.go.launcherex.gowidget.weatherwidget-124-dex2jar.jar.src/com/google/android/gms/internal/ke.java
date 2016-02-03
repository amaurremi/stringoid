package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.wearable.d;

public class ke
  extends b
  implements d
{
  public ke(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getId()
  {
    return getString("asset_id");
  }
  
  public String mc()
  {
    return getString("asset_key");
  }
  
  public d mf()
  {
    return new kd(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */