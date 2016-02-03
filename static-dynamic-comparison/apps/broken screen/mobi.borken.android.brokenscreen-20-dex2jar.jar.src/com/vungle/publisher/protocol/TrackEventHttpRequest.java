package com.vungle.publisher.protocol;

import android.os.Parcelable.Creator;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpRequest;
import com.vungle.publisher.net.http.HttpRequest.Factory;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class TrackEventHttpRequest
  extends HttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  private static final HttpRequest.b e = HttpRequest.b.h;
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.a;
  }
  
  protected final HttpRequest.b b()
  {
    return e;
  }
  
  public final String toString()
  {
    return "{" + e + ": " + this.b + "}";
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<TrackEventHttpRequest>
  {
    @Inject
    TrackEventHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends HttpRequest.Factory<TrackEventHttpRequest>
  {
    protected static TrackEventHttpRequest a()
    {
      return new TrackEventHttpRequest();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackEventHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */