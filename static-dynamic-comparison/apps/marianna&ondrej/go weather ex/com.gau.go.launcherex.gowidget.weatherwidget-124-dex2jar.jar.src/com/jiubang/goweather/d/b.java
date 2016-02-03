package com.jiubang.goweather.d;

import android.content.Context;
import android.text.format.Time;
import com.jiubang.goweather.a.h;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.g;
import java.util.ArrayList;
import java.util.Iterator;

public class b
{
  private boolean a;
  private Context b;
  private ArrayList c;
  private h d;
  private a e;
  private int f = 0;
  private e g;
  
  public b(Context paramContext, ArrayList paramArrayList, a parama)
  {
    this.b = paramContext;
    this.c = paramArrayList;
    this.e = parama;
    this.d = new h(paramArrayList);
  }
  
  private com.jiubang.goweather.b.f a(String paramString)
  {
    Time localTime = new Time();
    com.jiubang.goweather.b.f localf = new com.jiubang.goweather.b.f();
    if (this.g.h().equalsIgnoreCase("GET")) {}
    for (Object localObject = d.a(true); ((com.jiubang.goweather.b.c)localObject).a(localf, this.b); localObject = d.a(true))
    {
      localf.d(1);
      localTime.setToNow();
      long l3 = localTime.toMillis(true);
      localf.a(l3);
      localObject = ((com.jiubang.goweather.b.c)localObject).b(paramString, this.g, localf);
      com.gtp.a.a.a.a.a().a(paramString, "weather_request.txt");
      localTime.setToNow();
      long l2 = localTime.toMillis(true);
      long l1 = l2;
      if (l2 == l3) {
        l1 = l2 + 1000L;
      }
      localf.b(l1);
      if (localObject != null)
      {
        localf.b((String)localObject);
        localTime.setToNow();
        l3 = localTime.toMillis(true);
        localf.c(l3);
        this.d.a((String)localObject, localf, paramString, this.b);
        localTime.setToNow();
        l2 = localTime.toMillis(true);
        l1 = l2;
        if (l2 == l3) {
          l1 = l2 + 1000L;
        }
        localf.d(l1);
      }
      return localf;
    }
    paramString = this.c.iterator();
    while (paramString.hasNext()) {
      ((com.jiubang.goweather.a.a)paramString.next()).h(3);
    }
    localf.b(11);
    localf.c(3);
    return localf;
  }
  
  private String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(((com.jiubang.goweather.a.a)this.c.get(i)).c);
      if (i != j - 1) {
        localStringBuffer.append(",");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private e b(int paramInt)
  {
    e locale = new e("http://goweatherex.3g.cn/goweatherex/weather/getWeather");
    g.a(this.b, locale);
    locale.a("w", a());
    if (this.a) {}
    for (Object localObject = "12";; localObject = "24")
    {
      locale.a("h", (String)localObject);
      locale.a("timestamp", String.valueOf(b()));
      locale.a("sce", Integer.toString(paramInt));
      localObject = com.gau.go.launcherex.gowidget.weather.c.c.a(this.b.getApplicationContext()).e();
      if ((!((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(2)) && (!((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(32)) && (!((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(1)) && (!((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(128))) {
        break;
      }
      locale.a("payment", "1");
      return locale;
    }
    locale.a("payment", "0");
    return locale;
  }
  
  private String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(((com.jiubang.goweather.a.a)this.c.get(i)).o());
      if (i != j - 1) {
        localStringBuffer.append(",");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: iload_1
    //   3: invokespecial 234	com/jiubang/goweather/d/b:b	(I)Lcom/jiubang/goweather/b/e;
    //   6: putfield 48	com/jiubang/goweather/d/b:g	Lcom/jiubang/goweather/b/e;
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 25	com/jiubang/goweather/d/b:f	I
    //   14: new 236	com/gau/go/launcherex/gowidget/statistics/h
    //   17: dup
    //   18: aload_0
    //   19: getfield 27	com/jiubang/goweather/d/b:b	Landroid/content/Context;
    //   22: invokespecial 239	com/gau/go/launcherex/gowidget/statistics/h:<init>	(Landroid/content/Context;)V
    //   25: astore 5
    //   27: aload_0
    //   28: getfield 25	com/jiubang/goweather/d/b:f	I
    //   31: iconst_2
    //   32: if_icmpgt +105 -> 137
    //   35: aload_0
    //   36: getfield 48	com/jiubang/goweather/d/b:g	Lcom/jiubang/goweather/b/e;
    //   39: aload_0
    //   40: getfield 25	com/jiubang/goweather/d/b:f	I
    //   43: invokevirtual 240	com/jiubang/goweather/b/e:c	(I)V
    //   46: aload_0
    //   47: getfield 48	com/jiubang/goweather/d/b:g	Lcom/jiubang/goweather/b/e;
    //   50: invokevirtual 243	com/jiubang/goweather/b/e:i	()Ljava/lang/String;
    //   53: astore_3
    //   54: ldc -11
    //   56: new 247	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   63: ldc -6
    //   65: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_3
    //   69: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 257	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: aload_3
    //   80: invokespecial 259	com/jiubang/goweather/d/b:a	(Ljava/lang/String;)Lcom/jiubang/goweather/b/f;
    //   83: astore 4
    //   85: aload 4
    //   87: iload_1
    //   88: invokevirtual 261	com/jiubang/goweather/b/f:f	(I)V
    //   91: aload 5
    //   93: aload_3
    //   94: aload 4
    //   96: invokevirtual 264	com/gau/go/launcherex/gowidget/statistics/h:a	(Ljava/lang/String;Lcom/jiubang/goweather/b/f;)V
    //   99: aload 4
    //   101: invokevirtual 266	com/jiubang/goweather/b/f:c	()I
    //   104: istore_2
    //   105: iload_2
    //   106: iconst_1
    //   107: if_icmpne +43 -> 150
    //   110: aload_0
    //   111: getfield 27	com/jiubang/goweather/d/b:b	Landroid/content/Context;
    //   114: invokestatic 271	com/gau/go/launcherex/gowidget/statistics/j:a	(Landroid/content/Context;)Lcom/gau/go/launcherex/gowidget/statistics/j;
    //   117: aload 4
    //   119: invokevirtual 274	com/gau/go/launcherex/gowidget/statistics/j:a	(Lcom/jiubang/goweather/b/f;)V
    //   122: aload_0
    //   123: getfield 31	com/jiubang/goweather/d/b:e	Lcom/jiubang/goweather/d/a;
    //   126: aload_0
    //   127: getfield 29	com/jiubang/goweather/d/b:c	Ljava/util/ArrayList;
    //   130: aload 4
    //   132: invokeinterface 279 3 0
    //   137: return
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_3
    //   142: aload 4
    //   144: invokevirtual 282	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   147: goto -69 -> 78
    //   150: iload_2
    //   151: iconst_2
    //   152: if_icmpne +31 -> 183
    //   155: aload_0
    //   156: getfield 27	com/jiubang/goweather/d/b:b	Landroid/content/Context;
    //   159: invokestatic 271	com/gau/go/launcherex/gowidget/statistics/j:a	(Landroid/content/Context;)Lcom/gau/go/launcherex/gowidget/statistics/j;
    //   162: aload 4
    //   164: invokevirtual 274	com/gau/go/launcherex/gowidget/statistics/j:a	(Lcom/jiubang/goweather/b/f;)V
    //   167: aload_0
    //   168: getfield 31	com/jiubang/goweather/d/b:e	Lcom/jiubang/goweather/d/a;
    //   171: aload_0
    //   172: getfield 29	com/jiubang/goweather/d/b:c	Ljava/util/ArrayList;
    //   175: aload 4
    //   177: invokeinterface 284 3 0
    //   182: return
    //   183: iload_2
    //   184: bipush 11
    //   186: if_icmpne -159 -> 27
    //   189: aload 4
    //   191: invokevirtual 286	com/jiubang/goweather/b/f:e	()I
    //   194: istore_2
    //   195: iload_2
    //   196: iconst_3
    //   197: if_icmpne +19 -> 216
    //   200: aload_0
    //   201: getfield 31	com/jiubang/goweather/d/b:e	Lcom/jiubang/goweather/d/a;
    //   204: aload_0
    //   205: getfield 29	com/jiubang/goweather/d/b:c	Ljava/util/ArrayList;
    //   208: aload 4
    //   210: invokeinterface 288 3 0
    //   215: return
    //   216: aload_0
    //   217: getfield 27	com/jiubang/goweather/d/b:b	Landroid/content/Context;
    //   220: invokestatic 271	com/gau/go/launcherex/gowidget/statistics/j:a	(Landroid/content/Context;)Lcom/gau/go/launcherex/gowidget/statistics/j;
    //   223: aload 4
    //   225: invokevirtual 274	com/gau/go/launcherex/gowidget/statistics/j:a	(Lcom/jiubang/goweather/b/f;)V
    //   228: iload_2
    //   229: iconst_m1
    //   230: if_icmpeq +11 -> 241
    //   233: aload_0
    //   234: getfield 25	com/jiubang/goweather/d/b:f	I
    //   237: iconst_1
    //   238: if_icmple +19 -> 257
    //   241: aload_0
    //   242: getfield 31	com/jiubang/goweather/d/b:e	Lcom/jiubang/goweather/d/a;
    //   245: aload_0
    //   246: getfield 29	com/jiubang/goweather/d/b:c	Ljava/util/ArrayList;
    //   249: aload 4
    //   251: invokeinterface 290 3 0
    //   256: return
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 25	com/jiubang/goweather/d/b:f	I
    //   262: iconst_1
    //   263: iadd
    //   264: putfield 25	com/jiubang/goweather/d/b:f	I
    //   267: goto -240 -> 27
    //   270: astore 4
    //   272: goto -130 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	b
    //   0	275	1	paramInt	int
    //   104	127	2	i	int
    //   53	89	3	str	String
    //   83	48	4	localf	com.jiubang.goweather.b.f
    //   138	112	4	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   270	1	4	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   25	67	5	localh	com.gau.go.launcherex.gowidget.statistics.h
    // Exception table:
    //   from	to	target	type
    //   46	54	138	java/io/UnsupportedEncodingException
    //   54	78	270	java/io/UnsupportedEncodingException
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */