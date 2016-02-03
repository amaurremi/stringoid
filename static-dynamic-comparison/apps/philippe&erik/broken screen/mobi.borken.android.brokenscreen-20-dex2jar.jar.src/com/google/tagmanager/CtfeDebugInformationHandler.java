package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.DebugEvents;
import com.google.analytics.containertag.proto.Debug.EventInfo;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.protobuf.nano.MessageNano;
import java.io.IOException;

class CtfeDebugInformationHandler
  implements DebugInformationHandler
{
  @VisibleForTesting
  static final String CTFE_URL_PATH_PREFIX = "/d?";
  @VisibleForTesting
  static final int NUM_EVENTS_PER_SEND = 1;
  private int currentDebugEventNumber;
  private NetworkClient mClient;
  private CtfeHost mCtfeHost;
  private Debug.DebugEvents mDebugEvents;
  
  public CtfeDebugInformationHandler(CtfeHost paramCtfeHost)
  {
    this(new NetworkClientFactory().createNetworkClient(), paramCtfeHost);
  }
  
  @VisibleForTesting
  CtfeDebugInformationHandler(NetworkClient paramNetworkClient, CtfeHost paramCtfeHost)
  {
    this.mCtfeHost = paramCtfeHost;
    this.mClient = paramNetworkClient;
    this.mDebugEvents = new Debug.DebugEvents();
  }
  
  private byte[] getDebugEventsAsBytes()
    throws IOException
  {
    return MessageNano.toByteArray(this.mDebugEvents);
  }
  
  private boolean sendDebugInformationtoCtfe()
  {
    try
    {
      NetworkClient localNetworkClient = this.mClient;
      CtfeHost localCtfeHost = this.mCtfeHost;
      int i = this.currentDebugEventNumber;
      this.currentDebugEventNumber = (i + 1);
      localNetworkClient.sendPostRequest(localCtfeHost.constructCtfeDebugUrl(i), getDebugEventsAsBytes());
      return true;
    }
    catch (IOException localIOException)
    {
      Log.e("CtfeDebugInformationHandler: Error sending information to server that handles debug information: " + localIOException.getMessage());
    }
    return false;
  }
  
  public void receiveEventInfo(Debug.EventInfo paramEventInfo)
  {
    try
    {
      this.mDebugEvents.event = ArrayUtils.appendToArray(this.mDebugEvents.event, paramEventInfo);
      if ((this.mDebugEvents.event.length >= 1) && (sendDebugInformationtoCtfe())) {
        this.mDebugEvents.clear();
      }
      return;
    }
    finally
    {
      paramEventInfo = finally;
      throw paramEventInfo;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/CtfeDebugInformationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */