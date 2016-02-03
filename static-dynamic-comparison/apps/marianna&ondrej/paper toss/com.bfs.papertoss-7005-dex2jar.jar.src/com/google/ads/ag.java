package com.google.ads;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.a;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Locale;

public final class ag
{
  private static final a a = (a)a.a.b();
  
  public static void a(Activity paramActivity)
  {
    new Thread(new a(paramActivity)).start();
  }
  
  public static void a(Activity paramActivity, WebView paramWebView, String paramString)
  {
    new Thread(new b(paramActivity, paramWebView, paramString)).start();
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    a.a(paramWebView, String.format(Locale.US, "(G_resizeIframe(%s))", new Object[] { paramString }));
  }
  
  public static void a(WebView paramWebView, boolean paramBoolean)
  {
    a.a(paramWebView, String.format(Locale.US, "(G_updatePlusOne(%b))", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    return a(paramContext, paramLong, PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext()));
  }
  
  static boolean a(Context paramContext, long paramLong, SharedPreferences paramSharedPreferences)
  {
    return (ah.a(paramContext)) && ((!paramSharedPreferences.contains("drt")) || (!paramSharedPreferences.contains("drt_ts")) || (paramSharedPreferences.getLong("drt_ts", 0L) < new Date().getTime() - paramLong));
  }
  
  private static class a
    implements Runnable
  {
    private final WeakReference<Activity> a;
    private final SharedPreferences.Editor b;
    
    public a(Activity paramActivity)
    {
      this(paramActivity, null);
    }
    
    a(Activity paramActivity, SharedPreferences.Editor paramEditor)
    {
      this.a = new WeakReference(paramActivity);
      this.b = paramEditor;
    }
    
    private SharedPreferences.Editor a(Activity paramActivity)
    {
      if (this.b == null) {
        return PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).edit();
      }
      return this.b;
    }
    
    public void run()
    {
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject3 = (Activity)this.a.get();
          if (localObject3 == null)
          {
            b.a("Activity was null while making a doritos cookie request.");
            return;
          }
          Object localObject1 = ((Activity)localObject3).getContentResolver().query(af.b, af.d, null, null, null);
          if ((localObject1 != null) && (((Cursor)localObject1).moveToFirst()) && (((Cursor)localObject1).getColumnNames().length > 0))
          {
            localObject1 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex(((Cursor)localObject1).getColumnName(0)));
            localObject3 = a((Activity)localObject3);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label149;
            }
            ((SharedPreferences.Editor)localObject3).putString("drt", (String)localObject1);
            ((SharedPreferences.Editor)localObject3).putLong("drt_ts", new Date().getTime());
            ((SharedPreferences.Editor)localObject3).commit();
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          b.b("An unknown error occurred while sending a doritos request.", localThrowable);
          return;
        }
        b.a("Google+ app not installed, not storing doritos cookie");
        Object localObject2 = null;
        continue;
        label149:
        ((SharedPreferences.Editor)localObject3).putString("drt", "");
        ((SharedPreferences.Editor)localObject3).putLong("drt_ts", 0L);
      }
    }
  }
  
  private static class b
    implements Runnable
  {
    private final WeakReference<Activity> a;
    private final WebView b;
    private final String c;
    
    public b(Activity paramActivity, WebView paramWebView, String paramString)
    {
      this.a = new WeakReference(paramActivity);
      this.c = paramString;
      this.b = paramWebView;
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          Object localObject = Uri.withAppendedPath(af.a, this.c);
          Activity localActivity = (Activity)this.a.get();
          if (localActivity == null)
          {
            b.a("Activity was null while getting the +1 button state.");
            return;
          }
          localObject = localActivity.getContentResolver().query((Uri)localObject, af.c, null, null, null);
          if ((localObject == null) || (!((Cursor)localObject).moveToFirst())) {
            break label114;
          }
          if (((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("has_plus1")) == 1)
          {
            bool = true;
            this.b.post(new ag.c(this.b, bool));
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          b.b("An unknown error occurred while updating the +1 state.", localThrowable);
          return;
        }
        boolean bool = false;
        continue;
        label114:
        b.a("Google+ app not installed, showing ad as not +1'd");
        bool = false;
      }
    }
  }
  
  static class c
    implements Runnable
  {
    private final boolean a;
    private final WebView b;
    
    public c(WebView paramWebView, boolean paramBoolean)
    {
      this.b = paramWebView;
      this.a = paramBoolean;
    }
    
    public void run()
    {
      ag.a(this.b, this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */