package com.mobeta.android.dslv;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;

public class f
  implements DragSortListView.i
{
  private Bitmap aoM;
  private ImageView aoN;
  private int aoO = -16777216;
  private ListView mListView;
  
  public f(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public void Q(View paramView)
  {
    ((ImageView)paramView).setImageDrawable(null);
    this.aoM.recycle();
    this.aoM = null;
  }
  
  public void a(View paramView, Point paramPoint1, Point paramPoint2) {}
  
  public View fM(int paramInt)
  {
    View localView = this.mListView.getChildAt(this.mListView.getHeaderViewsCount() + paramInt - this.mListView.getFirstVisiblePosition());
    if (localView == null) {
      return null;
    }
    localView.setPressed(false);
    localView.setDrawingCacheEnabled(true);
    this.aoM = Bitmap.createBitmap(localView.getDrawingCache());
    localView.setDrawingCacheEnabled(false);
    if (this.aoN == null) {
      this.aoN = new ImageView(this.mListView.getContext());
    }
    this.aoN.setBackgroundColor(this.aoO);
    this.aoN.setPadding(0, 0, 0, 0);
    this.aoN.setImageBitmap(this.aoM);
    this.aoN.setLayoutParams(new ViewGroup.LayoutParams(localView.getWidth(), localView.getHeight()));
    return this.aoN;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.aoO = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobeta/android/dslv/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */