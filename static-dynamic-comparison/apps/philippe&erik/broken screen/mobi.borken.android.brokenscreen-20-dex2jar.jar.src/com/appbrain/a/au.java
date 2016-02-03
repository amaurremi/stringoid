package com.appbrain.a;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.appbrain.h.a;
import java.util.Locale;

final class au
  implements View.OnClickListener
{
  au(Button paramButton1, Button paramButton2, RelativeLayout paramRelativeLayout, a parama) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.getParent() != null) {
      return;
    }
    paramView = (ViewGroup)this.b.getParent();
    int m = this.b.getLeft();
    int k = this.b.getTop();
    int j = paramView.getWidth() - this.b.getRight();
    int i = paramView.getHeight() - this.b.getBottom();
    while (paramView != this.c)
    {
      localObject = (ViewGroup)paramView.getParent();
      m += paramView.getLeft();
      k += paramView.getTop();
      j += ((ViewGroup)localObject).getWidth() - paramView.getRight();
      i += ((ViewGroup)localObject).getHeight() - paramView.getBottom();
      paramView = (View)localObject;
    }
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    paramView.leftMargin = m;
    paramView.topMargin = k;
    paramView.rightMargin = j;
    paramView.bottomMargin = i;
    this.a.setLayoutParams(paramView);
    this.c.addView(this.a);
    this.a.requestLayout();
    Object localObject = this.c.getResources().getConfiguration().locale.getLanguage();
    paramView = this.b.getText().toString();
    localObject = bs.a(5, (String)localObject);
    this.d.a(this.a, new av(this, (String)localObject, paramView));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */