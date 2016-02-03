package com.google.api.client.http.a;

import com.google.api.client.util.aa;
import com.google.api.client.util.x;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

final class d
  extends AbstractHttpEntity
{
  private final long abS;
  private final aa abT;
  
  d(long paramLong, aa paramaa)
  {
    this.abS = paramLong;
    this.abT = ((aa)x.ad(paramaa));
  }
  
  public InputStream getContent()
  {
    throw new UnsupportedOperationException();
  }
  
  public long getContentLength()
  {
    return this.abS;
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public boolean isStreaming()
  {
    return true;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (this.abS != 0L) {
      this.abT.writeTo(paramOutputStream);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */