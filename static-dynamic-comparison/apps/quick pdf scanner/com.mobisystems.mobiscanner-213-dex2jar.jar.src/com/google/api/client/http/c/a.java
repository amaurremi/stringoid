package com.google.api.client.http.c;

import com.google.api.client.json.c;
import com.google.api.client.json.d;
import com.google.api.client.json.e;
import com.google.api.client.util.x;
import java.io.OutputStream;

public class a
  extends com.google.api.client.http.a
{
  private final d acn;
  private String aco;
  private final Object data;
  
  public a(d paramd, Object paramObject)
  {
    super(c.MEDIA_TYPE);
    this.acn = ((d)x.ad(paramd));
    this.data = x.ad(paramObject);
  }
  
  public a cn(String paramString)
  {
    this.aco = paramString;
    return this;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream = this.acn.a(paramOutputStream, xj());
    if (this.aco != null)
    {
      paramOutputStream.yg();
      paramOutputStream.cp(this.aco);
    }
    paramOutputStream.ab(this.data);
    if (this.aco != null) {
      paramOutputStream.yh();
    }
    paramOutputStream.flush();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */