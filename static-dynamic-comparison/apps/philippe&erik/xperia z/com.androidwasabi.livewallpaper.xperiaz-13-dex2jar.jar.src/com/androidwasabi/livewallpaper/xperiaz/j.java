package com.androidwasabi.livewallpaper.xperiaz;

import com.badlogic.gdx.c.a;
import com.badlogic.gdx.e;
import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.p;
import com.badlogic.gdx.graphics.r;
import com.badlogic.gdx.h;

public class j
{
  public static boolean a = true;
  public p b;
  public p c;
  public com.badlogic.gdx.graphics.g2d.b d;
  public com.badlogic.gdx.graphics.g2d.b e;
  
  public void a()
  {
    int i;
    a locala;
    if (Math.max(g.b.e(), g.b.f()) >= 800)
    {
      i = 1;
      if (i == 0) {
        break label221;
      }
      locala = g.e.a("textures/background1.jpg");
      label42:
      this.b = new p(new com.androidwasabi.a.b(locala, null, null, false, 4448));
      this.c = new p(new com.androidwasabi.a.b(g.e.a("textures/item.png"), null, null, false, 4448));
      if (!String.valueOf(g.e.a("textures/background1.jpg").b()).equals("237578"))
      {
        this.b = new p(g.e.a("textures/bg.png"));
        this.c = new p(g.e.a("textures/bg.png"));
      }
      if (i == 0) {
        break label235;
      }
    }
    label221:
    label235:
    for (this.d = new com.badlogic.gdx.graphics.g2d.b(this.b, 1, 1, 1022, 1022);; this.d = new com.badlogic.gdx.graphics.g2d.b(this.b, 1, 1, 510, 510))
    {
      this.e = new com.badlogic.gdx.graphics.g2d.b(this.c, 0, 0, 16, 16);
      return;
      i = 0;
      break;
      locala = g.e.a("textures/background2.jpg");
      break label42;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.a(r.b, r.b);
      this.c.a(r.b, r.b);
      return;
    }
    this.b.a(r.b, r.b);
    this.c.a(r.a, r.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */