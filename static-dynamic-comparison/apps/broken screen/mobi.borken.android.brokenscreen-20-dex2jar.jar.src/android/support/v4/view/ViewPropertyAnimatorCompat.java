package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public class ViewPropertyAnimatorCompat
{
  static final ViewPropertyAnimatorCompatImpl IMPL = new BaseViewPropertyAnimatorCompatImpl();
  private static final String TAG = "ViewAnimatorCompat";
  private WeakReference<View> mView;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18)
    {
      IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 16)
    {
      IMPL = new JBViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 14)
    {
      IMPL = new ICSViewPropertyAnimatorCompatImpl();
      return;
    }
  }
  
  ViewPropertyAnimatorCompat(View paramView)
  {
    this.mView = new WeakReference(paramView);
  }
  
  public ViewPropertyAnimatorCompat alpha(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.alpha(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat alphaBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.alphaBy(localView, paramFloat);
    }
    return this;
  }
  
  public void cancel()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.cancel(localView);
    }
  }
  
  public long getDuration()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      return IMPL.getDuration(localView);
    }
    return 0L;
  }
  
  public Interpolator getInterpolator()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      return IMPL.getInterpolator(localView);
    }
    return null;
  }
  
  public long getStartDelay()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      return IMPL.getStartDelay(localView);
    }
    return 0L;
  }
  
  public ViewPropertyAnimatorCompat rotation(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotation(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationBy(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationX(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationX(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationXBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationXBy(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationY(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationY(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationYBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationYBy(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleX(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.scaleX(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleXBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.scaleXBy(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleY(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.scaleY(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleYBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.scaleYBy(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setDuration(long paramLong)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setDuration(localView, paramLong);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setInterpolator(Interpolator paramInterpolator)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setInterpolator(localView, paramInterpolator);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setListener(localView, paramViewPropertyAnimatorListener);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setStartDelay(long paramLong)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setStartDelay(localView, paramLong);
    }
    return this;
  }
  
  public void start()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.start(localView);
    }
  }
  
  public ViewPropertyAnimatorCompat translationX(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.translationX(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationXBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.translationXBy(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationY(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.translationY(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationYBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.translationYBy(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat withEndAction(Runnable paramRunnable)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.withEndAction(localView, paramRunnable);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat withLayer()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.withLayer(localView);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat withStartAction(Runnable paramRunnable)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.withStartAction(localView, paramRunnable);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat x(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.x(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat xBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.xBy(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat y(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.y(localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat yBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.yBy(localView, paramFloat);
    }
    return this;
  }
  
  static class BaseViewPropertyAnimatorCompatImpl
    implements ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
  {
    public void alpha(View paramView, float paramFloat) {}
    
    public void alphaBy(View paramView, float paramFloat) {}
    
    public void cancel(View paramView) {}
    
    public long getDuration(View paramView)
    {
      return 0L;
    }
    
    public Interpolator getInterpolator(View paramView)
    {
      return null;
    }
    
    public long getStartDelay(View paramView)
    {
      return 0L;
    }
    
    public void rotation(View paramView, float paramFloat) {}
    
    public void rotationBy(View paramView, float paramFloat) {}
    
    public void rotationX(View paramView, float paramFloat) {}
    
    public void rotationXBy(View paramView, float paramFloat) {}
    
    public void rotationY(View paramView, float paramFloat) {}
    
    public void rotationYBy(View paramView, float paramFloat) {}
    
    public void scaleX(View paramView, float paramFloat) {}
    
    public void scaleXBy(View paramView, float paramFloat) {}
    
    public void scaleY(View paramView, float paramFloat) {}
    
    public void scaleYBy(View paramView, float paramFloat) {}
    
    public void setDuration(View paramView, long paramLong) {}
    
    public void setInterpolator(View paramView, Interpolator paramInterpolator) {}
    
    public void setListener(View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener) {}
    
    public void setStartDelay(View paramView, long paramLong) {}
    
    public void start(View paramView) {}
    
    public void translationX(View paramView, float paramFloat) {}
    
    public void translationXBy(View paramView, float paramFloat) {}
    
    public void translationY(View paramView, float paramFloat) {}
    
    public void translationYBy(View paramView, float paramFloat) {}
    
    public void withEndAction(View paramView, Runnable paramRunnable)
    {
      paramRunnable.run();
    }
    
    public void withLayer(View paramView) {}
    
    public void withStartAction(View paramView, Runnable paramRunnable)
    {
      paramRunnable.run();
    }
    
    public void x(View paramView, float paramFloat) {}
    
    public void xBy(View paramView, float paramFloat) {}
    
    public void y(View paramView, float paramFloat) {}
    
    public void yBy(View paramView, float paramFloat) {}
  }
  
  static class ICSViewPropertyAnimatorCompatImpl
    extends ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl
  {
    public void alpha(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.alpha(paramView, paramFloat);
    }
    
    public void alphaBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.alphaBy(paramView, paramFloat);
    }
    
    public void cancel(View paramView)
    {
      ViewPropertyAnimatorCompatICS.cancel(paramView);
    }
    
    public long getDuration(View paramView)
    {
      return ViewPropertyAnimatorCompatICS.getDuration(paramView);
    }
    
    public long getStartDelay(View paramView)
    {
      return ViewPropertyAnimatorCompatICS.getStartDelay(paramView);
    }
    
    public void rotation(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.rotation(paramView, paramFloat);
    }
    
    public void rotationBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.rotationBy(paramView, paramFloat);
    }
    
    public void rotationX(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.rotationX(paramView, paramFloat);
    }
    
    public void rotationXBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.rotationXBy(paramView, paramFloat);
    }
    
    public void rotationY(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.rotationY(paramView, paramFloat);
    }
    
    public void rotationYBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.rotationYBy(paramView, paramFloat);
    }
    
    public void scaleX(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.scaleX(paramView, paramFloat);
    }
    
    public void scaleXBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.scaleXBy(paramView, paramFloat);
    }
    
    public void scaleY(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.scaleY(paramView, paramFloat);
    }
    
    public void scaleYBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.scaleYBy(paramView, paramFloat);
    }
    
    public void setDuration(View paramView, long paramLong)
    {
      ViewPropertyAnimatorCompatICS.setDuration(paramView, paramLong);
    }
    
    public void setInterpolator(View paramView, Interpolator paramInterpolator)
    {
      ViewPropertyAnimatorCompatICS.setInterpolator(paramView, paramInterpolator);
    }
    
    public void setListener(View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
    {
      ViewPropertyAnimatorCompatICS.setListener(paramView, paramViewPropertyAnimatorListener);
    }
    
    public void setStartDelay(View paramView, long paramLong)
    {
      ViewPropertyAnimatorCompatICS.setStartDelay(paramView, paramLong);
    }
    
    public void start(View paramView)
    {
      ViewPropertyAnimatorCompatICS.start(paramView);
    }
    
    public void translationX(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.translationX(paramView, paramFloat);
    }
    
    public void translationXBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.translationXBy(paramView, paramFloat);
    }
    
    public void translationY(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.translationY(paramView, paramFloat);
    }
    
    public void translationYBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.translationYBy(paramView, paramFloat);
    }
    
    public void withEndAction(View paramView, final Runnable paramRunnable)
    {
      setListener(paramView, new ViewPropertyAnimatorListener()
      {
        public void onAnimationCancel(View paramAnonymousView) {}
        
        public void onAnimationEnd(View paramAnonymousView)
        {
          paramRunnable.run();
          ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.this.setListener(paramAnonymousView, null);
        }
        
        public void onAnimationStart(View paramAnonymousView) {}
      });
    }
    
    public void withLayer(View paramView)
    {
      setListener(paramView, new ViewPropertyAnimatorListener()
      {
        public void onAnimationCancel(View paramAnonymousView) {}
        
        public void onAnimationEnd(View paramAnonymousView)
        {
          ViewCompat.setLayerType(paramAnonymousView, this.val$currentLayerType, null);
          ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.this.setListener(paramAnonymousView, null);
        }
        
        public void onAnimationStart(View paramAnonymousView)
        {
          ViewCompat.setLayerType(paramAnonymousView, 2, null);
        }
      });
    }
    
    public void withStartAction(View paramView, final Runnable paramRunnable)
    {
      setListener(paramView, new ViewPropertyAnimatorListener()
      {
        public void onAnimationCancel(View paramAnonymousView) {}
        
        public void onAnimationEnd(View paramAnonymousView) {}
        
        public void onAnimationStart(View paramAnonymousView)
        {
          paramRunnable.run();
          ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.this.setListener(paramAnonymousView, null);
        }
      });
    }
    
    public void x(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.x(paramView, paramFloat);
    }
    
    public void xBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.xBy(paramView, paramFloat);
    }
    
    public void y(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.y(paramView, paramFloat);
    }
    
    public void yBy(View paramView, float paramFloat)
    {
      ViewPropertyAnimatorCompatICS.yBy(paramView, paramFloat);
    }
  }
  
  static class JBMr2ViewPropertyAnimatorCompatImpl
    extends ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl
  {
    public Interpolator getInterpolator(View paramView)
    {
      return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(paramView);
    }
  }
  
  static class JBViewPropertyAnimatorCompatImpl
    extends ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl
  {
    public void withEndAction(View paramView, Runnable paramRunnable)
    {
      ViewPropertyAnimatorCompatJB.withEndAction(paramView, paramRunnable);
    }
    
    public void withLayer(View paramView)
    {
      ViewPropertyAnimatorCompatJB.withLayer(paramView);
    }
    
    public void withStartAction(View paramView, Runnable paramRunnable)
    {
      ViewPropertyAnimatorCompatJB.withStartAction(paramView, paramRunnable);
    }
  }
  
  static abstract interface ViewPropertyAnimatorCompatImpl
  {
    public abstract void alpha(View paramView, float paramFloat);
    
    public abstract void alphaBy(View paramView, float paramFloat);
    
    public abstract void cancel(View paramView);
    
    public abstract long getDuration(View paramView);
    
    public abstract Interpolator getInterpolator(View paramView);
    
    public abstract long getStartDelay(View paramView);
    
    public abstract void rotation(View paramView, float paramFloat);
    
    public abstract void rotationBy(View paramView, float paramFloat);
    
    public abstract void rotationX(View paramView, float paramFloat);
    
    public abstract void rotationXBy(View paramView, float paramFloat);
    
    public abstract void rotationY(View paramView, float paramFloat);
    
    public abstract void rotationYBy(View paramView, float paramFloat);
    
    public abstract void scaleX(View paramView, float paramFloat);
    
    public abstract void scaleXBy(View paramView, float paramFloat);
    
    public abstract void scaleY(View paramView, float paramFloat);
    
    public abstract void scaleYBy(View paramView, float paramFloat);
    
    public abstract void setDuration(View paramView, long paramLong);
    
    public abstract void setInterpolator(View paramView, Interpolator paramInterpolator);
    
    public abstract void setListener(View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener);
    
    public abstract void setStartDelay(View paramView, long paramLong);
    
    public abstract void start(View paramView);
    
    public abstract void translationX(View paramView, float paramFloat);
    
    public abstract void translationXBy(View paramView, float paramFloat);
    
    public abstract void translationY(View paramView, float paramFloat);
    
    public abstract void translationYBy(View paramView, float paramFloat);
    
    public abstract void withEndAction(View paramView, Runnable paramRunnable);
    
    public abstract void withLayer(View paramView);
    
    public abstract void withStartAction(View paramView, Runnable paramRunnable);
    
    public abstract void x(View paramView, float paramFloat);
    
    public abstract void xBy(View paramView, float paramFloat);
    
    public abstract void y(View paramView, float paramFloat);
    
    public abstract void yBy(View paramView, float paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/android/support/v4/view/ViewPropertyAnimatorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */