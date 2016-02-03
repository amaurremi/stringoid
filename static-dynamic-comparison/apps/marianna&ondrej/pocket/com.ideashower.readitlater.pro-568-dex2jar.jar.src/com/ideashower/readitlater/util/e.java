package com.ideashower.readitlater.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.a.c.k;

public class e
{
  public static final String a = (String)null;
  public static String b;
  public static String c;
  public static Locale d;
  
  public static Dialog a(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.setTitle("Switch locale");
    localDialog.setCancelable(true);
    ListView localListView = new ListView(paramActivity);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("default");
    localArrayList.add("de");
    localArrayList.add("es_ES");
    localArrayList.add("es_US");
    localArrayList.add("fr_FR");
    localArrayList.add("fr_CA");
    localArrayList.add("it");
    localArrayList.add("ja");
    localArrayList.add("nl");
    localArrayList.add("pt_PT");
    localArrayList.add("ru");
    localArrayList.add("zh_CN");
    localArrayList.add("zh_TW");
    localListView.setAdapter(new ArrayAdapter(paramActivity, 17367043, localArrayList));
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @SuppressLint({"NewApi"})
      public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        StringTokenizer localStringTokenizer = new StringTokenizer((String)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt), "_");
        paramAnonymousView = (String)localStringTokenizer.nextElement();
        paramAnonymousAdapterView = null;
        if (localStringTokenizer.hasMoreElements()) {
          paramAnonymousAdapterView = (String)localStringTokenizer.nextElement();
        }
        e.e(paramAnonymousView, paramAnonymousAdapterView);
        e.this.finish();
        paramAnonymousAdapterView = e.this.getBaseContext().getPackageManager().getLaunchIntentForPackage(e.this.getBaseContext().getPackageName());
        paramAnonymousAdapterView.addFlags(67108864);
        e.this.startActivity(paramAnonymousAdapterView);
        Process.killProcess(Process.myPid());
      }
    });
    localDialog.setContentView(localListView);
    return localDialog;
  }
  
  public static void a() {}
  
  public static void a(long paramLong)
  {
    if (paramLong > 9999999999L) {
      throw new RuntimeException("Timestamp " + paramLong + " is too high to be UNIX time.");
    }
  }
  
  public static void a(Resources paramResources)
  {
    if (c == null)
    {
      b = i.a(com.ideashower.readitlater.h.a.cv);
      c = i.a(com.ideashower.readitlater.h.a.cu);
    }
    DisplayMetrics localDisplayMetrics = paramResources.getDisplayMetrics();
    Configuration localConfiguration = paramResources.getConfiguration();
    if ((c == null) || (c.contains("default"))) {
      localConfiguration.locale = Locale.getDefault();
    }
    for (;;)
    {
      d = localConfiguration.locale;
      paramResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      return;
      if (!k.a(b)) {
        localConfiguration.locale = new Locale(c, b);
      } else if (!k.a(c)) {
        localConfiguration.locale = new Locale(c);
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, false);
  }
  
  public static void a(String paramString1, String paramString2) {}
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (g.y()) {
      throw new RuntimeException(k.c(paramString));
    }
    if (paramBoolean) {
      try
      {
        throw new RuntimeException(k.c(paramString));
      }
      catch (Throwable paramString)
      {
        g.s().b(paramString);
      }
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    a(paramThrowable, false, null);
  }
  
  public static void a(Throwable paramThrowable, boolean paramBoolean)
  {
    a(paramThrowable, paramBoolean, null);
  }
  
  public static void a(Throwable paramThrowable, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      g.s().a(paramThrowable, paramString);
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public static void b()
  {
    if ((g.q()) || (!g.b().a())) {
      return;
    }
    throw new RuntimeException("May only be used on UI thread!");
  }
  
  public static void b(String paramString) {}
  
  public static void b(String paramString1, String paramString2) {}
  
  public static void c(String paramString)
  {
    paramString = new RuntimeException(k.c(paramString));
    try
    {
      throw paramString;
    }
    catch (RuntimeException localRuntimeException)
    {
      g.s().b(localRuntimeException);
      throw paramString;
    }
  }
  
  public static void c(String paramString1, String paramString2) {}
  
  public static void d(String paramString1, String paramString2) {}
  
  public static void e(String paramString1, String paramString2)
  {
    i.b().a(com.ideashower.readitlater.h.a.cu, paramString1).a(com.ideashower.readitlater.h.a.cv, paramString2).a();
    b = paramString2;
    c = paramString1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */