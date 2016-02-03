package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.List;

class NoopResolvedRuleBuilder
  implements ResolvedRuleBuilder
{
  public ResolvedFunctionCallBuilder createNegativePredicate()
  {
    return new NoopResolvedFunctionCallBuilder();
  }
  
  public ResolvedFunctionCallBuilder createPositivePredicate()
  {
    return new NoopResolvedFunctionCallBuilder();
  }
  
  public ResolvedFunctionCallTranslatorList getAddedMacroFunctions()
  {
    return new NoopResolvedFunctionCallTranslatorList();
  }
  
  public ResolvedFunctionCallTranslatorList getAddedTagFunctions()
  {
    return new NoopResolvedFunctionCallTranslatorList();
  }
  
  public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions()
  {
    return new NoopResolvedFunctionCallTranslatorList();
  }
  
  public ResolvedFunctionCallTranslatorList getRemovedTagFunctions()
  {
    return new NoopResolvedFunctionCallTranslatorList();
  }
  
  public void setValue(TypeSystem.Value paramValue) {}
  
  public class NoopResolvedFunctionCallTranslatorList
    implements ResolvedFunctionCallTranslatorList
  {
    public NoopResolvedFunctionCallTranslatorList() {}
    
    public void translateAndAddAll(List<ResourceUtil.ExpandedFunctionCall> paramList, List<String> paramList1) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/NoopResolvedRuleBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */