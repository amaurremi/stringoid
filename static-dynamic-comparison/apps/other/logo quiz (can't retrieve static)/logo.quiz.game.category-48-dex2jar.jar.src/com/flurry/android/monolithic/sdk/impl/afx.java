package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class afx
  extends afw
{
  protected final ow[] e;
  protected int f;
  
  protected afx(ow[] paramArrayOfow)
  {
    super(paramArrayOfow[0]);
    this.e = paramArrayOfow;
    this.f = 1;
  }
  
  public static afx a(ow paramow1, ow paramow2)
  {
    if ((!(paramow1 instanceof afx)) && (!(paramow2 instanceof afx))) {
      return new afx(new ow[] { paramow1, paramow2 });
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramow1 instanceof afx))
    {
      ((afx)paramow1).a(localArrayList);
      if (!(paramow2 instanceof afx)) {
        break label103;
      }
      ((afx)paramow2).a(localArrayList);
    }
    for (;;)
    {
      return new afx((ow[])localArrayList.toArray(new ow[localArrayList.size()]));
      localArrayList.add(paramow1);
      break;
      label103:
      localArrayList.add(paramow2);
    }
  }
  
  protected boolean A()
  {
    if (this.f >= this.e.length) {
      return false;
    }
    ow[] arrayOfow = this.e;
    int i = this.f;
    this.f = (i + 1);
    this.d = arrayOfow[i];
    return true;
  }
  
  protected void a(List<ow> paramList)
  {
    int i = this.f;
    int j = this.e.length;
    i -= 1;
    if (i < j)
    {
      ow localow = this.e[i];
      if ((localow instanceof afx)) {
        ((afx)localow).a(paramList);
      }
      for (;;)
      {
        i += 1;
        break;
        paramList.add(localow);
      }
    }
  }
  
  public pb b()
    throws IOException, ov
  {
    pb localpb = this.d.b();
    if (localpb != null) {
      return localpb;
    }
    while (A())
    {
      localpb = this.d.b();
      if (localpb != null) {
        return localpb;
      }
    }
    return null;
  }
  
  public void close()
    throws IOException
  {
    do
    {
      this.d.close();
    } while (A());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */