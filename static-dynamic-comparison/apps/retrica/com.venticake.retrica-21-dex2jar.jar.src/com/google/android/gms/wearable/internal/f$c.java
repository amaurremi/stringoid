package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import java.io.IOException;
import java.io.InputStream;

public class f$c
  implements DataApi.GetFdForAssetResult
{
  private final ParcelFileDescriptor alJ;
  private final Status yz;
  
  public f$c(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.yz = paramStatus;
    this.alJ = paramParcelFileDescriptor;
  }
  
  public ParcelFileDescriptor getFd()
  {
    return this.alJ;
  }
  
  public InputStream getInputStream()
  {
    return new ParcelFileDescriptor.AutoCloseInputStream(this.alJ);
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
  
  public void release()
  {
    try
    {
      this.alJ.close();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/f$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */