package com.venticake.retrica.view.album;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

class QuickViewActivity$QuickViewPagerAdapter
  extends ap
{
  private LayoutInflater mInflater;
  
  public QuickViewActivity$QuickViewPagerAdapter(QuickViewActivity paramQuickViewActivity, Context paramContext)
  {
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (QuickViewActivity.access$0(this.this$0) == null) {
      return 1;
    }
    return QuickViewActivity.access$0(this.this$0).length;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    this.this$0.mLazyImageView = new LazyImageView(this.this$0.getApplicationContext());
    this.this$0.mLazyImageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        QuickViewActivity.QuickViewPagerAdapter.this.this$0.finish();
      }
    });
    if ((QuickViewActivity.access$1(this.this$0) == 1) || (this.this$0.mPosition == -1))
    {
      this.this$0.mLazyImageView.loadImage(this.this$0.mURIString);
      Log.i("retrica", "hjh " + this.this$0.mURIString);
      new QuickViewActivity.InnerThread(this.this$0, paramView, this.this$0.mLazyImageView).start();
      return this.this$0.mLazyImageView;
    }
    this.this$0.mLazyImageView.loadImage(Uri.fromFile(QuickViewActivity.access$0(this.this$0)[paramInt]).toString());
    ((ViewPager)paramView).addView(this.this$0.mLazyImageView, 0);
    return this.this$0.mLazyImageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/QuickViewActivity$QuickViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */