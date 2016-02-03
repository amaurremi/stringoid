package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.DataLayerEventEvaluationInfo;
import com.google.analytics.containertag.proto.Debug.EventInfo;
import com.google.analytics.containertag.proto.Debug.MacroEvaluationInfo;
import com.google.android.gms.common.util.VisibleForTesting;

class DebugEventInfoBuilder
  implements EventInfoBuilder
{
  private DebugDataLayerEventEvaluationInfoBuilder dataLayerEventBuilder;
  @VisibleForTesting
  Debug.EventInfo eventInfoBuilder = new Debug.EventInfo();
  private DebugInformationHandler handler;
  private DebugMacroEvaluationInfoBuilder macroBuilder;
  
  public DebugEventInfoBuilder(int paramInt, String paramString1, String paramString2, String paramString3, DebugInformationHandler paramDebugInformationHandler)
  {
    this.eventInfoBuilder.eventType = paramInt;
    this.eventInfoBuilder.containerVersion = paramString1;
    this.eventInfoBuilder.containerId = paramString2;
    this.eventInfoBuilder.key = paramString3;
    this.handler = paramDebugInformationHandler;
    if (paramInt == 1)
    {
      this.eventInfoBuilder.dataLayerEventResult = new Debug.DataLayerEventEvaluationInfo();
      this.dataLayerEventBuilder = new DebugDataLayerEventEvaluationInfoBuilder(this.eventInfoBuilder.dataLayerEventResult);
      return;
    }
    this.eventInfoBuilder.macroResult = new Debug.MacroEvaluationInfo();
    this.macroBuilder = new DebugMacroEvaluationInfoBuilder(this.eventInfoBuilder.macroResult);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DebugEventInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */