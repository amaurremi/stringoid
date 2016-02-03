package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public class ja
  implements ActivityRecognitionApi
{
  public PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new pa(paramPendingIntent)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.removeActivityUpdates(paramPendingIntent);
        b(Status.En);
      }
    });
  }
  
  public PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, final long paramLong, PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new pa(paramLong)
    {
      protected void a(jg paramAnonymousjg)
      {
        paramAnonymousjg.requestActivityUpdates(paramLong, this.b);
        b(Status.En);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */