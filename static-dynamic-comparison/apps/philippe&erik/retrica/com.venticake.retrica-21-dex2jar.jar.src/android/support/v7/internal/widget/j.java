package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.support.v7.b.f;
import android.support.v7.b.h;
import android.support.v7.b.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class j
  extends BaseAdapter
{
  private d b;
  private int c = 4;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private j(ActivityChooserView paramActivityChooserView) {}
  
  public int a()
  {
    int i = 0;
    int k = this.c;
    this.c = Integer.MAX_VALUE;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = getCount();
    View localView = null;
    int j = 0;
    while (i < i1)
    {
      localView = getView(i, localView, null);
      localView.measure(m, n);
      j = Math.max(j, localView.getMeasuredWidth());
      i += 1;
    }
    this.c = k;
    return j;
  }
  
  public void a(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public void a(d paramd)
  {
    d locald = ActivityChooserView.a(this.a).e();
    if ((locald != null) && (this.a.isShown())) {
      locald.unregisterObserver(ActivityChooserView.i(this.a));
    }
    this.b = paramd;
    if ((paramd != null) && (this.a.isShown())) {
      paramd.registerObserver(ActivityChooserView.i(this.a));
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.d != paramBoolean1) || (this.e != paramBoolean2))
    {
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      notifyDataSetChanged();
    }
  }
  
  public ResolveInfo b()
  {
    return this.b.b();
  }
  
  public int c()
  {
    return this.b.a();
  }
  
  public int d()
  {
    return this.b.c();
  }
  
  public d e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public int getCount()
  {
    int j = this.b.a();
    int i = j;
    if (!this.d)
    {
      i = j;
      if (this.b.b() != null) {
        i = j - 1;
      }
    }
    j = Math.min(i, this.c);
    i = j;
    if (this.f) {
      i = j + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      return null;
    }
    int i = paramInt;
    if (!this.d)
    {
      i = paramInt;
      if (this.b.b() != null) {
        i = paramInt + 1;
      }
    }
    return this.b.a(i);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.f) && (paramInt == getCount() - 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getId() == 1) {
          break;
        }
      }
      else
      {
        localObject = LayoutInflater.from(this.a.getContext()).inflate(h.abc_activity_chooser_view_list_item, paramViewGroup, false);
        ((View)localObject).setId(1);
        ((TextView)((View)localObject).findViewById(f.title)).setText(this.a.getContext().getString(i.abc_activity_chooser_view_see_all));
      }
      break;
    }
    View localView;
    do
    {
      do
      {
        do
        {
          return (View)localObject;
          if (paramView != null)
          {
            localView = paramView;
            if (paramView.getId() == f.list_item) {}
          }
          else
          {
            localView = LayoutInflater.from(this.a.getContext()).inflate(h.abc_activity_chooser_view_list_item, paramViewGroup, false);
          }
          paramView = this.a.getContext().getPackageManager();
          paramViewGroup = (ImageView)localView.findViewById(f.icon);
          localObject = (ResolveInfo)getItem(paramInt);
          paramViewGroup.setImageDrawable(((ResolveInfo)localObject).loadIcon(paramView));
          ((TextView)localView.findViewById(f.title)).setText(((ResolveInfo)localObject).loadLabel(paramView));
          localObject = localView;
        } while (!this.d);
        localObject = localView;
      } while (paramInt != 0);
      localObject = localView;
    } while (!this.e);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */