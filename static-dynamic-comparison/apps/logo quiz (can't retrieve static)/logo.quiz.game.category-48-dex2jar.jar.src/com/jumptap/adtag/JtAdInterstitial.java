package com.jumptap.adtag;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.jumptap.adtag.utils.JtException;
import java.util.Timer;
import java.util.TimerTask;

public class JtAdInterstitial
  extends JtAdView
{
  private DismissTimer dismissTask;
  private boolean isPopupShown = false;
  private PopupWindow popup;
  
  public JtAdInterstitial(Context paramContext)
    throws JtException
  {
    super(paramContext);
    init();
  }
  
  public JtAdInterstitial(Context paramContext, AttributeSet paramAttributeSet)
    throws JtException
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public JtAdInterstitial(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    throws JtException
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public JtAdInterstitial(Context paramContext, JtAdWidgetSettings paramJtAdWidgetSettings)
    throws JtException
  {
    super(paramContext, paramJtAdWidgetSettings);
    init();
  }
  
  private void configDismissButton()
  {
    this.dismiss.setVisibility(0);
    this.dismiss.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        JtAdInterstitial.this.dismiss(true);
      }
    });
  }
  
  private void dismiss(boolean paramBoolean)
  {
    stopTimer();
    if (this.isPopupShown)
    {
      this.popup.dismiss();
      this.isPopupShown = false;
    }
    onInterstitialDismissed();
  }
  
  private void init()
  {
    configDismissButton();
    this.popup = new PopupWindow(this, getWidthSize(), getHeightSize(), true);
    this.webViewArr[this.ACTIVE_WEBVIEW_INDEX].setOnTouchListener(new InterstitialOnTouchListener(this, getId()));
    this.webViewArr[this.INACTIVE_WEBVIEW_INDEX].setOnTouchListener(new InterstitialOnTouchListener(this, getId()));
  }
  
  private void restartTimer()
  {
    stopTimer();
    startTimer();
  }
  
  private void startTimer()
  {
    int i = this.widgetSettings.getInterstitialshowTime();
    Log.i("JtAd", "Starting interstitial timer");
    Timer localTimer = new Timer("DismisTask");
    if (this.dismissTask != null) {
      this.dismissTask.cancel();
    }
    this.dismissTask = new DismissTimer();
    localTimer.schedule(this.dismissTask, i * 1000);
  }
  
  private void stopTimer()
  {
    Log.i("JtAd", "stopping interstitial timer");
    if (this.dismissTask != null) {
      this.dismissTask.cancel();
    }
  }
  
  public void dismiss()
  {
    dismiss(false);
  }
  
  protected int getHeightSize()
  {
    return -1;
  }
  
  protected int getWidthSize()
  {
    return -1;
  }
  
  public void onAdError(int paramInt)
  {
    super.onAdError(paramInt);
    dismiss(false);
  }
  
  public void onNoAdFound()
  {
    super.onNoAdFound();
    dismiss(false);
  }
  
  public void resize(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void show()
  {
    startTimer();
  }
  
  public void showAsPopup()
  {
    this.popup.showAtLocation(this, 48, 0, 0);
    this.isPopupShown = true;
  }
  
  protected void startTimers(boolean paramBoolean)
  {
    super.startTimers(paramBoolean);
    startTimer();
  }
  
  class DismissTimer
    extends TimerTask
  {
    DismissTimer() {}
    
    public void run()
    {
      Log.i("JtAd", "starting dismissal timer task");
      JtAdInterstitial.this.post(new Runnable()
      {
        public void run()
        {
          JtAdInterstitial.this.dismiss(false);
        }
      });
    }
  }
  
  private class InterstitialOnTouchListener
    extends JtAdView.JtAdListener
  {
    public InterstitialOnTouchListener(JtAdView paramJtAdView, int paramInt)
    {
      super(paramJtAdView, paramInt);
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      super.onTouch(paramView, paramMotionEvent);
      JtAdInterstitial.this.restartTimer();
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/JtAdInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */