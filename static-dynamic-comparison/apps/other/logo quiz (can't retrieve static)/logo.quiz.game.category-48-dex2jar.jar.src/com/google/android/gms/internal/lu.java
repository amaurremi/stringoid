package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationServices.a;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lu
  implements GeofencingApi
{
  public PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, final List<Geofence> paramList, final PendingIntent paramPendingIntent)
  {
    ArrayList localArrayList;
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Geofence localGeofence = (Geofence)paramList.next();
        n.b(localGeofence instanceof mb, "Geofence must be created using Geofence.Builder.");
        localArrayList.add((mb)localGeofence);
      }
    }
    for (paramList = localArrayList;; paramList = null) {
      paramGoogleApiClient.b(new a(paramList)
      {
        protected void a(ly paramAnonymously)
          throws RemoteException
        {
          LocationClient.OnAddGeofencesResultListener local1 = new LocationClient.OnAddGeofencesResultListener()
          {
            public void onAddGeofencesResult(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
            {
              lu.1.this.b(LocationStatusCodes.ef(paramAnonymous2Int));
            }
          };
          paramAnonymously.addGeofences(paramList, paramPendingIntent, local1);
        }
      });
    }
  }
  
  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramPendingIntent)
    {
      protected void a(ly paramAnonymously)
        throws RemoteException
      {
        LocationClient.OnRemoveGeofencesResultListener local1 = new LocationClient.OnRemoveGeofencesResultListener()
        {
          public void onRemoveGeofencesByPendingIntentResult(int paramAnonymous2Int, PendingIntent paramAnonymous2PendingIntent)
          {
            lu.2.this.b(LocationStatusCodes.ef(paramAnonymous2Int));
          }
          
          public void onRemoveGeofencesByRequestIdsResult(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
          }
        };
        paramAnonymously.removeGeofences(paramPendingIntent, local1);
      }
    });
  }
  
  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final List<String> paramList)
  {
    paramGoogleApiClient.b(new a(paramList)
    {
      protected void a(ly paramAnonymously)
        throws RemoteException
      {
        LocationClient.OnRemoveGeofencesResultListener local1 = new LocationClient.OnRemoveGeofencesResultListener()
        {
          public void onRemoveGeofencesByPendingIntentResult(int paramAnonymous2Int, PendingIntent paramAnonymous2PendingIntent)
          {
            Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
          }
          
          public void onRemoveGeofencesByRequestIdsResult(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            lu.3.this.b(LocationStatusCodes.ef(paramAnonymous2Int));
          }
        };
        paramAnonymously.removeGeofences(paramList, local1);
      }
    });
  }
  
  private static abstract class a
    extends LocationServices.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */