package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.MacroEvaluationInfo;
import com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall;
import com.google.analytics.containertag.proto.Debug.RuleEvaluationStepInfo;

class DebugMacroEvaluationInfoBuilder
  implements MacroEvaluationInfoBuilder
{
  private Debug.MacroEvaluationInfo macroEvaluationInfo;
  
  public DebugMacroEvaluationInfoBuilder(Debug.MacroEvaluationInfo paramMacroEvaluationInfo)
  {
    this.macroEvaluationInfo = paramMacroEvaluationInfo;
  }
  
  public ResolvedFunctionCallBuilder createResult()
  {
    this.macroEvaluationInfo.result = new Debug.ResolvedFunctionCall();
    return new DebugResolvedFunctionCallBuilder(this.macroEvaluationInfo.result);
  }
  
  public RuleEvaluationStepInfoBuilder createRulesEvaluation()
  {
    this.macroEvaluationInfo.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
    return new DebugRuleEvaluationStepInfoBuilder(this.macroEvaluationInfo.rulesEvaluation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DebugMacroEvaluationInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */