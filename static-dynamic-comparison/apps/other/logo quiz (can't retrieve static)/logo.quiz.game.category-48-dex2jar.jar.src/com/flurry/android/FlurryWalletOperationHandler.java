package com.flurry.android;

public abstract interface FlurryWalletOperationHandler
{
  public abstract void onError(FlurryWalletError paramFlurryWalletError);
  
  public abstract void onOperationSucceed();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/FlurryWalletOperationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */