package com.pocket.c;

import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import java.io.InputStream;
import org.apache.http.util.EncodingUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class r
  extends f
{
  private final s a;
  private String b;
  private String h;
  private byte[] p;
  
  public r(s params)
  {
    super(2);
    this.a = params;
  }
  
  protected void a(int paramInt)
  {
    if ((paramInt == 3) && (this.b != null) && (this.p != null))
    {
      this.a.a(this, this.b, this.h, this.p);
      return;
    }
    this.a.a();
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/bookmarklet", true);
    locala.a(false);
    return locala;
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        paramAnonymousInputStream = (ObjectNode)l.a().readTree(paramAnonymousInputStream);
        r.a(r.this, paramAnonymousInputStream.get("t").asText());
        r.b(r.this, "u=" + as.i() + "&t=" + r.a(r.this));
        r.a(r.this, EncodingUtils.getBytes(r.b(r.this), "BASE64"));
        if (r.c(r.this) != null) {
          return 1;
        }
        return 2;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */