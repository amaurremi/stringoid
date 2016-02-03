package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.proto.Serving.Supplemental;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Runtime
{
  static final String DEFAULT_RULE_NAME = "Unknown";
  private static final ObjectAndStatic<TypeSystem.Value> DEFAULT_VALUE_AND_STATIC = new ObjectAndStatic(Types.getDefaultValue(), true);
  static final String EXPERIMENT_SUPPLEMENTAL_NAME_PREFIX = "gaExperiment:";
  private static final int MAX_CACHE_SIZE = 1048576;
  private final EventInfoDistributor eventInfoDistributor;
  private volatile String mCurrentEventName;
  private final DataLayer mDataLayer;
  private final Cache<ResourceUtil.ExpandedFunctionCall, ObjectAndStatic<TypeSystem.Value>> mFunctionCallCache;
  private final Cache<String, CachedMacro> mMacroEvaluationCache;
  private final Map<String, MacroInfo> mMacroLookup;
  private final Map<String, FunctionCallImplementation> mMacroMap;
  private final Map<String, FunctionCallImplementation> mPredicateMap;
  private final ResourceUtil.ExpandedResource mResource;
  private final Set<ResourceUtil.ExpandedRule> mRules;
  private final Map<String, FunctionCallImplementation> mTrackingTagMap;
  
  public Runtime(Context paramContext, ResourceUtil.ExpandedResource paramExpandedResource, DataLayer paramDataLayer, CustomFunctionCall.CustomEvaluator paramCustomEvaluator1, CustomFunctionCall.CustomEvaluator paramCustomEvaluator2)
  {
    this(paramContext, paramExpandedResource, paramDataLayer, paramCustomEvaluator1, paramCustomEvaluator2, new NoopEventInfoDistributor());
  }
  
  public Runtime(Context paramContext, ResourceUtil.ExpandedResource paramExpandedResource, DataLayer paramDataLayer, CustomFunctionCall.CustomEvaluator paramCustomEvaluator1, CustomFunctionCall.CustomEvaluator paramCustomEvaluator2, EventInfoDistributor paramEventInfoDistributor)
  {
    if (paramExpandedResource == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.mResource = paramExpandedResource;
    this.mRules = new HashSet(paramExpandedResource.getRules());
    this.mDataLayer = paramDataLayer;
    this.eventInfoDistributor = paramEventInfoDistributor;
    paramExpandedResource = new CacheFactory.CacheSizeManager()
    {
      public int sizeOf(ResourceUtil.ExpandedFunctionCall paramAnonymousExpandedFunctionCall, ObjectAndStatic<TypeSystem.Value> paramAnonymousObjectAndStatic)
      {
        return ((TypeSystem.Value)paramAnonymousObjectAndStatic.getObject()).getCachedSize();
      }
    };
    this.mFunctionCallCache = new CacheFactory().createCache(1048576, paramExpandedResource);
    paramExpandedResource = new CacheFactory.CacheSizeManager()
    {
      public int sizeOf(String paramAnonymousString, Runtime.CachedMacro paramAnonymousCachedMacro)
      {
        return paramAnonymousString.length() + paramAnonymousCachedMacro.getSize();
      }
    };
    this.mMacroEvaluationCache = new CacheFactory().createCache(1048576, paramExpandedResource);
    this.mTrackingTagMap = new HashMap();
    addTrackingTag(new ArbitraryPixelTag(paramContext));
    addTrackingTag(new CustomFunctionCall(paramCustomEvaluator2));
    addTrackingTag(new DataLayerWriteTag(paramDataLayer));
    addTrackingTag(new UniversalAnalyticsTag(paramContext, paramDataLayer));
    this.mPredicateMap = new HashMap();
    addPredicate(new ContainsPredicate());
    addPredicate(new EndsWithPredicate());
    addPredicate(new EqualsPredicate());
    addPredicate(new GreaterEqualsPredicate());
    addPredicate(new GreaterThanPredicate());
    addPredicate(new LessEqualsPredicate());
    addPredicate(new LessThanPredicate());
    addPredicate(new RegexPredicate());
    addPredicate(new StartsWithPredicate());
    this.mMacroMap = new HashMap();
    addMacro(new AdvertiserIdMacro(paramContext));
    addMacro(new AdvertisingTrackingEnabledMacro());
    addMacro(new AdwordsClickReferrerMacro(paramContext));
    addMacro(new AppIdMacro(paramContext));
    addMacro(new AppNameMacro(paramContext));
    addMacro(new AppVersionMacro(paramContext));
    addMacro(new ConstantMacro());
    addMacro(new ContainerVersionMacro(this));
    addMacro(new CustomFunctionCall(paramCustomEvaluator1));
    addMacro(new DataLayerMacro(paramDataLayer));
    addMacro(new DeviceIdMacro(paramContext));
    addMacro(new DeviceNameMacro());
    addMacro(new EncodeMacro());
    addMacro(new EventMacro(this));
    addMacro(new GtmVersionMacro());
    addMacro(new HashMacro());
    addMacro(new InstallReferrerMacro(paramContext));
    addMacro(new JoinerMacro());
    addMacro(new LanguageMacro());
    addMacro(new MobileAdwordsUniqueIdMacro(paramContext));
    addMacro(new OsVersionMacro());
    addMacro(new PlatformMacro());
    addMacro(new RandomMacro());
    addMacro(new RegexGroupMacro());
    addMacro(new ResolutionMacro(paramContext));
    addMacro(new RuntimeVersionMacro());
    addMacro(new SdkVersionMacro());
    addMacro(new TimeMacro());
    this.mMacroLookup = new HashMap();
    paramDataLayer = this.mRules.iterator();
    while (paramDataLayer.hasNext())
    {
      paramCustomEvaluator1 = (ResourceUtil.ExpandedRule)paramDataLayer.next();
      if (paramEventInfoDistributor.debugMode())
      {
        verifyFunctionAndNameListSizes(paramCustomEvaluator1.getAddMacros(), paramCustomEvaluator1.getAddMacroRuleNames(), "add macro");
        verifyFunctionAndNameListSizes(paramCustomEvaluator1.getRemoveMacros(), paramCustomEvaluator1.getRemoveMacroRuleNames(), "remove macro");
        verifyFunctionAndNameListSizes(paramCustomEvaluator1.getAddTags(), paramCustomEvaluator1.getAddTagRuleNames(), "add tag");
        verifyFunctionAndNameListSizes(paramCustomEvaluator1.getRemoveTags(), paramCustomEvaluator1.getRemoveTagRuleNames(), "remove tag");
      }
      int i = 0;
      while (i < paramCustomEvaluator1.getAddMacros().size())
      {
        paramCustomEvaluator2 = (ResourceUtil.ExpandedFunctionCall)paramCustomEvaluator1.getAddMacros().get(i);
        paramExpandedResource = "Unknown";
        paramContext = paramExpandedResource;
        if (paramEventInfoDistributor.debugMode())
        {
          paramContext = paramExpandedResource;
          if (i < paramCustomEvaluator1.getAddMacroRuleNames().size()) {
            paramContext = (String)paramCustomEvaluator1.getAddMacroRuleNames().get(i);
          }
        }
        paramExpandedResource = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(paramCustomEvaluator2));
        paramExpandedResource.addRule(paramCustomEvaluator1);
        paramExpandedResource.addAddMacroForRule(paramCustomEvaluator1, paramCustomEvaluator2);
        paramExpandedResource.addAddMacroRuleNameForRule(paramCustomEvaluator1, paramContext);
        i += 1;
      }
      i = 0;
      while (i < paramCustomEvaluator1.getRemoveMacros().size())
      {
        paramCustomEvaluator2 = (ResourceUtil.ExpandedFunctionCall)paramCustomEvaluator1.getRemoveMacros().get(i);
        paramExpandedResource = "Unknown";
        paramContext = paramExpandedResource;
        if (paramEventInfoDistributor.debugMode())
        {
          paramContext = paramExpandedResource;
          if (i < paramCustomEvaluator1.getRemoveMacroRuleNames().size()) {
            paramContext = (String)paramCustomEvaluator1.getRemoveMacroRuleNames().get(i);
          }
        }
        paramExpandedResource = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(paramCustomEvaluator2));
        paramExpandedResource.addRule(paramCustomEvaluator1);
        paramExpandedResource.addRemoveMacroForRule(paramCustomEvaluator1, paramCustomEvaluator2);
        paramExpandedResource.addRemoveMacroRuleNameForRule(paramCustomEvaluator1, paramContext);
        i += 1;
      }
    }
    paramContext = this.mResource.getAllMacros().entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramExpandedResource = (Map.Entry)paramContext.next();
      paramDataLayer = ((List)paramExpandedResource.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        paramCustomEvaluator1 = (ResourceUtil.ExpandedFunctionCall)paramDataLayer.next();
        if (!Types.valueToBoolean((TypeSystem.Value)paramCustomEvaluator1.getProperties().get(Key.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
          getOrAddMacroInfo(this.mMacroLookup, (String)paramExpandedResource.getKey()).setDefault(paramCustomEvaluator1);
        }
      }
    }
  }
  
  private static void addFunctionImplToMap(Map<String, FunctionCallImplementation> paramMap, FunctionCallImplementation paramFunctionCallImplementation)
  {
    if (paramMap.containsKey(paramFunctionCallImplementation.getInstanceFunctionId())) {
      throw new IllegalArgumentException("Duplicate function type name: " + paramFunctionCallImplementation.getInstanceFunctionId());
    }
    paramMap.put(paramFunctionCallImplementation.getInstanceFunctionId(), paramFunctionCallImplementation);
  }
  
  private ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateGenericToRun(Set<ResourceUtil.ExpandedRule> paramSet, Set<String> paramSet1, AddRemoveSetPopulator paramAddRemoveSetPopulator, RuleEvaluationStepInfoBuilder paramRuleEvaluationStepInfoBuilder)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    boolean bool = true;
    paramSet = paramSet.iterator();
    if (paramSet.hasNext())
    {
      ResourceUtil.ExpandedRule localExpandedRule = (ResourceUtil.ExpandedRule)paramSet.next();
      ResolvedRuleBuilder localResolvedRuleBuilder = paramRuleEvaluationStepInfoBuilder.createResolvedRuleBuilder();
      ObjectAndStatic localObjectAndStatic = evaluatePredicatesInRule(localExpandedRule, paramSet1, localResolvedRuleBuilder);
      if (((Boolean)localObjectAndStatic.getObject()).booleanValue()) {
        paramAddRemoveSetPopulator.rulePassed(localExpandedRule, localHashSet1, localHashSet2, localResolvedRuleBuilder);
      }
      if ((bool) && (localObjectAndStatic.isStatic())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    paramRuleEvaluationStepInfoBuilder.setEnabledFunctions(localHashSet1);
    return new ObjectAndStatic(localHashSet1, bool);
  }
  
  private ObjectAndStatic<TypeSystem.Value> evaluateMacroReferenceCycleDetection(String paramString, Set<String> paramSet, MacroEvaluationInfoBuilder paramMacroEvaluationInfoBuilder)
  {
    Object localObject = (CachedMacro)this.mMacroEvaluationCache.get(paramString);
    if ((localObject != null) && (!this.eventInfoDistributor.debugMode()))
    {
      pushUnevaluatedValueToDataLayer(((CachedMacro)localObject).getPushAfterEvaluate(), paramSet);
      return ((CachedMacro)localObject).getObjectAndStatic();
    }
    localObject = (MacroInfo)this.mMacroLookup.get(paramString);
    if (localObject == null)
    {
      Log.e("Invalid macro: " + paramString);
      return DEFAULT_VALUE_AND_STATIC;
    }
    ObjectAndStatic localObjectAndStatic = calculateMacrosToRun(paramString, ((MacroInfo)localObject).getRules(), ((MacroInfo)localObject).getAddMacros(), ((MacroInfo)localObject).getAddMacroRuleNames(), ((MacroInfo)localObject).getRemoveMacros(), ((MacroInfo)localObject).getRemoveMacroRuleNames(), paramSet, paramMacroEvaluationInfoBuilder.createRulesEvaluation());
    if (((Set)localObjectAndStatic.getObject()).isEmpty()) {}
    for (localObject = ((MacroInfo)localObject).getDefault(); localObject == null; localObject = (ResourceUtil.ExpandedFunctionCall)((Set)localObjectAndStatic.getObject()).iterator().next())
    {
      return DEFAULT_VALUE_AND_STATIC;
      if (((Set)localObjectAndStatic.getObject()).size() > 1) {
        Log.w("Multiple macros active for macroName " + paramString);
      }
    }
    paramMacroEvaluationInfoBuilder = executeFunction(this.mMacroMap, (ResourceUtil.ExpandedFunctionCall)localObject, paramSet, paramMacroEvaluationInfoBuilder.createResult());
    boolean bool;
    if ((localObjectAndStatic.isStatic()) && (paramMacroEvaluationInfoBuilder.isStatic()))
    {
      bool = true;
      if (paramMacroEvaluationInfoBuilder != DEFAULT_VALUE_AND_STATIC) {
        break label328;
      }
    }
    label328:
    for (paramMacroEvaluationInfoBuilder = DEFAULT_VALUE_AND_STATIC;; paramMacroEvaluationInfoBuilder = new ObjectAndStatic(paramMacroEvaluationInfoBuilder.getObject(), bool))
    {
      localObject = ((ResourceUtil.ExpandedFunctionCall)localObject).getPushAfterEvaluate();
      if (paramMacroEvaluationInfoBuilder.isStatic()) {
        this.mMacroEvaluationCache.put(paramString, new CachedMacro(paramMacroEvaluationInfoBuilder, (TypeSystem.Value)localObject));
      }
      pushUnevaluatedValueToDataLayer((TypeSystem.Value)localObject, paramSet);
      return paramMacroEvaluationInfoBuilder;
      bool = false;
      break;
    }
  }
  
  private ObjectAndStatic<TypeSystem.Value> executeFunction(Map<String, FunctionCallImplementation> paramMap, ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall, Set<String> paramSet, ResolvedFunctionCallBuilder paramResolvedFunctionCallBuilder)
  {
    Object localObject1 = (TypeSystem.Value)paramExpandedFunctionCall.getProperties().get(Key.FUNCTION.toString());
    if (localObject1 == null)
    {
      Log.e("No function id in properties");
      paramMap = DEFAULT_VALUE_AND_STATIC;
    }
    FunctionCallImplementation localFunctionCallImplementation;
    do
    {
      return paramMap;
      localObject1 = ((TypeSystem.Value)localObject1).functionId;
      localFunctionCallImplementation = (FunctionCallImplementation)paramMap.get(localObject1);
      if (localFunctionCallImplementation == null)
      {
        Log.e((String)localObject1 + " has no backing implementation.");
        return DEFAULT_VALUE_AND_STATIC;
      }
      paramMap = (ObjectAndStatic)this.mFunctionCallCache.get(paramExpandedFunctionCall);
    } while ((paramMap != null) && (!this.eventInfoDistributor.debugMode()));
    paramMap = new HashMap();
    int i = 1;
    Iterator localIterator = paramExpandedFunctionCall.getProperties().entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = paramResolvedFunctionCallBuilder.createResolvedPropertyBuilder((String)localEntry.getKey());
      localObject2 = macroExpandValue((TypeSystem.Value)localEntry.getValue(), paramSet, ((ResolvedPropertyBuilder)localObject2).createPropertyValueBuilder((TypeSystem.Value)localEntry.getValue()));
      if (localObject2 == DEFAULT_VALUE_AND_STATIC) {
        return DEFAULT_VALUE_AND_STATIC;
      }
      if (((ObjectAndStatic)localObject2).isStatic()) {
        paramExpandedFunctionCall.updateCacheableProperty((String)localEntry.getKey(), (TypeSystem.Value)((ObjectAndStatic)localObject2).getObject());
      }
      for (;;)
      {
        paramMap.put(localEntry.getKey(), ((ObjectAndStatic)localObject2).getObject());
        break;
        i = 0;
      }
    }
    if (!localFunctionCallImplementation.hasRequiredKeys(paramMap.keySet()))
    {
      Log.e("Incorrect keys for function " + (String)localObject1 + " required " + localFunctionCallImplementation.getRequiredKeys() + " had " + paramMap.keySet());
      return DEFAULT_VALUE_AND_STATIC;
    }
    if ((i != 0) && (localFunctionCallImplementation.isCacheable())) {}
    for (boolean bool = true;; bool = false)
    {
      paramMap = new ObjectAndStatic(localFunctionCallImplementation.evaluate(paramMap), bool);
      if (bool) {
        this.mFunctionCallCache.put(paramExpandedFunctionCall, paramMap);
      }
      paramResolvedFunctionCallBuilder.setFunctionResult((TypeSystem.Value)paramMap.getObject());
      return paramMap;
    }
  }
  
  private static String getFunctionName(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
  {
    return Types.valueToString((TypeSystem.Value)paramExpandedFunctionCall.getProperties().get(Key.INSTANCE_NAME.toString()));
  }
  
  private static MacroInfo getOrAddMacroInfo(Map<String, MacroInfo> paramMap, String paramString)
  {
    MacroInfo localMacroInfo2 = (MacroInfo)paramMap.get(paramString);
    MacroInfo localMacroInfo1 = localMacroInfo2;
    if (localMacroInfo2 == null)
    {
      localMacroInfo1 = new MacroInfo();
      paramMap.put(paramString, localMacroInfo1);
    }
    return localMacroInfo1;
  }
  
  private ObjectAndStatic<TypeSystem.Value> macroExpandValue(TypeSystem.Value paramValue, Set<String> paramSet, ValueBuilder paramValueBuilder)
  {
    if (!paramValue.containsReferences) {
      return new ObjectAndStatic(paramValue, true);
    }
    ObjectAndStatic localObjectAndStatic1;
    switch (paramValue.type)
    {
    case 5: 
    case 6: 
    default: 
      Log.e("Unknown type: " + paramValue.type);
      return DEFAULT_VALUE_AND_STATIC;
    case 2: 
      localValue = ResourceUtil.newValueBasedOnValue(paramValue);
      localValue.listItem = new TypeSystem.Value[paramValue.listItem.length];
      i = 0;
      while (i < paramValue.listItem.length)
      {
        localObjectAndStatic1 = macroExpandValue(paramValue.listItem[i], paramSet, paramValueBuilder.getListItem(i));
        if (localObjectAndStatic1 == DEFAULT_VALUE_AND_STATIC) {
          return DEFAULT_VALUE_AND_STATIC;
        }
        localValue.listItem[i] = ((TypeSystem.Value)localObjectAndStatic1.getObject());
        i += 1;
      }
      return new ObjectAndStatic(localValue, false);
    case 3: 
      localValue = ResourceUtil.newValueBasedOnValue(paramValue);
      if (paramValue.mapKey.length != paramValue.mapValue.length)
      {
        Log.e("Invalid serving value: " + paramValue.toString());
        return DEFAULT_VALUE_AND_STATIC;
      }
      localValue.mapKey = new TypeSystem.Value[paramValue.mapKey.length];
      localValue.mapValue = new TypeSystem.Value[paramValue.mapKey.length];
      i = 0;
      while (i < paramValue.mapKey.length)
      {
        localObjectAndStatic1 = macroExpandValue(paramValue.mapKey[i], paramSet, paramValueBuilder.getMapKey(i));
        ObjectAndStatic localObjectAndStatic2 = macroExpandValue(paramValue.mapValue[i], paramSet, paramValueBuilder.getMapValue(i));
        if ((localObjectAndStatic1 == DEFAULT_VALUE_AND_STATIC) || (localObjectAndStatic2 == DEFAULT_VALUE_AND_STATIC)) {
          return DEFAULT_VALUE_AND_STATIC;
        }
        localValue.mapKey[i] = ((TypeSystem.Value)localObjectAndStatic1.getObject());
        localValue.mapValue[i] = ((TypeSystem.Value)localObjectAndStatic2.getObject());
        i += 1;
      }
      return new ObjectAndStatic(localValue, false);
    case 4: 
      if (paramSet.contains(paramValue.macroReference))
      {
        Log.e("Macro cycle detected.  Current macro reference: " + paramValue.macroReference + "." + "  Previous macro references: " + paramSet.toString() + ".");
        return DEFAULT_VALUE_AND_STATIC;
      }
      paramSet.add(paramValue.macroReference);
      paramValueBuilder = ValueEscapeUtil.applyEscapings(evaluateMacroReferenceCycleDetection(paramValue.macroReference, paramSet, paramValueBuilder.createValueMacroEvaluationInfoExtension()), paramValue.escaping);
      paramSet.remove(paramValue.macroReference);
      return paramValueBuilder;
    }
    TypeSystem.Value localValue = ResourceUtil.newValueBasedOnValue(paramValue);
    localValue.templateToken = new TypeSystem.Value[paramValue.templateToken.length];
    int i = 0;
    while (i < paramValue.templateToken.length)
    {
      localObjectAndStatic1 = macroExpandValue(paramValue.templateToken[i], paramSet, paramValueBuilder.getTemplateToken(i));
      if (localObjectAndStatic1 == DEFAULT_VALUE_AND_STATIC) {
        return DEFAULT_VALUE_AND_STATIC;
      }
      localValue.templateToken[i] = ((TypeSystem.Value)localObjectAndStatic1.getObject());
      i += 1;
    }
    return new ObjectAndStatic(localValue, false);
  }
  
  private void pushUnevaluatedValueToDataLayer(TypeSystem.Value paramValue, Set<String> paramSet)
  {
    if (paramValue == null) {}
    for (;;)
    {
      return;
      paramValue = macroExpandValue(paramValue, paramSet, new NoopValueBuilder());
      if (paramValue != DEFAULT_VALUE_AND_STATIC)
      {
        paramValue = Types.valueToObject((TypeSystem.Value)paramValue.getObject());
        if ((paramValue instanceof Map))
        {
          paramValue = (Map)paramValue;
          this.mDataLayer.push(paramValue);
          return;
        }
        if (!(paramValue instanceof List)) {
          break;
        }
        paramValue = ((List)paramValue).iterator();
        while (paramValue.hasNext())
        {
          paramSet = paramValue.next();
          if ((paramSet instanceof Map))
          {
            paramSet = (Map)paramSet;
            this.mDataLayer.push(paramSet);
          }
          else
          {
            Log.w("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    Log.w("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void verifyFunctionAndNameListSizes(List<ResourceUtil.ExpandedFunctionCall> paramList, List<String> paramList1, String paramString)
  {
    if (paramList.size() != paramList1.size()) {
      Log.i("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
    }
  }
  
  @VisibleForTesting
  void addMacro(FunctionCallImplementation paramFunctionCallImplementation)
  {
    addFunctionImplToMap(this.mMacroMap, paramFunctionCallImplementation);
  }
  
  @VisibleForTesting
  void addPredicate(FunctionCallImplementation paramFunctionCallImplementation)
  {
    addFunctionImplToMap(this.mPredicateMap, paramFunctionCallImplementation);
  }
  
  @VisibleForTesting
  void addTrackingTag(FunctionCallImplementation paramFunctionCallImplementation)
  {
    addFunctionImplToMap(this.mTrackingTagMap, paramFunctionCallImplementation);
  }
  
  @VisibleForTesting
  ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateMacrosToRun(String paramString, Set<ResourceUtil.ExpandedRule> paramSet, final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> paramMap1, final Map<ResourceUtil.ExpandedRule, List<String>> paramMap2, final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> paramMap3, final Map<ResourceUtil.ExpandedRule, List<String>> paramMap4, Set<String> paramSet1, RuleEvaluationStepInfoBuilder paramRuleEvaluationStepInfoBuilder)
  {
    calculateGenericToRun(paramSet, paramSet1, new AddRemoveSetPopulator()
    {
      public void rulePassed(ResourceUtil.ExpandedRule paramAnonymousExpandedRule, Set<ResourceUtil.ExpandedFunctionCall> paramAnonymousSet1, Set<ResourceUtil.ExpandedFunctionCall> paramAnonymousSet2, ResolvedRuleBuilder paramAnonymousResolvedRuleBuilder)
      {
        List localList1 = (List)paramMap1.get(paramAnonymousExpandedRule);
        List localList2 = (List)paramMap2.get(paramAnonymousExpandedRule);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymousResolvedRuleBuilder.getAddedMacroFunctions().translateAndAddAll(localList1, localList2);
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymousExpandedRule);
        paramAnonymousExpandedRule = (List)paramMap4.get(paramAnonymousExpandedRule);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymousResolvedRuleBuilder.getRemovedMacroFunctions().translateAndAddAll(paramAnonymousSet1, paramAnonymousExpandedRule);
        }
      }
    }, paramRuleEvaluationStepInfoBuilder);
  }
  
  @VisibleForTesting
  ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateTagsToRun(Set<ResourceUtil.ExpandedRule> paramSet, RuleEvaluationStepInfoBuilder paramRuleEvaluationStepInfoBuilder)
  {
    calculateGenericToRun(paramSet, new HashSet(), new AddRemoveSetPopulator()
    {
      public void rulePassed(ResourceUtil.ExpandedRule paramAnonymousExpandedRule, Set<ResourceUtil.ExpandedFunctionCall> paramAnonymousSet1, Set<ResourceUtil.ExpandedFunctionCall> paramAnonymousSet2, ResolvedRuleBuilder paramAnonymousResolvedRuleBuilder)
      {
        paramAnonymousSet1.addAll(paramAnonymousExpandedRule.getAddTags());
        paramAnonymousSet2.addAll(paramAnonymousExpandedRule.getRemoveTags());
        paramAnonymousResolvedRuleBuilder.getAddedTagFunctions().translateAndAddAll(paramAnonymousExpandedRule.getAddTags(), paramAnonymousExpandedRule.getAddTagRuleNames());
        paramAnonymousResolvedRuleBuilder.getRemovedTagFunctions().translateAndAddAll(paramAnonymousExpandedRule.getRemoveTags(), paramAnonymousExpandedRule.getRemoveTagRuleNames());
      }
    }, paramRuleEvaluationStepInfoBuilder);
  }
  
  public ObjectAndStatic<TypeSystem.Value> evaluateMacroReference(String paramString)
  {
    EventInfoBuilder localEventInfoBuilder = this.eventInfoDistributor.createMacroEvalutionEventInfo(paramString);
    paramString = evaluateMacroReferenceCycleDetection(paramString, new HashSet(), localEventInfoBuilder.createMacroEvaluationInfoBuilder());
    localEventInfoBuilder.processEventInfo();
    return paramString;
  }
  
  @VisibleForTesting
  ObjectAndStatic<Boolean> evaluatePredicate(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall, Set<String> paramSet, ResolvedFunctionCallBuilder paramResolvedFunctionCallBuilder)
  {
    paramExpandedFunctionCall = executeFunction(this.mPredicateMap, paramExpandedFunctionCall, paramSet, paramResolvedFunctionCallBuilder);
    paramSet = Types.valueToBoolean((TypeSystem.Value)paramExpandedFunctionCall.getObject());
    paramResolvedFunctionCallBuilder.setFunctionResult(Types.objectToValue(paramSet));
    return new ObjectAndStatic(paramSet, paramExpandedFunctionCall.isStatic());
  }
  
  @VisibleForTesting
  ObjectAndStatic<Boolean> evaluatePredicatesInRule(ResourceUtil.ExpandedRule paramExpandedRule, Set<String> paramSet, ResolvedRuleBuilder paramResolvedRuleBuilder)
  {
    boolean bool = true;
    Object localObject = paramExpandedRule.getNegativePredicates().iterator();
    if (((Iterator)localObject).hasNext())
    {
      ObjectAndStatic localObjectAndStatic = evaluatePredicate((ResourceUtil.ExpandedFunctionCall)((Iterator)localObject).next(), paramSet, paramResolvedRuleBuilder.createNegativePredicate());
      if (((Boolean)localObjectAndStatic.getObject()).booleanValue())
      {
        paramResolvedRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(false)));
        return new ObjectAndStatic(Boolean.valueOf(false), localObjectAndStatic.isStatic());
      }
      if ((bool) && (localObjectAndStatic.isStatic())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    paramExpandedRule = paramExpandedRule.getPositivePredicates().iterator();
    if (paramExpandedRule.hasNext())
    {
      localObject = evaluatePredicate((ResourceUtil.ExpandedFunctionCall)paramExpandedRule.next(), paramSet, paramResolvedRuleBuilder.createPositivePredicate());
      if (!((Boolean)((ObjectAndStatic)localObject).getObject()).booleanValue())
      {
        paramResolvedRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(false)));
        return new ObjectAndStatic(Boolean.valueOf(false), ((ObjectAndStatic)localObject).isStatic());
      }
      if ((bool) && (((ObjectAndStatic)localObject).isStatic())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    paramResolvedRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(true)));
    return new ObjectAndStatic(Boolean.valueOf(true), bool);
  }
  
  public void evaluateTags(String paramString)
  {
    try
    {
      setCurrentEventName(paramString);
      paramString = this.eventInfoDistributor.createDataLayerEventEvaluationEventInfo(paramString);
      DataLayerEventEvaluationInfoBuilder localDataLayerEventEvaluationInfoBuilder = paramString.createDataLayerEventEvaluationInfoBuilder();
      Iterator localIterator = ((Set)calculateTagsToRun(this.mRules, localDataLayerEventEvaluationInfoBuilder.createRulesEvaluation()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        ResourceUtil.ExpandedFunctionCall localExpandedFunctionCall = (ResourceUtil.ExpandedFunctionCall)localIterator.next();
        executeFunction(this.mTrackingTagMap, localExpandedFunctionCall, new HashSet(), localDataLayerEventEvaluationInfoBuilder.createAndAddResult());
      }
      paramString.processEventInfo();
    }
    finally {}
    setCurrentEventName(null);
  }
  
  String getCurrentEventName()
  {
    try
    {
      String str = this.mCurrentEventName;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ResourceUtil.ExpandedResource getResource()
  {
    return this.mResource;
  }
  
  @VisibleForTesting
  void setCurrentEventName(String paramString)
  {
    try
    {
      this.mCurrentEventName = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setSupplementals(List<Serving.Supplemental> paramList)
  {
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        Serving.Supplemental localSupplemental = (Serving.Supplemental)paramList.next();
        if ((localSupplemental.name == null) || (!localSupplemental.name.startsWith("gaExperiment:"))) {
          Log.v("Ignored supplemental: " + localSupplemental);
        } else {
          ExperimentMacroHelper.handleExperimentSupplemental(this.mDataLayer, localSupplemental);
        }
      }
      finally {}
    }
  }
  
  static abstract interface AddRemoveSetPopulator
  {
    public abstract void rulePassed(ResourceUtil.ExpandedRule paramExpandedRule, Set<ResourceUtil.ExpandedFunctionCall> paramSet1, Set<ResourceUtil.ExpandedFunctionCall> paramSet2, ResolvedRuleBuilder paramResolvedRuleBuilder);
  }
  
  private static class CachedMacro
  {
    private ObjectAndStatic<TypeSystem.Value> mObjectAndStatic;
    private TypeSystem.Value mPushAfterEvaluate;
    
    public CachedMacro(ObjectAndStatic<TypeSystem.Value> paramObjectAndStatic)
    {
      this(paramObjectAndStatic, null);
    }
    
    public CachedMacro(ObjectAndStatic<TypeSystem.Value> paramObjectAndStatic, TypeSystem.Value paramValue)
    {
      this.mObjectAndStatic = paramObjectAndStatic;
      this.mPushAfterEvaluate = paramValue;
    }
    
    public ObjectAndStatic<TypeSystem.Value> getObjectAndStatic()
    {
      return this.mObjectAndStatic;
    }
    
    public TypeSystem.Value getPushAfterEvaluate()
    {
      return this.mPushAfterEvaluate;
    }
    
    public int getSize()
    {
      int j = ((TypeSystem.Value)this.mObjectAndStatic.getObject()).getCachedSize();
      if (this.mPushAfterEvaluate == null) {}
      for (int i = 0;; i = this.mPushAfterEvaluate.getCachedSize()) {
        return i + j;
      }
    }
  }
  
  private static class MacroInfo
  {
    private final Map<ResourceUtil.ExpandedRule, List<String>> mAddMacroNames = new HashMap();
    private final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> mAddMacros = new HashMap();
    private ResourceUtil.ExpandedFunctionCall mDefault;
    private final Map<ResourceUtil.ExpandedRule, List<String>> mRemoveMacroNames = new HashMap();
    private final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> mRemoveMacros = new HashMap();
    private final Set<ResourceUtil.ExpandedRule> mRules = new HashSet();
    
    public void addAddMacroForRule(ResourceUtil.ExpandedRule paramExpandedRule, ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      List localList = (List)this.mAddMacros.get(paramExpandedRule);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.mAddMacros.put(paramExpandedRule, localObject);
      }
      ((List)localObject).add(paramExpandedFunctionCall);
    }
    
    public void addAddMacroRuleNameForRule(ResourceUtil.ExpandedRule paramExpandedRule, String paramString)
    {
      List localList = (List)this.mAddMacroNames.get(paramExpandedRule);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.mAddMacroNames.put(paramExpandedRule, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void addRemoveMacroForRule(ResourceUtil.ExpandedRule paramExpandedRule, ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      List localList = (List)this.mRemoveMacros.get(paramExpandedRule);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.mRemoveMacros.put(paramExpandedRule, localObject);
      }
      ((List)localObject).add(paramExpandedFunctionCall);
    }
    
    public void addRemoveMacroRuleNameForRule(ResourceUtil.ExpandedRule paramExpandedRule, String paramString)
    {
      List localList = (List)this.mRemoveMacroNames.get(paramExpandedRule);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.mRemoveMacroNames.put(paramExpandedRule, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void addRule(ResourceUtil.ExpandedRule paramExpandedRule)
    {
      this.mRules.add(paramExpandedRule);
    }
    
    public Map<ResourceUtil.ExpandedRule, List<String>> getAddMacroRuleNames()
    {
      return this.mAddMacroNames;
    }
    
    public Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> getAddMacros()
    {
      return this.mAddMacros;
    }
    
    public ResourceUtil.ExpandedFunctionCall getDefault()
    {
      return this.mDefault;
    }
    
    public Map<ResourceUtil.ExpandedRule, List<String>> getRemoveMacroRuleNames()
    {
      return this.mRemoveMacroNames;
    }
    
    public Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> getRemoveMacros()
    {
      return this.mRemoveMacros;
    }
    
    public Set<ResourceUtil.ExpandedRule> getRules()
    {
      return this.mRules;
    }
    
    public void setDefault(ResourceUtil.ExpandedFunctionCall paramExpandedFunctionCall)
    {
      this.mDefault = paramExpandedFunctionCall;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/Runtime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */