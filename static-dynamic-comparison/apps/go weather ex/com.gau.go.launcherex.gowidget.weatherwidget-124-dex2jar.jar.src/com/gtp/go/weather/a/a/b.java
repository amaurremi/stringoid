package com.gtp.go.weather.a.a;

import android.content.Context;
import com.gau.go.launcherex.gowidget.billing.v;
import com.gau.go.launcherex.gowidget.statistics.y;

public class b
{
  private static b a;
  private Context b;
  
  private b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new b(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void a(a parama)
  {
    com.gau.go.gostaticsdk.d locald = com.gau.go.gostaticsdk.d.a(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(41);
    localStringBuilder.append("||");
    localStringBuilder.append(y.v(this.b));
    localStringBuilder.append("||");
    localStringBuilder.append(com.gau.go.gostaticsdk.f.d.a());
    localStringBuilder.append("||");
    localStringBuilder.append(173);
    localStringBuilder.append("||");
    localStringBuilder.append("");
    localStringBuilder.append("||");
    localStringBuilder.append(parama.a());
    localStringBuilder.append("||");
    localStringBuilder.append(1);
    localStringBuilder.append("||");
    localStringBuilder.append(v.a(this.b));
    localStringBuilder.append("||");
    localStringBuilder.append(y.f(this.b));
    localStringBuilder.append("||");
    localStringBuilder.append(y.e(this.b));
    localStringBuilder.append("||");
    localStringBuilder.append(y.c(this.b));
    localStringBuilder.append("||");
    localStringBuilder.append("");
    localStringBuilder.append("||");
    localStringBuilder.append("");
    localStringBuilder.append("||");
    localStringBuilder.append("");
    localStringBuilder.append("||");
    localStringBuilder.append(0);
    localStringBuilder.append("||");
    localStringBuilder.append(com.gau.go.gostaticsdk.d.b(this.b));
    localStringBuilder.append("||");
    localStringBuilder.append("");
    localStringBuilder.append("||");
    localStringBuilder.append(parama.b());
    com.gtp.a.a.a.a.a().a(localStringBuilder.toString(), "photo_upload.txt");
    locald.a(localStringBuilder.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */