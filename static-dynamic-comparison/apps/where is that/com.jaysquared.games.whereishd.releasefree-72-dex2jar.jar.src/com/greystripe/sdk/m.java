package com.greystripe.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

final class m
{
  private m(c paramc) {}
  
  private q a(String paramString)
  {
    q localq = new q(this.a, (byte)0);
    if (!paramString.matches(".*:\\{.*\\}"))
    {
      bd.b("no mathcey!", new Object[0]);
      return localq;
    }
    String[] arrayOfString1 = paramString.substring(paramString.indexOf("{") + 1, paramString.indexOf("}")).split("\\|");
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      String str = arrayOfString2[0];
      if (arrayOfString2.length > 2)
      {
        paramString = "";
        int j = 1;
        while (j < arrayOfString2.length - 1)
        {
          paramString = paramString + arrayOfString2[j] + ":";
          j += 1;
        }
        arrayOfString2[1] = (paramString + arrayOfString2[(arrayOfString2.length - 1)]);
      }
      if (arrayOfString2.length >= 2) {
        localq.put(str, arrayOfString2[1].trim());
      }
      i += 1;
    }
    return localq;
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null)
    {
      this.a.c();
      return;
    }
    try
    {
      c.o(this.a).startActivity(paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      bd.b("Greystripe", new Object[] { paramString });
      paramIntent.printStackTrace();
      this.a.c();
    }
  }
  
  private Intent b(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT");
    Object localObject2 = a(paramString);
    if (((q)localObject2).size() == 0) {
      return null;
    }
    Object localObject1 = new StringBuilder().append(((q)localObject2).a("firstName"));
    if (((q)localObject2).containsKey("lastName")) {}
    String str1;
    String str2;
    String str3;
    String str4;
    for (paramString = " " + ((q)localObject2).a("lastName");; paramString = "")
    {
      str1 = paramString;
      str2 = ((q)localObject2).a("phone");
      str3 = ((q)localObject2).a("email");
      str4 = ((q)localObject2).a("company");
      paramString = "";
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "street";
      arrayOfString[1] = "city";
      arrayOfString[2] = "state";
      arrayOfString[3] = "zip";
      arrayOfString[4] = "country";
      int i = 0;
      while (i < arrayOfString.length)
      {
        String str5 = ((q)localObject2).a(arrayOfString[i]);
        localObject1 = paramString;
        if (str5.length() > 0) {
          localObject1 = paramString + str5 + ", ";
        }
        i += 1;
        paramString = (String)localObject1;
      }
    }
    localObject1 = paramString;
    if (paramString.endsWith(", ")) {
      localObject1 = paramString.substring(0, paramString.length() - ", ".length());
    }
    paramString = ((q)localObject2).a("fax");
    localObject2 = ((q)localObject2).a("url");
    localIntent.setType("vnd.android.cursor.dir/raw_contact");
    localIntent.putExtra("name", str1);
    localIntent.putExtra("email", str3);
    localIntent.putExtra("phone", str2);
    localIntent.putExtra("company", str4);
    localIntent.putExtra("postal", (String)localObject1);
    localIntent.putExtra("secondary_phone", paramString);
    localIntent.putExtra("secondary_phone_type", 4);
    localIntent.putExtra("notes", (String)localObject2);
    localIntent.addFlags(268435456);
    return localIntent;
  }
  
  private Intent c(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.EDIT");
    q localq = a(paramString);
    if (localq.size() == 0) {
      return null;
    }
    String str1 = localq.a("title");
    String str2 = localq.a("location");
    String str3 = localq.a("notes");
    String str4 = localq.a("url");
    if (localq.containsKey("timeZone")) {
      paramString = TimeZone.getTimeZone(localq.a("timeZone"));
    }
    for (;;)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
      localSimpleDateFormat.setTimeZone(paramString);
      String str5 = localq.a("startDate");
      paramString = Calendar.getInstance();
      try
      {
        paramString.setTime(localSimpleDateFormat.parse(str5));
        str5 = localq.a("endDate");
        localCalendar = Calendar.getInstance();
      }
      catch (ParseException localParseException2)
      {
        try
        {
          Calendar localCalendar;
          localCalendar.setTime(localSimpleDateFormat.parse(str5));
          if ((localq.a("allDay").startsWith("t")) || (localq.a("allDay").startsWith("y")))
          {
            bool = true;
            localIntent.setType("vnd.android.cursor.item/event");
            localIntent.addFlags(268435456);
            localIntent.putExtra("beginTime", paramString.getTimeInMillis());
            localIntent.putExtra("title", str1);
            localIntent.putExtra("description", str4 + "\n" + str3);
            localIntent.putExtra("eventLocation", str2);
            localIntent.putExtra("allDay", bool);
            if (!bool) {
              localIntent.putExtra("endTime", localCalendar.getTimeInMillis());
            }
            return localIntent;
            paramString = TimeZone.getDefault();
            continue;
            localParseException2 = localParseException2;
            bd.e("Cannot parse startDate string: " + str5, new Object[0]);
          }
        }
        catch (ParseException localParseException1)
        {
          for (;;)
          {
            bd.e("Cannot parse endDate string: " + str5, new Object[0]);
            continue;
            boolean bool = false;
          }
        }
      }
    }
  }
  
  @JavascriptInterface
  public final void onAdExpired()
  {
    if ((c.f(this.a)) || (c.p(this.a))) {
      return;
    }
    bd.b("onAdExpired", new Object[0]);
    c.y(this.a);
    c.z(this.a);
    c.a(this.a, GSAdErrorCode.AD_EXPIRED);
  }
  
  @JavascriptInterface
  public final void onAdReady()
  {
    if ((c.f(this.a)) || (c.p(this.a))) {}
    do
    {
      do
      {
        return;
        bd.b("onAdReady", new Object[0]);
        c.c(this.a);
        c.q(this.a);
        c.r(this.a);
        if (c.g(this.a))
        {
          c.h(this.a);
          return;
        }
      } while (!c.s(this.a));
      c.h(this.a);
    } while (!c.j(this.a));
    c.k(this.a);
  }
  
  @JavascriptInterface
  public final void onBlankThirdPartyAd()
  {
    c.A(this.a);
    bm.a(new n(this));
    c.a(this.a).a();
    c.e(this.a);
    this.a.a(GSAdErrorCode.NO_AD);
  }
  
  @JavascriptInterface
  public final void onClickthrough(String paramString)
  {
    if (c.w(this.a))
    {
      bd.b("mraid ad was expanded. exec'ing mraid.close", new Object[0]);
      c.a(this.a).b("mraid.close();");
    }
    c.t(this.a);
    c.x(this.a);
    bd.b("Clicking through: " + paramString, new Object[0]);
    Object localObject;
    if (paramString.startsWith("sms:"))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      String[] arrayOfString = paramString.split("\\?body=");
      String str3 = "";
      String str2 = "";
      String str1 = str2;
      localObject = str3;
      if (arrayOfString != null)
      {
        str1 = str2;
        localObject = str3;
        if (arrayOfString.length > 0)
        {
          str3 = arrayOfString[0].substring(paramString.indexOf(":") + 1);
          str1 = str2;
          localObject = str3;
          if (arrayOfString.length > 1)
          {
            str1 = arrayOfString[1];
            localObject = str3;
          }
        }
      }
      localIntent.setData(Uri.parse("sms:" + (String)localObject));
      localIntent.putExtra("sms_body", str1);
      localIntent.addFlags(268435456);
      a(localIntent, "Failed to send SMS " + paramString);
      return;
    }
    if (paramString.startsWith("contact:"))
    {
      a(b(paramString), "Failed to save contact " + paramString);
      return;
    }
    if (paramString.startsWith("calendar:"))
    {
      a(c(paramString), "Failed to save calendar event " + paramString);
      return;
    }
    try
    {
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      ((Intent)localObject).addFlags(268435456);
      c.o(this.a).startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      bd.b("Greystripe", new Object[] { "Failed to clickthrough to destination " + paramString });
      localException.printStackTrace();
      this.a.c();
    }
  }
  
  @JavascriptInterface
  public final void onDismissal()
  {
    c.t(this.a);
    c.u(this.a);
    c.v(this.a);
  }
  
  @JavascriptInterface
  public final void saveImage(String paramString)
  {
    new o(this, paramString).start();
  }
  
  @JavascriptInterface
  public final void setAdId(int paramInt)
  {
    bd.b("setting adid: " + paramInt, new Object[0]);
    c.a(this.a, paramInt);
  }
  
  @JavascriptInterface
  public final void setAdServerUrl(String paramString)
  {
    bj.b(paramString);
  }
  
  @JavascriptInterface
  public final void useCamera()
  {
    this.a.b = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */