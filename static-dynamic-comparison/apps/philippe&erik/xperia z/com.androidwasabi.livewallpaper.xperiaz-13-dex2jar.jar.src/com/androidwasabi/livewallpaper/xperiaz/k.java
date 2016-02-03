package com.androidwasabi.livewallpaper.xperiaz;

import android.graphics.Color;
import com.badlogic.gdx.graphics.g2d.b;
import com.badlogic.gdx.math.e;
import com.badlogic.gdx.math.f;

public class k
  extends com.androidwasabi.a.a
{
  public final f g;
  float h = 1.0F;
  float i = 1.0F;
  float j = 1.0F;
  boolean k = false;
  float l = 1.0F;
  float m = 1.0F;
  float n = 1.0F;
  float o = 0.0F;
  float p = 0.0F;
  float q = 0.0F;
  float r = 0.0F;
  
  public k(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.g = new f(paramFloat1, paramFloat2);
  }
  
  public void a()
  {
    f localf = this.c;
    localf.d += (this.g.d - this.c.d) * 0.1F;
  }
  
  public void a(int paramInt)
  {
    this.h = (Color.red(paramInt) / 255.0F);
    this.i = (Color.green(paramInt) / 255.0F);
    this.j = (Color.blue(paramInt) / 255.0F);
  }
  
  public void a(com.badlogic.gdx.graphics.g2d.a parama, b paramb)
  {
    parama.a(this.h, this.i, this.j, this.l);
    parama.a(paramb, this.c.d, this.c.e, this.d.e, this.d.f);
    parama.a(1.0F, 1.0F, 1.0F, 1.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */