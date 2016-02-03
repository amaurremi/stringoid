package com.google.tagmanager;

class NoopEventInfoBuilder
  implements EventInfoBuilder
{
  public DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder()
  {
    return new NoopDataLayerEventEvaluationInfoBuilder();
  }
  
  public MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder()
  {
    return new NoopMacroEvaluationInfoBuilder();
  }
  
  public void processEventInfo() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/NoopEventInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */