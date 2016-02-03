package com.vungle.publisher.protocol;

import android.os.Bundle;
import android.os.Parcelable.Creator;
import com.vungle.publisher.bo;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpRequest;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import com.vungle.publisher.protocol.message.RequestLocalAd;
import com.vungle.publisher.protocol.message.RequestLocalAd.Factory;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

public final class RequestLocalAdHttpRequest
  extends ProtocolHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.a;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.d;
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<RequestLocalAdHttpRequest>
  {
    @Inject
    RequestLocalAdHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ProtocolHttpRequest.a<RequestLocalAdHttpRequest>
  {
    @Inject
    RequestLocalAd.Factory f;
    
    protected static RequestLocalAdHttpRequest e()
    {
      return new RequestLocalAdHttpRequest();
    }
    
    public final RequestLocalAdHttpRequest d()
      throws bo
    {
      try
      {
        RequestLocalAdHttpRequest localRequestLocalAdHttpRequest = (RequestLocalAdHttpRequest)super.a();
        localRequestLocalAdHttpRequest.b = (this.e + "requestAd");
        localRequestLocalAdHttpRequest.c.putString("Content-Type", "application/json");
        localRequestLocalAdHttpRequest.d = this.f.c().a();
        return localRequestLocalAdHttpRequest;
      }
      catch (JSONException localJSONException)
      {
        throw new bo(localJSONException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestLocalAdHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */