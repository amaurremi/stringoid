package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.e;
import com.pocket.billing.google.GooglePremiumProduct;
import java.io.InputStream;

public class af
  extends f
{
  private final GooglePremiumProduct a;
  private final String b;
  private final String h;
  private final ag p;
  
  public af(GooglePremiumProduct paramGooglePremiumProduct, String paramString1, String paramString2, ag paramag)
  {
    super(2);
    this.a = paramGooglePremiumProduct;
    this.b = paramString1;
    this.h = paramString2;
    this.p = paramag;
    if (paramag == null) {
      e.a("missing type", true);
    }
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/purchase", true);
    locala.a("source", "googleplay");
    locala.a("product_id", this.a.f());
    locala.a("amount", this.a.h());
    locala.a("amount_display", this.a.a());
    locala.a("currency", this.a.i());
    locala.a("transaction_info", this.b);
    if (this.p == ag.a) {}
    for (String str = "purchase";; str = "restore")
    {
      locala.a("transaction_type", str);
      return locala;
    }
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        if (af.this.a_()) {
          return 3;
        }
        if (!paramAnonymousBoolean) {
          return 2;
        }
        return 1;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */