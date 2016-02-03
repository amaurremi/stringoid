package com.mobeta.android.dslv;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.a;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  extends a
  implements DragSortListView.e
{
  private SparseIntArray amQ = new SparseIntArray();
  private ArrayList<Integer> amR = new ArrayList();
  
  public b(Context paramContext, Cursor paramCursor, int paramInt)
  {
    super(paramContext, paramCursor, paramInt);
  }
  
  private void CA()
  {
    this.amQ.clear();
    this.amR.clear();
  }
  
  private void CB()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.amQ.size();
    int i = 0;
    while (i < j)
    {
      if (this.amQ.keyAt(i) == this.amQ.valueAt(i)) {
        localArrayList.add(Integer.valueOf(this.amQ.keyAt(i)));
      }
      i += 1;
    }
    j = localArrayList.size();
    i = 0;
    while (i < j)
    {
      this.amQ.delete(((Integer)localArrayList.get(i)).intValue());
      i += 1;
    }
  }
  
  public void F(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      int j = this.amQ.get(paramInt1, paramInt1);
      int i = paramInt1;
      if (paramInt1 > paramInt2) {
        while (paramInt1 > paramInt2)
        {
          this.amQ.put(paramInt1, this.amQ.get(paramInt1 - 1, paramInt1 - 1));
          paramInt1 -= 1;
        }
      }
      while (i < paramInt2)
      {
        this.amQ.put(i, this.amQ.get(i + 1, i + 1));
        i += 1;
      }
      this.amQ.put(paramInt2, j);
      CB();
      notifyDataSetChanged();
    }
  }
  
  public void G(int paramInt1, int paramInt2) {}
  
  public void changeCursor(Cursor paramCursor)
  {
    super.changeCursor(paramCursor);
    CA();
  }
  
  public int getCount()
  {
    return super.getCount() - this.amR.size();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return super.getDropDownView(this.amQ.get(paramInt, paramInt), paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return super.getItem(this.amQ.get(paramInt, paramInt));
  }
  
  public long getItemId(int paramInt)
  {
    return super.getItemId(this.amQ.get(paramInt, paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return super.getView(this.amQ.get(paramInt, paramInt), paramView, paramViewGroup);
  }
  
  public void remove(int paramInt)
  {
    int i = this.amQ.get(paramInt, paramInt);
    if (!this.amR.contains(Integer.valueOf(i))) {
      this.amR.add(Integer.valueOf(i));
    }
    i = getCount();
    while (paramInt < i)
    {
      this.amQ.put(paramInt, this.amQ.get(paramInt + 1, paramInt + 1));
      paramInt += 1;
    }
    this.amQ.delete(i);
    CB();
    notifyDataSetChanged();
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    paramCursor = super.swapCursor(paramCursor);
    CA();
    return paramCursor;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobeta/android/dslv/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */