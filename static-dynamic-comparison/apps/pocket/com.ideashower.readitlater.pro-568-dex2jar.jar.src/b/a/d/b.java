package b.a.d;

import b.a.c.a;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class b
  extends c
{
  public String a()
  {
    return "HMAC-SHA1";
  }
  
  public String a(b.a.c.b paramb, a parama)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec((b.a.c.a(b()) + '&' + b.a.c.a(c())).getBytes("UTF-8"), "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(localSecretKeySpec);
      paramb = new d(paramb, parama).a();
      b.a.c.a("SBS", paramb);
      paramb = a(localMac.doFinal(paramb.getBytes("UTF-8"))).trim();
      return paramb;
    }
    catch (GeneralSecurityException paramb)
    {
      throw new b.a.b.d(paramb);
    }
    catch (UnsupportedEncodingException paramb)
    {
      throw new b.a.b.d(paramb);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */