package com.pocket.f;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static JSONObject a(a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(c.R, parama.a());
      localJSONObject.put(c.S, parama.b());
      localJSONObject.put(c.T, parama.c());
      localJSONObject.put(c.U, parama.d());
      localJSONObject.put(c.V, parama.e());
      localJSONObject.put(c.O, parama.g());
      localJSONObject.put(c.X, parama.h());
      localJSONObject.put(c.W, parama.f());
      localJSONObject.put(c.Y, parama.i());
      return localJSONObject;
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(ArrayList paramArrayList)
  {
    JSONArray localJSONArray = b(paramArrayList);
    paramArrayList = new JSONObject();
    try
    {
      paramArrayList.put(c.a, c.c);
      paramArrayList.put(c.E, localJSONArray);
      return paramArrayList;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramArrayList;
  }
  
  private static JSONArray b(ArrayList paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localJSONArray.put(a((a)paramArrayList.next()));
      }
    }
    return localJSONArray;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */