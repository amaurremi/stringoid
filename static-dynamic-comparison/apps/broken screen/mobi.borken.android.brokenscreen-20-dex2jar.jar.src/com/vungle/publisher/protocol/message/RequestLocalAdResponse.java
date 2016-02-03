package com.vungle.publisher.protocol.message;

import com.vungle.publisher.bp;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

public final class RequestLocalAdResponse
  extends RequestAdResponse
{
  public Integer r;
  public Long s;
  public String t;
  public String u;
  public Integer v;
  public String w;
  
  @Singleton
  public static class Factory
    extends RequestAdResponse.a<RequestLocalAdResponse>
  {
    private RequestLocalAdResponse c(JSONObject paramJSONObject)
      throws JSONException
    {
      Object localObject = null;
      if (paramJSONObject != null)
      {
        if (paramJSONObject.isNull("sleep"))
        {
          RequestLocalAdResponse localRequestLocalAdResponse = (RequestLocalAdResponse)super.b(paramJSONObject);
          long l = paramJSONObject.optLong("expiry", -1L);
          if (l == -1L)
          {
            l = paramJSONObject.optLong("expiry", -2L);
            if (l == -2L) {}
          }
          for (localObject = Long.valueOf(l);; localObject = Long.valueOf(l))
          {
            localRequestLocalAdResponse.s = ((Long)localObject);
            a(paramJSONObject, "expiry", localObject);
            localRequestLocalAdResponse.t = bp.d(paramJSONObject, "postBundle");
            localRequestLocalAdResponse.u = bp.d(paramJSONObject, "preBundle");
            localRequestLocalAdResponse.v = bp.c(paramJSONObject, "size");
            localRequestLocalAdResponse.w = paramJSONObject.optString("md5");
            a(paramJSONObject, "md5", localRequestLocalAdResponse.w);
            return localRequestLocalAdResponse;
          }
        }
        localObject = new RequestLocalAdResponse();
        ((RequestLocalAdResponse)localObject).r = Integer.valueOf(paramJSONObject.getInt("sleep"));
        return (RequestLocalAdResponse)localObject;
      }
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestLocalAdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */