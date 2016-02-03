package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class jx<E>
  extends ArrayList<E>
{
  private boolean a = false;
  
  public jx() {}
  
  public jx(int paramInt)
  {
    super(paramInt);
  }
  
  public jx(List<E> paramList)
  {
    super(paramList);
  }
  
  private void b()
  {
    if (this.a) {
      throw new IllegalStateException();
    }
  }
  
  public List<E> a()
  {
    this.a = true;
    return this;
  }
  
  public boolean add(E paramE)
  {
    b();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    b();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    b();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    b();
    super.clear();
  }
  
  public E remove(int paramInt)
  {
    b();
    return (E)super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    b();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    b();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    b();
    return super.retainAll(paramCollection);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/jx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */