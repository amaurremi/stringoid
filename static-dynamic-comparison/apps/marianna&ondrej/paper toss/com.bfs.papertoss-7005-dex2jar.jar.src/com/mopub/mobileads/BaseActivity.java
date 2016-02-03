package com.mopub.mobileads;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public abstract class BaseActivity
  extends Activity
{
  private static final float CLOSE_BUTTON_PADDING_DP = 8.0F;
  private static final float CLOSE_BUTTON_SIZE_DP = 50.0F;
  private ImageView mCloseButton;
  private RelativeLayout mLayout;
  
  public abstract View getAdView();
  
  protected void hideInterstitialCloseButton()
  {
    this.mLayout.removeView(this.mCloseButton);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().addFlags(1024);
    this.mLayout = new RelativeLayout(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(13);
    this.mLayout.addView(getAdView(), paramBundle);
    setContentView(this.mLayout);
    showInterstitialCloseButton();
  }
  
  protected void onDestroy()
  {
    this.mLayout.removeAllViews();
    super.onDestroy();
  }
  
  protected void showInterstitialCloseButton()
  {
    if (this.mCloseButton == null)
    {
      localObject = new StateListDrawable();
      Drawable localDrawable = getResources().getDrawable(R.drawable.close_button_normal);
      ((StateListDrawable)localObject).addState(new int[] { -16842919 }, localDrawable);
      localDrawable = getResources().getDrawable(R.drawable.close_button_pressed);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      this.mCloseButton = new ImageButton(this);
      this.mCloseButton.setImageDrawable((Drawable)localObject);
      this.mCloseButton.setBackgroundDrawable(null);
      this.mCloseButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BaseActivity.this.finish();
        }
      });
    }
    float f = getResources().getDisplayMetrics().density;
    int i = (int)(50.0F * f + 0.5F);
    int j = (int)(8.0F * f + 0.5F);
    Object localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).setMargins(j, 0, j, 0);
    this.mLayout.removeView(this.mCloseButton);
    this.mLayout.addView(this.mCloseButton, (ViewGroup.LayoutParams)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */