package com.google.api.client.http;

public abstract class z
{
  private String abJ;
  private String abK;
  private long abS = -1L;
  private com.google.api.client.util.aa abT;
  
  public final void a(com.google.api.client.util.aa paramaa)
  {
    this.abT = paramaa;
  }
  
  public abstract void addHeader(String paramString1, String paramString2);
  
  public final String getContentEncoding()
  {
    return this.abJ;
  }
  
  public final long getContentLength()
  {
    return this.abS;
  }
  
  public final String getContentType()
  {
    return this.abK;
  }
  
  public final void setContentEncoding(String paramString)
  {
    this.abJ = paramString;
  }
  
  public final void setContentLength(long paramLong)
  {
    this.abS = paramLong;
  }
  
  public final void setContentType(String paramString)
  {
    this.abK = paramString;
  }
  
  public void v(int paramInt1, int paramInt2) {}
  
  public final com.google.api.client.util.aa xU()
  {
    return this.abT;
  }
  
  public abstract aa xu();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */