package com.gau.go.launcherex.gowidget.statistics;

import android.content.Context;
import android.provider.Settings.Secure;
import com.gau.go.gostaticsdk.d;

public class t
{
  public String a;
  public String b;
  public String c;
  private Context d;
  
  public t(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.d = paramContext;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(17).append("||");
    localStringBuilder.append(Settings.Secure.getString(this.d.getContentResolver(), "android_id")).append("||");
    localStringBuilder.append(y.x(this.d)).append("||");
    localStringBuilder.append(47).append("||");
    localStringBuilder.append(this.a).append("||");
    localStringBuilder.append(this.b).append("||");
    localStringBuilder.append(this.c).append("||");
    localStringBuilder.append(y.n(this.d)).append("||");
    localStringBuilder.append(y.f(this.d)).append("||");
    localStringBuilder.append(y.e(this.d)).append("||");
    localStringBuilder.append(y.c(this.d)).append("||");
    localStringBuilder.append(0).append("||");
    localStringBuilder.append(0).append("||");
    localStringBuilder.append("").append("||");
    localStringBuilder.append("").append("||");
    localStringBuilder.append(d.b(this.d));
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */