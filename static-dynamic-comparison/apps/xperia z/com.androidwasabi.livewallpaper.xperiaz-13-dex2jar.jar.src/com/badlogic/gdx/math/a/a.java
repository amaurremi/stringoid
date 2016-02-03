package com.badlogic.gdx.math.a;

import com.badlogic.gdx.math.g;
import java.io.Serializable;

public class a
  implements Serializable
{
  static g c = new g();
  public final g a = new g();
  public final g b = new g();
  
  public a(g paramg1, g paramg2)
  {
    this.a.a(paramg1);
    this.b.a(paramg2).d();
  }
  
  public String toString()
  {
    return "ray [" + this.a + ":" + this.b + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */