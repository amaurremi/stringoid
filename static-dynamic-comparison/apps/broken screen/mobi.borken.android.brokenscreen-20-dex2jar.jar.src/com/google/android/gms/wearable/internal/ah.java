package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

public final class ah
  implements NodeApi
{
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, final NodeApi.NodeListener paramNodeListener)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramNodeListener);
      }
      
      public Status d(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
    });
  }
  
  public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.q(this);
      }
      
      protected NodeApi.GetConnectedNodesResult aw(Status paramAnonymousStatus)
      {
        return new ah.a(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.p(this);
      }
      
      protected NodeApi.GetLocalNodeResult av(Status paramAnonymousStatus)
      {
        return new ah.b(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final NodeApi.NodeListener paramNodeListener)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.b(this, paramNodeListener);
      }
      
      public Status d(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
    });
  }
  
  public static class a
    implements NodeApi.GetConnectedNodesResult
  {
    private final List<Node> alW;
    private final Status yw;
    
    public a(Status paramStatus, List<Node> paramList)
    {
      this.yw = paramStatus;
      this.alW = paramList;
    }
    
    public List<Node> getNodes()
    {
      return this.alW;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  public static class b
    implements NodeApi.GetLocalNodeResult
  {
    private final Node alX;
    private final Status yw;
    
    public b(Status paramStatus, Node paramNode)
    {
      this.yw = paramStatus;
      this.alX = paramNode;
    }
    
    public Node getNode()
    {
      return this.alX;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */