package com.ideashower.readitlater.activity;

import android.webkit.JavascriptInterface;
import com.ideashower.readitlater.a.g;
import com.pocket.webkit.JsInterface;

public class ReaderFragment$JSInterfaceConnection
  extends JsInterface
{
  public ReaderFragment$JSInterfaceConnection(ReaderFragment paramReaderFragment, String paramString)
  {
    super(paramReaderFragment.Y, paramString);
  }
  
  @JavascriptInterface
  public boolean isConnected()
  {
    if (!isEnabled()) {
      return false;
    }
    return g.k();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */