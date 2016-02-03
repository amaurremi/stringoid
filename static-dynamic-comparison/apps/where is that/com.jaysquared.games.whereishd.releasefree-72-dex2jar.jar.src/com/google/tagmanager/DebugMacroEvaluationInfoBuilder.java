package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.MacroEvaluationInfo;

class DebugMacroEvaluationInfoBuilder
  implements MacroEvaluationInfoBuilder
{
  private MutableDebug.MacroEvaluationInfo macroEvaluationInfo;
  
  public DebugMacroEvaluationInfoBuilder(MutableDebug.MacroEvaluationInfo paramMacroEvaluationInfo)
  {
    this.macroEvaluationInfo = paramMacroEvaluationInfo;
  }
  
  public ResolvedFunctionCallBuilder createResult()
  {
    return new DebugResolvedFunctionCallBuilder(this.macroEvaluationInfo.getMutableResult());
  }
  
  public RuleEvaluationStepInfoBuilder createRulesEvaluation()
  {
    return new DebugRuleEvaluationStepInfoBuilder(this.macroEvaluationInfo.getMutableRulesEvaluation());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugMacroEvaluationInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */