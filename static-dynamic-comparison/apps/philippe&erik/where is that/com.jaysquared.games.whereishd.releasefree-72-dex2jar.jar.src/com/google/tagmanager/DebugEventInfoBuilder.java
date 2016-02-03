package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.EventInfo;
import com.google.analytics.containertag.proto.MutableDebug.EventInfo.EventType;
import com.google.android.gms.common.util.VisibleForTesting;

class DebugEventInfoBuilder
  implements EventInfoBuilder
{
  private DebugDataLayerEventEvaluationInfoBuilder dataLayerEventBuilder;
  @VisibleForTesting
  MutableDebug.EventInfo eventInfoBuilder = MutableDebug.EventInfo.newMessage();
  private DebugInformationHandler handler;
  private DebugMacroEvaluationInfoBuilder macroBuilder;
  
  public DebugEventInfoBuilder(MutableDebug.EventInfo.EventType paramEventType, String paramString1, String paramString2, String paramString3, DebugInformationHandler paramDebugInformationHandler)
  {
    this.eventInfoBuilder.setEventType(paramEventType);
    this.eventInfoBuilder.setContainerVersion(paramString1);
    this.eventInfoBuilder.setContainerId(paramString2);
    this.eventInfoBuilder.setKey(paramString3);
    this.handler = paramDebugInformationHandler;
    if (paramEventType.equals(MutableDebug.EventInfo.EventType.DATA_LAYER_EVENT))
    {
      this.dataLayerEventBuilder = new DebugDataLayerEventEvaluationInfoBuilder(this.eventInfoBuilder.getMutableDataLayerEventResult());
      return;
    }
    this.macroBuilder = new DebugMacroEvaluationInfoBuilder(this.eventInfoBuilder.getMutableMacroResult());
  }
  
  public DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder()
  {
    return this.dataLayerEventBuilder;
  }
  
  public MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder()
  {
    return this.macroBuilder;
  }
  
  public void processEventInfo()
  {
    this.handler.receiveEventInfo(this.eventInfoBuilder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugEventInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */