package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.atomic.apps.ringtone.cutter.aa;
import com.atomic.apps.ringtone.cutter.h;
import com.google.a.a.a;
import com.google.android.gms.ads.b.b;
import java.util.Map;

public final class ag
  extends aj
{
  private Map a;
  private Map b;
  
  private am b(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString, false, ag.class.getClassLoader());
      if (a.class.isAssignableFrom((Class)localObject))
      {
        localObject = (a)((Class)localObject).newInstance();
        return new at((a)localObject, (h)this.a.get(((a)localObject).b()));
      }
      if (b.class.isAssignableFrom((Class)localObject)) {
        return new as((b)((Class)localObject).newInstance(), (Bundle)this.b.get(localObject));
      }
      aa.e("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable)
    {
      aa.e("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
  }
  
  public final am a(String paramString)
  {
    return b(paramString);
  }
  
  public final void a(Map paramMap)
  {
    this.a = paramMap;
  }
  
  public final void b(Map paramMap)
  {
    this.b = paramMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */