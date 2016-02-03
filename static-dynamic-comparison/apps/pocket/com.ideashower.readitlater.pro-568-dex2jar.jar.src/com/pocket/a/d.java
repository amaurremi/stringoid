package com.pocket.a;

import android.app.Dialog;
import android.content.res.Resources;
import android.support.v4.app.f;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.b.b;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.GSFImageView;
import com.ideashower.readitlater.views.RilButton;
import com.pocket.widget.ah;
import java.util.ArrayList;

class d
  extends ah
{
  private final SparseArray b = new SparseArray();
  private final ArrayList c;
  private final ArrayList d = new ArrayList();
  
  private d(a parama)
  {
    this.c = com.ideashower.readitlater.activity.b.a.a(parama.n());
  }
  
  private View b(int paramInt)
  {
    Object localObject1 = LayoutInflater.from(this.a.m());
    int i;
    ViewGroup localViewGroup;
    Object localObject2;
    GSFImageView localGSFImageView;
    TextView localTextView;
    b localb;
    if (j.c())
    {
      i = 2130903193;
      localViewGroup = (ViewGroup)((LayoutInflater)localObject1).inflate(i, null, false);
      localObject2 = (TextView)localViewGroup.findViewById(2131230768);
      localGSFImageView = (GSFImageView)localViewGroup.findViewById(2131230925);
      localTextView = (TextView)localViewGroup.findViewById(2131230793);
      ((RilButton)localViewGroup.findViewById(2131230774)).setVisibility(8);
      i.a(i.a, (View)localObject2);
      i.a(i.h, localTextView);
      localb = (b)this.c.get(paramInt);
      if (!j.c()) {
        break label252;
      }
    }
    label252:
    for (localObject1 = "tablet";; localObject1 = "phone")
    {
      ((TextView)localObject2).setText(localb.a());
      localObject2 = localb.b();
      if (localObject2 != null)
      {
        localObject1 = ((String)localObject2).replace("%formfactor%", (CharSequence)localObject1);
        paramInt = this.a.n().getIdentifier((String)localObject1, "drawable", this.a.m().getPackageName());
        localGSFImageView.setImageDrawable(this.a.n().getDrawable(paramInt));
      }
      localTextView.setText(localb.c());
      if (g.y()) {
        localTextView.setOnLongClickListener(new View.OnLongClickListener()
        {
          public boolean onLongClick(View paramAnonymousView)
          {
            e.a(d.this.a.m()).show();
            return false;
          }
        });
      }
      z.b(localViewGroup.findViewById(2131231157), (int)(a.i(this.a) * 1.5F));
      return localViewGroup;
      i = 2130903192;
      break;
    }
  }
  
  private void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (TextView)paramView.findViewById(2131230768);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (a.j(this.a)) {}
    for (localLayoutParams.topMargin = this.a.n().getDimensionPixelSize(2131296298);; localLayoutParams.topMargin = this.a.n().getDimensionPixelSize(2131296297))
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public int a()
  {
    return this.c.size() + 1;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    if (paramInt == 0) {
      return a.h(this.a);
    }
    paramViewGroup = b(paramInt - 1);
    c(paramViewGroup);
    this.b.put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(View paramView, int paramInt)
  {
    this.b.delete(paramInt);
  }
  
  public void d()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      c((View)this.b.valueAt(i));
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */