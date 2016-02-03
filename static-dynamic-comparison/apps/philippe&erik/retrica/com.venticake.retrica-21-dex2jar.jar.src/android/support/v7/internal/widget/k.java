package android.support.v7.internal.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

class k
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private k(ActivityChooserView paramActivityChooserView) {}
  
  private void a()
  {
    if (ActivityChooserView.h(this.a) != null) {
      ActivityChooserView.h(this.a).onDismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == ActivityChooserView.e(this.a))
    {
      this.a.b();
      paramView = ActivityChooserView.a(this.a).b();
      int i = ActivityChooserView.a(this.a).e().a(paramView);
      paramView = ActivityChooserView.a(this.a).e().b(i);
      if (paramView != null)
      {
        paramView.addFlags(524288);
        this.a.getContext().startActivity(paramView);
      }
      return;
    }
    if (paramView == ActivityChooserView.f(this.a))
    {
      ActivityChooserView.a(this.a, false);
      ActivityChooserView.a(this.a, ActivityChooserView.g(this.a));
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void onDismiss()
  {
    a();
    if (this.a.a != null) {
      this.a.a.a(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (((j)paramAdapterView.getAdapter()).getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      ActivityChooserView.a(this.a, Integer.MAX_VALUE);
    }
    do
    {
      return;
      this.a.b();
      if (!ActivityChooserView.d(this.a)) {
        break;
      }
    } while (paramInt <= 0);
    ActivityChooserView.a(this.a).e().c(paramInt);
    return;
    if (ActivityChooserView.a(this.a).f()) {}
    for (;;)
    {
      paramAdapterView = ActivityChooserView.a(this.a).e().b(paramInt);
      if (paramAdapterView == null) {
        break;
      }
      paramAdapterView.addFlags(524288);
      this.a.getContext().startActivity(paramAdapterView);
      return;
      paramInt += 1;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == ActivityChooserView.e(this.a))
    {
      if (ActivityChooserView.a(this.a).getCount() > 0)
      {
        ActivityChooserView.a(this.a, true);
        ActivityChooserView.a(this.a, ActivityChooserView.g(this.a));
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */