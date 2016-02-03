package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class ki
  implements PanoramaApi.PanoramaResult
{
  private final Intent abl;
  private final Status yw;
  
  public ki(Status paramStatus, Intent paramIntent)
  {
    this.yw = ((Status)hn.f(paramStatus));
    this.abl = paramIntent;
  }
  
  public Status getStatus()
  {
    return this.yw;
  }
  
  public Intent getViewerIntent()
  {
    return this.abl;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */