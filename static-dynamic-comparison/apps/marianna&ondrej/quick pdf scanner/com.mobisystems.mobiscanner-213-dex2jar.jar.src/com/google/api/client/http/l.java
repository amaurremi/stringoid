package com.google.api.client.http;

import com.google.api.client.util.aa;
import com.google.api.client.util.x;
import java.io.OutputStream;

public final class l
  implements aa
{
  private final aa aaZ;
  private final k aba;
  
  public l(aa paramaa, k paramk)
  {
    this.aaZ = ((aa)x.ad(paramaa));
    this.aba = ((k)x.ad(paramk));
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    this.aba.a(this.aaZ, paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */