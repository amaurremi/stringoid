package com.vungle.publisher.protocol;

import android.os.Bundle;
import com.vungle.publisher.bd;
import com.vungle.publisher.be;
import com.vungle.publisher.inject.annotations.VungleBaseUrl;
import com.vungle.publisher.net.http.HttpRequest;
import com.vungle.publisher.net.http.HttpRequest.Factory;
import javax.inject.Inject;

public abstract class ProtocolHttpRequest
  extends HttpRequest
{
  public static abstract class a<T extends ProtocolHttpRequest>
    extends HttpRequest.Factory<T>
  {
    @Inject
    bd c;
    @Inject
    be d;
    @VungleBaseUrl
    @Inject
    String e;
    
    protected T a()
    {
      ProtocolHttpRequest localProtocolHttpRequest = (ProtocolHttpRequest)super.c();
      Bundle localBundle = localProtocolHttpRequest.c;
      localBundle.putString("X-VUNGLE-BUNDLE-ID", this.d.a());
      localBundle.putString("X-VUNGLE-LANGUAGE", this.c.a());
      localBundle.putString("X-VUNGLE-TIMEZONE", this.c.b());
      if (ProtocolHttpRequest.a(localProtocolHttpRequest)) {
        localBundle.putLong("X-VUNG-DATE", System.currentTimeMillis());
      }
      return localProtocolHttpRequest;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ProtocolHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */