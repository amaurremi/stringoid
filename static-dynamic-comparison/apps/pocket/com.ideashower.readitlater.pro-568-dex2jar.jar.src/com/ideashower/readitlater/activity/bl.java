package com.ideashower.readitlater.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.aa;
import android.support.v4.view.bn;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.activity.b.c;
import com.ideashower.readitlater.activity.b.d;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.GSFImageView;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.p.l;
import java.util.ArrayList;
import java.util.Iterator;

public class bl
  extends f
{
  static d Y;
  protected ToolbarLayout Z;
  protected StyledToolbar aa;
  protected StyledToolbar ab;
  protected RilButton ac;
  protected RilButton ad;
  protected ViewPager ae;
  private String af;
  private int ag;
  private String ah;
  private final ArrayList ai = new ArrayList();
  
  public static l Y()
  {
    if (j.g()) {
      return l.a;
    }
    return l.b;
  }
  
  private boolean Z()
  {
    if (this.ae == null) {}
    int i;
    do
    {
      return false;
      i = this.ae.getCurrentItem();
    } while (i == 0);
    this.ae.setCurrentItem(i - 1);
    return true;
  }
  
  public static bl a(String paramString1, int paramInt, String paramString2)
  {
    bl localbl = new bl();
    Bundle localBundle = new Bundle();
    localBundle.putString("section", paramString1);
    localBundle.putInt("config_id", paramInt);
    localBundle.putString("single_page", paramString2);
    localbl.g(localBundle);
    if (paramString2 != null)
    {
      if (paramString2.equals("see_apps")) {
        Y = com.ideashower.readitlater.activity.b.e.a(0);
      }
      while (!paramString2.equals("browsers")) {
        return localbl;
      }
      Y = com.ideashower.readitlater.activity.b.e.a(6);
      return localbl;
    }
    Y = com.ideashower.readitlater.activity.b.e.a(paramInt);
    return localbl;
  }
  
  private void a(int paramInt, String paramString)
  {
    String str = f(paramInt);
    com.pocket.stats.f.a(this.af, str, paramString, "2");
    if ((str.equals("browsers")) && (org.apache.a.c.k.a(paramString, "open"))) {
      v.f();
    }
  }
  
  public static void a(android.support.v4.app.f paramf, String paramString1, int paramInt, String paramString2)
  {
    if (Y() == l.a)
    {
      com.pocket.p.k.a(a(paramString1, paramInt, paramString2), paramf);
      return;
    }
    WalkthroughActivity.a(paramf, paramString1, paramInt, paramString2);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramString.equals("showExternalAndroidBrowserPage"))
    {
      a(paramInt, "find_apps");
      g.a(m(), "http://readitlaterlist.com/abm");
    }
    do
    {
      return;
      if (paramString.equals("emailBrowserInstructions"))
      {
        a(paramInt, "tapped_btn");
        v.i();
        com.pocket.c.e.a("pocket_help", "browser-setup-gs");
        return;
      }
    } while (!paramString.equals("closeAllPages"));
    P();
  }
  
  private View e(final int paramInt)
  {
    Object localObject1 = LayoutInflater.from(m());
    int i;
    ViewGroup localViewGroup;
    GSFImageView localGSFImageView;
    TextView localTextView1;
    RilButton localRilButton;
    label134:
    String str;
    label145:
    final Object localObject2;
    if (j.c())
    {
      i = 2130903193;
      localViewGroup = (ViewGroup)((LayoutInflater)localObject1).inflate(i, null, false);
      TextView localTextView2 = (TextView)localViewGroup.findViewById(2131230768);
      localGSFImageView = (GSFImageView)localViewGroup.findViewById(2131230925);
      this.ai.add(localGSFImageView);
      localTextView1 = (TextView)localViewGroup.findViewById(2131230793);
      localRilButton = (RilButton)localViewGroup.findViewById(2131230774);
      i.a(i.a, localTextView2);
      i.a(i.a, localRilButton);
      i.a(i.h, localTextView1);
      localRilButton.setIsBrightStyle(true);
      localRilButton.setTextSize(1, 19.0F);
      if (!j.c()) {
        break label364;
      }
      localObject1 = "tablet";
      if (!com.ideashower.readitlater.util.a.e()) {
        break label371;
      }
      str = "honeycomb";
      localObject2 = (c[])Y.a().get(paramInt);
      if ((!j.c()) || (localObject2.length <= 1)) {
        break label379;
      }
      localObject2 = localObject2[1];
      label179:
      localTextView2.setText(((c)localObject2).b());
      str = ((c)localObject2).f().replace("%formfactor%", (CharSequence)localObject1).replace("%honeycomb%", str);
      if (str.startsWith("http")) {
        break label388;
      }
      localGSFImageView.setImageResource(n().getIdentifier(str, "drawable", m().getPackageName()));
    }
    for (;;)
    {
      str = ((c)localObject2).c();
      localObject1 = str;
      if (str == null)
      {
        str = com.ideashower.readitlater.a.a.a(((c)localObject2).h(), true, false);
        if (str != null)
        {
          localObject1 = str;
          if (!str.equals("control")) {}
        }
        else
        {
          localObject1 = ((c)localObject2).i();
        }
      }
      localTextView1.setText((CharSequence)localObject1);
      localObject1 = ((c)localObject2).d();
      localObject2 = ((c)localObject2).e();
      if ((localObject1 == null) || (org.apache.a.c.k.a((CharSequence)localObject1))) {
        break label450;
      }
      localObject2 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          bl.a(bl.this, localObject2, paramInt);
        }
      };
      localRilButton.setText((CharSequence)localObject1);
      localRilButton.setOnClickListener((View.OnClickListener)localObject2);
      return localViewGroup;
      i = 2130903192;
      break;
      label364:
      localObject1 = "phone";
      break label134;
      label371:
      str = "prehoneycomb";
      break label145;
      label379:
      localObject2 = localObject2[0];
      break label179;
      label388:
      localObject1 = str;
      if (com.ideashower.readitlater.util.a.d())
      {
        localObject1 = str;
        if (((c)localObject2).g()) {
          localObject1 = str.substring(0, str.length() - 3) + "png";
        }
      }
      localGSFImageView.setImageUrl((String)localObject1);
    }
    label450:
    localRilButton.setVisibility(8);
    return localViewGroup;
  }
  
  private String f(int paramInt)
  {
    Object localObject = (c[])Y.a().get(paramInt);
    if ((j.c()) && (localObject.length > 1)) {}
    for (localObject = localObject[1];; localObject = localObject[0]) {
      return ((c)localObject).a();
    }
  }
  
  public String K()
  {
    return "walkthrough" + org.apache.a.c.k.c(this.af);
  }
  
  public int U()
  {
    return 3;
  }
  
  public boolean W()
  {
    if (Z()) {
      return true;
    }
    return super.W();
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903067, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    paramBundle = l();
    this.ag = paramBundle.getInt("config_id");
    this.af = paramBundle.getString("section");
    this.ah = paramBundle.getString("single_page");
    this.Z = ((ToolbarLayout)c(2131230729));
    this.aa = ((StyledToolbar)this.Z.getBottomToolbar());
    this.ab = ((StyledToolbar)this.Z.getTopToolbar());
    this.aa.a(StyledToolbar.g, false);
    this.ae = ((ViewPager)c(2131230730));
    if ((this.ah == null) && (Y.a().size() > 1))
    {
      this.Z.removeView(this.ab);
      this.ae.setOffscreenPageLimit(5);
      this.ae.setAdapter(new aa()
      {
        public int a()
        {
          return bl.Y.a().size();
        }
        
        public Object a(View paramAnonymousView, int paramAnonymousInt)
        {
          View localView = bl.a(bl.this, paramAnonymousInt);
          ((ViewPager)paramAnonymousView).addView(localView);
          return localView;
        }
        
        public void a(Parcelable paramAnonymousParcelable, ClassLoader paramAnonymousClassLoader) {}
        
        public void a(View paramAnonymousView) {}
        
        public void a(View paramAnonymousView, int paramAnonymousInt, Object paramAnonymousObject)
        {
          ((ViewPager)paramAnonymousView).removeView((View)paramAnonymousObject);
        }
        
        public boolean a(View paramAnonymousView, Object paramAnonymousObject)
        {
          return paramAnonymousView == (View)paramAnonymousObject;
        }
        
        public Parcelable b()
        {
          return null;
        }
        
        public void b(View paramAnonymousView) {}
      });
      this.ae.setOnPageChangeListener(new bn()
      {
        public void a(int paramAnonymousInt)
        {
          int j = 8;
          bl.a(bl.this, paramAnonymousInt, "open");
          RilButton localRilButton = bl.this.ad;
          if (paramAnonymousInt <= 0)
          {
            i = 8;
            localRilButton.setVisibility(i);
            localRilButton = bl.this.ac;
            if (paramAnonymousInt < bl.this.ae.getAdapter().a() - 1) {
              break label141;
            }
          }
          label141:
          for (int i = j;; i = 0)
          {
            localRilButton.setVisibility(i);
            if ((!bl.Y.b()) || (paramAnonymousInt != bl.this.ae.getAdapter().a() - 1)) {
              break label146;
            }
            bl.this.ac.setStyle(RilButton.c);
            bl.this.ac.setText(2131492960);
            bl.this.ac.setVisibility(0);
            return;
            i = 0;
            break;
          }
          label146:
          bl.this.ac.setStyle(RilButton.b);
          bl.this.ac.setText(2131492918);
        }
        
        public void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public void b(int paramAnonymousInt) {}
      });
      this.ad = ((RilButton)c(2131230752));
      this.ad.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          bl.a(bl.this);
        }
      });
      this.ad.setVisibility(8);
      this.ac = ((RilButton)c(2131230753));
      this.ac.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((bl.this.ae.getCurrentItem() + 1 == bl.this.ae.getAdapter().a()) && (bl.Y.b()))
          {
            bl.this.P();
            return;
          }
          bl.this.ae.setCurrentItem(bl.this.ae.getCurrentItem() + 1);
        }
      });
    }
    for (;;)
    {
      a(0, "open");
      return;
      this.Z.removeView(this.ae);
      this.ae = null;
      this.Z.a(this.aa, false, false);
      this.ab.setIsRainbowified(true);
      this.ab.a(true, this);
      paramBundle = e(0);
      paramBundle.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      this.Z.setContent(paramBundle);
    }
  }
  
  public void y()
  {
    super.y();
    Iterator localIterator = this.ai.iterator();
    while (localIterator.hasNext()) {
      ((GSFImageView)localIterator.next()).a();
    }
    this.ai.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */