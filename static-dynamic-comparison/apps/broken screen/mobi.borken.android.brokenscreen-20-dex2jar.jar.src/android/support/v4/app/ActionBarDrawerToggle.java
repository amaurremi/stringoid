package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private static final int ID_HOME = 16908332;
  private static final ActionBarDrawerToggleImpl IMPL = new ActionBarDrawerToggleImplBase(null);
  private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334F;
  private final Activity mActivity;
  private final Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private Drawable mDrawerImage;
  private final int mDrawerImageResource;
  private boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private final int mOpenDrawerContentDescRes;
  private Object mSetIndicatorInfo;
  private SlideDrawable mSlider;
  private Drawable mThemeImage;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18)
    {
      IMPL = new ActionBarDrawerToggleImplJellybeanMR2(null);
      return;
    }
    if (i >= 11)
    {
      IMPL = new ActionBarDrawerToggleImplHC(null);
      return;
    }
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mActivity = paramActivity;
    if ((paramActivity instanceof DelegateProvider)) {}
    for (this.mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();; this.mActivityImpl = null)
    {
      this.mDrawerLayout = paramDrawerLayout;
      this.mDrawerImageResource = paramInt1;
      this.mOpenDrawerContentDescRes = paramInt2;
      this.mCloseDrawerContentDescRes = paramInt3;
      this.mThemeImage = getThemeUpIndicator();
      this.mDrawerImage = paramActivity.getResources().getDrawable(paramInt1);
      this.mSlider = new SlideDrawable(this.mDrawerImage, null);
      this.mSlider.setOffset(0.33333334F);
      return;
    }
  }
  
  Drawable getThemeUpIndicator()
  {
    if (this.mActivityImpl != null) {
      return this.mActivityImpl.getThemeUpIndicator();
    }
    return IMPL.getThemeUpIndicator(this.mActivity);
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return this.mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mThemeImage = getThemeUpIndicator();
    this.mDrawerImage = this.mActivity.getResources().getDrawable(this.mDrawerImageResource);
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    this.mSlider.setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    this.mSlider.setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    float f = this.mSlider.getPosition();
    if (paramFloat > 0.5F) {}
    for (paramFloat = Math.max(f, Math.max(0.0F, paramFloat - 0.5F) * 2.0F);; paramFloat = Math.min(f, paramFloat * 2.0F))
    {
      this.mSlider.setPosition(paramFloat);
      return;
    }
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.mDrawerIndicatorEnabled))
    {
      if (this.mDrawerLayout.isDrawerVisible(8388611)) {
        this.mDrawerLayout.closeDrawer(8388611);
      }
      for (;;)
      {
        return true;
        this.mDrawerLayout.openDrawer(8388611);
      }
    }
    return false;
  }
  
  void setActionBarDescription(int paramInt)
  {
    if (this.mActivityImpl != null)
    {
      this.mActivityImpl.setActionBarDescription(paramInt);
      return;
    }
    this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if (this.mActivityImpl != null)
    {
      this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
      return;
    }
    this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, paramDrawable, paramInt);
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (!paramBoolean) {
        break label54;
      }
      SlideDrawable localSlideDrawable = this.mSlider;
      if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
        break label46;
      }
      i = this.mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localSlideDrawable, i);
    }
    for (;;)
    {
      this.mDrawerIndicatorEnabled = paramBoolean;
      return;
      label46:
      i = this.mOpenDrawerContentDescRes;
      break;
      label54:
      setActionBarUpIndicator(this.mThemeImage, 0);
    }
  }
  
  public void syncState()
  {
    SlideDrawable localSlideDrawable;
    if (this.mDrawerLayout.isDrawerOpen(8388611))
    {
      this.mSlider.setPosition(1.0F);
      if (this.mDrawerIndicatorEnabled)
      {
        localSlideDrawable = this.mSlider;
        if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
          break label67;
        }
      }
    }
    label67:
    for (int i = this.mCloseDrawerContentDescRes;; i = this.mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localSlideDrawable, i);
      return;
      this.mSlider.setPosition(0.0F);
      break;
    }
  }
  
  private static abstract interface ActionBarDrawerToggleImpl
  {
    public abstract Drawable getThemeUpIndicator(Activity paramActivity);
    
    public abstract Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt);
    
    public abstract Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt);
  }
  
  private static class ActionBarDrawerToggleImplBase
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return null;
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return paramObject;
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return paramObject;
    }
  }
  
  private static class ActionBarDrawerToggleImplHC
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(paramActivity);
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return ActionBarDrawerToggleHoneycomb.setActionBarDescription(paramObject, paramActivity, paramInt);
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(paramObject, paramActivity, paramDrawable, paramInt);
    }
  }
  
  private static class ActionBarDrawerToggleImplJellybeanMR2
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(paramActivity);
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(paramObject, paramActivity, paramInt);
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(paramObject, paramActivity, paramDrawable, paramInt);
    }
  }
  
  public static abstract interface Delegate
  {
    @Nullable
    public abstract Drawable getThemeUpIndicator();
    
    public abstract void setActionBarDescription(int paramInt);
    
    public abstract void setActionBarUpIndicator(Drawable paramDrawable, int paramInt);
  }
  
  public static abstract interface DelegateProvider
  {
    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  private class SlideDrawable
    extends InsetDrawable
    implements Drawable.Callback
  {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    
    private SlideDrawable(Drawable paramDrawable)
    {
      super(0);
      if (Build.VERSION.SDK_INT > 18) {
        bool = true;
      }
      this.mHasMirroring = bool;
      this.mTmpRect = new Rect();
    }
    
    public void draw(Canvas paramCanvas)
    {
      int j = 1;
      copyBounds(this.mTmpRect);
      paramCanvas.save();
      if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          j = -1;
        }
        int k = this.mTmpRect.width();
        paramCanvas.translate(-this.mOffset * k * this.mPosition * j, 0.0F);
        if ((i != 0) && (!this.mHasMirroring))
        {
          paramCanvas.translate(k, 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        super.draw(paramCanvas);
        paramCanvas.restore();
        return;
      }
    }
    
    public float getPosition()
    {
      return this.mPosition;
    }
    
    public void setOffset(float paramFloat)
    {
      this.mOffset = paramFloat;
      invalidateSelf();
    }
    
    public void setPosition(float paramFloat)
    {
      this.mPosition = paramFloat;
      invalidateSelf();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/android/support/v4/app/ActionBarDrawerToggle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */