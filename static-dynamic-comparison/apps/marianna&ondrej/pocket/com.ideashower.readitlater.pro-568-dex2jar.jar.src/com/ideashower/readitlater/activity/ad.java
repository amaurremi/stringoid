package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.o.a.b;
import com.pocket.o.a.i;
import com.pocket.o.a.m;
import com.pocket.p.s;
import com.pocket.widget.DropDownMessageView;
import com.pocket.widget.RainbowProgressCircleView;
import com.pocket.widget.ax;
import com.pocket.widget.ay;
import com.pocket.widget.bb;
import com.pocket.widget.bc;
import com.pocket.widget.chip.ChipEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.codehaus.jackson.JsonNode;

public class ad
  extends f
{
  private ae Y;
  private String Z;
  private boolean aa;
  private ChipEditText ab;
  private ListView ac;
  private RelativeLayout ad;
  private RainbowProgressCircleView ae;
  private View af;
  private DropDownMessageView ag;
  private com.pocket.o.a.l ah;
  private boolean ai;
  private ax aj;
  private boolean ak;
  private com.pocket.o.a.c al;
  
  public static com.pocket.p.l Y()
  {
    if (j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  private ListAdapter Z()
  {
    aa();
    com.a.a.a.a locala = new com.a.a.a.a();
    a(locala);
    e(locala);
    b(locala);
    d(locala);
    c(locala);
    return locala;
  }
  
  public static Bundle a(o paramo, UiContext paramUiContext)
  {
    return a(paramo.i(), paramo.c(), paramo.w(), paramUiContext);
  }
  
  public static Bundle a(String paramString, int paramInt, ArrayList paramArrayList, UiContext paramUiContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("item_url", paramString);
    localBundle.putInt("item_id", paramInt);
    localBundle.putStringArrayList("item_tags", new ArrayList(paramArrayList));
    localBundle.putParcelable("ui_context", paramUiContext);
    return localBundle;
  }
  
  public static Bundle a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("items", paramArrayList1);
    localBundle.putParcelableArrayList("ui_contexts", paramArrayList2);
    return localBundle;
  }
  
  public static void a(android.support.v4.app.f paramf, Bundle paramBundle)
  {
    if (Y() == com.pocket.p.l.a)
    {
      com.pocket.p.k.a(l(paramBundle), paramf);
      return;
    }
    ItemsTaggingActivity.a(paramf, paramBundle, false);
  }
  
  private void a(final com.a.a.a.a parama)
  {
    if (this.Y != ae.a) {
      return;
    }
    this.al = new com.pocket.o.a.c(this.Z, this.ah, new com.pocket.o.a.k()
    {
      public void a(i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        parama.b(paramAnonymousi.b(), paramAnonymousBoolean);
      }
    }, this.ac);
    this.ah.a(this.al);
    parama.a(this.al.b());
    this.al.d();
  }
  
  private void aa()
  {
    com.pocket.o.a.e locale = new com.pocket.o.a.e(this.ah, new com.pocket.o.a.k()
    {
      public void a(i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        z.c(ad.e(ad.this), paramAnonymousBoolean);
      }
    }, this.ab);
    this.ah.a(locale);
  }
  
  private void ab()
  {
    ArrayList localArrayList1;
    Object localObject;
    ArrayList localArrayList2;
    if (this.ah.e())
    {
      if (!this.ab.f()) {
        return;
      }
      localArrayList1 = this.ah.d();
      Collections.sort(localArrayList1);
      if (this.Y != ae.a) {
        break label178;
      }
      localObject = (UiContext)l().getParcelable("ui_context");
      if (this.al == null) {
        break label331;
      }
      localArrayList2 = this.al.c();
      if (localArrayList2 == null) {
        break label331;
      }
    }
    label178:
    label331:
    for (int i = localArrayList2.size();; i = 0)
    {
      localObject = UiContext.a(((UiContext)localObject).c(), this.ah.g(), i, this.ah.h(), this.ah.i(), this.ah.j(), this.ah.k());
      new com.ideashower.readitlater.db.operation.action.ad(this.Z, new ArrayList(localArrayList1), (UiContext)localObject).j();
      Toast.makeText(m(), a(2131493774), 0).show();
      for (;;)
      {
        this.ak = true;
        P();
        return;
        if (this.Y == ae.b)
        {
          localObject = l().getStringArrayList("items");
          localArrayList2 = l().getParcelableArrayList("ui_contexts");
          ArrayList localArrayList3 = new ArrayList(((ArrayList)localObject).size());
          Iterator localIterator = ((ArrayList)localObject).iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localArrayList3.add(new com.ideashower.readitlater.db.operation.action.e((String)localIterator.next(), localArrayList1, (UiContext)localArrayList2.get(i)));
            i += 1;
          }
          com.ideashower.readitlater.db.operation.action.c.a(localArrayList3, true);
          Toast.makeText(m(), a(2131493740, new Object[] { Integer.valueOf(localArrayList1.size()), Integer.valueOf(((ArrayList)localObject).size()) }), 1).show();
        }
      }
    }
  }
  
  private boolean ac()
  {
    if ((this.ak) || (!this.ah.e())) {
      return false;
    }
    new AlertDialog.Builder(m()).setTitle(2131493060).setMessage(2131493061).setPositiveButton(2131492890, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ad.b(ad.this, true);
        ad.this.P();
      }
    }).setNegativeButton(2131492884, null).show();
    return true;
  }
  
  private void b(final com.a.a.a.a parama)
  {
    final TextView localTextView1 = com.pocket.widget.d.a(m(), this.ac, 2131493262);
    final Object localObject2 = com.pocket.widget.d.a(m(), this.ad, 2131493262);
    final Object localObject1 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(6, this.ac.getId());
    ((View)localObject2).setClickable(true);
    this.ad.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new bb((View)localObject2, 8);
    TextView localTextView2 = (TextView)localTextView1;
    localObject2 = (TextView)localObject2;
    localObject2 = new com.pocket.o.a.f(this.ah, new com.pocket.o.a.k()
    {
      public void a(i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        parama.a(paramAnonymousi.a(), paramAnonymousBoolean);
        parama.b(localTextView1, paramAnonymousBoolean);
        localObject1.a();
      }
    }, m(), new TextView[] { localTextView2, localObject2 });
    ((bb)localObject1).a(new bc()
    {
      private boolean b()
      {
        int i = ad.f(ad.this).getFirstVisiblePosition();
        if (localTextView1.getParent() != null) {
          if (i < ad.f(ad.this).getPositionForView(localTextView1)) {}
        }
        while (parama.a(i) == localObject2.a())
        {
          return true;
          return false;
        }
        return false;
      }
      
      public boolean a()
      {
        boolean bool = b();
        View localView = localTextView1;
        if (bool) {}
        for (int i = 4;; i = 0)
        {
          localView.setVisibility(i);
          return bool;
        }
      }
    });
    ((bb)localObject1).a(new bc()
    {
      public boolean a()
      {
        return localObject2.h();
      }
    });
    this.ac.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        localObject1.a();
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.ah.a((i)localObject2);
    parama.a(localTextView1);
    parama.a(((com.pocket.o.a.f)localObject2).a());
  }
  
  private void c(final com.a.a.a.a parama)
  {
    com.pocket.o.a.a locala = new com.pocket.o.a.a(this.ah, new com.pocket.o.a.k()
    {
      public void a(i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        parama.b(paramAnonymousi.b(), paramAnonymousBoolean);
      }
    }, this.ac);
    this.ah.a(locala);
    parama.a(locala.b());
  }
  
  private void d(final com.a.a.a.a parama)
  {
    b localb = new b(this.ah, new com.pocket.o.a.k()
    {
      public void a(i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        parama.b(paramAnonymousi.b(), paramAnonymousBoolean);
      }
    }, this.ac);
    this.ah.a(localb);
    parama.a(localb.b());
  }
  
  private void e(final com.a.a.a.a parama)
  {
    if (this.Y != ae.a) {
      return;
    }
    com.pocket.o.a.d locald = new com.pocket.o.a.d(this.ah, new com.pocket.o.a.k()
    {
      public void a(i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        parama.b(paramAnonymousi.b(), paramAnonymousBoolean);
      }
    }, m());
    this.ah.a(locald);
    parama.a(locald.b());
    locald.c();
  }
  
  private void g(boolean paramBoolean)
  {
    this.ai = paramBoolean;
    if (paramBoolean)
    {
      this.ae.setVisibility(0);
      this.ad.setVisibility(4);
    }
    for (;;)
    {
      this.aj.a();
      return;
      this.ae.setVisibility(8);
      this.ad.setVisibility(0);
    }
  }
  
  public static ad l(Bundle paramBundle)
  {
    ad localad = new ad();
    localad.g(paramBundle);
    return localad;
  }
  
  public String K()
  {
    return "edit_tags";
  }
  
  public void P()
  {
    if (ac()) {}
    do
    {
      return;
      super.P();
    } while (!(m() instanceof StandaloneItemsTaggingActivity));
    m().finish();
  }
  
  public boolean W()
  {
    if (ac()) {
      return true;
    }
    return super.W();
  }
  
  public void a(s params)
  {
    if (this.Z != null)
    {
      params.a("Item: \n\n" + this.Z);
      params.b(g.b().o());
      if ((this.al != null) && (this.al.e() != null)) {
        params.a(this.al.e().toString());
      }
      params.a("Email: " + org.apache.a.c.k.c(as.j()));
      params.a("Item Id: " + l().getInt("item_id"));
      return;
    }
    params.a("Items: \n\n" + l().getStringArrayList("items").toString());
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903053, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.Z = l().getString("item_url");
    Object localObject;
    if (this.Z != null)
    {
      localObject = ae.a;
      this.Y = ((ae)localObject);
      if (paramBundle == null) {
        break label320;
      }
    }
    label320:
    for (boolean bool = true;; bool = false)
    {
      this.aa = bool;
      this.ad = ((RelativeLayout)c(2131230730));
      this.ae = ((RainbowProgressCircleView)c(2131230758));
      this.ab = ((ChipEditText)c(2131230803));
      this.ac = ((ListView)c(2131230754));
      this.af = c(2131230743);
      this.ag = ((DropDownMessageView)c(2131230804));
      ((StyledToolbar)c(2131230742)).a(true, this);
      this.af.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ad.a(ad.this);
        }
      });
      this.ah = new com.pocket.o.a.l(new m()
      {
        public void a()
        {
          ad.b(ad.this).a();
        }
        
        public void a(String paramAnonymousString)
        {
          ad.b(ad.this).a(paramAnonymousString, true);
        }
        
        public void a(boolean paramAnonymousBoolean)
        {
          ad.a(ad.this, paramAnonymousBoolean);
          if (ad.c(ad.this) != null) {
            ad.c(ad.this).a();
          }
        }
        
        public void b()
        {
          if (ad.c(ad.this) != null) {
            ad.c(ad.this).a();
          }
        }
      }, paramBundle);
      localObject = Z();
      this.ac.setAdapter((ListAdapter)localObject);
      this.ac.setSelector(new ColorDrawable(0));
      this.ac.setDivider(new com.pocket.i.a.a(m(), 2131165766));
      this.ac.setDividerHeight(1);
      this.aj = new ax(this.af);
      this.aj.a(this.ah);
      this.aj.a(new ay()
      {
        public boolean a()
        {
          return !ad.d(ad.this);
        }
      });
      if ((this.Y != ae.a) || (this.aa)) {
        break label325;
      }
      this.ah.a(this.Z, l().getStringArrayList("item_tags"), true);
      return;
      localObject = ae.b;
      break;
    }
    label325:
    if ((this.Y == ae.a) && (this.aa))
    {
      paramBundle = paramBundle.getStringArrayList("tagList");
      this.ah.a(this.Z, paramBundle, false);
      return;
    }
    this.ah.c();
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    this.ah.a(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */