package com.pocket.tts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.ideashower.readitlater.a.x;
import com.ideashower.readitlater.f.e;
import com.ideashower.readitlater.f.f;
import com.ideashower.readitlater.f.g;
import com.pocket.i.a.i;
import com.pocket.m.a.a;

public class l
  extends com.pocket.l.a.b
  implements g
{
  private String c;
  private String d;
  private String e;
  private String f;
  private com.ideashower.readitlater.util.a.b g;
  private com.ideashower.readitlater.util.a.b h;
  
  public l(k paramk)
  {
    super(paramk);
  }
  
  private Bitmap a(int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap).drawColor(i.c);
    return localBitmap;
  }
  
  private void a(String paramString, int paramInt)
  {
    paramString = f.a(paramString, new com.pocket.k.d(paramInt, paramInt), com.pocket.m.a.d.a()).a(true, com.pocket.m.a.k.a).a(paramInt).a(this, true, true).a();
    com.ideashower.readitlater.util.a.b localb = x.a(paramString);
    if (localb != null) {
      a(paramString, localb);
    }
  }
  
  private Bitmap b()
  {
    if (this.h != null) {
      return this.h.b();
    }
    return e();
  }
  
  private Bitmap c()
  {
    if (this.g != null) {
      return this.g.b();
    }
    return d();
  }
  
  private Bitmap d()
  {
    if (this.b.a == null) {
      this.b.a = a(k.h());
    }
    return this.b.a;
  }
  
  private Bitmap e()
  {
    if (this.b.b == null) {
      this.b.b = a(k.f());
    }
    return this.b.b;
  }
  
  public com.pocket.l.a.b a(Bitmap paramBitmap)
  {
    return this;
  }
  
  public com.pocket.l.a.b a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void a()
  {
    k.c(this.b);
  }
  
  public void a(e parame, com.ideashower.readitlater.util.a.b paramb)
  {
    com.ideashower.readitlater.util.a.b localb = paramb;
    if (paramb != null)
    {
      localb = paramb;
      if (!paramb.c())
      {
        paramb.b(false);
        localb = null;
      }
    }
    if (parame.d() == k.h())
    {
      this.g = localb;
      k.c(this.b);
    }
    for (;;)
    {
      parame.m();
      return;
      if (parame.d() == k.f())
      {
        this.h = localb;
        k.c(this.b);
      }
    }
  }
  
  public boolean a(e parame)
  {
    return (k.b(this.b) == this) && (this.f.equals(parame.f().e()));
  }
  
  public com.pocket.l.a.b b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public com.pocket.l.a.b c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public com.pocket.l.a.b d(String paramString)
  {
    if (paramString != this.f)
    {
      this.f = paramString;
      if (paramString == null) {
        break label41;
      }
      a(paramString, k.f());
      if (k.g()) {
        a(paramString, k.h());
      }
    }
    return this;
    label41:
    this.h = null;
    this.g = null;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */