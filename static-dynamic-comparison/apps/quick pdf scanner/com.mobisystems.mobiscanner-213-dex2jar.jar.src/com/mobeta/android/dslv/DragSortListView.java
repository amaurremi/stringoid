package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView
  extends ListView
{
  private View amS;
  private Point amT = new Point();
  private Point amU = new Point();
  private int amV;
  private boolean amW = false;
  private float amX = 1.0F;
  private float amY = 1.0F;
  private int amZ;
  private c anA = new c()
  {
    public float a(float paramAnonymousFloat, long paramAnonymousLong)
    {
      return DragSortListView.a(DragSortListView.this) * paramAnonymousFloat;
    }
  };
  private int anB;
  private int anC;
  private int anD;
  private int anE;
  private int anF;
  private int anG = 0;
  private boolean anH = false;
  private boolean anI = false;
  private i anJ = null;
  private MotionEvent anK;
  private int anL = 0;
  private float anM = 0.25F;
  private float anN = 0.0F;
  private a anO;
  private boolean anP = false;
  private f anQ;
  private boolean anR = false;
  private j anS = new j(3);
  private l anT;
  private k anU;
  private g anV;
  private boolean anW;
  private float anX = 0.0F;
  private boolean anY = false;
  private boolean anZ = false;
  private int ana;
  private int anb;
  private boolean anc = false;
  private int and;
  private int ane;
  private int anf;
  private int ang;
  private int anh;
  private b ani;
  private h anj;
  private m ank;
  private boolean anl = true;
  private int anm = 1;
  private int ann;
  private int ano;
  private View[] anp = new View[1];
  private d anq;
  private float anr = 0.33333334F;
  private float ans = 0.33333334F;
  private int ant;
  private int anu;
  private float anv;
  private float anw;
  private float anx;
  private float any;
  private float anz = 0.5F;
  private int ep = 0;
  private boolean mBlockLayoutRequests = false;
  private DataSetObserver mObserver;
  private int mWidthMeasureSpec = 0;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int j = 150;
    boolean bool1;
    int i;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, c.a.DragSortListView, 0, 0);
      this.anm = Math.max(1, paramContext.getDimensionPixelSize(0, 1));
      this.anP = paramContext.getBoolean(5, false);
      if (this.anP) {
        this.anQ = new f();
      }
      this.amX = paramContext.getFloat(6, this.amX);
      this.amY = this.amX;
      this.anl = paramContext.getBoolean(10, this.anl);
      this.anM = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(7, 0.75F)));
      if (this.anM > 0.0F)
      {
        bool1 = true;
        this.anc = bool1;
        x(paramContext.getFloat(1, this.anr));
        this.anz = paramContext.getFloat(2, this.anz);
        j = paramContext.getInt(8, 150);
        i = paramContext.getInt(9, 150);
        if (paramContext.getBoolean(17, true))
        {
          bool1 = paramContext.getBoolean(12, false);
          int k = paramContext.getInt(4, 1);
          boolean bool2 = paramContext.getBoolean(11, true);
          int m = paramContext.getInt(13, 0);
          int n = paramContext.getResourceId(14, 0);
          int i1 = paramContext.getResourceId(15, 0);
          int i2 = paramContext.getResourceId(16, 0);
          int i3 = paramContext.getColor(3, -16777216);
          paramAttributeSet = new a(this, n, m, k, i2, i1);
          paramAttributeSet.aN(bool1);
          paramAttributeSet.aM(bool2);
          paramAttributeSet.setBackgroundColor(i3);
          this.anJ = paramAttributeSet;
          setOnTouchListener(paramAttributeSet);
        }
        paramContext.recycle();
      }
    }
    for (;;)
    {
      this.anq = new d();
      if (j > 0) {
        this.anT = new l(0.5F, j);
      }
      if (i > 0) {
        this.anV = new g(0.5F, i);
      }
      this.anK = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.CD();
          }
        }
        
        public void onChanged()
        {
          cancel();
        }
        
        public void onInvalidated()
        {
          cancel();
        }
      };
      return;
      bool1 = false;
      break;
      i = 150;
    }
  }
  
  private boolean CC()
  {
    int i = getFirstVisiblePosition();
    int j = this.ana;
    View localView2 = getChildAt(j - i);
    View localView1 = localView2;
    if (localView2 == null)
    {
      j = i + getChildCount() / 2;
      localView1 = getChildAt(j - i);
    }
    int i1 = localView1.getTop();
    int i2 = localView1.getHeight();
    i = H(j, i1);
    int i4 = getDividerHeight();
    int k;
    int m;
    int n;
    label147:
    int i3;
    label200:
    float f2;
    if (this.amV < i)
    {
      k = i;
      m = i;
      i = k;
      n = j;
      j = n;
      k = m;
      if (n >= 0)
      {
        n -= 1;
        i = fI(n);
        if (n == 0)
        {
          i = i1 - i4 - i;
          k = m;
          j = n;
        }
      }
      else
      {
        n = getHeaderViewsCount();
        i3 = getFooterViewsCount();
        i1 = this.ana;
        i2 = this.anb;
        float f1 = this.anN;
        if (!this.anc) {
          break label629;
        }
        i4 = Math.abs(i - k);
        if (this.amV >= i) {
          break label555;
        }
        f2 = this.anM;
        m = (int)(i4 * (f2 * 0.5F));
        f2 = m;
        k += m;
        if (this.amV >= k) {
          break label568;
        }
        this.ana = (j - 1);
        this.anb = j;
        this.anN = ((k - this.amV) * 0.5F / f2);
        label267:
        if (this.ana >= n) {
          break label644;
        }
        this.ana = n;
        this.anb = n;
        j = n;
        label292:
        if ((this.ana == i1) && (this.anb == i2) && (this.anN == f1)) {
          break label687;
        }
      }
    }
    label555:
    label568:
    label629:
    label644:
    label687:
    for (boolean bool = true;; bool = false)
    {
      if (j != this.amZ)
      {
        if (this.ani != null) {
          this.ani.G(this.amZ - n, j - n);
        }
        this.amZ = j;
        return true;
        i2 = i1 - (i + i4);
        i1 = H(n, i2);
        j = n;
        k = m;
        i = i1;
        if (this.amV >= i1) {
          break label147;
        }
        m = i1;
        i = i1;
        i1 = i2;
        break;
        int i5 = getCount();
        k = i;
        n = i;
        i = k;
        m = j;
        for (;;)
        {
          j = m;
          k = n;
          if (m >= i5) {
            break;
          }
          if (m == i5 - 1)
          {
            i = i1 + i4 + i2;
            j = m;
            k = n;
            break;
          }
          i3 = i1 + (i4 + i2);
          i2 = fI(m + 1);
          i1 = H(m + 1, i3);
          j = m;
          k = n;
          i = i1;
          if (this.amV < i1) {
            break;
          }
          m += 1;
          n = i1;
          i = i1;
          i1 = i3;
        }
        m = k;
        k = i;
        i = m;
        break label200;
        if (this.amV < i - m)
        {
          this.ana = j;
          this.anb = j;
          break label267;
        }
        this.ana = j;
        this.anb = (j + 1);
        this.anN = ((1.0F + (i - this.amV) / f2) * 0.5F);
        break label267;
        this.ana = j;
        this.anb = j;
        break label267;
        if (this.anb < getCount() - i3) {
          break label292;
        }
        j = getCount() - i3 - 1;
        this.ana = j;
        this.anb = j;
        break label292;
      }
      return bool;
    }
  }
  
  private void CE()
  {
    this.and = -1;
    this.ana = -1;
    this.anb = -1;
    this.amZ = -1;
  }
  
  private void CF()
  {
    this.ep = 2;
    if ((this.anj != null) && (this.amZ >= 0) && (this.amZ < getCount()))
    {
      int i = getHeaderViewsCount();
      this.anj.F(this.and - i, this.amZ - i);
    }
    CO();
    CH();
    CE();
    CL();
    if (this.anI)
    {
      this.ep = 3;
      return;
    }
    this.ep = 0;
  }
  
  private void CG()
  {
    fJ(this.and - getHeaderViewsCount());
  }
  
  private void CH()
  {
    int i = 0;
    int j = getFirstVisiblePosition();
    if (this.and < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
  }
  
  private void CI()
  {
    this.anL = 0;
    this.anI = false;
    if (this.ep == 3) {
      this.ep = 0;
    }
    this.amY = this.amX;
    this.anY = false;
    this.anS.clear();
  }
  
  private void CK()
  {
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.anw = (i + this.anr * f1);
    float f2 = i;
    this.anv = (f1 * (1.0F - this.ans) + f2);
    this.ant = ((int)this.anw);
    this.anu = ((int)this.anv);
    this.anx = (this.anw - i);
    this.any = (i + j - this.anv);
  }
  
  private void CL()
  {
    int j = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int i = Math.max(0, getHeaderViewsCount() - j);
    k = Math.min(k - j, getCount() - 1 - getFooterViewsCount() - j);
    while (i <= k)
    {
      View localView = getChildAt(i);
      if (localView != null) {
        a(j + i, localView, false);
      }
      i += 1;
    }
  }
  
  private void CM()
  {
    if (this.amS != null)
    {
      P(this.amS);
      this.ann = this.amS.getMeasuredHeight();
      this.ano = (this.ann / 2);
    }
  }
  
  private void CN()
  {
    if (this.anJ != null)
    {
      this.amU.set(this.anB, this.anC);
      this.anJ.a(this.amS, this.amT, this.amU);
    }
    int i = this.amT.x;
    int m = this.amT.y;
    int j = getPaddingLeft();
    int k;
    if (((this.anG & 0x1) == 0) && (i > j))
    {
      this.amT.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.anG & 0x8) == 0)
      {
        j = i;
        if (n <= this.and) {
          j = Math.max(getChildAt(this.and - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.anG & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.and) {
          k = Math.min(getChildAt(this.and - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label315;
      }
      this.amT.y = j;
    }
    for (;;)
    {
      this.amV = (this.amT.y + this.ano);
      return;
      if (((this.anG & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.amT.x = j;
      break;
      label315:
      if (this.ann + m > k) {
        this.amT.y = (k - this.ann);
      }
    }
  }
  
  private void CO()
  {
    if (this.amS != null)
    {
      this.amS.setVisibility(8);
      if (this.anJ != null) {
        this.anJ.Q(this.amS);
      }
      this.amS = null;
      invalidate();
    }
  }
  
  private int H(int paramInt1, int paramInt2)
  {
    int i = getHeaderViewsCount();
    int j = getFooterViewsCount();
    if ((paramInt1 <= i) || (paramInt1 >= getCount() - j)) {
      return paramInt2;
    }
    j = getDividerHeight();
    int m = this.ann - this.anm;
    int k = fK(paramInt1);
    int n = fI(paramInt1);
    if (this.anb <= this.and) {
      if ((paramInt1 == this.anb) && (this.ana != this.anb)) {
        if (paramInt1 == this.and) {
          i = paramInt2 + n - this.ann;
        }
      }
    }
    while (paramInt1 <= this.and)
    {
      return (this.ann - j - fK(paramInt1 - 1)) / 2 + i;
      i = n - k + paramInt2 - m;
      continue;
      i = paramInt2;
      if (paramInt1 > this.anb)
      {
        i = paramInt2;
        if (paramInt1 <= this.and)
        {
          i = paramInt2 - m;
          continue;
          if ((paramInt1 > this.and) && (paramInt1 <= this.ana))
          {
            i = paramInt2 + m;
          }
          else
          {
            i = paramInt2;
            if (paramInt1 == this.anb)
            {
              i = paramInt2;
              if (this.ana != this.anb) {
                i = paramInt2 + (n - k);
              }
            }
          }
        }
      }
    }
    return (k - j - this.ann) / 2 + i;
  }
  
  private void I(int paramInt1, int paramInt2)
  {
    this.amT.x = (paramInt1 - this.ane);
    this.amT.y = (paramInt2 - this.anf);
    aP(true);
    paramInt1 = Math.min(paramInt2, this.amV + this.ano);
    paramInt2 = Math.max(paramInt2, this.amV - this.ano);
    int i = this.anq.CR();
    if ((paramInt1 > this.anE) && (paramInt1 > this.anu) && (i != 1))
    {
      if (i != -1) {
        this.anq.aQ(true);
      }
      this.anq.fL(1);
    }
    do
    {
      return;
      if ((paramInt2 < this.anE) && (paramInt2 < this.ant) && (i != 0))
      {
        if (i != -1) {
          this.anq.aQ(true);
        }
        this.anq.fL(0);
        return;
      }
    } while ((paramInt2 < this.ant) || (paramInt1 > this.anu) || (!this.anq.CQ()));
    this.anq.aQ(true);
  }
  
  private int J(int paramInt1, int paramInt2)
  {
    getDividerHeight();
    int i;
    int j;
    int k;
    if ((this.anc) && (this.ana != this.anb))
    {
      i = 1;
      j = this.ann - this.anm;
      k = (int)(this.anN * j);
      if (paramInt1 != this.and) {
        break label114;
      }
      if (this.and != this.ana) {
        break label90;
      }
      if (i == 0) {
        break label85;
      }
      i = k + this.anm;
    }
    label85:
    label90:
    label114:
    do
    {
      return i;
      i = 0;
      break;
      return this.ann;
      if (this.and == this.anb) {
        return this.ann - k;
      }
      return this.anm;
      if (paramInt1 == this.ana)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.anb);
    return paramInt2 + j - k;
  }
  
  private void P(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      return;
    }
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i = fK(paramInt1);
    int m = paramView.getHeight();
    int n = J(paramInt1, i);
    int j;
    if (paramInt1 != this.and)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.ann;
      int k = i1;
      if (this.and != this.ana)
      {
        k = i1;
        if (this.and != this.anb) {
          k = i1 - this.anm;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 > this.ana) {
          return k - i + 0;
        }
      }
      else
      {
        if (paramInt1 == paramInt3)
        {
          if (paramInt1 <= this.ana) {
            return j - k + 0;
          }
          if (paramInt1 == this.anb) {
            return m - n + 0;
          }
          return 0 + j;
        }
        if (paramInt1 <= this.ana) {
          return 0 - k;
        }
        if (paramInt1 == this.anb) {
          return 0 - i;
        }
      }
      return 0;
      i = n;
      j = m;
    }
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = getDivider();
    int m = getDividerHeight();
    ViewGroup localViewGroup;
    int j;
    int k;
    int i;
    if ((localDrawable != null) && (m != 0))
    {
      localViewGroup = (ViewGroup)getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        j = getPaddingLeft();
        k = getWidth() - getPaddingRight();
        i = localViewGroup.getChildAt(0).getHeight();
        if (paramInt <= this.and) {
          break label128;
        }
        i += localViewGroup.getTop();
        paramInt = i + m;
      }
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(j, i, k, paramInt);
      localDrawable.setBounds(j, i, k, paramInt);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      label128:
      paramInt = localViewGroup.getBottom() - i;
      i = paramInt - m;
    }
  }
  
  private void a(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i;
    if ((paramInt != this.and) && (paramInt != this.ana) && (paramInt != this.anb))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.ana) || (paramInt == this.anb))
      {
        if (paramInt >= this.and) {
          break label151;
        }
        ((DragSortItemView)paramView).setGravity(80);
      }
    }
    for (;;)
    {
      int k = paramView.getVisibility();
      int j = 0;
      i = j;
      if (paramInt == this.and)
      {
        i = j;
        if (this.amS != null) {
          i = 4;
        }
      }
      if (i != k) {
        paramView.setVisibility(i);
      }
      return;
      i = c(paramInt, paramView, paramBoolean);
      break;
      label151:
      if (paramInt > this.and) {
        ((DragSortItemView)paramView).setGravity(48);
      }
    }
  }
  
  private void aP(boolean paramBoolean)
  {
    int i = getFirstVisiblePosition();
    int j = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null) {
      return;
    }
    d(i + j, localView, paramBoolean);
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    int i = 0;
    if (paramInt == this.and) {
      paramInt = i;
    }
    View localView;
    label65:
    do
    {
      return paramInt;
      localView = paramView;
      if (paramInt >= getHeaderViewsCount()) {
        if (paramInt < getCount() - getFooterViewsCount()) {
          break label65;
        }
      }
      for (localView = paramView;; localView = ((ViewGroup)paramView).getChildAt(0))
      {
        paramView = localView.getLayoutParams();
        if ((paramView == null) || (paramView.height <= 0)) {
          break;
        }
        return paramView.height;
      }
      paramInt = localView.getHeight();
    } while ((paramInt != 0) && (!paramBoolean));
    P(localView);
    return localView.getMeasuredHeight();
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    return J(paramInt, b(paramInt, paramView, paramBoolean));
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    this.mBlockLayoutRequests = true;
    CN();
    int i = this.ana;
    int j = this.anb;
    boolean bool = CC();
    if (bool)
    {
      CL();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.mBlockLayoutRequests = false;
  }
  
  private int fI(int paramInt)
  {
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      return localView.getHeight();
    }
    return J(paramInt, fK(paramInt));
  }
  
  private void fJ(int paramInt)
  {
    this.ep = 1;
    if (this.ank != null) {
      this.ank.remove(paramInt);
    }
    CO();
    CH();
    CE();
    if (this.anI)
    {
      this.ep = 3;
      return;
    }
    this.ep = 0;
  }
  
  private int fK(int paramInt)
  {
    int i = 0;
    if (paramInt == this.and) {}
    do
    {
      return i;
      localObject = getChildAt(paramInt - getFirstVisiblePosition());
      if (localObject != null) {
        return b(paramInt, (View)localObject, false);
      }
      j = this.anS.get(paramInt);
      i = j;
    } while (j != -1);
    Object localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.anp.length) {
      this.anp = new View[j];
    }
    if (i >= 0) {
      if (this.anp[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.anp[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.anS.add(paramInt, i);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.anp[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  private void n(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.anD = this.anB;
      this.anE = this.anC;
    }
    this.anB = ((int)paramMotionEvent.getX());
    this.anC = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.anD = this.anB;
      this.anE = this.anC;
    }
    this.ang = ((int)paramMotionEvent.getRawX() - this.anB);
    this.anh = ((int)paramMotionEvent.getRawY() - this.anC);
  }
  
  public void CD()
  {
    if (this.ep == 4)
    {
      this.anq.aQ(true);
      CO();
      CE();
      CL();
      if (this.anI) {
        this.ep = 3;
      }
    }
    else
    {
      return;
    }
    this.ep = 0;
  }
  
  public boolean CJ()
  {
    return this.anY;
  }
  
  public boolean CP()
  {
    return this.anl;
  }
  
  public void a(b paramb)
  {
    this.ani = paramb;
  }
  
  public void a(h paramh)
  {
    this.anj = paramh;
  }
  
  public void a(m paramm)
  {
    this.ank = paramm;
  }
  
  public boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    if ((this.ep != 0) || (!this.anI) || (this.amS != null) || (paramView == null) || (!this.anl))
    {
      bool = false;
      return bool;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.ana = paramInt1;
    this.anb = paramInt1;
    this.and = paramInt1;
    this.amZ = paramInt1;
    this.ep = 4;
    this.anG = 0;
    this.anG |= paramInt2;
    this.amS = paramView;
    CM();
    this.ane = paramInt3;
    this.anf = paramInt4;
    this.anF = this.anC;
    this.amT.x = (this.anB - this.ane);
    this.amT.y = (this.anC - this.anf);
    paramView = getChildAt(this.and - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.anP) {
      this.anQ.startTracking();
    }
    switch (this.anL)
    {
    }
    for (;;)
    {
      requestLayout();
      if (this.anU == null) {
        break;
      }
      this.anU.start();
      return true;
      super.onTouchEvent(this.anK);
      continue;
      super.onInterceptTouchEvent(this.anK);
    }
  }
  
  public boolean a(boolean paramBoolean, float paramFloat)
  {
    this.anW = true;
    return b(paramBoolean, paramFloat);
  }
  
  public boolean aO(boolean paramBoolean)
  {
    this.anW = false;
    return b(paramBoolean, 0.0F);
  }
  
  public boolean b(boolean paramBoolean, float paramFloat)
  {
    if (this.amS != null)
    {
      this.anq.aQ(true);
      if (paramBoolean) {
        c(this.and - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.anP) {
          this.anQ.CT();
        }
        return true;
        if (this.anV != null) {
          this.anV.start();
        } else {
          CF();
        }
      }
    }
    return false;
  }
  
  public void c(int paramInt, float paramFloat)
  {
    if ((this.ep == 0) || (this.ep == 4))
    {
      if (this.ep == 0)
      {
        this.and = (getHeaderViewsCount() + paramInt);
        this.ana = this.and;
        this.anb = this.and;
        this.amZ = this.and;
        View localView = getChildAt(this.and - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.ep = 1;
      this.anX = paramFloat;
      if (this.anI) {
        switch (this.anL)
        {
        }
      }
    }
    while (this.anT != null)
    {
      this.anT.start();
      return;
      super.onTouchEvent(this.anK);
      continue;
      super.onInterceptTouchEvent(this.anK);
    }
    fJ(paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.ep != 0)
    {
      if (this.ana != this.and) {
        a(this.ana, paramCanvas);
      }
      if ((this.anb != this.ana) && (this.anb != this.and)) {
        a(this.anb, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.amS != null)
    {
      k = this.amS.getWidth();
      m = this.amS.getHeight();
      int j = this.amT.x;
      int n = getWidth();
      i = j;
      if (j < 0) {
        i = -j;
      }
      if (i >= n) {
        break label216;
      }
      f = (n - i) / n;
    }
    label216:
    for (f *= f;; f = 0.0F)
    {
      i = (int)(f * (255.0F * this.amY));
      paramCanvas.save();
      paramCanvas.translate(this.amT.x, this.amT.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.amS.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
    }
  }
  
  public void g(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F)
    {
      this.ans = 0.5F;
      if (paramFloat1 <= 0.5F) {
        break label46;
      }
    }
    label46:
    for (this.anr = 0.5F;; this.anr = paramFloat1)
    {
      if (getHeight() != 0) {
        CK();
      }
      return;
      this.ans = paramFloat2;
      break;
    }
  }
  
  public boolean h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!this.anI) || (this.anJ == null)) {}
    View localView;
    do
    {
      return false;
      localView = this.anJ.fM(paramInt1);
    } while (localView == null);
    return a(paramInt1, localView, paramInt2, paramInt3, paramInt4);
  }
  
  protected void layoutChildren()
  {
    super.layoutChildren();
    if (this.amS != null)
    {
      if ((this.amS.isLayoutRequested()) && (!this.amW)) {
        CM();
      }
      this.amS.layout(0, 0, this.amS.getMeasuredWidth(), this.amS.getMeasuredHeight());
      this.amW = false;
    }
  }
  
  protected boolean o(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      if (this.ep == 4) {
        CD();
      }
      CI();
      continue;
      if (this.ep == 4) {
        aO(false);
      }
      CI();
      continue;
      I((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.anP) {
      this.anQ.CS();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.anl) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    n(paramMotionEvent);
    this.anH = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.ep != 0)
      {
        this.anR = true;
        return true;
      }
      this.anI = true;
    }
    if (this.amS != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.anI = false;
      }
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.anY = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.anL = 1;
        }
        break;
      case 1: 
      case 3: 
        CI();
        break;
        this.anL = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.amS != null)
    {
      if (this.amS.isLayoutRequested()) {
        CM();
      }
      this.amW = true;
    }
    this.mWidthMeasureSpec = paramInt1;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    CK();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.anR)
    {
      this.anR = false;
      bool2 = bool1;
    }
    do
    {
      return bool2;
      if (!this.anl) {
        return super.onTouchEvent(paramMotionEvent);
      }
      bool1 = this.anH;
      this.anH = false;
      if (!bool1) {
        n(paramMotionEvent);
      }
      if (this.ep == 4)
      {
        o(paramMotionEvent);
        return true;
      }
      bool1 = bool2;
      if (this.ep == 0)
      {
        bool1 = bool2;
        if (super.onTouchEvent(paramMotionEvent)) {
          bool1 = true;
        }
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
      }
    } while (!bool1);
    this.anL = 1;
    return bool1;
    CI();
    return bool1;
  }
  
  public void removeItem(int paramInt)
  {
    this.anW = false;
    c(paramInt, 0.0F);
  }
  
  public void requestLayout()
  {
    if (!this.mBlockLayoutRequests) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter != null)
    {
      this.anO = new a(paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.mObserver);
      if ((paramListAdapter instanceof h)) {
        a((h)paramListAdapter);
      }
      if ((paramListAdapter instanceof b)) {
        a((b)paramListAdapter);
      }
      if ((paramListAdapter instanceof m)) {
        a((m)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.anO);
      return;
      this.anO = null;
    }
  }
  
  public void x(float paramFloat)
  {
    g(paramFloat, paramFloat);
  }
  
  private class a
    extends BaseAdapter
  {
    private ListAdapter mAdapter;
    
    public a(ListAdapter paramListAdapter)
    {
      this.mAdapter = paramListAdapter;
      this.mAdapter.registerDataSetObserver(new DataSetObserver()
      {
        public void onChanged()
        {
          DragSortListView.a.this.notifyDataSetChanged();
        }
        
        public void onInvalidated()
        {
          DragSortListView.a.this.notifyDataSetInvalidated();
        }
      });
    }
    
    public boolean areAllItemsEnabled()
    {
      return this.mAdapter.areAllItemsEnabled();
    }
    
    public int getCount()
    {
      return this.mAdapter.getCount();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mAdapter.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return this.mAdapter.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return this.mAdapter.getItemViewType(paramInt);
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null)
      {
        paramViewGroup = (DragSortItemView)paramView;
        View localView1 = paramViewGroup.getChildAt(0);
        View localView2 = this.mAdapter.getView(paramInt, localView1, DragSortListView.this);
        paramView = paramViewGroup;
        if (localView2 != localView1)
        {
          if (localView1 != null) {
            paramViewGroup.removeViewAt(0);
          }
          paramViewGroup.addView(localView2);
          paramView = paramViewGroup;
        }
        DragSortListView.a(DragSortListView.this, DragSortListView.this.getHeaderViewsCount() + paramInt, paramView, true);
        return paramView;
      }
      paramViewGroup = this.mAdapter.getView(paramInt, null, DragSortListView.this);
      if ((paramViewGroup instanceof Checkable)) {}
      for (paramView = new DragSortItemViewCheckable(DragSortListView.this.getContext());; paramView = new DragSortItemView(DragSortListView.this.getContext()))
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.addView(paramViewGroup);
        break;
      }
    }
    
    public int getViewTypeCount()
    {
      return this.mAdapter.getViewTypeCount();
    }
    
    public boolean hasStableIds()
    {
      return this.mAdapter.hasStableIds();
    }
    
    public boolean isEmpty()
    {
      return this.mAdapter.isEmpty();
    }
    
    public boolean isEnabled(int paramInt)
    {
      return this.mAdapter.isEnabled(paramInt);
    }
  }
  
  public static abstract interface b
  {
    public abstract void G(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract float a(float paramFloat, long paramLong);
  }
  
  private class d
    implements Runnable
  {
    private boolean aod;
    private long aoe;
    private long aof;
    private float aog;
    private long aoh;
    private int aoi;
    private float aoj;
    private boolean aok = false;
    private int dy;
    
    public d() {}
    
    public boolean CQ()
    {
      return this.aok;
    }
    
    public int CR()
    {
      if (this.aok) {
        return this.aoi;
      }
      return -1;
    }
    
    public void aQ(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        DragSortListView.this.removeCallbacks(this);
        this.aok = false;
        return;
      }
      this.aod = true;
    }
    
    public void fL(int paramInt)
    {
      if (!this.aok)
      {
        this.aod = false;
        this.aok = true;
        this.aoh = SystemClock.uptimeMillis();
        this.aoe = this.aoh;
        this.aoi = paramInt;
        DragSortListView.this.post(this);
      }
    }
    
    public void run()
    {
      if (this.aod)
      {
        this.aok = false;
        return;
      }
      int j = DragSortListView.this.getFirstVisiblePosition();
      int i = DragSortListView.this.getLastVisiblePosition();
      int m = DragSortListView.this.getCount();
      int k = DragSortListView.this.getPaddingTop();
      int n = DragSortListView.this.getHeight() - k - DragSortListView.this.getPaddingBottom();
      int i1 = Math.min(DragSortListView.f(DragSortListView.this), DragSortListView.r(DragSortListView.this) + DragSortListView.d(DragSortListView.this));
      int i2 = Math.max(DragSortListView.f(DragSortListView.this), DragSortListView.r(DragSortListView.this) - DragSortListView.d(DragSortListView.this));
      View localView;
      if (this.aoi == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.aok = false;
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.aok = false;
          return;
        }
        this.aoj = DragSortListView.u(DragSortListView.this).a((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this), this.aoe);
        this.aof = SystemClock.uptimeMillis();
        this.aog = ((float)(this.aof - this.aoe));
        this.dy = Math.round(this.aoj * this.aog);
        if (this.dy < 0) {
          break label470;
        }
        this.dy = Math.min(n, this.dy);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.dy;
        j = m;
        if (i == 0)
        {
          j = m;
          if (m > k) {
            j = k;
          }
        }
        DragSortListView.b(DragSortListView.this, true);
        DragSortListView.this.setSelectionFromTop(i, j - k);
        DragSortListView.this.layoutChildren();
        DragSortListView.this.invalidate();
        DragSortListView.b(DragSortListView.this, false);
        DragSortListView.c(DragSortListView.this, i, localView, false);
        this.aoe = this.aof;
        DragSortListView.this.post(this);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.aok = false;
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.aok = false;
          return;
        }
        this.aoj = (-DragSortListView.u(DragSortListView.this).a((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this), this.aoe));
        break;
        label470:
        this.dy = Math.max(-n, this.dy);
      }
    }
  }
  
  public static abstract interface e
    extends DragSortListView.b, DragSortListView.h, DragSortListView.m
  {}
  
  private class f
  {
    StringBuilder I = new StringBuilder();
    File aol = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    private int aom = 0;
    private int aon = 0;
    private boolean aoo = false;
    
    public f()
    {
      if (!this.aol.exists()) {}
      try
      {
        this.aol.createNewFile();
        Log.d("mobeta", "file created");
        return;
      }
      catch (IOException this$1)
      {
        Log.w("mobeta", "Could not create dslv_state.txt");
        Log.d("mobeta", DragSortListView.this.getMessage());
      }
    }
    
    public void CS()
    {
      if (!this.aoo) {}
      do
      {
        return;
        this.I.append("<DSLVState>\n");
        int j = DragSortListView.this.getChildCount();
        int k = DragSortListView.this.getFirstVisiblePosition();
        this.I.append("    <Positions>");
        int i = 0;
        while (i < j)
        {
          this.I.append(k + i).append(",");
          i += 1;
        }
        this.I.append("</Positions>\n");
        this.I.append("    <Tops>");
        i = 0;
        while (i < j)
        {
          this.I.append(DragSortListView.this.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        this.I.append("</Tops>\n");
        this.I.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          this.I.append(DragSortListView.this.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        this.I.append("</Bottoms>\n");
        this.I.append("    <FirstExpPos>").append(DragSortListView.l(DragSortListView.this)).append("</FirstExpPos>\n");
        this.I.append("    <FirstExpBlankHeight>").append(DragSortListView.c(DragSortListView.this, DragSortListView.l(DragSortListView.this)) - DragSortListView.d(DragSortListView.this, DragSortListView.l(DragSortListView.this))).append("</FirstExpBlankHeight>\n");
        this.I.append("    <SecondExpPos>").append(DragSortListView.m(DragSortListView.this)).append("</SecondExpPos>\n");
        this.I.append("    <SecondExpBlankHeight>").append(DragSortListView.c(DragSortListView.this, DragSortListView.m(DragSortListView.this)) - DragSortListView.d(DragSortListView.this, DragSortListView.m(DragSortListView.this))).append("</SecondExpBlankHeight>\n");
        this.I.append("    <SrcPos>").append(DragSortListView.h(DragSortListView.this)).append("</SrcPos>\n");
        this.I.append("    <SrcHeight>").append(DragSortListView.j(DragSortListView.this) + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
        this.I.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
        this.I.append("    <LastY>").append(DragSortListView.x(DragSortListView.this)).append("</LastY>\n");
        this.I.append("    <FloatY>").append(DragSortListView.r(DragSortListView.this)).append("</FloatY>\n");
        this.I.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          this.I.append(DragSortListView.a(DragSortListView.this, k + i, DragSortListView.this.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        this.I.append("</ShuffleEdges>\n");
        this.I.append("</DSLVState>\n");
        this.aom += 1;
      } while (this.aom <= 1000);
      flush();
      this.aom = 0;
    }
    
    public void CT()
    {
      if (this.aoo)
      {
        this.I.append("</DSLVStates>\n");
        flush();
        this.aoo = false;
      }
    }
    
    public void flush()
    {
      boolean bool = false;
      if (!this.aoo) {
        return;
      }
      for (;;)
      {
        try
        {
          if (this.aon == 0)
          {
            FileWriter localFileWriter = new FileWriter(this.aol, bool);
            localFileWriter.write(this.I.toString());
            this.I.delete(0, this.I.length());
            localFileWriter.flush();
            localFileWriter.close();
            this.aon += 1;
            return;
          }
        }
        catch (IOException localIOException)
        {
          return;
        }
        bool = true;
      }
    }
    
    public void startTracking()
    {
      this.I.append("<DSLVStates>\n");
      this.aon = 0;
      this.aoo = true;
    }
  }
  
  private class g
    extends DragSortListView.n
  {
    private int aop;
    private int aoq;
    private float aor;
    private float aos;
    
    public g(float paramFloat, int paramInt)
    {
      super(paramFloat, paramInt);
    }
    
    private int CU()
    {
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.aop - i);
      if (localView != null)
      {
        if (this.aop == this.aoq) {
          return localView.getTop();
        }
        if (this.aop < this.aoq) {
          return localView.getTop() - j;
        }
        return localView.getBottom() + j - DragSortListView.j(DragSortListView.this);
      }
      cancel();
      return -1;
    }
    
    public void h(float paramFloat1, float paramFloat2)
    {
      int i = CU();
      int j = DragSortListView.this.getPaddingLeft();
      paramFloat1 = DragSortListView.e(DragSortListView.this).y - i;
      float f = DragSortListView.e(DragSortListView.this).x - j;
      paramFloat2 = 1.0F - paramFloat2;
      if ((paramFloat2 < Math.abs(paramFloat1 / this.aor)) || (paramFloat2 < Math.abs(f / this.aos)))
      {
        DragSortListView.e(DragSortListView.this).y = (i + (int)(this.aor * paramFloat2));
        DragSortListView.e(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.aos * paramFloat2));
        DragSortListView.a(DragSortListView.this, true);
      }
    }
    
    public void onStart()
    {
      this.aop = DragSortListView.g(DragSortListView.this);
      this.aoq = DragSortListView.h(DragSortListView.this);
      DragSortListView.b(DragSortListView.this, 2);
      this.aor = (DragSortListView.e(DragSortListView.this).y - CU());
      this.aos = (DragSortListView.e(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
    }
    
    public void onStop()
    {
      DragSortListView.k(DragSortListView.this);
    }
  }
  
  public static abstract interface h
  {
    public abstract void F(int paramInt1, int paramInt2);
  }
  
  public static abstract interface i
  {
    public abstract void Q(View paramView);
    
    public abstract void a(View paramView, Point paramPoint1, Point paramPoint2);
    
    public abstract View fM(int paramInt);
  }
  
  private class j
  {
    private SparseIntArray aot;
    private ArrayList<Integer> aou;
    private int aov;
    
    public j(int paramInt)
    {
      this.aot = new SparseIntArray(paramInt);
      this.aou = new ArrayList(paramInt);
      this.aov = paramInt;
    }
    
    public void add(int paramInt1, int paramInt2)
    {
      int i = this.aot.get(paramInt1, -1);
      if (i != paramInt2)
      {
        if (i != -1) {
          break label77;
        }
        if (this.aot.size() == this.aov) {
          this.aot.delete(((Integer)this.aou.remove(0)).intValue());
        }
      }
      for (;;)
      {
        this.aot.put(paramInt1, paramInt2);
        this.aou.add(Integer.valueOf(paramInt1));
        return;
        label77:
        this.aou.remove(Integer.valueOf(paramInt1));
      }
    }
    
    public void clear()
    {
      this.aot.clear();
      this.aou.clear();
    }
    
    public int get(int paramInt)
    {
      return this.aot.get(paramInt, -1);
    }
  }
  
  private class k
    extends DragSortListView.n
  {
    private float aow;
    private float aox;
    
    public void h(float paramFloat1, float paramFloat2)
    {
      if (DragSortListView.b(this.aoa) != 4)
      {
        cancel();
        return;
      }
      DragSortListView.a(this.aoa, (int)(this.aox * paramFloat2 + (1.0F - paramFloat2) * this.aow));
      DragSortListView.e(this.aoa).y = (DragSortListView.f(this.aoa) - DragSortListView.c(this.aoa));
      DragSortListView.a(this.aoa, true);
    }
    
    public void onStart()
    {
      this.aow = DragSortListView.c(this.aoa);
      this.aox = DragSortListView.d(this.aoa);
    }
  }
  
  private class l
    extends DragSortListView.n
  {
    private float aoA;
    private int aoB = -1;
    private int aoC = -1;
    private int aoD;
    private int aoE;
    private int aoq;
    private float aoy;
    private float aoz;
    
    public l(float paramFloat, int paramInt)
    {
      super(paramFloat, paramInt);
    }
    
    public void h(float paramFloat1, float paramFloat2)
    {
      paramFloat1 = 1.0F - paramFloat2;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.aoD - j);
      if (DragSortListView.n(DragSortListView.this))
      {
        paramFloat2 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / 1000.0F;
        if (paramFloat2 != 0.0F) {}
      }
      do
      {
        do
        {
          return;
          float f = DragSortListView.o(DragSortListView.this);
          int k = DragSortListView.this.getWidth();
          localObject = DragSortListView.this;
          if (DragSortListView.o(DragSortListView.this) > 0.0F) {}
          for (i = 1;; i = -1)
          {
            DragSortListView.b((DragSortListView)localObject, i * paramFloat2 * k);
            this.aoy += f * paramFloat2;
            DragSortListView.e(DragSortListView.this).x = ((int)this.aoy);
            if ((this.aoy >= k) || (this.aoy <= -k)) {
              break;
            }
            this.mStartTime = SystemClock.uptimeMillis();
            DragSortListView.a(DragSortListView.this, true);
            return;
          }
          if (localView != null)
          {
            if (this.aoB == -1)
            {
              this.aoB = DragSortListView.b(DragSortListView.this, this.aoD, localView, false);
              this.aoz = (localView.getHeight() - this.aoB);
            }
            i = Math.max((int)(this.aoz * paramFloat1), 1);
            localObject = localView.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject).height = (i + this.aoB);
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        } while (this.aoE == this.aoD);
        localView = DragSortListView.this.getChildAt(this.aoE - j);
      } while (localView == null);
      if (this.aoC == -1)
      {
        this.aoC = DragSortListView.b(DragSortListView.this, this.aoE, localView, false);
        this.aoA = (localView.getHeight() - this.aoC);
      }
      int i = Math.max((int)(this.aoA * paramFloat1), 1);
      Object localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + this.aoC);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    
    public void onStart()
    {
      int i = -1;
      this.aoB = -1;
      this.aoC = -1;
      this.aoD = DragSortListView.l(DragSortListView.this);
      this.aoE = DragSortListView.m(DragSortListView.this);
      this.aoq = DragSortListView.h(DragSortListView.this);
      DragSortListView.b(DragSortListView.this, 1);
      this.aoy = DragSortListView.e(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.aoy < 0.0F) {
            DragSortListView.a(localDragSortListView, i * f);
          }
        }
        do
        {
          return;
          i = 1;
          break;
          f *= 2.0F;
          if ((DragSortListView.o(DragSortListView.this) < 0.0F) && (DragSortListView.o(DragSortListView.this) > -f))
          {
            DragSortListView.a(DragSortListView.this, -f);
            return;
          }
        } while ((DragSortListView.o(DragSortListView.this) <= 0.0F) || (DragSortListView.o(DragSortListView.this) >= f));
        DragSortListView.a(DragSortListView.this, f);
        return;
      }
      DragSortListView.p(DragSortListView.this);
    }
    
    public void onStop()
    {
      DragSortListView.q(DragSortListView.this);
    }
  }
  
  public static abstract interface m
  {
    public abstract void remove(int paramInt);
  }
  
  private class n
    implements Runnable
  {
    private float aoF;
    private float aoG;
    private float aoH;
    private float aoI;
    private float aoJ;
    private float mAlpha;
    private boolean mCanceled;
    protected long mStartTime;
    
    public n(float paramFloat, int paramInt)
    {
      this.mAlpha = paramFloat;
      this.aoF = paramInt;
      paramFloat = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.aoJ = paramFloat;
      this.aoG = paramFloat;
      this.aoH = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.aoI = (1.0F / (1.0F - this.mAlpha));
    }
    
    public void cancel()
    {
      this.mCanceled = true;
    }
    
    public void h(float paramFloat1, float paramFloat2) {}
    
    public void onStart() {}
    
    public void onStop() {}
    
    public void run()
    {
      if (this.mCanceled) {
        return;
      }
      float f = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.aoF;
      if (f >= 1.0F)
      {
        h(1.0F, 1.0F);
        onStop();
        return;
      }
      h(f, y(f));
      DragSortListView.this.post(this);
    }
    
    public void start()
    {
      this.mStartTime = SystemClock.uptimeMillis();
      this.mCanceled = false;
      onStart();
      DragSortListView.this.post(this);
    }
    
    public float y(float paramFloat)
    {
      if (paramFloat < this.mAlpha) {
        return this.aoG * paramFloat * paramFloat;
      }
      if (paramFloat < 1.0F - this.mAlpha) {
        return this.aoH + this.aoI * paramFloat;
      }
      return 1.0F - this.aoJ * (paramFloat - 1.0F) * (paramFloat - 1.0F);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobeta/android/dslv/DragSortListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */