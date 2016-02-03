package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.b;
import com.google.ads.mediation.g;
import com.google.android.gms.ads.b.a;
import java.util.Map;

public final class ah
  extends ai.a
{
  private Map<Class<? extends a>, a> Co;
  
  private <NETWORK_EXTRAS extends g, SERVER_PARAMETERS extends MediationServerParameters> aj aB(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString, false, ah.class.getClassLoader());
      if (!b.class.isAssignableFrom(localClass))
      {
        ce.D("Could not instantiate mediation adapter: " + paramString + ".");
        throw new RemoteException();
      }
    }
    catch (Throwable localThrowable)
    {
      ce.D("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
    Object localObject = (b)localThrowable.newInstance();
    localObject = new al((b)localObject, (g)this.Co.get(((b)localObject).fs()));
    return (aj)localObject;
  }
  
  public aj aA(String paramString)
  {
    return aB(paramString);
  }
  
  public void r(Map<Class<? extends a>, a> paramMap)
  {
    this.Co = paramMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */