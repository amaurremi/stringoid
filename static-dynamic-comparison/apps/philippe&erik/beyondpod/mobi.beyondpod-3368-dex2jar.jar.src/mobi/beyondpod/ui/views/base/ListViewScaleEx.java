package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import mobi.beyondpod.ui.core.ScaleGestureHelper;
import mobi.beyondpod.ui.core.ScaleGestureHelper.OnScaleGestureListener;

public class ListViewScaleEx
  extends ListViewEx
{
  ScaleScrollInfoListener _ScaleScrollInfoListener = null;
  ScaleGestureHelper _scaleDetector;
  
  public ListViewScaleEx(Context paramContext)
  {
    super(paramContext);
    InitializeView();
  }
  
  public ListViewScaleEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    InitializeView();
  }
  
  public ListViewScaleEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    InitializeView();
  }
  
  protected void InitializeView()
  {
    super.InitializeView();
    this._scaleDetector = ScaleGestureHelper.getInstance();
    this._scaleDetector.Initialize(getContext(), new ScaleListener());
  }
  
  protected void OnItemChecked(int paramInt)
  {
    if (this._ScaleScrollInfoListener != null) {
      this._ScaleScrollInfoListener.ItemChecked(paramInt);
    }
  }
  
  protected void OnItemSelected(int paramInt)
  {
    if (this._ScaleScrollInfoListener != null) {
      this._ScaleScrollInfoListener.ItemSelected(paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this._scaleDetector.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setScaleScrollListener(ScaleScrollInfoListener paramScaleScrollInfoListener)
  {
    this._ScaleScrollInfoListener = paramScaleScrollInfoListener;
  }
  
  public class ScaleListener
    implements ScaleGestureHelper.OnScaleGestureListener
  {
    public ScaleListener() {}
    
    public boolean onScale(float paramFloat)
    {
      if (paramFloat > 1.1D) {
        if (ListViewScaleEx.this._ScaleScrollInfoListener != null) {
          ListViewScaleEx.this._ScaleScrollInfoListener.onExpand();
        }
      }
      do
      {
        return true;
        if (paramFloat >= 0.9D) {
          break;
        }
      } while (ListViewScaleEx.this._ScaleScrollInfoListener == null);
      ListViewScaleEx.this._ScaleScrollInfoListener.onCollapse();
      return true;
      return false;
    }
  }
  
  public static abstract interface ScaleScrollInfoListener
  {
    public abstract void ItemChecked(int paramInt);
    
    public abstract void ItemSelected(int paramInt);
    
    public abstract void onCollapse();
    
    public abstract void onExpand();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/ListViewScaleEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */