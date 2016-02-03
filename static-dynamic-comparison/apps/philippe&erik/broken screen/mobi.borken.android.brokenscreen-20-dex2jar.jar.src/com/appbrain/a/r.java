package com.appbrain.a;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cmn.af;
import com.appbrain.AppBrainService;
import com.appbrain.b.i;
import com.appbrain.e.j.i;

public class r
{
  private static final String a = r.class.getName();
  private static final String b = a + ".Alert";
  
  static void a(Activity paramActivity, j.i parami)
  {
    Object localObject;
    String str1;
    if (parami.o())
    {
      localObject = new Intent(paramActivity, AppBrainService.class);
      ((Intent)localObject).putExtra(b, parami.b());
      localObject = PendingIntent.getService(paramActivity, parami.h(), (Intent)localObject, 0);
      if (TextUtils.isEmpty(parami.n())) {
        break label196;
      }
      str1 = parami.n();
      label56:
      if (TextUtils.isEmpty(parami.n())) {
        break label204;
      }
    }
    label196:
    label204:
    for (String str2 = parami.n();; str2 = paramActivity.getPackageManager().getApplicationLabel(paramActivity.getApplicationInfo()).toString())
    {
      Notification localNotification = new Notification();
      localNotification.tickerText = str1;
      localNotification.icon = paramActivity.getApplicationInfo().icon;
      localNotification.flags = 16;
      localNotification.defaults &= 0xFFFFFFFD;
      localNotification.setLatestEventInfo(paramActivity, str2, parami.j(), (PendingIntent)localObject);
      ((NotificationManager)paramActivity.getSystemService("notification")).notify(a, parami.h(), localNotification);
      t.a(false);
      return;
      localObject = a.c(paramActivity);
      ((Intent)localObject).putExtra("aa", parami.b());
      ((Intent)localObject).putExtra("fn", true);
      localObject = PendingIntent.getActivity(paramActivity, parami.h(), (Intent)localObject, 0);
      break;
      str1 = parami.j();
      break label56;
    }
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (!paramIntent.hasExtra(b)) {
      return false;
    }
    try
    {
      paramIntent = j.i.a(paramIntent.getByteArrayExtra(b));
      af.a(new s(paramContext, paramIntent));
      return true;
    }
    catch (i paramContext) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */