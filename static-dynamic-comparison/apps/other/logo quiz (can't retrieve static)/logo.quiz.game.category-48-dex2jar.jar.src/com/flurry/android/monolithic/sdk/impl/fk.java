package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.FlurryWalletError;
import com.flurry.android.FlurryWalletOperationHandler;

public final class fk
  implements hx
{
  private final FlurryWalletOperationHandler a;
  
  public fk(FlurryWalletOperationHandler paramFlurryWalletOperationHandler)
  {
    this.a = paramFlurryWalletOperationHandler;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.onOperationSucceed();
    }
  }
  
  public void a(hy paramhy)
  {
    if ((this.a != null) && (paramhy != null)) {
      this.a.onError(new FlurryWalletError(paramhy.a(), paramhy.b()));
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof fk)) {
        return false;
      }
      paramObject = (fk)paramObject;
    } while (this.a == ((fk)paramObject).a);
    return false;
  }
  
  public int hashCode()
  {
    if (this.a == null) {}
    for (int i = 0;; i = this.a.hashCode()) {
      return i + 527;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */