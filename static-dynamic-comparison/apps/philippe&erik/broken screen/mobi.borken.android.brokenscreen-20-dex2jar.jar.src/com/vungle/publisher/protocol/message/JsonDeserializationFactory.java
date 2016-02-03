package com.vungle.publisher.protocol.message;

import com.vungle.publisher.log.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsonDeserializationFactory<T>
  extends MessageFactory<T>
{
  protected static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      paramJSONObject = paramJSONObject.opt(paramString);
      if (paramJSONObject == null) {
        Logger.d("VungleProtocol", "null " + paramString + " is required input");
      }
    }
    do
    {
      return;
      Logger.d("VungleProtocol", "invalid " + paramString + ": " + paramJSONObject);
      return;
      if (((paramObject instanceof String)) && (((String)paramObject).length() == 0))
      {
        Logger.d("VungleProtocol", "empty " + paramString + " is required input");
        return;
      }
    } while ((!(paramObject instanceof JSONArray)) || (((JSONArray)paramObject).length() != 0));
    Logger.d("VungleProtocol", "empty array " + paramString + " is required input");
  }
  
  public final T a(String paramString)
    throws JSONException
  {
    if (paramString == null) {
      return null;
    }
    return (T)a(new JSONObject(paramString));
  }
  
  protected abstract T a(JSONObject paramJSONObject)
    throws JSONException;
  
  protected final T[] a(JSONArray paramJSONArray)
    throws JSONException
  {
    Object localObject = null;
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      Object[] arrayOfObject = a(j);
      int i = 0;
      for (;;)
      {
        localObject = arrayOfObject;
        if (i >= j) {
          break;
        }
        arrayOfObject[i] = a(paramJSONArray.optJSONObject(i));
        i += 1;
      }
    }
    return (T[])localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/JsonDeserializationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */