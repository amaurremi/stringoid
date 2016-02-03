package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import java.io.InputStream;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class y
  extends f
{
  private final String a;
  private final z b;
  private boolean h;
  private String p;
  private String q;
  private String r;
  private String s;
  private boolean t;
  
  public y(String paramString, z paramz)
  {
    super(1);
    this.a = paramString;
    this.b = paramz;
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == 3) {}
    for (int i = 1; i == 0; i = 0)
    {
      e.a(paramInt, this.d, this.c, this.f, true);
      this.b.g_();
      return;
    }
    this.b.a(this.h, this.p, this.q, this.r, this.s, this.t);
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/oauth/request_meta", true);
    locala.a("request_token", this.a);
    locala.c(this.a);
    return locala;
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        paramAnonymousInputStream = (ObjectNode)l.a().readTree(paramAnonymousInputStream);
        y.a(y.this, paramAnonymousInputStream.get("is_valid").asBoolean());
        y.b(y.this, paramAnonymousInputStream.get("has_access_token").asBoolean());
        if ((y.a(y.this)) && (y.b(y.this))) {
          return 1;
        }
        y.a(y.this, paramAnonymousInputStream.get("app_name").asText());
        y.b(y.this, paramAnonymousInputStream.get("app_description").asText());
        y.c(y.this, paramAnonymousInputStream.get("app_icon").asText());
        y.d(y.this, paramAnonymousInputStream.get("permission").asText());
        return 1;
      }
    };
  }
  
  protected boolean m()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */