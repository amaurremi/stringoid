package com.google.api.client.http.a;

import com.google.api.client.util.x;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

final class e
  extends HttpEntityEnclosingRequestBase
{
  private final String ach;
  
  public e(String paramString1, String paramString2)
  {
    this.ach = ((String)x.ad(paramString1));
    setURI(URI.create(paramString2));
  }
  
  public String getMethod()
  {
    return this.ach;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */