package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.DebugEvents;
import com.google.analytics.containertag.proto.MutableDebug.EventInfo;
import com.google.android.gms.common.util.VisibleForTesting;
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
  private MutableDebug.DebugEvents mDebugEvents;
  
  public CtfeDebugInformationHandler(CtfeHost paramCtfeHost)
  {
    this(new NetworkClientFactory().createNetworkClient(), paramCtfeHost);
  }
  
  @VisibleForTesting
  CtfeDebugInformationHandler(NetworkClient paramNetworkClient, CtfeHost paramCtfeHost)
  {
    this.mCtfeHost = paramCtfeHost;
    this.mClient = paramNetworkClient;
    this.mDebugEvents = MutableDebug.DebugEvents.newMessage();
  }
  
  private byte[] getDebugEventsAsBytes()
  {
    return this.mDebugEvents.toByteArray();
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
  
  public void receiveEventInfo(MutableDebug.EventInfo paramEventInfo)
  {
    try
    {
      this.mDebugEvents.addEvent(paramEventInfo);
      if ((this.mDebugEvents.getEventCount() >= 1) && (sendDebugInformationtoCtfe())) {
        this.mDebugEvents = this.mDebugEvents.clear();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/CtfeDebugInformationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */