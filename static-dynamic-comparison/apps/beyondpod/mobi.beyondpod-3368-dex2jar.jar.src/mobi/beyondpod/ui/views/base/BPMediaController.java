package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VideoView;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.services.player.impl.ChromecastDevice;
import mobi.beyondpod.ui.core.mediarouter.BPMediaRouteDialogFactory;
import mobi.beyondpod.ui.core.mediarouter.MediaRouteButton;

public class BPMediaController
  extends RelativeLayout
{
  private static final int SHOW_PROGRESS = 2;
  public static final int TOOLBAR_TIMEOUT_LONG = 3600000;
  public static final long TOOLBAR_TIMEOUT_SHORT = 3000L;
  private TextView _CurrentTime;
  private ImageView _Home;
  protected long _LastSeekEventTime;
  ViewGroup _MediaController;
  MediaRouteButton _MediaRouteButton;
  final Handler _NavigationHandler = new Handler();
  Runnable _NavigationRunnable = new Runnable()
  {
    public void run()
    {
      BPMediaController.this.toggleControls(false);
      if (BPMediaController.this._Owner != null) {
        BPMediaController.this._Owner.HideNavigation();
      }
    }
  };
  IViewOwner _Owner;
  private ImageButton _PlayPause;
  private View.OnClickListener _PlayPauseListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      BPMediaController.this.DoPlayPause();
    }
  };
  private TextView _RamainingTime;
  private RepeatingImageButton _SkipBack;
  private RepeatingImageButton.RepeatListener _SkipBackLongClickListener = new RepeatingImageButton.RepeatListener()
  {
    public void onRepeat(View paramAnonymousView, long paramAnonymousLong, int paramAnonymousInt)
    {
      BPMediaController.this.scanBackward(paramAnonymousInt, (int)paramAnonymousLong);
    }
  };
  private View.OnClickListener _SkipBackwardClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      BPMediaController.this.DoSkipBack();
    }
  };
  private RepeatingImageButton _SkipForward;
  private View.OnClickListener _SkipForwardClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      BPMediaController.this.DoSkipForward();
    }
  };
  private RepeatingImageButton.RepeatListener _SkipForwardLongClickListener = new RepeatingImageButton.RepeatListener()
  {
    public void onRepeat(View paramAnonymousView, long paramAnonymousLong, int paramAnonymousInt)
    {
      BPMediaController.this.scanForward(paramAnonymousInt, (int)paramAnonymousLong);
    }
  };
  private ImageView _SkipToEnd;
  private View.OnClickListener _SkipToEndClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (mobi.beyondpod.rsscore.Configuration.SkipToEndButtonClickType() == 1) {
        BPMediaController.this.DoSkipToEnd();
      }
    }
  };
  private View.OnLongClickListener _SkipToEndOnLongClickListener = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramAnonymousView)
    {
      if (mobi.beyondpod.rsscore.Configuration.SkipToEndButtonClickType() == 2) {
        BPMediaController.this.DoSkipToEnd();
      }
      return false;
    }
  };
  private int _StartSeekPos = 0;
  private TextView _SubTitle;
  private TextView _Title;
  private boolean mDragging;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      int i;
      do
      {
        return;
        i = BPMediaController.this.setProgress();
      } while ((BPMediaController.this.mDragging) || (!BPMediaController.this.mShowing) || (!BPMediaController.this.mPlayer.isPlaying()));
      sendMessageDelayed(obtainMessage(2), 1000 - i % 1000);
    }
  };
  private VideoView mPlayer;
  private ProgressBar mProgress;
  private SeekBar.OnSeekBarChangeListener mSeekListener = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      long l1 = BPMediaController.this.mPlayer.getDuration();
      long l2 = paramAnonymousInt * l1 / 1000L;
      BPMediaController.this.mPlayer.seekTo((int)l2);
      BPMediaController.this._RamainingTime.setText("-" + CoreHelper.FormatTimeAsString((l1 - l2) / 1000L, true));
      BPMediaController.this._CurrentTime.setText(CoreHelper.FormatTimeAsString(l2 / 1000L, true));
    }
    
    public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      BPMediaController.this.show(3600000L);
      BPMediaController.this.mDragging = true;
      BPMediaController.this.mHandler.removeMessages(2);
    }
    
    public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      BPMediaController.this.mDragging = false;
      BPMediaController.this.setProgress();
      BPMediaController.this.updatePausePlay();
      BPMediaController.this.show(3000L);
      BPMediaController.this.mHandler.sendEmptyMessage(2);
    }
  };
  private boolean mShowing;
  
  public BPMediaController(Context paramContext)
  {
    super(paramContext);
  }
  
  public BPMediaController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BPMediaController(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void ShowAndAutoHideNavigation(long paramLong)
  {
    toggleControls(true);
    if (this._Owner != null) {
      this._Owner.ShowNavigation();
    }
    HideNavigationDelayed(paramLong);
  }
  
  private void doPauseResume()
  {
    if (this.mPlayer.isPlaying()) {
      this._Owner.DoPause();
    }
    for (;;)
    {
      updatePausePlay();
      return;
      this._Owner.DoStart();
    }
  }
  
  private void initControllerView(View paramView)
  {
    this._PlayPause = ((ImageButton)paramView.findViewById(2131231109));
    if (this._PlayPause != null)
    {
      this._PlayPause.requestFocus();
      this._PlayPause.setOnClickListener(this._PlayPauseListener);
    }
    this._SkipForward = ((RepeatingImageButton)findViewById(2131231110));
    this._SkipForward.setOnClickListener(this._SkipForwardClickListener);
    this._SkipForward.setRepeatListener(this._SkipForwardLongClickListener, 260L);
    this._SkipBack = ((RepeatingImageButton)findViewById(2131231108));
    this._SkipBack.setOnClickListener(this._SkipBackwardClickListener);
    this._SkipBack.setRepeatListener(this._SkipBackLongClickListener, 260L);
    this._SkipToEnd = ((ImageButton)findViewById(2131231111));
    this._SkipToEnd.setOnClickListener(this._SkipToEndClickListener);
    this._SkipToEnd.setOnLongClickListener(this._SkipToEndOnLongClickListener);
    updateSkipToEndVisibility();
    this.mProgress = ((ProgressBar)paramView.findViewById(16908301));
    if (this.mProgress != null)
    {
      if ((this.mProgress instanceof SeekBar)) {
        ((SeekBar)this.mProgress).setOnSeekBarChangeListener(this.mSeekListener);
      }
      this.mProgress.setMax(1000);
    }
    this._RamainingTime = ((TextView)paramView.findViewById(2131231115));
    this._CurrentTime = ((TextView)paramView.findViewById(2131231114));
    this._Title = ((TextView)paramView.findViewById(2131231104));
    this._SubTitle = ((TextView)paramView.findViewById(2131231105));
    this._Home = ((ImageView)paramView.findViewById(2131230876));
    this._Home.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BPMediaController.this._Owner.RequestCloseView();
      }
    });
    this._MediaRouteButton = ((MediaRouteButton)findViewById(2131230866));
    this._MediaRouteButton.setRouteSelector(BeyondPodApplication.GetInstance().ChromecastDevice().getRouteSelector());
    this._MediaRouteButton.setDialogFactory(new BPMediaRouteDialogFactory());
  }
  
  private void scanBackward(int paramInt1, int paramInt2)
  {
    if (this.mPlayer == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      this._StartSeekPos = this.mPlayer.getCurrentPosition();
      this._LastSeekEventTime = 0L;
      HideNavigationDelayed(3000L);
      return;
    }
    if (paramInt2 < 5000) {
      paramInt2 *= 10;
    }
    for (;;)
    {
      int j = this._StartSeekPos - paramInt2;
      int i = j;
      if (j < 0)
      {
        this._StartSeekPos = 0;
        i = j + this._StartSeekPos;
      }
      if ((paramInt2 - this._LastSeekEventTime > 250L) || (paramInt1 < 0))
      {
        this.mPlayer.seekTo(i);
        this._LastSeekEventTime = paramInt2;
      }
      setProgress();
      break;
      paramInt2 = 50000 + (paramInt2 - 5000) * 40;
    }
  }
  
  private void scanForward(int paramInt1, int paramInt2)
  {
    if (this.mPlayer == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      this._StartSeekPos = this.mPlayer.getCurrentPosition();
      this._LastSeekEventTime = 0L;
      HideNavigationDelayed(3000L);
      return;
    }
    if (paramInt2 < 5000) {
      paramInt2 *= 10;
    }
    for (;;)
    {
      int j = this._StartSeekPos + paramInt2;
      int k = this.mPlayer.getDuration();
      int i = j;
      if (j >= k)
      {
        this._StartSeekPos = (k - 1000);
        i = this._StartSeekPos;
      }
      if ((paramInt2 - this._LastSeekEventTime > 250L) || (paramInt1 < 0))
      {
        this.mPlayer.seekTo(i);
        this._LastSeekEventTime = paramInt2;
      }
      setProgress();
      break;
      paramInt2 = 50000 + (paramInt2 - 5000) * 40;
    }
  }
  
  private int setProgress()
  {
    if ((this.mPlayer == null) || (this.mDragging)) {
      return 0;
    }
    int j = this.mPlayer.getCurrentPosition();
    int k = this.mPlayer.getDuration();
    int i;
    ProgressBar localProgressBar;
    if (this.mProgress != null)
    {
      if (k > 0)
      {
        long l = 1000L * j / k;
        this.mProgress.setProgress((int)l);
      }
      i = this.mPlayer.getBufferPercentage();
      localProgressBar = this.mProgress;
      if ((i != 0) || (j <= 0)) {
        break label150;
      }
      i = 1000;
    }
    for (;;)
    {
      localProgressBar.setSecondaryProgress(i);
      this._RamainingTime.setText("-" + CoreHelper.FormatTimeAsString((k - j) / 1000, true));
      this._CurrentTime.setText(CoreHelper.FormatTimeAsString(j / 1000, true));
      return j;
      label150:
      i *= 10;
    }
  }
  
  private void updatePausePlay()
  {
    if (this._PlayPause == null) {
      return;
    }
    if (this.mPlayer.isPlaying())
    {
      this._PlayPause.setImageResource(2130837752);
      return;
    }
    this._PlayPause.setImageResource(2130837753);
  }
  
  private void updateSkipToEndVisibility()
  {
    ImageView localImageView = this._SkipToEnd;
    if ((mobi.beyondpod.rsscore.Configuration.SkipToEndButtonClickType() != 3) && (getResources().getBoolean(2131427336))) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void DoPlayNextTrack()
  {
    this.mHandler.removeMessages(2);
    if (this._Owner != null) {
      this._Owner.GoToNextTrack();
    }
  }
  
  public void DoPlayPause()
  {
    doPauseResume();
    show(3000L);
  }
  
  public void DoSkipBack()
  {
    if (this.mPlayer == null) {
      return;
    }
    int i = this.mPlayer.getCurrentPosition() - mobi.beyondpod.rsscore.Configuration.getBackwardSkipInterval() * 1000;
    int j = this.mPlayer.getDuration();
    if (i > j) {
      this.mPlayer.seekTo(j - 1000);
    }
    for (;;)
    {
      setProgress();
      show(3000L);
      return;
      this.mPlayer.seekTo(i);
    }
  }
  
  public void DoSkipForward()
  {
    if (this.mPlayer == null) {
      return;
    }
    int i = this.mPlayer.getCurrentPosition() + mobi.beyondpod.rsscore.Configuration.getForwardSkipInterval() * 1000;
    int j = this.mPlayer.getDuration();
    if (i > j) {
      this.mPlayer.seekTo(j - 1000);
    }
    for (;;)
    {
      setProgress();
      show(3000L);
      return;
      this.mPlayer.seekTo(i);
    }
  }
  
  public void DoSkipToEnd()
  {
    this.mHandler.removeMessages(2);
    this.mProgress.setProgress(this.mProgress.getMax());
    if (this._Owner != null) {
      this._Owner.SkipToEnd();
    }
  }
  
  public void HideNavigationDelayed(long paramLong)
  {
    this._NavigationHandler.removeCallbacks(this._NavigationRunnable);
    if (this.mPlayer.isPlaying()) {
      this._NavigationHandler.postDelayed(this._NavigationRunnable, paramLong);
    }
  }
  
  public void Initialize(IViewOwner paramIViewOwner)
  {
    this._Owner = paramIViewOwner;
    this.mPlayer = ((VideoView)findViewById(2131231102));
    this._MediaController = ((ViewGroup)findViewById(2131231103));
    initControllerView(this);
    this._MediaController.setFocusable(true);
    this._MediaController.setFocusableInTouchMode(true);
    this._MediaController.setDescendantFocusability(262144);
    this._MediaController.requestFocus();
    UpdateTimeAndPosition();
  }
  
  public void UpdateTimeAndPosition()
  {
    updatePausePlay();
    this.mHandler.sendEmptyMessage(2);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int k = paramKeyEvent.getKeyCode();
    int j;
    int i;
    if ((paramKeyEvent.getRepeatCount() == 0) && (paramKeyEvent.getAction() == 0))
    {
      j = 1;
      switch (k)
      {
      default: 
        i = 0;
        if (i != 0)
        {
          show(3000L);
          updatePausePlay();
        }
        break;
      }
    }
    while ((k == 85) || (k == 126) || (k == 127) || (k == 87) || (k == 88) || (k == 90) || (k == 89) || (k == 130) || (k == 128) || (k == 129) || (k == 130))
    {
      return true;
      doPauseResume();
      i = j;
      break;
      this._Owner.DoPause();
      i = j;
      break;
      this._Owner.DoStart();
      i = j;
      break;
      i = j;
      if (!this.mPlayer.isPlaying()) {
        break;
      }
      this._Owner.DoPause();
      updatePausePlay();
      i = j;
      break;
      this._SkipForwardClickListener.onClick(null);
      i = j;
      break;
      this._SkipBackwardClickListener.onClick(null);
      i = j;
      break;
      i = j;
      if (this._Owner == null) {
        break;
      }
      this._Owner.GoToNextTrack();
      i = j;
      break;
      i = j;
      if (this._Owner == null) {
        break;
      }
      this._Owner.GoToPreviousTrack();
      i = j;
      break;
      i = j;
      if (!paramKeyEvent.isShiftPressed()) {
        break;
      }
      this._Owner.SkipToEnd();
      i = j;
      break;
      if ((k == 25) || (k == 24)) {
        return super.dispatchKeyEvent(paramKeyEvent);
      }
      show(3000L);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean isVisible()
  {
    return this._MediaController.getVisibility() == 0;
  }
  
  protected void onConfigurationChanged(android.content.res.Configuration paramConfiguration)
  {
    updateSkipToEndVisibility();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (CoreHelper.ApiLevel() < 11)
    {
      show(3000L);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTitle(String paramString1, String paramString2)
  {
    this._Title.setText(paramString1);
    this._SubTitle.setText(paramString2);
  }
  
  public void show(long paramLong)
  {
    if ((!isVisible()) && (this._PlayPause != null)) {
      this._PlayPause.requestFocus();
    }
    UpdateTimeAndPosition();
    ShowAndAutoHideNavigation(paramLong);
  }
  
  public void toggleControls(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this._MediaController;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public static abstract interface IViewOwner
  {
    public abstract void DoPause();
    
    public abstract void DoStart();
    
    public abstract void GoToNextTrack();
    
    public abstract void GoToPreviousTrack();
    
    public abstract void HideNavigation();
    
    public abstract void RequestCloseView();
    
    public abstract void ShowNavigation();
    
    public abstract void SkipToEnd();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/BPMediaController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */