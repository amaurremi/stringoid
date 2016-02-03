package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.b;

public class a
  extends b<Boolean>
{
  public a(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void a(Bundle paramBundle, Boolean paramBoolean)
  {
    paramBundle.putBoolean(getName(), paramBoolean.booleanValue());
  }
  
  protected Boolean d(Bundle paramBundle)
  {
    return Boolean.valueOf(paramBundle.getBoolean(getName()));
  }
  
  protected Boolean d(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return Boolean.valueOf(paramDataHolder.d(getName(), paramInt1, paramInt2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */