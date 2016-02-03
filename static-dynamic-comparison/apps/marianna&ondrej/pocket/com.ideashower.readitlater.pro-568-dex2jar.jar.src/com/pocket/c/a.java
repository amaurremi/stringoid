package com.pocket.c;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.l;
import com.pocket.billing.PremiumGiftMessage;
import com.pocket.user.UserMeta;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public abstract class a
  extends f
{
  protected UserMeta a;
  protected PremiumGiftMessage b;
  private final b h;
  private String p;
  private String q;
  private boolean r;
  
  public a(b paramb, int paramInt)
  {
    super(paramInt);
    if (paramb == null) {
      throw new NullPointerException("type cannot be null");
    }
    this.h = paramb;
  }
  
  protected int a(com.ideashower.readitlater.objects.a parama)
  {
    Locale localLocale = Locale.getDefault();
    parama.a("locale", localLocale.getLanguage());
    parama.a("country", localLocale.getCountry());
    parama.a("timezone", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000 / 60));
    if ((this.p != null) && (this.h == b.a))
    {
      parama.a("request_token", this.p);
      parama.a("use_request_api_id");
    }
    parama.a();
    try
    {
      parama.a("device_manuf", Build.MANUFACTURER);
      parama.a("device_model", Build.MODEL);
      parama.a("device_product", Build.PRODUCT);
      parama.a("device_sid", Build.SERIAL);
      parama.a("device_anid", Settings.Secure.getString(g.c().getContentResolver(), "android_id"));
      parama.a("getTests");
      parama.a("account");
      if (i.a(com.ideashower.readitlater.h.a.cl) != null) {
        parama.a("play_referrer", i.a(com.ideashower.readitlater.h.a.cl));
      }
      parama.a();
      return super.a(parama);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.a(localThrowable, true);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  protected boolean a(String paramString, JsonParser paramJsonParser)
  {
    return false;
  }
  
  public abstract String f_();
  
  protected com.ideashower.readitlater.objects.b l()
  {
    new com.ideashower.readitlater.objects.b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        paramAnonymousInputStream = l.d().createJsonParser(paramAnonymousInputStream);
        paramAnonymousInputStream.nextToken();
        while ((paramAnonymousInputStream.nextToken() != JsonToken.END_OBJECT) && (!paramAnonymousInputStream.isClosed()))
        {
          Object localObject = paramAnonymousInputStream.getCurrentName();
          paramAnonymousInputStream.nextToken();
          if (!a.this.a((String)localObject, paramAnonymousInputStream)) {
            if ("tests".equals(localObject))
            {
              com.ideashower.readitlater.a.a.a(l.b(paramAnonymousInputStream));
            }
            else if ("access_token".equals(localObject))
            {
              a.a(a.this, l.a(paramAnonymousInputStream));
            }
            else
            {
              if ("prompt_password".equals(localObject))
              {
                localObject = a.this;
                if (paramAnonymousInputStream.getValueAsInt() == 1) {}
                for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
                {
                  a.a((a)localObject, paramAnonymousBoolean);
                  break;
                }
              }
              if ("account".equals(localObject)) {
                a.this.a = UserMeta.a(paramAnonymousInputStream);
              } else if ("premium_gift".equals(localObject)) {
                a.this.b = new PremiumGiftMessage(paramAnonymousInputStream);
              } else {
                paramAnonymousInputStream.skipChildren();
              }
            }
          }
        }
        paramAnonymousInputStream.close();
        return 1;
      }
    };
  }
  
  protected boolean m()
  {
    return false;
  }
  
  public b n()
  {
    return this.h;
  }
  
  public String o()
  {
    return this.q;
  }
  
  public UserMeta p()
  {
    return this.a;
  }
  
  public boolean q()
  {
    return this.r;
  }
  
  public PremiumGiftMessage r()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */