package com.jiubang.playsdk.views;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;

class k
  extends GestureDetector.SimpleOnGestureListener
{
  private k(HorizontalListView paramHorizontalListView) {}
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      HorizontalListView.b(this.a);
      AdapterView.OnItemClickListener localOnItemClickListener = this.a.getOnItemClickListener();
      int i = HorizontalListView.a(this.a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i >= 0) && (!HorizontalListView.d(this.a)))
      {
        paramMotionEvent = this.a.getChildAt(i);
        i = HorizontalListView.e(this.a) + i;
        if (localOnItemClickListener != null)
        {
          localOnItemClickListener.onItemClick(this.a, paramMotionEvent, i, this.a.b.getItemId(i));
          return true;
        }
      }
      if ((HorizontalListView.f(this.a) != null) && (!HorizontalListView.d(this.a))) {
        HorizontalListView.f(this.a).onClick(this.a);
      }
      return false;
    }
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.a.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    HorizontalListView.b(this.a);
    int i = HorizontalListView.a(this.a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    Object localObject;
    if ((i >= 0) && (!HorizontalListView.d(this.a)))
    {
      paramMotionEvent = this.a.getChildAt(i);
      i = HorizontalListView.e(this.a) + i;
      localObject = this.a.getOnItemLongClickListener();
      if (localObject == null) {
        break label108;
      }
      if (((AdapterView.OnItemLongClickListener)localObject).onItemLongClick(this.a, paramMotionEvent, i, this.a.b.getItemId(i))) {
        this.a.performHapticFeedback(0);
      }
    }
    label108:
    do
    {
      return;
      localObject = this.a.getOnItemClickListener();
    } while (localObject == null);
    ((AdapterView.OnItemClickListener)localObject).onItemClick(this.a, paramMotionEvent, i, this.a.b.getItemId(i));
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    HorizontalListView.a(this.a, Boolean.valueOf(true));
    HorizontalListView.a(this.a, o.b);
    HorizontalListView.b(this.a);
    paramMotionEvent1 = this.a;
    paramMotionEvent1.d += (int)paramFloat1;
    HorizontalListView.a(this.a, Math.round(paramFloat1));
    this.a.requestLayout();
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    HorizontalListView.b(this.a);
    AdapterView.OnItemClickListener localOnItemClickListener = this.a.getOnItemClickListener();
    int i = HorizontalListView.a(this.a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((i >= 0) && (!HorizontalListView.d(this.a)))
    {
      paramMotionEvent = this.a.getChildAt(i);
      i = HorizontalListView.e(this.a) + i;
      if (localOnItemClickListener != null)
      {
        localOnItemClickListener.onItemClick(this.a, paramMotionEvent, i, this.a.b.getItemId(i));
        return true;
      }
    }
    if ((HorizontalListView.f(this.a) != null) && (!HorizontalListView.d(this.a))) {
      HorizontalListView.f(this.a).onClick(this.a);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */