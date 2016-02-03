package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.a;
import com.google.android.gms.location.ActivityRecognitionApi;

public class lq
  implements ActivityRecognitionApi
{
  public PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramPendingIntent)
    {
      protected void a(ly paramAnonymously)
        throws RemoteException
      {
        paramAnonymously.removeActivityUpdates(paramPendingIntent);
        b(Status.Jo);
      }
    });
  }
  
  public PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, final long paramLong, PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramLong)
    {
      protected void a(ly paramAnonymously)
        throws RemoteException
      {
        paramAnonymously.requestActivityUpdates(paramLong, this.aer);
        b(Status.Jo);
      }
    });
  }
  
  private static abstract class a
    extends ActivityRecognition.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */