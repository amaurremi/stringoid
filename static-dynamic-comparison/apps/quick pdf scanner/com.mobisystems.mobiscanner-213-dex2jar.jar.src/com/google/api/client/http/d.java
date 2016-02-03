package com.google.api.client.http;

import com.google.api.client.util.x;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class d
  extends b
{
  private final byte[] aaQ;
  private final int length;
  private final int offset;
  
  public d(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.aaQ = ((byte[])x.ad(paramArrayOfByte));
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length)) {}
    for (boolean bool = true;; bool = false)
    {
      x.b(bool, "offset %s, length %s, array length %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      this.offset = paramInt1;
      this.length = paramInt2;
      return;
    }
  }
  
  public d aq(boolean paramBoolean)
  {
    return (d)super.ap(paramBoolean);
  }
  
  public d bI(String paramString)
  {
    return (d)super.bH(paramString);
  }
  
  public InputStream getInputStream()
  {
    return new ByteArrayInputStream(this.aaQ, this.offset, this.length);
  }
  
  public long getLength()
  {
    return this.length;
  }
  
  public boolean xl()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */