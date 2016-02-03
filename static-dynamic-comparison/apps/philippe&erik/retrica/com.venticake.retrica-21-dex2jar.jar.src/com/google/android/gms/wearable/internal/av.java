package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;

public class av
  extends ac.a
{
  private final DataApi.DataListener aml;
  private final MessageApi.MessageListener amm;
  private final NodeApi.NodeListener amn;
  private final IntentFilter[] amo;
  
  public av(DataApi.DataListener paramDataListener, MessageApi.MessageListener paramMessageListener, NodeApi.NodeListener paramNodeListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.aml = paramDataListener;
    this.amm = paramMessageListener;
    this.amn = paramNodeListener;
    this.amo = paramArrayOfIntentFilter;
  }
  
  public static av a(DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new av(paramDataListener, null, null, paramArrayOfIntentFilter);
  }
  
  public static av a(MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new av(null, paramMessageListener, null, paramArrayOfIntentFilter);
  }
  
  public static av a(NodeApi.NodeListener paramNodeListener)
  {
    return new av(null, null, paramNodeListener, null);
  }
  
  public void Y(DataHolder paramDataHolder)
  {
    if (this.aml != null) {
      try
      {
        this.aml.onDataChanged(new DataEventBuffer(paramDataHolder));
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    paramDataHolder.close();
  }
  
  public void a(af paramaf)
  {
    if (this.amm != null) {
      this.amm.onMessageReceived(paramaf);
    }
  }
  
  public void a(ai paramai)
  {
    if (this.amn != null) {
      this.amn.onPeerConnected(paramai);
    }
  }
  
  public void b(ai paramai)
  {
    if (this.amn != null) {
      this.amn.onPeerDisconnected(paramai);
    }
  }
  
  public IntentFilter[] nu()
  {
    return this.amo;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */