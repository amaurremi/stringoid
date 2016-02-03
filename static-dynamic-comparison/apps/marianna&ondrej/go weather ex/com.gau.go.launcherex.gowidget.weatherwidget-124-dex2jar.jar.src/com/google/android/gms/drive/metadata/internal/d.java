package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class d
  extends a<Integer>
{
  public d(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void a(Bundle paramBundle, Integer paramInteger)
  {
    paramBundle.putInt(getName(), paramInteger.intValue());
  }
  
  protected Integer f(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramDataHolder.getInteger(getName(), paramInt1, paramInt2));
  }
  
  protected Integer h(Bundle paramBundle)
  {
    return Integer.valueOf(paramBundle.getInt(getName()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */