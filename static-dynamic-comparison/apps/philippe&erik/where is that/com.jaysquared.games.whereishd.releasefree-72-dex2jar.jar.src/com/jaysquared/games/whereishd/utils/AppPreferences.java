package com.jaysquared.games.whereishd.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class AppPreferences
{
  private static final String APP_SHARED_PREFS = "com.jaysquared.sharedpreferences";
  private final SharedPreferences appSharedPrefs;
  private final SharedPreferences.Editor prefsEditor;
  
  public AppPreferences(Context paramContext)
  {
    this.appSharedPrefs = paramContext.getSharedPreferences("com.jaysquared.sharedpreferences", 0);
    this.prefsEditor = this.appSharedPrefs.edit();
  }
  
  public ArrayList<String> getMember()
  {
    localArrayList = new ArrayList();
    Object localObject = this.appSharedPrefs.getString("member", null);
    if (localObject != null) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(((JSONArray)localObject).optString(i));
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void removePreferences()
  {
    this.prefsEditor.remove("member");
    this.prefsEditor.commit();
  }
  
  public void setMember(ArrayList<String> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localJSONArray.put(paramArrayList.get(i));
      i += 1;
    }
    if (!paramArrayList.isEmpty()) {
      this.prefsEditor.putString("member", localJSONArray.toString());
    }
    for (;;)
    {
      this.prefsEditor.commit();
      return;
      this.prefsEditor.putString("member", null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/AppPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */