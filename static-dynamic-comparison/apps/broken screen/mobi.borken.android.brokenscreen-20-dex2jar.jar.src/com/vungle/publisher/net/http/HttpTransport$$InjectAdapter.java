package com.vungle.publisher.net.http;

import com.vungle.publisher.cs;
import javax.inject.Provider;

public final class HttpTransport$$InjectAdapter
  extends cs<HttpTransport>
  implements Provider<HttpTransport>
{
  public HttpTransport$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.HttpTransport", "members/com.vungle.publisher.net.http.HttpTransport", true, HttpTransport.class);
  }
  
  public final HttpTransport get()
  {
    return new HttpTransport();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/HttpTransport$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */