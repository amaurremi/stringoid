package com.go.weatherex.c;

import android.text.TextUtils;

class g
{
  String a;
  String b;
  String c;
  String d;
  long e;
  boolean f;
  
  private g(a parama) {}
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.b);
    if (!TextUtils.isEmpty(this.d)) {
      localStringBuffer.append(", " + this.d);
    }
    if (!TextUtils.isEmpty(this.c)) {
      localStringBuffer.append("(" + this.c + ")");
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */