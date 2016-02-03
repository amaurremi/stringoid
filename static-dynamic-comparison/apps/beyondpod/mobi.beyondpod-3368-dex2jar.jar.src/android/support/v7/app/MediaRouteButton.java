package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.ProviderInfo;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.mediarouter.R.attr;
import android.support.v7.mediarouter.R.styleable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Toast;

public class MediaRouteButton
  extends View
{
  private static final int[] CHECKABLE_STATE_SET = { 16842911 };
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final String CHOOSER_FRAGMENT_TAG = "android.support.v7.mediarouter:MediaRouteChooserDialogFragment";
  private static final String CONTROLLER_FRAGMENT_TAG = "android.support.v7.mediarouter:MediaRouteControllerDialogFragment";
  private static final String TAG = "MediaRouteButton";
  private boolean mAttachedToWindow;
  private final MediaRouterCallback mCallback;
  private boolean mCheatSheetEnabled;
  private MediaRouteDialogFactory mDialogFactory = MediaRouteDialogFactory.getDefault();
  private boolean mIsConnecting;
  private int mMinHeight;
  private int mMinWidth;
  private boolean mRemoteActive;
  private Drawable mRemoteIndicator;
  private final MediaRouter mRouter;
  private MediaRouteSelector mSelector = MediaRouteSelector.EMPTY;
  
  public MediaRouteButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MediaRouteButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.mediaRouteButtonStyle);
  }
  
  public MediaRouteButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MediaRouterThemeHelper.createThemedContext(paramContext, false), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.mRouter = MediaRouter.getInstance(paramContext);
    this.mCallback = new MediaRouterCallback(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MediaRouteButton, paramInt, 0);
    setRemoteIndicatorDrawable(paramContext.getDrawable(2));
    this.mMinWidth = paramContext.getDimensionPixelSize(0, 0);
    this.mMinHeight = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
    setClickable(true);
    setLongClickable(true);
  }
  
  private Activity getActivity()
  {
    for (Context localContext = getContext(); (localContext instanceof ContextWrapper); localContext = ((ContextWrapper)localContext).getBaseContext()) {
      if ((localContext instanceof Activity)) {
        return (Activity)localContext;
      }
    }
    return null;
  }
  
  private FragmentManager getFragmentManager()
  {
    Activity localActivity = getActivity();
    if ((localActivity instanceof FragmentActivity)) {
      return ((FragmentActivity)localActivity).getSupportFragmentManager();
    }
    return null;
  }
  
  private void refreshRoute()
  {
    boolean bool3 = false;
    MediaRouter.RouteInfo localRouteInfo;
    if (this.mAttachedToWindow)
    {
      localRouteInfo = this.mRouter.getSelectedRoute();
      if ((localRouteInfo.isDefault()) || (!localRouteInfo.matchesSelector(this.mSelector))) {
        break label118;
      }
    }
    label118:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (localRouteInfo.isConnecting()) {
          bool2 = true;
        }
      }
      int i = 0;
      if (this.mRemoteActive != bool1)
      {
        this.mRemoteActive = bool1;
        i = 1;
      }
      if (this.mIsConnecting != bool2)
      {
        this.mIsConnecting = bool2;
        i = 1;
      }
      if (i != 0) {
        refreshDrawableState();
      }
      setEnabled(this.mRouter.isRouteAvailable(this.mSelector, 1));
      return;
    }
  }
  
  private void setRemoteIndicatorDrawable(Drawable paramDrawable)
  {
    if (this.mRemoteIndicator != null)
    {
      this.mRemoteIndicator.setCallback(null);
      unscheduleDrawable(this.mRemoteIndicator);
    }
    this.mRemoteIndicator = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      paramDrawable.setState(getDrawableState());
      if (getVisibility() != 0) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      refreshDrawableState();
      return;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mRemoteIndicator != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.mRemoteIndicator.setState(arrayOfInt);
      invalidate();
    }
  }
  
  public MediaRouteDialogFactory getDialogFactory()
  {
    return this.mDialogFactory;
  }
  
  public MediaRouteSelector getRouteSelector()
  {
    return this.mSelector;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    if (getBackground() != null) {
      DrawableCompat.jumpToCurrentState(getBackground());
    }
    if (this.mRemoteIndicator != null) {
      DrawableCompat.jumpToCurrentState(this.mRemoteIndicator);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mAttachedToWindow = true;
    if (!this.mSelector.isEmpty()) {
      this.mRouter.addCallback(this.mSelector, this.mCallback);
    }
    refreshRoute();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (this.mIsConnecting) {
      mergeDrawableStates(arrayOfInt, CHECKABLE_STATE_SET);
    }
    while (!this.mRemoteActive) {
      return arrayOfInt;
    }
    mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    return arrayOfInt;
  }
  
  public void onDetachedFromWindow()
  {
    this.mAttachedToWindow = false;
    if (!this.mSelector.isEmpty()) {
      this.mRouter.removeCallback(this.mCallback);
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mRemoteIndicator != null)
    {
      int i1 = getPaddingLeft();
      int i2 = getWidth();
      int i3 = getPaddingRight();
      int k = getPaddingTop();
      int m = getHeight();
      int n = getPaddingBottom();
      int i = this.mRemoteIndicator.getIntrinsicWidth();
      int j = this.mRemoteIndicator.getIntrinsicHeight();
      i1 += (i2 - i3 - i1 - i) / 2;
      k += (m - n - k - j) / 2;
      this.mRemoteIndicator.setBounds(i1, k, i1 + i, k + j);
      this.mRemoteIndicator.draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 0;
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    int n = this.mMinWidth;
    if (this.mRemoteIndicator != null)
    {
      paramInt1 = this.mRemoteIndicator.getIntrinsicWidth();
      n = Math.max(n, paramInt1);
      int i1 = this.mMinHeight;
      paramInt1 = k;
      if (this.mRemoteIndicator != null) {
        paramInt1 = this.mRemoteIndicator.getIntrinsicHeight();
      }
      k = Math.max(i1, paramInt1);
      switch (m)
      {
      default: 
        paramInt1 = getPaddingLeft() + n + getPaddingRight();
        switch (paramInt2)
        {
        default: 
          label129:
          paramInt2 = getPaddingTop() + k + getPaddingBottom();
        }
        break;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = j;
      break label129;
      paramInt1 = Math.min(j, getPaddingLeft() + n + getPaddingRight());
      break label129;
      paramInt2 = i;
      continue;
      paramInt2 = Math.min(i, getPaddingTop() + k + getPaddingBottom());
    }
  }
  
  public boolean performClick()
  {
    boolean bool1 = false;
    boolean bool2 = super.performClick();
    if (!bool2) {
      playSoundEffect(0);
    }
    if ((showDialog()) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean performLongClick()
  {
    if (super.performLongClick()) {
      return true;
    }
    if (!this.mCheatSheetEnabled) {
      return false;
    }
    Object localObject = getContentDescription();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    int[] arrayOfInt = new int[2];
    Rect localRect = new Rect();
    getLocationOnScreen(arrayOfInt);
    getWindowVisibleDisplayFrame(localRect);
    Context localContext = getContext();
    int i = getWidth();
    int j = getHeight();
    int k = arrayOfInt[1];
    int m = j / 2;
    int n = localContext.getResources().getDisplayMetrics().widthPixels;
    localObject = Toast.makeText(localContext, (CharSequence)localObject, 0);
    if (k + m < localRect.height()) {
      ((Toast)localObject).setGravity(8388661, n - arrayOfInt[0] - i / 2, j);
    }
    for (;;)
    {
      ((Toast)localObject).show();
      performHapticFeedback(0);
      return true;
      ((Toast)localObject).setGravity(81, 0, j);
    }
  }
  
  void setCheatSheetEnabled(boolean paramBoolean)
  {
    this.mCheatSheetEnabled = paramBoolean;
  }
  
  public void setDialogFactory(MediaRouteDialogFactory paramMediaRouteDialogFactory)
  {
    if (paramMediaRouteDialogFactory == null) {
      throw new IllegalArgumentException("factory must not be null");
    }
    this.mDialogFactory = paramMediaRouteDialogFactory;
  }
  
  public void setRouteSelector(MediaRouteSelector paramMediaRouteSelector)
  {
    if (paramMediaRouteSelector == null) {
      throw new IllegalArgumentException("selector must not be null");
    }
    if (!this.mSelector.equals(paramMediaRouteSelector))
    {
      if (this.mAttachedToWindow)
      {
        if (!this.mSelector.isEmpty()) {
          this.mRouter.removeCallback(this.mCallback);
        }
        if (!paramMediaRouteSelector.isEmpty()) {
          this.mRouter.addCallback(paramMediaRouteSelector, this.mCallback);
        }
      }
      this.mSelector = paramMediaRouteSelector;
      refreshRoute();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    Drawable localDrawable;
    if (this.mRemoteIndicator != null)
    {
      localDrawable = this.mRemoteIndicator;
      if (getVisibility() != 0) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      localDrawable.setVisible(bool, false);
      return;
    }
  }
  
  public boolean showDialog()
  {
    if (!this.mAttachedToWindow) {
      return false;
    }
    FragmentManager localFragmentManager = getFragmentManager();
    if (localFragmentManager == null) {
      throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
    }
    Object localObject = this.mRouter.getSelectedRoute();
    if ((((MediaRouter.RouteInfo)localObject).isDefault()) || (!((MediaRouter.RouteInfo)localObject).matchesSelector(this.mSelector)))
    {
      if (localFragmentManager.findFragmentByTag("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null)
      {
        Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
        return false;
      }
      localObject = this.mDialogFactory.onCreateChooserDialogFragment();
      ((MediaRouteChooserDialogFragment)localObject).setRouteSelector(this.mSelector);
      ((MediaRouteChooserDialogFragment)localObject).show(localFragmentManager, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment");
    }
    for (;;)
    {
      return true;
      if (localFragmentManager.findFragmentByTag("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null)
      {
        Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
        return false;
      }
      this.mDialogFactory.onCreateControllerDialogFragment().show(localFragmentManager, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment");
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mRemoteIndicator);
  }
  
  static abstract interface AttachCallback
  {
    public abstract void onAttachedToWindow();
    
    public abstract void onDetachedFromWindow();
  }
  
  private final class MediaRouterCallback
    extends MediaRouter.Callback
  {
    private MediaRouterCallback() {}
    
    public void onProviderAdded(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo)
    {
      MediaRouteButton.this.refreshRoute();
    }
    
    public void onProviderChanged(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo)
    {
      MediaRouteButton.this.refreshRoute();
    }
    
    public void onProviderRemoved(MediaRouter paramMediaRouter, MediaRouter.ProviderInfo paramProviderInfo)
    {
      MediaRouteButton.this.refreshRoute();
    }
    
    public void onRouteAdded(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      MediaRouteButton.this.refreshRoute();
    }
    
    public void onRouteChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      MediaRouteButton.this.refreshRoute();
    }
    
    public void onRouteRemoved(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      MediaRouteButton.this.refreshRoute();
    }
    
    public void onRouteSelected(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      MediaRouteButton.this.refreshRoute();
    }
    
    public void onRouteUnselected(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo)
    {
      MediaRouteButton.this.refreshRoute();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/app/MediaRouteButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */