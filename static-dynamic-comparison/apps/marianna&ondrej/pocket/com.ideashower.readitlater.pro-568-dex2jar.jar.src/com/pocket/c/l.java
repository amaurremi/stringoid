package com.pocket.c;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import java.io.InputStream;
import org.apache.a.c.k;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class l
  extends f
{
  private final String a;
  private final m b;
  private String h;
  
  public l(String paramString, m paramm)
  {
    super(2);
    this.a = paramString;
    this.b = paramm;
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == 3)
    {
      this.b.a(this.h);
      return;
    }
    this.b.a();
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/getMessage", false);
    locala.a();
    locala.a("messageType", this.a);
    locala.a("device_manuf", Build.MANUFACTURER);
    locala.a("device_model", Build.MODEL);
    locala.a("device_product", Build.PRODUCT);
    locala.a("device_sid", Build.SERIAL);
    locala.a("device_anid", Settings.Secure.getString(g.c().getContentResolver(), "android_id"));
    return locala;
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        paramAnonymousInputStream = (ObjectNode)com.ideashower.readitlater.util.l.a().readTree(paramAnonymousInputStream);
        l.a(l.this, com.ideashower.readitlater.util.l.a(paramAnonymousInputStream, "message", null));
        if (k.c(l.a(l.this))) {
          l.a(l.this, null);
        }
        return 1;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */