package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.mediarouter.R.attr;
import android.support.v7.mediarouter.R.id;
import android.support.v7.mediarouter.R.layout;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MediaRouteControllerDialog
  extends Dialog
{
  private static final String TAG = "MediaRouteControllerDialog";
  private static final int VOLUME_UPDATE_DELAY_MILLIS = 250;
  private final MediaRouterCallback mCallback = new MediaRouterCallback(null);
  private View mControlView;
  private boolean mCreated;
  private Drawable mCurrentIconDrawable;
  private Button mDisconnectButton;
  private Drawable mMediaRouteConnectingDrawable;
  private Drawable mMediaRouteOnDrawable;
  private final MediaRouter.RouteInfo mRoute = this.mRouter.getSelectedRoute();
  private final MediaRouter mRouter = MediaRouter.getInstance(getContext());
  private boolean mVolumeControlEnabled = true;
  private LinearLayout mVolumeLayout;
  private SeekBar mVolumeSlider;
  private boolean mVolumeSliderTouched;
  
  public MediaRouteControllerDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public MediaRouteControllerDialog(Context paramContext, int paramInt)
  {
    super(MediaRouterThemeHelper.createThemedContext(paramContext, true), paramInt);
  }
  
  private Drawable getIconDrawable()
  {
    if (this.mRoute.isConnecting())
    {
      if (this.mMediaRouteConnectingDrawable == null) {
        this.mMediaRouteConnectingDrawable = MediaRouterThemeHelper.getThemeDrawable(getContext(), R.attr.mediaRouteConnectingDrawable);
      }
      return this.mMediaRouteConnectingDrawable;
    }
    if (this.mMediaRouteOnDrawable == null) {
      this.mMediaRouteOnDrawable = MediaRouterThemeHelper.getThemeDrawable(getContext(), R.attr.mediaRouteOnDrawable);
    }
    return this.mMediaRouteOnDrawable;
  }
  
  private boolean isVolumeControlAvailable()
  {
    return (this.mVolumeControlEnabled) && (this.mRoute.getVolumeHandling() == 1);
  }
  
  private boolean update()
  {
    boolean bool = true;
    if ((!this.mRoute.isSelected()) || (this.mRoute.isDefault()))
    {
      dismiss();
      bool = false;
    }
    Drawable localDrawable;
    do
    {
      return bool;
      setTitle(this.mRoute.getName());
      updateVolume();
      localDrawable = getIconDrawable();
    } while (localDrawable == this.mCurrentIconDrawable);
    this.mCurrentIconDrawable = localDrawable;
    localDrawable.setVisible(false, true);
    getWindow().setFeatureDrawable(3, localDrawable);
    return true;
  }
  
  private void updateVolume()
  {
    if (!this.mVolumeSliderTouched)
    {
      if (isVolumeControlAvailable())
      {
        this.mVolumeLayout.setVisibility(0);
        this.mVolumeSlider.setMax(this.mRoute.getVolumeMax());
        this.mVolumeSlider.setProgress(this.mRoute.getVolume());
      }
    }
    else {
      return;
    }
    this.mVolumeLayout.setVisibility(8);
  }
  
  public View getMediaControlView()
  {
    return this.mControlView;
  }
  
  public MediaRouter.RouteInfo getRoute()
  {
    return this.mRoute;
  }
  
  public boolean isVolumeControlEnabled()
  {
    return this.mVolumeControlEnabled;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mRouter.addCallback(MediaRouteSelector.EMPTY, this.mCallback, 2);
    update();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(3);
    setContentView(R.layout.mr_media_route_controller_dialog);
    this.mVolumeLayout = ((LinearLayout)findViewById(R.id.media_route_volume_layout));
    this.mVolumeSlider = ((SeekBar)findViewById(R.id.media_route_volume_slider));
    this.mVolumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      private final Runnable mStopTrackingTouch = new Runnable()
      {
        public void run()
        {
          if (MediaRouteControllerDialog.this.mVolumeSliderTouched)
          {
            MediaRouteControllerDialog.access$102(MediaRouteControllerDialog.this, false);
            MediaRouteControllerDialog.this.updateVolume();
          }
        }
      };
      
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          MediaRouteControllerDialog.this.mRoute.requestSetVolume(paramAnonymousInt);
        }
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        if (MediaRouteControllerDialog.this.mVolumeSliderTouched)
        {
          MediaRouteControllerDialog.this.mVolumeSlider.removeCallbacks(this.mStopTrackingTouch);
          return;
        }
        MediaRouteControllerDialog.access$102(MediaRouteControllerDialog.this, true);
      }
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MediaRouteControllerDialog.this.mVolumeSlider.postDelayed(this.mStopTrackingTouch, 250L);
      }
    });
    this.mDisconnectButton = ((Button)findViewById(R.id.media_route_disconnect_button));
    this.mDisconnectButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (MediaRouteControllerDialog.this.mRoute.isSelected()) {
          MediaRouteControllerDialog.this.mRouter.getDefaultRoute().select();
        }
        MediaRouteControllerDialog.this.dismiss();
      }
    });
    this.mCreated = true;
    if (update())
    {
      this.mControlView = onCreateMediaControlView(paramBundle);
      paramBundle = (FrameLayout)findViewById(R.id.media_route_control_frame);
      if (this.mControlView != null)
      {
        paramBundle.addView(this.mControlView);
        paramBundle.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    paramBundle.setVisibility(8);
  }
  
  public View onCreateMediaControlView(Bundle paramBundle)
  {
    return null;
  }
  
  public void onDetachedFromWindow()
  {
    this.mRouter.removeCallback(this.mCallback);
    super.onDetachedFromWindow();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 25) || (paramInt == 24))
    {
      paramKeyEvent = this.mRoute;
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        paramKeyEvent.requestUpdateVolume(paramInt);
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 25) || (paramInt == 24)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setVolumeControlEnabled(boolean paramBoolean)
  {
    if (this.mVolumeControlEnabled != paramBoolean)
    {
      this.mVolumeControlEnabled = paramBoolean;
      if (this.mCreated) {
        updateVolume();
      }
    }
  }
  
  private final class MediaRouterCallback
    extends MediaRouter.Callback
  {
    private MediaRouterCallback() {}
    
    public void onRouteChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      MediaRouteControllerDialog.this.update();
    }
    
    public void onRouteUnselected(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      MediaRouteControllerDialog.this.update();
    }
    
    public void onRouteVolumeChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      if (paramRouteInfo == MediaRouteControllerDialog.this.mRoute) {
        MediaRouteControllerDialog.this.updateVolume();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/app/MediaRouteControllerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */