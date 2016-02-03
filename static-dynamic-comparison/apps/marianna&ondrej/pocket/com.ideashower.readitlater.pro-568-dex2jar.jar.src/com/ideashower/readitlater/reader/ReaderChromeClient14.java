package com.ideashower.readitlater.reader;

import android.support.v4.app.f;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.ideashower.readitlater.activity.ReaderFragment;

public class ReaderChromeClient14
  extends ReaderChromeClient11
{
  private int h;
  private boolean i = false;
  
  protected ReaderChromeClient14(ReaderFragment paramReaderFragment, ViewGroup paramViewGroup)
  {
    super(paramReaderFragment, paramViewGroup);
  }
  
  public void onHideCustomView()
  {
    if (this.e == null) {}
    do
    {
      return;
      super.onHideCustomView();
    } while (!this.i);
    this.i = false;
    this.g.m().setRequestedOrientation(this.h);
  }
  
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.e != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.i = true;
    this.h = this.g.m().getRequestedOrientation();
    onShowCustomView(paramView, paramCustomViewCallback);
    this.g.m().setRequestedOrientation(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/ReaderChromeClient14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */