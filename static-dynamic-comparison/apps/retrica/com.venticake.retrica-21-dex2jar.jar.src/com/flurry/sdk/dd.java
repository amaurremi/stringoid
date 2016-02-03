package com.flurry.sdk;

import android.widget.Toast;

public class dd
  extends de
  implements dq.a
{
  static String a;
  static String b = "http://data.flurry.com/aap.do";
  static String c = "https://data.flurry.com/aap.do";
  private static final String h = dd.class.getSimpleName();
  private boolean i;
  
  public dd()
  {
    this(null);
  }
  
  dd(de.a parama)
  {
    super("Analytics", dd.class.getSimpleName());
    this.g = "AnalyticsData_";
    g();
    a(parama);
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (!paramString.endsWith(".do"))) {
      eo.a(5, h, "overriding analytics agent report URL without an endpoint, are you sure?");
    }
    a = paramString;
  }
  
  private void g()
  {
    dq localdq = dp.a();
    this.i = ((Boolean)localdq.a("UseHttps")).booleanValue();
    localdq.a("UseHttps", this);
    eo.a(4, h, "initSettings, UseHttps = " + this.i);
    String str = (String)localdq.a("ReportUrl");
    localdq.a("ReportUrl", this);
    b(str);
    eo.a(4, h, "initSettings, ReportUrl = " + str);
  }
  
  String a()
  {
    if (a != null) {
      return a;
    }
    if (this.i) {
      return c;
    }
    return b;
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("UseHttps"))
    {
      this.i = ((Boolean)paramObject).booleanValue();
      eo.a(4, h, "onSettingUpdate, UseHttps = " + this.i);
      return;
    }
    if (paramString.equals("ReportUrl"))
    {
      paramString = (String)paramObject;
      b(paramString);
      eo.a(4, h, "onSettingUpdate, ReportUrl = " + paramString);
      return;
    }
    eo.a(6, h, "onSettingUpdate internal error!");
  }
  
  protected void a(String paramString1, String paramString2, final int paramInt)
  {
    a(new ff()
    {
      public void a()
      {
        if (paramInt == 200)
        {
          dj localdj = dl.a().c();
          if (localdj != null) {
            localdj.b();
          }
        }
      }
    });
    super.a(paramString1, paramString2, paramInt);
  }
  
  protected void a(byte[] paramArrayOfByte, final String paramString1, final String paramString2)
  {
    String str = a();
    eo.a(4, h, "FlurryDataSender: start upload data " + paramArrayOfByte + " with id = " + paramString1 + " to " + str);
    el localel = new el();
    localel.a(str);
    localel.a(en.a.c);
    localel.a("Content-Type", "application/octet-stream");
    localel.a(new ew());
    localel.a(paramArrayOfByte);
    localel.a(new el.a()
    {
      public void a(el<byte[], Void> paramAnonymousel, Void paramAnonymousVoid)
      {
        final int i = paramAnonymousel.e();
        if (i > 0)
        {
          eo.d(dd.b(), "FlurryDataSender: report " + paramString1 + " sent. HTTP response: " + i);
          if ((eo.c() <= 3) && (eo.d())) {
            do.a().a(new Runnable()
            {
              public void run()
              {
                Toast.makeText(do.a().b(), "SD HTTP Response Code: " + i, 0).show();
              }
            });
          }
          dd.this.a(paramString1, paramString2, i);
          dd.this.d();
          return;
        }
        dd.this.b(paramString1, paramString2);
      }
    });
    em.a().a(this, localel);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */