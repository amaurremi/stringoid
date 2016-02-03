package com.mopub.mobileads.util;

import com.mopub.mobileads.factories.HttpClientFactory;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpUtils
{
  public static HttpResponse ping(String paramString)
    throws IOException, IllegalArgumentException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Url must not be null.");
    }
    paramString = new HttpGet(paramString);
    return HttpClientFactory.create().execute(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/util/HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */