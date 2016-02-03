package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.io.HttpTransportMetrics;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpTransportMetricsImpl
  implements HttpTransportMetrics
{
  private long bytesTransferred = 0L;
  
  public void incrementBytesTransferred(long paramLong)
  {
    this.bytesTransferred += paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/HttpTransportMetricsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */