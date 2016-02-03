package com.mobeta.android.dslv;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;

public class DragSortItemViewCheckable
  extends DragSortItemView
  implements Checkable
{
  public DragSortItemViewCheckable(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean isChecked()
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      return ((Checkable)localView).isChecked();
    }
    return false;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).setChecked(paramBoolean);
    }
  }
  
  public void toggle()
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).toggle();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobeta/android/dslv/DragSortItemViewCheckable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */