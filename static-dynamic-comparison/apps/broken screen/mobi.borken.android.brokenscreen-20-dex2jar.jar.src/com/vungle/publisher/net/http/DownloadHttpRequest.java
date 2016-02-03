package com.vungle.publisher.net.http;

import android.os.Parcelable.Creator;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class DownloadHttpRequest
  extends HttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.a;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.a;
  }
  
  public final String toString()
  {
    return "{" + HttpRequest.b.a + ": " + this.b + "}";
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<DownloadHttpRequest>
  {
    @Inject
    DownloadHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends HttpRequest.Factory<DownloadHttpRequest>
  {
    protected static DownloadHttpRequest a()
    {
      return new DownloadHttpRequest();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */