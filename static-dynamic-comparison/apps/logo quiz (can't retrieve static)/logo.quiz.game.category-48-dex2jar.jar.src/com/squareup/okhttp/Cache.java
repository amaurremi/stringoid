package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.DiskLruCache.Editor;
import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okio.BufferedSource;
import com.squareup.okio.ByteString;
import com.squareup.okio.ForwardingSource;
import com.squareup.okio.Okio;
import com.squareup.okio.Source;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheRequest;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

public final class Cache
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  private final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new InternalCache()
  {
    public Response get(Request paramAnonymousRequest)
      throws IOException
    {
      return Cache.this.get(paramAnonymousRequest);
    }
    
    public CacheRequest put(Response paramAnonymousResponse)
      throws IOException
    {
      return Cache.this.put(paramAnonymousResponse);
    }
    
    public void remove(Request paramAnonymousRequest)
      throws IOException
    {
      Cache.this.remove(paramAnonymousRequest);
    }
    
    public void trackConditionalCacheHit()
    {
      Cache.this.trackConditionalCacheHit();
    }
    
    public void trackResponse(CacheStrategy paramAnonymousCacheStrategy)
    {
      Cache.this.trackResponse(paramAnonymousCacheStrategy);
    }
    
    public void update(Response paramAnonymousResponse1, Response paramAnonymousResponse2)
      throws IOException
    {
      Cache.this.update(paramAnonymousResponse1, paramAnonymousResponse2);
    }
  };
  private int networkCount;
  private int requestCount;
  private int writeAbortCount;
  private int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong)
    throws IOException
  {
    this.cache = DiskLruCache.open(paramFile, 201105, 2, paramLong);
  }
  
  private void abortQuietly(DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null) {}
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor) {}
  }
  
  private CacheRequest put(Response paramResponse)
    throws IOException
  {
    Object localObject = paramResponse.request().method();
    if (HttpMethod.invalidatesCache(paramResponse.request().method())) {}
    for (;;)
    {
      try
      {
        remove(paramResponse.request());
        return null;
      }
      catch (IOException paramResponse) {}
      if ((((String)localObject).equals("GET")) && (!OkHeaders.hasVaryAll(paramResponse)))
      {
        Entry localEntry = new Entry(paramResponse);
        localObject = null;
        try
        {
          paramResponse = this.cache.edit(urlToKey(paramResponse.request()));
          if (paramResponse != null)
          {
            localObject = paramResponse;
            localEntry.writeTo(paramResponse);
            localObject = paramResponse;
            paramResponse = new CacheRequestImpl(paramResponse);
            return paramResponse;
          }
        }
        catch (IOException paramResponse)
        {
          abortQuietly((DiskLruCache.Editor)localObject);
          return null;
        }
      }
    }
    return null;
  }
  
  private static int readInt(BufferedSource paramBufferedSource)
    throws IOException
  {
    paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
    try
    {
      int i = Integer.parseInt(paramBufferedSource);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IOException("Expected an integer but was \"" + paramBufferedSource + "\"");
    }
  }
  
  private void remove(Request paramRequest)
    throws IOException
  {
    this.cache.remove(urlToKey(paramRequest));
  }
  
  private void trackConditionalCacheHit()
  {
    try
    {
      this.hitCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void trackResponse(CacheStrategy paramCacheStrategy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 193	com/squareup/okhttp/Cache:requestCount	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 193	com/squareup/okhttp/Cache:requestCount	I
    //   12: aload_1
    //   13: getfield 199	com/squareup/okhttp/internal/http/CacheStrategy:networkRequest	Lcom/squareup/okhttp/Request;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 201	com/squareup/okhttp/Cache:networkCount	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 201	com/squareup/okhttp/Cache:networkCount	I
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: getfield 205	com/squareup/okhttp/internal/http/CacheStrategy:cacheResponse	Lcom/squareup/okhttp/Response;
    //   36: ifnull -7 -> 29
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 191	com/squareup/okhttp/Cache:hitCount	I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield 191	com/squareup/okhttp/Cache:hitCount	I
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Cache
    //   0	57	1	paramCacheStrategy	CacheStrategy
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  private void update(Response paramResponse1, Response paramResponse2)
  {
    Entry localEntry = new Entry(paramResponse2);
    paramResponse2 = ((CacheResponseBody)paramResponse1.body()).snapshot;
    paramResponse1 = null;
    try
    {
      paramResponse2 = paramResponse2.edit();
      if (paramResponse2 != null)
      {
        paramResponse1 = paramResponse2;
        localEntry.writeTo(paramResponse2);
        paramResponse1 = paramResponse2;
        paramResponse2.commit();
      }
      return;
    }
    catch (IOException paramResponse2)
    {
      abortQuietly(paramResponse1);
    }
  }
  
  private static String urlToKey(Request paramRequest)
  {
    return Util.hash(paramRequest.urlString());
  }
  
  public void close()
    throws IOException
  {
    this.cache.close();
  }
  
  public void delete()
    throws IOException
  {
    this.cache.delete();
  }
  
  public void flush()
    throws IOException
  {
    this.cache.flush();
  }
  
  Response get(Request paramRequest)
  {
    Object localObject = urlToKey(paramRequest);
    for (;;)
    {
      try
      {
        localObject = this.cache.get((String)localObject);
        if (localObject == null)
        {
          localObject = null;
          return (Response)localObject;
        }
      }
      catch (IOException paramRequest)
      {
        return null;
      }
      try
      {
        Entry localEntry = new Entry(((DiskLruCache.Snapshot)localObject).getInputStream(0));
        Response localResponse = localEntry.response(paramRequest, (DiskLruCache.Snapshot)localObject);
        localObject = localResponse;
        if (!localEntry.matches(paramRequest, localResponse))
        {
          Util.closeQuietly(localResponse.body());
          return null;
        }
      }
      catch (IOException paramRequest)
      {
        Util.closeQuietly((Closeable)localObject);
      }
    }
    return null;
  }
  
  public File getDirectory()
  {
    return this.cache.getDirectory();
  }
  
  public int getHitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getMaxSize()
  {
    return this.cache.getMaxSize();
  }
  
  public int getNetworkCount()
  {
    try
    {
      int i = this.networkCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getRequestCount()
  {
    try
    {
      int i = this.requestCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getSize()
  {
    return this.cache.size();
  }
  
  public int getWriteAbortCount()
  {
    try
    {
      int i = this.writeAbortCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getWriteSuccessCount()
  {
    try
    {
      int i = this.writeSuccessCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isClosed()
  {
    return this.cache.isClosed();
  }
  
  private final class CacheRequestImpl
    extends CacheRequest
  {
    private OutputStream body;
    private OutputStream cacheOut;
    private boolean done;
    private final DiskLruCache.Editor editor;
    
    public CacheRequestImpl(final DiskLruCache.Editor paramEditor)
      throws IOException
    {
      this.editor = paramEditor;
      this.cacheOut = paramEditor.newOutputStream(1);
      this.body = new FilterOutputStream(this.cacheOut)
      {
        public void close()
          throws IOException
        {
          synchronized (Cache.this)
          {
            if (Cache.CacheRequestImpl.this.done) {
              return;
            }
            Cache.CacheRequestImpl.access$602(Cache.CacheRequestImpl.this, true);
            Cache.access$708(Cache.this);
            super.close();
            paramEditor.commit();
            return;
          }
        }
        
        public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
          throws IOException
        {
          this.out.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
      };
    }
    
    public void abort()
    {
      synchronized (Cache.this)
      {
        if (this.done) {
          return;
        }
        this.done = true;
        Cache.access$808(Cache.this);
        Util.closeQuietly(this.cacheOut);
        try
        {
          this.editor.abort();
          return;
        }
        catch (IOException localIOException) {}
      }
    }
    
    public OutputStream getBody()
      throws IOException
    {
      return this.body;
    }
  }
  
  private static class CacheResponseBody
    extends ResponseBody
  {
    private final BufferedSource bodySource;
    private final String contentLength;
    private final String contentType;
    private final DiskLruCache.Snapshot snapshot;
    
    public CacheResponseBody(final DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
    {
      this.snapshot = paramSnapshot;
      this.contentType = paramString1;
      this.contentLength = paramString2;
      this.bodySource = Okio.buffer(new ForwardingSource(Okio.source(paramSnapshot.getInputStream(1)))
      {
        public void close()
          throws IOException
        {
          paramSnapshot.close();
          super.close();
        }
      });
    }
    
    public long contentLength()
    {
      long l = -1L;
      try
      {
        if (this.contentLength != null) {
          l = Long.parseLong(this.contentLength);
        }
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
      return -1L;
    }
    
    public MediaType contentType()
    {
      if (this.contentType != null) {
        return MediaType.parse(this.contentType);
      }
      return null;
    }
    
    public BufferedSource source()
    {
      return this.bodySource;
    }
  }
  
  private static final class Entry
  {
    private final int code;
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final String url;
    private final Headers varyHeaders;
    
    public Entry(Response paramResponse)
    {
      this.url = paramResponse.request().urlString();
      this.varyHeaders = OkHeaders.varyHeaders(paramResponse);
      this.requestMethod = paramResponse.request().method();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.responseHeaders = paramResponse.headers();
      this.handshake = paramResponse.handshake();
    }
    
    public Entry(InputStream paramInputStream)
      throws IOException
    {
      try
      {
        BufferedSource localBufferedSource1 = Okio.buffer(Okio.source(paramInputStream));
        this.url = localBufferedSource1.readUtf8LineStrict();
        this.requestMethod = localBufferedSource1.readUtf8LineStrict();
        Object localObject = new Headers.Builder();
        int j = Cache.readInt(localBufferedSource1);
        int i = 0;
        while (i < j)
        {
          ((Headers.Builder)localObject).addLine(localBufferedSource1.readUtf8LineStrict());
          i += 1;
        }
        this.varyHeaders = ((Headers.Builder)localObject).build();
        localObject = StatusLine.parse(localBufferedSource1.readUtf8LineStrict());
        this.protocol = ((StatusLine)localObject).protocol;
        this.code = ((StatusLine)localObject).code;
        this.message = ((StatusLine)localObject).message;
        localObject = new Headers.Builder();
        j = Cache.readInt(localBufferedSource1);
        i = 0;
        while (i < j)
        {
          ((Headers.Builder)localObject).addLine(localBufferedSource1.readUtf8LineStrict());
          i += 1;
        }
        this.responseHeaders = ((Headers.Builder)localObject).build();
        if (isHttps())
        {
          localObject = localBufferedSource1.readUtf8LineStrict();
          if (((String)localObject).length() > 0) {
            throw new IOException("expected \"\" but was \"" + (String)localObject + "\"");
          }
        }
      }
      finally
      {
        paramInputStream.close();
      }
      for (this.handshake = Handshake.get(localBufferedSource2.readUtf8LineStrict(), readCertificateList(localBufferedSource2), readCertificateList(localBufferedSource2));; this.handshake = null)
      {
        paramInputStream.close();
        return;
      }
    }
    
    private boolean isHttps()
    {
      return this.url.startsWith("https://");
    }
    
    /* Error */
    private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
      throws IOException
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 102	com/squareup/okhttp/Cache:access$900	(Lcom/squareup/okio/BufferedSource;)I
      //   4: istore_3
      //   5: iload_3
      //   6: iconst_m1
      //   7: if_icmpne +11 -> 18
      //   10: invokestatic 174	java/util/Collections:emptyList	()Ljava/util/List;
      //   13: astore 4
      //   15: aload 4
      //   17: areturn
      //   18: ldc -80
      //   20: invokestatic 182	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
      //   23: astore 6
      //   25: new 184	java/util/ArrayList
      //   28: dup
      //   29: iload_3
      //   30: invokespecial 187	java/util/ArrayList:<init>	(I)V
      //   33: astore 5
      //   35: iconst_0
      //   36: istore_2
      //   37: aload 5
      //   39: astore 4
      //   41: iload_2
      //   42: iload_3
      //   43: if_icmpge -28 -> 15
      //   46: aload 5
      //   48: aload 6
      //   50: new 189	java/io/ByteArrayInputStream
      //   53: dup
      //   54: aload_1
      //   55: invokeinterface 95 1 0
      //   60: invokestatic 195	com/squareup/okio/ByteString:decodeBase64	(Ljava/lang/String;)Lcom/squareup/okio/ByteString;
      //   63: invokevirtual 199	com/squareup/okio/ByteString:toByteArray	()[B
      //   66: invokespecial 202	java/io/ByteArrayInputStream:<init>	([B)V
      //   69: invokevirtual 206	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
      //   72: invokeinterface 212 2 0
      //   77: pop
      //   78: iload_2
      //   79: iconst_1
      //   80: iadd
      //   81: istore_2
      //   82: goto -45 -> 37
      //   85: astore_1
      //   86: new 80	java/io/IOException
      //   89: dup
      //   90: aload_1
      //   91: invokevirtual 215	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
      //   94: invokespecial 144	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   97: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	98	0	this	Entry
      //   0	98	1	paramBufferedSource	BufferedSource
      //   36	46	2	i	int
      //   4	40	3	j	int
      //   13	27	4	localObject	Object
      //   33	14	5	localArrayList	java.util.ArrayList
      //   23	26	6	localCertificateFactory	java.security.cert.CertificateFactory
      // Exception table:
      //   from	to	target	type
      //   18	35	85	java/security/cert/CertificateException
      //   46	78	85	java/security/cert/CertificateException
    }
    
    private void writeCertArray(Writer paramWriter, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramWriter.write(Integer.toString(paramList.size()));
        paramWriter.write(10);
        int i = 0;
        int j = paramList.size();
        while (i < j)
        {
          paramWriter.write(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64());
          paramWriter.write(10);
          i += 1;
        }
        return;
      }
      catch (CertificateEncodingException paramWriter)
      {
        throw new IOException(paramWriter.getMessage());
      }
    }
    
    public boolean matches(Request paramRequest, Response paramResponse)
    {
      return (this.url.equals(paramRequest.urlString())) && (this.requestMethod.equals(paramRequest.method())) && (OkHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest));
    }
    
    public Response response(Request paramRequest, DiskLruCache.Snapshot paramSnapshot)
    {
      paramRequest = this.responseHeaders.get("Content-Type");
      String str = this.responseHeaders.get("Content-Length");
      Request localRequest = new Request.Builder().url(this.url).method(this.message, null).headers(this.varyHeaders).build();
      return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, paramRequest, str)).handshake(this.handshake).build();
    }
    
    public void writeTo(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      paramEditor = new BufferedWriter(new OutputStreamWriter(paramEditor.newOutputStream(0), Util.UTF_8));
      paramEditor.write(this.url);
      paramEditor.write(10);
      paramEditor.write(this.requestMethod);
      paramEditor.write(10);
      paramEditor.write(Integer.toString(this.varyHeaders.size()));
      paramEditor.write(10);
      int i = 0;
      while (i < this.varyHeaders.size())
      {
        paramEditor.write(this.varyHeaders.name(i));
        paramEditor.write(": ");
        paramEditor.write(this.varyHeaders.value(i));
        paramEditor.write(10);
        i += 1;
      }
      paramEditor.write(new StatusLine(this.protocol, this.code, this.message).toString());
      paramEditor.write(10);
      paramEditor.write(Integer.toString(this.responseHeaders.size()));
      paramEditor.write(10);
      i = 0;
      while (i < this.responseHeaders.size())
      {
        paramEditor.write(this.responseHeaders.name(i));
        paramEditor.write(": ");
        paramEditor.write(this.responseHeaders.value(i));
        paramEditor.write(10);
        i += 1;
      }
      if (isHttps())
      {
        paramEditor.write(10);
        paramEditor.write(this.handshake.cipherSuite());
        paramEditor.write(10);
        writeCertArray(paramEditor, this.handshake.peerCertificates());
        writeCertArray(paramEditor, this.handshake.localCertificates());
      }
      paramEditor.close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */