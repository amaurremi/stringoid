package com.amazonaws.org.apache.http.entity;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.message.BasicHeader;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractHttpEntity
  implements HttpEntity
{
  protected boolean chunked;
  protected Header contentEncoding;
  protected Header contentType;
  
  public Header getContentEncoding()
  {
    return this.contentEncoding;
  }
  
  public Header getContentType()
  {
    return this.contentType;
  }
  
  public boolean isChunked()
  {
    return this.chunked;
  }
  
  public void setChunked(boolean paramBoolean)
  {
    this.chunked = paramBoolean;
  }
  
  public void setContentEncoding(Header paramHeader)
  {
    this.contentEncoding = paramHeader;
  }
  
  public void setContentType(Header paramHeader)
  {
    this.contentType = paramHeader;
  }
  
  public void setContentType(String paramString)
  {
    BasicHeader localBasicHeader = null;
    if (paramString != null) {
      localBasicHeader = new BasicHeader("Content-Type", paramString);
    }
    setContentType(localBasicHeader);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/entity/AbstractHttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */