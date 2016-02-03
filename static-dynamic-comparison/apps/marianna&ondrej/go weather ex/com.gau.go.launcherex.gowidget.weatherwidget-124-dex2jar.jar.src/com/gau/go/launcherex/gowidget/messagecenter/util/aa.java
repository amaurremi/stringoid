package com.gau.go.launcherex.gowidget.messagecenter.util;

public class aa
{
  public long a = 0L;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.b != null) && (this.c != null) && (this.d != null) && (this.e != null)) {
      localStringBuilder.append(System.currentTimeMillis()).append("||").append(System.currentTimeMillis()).append("||").append(this.b).append("||").append(this.c).append("||").append(this.d).append("||").append(this.e).append("||").append(this.f);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */