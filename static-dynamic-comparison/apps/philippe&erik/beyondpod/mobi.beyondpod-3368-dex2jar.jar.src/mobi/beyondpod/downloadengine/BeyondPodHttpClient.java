package mobi.beyondpod.downloadengine;

import android.content.ContentResolver;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.NetworkCredential;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

public final class BeyondPodHttpClient
  implements HttpClient
{
  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
  public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
  private static final String TAG = "AndroidHttpClient";
  private static final ThreadLocal<Boolean> sThreadBlocked = new ThreadLocal();
  private static final HttpRequestInterceptor sThreadCheckInterceptor = new HttpRequestInterceptor()
  {
    public void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
    {
      if ((BeyondPodHttpClient.sThreadBlocked.get() != null) && (((Boolean)BeyondPodHttpClient.sThreadBlocked.get()).booleanValue())) {
        throw new RuntimeException("This thread forbids HTTP requests");
      }
    }
  };
  BPRedirectHandler _BPRedirectHandler = new BPRedirectHandler(null);
  private final HttpClient delegate;
  private RuntimeException mLeakedException = new IllegalStateException("BeyondPodHttpClient created and never closed");
  
  private BeyondPodHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    paramClientConnectionManager = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams)
    {
      protected HttpContext createHttpContext()
      {
        BasicHttpContext localBasicHttpContext = new BasicHttpContext();
        localBasicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
        localBasicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        localBasicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return localBasicHttpContext;
      }
      
      protected BasicHttpProcessor createHttpProcessor()
      {
        BasicHttpProcessor localBasicHttpProcessor = super.createHttpProcessor();
        localBasicHttpProcessor.addRequestInterceptor(BeyondPodHttpClient.sThreadCheckInterceptor);
        return localBasicHttpProcessor;
      }
    };
    paramClientConnectionManager.setRedirectHandler(this._BPRedirectHandler);
    this.delegate = paramClientConnectionManager;
    paramClientConnectionManager.addRequestInterceptor(new HttpRequestInterceptor()
    {
      public void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
        throws HttpException, IOException
      {
        try
        {
          URI localURI = ((RequestWrapper)paramAnonymousHttpRequest).getURI();
          String str2 = localURI.getHost();
          String str1 = str2;
          if (str2 == null) {
            str1 = ((HttpHost)paramAnonymousHttpContext.getAttribute("http.target_host")).getHostName();
          }
          if ((str1 != null) && (str1.endsWith("s3.amazonaws.com")) && (localURI.getQuery() != null) && (localURI.getQuery().contains("Signature=")) && (paramAnonymousHttpRequest.getHeaders("Authorization").length > 0))
          {
            CoreHelper.WriteTraceEntry("AndroidHttpClient", "Detected request to amazon servers using Authorization header! Authorization header was removed!. Url: " + localURI.toString());
            paramAnonymousHttpRequest.removeHeaders("Authorization");
          }
          return;
        }
        catch (Exception paramAnonymousHttpRequest)
        {
          CoreHelper.LogException("AndroidHttpClient", "Failed to check for Amazon authentication!", paramAnonymousHttpRequest);
        }
      }
    });
  }
  
  public static String GetContentDisposition(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = GetHeader(paramHttpResponse, "Content-Disposition");
    if (StringUtils.IsNullOrEmpty(paramHttpResponse)) {
      return null;
    }
    return parseContentDisposition(paramHttpResponse);
  }
  
  public static String GetContentEncodingFrom(HttpResponse paramHttpResponse)
  {
    return GetHeader(paramHttpResponse, "Content-Encoding");
  }
  
  public static Long GetContentLengthFrom(HttpResponse paramHttpResponse)
  {
    long l = StringUtils.SafeParseLong(GetHeader(paramHttpResponse, "Content-Length"), -1L);
    if (l < 0L) {
      return null;
    }
    return Long.valueOf(l);
  }
  
  private static String GetHeader(HttpResponse paramHttpResponse, String paramString)
  {
    paramHttpResponse = paramHttpResponse.getHeaders(paramString);
    if (paramHttpResponse.length > 0) {
      return paramHttpResponse[0].getValue();
    }
    return null;
  }
  
  public static Date GetLastModifiedFrom(HttpResponse paramHttpResponse)
  {
    return DateTime.TryParseRFC822Time(GetHeader(paramHttpResponse, "Last-Modified"), null);
  }
  
  public static String GetResponseCookie(HttpResponse paramHttpResponse)
  {
    return GetHeader(paramHttpResponse, "Set-Cookie");
  }
  
  public static void ModifyRequestToAcceptGzipResponse(HttpRequest paramHttpRequest)
  {
    SetAcceptEncodingTo("gzip", paramHttpRequest);
  }
  
  public static void SetAcceptEncodingTo(String paramString, HttpRequest paramHttpRequest)
  {
    if (!StringUtils.IsNullOrEmpty(paramString)) {
      SetHeader(paramHttpRequest, "Accept-Encoding", paramString);
    }
  }
  
  public static void SetAcceptTo(String paramString, HttpRequest paramHttpRequest)
  {
    if (!StringUtils.IsNullOrEmpty(paramString)) {
      SetHeader(paramHttpRequest, "Accept", paramString);
    }
  }
  
  public static void SetHeader(HttpRequest paramHttpRequest, String paramString1, String paramString2)
  {
    paramHttpRequest.addHeader(paramString1, paramString2);
  }
  
  public static void SetIfModifiedSinceTo(Date paramDate, HttpRequest paramHttpRequest)
  {
    if (paramDate != null) {
      SetHeader(paramHttpRequest, "If-Modified-Since", DateTime.ToRFC822UTCString(paramDate));
    }
  }
  
  public static void SetRangeTo(int paramInt, Long paramLong, HttpRequest paramHttpRequest)
  {
    String str2 = "bytes=" + paramInt + "-";
    String str1 = str2;
    if (paramLong != null)
    {
      str1 = str2;
      if (paramLong.longValue() >= 0L) {
        str1 = str2 + (paramLong.longValue() - 1L);
      }
    }
    paramHttpRequest.addHeader("Range", str1);
  }
  
  public static void SetRequestCookie(String paramString, HttpRequest paramHttpRequest)
  {
    if (!StringUtils.IsNullOrEmpty(paramString)) {
      SetHeader(paramHttpRequest, "Cookie", paramString);
    }
  }
  
  public static void SetUserAgentTo(String paramString, HttpRequest paramHttpRequest)
  {
    if (!StringUtils.IsNullOrEmpty(paramString)) {
      SetHeader(paramHttpRequest, "User-Agent", paramString);
    }
  }
  
  public static AbstractHttpEntity getCompressedEntity(byte[] paramArrayOfByte, ContentResolver paramContentResolver)
    throws IOException
  {
    if (paramArrayOfByte.length < getMinGzipSize(paramContentResolver)) {
      return new ByteArrayEntity(paramArrayOfByte);
    }
    paramContentResolver = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(paramContentResolver);
    localGZIPOutputStream.write(paramArrayOfByte);
    localGZIPOutputStream.close();
    paramArrayOfByte = new ByteArrayEntity(paramContentResolver.toByteArray());
    paramArrayOfByte.setContentEncoding("gzip");
    return paramArrayOfByte;
  }
  
  public static long getMinGzipSize(ContentResolver paramContentResolver)
  {
    return DEFAULT_SYNC_MIN_GZIP_BYTES;
  }
  
  public static InputStream getUngzippedContent(HttpEntity paramHttpEntity)
    throws IOException
  {
    InputStream localInputStream = paramHttpEntity.getContent();
    if (localInputStream == null) {
      return localInputStream;
    }
    paramHttpEntity = paramHttpEntity.getContentEncoding();
    if (paramHttpEntity == null) {
      return localInputStream;
    }
    String str = paramHttpEntity.getValue();
    if (str == null) {
      return localInputStream;
    }
    paramHttpEntity = localInputStream;
    if (str.contains("gzip")) {
      paramHttpEntity = new GZIPInputStream(localInputStream);
    }
    return paramHttpEntity;
  }
  
  public static BeyondPodHttpClient newInstance(String paramString)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, Configuration.HttpConnectionTimeout() * 1000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, Configuration.HttpConnectionTimeout() * 1000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, paramString);
    paramString = new SchemeRegistry();
    paramString.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    paramString.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    return new BeyondPodHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, paramString), localBasicHttpParams);
  }
  
  private static String parseContentDisposition(String paramString)
  {
    try
    {
      paramString = CONTENT_DISPOSITION_PATTERN.matcher(paramString);
      if (paramString.find())
      {
        paramString = paramString.group(1);
        return paramString;
      }
    }
    catch (IllegalStateException paramString) {}
    return null;
  }
  
  public static void setThreadBlocked(boolean paramBoolean)
  {
    sThreadBlocked.set(Boolean.valueOf(paramBoolean));
  }
  
  public URI FinalDownloadUrl()
  {
    return this._BPRedirectHandler.LastRedirectedUri();
  }
  
  public void SetCredentialsTo(NetworkCredential paramNetworkCredential, URI paramURI)
  {
    if (paramNetworkCredential == null) {
      return;
    }
    ((DefaultHttpClient)this.delegate).getCredentialsProvider().setCredentials(new AuthScope(AuthScope.ANY_HOST, -1), new UsernamePasswordCredentials(paramNetworkCredential.UserName, paramNetworkCredential.Password));
  }
  
  public void close()
  {
    if (this.mLeakedException != null)
    {
      getConnectionManager().shutdown();
      this.mLeakedException = null;
    }
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws IOException, ClientProtocolException
  {
    return (T)this.delegate.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException
  {
    return (T)this.delegate.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws IOException, ClientProtocolException
  {
    return (T)this.delegate.execute(paramHttpUriRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException
  {
    return (T)this.delegate.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
    throws IOException
  {
    return this.delegate.execute(paramHttpHost, paramHttpRequest);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws IOException
  {
    return this.delegate.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    return this.delegate.execute(paramHttpUriRequest);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws IOException
  {
    return this.delegate.execute(paramHttpUriRequest, paramHttpContext);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.mLeakedException != null)
    {
      Log.e("AndroidHttpClient", "Leak found", this.mLeakedException);
      this.mLeakedException = null;
    }
  }
  
  public ClientConnectionManager getConnectionManager()
  {
    return this.delegate.getConnectionManager();
  }
  
  public HttpParams getParams()
  {
    return this.delegate.getParams();
  }
  
  private static class BPRedirectHandler
    extends DefaultRedirectHandler
  {
    URI _LastRedirectedUri;
    
    public URI LastRedirectedUri()
    {
      return this._LastRedirectedUri;
    }
    
    public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
      throws ProtocolException
    {
      try
      {
        this._LastRedirectedUri = super.getLocationURI(paramHttpResponse, paramHttpContext);
        return this._LastRedirectedUri;
      }
      catch (ProtocolException paramHttpContext)
      {
        while ((paramHttpContext.getCause() instanceof URISyntaxException))
        {
          paramHttpResponse = paramHttpResponse.getFirstHeader("location").getValue();
          CoreHelper.WriteTraceEntry("AndroidHttpClient", "Redirected to an invalid URL! Trying to patch... URL:" + paramHttpResponse + ", Error:" + paramHttpContext.getMessage());
          paramHttpContext = CoreHelper.SafeCreateURI(paramHttpResponse);
          if (paramHttpContext != null)
          {
            this._LastRedirectedUri = paramHttpContext;
            CoreHelper.WriteTraceEntry("AndroidHttpClient", "URL Patched!, Continue redirects...");
          }
          else
          {
            throw new ProtocolException("Invalid redirect URI: " + paramHttpResponse);
          }
        }
        throw paramHttpContext;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/BeyondPodHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */