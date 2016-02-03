package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.RuleEvaluationStepInfo;
import java.util.Iterator;
import java.util.Set;

class DebugRuleEvaluationStepInfoBuilder
  implements RuleEvaluationStepInfoBuilder
{
  private MutableDebug.RuleEvaluationStepInfo ruleEvaluationStepInfo;
  
  public DebugRuleEvaluationStepInfoBuilder(MutableDebug.RuleEvaluationStepInfo paramRuleEvaluationStepInfo)
  {
    this.ruleEvaluationStepInfo = paramRuleEvaluationStepInfo;
  }
  
  public ResolvedRuleBuilder createResolvedRuleBuilder()
  {
    return new DebugResolvedRuleBuilder(this.ruleEvaluationStepInfo.addRules());
  }
  
  public void setEnabledFunctions(Set<ResourceUtil.ExpandedFunctionCall> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ResourceUtil.ExpandedFunctionCall localExpandedFunctionCall = (ResourceUtil.ExpandedFunctionCall)paramSet.next();
      this.ruleEvaluationStepInfo.addEnabledFunctions(DebugResolvedRuleBuilder.translateExpandedFunctionCall(localExpandedFunctionCall));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugRuleEvaluationStepInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */