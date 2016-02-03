package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.fitness.Fitness;

public abstract interface kj
  extends Api.a
{
  public abstract Context getContext();
  
  public abstract ko iT();
  
  public static abstract class a<R extends Result>
    extends BaseImplementation.a<R, kj>
  {
    public a()
    {
      super();
    }
  }
  
  public static class b
    extends ks.a
  {
    private final BaseImplementation.b<Status> De;
    
    public b(BaseImplementation.b<Status> paramb)
    {
      this.De = paramb;
    }
    
    public void k(Status paramStatus)
    {
      this.De.b(paramStatus);
    }
  }
  
  public static abstract class c
    extends kj.a<Status>
  {
    protected Status d(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        n.K(bool);
        return paramStatus;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/kj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */