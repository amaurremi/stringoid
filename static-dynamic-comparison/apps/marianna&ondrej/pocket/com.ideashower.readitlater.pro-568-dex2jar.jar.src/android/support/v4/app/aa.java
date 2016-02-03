package android.support.v4.app;

import android.app.Notification;

class aa
  implements z
{
  public Notification a(x paramx)
  {
    Notification localNotification = paramx.r;
    localNotification.setLatestEventInfo(paramx.a, paramx.b, paramx.c, paramx.d);
    if (paramx.j > 0) {
      localNotification.flags |= 0x80;
    }
    return localNotification;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */