package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;

public final class ah
  implements NodeApi
{
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, final NodeApi.NodeListener paramNodeListener)
  {
    paramGoogleApiClient.a(new az()
    {
      public Status a(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.a(this, paramNodeListener);
      }
    });
  }
  
  public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new az()
    {
      protected NodeApi.GetConnectedNodesResult a(Status paramAnonymousStatus)
      {
        return new ah.a(paramAnonymousStatus, null);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.q(this);
      }
    });
  }
  
  public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new az()
    {
      protected NodeApi.GetLocalNodeResult a(Status paramAnonymousStatus)
      {
        return new ah.b(paramAnonymousStatus, null);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.p(this);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final NodeApi.NodeListener paramNodeListener)
  {
    paramGoogleApiClient.a(new az()
    {
      public Status a(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
      
      protected void a(au paramAnonymousau)
      {
        paramAnonymousau.b(this, paramNodeListener);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */