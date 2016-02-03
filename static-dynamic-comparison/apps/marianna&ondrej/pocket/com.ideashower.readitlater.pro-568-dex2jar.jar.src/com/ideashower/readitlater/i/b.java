package com.ideashower.readitlater.i;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import com.ideashower.readitlater.a.g;

@TargetApi(14)
public class b
  extends a
{
  public Notification a(int paramInt1, int paramInt2)
  {
    return c(paramInt1, paramInt2).getNotification();
  }
  
  protected void a(Notification.Builder paramBuilder)
  {
    paramBuilder.setContentText(f).setContentIntent(b).setAutoCancel(true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a = a(paramInt1, paramInt2);
  }
  
  protected Notification.Builder c(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    c.setLength(0);
    Object localObject = String.format(e, new Object[] { Integer.valueOf(paramInt2 - paramInt1) });
    c.append((String)localObject);
    localObject = new Notification.Builder(g.c()).setTicker(d).setContentTitle(c.toString()).setSmallIcon(2130837694).setWhen(h).setOngoing(true).setOnlyAlertOnce(true);
    int i;
    if (!a(false))
    {
      i = paramInt2;
      if (paramInt2 < 0) {
        i = 0;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = 0;
      }
      if (paramInt2 != 0) {
        break label132;
      }
    }
    for (;;)
    {
      ((Notification.Builder)localObject).setProgress(i, paramInt2, bool);
      a((Notification.Builder)localObject);
      return (Notification.Builder)localObject;
      label132:
      bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */