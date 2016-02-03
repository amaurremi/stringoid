package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

abstract class pp
  extends pr<PanoramaApi.PanoramaResult>
{
  protected PanoramaApi.PanoramaResult a(Status paramStatus)
  {
    return new ps(paramStatus, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/pp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */