package com.parse.internal;

public abstract interface AsyncCallback
{
  public abstract void onCancel();
  
  public abstract void onFailure(Throwable paramThrowable);
  
  public abstract void onSuccess(Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/internal/AsyncCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */