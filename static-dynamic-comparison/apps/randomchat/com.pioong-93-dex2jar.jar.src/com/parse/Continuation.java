package com.parse;

abstract interface Continuation<TTaskResult, TContinuationResult>
{
  public abstract TContinuationResult then(Task<TTaskResult> paramTask)
    throws Exception;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/Continuation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */