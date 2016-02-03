package twitter4j.internal.org.json;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class JSONArray
{
  private ArrayList myArrayList = new ArrayList();
  
  public JSONArray() {}
  
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
  
  public JSONArray(String paramString)
  {
    this(new JSONTokener(paramString));
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
  
  public JSONArray(JSONTokener paramJSONTokener)
  {
    this();
    if (paramJSONTokener.nextClean() != '[') {
      throw paramJSONTokener.syntaxError("A JSONArray text must start with '['");
    }
    if (paramJSONTokener.nextClean() != ']') {
      paramJSONTokener.back();
    }
    for (;;)
    {
      if (paramJSONTokener.nextClean() == ',')
      {
        paramJSONTokener.back();
        this.myArrayList.add(JSONObject.NULL);
      }
      for (;;)
      {
        switch (paramJSONTokener.nextClean())
        {
        default: 
          throw paramJSONTokener.syntaxError("Expected a ',' or ']'");
          paramJSONTokener.back();
          this.myArrayList.add(paramJSONTokener.nextValue());
        }
      }
      if (paramJSONTokener.nextClean() == ']') {
        return;
      }
      paramJSONTokener.back();
    }
  }
  
  public Object get(int paramInt)
  {
    Object localObject = opt(paramInt);
    if (localObject == null) {
      throw new JSONException("JSONArray[" + paramInt + "] not found.");
    }
    return localObject;
  }
  
  public boolean getBoolean(int paramInt)
  {
    Object localObject = get(paramInt);
    if ((localObject.equals(Boolean.FALSE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("false")))) {
      return false;
    }
    if ((localObject.equals(Boolean.TRUE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("true")))) {
      return true;
    }
    throw new JSONException("JSONArray[" + paramInt + "] is not a boolean.");
  }
  
  public double getDouble(int paramInt)
  {
    Object localObject = get(paramInt);
    try
    {
      if ((localObject instanceof Number)) {
        return ((Number)localObject).doubleValue();
      }
      double d = Double.parseDouble((String)localObject);
      return d;
    }
    catch (Exception localException)
    {
      throw new JSONException("JSONArray[" + paramInt + "] is not a number.");
    }
  }
  
  public int getInt(int paramInt)
  {
    Object localObject = get(paramInt);
    try
    {
      if ((localObject instanceof Number)) {
        return ((Number)localObject).intValue();
      }
      int i = Integer.parseInt((String)localObject);
      return i;
    }
    catch (Exception localException)
    {
      throw new JSONException("JSONArray[" + paramInt + "] is not a number.");
    }
  }
  
  public JSONArray getJSONArray(int paramInt)
  {
    Object localObject = get(paramInt);
    if ((localObject instanceof JSONArray)) {
      return (JSONArray)localObject;
    }
    throw new JSONException("JSONArray[" + paramInt + "] is not a JSONArray.");
  }
  
  public JSONObject getJSONObject(int paramInt)
  {
    Object localObject = get(paramInt);
    if ((localObject instanceof JSONObject)) {
      return (JSONObject)localObject;
    }
    throw new JSONException("JSONArray[" + paramInt + "] is not a JSONObject.");
  }
  
  public long getLong(int paramInt)
  {
    Object localObject = get(paramInt);
    try
    {
      if ((localObject instanceof Number)) {
        return ((Number)localObject).longValue();
      }
      long l = Long.parseLong((String)localObject);
      return l;
    }
    catch (Exception localException)
    {
      throw new JSONException("JSONArray[" + paramInt + "] is not a number.");
    }
  }
  
  public String getString(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == JSONObject.NULL) {
      return null;
    }
    return localObject.toString();
  }
  
  public boolean isNull(int paramInt)
  {
    return JSONObject.NULL.equals(opt(paramInt));
  }
  
  public String join(String paramString)
  {
    int j = length();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append(JSONObject.valueToString(this.myArrayList.get(i)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int length()
  {
    return this.myArrayList.size();
  }
  
  public Object opt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= length())) {
      return null;
    }
    return this.myArrayList.get(paramInt);
  }
  
  public JSONArray put(int paramInt)
  {
    put(new Integer(paramInt));
    return this;
  }
  
  public JSONArray put(int paramInt, double paramDouble)
  {
    put(paramInt, new Double(paramDouble));
    return this;
  }
  
  public JSONArray put(int paramInt1, int paramInt2)
  {
    put(paramInt1, new Integer(paramInt2));
    return this;
  }
  
  public JSONArray put(int paramInt, long paramLong)
  {
    put(paramInt, new Long(paramLong));
    return this;
  }
  
  public JSONArray put(int paramInt, Object paramObject)
  {
    JSONObject.testValidity(paramObject);
    if (paramInt < 0) {
      throw new JSONException("JSONArray[" + paramInt + "] not found.");
    }
    if (paramInt < length())
    {
      this.myArrayList.set(paramInt, paramObject);
      return this;
    }
    while (paramInt != length()) {
      put(JSONObject.NULL);
    }
    put(paramObject);
    return this;
  }
  
  public JSONArray put(int paramInt, Collection paramCollection)
  {
    put(paramInt, new JSONArray(paramCollection));
    return this;
  }
  
  public JSONArray put(int paramInt, Map paramMap)
  {
    put(paramInt, new JSONObject(paramMap));
    return this;
  }
  
  public JSONArray put(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      put(paramInt, localBoolean);
      return this;
    }
  }
  
  public JSONArray put(long paramLong)
  {
    put(new Long(paramLong));
    return this;
  }
  
  public JSONArray put(Object paramObject)
  {
    this.myArrayList.add(paramObject);
    return this;
  }
  
  public JSONArray put(Collection paramCollection)
  {
    put(new JSONArray(paramCollection));
    return this;
  }
  
  public JSONArray put(Map paramMap)
  {
    put(new JSONObject(paramMap));
    return this;
  }
  
  public JSONArray put(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      put(localBoolean);
      return this;
    }
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
  
  public String toString(int paramInt)
  {
    return toString(paramInt, 0);
  }
  
  String toString(int paramInt1, int paramInt2)
  {
    int k = 0;
    int m = length();
    if (m == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder("[");
    if (m == 1) {
      localStringBuilder.append(JSONObject.valueToString(this.myArrayList.get(0), paramInt1, paramInt2));
    }
    for (;;)
    {
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      int n = paramInt2 + paramInt1;
      localStringBuilder.append('\n');
      int i = 0;
      while (i < m)
      {
        if (i > 0) {
          localStringBuilder.append(",\n");
        }
        int j = 0;
        while (j < n)
        {
          localStringBuilder.append(' ');
          j += 1;
        }
        localStringBuilder.append(JSONObject.valueToString(this.myArrayList.get(i), paramInt1, n));
        i += 1;
      }
      localStringBuilder.append('\n');
      paramInt1 = k;
      while (paramInt1 < paramInt2)
      {
        localStringBuilder.append(' ');
        paramInt1 += 1;
      }
    }
  }
  
  public Writer write(Writer paramWriter)
  {
    for (int i = 0;; i = 1)
    {
      int j;
      Object localObject;
      try
      {
        int k = length();
        paramWriter.write(91);
        j = 0;
        if (j >= k) {
          break label106;
        }
        if (i != 0) {
          paramWriter.write(44);
        }
        localObject = this.myArrayList.get(j);
        if ((localObject instanceof JSONObject)) {
          ((JSONObject)localObject).write(paramWriter);
        } else if ((localObject instanceof JSONArray)) {
          ((JSONArray)localObject).write(paramWriter);
        }
      }
      catch (IOException paramWriter)
      {
        throw new JSONException(paramWriter);
      }
      paramWriter.write(JSONObject.valueToString(localObject));
      break label114;
      label106:
      paramWriter.write(93);
      return paramWriter;
      label114:
      j += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/org/json/JSONArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */