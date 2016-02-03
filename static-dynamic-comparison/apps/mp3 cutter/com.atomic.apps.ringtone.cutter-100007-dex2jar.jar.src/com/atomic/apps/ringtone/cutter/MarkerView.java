package com.atomic.apps.ringtone.cutter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MarkerView
  extends ImageView
{
  private int a;
  private h b;
  
  public MarkerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    this.a = 0;
    this.b = null;
  }
  
  public final void a(h paramh)
  {
    this.b = paramh;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b != null) {
      paramCanvas = this.b;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if ((paramBoolean) && (this.b != null)) {
      this.b.b(this);
    }
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    this.a += 1;
    int i = (int)Math.sqrt(this.a / 2 + 1);
    if (this.b != null)
    {
      if (paramInt == 21)
      {
        this.b.a(this, i);
        return true;
      }
      if (paramInt == 22)
      {
        this.b.b(this, i);
        return true;
      }
      if (paramInt == 23)
      {
        paramKeyEvent = this.b;
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    this.a = 0;
    if (this.b != null) {
      this.b.a();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      requestFocus();
      this.b.a(paramMotionEvent.getRawX());
      continue;
      this.b.a(this, paramMotionEvent.getRawX());
      continue;
      this.b.a(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/MarkerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */