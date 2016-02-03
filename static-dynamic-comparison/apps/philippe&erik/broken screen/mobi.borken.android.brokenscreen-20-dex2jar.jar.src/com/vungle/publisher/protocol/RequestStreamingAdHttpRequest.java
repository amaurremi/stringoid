package com.vungle.publisher.protocol;

import android.os.Bundle;
import android.os.Parcelable.Creator;
import com.vungle.publisher.bo;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpRequest;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import com.vungle.publisher.protocol.message.RequestStreamingAd;
import com.vungle.publisher.protocol.message.RequestStreamingAd.Factory;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

public final class RequestStreamingAdHttpRequest
  extends ProtocolHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.a;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.e;
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<RequestStreamingAdHttpRequest>
  {
    @Inject
    RequestStreamingAdHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ProtocolHttpRequest.a<RequestStreamingAdHttpRequest>
  {
    @Inject
    RequestStreamingAd.Factory f;
    
    protected static RequestStreamingAdHttpRequest d()
    {
      return new RequestStreamingAdHttpRequest();
    }
    
    public final RequestStreamingAdHttpRequest a(String paramString)
      throws bo
    {
      try
      {
        RequestStreamingAdHttpRequest localRequestStreamingAdHttpRequest = (RequestStreamingAdHttpRequest)super.a();
        localRequestStreamingAdHttpRequest.b = (this.e + "requestStreamingAd");
        localRequestStreamingAdHttpRequest.c.putString("Content-Type", "application/json");
        localRequestStreamingAdHttpRequest.d = this.f.a(paramString).a();
        return localRequestStreamingAdHttpRequest;
      }
      catch (JSONException paramString)
      {
        throw new bo(paramString);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestStreamingAdHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */