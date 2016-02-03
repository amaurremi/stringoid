package com.millennialmedia.android;

import android.content.Context;
import android.text.ClipboardManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;

class BridgeMMPasteboard
  extends MMJSObject
{
  public MMJSResponse getPasteboardContents(final HashMap<String, String> paramHashMap)
  {
    paramHashMap = (Context)this.contextRef.get();
    if (paramHashMap != null) {
      runOnUiThreadFuture(new Callable()
      {
        public MMJSResponse call()
        {
          try
          {
            CharSequence localCharSequence = ((ClipboardManager)paramHashMap.getSystemService("clipboard")).getText();
            Object localObject = null;
            if (localCharSequence != null) {
              localObject = localCharSequence.toString();
            }
            if (localObject != null)
            {
              localObject = MMJSResponse.responseWithSuccess((String)localObject);
              return (MMJSResponse)localObject;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          return null;
        }
      });
    }
    return null;
  }
  
  public MMJSResponse writeToPasteboard(final HashMap<String, String> paramHashMap)
  {
    final Context localContext = (Context)this.contextRef.get();
    if (localContext != null) {
      runOnUiThreadFuture(new Callable()
      {
        public MMJSResponse call()
        {
          try
          {
            ((ClipboardManager)localContext.getSystemService("clipboard")).setText((String)paramHashMap.get("data"));
            MMJSResponse localMMJSResponse = MMJSResponse.responseWithSuccess();
            return localMMJSResponse;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          return null;
        }
      });
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/BridgeMMPasteboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */