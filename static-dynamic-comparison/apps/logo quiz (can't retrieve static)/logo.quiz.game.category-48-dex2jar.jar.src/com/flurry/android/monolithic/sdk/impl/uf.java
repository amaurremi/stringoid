package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Collection;

@rz
public class uf
  extends ug<Collection<Object>>
  implements ro
{
  protected final afm a;
  protected final qu<Object> b;
  protected final rw c;
  protected final th d;
  protected qu<Object> e;
  
  public uf(afm paramafm, qu<Object> paramqu, rw paramrw, th paramth)
  {
    super(paramafm.p());
    this.a = paramafm;
    this.b = paramqu;
    this.c = paramrw;
    this.d = paramth;
  }
  
  private final Collection<Object> b(ow paramow, qm paramqm, Collection<Object> paramCollection)
    throws IOException, oz
  {
    if (!paramqm.a(ql.o)) {
      throw paramqm.b(this.a.p());
    }
    qu localqu = this.b;
    rw localrw = this.c;
    if (paramow.e() == pb.m) {
      paramow = null;
    }
    for (;;)
    {
      paramCollection.add(paramow);
      return paramCollection;
      if (localrw == null) {
        paramow = localqu.a(paramow, paramqm);
      } else {
        paramow = localqu.a(paramow, paramqm, localrw);
      }
    }
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return paramrw.b(paramow, paramqm);
  }
  
  public Collection<Object> a(ow paramow, qm paramqm, Collection<Object> paramCollection)
    throws IOException, oz
  {
    Object localObject;
    if (!paramow.j()) {
      localObject = b(paramow, paramqm, paramCollection);
    }
    qu localqu;
    rw localrw;
    pb localpb;
    do
    {
      return (Collection<Object>)localObject;
      localqu = this.b;
      localrw = this.c;
      localpb = paramow.b();
      localObject = paramCollection;
    } while (localpb == pb.e);
    if (localpb == pb.m) {
      localObject = null;
    }
    for (;;)
    {
      paramCollection.add(localObject);
      break;
      if (localrw == null) {
        localObject = localqu.a(paramow, paramqm);
      } else {
        localObject = localqu.a(paramow, paramqm, localrw);
      }
    }
  }
  
  public void a(qk paramqk, qq paramqq)
    throws qw
  {
    if (this.d.i())
    {
      afm localafm = this.d.l();
      if (localafm == null) {
        throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.a + ": value instantiator (" + this.d.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
      }
      this.e = a(paramqk, paramqq, localafm, new qd(null, localafm, null, this.d.o()));
    }
  }
  
  public Collection<Object> b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (this.e != null) {
      return (Collection)this.d.a(this.e.a(paramow, paramqm));
    }
    if (paramow.e() == pb.h)
    {
      String str = paramow.k();
      if (str.length() == 0) {
        return (Collection)this.d.a(str);
      }
    }
    return a(paramow, paramqm, (Collection)this.d.m());
  }
  
  public qu<Object> d()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/uf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */