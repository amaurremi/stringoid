package com.mobeta.android.dslv;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class a
  extends f
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private GestureDetector aQ;
  private int amA = -1;
  private int[] amB = new int[2];
  private int amC;
  private int amD;
  private int amE;
  private int amF;
  private boolean amG = false;
  private float amH = 500.0F;
  private int amI;
  private int amJ;
  private int amK;
  private boolean amL;
  private DragSortListView amM;
  private int amN;
  private GestureDetector.OnGestureListener amO = new GestureDetector.SimpleOnGestureListener()
  {
    public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int i;
      if ((a.a(a.this)) && (a.b(a.this)))
      {
        i = a.c(a.this).getWidth() / 5;
        if (paramAnonymousFloat1 <= a.d(a.this)) {
          break label83;
        }
        if (a.e(a.this) > -i) {
          a.c(a.this).a(true, paramAnonymousFloat1);
        }
      }
      for (;;)
      {
        a.a(a.this, false);
        return false;
        label83:
        if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i)) {
          a.c(a.this).a(true, paramAnonymousFloat1);
        }
      }
    }
  };
  private int ams = 0;
  private boolean amt = true;
  private int amu;
  private boolean amv = false;
  private boolean amw = false;
  private GestureDetector amx;
  private int amy = -1;
  private int amz = -1;
  private int bi;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.amM = paramDragSortListView;
    this.aQ = new GestureDetector(paramDragSortListView.getContext(), this);
    this.amx = new GestureDetector(paramDragSortListView.getContext(), this.amO);
    this.amx.setIsLongpressEnabled(false);
    this.bi = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.amI = paramInt1;
    this.amJ = paramInt4;
    this.amK = paramInt5;
    fH(paramInt3);
    fG(paramInt2);
  }
  
  public void a(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.amv) && (this.amw)) {
      this.amN = paramPoint1.x;
    }
  }
  
  public void aM(boolean paramBoolean)
  {
    this.amt = paramBoolean;
  }
  
  public void aN(boolean paramBoolean)
  {
    this.amv = paramBoolean;
  }
  
  public int e(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.amM.pointToPosition(i, j);
    j = this.amM.getHeaderViewsCount();
    int k = this.amM.getFooterViewsCount();
    int m = this.amM.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      View localView = this.amM.getChildAt(i - this.amM.getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = localView; paramMotionEvent != null; paramMotionEvent = localView.findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.amB);
        if ((k <= this.amB[0]) || (j <= this.amB[1]) || (k >= this.amB[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.amB[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.amC = localView.getLeft();
        this.amD = localView.getTop();
        return i;
      }
    }
    return -1;
  }
  
  public void fG(int paramInt)
  {
    this.ams = paramInt;
  }
  
  public void fH(int paramInt)
  {
    this.amu = paramInt;
  }
  
  public int j(MotionEvent paramMotionEvent)
  {
    return l(paramMotionEvent);
  }
  
  public boolean j(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = j;
    if (this.amt)
    {
      i = j;
      if (!this.amw) {
        i = 12;
      }
    }
    j = i;
    if (this.amv)
    {
      j = i;
      if (this.amw) {
        j = i | 0x1 | 0x2;
      }
    }
    this.amG = this.amM.h(paramInt1 - this.amM.getHeaderViewsCount(), j, paramInt2, paramInt3);
    return this.amG;
  }
  
  public int k(MotionEvent paramMotionEvent)
  {
    if (this.amu == 1) {
      return m(paramMotionEvent);
    }
    return -1;
  }
  
  public int l(MotionEvent paramMotionEvent)
  {
    return e(paramMotionEvent, this.amI);
  }
  
  public int m(MotionEvent paramMotionEvent)
  {
    return e(paramMotionEvent, this.amK);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.amv) && (this.amu == 0)) {
      this.amA = e(paramMotionEvent, this.amJ);
    }
    this.amy = j(paramMotionEvent);
    if ((this.amy != -1) && (this.ams == 0)) {
      j(this.amy, (int)paramMotionEvent.getX() - this.amC, (int)paramMotionEvent.getY() - this.amD);
    }
    this.amw = false;
    this.amL = true;
    this.amN = 0;
    this.amz = k(paramMotionEvent);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.amy != -1) && (this.ams == 2))
    {
      this.amM.performHapticFeedback(0);
      j(this.amy, this.amE - this.amC, this.amF - this.amD);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = (int)paramMotionEvent1.getX();
    int j = (int)paramMotionEvent1.getY();
    int k = (int)paramMotionEvent2.getX();
    int m = (int)paramMotionEvent2.getY();
    int n = k - this.amC;
    int i1 = m - this.amD;
    if ((this.amL) && (!this.amG) && ((this.amy != -1) || (this.amz != -1)))
    {
      if (this.amy == -1) {
        break label178;
      }
      if ((this.ams != 1) || (Math.abs(m - j) <= this.bi) || (!this.amt)) {
        break label129;
      }
      j(this.amy, n, i1);
    }
    label129:
    label178:
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.ams == 0) || (Math.abs(k - i) <= this.bi) || (!this.amv));
        this.amw = true;
        j(this.amz, n, i1);
        return false;
      } while (this.amz == -1);
      if ((Math.abs(k - i) > this.bi) && (this.amv))
      {
        this.amw = true;
        j(this.amz, n, i1);
        return false;
      }
    } while (Math.abs(m - j) <= this.bi);
    this.amL = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.amv) && (this.amu == 0) && (this.amA != -1)) {
      this.amM.removeItem(this.amA - this.amM.getHeaderViewsCount());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.amM.CP()) || (this.amM.CJ())) {
      return false;
    }
    this.aQ.onTouchEvent(paramMotionEvent);
    if ((this.amv) && (this.amG) && (this.amu == 1)) {
      this.amx.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.amE = ((int)paramMotionEvent.getX());
      this.amF = ((int)paramMotionEvent.getY());
      return false;
    case 1: 
      if ((this.amv) && (this.amw)) {
        if (this.amN < 0) {
          break label183;
        }
      }
      break;
    }
    label183:
    for (int i = this.amN;; i = -this.amN)
    {
      if (i > this.amM.getWidth() / 2) {
        this.amM.a(true, 0.0F);
      }
      this.amw = false;
      this.amG = false;
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobeta/android/dslv/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */