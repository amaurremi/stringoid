package com.jiubang.goweather.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import java.io.InputStream;

public abstract class c
{
  protected String a;
  protected int b;
  
  public abstract InputStream a(String paramString, e parame, f paramf);
  
  public abstract void a();
  
  public boolean a(f paramf, Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      int i = paramContext.getType();
      this.a = Proxy.getDefaultHost();
      this.b = Proxy.getDefaultPort();
      if (TextUtils.isEmpty(this.a)) {
        this.a = null;
      }
      if (i == 0) {
        if (!TextUtils.isEmpty(this.a)) {
          paramf.a(3);
        }
      }
      for (;;)
      {
        return true;
        paramf.a(2);
        continue;
        if (i == 1) {
          paramf.a(1);
        } else if (i == 6) {
          paramf.a(4);
        } else if (i == 9) {
          paramf.a(5);
        } else if (i == 4) {
          paramf.a(6);
        } else {
          paramf.a(7);
        }
      }
    }
    paramf.a(16);
    this.a = null;
    return false;
  }
  
  public abstract String b(String paramString, e parame, f paramf);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */