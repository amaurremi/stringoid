package com.atomic.apps.ringtone.cutter;

import android.app.ProgressDialog;
import com.atomic.apps.ringtone.a.j;

final class w
  implements j
{
  w(RingtoneEditActivity paramRingtoneEditActivity) {}
  
  public final boolean a(double paramDouble)
  {
    long l = System.currentTimeMillis();
    if (l - RingtoneEditActivity.w(this.a) > 100L)
    {
      RingtoneEditActivity.x(this.a).setProgress((int)(RingtoneEditActivity.x(this.a).getMax() * paramDouble));
      RingtoneEditActivity.a(this.a, l);
    }
    return RingtoneEditActivity.y(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */