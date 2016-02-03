package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class jb
  implements FusedLocationProviderApi
{
  public Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.e(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.getLastLocation();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new pb(paramPendingIntent)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.removeLocationUpdates(paramPendingIntent);
        b(Status.En);
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.b(new pb(paramLocationListener)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.removeLocationUpdates(paramLocationListener);
        b(Status.En);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new pb(paramLocationRequest)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
        b(Status.En);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.b(new pb(paramLocationRequest)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.requestLocationUpdates(paramLocationRequest, paramLocationListener);
        b(Status.En);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener, final Looper paramLooper)
  {
    paramGoogleApiClient.b(new pb(paramLocationRequest)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
        b(Status.En);
      }
    });
  }
  
  public PendingResult<Status> setMockLocation(GoogleApiClient paramGoogleApiClient, final Location paramLocation)
  {
    paramGoogleApiClient.b(new pb(paramLocation)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.setMockLocation(paramLocation);
        b(Status.En);
      }
    });
  }
  
  public PendingResult<Status> setMockMode(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.b(new pb(paramBoolean)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.setMockMode(paramBoolean);
        b(Status.En);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */