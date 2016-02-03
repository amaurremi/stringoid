package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.Route;
import com.squareup.okio.Sink;
import com.squareup.okio.Source;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.Proxy;

public final class HttpTransport
  implements Transport
{
  private final HttpConnection httpConnection;
  private final HttpEngine httpEngine;
  
  public HttpTransport(HttpEngine paramHttpEngine, HttpConnection paramHttpConnection)
  {
    this.httpEngine = paramHttpEngine;
    this.httpConnection = paramHttpConnection;
  }
  
  public boolean canReuseConnection()
  {
    if ("close".equalsIgnoreCase(this.httpEngine.getRequest().header("Connection"))) {}
    while (("close".equalsIgnoreCase(this.httpEngine.getResponse().header("Connection"))) || (this.httpConnection.isClosed())) {
      return false;
    }
    return true;
  }
  
  public Sink createRequestBody(Request paramRequest)
    throws IOException
  {
    long l = OkHeaders.contentLength(paramRequest);
    if (this.httpEngine.bufferRequestBody)
    {
      if (l > 2147483647L) {
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
      }
      if (l != -1L)
      {
        writeRequestHeaders(paramRequest);
        return new RetryableSink((int)l);
      }
      return new RetryableSink();
    }
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding")))
    {
      writeRequestHeaders(paramRequest);
      return this.httpConnection.newChunkedSink();
    }
    if (l != -1L)
    {
      writeRequestHeaders(paramRequest);
      return this.httpConnection.newFixedLengthSink(l);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public void disconnect(HttpEngine paramHttpEngine)
    throws IOException
  {
    this.httpConnection.closeIfOwnedBy(paramHttpEngine);
  }
  
  public void emptyTransferStream()
    throws IOException
  {
    this.httpConnection.emptyResponseBody();
  }
  
  public void flushRequest()
    throws IOException
  {
    this.httpConnection.flush();
  }
  
  public Source getTransferStream(CacheRequest paramCacheRequest)
    throws IOException
  {
    if (!this.httpEngine.hasResponseBody()) {
      return this.httpConnection.newFixedLengthSource(paramCacheRequest, 0L);
    }
    if ("chunked".equalsIgnoreCase(this.httpEngine.getResponse().header("Transfer-Encoding"))) {
      return this.httpConnection.newChunkedSource(paramCacheRequest, this.httpEngine);
    }
    long l = OkHeaders.contentLength(this.httpEngine.getResponse());
    if (l != -1L) {
      return this.httpConnection.newFixedLengthSource(paramCacheRequest, l);
    }
    return this.httpConnection.newUnknownLengthSource(paramCacheRequest);
  }
  
  public Response.Builder readResponseHeaders()
    throws IOException
  {
    return this.httpConnection.readResponse();
  }
  
  public void releaseConnectionOnIdle()
    throws IOException
  {
    if (canReuseConnection())
    {
      this.httpConnection.poolOnIdle();
      return;
    }
    this.httpConnection.closeOnIdle();
  }
  
  public void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException
  {
    this.httpConnection.writeRequestBody(paramRetryableSink);
  }
  
  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    this.httpEngine.writingRequestHeaders();
    String str = RequestLine.get(paramRequest, this.httpEngine.getConnection().getRoute().getProxy().type(), this.httpEngine.getConnection().getProtocol());
    this.httpConnection.writeRequest(paramRequest.headers(), str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/http/HttpTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */