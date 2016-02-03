package com.bluebird.mobile.tools.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class SharedPreferencesUtils
{
  public static ArrayList<String> getStringArrayPref(Context paramContext, String paramString)
  {
    return getStringArrayPref(PreferenceManager.getDefaultSharedPreferences(paramContext), paramString);
  }
  
  public static ArrayList<String> getStringArrayPref(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramString = paramSharedPreferences.getString(paramString, null);
    paramSharedPreferences = new ArrayList();
    if (paramString != null) {
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          paramSharedPreferences.add(paramString.optString(i));
          i += 1;
        }
        return paramSharedPreferences;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void setStringArrayPref(Context paramContext, String paramString, List<String> paramList)
  {
    setStringArrayPref(PreferenceManager.getDefaultSharedPreferences(paramContext), paramString, paramList);
  }
  
  public static void setStringArrayPref(SharedPreferences paramSharedPreferences, String paramString, List<String> paramList)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((String)localIterator.next());
    }
    if (!paramList.isEmpty()) {
      paramSharedPreferences.putString(paramString, localJSONArray.toString());
    }
    for (;;)
    {
      paramSharedPreferences.commit();
      return;
      paramSharedPreferences.putString(paramString, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/storage/SharedPreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */