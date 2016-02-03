package com.vungle.publisher.protocol;

import android.os.Parcelable.Creator;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import com.vungle.publisher.protocol.message.SessionStart;
import com.vungle.publisher.protocol.message.SessionStart.Factory;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

public final class SessionStartHttpRequest
  extends ProtocolHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.c;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.g;
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<SessionStartHttpRequest>
  {
    @Inject
    SessionStartHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ProtocolHttpRequest.a<SessionStartHttpRequest>
  {
    @Inject
    SessionStart.Factory f;
    
    protected static SessionStartHttpRequest d()
    {
      return new SessionStartHttpRequest();
    }
    
    protected final SessionStartHttpRequest a(long paramLong)
      throws JSONException
    {
      SessionStartHttpRequest localSessionStartHttpRequest = (SessionStartHttpRequest)a();
      localSessionStartHttpRequest.b = (this.e + "sessionStart");
      localSessionStartHttpRequest.d = this.f.a(paramLong).a();
      return localSessionStartHttpRequest;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionStartHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */