package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class RepeatingImageButton
  extends ImageButton
{
  private long mInterval = 500L;
  private RepeatListener mListener;
  private int mRepeatCount;
  private Runnable mRepeater = new Runnable()
  {
    public void run()
    {
      RepeatingImageButton.this.doRepeat(false);
      if (RepeatingImageButton.this.isPressed()) {
        RepeatingImageButton.this.postDelayed(this, RepeatingImageButton.this.mInterval);
      }
    }
  };
  private long mStartTime;
  
  public RepeatingImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RepeatingImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842866);
  }
  
  public RepeatingImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setLongClickable(true);
  }
  
  private void doRepeat(boolean paramBoolean)
  {
    long l1 = SystemClock.elapsedRealtime();
    RepeatListener localRepeatListener;
    long l2;
    int i;
    if (this.mListener != null)
    {
      localRepeatListener = this.mListener;
      l2 = this.mStartTime;
      if (!paramBoolean) {
        break label43;
      }
      i = -1;
    }
    for (;;)
    {
      localRepeatListener.onRepeat(this, l1 - l2, i);
      return;
      label43:
      i = this.mRepeatCount;
      this.mRepeatCount = (i + 1);
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.onKeyUp(paramInt, paramKeyEvent);
      removeCallbacks(this.mRepeater);
      if (this.mStartTime != 0L)
      {
        doRepeat(true);
        this.mStartTime = 0L;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      removeCallbacks(this.mRepeater);
      if (this.mStartTime != 0L)
      {
        doRepeat(true);
        this.mStartTime = 0L;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performLongClick()
  {
    this.mStartTime = SystemClock.elapsedRealtime();
    this.mRepeatCount = 0;
    post(this.mRepeater);
    return true;
  }
  
  public void setRepeatListener(RepeatListener paramRepeatListener, long paramLong)
  {
    this.mListener = paramRepeatListener;
    this.mInterval = paramLong;
  }
  
  public static abstract interface RepeatListener
  {
    public abstract void onRepeat(View paramView, long paramLong, int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/RepeatingImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */