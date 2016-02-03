package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class nd
  implements PanoramaApi.PanoramaResult
{
  private final Status CM;
  private final Intent akr;
  
  public nd(Status paramStatus, Intent paramIntent)
  {
    this.CM = ((Status)n.i(paramStatus));
    this.akr = paramIntent;
  }
  
  public Status getStatus()
  {
    return this.CM;
  }
  
  public Intent getViewerIntent()
  {
    return this.akr;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */