package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.f;
import com.ideashower.readitlater.activity.ba;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.objects.e;

class ae
  extends al
{
  private final int b;
  
  public ae(ad paramad, int paramInt)
  {
    super(paramad, null);
    this.b = paramInt;
    switch (paramInt)
    {
    default: 
      this.d = null;
      this.e = null;
    }
    for (;;)
    {
      this.f = ad.b(paramInt);
      return;
      this.d = paramad.getResources().getDrawable(2130837692);
      this.e = paramad.getContext().getString(2131493453);
      continue;
      this.d = paramad.getResources().getDrawable(2130837693);
      this.e = paramad.getContext().getString(2131493475);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Drawable b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    ad.a(this.b);
    switch (this.b)
    {
    default: 
      return;
    case 1: 
      e.a(this.a.getContext()).a(ad.e(this.a), this.a.getContext().getString(2131493515));
      i.b().a(a.ba, ad.e(this.a).hashCode()).a();
      return;
    }
    ba.a((f)this.a.getContext(), ad.c(this.a), ad.f(this.a));
  }
  
  public String e()
  {
    return j();
  }
  
  public boolean f()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */