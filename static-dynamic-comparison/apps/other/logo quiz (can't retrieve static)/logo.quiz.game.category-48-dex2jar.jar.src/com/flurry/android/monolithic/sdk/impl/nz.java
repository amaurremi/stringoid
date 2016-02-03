package com.flurry.android.monolithic.sdk.impl;

import java.lang.ref.WeakReference;

class nz
  extends WeakReference<K>
{
  int a;
  
  nz(nx paramnx, Object paramObject)
  {
    super(paramObject, nx.a(paramnx));
    this.a = System.identityHashCode(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      paramObject = (nz)paramObject;
    } while (get() == ((nz)paramObject).get());
    return false;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */