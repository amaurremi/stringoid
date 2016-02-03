package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall;
import com.google.analytics.containertag.proto.Debug.ResolvedProperty;
import com.google.analytics.containertag.proto.Debug.ResolvedRule;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.ArrayList;
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
  Debug.ResolvedRule resolvedRule;
  
  public DebugResolvedRuleBuilder(Debug.ResolvedRule paramResolvedRule)
  {
    this.resolvedRule = paramResolvedRule;
    this.addMacrosHolder = new DebugResolvedFunctionCallListTranslator(1);
    this.removeMacrosHolder = new DebugResolvedFunctionCallListTranslator(2);
    this.addTagsHolder = new DebugResolvedFunctionCallListTranslator(3);
    this.removeTagsHolder = new DebugResolvedFunctionCallListTranslator(4);
  }
  
  public static Debug.ResolvedFunctionCall translateExpandedFunctionCall(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
  {
    Debug.ResolvedFunctionCall localResolvedFunctionCall = new Debug.ResolvedFunctionCall();
    paramExpandedFunctionCall = paramExpandedFunctionCall.getProperties().entrySet().iterator();
    while (paramExpandedFunctionCall.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramExpandedFunctionCall.next();
      Debug.ResolvedProperty localResolvedProperty = new Debug.ResolvedProperty();
      localResolvedProperty.key = ((String)localEntry.getKey());
      localResolvedProperty.value = DebugValueBuilder.copyImmutableValue((TypeSystem.Value)localEntry.getValue());
      localResolvedFunctionCall.properties = ArrayUtils.appendToArray(localResolvedFunctionCall.properties, localResolvedProperty);
    }
    return localResolvedFunctionCall;
  }
  
  public ResolvedFunctionCallBuilder createNegativePredicate()
  {
    Debug.ResolvedFunctionCall localResolvedFunctionCall = new Debug.ResolvedFunctionCall();
    this.resolvedRule.negativePredicates = ArrayUtils.appendToArray(this.resolvedRule.negativePredicates, localResolvedFunctionCall);
    return new DebugResolvedFunctionCallBuilder(localResolvedFunctionCall);
  }
  
  public ResolvedFunctionCallBuilder createPositivePredicate()
  {
    Debug.ResolvedFunctionCall localResolvedFunctionCall = new Debug.ResolvedFunctionCall();
    this.resolvedRule.positivePredicates = ArrayUtils.appendToArray(this.resolvedRule.positivePredicates, localResolvedFunctionCall);
    return new DebugResolvedFunctionCallBuilder(localResolvedFunctionCall);
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
    this.resolvedRule.result = DebugValueBuilder.copyImmutableValue(paramValue);
  }
  
  class DebugResolvedFunctionCallListTranslator
    implements ResolvedFunctionCallTranslatorList
  {
    private final int type;
    
    DebugResolvedFunctionCallListTranslator(int paramInt)
    {
      this.type = paramInt;
    }
    
    public void translateAndAddAll(List<ResourceUtil.ExpandedFunctionCall> paramList, List<String> paramList1)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      int i = 0;
      if (i < paramList.size())
      {
        localArrayList.add(DebugResolvedRuleBuilder.translateExpandedFunctionCall((ResourceUtil.ExpandedFunctionCall)paramList.get(i)));
        if (i < paramList1.size()) {}
        for (((Debug.ResolvedFunctionCall)localArrayList.get(i)).associatedRuleName = ((String)paramList1.get(i));; ((Debug.ResolvedFunctionCall)localArrayList.get(i)).associatedRuleName = "Unknown")
        {
          i += 1;
          break;
        }
      }
      paramList = (Debug.ResolvedFunctionCall[])localArrayList.toArray(new Debug.ResolvedFunctionCall[0]);
      switch (this.type)
      {
      default: 
        Log.e("unknown type in translateAndAddAll: " + this.type);
        return;
      case 1: 
        DebugResolvedRuleBuilder.this.resolvedRule.addMacros = paramList;
        return;
      case 2: 
        DebugResolvedRuleBuilder.this.resolvedRule.removeMacros = paramList;
        return;
      case 3: 
        DebugResolvedRuleBuilder.this.resolvedRule.addTags = paramList;
        return;
      }
      DebugResolvedRuleBuilder.this.resolvedRule.removeTags = paramList;
    }
    
    class Type
    {
      static final int ADD_MACROS = 1;
      static final int ADD_TAGS = 3;
      static final int REMOVE_MACROS = 2;
      static final int REMOVE_TAGS = 4;
      
      Type() {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DebugResolvedRuleBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */