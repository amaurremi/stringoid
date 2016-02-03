package com.gtp.go.weather.sharephoto.b;

import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n
{
  private int a;
  private List b = new ArrayList();
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("type", this.a);
      JSONObject localJSONObject2 = new JSONObject();
      if (this.a == 1)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put((String)localIterator.next());
        }
        localJSONException.put("packageNames", localJSONArray);
      }
    }
    catch (JSONException localJSONException)
    {
      if (c.a()) {
        localJSONException.printStackTrace();
      }
      return localJSONObject1;
    }
    localJSONObject1.put("usedDetail", localJSONException);
    return localJSONObject1;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(List paramList)
  {
    this.b = paramList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */