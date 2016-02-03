package com.vungle.publisher.protocol;

import android.os.Bundle;
import android.os.Parcelable.Creator;
import com.vungle.publisher.bo;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpRequest;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import com.vungle.publisher.protocol.message.RequestConfig;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
public class RequestConfigHttpRequest
  extends ProtocolHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  boolean e;
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.a;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.c;
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<RequestConfigHttpRequest>
  {
    @Inject
    RequestConfigHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ProtocolHttpRequest.a<RequestConfigHttpRequest>
  {
    @Inject
    RequestConfigHttpRequest f;
    @Inject
    RequestConfig g;
    
    public final RequestConfigHttpRequest d()
      throws bo
    {
      try
      {
        if (this.f.e) {
          return this.f;
        }
        RequestConfigHttpRequest localRequestConfigHttpRequest = (RequestConfigHttpRequest)super.a();
        localRequestConfigHttpRequest.b = (this.e + "config");
        localRequestConfigHttpRequest.c.putString("Content-Type", "application/json");
        localRequestConfigHttpRequest.d = this.g.a();
        return localRequestConfigHttpRequest;
      }
      catch (JSONException localJSONException)
      {
        throw new bo(localJSONException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */