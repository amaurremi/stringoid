package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall;
import com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty;
import com.google.analytics.containertag.proto.MutableDebug.ResolvedRule;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class DebugResolvedRuleBuilder
  implements ResolvedRuleBuilder
{
  ResolvedFunctionCallTranslatorList addMacrosHolder;
  ResolvedFunctionCallTranslatorList addTagsHolder;
  ResolvedFunctionCallTranslatorList removeMacrosHolder;
  ResolvedFunctionCallTranslatorList removeTagsHolder;
  MutableDebug.ResolvedRule resolvedRule;
  
  public DebugResolvedRuleBuilder(MutableDebug.ResolvedRule paramResolvedRule)
  {
    this.resolvedRule = paramResolvedRule;
    this.addMacrosHolder = new DebugResolvedFunctionCallListTranslator(this.resolvedRule.getMutableAddMacrosList());
    this.removeMacrosHolder = new DebugResolvedFunctionCallListTranslator(this.resolvedRule.getMutableRemoveMacrosList());
    this.addTagsHolder = new DebugResolvedFunctionCallListTranslator(this.resolvedRule.getMutableAddTagsList());
    this.removeTagsHolder = new DebugResolvedFunctionCallListTranslator(this.resolvedRule.getMutableRemoveTagsList());
  }
  
  public static MutableDebug.ResolvedFunctionCall translateExpandedFunctionCall(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
  {
    MutableDebug.ResolvedFunctionCall localResolvedFunctionCall = MutableDebug.ResolvedFunctionCall.newMessage();
    paramExpandedFunctionCall = paramExpandedFunctionCall.getProperties().entrySet().iterator();
    while (paramExpandedFunctionCall.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramExpandedFunctionCall.next();
      MutableDebug.ResolvedProperty localResolvedProperty = MutableDebug.ResolvedProperty.newMessage();
      localResolvedProperty.setKey((String)localEntry.getKey());
      localResolvedProperty.setValue(DebugValueBuilder.copyImmutableValue((TypeSystem.Value)localEntry.getValue()));
      localResolvedFunctionCall.addProperties(localResolvedProperty);
    }
    return localResolvedFunctionCall;
  }
  
  public ResolvedFunctionCallBuilder createNegativePredicate()
  {
    return new DebugResolvedFunctionCallBuilder(this.resolvedRule.addNegativePredicates());
  }
  
  public ResolvedFunctionCallBuilder createPositivePredicate()
  {
    return new DebugResolvedFunctionCallBuilder(this.resolvedRule.addPositivePredicates());
  }
  
  public ResolvedFunctionCallTranslatorList getAddedMacroFunctions()
  {
    return this.addMacrosHolder;
  }
  
  public ResolvedFunctionCallTranslatorList getAddedTagFunctions()
  {
    return this.addTagsHolder;
  }
  
  public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions()
  {
    return this.removeMacrosHolder;
  }
  
  public ResolvedFunctionCallTranslatorList getRemovedTagFunctions()
  {
    return this.removeTagsHolder;
  }
  
  public void setValue(TypeSystem.Value paramValue)
  {
    this.resolvedRule.setResult(DebugValueBuilder.copyImmutableValue(paramValue));
  }
  
  class DebugResolvedFunctionCallListTranslator
    implements ResolvedFunctionCallTranslatorList
  {
    @VisibleForTesting
    List<MutableDebug.ResolvedFunctionCall> toBuild;
    
    DebugResolvedFunctionCallListTranslator()
    {
      List localList;
      this.toBuild = localList;
    }
    
    public void translateAndAddAll(List<ResourceUtil.ExpandedFunctionCall> paramList, List<String> paramList1)
    {
      int i = 0;
      if (i < paramList.size())
      {
        this.toBuild.add(DebugResolvedRuleBuilder.translateExpandedFunctionCall((ResourceUtil.ExpandedFunctionCall)paramList.get(i)));
        if (i < paramList1.size()) {
          ((MutableDebug.ResolvedFunctionCall)this.toBuild.get(i)).setAssociatedRuleName((String)paramList1.get(i));
        }
        for (;;)
        {
          i += 1;
          break;
          ((MutableDebug.ResolvedFunctionCall)this.toBuild.get(i)).setAssociatedRuleName("Unknown");
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugResolvedRuleBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */