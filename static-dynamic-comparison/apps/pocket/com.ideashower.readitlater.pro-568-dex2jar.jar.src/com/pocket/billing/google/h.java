package com.pocket.billing.google;

import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.util.l;
import com.pocket.c.af;
import com.pocket.c.ag;
import com.pocket.c.f;
import com.pocket.c.g;
import java.util.HashSet;
import java.util.Set;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class h
{
  private static final Object a = new Object();
  private static Set b = new HashSet();
  
  private static void a(GooglePremiumProduct paramGooglePremiumProduct, String paramString1, String paramString2, ag paramag)
  {
    ObjectNode localObjectNode = l.b();
    localObjectNode.put("product", paramGooglePremiumProduct.j());
    localObjectNode.put("data", paramString1);
    localObjectNode.put("sig", paramString2);
    if (paramag == ag.b) {}
    for (boolean bool = true;; bool = false)
    {
      localObjectNode.put("restore", bool);
      com.ideashower.readitlater.h.i.a(a.cg, localObjectNode.toString());
      return;
    }
  }
  
  public static void a(GooglePremiumProduct paramGooglePremiumProduct, final String paramString1, String paramString2, ag paramag, i parami)
  {
    synchronized (a)
    {
      if (b.contains(paramString1)) {
        return;
      }
      b.add(paramString1);
      a(paramGooglePremiumProduct, paramString1, paramString2, paramag);
      paramGooglePremiumProduct = new af(paramGooglePremiumProduct, paramString1, paramString2, paramag);
      paramGooglePremiumProduct.a(new g()
      {
        public void a(f arg1, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            com.ideashower.readitlater.h.i.a(a.cg, null);
            if (h.this != null) {
              h.this.a();
            }
            com.pocket.c.e.l();
          }
          synchronized (h.b())
          {
            do
            {
              h.c().remove(paramString1);
              return;
            } while (h.this == null);
            h.this.a(???.t());
          }
        }
      });
      paramGooglePremiumProduct.h();
      return;
    }
  }
  
  public static void a(i parami)
  {
    String str1 = com.ideashower.readitlater.h.i.a(a.cg);
    if (str1 != null) {
      try
      {
        Object localObject = l.a(str1);
        GooglePremiumProduct localGooglePremiumProduct = GooglePremiumProduct.a(((ObjectNode)localObject).get("product").asText());
        String str2 = ((ObjectNode)localObject).get("data").asText();
        String str3 = ((ObjectNode)localObject).get("sig").asText();
        if (l.a((JsonNode)localObject, "restore", false)) {}
        for (localObject = ag.b;; localObject = ag.a)
        {
          a(localGooglePremiumProduct, str2, str3, (ag)localObject, parami);
          return;
        }
        return;
      }
      catch (Throwable parami)
      {
        com.ideashower.readitlater.util.e.a(parami, true);
        com.ideashower.readitlater.h.i.a(a.cg, null);
        com.ideashower.readitlater.util.e.a("invalid purchase data: " + str1);
      }
    }
  }
  
  public static boolean a()
  {
    return com.ideashower.readitlater.h.i.a(a.cg) != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/google/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */