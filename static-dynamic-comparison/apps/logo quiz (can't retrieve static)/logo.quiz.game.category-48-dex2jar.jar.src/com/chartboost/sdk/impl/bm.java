package com.chartboost.sdk.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class bm<T>
{
  final int a;
  private Queue<T> b = new ConcurrentLinkedQueue();
  
  public bm(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected boolean a(T paramT)
  {
    return true;
  }
  
  protected abstract T b();
  
  public void b(T paramT)
  {
    if (!a(paramT)) {}
    while (this.b.size() > this.a) {
      return;
    }
    this.b.add(paramT);
  }
  
  public T c()
  {
    Object localObject = this.b.poll();
    if (localObject != null) {
      return (T)localObject;
    }
    return (T)b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */