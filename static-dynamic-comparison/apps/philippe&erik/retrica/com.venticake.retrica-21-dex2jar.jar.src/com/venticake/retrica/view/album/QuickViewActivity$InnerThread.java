package com.venticake.retrica.view.album;

import android.support.v4.view.ViewPager;
import android.view.View;

class QuickViewActivity$InnerThread
  extends Thread
{
  LazyImageView imLazyImageView;
  View imView;
  
  public QuickViewActivity$InnerThread(QuickViewActivity paramQuickViewActivity, View paramView, LazyImageView paramLazyImageView)
  {
    this.imView = paramView;
    this.imLazyImageView = paramLazyImageView;
  }
  
  public void run()
  {
    ((ViewPager)this.imView).addView(this.imLazyImageView, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/QuickViewActivity$InnerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */