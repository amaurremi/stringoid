package com.ideashower.readitlater.reader;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import com.ideashower.readitlater.activity.ReaderFragment;

@TargetApi(11)
public class ReaderChromeClient11
  extends ReaderChromeClient
{
  protected ReaderChromeClient11(ReaderFragment paramReaderFragment, ViewGroup paramViewGroup)
  {
    super(paramReaderFragment, paramViewGroup);
  }
  
  public void setFullscreen(boolean paramBoolean)
  {
    super.setFullscreen(paramBoolean);
    if (!paramBoolean)
    {
      if (this.e != null) {
        this.e.setSystemUiVisibility(0);
      }
    }
    else {
      return;
    }
    this.d.setSystemUiVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/ReaderChromeClient11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */