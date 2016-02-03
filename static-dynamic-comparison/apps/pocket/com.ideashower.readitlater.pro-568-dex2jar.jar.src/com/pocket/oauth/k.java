package com.pocket.oauth;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import b.a.a.a;
import b.a.a.b;
import com.ideashower.readitlater.activity.OAuthActivity;
import com.ideashower.readitlater.h.h;
import com.ideashower.readitlater.h.i;

public class k
{
  private static k c;
  protected final h a;
  protected final h b;
  private final a d;
  private final b e;
  private final Uri f;
  private final Context g;
  private n h;
  
  public k(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, h paramh1, h paramh2)
  {
    this(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, a(paramContext, paramInt), paramh1, paramh2);
  }
  
  public k(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, h paramh1, h paramh2)
  {
    this.d = new a(paramString1, paramString2);
    this.e = new b(paramString3, paramString5, paramString4);
    this.f = Uri.parse(paramString6);
    this.g = paramContext;
    this.a = paramh1;
    this.b = paramh2;
  }
  
  private static String a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    return "http://getpocket.com/androidoauthcallback/" + paramContext.getString(paramInt);
  }
  
  private static void a(k paramk, String paramString)
  {
    if (c != null) {
      c.c();
    }
    c = paramk;
    paramk = paramk.h();
    Intent localIntent = new Intent(paramk, OAuthActivity.class);
    localIntent.putExtra("requestUrl", paramString);
    paramk.startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.h != null) {
      this.h.a(this, paramBoolean);
    }
  }
  
  public static void b(Uri paramUri, int paramInt)
  {
    if (c == null) {
      return;
    }
    c.a(paramUri, paramInt);
    c = null;
  }
  
  private Context h()
  {
    return this.g;
  }
  
  protected void a(Uri paramUri, int paramInt)
  {
    String str = this.f.getScheme();
    if ((paramUri != null) && (paramUri.getScheme().equals(str)))
    {
      paramUri = paramUri.getQueryParameter("oauth_verifier");
      if (paramUri != null)
      {
        b(paramUri);
        return;
      }
      c();
      return;
    }
    c();
  }
  
  public void a(n paramn)
  {
    this.h = paramn;
  }
  
  protected void a(String paramString)
  {
    a(this, paramString);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
    a(true);
  }
  
  protected void a(Throwable paramThrowable)
  {
    a(false);
  }
  
  public boolean a()
  {
    return (d() != null) && (e() != null);
  }
  
  public void b()
  {
    new m(this, this.d, this.e, this.f.toString(), null).h();
  }
  
  protected void b(String paramString)
  {
    new l(this, this.d, this.e, paramString, null).h();
  }
  
  protected void b(String paramString1, String paramString2)
  {
    i.b().a(this.a, paramString1).a(this.b, paramString2).a();
  }
  
  protected void b(Throwable paramThrowable)
  {
    a(false);
  }
  
  protected void c()
  {
    a(false);
  }
  
  public String d()
  {
    return i.a(this.a);
  }
  
  public String e()
  {
    return i.a(this.b);
  }
  
  public String f()
  {
    return this.d.c();
  }
  
  public String g()
  {
    return this.d.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */