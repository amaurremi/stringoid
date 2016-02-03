package com.pocket.billing.google;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.u;
import java.util.ArrayList;
import org.apache.a.a.a.d;

public abstract class a
{
  public static final c a;
  private static final boolean b = e.a(false);
  private static final c c = new c("subs", "pocket.premium.1month", "pocket.premium.1year", null);
  private static final c d = new c("inapp", "pocket.test.1mo", "pocket.test.1yr", null);
  private static Object e;
  private static String f;
  
  static
  {
    if (b) {}
    for (Object localObject = d;; localObject = c)
    {
      a = (c)localObject;
      e = new String[] { "od", "l", "G", " U", "R", "cr", "ie", "it", "ae", "hu", "f", "zi", "t", " R", " ", "sh", " c", ".", "s.", "la", "es", "nu" };
      localObject = u.a();
      f = ((String[])(String[])e)[2] + ((String[])(String[])e)[0] + ((String[])(String[])e)[11] + "lla" + ((String[])(String[])e)[14] + ((String[])(String[])e)[5] + "ush" + ((String[])(String[])e)[20] + ((String[])(String[])e)[16] + ((String[])(String[])e)[7] + ((String[])(String[])e)[6] + ((String[])(String[])e)[18] + ((String[])(String[])e)[13] + "un" + ".";
      u.a((StringBuilder)localObject);
      return;
    }
  }
  
  protected static int a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null) {
      return 0;
    }
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof Long)) {
      return (int)((Long)paramIntent).longValue();
    }
    return -1;
  }
  
  protected static int a(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null) {
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    if ((paramBundle instanceof Long)) {
      return (int)((Long)paramBundle).longValue();
    }
    return -1;
  }
  
  public static Intent a(Context paramContext)
  {
    return new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
  }
  
  public static Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("ITEM_ID_LIST", new ArrayList(c.a(a)));
    return localBundle;
  }
  
  public static String b()
  {
    return new String(d.a(org.apache.a.a.b.a.a((f + "::" + as.i()).getBytes())));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/google/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */