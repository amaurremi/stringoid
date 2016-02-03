package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.a;
import com.badlogic.gdx.b;
import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.graphics.k;
import com.badlogic.gdx.graphics.l;
import com.badlogic.gdx.h;

public class i
{
  private static boolean a = true;
  
  private static void a(int paramInt, k paramk)
  {
    g.g.glTexImage2D(paramInt, 0, paramk.f(), paramk.b(), paramk.d(), 0, paramk.e(), paramk.g(), paramk.h());
    g.j.glGenerateMipmap(paramInt);
  }
  
  public static void a(int paramInt1, k paramk, int paramInt2, int paramInt3)
  {
    if (!a)
    {
      c(paramInt1, paramk, paramInt2, paramInt3);
      return;
    }
    if ((g.a.b() == b.a) || (g.a.b() == b.d))
    {
      if (g.b.a())
      {
        a(paramInt1, paramk);
        return;
      }
      c(paramInt1, paramk, paramInt2, paramInt3);
      return;
    }
    b(paramInt1, paramk, paramInt2, paramInt3);
  }
  
  private static void b(int paramInt1, k paramk, int paramInt2, int paramInt3)
  {
    if ((g.b.a()) && ((g.b.a("GL_ARB_framebuffer_object")) || (g.b.a("GL_EXT_framebuffer_object"))))
    {
      g.g.glTexImage2D(paramInt1, 0, paramk.f(), paramk.b(), paramk.d(), 0, paramk.e(), paramk.g(), paramk.h());
      g.j.glGenerateMipmap(paramInt1);
      return;
    }
    if (g.b.a("GL_SGIS_generate_mipmap"))
    {
      if ((g.j == null) && (paramInt2 != paramInt3)) {
        throw new com.badlogic.gdx.utils.f("texture width and height must be square when using mipmapping in OpenGL ES 1.x");
      }
      g.g.glTexParameterf(paramInt1, 33169, 1.0F);
      g.g.glTexImage2D(paramInt1, 0, paramk.f(), paramk.b(), paramk.d(), 0, paramk.e(), paramk.g(), paramk.h());
      return;
    }
    c(paramInt1, paramk, paramInt2, paramInt3);
  }
  
  private static void c(int paramInt1, k paramk, int paramInt2, int paramInt3)
  {
    g.g.glTexImage2D(paramInt1, 0, paramk.f(), paramk.b(), paramk.d(), 0, paramk.e(), paramk.g(), paramk.h());
    if ((g.j == null) && (paramInt2 != paramInt3)) {
      throw new com.badlogic.gdx.utils.f("texture width and height must be square when using mipmapping.");
    }
    paramInt3 = paramk.b() / 2;
    int i = paramk.d() / 2;
    l locall = k.j();
    k.a(l.a);
    paramInt2 = 1;
    while ((paramInt3 > 0) && (i > 0))
    {
      k localk = new k(paramInt3, i, paramk.i());
      localk.a(paramk, 0, 0, paramk.b(), paramk.d(), 0, 0, paramInt3, i);
      if (paramInt2 > 1) {
        paramk.c();
      }
      g.g.glTexImage2D(paramInt1, paramInt2, localk.f(), localk.b(), localk.d(), 0, localk.e(), localk.g(), localk.h());
      paramInt3 = localk.b() / 2;
      i = localk.d() / 2;
      paramInt2 += 1;
      paramk = localk;
    }
    k.a(locall);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */