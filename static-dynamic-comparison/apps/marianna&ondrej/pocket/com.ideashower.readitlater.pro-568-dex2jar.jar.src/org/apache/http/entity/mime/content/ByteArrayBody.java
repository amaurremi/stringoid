package org.apache.http.entity.mime.content;

import java.io.OutputStream;

public class ByteArrayBody
  extends AbstractContentBody
{
  private final byte[] data;
  private final String filename;
  
  public ByteArrayBody(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte, "application/octet-stream", paramString);
  }
  
  public ByteArrayBody(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    super(paramString1);
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("byte[] may not be null");
    }
    this.data = paramArrayOfByte;
    this.filename = paramString2;
  }
  
  public String getCharset()
  {
    return null;
  }
  
  public long getContentLength()
  {
    return this.data.length;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public String getTransferEncoding()
  {
    return "binary";
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream.write(this.data);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/http/entity/mime/content/ByteArrayBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */