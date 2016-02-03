package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.j;
import android.support.v4.view.n;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class i
{
  private static final Interpolator bJ = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private VelocityTracker aO;
  private int bi;
  private int cj = -1;
  private int eA;
  private int eB;
  private f eC;
  private final a eD;
  private View eE;
  private boolean eF;
  private final ViewGroup eG;
  private final Runnable eH = new Runnable()
  {
    public void run()
    {
      i.this.J(0);
    }
  };
  private int ep;
  private float[] eq;
  private float[] er;
  private float[] es;
  private float[] et;
  private int[] eu;
  private int[] ev;
  private int[] ew;
  private int ex;
  private float ey;
  private float ez;
  
  private i(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parama == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.eG = paramViewGroup;
    this.eD = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.eA = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.bi = paramViewGroup.getScaledTouchSlop();
    this.ey = paramViewGroup.getScaledMaximumFlingVelocity();
    this.ez = paramViewGroup.getScaledMinimumFlingVelocity();
    this.eC = f.a(paramContext, bJ);
  }
  
  private void G(int paramInt)
  {
    if (this.eq == null) {
      return;
    }
    this.eq[paramInt] = 0.0F;
    this.er[paramInt] = 0.0F;
    this.es[paramInt] = 0.0F;
    this.et[paramInt] = 0.0F;
    this.eu[paramInt] = 0;
    this.ev[paramInt] = 0;
    this.ew[paramInt] = 0;
    this.ex &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private void H(int paramInt)
  {
    if ((this.eq == null) || (this.eq.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.eq != null)
      {
        System.arraycopy(this.eq, 0, arrayOfFloat1, 0, this.eq.length);
        System.arraycopy(this.er, 0, arrayOfFloat2, 0, this.er.length);
        System.arraycopy(this.es, 0, arrayOfFloat3, 0, this.es.length);
        System.arraycopy(this.et, 0, arrayOfFloat4, 0, this.et.length);
        System.arraycopy(this.eu, 0, arrayOfInt1, 0, this.eu.length);
        System.arraycopy(this.ev, 0, arrayOfInt2, 0, this.ev.length);
        System.arraycopy(this.ew, 0, arrayOfInt3, 0, this.ew.length);
      }
      this.eq = arrayOfFloat1;
      this.er = arrayOfFloat2;
      this.es = arrayOfFloat3;
      this.et = arrayOfFloat4;
      this.eu = arrayOfInt1;
      this.ev = arrayOfInt2;
      this.ew = arrayOfInt3;
    }
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  public static i a(ViewGroup paramViewGroup, float paramFloat, a parama)
  {
    paramViewGroup = a(paramViewGroup, parama);
    paramViewGroup.bi = ((int)(paramViewGroup.bi * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static i a(ViewGroup paramViewGroup, a parama)
  {
    return new i(paramViewGroup.getContext(), paramViewGroup, parama);
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    H(paramInt);
    float[] arrayOfFloat = this.eq;
    this.es[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.er;
    this.et[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.eu[paramInt] = k((int)paramFloat1, (int)paramFloat2);
    this.ex |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.eu[paramInt1] & paramInt2) != paramInt2) || ((this.eB & paramInt2) == 0) || ((this.ew[paramInt1] & paramInt2) == paramInt2) || ((this.ev[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.bi) && (paramFloat2 <= this.bi))) {}
    do
    {
      return false;
      if ((paramFloat1 < paramFloat2 * 0.5F) && (this.eD.C(paramInt2)))
      {
        int[] arrayOfInt = this.ew;
        arrayOfInt[paramInt1] |= paramInt2;
        return false;
      }
    } while (((this.ev[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.bi));
    return true;
  }
  
  private void al()
  {
    if (this.eq == null) {
      return;
    }
    Arrays.fill(this.eq, 0.0F);
    Arrays.fill(this.er, 0.0F);
    Arrays.fill(this.es, 0.0F);
    Arrays.fill(this.et, 0.0F);
    Arrays.fill(this.eu, 0);
    Arrays.fill(this.ev, 0);
    Arrays.fill(this.ew, 0);
    this.ex = 0;
  }
  
  private void am()
  {
    this.aO.computeCurrentVelocity(1000, this.ey);
    b(a(n.a(this.aO, this.cj), this.ez, this.ey), a(n.b(this.aO, this.cj), this.ez, this.ey));
  }
  
  private float b(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.eG.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = b(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.eF = true;
    this.eD.a(this.eE, paramFloat1, paramFloat2);
    this.eF = false;
    if (this.ep == 1) {
      J(0);
    }
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (a(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 4)) {
        i = j | 0x4;
      }
      j = i;
      if (a(paramFloat1, paramFloat2, paramInt, 2)) {
        j = i | 0x2;
      }
      i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 8)) {
        i = j | 0x8;
      }
      if (i != 0)
      {
        int[] arrayOfInt = this.ev;
        arrayOfInt[paramInt] |= i;
        this.eD.f(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private boolean b(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (paramView == null) {
      bool = false;
    }
    label27:
    label80:
    label86:
    do
    {
      int j;
      do
      {
        return bool;
        int i;
        if (this.eD.y(paramView) > 0)
        {
          i = 1;
          if (this.eD.I(paramView) <= 0) {
            break label80;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label86;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.bi * this.bi) {
            break;
          }
          return false;
          i = 0;
          break label27;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) > this.bi);
      return false;
      if (j == 0) {
        break;
      }
    } while (Math.abs(paramFloat2) > this.bi);
    return false;
    return false;
  }
  
  private int c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  private int c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = c(paramInt3, (int)this.ez, (int)this.ey);
    paramInt4 = c(paramInt4, (int)this.ez, (int)this.ey);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = k / n;
      if (paramInt4 == 0) {
        break label165;
      }
    }
    label165:
    for (float f2 = m / n;; f2 = j / i1)
    {
      paramInt1 = b(paramInt1, paramInt3, this.eD.y(paramView));
      paramInt2 = b(paramInt2, paramInt4, this.eD.I(paramView));
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = i / i1;
      break;
    }
  }
  
  private boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.eE.getLeft();
    int j = this.eE.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.eC.abortAnimation();
      J(0);
      return false;
    }
    paramInt3 = c(this.eE, paramInt1, paramInt2, paramInt3, paramInt4);
    this.eC.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    J(2);
    return true;
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.eE.getLeft();
    int j = this.eE.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.eD.a(this.eE, paramInt1, paramInt3);
      this.eE.offsetLeftAndRight(paramInt1 - i);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.eD.b(this.eE, paramInt2, paramInt4);
        this.eE.offsetTopAndBottom(paramInt2 - j);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.eD.b(this.eE, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j);
        }
        return;
      }
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    int j = j.c(paramMotionEvent);
    int i = 0;
    while (i < j)
    {
      int k = j.b(paramMotionEvent, i);
      float f1 = j.c(paramMotionEvent, i);
      float f2 = j.d(paramMotionEvent, i);
      this.es[k] = f1;
      this.et[k] = f2;
      i += 1;
    }
  }
  
  private int k(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramInt1 < this.eG.getLeft() + this.eA) {
      j = 1;
    }
    int i = j;
    if (paramInt2 < this.eG.getTop() + this.eA) {
      i = j | 0x4;
    }
    j = i;
    if (paramInt1 > this.eG.getRight() - this.eA) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > this.eG.getBottom() - this.eA) {
      paramInt1 = j | 0x8;
    }
    return paramInt1;
  }
  
  public void F(int paramInt)
  {
    this.eB = paramInt;
  }
  
  public boolean I(int paramInt)
  {
    return (this.ex & 1 << paramInt) != 0;
  }
  
  void J(int paramInt)
  {
    if (this.ep != paramInt)
    {
      this.ep = paramInt;
      this.eD.B(paramInt);
      if (paramInt == 0) {
        this.eE = null;
      }
    }
  }
  
  public boolean K(int paramInt)
  {
    boolean bool2 = false;
    int j = this.eq.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (h(paramInt, i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void abort()
  {
    cancel();
    if (this.ep == 2)
    {
      int i = this.eC.getCurrX();
      int j = this.eC.getCurrY();
      this.eC.abortAnimation();
      int k = this.eC.getCurrX();
      int m = this.eC.getCurrY();
      this.eD.b(this.eE, k, m, k - i, m - j);
    }
    J(0);
  }
  
  public int ai()
  {
    return this.ep;
  }
  
  public int aj()
  {
    return this.eA;
  }
  
  public View ak()
  {
    return this.eE;
  }
  
  public boolean c(View paramView, int paramInt1, int paramInt2)
  {
    this.eE = paramView;
    this.cj = -1;
    return c(paramInt1, paramInt2, 0, 0);
  }
  
  public void cancel()
  {
    this.cj = -1;
    al();
    if (this.aO != null)
    {
      this.aO.recycle();
      this.aO = null;
    }
  }
  
  public boolean d(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  public boolean e(boolean paramBoolean)
  {
    boolean bool;
    if (this.ep == 2)
    {
      bool = this.eC.computeScrollOffset();
      int i = this.eC.getCurrX();
      int j = this.eC.getCurrY();
      int k = i - this.eE.getLeft();
      int m = j - this.eE.getTop();
      if (k != 0) {
        this.eE.offsetLeftAndRight(k);
      }
      if (m != 0) {
        this.eE.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        this.eD.b(this.eE, i, j, k, m);
      }
      if ((!bool) || (i != this.eC.getFinalX()) || (j != this.eC.getFinalY())) {
        break label194;
      }
      this.eC.abortAnimation();
      bool = this.eC.isFinished();
    }
    label184:
    label194:
    for (;;)
    {
      if (!bool)
      {
        if (!paramBoolean) {
          break label184;
        }
        this.eG.post(this.eH);
      }
      while (this.ep == 2)
      {
        return true;
        J(0);
      }
      return false;
    }
  }
  
  public void f(float paramFloat)
  {
    this.ez = paramFloat;
  }
  
  public boolean f(MotionEvent paramMotionEvent)
  {
    int j = j.a(paramMotionEvent);
    int i = j.b(paramMotionEvent);
    if (j == 0) {
      cancel();
    }
    if (this.aO == null) {
      this.aO = VelocityTracker.obtain();
    }
    this.aO.addMovement(paramMotionEvent);
    switch (j)
    {
    }
    while (this.ep == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = j.b(paramMotionEvent, 0);
      a(f1, f2, i);
      paramMotionEvent = j((int)f1, (int)f2);
      if ((paramMotionEvent == this.eE) && (this.ep == 2)) {
        i(paramMotionEvent, i);
      }
      j = this.eu[i];
      if ((this.eB & j) != 0)
      {
        this.eD.e(j & this.eB, i);
        continue;
        j = j.b(paramMotionEvent, i);
        f1 = j.c(paramMotionEvent, i);
        f2 = j.d(paramMotionEvent, i);
        a(f1, f2, j);
        if (this.ep == 0)
        {
          i = this.eu[j];
          if ((this.eB & i) != 0) {
            this.eD.e(i & this.eB, j);
          }
        }
        else if (this.ep == 2)
        {
          paramMotionEvent = j((int)f1, (int)f2);
          if (paramMotionEvent == this.eE)
          {
            i(paramMotionEvent, j);
            continue;
            j = j.c(paramMotionEvent);
            i = 0;
            for (;;)
            {
              int k;
              float f3;
              float f4;
              if (i < j)
              {
                k = j.b(paramMotionEvent, i);
                f1 = j.c(paramMotionEvent, i);
                f2 = j.d(paramMotionEvent, i);
                f3 = f1 - this.eq[k];
                f4 = f2 - this.er[k];
                b(f3, f4, k);
                if (this.ep != 1) {
                  break label391;
                }
              }
              label391:
              View localView;
              do
              {
                e(paramMotionEvent);
                break;
                localView = j((int)f1, (int)f2);
              } while ((localView != null) && (b(localView, f3, f4)) && (i(localView, k)));
              i += 1;
            }
            G(j.b(paramMotionEvent, i));
            continue;
            cancel();
          }
        }
      }
    }
    return false;
  }
  
  public void g(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int m = j.a(paramMotionEvent);
    int k = j.b(paramMotionEvent);
    if (m == 0) {
      cancel();
    }
    if (this.aO == null) {
      this.aO = VelocityTracker.obtain();
    }
    this.aO.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            i = j.b(paramMotionEvent, 0);
            paramMotionEvent = j((int)f1, (int)f2);
            a(f1, f2, i);
            i(paramMotionEvent, i);
            j = this.eu[i];
          } while ((this.eB & j) == 0);
          this.eD.e(j & this.eB, i);
          return;
          i = j.b(paramMotionEvent, k);
          f1 = j.c(paramMotionEvent, k);
          f2 = j.d(paramMotionEvent, k);
          a(f1, f2, i);
          if (this.ep != 0) {
            break;
          }
          i(j((int)f1, (int)f2), i);
          j = this.eu[i];
        } while ((this.eB & j) == 0);
        this.eD.e(j & this.eB, i);
        return;
      } while (!i((int)f1, (int)f2));
      i(this.eE, i);
      return;
    case 2: 
      if (this.ep == 1)
      {
        i = j.a(paramMotionEvent, this.cj);
        f1 = j.c(paramMotionEvent, i);
        f2 = j.d(paramMotionEvent, i);
        i = (int)(f1 - this.es[this.cj]);
        j = (int)(f2 - this.et[this.cj]);
        d(this.eE.getLeft() + i, this.eE.getTop() + j, i, j);
        e(paramMotionEvent);
        return;
      }
      k = j.c(paramMotionEvent);
      i = j;
      for (;;)
      {
        float f3;
        float f4;
        if (i < k)
        {
          j = j.b(paramMotionEvent, i);
          f1 = j.c(paramMotionEvent, i);
          f2 = j.d(paramMotionEvent, i);
          f3 = f1 - this.eq[j];
          f4 = f2 - this.er[j];
          b(f3, f4, j);
          if (this.ep != 1) {
            break label461;
          }
        }
        View localView;
        do
        {
          e(paramMotionEvent);
          return;
          localView = j((int)f1, (int)f2);
        } while ((b(localView, f3, f4)) && (i(localView, j)));
        i += 1;
      }
    case 6: 
      label461:
      j = j.b(paramMotionEvent, k);
      if ((this.ep == 1) && (j == this.cj))
      {
        k = j.c(paramMotionEvent);
        if (i >= k) {
          break label669;
        }
        m = j.b(paramMotionEvent, i);
        if (m == this.cj) {}
        do
        {
          i += 1;
          break;
          f1 = j.c(paramMotionEvent, i);
          f2 = j.d(paramMotionEvent, i);
        } while ((j((int)f1, (int)f2) != this.eE) || (!i(this.eE, m)));
      }
      break;
    }
    label669:
    for (i = this.cj;; i = -1)
    {
      if (i == -1) {
        am();
      }
      G(j);
      return;
      if (this.ep == 1) {
        am();
      }
      cancel();
      return;
      if (this.ep == 1) {
        b(0.0F, 0.0F);
      }
      cancel();
      return;
    }
  }
  
  public boolean g(int paramInt1, int paramInt2)
  {
    if (!this.eF) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return c(paramInt1, paramInt2, (int)n.a(this.aO, this.cj), (int)n.b(this.aO, this.cj));
  }
  
  public int getTouchSlop()
  {
    return this.bi;
  }
  
  public void h(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.eG) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.eG + ")");
    }
    this.eE = paramView;
    this.cj = paramInt;
    this.eD.e(paramView, paramInt);
    J(1);
  }
  
  public boolean h(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!I(paramInt2)) {
      bool = false;
    }
    label27:
    float f2;
    label105:
    label110:
    do
    {
      float f1;
      do
      {
        return bool;
        int i;
        if ((paramInt1 & 0x1) == 1)
        {
          i = 1;
          if ((paramInt1 & 0x2) != 2) {
            break label105;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          f1 = this.es[paramInt2] - this.eq[paramInt2];
          f2 = this.et[paramInt2] - this.er[paramInt2];
          if ((i == 0) || (paramInt1 == 0)) {
            break label110;
          }
          if (f1 * f1 + f2 * f2 > this.bi * this.bi) {
            break;
          }
          return false;
          i = 0;
          break label27;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(f1) > this.bi);
      return false;
      if (paramInt1 == 0) {
        break;
      }
    } while (Math.abs(f2) > this.bi);
    return false;
    return false;
  }
  
  public boolean i(int paramInt1, int paramInt2)
  {
    return d(this.eE, paramInt1, paramInt2);
  }
  
  boolean i(View paramView, int paramInt)
  {
    if ((paramView == this.eE) && (this.cj == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.eD.d(paramView, paramInt)))
    {
      this.cj = paramInt;
      h(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public View j(int paramInt1, int paramInt2)
  {
    int i = this.eG.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.eG.getChildAt(this.eD.L(i));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public static abstract class a
  {
    public void B(int paramInt) {}
    
    public boolean C(int paramInt)
    {
      return false;
    }
    
    public int I(View paramView)
    {
      return 0;
    }
    
    public int L(int paramInt)
    {
      return paramInt;
    }
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int b(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public abstract boolean d(View paramView, int paramInt);
    
    public void e(int paramInt1, int paramInt2) {}
    
    public void e(View paramView, int paramInt) {}
    
    public void f(int paramInt1, int paramInt2) {}
    
    public int y(View paramView)
    {
      return 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */