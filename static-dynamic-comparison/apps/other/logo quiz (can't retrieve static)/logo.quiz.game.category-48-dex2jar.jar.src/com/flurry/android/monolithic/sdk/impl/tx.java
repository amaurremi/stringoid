package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.ArrayList;

public class tx
{
  protected final ArrayList<sw> a = new ArrayList();
  
  public Object a(ow paramow, qm paramqm, Object paramObject, afz paramafz)
    throws IOException, oz
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      paramow = (sw)this.a.get(i);
      ow localow = paramafz.h();
      localow.b();
      paramow.a(localow, paramqm, paramObject);
      i += 1;
    }
    return paramObject;
  }
  
  public void a(sw paramsw)
  {
    this.a.add(paramsw);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */