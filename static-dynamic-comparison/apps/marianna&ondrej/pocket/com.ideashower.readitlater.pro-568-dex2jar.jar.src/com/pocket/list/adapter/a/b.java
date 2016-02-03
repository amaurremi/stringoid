package com.pocket.list.adapter.a;

import android.graphics.Point;
import android.util.SparseArray;
import android.widget.RelativeLayout.LayoutParams;
import com.pocket.list.widget.b.b.a;

public class b
{
  private final SparseArray a = new SparseArray();
  private final com.pocket.list.widget.b b;
  
  public b(com.pocket.list.widget.b paramb)
  {
    this.b = paramb;
  }
  
  private int a(a parama)
  {
    if (parama.a()) {
      return 0;
    }
    return parama.T();
  }
  
  private RelativeLayout.LayoutParams a(int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(0, 0);
    a(localLayoutParams, paramInt1, paramInt2);
    return localLayoutParams;
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      paramLayoutParams.width = -1;
      paramLayoutParams.height = -2;
      paramLayoutParams.leftMargin = 0;
      return;
    }
    paramLayoutParams.height = this.b.getRowHeight();
    if (paramInt1 == 1) {}
    for (paramLayoutParams.width = this.b.getSingleSpaceWidth();; paramLayoutParams.width = this.b.getDoubleSpaceWidth())
    {
      Point localPoint = this.b.getTileSpacing();
      paramInt1 = localPoint.x;
      int i = this.b.getSingleSpaceWidth();
      paramLayoutParams.leftMargin = (localPoint.x + (paramInt1 * 2 + i) * paramInt2);
      return;
    }
  }
  
  public RelativeLayout.LayoutParams a(a parama, int paramInt)
  {
    SparseArray localSparseArray = (SparseArray)this.a.get(a(parama));
    if (localSparseArray == null)
    {
      localSparseArray = new SparseArray();
      this.a.put(a(parama), localSparseArray);
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localSparseArray.get(paramInt);
      RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = a(a(parama), paramInt);
        localSparseArray.put(paramInt, localLayoutParams1);
      }
      return localLayoutParams1;
    }
  }
  
  public void a()
  {
    int k = this.a.size();
    int i = 0;
    while (i < k)
    {
      SparseArray localSparseArray = (SparseArray)this.a.valueAt(i);
      int m = localSparseArray.size();
      int j = 0;
      while (j < m)
      {
        a((RelativeLayout.LayoutParams)localSparseArray.valueAt(j), this.a.keyAt(i), localSparseArray.keyAt(j));
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */