package com.pocket.oauth;

import android.content.Context;
import android.os.Bundle;
import com.pocket.c.f;
import com.pocket.c.g;
import com.pocket.c.t;
import org.apache.a.c.k;

public class c
  extends a
{
  private t e;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  public static void a(Bundle paramBundle, String paramString)
  {
    paramBundle.putString("username", paramString);
  }
  
  public static void b(Bundle paramBundle, String paramString)
  {
    paramBundle.putString("email", paramString);
  }
  
  public static void c(Bundle paramBundle, String paramString)
  {
    paramBundle.putString("firstname", paramString);
  }
  
  public static void d(Bundle paramBundle, String paramString)
  {
    paramBundle.putString("lastname", paramString);
  }
  
  public static void e(Bundle paramBundle, String paramString)
  {
    paramBundle.putString("password", paramString);
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.e != null) {
      return;
    }
    if (!this.b.a()) {
      this.b.a(this);
    }
    String str1 = k.c(paramBundle.getString("username"));
    String str2 = k.c(paramBundle.getString("password"));
    String str3 = k.c(paramBundle.getString("email"));
    String str4 = k.c(paramBundle.getString("firstname"));
    paramBundle = k.c(paramBundle.getString("lastname"));
    g local1 = new g()
    {
      public void a(f paramAnonymousf, boolean paramAnonymousBoolean)
      {
        c.this.b.a((com.pocket.c.a)paramAnonymousf, paramAnonymousBoolean);
        c.a(c.this, null);
      }
    };
    if (this.c == com.pocket.c.b.b) {}
    for (this.e = t.a(str1, str2, 1, local1);; this.e = t.a(str3, str2, str4, paramBundle, 1, local1))
    {
      this.e.a(this.d);
      this.e.h();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */