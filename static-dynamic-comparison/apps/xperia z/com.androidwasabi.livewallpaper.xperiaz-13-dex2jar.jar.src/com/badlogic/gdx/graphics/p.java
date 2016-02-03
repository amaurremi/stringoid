package com.badlogic.gdx.graphics;

import com.badlogic.gdx.graphics.glutils.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class p
  extends g
{
  static final Map<com.badlogic.gdx.a, com.badlogic.gdx.utils.a<p>> g = new HashMap();
  private static com.badlogic.gdx.a.f i;
  t h;
  
  public p(int paramInt1, int paramInt2, m paramm)
  {
    this(new j(new k(paramInt1, paramInt2, paramm), null, false, true));
  }
  
  public p(com.badlogic.gdx.c.a parama)
  {
    this(parama, null, false);
  }
  
  public p(com.badlogic.gdx.c.a parama, m paramm, boolean paramBoolean)
  {
    this(a(parama, paramm, paramBoolean));
  }
  
  public p(t paramt)
  {
    super(3553, i());
    a(paramt);
    if (paramt.i()) {
      a(com.badlogic.gdx.g.a, this);
    }
  }
  
  public static void a(com.badlogic.gdx.a parama)
  {
    g.remove(parama);
  }
  
  private static void a(com.badlogic.gdx.a parama, p paramp)
  {
    com.badlogic.gdx.utils.a locala2 = (com.badlogic.gdx.utils.a)g.get(parama);
    com.badlogic.gdx.utils.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.badlogic.gdx.utils.a();
    }
    locala1.a(paramp);
    g.put(parama, locala1);
  }
  
  public static void b(com.badlogic.gdx.a parama)
  {
    int j = 0;
    parama = (com.badlogic.gdx.utils.a)g.get(parama);
    if (parama == null) {}
    for (;;)
    {
      return;
      if (i != null) {
        break;
      }
      while (j < parama.b)
      {
        ((p)parama.a(j)).j();
        j += 1;
      }
    }
    i.b();
    com.badlogic.gdx.utils.a locala = new com.badlogic.gdx.utils.a(parama);
    Iterator localIterator = locala.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      String str = i.a(localp);
      if (str == null)
      {
        localp.j();
      }
      else
      {
        j = i.c(str);
        i.a(str, 0);
        localp.b = 0;
        com.badlogic.gdx.a.a.g localg = new com.badlogic.gdx.a.a.g();
        localg.e = localp.m();
        localg.f = localp.b();
        localg.g = localp.d();
        localg.h = localp.e();
        localg.i = localp.f();
        localg.c = localp.h.h();
        localg.d = localp;
        localg.a = new q(j);
        i.a(str);
        localp.b = i();
        i.a(str, p.class, localg);
      }
    }
    parama.b();
    parama.a(locala);
  }
  
  public static String o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Managed textures/app: { ");
    Iterator localIterator = g.keySet().iterator();
    while (localIterator.hasNext())
    {
      com.badlogic.gdx.a locala = (com.badlogic.gdx.a)localIterator.next();
      localStringBuilder.append(((com.badlogic.gdx.utils.a)g.get(locala)).b);
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void a(t paramt)
  {
    if ((this.h != null) && (paramt.i() != this.h.i())) {
      throw new com.badlogic.gdx.utils.f("New data must have the same managed status as the old data");
    }
    this.h = paramt;
    if (!paramt.a()) {
      paramt.b();
    }
    a();
    a(3553, paramt);
    a(this.c, this.d);
    a(this.e, this.f);
    com.badlogic.gdx.g.g.glBindTexture(this.a, 0);
  }
  
  public void c()
  {
    if (this.b == 0) {}
    do
    {
      return;
      h();
    } while ((!this.h.i()) || (g.get(com.badlogic.gdx.g.a) == null));
    ((com.badlogic.gdx.utils.a)g.get(com.badlogic.gdx.g.a)).b(this, true);
  }
  
  protected void j()
  {
    if (!n()) {
      throw new com.badlogic.gdx.utils.f("Tried to reload unmanaged Texture");
    }
    this.b = i();
    a(this.h);
  }
  
  public int k()
  {
    return this.h.e();
  }
  
  public int l()
  {
    return this.h.f();
  }
  
  public t m()
  {
    return this.h;
  }
  
  public boolean n()
  {
    return this.h.i();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */