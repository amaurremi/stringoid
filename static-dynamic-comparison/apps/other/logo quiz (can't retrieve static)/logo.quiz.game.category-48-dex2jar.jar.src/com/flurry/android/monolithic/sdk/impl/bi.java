package com.flurry.android.monolithic.sdk.impl;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class bi
  implements ci
{
  private static final String d = bi.class.getSimpleName();
  private static int e = 0;
  FlurryAdModule a;
  ce b;
  ck c;
  private boolean f = true;
  
  public bi(FlurryAdModule paramFlurryAdModule)
  {
    this.a = paramFlurryAdModule;
    this.c = new ck(paramFlurryAdModule);
    this.b = ce.a();
  }
  
  /* Error */
  public static HttpResponse a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 59	org/apache/http/client/methods/HttpGet
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 62	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   11: astore 6
    //   13: new 64	org/apache/http/params/BasicHttpParams
    //   16: dup
    //   17: invokespecial 65	org/apache/http/params/BasicHttpParams:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: iload_1
    //   25: invokestatic 71	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   28: aload 4
    //   30: iload_2
    //   31: invokestatic 74	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   34: aload 4
    //   36: ldc 76
    //   38: iload_3
    //   39: invokestatic 82	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   42: invokeinterface 88 3 0
    //   47: pop
    //   48: aload 4
    //   50: invokestatic 93	com/flurry/android/monolithic/sdk/impl/iz:b	(Lorg/apache/http/params/HttpParams;)Lorg/apache/http/client/HttpClient;
    //   53: astore 4
    //   55: aload 4
    //   57: astore 5
    //   59: aload 4
    //   61: aload 6
    //   63: invokeinterface 99 2 0
    //   68: astore 6
    //   70: aload 6
    //   72: astore 5
    //   74: aload 5
    //   76: astore_0
    //   77: aload 4
    //   79: ifnull +18 -> 97
    //   82: aload 4
    //   84: invokeinterface 103 1 0
    //   89: invokeinterface 108 1 0
    //   94: aload 5
    //   96: astore_0
    //   97: aload_0
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: astore 4
    //   103: aload 4
    //   105: astore 5
    //   107: getstatic 28	com/flurry/android/monolithic/sdk/impl/bi:d	Ljava/lang/String;
    //   110: new 110	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   117: ldc 113
    //   119: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_0
    //   123: invokevirtual 120	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 128	com/flurry/android/monolithic/sdk/impl/ja:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 7
    //   137: astore_0
    //   138: aload 4
    //   140: ifnull -43 -> 97
    //   143: aload 4
    //   145: invokeinterface 103 1 0
    //   150: invokeinterface 108 1 0
    //   155: aconst_null
    //   156: areturn
    //   157: astore 6
    //   159: aconst_null
    //   160: astore 4
    //   162: aload 4
    //   164: astore 5
    //   166: getstatic 28	com/flurry/android/monolithic/sdk/impl/bi:d	Ljava/lang/String;
    //   169: new 110	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   176: ldc -126
    //   178: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_0
    //   182: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: aload 6
    //   190: invokestatic 133	com/flurry/android/monolithic/sdk/impl/ja:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: aload 7
    //   195: astore_0
    //   196: aload 4
    //   198: ifnull -101 -> 97
    //   201: aload 4
    //   203: invokeinterface 103 1 0
    //   208: invokeinterface 108 1 0
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: aconst_null
    //   217: astore 5
    //   219: aload 5
    //   221: ifnull +15 -> 236
    //   224: aload 5
    //   226: invokeinterface 103 1 0
    //   231: invokeinterface 108 1 0
    //   236: aload_0
    //   237: athrow
    //   238: astore_0
    //   239: goto -20 -> 219
    //   242: astore 6
    //   244: goto -82 -> 162
    //   247: astore_0
    //   248: goto -145 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramString	String
    //   0	251	1	paramInt1	int
    //   0	251	2	paramInt2	int
    //   0	251	3	paramBoolean	boolean
    //   20	182	4	localObject1	Object
    //   57	168	5	localObject2	Object
    //   11	60	6	localObject3	Object
    //   157	32	6	localException1	Exception
    //   242	1	6	localException2	Exception
    //   1	193	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	55	99	java/net/UnknownHostException
    //   3	55	157	java/lang/Exception
    //   3	55	215	finally
    //   59	70	238	finally
    //   107	135	238	finally
    //   166	193	238	finally
    //   59	70	242	java/lang/Exception
    //   59	70	247	java/net/UnknownHostException
  }
  
  public int a(i parami)
  {
    parami = parami.c.d.b().toString();
    return this.a.b().a().b(parami);
  }
  
  Intent a(Intent paramIntent, String paramString)
  {
    if (je.b(paramIntent)) {}
    Intent localIntent;
    for (paramIntent = new Intent(paramIntent);; paramIntent = localIntent)
    {
      if (paramIntent != null) {
        paramIntent.putExtra("adSpaceName", paramString);
      }
      return paramIntent;
      localIntent = new Intent(ia.a().b(), FlurryFullscreenTakeoverActivity.class);
      localIntent.putExtra("targetIntent", paramIntent);
    }
  }
  
  public String a(m paramm, AdUnit paramAdUnit, i parami, String paramString)
  {
    Pattern localPattern = Pattern.compile(".*?(%\\{\\w+\\}).*?");
    Matcher localMatcher = localPattern.matcher(paramString);
    String str = paramString;
    for (paramString = localMatcher; paramString.matches(); paramString = localPattern.matcher(str)) {
      str = this.c.a(paramm, paramAdUnit, parami, str, paramString.group(1));
    }
    return str;
  }
  
  public void a()
  {
    this.f = e(null);
  }
  
  void a(Context paramContext, String paramString, AdUnit paramAdUnit)
  {
    Intent localIntent = ia.a().c().getLaunchIntentForPackage(paramString);
    if ((localIntent != null) && (je.a(localIntent)))
    {
      a(paramContext, localIntent, paramAdUnit.b().toString());
      return;
    }
    a(paramContext, "https://play.google.com/store/apps/details?id=" + paramString, false, paramAdUnit);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.startsWith("market://details?id="))
    {
      if (this.f)
      {
        if (!b(paramContext, paramString1, paramString2)) {
          ja.a(6, d, "Cannot launch Google Play url " + paramString1);
        }
        return;
      }
      paramString1 = paramString1.substring("market://details?id=".length());
      b(paramContext, "https://market.android.com/details?id=" + paramString1, paramString2);
      return;
    }
    ja.a(5, d, "Unexpected Google Play url scheme: " + paramString1);
  }
  
  void a(Context paramContext, String paramString, boolean paramBoolean, AdUnit paramAdUnit)
  {
    this.a.a(new bk(this, paramString, paramAdUnit, paramContext, paramBoolean));
  }
  
  void a(i parami, int paramInt)
  {
    e = a(parami);
    if (paramInt > e)
    {
      ja.a(5, d, "Maximum depth for event/action loop exceeded when performing next AdUnit:");
      return;
    }
    Context localContext = parami.c.c;
    Object localObject = parami.c.d;
    String str = ((AdUnit)localObject).b().toString();
    boolean bool1 = parami.b.containsKey("delay");
    boolean bool2 = a((AdUnit)localObject, parami.c.f);
    if (bool1) {}
    for (;;)
    {
      try
      {
        l = Long.parseLong((String)parami.b.get("delay"));
        localObject = this.a.b().a(str);
        if ((localObject == null) || (!bool1) || (!bool2)) {
          break;
        }
        ((an)localObject).a(l * 1000L);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ja.a(6, d, "caught NumberFormatException with delay parameter in nextAdUnit:" + (String)parami.b.get("delay"));
      }
      long l = 30L;
    }
    if (localNumberFormatException != null)
    {
      localNumberFormatException.post(new bj(this, localContext, str, localNumberFormatException));
      return;
    }
    if (parami.c.a.equals("renderFailed"))
    {
      this.a.b().b(localContext, str);
      return;
    }
    parami = this.a.b().g(str);
    this.a.a(localContext, parami);
  }
  
  public void a(i parami, cj paramcj, int paramInt)
  {
    String str1 = null;
    if (parami.c != null) {
      str1 = parami.c.a;
    }
    ja.a(3, d, "performAction:action=" + parami.a + ",params=" + parami.b + ",triggering event=" + str1);
    String str2 = parami.a;
    if (paramInt > 10)
    {
      ja.a(5, d, "Maximum depth for event/action loop exceeded when performing action:" + str2 + "," + parami.b + ",triggered by:" + str1);
      return;
    }
    if (str2.equals("directOpen"))
    {
      b(parami);
      return;
    }
    if (str2.equals("delete"))
    {
      c(parami);
      return;
    }
    if (str2.equals("processRedirect"))
    {
      d(parami);
      return;
    }
    if (str2.equals("verifyUrl"))
    {
      b(parami, paramcj, paramInt);
      return;
    }
    if (str2.equals("launchPackage"))
    {
      e(parami);
      return;
    }
    if (str2.equals("sendUrlAsync"))
    {
      f(parami);
      return;
    }
    if (str2.equals("sendAdLogs"))
    {
      g(parami);
      return;
    }
    if (str2.equals("logEvent"))
    {
      h(parami);
      return;
    }
    if (str2.equals("nextFrame"))
    {
      i(parami);
      return;
    }
    if (str2.equals("nextAdUnit"))
    {
      a(parami, paramInt);
      return;
    }
    if (str2.equals("checkCap"))
    {
      c(parami, paramcj, paramInt);
      return;
    }
    if (str2.equals("updateViewCount"))
    {
      j(parami);
      return;
    }
    ja.a(5, d, "Unknown action:" + str2 + ",triggered by:" + str1);
  }
  
  public boolean a(Context paramContext, Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (je.a(paramIntent)) {
            paramIntent = a(paramIntent, paramString);
          }
        }
      }
    }
    try
    {
      paramContext.startActivity(paramIntent);
      bool1 = true;
      return bool1;
    }
    catch (ActivityNotFoundException paramContext)
    {
      ja.a(6, d, "Cannot launch Activity", paramContext);
    }
    return false;
  }
  
  boolean a(AdUnit paramAdUnit, int paramInt)
  {
    if ((paramAdUnit != null) && (paramAdUnit.d().size() > 0)) {
      return ((AdFrame)paramAdUnit.d().get(paramInt)).e().e().toString().equals("banner");
    }
    return false;
  }
  
  boolean a(String paramString)
  {
    paramString = ia.a().c().getLaunchIntentForPackage(paramString);
    return (paramString != null) && (je.a(paramString));
  }
  
  boolean a(String paramString1, String paramString2)
  {
    paramString2 = new Intent(paramString2);
    paramString2.setData(Uri.parse(paramString1));
    return je.a(paramString2);
  }
  
  String b(String paramString)
  {
    int i = 0;
    if (i < 5)
    {
      if (Uri.parse(paramString).getScheme().equals("http")) {
        if ((c()) && (!b()))
        {
          localHttpResponse = a(paramString, 10000, 15000, false);
          str1 = paramString;
          if (localHttpResponse != null)
          {
            j = localHttpResponse.getStatusLine().getStatusCode();
            if (ja.c() <= 3) {
              Toast.makeText(ia.a().b(), "fFU HTTP Response Code: " + j, 0).show();
            }
            if (j == 200) {
              ja.a(3, d, "Redirect URL found for: " + paramString);
            }
          }
        }
      }
      while ((a(paramString, "android.intent.action.VIEW")) || ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("market://"))))
      {
        HttpResponse localHttpResponse;
        String str1;
        int j;
        return paramString;
        if ((j >= 300) && (j < 400))
        {
          ja.a(3, d, "NumRedirects: " + (i + 1));
          str1 = paramString;
          if (localHttpResponse.containsHeader("Location")) {
            str1 = localHttpResponse.getFirstHeader("Location").getValue();
          }
        }
        for (;;)
        {
          i += 1;
          paramString = str1;
          break;
          ja.a(3, d, "Bad Response status code: " + j);
          return null;
          try
          {
            Thread.sleep(100L);
            str1 = paramString;
          }
          catch (InterruptedException localInterruptedException)
          {
            ja.a(3, d, localInterruptedException.getMessage());
            String str2 = paramString;
          }
        }
      }
    }
    return null;
  }
  
  void b(Context paramContext, String paramString, boolean paramBoolean, AdUnit paramAdUnit)
  {
    this.a.a(new bl(this, paramString, paramContext, paramBoolean, paramAdUnit));
  }
  
  void b(i parami)
  {
    Context localContext = parami.c.c;
    m localm = parami.c.e;
    AdUnit localAdUnit = parami.c.d;
    String str1 = localAdUnit.b().toString();
    if (parami.b.containsKey("url"))
    {
      String str2 = (String)parami.b.get("url");
      if (str2.startsWith("market://"))
      {
        a(localContext, str2, str1);
        return;
      }
      if ("true".equals(parami.b.get("native")))
      {
        ja.a(2, d, "Explictly instructed to use native browser");
        b(localContext, a(localm, localAdUnit, parami, str2), str1);
        return;
      }
      parami = new Intent(ia.a().b(), FlurryFullscreenTakeoverActivity.class);
      parami.putExtra("url", str2);
      if (je.a(parami))
      {
        a(localContext, parami, str1);
        return;
      }
      ja.a(6, d, "Can't start FlurryFullscreenTakeoverActivity, was it declared in the manifest? Falling back to default browser");
      b(localContext, str2, str1);
      return;
    }
    ja.a(6, d, "failed to perform directOpen action: no url in " + parami.c.a);
  }
  
  void b(i parami, cj paramcj, int paramInt)
  {
    Context localContext = parami.c.c;
    m localm = parami.c.e;
    AdUnit localAdUnit = parami.c.d;
    if (parami.b.containsKey("url")) {
      if (!a((String)parami.b.get("url"))) {
        break label105;
      }
    }
    label105:
    for (String str = "urlVerified";; str = "urlNotVerified")
    {
      paramcj.a(new bh(str, Collections.emptyMap(), localContext, localAdUnit, localm, parami.c.f), this, paramInt + 1);
      return;
    }
  }
  
  boolean b()
  {
    return FlurryAdModule.e();
  }
  
  public boolean b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, new Intent("android.intent.action.VIEW").setData(Uri.parse(paramString1)), paramString2);
  }
  
  void c(i parami)
  {
    String str = parami.c.d.b().toString();
    if (parami.b.containsKey("count")) {
      parami = (String)parami.b.get("count");
    }
    while (!parami.b.containsKey("groupId")) {
      try
      {
        i = Integer.parseInt(parami);
        this.a.b().a(str, i);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          ja.a(6, d, "caught NumberFormatException with count parameter in deleteAds:" + parami);
          int i = -1;
        }
      }
    }
    parami = (String)parami.b.get("groupId");
    this.a.b().a(str, parami);
  }
  
  void c(i parami, cj paramcj, int paramInt)
  {
    Context localContext = parami.c.c;
    m localm = parami.c.e;
    AdUnit localAdUnit = parami.c.d;
    if (parami.b.containsKey("idHash"))
    {
      String str2 = (String)parami.b.get("idHash");
      Object localObject2 = this.b.a(str2);
      String str1 = "capNotExhausted";
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (this.b.a(((cd)localObject2).h()))
        {
          ja.a(4, d, "Discarding expired frequency cap info for idHash=" + str2);
          this.b.b(str2);
          localObject1 = null;
        }
      }
      localObject2 = str1;
      if (localObject1 != null)
      {
        localObject2 = str1;
        if (((cd)localObject1).c() >= ((cd)localObject1).e())
        {
          ja.a(4, d, "Frequency cap exhausted for idHash=" + str2);
          localObject2 = "capExhausted";
        }
      }
      paramcj.a(new bh((String)localObject2, Collections.emptyMap(), localContext, localAdUnit, localm, parami.c.f), this, paramInt + 1);
    }
  }
  
  void c(String paramString)
  {
    ja.a(3, d, "url after is: " + paramString);
    paramString = new bm(this, paramString);
    this.a.a(paramString);
  }
  
  boolean c()
  {
    return jc.a().c();
  }
  
  void d(i parami)
  {
    Context localContext = parami.c.c;
    m localm = parami.c.e;
    AdUnit localAdUnit = parami.c.d;
    String str1 = localAdUnit.b().toString();
    String str2;
    if (parami.b.containsKey("url"))
    {
      str2 = (String)parami.b.get("url");
      if ("true".equals(parami.b.get("native")))
      {
        ja.a(2, d, "Explictly instructed to use native browser in pr.");
        b(localContext, a(localm, localAdUnit, parami, str2), str1);
      }
    }
    else
    {
      return;
    }
    if (str2.startsWith("http"))
    {
      b(localContext, a(localm, localAdUnit, parami, str2), true, localAdUnit);
      return;
    }
    a(localContext, str2, false, localAdUnit);
  }
  
  boolean d(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < 5)
      {
        ja.a(6, d, " sendURLUntilSuccess URL: " + paramString);
        if ((c()) && (!b()))
        {
          HttpResponse localHttpResponse = a(paramString, 10000, 15000, true);
          int j = localHttpResponse.getStatusLine().getStatusCode();
          if (ja.c() <= 3) {
            Toast.makeText(ia.a().b(), "sUUS HTTP Response Code: " + j, 0).show();
          }
          if ((localHttpResponse == null) || (j != 200)) {
            break label162;
          }
          ja.a(3, d, "URL hit succeeded for: " + paramString);
          return true;
        }
        try
        {
          Thread.sleep(100L);
          label162:
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ja.a(3, d, localInterruptedException.getMessage());
          }
        }
      }
    }
    return false;
  }
  
  void e(i parami)
  {
    Context localContext = parami.c.c;
    AdUnit localAdUnit = parami.c.d;
    if (parami.b.containsKey("package")) {
      a(localContext, (String)parami.b.get("package"), localAdUnit);
    }
  }
  
  boolean e(String paramString)
  {
    String str2 = ia.a().b().getPackageName();
    String str1 = paramString;
    if (paramString == null) {
      str1 = "market://details?id=" + str2;
    }
    return a(str1, "android.intent.action.VIEW");
  }
  
  void f(i parami)
  {
    m localm = parami.c.e;
    AdUnit localAdUnit = parami.c.d;
    if (parami.b.containsKey("url")) {
      c(a(localm, localAdUnit, parami, (String)parami.b.get("url")));
    }
  }
  
  void g(i parami)
  {
    this.a.w();
  }
  
  void h(i parami)
  {
    if ((parami.b.containsKey("__sendToServer")) && (((String)parami.b.get("__sendToServer")).equals("true"))) {}
    for (boolean bool = true;; bool = false)
    {
      parami.b.remove("__sendToServer");
      this.a.a(parami.c.e, parami.c.a, bool, parami.b);
      return;
    }
  }
  
  void i(i parami) {}
  
  void j(i parami)
  {
    if (parami.b.containsKey("idHash"))
    {
      parami = (String)parami.b.get("idHash");
      parami = this.b.a(parami);
      if (parami != null)
      {
        parami.d();
        ja.a(4, d, "updateViewCount:idHash=" + parami.b() + ",newCap=" + parami.e() + ",prevCap=" + parami.f() + ",views=" + parami.c());
        if (parami.c() > parami.e()) {
          ja.a(6, d, "FlurryAdAction: !! rendering a capped object: " + parami.b());
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */