package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.DataLayerEventEvaluationInfo;
import com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall;
import com.google.analytics.containertag.proto.Debug.RuleEvaluationStepInfo;

class DebugDataLayerEventEvaluationInfoBuilder
  implements DataLayerEventEvaluationInfoBuilder
{
  private Debug.DataLayerEventEvaluationInfo dataLayerEvent;
  
  public DebugDataLayerEventEvaluationInfoBuilder(Debug.DataLayerEventEvaluationInfo paramDataLayerEventEvaluationInfo)
  {
    this.dataLayerEvent = paramDataLayerEventEvaluationInfo;
  }
  
  public ResolvedFunctionCallBuilder createAndAddResult()
  {
    Debug.ResolvedFunctionCall localResolvedFunctionCall = new Debug.ResolvedFunctionCall();
    this.dataLayerEvent.results = ArrayUtils.appendToArray(this.dataLayerEvent.results, localResolvedFunctionCall);
    return new DebugResolvedFunctionCallBuilder(localResolvedFunctionCall);
  }
  
  public RuleEvaluationStepInfoBuilder createRulesEvaluation()
  {
    this.dataLayerEvent.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
    return new DebugRuleEvaluationStepInfoBuilder(this.dataLayerEvent.rulesEvaluation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DebugDataLayerEventEvaluationInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */