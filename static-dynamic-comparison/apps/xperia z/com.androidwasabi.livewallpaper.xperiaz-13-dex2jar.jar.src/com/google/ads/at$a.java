package com.google.ads;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.util.b;
import java.lang.ref.WeakReference;
import java.util.Date;

class at$a
  implements Runnable
{
  private final WeakReference<Activity> a;
  private final SharedPreferences.Editor b;
  
  public at$a(Activity paramActivity)
  {
    this(paramActivity, null);
  }
  
  at$a(Activity paramActivity, SharedPreferences.Editor paramEditor)
  {
    this.a = new WeakReference(paramActivity);
    this.b = paramEditor;
  }
  
  private SharedPreferences.Editor a(Context paramContext)
  {
    if (this.b == null) {
      return PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext()).edit();
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
        Object localObject1 = ((Activity)localObject3).getContentResolver().query(as.a, as.b, null, null, null);
        if ((localObject1 != null) && (((Cursor)localObject1).moveToFirst()) && (((Cursor)localObject1).getColumnNames().length > 0))
        {
          localObject1 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex(((Cursor)localObject1).getColumnName(0)));
          localObject3 = a((Context)localObject3);
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
        b.d("An unknown error occurred while sending a doritos request.", localThrowable);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/at$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */