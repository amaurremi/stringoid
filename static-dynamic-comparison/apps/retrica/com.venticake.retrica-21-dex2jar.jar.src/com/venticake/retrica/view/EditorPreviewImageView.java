package com.venticake.retrica.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class EditorPreviewImageView
  extends ImageView
  implements View.OnTouchListener
{
  private RetricaBlurTouchEventDispatcher eventDispatcher = null;
  private Paint mDebuggerPaint;
  
  public EditorPreviewImageView(Context paramContext)
  {
    super(paramContext);
    _init(paramContext);
  }
  
  public EditorPreviewImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    _init(paramContext);
  }
  
  public EditorPreviewImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    _init(paramContext);
  }
  
  private void _init(Context paramContext)
  {
    setOnTouchListener(this);
    this.eventDispatcher = new RetricaBlurTouchEventDispatcher(paramContext);
  }
  
  public RetricaBlurTouchEventDispatcher eventDispatcher()
  {
    return this.eventDispatcher;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.eventDispatcher != null) && (this.eventDispatcher.blurGestureEventEnabled())) {
      this.eventDispatcher.drawBlurGuide(this, paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.eventDispatcher.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((getDrawable() != null) && (getDrawable().getIntrinsicWidth() > 0)) {
      this.eventDispatcher.setImageSize(getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.eventDispatcher.onTouchEvent(paramMotionEvent);
  }
  
  public void setEventListner(RetricaBlurTouchEventListener paramRetricaBlurTouchEventListener)
  {
    this.eventDispatcher.setEventListner(paramRetricaBlurTouchEventListener);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (paramBitmap.getWidth() > 0) {
      this.eventDispatcher.setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/EditorPreviewImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */