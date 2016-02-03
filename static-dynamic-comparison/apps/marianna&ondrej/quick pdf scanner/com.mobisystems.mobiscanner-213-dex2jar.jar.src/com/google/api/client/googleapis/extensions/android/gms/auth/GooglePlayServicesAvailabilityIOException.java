package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;

public class GooglePlayServicesAvailabilityIOException
  extends UserRecoverableAuthIOException
{
  private static final long serialVersionUID = 1L;
  
  GooglePlayServicesAvailabilityIOException(GooglePlayServicesAvailabilityException paramGooglePlayServicesAvailabilityException)
  {
    super(paramGooglePlayServicesAvailabilityException);
  }
  
  public GooglePlayServicesAvailabilityException wM()
  {
    return (GooglePlayServicesAvailabilityException)super.wN();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/extensions/android/gms/auth/GooglePlayServicesAvailabilityIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */