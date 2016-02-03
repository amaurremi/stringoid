package com.google.android.gms.plus;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public abstract interface Moments
{
  public abstract PendingResult<LoadMomentsResult> load(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<LoadMomentsResult> load(GoogleApiClient paramGoogleApiClient, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3);
  
  public abstract PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Status> write(GoogleApiClient paramGoogleApiClient, Moment paramMoment);
  
  public static abstract interface LoadMomentsResult
    extends Releasable, Result
  {
    public abstract MomentBuffer getMomentBuffer();
    
    public abstract String getNextPageToken();
    
    public abstract String getUpdated();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/plus/Moments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */