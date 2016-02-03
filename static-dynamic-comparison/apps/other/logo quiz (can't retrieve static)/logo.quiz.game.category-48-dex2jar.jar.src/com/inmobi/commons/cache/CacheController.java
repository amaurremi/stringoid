package com.inmobi.commons.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CacheController
{
  static Map<String, a> a = new HashMap();
  static a b = null;
  static boolean c = true;
  static Map<String, Validator> d = new HashMap();
  
  static void a()
  {
    Iterator localIterator = d.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
          getConfig(str, null, null, (Validator)d.get(str));
        }
      }
      catch (CommonsException localCommonsException) {}
    }
    if (b != null) {
      b.getData();
    }
  }
  
  private static void c()
  {
    InternalSDKUtil.getContext().registerReceiver(new a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  private static void d()
  {
    Log.internal("IMCOMMONS_3.7.1", "Bootstrapping cache.");
    LocalCache.initRoot();
    Iterator localIterator = LocalCache.getRoot().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        Object localObject = LocalCache.getRoot().get(str);
        if ((localObject instanceof JSONObject))
        {
          localObject = new a((JSONObject)localObject, new b(str));
          a locala = (a)a.get(str);
          if (locala != null)
          {
            ((a)localObject).a = locala.a;
            ((a)localObject).c = locala.c;
          }
          a.put(str, localObject);
        }
      }
      catch (JSONException localJSONException)
      {
        Log.internal("IMCOMMONS_3.7.1", "Unable to dump config from persistent memory to products in memory", localJSONException);
      }
    }
    if (b == null)
    {
      b = new a(LocalCache.getRoot(), new c());
      b.a(UIDUtil.getMap(InternalSDKUtil.getContext(), null), new d());
    }
    InternalSDKUtil.initialize(InternalSDKUtil.getContext());
  }
  
  public static ProductConfig getConfig(String paramString, Context paramContext, Map<String, String> paramMap, Validator paramValidator)
    throws CommonsException
  {
    if (paramValidator != null) {
      d.put(paramString, paramValidator);
    }
    if (c)
    {
      if (InternalSDKUtil.getContext() == null)
      {
        if (paramContext == null) {
          throw new CommonsException(1);
        }
        InternalSDKUtil.setContext(paramContext);
      }
      c = false;
      d();
      c();
    }
    b.a(null);
    paramString = (a)a.get(paramString);
    if (paramString == null) {
      throw new CommonsException(2);
    }
    paramString.a(paramMap, paramValidator);
    return paramString;
  }
  
  public static abstract interface Validator
  {
    public abstract String validate(String paramString);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent) {}
  }
  
  static final class b
    implements CacheController.e
  {
    b(String paramString) {}
    
    public void a()
    {
      try
      {
        a locala = (a)CacheController.a.get(this.a);
        if (locala == null) {
          return;
        }
        LocalCache.addToCache(this.a, locala.a());
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.internal("IMCOMMONS_3.7.1", "Unable to add json to persistent memory", localJSONException);
      }
    }
  }
  
  static final class c
    implements CacheController.e
  {
    public void a()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(CacheController.b.data);
        try
        {
          localJSONObject.put("timestamp", CacheController.b.timestamp);
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            Object localObject2 = (String)localIterator.next();
            try
            {
              Object localObject1 = LocalCache.getRoot().get((String)localObject2);
              if ((localObject1 instanceof JSONObject))
              {
                localObject2 = (a)CacheController.a.get(localObject2);
                if (localObject2 != null)
                {
                  ((JSONObject)localObject1).put("timestamp", 0);
                  ((JSONObject)localObject1).put("data", ((a)localObject2).data);
                }
              }
            }
            catch (Exception localException)
            {
              Log.debug("IMCOMMONS_3.7.1", "Error while merging data -> " + localException.getMessage());
            }
          }
          LocalCache.saveRoot(localJSONObject);
          CacheController.b();
          CacheController.a();
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;) {}
        }
        return;
      }
      catch (JSONException localJSONException1) {}
    }
  }
  
  static final class d
    implements CacheController.Validator
  {
    public String validate(String paramString)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        JSONObject localJSONObject2 = (JSONObject)localJSONObject1.get("common");
        paramString = new JSONObject();
        try
        {
          localJSONObject1 = (JSONObject)localJSONObject1.get("AND");
          paramString = localJSONObject1;
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        paramString = InternalSDKUtil.populateToNewJSON(paramString, localJSONObject2, true).toString();
        return paramString;
      }
      catch (Exception paramString) {}
      return null;
    }
  }
  
  static abstract interface e
  {
    public abstract void a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/cache/CacheController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */