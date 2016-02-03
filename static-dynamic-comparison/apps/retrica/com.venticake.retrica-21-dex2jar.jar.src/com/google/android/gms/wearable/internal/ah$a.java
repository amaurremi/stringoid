package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import java.util.List;

public class ah$a
  implements NodeApi.GetConnectedNodesResult
{
  private final List<Node> alZ;
  private final Status yz;
  
  public ah$a(Status paramStatus, List<Node> paramList)
  {
    this.yz = paramStatus;
    this.alZ = paramList;
  }
  
  public List<Node> getNodes()
  {
    return this.alZ;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ah$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */