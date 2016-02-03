package com.mobisystems.mobiscanner.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.mobisystems.mobiscanner.a.a;

public class DragAndDropGridViewV3
  extends GridView
  implements GestureDetector.OnGestureListener
{
  private static final float[] aLC = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 158.0F };
  GestureDetector _gestureDetector;
  private int aLA = 30;
  private int aLB = 500;
  final Handler aLD = new Handler();
  Runnable aLE = new Runnable()
  {
    public void run()
    {
      DragAndDropGridViewV3.this.smoothScrollBy(DragAndDropGridViewV3.a(DragAndDropGridViewV3.this), DragAndDropGridViewV3.b(DragAndDropGridViewV3.this) / 2);
      DragAndDropGridViewV3.a(DragAndDropGridViewV3.this, false);
      DragAndDropGridViewV3.this.aLD.postDelayed(this, DragAndDropGridViewV3.b(DragAndDropGridViewV3.this));
    }
  };
  private boolean aLF = false;
  private int aLG;
  private SparseArray<a> aLH;
  private SparseArray<Integer> aLI;
  private int aLJ = 0;
  private int aLK;
  private int aLL;
  private Bitmap aLM;
  private int aLN;
  private int aLO;
  private boolean aLP;
  private boolean aLQ;
  b aLx;
  private int aLy = 100;
  private int aLz = 100;
  
  public DragAndDropGridViewV3(Context paramContext)
  {
    super(paramContext);
    b(paramContext, true);
  }
  
  public DragAndDropGridViewV3(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.a.DragDropGridView, 0, 0);
    try
    {
      this.aLy = paramContext.getDimensionPixelSize(0, this.aLy);
      this.aLz = paramContext.getInteger(1, this.aLz);
      this.aLA = paramContext.getInteger(2, this.aLA);
      this.aLB = paramContext.getInteger(3, this.aLB);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public DragAndDropGridViewV3(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    b(paramContext, paramBoolean);
  }
  
  private Bitmap JY()
  {
    Bitmap localBitmap1 = this.aLx.getDragBitmap(this.aLL - getFirstVisiblePosition());
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint();
    localPaint.setColorFilter(new ColorMatrixColorFilter(aLC));
    localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, localPaint);
    return localBitmap2;
  }
  
  @SuppressLint({"UseSparseArrays"})
  private void b(Context paramContext, boolean paramBoolean)
  {
    this._gestureDetector = new GestureDetector(paramContext, this);
    this.aLP = paramBoolean;
    this.aLH = new SparseArray();
    this.aLI = new SparseArray();
  }
  
  private void i(float paramFloat1, float paramFloat2)
  {
    int k = (int)paramFloat1;
    int m = (int)paramFloat2;
    int j = pointToPosition(k, m);
    int i = j;
    if (j == -1)
    {
      i = this.aLK;
      View localView = getChildAt(getChildCount() - 1);
      j = localView.getTop();
      int n = localView.getRight();
      int i1 = localView.getBottom();
      if (((j >= m) || (n >= k)) && (i1 >= m)) {
        break label214;
      }
      i = getChildCount() - 1 + getFirstVisiblePosition();
      this.aLF = false;
    }
    label214:
    do
    {
      for (;;)
      {
        if (i != this.aLL)
        {
          P(this.aLL, i);
          this.aLL = i;
          performHapticFeedback(3, 2);
          this.aLQ = true;
        }
        this.aLN = k;
        this.aLO = m;
        invalidate();
        if (m >= getTop() + this.aLy) {
          break;
        }
        this.aLG = -20;
        this.aLO -= 20;
        if (this.aLF)
        {
          this.aLF = false;
          this.aLD.postDelayed(this.aLE, this.aLz);
        }
        return;
        if (getChildAt(0).getTop() > m)
        {
          i = getFirstVisiblePosition();
          this.aLF = false;
        }
      }
      if (m <= getBottom() - this.aLy) {
        break;
      }
      this.aLG = 20;
      this.aLO += 20;
    } while (!this.aLF);
    this.aLF = false;
    this.aLD.postDelayed(this.aLE, this.aLz);
    return;
    this.aLF = true;
    this.aLD.removeCallbacks(this.aLE);
  }
  
  protected void P(int paramInt1, int paramInt2)
  {
    int i = Math.min(paramInt1, paramInt2);
    int m = Math.max(paramInt1, paramInt2);
    int n = getFirstVisiblePosition();
    View localView;
    if (i <= m)
    {
      localView = getChildAt(i - n);
      if (this.aLI.get(i) == null) {
        break label427;
      }
    }
    label425:
    label427:
    for (int j = ((Integer)this.aLI.get(i)).intValue();; j = i)
    {
      if (i == this.aLK) {}
      for (;;)
      {
        i += 1;
        break;
        int k;
        if ((paramInt1 < paramInt2) && (j >= paramInt1 + 1) && (j <= paramInt2)) {
          k = j - 1;
        }
        for (;;)
        {
          if (j == k) {
            break label425;
          }
          Object localObject1 = getChildAt(j - n);
          if (localObject1 == null) {
            break;
          }
          localObject1 = new Point(((View)localObject1).getLeft(), ((View)localObject1).getTop());
          Object localObject2 = getChildAt(k - n);
          if (localObject2 == null) {
            break;
          }
          localObject2 = new Point(((View)localObject2).getLeft(), ((View)localObject2).getTop());
          localObject1 = new Point(((Point)localObject1).x - localView.getLeft(), ((Point)localObject1).y - localView.getTop());
          localObject2 = new Point(((Point)localObject2).x - localView.getLeft(), ((Point)localObject2).y - localView.getTop());
          localObject1 = new TranslateAnimation(0, ((Point)localObject1).x, 0, ((Point)localObject2).x, 0, ((Point)localObject1).y, 0, ((Point)localObject2).y);
          ((TranslateAnimation)localObject1).setDuration(this.aLB);
          ((TranslateAnimation)localObject1).setFillEnabled(true);
          ((TranslateAnimation)localObject1).setFillAfter(true);
          localObject2 = new TranslateAnimation(0, ((Point)localObject2).x, 0, 0.0F, 0, ((Point)localObject2).y, 0, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(0L);
          ((TranslateAnimation)localObject2).setFillEnabled(true);
          ((TranslateAnimation)localObject2).setFillAfter(true);
          this.aLH.put(i, new a((TranslateAnimation)localObject1, (TranslateAnimation)localObject2));
          localView.clearAnimation();
          localView.startAnimation((Animation)localObject1);
          this.aLI.put(i, Integer.valueOf(k));
          break;
          if ((paramInt2 < paramInt1) && (j >= paramInt2) && (j < paramInt1)) {
            k = j + 1;
          } else {
            k = j;
          }
        }
      }
    }
  }
  
  public void a(b paramb)
  {
    this.aLx = paramb;
    setAdapter(paramb);
  }
  
  public void b(int paramInt, View paramView)
  {
    int j = 1;
    int i;
    if (paramView != null)
    {
      paramView.clearAnimation();
      i = j;
      if (this.aLJ != 1)
      {
        if (this.aLJ != 3) {
          break label51;
        }
        i = j;
      }
      if (i == 0) {
        break label115;
      }
      if (paramInt != this.aLK) {
        break label56;
      }
      paramView.setVisibility(4);
    }
    label51:
    label56:
    label115:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        if (paramView.getVisibility() != 0) {
          paramView.setVisibility(0);
        }
        localObject = (a)this.aLH.get(paramInt);
      } while (localObject == null);
      localObject = ((a)localObject).aLS;
      if (localObject != null)
      {
        ((TranslateAnimation)localObject).setDuration(0L);
        paramView.startAnimation((Animation)localObject);
      }
      paramView.bringToFront();
      return;
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
      localObject = (a)this.aLH.get(paramInt);
    } while (localObject == null);
    Object localObject = ((a)localObject).aLT;
    if (localObject != null)
    {
      paramView.startAnimation((Animation)localObject);
      this.aLH.delete(paramInt);
    }
    paramView.bringToFront();
  }
  
  public void bw(boolean paramBoolean)
  {
    this.aLP = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.aLM != null) {
      paramCanvas.drawBitmap(this.aLM, this.aLN - (this.aLM.getWidth() >> 1) - 5, this.aLO - (this.aLM.getHeight() >> 1) - 5, null);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    boolean bool2 = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    boolean bool1 = bool2;
    if (this.aLJ == 3)
    {
      paramInt1 = getSelectedItemPosition();
      bool1 = bool2;
      if (paramInt1 != this.aLK)
      {
        this.aLx.moveItem(this.aLK, paramInt1);
        this.aLK = paramInt1;
        invalidateViews();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    if (paramInt == 23)
    {
      if (this.aLJ == 0)
      {
        this.aLJ = 3;
        this.aLK = getSelectedItemPosition();
        return true;
      }
      if (this.aLJ == 3)
      {
        this.aLJ = 0;
        return true;
      }
    }
    else if (this.aLJ == 3)
    {
      paramInt = getSelectedItemPosition();
      if ((paramInt != this.aLK) && (paramInt >= 0) && (this.aLK >= 0))
      {
        this.aLx.moveItem(this.aLK, paramInt);
        this.aLK = paramInt;
        invalidateViews();
        return true;
      }
    }
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.aLJ == 0)
    {
      this.aLJ = 1;
      this.aLM = JY();
      this.aLN = ((int)paramMotionEvent.getX());
      this.aLO = ((int)paramMotionEvent.getY());
      if (this.aLK >= 0)
      {
        paramMotionEvent = getChildAt(this.aLK - getFirstVisiblePosition());
        paramMotionEvent.clearAnimation();
        paramMotionEvent.setVisibility(4);
        this.aLH.clear();
      }
      performHapticFeedback(0, 2);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aLJ == 3) {
      this.aLJ = 0;
    }
    if ((!this.aLP) || ((this.aLJ != 1) && (this._gestureDetector.onTouchEvent(paramMotionEvent)))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.aLK = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((this.aLK >= 0) && (this.aLK < this.aLx.getCount())) {
        this.aLL = this.aLK;
      }
      for (this.aLJ = 0;; this.aLJ = 2)
      {
        this.aLQ = false;
        break;
      }
      if (this.aLJ == 1)
      {
        i(paramMotionEvent.getX(), paramMotionEvent.getY());
        return true;
        this.aLF = true;
        this.aLD.removeCallbacks(this.aLE);
        if ((this.aLJ == 1) && (this.aLL != this.aLK))
        {
          this.aLx.moveItem(this.aLL, this.aLK);
          this.aLI.clear();
        }
        this.aLJ = 0;
        this.aLM = null;
        invalidate();
        continue;
        this.aLM = null;
        this.aLD.removeCallbacks(this.aLE);
        this.aLF = true;
        invalidate();
        if (this.aLJ == 1)
        {
          this.aLJ = 0;
          if (!this.aLQ)
          {
            this.aLx.performLongClick(this.aLL);
            return true;
          }
          if (this.aLK == this.aLL) {
            b(this.aLL, getChildAt(this.aLL - getFirstVisiblePosition()));
          }
          this.aLx.moveItem(this.aLK, this.aLL);
          this.aLI.clear();
          return true;
        }
        this.aLJ = 0;
      }
    }
  }
  
  private class a
  {
    public TranslateAnimation aLS;
    public TranslateAnimation aLT;
    
    public a(TranslateAnimation paramTranslateAnimation1, TranslateAnimation paramTranslateAnimation2)
    {
      this.aLS = paramTranslateAnimation1;
      this.aLT = paramTranslateAnimation2;
    }
  }
  
  public static abstract interface b
    extends ListAdapter
  {
    public abstract Bitmap getDragBitmap(int paramInt);
    
    public abstract void moveItem(int paramInt1, int paramInt2);
    
    public abstract void performLongClick(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/DragAndDropGridViewV3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */