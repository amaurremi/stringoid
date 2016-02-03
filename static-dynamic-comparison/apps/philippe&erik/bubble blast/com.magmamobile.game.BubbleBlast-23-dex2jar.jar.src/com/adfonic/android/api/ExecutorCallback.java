package com.adfonic.android.api;

import com.adfonic.android.api.response.ApiResponse;

public abstract interface ExecutorCallback
{
  public abstract void onResponse(ApiResponse paramApiResponse);
  
  public abstract void onThrowable(Throwable paramThrowable);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/ExecutorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */