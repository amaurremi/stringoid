package com.ideashower.readitlater.views;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.util.j;
import com.pocket.widget.BorderedRelativeLayout;
import java.util.ArrayList;

class aj
{
  private final BorderedRelativeLayout b;
  private final ImageView c;
  private final TextView d;
  
  private aj(ad paramad, BorderedRelativeLayout paramBorderedRelativeLayout)
  {
    this.b = paramBorderedRelativeLayout;
    this.c = ((ImageView)paramBorderedRelativeLayout.findViewById(2131230770));
    this.d = ((TextView)paramBorderedRelativeLayout.findViewById(2131230962));
    if (!a.p()) {
      this.d.setTextColor(paramad.getResources().getColorStateList(2131165824));
    }
  }
  
  private void a(al paramal, int paramInt)
  {
    boolean bool2 = false;
    this.c.setImageDrawable(paramal.i());
    this.d.setText(paramal.j());
    int i;
    boolean bool1;
    if (ai.b(ad.a(this.a)))
    {
      i = ai.c(ad.a(this.a)).size();
      if (paramInt <= i - 1) {
        break label70;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      a(bool1);
      return;
      label70:
      int j = ad.b(this.a);
      bool1 = bool2;
      if (j != -1)
      {
        bool1 = bool2;
        if (paramInt >= i - j) {
          bool1 = true;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setBorder(2131165825);
      this.b.setBottomBorderLength(j.a(1.0F));
      return;
    }
    this.b.setBottomBorderLength(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */