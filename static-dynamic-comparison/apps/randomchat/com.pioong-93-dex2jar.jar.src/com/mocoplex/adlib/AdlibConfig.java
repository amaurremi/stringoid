package com.mocoplex.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdlibConfig
{
  private static AdlibConfig f = null;
  private static String h = null;
  private static String j = "http://ad.adlibr.com/my2/parta.jsp";
  private static String m = "http://ad.adlibr.com/rsch.jsp";
  private static String o = "http://ad.adlibr.com/dlg/dcampaign.jsp";
  private static String p = "http://ad.adlibr.com/dlg/dlg.jsp";
  private static String q = "http://ad.adlibr.com/smartad/smart_cache2.jsp";
  private static String r = "http://ad.adlibr.com/smartad/rlink/icon.jsp";
  protected String a;
  protected boolean b = false;
  public int c = 0;
  LocationManager d;
  Location e = null;
  private Activity g = null;
  private boolean i = true;
  private String k = "";
  private String l = "";
  private boolean n = true;
  
  private AdlibConfig()
  {
    h = "3.4";
  }
  
  private static String a(int paramInt)
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyyMMdd");
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(new Date());
      localCalendar.add(5, paramInt);
      localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = paramContext.getCacheDir();
        if (paramContext != null)
        {
          paramContext = paramContext.getAbsolutePath() + "/Adlib-data/";
          File localFile = new File(paramContext);
          if (!localFile.exists())
          {
            boolean bool = localFile.mkdirs();
            if (!bool) {}
          }
          else
          {
            return paramContext;
          }
        }
      }
      catch (Exception paramContext) {}
    }
    return null;
  }
  
  protected static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramString = new File(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(a(paramContext))).append("icon/").toString())).append(paramString).toString())).append("/").toString() + "ok");
    if (paramString.exists()) {
      paramString.delete();
    }
    try
    {
      paramString.createNewFile();
      paramContext = Integer.toString(paramInt1) + "," + Integer.toString(paramInt2);
      paramString = new FileOutputStream(paramString);
      paramString.write(paramContext.getBytes());
      paramString.close();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void a(File paramFile)
  {
    File[] arrayOfFile;
    int i2;
    int i1;
    if (paramFile.isDirectory())
    {
      arrayOfFile = paramFile.listFiles();
      i2 = arrayOfFile.length;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2)
      {
        paramFile.delete();
        return;
      }
      a(arrayOfFile[i1]);
      i1 += 1;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    final String str1;
    if (paramInt == 0) {
      str1 = n();
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        if (!b()) {}
      }
      else {
        while ((paramInt == 1) && (c()))
        {
          return;
          if (paramInt != 1) {
            break label150;
          }
          str1 = m();
          break;
        }
      }
      String str2 = j;
      Object localObject1 = new ArrayList();
      if (paramBoolean) {
        ((List)localObject1).add(new BasicNameValuePair("legacy", "1"));
      }
      ((List)localObject1).add(new BasicNameValuePair("banner", str1));
      try
      {
        localObject1 = new UrlEncodedFormEntity((List)localObject1, "UTF-8");
        new d(new Handler()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            }
            paramAnonymousMessage = (String)paramAnonymousMessage.obj;
            AdlibConfig.this.a(paramAnonymousMessage, str1);
          }
        }).a(str2, (UrlEncodedFormEntity)localObject1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
      label150:
      str1 = "";
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    while (!new File(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(a(paramContext))).append("icon/").toString())).append(paramString).toString())).append("/").toString() + "ok").exists()) {
      return false;
    }
    return true;
  }
  
  private void c(String paramString1, String paramString2)
  {
    if (this.g != null)
    {
      SharedPreferences.Editor localEditor = this.g.getSharedPreferences("adlibr", 0).edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  /* Error */
  private void d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 178	java/lang/StringBuilder
    //   3: dup
    //   4: new 178	java/lang/StringBuilder
    //   7: dup
    //   8: new 178	java/lang/StringBuilder
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 323	com/mocoplex/adlib/AdlibConfig:o	()Ljava/lang/String;
    //   16: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   19: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: ldc_w 325
    //   25: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: ldc -41
    //   52: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 7
    //   60: new 180	java/io/File
    //   63: dup
    //   64: aload 7
    //   66: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: invokevirtual 208	java/io/File:mkdirs	()Z
    //   72: pop
    //   73: new 327	org/json/JSONArray
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 328	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   81: astore 6
    //   83: iconst_0
    //   84: istore 4
    //   86: iconst_0
    //   87: istore_3
    //   88: iload 4
    //   90: aload 6
    //   92: invokevirtual 332	org/json/JSONArray:length	()I
    //   95: if_icmplt +405 -> 500
    //   98: iload_3
    //   99: aload 6
    //   101: invokevirtual 332	org/json/JSONArray:length	()I
    //   104: if_icmpne +395 -> 499
    //   107: new 180	java/io/File
    //   110: dup
    //   111: new 178	java/lang/StringBuilder
    //   114: dup
    //   115: aload 7
    //   117: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   120: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: ldc -39
    //   125: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: astore 6
    //   136: aload 6
    //   138: invokevirtual 223	java/io/File:createNewFile	()Z
    //   141: pop
    //   142: new 178	java/lang/StringBuilder
    //   145: dup
    //   146: aload 7
    //   148: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   151: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: ldc_w 334
    //   157: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore_1
    //   164: aload_1
    //   165: invokestatic 337	com/mocoplex/adlib/AdlibConfig:j	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore_1
    //   169: new 180	java/io/File
    //   172: dup
    //   173: aload 7
    //   175: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: new 32	com/mocoplex/adlib/AdlibConfig$a
    //   181: dup
    //   182: aload_0
    //   183: ldc_w 338
    //   186: invokespecial 339	com/mocoplex/adlib/AdlibConfig$a:<init>	(Lcom/mocoplex/adlib/AdlibConfig;Ljava/lang/String;)V
    //   189: invokevirtual 342	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   192: astore 5
    //   194: iconst_0
    //   195: istore_3
    //   196: iload_3
    //   197: aload 5
    //   199: arraylength
    //   200: if_icmplt +466 -> 666
    //   203: aload_0
    //   204: ldc_w 344
    //   207: invokevirtual 346	com/mocoplex/adlib/AdlibConfig:c	(Ljava/lang/String;)Ljava/lang/String;
    //   210: astore 7
    //   212: aload_1
    //   213: astore 5
    //   215: aload 7
    //   217: ldc 107
    //   219: invokevirtual 349	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   222: ifne +14 -> 236
    //   225: aload_1
    //   226: ldc_w 351
    //   229: aload 7
    //   231: invokevirtual 355	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   234: astore 5
    //   236: aload_0
    //   237: getfield 99	com/mocoplex/adlib/AdlibConfig:g	Landroid/app/Activity;
    //   240: invokestatic 360	com/mocoplex/adlib/f:a	(Landroid/content/Context;)Lcom/mocoplex/adlib/f;
    //   243: invokevirtual 362	com/mocoplex/adlib/f:a	()Ljava/lang/String;
    //   246: astore_1
    //   247: aload_0
    //   248: getfield 99	com/mocoplex/adlib/AdlibConfig:g	Landroid/app/Activity;
    //   251: invokevirtual 366	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   254: invokevirtual 372	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   257: getfield 378	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   260: invokevirtual 383	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   263: astore 8
    //   265: aload 5
    //   267: ldc_w 385
    //   270: new 178	java/lang/StringBuilder
    //   273: dup
    //   274: new 178	java/lang/StringBuilder
    //   277: dup
    //   278: new 178	java/lang/StringBuilder
    //   281: dup
    //   282: new 178	java/lang/StringBuilder
    //   285: dup
    //   286: new 178	java/lang/StringBuilder
    //   289: dup
    //   290: new 178	java/lang/StringBuilder
    //   293: dup
    //   294: new 178	java/lang/StringBuilder
    //   297: dup
    //   298: new 178	java/lang/StringBuilder
    //   301: dup
    //   302: new 178	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 107
    //   308: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   311: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: ldc_w 387
    //   317: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 7
    //   322: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   331: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: ldc_w 389
    //   337: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   346: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: ldc_w 391
    //   352: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_1
    //   356: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: ldc_w 389
    //   371: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   380: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   383: ldc_w 393
    //   386: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 8
    //   391: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   400: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: ldc_w 389
    //   406: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   415: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   418: ldc_w 395
    //   421: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_2
    //   425: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   434: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   437: ldc_w 389
    //   440: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   449: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: ldc_w 397
    //   455: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: getstatic 69	com/mocoplex/adlib/AdlibConfig:h	Ljava/lang/String;
    //   461: ldc_w 399
    //   464: invokestatic 405	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 355	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   476: astore_1
    //   477: new 231	java/io/FileOutputStream
    //   480: dup
    //   481: aload 6
    //   483: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   486: astore_2
    //   487: aload_2
    //   488: aload_1
    //   489: invokevirtual 238	java/lang/String:getBytes	()[B
    //   492: invokevirtual 242	java/io/FileOutputStream:write	([B)V
    //   495: aload_2
    //   496: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   499: return
    //   500: aload 6
    //   502: iload 4
    //   504: invokevirtual 409	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   507: checkcast 411	org/json/JSONObject
    //   510: astore_1
    //   511: aload_1
    //   512: ldc_w 413
    //   515: invokevirtual 416	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   518: checkcast 186	java/lang/String
    //   521: astore 8
    //   523: aload_1
    //   524: ldc_w 418
    //   527: invokevirtual 416	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   530: checkcast 186	java/lang/String
    //   533: astore 5
    //   535: aload 5
    //   537: astore_1
    //   538: aload 5
    //   540: ldc_w 420
    //   543: invokevirtual 424	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   546: ifge +25 -> 571
    //   549: new 178	java/lang/StringBuilder
    //   552: dup
    //   553: aload 5
    //   555: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   558: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   561: ldc_w 420
    //   564: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: astore_1
    //   571: new 178	java/lang/StringBuilder
    //   574: dup
    //   575: aload_1
    //   576: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   579: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: ldc_w 426
    //   585: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: getstatic 69	com/mocoplex/adlib/AdlibConfig:h	Ljava/lang/String;
    //   591: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: astore_1
    //   598: aload_0
    //   599: aload_1
    //   600: new 180	java/io/File
    //   603: dup
    //   604: new 178	java/lang/StringBuilder
    //   607: dup
    //   608: aload 7
    //   610: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   613: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   616: aload 8
    //   618: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   627: invokevirtual 429	com/mocoplex/adlib/AdlibConfig:a	(Ljava/lang/String;Ljava/io/File;)Ljava/lang/Boolean;
    //   630: invokevirtual 434	java/lang/Boolean:booleanValue	()Z
    //   633: ifne +26 -> 659
    //   636: new 137	java/lang/Exception
    //   639: dup
    //   640: invokespecial 435	java/lang/Exception:<init>	()V
    //   643: athrow
    //   644: astore_1
    //   645: aload_0
    //   646: iconst_0
    //   647: putfield 113	com/mocoplex/adlib/AdlibConfig:n	Z
    //   650: iload 4
    //   652: iconst_1
    //   653: iadd
    //   654: istore 4
    //   656: goto -568 -> 88
    //   659: iload_3
    //   660: iconst_1
    //   661: iadd
    //   662: istore_3
    //   663: goto -13 -> 650
    //   666: aload 5
    //   668: iload_3
    //   669: aaload
    //   670: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   673: astore 7
    //   675: aload 5
    //   677: iload_3
    //   678: aaload
    //   679: invokevirtual 438	java/io/File:getName	()Ljava/lang/String;
    //   682: astore 8
    //   684: aload_1
    //   685: new 178	java/lang/StringBuilder
    //   688: dup
    //   689: ldc_w 440
    //   692: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   695: aload 8
    //   697: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: ldc_w 440
    //   703: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: new 178	java/lang/StringBuilder
    //   712: dup
    //   713: ldc_w 442
    //   716: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   719: aload 7
    //   721: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokevirtual 355	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   730: astore_1
    //   731: iload_3
    //   732: iconst_1
    //   733: iadd
    //   734: istore_3
    //   735: goto -539 -> 196
    //   738: astore_1
    //   739: aload_0
    //   740: iconst_0
    //   741: putfield 113	com/mocoplex/adlib/AdlibConfig:n	Z
    //   744: return
    //   745: astore_1
    //   746: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	this	AdlibConfig
    //   0	747	1	paramString1	String
    //   0	747	2	paramString2	String
    //   87	648	3	i1	int
    //   84	571	4	i2	int
    //   192	484	5	localObject1	Object
    //   81	420	6	localObject2	Object
    //   58	662	7	str1	String
    //   263	433	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   598	644	644	java/lang/Exception
    //   73	83	738	java/lang/Exception
    //   88	164	738	java/lang/Exception
    //   500	535	738	java/lang/Exception
    //   538	571	738	java/lang/Exception
    //   571	598	738	java/lang/Exception
    //   645	650	738	java/lang/Exception
    //   164	194	745	java/lang/Exception
    //   196	212	745	java/lang/Exception
    //   215	236	745	java/lang/Exception
    //   236	499	745	java/lang/Exception
    //   666	731	745	java/lang/Exception
  }
  
  /* Error */
  private void e(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 178	java/lang/StringBuilder
    //   3: dup
    //   4: new 178	java/lang/StringBuilder
    //   7: dup
    //   8: new 178	java/lang/StringBuilder
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 323	com/mocoplex/adlib/AdlibConfig:o	()Ljava/lang/String;
    //   16: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   19: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: ldc_w 445
    //   25: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: ldc -41
    //   52: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 6
    //   60: new 180	java/io/File
    //   63: dup
    //   64: aload 6
    //   66: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: invokevirtual 208	java/io/File:mkdirs	()Z
    //   72: pop
    //   73: ldc 107
    //   75: astore_2
    //   76: new 327	org/json/JSONArray
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 328	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   84: astore 7
    //   86: iconst_0
    //   87: istore 4
    //   89: iconst_0
    //   90: istore_3
    //   91: aload_2
    //   92: astore_1
    //   93: iload 4
    //   95: aload 7
    //   97: invokevirtual 332	org/json/JSONArray:length	()I
    //   100: if_icmplt +446 -> 546
    //   103: iload_3
    //   104: aload 7
    //   106: invokevirtual 332	org/json/JSONArray:length	()I
    //   109: if_icmpne +436 -> 545
    //   112: new 180	java/io/File
    //   115: dup
    //   116: new 178	java/lang/StringBuilder
    //   119: dup
    //   120: aload 6
    //   122: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: ldc -39
    //   130: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   139: astore 7
    //   141: aload 7
    //   143: invokevirtual 223	java/io/File:createNewFile	()Z
    //   146: pop
    //   147: new 178	java/lang/StringBuilder
    //   150: dup
    //   151: aload 6
    //   153: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: ldc_w 334
    //   162: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore_2
    //   169: aload_2
    //   170: invokestatic 337	com/mocoplex/adlib/AdlibConfig:j	(Ljava/lang/String;)Ljava/lang/String;
    //   173: astore_2
    //   174: new 180	java/io/File
    //   177: dup
    //   178: aload 6
    //   180: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: new 32	com/mocoplex/adlib/AdlibConfig$a
    //   186: dup
    //   187: aload_0
    //   188: ldc_w 338
    //   191: invokespecial 339	com/mocoplex/adlib/AdlibConfig$a:<init>	(Lcom/mocoplex/adlib/AdlibConfig;Ljava/lang/String;)V
    //   194: invokevirtual 342	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   197: astore 5
    //   199: iconst_0
    //   200: istore_3
    //   201: iload_3
    //   202: aload 5
    //   204: arraylength
    //   205: if_icmplt +528 -> 733
    //   208: aload_0
    //   209: ldc_w 344
    //   212: invokevirtual 346	com/mocoplex/adlib/AdlibConfig:c	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 8
    //   217: aload_2
    //   218: astore 5
    //   220: aload 8
    //   222: ldc 107
    //   224: invokevirtual 349	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifne +14 -> 241
    //   230: aload_2
    //   231: ldc_w 351
    //   234: aload 8
    //   236: invokevirtual 355	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   239: astore 5
    //   241: aload_0
    //   242: getfield 99	com/mocoplex/adlib/AdlibConfig:g	Landroid/app/Activity;
    //   245: invokestatic 360	com/mocoplex/adlib/f:a	(Landroid/content/Context;)Lcom/mocoplex/adlib/f;
    //   248: invokevirtual 362	com/mocoplex/adlib/f:a	()Ljava/lang/String;
    //   251: astore_2
    //   252: aload_0
    //   253: getfield 99	com/mocoplex/adlib/AdlibConfig:g	Landroid/app/Activity;
    //   256: invokevirtual 366	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   259: invokevirtual 372	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   262: getfield 378	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   265: invokevirtual 383	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   268: astore 9
    //   270: aload 5
    //   272: ldc_w 385
    //   275: new 178	java/lang/StringBuilder
    //   278: dup
    //   279: new 178	java/lang/StringBuilder
    //   282: dup
    //   283: new 178	java/lang/StringBuilder
    //   286: dup
    //   287: new 178	java/lang/StringBuilder
    //   290: dup
    //   291: new 178	java/lang/StringBuilder
    //   294: dup
    //   295: new 178	java/lang/StringBuilder
    //   298: dup
    //   299: new 178	java/lang/StringBuilder
    //   302: dup
    //   303: ldc 107
    //   305: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: ldc_w 387
    //   314: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload 8
    //   319: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   328: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: ldc_w 389
    //   334: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   343: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   346: ldc_w 391
    //   349: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_2
    //   353: ldc_w 399
    //   356: invokestatic 405	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   359: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   368: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   371: ldc_w 389
    //   374: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   383: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: ldc_w 393
    //   389: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 9
    //   394: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   403: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   406: ldc_w 389
    //   409: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   418: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: ldc_w 397
    //   424: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: getstatic 69	com/mocoplex/adlib/AdlibConfig:h	Ljava/lang/String;
    //   430: ldc_w 399
    //   433: invokestatic 405	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   436: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokevirtual 355	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   445: astore 5
    //   447: new 180	java/io/File
    //   450: dup
    //   451: new 178	java/lang/StringBuilder
    //   454: dup
    //   455: aload 6
    //   457: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   460: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   463: ldc_w 447
    //   466: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   475: astore 6
    //   477: aload 6
    //   479: invokevirtual 223	java/io/File:createNewFile	()Z
    //   482: pop
    //   483: aload_1
    //   484: astore_2
    //   485: aload_1
    //   486: ldc 107
    //   488: invokevirtual 349	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   491: ifeq +9 -> 500
    //   494: bipush 7
    //   496: invokestatic 449	com/mocoplex/adlib/AdlibConfig:a	(I)Ljava/lang/String;
    //   499: astore_2
    //   500: new 231	java/io/FileOutputStream
    //   503: dup
    //   504: aload 6
    //   506: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   509: astore_1
    //   510: aload_1
    //   511: aload_2
    //   512: invokevirtual 238	java/lang/String:getBytes	()[B
    //   515: invokevirtual 242	java/io/FileOutputStream:write	([B)V
    //   518: aload_1
    //   519: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   522: new 231	java/io/FileOutputStream
    //   525: dup
    //   526: aload 7
    //   528: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   531: astore_1
    //   532: aload_1
    //   533: aload 5
    //   535: invokevirtual 238	java/lang/String:getBytes	()[B
    //   538: invokevirtual 242	java/io/FileOutputStream:write	([B)V
    //   541: aload_1
    //   542: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   545: return
    //   546: aload 7
    //   548: iload 4
    //   550: invokevirtual 409	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   553: checkcast 411	org/json/JSONObject
    //   556: astore_2
    //   557: aload_2
    //   558: ldc_w 413
    //   561: invokevirtual 416	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   564: checkcast 186	java/lang/String
    //   567: astore 8
    //   569: aload 8
    //   571: ldc_w 451
    //   574: invokevirtual 349	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   577: ifeq +24 -> 601
    //   580: aload_2
    //   581: ldc_w 453
    //   584: invokevirtual 456	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   587: invokestatic 459	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   590: invokestatic 449	com/mocoplex/adlib/AdlibConfig:a	(I)Ljava/lang/String;
    //   593: astore_1
    //   594: iload_3
    //   595: iconst_1
    //   596: iadd
    //   597: istore_3
    //   598: goto +211 -> 809
    //   601: aload_2
    //   602: ldc_w 418
    //   605: invokevirtual 416	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   608: checkcast 186	java/lang/String
    //   611: astore 5
    //   613: aload 5
    //   615: astore_2
    //   616: aload 5
    //   618: ldc_w 420
    //   621: invokevirtual 424	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   624: ifge +25 -> 649
    //   627: new 178	java/lang/StringBuilder
    //   630: dup
    //   631: aload 5
    //   633: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   636: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   639: ldc_w 420
    //   642: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: astore_2
    //   649: new 178	java/lang/StringBuilder
    //   652: dup
    //   653: aload_2
    //   654: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   657: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   660: ldc_w 426
    //   663: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: getstatic 69	com/mocoplex/adlib/AdlibConfig:h	Ljava/lang/String;
    //   669: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: astore_2
    //   676: aload_0
    //   677: aload_2
    //   678: new 180	java/io/File
    //   681: dup
    //   682: new 178	java/lang/StringBuilder
    //   685: dup
    //   686: aload 6
    //   688: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   691: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   694: aload 8
    //   696: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   705: invokevirtual 429	com/mocoplex/adlib/AdlibConfig:a	(Ljava/lang/String;Ljava/io/File;)Ljava/lang/Boolean;
    //   708: invokevirtual 434	java/lang/Boolean:booleanValue	()Z
    //   711: ifne +15 -> 726
    //   714: new 137	java/lang/Exception
    //   717: dup
    //   718: invokespecial 435	java/lang/Exception:<init>	()V
    //   721: athrow
    //   722: astore_2
    //   723: goto +86 -> 809
    //   726: iload_3
    //   727: iconst_1
    //   728: iadd
    //   729: istore_3
    //   730: goto +79 -> 809
    //   733: aload 5
    //   735: iload_3
    //   736: aaload
    //   737: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   740: astore 8
    //   742: aload 5
    //   744: iload_3
    //   745: aaload
    //   746: invokevirtual 438	java/io/File:getName	()Ljava/lang/String;
    //   749: astore 9
    //   751: aload_2
    //   752: new 178	java/lang/StringBuilder
    //   755: dup
    //   756: ldc_w 440
    //   759: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   762: aload 9
    //   764: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: ldc_w 440
    //   770: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: new 178	java/lang/StringBuilder
    //   779: dup
    //   780: ldc_w 442
    //   783: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   786: aload 8
    //   788: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokevirtual 355	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   797: astore_2
    //   798: iload_3
    //   799: iconst_1
    //   800: iadd
    //   801: istore_3
    //   802: goto -601 -> 201
    //   805: astore_1
    //   806: return
    //   807: astore_1
    //   808: return
    //   809: iload 4
    //   811: iconst_1
    //   812: iadd
    //   813: istore 4
    //   815: goto -722 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	this	AdlibConfig
    //   0	818	1	paramString1	String
    //   0	818	2	paramString2	String
    //   90	712	3	i1	int
    //   87	727	4	i2	int
    //   197	546	5	localObject1	Object
    //   58	629	6	localObject2	Object
    //   84	463	7	localObject3	Object
    //   215	572	8	str1	String
    //   268	495	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   676	722	722	java/lang/Exception
    //   76	86	805	java/lang/Exception
    //   93	169	805	java/lang/Exception
    //   546	594	805	java/lang/Exception
    //   601	613	805	java/lang/Exception
    //   616	649	805	java/lang/Exception
    //   649	676	805	java/lang/Exception
    //   169	199	807	java/lang/Exception
    //   201	217	807	java/lang/Exception
    //   220	241	807	java/lang/Exception
    //   241	483	807	java/lang/Exception
    //   485	500	807	java/lang/Exception
    //   500	545	807	java/lang/Exception
    //   733	798	807	java/lang/Exception
  }
  
  public static AdlibConfig getInstance()
  {
    try
    {
      if (f == null) {
        f = new AdlibConfig();
      }
      AdlibConfig localAdlibConfig = f;
      return localAdlibConfig;
    }
    finally {}
  }
  
  public static String h()
  {
    return h;
  }
  
  private static String j(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = new byte[(int)new File(paramString).length()];
    new FileInputStream(paramString).read(arrayOfByte);
    return new String(arrayOfByte);
  }
  
  private boolean k(String paramString)
  {
    return new File(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(o())).append("dlg/").toString())).append(paramString).toString())).append("/").toString() + "ok").exists();
  }
  
  private String m()
  {
    if (this.l.equals(""))
    {
      Object localObject = c("sch");
      try
      {
        localObject = new JSONObject((String)localObject);
        String str = (String)((JSONObject)localObject).get("banner2");
        if (str != null)
        {
          this.l = str;
          return this.l;
        }
        localObject = (String)((JSONObject)localObject).get("banner");
        if (localObject != null)
        {
          this.l = ((String)localObject);
          localObject = this.l;
          return (String)localObject;
        }
      }
      catch (JSONException localJSONException) {}
    }
    return this.l;
  }
  
  private String n()
  {
    if (this.k.equals(""))
    {
      Object localObject = c("sch");
      try
      {
        localObject = new JSONObject((String)localObject);
        String str = (String)((JSONObject)localObject).get("default2");
        if (str != null)
        {
          this.k = str;
          return this.k;
        }
        localObject = (String)((JSONObject)localObject).get("default");
        if (localObject != null)
        {
          this.k = ((String)localObject);
          localObject = this.k;
          return (String)localObject;
        }
      }
      catch (JSONException localJSONException) {}
    }
    return this.k;
  }
  
  private String o()
  {
    File localFile1 = null;
    Object localObject;
    if (this.a != null) {
      localObject = this.a;
    }
    for (;;)
    {
      return (String)localObject;
      localObject = localFile1;
      if (this.g != null) {
        try
        {
          File localFile2 = this.g.getCacheDir();
          localObject = localFile1;
          if (localFile2 != null)
          {
            localObject = localFile2.getAbsolutePath() + "/Adlib-data/";
            localFile1 = new File((String)localObject);
            if ((!localFile1.exists()) && (!localFile1.mkdirs()))
            {
              this.a = null;
              return null;
            }
            this.a = ((String)localObject);
            localObject = this.a;
            return (String)localObject;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
  
  private void p()
  {
    String str1 = m;
    Object localObject = c("api");
    if (((String)localObject).equals("")) {}
    while (this.g == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String str2 = this.g.getResources().getConfiguration().locale.getLanguage();
    localArrayList.add(new BasicNameValuePair("key", (String)localObject));
    localArrayList.add(new BasicNameValuePair("cc", str2));
    localArrayList.add(new BasicNameValuePair("udid", f.a(this.g).a()));
    localArrayList.add(new BasicNameValuePair("ver", h));
    try
    {
      localObject = new UrlEncodedFormEntity(localArrayList, "UTF-8");
      new d(new Handler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          }
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          AdlibConfig.this.b(paramAnonymousMessage);
        }
      }).a(str1, (UrlEncodedFormEntity)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected final Boolean a(String paramString, File paramFile)
  {
    Object localObject = new BasicHttpParams();
    HttpProtocolParams.setVersion((HttpParams)localObject, HttpVersion.HTTP_1_1);
    ((HttpParams)localObject).setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    localObject = new DefaultHttpClient((HttpParams)localObject);
    ((DefaultHttpClient)localObject).addRequestInterceptor(new HttpRequestInterceptor()
    {
      public final void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
      {
        if (!paramAnonymousHttpRequest.containsHeader("Accept-Encoding")) {
          paramAnonymousHttpRequest.addHeader("Accept-Encoding", "gzip");
        }
      }
    });
    ((DefaultHttpClient)localObject).addResponseInterceptor(new HttpResponseInterceptor()
    {
      public final void process(HttpResponse paramAnonymousHttpResponse, HttpContext paramAnonymousHttpContext)
      {
        paramAnonymousHttpContext = paramAnonymousHttpResponse.getEntity().getContentEncoding();
        int j;
        int i;
        if (paramAnonymousHttpContext != null)
        {
          paramAnonymousHttpContext = paramAnonymousHttpContext.getElements();
          j = paramAnonymousHttpContext.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= j) {
            return;
          }
          if (paramAnonymousHttpContext[i].getName().equalsIgnoreCase("gzip"))
          {
            paramAnonymousHttpResponse.setEntity(new AdlibConfig.b(paramAnonymousHttpResponse.getEntity()));
            return;
          }
          i += 1;
        }
      }
    });
    HttpConnectionParams.setSoTimeout(((DefaultHttpClient)localObject).getParams(), 10000);
    try
    {
      paramString = ((DefaultHttpClient)localObject).execute(new HttpGet(paramString));
      if (paramString.getStatusLine().getStatusCode() != 200) {
        return Boolean.valueOf(false);
      }
      paramFile = new FileOutputStream(paramFile);
      paramFile.write(EntityUtils.toByteArray(paramString.getEntity()));
      paramFile.close();
      return Boolean.valueOf(true);
    }
    catch (Exception paramString) {}
    return Boolean.valueOf(false);
  }
  
  public final String a(String paramString)
  {
    if (paramString.equals("7")) {
      return "com.mocoplex.adlib.SubAdlibAdViewRewardBanner";
    }
    if (paramString.equals("77")) {
      return "com.mocoplex.adlib.SubAdlibAdViewCrossBanner";
    }
    if (paramString.equals("-1")) {
      return "com.mocoplex.adlib.SubAdlibAdViewMain";
    }
    if (this.g != null)
    {
      SharedPreferences localSharedPreferences = this.g.getSharedPreferences("adlibr", 0);
      String str = "ad_";
      if (paramString.equals("0")) {
        str = "ad_" + "ADAM";
      }
      for (;;)
      {
        return localSharedPreferences.getString(str, "");
        if (paramString.equals("1")) {
          str = "ad_" + "ADCUBE";
        } else if (paramString.equals("2")) {
          str = "ad_" + "ADMOB";
        } else if (paramString.equals("3")) {
          str = "ad_" + "CAULY";
        } else if (paramString.equals("4")) {
          str = "ad_" + "TAD";
        } else if (paramString.equals("6")) {
          str = "ad_" + "INMOBI";
        } else if (paramString.equals("9")) {
          str = "ad_" + "NAVER";
        } else if (paramString.equals("10")) {
          str = "ad_" + "MM";
        } else if (paramString.equals("11")) {
          str = "ad_" + "MOJIVA";
        } else if (paramString.equals("12")) {
          str = "ad_" + "SHALLWEAD";
        } else if (paramString.equals("13")) {
          str = "ad_" + "ADHUB";
        } else if (paramString.equals("14")) {
          str = "ad_" + "AROUNDERS";
        } else if (paramString.equals("15")) {
          str = "ad_" + "ADSQUARE";
        } else if (paramString.equals("700")) {
          str = "ad_" + "CUSTOM0";
        } else if (paramString.equals("701")) {
          str = "ad_" + "CUSTOM1";
        } else if (paramString.equals("702")) {
          str = "ad_" + "CUSTOM2";
        } else if (paramString.equals("703")) {
          str = "ad_" + "CUSTOM3";
        } else if (paramString.equals("704")) {
          str = "ad_" + "CUSTOM4";
        }
      }
    }
    return "";
  }
  
  protected final String a(String paramString, UrlEncodedFormEntity paramUrlEncodedFormEntity)
  {
    paramString = new HttpPost(paramString);
    paramString.setEntity(paramUrlEncodedFormEntity);
    paramUrlEncodedFormEntity = new BasicHttpParams();
    HttpProtocolParams.setVersion(paramUrlEncodedFormEntity, HttpVersion.HTTP_1_1);
    paramUrlEncodedFormEntity.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    paramUrlEncodedFormEntity = new DefaultHttpClient(paramUrlEncodedFormEntity);
    HttpConnectionParams.setSoTimeout(paramUrlEncodedFormEntity.getParams(), 5000);
    paramUrlEncodedFormEntity.addRequestInterceptor(new HttpRequestInterceptor()
    {
      public final void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
      {
        if (!paramAnonymousHttpRequest.containsHeader("Accept-Encoding")) {
          paramAnonymousHttpRequest.addHeader("Accept-Encoding", "gzip");
        }
      }
    });
    paramUrlEncodedFormEntity.addResponseInterceptor(new HttpResponseInterceptor()
    {
      public final void process(HttpResponse paramAnonymousHttpResponse, HttpContext paramAnonymousHttpContext)
      {
        paramAnonymousHttpContext = paramAnonymousHttpResponse.getEntity().getContentEncoding();
        int j;
        int i;
        if (paramAnonymousHttpContext != null)
        {
          paramAnonymousHttpContext = paramAnonymousHttpContext.getElements();
          j = paramAnonymousHttpContext.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= j) {
            return;
          }
          if (paramAnonymousHttpContext[i].getName().equalsIgnoreCase("gzip"))
          {
            paramAnonymousHttpResponse.setEntity(new AdlibConfig.b(paramAnonymousHttpResponse.getEntity()));
            return;
          }
          i += 1;
        }
      }
    });
    try
    {
      paramString = paramUrlEncodedFormEntity.execute(paramString);
      if (paramString.getStatusLine().getStatusCode() != 200) {
        return null;
      }
      paramString = new BufferedReader(new InputStreamReader(paramString.getEntity().getContent(), "UTF-8"));
      paramUrlEncodedFormEntity = new char['Ѐ'];
      StringWriter localStringWriter = new StringWriter();
      for (;;)
      {
        int i1 = paramString.read(paramUrlEncodedFormEntity);
        if (i1 == -1) {
          return localStringWriter.toString();
        }
        localStringWriter.write(paramUrlEncodedFormEntity, 0, i1);
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public final void a()
  {
    this.b = false;
  }
  
  public final void a(Activity paramActivity)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      try
      {
        this.g = paramActivity;
        if (!this.b)
        {
          paramActivity = new Handler()
          {
            public final void handleMessage(Message paramAnonymousMessage)
            {
              if (new Date().getTime() - AdlibConfig.a(AdlibConfig.this) > 3600000L) {
                AdlibConfig.b(AdlibConfig.this);
              }
            }
          };
          o();
          p();
          new Timer().schedule(new d(paramActivity), 60000L, 60000L);
          this.b = true;
          return;
        }
      }
      catch (Exception paramActivity) {}
    }
  }
  
  protected final void a(final Context paramContext, String paramString, final Handler paramHandler)
  {
    final String str = r;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("key", paramString));
    try
    {
      new Thread(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 24	com/mocoplex/adlib/AdlibConfig$4:a	Lcom/mocoplex/adlib/AdlibConfig;
          //   4: aload_0
          //   5: getfield 26	com/mocoplex/adlib/AdlibConfig$4:b	Ljava/lang/String;
          //   8: aload_0
          //   9: getfield 28	com/mocoplex/adlib/AdlibConfig$4:c	Lorg/apache/http/client/entity/UrlEncodedFormEntity;
          //   12: invokevirtual 42	com/mocoplex/adlib/AdlibConfig:a	(Ljava/lang/String;Lorg/apache/http/client/entity/UrlEncodedFormEntity;)Ljava/lang/String;
          //   15: astore_3
          //   16: aload_3
          //   17: ifnonnull +4 -> 21
          //   20: return
          //   21: new 44	org/json/JSONObject
          //   24: dup
          //   25: aload_3
          //   26: invokespecial 47	org/json/JSONObject:<init>	(Ljava/lang/String;)V
          //   29: astore 5
          //   31: aload 5
          //   33: ldc 49
          //   35: invokevirtual 53	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
          //   38: astore 4
          //   40: aload 5
          //   42: ldc 55
          //   44: invokevirtual 53	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
          //   47: astore_3
          //   48: aload 5
          //   50: ldc 57
          //   52: invokevirtual 61	org/json/JSONObject:getInt	(Ljava/lang/String;)I
          //   55: istore_1
          //   56: aload 5
          //   58: ldc 63
          //   60: invokevirtual 61	org/json/JSONObject:getInt	(Ljava/lang/String;)I
          //   63: istore_2
          //   64: aload_0
          //   65: getfield 24	com/mocoplex/adlib/AdlibConfig$4:a	Lcom/mocoplex/adlib/AdlibConfig;
          //   68: astore 6
          //   70: aload_0
          //   71: getfield 30	com/mocoplex/adlib/AdlibConfig$4:d	Landroid/content/Context;
          //   74: aload 4
          //   76: invokestatic 66	com/mocoplex/adlib/AdlibConfig:a	(Landroid/content/Context;Ljava/lang/String;)Z
          //   79: ifne +97 -> 176
          //   82: aload 5
          //   84: ldc 68
          //   86: invokevirtual 53	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
          //   89: astore 5
          //   91: aload_0
          //   92: getfield 24	com/mocoplex/adlib/AdlibConfig$4:a	Lcom/mocoplex/adlib/AdlibConfig;
          //   95: aload_0
          //   96: getfield 30	com/mocoplex/adlib/AdlibConfig$4:d	Landroid/content/Context;
          //   99: aload 5
          //   101: aload 4
          //   103: iload_1
          //   104: iload_2
          //   105: invokevirtual 71	com/mocoplex/adlib/AdlibConfig:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
          //   108: aload_0
          //   109: getfield 24	com/mocoplex/adlib/AdlibConfig$4:a	Lcom/mocoplex/adlib/AdlibConfig;
          //   112: astore 5
          //   114: aload_0
          //   115: getfield 30	com/mocoplex/adlib/AdlibConfig$4:d	Landroid/content/Context;
          //   118: aload 4
          //   120: invokestatic 66	com/mocoplex/adlib/AdlibConfig:a	(Landroid/content/Context;Ljava/lang/String;)Z
          //   123: ifeq -103 -> 20
          //   126: new 44	org/json/JSONObject
          //   129: dup
          //   130: invokespecial 72	org/json/JSONObject:<init>	()V
          //   133: astore 5
          //   135: aload 5
          //   137: ldc 49
          //   139: aload 4
          //   141: invokevirtual 76	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
          //   144: pop
          //   145: aload 5
          //   147: ldc 55
          //   149: aload_3
          //   150: invokevirtual 76	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
          //   153: pop
          //   154: aload_0
          //   155: getfield 32	com/mocoplex/adlib/AdlibConfig$4:e	Landroid/os/Handler;
          //   158: bipush 10
          //   160: aload 5
          //   162: invokestatic 82	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
          //   165: astore_3
          //   166: aload_0
          //   167: getfield 32	com/mocoplex/adlib/AdlibConfig$4:e	Landroid/os/Handler;
          //   170: aload_3
          //   171: invokevirtual 88	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
          //   174: pop
          //   175: return
          //   176: aload_0
          //   177: getfield 24	com/mocoplex/adlib/AdlibConfig$4:a	Lcom/mocoplex/adlib/AdlibConfig;
          //   180: astore 5
          //   182: aload_0
          //   183: getfield 30	com/mocoplex/adlib/AdlibConfig$4:d	Landroid/content/Context;
          //   186: aload 4
          //   188: iload_1
          //   189: iload_2
          //   190: invokestatic 91	com/mocoplex/adlib/AdlibConfig:a	(Landroid/content/Context;Ljava/lang/String;II)V
          //   193: goto -85 -> 108
          //   196: astore_3
          //   197: return
          //   198: astore_3
          //   199: return
          //   200: astore_3
          //   201: ldc 93
          //   203: astore_3
          //   204: goto -156 -> 48
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	207	0	this	4
          //   55	134	1	i	int
          //   63	127	2	j	int
          //   15	156	3	localObject1	Object
          //   196	1	3	localException1	Exception
          //   198	1	3	localException2	Exception
          //   200	1	3	localException3	Exception
          //   203	1	3	str1	String
          //   38	149	4	str2	String
          //   29	152	5	localObject2	Object
          //   68	1	6	localAdlibConfig	AdlibConfig
          // Exception table:
          //   from	to	target	type
          //   0	16	196	java/lang/Exception
          //   21	40	198	java/lang/Exception
          //   48	108	198	java/lang/Exception
          //   108	175	198	java/lang/Exception
          //   176	193	198	java/lang/Exception
          //   40	48	200	java/lang/Exception
        }
      }).start();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected final void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString2 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(a(paramContext))).append("icon/").toString())).append(paramString2).toString() + "/";
    new File(paramString2).mkdirs();
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString1);
      int i2 = 0;
      int i1 = 0;
      if (i2 >= localJSONArray.length())
      {
        if (i1 == localJSONArray.length())
        {
          paramString1 = new File(paramString2 + "ok");
          paramString1.createNewFile();
          paramContext = Integer.toString(paramInt1) + "," + Integer.toString(paramInt2);
          paramString1 = new FileOutputStream(paramString1);
          paramString1.write(paramContext.getBytes());
          paramString1.close();
        }
      }
      else
      {
        paramContext = (JSONObject)localJSONArray.get(i2);
        String str1 = paramContext.getString("url");
        String str2 = Integer.toString((int)paramContext.getDouble("delay"));
        for (;;)
        {
          try
          {
            paramString1 = Integer.toString(i2 + 1);
            paramContext = paramString1;
            if (i2 < 9) {
              paramContext = "0" + paramString1;
            }
            paramContext = paramContext + "_" + str2;
            if (a(str1, new File(paramString2 + paramContext)).booleanValue()) {
              break label341;
            }
            throw new Exception();
          }
          catch (Exception paramContext)
          {
            i2 += 1;
          }
          break;
          label341:
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected final void a(final String paramString1, final String paramString2)
  {
    paramString2 = new StringBuilder(String.valueOf(o())).append(paramString2).toString() + "/";
    new File(paramString2).mkdirs();
    new Thread(new Runnable()
    {
      private int b = 0;
      
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: new 36	org/json/JSONArray
        //   3: dup
        //   4: aload_0
        //   5: getfield 23	com/mocoplex/adlib/AdlibConfig$9:c	Ljava/lang/String;
        //   8: invokespecial 39	org/json/JSONArray:<init>	(Ljava/lang/String;)V
        //   11: astore 4
        //   13: iconst_0
        //   14: istore_1
        //   15: iload_1
        //   16: aload 4
        //   18: invokevirtual 43	org/json/JSONArray:length	()I
        //   21: if_icmplt +176 -> 197
        //   24: aload_0
        //   25: getfield 30	com/mocoplex/adlib/AdlibConfig$9:b	I
        //   28: aload 4
        //   30: invokevirtual 43	org/json/JSONArray:length	()I
        //   33: if_icmpne +163 -> 196
        //   36: new 45	java/io/File
        //   39: dup
        //   40: new 47	java/lang/StringBuilder
        //   43: dup
        //   44: aload_0
        //   45: getfield 25	com/mocoplex/adlib/AdlibConfig$9:d	Ljava/lang/String;
        //   48: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   51: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   54: ldc 56
        //   56: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   59: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   62: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
        //   65: astore 4
        //   67: aload 4
        //   69: invokevirtual 69	java/io/File:createNewFile	()Z
        //   72: pop
        //   73: new 47	java/lang/StringBuilder
        //   76: dup
        //   77: aload_0
        //   78: getfield 25	com/mocoplex/adlib/AdlibConfig$9:d	Ljava/lang/String;
        //   81: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   84: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   87: ldc 71
        //   89: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   92: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   95: astore_2
        //   96: aload_0
        //   97: getfield 21	com/mocoplex/adlib/AdlibConfig$9:a	Lcom/mocoplex/adlib/AdlibConfig;
        //   100: astore_3
        //   101: aload_2
        //   102: invokestatic 75	com/mocoplex/adlib/AdlibConfig:i	(Ljava/lang/String;)Ljava/lang/String;
        //   105: astore_2
        //   106: new 45	java/io/File
        //   109: dup
        //   110: aload_0
        //   111: getfield 25	com/mocoplex/adlib/AdlibConfig$9:d	Ljava/lang/String;
        //   114: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
        //   117: new 77	com/mocoplex/adlib/AdlibConfig$a
        //   120: dup
        //   121: aload_0
        //   122: getfield 21	com/mocoplex/adlib/AdlibConfig$9:a	Lcom/mocoplex/adlib/AdlibConfig;
        //   125: ldc 78
        //   127: invokespecial 81	com/mocoplex/adlib/AdlibConfig$a:<init>	(Lcom/mocoplex/adlib/AdlibConfig;Ljava/lang/String;)V
        //   130: invokevirtual 85	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
        //   133: astore_3
        //   134: iconst_0
        //   135: istore_1
        //   136: iload_1
        //   137: aload_3
        //   138: arraylength
        //   139: if_icmplt +212 -> 351
        //   142: aload_0
        //   143: getfield 21	com/mocoplex/adlib/AdlibConfig$9:a	Lcom/mocoplex/adlib/AdlibConfig;
        //   146: ldc 87
        //   148: invokevirtual 89	com/mocoplex/adlib/AdlibConfig:c	(Ljava/lang/String;)Ljava/lang/String;
        //   151: astore 5
        //   153: aload_2
        //   154: astore_3
        //   155: aload 5
        //   157: ldc 91
        //   159: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   162: ifne +12 -> 174
        //   165: aload_2
        //   166: ldc 97
        //   168: aload 5
        //   170: invokevirtual 101	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   173: astore_3
        //   174: new 103	java/io/FileOutputStream
        //   177: dup
        //   178: aload 4
        //   180: invokespecial 106	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   183: astore_2
        //   184: aload_2
        //   185: aload_3
        //   186: invokevirtual 110	java/lang/String:getBytes	()[B
        //   189: invokevirtual 114	java/io/FileOutputStream:write	([B)V
        //   192: aload_2
        //   193: invokevirtual 117	java/io/FileOutputStream:close	()V
        //   196: return
        //   197: aload 4
        //   199: iload_1
        //   200: invokevirtual 121	org/json/JSONArray:get	(I)Ljava/lang/Object;
        //   203: checkcast 123	org/json/JSONObject
        //   206: astore_2
        //   207: aload_2
        //   208: ldc 125
        //   210: invokevirtual 128	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
        //   213: checkcast 49	java/lang/String
        //   216: astore 5
        //   218: aload_2
        //   219: ldc -126
        //   221: invokevirtual 128	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
        //   224: checkcast 49	java/lang/String
        //   227: astore_3
        //   228: aload_3
        //   229: astore_2
        //   230: aload_3
        //   231: ldc -124
        //   233: invokevirtual 136	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   236: ifge +23 -> 259
        //   239: new 47	java/lang/StringBuilder
        //   242: dup
        //   243: aload_3
        //   244: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   247: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   250: ldc -124
        //   252: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   255: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   258: astore_2
        //   259: new 47	java/lang/StringBuilder
        //   262: dup
        //   263: aload_2
        //   264: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   267: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   270: ldc -118
        //   272: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   275: invokestatic 141	com/mocoplex/adlib/AdlibConfig:l	()Ljava/lang/String;
        //   278: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   281: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   284: astore_2
        //   285: new 45	java/io/File
        //   288: dup
        //   289: new 47	java/lang/StringBuilder
        //   292: dup
        //   293: aload_0
        //   294: getfield 25	com/mocoplex/adlib/AdlibConfig$9:d	Ljava/lang/String;
        //   297: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   300: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   303: aload 5
        //   305: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   308: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   311: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
        //   314: astore_3
        //   315: aload_0
        //   316: getfield 21	com/mocoplex/adlib/AdlibConfig$9:a	Lcom/mocoplex/adlib/AdlibConfig;
        //   319: aload_2
        //   320: aload_3
        //   321: invokevirtual 144	com/mocoplex/adlib/AdlibConfig:a	(Ljava/lang/String;Ljava/io/File;)Ljava/lang/Boolean;
        //   324: invokevirtual 149	java/lang/Boolean:booleanValue	()Z
        //   327: ifne +11 -> 338
        //   330: new 34	java/lang/Exception
        //   333: dup
        //   334: invokespecial 150	java/lang/Exception:<init>	()V
        //   337: athrow
        //   338: aload_0
        //   339: aload_0
        //   340: getfield 30	com/mocoplex/adlib/AdlibConfig$9:b	I
        //   343: iconst_1
        //   344: iadd
        //   345: putfield 30	com/mocoplex/adlib/AdlibConfig$9:b	I
        //   348: goto +75 -> 423
        //   351: aload_3
        //   352: iload_1
        //   353: aaload
        //   354: invokevirtual 153	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   357: astore 5
        //   359: aload_3
        //   360: iload_1
        //   361: aaload
        //   362: invokevirtual 156	java/io/File:getName	()Ljava/lang/String;
        //   365: astore 6
        //   367: aload_2
        //   368: new 47	java/lang/StringBuilder
        //   371: dup
        //   372: ldc -98
        //   374: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   377: aload 6
        //   379: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   382: ldc -98
        //   384: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   387: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   390: new 47	java/lang/StringBuilder
        //   393: dup
        //   394: ldc -96
        //   396: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   399: aload 5
        //   401: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   404: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   407: invokevirtual 101	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   410: astore_2
        //   411: iload_1
        //   412: iconst_1
        //   413: iadd
        //   414: istore_1
        //   415: goto -279 -> 136
        //   418: astore_2
        //   419: return
        //   420: astore_2
        //   421: return
        //   422: astore_2
        //   423: iload_1
        //   424: iconst_1
        //   425: iadd
        //   426: istore_1
        //   427: goto -412 -> 15
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	430	0	this	9
        //   14	413	1	i	int
        //   95	316	2	localObject1	Object
        //   418	1	2	localException1	Exception
        //   420	1	2	localException2	Exception
        //   422	1	2	localException3	Exception
        //   100	260	3	localObject2	Object
        //   11	187	4	localObject3	Object
        //   151	249	5	str1	String
        //   365	13	6	str2	String
        // Exception table:
        //   from	to	target	type
        //   0	13	418	java/lang/Exception
        //   15	96	418	java/lang/Exception
        //   197	228	418	java/lang/Exception
        //   230	259	418	java/lang/Exception
        //   259	285	418	java/lang/Exception
        //   96	134	420	java/lang/Exception
        //   136	153	420	java/lang/Exception
        //   155	174	420	java/lang/Exception
        //   174	196	420	java/lang/Exception
        //   351	411	420	java/lang/Exception
        //   285	338	422	java/lang/Exception
        //   338	348	422	java/lang/Exception
      }
    }).start();
  }
  
  public final void b(Activity paramActivity)
  {
    if (this.g == paramActivity) {
      this.g = null;
    }
  }
  
  protected final void b(Context paramContext, String paramString, final Handler paramHandler)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("key", paramString));
    localArrayList.add(new BasicNameValuePair("udid", f.a(paramContext).a()));
    localArrayList.add(new BasicNameValuePair("agent", new WebView(paramContext).getSettings().getUserAgentString()));
    try
    {
      new Thread(new Runnable()
      {
        public final void run()
        {
          try
          {
            String str = AdlibConfig.getInstance().a("http://ad.adlibr.com/smartad/rlink/clk.jsp", this.b);
            if (str == null) {
              throw new Exception();
            }
          }
          catch (Exception localException)
          {
            paramHandler.sendEmptyMessage(20);
            return;
          }
          Message localMessage = Message.obtain(paramHandler, 10, localException);
          paramHandler.sendMessage(localMessage);
        }
      }).start();
      return;
    }
    catch (Exception paramContext)
    {
      paramHandler.sendEmptyMessage(20);
    }
  }
  
  protected final void b(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramString.put("now", new Date().getTime());
        localObject = paramString.toString();
        new JSONArray(paramString.getString("setting"));
        c("sch", (String)localObject);
        long l1 = new Date().getTime();
        if (this.g != null)
        {
          localObject = this.g.getSharedPreferences("adlibr", 0).edit();
          ((SharedPreferences.Editor)localObject).putLong("acc", l1);
          ((SharedPreferences.Editor)localObject).commit();
        }
      }
      catch (JSONException paramString)
      {
        final Object localObject;
        final String str;
        ArrayList localArrayList;
        continue;
      }
      try
      {
        if (paramString.getString("loc").equals("N")) {
          this.i = false;
        }
      }
      catch (Exception localException4)
      {
        try
        {
          this.c = paramString.getInt("rbdelay");
        }
        catch (Exception localException4)
        {
          try
          {
            localObject = paramString.getString("smart");
            if (localObject != null)
            {
              c("smart", (String)localObject);
              if (o() != null) {
                new Thread(new Runnable()
                {
                  public final void run()
                  {
                    try
                    {
                      JSONArray localJSONArray = new JSONArray(localObject);
                      int i = 0;
                      for (;;)
                      {
                        if (i >= localJSONArray.length())
                        {
                          e.a().c();
                          return;
                        }
                        String str = (String)localJSONArray.get(i);
                        AdlibConfig.this.f(str);
                        i += 1;
                      }
                      return;
                    }
                    catch (Exception localException) {}
                  }
                }).start();
              }
            }
          }
          catch (Exception localException4)
          {
            try
            {
              localObject = (String)paramString.get("dlg");
              str = c("campaign");
              if (str != "") {
                if (((String)localObject).equals(str))
                {
                  if (i1 == 0) {
                    continue;
                  }
                  str = o;
                  localArrayList = new ArrayList();
                  localArrayList.add(new BasicNameValuePair("id", (String)localObject));
                }
              }
            }
            catch (Exception localException4)
            {
              try
              {
                new Thread(new Runnable()
                {
                  public final void run()
                  {
                    try
                    {
                      String str1 = AdlibConfig.this.a(str, this.c);
                      if (str1 == null) {
                        throw new Exception();
                      }
                    }
                    catch (Exception localException1)
                    {
                      return;
                    }
                    try
                    {
                      JSONArray localJSONArray = new JSONArray(localException1);
                      int i = 0;
                      for (;;)
                      {
                        if (i >= localJSONArray.length())
                        {
                          if (AdlibConfig.d(AdlibConfig.this))
                          {
                            AdlibConfig.a(AdlibConfig.this, "campaign", localObject);
                            AdlibConfig.a(AdlibConfig.this, "dialog", localException1);
                          }
                          c.a().a(AdlibConfig.c(AdlibConfig.this));
                          return;
                        }
                        String str2 = (String)localJSONArray.get(i);
                        c.a();
                        if (c.d(AdlibConfig.c(AdlibConfig.this), str2) == null) {
                          AdlibConfig.this.d(str2);
                        }
                        i += 1;
                      }
                      return;
                    }
                    catch (Exception localException2) {}
                  }
                }).start();
                try
                {
                  localObject = (String)paramString.get("banner2");
                  if (localObject != null)
                  {
                    this.l = ((String)localObject);
                    if (o() != null) {
                      a(false, 1);
                    }
                  }
                }
                catch (Exception localException7)
                {
                  continue;
                }
                try
                {
                  if (this.l.equals(""))
                  {
                    localObject = (String)paramString.get("banner");
                    if (localObject != null)
                    {
                      this.l = ((String)localObject);
                      if (o() != null) {
                        a(true, 1);
                      }
                    }
                  }
                }
                catch (Exception localException6)
                {
                  continue;
                }
                try
                {
                  localObject = (String)paramString.get("default2");
                  if (localObject != null)
                  {
                    this.k = ((String)localObject);
                    if (o() != null) {
                      a(false, 0);
                    }
                  }
                }
                catch (Exception localException5)
                {
                  continue;
                }
                try
                {
                  if (this.k.equals(""))
                  {
                    paramString = (String)paramString.get("default");
                    if (paramString != null)
                    {
                      this.k = paramString;
                      if (o() != null) {
                        a(true, 0);
                      }
                    }
                  }
                }
                catch (Exception paramString)
                {
                  continue;
                }
                f.a(null).b();
                return;
                this.i = true;
                continue;
                localException1 = localException1;
                this.i = true;
                continue;
                localException2 = localException2;
                this.c = 0;
                continue;
                localException3 = localException3;
                c("smart", "");
                continue;
                i1 = 1;
                continue;
                c.a().a(this.g, false);
                continue;
                localException4 = localException4;
                continue;
              }
              catch (Exception localException8)
              {
                continue;
              }
              i1 = 1;
            }
          }
        }
      }
    }
  }
  
  protected final void b(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("id", paramString2));
    try
    {
      paramString1 = a(paramString1, new UrlEncodedFormEntity(localArrayList, "UTF-8"));
      if (paramString1 == null) {
        throw new Exception();
      }
      e(paramString1, paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public final boolean b()
  {
    String str1 = o();
    String str2 = n();
    return new File(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str1)).append(str2).toString())).append("/").toString() + "ok").exists();
  }
  
  public void bindPlatform(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.g.getSharedPreferences("adlibr", 0).edit();
    localEditor.putString("ad_" + paramString1, paramString2);
    localEditor.commit();
  }
  
  public final String c(String paramString)
  {
    if (this.g != null) {
      return this.g.getSharedPreferences("adlibr", 0).getString(paramString, "");
    }
    return "";
  }
  
  public final boolean c()
  {
    String str1 = o();
    String str2 = m();
    return new File(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str1)).append(str2).toString())).append("/").toString() + "ok").exists();
  }
  
  public final String d()
  {
    String str1 = o();
    String str2 = m();
    return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str1)).append(str2).toString())).append("/").toString() + "ok";
  }
  
  protected final void d(String paramString)
  {
    String str = p;
    Object localObject = new ArrayList();
    ((List)localObject).add(new BasicNameValuePair("id", paramString));
    boolean bool;
    do
    {
      try
      {
        str = a(str, new UrlEncodedFormEntity((List)localObject, "UTF-8"));
        if (str == null) {
          throw new Exception();
        }
      }
      catch (Exception paramString)
      {
        this.n = false;
        return;
      }
      bool = k(paramString);
    } while (bool);
    for (;;)
    {
      try
      {
        localObject = (String)new JSONObject(str).get("url");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("id", paramString));
        try
        {
          localObject = a((String)localObject, new UrlEncodedFormEntity(localArrayList, "UTF-8"));
          if (localObject != null) {
            break label195;
          }
          throw new Exception();
        }
        catch (Exception localException)
        {
          this.n = false;
          if (!k(paramString)) {
            break;
          }
        }
        c.a();
        c.a(this.g, paramString, str);
        return;
      }
      catch (Exception paramString)
      {
        this.n = false;
        return;
      }
      label195:
      d(localException, paramString);
    }
    this.n = false;
  }
  
  public final String e()
  {
    String str1 = o();
    String str2 = n();
    return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str1)).append(str2).toString())).append("/").toString() + "ok";
  }
  
  public final String e(String paramString)
  {
    return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(o())).append("dlg/").toString())).append(paramString).toString())).append("/").toString() + "ok";
  }
  
  protected final void f()
  {
    Thread localThread = new Thread(new Runnable()
    {
      public final void run()
      {
        try
        {
          AdlibConfig.this.g();
          return;
        }
        catch (Exception localException) {}
      }
    });
    localThread.setPriority(1);
    localThread.start();
  }
  
  protected final void f(String paramString)
  {
    String str = q;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("id", paramString));
    try
    {
      str = a(str, new UrlEncodedFormEntity(localArrayList, "UTF-8"));
      if (str == null) {
        throw new Exception();
      }
      if (!g(paramString))
      {
        e(str, paramString);
        return;
      }
    }
    catch (Exception paramString) {}
  }
  
  /* Error */
  public final void g()
  {
    // Byte code:
    //   0: new 178	java/lang/StringBuilder
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 323	com/mocoplex/adlib/AdlibConfig:o	()Ljava/lang/String;
    //   8: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   11: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: ldc_w 445
    //   17: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_3
    //   24: new 180	java/io/File
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 4
    //   34: aload 4
    //   36: invokevirtual 256	java/io/File:listFiles	()[Ljava/io/File;
    //   39: arraylength
    //   40: ifle +136 -> 176
    //   43: aload 4
    //   45: invokevirtual 256	java/io/File:listFiles	()[Ljava/io/File;
    //   48: astore 4
    //   50: aload 4
    //   52: arraylength
    //   53: istore_2
    //   54: iconst_0
    //   55: istore_1
    //   56: goto +115 -> 171
    //   59: aload 4
    //   61: iload_1
    //   62: aaload
    //   63: astore 5
    //   65: new 178	java/lang/StringBuilder
    //   68: dup
    //   69: aload_3
    //   70: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload 5
    //   78: invokevirtual 438	java/io/File:getName	()Ljava/lang/String;
    //   81: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 837
    //   87: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 6
    //   95: new 180	java/io/File
    //   98: dup
    //   99: aload 6
    //   101: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 205	java/io/File:exists	()Z
    //   107: ifeq +50 -> 157
    //   110: aload 6
    //   112: invokestatic 337	com/mocoplex/adlib/AdlibConfig:j	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore 6
    //   117: new 139	java/text/SimpleDateFormat
    //   120: dup
    //   121: ldc -115
    //   123: invokespecial 144	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   126: new 152	java/util/Date
    //   129: dup
    //   130: invokespecial 153	java/util/Date:<init>	()V
    //   133: invokevirtual 169	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   136: astore 7
    //   138: aload 6
    //   140: invokestatic 459	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   143: aload 7
    //   145: invokestatic 459	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   148: if_icmpge +9 -> 157
    //   151: aload_0
    //   152: aload 5
    //   154: invokespecial 258	com/mocoplex/adlib/AdlibConfig:a	(Ljava/io/File;)V
    //   157: iload_1
    //   158: iconst_1
    //   159: iadd
    //   160: istore_1
    //   161: goto +10 -> 171
    //   164: astore_3
    //   165: return
    //   166: astore 5
    //   168: goto -11 -> 157
    //   171: iload_1
    //   172: iload_2
    //   173: if_icmplt -114 -> 59
    //   176: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	AdlibConfig
    //   55	119	1	i1	int
    //   53	121	2	i2	int
    //   23	47	3	str1	String
    //   164	1	3	localException1	Exception
    //   32	28	4	localObject	Object
    //   63	90	5	localFile	File
    //   166	1	5	localException2	Exception
    //   93	46	6	str2	String
    //   136	8	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   24	54	164	java/lang/Exception
    //   65	157	166	java/lang/Exception
  }
  
  public final boolean g(String paramString)
  {
    return new File(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(o())).append("smart/").toString())).append(paramString).toString())).append("/").toString() + "ok").exists();
  }
  
  public String getCaulyAge()
  {
    String str = c("age");
    if (str.equals("10")) {
      return "10";
    }
    if (str.equals("20")) {
      return "20";
    }
    if (str.equals("30")) {
      return "30";
    }
    if (str.equals("40")) {
      return "40";
    }
    return "all";
  }
  
  public String getCaulyGPS()
  {
    String str = c("lat");
    if ((str.equals("")) || (str.equals("0"))) {
      return "off";
    }
    return "auto";
  }
  
  public String getCaulyGender()
  {
    String str = c("sex");
    if (str.equals("F")) {
      return "female";
    }
    if (str.equals("M")) {
      return "male";
    }
    return "all";
  }
  
  public final String h(String paramString)
  {
    return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(o())).append("smart/").toString())).append(paramString).toString())).append("/").toString() + "ok";
  }
  
  public final Location i()
  {
    if (this.e == null)
    {
      if (this.g != null) {
        try
        {
          this.d = ((LocationManager)this.g.getSystemService("location"));
          this.e = this.d.getLastKnownLocation("network");
          return this.e;
        }
        catch (Exception localException)
        {
          this.i = false;
          return null;
        }
      }
      return null;
    }
    return this.e;
  }
  
  public final void j()
  {
    this.e = null;
  }
  
  public final boolean k()
  {
    return this.i;
  }
  
  public void setAdInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    SharedPreferences.Editor localEditor = this.g.getSharedPreferences("adlibr", 0).edit();
    localEditor.putString("sex", paramString1);
    localEditor.putString("age", paramString2);
    localEditor.putString("lat", paramString3);
    localEditor.putString("lon", paramString4);
    localEditor.commit();
  }
  
  public void setAdlibKey(String paramString)
  {
    c("logging", "Y");
    c("api", paramString);
    if (c("sch").equals("")) {
      p();
    }
  }
  
  final class a
    implements FilenameFilter
  {
    private String b;
    
    public a(String paramString)
    {
      this.b = paramString;
    }
    
    public final boolean accept(File paramFile, String paramString)
    {
      return (paramString != null) && (paramString.indexOf(this.b) == 0);
    }
  }
  
  static final class b
    extends HttpEntityWrapper
  {
    public b(HttpEntity paramHttpEntity)
    {
      super();
    }
    
    public final InputStream getContent()
      throws IOException
    {
      return new GZIPInputStream(this.wrappedEntity.getContent());
    }
    
    public final long getContentLength()
    {
      return -1L;
    }
  }
  
  public static final class c {}
  
  final class d
    extends TimerTask
  {
    protected Handler a;
    
    public d(Handler paramHandler)
    {
      this.a = paramHandler;
    }
    
    public final void run()
    {
      Message localMessage = Message.obtain(this.a, 0, Integer.valueOf(0));
      this.a.sendMessage(localMessage);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */