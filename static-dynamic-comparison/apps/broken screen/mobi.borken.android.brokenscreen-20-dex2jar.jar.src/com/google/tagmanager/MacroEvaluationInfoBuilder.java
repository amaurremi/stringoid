package com.google.tagmanager;

abstract interface MacroEvaluationInfoBuilder
{
  public abstract ResolvedFunctionCallBuilder createResult();
  
  public abstract RuleEvaluationStepInfoBuilder createRulesEvaluation();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/MacroEvaluationInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */