package com.magmamobile.game.engine;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

final class AdLayoutDebug
  extends AdLayout
  implements View.OnClickListener
{
  private LinearLayout adLoading;
  private ProgressBar adProgress;
  private TextView adView;
  private LinearLayout.LayoutParams params;
  
  public AdLayoutDebug(Context paramContext, AdType paramAdType)
  {
    super(paramContext);
    setGravity(49);
    this.adType = paramAdType;
    this.adView = new TextView(getContext());
    this.adLoading = new LinearLayout(getContext());
    this.adLoading.setGravity(17);
    this.adLoading.setBackgroundColor(-15856114);
    this.adProgress = new ProgressBar(getContext(), null, 16842873);
    this.adProgress.setIndeterminate(true);
    this.adProgress.setMinimumHeight(48);
    this.adProgress.setMinimumWidth(48);
    this.adLoading.addView(this.adProgress, new LinearLayout.LayoutParams((int)Game.dpi(48.0F), (int)Game.dpi(48.0F)));
    if (paramAdType == AdType.BANNER)
    {
      this.theoricalWidth = 320;
      this.theoricalHeight = 50;
      this.params = new LinearLayout.LayoutParams((int)Game.dpi(this.theoricalWidth), (int)Game.dpi(this.theoricalHeight));
      this.adView.setText("Banner 320x50");
    }
    for (;;)
    {
      this.adView.setTypeface(null, 1);
      this.adView.setGravity(17);
      this.adView.setBackgroundColor(-15856114);
      this.adView.setTextColor(-1);
      this.adView.setOnClickListener(this);
      this.adView.setVisibility(8);
      addView(this.adView, this.params);
      addView(this.adLoading, this.params);
      return;
      if (paramAdType == AdType.SQUARE)
      {
        this.theoricalWidth = 300;
        this.theoricalHeight = 250;
        this.params = new LinearLayout.LayoutParams((int)Game.dpi(this.theoricalWidth), (int)Game.dpi(this.theoricalHeight));
        this.adView.setText("Square 300x250");
      }
    }
  }
  
  private void deleteAllView()
  {
    if (this.adView == null) {
      return;
    }
    removeAllViews();
  }
  
  public void onClick(View paramView)
  {
    Toast.makeText(getContext(), "Clicked !", 0).show();
  }
  
  public void onDestroy()
  {
    deleteAllView();
  }
  
  public void onPause()
  {
    deleteAllView();
  }
  
  public void onResume()
  {
    sendRequest();
  }
  
  protected void onShowCallback()
  {
    super.onShowCallback();
    sendRequest();
  }
  
  public void sendRequest()
  {
    if ((this.adView != null) && (this.visible))
    {
      deleteAllView();
      addView(this.adLoading, this.params);
      this.adLoading.setVisibility(0);
      Game.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          try
          {
            AdLayoutDebug.this.addView(AdLayoutDebug.this.adView, AdLayoutDebug.this.params);
            AdLayoutDebug.this.adLoading.setVisibility(8);
            AdLayoutDebug.this.adView.setVisibility(0);
            return;
          }
          catch (Exception localException) {}
        }
      }, 3000L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AdLayoutDebug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */