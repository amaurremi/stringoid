package com.chartboost.sdk.Libraries;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.chartboost.sdk.Chartboost;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public final class CBUtility
{
  private static Boolean a = null;
  private static final X500Principal b = new X500Principal("CN=Android Debug,O=Android,C=US");
  
  public static int a(int paramInt, Context paramContext)
  {
    return Math.round(paramInt * b(paramContext));
  }
  
  public static SharedPreferences a()
  {
    Chartboost localChartboost = Chartboost.sharedChartboost();
    if (localChartboost.getContext() == null) {
      throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before modifying or accessing preferences.");
    }
    return localChartboost.getContext().getSharedPreferences("cbPrefs", 0);
  }
  
  public static String a(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramMap.keySet().isEmpty()) {
      localStringBuilder.append("?");
    }
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append("&");
      }
      String str2 = paramMap.get(str1).toString();
      if (str1 != null) {}
      for (;;)
      {
        try
        {
          str1 = URLEncoder.encode(str1, "UTF-8");
          localStringBuilder.append(str1);
          localStringBuilder.append("=");
          if (str2 == null) {
            break label158;
          }
          str1 = URLEncoder.encode(str2, "UTF-8");
          localStringBuilder.append(str1);
        }
        catch (UnsupportedEncodingException paramMap)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
        }
        str1 = "";
        continue;
        label158:
        str1 = "";
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(HttpEntity paramHttpEntity)
  {
    try
    {
      paramHttpEntity.consumeContent();
      return;
    }
    catch (Exception paramHttpEntity)
    {
      CBLogging.b("CBUtility", "Exception raised calling entity.consumeContent()", paramHttpEntity);
    }
  }
  
  public static void a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse != null) {}
    try
    {
      if (paramHttpResponse.getEntity() != null) {
        a(paramHttpResponse.getEntity());
      }
      return;
    }
    catch (Exception paramHttpResponse)
    {
      CBLogging.b("CBUtility", "Exception raised calling consumeQuietly over http response", paramHttpResponse);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (a == null) {}
    for (;;)
    {
      try
      {
        arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures;
        i = 0;
        j = 0;
      }
      catch (Exception localException1)
      {
        Signature[] arrayOfSignature;
        int i;
        int k;
        int j = 0;
        continue;
      }
      try
      {
        if (i >= arrayOfSignature.length) {
          break label130;
        }
        k = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(arrayOfSignature[i].toByteArray()))).getSubjectX500Principal().equals(b);
        j = k;
        if (j == 0) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
    }
    if ((paramContext.getApplicationInfo().flags & 0x2) != 0) {}
    for (i = 1;; i = 0)
    {
      a = Boolean.valueOf(j | i);
      return a.booleanValue();
      i += 1;
      break;
    }
  }
  
  public static float b(int paramInt, Context paramContext)
  {
    return paramInt * b(paramContext);
  }
  
  public static float b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static boolean b()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static CBOrientation c(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int j = paramContext.getResources().getConfiguration().orientation;
    int k = localDisplay.getRotation();
    int i;
    if (localDisplay.getWidth() == localDisplay.getHeight())
    {
      i = 3;
      if (i != 1) {
        break label127;
      }
      i = 1;
    }
    for (;;)
    {
      label56:
      j = i;
      if (k != 0)
      {
        if (k != 2) {
          break label162;
        }
        j = i;
      }
      for (;;)
      {
        if (j != 0) {
          switch (k)
          {
          default: 
            return CBOrientation.PORTRAIT;
            if (localDisplay.getWidth() < localDisplay.getHeight())
            {
              i = 1;
              break;
            }
            i = 2;
            break;
            if (i == 2)
            {
              i = 0;
              break label56;
            }
            if (i != 3) {
              break label232;
            }
            if (j == 1)
            {
              i = 1;
              break label56;
            }
            if (j != 2) {
              break label232;
            }
            i = 0;
            break label56;
            if (i == 0) {
              j = 1;
            } else {
              j = 0;
            }
            break;
          case 1: 
            return CBOrientation.LANDSCAPE_LEFT;
          case 2: 
            return CBOrientation.PORTRAIT_REVERSE;
          case 3: 
            label127:
            label162:
            return CBOrientation.LANDSCAPE_RIGHT;
          }
        }
      }
      switch (k)
      {
      default: 
        return CBOrientation.LANDSCAPE;
      case 1: 
        return CBOrientation.PORTRAIT_LEFT;
      case 2: 
        return CBOrientation.LANDSCAPE_REVERSE;
      }
      return CBOrientation.PORTRAIT_RIGHT;
      label232:
      i = 1;
    }
  }
  
  public static void throwProguardError(Exception paramException)
  {
    if ((paramException instanceof NoSuchMethodException)) {
      throw new IllegalStateException("Chartboost library error! Have you used proguard on your application? Make sure to add the line '-keep class com.chartboost.sdk.** { *; }' to your proguard config file.");
    }
    throw new RuntimeException(paramException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/CBUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */