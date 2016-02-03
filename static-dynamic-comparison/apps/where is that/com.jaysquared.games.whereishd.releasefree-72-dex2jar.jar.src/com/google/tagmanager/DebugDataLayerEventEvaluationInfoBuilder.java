package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.DataLayerEventEvaluationInfo;

class DebugDataLayerEventEvaluationInfoBuilder
  implements DataLayerEventEvaluationInfoBuilder
{
  private MutableDebug.DataLayerEventEvaluationInfo dataLayerEvent;
  
  public DebugDataLayerEventEvaluationInfoBuilder(MutableDebug.DataLayerEventEvaluationInfo paramDataLayerEventEvaluationInfo)
  {
    this.dataLayerEvent = paramDataLayerEventEvaluationInfo;
  }
  
  public ResolvedFunctionCallBuilder createAndAddResult()
  {
    return new DebugResolvedFunctionCallBuilder(this.dataLayerEvent.addResults());
  }
  
  public RuleEvaluationStepInfoBuilder createRulesEvaluation()
  {
    return new DebugRuleEvaluationStepInfoBuilder(this.dataLayerEvent.getMutableRulesEvaluation());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugDataLayerEventEvaluationInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */