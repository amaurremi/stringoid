package com.vungle.publisher.protocol.message;

import com.vungle.publisher.env.SdkState;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

public final class RequestStreamingAd
  extends RequestAd<RequestStreamingAd>
{
  String e;
  
  public final JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject = super.b();
    localJSONObject.putOpt("campaignId", this.e);
    return localJSONObject;
  }
  
  @Singleton
  public static class Factory
    extends RequestAd.a<RequestStreamingAd>
  {
    @Inject
    SdkState e;
    
    public final RequestStreamingAd a(String paramString)
    {
      RequestStreamingAd localRequestStreamingAd = (RequestStreamingAd)super.b();
      localRequestStreamingAd.e = paramString;
      return localRequestStreamingAd;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestStreamingAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */