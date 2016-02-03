package com.google.ads.mediation;

import com.google.ads.util.b;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class MediationServerParameters
{
  protected void a() {}
  
  public void load(Map<String, String> paramMap)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = getClass().getFields();
    int j = localObject2.length;
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = localObject2[i];
      MediationServerParameters.Parameter localParameter = (MediationServerParameters.Parameter)((Field)localObject3).getAnnotation(MediationServerParameters.Parameter.class);
      if (localParameter != null) {
        ((Map)localObject1).put(localParameter.name(), localObject3);
      }
      i += 1;
    }
    if (((Map)localObject1).isEmpty()) {
      b.e("No server options fields detected.  To suppress this message either add a field with the @Parameter annotation, or override the load() method");
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (Map.Entry)paramMap.next();
      localObject3 = (Field)((Map)localObject1).remove(((Map.Entry)localObject2).getKey());
      if (localObject3 != null) {
        try
        {
          ((Field)localObject3).set(this, ((Map.Entry)localObject2).getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          b.b("Server Option '" + (String)((Map.Entry)localObject2).getKey() + "' could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          b.b("Server Option '" + (String)((Map.Entry)localObject2).getKey() + "' could not be set: Bad Type");
        }
      } else {
        b.e("Unexpected Server Option: " + (String)((Map.Entry)localObject2).getKey() + " = '" + (String)((Map.Entry)localObject2).getValue() + "'");
      }
    }
    paramMap = null;
    localObject1 = ((Map)localObject1).values().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Field)((Iterator)localObject1).next();
      if (!((MediationServerParameters.Parameter)((Field)localObject2).getAnnotation(MediationServerParameters.Parameter.class)).required()) {
        break label500;
      }
      b.b("Required Server Option missing: " + ((MediationServerParameters.Parameter)((Field)localObject2).getAnnotation(MediationServerParameters.Parameter.class)).name());
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramMap == null)
      {
        paramMap = "";
        label410:
        paramMap = paramMap + ((MediationServerParameters.Parameter)((Field)localObject2).getAnnotation(MediationServerParameters.Parameter.class)).name();
      }
    }
    label500:
    for (;;)
    {
      break;
      paramMap = paramMap + ", ";
      break label410;
      if (paramMap != null) {
        throw new MediationServerParameters.MappingException("Required Server Option(s) missing: " + paramMap);
      }
      a();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/mediation/MediationServerParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */