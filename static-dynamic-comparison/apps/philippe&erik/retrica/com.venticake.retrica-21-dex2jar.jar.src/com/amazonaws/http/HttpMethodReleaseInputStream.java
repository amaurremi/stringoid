package com.amazonaws.http;

import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.client.methods.AbortableHttpRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpMethodReleaseInputStream
  extends SdkInputStream
{
  private static final Log log = LogFactory.getLog(HttpMethodReleaseInputStream.class);
  private boolean alreadyReleased;
  private HttpEntityEnclosingRequest httpRequest;
  private InputStream in;
  private boolean underlyingStreamConsumed;
  
  public HttpMethodReleaseInputStream(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    this.httpRequest = paramHttpEntityEnclosingRequest;
    try
    {
      this.in = paramHttpEntityEnclosingRequest.getEntity().getContent();
      return;
    }
    catch (IOException localIOException)
    {
      if (log.isWarnEnabled()) {
        log.warn("Unable to obtain HttpMethod's response data stream", localIOException);
      }
    }
    try
    {
      paramHttpEntityEnclosingRequest.getEntity().getContent().close();
      this.in = new ByteArrayInputStream(new byte[0]);
      return;
    }
    catch (Exception paramHttpEntityEnclosingRequest)
    {
      for (;;) {}
    }
  }
  
  public int available()
  {
    try
    {
      int i = this.in.available();
      return i;
    }
    catch (IOException localIOException)
    {
      releaseConnection();
      if (log.isDebugEnabled()) {
        log.debug("Released HttpMethod as its response data stream threw an exception", localIOException);
      }
      throw localIOException;
    }
  }
  
  public void close()
  {
    if (!this.alreadyReleased)
    {
      releaseConnection();
      if (log.isDebugEnabled()) {
        log.debug("Released HttpMethod as its response data stream is closed");
      }
    }
    this.in.close();
  }
  
  protected void finalize()
  {
    if (!this.alreadyReleased)
    {
      if (log.isWarnEnabled()) {
        log.warn("Attempting to release HttpMethod in finalize() as its response data stream has gone out of scope. This attempt will not always succeed and cannot be relied upon! Please ensure S3 response data streams are always fully consumed or closed to avoid HTTP connection starvation.");
      }
      releaseConnection();
      if (log.isWarnEnabled()) {
        log.warn("Successfully released HttpMethod in finalize(). You were lucky this time... Please ensure S3 response data streams are always fully consumed or closed.");
      }
    }
    super.finalize();
  }
  
  protected InputStream getWrappedInputStream()
  {
    return this.in;
  }
  
  public int read()
  {
    try
    {
      int i = this.in.read();
      if (i == -1)
      {
        this.underlyingStreamConsumed = true;
        if (!this.alreadyReleased)
        {
          releaseConnection();
          if (log.isDebugEnabled()) {
            log.debug("Released HttpMethod as its response data stream is fully consumed");
          }
        }
      }
      return i;
    }
    catch (IOException localIOException)
    {
      releaseConnection();
      if (log.isDebugEnabled()) {
        log.debug("Released HttpMethod as its response data stream threw an exception", localIOException);
      }
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        this.underlyingStreamConsumed = true;
        if (!this.alreadyReleased)
        {
          releaseConnection();
          if (log.isDebugEnabled()) {
            log.debug("Released HttpMethod as its response data stream is fully consumed");
          }
        }
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      releaseConnection();
      if (log.isDebugEnabled()) {
        log.debug("Released HttpMethod as its response data stream threw an exception", paramArrayOfByte);
      }
      throw paramArrayOfByte;
    }
  }
  
  protected void releaseConnection()
  {
    if (!this.alreadyReleased)
    {
      if ((!this.underlyingStreamConsumed) && ((this.httpRequest instanceof AbortableHttpRequest))) {
        ((AbortableHttpRequest)this.httpRequest).abort();
      }
      this.in.close();
      this.alreadyReleased = true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpMethodReleaseInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */