package com.ideashower.readitlater.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.ideashower.readitlater.a.am;
import com.ideashower.readitlater.a.ap;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.pocket.c.e;

public abstract class b
  extends a
{
  public b(String paramString)
  {
    super(paramString);
  }
  
  private static PendingIntent a(Context paramContext, int paramInt)
  {
    return PendingIntent.getBroadcast(paramContext, paramInt, new Intent(paramContext, OnAlarmReceiver.class), 134217728);
  }
  
  public static void a(Context paramContext)
  {
    long l;
    switch (i.a(com.ideashower.readitlater.h.a.J))
    {
    default: 
      b(paramContext);
      return;
    case 3: 
      l = 86400000L;
    }
    for (;;)
    {
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      a(paramContext, localAlarmManager);
      localAlarmManager.setInexactRepeating(0, System.currentTimeMillis() + l, l, a(paramContext, 1));
      return;
      l = 43200000L;
      continue;
      l = 3600000L;
    }
  }
  
  public static void a(Context paramContext, AlarmManager paramAlarmManager)
  {
    paramAlarmManager.cancel(a(paramContext, 1));
    paramAlarmManager.cancel(a(paramContext, 2));
  }
  
  public static void a(Context paramContext, UiTrigger paramUiTrigger)
  {
    if (g.d()) {}
    for (int i = 4;; i = 1)
    {
      a(paramContext, i, paramUiTrigger);
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt, UiTrigger paramUiTrigger)
  {
    if ((g.d()) && (a(paramInt))) {
      return false;
    }
    i.b().a(com.ideashower.readitlater.h.a.J, paramInt).a();
    if (paramInt != 0)
    {
      ap localap = am.c();
      if (localap != null) {
        localap.a(paramContext, paramUiTrigger);
      }
    }
    if ((paramInt == 0) || (paramInt == 4)) {
      b(paramContext);
    }
    for (;;)
    {
      return true;
      a(paramContext);
    }
  }
  
  public static void b(Context paramContext)
  {
    a(paramContext, (AlarmManager)paramContext.getSystemService("alarm"));
  }
  
  public static boolean b()
  {
    return i.a(com.ideashower.readitlater.h.a.J) == 0;
  }
  
  public static boolean c()
  {
    return a(i.a(com.ideashower.readitlater.h.a.J));
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (!as.l()) {
      return;
    }
    com.pocket.m.a.l();
    e.a(2, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */