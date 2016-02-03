package com.inmobi.androidsdk.impl.net;

import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;

public abstract interface HttpRequestCallback
{
  public static final int HTTP_FAILURE = 1;
  public static final int HTTP_SUCCESS = 0;
  
  public abstract void notifyResult(int paramInt, Object paramObject);
  
  public static class ResponseStatus
  {
    WeakReference<IMWebView> a;
    String b;
    
    public String getClickUrl()
    {
      return this.b;
    }
    
    public WeakReference<IMWebView> getWebviewRef()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/net/HttpRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */