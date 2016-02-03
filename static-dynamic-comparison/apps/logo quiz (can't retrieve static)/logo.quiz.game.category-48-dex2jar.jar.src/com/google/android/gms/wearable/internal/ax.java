package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;

public class ax
  extends ae.a
{
  private final DataApi.DataListener avM;
  private final MessageApi.MessageListener avN;
  private final NodeApi.NodeListener avO;
  private final IntentFilter[] avP;
  
  public ax(DataApi.DataListener paramDataListener, MessageApi.MessageListener paramMessageListener, NodeApi.NodeListener paramNodeListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.avM = paramDataListener;
    this.avN = paramMessageListener;
    this.avO = paramNodeListener;
    this.avP = paramArrayOfIntentFilter;
  }
  
  public static ax a(DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new ax(paramDataListener, null, null, paramArrayOfIntentFilter);
  }
  
  public static ax a(MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new ax(null, paramMessageListener, null, paramArrayOfIntentFilter);
  }
  
  public static ax a(NodeApi.NodeListener paramNodeListener)
  {
    return new ax(null, null, paramNodeListener, null);
  }
  
  public void Z(DataHolder paramDataHolder)
  {
    if (this.avM != null) {
      try
      {
        this.avM.onDataChanged(new DataEventBuffer(paramDataHolder));
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    paramDataHolder.close();
  }
  
  public void a(ah paramah)
  {
    if (this.avN != null) {
      this.avN.onMessageReceived(paramah);
    }
  }
  
  public void a(ak paramak)
  {
    if (this.avO != null) {
      this.avO.onPeerConnected(paramak);
    }
  }
  
  public void b(ak paramak)
  {
    if (this.avO != null) {
      this.avO.onPeerDisconnected(paramak);
    }
  }
  
  public IntentFilter[] pZ()
  {
    return this.avP;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */