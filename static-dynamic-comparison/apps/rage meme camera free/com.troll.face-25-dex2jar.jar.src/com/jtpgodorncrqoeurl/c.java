package com.jtpgodorncrqoeurl;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

final class c
  implements View.OnClickListener
{
  c(AdBrowser paramAdBrowser) {}
  
  public final void onClick(View paramView)
  {
    paramView = (WebView)this.a.findViewById(101);
    if (paramView.canGoBack())
    {
      paramView.goBack();
      return;
    }
    this.a.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */