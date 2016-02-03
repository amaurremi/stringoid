package com.atomic.apps.ringtone.cutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class v
  implements DialogInterface.OnCancelListener
{
  v(RingtoneEditActivity paramRingtoneEditActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    RingtoneEditActivity.a(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */