package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.internal.hm;

public abstract class a$b<R extends Result, A extends Api.a>
  extends a.a<R>
  implements g<A>
{
  private final Api.c<A> Dn;
  private e Dy;
  
  protected a$b(Api.c<A> paramc)
  {
    this.Dn = ((Api.c)hm.f(paramc));
  }
  
  private void a(RemoteException paramRemoteException)
  {
    m(new Status(8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  protected abstract void a(A paramA);
  
  public void a(e parame)
  {
    this.Dy = parame;
  }
  
  public final void b(A paramA)
  {
    a(new a.c(paramA.getLooper()));
    try
    {
      a(paramA);
      return;
    }
    catch (DeadObjectException paramA)
    {
      a(paramA);
      throw paramA;
    }
    catch (RemoteException paramA)
    {
      a(paramA);
    }
  }
  
  public final Api.c<A> eB()
  {
    return this.Dn;
  }
  
  protected void eD()
  {
    super.eD();
    if (this.Dy != null)
    {
      this.Dy.a(this);
      this.Dy = null;
    }
  }
  
  public int eG()
  {
    return 0;
  }
  
  public final void m(Status paramStatus)
  {
    if (!paramStatus.isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      hm.b(bool, "Failed result must not be success");
      b(c(paramStatus));
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/a$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */