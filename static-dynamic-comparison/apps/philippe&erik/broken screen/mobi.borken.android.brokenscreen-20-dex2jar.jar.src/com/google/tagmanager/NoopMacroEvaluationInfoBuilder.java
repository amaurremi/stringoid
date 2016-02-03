package com.google.tagmanager;

class NoopMacroEvaluationInfoBuilder
  implements MacroEvaluationInfoBuilder
{
  public ResolvedFunctionCallBuilder createResult()
  {
    return new NoopResolvedFunctionCallBuilder();
  }
  
  public RuleEvaluationStepInfoBuilder createRulesEvaluation()
  {
    return new NoopRuleEvaluationStepInfoBuilder();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/NoopMacroEvaluationInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */