package com.pocket.widget.navigation;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.EmptyListLayout;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.k;
import com.ideashower.readitlater.views.l;
import com.pocket.o.a;
import com.pocket.o.d;
import java.util.ArrayList;
import java.util.List;

public class w
  extends ResizeDetectRelativeLayout
  implements com.ideashower.readitlater.d.c
{
  private x a;
  private final boolean b;
  private ArrayList c;
  private ListView d;
  private View e;
  private EmptyListLayout f;
  private a g;
  
  public w(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.b = paramBoolean1;
    a(paramContext, paramBoolean2);
  }
  
  private void a(final Context paramContext, final boolean paramBoolean)
  {
    ((Activity)getContext()).getLayoutInflater().inflate(2130903187, this, true);
    this.d = ((ListView)findViewById(2131231147));
    this.d.setCacheColorHint(0);
    this.d.setVerticalFadingEdgeEnabled(false);
    this.d.setSelector(new ColorDrawable(0));
    u localu = new u(getResources(), false);
    localu.setState(this.d.getDrawableState());
    this.d.setDivider(localu);
    this.d.setDividerHeight(1);
    this.d.setChoiceMode(1);
    this.e = findViewById(2131231144);
    this.f = ((EmptyListLayout)findViewById(2131231148));
    this.f.setEmptyStateHandler(new l()
    {
      public void a(k paramAnonymousk)
      {
        paramAnonymousk.a(paramContext.getString(2131493417), paramContext.getString(2131493416), null, 0, null);
      }
      
      public void a(k paramAnonymousk, boolean paramAnonymousBoolean, ErrorReport paramAnonymousErrorReport) {}
    });
    this.d.setEmptyView(this.f);
    this.f.C();
    com.pocket.o.c.a(new d()
    {
      public void a(ArrayList paramAnonymousArrayList)
      {
        w.a(w.this, paramAnonymousArrayList);
        if ((w.this.getContext() == null) || (((Activity)w.this.getContext()).isFinishing())) {
          return;
        }
        if (w.a(w.this).size() == 0)
        {
          w.this.findViewById(2131231145).setVisibility(8);
          w.this.findViewById(2131231147).setVisibility(8);
          w.b(w.this).E();
          return;
        }
        w.b(w.this).D();
        if (w.c(w.this) == null)
        {
          w.a(w.this, new a(w.this.getContext(), w.a(w.this), w.d(w.this), w.e(w.this)));
          w.f(w.this).setAdapter(w.c(w.this));
        }
        for (;;)
        {
          if (!w.d(w.this)) {
            w.a(w.this).add(0, g.a(2131493488));
          }
          if (w.e(w.this) != null) {
            w.e(w.this).a(w.this);
          }
          if (!paramBoolean) {
            break;
          }
          w.g(w.this).setVisibility(0);
          return;
          w.c(w.this).a(w.a(w.this));
          w.c(w.this).notifyDataSetChanged();
        }
        w.g(w.this).setVisibility(8);
      }
    });
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (w.d(w.this))
        {
          paramAnonymousAdapterView = (String)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (w.e(w.this) != null) {
            w.e(w.this).a(paramAnonymousAdapterView, w.a(w.this));
          }
        }
        label135:
        for (;;)
        {
          if (j.c())
          {
            w.c(w.this).a(paramAnonymousInt);
            w.c(w.this).notifyDataSetChanged();
          }
          return;
          if (paramAnonymousInt == 0) {}
          for (paramAnonymousAdapterView = "_untagged_";; paramAnonymousAdapterView = (String)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt))
          {
            if (w.e(w.this) == null) {
              break label135;
            }
            w.e(w.this).a(w.this, paramAnonymousAdapterView, paramAnonymousInt);
            break;
          }
        }
      }
    });
    com.ideashower.readitlater.i.c.a(this);
  }
  
  public void a(o paramo) {}
  
  public void a(List paramList) {}
  
  public void aj()
  {
    com.pocket.o.c.a(new d()
    {
      public void a(ArrayList paramAnonymousArrayList)
      {
        w.a(w.this, paramAnonymousArrayList);
        if (!w.d(w.this)) {
          w.a(w.this).add(0, g.a(2131493488));
        }
        if (w.c(w.this) == null)
        {
          w.a(w.this, new a(w.this.getContext(), w.a(w.this), w.d(w.this), w.e(w.this)));
          w.f(w.this).setAdapter(w.c(w.this));
          return;
        }
        w.c(w.this).a(w.a(w.this));
        w.c(w.this).notifyDataSetChanged();
      }
    });
  }
  
  public View getEditActionHeader()
  {
    return this.e;
  }
  
  public ListView getListView()
  {
    return this.d;
  }
  
  public ArrayList getTags()
  {
    return this.c;
  }
  
  public void setTagSelectedListener(x paramx)
  {
    this.a = paramx;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */