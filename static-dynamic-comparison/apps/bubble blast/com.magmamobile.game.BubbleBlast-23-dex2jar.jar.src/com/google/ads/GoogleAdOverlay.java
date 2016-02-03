package com.google.ads;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.List;

class GoogleAdOverlay
  extends PopupWindow
{
  private static final float BACKGROUND_DIM_AMOUNT = 0.5F;
  private FrameLayout mAdContainer;
  private View mParent;
  private WebView mWebView;
  
  public GoogleAdOverlay(Context paramContext, View paramView, WebView paramWebView)
  {
    super(paramContext);
    this.mParent = paramView;
    this.mWebView = paramWebView;
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setBackgroundDrawable(null);
    setFocusable(true);
    this.mAdContainer = new AdContainer(paramContext);
    this.mAdContainer.setBackgroundDrawable(null);
    setContentView(this.mAdContainer);
  }
  
  private void sendCloseMessage()
  {
    sendOutsideTouchMessage(-1, -1);
  }
  
  private void sendOutsideTouchMessage(int paramInt1, int paramInt2)
  {
    Object localObject = new int[2];
    this.mWebView.getLocationInWindow((int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    localObject = new Rect();
    this.mParent.getWindowVisibleDisplayFrame((Rect)localObject);
    Context localContext = this.mWebView.getContext();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AdSpec.Parameter("click_x", Integer.toString(AdUtil.scalePixelsToDips(localContext, paramInt1 + i))));
    localArrayList.add(new AdSpec.Parameter("click_y", Integer.toString(AdUtil.scalePixelsToDips(localContext, paramInt2 + j))));
    localArrayList.add(new AdSpec.Parameter("ad_x", Integer.toString(AdUtil.scalePixelsToDips(localContext, i))));
    localArrayList.add(new AdSpec.Parameter("ad_y", Integer.toString(AdUtil.scalePixelsToDips(localContext, j))));
    localArrayList.add(new AdSpec.Parameter("ad_width", Integer.toString(AdUtil.scalePixelsToDips(localContext, this.mWebView.getWidth()))));
    localArrayList.add(new AdSpec.Parameter("ad_height", Integer.toString(AdUtil.scalePixelsToDips(localContext, this.mWebView.getHeight()))));
    localArrayList.add(new AdSpec.Parameter("screen_width", Integer.toString(AdUtil.scalePixelsToDips(localContext, ((Rect)localObject).width()))));
    localArrayList.add(new AdSpec.Parameter("screen_height", Integer.toString(AdUtil.scalePixelsToDips(localContext, ((Rect)localObject).height()))));
    AdViewCommunicator.sendJavaScriptMessage(this.mWebView, AdViewCommunicator.JsMessageAction.JS_OUTSIDE_CLICK_MESSAGE, localArrayList);
  }
  
  public void addAndShowWebView(int paramInt1, int paramInt2)
  {
    removeAllViews();
    this.mAdContainer.addView(this.mWebView);
    showAtLocation(this.mParent, 0, paramInt1, paramInt2);
  }
  
  public void addView(View paramView)
  {
    removeAllViews();
    this.mAdContainer.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    removeAllViews();
    this.mAdContainer.addView(paramView, paramInt1, paramInt2);
  }
  
  public void dimBackground()
  {
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.mAdContainer.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    localLayoutParams.flags |= 0x2;
    localLayoutParams.dimAmount = 0.5F;
    ((WindowManager)this.mWebView.getContext().getSystemService("window")).updateViewLayout(this.mAdContainer, this.mAdContainer.getLayoutParams());
  }
  
  public void removeAllViews()
  {
    this.mAdContainer.removeAllViews();
  }
  
  public void removeAllViewsAndDismiss()
  {
    this.mAdContainer.removeAllViews();
    dismiss();
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    setWidth(AdUtil.scaleDipsToPixels(this.mParent.getContext(), paramInt1));
    setHeight(AdUtil.scaleDipsToPixels(this.mParent.getContext(), paramInt2));
  }
  
  private class AdContainer
    extends FrameLayout
  {
    public AdContainer(Context paramContext)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
      {
        GoogleAdOverlay.this.sendCloseMessage();
        return true;
      }
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
      {
        GoogleAdOverlay.this.sendOutsideTouchMessage(i, j);
        return true;
      }
      if (paramMotionEvent.getAction() == 4)
      {
        GoogleAdOverlay.this.sendOutsideTouchMessage(i, j);
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/GoogleAdOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */