package com.atomic.apps.ringtone.cutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;

final class ag
  implements DialogInterface.OnClickListener
{
  ag(SplashActivity paramSplashActivity, SharedPreferences.Editor paramEditor) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.putBoolean("shownever", true);
    this.b.commit();
    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + this.a.getPackageName())));
    this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */