package com.vungle.publisher.protocol;

import android.os.Parcelable.Creator;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import com.vungle.publisher.protocol.message.SessionEnd;
import com.vungle.publisher.protocol.message.SessionEnd.Factory;
import com.vungle.publisher.protocol.message.SessionStart;
import com.vungle.publisher.protocol.message.SessionStart.Factory;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

public final class SessionEndHttpRequest
  extends ProtocolHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.c;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.f;
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<SessionEndHttpRequest>
  {
    @Inject
    SessionEndHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ProtocolHttpRequest.a<SessionEndHttpRequest>
  {
    @Inject
    SessionEnd.Factory f;
    
    protected static SessionEndHttpRequest d()
    {
      return new SessionEndHttpRequest();
    }
    
    protected final SessionEndHttpRequest a(long paramLong1, long paramLong2)
      throws JSONException
    {
      SessionEndHttpRequest localSessionEndHttpRequest = (SessionEndHttpRequest)a();
      localSessionEndHttpRequest.b = (this.e + "sessionEnd");
      SessionStart localSessionStart = this.f.a.a(paramLong1);
      SessionEnd localSessionEnd = SessionEnd.Factory.a();
      localSessionEnd.b = localSessionStart;
      localSessionEnd.a = Long.valueOf(paramLong2);
      localSessionEndHttpRequest.d = localSessionEnd.a();
      return localSessionEndHttpRequest;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionEndHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */