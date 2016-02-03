package com.vungle.publisher.protocol.message;

import com.vungle.publisher.by;
import com.vungle.publisher.log.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseJsonSerializable
  implements by
{
  protected static void a(String paramString, Object paramObject)
  {
    if (paramObject == null) {
      Logger.d("VungleProtocol", "null " + paramString + " is required output");
    }
  }
  
  public final String a()
    throws JSONException
  {
    JSONObject localJSONObject = b();
    if (localJSONObject == null) {
      return null;
    }
    return localJSONObject.toString();
  }
  
  public JSONObject b()
    throws JSONException
  {
    return new JSONObject();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/BaseJsonSerializable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */