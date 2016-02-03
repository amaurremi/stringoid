package com.gtp.go.weather.sharephoto.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class m
{
  public int a;
  public int b;
  
  private static m a(JSONObject paramJSONObject)
  {
    m localm = new m();
    localm.a = paramJSONObject.getInt("type");
    localm.b = paramJSONObject.getInt("size");
    return localm;
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(paramJSONArray.getJSONObject(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */