package com.google.tagmanager;

class NoopEventInfoDistributor
  implements EventInfoDistributor
{
  public EventInfoBuilder createDataLayerEventEvaluationEventInfo(String paramString)
  {
    return new NoopEventInfoBuilder();
  }
  
  public EventInfoBuilder createMacroEvalutionEventInfo(String paramString)
  {
    return new NoopEventInfoBuilder();
  }
  
  public boolean debugMode()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/NoopEventInfoDistributor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */