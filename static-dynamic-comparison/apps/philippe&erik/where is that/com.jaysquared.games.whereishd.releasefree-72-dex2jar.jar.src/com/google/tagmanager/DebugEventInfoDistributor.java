package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.EventInfo.EventType;

class DebugEventInfoDistributor
  implements EventInfoDistributor
{
  private String containerId;
  private String containerVersion;
  private DebugInformationHandler handler;
  
  public DebugEventInfoDistributor(DebugInformationHandler paramDebugInformationHandler, String paramString1, String paramString2)
  {
    this.handler = paramDebugInformationHandler;
    this.containerVersion = paramString1;
    this.containerId = paramString2;
  }
  
  public EventInfoBuilder createDataLayerEventEvaluationEventInfo(String paramString)
  {
    return new DebugEventInfoBuilder(MutableDebug.EventInfo.EventType.DATA_LAYER_EVENT, this.containerVersion, this.containerId, paramString, this.handler);
  }
  
  public EventInfoBuilder createMacroEvalutionEventInfo(String paramString)
  {
    return new DebugEventInfoBuilder(MutableDebug.EventInfo.EventType.MACRO_REFERENCE, this.containerVersion, this.containerId, paramString, this.handler);
  }
  
  public boolean debugMode()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugEventInfoDistributor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */