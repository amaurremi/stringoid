package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okio.BufferedSource;
import com.squareup.okio.Okio;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SecureCacheResponse;
import java.net.URI;
import java.net.URLConnection;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class JavaApiConverter
{
  public static CacheResponse createJavaCacheResponse(final Response paramResponse)
  {
    final Headers localHeaders = paramResponse.headers();
    final ResponseBody localResponseBody = paramResponse.body();
    if (paramResponse.request().isHttps()) {
      new SecureCacheResponse()
      {
        public InputStream getBody()
          throws IOException
        {
          if (localResponseBody == null) {
            return null;
          }
          return localResponseBody.byteStream();
        }
        
        public String getCipherSuite()
        {
          if (this.val$handshake != null) {
            return this.val$handshake.cipherSuite();
          }
          return null;
        }
        
        public Map<String, List<String>> getHeaders()
          throws IOException
        {
          return OkHeaders.toMultimap(localHeaders, StatusLine.get(paramResponse).toString());
        }
        
        public List<Certificate> getLocalCertificateChain()
        {
          if (this.val$handshake == null) {
            return null;
          }
          List localList = this.val$handshake.localCertificates();
          if (localList.size() > 0) {}
          for (;;)
          {
            return localList;
            localList = null;
          }
        }
        
        public Principal getLocalPrincipal()
        {
          if (this.val$handshake == null) {
            return null;
          }
          return this.val$handshake.localPrincipal();
        }
        
        public Principal getPeerPrincipal()
          throws SSLPeerUnverifiedException
        {
          if (this.val$handshake == null) {
            return null;
          }
          return this.val$handshake.peerPrincipal();
        }
        
        public List<Certificate> getServerCertificateChain()
          throws SSLPeerUnverifiedException
        {
          if (this.val$handshake == null) {
            return null;
          }
          List localList = this.val$handshake.peerCertificates();
          if (localList.size() > 0) {}
          for (;;)
          {
            return localList;
            localList = null;
          }
        }
      };
    }
    new CacheResponse()
    {
      public InputStream getBody()
        throws IOException
      {
        if (localResponseBody == null) {
          return null;
        }
        return localResponseBody.byteStream();
      }
      
      public Map<String, List<String>> getHeaders()
        throws IOException
      {
        return OkHeaders.toMultimap(this.val$headers, StatusLine.get(paramResponse).toString());
      }
    };
  }
  
  static HttpURLConnection createJavaUrlConnection(Response paramResponse)
  {
    if (paramResponse.request().isHttps()) {
      return new CacheHttpsURLConnection(new CacheHttpURLConnection(paramResponse));
    }
    return new CacheHttpURLConnection(paramResponse);
  }
  
  private static ResponseBody createOkBody(Headers paramHeaders, InputStream paramInputStream)
  {
    new ResponseBody()
    {
      public long contentLength()
      {
        return OkHeaders.contentLength(this.val$okHeaders);
      }
      
      public MediaType contentType()
      {
        String str = this.val$okHeaders.get("Content-Type");
        if (str == null) {
          return null;
        }
        return MediaType.parse(str);
      }
      
      public BufferedSource source()
      {
        return this.val$source;
      }
    };
  }
  
  public static Request createOkRequest(URI paramURI, String paramString, Map<String, List<String>> paramMap)
  {
    paramURI = new Request.Builder().url(paramURI.toString()).method(paramString, null);
    if (paramMap != null) {
      paramURI.headers(extractOkHeaders(paramMap));
    }
    return paramURI.build();
  }
  
  static Response createOkResponse(Request paramRequest, CacheResponse paramCacheResponse)
    throws IOException
  {
    Response.Builder localBuilder = new Response.Builder();
    localBuilder.request(paramRequest);
    paramRequest = StatusLine.parse(extractStatusLine(paramCacheResponse));
    localBuilder.protocol(paramRequest.protocol);
    localBuilder.code(paramRequest.code);
    localBuilder.message(paramRequest.message);
    paramRequest = extractOkHeaders(paramCacheResponse);
    localBuilder.headers(paramRequest);
    localBuilder.body(createOkBody(paramRequest, paramCacheResponse.getBody()));
    SecureCacheResponse localSecureCacheResponse;
    if ((paramCacheResponse instanceof SecureCacheResponse)) {
      localSecureCacheResponse = (SecureCacheResponse)paramCacheResponse;
    }
    try
    {
      paramRequest = localSecureCacheResponse.getServerCertificateChain();
      List localList = localSecureCacheResponse.getLocalCertificateChain();
      paramCacheResponse = localList;
      if (localList == null) {
        paramCacheResponse = Collections.emptyList();
      }
      localBuilder.handshake(Handshake.get(localSecureCacheResponse.getCipherSuite(), paramRequest, paramCacheResponse));
      return localBuilder.build();
    }
    catch (SSLPeerUnverifiedException paramRequest)
    {
      for (;;)
      {
        paramRequest = Collections.emptyList();
      }
    }
  }
  
  public static Response createOkResponse(URI paramURI, URLConnection paramURLConnection)
    throws IOException
  {
    Object localObject = (HttpURLConnection)paramURLConnection;
    Response.Builder localBuilder = new Response.Builder();
    localBuilder.request(createOkRequest(paramURI, ((HttpURLConnection)localObject).getRequestMethod(), null));
    paramURI = StatusLine.parse(extractStatusLine((HttpURLConnection)localObject));
    localBuilder.protocol(paramURI.protocol);
    localBuilder.code(paramURI.code);
    localBuilder.message(paramURI.message);
    paramURI = extractOkResponseHeaders((HttpURLConnection)localObject);
    localBuilder.headers(paramURI);
    localBuilder.body(createOkBody(paramURI, paramURLConnection.getInputStream()));
    if ((localObject instanceof HttpsURLConnection)) {
      paramURLConnection = (HttpsURLConnection)localObject;
    }
    try
    {
      paramURI = paramURLConnection.getServerCertificates();
      localObject = paramURLConnection.getLocalCertificates();
      localBuilder.handshake(Handshake.get(paramURLConnection.getCipherSuite(), nullSafeImmutableList(paramURI), nullSafeImmutableList((Object[])localObject)));
      return localBuilder.build();
    }
    catch (SSLPeerUnverifiedException paramURI)
    {
      for (;;)
      {
        paramURI = null;
      }
    }
  }
  
  static Map<String, List<String>> extractJavaHeaders(Request paramRequest)
  {
    return OkHeaders.toMultimap(paramRequest.headers(), null);
  }
  
  private static Headers extractOkHeaders(CacheResponse paramCacheResponse)
    throws IOException
  {
    return extractOkHeaders(paramCacheResponse.getHeaders());
  }
  
  static Headers extractOkHeaders(Map<String, List<String>> paramMap)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      if (str != null)
      {
        localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext()) {
          localBuilder.add(str, (String)((Iterator)localObject).next());
        }
      }
    }
    return localBuilder.build();
  }
  
  private static Headers extractOkResponseHeaders(HttpURLConnection paramHttpURLConnection)
  {
    return extractOkHeaders(paramHttpURLConnection.getHeaderFields());
  }
  
  private static String extractStatusLine(CacheResponse paramCacheResponse)
    throws IOException
  {
    return extractStatusLine(paramCacheResponse.getHeaders());
  }
  
  private static String extractStatusLine(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField(null);
  }
  
  static String extractStatusLine(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get(null);
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    return (String)paramMap.get(0);
  }
  
  private static <T> List<T> nullSafeImmutableList(T[] paramArrayOfT)
  {
    if (paramArrayOfT == null) {
      return Collections.emptyList();
    }
    return Util.immutableList(paramArrayOfT);
  }
  
  private static RuntimeException throwRequestHeaderAccessException()
  {
    throw new UnsupportedOperationException("ResponseCache cannot access request headers");
  }
  
  private static RuntimeException throwRequestModificationException()
  {
    throw new UnsupportedOperationException("ResponseCache cannot modify the request.");
  }
  
  private static RuntimeException throwRequestSslAccessException()
  {
    throw new UnsupportedOperationException("ResponseCache cannot access SSL internals");
  }
  
  private static RuntimeException throwResponseBodyAccessException()
  {
    throw new UnsupportedOperationException("ResponseCache cannot access the response body.");
  }
  
  private static final class CacheHttpURLConnection
    extends HttpURLConnection
  {
    private final Request request;
    private final Response response;
    
    public CacheHttpURLConnection(Response paramResponse)
    {
      super();
      this.request = paramResponse.request();
      this.response = paramResponse;
      this.connected = true;
      if (paramResponse.body() == null) {}
      for (;;)
      {
        this.doOutput = bool;
        this.method = this.request.method();
        return;
        bool = false;
      }
    }
    
    public void addRequestProperty(String paramString1, String paramString2)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void connect()
      throws IOException
    {
      throw JavaApiConverter.access$000();
    }
    
    public void disconnect()
    {
      throw JavaApiConverter.access$000();
    }
    
    public boolean getAllowUserInteraction()
    {
      return false;
    }
    
    public int getConnectTimeout()
    {
      return 0;
    }
    
    public Object getContent()
      throws IOException
    {
      throw JavaApiConverter.access$200();
    }
    
    public Object getContent(Class[] paramArrayOfClass)
      throws IOException
    {
      throw JavaApiConverter.access$200();
    }
    
    public boolean getDefaultUseCaches()
    {
      return super.getDefaultUseCaches();
    }
    
    public boolean getDoInput()
    {
      return true;
    }
    
    public boolean getDoOutput()
    {
      return this.request.body() != null;
    }
    
    public InputStream getErrorStream()
    {
      return null;
    }
    
    public String getHeaderField(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("Invalid header index: " + paramInt);
      }
      if (paramInt == 0) {
        return StatusLine.get(this.response).toString();
      }
      return this.response.headers().value(paramInt - 1);
    }
    
    public String getHeaderField(String paramString)
    {
      if (paramString == null) {
        return StatusLine.get(this.response).toString();
      }
      return this.response.headers().get(paramString);
    }
    
    public String getHeaderFieldKey(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("Invalid header index: " + paramInt);
      }
      if (paramInt == 0) {
        return null;
      }
      return this.response.headers().name(paramInt - 1);
    }
    
    public Map<String, List<String>> getHeaderFields()
    {
      return OkHeaders.toMultimap(this.response.headers(), StatusLine.get(this.response).toString());
    }
    
    public long getIfModifiedSince()
    {
      return 0L;
    }
    
    public InputStream getInputStream()
      throws IOException
    {
      throw JavaApiConverter.access$200();
    }
    
    public boolean getInstanceFollowRedirects()
    {
      return super.getInstanceFollowRedirects();
    }
    
    public OutputStream getOutputStream()
      throws IOException
    {
      throw JavaApiConverter.access$000();
    }
    
    public int getReadTimeout()
    {
      return 0;
    }
    
    public String getRequestMethod()
    {
      return this.request.method();
    }
    
    public Map<String, List<String>> getRequestProperties()
    {
      throw JavaApiConverter.access$100();
    }
    
    public String getRequestProperty(String paramString)
    {
      return this.request.header(paramString);
    }
    
    public int getResponseCode()
      throws IOException
    {
      return this.response.code();
    }
    
    public String getResponseMessage()
      throws IOException
    {
      return this.response.message();
    }
    
    public boolean getUseCaches()
    {
      return super.getUseCaches();
    }
    
    public void setAllowUserInteraction(boolean paramBoolean)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setChunkedStreamingMode(int paramInt)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setConnectTimeout(int paramInt)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setDefaultUseCaches(boolean paramBoolean)
    {
      super.setDefaultUseCaches(paramBoolean);
    }
    
    public void setDoInput(boolean paramBoolean)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setDoOutput(boolean paramBoolean)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setFixedLengthStreamingMode(int paramInt)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setFixedLengthStreamingMode(long paramLong)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setIfModifiedSince(long paramLong)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setInstanceFollowRedirects(boolean paramBoolean)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setReadTimeout(int paramInt)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setRequestMethod(String paramString)
      throws ProtocolException
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setRequestProperty(String paramString1, String paramString2)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setUseCaches(boolean paramBoolean)
    {
      throw JavaApiConverter.access$000();
    }
    
    public boolean usingProxy()
    {
      return false;
    }
  }
  
  private static final class CacheHttpsURLConnection
    extends DelegatingHttpsURLConnection
  {
    private final JavaApiConverter.CacheHttpURLConnection delegate;
    
    public CacheHttpsURLConnection(JavaApiConverter.CacheHttpURLConnection paramCacheHttpURLConnection)
    {
      super();
      this.delegate = paramCacheHttpURLConnection;
    }
    
    public long getContentLengthLong()
    {
      return this.delegate.getContentLengthLong();
    }
    
    public long getHeaderFieldLong(String paramString, long paramLong)
    {
      return this.delegate.getHeaderFieldLong(paramString, paramLong);
    }
    
    public HostnameVerifier getHostnameVerifier()
    {
      throw JavaApiConverter.access$400();
    }
    
    public SSLSocketFactory getSSLSocketFactory()
    {
      throw JavaApiConverter.access$400();
    }
    
    protected Handshake handshake()
    {
      return this.delegate.response.handshake();
    }
    
    public void setFixedLengthStreamingMode(long paramLong)
    {
      this.delegate.setFixedLengthStreamingMode(paramLong);
    }
    
    public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
    {
      throw JavaApiConverter.access$000();
    }
    
    public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
    {
      throw JavaApiConverter.access$000();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/huc/JavaApiConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */