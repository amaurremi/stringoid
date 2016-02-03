package com.amazonaws.util.json;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JSONArray
{
  private ArrayList myArrayList = new ArrayList();
  
  public JSONArray() {}
  
  public JSONArray(JSONTokener paramJSONTokener)
  {
    this();
    int i = paramJSONTokener.nextClean();
    char c;
    if (i == 91)
    {
      c = ']';
      if (paramJSONTokener.nextClean() != ']') {
        break label47;
      }
    }
    label47:
    do
    {
      return;
      if (i == 40)
      {
        c = ')';
        break;
      }
      throw paramJSONTokener.syntaxError("A JSONArray text must start with '['");
      paramJSONTokener.back();
      for (;;)
      {
        if (paramJSONTokener.nextClean() == ',')
        {
          paramJSONTokener.back();
          this.myArrayList.add(null);
        }
        for (;;)
        {
          i = paramJSONTokener.nextClean();
          switch (i)
          {
          default: 
            throw paramJSONTokener.syntaxError("Expected a ',' or ']'");
            paramJSONTokener.back();
            this.myArrayList.add(paramJSONTokener.nextValue());
          }
        }
        if (paramJSONTokener.nextClean() == ']') {
          break;
        }
        paramJSONTokener.back();
      }
    } while (c == i);
    throw paramJSONTokener.syntaxError("Expected a '" + Character.valueOf(c) + "'");
  }
  
  public JSONArray(Object paramObject)
  {
    this();
    if (paramObject.getClass().isArray())
    {
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        put(JSONObject.wrap(Array.get(paramObject, i)));
        i += 1;
      }
    }
    throw new JSONException("JSONArray initial value should be a string or collection or array.");
  }
  
  public JSONArray(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        this.myArrayList.add(JSONObject.wrap(localObject));
      }
    }
  }
  
  public String join(String paramString)
  {
    int j = length();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuffer.append(paramString);
      }
      localStringBuffer.append(JSONObject.valueToString(this.myArrayList.get(i)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public int length()
  {
    return this.myArrayList.size();
  }
  
  public JSONArray put(Object paramObject)
  {
    this.myArrayList.add(paramObject);
    return this;
  }
  
  public String toString()
  {
    try
    {
      String str = '[' + join(",") + ']';
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/json/JSONArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */