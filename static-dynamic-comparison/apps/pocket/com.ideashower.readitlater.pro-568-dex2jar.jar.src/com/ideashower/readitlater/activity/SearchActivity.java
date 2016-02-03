package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.au;
import com.ideashower.readitlater.db.operation.action.y;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.SearchField;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.l;
import com.pocket.list.adapter.data.n;
import com.pocket.list.adapter.h;
import com.pocket.list.widget.PocketView;
import com.pocket.p.s;
import com.pocket.widget.chip.i;
import com.pocket.widget.v;
import com.pocket.widget.w;
import com.pocket.widget.x;
import java.util.ArrayList;

public class SearchActivity
  extends a
  implements View.OnClickListener, au, com.pocket.list.g, com.pocket.n.b, com.pocket.n.d
{
  private boolean A = false;
  private LayoutInflater B;
  private PocketView C;
  private View D;
  private SearchField E;
  private StyledIconButton F;
  private View G;
  private View H;
  private View I;
  private View J;
  private View K;
  private View L;
  private View M;
  private View N;
  private View O;
  private View P;
  private v Q;
  private v R;
  private ArrayList S;
  private View T;
  private com.pocket.widget.al U;
  private View V;
  private RilButton W;
  private View X;
  private View Y;
  private final ItemQuery Z = new ItemQuery();
  private boolean aa = false;
  private PopupWindow z;
  
  private void G()
  {
    this.X.setVisibility(0);
    this.Y.setVisibility(8);
    com.pocket.n.a.a(this);
    com.pocket.n.a.c(this);
  }
  
  private void H()
  {
    final LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
    this.F.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = localLayoutInflater.inflate(2130903144, null);
        ((TextView)paramAnonymousView.findViewById(2131230902)).setText(2131493333);
        SearchActivity.a(SearchActivity.this, new com.pocket.widget.al(SearchActivity.this, SearchActivity.q(SearchActivity.this), true, paramAnonymousView));
        SearchActivity.s(SearchActivity.this).a(SearchActivity.r(SearchActivity.this));
      }
    });
  }
  
  private void I()
  {
    if (!this.C.getQuery().y())
    {
      if (this.A)
      {
        this.N.setEnabled(false);
        this.O.setEnabled(false);
        this.P.setEnabled(false);
      }
      for (;;)
      {
        this.F.setEnabled(false);
        return;
        this.H.setVisibility(8);
      }
    }
    if (this.A)
    {
      this.N.setEnabled(true);
      this.O.setEnabled(true);
      this.P.setEnabled(true);
    }
    for (;;)
    {
      this.F.setEnabled(true);
      return;
      this.H.setVisibility(0);
    }
  }
  
  private ArrayList J()
  {
    boolean bool2 = true;
    ArrayList localArrayList = new ArrayList();
    int i = this.C.getQuery().j();
    if (i == 6)
    {
      bool1 = true;
      localArrayList.add(new ay(this, 0, 2131492952, bool1));
      if (i != 0) {
        break label105;
      }
      bool1 = true;
      label54:
      localArrayList.add(new ay(this, 1, 2131492950, bool1));
      if (i != 1) {
        break label110;
      }
    }
    label105:
    label110:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localArrayList.add(new ay(this, 2, 2131492951, bool1));
      return localArrayList;
      bool1 = false;
      break;
      bool1 = false;
      break label54;
    }
  }
  
  private void K()
  {
    int i = 0;
    ItemQuery localItemQuery = this.C.getQuery();
    if ((localItemQuery.y()) && (as.m())) {
      com.pocket.n.a.a(new com.pocket.n.g(localItemQuery.x(), localItemQuery.d()), null);
    }
    if ((!this.C.getQuery().l()) && (!this.Z.a(localItemQuery, false, false, false, true)))
    {
      this.Z.a().a(localItemQuery).a();
      if (this.C.getAdapter() != null) {
        i = this.C.getAdapter().getCount();
      }
      new y(localItemQuery.c(), i).j();
    }
  }
  
  private String L()
  {
    ItemQuery localItemQuery = this.C.getQuery();
    String str2 = localItemQuery.x();
    String str1 = str2;
    if (localItemQuery.d() != null) {
      str1 = localItemQuery.d() + " " + str2;
    }
    return str1;
  }
  
  public static Intent a(Context paramContext, ItemQuery paramItemQuery)
  {
    return new Intent(paramContext, SearchActivity.class).putExtra("extraCameFromQuery", paramItemQuery);
  }
  
  public static void a(Activity paramActivity, ItemQuery paramItemQuery)
  {
    paramActivity.startActivity(a(paramActivity, paramItemQuery));
  }
  
  private void a(Bundle paramBundle)
  {
    if (j.d())
    {
      this.z = new PopupWindow(this);
      a(this.E);
    }
    for (;;)
    {
      if (as.m()) {
        G();
      }
      return;
      f(false);
    }
  }
  
  private void a(ListView paramListView)
  {
    paramListView.setCacheColorHint(0);
    paramListView.setVerticalFadingEdgeEnabled(false);
    paramListView.setSelector(new ColorDrawable(0));
    ax localax = new ax(getResources(), 2131165767);
    localax.setState(paramListView.getDrawableState());
    paramListView.setDivider(localax);
    paramListView.setDividerHeight(1);
  }
  
  private void a(final SearchField paramSearchField)
  {
    if (this.z.isShowing()) {
      this.z.dismiss();
    }
    this.z.setBackgroundDrawable(null);
    this.z.setInputMethodMode(1);
    if ((this.S == null) || (this.S.size() == 0)) {
      f(true);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.E.getText())) {
        paramSearchField.post(new Runnable()
        {
          public void run()
          {
            paramSearchField.getWidth();
            j.a(30.0F);
            SearchActivity.p(SearchActivity.this).showAsDropDown(paramSearchField);
            SearchActivity.p(SearchActivity.this).update(paramSearchField, -j.a(16.0F), -j.a(3.0F), SearchActivity.a(SearchActivity.this, paramSearchField.getWidth() + j.a(30.0F)), j.a(250.0F));
          }
        });
      }
      this.C.getAdapter().a(new com.pocket.list.adapter.f()
      {
        public void a(com.pocket.list.adapter.a paramAnonymousa)
        {
          if (paramAnonymousa.c().x() == null)
          {
            paramSearchField.post(new Runnable()
            {
              public void run()
              {
                SearchActivity.p(SearchActivity.this).showAsDropDown(SearchActivity.3.this.a);
                SearchActivity.p(SearchActivity.this).update(SearchActivity.3.this.a, -j.a(16.0F), -j.a(3.0F), SearchActivity.a(SearchActivity.this, SearchActivity.3.this.a.getWidth() + j.a(30.0F)), j.a(200.0F));
              }
            });
            return;
          }
          SearchActivity.p(SearchActivity.this).dismiss();
        }
      });
      return;
      a(this.S, true);
    }
  }
  
  private void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    com.a.a.a.a locala = new com.a.a.a.a();
    if (paramArrayList.size() < 3)
    {
      localObject = this.B.inflate(2130903137, null);
      ((View)localObject).findViewById(2131231037).setVisibility(8);
      ((View)localObject).setPadding(j.a(30.0F), j.a(30.0F), j.a(30.0F), j.a(15.0F));
      locala.a((View)localObject);
    }
    paramArrayList = new com.pocket.n.c(this, paramArrayList, this);
    Object localObject = this.B.inflate(2130903099, null);
    if (j.e())
    {
      View localView = ((View)localObject).findViewById(2131230946);
      ((View)localObject).findViewById(2131230946).setPadding(j.a(52.0F), localView.getPaddingTop(), localView.getPaddingRight(), localView.getPaddingBottom());
    }
    locala.a((View)localObject);
    locala.a(paramArrayList);
    if (paramBoolean)
    {
      paramArrayList = this.B.inflate(2130903139, null);
      paramArrayList.findViewById(2131231042).setVisibility(8);
      paramArrayList.findViewById(2131231043).setVisibility(0);
      paramArrayList.findViewById(2131231043);
      localObject = (ListView)paramArrayList.findViewById(2131231130);
      ((ListView)localObject).setAdapter(locala);
      a((ListView)localObject);
      this.z.setWindowLayoutMode(this.z.getWidth(), -2);
      this.z.setContentView(paramArrayList);
      return;
    }
    paramArrayList = this.B.inflate(2130903174, null, false);
    paramArrayList.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localObject = (ListView)paramArrayList.findViewById(2131231130);
    ((ListView)localObject).setAdapter(locala);
    a((ListView)localObject);
    this.C.getEmptyView().setDisabledView(paramArrayList);
  }
  
  private void b(Bundle paramBundle)
  {
    paramBundle = new x()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt)
      {
        l locall = SearchActivity.b(SearchActivity.this).getQuery().a();
        SearchActivity.c(SearchActivity.this).setVisibility(8);
        if ((paramAnonymousView == SearchActivity.d(SearchActivity.this)) || (paramAnonymousView == SearchActivity.e(SearchActivity.this))) {
          if (as.m()) {
            locall.a(null).b(false);
          }
        }
        for (;;)
        {
          locall.a();
          return;
          if (com.ideashower.readitlater.a.f.b())
          {
            SearchActivity.c(SearchActivity.this).setVisibility(0);
            if (SearchActivity.b(SearchActivity.this).getQuery().y())
            {
              com.pocket.stats.d.b.a(SearchActivity.f(SearchActivity.this), "search");
              continue;
              if ((paramAnonymousView == SearchActivity.g(SearchActivity.this)) || (paramAnonymousView == SearchActivity.h(SearchActivity.this)))
              {
                locall.a(Integer.valueOf(0));
                if (as.m()) {
                  locall.b(true);
                } else {
                  locall.b();
                }
              }
              else
              {
                if ((paramAnonymousView != SearchActivity.i(SearchActivity.this)) && (paramAnonymousView != SearchActivity.j(SearchActivity.this))) {
                  break;
                }
                locall.a(Integer.valueOf(1)).b(false);
              }
            }
          }
        }
        com.ideashower.readitlater.util.e.a("unexpected view " + paramAnonymousView + " at " + paramAnonymousInt);
      }
    };
    if ((!as.m()) && (!com.ideashower.readitlater.a.f.b()))
    {
      this.J.setVisibility(8);
      this.N.setVisibility(8);
      this.R = new w().a(this.K).a(this.L).a();
    }
    for (this.Q = new w().a(this.O).a(this.P).a();; this.Q = new w().a(this.N).a(this.O).a(this.P).a())
    {
      this.R.a(paramBundle);
      this.Q.a(paramBundle);
      this.C.getAdapter().a(new com.pocket.list.adapter.f()
      {
        public void a(com.pocket.list.adapter.a paramAnonymousa)
        {
          paramAnonymousa = SearchActivity.b(SearchActivity.this).getQuery().e();
          if (paramAnonymousa == null) {}
          do
          {
            try
            {
              SearchActivity.k(SearchActivity.this).a(SearchActivity.d(SearchActivity.this));
              SearchActivity.l(SearchActivity.this).a(SearchActivity.e(SearchActivity.this));
              return;
            }
            catch (Exception paramAnonymousa)
            {
              SearchActivity.k(SearchActivity.this).a(SearchActivity.g(SearchActivity.this));
              SearchActivity.l(SearchActivity.this).a(SearchActivity.h(SearchActivity.this));
              return;
            }
            if (paramAnonymousa.intValue() == 0)
            {
              SearchActivity.k(SearchActivity.this).a(SearchActivity.g(SearchActivity.this));
              SearchActivity.l(SearchActivity.this).a(SearchActivity.h(SearchActivity.this));
              return;
            }
          } while (paramAnonymousa.intValue() != 1);
          SearchActivity.k(SearchActivity.this).a(SearchActivity.i(SearchActivity.this));
          SearchActivity.l(SearchActivity.this).a(SearchActivity.j(SearchActivity.this));
        }
      });
      return;
      this.J.setVisibility(0);
      this.N.setVisibility(0);
      this.R = new w().a(this.J).a(this.K).a(this.L).a();
    }
  }
  
  private void c(Bundle paramBundle)
  {
    this.E.a(new com.pocket.widget.chip.a()
    {
      private com.pocket.n.e b;
      
      public void a(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        boolean bool;
        if (!SearchActivity.m(SearchActivity.this))
        {
          com.pocket.list.adapter.data.a locala = SearchActivity.b(SearchActivity.this).getAdapter().b();
          if (org.apache.a.c.k.c(paramAnonymousCharSequence)) {
            break label95;
          }
          bool = true;
          locala.a(bool);
          paramAnonymousCharSequence = SearchActivity.b(SearchActivity.this).getQuery().a().a((String)org.apache.a.c.k.e(paramAnonymousCharSequence.toString(), null));
          if (paramAnonymousInt <= 0) {
            break label100;
          }
          this.b = SearchActivity.b(SearchActivity.this).getQuery().d();
        }
        for (;;)
        {
          paramAnonymousCharSequence.a();
          return;
          label95:
          bool = false;
          break;
          label100:
          if (this.b != null)
          {
            paramAnonymousCharSequence.a(this.b);
            this.b = null;
          }
        }
      }
    });
    d(paramBundle);
    this.C.setOnViewGroupTouchedListener(new com.pocket.list.widget.e()
    {
      public void a()
      {
        SearchActivity.a(SearchActivity.this).d();
      }
    });
    a(new e()
    {
      public void d()
      {
        SearchActivity.a(SearchActivity.this).d();
      }
    });
    this.C.getAdapter().a(new com.pocket.list.adapter.f()
    {
      public void a(com.pocket.list.adapter.a paramAnonymousa)
      {
        CharSequence localCharSequence = null;
        int j = 1;
        final Object localObject = paramAnonymousa.c().x();
        if (!SearchActivity.a(SearchActivity.this).getText().toString().equals(localObject)) {
          SearchActivity.a(SearchActivity.this).setText((String)localObject);
        }
        for (int i = 1;; i = 0)
        {
          localObject = paramAnonymousa.c().d();
          if (localObject != null)
          {
            paramAnonymousa = ((com.pocket.n.e)localObject).toString();
            if (SearchActivity.a(SearchActivity.this).getChipCount() > 0) {
              localCharSequence = SearchActivity.a(SearchActivity.this).a(0);
            }
            if (org.apache.a.c.k.a(paramAnonymousa, localCharSequence)) {
              break label211;
            }
            SearchActivity.a(SearchActivity.this, true);
            SearchActivity.a(SearchActivity.this).i();
            SearchActivity.a(SearchActivity.this, false);
            i = j;
            if (localObject != null)
            {
              SearchActivity.a(SearchActivity.this).a(new i()
              {
                public View a(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int, ViewGroup paramAnonymous2ViewGroup)
                {
                  return localObject.a(SearchActivity.this, paramAnonymous2ViewGroup, com.pocket.n.f.b);
                }
                
                public CharSequence a()
                {
                  return localObject.toString();
                }
              });
              i = j;
            }
          }
          label211:
          for (;;)
          {
            SearchActivity.n(SearchActivity.this);
            if ((i != 0) && (SearchActivity.a(SearchActivity.this).c()))
            {
              SearchActivity.a(SearchActivity.this).b();
              SearchActivity.a(SearchActivity.this).e();
            }
            return;
            paramAnonymousa = null;
            break;
          }
        }
      }
    });
    this.E.setOnInputDoneListener(new com.pocket.widget.chip.c()
    {
      public void a()
      {
        SearchActivity.a(SearchActivity.this).d();
        SearchActivity.b(SearchActivity.this).getAdapter().b().b(true);
      }
    });
    this.E.setOnInputFocusChangedListener(new com.pocket.widget.chip.d()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          SearchActivity.o(SearchActivity.this);
        }
      }
    });
  }
  
  private void d(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      this.C.getQuery().b().a(as.m());
      paramBundle = (ItemQuery)getIntent().getParcelableExtra("extraCameFromQuery");
      if (paramBundle != null)
      {
        a(new com.pocket.n.g(paramBundle.x(), paramBundle.d()));
        if ((paramBundle.e() == null) || (paramBundle.e().intValue() != 1)) {
          break label123;
        }
        this.R.a(this.L);
        this.Q.a(this.P);
      }
    }
    while (as.m())
    {
      this.C.getQuery().a().a(6).a();
      return;
      label123:
      if (as.m())
      {
        if (!com.ideashower.readitlater.a.g.k())
        {
          this.R.a(this.K);
          this.Q.a(this.O);
        }
        else
        {
          this.R.a(this.J);
          this.Q.a(this.N);
        }
      }
      else
      {
        this.R.a(this.K);
        this.Q.a(this.O);
      }
    }
    this.C.getQuery().a().a(0).a();
  }
  
  private int e(int paramInt)
  {
    int i = paramInt;
    if (paramInt < j.a(300.0F)) {
      i = j.a(300.0F);
    }
    return i;
  }
  
  private void e(Bundle paramBundle)
  {
    com.pocket.list.adapter.a locala = this.C.getAdapter();
    if (as.m()) {
      locala.b().a(null);
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        this.C.getAdapter().c().a().a((ItemQuery)paramBundle.getParcelable("stateQuery")).a();
        this.C.getAdapter().b(paramBundle);
        a(true, false, false);
        this.C.getAdapter().a(new h()
        {
          public void a()
          {
            if (!SearchActivity.this.isFinishing()) {
              SearchActivity.this.a(false, false, true);
            }
          }
        });
      }
      locala.b(locala.c().y());
      return;
      locala.b().a(com.ideashower.readitlater.h.a.F);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool;
    if (j.d()) {
      bool = true;
    }
    while ((bool == this.A) && (!paramBoolean))
    {
      return;
      if ((j.e()) && (getResources().getConfiguration().orientation == 2)) {
        bool = true;
      } else {
        bool = false;
      }
    }
    this.A = bool;
    StyledToolbar localStyledToolbar = (StyledToolbar)findViewById(2131230742);
    int i;
    if (bool)
    {
      i = StyledToolbar.a;
      localStyledToolbar.a(i, false);
      if (!bool) {
        break label165;
      }
      this.M.setVisibility(0);
      this.I.setVisibility(8);
      this.H = this.M;
      this.N.setEnabled(false);
      this.O.setEnabled(false);
      this.P.setEnabled(false);
      this.T.setBackgroundDrawable(getResources().getDrawable(2130837802));
    }
    for (;;)
    {
      I();
      return;
      i = StyledToolbar.g;
      break;
      label165:
      this.H = this.I;
      this.I.setVisibility(8);
      this.M.setVisibility(8);
      if (j.c())
      {
        this.T.setBackgroundDrawable(getResources().getDrawable(2130837802));
        this.H.setBackgroundDrawable(getResources().getDrawable(2130837802));
      }
      else
      {
        this.T.setBackgroundDrawable(getResources().getDrawable(2130837534));
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localView = this.B.inflate(2130903139, null);
      ((RelativeLayout)localView.findViewById(2131231034)).setGravity(17);
      localView.findViewById(2131231042).setVisibility(0);
      localView.findViewById(2131231043).setVisibility(8);
      if (as.m()) {
        ((TextView)localView.findViewById(2131231038)).setText(2131493355);
      }
      for (;;)
      {
        this.X = localView.findViewById(2131230758);
        this.Y = localView.findViewById(2131231036);
        this.z.setContentView(localView);
        return;
        ((TextView)localView.findViewById(2131231038)).setText(2131493323);
      }
    }
    View localView = this.B.inflate(2130903137, null);
    this.C.getEmptyView().setBackgroundDrawable(getResources().getDrawable(2130837783));
    this.X = localView.findViewById(2131230758);
    this.Y = localView.findViewById(2131231036);
    ScrollView localScrollView = new ScrollView(this);
    localView.findViewById(2131231035).setVisibility(0);
    localScrollView.addView(localView);
    this.C.getEmptyView().setDisabledView(localScrollView);
    if (as.m())
    {
      ((TextView)findViewById(2131231038)).setText(2131493355);
      return;
    }
    ((TextView)findViewById(2131231038)).setText(2131493323);
  }
  
  public void A()
  {
    super.A();
    this.E.d();
  }
  
  public void C() {}
  
  public void D()
  {
    if ((!as.m()) && (com.ideashower.readitlater.a.f.b())) {
      com.pocket.stats.d.a.a(L(), "search");
    }
  }
  
  public void E()
  {
    if ((!as.m()) && (com.ideashower.readitlater.a.f.b())) {
      com.pocket.stats.d.a.a(L(), "search");
    }
  }
  
  public void F() {}
  
  protected void a(com.pocket.n.g paramg)
  {
    l locall = this.C.getQuery().a();
    locall.a(paramg.b()).e(null).a(null).c(null);
    Object localObject = paramg.a();
    if (localObject != null)
    {
      paramg = ((com.pocket.n.e)localObject).a();
      localObject = ((com.pocket.n.e)localObject).b();
      if (!"tag".equals(paramg)) {
        break label87;
      }
      locall.c((String)localObject);
    }
    for (;;)
    {
      locall.a();
      this.C.getAdapter().b().b(true);
      return;
      label87:
      if ("in".equals(paramg)) {
        if ("favorites".equals(localObject)) {
          locall.a(Boolean.valueOf(true));
        } else if ("shared".equals(localObject)) {
          locall.b(Integer.valueOf(1));
        } else if ("article".equals(localObject)) {
          locall.e(Integer.valueOf(1));
        } else if ("video".equals(localObject)) {
          locall.e(Integer.valueOf(2));
        } else if ("image".equals(localObject)) {
          locall.e(Integer.valueOf(3));
        }
      }
    }
  }
  
  public void a(s params)
  {
    super.a(params);
    params.b(com.ideashower.readitlater.a.g.b().p());
    params.a(this.C.getQuery().toString());
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.X.setVisibility(8);
    this.Y.setVisibility(0);
    this.S = paramArrayList;
    if (paramArrayList.size() != 0) {
      a(paramArrayList, j.d());
    }
  }
  
  public void a(boolean paramBoolean, ErrorReport paramErrorReport) {}
  
  public void d(int paramInt)
  {
    a((com.pocket.n.g)this.S.get(paramInt));
    this.C.getQuery().a().b("recent").a();
    com.ideashower.readitlater.a.g.o().post(new Runnable()
    {
      public void run()
      {
        SearchActivity.a(SearchActivity.this).d();
      }
    });
  }
  
  public String f()
  {
    return "search";
  }
  
  public void i(boolean paramBoolean)
  {
    if (j.d())
    {
      this.z.dismiss();
      this.z = new PopupWindow();
    }
    com.pocket.list.adapter.a locala = this.C.getAdapter();
    K();
    this.E.setText("");
    this.E.i();
    b(null);
    this.C.getQuery().b().a(as.m());
    if (paramBoolean)
    {
      a(null);
      G();
      this.G.setVisibility(8);
      this.F.setVisibility(0);
      locala.b().a(null);
      this.C.getQuery().a().a(6).a();
      return;
    }
    this.S = null;
    a(null);
    this.G.setVisibility(0);
    this.F.setVisibility(8);
    locala.b().a(com.ideashower.readitlater.h.a.F);
    this.C.getQuery().a().a(0).a();
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.D) {
      finish();
    }
    while (paramView != this.W) {
      return;
    }
    al.a(this, 2, "search");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    e(false);
    if (j.d())
    {
      if (this.z.isShowing()) {
        this.z.dismiss();
      }
      this.z = new PopupWindow(this);
      a(this.E);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903061);
    this.B = ((LayoutInflater)getSystemService("layout_inflater"));
    this.D = findViewById(2131230876);
    this.E = ((SearchField)findViewById(2131230806));
    this.I = findViewById(2131230884);
    this.M = findViewById(2131230877);
    this.T = findViewById(2131230875);
    this.J = findViewById(2131230885);
    this.K = findViewById(2131230886);
    this.L = findViewById(2131230856);
    this.N = findViewById(2131230878);
    this.O = findViewById(2131230879);
    this.P = findViewById(2131230880);
    this.C = ((PocketView)findViewById(2131230754));
    this.V = findViewById(2131230874);
    this.W = ((RilButton)findViewById(2131231041));
    this.W.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.G = findViewById(2131230881);
    this.F = ((StyledIconButton)findViewById(2131230883));
    H();
    if (as.m())
    {
      this.G.setVisibility(8);
      this.F.setVisibility(0);
    }
    for (;;)
    {
      b(paramBundle);
      c(paramBundle);
      a(paramBundle);
      e(true);
      e(paramBundle);
      if (paramBundle == null) {
        com.ideashower.readitlater.a.g.o().post(new Runnable()
        {
          public void run()
          {
            SearchActivity.a(SearchActivity.this).b();
          }
        });
      }
      as.a(this);
      return;
      this.G.setVisibility(0);
      this.F.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.pocket.n.a.b(this);
    as.b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    K();
    this.C.getAdapter().b(this);
  }
  
  public void onResume()
  {
    super.onResume();
    this.C.getAdapter().a(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.C.getAdapter().a(paramBundle);
    paramBundle.putParcelable("stateQuery", this.C.getQuery());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/SearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */