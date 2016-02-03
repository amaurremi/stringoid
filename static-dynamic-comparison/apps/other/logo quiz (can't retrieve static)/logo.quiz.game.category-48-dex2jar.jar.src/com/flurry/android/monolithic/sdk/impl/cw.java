package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class cw
  implements cx
{
  private final List<cx> a;
  
  public cw()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cv());
    localArrayList.add(new da());
    localArrayList.add(new ct());
    localArrayList.add(new cz());
    this.a = Collections.unmodifiableList(localArrayList);
  }
  
  public boolean a(Context paramContext, db paramdb)
  {
    boolean bool2;
    if ((paramContext == null) || (paramdb == null)) {
      bool2 = false;
    }
    Iterator localIterator;
    boolean bool1;
    do
    {
      return bool2;
      localIterator = this.a.iterator();
      bool1 = true;
      bool2 = bool1;
    } while (!localIterator.hasNext());
    if (!((cx)localIterator.next()).a(paramContext, paramdb)) {
      bool1 = false;
    }
    for (;;)
    {
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */