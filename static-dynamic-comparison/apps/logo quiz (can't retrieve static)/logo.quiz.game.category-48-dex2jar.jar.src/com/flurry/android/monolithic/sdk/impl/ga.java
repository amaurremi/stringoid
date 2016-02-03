package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.FlurryWalletError;
import com.flurry.android.FlurryWalletHandler;
import com.flurry.android.FlurryWalletInfo;

public final class ga
  implements fz
{
  private final FlurryWalletHandler a;
  
  public ga(FlurryWalletHandler paramFlurryWalletHandler)
  {
    this.a = paramFlurryWalletHandler;
  }
  
  public void a(hy paramhy)
  {
    if ((this.a != null) && (paramhy != null)) {
      this.a.onError(new FlurryWalletError(paramhy.a(), paramhy.b()));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      paramString1 = new FlurryWalletInfo(paramString1, Float.parseFloat(paramString2));
      this.a.onValueUpdated(paramString1);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ga)) {
        return false;
      }
      paramObject = (ga)paramObject;
    } while (this.a == ((ga)paramObject).a);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */