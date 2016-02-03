package com.ideashower.readitlater.reader;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.CheckableImageButton;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.stats.f;
import com.pocket.widget.al;
import java.util.ArrayList;
import java.util.Iterator;

public class n
{
  protected ReaderFragment a;
  protected LayoutInflater b;
  protected StyledToolbar c;
  protected ReaderToolbarLayout d;
  protected StyledIconButton e;
  protected StyledIconButton f;
  protected StyledIconButton g;
  protected StyledIconButton h;
  protected StyledIconButton i;
  protected StyledIconButton j;
  protected StyledIconButton k;
  protected al l;
  protected View m;
  public ArrayList n;
  private final o o;
  private RilButton p;
  private int q = 1;
  
  public n(ReaderFragment paramReaderFragment, ReaderToolbarLayout paramReaderToolbarLayout, View paramView, o paramo)
  {
    this.a = paramReaderFragment;
    this.m = paramView;
    this.d = paramReaderToolbarLayout;
    this.o = paramo;
    this.b = LayoutInflater.from(paramReaderFragment.m());
    a();
  }
  
  private StyledIconButton a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    StyledIconButton localStyledIconButton = (StyledIconButton)this.b.inflate(2130903171, this.c, false);
    localStyledIconButton.setImageResource(paramInt1);
    localStyledIconButton.setOnClickListener(paramOnClickListener);
    localStyledIconButton.setTooltip(paramInt2);
    this.c.addView(localStyledIconButton);
    return localStyledIconButton;
  }
  
  private void h()
  {
    this.e = a(2130837853, 2131493344, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.a(n.this).g();
      }
    });
    this.e.setCheckable(true);
    this.e.setCheckedUseSourceImage(true);
    this.f = a(2130837850, 2131493342, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.a(n.this).f();
      }
    });
    this.g = a(2130837858, 2131493347, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.a(n.this).b(((CheckableImageButton)paramAnonymousView).isChecked());
      }
    });
    this.g.setId(1002);
    this.g.setCheckable(true);
    this.g.setCheckedUseSourceImage(true);
    this.i = a(2130837874, 2131493350, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.a(n.this).a(false);
      }
    });
    int i1;
    if ((j.c()) || (com.ideashower.readitlater.util.a.d()))
    {
      this.h = a(2130837875, 2131493351, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          n.a(n.this).b();
        }
      });
      i1 = 0;
      if (!j.d()) {
        break label451;
      }
      this.k = a(2130837876, 2131493349, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          n.a(n.this).a();
        }
      });
    }
    label451:
    for (int i2 = 0;; i2 = 1)
    {
      final Object localObject = new ArrayList();
      this.n = ((ArrayList)localObject);
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493483, 2130837657, 2130837658)
      {
        public void a()
        {
          n.a(n.this).a(1);
        }
        
        public boolean b()
        {
          return n.this.a.am() == 2;
        }
      });
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493486, 2130837674, 2130837675)
      {
        public void a()
        {
          n.a(n.this).a(2);
        }
        
        public boolean b()
        {
          return n.this.a.am() == 1;
        }
      });
      if (i2 != 0) {
        ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493471, 2130837667, 2130837668)
        {
          public void a()
          {
            n.a(n.this).a();
          }
        });
      }
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493449, 2130837672, 2130837673)
      {
        public void a()
        {
          n.a(n.this).e();
        }
        
        public boolean b()
        {
          return n.this.a.ao() != null;
        }
      });
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493455, 2130837659, 2130837660)
      {
        public void a()
        {
          n.a(n.this).d();
        }
        
        public boolean b()
        {
          return n.this.a.ao() != null;
        }
      });
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493463, 2130837666, 2130837664)
      {
        public void a()
        {
          n.a(n.this).c();
        }
        
        public boolean b()
        {
          return n.this.a.am() != 3;
        }
      });
      if (i1 != 0) {
        ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493456, 2130837671, 2130837661)
        {
          public void a()
          {
            n.a(n.this).b();
          }
        });
      }
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493473, 2130837665, 2130837669)
      {
        public void a()
        {
          f.a(n.this.a.ap(), n.this.a.m());
        }
        
        public boolean b()
        {
          return n.this.a.am() != 3;
        }
      });
      if (com.ideashower.readitlater.util.a.e())
      {
        this.j = a(2130837871, 2131492916, new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new ArrayList();
            paramAnonymousView.addAll(localObject);
            if (n.this.a.am() == 1) {
              paramAnonymousView.remove(0);
            }
            for (;;)
            {
              n.this.l = new al(n.this.a.m(), paramAnonymousView, false, null);
              n.this.l.a(n.this.j);
              return;
              paramAnonymousView.remove(1);
            }
          }
        });
        localObject = new LinearLayout.LayoutParams(-2, -1);
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      i1 = 1;
      break;
    }
  }
  
  private void i()
  {
    j();
    this.e = a(2130837853, 2131493344, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.a(n.this).g();
      }
    });
    this.e.setCheckable(true);
    this.e.setCheckedUseSourceImage(true);
    final Object localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = j.a(4.0F);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.f = a(2130837850, 2131493342, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.a(n.this).f();
      }
    });
    localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = j.a(4.0F);
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.g = a(2130837858, 2131493347, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.a(n.this).b(((CheckableImageButton)paramAnonymousView).isChecked());
      }
    });
    this.g.setCheckable(true);
    this.g.setCheckedUseSourceImage(true);
    k();
    int i1;
    if (j.c())
    {
      this.h = a(2130837875, 2131493351, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          n.a(n.this).b();
        }
      });
      i1 = 0;
      this.i = a(2130837874, 2131493350, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          n.a(n.this).a(false);
        }
      });
      if (!j.d()) {
        break label520;
      }
      this.k = a(2130837876, 2131493349, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          n.a(n.this).a();
        }
      });
    }
    label520:
    for (int i2 = 0;; i2 = 1)
    {
      localObject = new ArrayList();
      this.n = ((ArrayList)localObject);
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493483, 2130837657, 2130837658)
      {
        public void a()
        {
          n.a(n.this).a(1);
        }
        
        public boolean b()
        {
          return n.this.a.am() == 2;
        }
      });
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493486, 2130837674, 2130837675)
      {
        public void a()
        {
          n.a(n.this).a(2);
        }
        
        public boolean b()
        {
          return n.this.a.am() == 1;
        }
      });
      if (i2 != 0) {
        ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493471, 2130837667, 2130837668)
        {
          public void a()
          {
            n.a(n.this).a();
          }
        });
      }
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493449, 2130837672, 2130837673)
      {
        public void a()
        {
          n.a(n.this).e();
        }
        
        public boolean b()
        {
          return n.this.a.ao() != null;
        }
      });
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493455, 2130837659, 2130837660)
      {
        public void a()
        {
          n.a(n.this).d();
        }
        
        public boolean b()
        {
          return n.this.a.ao() != null;
        }
      });
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493463, 2130837666, 2130837664)
      {
        public void a()
        {
          n.a(n.this).c();
        }
        
        public boolean b()
        {
          return n.this.a.am() != 3;
        }
      });
      if (i1 != 0) {
        ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493456, 2130837671, 2130837661)
        {
          public void a()
          {
            n.a(n.this).b();
          }
        });
      }
      ((ArrayList)localObject).add(new com.pocket.widget.a(((ArrayList)localObject).size(), 2131493473, 2130837665, 2130837669)
      {
        public void a()
        {
          f.a(n.this.a.ap(), n.this.a.m());
        }
        
        public boolean b()
        {
          return n.this.a.am() != 3;
        }
      });
      if (com.ideashower.readitlater.util.a.e())
      {
        this.j = a(2130837871, 2131492916, new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new ArrayList();
            paramAnonymousView.addAll(localObject);
            if (n.this.a.am() == 1) {
              paramAnonymousView.remove(0);
            }
            for (;;)
            {
              n.this.l = new al(n.this.a.m(), paramAnonymousView, false, null);
              n.this.l.a(n.this.j);
              return;
              paramAnonymousView.remove(1);
            }
          }
        });
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        localLayoutParams.gravity = 17;
        this.j.setLayoutParams(localLayoutParams);
        this.j.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new ArrayList();
            paramAnonymousView.addAll(localObject);
            if (n.this.a.am() == 1) {
              paramAnonymousView.remove(0);
            }
            for (;;)
            {
              n.this.l = new al(n.this.a.m(), paramAnonymousView, false, null);
              n.this.l.a(n.this.j);
              return;
              paramAnonymousView.remove(1);
            }
          }
        });
      }
      return;
      i1 = 1;
      break;
    }
  }
  
  private void j()
  {
    ViewGroup localViewGroup = (ViewGroup)this.c.b(false).getParent();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localViewGroup.getLayoutParams();
    localLayoutParams.width = -2;
    localLayoutParams.weight = 0.0F;
    localViewGroup.setLayoutParams(localLayoutParams);
  }
  
  private void k()
  {
    View localView = new View(this.a.m());
    this.c.addView(localView, new LinearLayout.LayoutParams(0, j.a(1.0F), 1.0F));
  }
  
  private void l()
  {
    if (!this.a.an()) {
      return;
    }
    if (this.q == 2)
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    com.ideashower.readitlater.e.o localo = this.a.ao();
    if (localo != null)
    {
      this.g.setChecked(localo.ae());
      return;
    }
    this.g.setChecked(false);
  }
  
  private void m()
  {
    if (!this.a.an()) {}
    do
    {
      return;
      if (this.q == 2)
      {
        if (this.p == null)
        {
          this.p = ((RilButton)this.b.inflate(2130903172, this.c, false));
          this.p.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              n.a(n.this).a(true);
            }
          });
          this.c.addView(this.p);
        }
        this.p.setVisibility(0);
        return;
      }
    } while (this.p == null);
    this.p.setVisibility(8);
  }
  
  public void a()
  {
    this.c = ((StyledToolbar)this.d.findViewById(2131230742));
    this.c.setIsTopToolbar(true);
    this.c.a(true, this.a, true);
    if (j.c()) {
      i();
    }
    for (;;)
    {
      b(false);
      return;
      h();
    }
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
    b(false);
  }
  
  public void a(Menu paramMenu)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      com.pocket.widget.a locala = (com.pocket.widget.a)localIterator.next();
      paramMenu.add(locala.h, locala.f, locala.g, locala.c).setIcon(locala.d);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.setShadowVisibility(paramBoolean);
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId() - 3;
    if ((i1 >= 0) && (i1 < this.n.size()))
    {
      ((com.pocket.widget.a)this.n.get(i1)).a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    int i2 = 1;
    int i3 = 0;
    int i1;
    if (this.a.am() == 3)
    {
      i1 = 1;
      if (this.q != 2) {
        break label63;
      }
    }
    for (;;)
    {
      if (this.k != null)
      {
        StyledIconButton localStyledIconButton = this.k;
        if (i1 == 0)
        {
          i1 = i3;
          if (i2 == 0) {}
        }
        else
        {
          i1 = 8;
        }
        localStyledIconButton.setVisibility(i1);
      }
      return;
      i1 = 0;
      break;
      label63:
      i2 = 0;
    }
  }
  
  public void b(Menu paramMenu)
  {
    paramMenu.setGroupVisible(-1, false);
    paramMenu.setGroupVisible(-2, false);
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      com.pocket.widget.a locala = (com.pocket.widget.a)localIterator.next();
      paramMenu.findItem(locala.f).setEnabled(locala.c()).setVisible(locala.b());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i2 = 0;
    c(paramBoolean);
    c();
    m();
    if (this.q == 2) {}
    for (int i1 = 8;; i1 = 0)
    {
      if (this.i.getVisibility() != i1) {
        i2 = 1;
      }
      this.i.setVisibility(i1);
      if (this.h != null) {
        this.h.setVisibility(i1);
      }
      if (this.j != null) {
        this.j.setVisibility(i1);
      }
      if (i2 != 0) {
        this.c.post(new Runnable()
        {
          public void run()
          {
            n.this.c.requestLayout();
          }
        });
      }
      return;
    }
  }
  
  public void c()
  {
    d();
    l();
  }
  
  public void c(boolean paramBoolean)
  {
    int i3 = 0;
    if (this.a.Q()) {
      return;
    }
    int i4 = this.a.am();
    int i1;
    Object localObject;
    int i2;
    if (i4 == 3)
    {
      i1 = 1;
      b();
      if (this.h != null)
      {
        localObject = this.h;
        if (i1 == 0) {
          break label111;
        }
        i2 = 2130837856;
        label56:
        ((StyledIconButton)localObject).setImageResource(i2);
      }
      if (i4 != 2) {
        break label117;
      }
      i1 = StyledToolbar.g;
      this.d.a(false, true);
      this.a.T().c(1);
    }
    for (;;)
    {
      b();
      this.c.a(i1, paramBoolean);
      return;
      i1 = 0;
      break;
      label111:
      i2 = 2130837875;
      break label56;
      label117:
      i4 = StyledToolbar.b;
      localObject = this.a.T();
      i2 = i3;
      if (i1 != 0) {
        i2 = 2;
      }
      ((com.ideashower.readitlater.activity.a)localObject).c(i2);
      i1 = i4;
    }
  }
  
  public void d()
  {
    if (!this.a.an()) {
      return;
    }
    if (this.q == 2)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    com.ideashower.readitlater.e.o localo = this.a.ao();
    if ((localo != null) && (localo.aj()))
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
    }
    for (;;)
    {
      this.e.setChecked(false);
      return;
      this.e.setVisibility(8);
      this.f.setVisibility(0);
    }
  }
  
  public boolean e()
  {
    return this.g.isChecked();
  }
  
  public View f()
  {
    return this.h;
  }
  
  public int g()
  {
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */