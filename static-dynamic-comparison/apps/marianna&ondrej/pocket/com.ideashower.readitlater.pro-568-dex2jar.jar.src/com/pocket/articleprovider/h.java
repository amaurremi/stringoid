package com.pocket.articleprovider;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.ideashower.readitlater.a.x;
import com.ideashower.readitlater.f.e;
import com.ideashower.readitlater.f.g;
import com.ideashower.readitlater.util.a.b;
import org.apache.a.b.d;

class h
  implements g
{
  private h(f paramf) {}
  
  public void a(e parame, b paramb)
  {
    byte[] arrayOfByte = null;
    int i = 100;
    if (f.c(this.a) == null)
    {
      if (paramb != null) {
        paramb.b(false);
      }
      parame.m();
      return;
    }
    if (parame.j() != null) {
      i = parame.j().getInt("quality", 100);
    }
    if ((paramb != null) && (paramb.c())) {}
    for (Bitmap localBitmap = paramb.b();; localBitmap = null)
    {
      if (localBitmap != null)
      {
        org.apache.a.b.a.a locala = new org.apache.a.b.a.a();
        localBitmap.compress(Bitmap.CompressFormat.JPEG, i, locala);
        arrayOfByte = locala.b();
        d.a(locala);
      }
      if (paramb != null) {
        paramb.b(false);
      }
      f.a(this.a).a(parame.f().e(), parame.i().a(), parame.i().b(), parame.d(), i, arrayOfByte);
      parame.m();
      return;
    }
  }
  
  public boolean a(e parame)
  {
    return f.c(this.a) != null;
  }
  
  public void b(e parame)
  {
    b localb = x.a(parame);
    if (localb != null) {
      a(parame, localb);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */