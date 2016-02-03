package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface Cast$CastApi
{
  public abstract ApplicationMetadata getApplicationMetadata(GoogleApiClient paramGoogleApiClient);
  
  public abstract String getApplicationStatus(GoogleApiClient paramGoogleApiClient);
  
  public abstract double getVolume(GoogleApiClient paramGoogleApiClient);
  
  public abstract boolean isMute(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2);
  
  public abstract PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, String paramString, LaunchOptions paramLaunchOptions);
  
  @Deprecated
  public abstract PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, String paramString, boolean paramBoolean);
  
  public abstract PendingResult<Status> leaveApplication(GoogleApiClient paramGoogleApiClient);
  
  public abstract void removeMessageReceivedCallbacks(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract void requestStatus(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> sendMessage(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2);
  
  public abstract void setMessageReceivedCallbacks(GoogleApiClient paramGoogleApiClient, String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback);
  
  public abstract void setMute(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract void setVolume(GoogleApiClient paramGoogleApiClient, double paramDouble);
  
  public abstract PendingResult<Status> stopApplication(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> stopApplication(GoogleApiClient paramGoogleApiClient, String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/Cast$CastApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */