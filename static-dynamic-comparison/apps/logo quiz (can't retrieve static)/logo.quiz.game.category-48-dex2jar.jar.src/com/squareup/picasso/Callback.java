package com.squareup.picasso;

public abstract interface Callback
{
  public abstract void onError();
  
  public abstract void onSuccess();
  
  public static class EmptyCallback
    implements Callback
  {
    public void onError() {}
    
    public void onSuccess() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */