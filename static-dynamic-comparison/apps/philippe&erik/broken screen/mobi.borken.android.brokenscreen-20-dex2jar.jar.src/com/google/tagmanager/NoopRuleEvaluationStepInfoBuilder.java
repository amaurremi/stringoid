package com.google.tagmanager;

import java.util.Set;

class NoopRuleEvaluationStepInfoBuilder
  implements RuleEvaluationStepInfoBuilder
{
  public ResolvedRuleBuilder createResolvedRuleBuilder()
  {
    return new NoopResolvedRuleBuilder();
  }
  
  public void setEnabledFunctions(Set<ResourceUtil.ExpandedFunctionCall> paramSet) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/NoopRuleEvaluationStepInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */