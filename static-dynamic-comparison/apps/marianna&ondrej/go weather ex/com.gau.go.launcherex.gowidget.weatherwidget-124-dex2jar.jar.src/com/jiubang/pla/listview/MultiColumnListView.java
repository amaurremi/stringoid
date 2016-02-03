package com.jiubang.pla.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ListAdapter;
import com.gau.go.launcherex.gowidget.weatherwidget.R.styleable;
import com.jiubang.pla.internal.PLA_ListView;

public class MultiColumnListView
  extends PLA_ListView
{
  private int V = 2;
  private b[] W = null;
  private b Z = null;
  private SparseIntArray aa = new SparseIntArray();
  private int ab = 0;
  private int ac = 0;
  private Rect ad = new Rect();
  private boolean ae = true;
  
  public MultiColumnListView(Context paramContext)
  {
    super(paramContext);
    b(null);
  }
  
  public MultiColumnListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramAttributeSet);
  }
  
  public MultiColumnListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramAttributeSet);
  }
  
  private b D()
  {
    Object localObject = this.W[0];
    b[] arrayOfb = this.W;
    int j = arrayOfb.length;
    int i = 0;
    if (i < j)
    {
      b localb = arrayOfb[i];
      if (((b)localObject).e() > localb.e()) {
        localObject = localb;
      }
      for (;;)
      {
        i += 1;
        break;
      }
    }
    return (b)localObject;
  }
  
  private b E()
  {
    Object localObject = this.W[0];
    b[] arrayOfb = this.W;
    int j = arrayOfb.length;
    int i = 0;
    if (i < j)
    {
      b localb = arrayOfb[i];
      if (((b)localObject).d() > localb.d()) {
        localObject = localb;
      }
      for (;;)
      {
        i += 1;
        break;
      }
    }
    return (b)localObject;
  }
  
  private b a(boolean paramBoolean, int paramInt)
  {
    int i = this.aa.get(paramInt, -1);
    if (i != -1) {
      return this.W[i];
    }
    paramInt = Math.max(0, paramInt);
    if (paramInt < this.V) {
      return this.W[paramInt];
    }
    if (paramBoolean) {
      return E();
    }
    return D();
  }
  
  private void b(AttributeSet paramAttributeSet)
  {
    int i = 0;
    getWindowVisibleDisplayFrame(this.ad);
    if (paramAttributeSet == null)
    {
      this.V = 2;
      this.W = new b[this.V];
      while (i < this.V)
      {
        this.W[i] = new b(this, i);
        i += 1;
      }
    }
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.PinterestLikeAdapterView);
    int j = paramAttributeSet.getInteger(1, -1);
    int k = paramAttributeSet.getInteger(0, -1);
    if ((this.ad.width() > this.ad.height()) && (j != -1)) {
      this.V = j;
    }
    for (;;)
    {
      this.ab = paramAttributeSet.getDimensionPixelSize(2, 0);
      this.ac = paramAttributeSet.getDimensionPixelSize(3, 0);
      paramAttributeSet.recycle();
      break;
      if (k != -1) {
        this.V = k;
      } else {
        this.V = 2;
      }
    }
    this.Z = new c(this);
  }
  
  private boolean n(int paramInt)
  {
    return this.c.getItemViewType(paramInt) == -2;
  }
  
  private int o(int paramInt)
  {
    paramInt = this.aa.get(paramInt, -1);
    if (paramInt == -1) {
      return 0;
    }
    return this.W[paramInt].a();
  }
  
  private int p(int paramInt)
  {
    paramInt = this.aa.get(paramInt, -1);
    if (paramInt == -1) {
      return 0;
    }
    return this.W[paramInt].b();
  }
  
  public void C()
  {
    this.ae = true;
  }
  
  public void a(d paramd)
  {
    if (paramd != null) {
      a(new a(this, paramd));
    }
  }
  
  protected void b(int paramInt, boolean paramBoolean)
  {
    super.b(paramInt, paramBoolean);
    if (!n(paramInt))
    {
      b localb = a(paramBoolean, paramInt);
      this.aa.append(paramInt, localb.c());
    }
  }
  
  protected void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (d(paramView))
    {
      paramView.measure(paramInt2, paramInt3);
      return;
    }
    paramView.measure(0x40000000 | p(paramInt1), paramInt3);
  }
  
  protected void d(int paramInt)
  {
    b[] arrayOfb = this.W;
    int i = arrayOfb.length;
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfb[paramInt].f();
      paramInt += 1;
    }
  }
  
  protected void e(int paramInt)
  {
    b[] arrayOfb = this.W;
    int i = arrayOfb.length;
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfb[paramInt].g();
      paramInt += 1;
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    int i = 0;
    int j = v();
    if ((!paramBoolean) && (j == 0))
    {
      j = this.W[0].e();
      b[] arrayOfb = this.W;
      int k = arrayOfb.length;
      while (i < k)
      {
        b localb = arrayOfb[i];
        localb.a(j - localb.e());
        i += 1;
      }
    }
    super.e(paramBoolean);
  }
  
  protected int h(int paramInt)
  {
    return paramInt / this.V;
  }
  
  protected int i(int paramInt)
  {
    if (n(paramInt)) {
      return this.Z.a();
    }
    return o(paramInt);
  }
  
  protected int j(int paramInt)
  {
    if (n(paramInt)) {
      return this.Z.d();
    }
    paramInt = this.aa.get(paramInt, -1);
    if (paramInt == -1) {
      return q();
    }
    return this.W[paramInt].d();
  }
  
  protected int k(int paramInt)
  {
    if (n(paramInt)) {
      return this.Z.e();
    }
    paramInt = this.aa.get(paramInt, -1);
    if (paramInt == -1) {
      return p();
    }
    return this.W[paramInt].e();
  }
  
  protected int o()
  {
    int i = Integer.MAX_VALUE;
    b[] arrayOfb = this.W;
    int m = arrayOfb.length;
    int j = 0;
    if (j < m)
    {
      int k = arrayOfb[j].e();
      if (i > k) {
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
      }
    }
    return i;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = (getMeasuredWidth() - this.l.left - this.l.right - this.ab - this.ac) / this.V;
    paramInt1 = 0;
    while (paramInt1 < this.V)
    {
      b.a(this.W[paramInt1], paramInt2);
      b.b(this.W[paramInt1], this.l.left + this.ab + paramInt2 * paramInt1);
      paramInt1 += 1;
    }
    b.b(this.Z, this.l.left);
    b.a(this.Z, getMeasuredWidth());
  }
  
  protected int p()
  {
    int i = Integer.MIN_VALUE;
    b[] arrayOfb = this.W;
    int m = arrayOfb.length;
    int j = 0;
    if (j < m)
    {
      int k = arrayOfb[j].e();
      if (i < k) {
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
      }
    }
    return i;
  }
  
  protected int q()
  {
    int i = Integer.MAX_VALUE;
    b[] arrayOfb = this.W;
    int m = arrayOfb.length;
    int j = 0;
    if (j < m)
    {
      int k = arrayOfb[j].d();
      if (i > k) {
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
      }
    }
    return i;
  }
  
  protected int r()
  {
    int i = Integer.MIN_VALUE;
    b[] arrayOfb = this.W;
    int m = arrayOfb.length;
    int j = 0;
    if (j < m)
    {
      int k = arrayOfb[j].d();
      if (i < k) {
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
      }
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/listview/MultiColumnListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */