package com.atomic.apps.ringtone.cutter;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import com.atomic.apps.ringtone.a.h;
import com.atomic.apps.ringtone.a.j;
import java.io.File;

final class z
  extends Thread
{
  z(RingtoneEditActivity paramRingtoneEditActivity, j paramj) {}
  
  public final void run()
  {
    Object localObject2;
    try
    {
      RingtoneEditActivity.a(this.a, h.a(RingtoneEditActivity.z(this.a).getAbsolutePath(), this.b));
      if (RingtoneEditActivity.A(this.a) == null)
      {
        RingtoneEditActivity.x(this.a).dismiss();
        Object localObject1 = RingtoneEditActivity.z(this.a).getName().toLowerCase().split("\\.");
        if (localObject1.length < 2) {}
        for (localObject1 = this.a.getResources().getString(2130968681);; localObject1 = this.a.getResources().getString(2130968680) + " " + localObject1[(localObject1.length - 1)])
        {
          localObject1 = new A(this, (String)localObject1);
          RingtoneEditActivity.g(this.a).post((Runnable)localObject1);
          return;
        }
      }
      RingtoneEditActivity.x(this.a).dismiss();
    }
    catch (Exception localException)
    {
      RingtoneEditActivity.x(this.a).dismiss();
      localException.printStackTrace();
      RingtoneEditActivity.B(this.a).setText(localException.toString());
      localObject2 = new B(this, localException);
      RingtoneEditActivity.g(this.a).post((Runnable)localObject2);
      return;
    }
    if (RingtoneEditActivity.y(this.a))
    {
      localObject2 = new C(this);
      RingtoneEditActivity.g(this.a).post((Runnable)localObject2);
      return;
    }
    this.a.a(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */