package com.venticake.retrica.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class RetricaGLSurfaceView
  extends GLSurfaceView
{
  private RetricaBlurTouchEventDispatcher eventDispatcher = null;
  
  public RetricaGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    _init(paramContext);
  }
  
  public RetricaGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    _init(paramContext);
  }
  
  private void _init(Context paramContext)
  {
    this.eventDispatcher = new RetricaBlurTouchEventDispatcher(paramContext);
  }
  
  public RetricaBlurTouchEventDispatcher eventDispatcher()
  {
    return this.eventDispatcher;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.eventDispatcher.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.eventDispatcher.onTouchEvent(paramMotionEvent);
  }
  
  public void setEventListner(RetricaBlurTouchEventListener paramRetricaBlurTouchEventListener)
  {
    this.eventDispatcher.setEventListner(paramRetricaBlurTouchEventListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/RetricaGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */