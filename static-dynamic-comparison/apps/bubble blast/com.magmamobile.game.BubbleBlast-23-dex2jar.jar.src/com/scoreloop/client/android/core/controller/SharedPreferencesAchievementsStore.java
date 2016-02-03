package com.scoreloop.client.android.core.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SharedPreferencesAchievementsStore
  implements AchievementsStore
{
  private Context a;
  private String b;
  
  public SharedPreferencesAchievementsStore(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private String e()
  {
    return "com.scoreloop.achievements.store_" + b();
  }
  
  private String f()
  {
    return e() + "_sync";
  }
  
  private String g()
  {
    return e() + "_data";
  }
  
  public JSONObject a(String paramString)
  {
    paramString = this.a.getSharedPreferences(g(), 0).getString(paramString, null);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences(g(), 0).edit();
    localEditor.putString(paramString, paramJSONObject.toString());
    localEditor.commit();
    localEditor = this.a.getSharedPreferences(f(), 0).edit();
    localEditor.putBoolean(paramString, paramJSONObject.optBoolean("needs_sync"));
    localEditor.commit();
  }
  
  public boolean a()
  {
    return this.a.getSharedPreferences(e(), 0).getBoolean("did_query_server", false);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public List<JSONObject> c()
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences(f(), 0);
    Object localObject1 = localSharedPreferences.getAll();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      if (localSharedPreferences.getBoolean((String)localObject2, false))
      {
        localObject2 = a((String)localObject2);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  public void d()
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences(e(), 0).edit();
    localEditor.putBoolean("did_query_server", true);
    localEditor.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/SharedPreferencesAchievementsStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */