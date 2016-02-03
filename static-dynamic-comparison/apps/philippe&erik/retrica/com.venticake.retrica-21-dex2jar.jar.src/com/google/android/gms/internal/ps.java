package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class ps
  implements PanoramaApi.PanoramaResult
{
  private final Intent abo;
  private final Status yz;
  
  public ps(Status paramStatus, Intent paramIntent)
  {
    this.yz = ((Status)hm.f(paramStatus));
    this.abo = paramIntent;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
  
  public Intent getViewerIntent()
  {
    return this.abo;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */