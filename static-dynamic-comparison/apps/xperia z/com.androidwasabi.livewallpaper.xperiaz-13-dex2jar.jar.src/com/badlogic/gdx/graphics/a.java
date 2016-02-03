package com.badlogic.gdx.graphics;

import com.badlogic.gdx.h;
import com.badlogic.gdx.math.Matrix4;

public abstract class a
{
  public final com.badlogic.gdx.math.g a = new com.badlogic.gdx.math.g();
  public final com.badlogic.gdx.math.g b = new com.badlogic.gdx.math.g(0.0F, 0.0F, -1.0F);
  public final com.badlogic.gdx.math.g c = new com.badlogic.gdx.math.g(0.0F, 1.0F, 0.0F);
  public final Matrix4 d = new Matrix4();
  public final Matrix4 e = new Matrix4();
  public final Matrix4 f = new Matrix4();
  public final Matrix4 g = new Matrix4();
  public float h = 1.0F;
  public float i = 100.0F;
  public float j = 0.0F;
  public float k = 0.0F;
  public final com.badlogic.gdx.math.a l = new com.badlogic.gdx.math.a();
  final com.badlogic.gdx.math.a.a m = new com.badlogic.gdx.math.a.a(new com.badlogic.gdx.math.g(), new com.badlogic.gdx.math.g());
  private final com.badlogic.gdx.math.g n = new com.badlogic.gdx.math.g();
  
  public void a(com.badlogic.gdx.math.g paramg)
  {
    a(paramg, 0.0F, 0.0F, com.badlogic.gdx.g.b.e(), com.badlogic.gdx.g.b.f());
  }
  
  public void a(com.badlogic.gdx.math.g paramg, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramg.a;
    float f2 = paramg.b;
    float f3 = com.badlogic.gdx.g.b.f();
    paramg.a = ((f1 - paramFloat1) * 2.0F / paramFloat3 - 1.0F);
    paramg.b = (2.0F * (f3 - f2 - 1.0F - paramFloat2) / paramFloat4 - 1.0F);
    paramg.c = (paramg.c * 2.0F - 1.0F);
    paramg.a(this.g);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */