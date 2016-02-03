package com.vungle.publisher.protocol.message;

import com.vungle.publisher.be;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
public class RequestConfig
  extends BaseJsonSerializable
{
  @Inject
  be a;
  
  public final JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject = super.b();
    localJSONObject.putOpt("pubAppId", this.a.b());
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */