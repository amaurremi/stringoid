package cmn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public final class ae
  extends BroadcastReceiver
{
  public static String a(SharedPreferences paramSharedPreferences)
  {
    return paramSharedPreferences.getString("cmn.refkey", null);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("referrer");
    if (paramIntent == null) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("cmn.refkey", paramIntent);
    a.a().a(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */