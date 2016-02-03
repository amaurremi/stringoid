package com.tapjoy;

public abstract interface TJEventCallback
{
  public abstract void contentDidDisappear(TJEvent paramTJEvent);
  
  public abstract void contentDidShow(TJEvent paramTJEvent);
  
  public abstract void didRequestAction(TJEvent paramTJEvent, TJEventRequest paramTJEventRequest);
  
  public abstract void sendEventCompleted(TJEvent paramTJEvent, boolean paramBoolean);
  
  public abstract void sendEventFail(TJEvent paramTJEvent, TJError paramTJError);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJEventCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */