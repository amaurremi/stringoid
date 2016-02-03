package com.flurry.android;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View.OnClickListener;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

final class u
  implements View.OnClickListener
{
  private static volatile long A = 0L;
  static String a;
  static String b;
  private static volatile String c = "market://";
  private static volatile String d = "market://details?id=";
  private static volatile String e = "https://market.android.com/details?id=";
  private static String f = "com.flurry.android.ACTION_CATALOG";
  private static int g;
  private String h;
  private String i;
  private String j;
  private long k;
  private long l;
  private long m;
  private long n;
  private z o = new z();
  private boolean p = true;
  private volatile boolean q;
  private String r;
  private Map s = new HashMap();
  private Handler t;
  private boolean u;
  private transient Map v = new HashMap();
  private ag w;
  private List x = new ArrayList();
  private Map y = new HashMap();
  private AppCircleCallback z;
  
  static
  {
    a = "FlurryAgent";
    new Random(System.currentTimeMillis());
    g = 5000;
    b = "";
  }
  
  private Offer a(String paramString, v paramv)
  {
    p localp = new p(paramString, (byte)3, j());
    c(localp);
    localp.a(new f((byte)2, j()));
    localp.b = paramv;
    al localal = this.o.a(paramv.a);
    if (localal == null)
    {
      paramString = "";
      if (localal != null) {
        break label161;
      }
    }
    label161:
    for (int i1 = 0;; i1 = localal.c)
    {
      long l1 = A + 1L;
      A = l1;
      paramString = new OfferInSdk(l1, localp, paramv.h, paramv.d, paramString, i1);
      this.y.put(Long.valueOf(paramString.a), paramString);
      return new Offer(paramString.a, paramString.f, paramString.c, paramString.d, paramString.e);
      paramString = localal.a;
      break;
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    if (i1 < paramArrayOfByte.length)
    {
      int i2 = paramArrayOfByte[i1] >> 4 & 0xF;
      if (i2 < 10)
      {
        localStringBuilder.append((char)(i2 + 48));
        label41:
        i2 = paramArrayOfByte[i1] & 0xF;
        if (i2 >= 10) {
          break label87;
        }
        localStringBuilder.append((char)(i2 + 48));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append((char)(i2 + 65 - 10));
        break label41;
        label87:
        localStringBuilder.append((char)(i2 + 65 - 10));
      }
    }
    return localStringBuilder.toString();
  }
  
  private List a(List paramList, Long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (!this.o.b())) {
      return Collections.emptyList();
    }
    Object localObject = this.o.a((String)paramList.get(0));
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = new ArrayList(Arrays.asList((Object[])localObject));
      Collections.shuffle((List)localObject);
      if (paramLong != null)
      {
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext()) {
          if (((v)localIterator.next()).a == paramLong.longValue()) {
            localIterator.remove();
          }
        }
      }
      return ((List)localObject).subList(0, Math.min(((List)localObject).size(), paramList.size()));
    }
    return Collections.emptyList();
  }
  
  private static void a(Runnable paramRunnable)
  {
    new Handler().post(paramRunnable);
  }
  
  private void b(Context paramContext, p paramp, String paramString)
  {
    Intent localIntent = new Intent(o());
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.putExtra("u", paramString);
    if (paramp != null) {
      localIntent.putExtra("o", paramp.a());
    }
    paramContext.startActivity(localIntent);
  }
  
  private void c(p paramp)
  {
    if (this.x.size() < 32767)
    {
      this.x.add(paramp);
      this.v.put(Long.valueOf(paramp.a()), paramp);
    }
  }
  
  private String d(String paramString)
  {
    String str = paramString;
    Object localObject = paramString;
    try
    {
      if (!paramString.startsWith(c))
      {
        str = paramString;
        localObject = new HttpGet(paramString);
        str = paramString;
        localObject = new DefaultHttpClient().execute((HttpUriRequest)localObject);
        str = paramString;
        int i1 = ((HttpResponse)localObject).getStatusLine().getStatusCode();
        if (i1 == 200)
        {
          str = paramString;
          paramString = EntityUtils.toString(((HttpResponse)localObject).getEntity());
          str = paramString;
          localObject = paramString;
          if (!paramString.startsWith(c))
          {
            str = paramString;
            return d(paramString);
          }
        }
        else
        {
          str = paramString;
          ah.c(a, "Cannot process with responseCode " + i1);
          str = paramString;
          e("Error when fetching application's android market ID, responseCode " + i1);
          return paramString;
        }
      }
    }
    catch (UnknownHostException paramString)
    {
      ah.c(a, "Unknown host: " + paramString.getMessage());
      if (this.z != null) {
        e("Unknown host: " + paramString.getMessage());
      }
      return null;
    }
    catch (Exception paramString)
    {
      ah.c(a, "Failed on url: " + str, paramString);
      localObject = null;
    }
    return (String)localObject;
  }
  
  private void e(String paramString)
  {
    a(new ae(this, paramString));
  }
  
  /* Error */
  private AdImage n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   21: iconst_1
    //   22: invokevirtual 420	com/flurry/android/z:a	(S)Lcom/flurry/android/AdImage;
    //   25: astore_2
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	u
    //   6	2	1	bool	boolean
    //   12	14	2	localAdImage	AdImage
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   17	26	29	finally
  }
  
  private static String o()
  {
    if (FlurryAgent.a != null) {
      return FlurryAgent.a;
    }
    return f;
  }
  
  private boolean p()
  {
    if (!this.q) {
      ah.d(a, "AppCircle is not initialized");
    }
    if (this.r == null) {
      ah.d(a, "Cannot identify UDID.");
    }
    return this.q;
  }
  
  /* Error */
  final android.view.View a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifne +9 -> 19
    //   13: aconst_null
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: new 434	com/flurry/android/o
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: iload_3
    //   27: invokespecial 437	com/flurry/android/o:<init>	(Lcom/flurry/android/u;Landroid/content/Context;Ljava/lang/String;I)V
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 439	com/flurry/android/u:w	Lcom/flurry/android/ag;
    //   35: aload_1
    //   36: invokevirtual 444	com/flurry/android/ag:a	(Lcom/flurry/android/o;)V
    //   39: goto -24 -> 15
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	u
    //   0	47	1	paramContext	Context
    //   0	47	2	paramString	String
    //   0	47	3	paramInt	int
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	42	finally
    //   19	39	42	finally
  }
  
  /* Error */
  final AdImage a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +11 -> 19
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: monitorexit
    //   16: aload 4
    //   18: areturn
    //   19: aload_0
    //   20: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   23: lload_1
    //   24: invokevirtual 447	com/flurry/android/z:b	(J)Lcom/flurry/android/AdImage;
    //   27: astore 4
    //   29: goto -15 -> 14
    //   32: astore 4
    //   34: aload_0
    //   35: monitorexit
    //   36: aload 4
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	u
    //   0	39	1	paramLong	long
    //   6	2	3	bool	boolean
    //   12	16	4	localAdImage	AdImage
    //   32	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   19	29	32	finally
  }
  
  final String a(p paramp)
  {
    try
    {
      Object localObject1 = paramp.b;
      long l1 = paramp.a();
      paramp = new StringBuilder().append("?apik=").append(this.j).append("&cid=").append(((v)localObject1).e).append("&adid=").append(((v)localObject1).a).append("&pid=").append(this.r).append("&iid=").append(this.k).append("&sid=").append(this.l).append("&its=").append(l1).append("&hid=").append(r.a(paramp.a)).append("&ac=").append(a(((v)localObject1).g));
      if ((this.s != null) && (!this.s.isEmpty()))
      {
        localObject1 = this.s.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = "c_" + r.a((String)((Map.Entry)localObject2).getKey());
          localObject2 = r.a((String)((Map.Entry)localObject2).getValue());
          paramp.append("&").append(str).append("=").append((String)localObject2);
        }
      }
      paramp.append("&ats=").append(System.currentTimeMillis());
    }
    finally {}
    paramp = paramp.toString();
    return paramp;
  }
  
  final List a(Context paramContext, List paramList, Long paramLong, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (!p())
        {
          paramContext = Collections.emptyList();
          return paramContext;
        }
        if ((!this.o.b()) || (paramList == null)) {
          break label249;
        }
        List localList = a(paramList, paramLong);
        int i2 = Math.min(paramList.size(), localList.size());
        paramLong = new ArrayList();
        i1 = 0;
        if (i1 < i2)
        {
          Object localObject = (String)paramList.get(i1);
          e locale = this.o.b((String)localObject);
          if (locale != null)
          {
            localObject = new p((String)paramList.get(i1), (byte)1, j());
            c((p)localObject);
            if (i1 < localList.size())
            {
              ((p)localObject).b = ((v)localList.get(i1));
              ((p)localObject).a(new f((byte)2, j()));
              paramLong.add(new y(paramContext, this, (p)localObject, locale, paramInt, paramBoolean));
            }
          }
          else
          {
            ah.d(a, "Cannot find hook: " + (String)localObject);
          }
        }
      }
      finally {}
      paramContext = paramLong;
      continue;
      label249:
      paramContext = Collections.emptyList();
      continue;
      i1 += 1;
    }
  }
  
  final void a(int paramInt)
  {
    try
    {
      if (this.z != null) {
        a(new ad(this, paramInt));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void a(long paramLong1, long paramLong2)
  {
    try
    {
      this.l = paramLong1;
      this.m = paramLong2;
      this.n = 0L;
      this.x.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void a(Context paramContext, long paramLong)
  {
    for (;;)
    {
      OfferInSdk localOfferInSdk;
      try
      {
        boolean bool = p();
        if (!bool) {
          return;
        }
        localOfferInSdk = (OfferInSdk)this.y.get(Long.valueOf(paramLong));
        if (localOfferInSdk == null)
        {
          ah.b(a, "Cannot find offer " + paramLong);
          continue;
        }
        localp = b(localOfferInSdk.b);
      }
      finally {}
      p localp;
      localOfferInSdk.b = localp;
      String str = FlurryAgent.c() + a(localp);
      ah.a(a, "Offer " + localOfferInSdk.a + " accepted. Sent with cookies: " + this.s);
      a(paramContext, localp, str);
    }
  }
  
  /* Error */
  final void a(Context paramContext, a parama)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 425	com/flurry/android/u:q	Z
    //   8: ifne +186 -> 194
    //   11: aload_0
    //   12: aload_2
    //   13: getfield 569	com/flurry/android/a:c	Ljava/lang/String;
    //   16: putfield 571	com/flurry/android/u:h	Ljava/lang/String;
    //   19: aload_0
    //   20: aload_2
    //   21: getfield 572	com/flurry/android/a:d	Ljava/lang/String;
    //   24: putfield 574	com/flurry/android/u:i	Ljava/lang/String;
    //   27: aload_0
    //   28: aload_2
    //   29: getfield 575	com/flurry/android/a:a	Ljava/lang/String;
    //   32: putfield 452	com/flurry/android/u:j	Ljava/lang/String;
    //   35: aload_0
    //   36: aload_2
    //   37: getfield 577	com/flurry/android/a:b	J
    //   40: putfield 467	com/flurry/android/u:k	J
    //   43: aload_0
    //   44: aload_2
    //   45: getfield 579	com/flurry/android/a:e	Landroid/os/Handler;
    //   48: putfield 581	com/flurry/android/u:t	Landroid/os/Handler;
    //   51: aload_0
    //   52: new 441	com/flurry/android/ag
    //   55: dup
    //   56: aload_0
    //   57: getfield 581	com/flurry/android/u:t	Landroid/os/Handler;
    //   60: getstatic 79	com/flurry/android/u:g	I
    //   63: invokespecial 584	com/flurry/android/ag:<init>	(Landroid/os/Handler;I)V
    //   66: putfield 439	com/flurry/android/u:w	Lcom/flurry/android/ag;
    //   69: aload_1
    //   70: invokevirtual 588	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   73: invokevirtual 594	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   76: pop
    //   77: aload_0
    //   78: getfield 104	com/flurry/android/u:y	Ljava/util/Map;
    //   81: invokeinterface 595 1 0
    //   86: aload_0
    //   87: getfield 97	com/flurry/android/u:v	Ljava/util/Map;
    //   90: invokeinterface 595 1 0
    //   95: aload_0
    //   96: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   99: aload_1
    //   100: aload_0
    //   101: aload_2
    //   102: invokevirtual 598	com/flurry/android/z:a	(Landroid/content/Context;Lcom/flurry/android/u;Lcom/flurry/android/a;)V
    //   105: aload_0
    //   106: getfield 95	com/flurry/android/u:s	Ljava/util/Map;
    //   109: invokeinterface 595 1 0
    //   114: aload_1
    //   115: invokevirtual 602	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   118: astore_2
    //   119: aload_1
    //   120: invokevirtual 605	android/content/Context:getPackageName	()Ljava/lang/String;
    //   123: astore_1
    //   124: new 186	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   131: getstatic 53	com/flurry/android/u:d	Ljava/lang/String;
    //   134: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_1
    //   145: new 291	android/content/Intent
    //   148: dup
    //   149: ldc_w 293
    //   152: invokespecial 296	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   155: astore 4
    //   157: aload 4
    //   159: aload_1
    //   160: invokestatic 302	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   163: invokevirtual 306	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   166: pop
    //   167: aload_2
    //   168: aload 4
    //   170: ldc_w 606
    //   173: invokevirtual 612	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   176: invokeinterface 255 1 0
    //   181: ifle +16 -> 197
    //   184: aload_0
    //   185: iload_3
    //   186: putfield 90	com/flurry/android/u:p	Z
    //   189: aload_0
    //   190: iconst_1
    //   191: putfield 425	com/flurry/android/u:q	Z
    //   194: aload_0
    //   195: monitorexit
    //   196: return
    //   197: iconst_0
    //   198: istore_3
    //   199: goto -15 -> 184
    //   202: astore_1
    //   203: aload_0
    //   204: monitorexit
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	u
    //   0	207	1	paramContext	Context
    //   0	207	2	parama	a
    //   1	198	3	bool	boolean
    //   155	14	4	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   4	184	202	finally
    //   184	194	202	finally
  }
  
  /* Error */
  final void a(Context paramContext, p paramp, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 581	com/flurry/android/u:t	Landroid/os/Handler;
    //   20: new 614	com/flurry/android/ak
    //   23: dup
    //   24: aload_0
    //   25: aload_3
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial 617	com/flurry/android/ak:<init>	(Lcom/flurry/android/u;Ljava/lang/String;Landroid/content/Context;Lcom/flurry/android/p;)V
    //   31: invokevirtual 331	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   34: pop
    //   35: goto -22 -> 13
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	u
    //   0	43	1	paramContext	Context
    //   0	43	2	paramp	p
    //   0	43	3	paramString	String
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	38	finally
    //   16	35	38	finally
  }
  
  final void a(Context paramContext, String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        boolean bool = p();
        if (!bool) {
          return;
        }
        try
        {
          localObject = a(Arrays.asList(new String[] { paramString }), null);
          if ((localObject == null) || (((List)localObject).isEmpty())) {
            break label157;
          }
          p localp = new p(paramString, (byte)2, j());
          localp.b = ((v)((List)localObject).get(0));
          c(localp);
          b(paramContext, localp, this.h + a(localp));
        }
        catch (Exception paramContext)
        {
          ah.d(a, "Failed to launch promotional canvas for hook: " + paramString, paramContext);
        }
        continue;
        localObject = new Intent(o());
      }
      finally {}
      label157:
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      paramContext.startActivity((Intent)localObject);
    }
  }
  
  final void a(AppCircleCallback paramAppCircleCallback)
  {
    this.z = paramAppCircleCallback;
  }
  
  final void a(String paramString)
  {
    this.r = paramString;
  }
  
  final void a(String paramString1, String paramString2)
  {
    try
    {
      this.s.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  final void a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 236 1 0
    //   20: astore_1
    //   21: aload_1
    //   22: invokeinterface 241 1 0
    //   27: ifeq -16 -> 11
    //   30: aload_1
    //   31: invokeinterface 245 1 0
    //   36: checkcast 153	java/lang/Long
    //   39: astore_3
    //   40: aload_0
    //   41: getfield 104	com/flurry/android/u:y	Ljava/util/Map;
    //   44: aload_3
    //   45: invokeinterface 628 2 0
    //   50: pop
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	u
    //   0	59	1	paramList	List
    //   6	2	2	bool	boolean
    //   39	6	3	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   2	7	54	finally
    //   14	21	54	finally
    //   21	51	54	finally
  }
  
  /* Error */
  final void a(Map paramMap1, Map paramMap2, Map paramMap3, Map paramMap4, Map paramMap5, Map paramMap6)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore 7
    //   8: iload 7
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   20: aload_1
    //   21: aload_2
    //   22: aload_3
    //   23: aload 4
    //   25: aload 5
    //   27: aload 6
    //   29: invokevirtual 631	com/flurry/android/z:a	(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V
    //   32: ldc 63
    //   34: aload_0
    //   35: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   38: invokevirtual 632	com/flurry/android/z:toString	()Ljava/lang/String;
    //   41: invokestatic 636	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: goto -32 -> 13
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	u
    //   0	53	1	paramMap1	Map
    //   0	53	2	paramMap2	Map
    //   0	53	3	paramMap3	Map
    //   0	53	4	paramMap4	Map
    //   0	53	5	paramMap5	Map
    //   0	53	6	paramMap6	Map
    //   6	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	48	finally
    //   16	45	48	finally
  }
  
  final void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  final boolean a()
  {
    return this.q;
  }
  
  /* Error */
  final Offer b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 417	com/flurry/android/u:p	()Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifne +10 -> 21
    //   14: aload 4
    //   16: astore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_3
    //   20: areturn
    //   21: aload_0
    //   22: iconst_1
    //   23: anewarray 216	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: invokestatic 225	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   33: aconst_null
    //   34: invokespecial 514	com/flurry/android/u:a	(Ljava/util/List;Ljava/lang/Long;)Ljava/util/List;
    //   37: astore 5
    //   39: aload 4
    //   41: astore_3
    //   42: aload 5
    //   44: ifnull -27 -> 17
    //   47: aload 4
    //   49: astore_3
    //   50: aload 5
    //   52: invokeinterface 202 1 0
    //   57: ifne -40 -> 17
    //   60: aload_0
    //   61: aload_1
    //   62: aload 5
    //   64: iconst_0
    //   65: invokeinterface 214 2 0
    //   70: checkcast 136	com/flurry/android/v
    //   73: invokespecial 642	com/flurry/android/u:a	(Ljava/lang/String;Lcom/flurry/android/v;)Lcom/flurry/android/Offer;
    //   76: astore_3
    //   77: getstatic 65	com/flurry/android/u:a	Ljava/lang/String;
    //   80: new 186	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 644
    //   90: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 647	com/flurry/android/Offer:getId	()J
    //   97: invokevirtual 459	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 289	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: goto -90 -> 17
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	u
    //   0	115	1	paramString	String
    //   9	2	2	bool	boolean
    //   16	78	3	localObject1	Object
    //   1	47	4	localObject2	Object
    //   37	26	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   5	10	110	finally
    //   21	39	110	finally
    //   50	107	110	finally
  }
  
  final p b(long paramLong)
  {
    try
    {
      p localp = (p)this.v.get(Long.valueOf(paramLong));
      return localp;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final p b(p paramp)
  {
    p localp = paramp;
    try
    {
      if (!this.x.contains(paramp))
      {
        localp = new p(paramp, j());
        this.x.add(localp);
      }
      localp.a(new f((byte)4, j()));
      return localp;
    }
    finally {}
  }
  
  /* Error */
  final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   18: invokevirtual 656	com/flurry/android/z:d	()V
    //   21: goto -10 -> 11
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	u
    //   6	2	1	bool	boolean
    //   24	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
    //   14	21	24	finally
  }
  
  /* Error */
  final List c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: ifne +11 -> 17
    //   9: invokestatic 210	java/util/Collections:emptyList	()Ljava/util/List;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   21: invokevirtual 204	com/flurry/android/z:b	()Z
    //   24: ifne +10 -> 34
    //   27: invokestatic 210	java/util/Collections:emptyList	()Ljava/util/List;
    //   30: astore_1
    //   31: goto -18 -> 13
    //   34: aload_0
    //   35: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   38: aload_1
    //   39: invokevirtual 219	com/flurry/android/z:a	(Ljava/lang/String;)[Lcom/flurry/android/v;
    //   42: astore 5
    //   44: new 99	java/util/ArrayList
    //   47: dup
    //   48: invokespecial 100	java/util/ArrayList:<init>	()V
    //   51: astore 4
    //   53: aload 5
    //   55: ifnull +44 -> 99
    //   58: aload 5
    //   60: arraylength
    //   61: ifle +38 -> 99
    //   64: aload 5
    //   66: arraylength
    //   67: istore_3
    //   68: iconst_0
    //   69: istore_2
    //   70: iload_2
    //   71: iload_3
    //   72: if_icmpge +27 -> 99
    //   75: aload 4
    //   77: aload_0
    //   78: aload_1
    //   79: aload 5
    //   81: iload_2
    //   82: aaload
    //   83: invokespecial 642	com/flurry/android/u:a	(Ljava/lang/String;Lcom/flurry/android/v;)Lcom/flurry/android/Offer;
    //   86: invokeinterface 358 2 0
    //   91: pop
    //   92: iload_2
    //   93: iconst_1
    //   94: iadd
    //   95: istore_2
    //   96: goto -26 -> 70
    //   99: getstatic 65	com/flurry/android/u:a	Ljava/lang/String;
    //   102: new 186	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 659
    //   112: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokeinterface 255 1 0
    //   122: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc_w 661
    //   128: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 289	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   137: pop
    //   138: aload 4
    //   140: astore_1
    //   141: goto -128 -> 13
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	u
    //   0	149	1	paramString	String
    //   69	27	2	i1	int
    //   67	6	3	i2	int
    //   51	88	4	localArrayList	ArrayList
    //   42	38	5	arrayOfv	v[]
    // Exception table:
    //   from	to	target	type
    //   2	13	144	finally
    //   17	31	144	finally
    //   34	53	144	finally
    //   58	68	144	finally
    //   75	92	144	finally
    //   99	138	144	finally
  }
  
  /* Error */
  final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   18: invokevirtual 663	com/flurry/android/z:e	()V
    //   21: goto -10 -> 11
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	u
    //   6	2	1	bool	boolean
    //   24	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
    //   14	21	24	finally
  }
  
  /* Error */
  final long d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: lconst_0
    //   12: lstore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: lload_2
    //   16: lreturn
    //   17: aload_0
    //   18: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   21: invokevirtual 665	com/flurry/android/z:c	()J
    //   24: lstore_2
    //   25: goto -12 -> 13
    //   28: astore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	u
    //   6	2	1	bool	boolean
    //   12	13	2	l1	long
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  final Set e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: ifne +11 -> 17
    //   9: invokestatic 668	java/util/Collections:emptySet	()Ljava/util/Set;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   21: invokevirtual 670	com/flurry/android/z:a	()Ljava/util/Set;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	u
    //   12	13	1	localSet	Set
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
    //   17	25	28	finally
  }
  
  final List f()
  {
    try
    {
      List localList = this.x;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void g()
  {
    try
    {
      this.v.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final boolean h()
  {
    return this.u;
  }
  
  final String i()
  {
    return this.h;
  }
  
  /* Error */
  final long j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 675	android/os/SystemClock:elapsedRealtime	()J
    //   5: aload_0
    //   6: getfield 533	com/flurry/android/u:m	J
    //   9: lsub
    //   10: lstore_1
    //   11: lload_1
    //   12: aload_0
    //   13: getfield 535	com/flurry/android/u:n	J
    //   16: lcmp
    //   17: ifle +17 -> 34
    //   20: aload_0
    //   21: lload_1
    //   22: putfield 535	com/flurry/android/u:n	J
    //   25: aload_0
    //   26: getfield 535	com/flurry/android/u:n	J
    //   29: lstore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: lload_1
    //   33: lreturn
    //   34: aload_0
    //   35: getfield 535	com/flurry/android/u:n	J
    //   38: lconst_1
    //   39: ladd
    //   40: lstore_1
    //   41: aload_0
    //   42: lload_1
    //   43: putfield 535	com/flurry/android/u:n	J
    //   46: goto -26 -> 20
    //   49: astore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_3
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	u
    //   10	33	1	l1	long
    //   49	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	49	finally
    //   20	30	49	finally
    //   34	46	49	finally
  }
  
  final void k()
  {
    try
    {
      this.s.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  final AdImage l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: invokespecial 677	com/flurry/android/u:n	()Lcom/flurry/android/AdImage;
    //   21: astore_2
    //   22: goto -9 -> 13
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	u
    //   6	2	1	bool	boolean
    //   12	10	2	localAdImage	AdImage
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  /* Error */
  final boolean m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 417	com/flurry/android/u:p	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 109	com/flurry/android/u:o	Lcom/flurry/android/z;
    //   21: invokevirtual 204	com/flurry/android/z:b	()Z
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	u
    //   6	19	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public final void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: checkcast 519	com/flurry/android/y
    //   6: astore_3
    //   7: aload_0
    //   8: aload_3
    //   9: invokevirtual 682	com/flurry/android/y:a	()Lcom/flurry/android/p;
    //   12: invokevirtual 552	com/flurry/android/u:b	(Lcom/flurry/android/p;)Lcom/flurry/android/p;
    //   15: astore_2
    //   16: aload_3
    //   17: aload_2
    //   18: invokevirtual 684	com/flurry/android/y:a	(Lcom/flurry/android/p;)V
    //   21: aload_0
    //   22: aload_2
    //   23: invokevirtual 556	com/flurry/android/u:a	(Lcom/flurry/android/p;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 639	com/flurry/android/u:u	Z
    //   31: ifeq +36 -> 67
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 690	android/view/View:getContext	()Landroid/content/Context;
    //   39: aload_2
    //   40: new 186	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   47: aload_0
    //   48: getfield 571	com/flurry/android/u:h	Ljava/lang/String;
    //   51: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 620	com/flurry/android/u:b	(Landroid/content/Context;Lcom/flurry/android/p;Ljava/lang/String;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 690	android/view/View:getContext	()Landroid/content/Context;
    //   72: aload_2
    //   73: new 186	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   80: aload_0
    //   81: getfield 574	com/flurry/android/u:i	Ljava/lang/String;
    //   84: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokevirtual 565	com/flurry/android/u:a	(Landroid/content/Context;Lcom/flurry/android/p;Ljava/lang/String;)V
    //   97: goto -33 -> 64
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	u
    //   0	105	1	paramView	android.view.View
    //   15	58	2	localp	p
    //   6	82	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	100	finally
    //   67	97	100	finally
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[adLogs=").append(this.x).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */