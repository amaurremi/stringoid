package com.go.weatherex.g;

import android.content.Context;
import com.gau.go.launcherex.gowidget.statistics.y;
import java.util.Locale;

public class a
  extends com.gau.go.launcherex.goweather.goplay.a.a
{
  private final String a = "24";
  private String b = "0";
  private String c = "0";
  private String d = "0";
  private String e = "0";
  private String f = "0";
  private String g = "0";
  private String h = "0";
  private final String i = "184";
  private String j = "0";
  private String k = "0";
  private String l = "0";
  
  public a(Context paramContext)
  {
    this.c = y.v(paramContext);
    this.e = y.n(paramContext).toUpperCase(Locale.US);
    this.f = y.f(paramContext);
    this.g = String.valueOf(y.e(paramContext));
    this.h = y.c(paramContext);
    this.d = "0";
  }
  
  public void a()
  {
    this.j = "0";
    this.k = "0";
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("24");
    localStringBuilder.append("||");
    this.b = a("%Y-%m-%d %H:%M:%S");
    localStringBuilder.append(this.b);
    localStringBuilder.append("||");
    localStringBuilder.append(this.c);
    localStringBuilder.append("||");
    localStringBuilder.append(this.d);
    localStringBuilder.append("||");
    localStringBuilder.append(this.e);
    localStringBuilder.append("||");
    localStringBuilder.append(this.f);
    localStringBuilder.append("||");
    localStringBuilder.append(this.g);
    localStringBuilder.append("||");
    localStringBuilder.append(this.h);
    localStringBuilder.append("||");
    localStringBuilder.append("184");
    localStringBuilder.append("||");
    localStringBuilder.append(this.j);
    localStringBuilder.append("||");
    localStringBuilder.append(this.k);
    localStringBuilder.append("||");
    localStringBuilder.append(this.l);
    return localStringBuilder.toString();
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
  }
  
  public void c(String paramString)
  {
    this.k = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */