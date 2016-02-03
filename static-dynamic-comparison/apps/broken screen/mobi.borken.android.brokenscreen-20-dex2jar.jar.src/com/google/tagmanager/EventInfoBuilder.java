package com.google.tagmanager;

abstract interface EventInfoBuilder
{
  public abstract DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder();
  
  public abstract MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder();
  
  public abstract void processEventInfo();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/EventInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */