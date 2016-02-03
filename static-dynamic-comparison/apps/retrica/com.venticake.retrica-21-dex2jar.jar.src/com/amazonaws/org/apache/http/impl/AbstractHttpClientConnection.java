package com.amazonaws.org.apache.http.impl;

import com.amazonaws.org.apache.http.HttpClientConnection;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseFactory;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.impl.entity.EntityDeserializer;
import com.amazonaws.org.apache.http.impl.entity.EntitySerializer;
import com.amazonaws.org.apache.http.impl.entity.LaxContentLengthStrategy;
import com.amazonaws.org.apache.http.impl.entity.StrictContentLengthStrategy;
import com.amazonaws.org.apache.http.impl.io.DefaultHttpResponseParser;
import com.amazonaws.org.apache.http.impl.io.HttpRequestWriter;
import com.amazonaws.org.apache.http.io.EofSensor;
import com.amazonaws.org.apache.http.io.HttpMessageParser;
import com.amazonaws.org.apache.http.io.HttpMessageWriter;
import com.amazonaws.org.apache.http.io.HttpTransportMetrics;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.SocketTimeoutException;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractHttpClientConnection
  implements HttpClientConnection
{
  private final EntityDeserializer entitydeserializer = createEntityDeserializer();
  private final EntitySerializer entityserializer = createEntitySerializer();
  private EofSensor eofSensor = null;
  private SessionInputBuffer inbuffer = null;
  private HttpConnectionMetricsImpl metrics = null;
  private SessionOutputBuffer outbuffer = null;
  private HttpMessageWriter<HttpRequest> requestWriter = null;
  private HttpMessageParser<HttpResponse> responseParser = null;
  
  protected abstract void assertOpen();
  
  protected HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics paramHttpTransportMetrics1, HttpTransportMetrics paramHttpTransportMetrics2)
  {
    return new HttpConnectionMetricsImpl(paramHttpTransportMetrics1, paramHttpTransportMetrics2);
  }
  
  protected EntityDeserializer createEntityDeserializer()
  {
    return new EntityDeserializer(new LaxContentLengthStrategy());
  }
  
  protected EntitySerializer createEntitySerializer()
  {
    return new EntitySerializer(new StrictContentLengthStrategy());
  }
  
  protected HttpResponseFactory createHttpResponseFactory()
  {
    return new DefaultHttpResponseFactory();
  }
  
  protected HttpMessageWriter<HttpRequest> createRequestWriter(SessionOutputBuffer paramSessionOutputBuffer, HttpParams paramHttpParams)
  {
    return new HttpRequestWriter(paramSessionOutputBuffer, null, paramHttpParams);
  }
  
  protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer paramSessionInputBuffer, HttpResponseFactory paramHttpResponseFactory, HttpParams paramHttpParams)
  {
    return new DefaultHttpResponseParser(paramSessionInputBuffer, null, paramHttpResponseFactory, paramHttpParams);
  }
  
  protected void doFlush()
  {
    this.outbuffer.flush();
  }
  
  public void flush()
  {
    assertOpen();
    doFlush();
  }
  
  protected void init(SessionInputBuffer paramSessionInputBuffer, SessionOutputBuffer paramSessionOutputBuffer, HttpParams paramHttpParams)
  {
    if (paramSessionInputBuffer == null) {
      throw new IllegalArgumentException("Input session buffer may not be null");
    }
    if (paramSessionOutputBuffer == null) {
      throw new IllegalArgumentException("Output session buffer may not be null");
    }
    this.inbuffer = paramSessionInputBuffer;
    this.outbuffer = paramSessionOutputBuffer;
    if ((paramSessionInputBuffer instanceof EofSensor)) {
      this.eofSensor = ((EofSensor)paramSessionInputBuffer);
    }
    this.responseParser = createResponseParser(paramSessionInputBuffer, createHttpResponseFactory(), paramHttpParams);
    this.requestWriter = createRequestWriter(paramSessionOutputBuffer, paramHttpParams);
    this.metrics = createConnectionMetrics(paramSessionInputBuffer.getMetrics(), paramSessionOutputBuffer.getMetrics());
  }
  
  protected boolean isEof()
  {
    return (this.eofSensor != null) && (this.eofSensor.isEof());
  }
  
  public boolean isResponseAvailable(int paramInt)
  {
    assertOpen();
    try
    {
      boolean bool = this.inbuffer.isDataAvailable(paramInt);
      return bool;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
    return false;
  }
  
  public boolean isStale()
  {
    if (!isOpen()) {}
    while (isEof()) {
      return true;
    }
    try
    {
      this.inbuffer.isDataAvailable(1);
      boolean bool = isEof();
      return bool;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return false;
    }
    catch (IOException localIOException) {}
    return true;
  }
  
  public void receiveResponseEntity(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    assertOpen();
    paramHttpResponse.setEntity(this.entitydeserializer.deserialize(this.inbuffer, paramHttpResponse));
  }
  
  public HttpResponse receiveResponseHeader()
  {
    assertOpen();
    HttpResponse localHttpResponse = (HttpResponse)this.responseParser.parse();
    if (localHttpResponse.getStatusLine().getStatusCode() >= 200) {
      this.metrics.incrementResponseCount();
    }
    return localHttpResponse;
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    if (paramHttpEntityEnclosingRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    assertOpen();
    if (paramHttpEntityEnclosingRequest.getEntity() == null) {
      return;
    }
    this.entityserializer.serialize(this.outbuffer, paramHttpEntityEnclosingRequest, paramHttpEntityEnclosingRequest.getEntity());
  }
  
  public void sendRequestHeader(HttpRequest paramHttpRequest)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    assertOpen();
    this.requestWriter.write(paramHttpRequest);
    this.metrics.incrementRequestCount();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/AbstractHttpClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */