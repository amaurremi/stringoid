package com.google.api.client.http;

import com.google.api.client.util.x;
import java.io.InputStream;

public final class y
  extends b
{
  private long abP = -1L;
  private boolean abQ;
  private final InputStream abR;
  
  public y(String paramString, InputStream paramInputStream)
  {
    super(paramString);
    this.abR = ((InputStream)x.ad(paramInputStream));
  }
  
  public y at(boolean paramBoolean)
  {
    this.abQ = paramBoolean;
    return this;
  }
  
  public y au(boolean paramBoolean)
  {
    return (y)super.ap(paramBoolean);
  }
  
  public y ck(String paramString)
  {
    return (y)super.bH(paramString);
  }
  
  public InputStream getInputStream()
  {
    return this.abR;
  }
  
  public long getLength()
  {
    return this.abP;
  }
  
  public boolean xl()
  {
    return this.abQ;
  }
  
  public y y(long paramLong)
  {
    this.abP = paramLong;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */