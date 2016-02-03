package b.a;

import b.a.d.e;
import java.io.IOException;
import java.util.Random;

public abstract class a
  implements d
{
  private String a;
  private String b;
  private String c;
  private b.a.d.c d;
  private e e;
  private b.a.c.a f;
  private b.a.c.a g;
  private boolean h;
  private final Random i = new Random(System.nanoTime());
  
  public a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    a(new b.a.d.b());
    a(new b.a.d.a());
  }
  
  public b.a.c.b a(b.a.c.b paramb)
  {
    try
    {
      if (this.a == null) {
        throw new b.a.b.c("consumer key not set");
      }
    }
    finally {}
    if (this.b == null) {
      throw new b.a.b.c("consumer secret not set");
    }
    this.g = new b.a.c.a();
    try
    {
      if (this.f != null) {
        this.g.a(this.f, false);
      }
      a(paramb, this.g);
      c(paramb, this.g);
      b(paramb, this.g);
      b(this.g);
      this.g.c("oauth_signature");
      String str = this.d.a(paramb, this.g);
      c.a("signature", str);
      this.e.a(str, paramb, this.g);
      c.a("Request URL", paramb.b());
      return paramb;
    }
    catch (IOException paramb)
    {
      throw new b.a.b.a(paramb);
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(b.a.c.a parama)
  {
    this.f = parama;
  }
  
  protected void a(b.a.c.b paramb, b.a.c.a parama)
  {
    parama.a(c.e(paramb.a("Authorization")), false);
  }
  
  public void a(b.a.d.c paramc)
  {
    this.d = paramc;
    paramc.a(this.b);
  }
  
  public void a(e parame)
  {
    this.e = parame;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d.b(paramString2);
  }
  
  public String b()
  {
    return this.d.c();
  }
  
  protected void b(b.a.c.a parama)
  {
    if (!parama.containsKey("oauth_consumer_key")) {
      parama.a("oauth_consumer_key", this.a, true);
    }
    if (!parama.containsKey("oauth_signature_method")) {
      parama.a("oauth_signature_method", this.d.a(), true);
    }
    if (!parama.containsKey("oauth_timestamp")) {
      parama.a("oauth_timestamp", e(), true);
    }
    if (!parama.containsKey("oauth_nonce")) {
      parama.a("oauth_nonce", f(), true);
    }
    if (!parama.containsKey("oauth_version")) {
      parama.a("oauth_version", "1.0", true);
    }
    if ((!parama.containsKey("oauth_token")) && (((this.c != null) && (!this.c.equals(""))) || (this.h))) {
      parama.a("oauth_token", this.c, true);
    }
  }
  
  protected void b(b.a.c.b paramb, b.a.c.a parama)
  {
    String str = paramb.c();
    if ((str != null) && (str.startsWith("application/x-www-form-urlencoded"))) {
      parama.a(c.a(paramb.d()), true);
    }
  }
  
  public String c()
  {
    return this.a;
  }
  
  protected void c(b.a.c.b paramb, b.a.c.a parama)
  {
    paramb = paramb.b();
    int j = paramb.indexOf('?');
    if (j >= 0) {
      parama.a(c.c(paramb.substring(j + 1)), true);
    }
  }
  
  public String d()
  {
    return this.b;
  }
  
  protected String e()
  {
    return Long.toString(System.currentTimeMillis() / 1000L);
  }
  
  protected String f()
  {
    return Long.toString(this.i.nextLong());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */