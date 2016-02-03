package com.ideashower.readitlater.activity.a;

import android.os.Bundle;
import android.support.v4.app.f;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a;
import com.pocket.p.k;

public abstract class e
  extends o
{
  protected abstract boolean L();
  
  public void N()
  {
    a(null);
  }
  
  protected boolean O()
  {
    return true;
  }
  
  public void a(Bundle paramBundle)
  {
    boolean bool = true;
    super.a(paramBundle);
    e(true);
    if (paramBundle != null) {}
    for (;;)
    {
      this.ab = bool;
      if (this.ab)
      {
        this.ac = paramBundle.getBoolean("stateShouldPersist");
        if (!this.ac)
        {
          c(false);
          a();
        }
      }
      return;
      bool = false;
    }
  }
  
  public void a(final f paramf)
  {
    if ((b_()) && (L())) {}
    do
    {
      return;
      if ((paramf != null) && (!paramf.isFinishing()))
      {
        e(true);
        k.a(this, paramf, k(), false);
        return;
      }
      paramf = g.n();
    } while (paramf == null);
    g.a(new Runnable()
    {
      public void run()
      {
        e.this.e(true);
        k.a(e.this, paramf, e.this.k(), false);
      }
    });
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, g.a(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    if (paramString1 != null) {
      localBundle.putString("title", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("message", paramString2);
    }
    g(l(localBundle));
  }
  
  protected void b(int paramInt, String paramString)
  {
    a(g.a(paramInt), paramString);
  }
  
  protected boolean b_()
  {
    return false;
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    a(g.a(paramInt1), g.a(paramInt2));
  }
  
  protected abstract void e(boolean paramBoolean);
  
  protected void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    e(false);
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    return paramBundle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */