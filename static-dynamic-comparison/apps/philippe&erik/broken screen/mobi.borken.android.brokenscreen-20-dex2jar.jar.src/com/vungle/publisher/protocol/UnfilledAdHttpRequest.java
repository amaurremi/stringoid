package com.vungle.publisher.protocol;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcelable.Creator;
import com.vungle.publisher.bc;
import com.vungle.publisher.be;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import com.vungle.publisher.protocol.message.RequestLocalAd.Factory;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class UnfilledAdHttpRequest
  extends ProtocolHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.c;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.j;
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<UnfilledAdHttpRequest>
  {
    @Inject
    UnfilledAdHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ProtocolHttpRequest.a<UnfilledAdHttpRequest>
  {
    @Inject
    bc f;
    @Inject
    RequestLocalAd.Factory g;
    
    public final UnfilledAdHttpRequest a(long paramLong)
    {
      UnfilledAdHttpRequest localUnfilledAdHttpRequest = (UnfilledAdHttpRequest)super.a();
      localUnfilledAdHttpRequest.b = (this.e + "unfilled");
      localUnfilledAdHttpRequest.b = Uri.parse(this.e + "unfilled").buildUpon().appendQueryParameter("app_id", this.d.b()).appendQueryParameter("isu", this.f.a()).appendQueryParameter("ut", String.valueOf(paramLong)).toString();
      return localUnfilledAdHttpRequest;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/UnfilledAdHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */