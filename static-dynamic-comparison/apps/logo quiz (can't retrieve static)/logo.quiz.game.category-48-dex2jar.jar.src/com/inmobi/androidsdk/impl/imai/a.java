package com.inmobi.androidsdk.impl.imai;

import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback.ResponseStatus;
import com.inmobi.commons.internal.Log;

final class a
  implements HttpRequestCallback
{
  public void notifyResult(int paramInt, Object paramObject)
  {
    Log.internal("InMobiAndroidSDK_3.7.1", "Got PING IN WEBVIEW callback. Status: " + paramInt + "webview: " + paramObject);
    if (paramObject == null) {}
    while (!(paramObject instanceof HttpRequestCallback.ResponseStatus)) {
      return;
    }
    paramObject = (HttpRequestCallback.ResponseStatus)paramObject;
    if (paramInt == 0)
    {
      IMAIUtility.firePingInWebViewSuccessful(((HttpRequestCallback.ResponseStatus)paramObject).getWebviewRef(), ((HttpRequestCallback.ResponseStatus)paramObject).getClickUrl());
      return;
    }
    IMAIUtility.fireErrorEvent(((HttpRequestCallback.ResponseStatus)paramObject).getWebviewRef(), "IMAI Ping in webview failed", "pingInWebview", ((HttpRequestCallback.ResponseStatus)paramObject).getClickUrl());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/imai/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */