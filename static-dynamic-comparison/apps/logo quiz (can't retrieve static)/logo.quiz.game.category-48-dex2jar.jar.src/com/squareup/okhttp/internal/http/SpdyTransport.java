package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import com.squareup.okio.Buffer;
import com.squareup.okio.ByteString;
import com.squareup.okio.Sink;
import com.squareup.okio.Source;
import com.squareup.okio.Timeout;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class SpdyTransport
  implements Transport
{
  private static final List<ByteString> HTTP_2_PROHIBITED_HEADERS = Util.immutableList(new ByteString[] { ByteString.encodeUtf8("connection"), ByteString.encodeUtf8("host"), ByteString.encodeUtf8("keep-alive"), ByteString.encodeUtf8("proxy-connection"), ByteString.encodeUtf8("te"), ByteString.encodeUtf8("transfer-encoding"), ByteString.encodeUtf8("encoding"), ByteString.encodeUtf8("upgrade") });
  private static final List<ByteString> SPDY_3_PROHIBITED_HEADERS = Util.immutableList(new ByteString[] { ByteString.encodeUtf8("connection"), ByteString.encodeUtf8("host"), ByteString.encodeUtf8("keep-alive"), ByteString.encodeUtf8("proxy-connection"), ByteString.encodeUtf8("transfer-encoding") });
  private final HttpEngine httpEngine;
  private final SpdyConnection spdyConnection;
  private SpdyStream stream;
  
  public SpdyTransport(HttpEngine paramHttpEngine, SpdyConnection paramSpdyConnection)
  {
    this.httpEngine = paramHttpEngine;
    this.spdyConnection = paramSpdyConnection;
  }
  
  private static boolean isProhibitedHeader(Protocol paramProtocol, ByteString paramByteString)
  {
    if (paramProtocol == Protocol.SPDY_3) {
      return SPDY_3_PROHIBITED_HEADERS.contains(paramByteString);
    }
    if (paramProtocol == Protocol.HTTP_2) {
      return HTTP_2_PROHIBITED_HEADERS.contains(paramByteString);
    }
    throw new AssertionError(paramProtocol);
  }
  
  private static String joinOnNull(String paramString1, String paramString2)
  {
    return paramString1 + '\000' + paramString2;
  }
  
  public static Response.Builder readNameValueBlock(List<Header> paramList, Protocol paramProtocol)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = "HTTP/1.1";
    Headers.Builder localBuilder = new Headers.Builder();
    localBuilder.set(OkHeaders.SELECTED_PROTOCOL, paramProtocol.toString());
    int i = 0;
    while (i < paramList.size())
    {
      ByteString localByteString = ((Header)paramList.get(i)).name;
      String str2 = ((Header)paramList.get(i)).value.utf8();
      int j = 0;
      if (j < str2.length())
      {
        int m = str2.indexOf(0, j);
        int k = m;
        if (m == -1) {
          k = str2.length();
        }
        String str1 = str2.substring(j, k);
        Object localObject3;
        Object localObject4;
        if (localByteString.equals(Header.RESPONSE_STATUS))
        {
          localObject3 = str1;
          localObject4 = localObject1;
        }
        for (;;)
        {
          j = k + 1;
          localObject2 = localObject3;
          localObject1 = localObject4;
          break;
          if (localByteString.equals(Header.VERSION))
          {
            localObject4 = str1;
            localObject3 = localObject2;
          }
          else
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (!isProhibitedHeader(paramProtocol, localByteString))
            {
              localBuilder.add(localByteString.utf8(), str1);
              localObject3 = localObject2;
              localObject4 = localObject1;
            }
          }
        }
      }
      i += 1;
    }
    if (localObject2 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':version' header not present");
    }
    paramList = StatusLine.parse((String)localObject1 + " " + (String)localObject2);
    return new Response.Builder().protocol(paramList.protocol).code(paramList.code).message(paramList.message).headers(localBuilder.build());
  }
  
  public static List<Header> writeNameValueBlock(Request paramRequest, Protocol paramProtocol, String paramString)
  {
    Headers localHeaders = paramRequest.headers();
    ArrayList localArrayList = new ArrayList(localHeaders.size() + 10);
    localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    String str = HttpEngine.hostHeader(paramRequest.url());
    int i;
    if (Protocol.SPDY_3 == paramProtocol)
    {
      localArrayList.add(new Header(Header.VERSION, paramString));
      localArrayList.add(new Header(Header.TARGET_HOST, str));
      localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().getProtocol()));
      paramRequest = new LinkedHashSet();
      i = 0;
      label160:
      if (i >= localHeaders.size()) {
        break label427;
      }
      paramString = ByteString.encodeUtf8(localHeaders.name(i).toLowerCase(Locale.US));
      str = localHeaders.value(i);
      if (!isProhibitedHeader(paramProtocol, paramString)) {
        break label246;
      }
    }
    label246:
    label425:
    for (;;)
    {
      i += 1;
      break label160;
      if (Protocol.HTTP_2 == paramProtocol)
      {
        localArrayList.add(new Header(Header.TARGET_AUTHORITY, str));
        break;
      }
      throw new AssertionError();
      if ((!paramString.equals(Header.TARGET_METHOD)) && (!paramString.equals(Header.TARGET_PATH)) && (!paramString.equals(Header.TARGET_SCHEME)) && (!paramString.equals(Header.TARGET_AUTHORITY)) && (!paramString.equals(Header.TARGET_HOST)) && (!paramString.equals(Header.VERSION))) {
        if (paramRequest.add(paramString))
        {
          localArrayList.add(new Header(paramString, str));
        }
        else
        {
          int j = 0;
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label425;
            }
            if (((Header)localArrayList.get(j)).name.equals(paramString))
            {
              localArrayList.set(j, new Header(paramString, joinOnNull(((Header)localArrayList.get(j)).value.utf8(), str)));
              break;
            }
            j += 1;
          }
        }
      }
    }
    label427:
    return localArrayList;
  }
  
  public boolean canReuseConnection()
  {
    return true;
  }
  
  public Sink createRequestBody(Request paramRequest)
    throws IOException
  {
    writeRequestHeaders(paramRequest);
    return this.stream.getSink();
  }
  
  public void disconnect(HttpEngine paramHttpEngine)
    throws IOException
  {
    this.stream.close(ErrorCode.CANCEL);
  }
  
  public void emptyTransferStream() {}
  
  public void flushRequest()
    throws IOException
  {
    this.stream.getSink().close();
  }
  
  public Source getTransferStream(CacheRequest paramCacheRequest)
    throws IOException
  {
    return new SpdySource(this.stream, paramCacheRequest);
  }
  
  public Response.Builder readResponseHeaders()
    throws IOException
  {
    return readNameValueBlock(this.stream.getResponseHeaders(), this.spdyConnection.getProtocol());
  }
  
  public void releaseConnectionOnIdle() {}
  
  public void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    if (this.stream != null) {
      return;
    }
    this.httpEngine.writingRequestHeaders();
    boolean bool = this.httpEngine.hasRequestBody();
    String str = RequestLine.version(this.httpEngine.getConnection().getProtocol());
    this.stream = this.spdyConnection.newStream(writeNameValueBlock(paramRequest, this.spdyConnection.getProtocol(), str), bool, true);
    this.stream.readTimeout().timeout(this.httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
  }
  
  private static class SpdySource
    implements Source
  {
    private final OutputStream cacheBody;
    private final CacheRequest cacheRequest;
    private boolean closed;
    private boolean inputExhausted;
    private final Source source;
    private final SpdyStream stream;
    
    SpdySource(SpdyStream paramSpdyStream, CacheRequest paramCacheRequest)
      throws IOException
    {
      this.stream = paramSpdyStream;
      this.source = paramSpdyStream.getSource();
      if (paramCacheRequest != null) {}
      for (paramSpdyStream = paramCacheRequest.getBody();; paramSpdyStream = null)
      {
        if (paramSpdyStream == null) {
          paramCacheRequest = null;
        }
        this.cacheBody = paramSpdyStream;
        this.cacheRequest = paramCacheRequest;
        return;
      }
    }
    
    private boolean discardStream()
    {
      long l = this.stream.readTimeout().timeoutNanos();
      this.stream.readTimeout().timeout(100L, TimeUnit.MILLISECONDS);
      try
      {
        Util.skipAll(this, 100);
        this.stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
        return true;
      }
      catch (IOException localIOException)
      {
        localIOException = localIOException;
        this.stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
        return false;
      }
      finally
      {
        localObject = finally;
        this.stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
        throw ((Throwable)localObject);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {}
      do
      {
        do
        {
          return;
          if ((!this.inputExhausted) && (this.cacheBody != null)) {
            discardStream();
          }
          this.closed = true;
        } while (this.inputExhausted);
        this.stream.closeLater(ErrorCode.CANCEL);
      } while (this.cacheRequest == null);
      this.cacheRequest.abort();
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (this.inputExhausted) {
        paramLong = -1L;
      }
      long l;
      do
      {
        return paramLong;
        l = this.source.read(paramBuffer, paramLong);
        if (l == -1L)
        {
          this.inputExhausted = true;
          if (this.cacheRequest != null) {
            this.cacheBody.close();
          }
          return -1L;
        }
        paramLong = l;
      } while (this.cacheBody == null);
      paramBuffer.copyTo(this.cacheBody, paramBuffer.size() - l, l);
      return l;
    }
    
    public Timeout timeout()
    {
      return this.source.timeout();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/http/SpdyTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */