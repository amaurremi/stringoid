package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.proto.Serving.FunctionCall;
import com.google.analytics.containertag.proto.Serving.Property;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.containertag.proto.Serving.Rule;
import com.google.analytics.containertag.proto.Serving.ServingValue;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ResourceUtil
{
  private static ExpandedFunctionCall expandFunctionCall(Serving.FunctionCall paramFunctionCall, Serving.Resource paramResource, TypeSystem.Value[] paramArrayOfValue, int paramInt)
    throws ResourceUtil.InvalidResourceException
  {
    ExpandedFunctionCallBuilder localExpandedFunctionCallBuilder = ExpandedFunctionCall.newBuilder();
    paramFunctionCall = paramFunctionCall.getPropertyList().iterator();
    while (paramFunctionCall.hasNext())
    {
      Object localObject = (Integer)paramFunctionCall.next();
      localObject = (Serving.Property)getWithBoundsCheck(paramResource.getPropertyList(), ((Integer)localObject).intValue(), "properties");
      localExpandedFunctionCallBuilder.addProperty((String)getWithBoundsCheck(paramResource.getKeyList(), ((Serving.Property)localObject).getKey(), "keys"), (TypeSystem.Value)getWithBoundsCheck(paramArrayOfValue, ((Serving.Property)localObject).getValue(), "values"));
    }
    return localExpandedFunctionCallBuilder.build();
  }
  
  private static ExpandedRule expandRule(Serving.Rule paramRule, List<ExpandedFunctionCall> paramList1, List<ExpandedFunctionCall> paramList2, List<ExpandedFunctionCall> paramList3, Serving.Resource paramResource)
  {
    ExpandedRuleBuilder localExpandedRuleBuilder = ExpandedRule.newBuilder();
    Iterator localIterator = paramRule.getPositivePredicateList().iterator();
    while (localIterator.hasNext()) {
      localExpandedRuleBuilder.addPositivePredicate((ExpandedFunctionCall)paramList3.get(((Integer)localIterator.next()).intValue()));
    }
    localIterator = paramRule.getNegativePredicateList().iterator();
    while (localIterator.hasNext()) {
      localExpandedRuleBuilder.addNegativePredicate((ExpandedFunctionCall)paramList3.get(((Integer)localIterator.next()).intValue()));
    }
    paramList3 = paramRule.getAddTagList().iterator();
    while (paramList3.hasNext()) {
      localExpandedRuleBuilder.addAddTag((ExpandedFunctionCall)paramList1.get(((Integer)paramList3.next()).intValue()));
    }
    paramList3 = paramRule.getAddTagRuleNameList().iterator();
    while (paramList3.hasNext()) {
      localExpandedRuleBuilder.addAddTagRuleName(paramResource.getValue(((Integer)paramList3.next()).intValue()).getString());
    }
    paramList3 = paramRule.getRemoveTagList().iterator();
    while (paramList3.hasNext()) {
      localExpandedRuleBuilder.addRemoveTag((ExpandedFunctionCall)paramList1.get(((Integer)paramList3.next()).intValue()));
    }
    paramList1 = paramRule.getRemoveTagRuleNameList().iterator();
    while (paramList1.hasNext()) {
      localExpandedRuleBuilder.addRemoveTagRuleName(paramResource.getValue(((Integer)paramList1.next()).intValue()).getString());
    }
    paramList1 = paramRule.getAddMacroList().iterator();
    while (paramList1.hasNext()) {
      localExpandedRuleBuilder.addAddMacro((ExpandedFunctionCall)paramList2.get(((Integer)paramList1.next()).intValue()));
    }
    paramList1 = paramRule.getAddMacroRuleNameList().iterator();
    while (paramList1.hasNext()) {
      localExpandedRuleBuilder.addAddMacroRuleName(paramResource.getValue(((Integer)paramList1.next()).intValue()).getString());
    }
    paramList1 = paramRule.getRemoveMacroList().iterator();
    while (paramList1.hasNext()) {
      localExpandedRuleBuilder.addRemoveMacro((ExpandedFunctionCall)paramList2.get(((Integer)paramList1.next()).intValue()));
    }
    paramRule = paramRule.getRemoveMacroRuleNameList().iterator();
    while (paramRule.hasNext()) {
      localExpandedRuleBuilder.addRemoveMacroRuleName(paramResource.getValue(((Integer)paramRule.next()).intValue()).getString());
    }
    return localExpandedRuleBuilder.build();
  }
  
  private static TypeSystem.Value expandValue(int paramInt, Serving.Resource paramResource, TypeSystem.Value[] paramArrayOfValue, Set<Integer> paramSet)
    throws ResourceUtil.InvalidResourceException
  {
    if (paramSet.contains(Integer.valueOf(paramInt))) {
      logAndThrow("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
    }
    TypeSystem.Value localValue = (TypeSystem.Value)getWithBoundsCheck(paramResource.getValueList(), paramInt, "values");
    if (paramArrayOfValue[paramInt] != null) {
      return paramArrayOfValue[paramInt];
    }
    TypeSystem.Value.Builder localBuilder = null;
    paramSet.add(Integer.valueOf(paramInt));
    switch (localValue.getType())
    {
    default: 
      paramResource = localBuilder;
    }
    for (;;)
    {
      if (paramResource == null) {
        logAndThrow("Invalid value: " + localValue);
      }
      paramArrayOfValue[paramInt] = paramResource;
      paramSet.remove(Integer.valueOf(paramInt));
      return paramResource;
      localBuilder = newValueBuilderBasedOnValue(localValue);
      Object localObject = getServingValue(localValue).getListItemList().iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addListItem(expandValue(((Integer)((Iterator)localObject).next()).intValue(), paramResource, paramArrayOfValue, paramSet));
      }
      paramResource = localBuilder.build();
      continue;
      localBuilder = newValueBuilderBasedOnValue(localValue);
      localObject = getServingValue(localValue);
      if (((Serving.ServingValue)localObject).getMapKeyCount() != ((Serving.ServingValue)localObject).getMapValueCount()) {
        logAndThrow("Uneven map keys (" + ((Serving.ServingValue)localObject).getMapKeyCount() + ") and map values (" + ((Serving.ServingValue)localObject).getMapValueCount() + ")");
      }
      Iterator localIterator = ((Serving.ServingValue)localObject).getMapKeyList().iterator();
      while (localIterator.hasNext()) {
        localBuilder.addMapKey(expandValue(((Integer)localIterator.next()).intValue(), paramResource, paramArrayOfValue, paramSet));
      }
      localObject = ((Serving.ServingValue)localObject).getMapValueList().iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addMapValue(expandValue(((Integer)((Iterator)localObject).next()).intValue(), paramResource, paramArrayOfValue, paramSet));
      }
      paramResource = localBuilder.build();
      continue;
      localBuilder = newValueBuilderBasedOnValue(localValue);
      localObject = getServingValue(localValue);
      if (!((Serving.ServingValue)localObject).hasMacroNameReference()) {
        logAndThrow("Missing macro name reference");
      }
      for (paramResource = "";; paramResource = Types.valueToString(expandValue(((Serving.ServingValue)localObject).getMacroNameReference(), paramResource, paramArrayOfValue, paramSet)))
      {
        localBuilder.setMacroReference(paramResource);
        paramResource = localBuilder.build();
        break;
      }
      localBuilder = newValueBuilderBasedOnValue(localValue);
      localObject = getServingValue(localValue).getTemplateTokenList().iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addTemplateToken(expandValue(((Integer)((Iterator)localObject).next()).intValue(), paramResource, paramArrayOfValue, paramSet));
      }
      paramResource = localBuilder.build();
      continue;
      paramResource = localValue;
    }
  }
  
  public static ExpandedResource getExpandedResource(Serving.Resource paramResource)
    throws ResourceUtil.InvalidResourceException
  {
    Object localObject = new TypeSystem.Value[paramResource.getValueCount()];
    int i = 0;
    while (i < paramResource.getValueCount())
    {
      expandValue(i, paramResource, (TypeSystem.Value[])localObject, new HashSet(0));
      i += 1;
    }
    ExpandedResourceBuilder localExpandedResourceBuilder = ExpandedResource.newBuilder();
    ArrayList localArrayList1 = new ArrayList();
    i = 0;
    while (i < paramResource.getTagCount())
    {
      localArrayList1.add(expandFunctionCall(paramResource.getTag(i), paramResource, (TypeSystem.Value[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    i = 0;
    while (i < paramResource.getPredicateCount())
    {
      localArrayList2.add(expandFunctionCall(paramResource.getPredicate(i), paramResource, (TypeSystem.Value[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList3 = new ArrayList();
    i = 0;
    while (i < paramResource.getMacroCount())
    {
      ExpandedFunctionCall localExpandedFunctionCall = expandFunctionCall(paramResource.getMacro(i), paramResource, (TypeSystem.Value[])localObject, i);
      localExpandedResourceBuilder.addMacro(localExpandedFunctionCall);
      localArrayList3.add(localExpandedFunctionCall);
      i += 1;
    }
    localObject = paramResource.getRuleList().iterator();
    while (((Iterator)localObject).hasNext()) {
      localExpandedResourceBuilder.addRule(expandRule((Serving.Rule)((Iterator)localObject).next(), localArrayList1, localArrayList3, localArrayList2, paramResource));
    }
    localExpandedResourceBuilder.setVersion(paramResource.getVersion());
    localExpandedResourceBuilder.setResourceFormatVersion(paramResource.getResourceFormatVersion());
    return localExpandedResourceBuilder.build();
  }
  
  private static Serving.ServingValue getServingValue(TypeSystem.Value paramValue)
    throws ResourceUtil.InvalidResourceException
  {
    if (!paramValue.hasExtension(Serving.ServingValue.ext)) {
      logAndThrow("Expected a ServingValue and didn't get one. Value is: " + paramValue);
    }
    return (Serving.ServingValue)paramValue.getExtension(Serving.ServingValue.ext);
  }
  
  private static <T> T getWithBoundsCheck(List<T> paramList, int paramInt, String paramString)
    throws ResourceUtil.InvalidResourceException
  {
    if ((paramInt < 0) || (paramInt >= paramList.size())) {
      logAndThrow("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return (T)paramList.get(paramInt);
  }
  
  private static <T> T getWithBoundsCheck(T[] paramArrayOfT, int paramInt, String paramString)
    throws ResourceUtil.InvalidResourceException
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      logAndThrow("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  private static void logAndThrow(String paramString)
    throws ResourceUtil.InvalidResourceException
  {
    Log.e(paramString);
    throw new InvalidResourceException(paramString);
  }
  
  public static TypeSystem.Value.Builder newValueBuilderBasedOnValue(TypeSystem.Value paramValue)
  {
    TypeSystem.Value.Builder localBuilder = TypeSystem.Value.newBuilder().setType(paramValue.getType()).addAllEscaping(paramValue.getEscapingList());
    if (paramValue.getContainsReferences()) {
      localBuilder.setContainsReferences(true);
    }
    return localBuilder;
  }
  
  public static class ExpandedFunctionCall
  {
    private final Map<String, TypeSystem.Value> mPropertiesMap;
    
    private ExpandedFunctionCall(Map<String, TypeSystem.Value> paramMap)
    {
      this.mPropertiesMap = paramMap;
    }
    
    public static ResourceUtil.ExpandedFunctionCallBuilder newBuilder()
    {
      return new ResourceUtil.ExpandedFunctionCallBuilder(null);
    }
    
    public Map<String, TypeSystem.Value> getProperties()
    {
      return Collections.unmodifiableMap(this.mPropertiesMap);
    }
    
    public String toString()
    {
      return "Properties: " + getProperties();
    }
    
    public void updateCacheableProperty(String paramString, TypeSystem.Value paramValue)
    {
      this.mPropertiesMap.put(paramString, paramValue);
    }
  }
  
  public static class ExpandedFunctionCallBuilder
  {
    private final Map<String, TypeSystem.Value> mPropertiesMap = new HashMap();
    
    public ExpandedFunctionCallBuilder addProperty(String paramString, TypeSystem.Value paramValue)
    {
      this.mPropertiesMap.put(paramString, paramValue);
      return this;
    }
    
    public ResourceUtil.ExpandedFunctionCall build()
    {
      return new ResourceUtil.ExpandedFunctionCall(this.mPropertiesMap, null);
    }
  }
  
  public static class ExpandedResource
  {
    private final Map<String, List<ResourceUtil.ExpandedFunctionCall>> mMacros;
    private final int mResourceFormatVersion;
    private final List<ResourceUtil.ExpandedRule> mRules;
    private final String mVersion;
    
    private ExpandedResource(List<ResourceUtil.ExpandedRule> paramList, Map<String, List<ResourceUtil.ExpandedFunctionCall>> paramMap, String paramString, int paramInt)
    {
      this.mRules = Collections.unmodifiableList(paramList);
      this.mMacros = Collections.unmodifiableMap(paramMap);
      this.mVersion = paramString;
      this.mResourceFormatVersion = paramInt;
    }
    
    public static ResourceUtil.ExpandedResourceBuilder newBuilder()
    {
      return new ResourceUtil.ExpandedResourceBuilder(null);
    }
    
    public Map<String, List<ResourceUtil.ExpandedFunctionCall>> getAllMacros()
    {
      return this.mMacros;
    }
    
    public List<ResourceUtil.ExpandedFunctionCall> getMacros(String paramString)
    {
      return (List)this.mMacros.get(paramString);
    }
    
    public int getResourceFormatVersion()
    {
      return this.mResourceFormatVersion;
    }
    
    public List<ResourceUtil.ExpandedRule> getRules()
    {
      return this.mRules;
    }
    
    public String getVersion()
    {
      return this.mVersion;
    }
    
    public String toString()
    {
      return "Rules: " + getRules() + "  Macros: " + this.mMacros;
    }
  }
  
  public static class ExpandedResourceBuilder
  {
    private final Map<String, List<ResourceUtil.ExpandedFunctionCall>> mMacros = new HashMap();
    private final List<ResourceUtil.ExpandedFunctionCall> mPredicates = new ArrayList();
    private int mResourceFormatVersion = 0;
    private final List<ResourceUtil.ExpandedRule> mRules = new ArrayList();
    private final List<ResourceUtil.ExpandedFunctionCall> mTags = new ArrayList();
    private String mVersion = "";
    
    public ExpandedResourceBuilder addMacro(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      String str = Types.valueToString((TypeSystem.Value)paramExpandedFunctionCall.getProperties().get(Key.INSTANCE_NAME.toString()));
      List localList = (List)this.mMacros.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.mMacros.put(str, localObject);
      }
      ((List)localObject).add(paramExpandedFunctionCall);
      return this;
    }
    
    public ExpandedResourceBuilder addRule(ResourceUtil.ExpandedRule paramExpandedRule)
    {
      this.mRules.add(paramExpandedRule);
      return this;
    }
    
    public ResourceUtil.ExpandedResource build()
    {
      return new ResourceUtil.ExpandedResource(this.mRules, this.mMacros, this.mVersion, this.mResourceFormatVersion, null);
    }
    
    public ExpandedResourceBuilder setResourceFormatVersion(int paramInt)
    {
      this.mResourceFormatVersion = paramInt;
      return this;
    }
    
    public ExpandedResourceBuilder setVersion(String paramString)
    {
      this.mVersion = paramString;
      return this;
    }
  }
  
  public static class ExpandedRule
  {
    private final List<String> mAddMacroRuleNames;
    private final List<ResourceUtil.ExpandedFunctionCall> mAddMacros;
    private final List<String> mAddTagRuleNames;
    private final List<ResourceUtil.ExpandedFunctionCall> mAddTags;
    private final List<ResourceUtil.ExpandedFunctionCall> mNegativePredicates;
    private final List<ResourceUtil.ExpandedFunctionCall> mPositivePredicates;
    private final List<String> mRemoveMacroRuleNames;
    private final List<ResourceUtil.ExpandedFunctionCall> mRemoveMacros;
    private final List<String> mRemoveTagRuleNames;
    private final List<ResourceUtil.ExpandedFunctionCall> mRemoveTags;
    
    private ExpandedRule(List<ResourceUtil.ExpandedFunctionCall> paramList1, List<ResourceUtil.ExpandedFunctionCall> paramList2, List<ResourceUtil.ExpandedFunctionCall> paramList3, List<ResourceUtil.ExpandedFunctionCall> paramList4, List<ResourceUtil.ExpandedFunctionCall> paramList5, List<ResourceUtil.ExpandedFunctionCall> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.mPositivePredicates = Collections.unmodifiableList(paramList1);
      this.mNegativePredicates = Collections.unmodifiableList(paramList2);
      this.mAddTags = Collections.unmodifiableList(paramList3);
      this.mRemoveTags = Collections.unmodifiableList(paramList4);
      this.mAddMacros = Collections.unmodifiableList(paramList5);
      this.mRemoveMacros = Collections.unmodifiableList(paramList6);
      this.mAddMacroRuleNames = Collections.unmodifiableList(paramList7);
      this.mRemoveMacroRuleNames = Collections.unmodifiableList(paramList8);
      this.mAddTagRuleNames = Collections.unmodifiableList(paramList9);
      this.mRemoveTagRuleNames = Collections.unmodifiableList(paramList10);
    }
    
    public static ResourceUtil.ExpandedRuleBuilder newBuilder()
    {
      return new ResourceUtil.ExpandedRuleBuilder(null);
    }
    
    public List<String> getAddMacroRuleNames()
    {
      return this.mAddMacroRuleNames;
    }
    
    public List<ResourceUtil.ExpandedFunctionCall> getAddMacros()
    {
      return this.mAddMacros;
    }
    
    public List<String> getAddTagRuleNames()
    {
      return this.mAddTagRuleNames;
    }
    
    public List<ResourceUtil.ExpandedFunctionCall> getAddTags()
    {
      return this.mAddTags;
    }
    
    public List<ResourceUtil.ExpandedFunctionCall> getNegativePredicates()
    {
      return this.mNegativePredicates;
    }
    
    public List<ResourceUtil.ExpandedFunctionCall> getPositivePredicates()
    {
      return this.mPositivePredicates;
    }
    
    public List<String> getRemoveMacroRuleNames()
    {
      return this.mRemoveMacroRuleNames;
    }
    
    public List<ResourceUtil.ExpandedFunctionCall> getRemoveMacros()
    {
      return this.mRemoveMacros;
    }
    
    public List<String> getRemoveTagRuleNames()
    {
      return this.mRemoveTagRuleNames;
    }
    
    public List<ResourceUtil.ExpandedFunctionCall> getRemoveTags()
    {
      return this.mRemoveTags;
    }
    
    public String toString()
    {
      return "Positive predicates: " + getPositivePredicates() + "  Negative predicates: " + getNegativePredicates() + "  Add tags: " + getAddTags() + "  Remove tags: " + getRemoveTags() + "  Add macros: " + getAddMacros() + "  Remove macros: " + getRemoveMacros();
    }
  }
  
  public static class ExpandedRuleBuilder
  {
    private final List<String> mAddMacroRuleNames = new ArrayList();
    private final List<ResourceUtil.ExpandedFunctionCall> mAddMacros = new ArrayList();
    private final List<String> mAddTagRuleNames = new ArrayList();
    private final List<ResourceUtil.ExpandedFunctionCall> mAddTags = new ArrayList();
    private final List<ResourceUtil.ExpandedFunctionCall> mNegativePredicates = new ArrayList();
    private final List<ResourceUtil.ExpandedFunctionCall> mPositivePredicates = new ArrayList();
    private final List<String> mRemoveMacroRuleNames = new ArrayList();
    private final List<ResourceUtil.ExpandedFunctionCall> mRemoveMacros = new ArrayList();
    private final List<String> mRemoveTagRuleNames = new ArrayList();
    private final List<ResourceUtil.ExpandedFunctionCall> mRemoveTags = new ArrayList();
    
    public ExpandedRuleBuilder addAddMacro(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      this.mAddMacros.add(paramExpandedFunctionCall);
      return this;
    }
    
    public ExpandedRuleBuilder addAddMacroRuleName(String paramString)
    {
      this.mAddMacroRuleNames.add(paramString);
      return this;
    }
    
    public ExpandedRuleBuilder addAddTag(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      this.mAddTags.add(paramExpandedFunctionCall);
      return this;
    }
    
    public ExpandedRuleBuilder addAddTagRuleName(String paramString)
    {
      this.mAddTagRuleNames.add(paramString);
      return this;
    }
    
    public ExpandedRuleBuilder addNegativePredicate(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      this.mNegativePredicates.add(paramExpandedFunctionCall);
      return this;
    }
    
    public ExpandedRuleBuilder addPositivePredicate(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      this.mPositivePredicates.add(paramExpandedFunctionCall);
      return this;
    }
    
    public ExpandedRuleBuilder addRemoveMacro(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      this.mRemoveMacros.add(paramExpandedFunctionCall);
      return this;
    }
    
    public ExpandedRuleBuilder addRemoveMacroRuleName(String paramString)
    {
      this.mRemoveMacroRuleNames.add(paramString);
      return this;
    }
    
    public ExpandedRuleBuilder addRemoveTag(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      this.mRemoveTags.add(paramExpandedFunctionCall);
      return this;
    }
    
    public ExpandedRuleBuilder addRemoveTagRuleName(String paramString)
    {
      this.mRemoveTagRuleNames.add(paramString);
      return this;
    }
    
    public ResourceUtil.ExpandedRule build()
    {
      return new ResourceUtil.ExpandedRule(this.mPositivePredicates, this.mNegativePredicates, this.mAddTags, this.mRemoveTags, this.mAddMacros, this.mRemoveMacros, this.mAddMacroRuleNames, this.mRemoveMacroRuleNames, this.mAddTagRuleNames, this.mRemoveTagRuleNames, null);
    }
  }
  
  public static class InvalidResourceException
    extends Exception
  {
    public InvalidResourceException(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/ResourceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */