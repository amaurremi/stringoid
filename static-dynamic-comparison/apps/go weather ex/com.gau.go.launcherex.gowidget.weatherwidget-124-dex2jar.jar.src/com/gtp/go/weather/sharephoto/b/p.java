package com.gtp.go.weather.sharephoto.b;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class p
{
  private boolean a;
  private long b;
  private String c;
  private String d = "";
  private boolean e;
  private int f;
  private int g;
  private int h;
  private String i;
  private String j;
  private long k = 0L;
  private long l = 0L;
  private boolean m = false;
  private long n;
  private String o = "";
  private String p = "";
  private String q = "";
  private String r = "";
  private e s;
  
  public p(e parame)
  {
    a(parame);
  }
  
  public p(g paramg)
  {
    this.a = false;
    this.b = paramg.a();
    this.c = paramg.l();
    this.d = paramg.m();
    this.o = a(paramg.k());
    this.n = paramg.j();
    this.p = paramg.x();
    this.q = paramg.p();
    this.r = paramg.t();
    this.e = paramg.h();
    this.f = paramg.c();
    this.g = paramg.d();
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.split("\\s")[0];
    }
    return "unknown";
  }
  
  public static ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(new p((e)paramArrayList.next()));
    }
    return localArrayList;
  }
  
  private String n()
  {
    return new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
  }
  
  public e a()
  {
    return this.s;
  }
  
  public void a(int paramInt)
  {
    this.f = Math.max(0, this.f + paramInt);
  }
  
  public void a(e parame)
  {
    this.a = true;
    this.b = parame.f();
    this.c = parame.c();
    this.d = parame.a();
    this.o = n();
    this.s = parame;
    this.h = parame.d();
    this.i = parame.g();
    this.j = parame.h();
    this.k = parame.i();
    this.l = parame.j();
    this.m = parame.m();
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public String f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.j;
  }
  
  public boolean h()
  {
    return this.s.k();
  }
  
  public String i()
  {
    return this.o;
  }
  
  public String j()
  {
    return this.p;
  }
  
  public boolean k()
  {
    return this.e;
  }
  
  public int l()
  {
    return this.f;
  }
  
  public int m()
  {
    return this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */