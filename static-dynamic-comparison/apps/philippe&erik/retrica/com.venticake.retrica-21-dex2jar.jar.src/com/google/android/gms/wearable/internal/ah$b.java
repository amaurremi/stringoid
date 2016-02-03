package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;

public class ah$b
  implements NodeApi.GetLocalNodeResult
{
  private final Node ama;
  private final Status yz;
  
  public ah$b(Status paramStatus, Node paramNode)
  {
    this.yz = paramStatus;
    this.ama = paramNode;
  }
  
  public Node getNode()
  {
    return this.ama;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ah$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */