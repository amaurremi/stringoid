package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class HTML5AdView
  extends AdView
{
  static final FrameLayout.LayoutParams COVER_SCREEN_GRAVITY_CENTER = new FrameLayout.LayoutParams(-1, -1, 17);
  private View mCustomView;
  private WebChromeClient.CustomViewCallback mCustomViewCallback;
  private FrameLayout mCustomViewContainer;
  private Bitmap mDefaultVideoPoster;
  private View mVideoProgressView;
  
  public HTML5AdView(Context paramContext, MoPubView paramMoPubView)
  {
    super(paramContext, paramMoPubView);
    if (new Integer(Build.VERSION.SDK).intValue() > 7) {
      setWebChromeClient(new HTML5WebChromeClient(null));
    }
    this.mCustomViewContainer = new FrameLayout(paramContext);
    this.mCustomViewContainer.setVisibility(8);
    this.mCustomViewContainer.setLayoutParams(COVER_SCREEN_GRAVITY_CENTER);
  }
  
  private class HTML5WebChromeClient
    extends WebChromeClient
    implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
  {
    private HTML5WebChromeClient() {}
    
    public Bitmap getDefaultVideoPoster()
    {
      if (HTML5AdView.this.mDefaultVideoPoster == null) {
        HTML5AdView.access$402(HTML5AdView.this, BitmapFactory.decodeResource(HTML5AdView.this.getResources(), R.drawable.default_video_poster));
      }
      return HTML5AdView.this.mDefaultVideoPoster;
    }
    
    public View getVideoLoadingProgressView()
    {
      if (HTML5AdView.this.mVideoProgressView == null)
      {
        LayoutInflater localLayoutInflater = LayoutInflater.from(HTML5AdView.this.getContext());
        HTML5AdView.access$502(HTML5AdView.this, localLayoutInflater.inflate(R.layout.video_loading_progress, null));
      }
      return HTML5AdView.this.mVideoProgressView;
    }
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      paramMediaPlayer.stop();
      HTML5AdView.this.mCustomViewCallback.onCustomViewHidden();
      Log.d("MoPub", "Video completed!");
    }
    
    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      Log.d("MoPub", "Video errored!");
      return false;
    }
    
    public void onHideCustomView()
    {
      if (HTML5AdView.this.mCustomView == null) {
        return;
      }
      HTML5AdView.this.mCustomView.setVisibility(8);
      HTML5AdView.this.mCustomViewContainer.removeView(HTML5AdView.this.mCustomView);
      HTML5AdView.access$102(HTML5AdView.this, null);
      HTML5AdView.this.mCustomViewContainer.setVisibility(8);
      HTML5AdView.this.mCustomViewCallback.onCustomViewHidden();
      HTML5AdView.this.mMoPubView.removeView(HTML5AdView.this.mCustomViewContainer);
      HTML5AdView.this.setVisibility(0);
    }
    
    public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      super.onShowCustomView(paramView, paramCustomViewCallback);
      HTML5AdView.this.setVisibility(8);
      if (HTML5AdView.this.mCustomView != null)
      {
        paramCustomViewCallback.onCustomViewHidden();
        return;
      }
      HTML5AdView.this.mCustomViewContainer.addView(paramView, HTML5AdView.COVER_SCREEN_GRAVITY_CENTER);
      HTML5AdView.access$102(HTML5AdView.this, paramView);
      HTML5AdView.access$302(HTML5AdView.this, paramCustomViewCallback);
      HTML5AdView.this.mMoPubView.addView(HTML5AdView.this.mCustomViewContainer);
      HTML5AdView.this.mCustomViewContainer.setVisibility(0);
      HTML5AdView.this.mCustomViewContainer.bringToFront();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/HTML5AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */