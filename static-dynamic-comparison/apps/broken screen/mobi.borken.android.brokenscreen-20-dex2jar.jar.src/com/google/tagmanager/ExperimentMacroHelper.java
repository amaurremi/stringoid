package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving.GaExperimentRandom;
import com.google.analytics.containertag.proto.Serving.GaExperimentSupplemental;
import com.google.analytics.containertag.proto.Serving.Supplemental;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

public class ExperimentMacroHelper
{
  private static void clearKeys(DataLayer paramDataLayer, Serving.GaExperimentSupplemental paramGaExperimentSupplemental)
  {
    paramGaExperimentSupplemental = paramGaExperimentSupplemental.valueToClear;
    int j = paramGaExperimentSupplemental.length;
    int i = 0;
    while (i < j)
    {
      paramDataLayer.clearPersistentKeysWithPrefix(Types.valueToString(paramGaExperimentSupplemental[i]));
      i += 1;
    }
  }
  
  public static void handleExperimentSupplemental(DataLayer paramDataLayer, Serving.Supplemental paramSupplemental)
  {
    if (paramSupplemental.experimentSupplemental == null)
    {
      Log.w("supplemental missing experimentSupplemental");
      return;
    }
    clearKeys(paramDataLayer, paramSupplemental.experimentSupplemental);
    pushValues(paramDataLayer, paramSupplemental.experimentSupplemental);
    setRandomValues(paramDataLayer, paramSupplemental.experimentSupplemental);
  }
  
  private static void pushValues(DataLayer paramDataLayer, Serving.GaExperimentSupplemental paramGaExperimentSupplemental)
  {
    paramGaExperimentSupplemental = paramGaExperimentSupplemental.valueToPush;
    int j = paramGaExperimentSupplemental.length;
    int i = 0;
    while (i < j)
    {
      Map localMap = valueToMap(paramGaExperimentSupplemental[i]);
      if (localMap != null) {
        paramDataLayer.push(localMap);
      }
      i += 1;
    }
  }
  
  private static void setRandomValues(DataLayer paramDataLayer, Serving.GaExperimentSupplemental paramGaExperimentSupplemental)
  {
    Serving.GaExperimentRandom[] arrayOfGaExperimentRandom = paramGaExperimentSupplemental.experimentRandom;
    int j = arrayOfGaExperimentRandom.length;
    int i = 0;
    while (i < j)
    {
      Serving.GaExperimentRandom localGaExperimentRandom = arrayOfGaExperimentRandom[i];
      if (localGaExperimentRandom.key == null)
      {
        Log.w("GaExperimentRandom: No key");
        i += 1;
      }
      else
      {
        Object localObject = paramDataLayer.get(localGaExperimentRandom.key);
        if (!(localObject instanceof Number))
        {
          paramGaExperimentSupplemental = null;
          label64:
          long l1 = localGaExperimentRandom.minRandom;
          long l2 = localGaExperimentRandom.maxRandom;
          if ((!localGaExperimentRandom.retainOriginalValue) || (paramGaExperimentSupplemental == null) || (paramGaExperimentSupplemental.longValue() < l1) || (paramGaExperimentSupplemental.longValue() > l2))
          {
            if (l1 > l2) {
              break label237;
            }
            localObject = Long.valueOf(Math.round(Math.random() * (l2 - l1) + l1));
          }
          paramDataLayer.clearPersistentKeysWithPrefix(localGaExperimentRandom.key);
          paramGaExperimentSupplemental = paramDataLayer.expandKeyValue(localGaExperimentRandom.key, localObject);
          if (localGaExperimentRandom.lifetimeInMilliseconds > 0L)
          {
            if (paramGaExperimentSupplemental.containsKey("gtm")) {
              break label245;
            }
            paramGaExperimentSupplemental.put("gtm", DataLayer.mapOf(new Object[] { "lifetime", Long.valueOf(localGaExperimentRandom.lifetimeInMilliseconds) }));
          }
        }
        for (;;)
        {
          paramDataLayer.push(paramGaExperimentSupplemental);
          break;
          paramGaExperimentSupplemental = Long.valueOf(((Number)localObject).longValue());
          break label64;
          label237:
          Log.w("GaExperimentRandom: random range invalid");
          break;
          label245:
          localObject = paramGaExperimentSupplemental.get("gtm");
          if ((localObject instanceof Map)) {
            ((Map)localObject).put("lifetime", Long.valueOf(localGaExperimentRandom.lifetimeInMilliseconds));
          } else {
            Log.w("GaExperimentRandom: gtm not a map");
          }
        }
      }
    }
  }
  
  private static Map<Object, Object> valueToMap(TypeSystem.Value paramValue)
  {
    paramValue = Types.valueToObject(paramValue);
    if (!(paramValue instanceof Map))
    {
      Log.w("value: " + paramValue + " is not a map value, ignored.");
      return null;
    }
    return (Map)paramValue;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/ExperimentMacroHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */