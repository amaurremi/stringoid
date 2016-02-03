package com.pocket.o.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.objects.ErrorReport;
import com.pocket.c.f;
import com.pocket.c.n;
import com.pocket.widget.RainbowProgressCircleView;
import com.pocket.widget.chip.ChipLayout;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;

public class c
  extends i
  implements com.pocket.widget.chip.k
{
  private final String a;
  private final View b;
  private final ChipLayout c;
  private final RainbowProgressCircleView d;
  private final TextView e;
  private boolean f;
  private long g;
  private ArrayNode h;
  private ArrayList i;
  
  public c(String paramString, l paraml, k paramk, ListView paramListView)
  {
    super(paraml, paramk, paramListView.getContext());
    this.a = paramString;
    this.b = LayoutInflater.from(g()).inflate(2130903183, paramListView, false);
    this.e = ((TextView)this.b.findViewById(2131230804));
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a(c.this, System.currentTimeMillis());
        c.a(c.this);
      }
    });
    this.c = ((ChipLayout)this.b.findViewById(2131231140));
    this.c.setOnItemClickListener(this);
    this.c.setAdapter(new com.pocket.widget.chip.j()
    {
      public View a(CharSequence paramAnonymousCharSequence, ViewGroup paramAnonymousViewGroup)
      {
        paramAnonymousViewGroup = (TextView)LayoutInflater.from(c.this.g()).inflate(2130903129, paramAnonymousViewGroup, false);
        paramAnonymousViewGroup.setText(paramAnonymousCharSequence);
        return paramAnonymousViewGroup;
      }
    });
    this.c.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
    {
      public void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2) {}
      
      public void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
      {
        c.this.d();
      }
    });
    this.d = ((RainbowProgressCircleView)this.b.findViewById(2131230758));
    this.c.setVisibility(8);
    d();
  }
  
  private void i()
  {
    if (!as.m()) {
      return;
    }
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(0);
    ((ViewGroup)this.c.getParent()).setMinimumHeight(g().getResources().getDimensionPixelSize(2131296385));
    d();
    new n(0, this.a, new com.pocket.c.g()
    {
      private void b(f paramAnonymousf, boolean paramAnonymousBoolean)
      {
        c.a(c.this, ((n)paramAnonymousf).n());
        Object localObject;
        if ((paramAnonymousBoolean) && (!c.c(c.this).isEmpty()))
        {
          c.d(c.this).i();
          localObject = c.c(c.this).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            c.d(c.this).b(str);
          }
          ((ViewGroup)c.d(c.this).getParent()).setMinimumHeight(0);
          c.d(c.this).setVisibility(0);
          c.e(c.this).setVisibility(8);
          c.f(c.this).setVisibility(8);
          c.a(c.this, ((n)paramAnonymousf).o());
          c.this.d();
          return;
        }
        c.f(c.this).setVisibility(0);
        c.e(c.this).setVisibility(8);
        c.d(c.this).setVisibility(8);
        if ((paramAnonymousBoolean) && (c.c(c.this).isEmpty())) {
          c.f(c.this).setText(2131493722);
        }
        for (;;)
        {
          c.a(c.this, null);
          break;
          if (!com.ideashower.readitlater.a.g.k())
          {
            c.f(c.this).setText(2131493723);
          }
          else if (paramAnonymousf.t() != null)
          {
            localObject = c.this.g().getString(2131493724);
            c.f(c.this).setText(paramAnonymousf.t().a((String)localObject));
          }
          else
          {
            c.f(c.this).setText(2131493724);
          }
        }
      }
      
      public void a(final f paramAnonymousf, final boolean paramAnonymousBoolean)
      {
        if (c.b(c.this) == 0L)
        {
          b(paramAnonymousf, paramAnonymousBoolean);
          return;
        }
        long l = c.b(c.this) + 500L - System.currentTimeMillis();
        c.a(c.this, 0L);
        if ((!paramAnonymousBoolean) && (l > 0L))
        {
          com.ideashower.readitlater.a.g.o().postDelayed(new Runnable()
          {
            public void run()
            {
              c.4.a(c.4.this, paramAnonymousf, paramAnonymousBoolean);
            }
          }, l);
          return;
        }
        b(paramAnonymousf, paramAnonymousBoolean);
      }
    }).h();
  }
  
  public ListAdapter a()
  {
    return null;
  }
  
  public void a(j paramj)
  {
    i();
    paramj.b();
  }
  
  public void a(ChipLayout paramChipLayout, View paramView, int paramInt)
  {
    String str = ((TextView)paramView).getText().toString();
    f().a(this, str);
    paramChipLayout.a(paramChipLayout.indexOfChild(paramView));
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {}
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      d();
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.c.c(paramString);
  }
  
  public View b()
  {
    return this.b;
  }
  
  public void b(String paramString) {}
  
  public ArrayList c()
  {
    return this.i;
  }
  
  public void d()
  {
    boolean bool2 = false;
    boolean bool1;
    if (!as.m()) {
      bool1 = bool2;
    }
    for (;;)
    {
      a(bool1);
      return;
      bool1 = bool2;
      if (!this.f) {
        if ((this.e.getVisibility() != 0) && (this.d.getVisibility() != 0))
        {
          bool1 = bool2;
          if (this.c.getVisibility() == 0)
          {
            bool1 = bool2;
            if (this.c.getChipCount() <= 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public JsonNode e()
  {
    return this.h;
  }
  
  public void i(boolean paramBoolean)
  {
    d();
    if (paramBoolean)
    {
      i();
      return;
    }
    this.i = null;
    this.h = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */