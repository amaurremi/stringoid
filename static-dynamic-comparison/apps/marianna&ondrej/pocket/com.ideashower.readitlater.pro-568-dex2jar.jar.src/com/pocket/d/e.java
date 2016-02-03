package com.pocket.d;

import android.content.Context;
import android.os.Bundle;
import com.ideashower.readitlater.a.x;
import com.pocket.m.a.a;
import com.pocket.m.a.d;
import com.pocket.m.a.k;
import com.pocket.m.a.l;
import java.io.File;

public abstract class e
  extends c
{
  private a i;
  private final b j;
  
  public e(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    this.j = paramb;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.i = a.a(paramBundle.getString("url"), 1, l.c());
      a(x.b(com.ideashower.readitlater.f.f.a(this.i, m(), d.a()).a(1).a()));
    }
  }
  
  protected void a(String paramString)
  {
    this.i = a.a(paramString, 1, l.c());
    a(com.ideashower.readitlater.f.f.a(this.i, m(), d.a()).a(1).a(true, k.a).a(this.g, true, true).a());
  }
  
  public void f()
  {
    if (this.j != null) {
      this.j.c(this);
    }
    new f(this, null).h();
  }
  
  public File n()
  {
    if ((this.f != null) && (this.i != null)) {
      return new File(this.i.c());
    }
    return null;
  }
  
  public Bundle p()
  {
    if (this.i != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", this.i.e());
      return localBundle;
    }
    return null;
  }
  
  protected abstract String r();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */