package com.atomic.apps.ringtone.cutter;

import android.os.Handler;
import android.widget.TextView;

final class q
  implements Runnable
{
  q(RingtoneEditActivity paramRingtoneEditActivity) {}
  
  public final void run()
  {
    if ((RingtoneEditActivity.a(this.a) != RingtoneEditActivity.b(this.a)) && (!RingtoneEditActivity.c(this.a).hasFocus()))
    {
      RingtoneEditActivity.c(this.a).setText(RingtoneEditActivity.a(this.a, RingtoneEditActivity.a(this.a)));
      RingtoneEditActivity.b(this.a, RingtoneEditActivity.a(this.a));
    }
    if ((RingtoneEditActivity.d(this.a) != RingtoneEditActivity.e(this.a)) && (!RingtoneEditActivity.f(this.a).hasFocus()))
    {
      RingtoneEditActivity.f(this.a).setText(RingtoneEditActivity.a(this.a, RingtoneEditActivity.d(this.a)));
      RingtoneEditActivity.c(this.a, RingtoneEditActivity.d(this.a));
    }
    RingtoneEditActivity.g(this.a).postDelayed(RingtoneEditActivity.h(this.a), 100L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */