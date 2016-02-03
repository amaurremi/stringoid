package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

public abstract class a<T>
  extends b<Collection<T>>
{
  protected a(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected Collection<T> a(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/metadata/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */