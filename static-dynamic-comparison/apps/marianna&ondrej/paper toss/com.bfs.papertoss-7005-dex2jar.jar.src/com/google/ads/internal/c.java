package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.l;
import com.google.ads.l.a;
import com.google.ads.m;
import com.google.ads.searchads.SearchAdRequest;
import com.google.ads.util.AdUtil;
import com.google.ads.util.AdUtil.a;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import com.google.ads.util.i.d;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

public class c
  implements Runnable
{
  boolean a;
  private String b;
  private String c;
  private String d;
  private String e;
  private boolean f;
  private f g;
  private d h;
  private AdRequest i;
  private WebView j;
  private String k;
  private LinkedList<String> l;
  private String m;
  private AdSize n;
  private volatile boolean o;
  private boolean p;
  private AdRequest.ErrorCode q;
  private boolean r;
  private int s;
  private Thread t;
  private boolean u;
  private d v = d.b;
  
  protected c() {}
  
  public c(d paramd)
  {
    this.h = paramd;
    this.k = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.l = new LinkedList();
    this.q = null;
    this.r = false;
    this.s = -1;
    this.f = false;
    this.p = false;
    this.m = null;
    this.n = null;
    if ((Activity)paramd.h().e.a() != null)
    {
      this.j = new AdWebView(paramd.h(), null);
      this.j.setWebViewClient(i.a(paramd, a.b, false, false));
      this.j.setVisibility(8);
      this.j.setWillNotDraw(true);
      this.g = new f(this, paramd);
      return;
    }
    this.j = null;
    this.g = null;
    com.google.ads.util.b.e("activity was null while trying to create an AdLoader.");
  }
  
  static void a(String paramString, com.google.ads.c paramc, com.google.ads.d paramd)
  {
    if (paramString == null) {}
    while ((paramString.contains("no-store")) || (paramString.contains("no-cache"))) {
      return;
    }
    Matcher localMatcher = Pattern.compile("max-age\\s*=\\s*(\\d+)").matcher(paramString);
    if (localMatcher.find()) {
      try
      {
        int i1 = Integer.parseInt(localMatcher.group(1));
        paramd.a(paramc, i1);
        com.google.ads.util.b.c(String.format(Locale.US, "Caching gWhirl configuration for: %d seconds", new Object[] { Integer.valueOf(i1) }));
        return;
      }
      catch (NumberFormatException paramString)
      {
        com.google.ads.util.b.b("Caught exception trying to parse cache control directive. Overflow?", paramString);
        return;
      }
    }
    com.google.ads.util.b.c("Unrecognized cacheControlDirective: '" + paramString + "'. Not caching configuration.");
  }
  
  private void b(String paramString1, String paramString2)
  {
    this.h.a(new c(this.j, paramString2, paramString1));
  }
  
  private String d()
  {
    if ((this.i instanceof SearchAdRequest)) {
      return "AFMA_buildAdURL";
    }
    return "AFMA_buildAdURL";
  }
  
  private String e()
  {
    if ((this.i instanceof SearchAdRequest)) {
      return "AFMA_getSdkConstants();";
    }
    return "AFMA_getSdkConstants();";
  }
  
  private String f()
  {
    if ((this.i instanceof SearchAdRequest)) {
      return "http://www.gstatic.com/safa/";
    }
    return "http://media.admob.com/";
  }
  
  private String g()
  {
    if ((this.i instanceof SearchAdRequest)) {
      return "<html><head><script src=\"http://www.gstatic.com/safa/sdk-core-v40.js\"></script><script>";
    }
    return "<html><head><script src=\"http://media.admob.com/sdk-core-v40.js\"></script><script>";
  }
  
  private String h()
  {
    if ((this.i instanceof SearchAdRequest)) {
      return "</script></head><body></body></html>";
    }
    return "</script></head><body></body></html>";
  }
  
  private void i()
  {
    AdWebView localAdWebView = this.h.k();
    this.h.l().c(true);
    this.h.m().h();
    this.h.a(new c(localAdWebView, this.b, this.c));
  }
  
  private void j()
  {
    this.h.a(new e(this.h, this.j, this.l, this.s, this.p, this.m, this.n));
  }
  
  public String a(Map<String, Object> paramMap, Activity paramActivity)
    throws c.b
  {
    int i2 = 0;
    Context localContext = paramActivity.getApplicationContext();
    Object localObject1 = this.h.m();
    long l1 = ((g)localObject1).m();
    if (l1 > 0L) {
      paramMap.put("prl", Long.valueOf(l1));
    }
    l1 = ((g)localObject1).n();
    if (l1 > 0L) {
      paramMap.put("prnl", Long.valueOf(l1));
    }
    Object localObject2 = ((g)localObject1).l();
    if (localObject2 != null) {
      paramMap.put("ppcl", localObject2);
    }
    localObject2 = ((g)localObject1).k();
    if (localObject2 != null) {
      paramMap.put("pcl", localObject2);
    }
    l1 = ((g)localObject1).j();
    if (l1 > 0L) {
      paramMap.put("pcc", Long.valueOf(l1));
    }
    paramMap.put("preqs", Long.valueOf(((g)localObject1).o()));
    paramMap.put("oar", Long.valueOf(((g)localObject1).p()));
    paramMap.put("bas_on", Long.valueOf(((g)localObject1).s()));
    paramMap.put("bas_off", Long.valueOf(((g)localObject1).v()));
    if (((g)localObject1).y()) {
      paramMap.put("aoi_timeout", "true");
    }
    if (((g)localObject1).A()) {
      paramMap.put("aoi_nofill", "true");
    }
    localObject2 = ((g)localObject1).D();
    if (localObject2 != null) {
      paramMap.put("pit", localObject2);
    }
    paramMap.put("ptime", Long.valueOf(g.E()));
    ((g)localObject1).a();
    ((g)localObject1).i();
    if (this.h.h().b())
    {
      paramMap.put("format", "interstitial_mb");
      paramMap.put("slotname", this.h.h().d.a());
      paramMap.put("js", "afma-sdk-a-v6.2.1");
      localObject1 = localContext.getPackageName();
    }
    for (;;)
    {
      try
      {
        localObject1 = localContext.getPackageManager().getPackageInfo((String)localObject1, 0);
        i1 = ((PackageInfo)localObject1).versionCode;
        localObject1 = AdUtil.f(localContext);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramMap.put("mv", localObject1);
        }
        paramMap.put("msid", localContext.getPackageName());
        paramMap.put("app_name", i1 + ".android." + localContext.getPackageName());
        paramMap.put("isu", AdUtil.a(localContext));
        localObject2 = AdUtil.d(localContext);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
        paramMap.put("net", localObject1);
        localObject1 = AdUtil.e(localContext);
        if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
          paramMap.put("cap", localObject1);
        }
        paramMap.put("u_audio", Integer.valueOf(AdUtil.g(localContext).ordinal()));
        paramActivity = AdUtil.a(paramActivity);
        paramMap.put("u_sd", Float.valueOf(paramActivity.density));
        paramMap.put("u_h", Integer.valueOf(AdUtil.a(localContext, paramActivity)));
        paramMap.put("u_w", Integer.valueOf(AdUtil.b(localContext, paramActivity)));
        paramMap.put("hl", Locale.getDefault().getLanguage());
        if ((this.h.h().i != null) && (this.h.h().i.a() != null))
        {
          paramActivity = (AdView)this.h.h().i.a();
          if (paramActivity.getParent() != null)
          {
            localObject1 = new int[2];
            paramActivity.getLocationOnScreen((int[])localObject1);
            i3 = localObject1[0];
            int i4 = localObject1[1];
            localObject1 = ((Context)this.h.h().f.a()).getResources().getDisplayMetrics();
            i1 = ((DisplayMetrics)localObject1).widthPixels;
            int i5 = ((DisplayMetrics)localObject1).heightPixels;
            if ((!paramActivity.isShown()) || (paramActivity.getWidth() + i3 <= 0) || (paramActivity.getHeight() + i4 <= 0) || (i3 > i1) || (i4 > i5)) {
              break label1486;
            }
            i1 = 1;
            localObject1 = new HashMap();
            ((Map)localObject1).put("x", Integer.valueOf(i3));
            ((Map)localObject1).put("y", Integer.valueOf(i4));
            ((Map)localObject1).put("width", Integer.valueOf(paramActivity.getWidth()));
            ((Map)localObject1).put("height", Integer.valueOf(paramActivity.getHeight()));
            ((Map)localObject1).put("visible", Integer.valueOf(i1));
            paramMap.put("ad_pos", localObject1);
          }
        }
        paramActivity = new StringBuilder();
        localObject1 = (AdSize[])this.h.h().l.a();
        if (localObject1 == null) {
          break label1209;
        }
        int i3 = localObject1.length;
        i1 = i2;
        if (i1 < i3)
        {
          localObject2 = localObject1[i1];
          if (paramActivity.length() != 0) {
            paramActivity.append("|");
          }
          paramActivity.append(((AdSize)localObject2).getWidth() + "x" + ((AdSize)localObject2).getHeight());
          i1 += 1;
          continue;
          localObject1 = ((h)this.h.h().k.a()).b();
          if (((AdSize)localObject1).isFullWidth()) {
            paramMap.put("smart_w", "full");
          }
          if (((AdSize)localObject1).isAutoHeight()) {
            paramMap.put("smart_h", "auto");
          }
          if (!((AdSize)localObject1).isCustomAdSize())
          {
            paramMap.put("format", ((AdSize)localObject1).toString());
            break;
          }
          localObject2 = new HashMap();
          ((Map)localObject2).put("w", Integer.valueOf(((AdSize)localObject1).getWidth()));
          ((Map)localObject2).put("h", Integer.valueOf(((AdSize)localObject1).getHeight()));
          paramMap.put("ad_frame", localObject2);
        }
      }
      catch (PackageManager.NameNotFoundException paramMap)
      {
        throw new b("NameNotFoundException");
      }
      paramMap.put("sz", paramActivity.toString());
      label1209:
      paramActivity = (TelephonyManager)localContext.getSystemService("phone");
      paramMap.put("carrier", paramActivity.getNetworkOperator());
      paramMap.put("gnt", Integer.valueOf(paramActivity.getNetworkType()));
      if (AdUtil.c()) {
        paramMap.put("simulator", Integer.valueOf(1));
      }
      paramMap.put("session_id", com.google.ads.b.a().b().toString());
      paramMap.put("seq_num", com.google.ads.b.a().c().toString());
      paramMap = AdUtil.a(paramMap);
      if (((Boolean)((l.a)((l)this.h.h().a.a()).a.a()).l.a()).booleanValue()) {}
      for (paramMap = g() + d() + "(" + paramMap + ");" + h();; paramMap = g() + e() + d() + "(" + paramMap + ");" + h())
      {
        com.google.ads.util.b.c("adRequestUrlHtml: " + paramMap);
        return paramMap;
      }
      label1486:
      int i1 = 0;
    }
  }
  
  protected void a()
  {
    com.google.ads.util.b.a("AdLoader cancelled.");
    if (this.j != null)
    {
      this.j.stopLoading();
      this.j.destroy();
    }
    if (this.t != null)
    {
      this.t.interrupt();
      this.t = null;
    }
    if (this.g != null) {
      this.g.a();
    }
    this.o = true;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.s = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(AdRequest.ErrorCode paramErrorCode)
  {
    try
    {
      this.q = paramErrorCode;
      notify();
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  protected void a(AdRequest.ErrorCode paramErrorCode, boolean paramBoolean)
  {
    this.h.a(new a(this.h, this.j, this.g, paramErrorCode, paramBoolean));
  }
  
  protected void a(AdRequest paramAdRequest)
  {
    this.i = paramAdRequest;
    this.o = false;
    this.t = new Thread(this);
    this.t.start();
  }
  
  public void a(AdSize paramAdSize)
  {
    try
    {
      this.n = paramAdSize;
      return;
    }
    finally
    {
      paramAdSize = finally;
      throw paramAdSize;
    }
  }
  
  public void a(d paramd)
  {
    try
    {
      this.v = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  protected void a(String paramString)
  {
    try
    {
      this.l.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    try
    {
      this.b = paramString2;
      this.c = paramString1;
      notify();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void b()
  {
    try
    {
      if (TextUtils.isEmpty(this.e))
      {
        com.google.ads.util.b.b("Got a mediation response with no content type. Aborting mediation.");
        a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
        return;
      }
      if (!this.e.startsWith("application/json"))
      {
        com.google.ads.util.b.b("Got a mediation response with a content type: '" + this.e + "'. Expected something starting with 'application/json'. Aborting mediation.");
        a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      com.google.ads.util.b.b("AdLoader can't parse gWhirl server configuration.", localJSONException);
      a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
      return;
    }
    final com.google.ads.c localc = com.google.ads.c.a(this.c);
    a(this.d, localc, this.h.i());
    this.h.a(new Runnable()
    {
      public void run()
      {
        if (c.a(c.this) != null)
        {
          c.a(c.this).stopLoading();
          c.a(c.this).destroy();
        }
        c.c(c.this).a(c.b(c.this));
        if (c.d(c.this) != null) {
          ((h)c.c(c.this).h().k.a()).b(c.d(c.this));
        }
        c.c(c.this).a(localc);
      }
    });
  }
  
  protected void b(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.p = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void c()
  {
    try
    {
      this.r = true;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void c(String paramString)
  {
    try
    {
      this.d = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      this.u = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      this.k = paramString;
      notify();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    try
    {
      this.a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void e(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/google/ads/internal/c:j	Landroid/webkit/WebView;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 149	com/google/ads/internal/c:g	Lcom/google/ads/internal/f;
    //   13: ifnonnull +20 -> 33
    //   16: ldc_w 756
    //   19: invokestatic 156	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getstatic 718	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   26: iconst_0
    //   27: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   37: invokevirtual 99	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   40: getfield 104	com/google/ads/m:e	Lcom/google/ads/util/i$d;
    //   43: invokevirtual 109	com/google/ads/util/i$d:a	()Ljava/lang/Object;
    //   46: checkcast 111	android/app/Activity
    //   49: astore 8
    //   51: aload 8
    //   53: ifnonnull +27 -> 80
    //   56: ldc_w 758
    //   59: invokestatic 156	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getstatic 718	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   66: iconst_0
    //   67: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore 8
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 8
    //   79: athrow
    //   80: aload_0
    //   81: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   84: invokevirtual 759	com/google/ads/internal/d:o	()J
    //   87: lstore_1
    //   88: invokestatic 764	android/os/SystemClock:elapsedRealtime	()J
    //   91: lstore_3
    //   92: aload_0
    //   93: getfield 253	com/google/ads/internal/c:i	Lcom/google/ads/AdRequest;
    //   96: aload_0
    //   97: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   100: invokevirtual 99	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   103: getfield 502	com/google/ads/m:f	Lcom/google/ads/util/i$b;
    //   106: invokevirtual 381	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   109: checkcast 387	android/content/Context
    //   112: invokevirtual 770	com/google/ads/AdRequest:getRequestMap	(Landroid/content/Context;)Ljava/util/Map;
    //   115: astore 9
    //   117: aload 9
    //   119: ldc_w 772
    //   122: invokeinterface 776 2 0
    //   127: astore 10
    //   129: aload 10
    //   131: instanceof 306
    //   134: ifeq +142 -> 276
    //   137: aload 10
    //   139: checkcast 306	java/util/Map
    //   142: astore 10
    //   144: aload 10
    //   146: ldc_w 778
    //   149: invokeinterface 776 2 0
    //   154: astore 11
    //   156: aload 11
    //   158: instanceof 164
    //   161: ifeq +12 -> 173
    //   164: aload_0
    //   165: aload 11
    //   167: checkcast 164	java/lang/String
    //   170: putfield 71	com/google/ads/internal/c:b	Ljava/lang/String;
    //   173: aload 10
    //   175: ldc_w 780
    //   178: invokeinterface 776 2 0
    //   183: astore 11
    //   185: aload 11
    //   187: instanceof 164
    //   190: ifeq +12 -> 202
    //   193: aload_0
    //   194: aload 11
    //   196: checkcast 164	java/lang/String
    //   199: putfield 69	com/google/ads/internal/c:k	Ljava/lang/String;
    //   202: aload 10
    //   204: ldc_w 782
    //   207: invokeinterface 776 2 0
    //   212: astore 11
    //   214: aload 11
    //   216: instanceof 164
    //   219: ifeq +19 -> 238
    //   222: aload 11
    //   224: ldc_w 783
    //   227: invokevirtual 786	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +124 -> 354
    //   233: aload_0
    //   234: iconst_1
    //   235: putfield 86	com/google/ads/internal/c:s	I
    //   238: aload 10
    //   240: ldc_w 788
    //   243: invokeinterface 776 2 0
    //   248: astore 10
    //   250: aload 10
    //   252: instanceof 164
    //   255: ifeq +21 -> 276
    //   258: aload 10
    //   260: ldc_w 789
    //   263: invokevirtual 786	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +10 -> 276
    //   269: aload_0
    //   270: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   273: invokevirtual 791	com/google/ads/internal/d:d	()V
    //   276: aload_0
    //   277: getfield 71	com/google/ads/internal/c:b	Ljava/lang/String;
    //   280: ifnonnull +585 -> 865
    //   283: aload_0
    //   284: getfield 69	com/google/ads/internal/c:k	Ljava/lang/String;
    //   287: astore 10
    //   289: aload 10
    //   291: ifnonnull +235 -> 526
    //   294: aload_0
    //   295: aload 9
    //   297: aload 8
    //   299: invokevirtual 793	com/google/ads/internal/c:a	(Ljava/util/Map;Landroid/app/Activity;)Ljava/lang/String;
    //   302: astore 8
    //   304: aload_0
    //   305: aload 8
    //   307: aload_0
    //   308: invokespecial 795	com/google/ads/internal/c:f	()Ljava/lang/String;
    //   311: invokespecial 797	com/google/ads/internal/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: invokestatic 764	android/os/SystemClock:elapsedRealtime	()J
    //   317: lstore 5
    //   319: lload_1
    //   320: lload 5
    //   322: lload_3
    //   323: lsub
    //   324: lsub
    //   325: lstore 5
    //   327: lload 5
    //   329: lconst_0
    //   330: lcmp
    //   331: ifle +9 -> 340
    //   334: aload_0
    //   335: lload 5
    //   337: invokevirtual 801	java/lang/Object:wait	(J)V
    //   340: aload_0
    //   341: getfield 685	com/google/ads/internal/c:o	Z
    //   344: istore 7
    //   346: iload 7
    //   348: ifeq +112 -> 460
    //   351: aload_0
    //   352: monitorexit
    //   353: return
    //   354: aload 11
    //   356: ldc_w 802
    //   359: invokevirtual 786	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   362: ifeq -124 -> 238
    //   365: aload_0
    //   366: iconst_0
    //   367: putfield 86	com/google/ads/internal/c:s	I
    //   370: goto -132 -> 238
    //   373: astore 8
    //   375: ldc_w 804
    //   378: aload 8
    //   380: invokestatic 226	com/google/ads/util/b:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   383: aload_0
    //   384: getstatic 718	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   387: iconst_1
    //   388: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   391: aload_0
    //   392: monitorexit
    //   393: return
    //   394: astore 8
    //   396: new 228	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 806
    //   406: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 8
    //   411: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   420: aload_0
    //   421: getstatic 718	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   424: iconst_0
    //   425: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   428: aload_0
    //   429: monitorexit
    //   430: return
    //   431: astore 8
    //   433: new 228	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 811
    //   443: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 8
    //   448: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 669	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   457: aload_0
    //   458: monitorexit
    //   459: return
    //   460: aload_0
    //   461: getfield 82	com/google/ads/internal/c:q	Lcom/google/ads/AdRequest$ErrorCode;
    //   464: ifnull +15 -> 479
    //   467: aload_0
    //   468: aload_0
    //   469: getfield 82	com/google/ads/internal/c:q	Lcom/google/ads/AdRequest$ErrorCode;
    //   472: iconst_0
    //   473: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   476: aload_0
    //   477: monitorexit
    //   478: return
    //   479: aload_0
    //   480: getfield 69	com/google/ads/internal/c:k	Ljava/lang/String;
    //   483: ifnonnull +43 -> 526
    //   486: new 228	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 813
    //   496: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: lload_1
    //   500: invokevirtual 816	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   503: ldc_w 818
    //   506: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   515: aload_0
    //   516: getstatic 821	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   519: iconst_0
    //   520: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   523: aload_0
    //   524: monitorexit
    //   525: return
    //   526: aload_0
    //   527: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   530: invokevirtual 280	com/google/ads/internal/d:m	()Lcom/google/ads/internal/g;
    //   533: astore 8
    //   535: getstatic 824	com/google/ads/internal/c$2:a	[I
    //   538: aload_0
    //   539: getfield 63	com/google/ads/internal/c:v	Lcom/google/ads/internal/c$d;
    //   542: invokevirtual 825	com/google/ads/internal/c$d:ordinal	()I
    //   545: iaload
    //   546: tableswitch	default:+668->1214, 1:+105->651, 2:+129->675, 3:+143->689, 4:+162->708
    //   576: aload_0
    //   577: getfield 749	com/google/ads/internal/c:a	Z
    //   580: ifne +251 -> 831
    //   583: ldc_w 827
    //   586: invokestatic 669	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   589: aload_0
    //   590: getfield 149	com/google/ads/internal/c:g	Lcom/google/ads/internal/f;
    //   593: aload_0
    //   594: getfield 747	com/google/ads/internal/c:u	Z
    //   597: invokevirtual 829	com/google/ads/internal/f:a	(Z)V
    //   600: aload_0
    //   601: getfield 149	com/google/ads/internal/c:g	Lcom/google/ads/internal/f;
    //   604: aload_0
    //   605: getfield 69	com/google/ads/internal/c:k	Ljava/lang/String;
    //   608: invokevirtual 830	com/google/ads/internal/f:a	(Ljava/lang/String;)V
    //   611: invokestatic 764	android/os/SystemClock:elapsedRealtime	()J
    //   614: lstore 5
    //   616: lload_1
    //   617: lload 5
    //   619: lload_3
    //   620: lsub
    //   621: lsub
    //   622: lstore 5
    //   624: lload 5
    //   626: lconst_0
    //   627: lcmp
    //   628: ifle +9 -> 637
    //   631: aload_0
    //   632: lload 5
    //   634: invokevirtual 801	java/lang/Object:wait	(J)V
    //   637: aload_0
    //   638: getfield 685	com/google/ads/internal/c:o	Z
    //   641: istore 7
    //   643: iload 7
    //   645: ifeq +120 -> 765
    //   648: aload_0
    //   649: monitorexit
    //   650: return
    //   651: aload 8
    //   653: invokevirtual 832	com/google/ads/internal/g:r	()V
    //   656: aload 8
    //   658: invokevirtual 834	com/google/ads/internal/g:u	()V
    //   661: aload 8
    //   663: invokevirtual 836	com/google/ads/internal/g:x	()V
    //   666: ldc_w 838
    //   669: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   672: goto -96 -> 576
    //   675: aload 8
    //   677: invokevirtual 840	com/google/ads/internal/g:t	()V
    //   680: ldc_w 842
    //   683: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   686: goto -110 -> 576
    //   689: aload 8
    //   691: invokevirtual 844	com/google/ads/internal/g:w	()V
    //   694: aload 8
    //   696: invokevirtual 846	com/google/ads/internal/g:q	()V
    //   699: ldc_w 848
    //   702: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   705: goto -129 -> 576
    //   708: aload 8
    //   710: invokevirtual 846	com/google/ads/internal/g:q	()V
    //   713: ldc_w 850
    //   716: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   719: ldc_w 852
    //   722: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   725: aload_0
    //   726: getstatic 821	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   729: iconst_0
    //   730: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   733: aload_0
    //   734: monitorexit
    //   735: return
    //   736: astore 8
    //   738: new 228	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   745: ldc_w 854
    //   748: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload 8
    //   753: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 669	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   762: aload_0
    //   763: monitorexit
    //   764: return
    //   765: aload_0
    //   766: getfield 82	com/google/ads/internal/c:q	Lcom/google/ads/AdRequest$ErrorCode;
    //   769: ifnull +15 -> 784
    //   772: aload_0
    //   773: aload_0
    //   774: getfield 82	com/google/ads/internal/c:q	Lcom/google/ads/AdRequest$ErrorCode;
    //   777: iconst_0
    //   778: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   781: aload_0
    //   782: monitorexit
    //   783: return
    //   784: aload_0
    //   785: getfield 73	com/google/ads/internal/c:c	Ljava/lang/String;
    //   788: ifnonnull +77 -> 865
    //   791: new 228	java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   798: ldc_w 813
    //   801: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: lload_1
    //   805: invokevirtual 816	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   808: ldc_w 856
    //   811: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   820: aload_0
    //   821: getstatic 821	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   824: iconst_0
    //   825: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   828: aload_0
    //   829: monitorexit
    //   830: return
    //   831: aload_0
    //   832: aload_0
    //   833: getfield 69	com/google/ads/internal/c:k	Ljava/lang/String;
    //   836: putfield 71	com/google/ads/internal/c:b	Ljava/lang/String;
    //   839: new 228	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   846: ldc_w 858
    //   849: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload_0
    //   853: getfield 71	com/google/ads/internal/c:b	Ljava/lang/String;
    //   856: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 669	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   865: aload_0
    //   866: getfield 749	com/google/ads/internal/c:a	Z
    //   869: ifne +227 -> 1096
    //   872: aload_0
    //   873: getfield 88	com/google/ads/internal/c:f	Z
    //   876: ifeq +18 -> 894
    //   879: aload_0
    //   880: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   883: iconst_1
    //   884: invokevirtual 860	com/google/ads/internal/d:b	(Z)V
    //   887: aload_0
    //   888: invokevirtual 862	com/google/ads/internal/c:b	()V
    //   891: aload_0
    //   892: monitorexit
    //   893: return
    //   894: aload_0
    //   895: getfield 709	com/google/ads/internal/c:e	Ljava/lang/String;
    //   898: ifnull +72 -> 970
    //   901: aload_0
    //   902: getfield 709	com/google/ads/internal/c:e	Ljava/lang/String;
    //   905: ldc_w 722
    //   908: invokevirtual 726	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   911: ifne +16 -> 927
    //   914: aload_0
    //   915: getfield 709	com/google/ads/internal/c:e	Ljava/lang/String;
    //   918: ldc_w 864
    //   921: invokevirtual 726	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   924: ifeq +46 -> 970
    //   927: new 228	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   934: ldc_w 866
    //   937: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: aload_0
    //   941: getfield 709	com/google/ads/internal/c:e	Ljava/lang/String;
    //   944: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: ldc_w 868
    //   950: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokestatic 713	com/google/ads/util/b:b	(Ljava/lang/String;)V
    //   959: aload_0
    //   960: getstatic 718	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   963: iconst_0
    //   964: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   967: aload_0
    //   968: monitorexit
    //   969: return
    //   970: aload_0
    //   971: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   974: invokevirtual 99	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   977: getfield 544	com/google/ads/m:l	Lcom/google/ads/util/i$c;
    //   980: invokevirtual 547	com/google/ads/util/i$c:a	()Ljava/lang/Object;
    //   983: ifnull +95 -> 1078
    //   986: aload_0
    //   987: getfield 94	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   990: ifnonnull +20 -> 1010
    //   993: ldc_w 870
    //   996: invokestatic 713	com/google/ads/util/b:b	(Ljava/lang/String;)V
    //   999: aload_0
    //   1000: getstatic 718	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   1003: iconst_0
    //   1004: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   1007: aload_0
    //   1008: monitorexit
    //   1009: return
    //   1010: aload_0
    //   1011: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   1014: invokevirtual 99	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   1017: getfield 544	com/google/ads/m:l	Lcom/google/ads/util/i$c;
    //   1020: invokevirtual 547	com/google/ads/util/i$c:a	()Ljava/lang/Object;
    //   1023: checkcast 872	[Ljava/lang/Object;
    //   1026: invokestatic 878	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   1029: aload_0
    //   1030: getfield 94	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1033: invokeinterface 882 2 0
    //   1038: ifne +58 -> 1096
    //   1041: new 228	java/lang/StringBuilder
    //   1044: dup
    //   1045: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1048: ldc_w 884
    //   1051: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: aload_0
    //   1055: getfield 94	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1058: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 713	com/google/ads/util/b:b	(Ljava/lang/String;)V
    //   1067: aload_0
    //   1068: getstatic 718	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   1071: iconst_0
    //   1072: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   1075: aload_0
    //   1076: monitorexit
    //   1077: return
    //   1078: aload_0
    //   1079: getfield 94	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1082: ifnull +14 -> 1096
    //   1085: ldc_w 886
    //   1088: invokestatic 156	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   1091: aload_0
    //   1092: aconst_null
    //   1093: putfield 94	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1096: aload_0
    //   1097: getfield 67	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   1100: iconst_0
    //   1101: invokevirtual 860	com/google/ads/internal/d:b	(Z)V
    //   1104: aload_0
    //   1105: invokespecial 887	com/google/ads/internal/c:i	()V
    //   1108: invokestatic 764	android/os/SystemClock:elapsedRealtime	()J
    //   1111: lstore 5
    //   1113: lload_1
    //   1114: lload 5
    //   1116: lload_3
    //   1117: lsub
    //   1118: lsub
    //   1119: lstore_3
    //   1120: lload_3
    //   1121: lconst_0
    //   1122: lcmp
    //   1123: ifle +8 -> 1131
    //   1126: aload_0
    //   1127: lload_3
    //   1128: invokevirtual 801	java/lang/Object:wait	(J)V
    //   1131: aload_0
    //   1132: getfield 84	com/google/ads/internal/c:r	Z
    //   1135: ifeq +39 -> 1174
    //   1138: aload_0
    //   1139: invokespecial 889	com/google/ads/internal/c:j	()V
    //   1142: goto -751 -> 391
    //   1145: astore 8
    //   1147: new 228	java/lang/StringBuilder
    //   1150: dup
    //   1151: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1154: ldc_w 891
    //   1157: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: aload 8
    //   1162: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1165: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1168: invokestatic 669	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   1171: aload_0
    //   1172: monitorexit
    //   1173: return
    //   1174: new 228	java/lang/StringBuilder
    //   1177: dup
    //   1178: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1181: ldc_w 813
    //   1184: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: lload_1
    //   1188: invokevirtual 816	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1191: ldc_w 893
    //   1194: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1200: invokestatic 221	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   1203: aload_0
    //   1204: getstatic 821	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   1207: iconst_1
    //   1208: invokevirtual 720	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   1211: goto -820 -> 391
    //   1214: goto -638 -> 576
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1217	0	this	c
    //   87	1101	1	l1	long
    //   91	1037	3	l2	long
    //   317	798	5	l3	long
    //   344	300	7	bool	boolean
    //   49	3	8	localActivity1	Activity
    //   73	225	8	localActivity2	Activity
    //   302	4	8	str	String
    //   373	6	8	localThrowable	Throwable
    //   394	16	8	localb	b
    //   431	16	8	localInterruptedException1	InterruptedException
    //   533	176	8	localg	g
    //   736	16	8	localInterruptedException2	InterruptedException
    //   1145	16	8	localInterruptedException3	InterruptedException
    //   115	181	9	localMap	Map
    //   127	163	10	localObject1	Object
    //   154	201	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	73	finally
    //   16	30	73	finally
    //   30	32	73	finally
    //   33	51	73	finally
    //   56	70	73	finally
    //   70	72	73	finally
    //   75	77	73	finally
    //   80	173	73	finally
    //   173	202	73	finally
    //   202	238	73	finally
    //   238	276	73	finally
    //   276	289	73	finally
    //   294	304	73	finally
    //   304	319	73	finally
    //   334	340	73	finally
    //   340	346	73	finally
    //   351	353	73	finally
    //   354	370	73	finally
    //   375	391	73	finally
    //   391	393	73	finally
    //   396	428	73	finally
    //   428	430	73	finally
    //   433	457	73	finally
    //   457	459	73	finally
    //   460	476	73	finally
    //   476	478	73	finally
    //   479	523	73	finally
    //   523	525	73	finally
    //   526	576	73	finally
    //   576	616	73	finally
    //   631	637	73	finally
    //   637	643	73	finally
    //   648	650	73	finally
    //   651	672	73	finally
    //   675	686	73	finally
    //   689	705	73	finally
    //   708	733	73	finally
    //   733	735	73	finally
    //   738	762	73	finally
    //   762	764	73	finally
    //   765	781	73	finally
    //   781	783	73	finally
    //   784	828	73	finally
    //   828	830	73	finally
    //   831	865	73	finally
    //   865	891	73	finally
    //   891	893	73	finally
    //   894	927	73	finally
    //   927	967	73	finally
    //   967	969	73	finally
    //   970	1007	73	finally
    //   1007	1009	73	finally
    //   1010	1075	73	finally
    //   1075	1077	73	finally
    //   1078	1096	73	finally
    //   1096	1113	73	finally
    //   1126	1131	73	finally
    //   1131	1142	73	finally
    //   1147	1171	73	finally
    //   1171	1173	73	finally
    //   1174	1211	73	finally
    //   2	16	373	java/lang/Throwable
    //   16	30	373	java/lang/Throwable
    //   33	51	373	java/lang/Throwable
    //   56	70	373	java/lang/Throwable
    //   80	173	373	java/lang/Throwable
    //   173	202	373	java/lang/Throwable
    //   202	238	373	java/lang/Throwable
    //   238	276	373	java/lang/Throwable
    //   276	289	373	java/lang/Throwable
    //   294	304	373	java/lang/Throwable
    //   304	319	373	java/lang/Throwable
    //   334	340	373	java/lang/Throwable
    //   340	346	373	java/lang/Throwable
    //   354	370	373	java/lang/Throwable
    //   396	428	373	java/lang/Throwable
    //   433	457	373	java/lang/Throwable
    //   460	476	373	java/lang/Throwable
    //   479	523	373	java/lang/Throwable
    //   526	576	373	java/lang/Throwable
    //   576	616	373	java/lang/Throwable
    //   631	637	373	java/lang/Throwable
    //   637	643	373	java/lang/Throwable
    //   651	672	373	java/lang/Throwable
    //   675	686	373	java/lang/Throwable
    //   689	705	373	java/lang/Throwable
    //   708	733	373	java/lang/Throwable
    //   738	762	373	java/lang/Throwable
    //   765	781	373	java/lang/Throwable
    //   784	828	373	java/lang/Throwable
    //   831	865	373	java/lang/Throwable
    //   865	891	373	java/lang/Throwable
    //   894	927	373	java/lang/Throwable
    //   927	967	373	java/lang/Throwable
    //   970	1007	373	java/lang/Throwable
    //   1010	1075	373	java/lang/Throwable
    //   1078	1096	373	java/lang/Throwable
    //   1096	1113	373	java/lang/Throwable
    //   1126	1131	373	java/lang/Throwable
    //   1131	1142	373	java/lang/Throwable
    //   1147	1171	373	java/lang/Throwable
    //   1174	1211	373	java/lang/Throwable
    //   294	304	394	com/google/ads/internal/c$b
    //   334	340	431	java/lang/InterruptedException
    //   631	637	736	java/lang/InterruptedException
    //   1126	1131	1145	java/lang/InterruptedException
  }
  
  private static class a
    implements Runnable
  {
    private final d a;
    private final WebView b;
    private final f c;
    private final AdRequest.ErrorCode d;
    private final boolean e;
    
    public a(d paramd, WebView paramWebView, f paramf, AdRequest.ErrorCode paramErrorCode, boolean paramBoolean)
    {
      this.a = paramd;
      this.b = paramWebView;
      this.c = paramf;
      this.d = paramErrorCode;
      this.e = paramBoolean;
    }
    
    public void run()
    {
      if (this.b != null)
      {
        this.b.stopLoading();
        this.b.destroy();
      }
      if (this.c != null) {
        this.c.a();
      }
      if (this.e)
      {
        AdWebView localAdWebView = this.a.k();
        localAdWebView.stopLoading();
        localAdWebView.setVisibility(8);
      }
      this.a.a(this.d);
    }
  }
  
  private class b
    extends Exception
  {
    public b(String paramString)
    {
      super();
    }
  }
  
  private class c
    implements Runnable
  {
    private final String b;
    private final String c;
    private final WebView d;
    
    public c(WebView paramWebView, String paramString1, String paramString2)
    {
      this.d = paramWebView;
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public void run()
    {
      if (this.c != null)
      {
        this.d.loadDataWithBaseURL(this.b, this.c, "text/html", "utf-8", null);
        return;
      }
      this.d.loadUrl(this.b);
    }
  }
  
  public static enum d
  {
    public String e;
    
    private d(String paramString)
    {
      this.e = paramString;
    }
  }
  
  private static class e
    implements Runnable
  {
    private final d a;
    private final WebView b;
    private final LinkedList<String> c;
    private final int d;
    private final boolean e;
    private final String f;
    private final AdSize g;
    
    public e(d paramd, WebView paramWebView, LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean, String paramString, AdSize paramAdSize)
    {
      this.a = paramd;
      this.b = paramWebView;
      this.c = paramLinkedList;
      this.d = paramInt;
      this.e = paramBoolean;
      this.f = paramString;
      this.g = paramAdSize;
    }
    
    public void run()
    {
      if (this.b != null)
      {
        this.b.stopLoading();
        this.b.destroy();
      }
      this.a.a(this.c);
      this.a.a(this.d);
      this.a.a(this.e);
      this.a.a(this.f);
      if (this.g != null)
      {
        ((h)this.a.h().k.a()).b(this.g);
        this.a.k().setAdSize(this.g);
      }
      this.a.C();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */