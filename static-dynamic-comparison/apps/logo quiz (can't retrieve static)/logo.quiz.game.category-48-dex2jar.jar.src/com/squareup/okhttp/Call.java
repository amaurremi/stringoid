package com.squareup.okhttp;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RetryableSink;
import com.squareup.okio.BufferedSink;
import com.squareup.okio.BufferedSource;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.URL;

public final class Call
{
  volatile boolean canceled;
  private final OkHttpClient client;
  private final Dispatcher dispatcher;
  HttpEngine engine;
  private boolean executed;
  private int redirectionCount;
  private Request request;
  
  Call(OkHttpClient paramOkHttpClient, Dispatcher paramDispatcher, Request paramRequest)
  {
    this.client = paramOkHttpClient;
    this.dispatcher = paramDispatcher;
    this.request = paramRequest;
  }
  
  private Response getResponse()
    throws IOException
  {
    Object localObject2 = this.request.body();
    Object localObject1 = null;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.request.newBuilder();
      MediaType localMediaType = ((RequestBody)localObject2).contentType();
      if (localMediaType != null) {
        ((Request.Builder)localObject3).header("Content-Type", localMediaType.toString());
      }
      long l = ((RequestBody)localObject2).contentLength();
      if (l != -1L)
      {
        ((Request.Builder)localObject3).header("Content-Length", Long.toString(l));
        ((Request.Builder)localObject3).removeHeader("Transfer-Encoding");
        this.request = ((Request.Builder)localObject3).build();
      }
    }
    label94:
    for (this.engine = new HttpEngine(this.client, this.request, false, null, null, (RetryableSink)localObject1, null);; this.engine = new HttpEngine(this.client, this.request, false, (Connection)localObject3, null, null, localIOException))
    {
      for (;;)
      {
        if (this.canceled)
        {
          return null;
          ((Request.Builder)localObject3).header("Transfer-Encoding", "chunked");
          ((Request.Builder)localObject3).removeHeader("Content-Length");
          break;
          if (!HttpMethod.hasRequestBody(this.request.method())) {
            break label94;
          }
          localObject1 = Util.emptySink();
          break label94;
        }
        try
        {
          this.engine.sendRequest();
          if (this.request.body() != null)
          {
            localObject1 = this.engine.getBufferedRequestBody();
            this.request.body().writeTo((BufferedSink)localObject1);
          }
          this.engine.readResponse();
          localObject1 = this.engine.getResponse();
          localObject2 = this.engine.followUpRequest();
          if (localObject2 == null)
          {
            this.engine.releaseConnection();
            return ((Response)localObject1).newBuilder().body(new RealResponseBody((Response)localObject1, this.engine.getResponseBody())).build();
          }
        }
        catch (IOException localIOException)
        {
          localObject2 = this.engine.recover(localIOException, null);
          if (localObject2 != null) {
            this.engine = ((HttpEngine)localObject2);
          } else {
            throw localIOException;
          }
        }
      }
      if (this.engine.getResponse().isRedirect())
      {
        int i = this.redirectionCount + 1;
        this.redirectionCount = i;
        if (i > 20) {
          throw new ProtocolException("Too many redirects: " + this.redirectionCount);
        }
      }
      if (!this.engine.sameConnection(((Request)localObject2).url())) {
        this.engine.releaseConnection();
      }
      localObject3 = this.engine.close();
      this.request = ((Request)localObject2);
    }
  }
  
  public void cancel()
  {
    this.canceled = true;
    if (this.engine != null) {
      this.engine.disconnect();
    }
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    this.dispatcher.enqueue(new AsyncCall(paramCallback, null));
  }
  
  public Response execute()
    throws IOException
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    Response localResponse = getResponse();
    this.engine.releaseConnection();
    if (localResponse == null) {
      throw new IOException("Canceled");
    }
    return localResponse;
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final Callback responseCallback;
    
    private AsyncCall(Callback paramCallback)
    {
      super(new Object[] { Call.this.request.urlString() });
      this.responseCallback = paramCallback;
    }
    
    protected void execute()
    {
      int j = 0;
      int i = j;
      try
      {
        Response localResponse = Call.this.getResponse();
        i = j;
        if (Call.this.canceled)
        {
          i = 1;
          this.responseCallback.onFailure(Call.this.request, new IOException("Canceled"));
        }
        for (;;)
        {
          return;
          j = 1;
          i = j;
          Call.this.engine.releaseConnection();
          i = j;
          this.responseCallback.onResponse(localResponse);
        }
        this.responseCallback.onFailure(Call.this.request, localIOException2);
      }
      catch (IOException localIOException1)
      {
        if (i != 0) {
          throw new RuntimeException(localIOException1);
        }
      }
      finally
      {
        Call.this.dispatcher.finished(this);
      }
      Call.this.dispatcher.finished(this);
    }
    
    Call get()
    {
      return Call.this;
    }
    
    String host()
    {
      return Call.this.request.url().getHost();
    }
    
    Request request()
    {
      return Call.this.request;
    }
    
    Object tag()
    {
      return Call.this.request.tag();
    }
  }
  
  private static class RealResponseBody
    extends ResponseBody
  {
    private final Response response;
    private final BufferedSource source;
    
    RealResponseBody(Response paramResponse, BufferedSource paramBufferedSource)
    {
      this.response = paramResponse;
      this.source = paramBufferedSource;
    }
    
    public long contentLength()
    {
      return OkHeaders.contentLength(this.response);
    }
    
    public MediaType contentType()
    {
      String str = this.response.header("Content-Type");
      if (str != null) {
        return MediaType.parse(str);
      }
      return null;
    }
    
    public BufferedSource source()
    {
      return this.source;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */