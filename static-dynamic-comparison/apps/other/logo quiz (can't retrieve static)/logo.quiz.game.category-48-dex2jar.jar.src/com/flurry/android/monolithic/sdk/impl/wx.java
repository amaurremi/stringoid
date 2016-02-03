package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Collection;

@rz
public final class wx
  extends ug<Collection<String>>
  implements ro
{
  protected final afm a;
  protected final qu<String> b;
  protected final boolean c;
  protected final th d;
  protected qu<Object> e;
  
  public wx(afm paramafm, qu<?> paramqu, th paramth)
  {
    super(paramafm.p());
    this.a = paramafm;
    this.b = paramqu;
    this.d = paramth;
    this.c = a(paramqu);
  }
  
  private Collection<String> b(ow paramow, qm paramqm, Collection<String> paramCollection)
    throws IOException, oz
  {
    qu localqu = this.b;
    Object localObject = paramow.b();
    if (localObject != pb.e)
    {
      if (localObject == pb.m) {}
      for (localObject = null;; localObject = (String)localqu.a(paramow, paramqm))
      {
        paramCollection.add(localObject);
        break;
      }
    }
    return paramCollection;
  }
  
  private final Collection<String> c(ow paramow, qm paramqm, Collection<String> paramCollection)
    throws IOException, oz
  {
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.a.p());
    }
    qu localqu = this.b;
    if (paramow.e() == pb.m) {
      paramow = null;
    }
    for (;;)
    {
      paramCollection.add(paramow);
      return paramCollection;
      if (localqu == null) {
        paramow = paramow.k();
      } else {
        paramow = (String)localqu.a(paramow, paramqm);
      }
    }
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return paramrw.b(paramow, paramqm);
  }
  
  public Collection<String> a(ow paramow, qm paramqm, Collection<String> paramCollection)
    throws IOException, oz
  {
    if (!paramow.j()) {
      paramqm = c(paramow, paramqm, paramCollection);
    }
    pb localpb;
    do
    {
      return paramqm;
      if (!this.c) {
        return b(paramow, paramqm, paramCollection);
      }
      localpb = paramow.b();
      paramqm = paramCollection;
    } while (localpb == pb.e);
    if (localpb == pb.m) {}
    for (paramqm = null;; paramqm = paramow.k())
    {
      paramCollection.add(paramqm);
      break;
    }
  }
  
  public void a(qk paramqk, qq paramqq)
    throws qw
  {
    xo localxo = this.d.o();
    if (localxo != null)
    {
      afm localafm = this.d.l();
      this.e = a(paramqk, paramqq, localafm, new qd(null, localafm, null, localxo));
    }
  }
  
  public Collection<String> b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (this.e != null) {
      return (Collection)this.d.a(this.e.a(paramow, paramqm));
    }
    return a(paramow, paramqm, (Collection)this.d.m());
  }
  
  public qu<Object> d()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */