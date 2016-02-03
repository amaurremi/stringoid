package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;

class BridgeMMInlineVideo
  extends MMJSObject
{
  public MMJSResponse adjustVideo(final HashMap<String, String> paramHashMap)
  {
    runOnUiThreadFuture(new Callable()
    {
      public MMJSResponse call()
      {
        MMWebView localMMWebView = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
        if ((localMMWebView != null) && (localMMWebView != null) && (localMMWebView.getMMLayout().adjustVideo(new InlineVideoView.InlineParams(paramHashMap, localMMWebView.getContext())))) {
          return MMJSResponse.responseWithSuccess();
        }
        return MMJSResponse.responseWithError();
      }
    });
  }
  
  public MMJSResponse insertVideo(final HashMap<String, String> paramHashMap)
  {
    runOnUiThreadFuture(new Callable()
    {
      public MMJSResponse call()
      {
        MMWebView localMMWebView = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
        if (localMMWebView != null)
        {
          MMLayout localMMLayout = localMMWebView.getMMLayout();
          localMMLayout.initInlineVideo(new InlineVideoView.InlineParams(paramHashMap, localMMWebView.getContext()));
          return MMJSResponse.responseWithSuccess("usingStreaming=" + localMMLayout.isVideoPlayingStreaming());
        }
        return MMJSResponse.responseWithError();
      }
    });
  }
  
  public MMJSResponse pauseVideo(HashMap<String, String> paramHashMap)
  {
    runOnUiThreadFuture(new Callable()
    {
      public MMJSResponse call()
      {
        Object localObject = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
        if (localObject != null)
        {
          localObject = ((MMWebView)localObject).getMMLayout();
          if (localObject != null)
          {
            ((MMLayout)localObject).pauseVideo();
            return MMJSResponse.responseWithSuccess();
          }
        }
        return MMJSResponse.responseWithError();
      }
    });
  }
  
  public MMJSResponse playVideo(HashMap<String, String> paramHashMap)
  {
    runOnUiThreadFuture(new Callable()
    {
      public MMJSResponse call()
      {
        Object localObject = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
        if (localObject != null)
        {
          localObject = ((MMWebView)localObject).getMMLayout();
          if (localObject != null)
          {
            ((MMLayout)localObject).playVideo();
            return MMJSResponse.responseWithSuccess();
          }
        }
        return MMJSResponse.responseWithError();
      }
    });
  }
  
  public MMJSResponse removeVideo(HashMap<String, String> paramHashMap)
  {
    runOnUiThreadFuture(new Callable()
    {
      public MMJSResponse call()
      {
        Object localObject = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
        if (localObject != null)
        {
          localObject = ((MMWebView)localObject).getMMLayout();
          if (localObject != null)
          {
            ((MMLayout)localObject).removeVideo();
            return MMJSResponse.responseWithSuccess();
          }
        }
        return MMJSResponse.responseWithError();
      }
    });
  }
  
  public MMJSResponse resumeVideo(HashMap<String, String> paramHashMap)
  {
    runOnUiThreadFuture(new Callable()
    {
      public MMJSResponse call()
      {
        Object localObject = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
        if (localObject != null)
        {
          localObject = ((MMWebView)localObject).getMMLayout();
          if (localObject != null)
          {
            ((MMLayout)localObject).resumeVideo();
            return MMJSResponse.responseWithSuccess();
          }
        }
        return MMJSResponse.responseWithError();
      }
    });
  }
  
  public MMJSResponse setStreamVideoSource(final HashMap<String, String> paramHashMap)
  {
    runOnUiThreadFuture(new Callable()
    {
      public MMJSResponse call()
      {
        Object localObject = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
        if (localObject != null)
        {
          localObject = ((MMWebView)localObject).getMMLayout();
          String str = (String)paramHashMap.get("streamVideoURI");
          if ((localObject != null) && (str != null))
          {
            ((MMLayout)localObject).setVideoSource(str);
            return MMJSResponse.responseWithSuccess();
          }
        }
        return MMJSResponse.responseWithError();
      }
    });
  }
  
  public MMJSResponse stopVideo(HashMap<String, String> paramHashMap)
  {
    runOnUiThreadFuture(new Callable()
    {
      public MMJSResponse call()
      {
        Object localObject = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
        if (localObject != null)
        {
          localObject = ((MMWebView)localObject).getMMLayout();
          if (localObject != null)
          {
            ((MMLayout)localObject).stopVideo();
            return MMJSResponse.responseWithSuccess();
          }
        }
        return MMJSResponse.responseWithError();
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/BridgeMMInlineVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */