package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import com.pocket.billing.PremiumStatus;
import java.io.InputStream;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class j
  extends f
{
  private final k a;
  private PremiumStatus b;
  private boolean h;
  
  public j(k paramk)
  {
    super(2);
    this.a = paramk;
  }
  
  protected void a(int paramInt)
  {
    k localk = this.a;
    PremiumStatus localPremiumStatus = this.b;
    if (paramInt == 3) {}
    for (boolean bool = true;; bool = false)
    {
      localk.a(localPremiumStatus, bool, this.d, this.h);
      return;
    }
  }
  
  protected int b(a parama)
  {
    switch (parama.e())
    {
    }
    for (;;)
    {
      return super.b(parama);
      this.h = true;
    }
  }
  
  protected a k()
  {
    return new a("https://getpocket.com/v3/purchase_status", true);
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        paramAnonymousInputStream = (ObjectNode)l.a().readTree(paramAnonymousInputStream);
        j.a(j.this, new PremiumStatus(paramAnonymousInputStream));
        return 1;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */