package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.util.Map;

public final class CacheAdapter
  implements InternalCache
{
  private final ResponseCache delegate;
  
  public CacheAdapter(ResponseCache paramResponseCache)
  {
    this.delegate = paramResponseCache;
  }
  
  private CacheResponse getJavaCachedResponse(Request paramRequest)
    throws IOException
  {
    Map localMap = JavaApiConverter.extractJavaHeaders(paramRequest);
    return this.delegate.get(paramRequest.uri(), paramRequest.method(), localMap);
  }
  
  public Response get(Request paramRequest)
    throws IOException
  {
    CacheResponse localCacheResponse = getJavaCachedResponse(paramRequest);
    if (localCacheResponse == null) {
      return null;
    }
    return JavaApiConverter.createOkResponse(paramRequest, localCacheResponse);
  }
  
  public ResponseCache getDelegate()
  {
    return this.delegate;
  }
  
  public CacheRequest put(Response paramResponse)
    throws IOException
  {
    URI localURI = paramResponse.request().uri();
    paramResponse = JavaApiConverter.createJavaUrlConnection(paramResponse);
    return this.delegate.put(localURI, paramResponse);
  }
  
  public void remove(Request paramRequest)
    throws IOException
  {}
  
  public void trackConditionalCacheHit() {}
  
  public void trackResponse(CacheStrategy paramCacheStrategy) {}
  
  public void update(Response paramResponse1, Response paramResponse2)
    throws IOException
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/huc/CacheAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */