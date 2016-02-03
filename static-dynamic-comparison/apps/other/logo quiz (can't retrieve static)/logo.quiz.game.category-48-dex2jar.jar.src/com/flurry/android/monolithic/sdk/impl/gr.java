package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.NameValuePair;

public class gr
{
  public static String a = "";
  private static String b = "";
  private static String c = "del_internal";
  private static ExecutorService d = Executors.newCachedThreadPool();
  
  public static void a(String paramString)
  {
    b = hh.a(paramString, paramString);
  }
  
  public static void a(boolean paramBoolean, String paramString, List<NameValuePair> paramList, fr paramfr)
    throws Exception
  {
    HashMap localHashMap = new HashMap();
    b(localHashMap);
    gs localgs = new gs();
    localHashMap.put(c, localgs);
    localHashMap.put("del", paramfr);
    localHashMap.put("url", paramString);
    localHashMap.put("data", paramList);
    d.submit(new hf(localHashMap));
  }
  
  private static void b(fq paramfq, fr paramfr, gx paramgx, HashMap<String, Object> paramHashMap)
  {
    for (;;)
    {
      try
      {
        if (paramfq.a())
        {
          paramfr.a(paramfq);
          return;
        }
        if ((paramfq.d() != 400) || (!paramfq.b().equals("invalid user session"))) {
          break label158;
        }
        ja.a(5, "FlurryAppCloudRequestManager", "CURRENT USER SESSION = " + a + " IS NOT VALID!");
        a = "";
        fy.b();
        if (fy.c() == null)
        {
          fy.i();
          paramfr.a(paramfq);
          continue;
        }
      }
      catch (Exception paramfq)
      {
        ja.a(6, "FlurryAppCloudRequestManager", "checkForTokenError Exception: ", paramfq);
        continue;
      }
      finally {}
      ft.a(fy.c());
      ja.a(3, "FlurryAppCloudRequestManager", "TRYING TO RELOGIN WITH LAST USER!");
      ft.a(fy.f(), fy.g(), new gv(paramHashMap, paramgx, paramfr));
      continue;
      label158:
      paramfr.a(paramfq);
    }
  }
  
  private static void b(HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("session", a);
    paramHashMap.put("auth", b);
  }
  
  public static void b(boolean paramBoolean, String paramString, List<NameValuePair> paramList, fr paramfr)
    throws Exception
  {
    HashMap localHashMap = new HashMap();
    b(localHashMap);
    gt localgt = new gt();
    localHashMap.put(c, localgt);
    localHashMap.put("del", paramfr);
    localHashMap.put("url", paramString);
    if (paramList == null) {
      localHashMap.put("data", new ArrayList());
    }
    for (;;)
    {
      d.submit(new hg(localHashMap));
      return;
      localHashMap.put("data", paramList);
    }
  }
  
  public static void c(boolean paramBoolean, String paramString, List<NameValuePair> paramList, fr paramfr)
    throws Exception
  {
    HashMap localHashMap = new HashMap();
    b(localHashMap);
    gu localgu = new gu();
    localHashMap.put(c, localgu);
    localHashMap.put("del", paramfr);
    if (paramList != null) {
      localHashMap.put("url", paramString + "/" + hh.a(paramList));
    }
    for (;;)
    {
      d.submit(new gy(localHashMap));
      return;
      localHashMap.put("url", paramString + "/");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */