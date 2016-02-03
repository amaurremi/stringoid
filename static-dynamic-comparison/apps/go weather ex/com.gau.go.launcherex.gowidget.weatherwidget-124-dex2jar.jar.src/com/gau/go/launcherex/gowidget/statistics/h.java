package com.gau.go.launcherex.gowidget.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.format.Time;
import com.jiubang.goweather.b.f;
import java.util.TimeZone;

public class h
  implements Handler.Callback
{
  private Handler a;
  private Time b;
  private Context c;
  
  public h(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = new Handler(Looper.getMainLooper(), this);
    this.b = new Time();
  }
  
  private String a()
  {
    this.b.setToNow();
    this.b.switchTimezone(TimeZone.getTimeZone("GMT+0800").getID());
    return this.b.format("%Y-%m-%d %H:%M:%S") + " " + this.b.timezone;
  }
  
  public void a(String paramString, f paramf)
  {
    if (paramf == null) {}
    for (;;)
    {
      return;
      int i;
      if ((paramf.c() == 1) || (paramf.c() == 2)) {
        i = 0;
      }
      while ((i == 3) || (i == 4) || (i == 5) || (i == 6) || (i == 2) || (i == 102) || (i == 103) || (i == 104) || (i == 100))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("===========");
        localStringBuffer.append(a());
        localStringBuffer.append("===========");
        localStringBuffer.append("\n");
        localStringBuffer.append("URL : ");
        localStringBuffer.append(paramString);
        localStringBuffer.append("\n");
        localStringBuffer.append("error status code : ");
        localStringBuffer.append(i);
        localStringBuffer.append("\n");
        if (i == 3)
        {
          localStringBuffer.append("http response status code : ");
          localStringBuffer.append(paramf.n());
          localStringBuffer.append("\n");
        }
        localStringBuffer.append("error message : ");
        localStringBuffer.append(paramf.j());
        localStringBuffer.append("\n");
        localStringBuffer.append("json from server : ");
        localStringBuffer.append(paramf.l());
        localStringBuffer.append("\n");
        if ((i == 2) || (i == 100))
        {
          localStringBuffer.append("StackTraceInfo : ");
          localStringBuffer.append(paramf.m());
          localStringBuffer.append("\n");
        }
        localStringBuffer.append("\n");
        localStringBuffer.append("\n");
        paramString = Message.obtain();
        paramString.what = 1;
        paramString.obj = localStringBuffer.toString();
        this.a.sendMessage(paramString);
        return;
        switch (paramf.e())
        {
        case 1: 
        case 2: 
        case 9: 
        case 11: 
        default: 
          i = 100;
          break;
        case 6: 
          i = 1;
          break;
        case 7: 
          i = 2;
          break;
        case 8: 
          i = 3;
          break;
        case 0: 
          i = 4;
          break;
        case -1: 
          i = 5;
          break;
        case 10: 
          i = 6;
          break;
        case 12: 
          i = 7;
          break;
        case 3: 
          i = 101;
          break;
        case 4: 
          i = 102;
          break;
        case 5: 
          i = 103;
          break;
        case 13: 
          i = 104;
        }
      }
    }
  }
  
  public void b(String paramString, f paramf)
  {
    a(paramString, paramf);
  }
  
  public void c(String paramString, f paramf)
  {
    a(paramString, paramf);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    j.a(this.c).a((String)paramMessage.obj);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */