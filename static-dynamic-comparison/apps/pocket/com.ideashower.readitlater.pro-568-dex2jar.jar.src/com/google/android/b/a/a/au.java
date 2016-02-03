package com.google.android.b.a.a;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.b.a.c;
import com.google.android.b.a.e;
import com.google.android.b.a.g;
import com.google.android.b.a.h;

public final class au
  implements c
{
  private f a;
  private j b;
  
  public au(f paramf, j paramj)
  {
    this.a = ((f)d.a(paramf, "connectionClient cannot be null"));
    this.b = ((j)d.a(paramj, "embeddedPlayer cannot be null"));
  }
  
  public final void a()
  {
    b(true);
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.b.d(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void a(Configuration paramConfiguration)
  {
    try
    {
      this.b.a(paramConfiguration);
      return;
    }
    catch (RemoteException paramConfiguration)
    {
      throw new an(paramConfiguration);
    }
  }
  
  public final void a(final e parame)
  {
    try
    {
      this.b.a(new n()
      {
        public final void a(boolean paramAnonymousBoolean)
        {
          parame.a(paramAnonymousBoolean);
        }
      });
      return;
    }
    catch (RemoteException parame)
    {
      throw new an(parame);
    }
  }
  
  public final void a(final g paramg)
  {
    try
    {
      this.b.a(new q()
      {
        public final void a()
        {
          paramg.a();
        }
        
        public final void a(int paramAnonymousInt)
        {
          paramg.a(paramAnonymousInt);
        }
        
        public final void a(boolean paramAnonymousBoolean)
        {
          paramg.b(paramAnonymousBoolean);
        }
        
        public final void b()
        {
          paramg.b();
        }
        
        public final void c()
        {
          paramg.c();
        }
      });
      return;
    }
    catch (RemoteException paramg)
    {
      throw new an(paramg);
    }
  }
  
  public final void a(final h paramh)
  {
    try
    {
      this.b.a(new t()
      {
        public final void a()
        {
          paramh.d();
        }
        
        public final void a(String paramAnonymousString)
        {
          paramh.a(paramAnonymousString);
        }
        
        public final void b()
        {
          paramh.e();
        }
        
        public final void b(String paramAnonymousString)
        {
          try
          {
            paramAnonymousString = com.google.android.b.a.d.valueOf(paramAnonymousString);
            paramh.a(paramAnonymousString);
            return;
          }
          catch (IllegalArgumentException paramAnonymousString)
          {
            for (;;)
            {
              paramAnonymousString = com.google.android.b.a.d.m;
            }
          }
          catch (NullPointerException paramAnonymousString)
          {
            for (;;)
            {
              paramAnonymousString = com.google.android.b.a.d.m;
            }
          }
        }
        
        public final void c()
        {
          paramh.f();
        }
        
        public final void d()
        {
          paramh.g();
        }
      });
      return;
    }
    catch (RemoteException paramh)
    {
      throw new an(paramh);
    }
  }
  
  public final void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      this.b.b(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new an(paramString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.b.b(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    try
    {
      boolean bool = this.b.a(paramInt, paramKeyEvent);
      return bool;
    }
    catch (RemoteException paramKeyEvent)
    {
      throw new an(paramKeyEvent);
    }
  }
  
  public final boolean a(Bundle paramBundle)
  {
    try
    {
      boolean bool = this.b.a(paramBundle);
      return bool;
    }
    catch (RemoteException paramBundle)
    {
      throw new an(paramBundle);
    }
  }
  
  public final void b()
  {
    try
    {
      this.b.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      this.b.a(paramBoolean);
      this.a.a(paramBoolean);
      this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    try
    {
      boolean bool = this.b.b(paramInt, paramKeyEvent);
      return bool;
    }
    catch (RemoteException paramKeyEvent)
    {
      throw new an(paramKeyEvent);
    }
  }
  
  public final void c()
  {
    try
    {
      this.b.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    try
    {
      this.b.e(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final boolean d()
  {
    try
    {
      boolean bool = this.b.c();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final View e()
  {
    try
    {
      View localView = (View)bb.a(this.b.s());
      return localView;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void f()
  {
    try
    {
      this.b.m();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void g()
  {
    try
    {
      this.b.n();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void h()
  {
    try
    {
      this.b.o();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void i()
  {
    try
    {
      this.b.p();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void j()
  {
    try
    {
      this.b.q();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final void k()
  {
    try
    {
      this.b.l();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
  
  public final Bundle l()
  {
    try
    {
      Bundle localBundle = this.b.r();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      throw new an(localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */