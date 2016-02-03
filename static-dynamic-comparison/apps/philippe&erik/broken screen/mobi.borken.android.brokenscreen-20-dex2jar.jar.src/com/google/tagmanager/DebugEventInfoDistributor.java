package com.google.tagmanager;

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
    return new DebugEventInfoBuilder(1, this.containerVersion, this.containerId, paramString, this.handler);
  }
  
  public EventInfoBuilder createMacroEvalutionEventInfo(String paramString)
  {
    return new DebugEventInfoBuilder(2, this.containerVersion, this.containerId, paramString, this.handler);
  }
  
  public boolean debugMode()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DebugEventInfoDistributor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */