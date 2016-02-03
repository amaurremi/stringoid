package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class UniversalAnalyticsTag
  extends TrackingTag
{
  private static final String ACCOUNT;
  private static final String ANALYTICS_FIELDS = Key.ANALYTICS_FIELDS.toString();
  private static final String ANALYTICS_PASS_THROUGH;
  private static final String DEFAULT_TRACKING_ID = "_GTM_DEFAULT_TRACKER_";
  private static final String ID = FunctionType.UNIVERSAL_ANALYTICS.toString();
  private static final String TRACK_TRANSACTION = Key.TRACK_TRANSACTION.toString();
  private static final String TRANSACTION_DATALAYER_MAP = Key.TRANSACTION_DATALAYER_MAP.toString();
  private static final String TRANSACTION_ITEM_DATALAYER_MAP = Key.TRANSACTION_ITEM_DATALAYER_MAP.toString();
  private static Map<String, String> defaultItemMap;
  private static Map<String, String> defaultTransactionMap;
  private final DataLayer mDataLayer;
  private final TrackerProvider mTrackerProvider;
  private final Set<String> mTurnOffAnonymizeIpValues;
  
  static
  {
    ACCOUNT = Key.ACCOUNT.toString();
    ANALYTICS_PASS_THROUGH = Key.ANALYTICS_PASS_THROUGH.toString();
  }
  
  public UniversalAnalyticsTag(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new TrackerProvider(paramContext));
  }
  
  @VisibleForTesting
  UniversalAnalyticsTag(Context paramContext, DataLayer paramDataLayer, TrackerProvider paramTrackerProvider)
  {
    super(ID, new String[0]);
    this.mDataLayer = paramDataLayer;
    this.mTrackerProvider = paramTrackerProvider;
    this.mTurnOffAnonymizeIpValues = new HashSet();
    this.mTurnOffAnonymizeIpValues.add("");
    this.mTurnOffAnonymizeIpValues.add("0");
    this.mTurnOffAnonymizeIpValues.add("false");
  }
  
  private void addParam(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private boolean checkBooleanProperty(Map<String, TypeSystem.Value> paramMap, String paramString)
  {
    paramMap = (TypeSystem.Value)paramMap.get(paramString);
    if (paramMap == null) {
      return false;
    }
    return Types.valueToBoolean(paramMap).booleanValue();
  }
  
  private Map<String, String> convertToGaFields(TypeSystem.Value paramValue)
  {
    if (paramValue == null) {
      paramValue = new HashMap();
    }
    Map localMap;
    String str;
    do
    {
      do
      {
        return paramValue;
        localMap = valueToMap(paramValue);
        if (localMap == null) {
          return new HashMap();
        }
        str = (String)localMap.get("&aip");
        paramValue = localMap;
      } while (str == null);
      paramValue = localMap;
    } while (!this.mTurnOffAnonymizeIpValues.contains(str.toLowerCase()));
    localMap.remove("&aip");
    return localMap;
  }
  
  private String getDataLayerString(String paramString)
  {
    paramString = this.mDataLayer.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  private Map<String, String> getTransactionFields(Map<String, TypeSystem.Value> paramMap)
  {
    paramMap = (TypeSystem.Value)paramMap.get(TRANSACTION_DATALAYER_MAP);
    if (paramMap != null) {
      return valueToMap(paramMap);
    }
    if (defaultTransactionMap == null)
    {
      paramMap = new HashMap();
      paramMap.put("transactionId", "&ti");
      paramMap.put("transactionAffiliation", "&ta");
      paramMap.put("transactionTax", "&tt");
      paramMap.put("transactionShipping", "&ts");
      paramMap.put("transactionTotal", "&tr");
      paramMap.put("transactionCurrency", "&cu");
      defaultTransactionMap = paramMap;
    }
    return defaultTransactionMap;
  }
  
  private Map<String, String> getTransactionItemFields(Map<String, TypeSystem.Value> paramMap)
  {
    paramMap = (TypeSystem.Value)paramMap.get(TRANSACTION_ITEM_DATALAYER_MAP);
    if (paramMap != null) {
      return valueToMap(paramMap);
    }
    if (defaultItemMap == null)
    {
      paramMap = new HashMap();
      paramMap.put("name", "&in");
      paramMap.put("sku", "&ic");
      paramMap.put("category", "&iv");
      paramMap.put("price", "&ip");
      paramMap.put("quantity", "&iq");
      paramMap.put("currency", "&cu");
      defaultItemMap = paramMap;
    }
    return defaultItemMap;
  }
  
  private List<Map<String, String>> getTransactionItems()
  {
    Object localObject = this.mDataLayer.get("transactionProducts");
    if (localObject == null) {
      return null;
    }
    if (!(localObject instanceof List)) {
      throw new IllegalArgumentException("transactionProducts should be of type List.");
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof Map)) {
        throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
    }
    return (List)localObject;
  }
  
  private void sendTransaction(Tracker paramTracker, Map<String, TypeSystem.Value> paramMap)
  {
    String str = getDataLayerString("transactionId");
    if (str == null) {
      Log.e("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = convertToGaFields((TypeSystem.Value)paramMap.get(ANALYTICS_FIELDS));
        ((Map)localObject1).put("&t", "transaction");
        localObject2 = getTransactionFields(paramMap).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          addParam((Map)localObject1, (String)((Map.Entry)localObject3).getValue(), getDataLayerString((String)((Map.Entry)localObject3).getKey()));
        }
        localLinkedList.add(localObject1);
      }
      catch (IllegalArgumentException paramTracker)
      {
        Log.e("Unable to send transaction", paramTracker);
        return;
      }
      Object localObject1 = getTransactionItems();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map)((Iterator)localObject1).next();
          if (((Map)localObject2).get("name") == null)
          {
            Log.e("Unable to send transaction item hit due to missing 'name' field.");
            return;
          }
          localObject3 = convertToGaFields((TypeSystem.Value)paramMap.get(ANALYTICS_FIELDS));
          ((Map)localObject3).put("&t", "item");
          ((Map)localObject3).put("&ti", str);
          Iterator localIterator = getTransactionItemFields(paramMap).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            addParam((Map)localObject3, (String)localEntry.getValue(), (String)((Map)localObject2).get(localEntry.getKey()));
          }
          localLinkedList.add(localObject3);
        }
      }
      paramMap = localLinkedList.iterator();
      while (paramMap.hasNext()) {
        paramTracker.send((Map)paramMap.next());
      }
    }
  }
  
  private Map<String, String> valueToMap(TypeSystem.Value paramValue)
  {
    paramValue = Types.valueToObject(paramValue);
    if (!(paramValue instanceof Map))
    {
      paramValue = null;
      return paramValue;
    }
    paramValue = (Map)paramValue;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramValue.entrySet().iterator();
    for (;;)
    {
      paramValue = localLinkedHashMap;
      if (!localIterator.hasNext()) {
        break;
      }
      paramValue = (Map.Entry)localIterator.next();
      localLinkedHashMap.put(paramValue.getKey().toString(), paramValue.getValue().toString());
    }
  }
  
  public void evaluateTrackingTag(Map<String, TypeSystem.Value> paramMap)
  {
    Tracker localTracker = this.mTrackerProvider.getTracker("_GTM_DEFAULT_TRACKER_");
    if (checkBooleanProperty(paramMap, ANALYTICS_PASS_THROUGH)) {
      localTracker.send(convertToGaFields((TypeSystem.Value)paramMap.get(ANALYTICS_FIELDS)));
    }
    for (;;)
    {
      this.mTrackerProvider.close(localTracker);
      return;
      if (checkBooleanProperty(paramMap, TRACK_TRANSACTION)) {
        sendTransaction(localTracker, paramMap);
      } else {
        Log.w("Ignoring unknown tag.");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/UniversalAnalyticsTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */