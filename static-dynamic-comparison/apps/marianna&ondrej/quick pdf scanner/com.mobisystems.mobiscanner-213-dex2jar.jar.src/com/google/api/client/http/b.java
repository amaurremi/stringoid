package com.google.api.client.http;

import com.google.api.client.util.m;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class b
  implements j
{
  private boolean aaP = true;
  private String type;
  
  public b(String paramString)
  {
    bH(paramString);
  }
  
  public b ap(boolean paramBoolean)
  {
    this.aaP = paramBoolean;
    return this;
  }
  
  public b bH(String paramString)
  {
    this.type = paramString;
    return this;
  }
  
  public abstract InputStream getInputStream();
  
  public String getType()
  {
    return this.type;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    m.a(getInputStream(), paramOutputStream, this.aaP);
    paramOutputStream.flush();
  }
  
  public final boolean xm()
  {
    return this.aaP;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */