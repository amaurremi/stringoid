package com.pocket.l.a;

import android.graphics.Bitmap;
import android.media.RemoteControlClient.MetadataEditor;
import com.ideashower.readitlater.a.x;
import com.ideashower.readitlater.f.e;
import com.ideashower.readitlater.f.f;
import com.ideashower.readitlater.f.g;
import com.ideashower.readitlater.util.j;
import com.pocket.m.a.a;
import com.pocket.m.a.k;

public class d
  extends b
  implements g
{
  private final RemoteControlClient.MetadataEditor c;
  private String d;
  
  public d(c paramc, RemoteControlClient.MetadataEditor paramMetadataEditor)
  {
    super(paramc);
    this.c = paramMetadataEditor;
  }
  
  private void a(String paramString, int paramInt)
  {
    paramString = f.a(paramString, new com.pocket.k.d(paramInt, paramInt), com.pocket.m.a.d.a()).a(true, k.a).a(this, true, true).a();
    com.ideashower.readitlater.util.a.b localb = x.a(paramString);
    if (localb != null) {
      a(paramString, localb);
    }
  }
  
  public b a(Bitmap paramBitmap)
  {
    this.c.putBitmap(100, paramBitmap);
    return this;
  }
  
  public b a(String paramString)
  {
    this.c.putString(1, paramString);
    return this;
  }
  
  public void a()
  {
    this.c.apply();
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
    if (localb != null)
    {
      paramb = localb.b().copy(localb.b().getConfig(), false);
      this.b.a(false).a(paramb).a();
      localb.b(false);
    }
    parame.m();
  }
  
  public boolean a(e parame)
  {
    return (c.a(this.b) == this) && (this.d.equals(parame.f().e()));
  }
  
  public b b(String paramString)
  {
    this.c.putString(2, paramString);
    return this;
  }
  
  public b c(String paramString)
  {
    this.c.putString(7, paramString);
    return this;
  }
  
  public b d(String paramString)
  {
    if (paramString != this.d)
    {
      this.d = paramString;
      if (paramString != null) {
        a(paramString, j.a(300.0F));
      }
    }
    else
    {
      return this;
    }
    this.b.a(false).a(null).a();
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/l/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */