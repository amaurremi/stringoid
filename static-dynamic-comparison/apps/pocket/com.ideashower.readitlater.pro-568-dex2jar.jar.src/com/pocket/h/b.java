package com.pocket.h;

import android.text.util.Rfc822Token;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.db.operation.f;
import org.apache.a.c.k;

public class b
{
  public static Rfc822Token a(f paramf)
  {
    return new Rfc822Token(paramf.h(), "Pocket", String.valueOf(paramf.a()));
  }
  
  public static boolean a(Rfc822Token paramRfc822Token)
  {
    return a(paramRfc822Token.getAddress(), paramRfc822Token.getComment());
  }
  
  public static boolean a(com.android.b.a.a parama)
  {
    return a(parama.a(), parama.b());
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (!k.b("Pocket", paramString1)) {}
    int i;
    do
    {
      return false;
      i = org.apache.a.c.d.a.a(paramString2);
    } while ((i == 0) || (o.c().b(i) == null));
    return true;
  }
  
  public static com.android.b.a.a b(Rfc822Token paramRfc822Token)
  {
    return new com.android.b.a.a("Pocket", paramRfc822Token.getComment());
  }
  
  public static f c(Rfc822Token paramRfc822Token)
  {
    return o.c().b(Integer.valueOf(paramRfc822Token.getComment()).intValue());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */