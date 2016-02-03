package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.activity.ba;
import com.ideashower.readitlater.util.j;
import com.pocket.d.h;

class ah
  extends al
{
  private final com.ideashower.readitlater.db.operation.f b;
  private int c;
  
  public ah(ad paramad, int paramInt)
  {
    super(paramad, null);
    this.b = o.c().b(paramInt);
    this.e = this.b.h();
    this.f = this.b.l();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Drawable b()
  {
    Bitmap localBitmap;
    if (this.d == null)
    {
      localBitmap = com.ideashower.readitlater.db.operation.f.a(this.b, (int)this.a.getResources().getDimension(2131296379) - j.a(3.0F), true);
      if (localBitmap == null) {
        break label63;
      }
    }
    label63:
    for (this.d = new BitmapDrawable(this.a.getResources(), localBitmap);; this.d = new h(com.ideashower.readitlater.db.operation.f.f(), this.a.getResources())) {
      return this.d;
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    this.b.a(System.currentTimeMillis());
    ba.a((android.support.v4.app.f)this.a.getContext(), ad.c(this.a), ad.f(this.a), this.b.a());
  }
  
  public String e()
  {
    return this.a.getContext().getString(2131493475) + " recent " + this.c;
  }
  
  public boolean f()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */