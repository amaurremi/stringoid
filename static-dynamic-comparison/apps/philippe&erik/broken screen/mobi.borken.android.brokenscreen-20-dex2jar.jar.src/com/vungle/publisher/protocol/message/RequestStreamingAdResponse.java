package com.vungle.publisher.protocol.message;

import com.vungle.publisher.bp;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

public final class RequestStreamingAdResponse
  extends RequestAdResponse
{
  public Boolean r;
  
  @Singleton
  public static class Factory
    extends RequestAdResponse.a<RequestStreamingAdResponse>
  {
    private RequestStreamingAdResponse c(JSONObject paramJSONObject)
      throws JSONException
    {
      Object localObject = null;
      if (paramJSONObject != null)
      {
        localObject = bp.a(paramJSONObject, "shouldStream");
        if (!Boolean.TRUE.equals(localObject)) {
          break label41;
        }
      }
      label41:
      for (paramJSONObject = (RequestStreamingAdResponse)super.b(paramJSONObject);; paramJSONObject = new RequestStreamingAdResponse())
      {
        paramJSONObject.r = ((Boolean)localObject);
        localObject = paramJSONObject;
        return (RequestStreamingAdResponse)localObject;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestStreamingAdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */