package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.a;

public final class aa
  extends u
{
  public final int b;
  public final Bundle c;
  public final IBinder d;
  
  public aa(s params, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(params, Boolean.valueOf(true));
    this.b = paramInt;
    this.d = paramIBinder;
    this.c = paramBundle;
  }
  
  protected void a() {}
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    switch (this.b)
    {
    default: 
      if (this.c == null) {
        break;
      }
    }
    for (paramBoolean = (PendingIntent)this.c.getParcelable("pendingIntent");; paramBoolean = null)
    {
      if (s.e(this.e) != null)
      {
        ab.a(s.f(this.e)).b(this.e.a(), s.e(this.e));
        s.a(this.e, null);
      }
      s.a(this.e, null);
      this.e.a(new a(this.b, paramBoolean));
      return;
      try
      {
        paramBoolean = this.d.getInterfaceDescriptor();
        if (this.e.b().equals(paramBoolean))
        {
          s.a(this.e, this.e.a(this.d));
          if (s.d(this.e) != null)
          {
            this.e.h();
            return;
          }
        }
      }
      catch (RemoteException paramBoolean)
      {
        ab.a(s.f(this.e)).b(this.e.a(), s.e(this.e));
        s.a(this.e, null);
        s.a(this.e, null);
        this.e.a(new a(8, null));
        return;
      }
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */