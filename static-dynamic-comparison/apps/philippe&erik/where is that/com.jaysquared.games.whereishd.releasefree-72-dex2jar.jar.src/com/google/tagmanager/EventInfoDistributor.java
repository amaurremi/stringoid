package com.google.tagmanager;

abstract interface EventInfoDistributor
{
  public abstract EventInfoBuilder createDataLayerEventEvaluationEventInfo(String paramString);
  
  public abstract EventInfoBuilder createMacroEvalutionEventInfo(String paramString);
  
  public abstract boolean debugMode();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/EventInfoDistributor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */