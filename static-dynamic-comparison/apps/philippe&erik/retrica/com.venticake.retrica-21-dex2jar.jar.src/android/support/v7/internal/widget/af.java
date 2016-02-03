package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

class af
  extends ListPopupWindow
  implements ag
{
  private CharSequence c;
  private ListAdapter d;
  
  public af(final ac paramac, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramac);
    a(true);
    a(0);
    a(new o(paramac, new n()
    {
      public void a(l paramAnonymousl, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        af.this.b.a(paramAnonymousInt);
        if (af.this.b.t != null) {
          af.this.b.a(paramAnonymousView, paramAnonymousInt, af.a(af.this).getItemId(paramAnonymousInt));
        }
        af.this.d();
      }
    }));
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    super.a(paramListAdapter);
    this.d = paramListAdapter;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
  
  public void c()
  {
    int j = this.b.getPaddingLeft();
    int i;
    if (this.b.E == -2)
    {
      i = this.b.getWidth();
      int k = this.b.getPaddingRight();
      e(Math.max(this.b.a((SpinnerAdapter)this.d, a()), i - j - k));
    }
    for (;;)
    {
      Drawable localDrawable = a();
      i = 0;
      if (localDrawable != null)
      {
        localDrawable.getPadding(ac.a(this.b));
        i = -ac.a(this.b).left;
      }
      b(i + j);
      f(2);
      super.c();
      h().setChoiceMode(1);
      g(this.b.f());
      return;
      if (this.b.E == -1) {
        e(this.b.getWidth() - j - this.b.getPaddingRight());
      } else {
        e(this.b.E);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */