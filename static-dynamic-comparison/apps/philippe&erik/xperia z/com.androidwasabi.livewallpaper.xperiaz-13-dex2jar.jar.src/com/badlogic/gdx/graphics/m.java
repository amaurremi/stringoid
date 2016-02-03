package com.badlogic.gdx.graphics;

import com.badlogic.gdx.utils.f;

public enum m
{
  private m() {}
  
  public static int a(m paramm)
  {
    if (paramm == a) {}
    while (paramm == b) {
      return 1;
    }
    if (paramm == c) {
      return 2;
    }
    if (paramm == d) {
      return 5;
    }
    if (paramm == e) {
      return 6;
    }
    if (paramm == f) {
      return 3;
    }
    if (paramm == g) {
      return 4;
    }
    throw new f("Unknown Format: " + paramm);
  }
  
  public static m a(int paramInt)
  {
    if (paramInt == 1) {
      return a;
    }
    if (paramInt == 2) {
      return c;
    }
    if (paramInt == 5) {
      return d;
    }
    if (paramInt == 6) {
      return e;
    }
    if (paramInt == 3) {
      return f;
    }
    if (paramInt == 4) {
      return g;
    }
    throw new f("Unknown Gdx2DPixmap Format: " + paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */