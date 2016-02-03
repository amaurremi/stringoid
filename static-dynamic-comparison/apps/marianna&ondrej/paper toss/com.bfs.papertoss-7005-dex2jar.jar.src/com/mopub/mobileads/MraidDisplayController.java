package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;

class MraidDisplayController
  extends MraidAbstractController
{
  private static final int CLOSE_BUTTON_SIZE_DP = 50;
  private static final String LOGTAG = "MraidDisplayController";
  private static final long VIEWABILITY_TIMER_MILLIS = 3000L;
  private boolean mAdWantsCustomCloseButton;
  private Runnable mCheckViewabilityTask = new Runnable()
  {
    public void run()
    {
      boolean bool = MraidDisplayController.this.checkViewable();
      if (MraidDisplayController.this.mIsViewable != bool)
      {
        MraidDisplayController.access$002(MraidDisplayController.this, bool);
        MraidDisplayController.this.getView().fireChangeEventForProperty(MraidViewableProperty.createWithViewable(MraidDisplayController.this.mIsViewable));
      }
      MraidDisplayController.this.mHandler.postDelayed(this, 3000L);
    }
  };
  private ImageView mCloseButton;
  protected float mDensity;
  private final MraidView.ExpansionStyle mExpansionStyle;
  private Handler mHandler = new Handler();
  private boolean mIsViewable;
  private final MraidView.NativeCloseButtonStyle mNativeCloseButtonStyle;
  private BroadcastReceiver mOrientationBroadcastReceiver = new BroadcastReceiver()
  {
    private int mLastRotation;
    
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
      {
        int i = MraidDisplayController.this.getDisplayRotation();
        if (i != this.mLastRotation)
        {
          this.mLastRotation = i;
          MraidDisplayController.this.onOrientationChanged(this.mLastRotation);
        }
      }
    }
  };
  private final int mOriginalRequestedOrientation;
  FrameLayout mPlaceholderView;
  private FrameLayout mRootView;
  protected int mScreenHeight = -1;
  protected int mScreenWidth = -1;
  private MraidView mTwoPartExpansionView;
  private int mViewIndexInParent;
  private MraidView.ViewState mViewState = MraidView.ViewState.HIDDEN;
  
  MraidDisplayController(MraidView paramMraidView, MraidView.ExpansionStyle paramExpansionStyle, MraidView.NativeCloseButtonStyle paramNativeCloseButtonStyle)
  {
    super(paramMraidView);
    this.mExpansionStyle = paramExpansionStyle;
    this.mNativeCloseButtonStyle = paramNativeCloseButtonStyle;
    paramMraidView = getView().getContext();
    if ((paramMraidView instanceof Activity)) {
      i = ((Activity)paramMraidView).getRequestedOrientation();
    }
    this.mOriginalRequestedOrientation = i;
    initialize();
  }
  
  private ViewGroup createExpansionViewContainer(View paramView, int paramInt1, int paramInt2)
  {
    int i = (int)(50.0F * this.mDensity + 0.5F);
    int j = paramInt1;
    if (paramInt1 < i) {
      j = i;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < i) {
      paramInt1 = i;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(getView().getContext());
    localRelativeLayout.setId(101);
    Object localObject = new View(getView().getContext());
    ((View)localObject).setBackgroundColor(0);
    ((View)localObject).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    localRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(-1, -1));
    localObject = new FrameLayout(getView().getContext());
    ((FrameLayout)localObject).setId(102);
    ((FrameLayout)localObject).addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
    paramView = new RelativeLayout.LayoutParams(j, paramInt1);
    paramView.addRule(13);
    localRelativeLayout.addView((View)localObject, paramView);
    return localRelativeLayout;
  }
  
  private int getDisplayRotation()
  {
    return ((WindowManager)getView().getContext().getSystemService("window")).getDefaultDisplay().getOrientation();
  }
  
  private void initialize()
  {
    this.mViewState = MraidView.ViewState.LOADING;
    initializeScreenMetrics();
    initializeViewabilityTimer();
    getView().getContext().registerReceiver(this.mOrientationBroadcastReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
  }
  
  private void initializeScreenMetrics()
  {
    Object localObject = getView().getContext();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.mDensity = localDisplayMetrics.density;
    int i = 0;
    int j = 0;
    if ((localObject instanceof Activity))
    {
      localObject = ((Activity)localObject).getWindow();
      Rect localRect = new Rect();
      ((Window)localObject).getDecorView().getWindowVisibleDisplayFrame(localRect);
      i = localRect.top;
      j = ((Window)localObject).findViewById(16908290).getTop() - i;
    }
    int k = localDisplayMetrics.widthPixels;
    int m = localDisplayMetrics.heightPixels;
    this.mScreenWidth = ((int)(k * (160.0D / localDisplayMetrics.densityDpi)));
    this.mScreenHeight = ((int)((m - i - j) * (160.0D / localDisplayMetrics.densityDpi)));
  }
  
  private void initializeViewabilityTimer()
  {
    this.mHandler.removeCallbacks(this.mCheckViewabilityTask);
    this.mHandler.post(this.mCheckViewabilityTask);
  }
  
  private void onOrientationChanged(int paramInt)
  {
    initializeScreenMetrics();
    getView().fireChangeEventForProperty(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
  }
  
  private void resetViewToDefaultState()
  {
    Object localObject = (FrameLayout)this.mRootView.findViewById(102);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(101);
    setNativeCloseButtonEnabled(false);
    ((FrameLayout)localObject).removeAllViewsInLayout();
    this.mRootView.removeView(localRelativeLayout);
    getView().requestLayout();
    localObject = (ViewGroup)this.mPlaceholderView.getParent();
    ((ViewGroup)localObject).addView(getView(), this.mViewIndexInParent);
    ((ViewGroup)localObject).removeView(this.mPlaceholderView);
    ((ViewGroup)localObject).invalidate();
  }
  
  private void setOrientationLockEnabled(boolean paramBoolean)
  {
    Object localObject = getView().getContext();
    try
    {
      localObject = (Activity)localObject;
      if (paramBoolean) {}
      for (int i = ((Activity)localObject).getResources().getConfiguration().orientation;; i = this.mOriginalRequestedOrientation)
      {
        ((Activity)localObject).setRequestedOrientation(i);
        return;
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      Log.d("MraidDisplayController", "Unable to modify device orientation.");
    }
  }
  
  private void swapViewWithPlaceholderView()
  {
    ViewGroup localViewGroup = (ViewGroup)getView().getParent();
    if (localViewGroup == null) {
      return;
    }
    this.mPlaceholderView = new FrameLayout(getView().getContext());
    int j = localViewGroup.getChildCount();
    int i = 0;
    for (;;)
    {
      if ((i >= j) || (localViewGroup.getChildAt(i) == getView()))
      {
        this.mViewIndexInParent = i;
        localViewGroup.addView(this.mPlaceholderView, i, new ViewGroup.LayoutParams(getView().getWidth(), getView().getHeight()));
        localViewGroup.removeView(getView());
        return;
      }
      i += 1;
    }
  }
  
  protected boolean checkViewable()
  {
    return true;
  }
  
  protected void close()
  {
    if (this.mViewState == MraidView.ViewState.EXPANDED)
    {
      resetViewToDefaultState();
      setOrientationLockEnabled(false);
      this.mViewState = MraidView.ViewState.DEFAULT;
      getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
    }
    for (;;)
    {
      if (getView().getOnCloseListener() != null) {
        getView().getOnCloseListener().onClose(getView(), this.mViewState);
      }
      return;
      if (this.mViewState == MraidView.ViewState.DEFAULT)
      {
        getView().setVisibility(4);
        this.mViewState = MraidView.ViewState.HIDDEN;
        getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
      }
    }
  }
  
  public void destroy()
  {
    this.mHandler.removeCallbacks(this.mCheckViewabilityTask);
    try
    {
      getView().getContext().unregisterReceiver(this.mOrientationBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (localIllegalArgumentException.getMessage().contains("Receiver not registered")) {}
      throw localIllegalArgumentException;
    }
  }
  
  protected void expand(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mExpansionStyle == MraidView.ExpansionStyle.DISABLED) {}
    do
    {
      return;
      if ((paramString != null) && (!URLUtil.isValidUrl(paramString)))
      {
        getView().fireErrorEvent("expand", "URL passed to expand() was invalid.");
        return;
      }
      this.mRootView = ((FrameLayout)getView().getRootView().findViewById(16908290));
      useCustomClose(paramBoolean1);
      setOrientationLockEnabled(paramBoolean2);
      swapViewWithPlaceholderView();
      MraidView localMraidView = getView();
      if (paramString != null)
      {
        this.mTwoPartExpansionView = new MraidView(getView().getContext(), MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.AD_CONTROLLED, MraidView.PlacementType.INLINE);
        this.mTwoPartExpansionView.setOnCloseListener(new MraidView.OnCloseListener()
        {
          public void onClose(MraidView paramAnonymousMraidView, MraidView.ViewState paramAnonymousViewState)
          {
            MraidDisplayController.this.close();
          }
        });
        this.mTwoPartExpansionView.loadUrl(paramString);
        localMraidView = this.mTwoPartExpansionView;
      }
      paramString = createExpansionViewContainer(localMraidView, (int)(paramInt1 * this.mDensity), (int)(paramInt2 * this.mDensity));
      this.mRootView.addView(paramString, new RelativeLayout.LayoutParams(-1, -1));
      if ((this.mNativeCloseButtonStyle == MraidView.NativeCloseButtonStyle.ALWAYS_VISIBLE) || ((!this.mAdWantsCustomCloseButton) && (this.mNativeCloseButtonStyle != MraidView.NativeCloseButtonStyle.ALWAYS_HIDDEN))) {
        setNativeCloseButtonEnabled(true);
      }
      this.mViewState = MraidView.ViewState.EXPANDED;
      getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
    } while (getView().getOnExpandListener() == null);
    getView().getOnExpandListener().onExpand(getView());
  }
  
  protected void initializeJavaScriptState()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
    localArrayList.add(MraidViewableProperty.createWithViewable(this.mIsViewable));
    getView().fireChangeEventForProperties(localArrayList);
    this.mViewState = MraidView.ViewState.DEFAULT;
    getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
  }
  
  protected boolean isExpanded()
  {
    return this.mViewState == MraidView.ViewState.EXPANDED;
  }
  
  protected void setNativeCloseButtonEnabled(boolean paramBoolean)
  {
    if (this.mRootView == null) {
      return;
    }
    Object localObject1 = (FrameLayout)this.mRootView.findViewById(102);
    if (paramBoolean)
    {
      if (this.mCloseButton == null)
      {
        localObject2 = new StateListDrawable();
        Drawable localDrawable = getView().getResources().getDrawable(R.drawable.close_button_normal);
        ((StateListDrawable)localObject2).addState(new int[] { -16842919 }, localDrawable);
        localDrawable = getView().getResources().getDrawable(R.drawable.close_button_pressed);
        ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, localDrawable);
        this.mCloseButton = new ImageButton(getView().getContext());
        this.mCloseButton.setImageDrawable((Drawable)localObject2);
        this.mCloseButton.setBackgroundDrawable(null);
        this.mCloseButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MraidDisplayController.this.close();
          }
        });
      }
      int i = (int)(50.0F * this.mDensity + 0.5F);
      Object localObject2 = new FrameLayout.LayoutParams(i, i, 5);
      ((FrameLayout)localObject1).addView(this.mCloseButton, (ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      localObject1 = getView();
      if (((MraidView)localObject1).getOnCloseButtonStateChangeListener() == null) {
        break;
      }
      ((MraidView)localObject1).getOnCloseButtonStateChangeListener().onCloseButtonStateChange((MraidView)localObject1, paramBoolean);
      return;
      ((FrameLayout)localObject1).removeView(this.mCloseButton);
    }
  }
  
  protected void useCustomClose(boolean paramBoolean)
  {
    this.mAdWantsCustomCloseButton = paramBoolean;
    MraidView localMraidView = getView();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (localMraidView.getOnCloseButtonStateChangeListener() != null) {
        localMraidView.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(localMraidView, paramBoolean);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */