package com.flurry.android.monolithic.sdk.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class em
  implements id, jb
{
  static String a;
  static String b = "http://data.flurry.com/aap.do";
  static String c = "https://data.flurry.com/aap.do";
  private static final String f = em.class.getSimpleName();
  ey d;
  Set<String> e = new HashSet();
  private boolean g;
  private ExecutorService h;
  private ExecutorService i;
  
  public em()
  {
    this(null);
  }
  
  em(eu parameu)
  {
    jc.a().a(this);
    this.h = Executors.newSingleThreadExecutor();
    this.i = Executors.newCachedThreadPool();
    e();
    f();
    a(parameu);
  }
  
  private void a(eu parameu)
  {
    this.h.submit(new eo(this, parameu));
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (!paramString.endsWith(".do"))) {
      ja.a(5, f, "overriding analytics agent report URL without an endpoint, are you sure?");
    }
    a = paramString;
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    this.h.submit(new es(this, paramInt, paramString1, paramString2));
  }
  
  private void b(String paramString1, String paramString2)
  {
    this.h.submit(new et(this, paramString1));
  }
  
  private void c(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this.h.submit(new ep(this, paramArrayOfByte, paramString1, paramString2));
  }
  
  private void d(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    String str = b();
    ja.a(4, f, "FlurryDataSender: start upload data with id = " + paramString1 + " to " + str);
    eq localeq = new eq(this);
    this.i.submit(new ev(str, paramString1, paramString2, paramArrayOfByte, localeq));
  }
  
  private void e()
  {
    ic localic = ib.a();
    this.g = ((Boolean)localic.a("UseHttps")).booleanValue();
    localic.a("UseHttps", this);
    ja.a(4, f, "initSettings, UseHttps = " + this.g);
    String str = (String)localic.a("ReportUrl");
    localic.a("ReportUrl", this);
    a(str);
    ja.a(4, f, "initSettings, ReportUrl = " + str);
  }
  
  private void f()
  {
    this.h.submit(new en(this));
  }
  
  private void g()
  {
    a(null);
  }
  
  private void h()
  {
    if (!jc.a().c())
    {
      ja.a(5, f, "Reports were not sent! No Internet connection!");
      return;
    }
    label57:
    String str1;
    do
    {
      Object localObject;
      do
      {
        localObject = this.d.b();
        if ((localObject == null) || (((List)localObject).isEmpty()))
        {
          ja.a(4, f, "No more reports to send.");
          return;
        }
        localObject = ((List)localObject).iterator();
      } while (!((Iterator)localObject).hasNext());
      str1 = (String)((Iterator)localObject).next();
    } while (!c());
    List localList = this.d.b(str1);
    ja.a(4, f, "Number of not sent blocks = " + localList.size());
    int j = 0;
    label127:
    String str2;
    if (j < localList.size())
    {
      str2 = (String)localList.get(j);
      if (!this.e.contains(str2)) {
        break label172;
      }
    }
    for (;;)
    {
      j += 1;
      break label127;
      break label57;
      label172:
      if (!c()) {
        break;
      }
      byte[] arrayOfByte = new ew(str2).b();
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        ja.a(6, f, "Internal ERROR! Report is empty!");
        this.d.a(str2, str1);
      }
      else
      {
        this.e.add(str2);
        d(arrayOfByte, str2, str1);
      }
    }
  }
  
  private void i()
  {
    long l = Thread.currentThread().getId();
    Thread.currentThread().setName("DataSender Main Single Thread , id = " + l);
  }
  
  int a()
  {
    return this.e.size();
  }
  
  String a(String paramString1, String paramString2)
  {
    return "Data_" + paramString1 + "_" + paramString2;
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("UseHttps"))
    {
      this.g = ((Boolean)paramObject).booleanValue();
      ja.a(4, f, "onSettingUpdate, UseHttps = " + this.g);
      return;
    }
    if (paramString.equals("ReportUrl"))
    {
      paramString = (String)paramObject;
      a(paramString);
      ja.a(4, f, "onSettingUpdate, ReportUrl = " + paramString);
      return;
    }
    ja.a(6, f, "onSettingUpdate internal error!");
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    a(paramArrayOfByte, paramString1, paramString2, null);
  }
  
  void a(byte[] paramArrayOfByte, String paramString1, String paramString2, eu parameu)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ja.a(6, f, "Report that has to be sent is EMPTY or NULL");
      return;
    }
    c(paramArrayOfByte, paramString1, paramString2);
    a(parameu);
  }
  
  String b()
  {
    if (a != null) {
      return a;
    }
    if (this.g) {
      return c;
    }
    return b;
  }
  
  String b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    paramString2 = new ew();
    paramString2.a(paramArrayOfByte);
    paramArrayOfByte = paramString2.a();
    this.d.a(paramString2, paramString1);
    return paramArrayOfByte;
  }
  
  public void b(boolean paramBoolean)
  {
    ja.a(4, f, "onNetworkStateChanged : isNetworkEnable = " + paramBoolean);
    if (paramBoolean) {
      g();
    }
  }
  
  boolean c()
  {
    return a() <= 8;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */