package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.b;

public class e
  extends b<Long>
{
  public e(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void a(Bundle paramBundle, Long paramLong)
  {
    paramBundle.putLong(getName(), paramLong.longValue());
  }
  
  protected Long g(Bundle paramBundle)
  {
    return Long.valueOf(paramBundle.getLong(getName()));
  }
  
  protected Long g(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return Long.valueOf(paramDataHolder.a(getName(), paramInt1, paramInt2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */