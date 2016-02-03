package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

public abstract class b<T>
  extends a<Collection<T>>
{
  protected b(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected Collection<T> c(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/metadata/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */