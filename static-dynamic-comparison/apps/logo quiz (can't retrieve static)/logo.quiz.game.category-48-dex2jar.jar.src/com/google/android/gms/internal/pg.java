package com.google.android.gms.internal;

import java.io.IOException;

public abstract class pg<M extends pg<M>>
  extends pm
{
  protected pi awy;
  
  public final <T> T a(ph<M, T> paramph)
  {
    if (this.awy == null) {}
    pj localpj;
    do
    {
      return null;
      localpj = this.awy.gD(pp.gH(paramph.tag));
    } while (localpj == null);
    return (T)localpj.b(paramph);
  }
  
  public void a(pf parampf)
    throws IOException
  {
    if (this.awy == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.awy.size())
      {
        this.awy.gE(i).a(parampf);
        i += 1;
      }
    }
  }
  
  protected final boolean a(pe parampe, int paramInt)
    throws IOException
  {
    int i = parampe.getPosition();
    if (!parampe.gm(paramInt)) {
      return false;
    }
    int j = pp.gH(paramInt);
    po localpo = new po(paramInt, parampe.r(i, parampe.getPosition() - i));
    parampe = null;
    if (this.awy == null) {
      this.awy = new pi();
    }
    for (;;)
    {
      Object localObject = parampe;
      if (parampe == null)
      {
        localObject = new pj();
        this.awy.a(j, (pj)localObject);
      }
      ((pj)localObject).a(localpo);
      return true;
      parampe = this.awy.gD(j);
    }
  }
  
  protected final boolean a(M paramM)
  {
    if ((this.awy == null) || (this.awy.isEmpty())) {
      return (paramM.awy == null) || (paramM.awy.isEmpty());
    }
    return this.awy.equals(paramM.awy);
  }
  
  protected int c()
  {
    int j = 0;
    if (this.awy != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= this.awy.size()) {
          break;
        }
        i += this.awy.gE(j).c();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  protected final int qx()
  {
    if ((this.awy == null) || (this.awy.isEmpty())) {
      return 0;
    }
    return this.awy.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */