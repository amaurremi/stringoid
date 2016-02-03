package com.go.weatherex.sidebar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.go.weatherex.d.f;
import java.util.ArrayList;
import java.util.Iterator;

public class SidebarGoAdView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context a;
  private com.go.weatherex.framework.fragment.a b;
  private View c;
  private View d;
  private View e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private boolean l = false;
  private SharedPreferences m;
  private TextView n;
  
  SidebarGoAdView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public SidebarGoAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SidebarGoAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private com.go.weatherex.d.a a(ArrayList paramArrayList, int paramInt, String paramString)
  {
    int i2 = 0;
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    int i1;
    if (paramInt < paramArrayList.size() - 1)
    {
      paramInt += 1;
      i1 = paramInt;
    }
    for (;;)
    {
      if (a((com.go.weatherex.d.a)paramArrayList.get(i1)))
      {
        ((com.go.weatherex.d.a)paramArrayList.get(i1)).a(true);
        paramInt = i1;
      }
      do
      {
        SharedPreferences.Editor localEditor = this.m.edit();
        i1 = i2;
        if (((com.go.weatherex.d.a)paramArrayList.get(paramInt)).b()) {
          i1 = paramInt;
        }
        localEditor.putInt(paramString, i1);
        localEditor.commit();
        return (com.go.weatherex.d.a)paramArrayList.get(paramInt);
        paramInt = 0;
        break;
        ((com.go.weatherex.d.a)paramArrayList.get(i1)).a(false);
        int i3 = i1 + 1;
        i1 = i3;
        if (i3 == paramArrayList.size()) {
          i1 = 0;
        }
      } while (i1 == paramInt);
    }
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.m = paramContext.getSharedPreferences("go_ad_share_prefs", 0);
    a();
  }
  
  private void a(View paramView, ImageView paramImageView, TextView paramTextView, com.go.weatherex.d.a parama)
  {
    if ((parama == null) || (!parama.b()))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    Bitmap localBitmap = BitmapFactory.decodeFile(parama.c());
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      paramImageView.setVisibility(0);
    }
    for (;;)
    {
      paramTextView.setText(parama.f());
      paramView.setTag(parama);
      this.l = true;
      return;
      paramImageView.setVisibility(8);
    }
  }
  
  private boolean a(com.go.weatherex.d.a parama)
  {
    return !d.b(this.a, parama.g());
  }
  
  private void d()
  {
    if (this.n != null) {
      this.b.a(this.n, 4, true);
    }
  }
  
  public void a()
  {
    if (f.c(this.a)) {}
    for (int i1 = 8;; i1 = 0)
    {
      setVisibility(i1);
      return;
    }
  }
  
  public void a(com.go.weatherex.framework.fragment.a parama)
  {
    this.b = parama;
    d();
  }
  
  public void b()
  {
    this.n.setText(getResources().getString(2131165989));
  }
  
  public void c()
  {
    this.l = false;
    if (f.c(this.a)) {}
    do
    {
      return;
      Object localObject = f.b(this.a);
      if (((ArrayList)localObject).size() == 0)
      {
        setVisibility(8);
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i1 = this.m.getInt("go_ad_share_slider_a_index", -1);
      int i2 = this.m.getInt("go_ad_share_slider_b_index", -1);
      int i3 = this.m.getInt("go_ad_share_slider_c_index", -1);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.go.weatherex.d.a locala = (com.go.weatherex.d.a)((Iterator)localObject).next();
        if (locala.h().equals("A")) {
          localArrayList1.add(locala);
        } else if (locala.h().equals("B")) {
          localArrayList2.add(locala);
        } else if (locala.h().equals("C")) {
          localArrayList3.add(locala);
        }
      }
      a(this.c, this.f, this.i, a(localArrayList1, i1, "go_ad_share_slider_a_index"));
      a(this.d, this.g, this.j, a(localArrayList2, i2, "go_ad_share_slider_b_index"));
      a(this.e, this.h, this.k, a(localArrayList3, i3, "go_ad_share_slider_c_index"));
    } while (this.l);
    setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.equals(this.c)) || (paramView.equals(this.d)) || (paramView.equals(this.e)))
    {
      paramView = (com.go.weatherex.d.a)paramView.getTag();
      if (paramView != null) {
        f.a(this.a, paramView);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = findViewById(2131231522);
    this.d = findViewById(2131231525);
    this.e = findViewById(2131231528);
    this.f = ((ImageView)findViewById(2131231523));
    this.g = ((ImageView)findViewById(2131231526));
    this.h = ((ImageView)findViewById(2131231529));
    this.i = ((TextView)findViewById(2131231524));
    this.j = ((TextView)findViewById(2131231527));
    this.k = ((TextView)findViewById(2131231530));
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.n = ((TextView)findViewById(2131231521));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/sidebar/SidebarGoAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */