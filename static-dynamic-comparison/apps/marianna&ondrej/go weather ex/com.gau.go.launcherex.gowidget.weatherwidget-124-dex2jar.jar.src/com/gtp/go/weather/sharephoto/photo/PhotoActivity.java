package com.gtp.go.weather.sharephoto.photo;

import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.view.pullrefresh.LineRefreshView;
import com.getjar.sdk.Account;
import com.getjar.sdk.GetjarClient;
import com.google.analytics.tracking.android.EasyTracker;
import com.gtp.go.weather.sharephoto.PhotoDetailActivity;
import com.gtp.go.weather.sharephoto.UserPhotosActivity;
import com.gtp.go.weather.sharephoto.a.e;
import com.gtp.go.weather.sharephoto.takephoto.m;
import com.jiubang.pla.listview.MultiColumnListView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PhotoActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, com.gau.go.launcherex.gowidget.weather.view.pullrefresh.a, e, ah, com.jiubang.core.c.a.c, com.jiubang.pla.a.c, com.jiubang.pla.listview.d
{
  private String A = "";
  private boolean B = false;
  private boolean C = false;
  private int D = 1;
  private boolean E = false;
  private boolean F = false;
  private com.gtp.go.weather.sharephoto.takephoto.aa G;
  private com.gtp.go.weather.sharephoto.award.r H;
  private com.gtp.go.weather.sharephoto.award.k I;
  private View J;
  private View K;
  private View L;
  private View M;
  private an N;
  private LineRefreshView O;
  private View P;
  private TextView Q;
  private PhotoTouchRefresh R;
  private boolean S = true;
  private View T;
  private TextView U;
  private View V;
  private com.gtp.go.weather.sharephoto.a.a W = null;
  private com.gau.go.launcherex.gowidget.weather.globalview.b X = null;
  private com.gtp.go.weather.sharephoto.b.k Y = null;
  private int Z = -1;
  protected com.jiubang.pla.a.b a;
  private i aa;
  private ViewStub ab;
  private View ac;
  private com.jiubang.core.c.a.b ad;
  private com.gtp.go.weather.sharephoto.b.g ae;
  private boolean af = false;
  private final com.gtp.go.weather.sharephoto.award.o ag = new l(this);
  private MultiColumnListView b = null;
  private ad c;
  private ArrayList d = new ArrayList();
  private ArrayList e = new ArrayList();
  private z f;
  private b g;
  private int h;
  private com.gtp.go.weather.sharephoto.c.d i;
  private ViewGroup j;
  private ImageView k;
  private TextView l;
  private View m;
  private ImageView n;
  private Button o;
  private ImageView p;
  private View q;
  private TextView r;
  private View s;
  private ImageView t;
  private Dialog u;
  private ListView v;
  private aa w;
  private ArrayList x = new ArrayList();
  private LayoutInflater y;
  private int z = 1;
  
  private void a(long paramLong)
  {
    if (this.P.getVisibility() == 0)
    {
      this.P.clearAnimation();
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setStartOffset(paramLong);
      localAlphaAnimation.setDuration(300L);
      localAlphaAnimation.setAnimationListener(new p(this));
      this.P.startAnimation(localAlphaAnimation);
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(this, PhotoDetailActivity.class);
    localIntent.putExtra("extra_photo_id", paramLong);
    localIntent.putExtra("extra_photo_isuploaded", true);
    localIntent.putExtra("extra_enter_type", paramInt);
    startActivity(localIntent);
  }
  
  private void a(com.gtp.go.weather.sharephoto.b.g paramg)
  {
    com.gtp.a.a.b.c.a("new_download", "==========》开始重新下载图片");
    paramg = new com.jiubang.core.c.a.a(paramg.x(), ad.a, com.jiubang.core.c.a.b.a(paramg.x()) + ".png");
    this.ad.a(paramg);
  }
  
  private void a(com.gtp.go.weather.sharephoto.b.g paramg, Bitmap paramBitmap)
  {
    if (paramg == null) {}
    View localView2;
    do
    {
      View localView1;
      do
      {
        String str1;
        String str2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                com.gtp.a.a.b.c.a("photo_list", "updateListViewItem = " + paramg.a() + " | " + paramg.m());
                str1 = c(paramg);
                localView1 = this.b.findViewWithTag(str1);
              } while (localView1 == null);
              str2 = d(paramg);
              localView2 = this.b.findViewWithTag(str2);
              if (paramBitmap == null) {
                break;
              }
              com.gtp.a.a.b.c.a("new_download", "bitmap != null");
              paramg = new BitmapDrawable(paramBitmap);
            } while (paramg == null);
            localView1.setBackgroundDrawable(paramg);
            localView1.setVisibility(0);
          } while (localView2 == null);
          localView2.setVisibility(4);
          return;
          com.gtp.a.a.b.c.a("new_download", "bitmap == null");
          paramg = paramg.y();
        } while (TextUtils.isEmpty(paramg));
        paramg = this.g.a(getApplicationContext(), paramg, str1, str2, new o(this));
        if (paramg == null) {
          break;
        }
        localView1.setBackgroundDrawable(paramg);
        localView1.setVisibility(0);
      } while (localView2 == null);
      localView2.setVisibility(4);
      return;
      localView1.setBackgroundResource(2130838889);
      localView1.setVisibility(4);
    } while (localView2 == null);
    localView2.setVisibility(0);
  }
  
  private void b(long paramLong)
  {
    if (this.Q.getVisibility() == 0)
    {
      this.Q.clearAnimation();
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setStartOffset(paramLong);
      localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
      localAnimationSet.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F));
      localAnimationSet.setAnimationListener(new q(this));
      localAnimationSet.setDuration(300L);
      this.Q.startAnimation(localAnimationSet);
    }
  }
  
  private void b(com.gtp.go.weather.sharephoto.b.g paramg)
  {
    a(paramg, null);
  }
  
  private void b(boolean paramBoolean)
  {
    if (!com.gau.go.launcherex.gowidget.statistics.y.h(getApplicationContext())) {
      this.W.a(paramBoolean);
    }
    GetjarClient localGetjarClient;
    Object localObject1;
    do
    {
      return;
      localGetjarClient = com.gau.go.launcherex.gowidget.a.g.a(this).c();
      localObject1 = localGetjarClient.getCurrentAccount();
      if (localObject1 != null) {}
      for (localObject1 = ((Account)localObject1).getName();; localObject1 = "")
      {
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = com.gtp.go.weather.sharephoto.d.n.b(getApplicationContext());
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        this.W.a(paramBoolean, (String)localObject2);
        return;
      }
    } while (!paramBoolean);
    if ((localGetjarClient.getAvailableAccounts() == null) || (localGetjarClient.getAvailableAccounts().size() <= 0))
    {
      localObject1 = new com.gau.go.launcherex.gowidget.weather.globalview.b(this);
      ((com.gau.go.launcherex.gowidget.weather.globalview.b)localObject1).c(2131166353);
      ((com.gau.go.launcherex.gowidget.weather.globalview.b)localObject1).b(2131166348);
      ((com.gau.go.launcherex.gowidget.weather.globalview.b)localObject1).d(2131165344);
      ((com.gau.go.launcherex.gowidget.weather.globalview.b)localObject1).a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.b)localObject1).a(new r(this));
      ((com.gau.go.launcherex.gowidget.weather.globalview.b)localObject1).b();
      return;
    }
    Toast.makeText(getApplicationContext(), getString(2131166352), 0).show();
  }
  
  private String c(com.gtp.go.weather.sharephoto.b.g paramg)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramg.g()).append("*").append(String.valueOf(paramg.a()));
    return localStringBuffer.toString();
  }
  
  private void c(boolean paramBoolean)
  {
    this.K.setVisibility(0);
    if (paramBoolean)
    {
      this.L.setVisibility(0);
      this.M.setVisibility(8);
      return;
    }
    this.L.setVisibility(8);
    this.M.setVisibility(0);
  }
  
  private String d(com.gtp.go.weather.sharephoto.b.g paramg)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf(paramg.a())).append("*").append(paramg.g());
    return localStringBuffer.toString();
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.s.setVisibility(8);
      this.q.setVisibility(0);
      switch (this.z)
      {
      default: 
        return;
      case 1: 
        this.r.setText(getString(2131166346));
        this.o.setVisibility(8);
        return;
      }
      this.r.setText(getString(2131166345));
      this.o.setVisibility(0);
      return;
    }
    this.s.setVisibility(0);
    this.q.setVisibility(8);
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i();
      this.b.setVisibility(4);
      this.J.setVisibility(0);
      return;
    }
    this.b.setVisibility(0);
    this.J.setVisibility(8);
  }
  
  private void h()
  {
    if ((com.gau.go.launcherex.gowidget.statistics.y.a()) || (com.gau.go.launcherex.gowidget.statistics.y.h(getApplicationContext())))
    {
      if (this.X == null)
      {
        this.X = new com.gau.go.launcherex.gowidget.weather.globalview.b(this);
        this.X.b(2131166348);
        this.X.c(2131166349);
        this.X.d(2131165344);
        this.X.a(new s(this));
      }
      this.X.b();
      return;
    }
    Toast.makeText(getApplicationContext(), getString(2131166354), 0).show();
  }
  
  private void i()
  {
    this.s.setVisibility(8);
    this.q.setVisibility(8);
  }
  
  private void j()
  {
    c(2130968580);
  }
  
  private void k()
  {
    this.P.clearAnimation();
    this.P.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(300L);
    this.P.startAnimation(localAlphaAnimation);
  }
  
  public View a(LayoutInflater paramLayoutInflater, com.gtp.go.weather.sharephoto.b.g paramg)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903266, null);
    com.gtp.a.a.b.c.a("photo_list", "newView");
    return paramLayoutInflater;
  }
  
  public void a()
  {
    com.gtp.a.a.b.c.a("pull_photo", "1-> onStartPull");
    this.O.setVisibility(0);
    this.O.a(0.0F);
    this.Q.setText(getString(2131165965));
    this.Q.setVisibility(0);
    this.Q.scrollTo(0, this.Q.getHeight());
    k();
  }
  
  public void a(float paramFloat)
  {
    com.gtp.a.a.b.c.a("pull_photo", "2-> onReleasePull.pullPercentage = " + paramFloat);
    this.O.a();
    if (!this.N.b())
    {
      b(0L);
      a(0L);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList)
  {
    Object localObject;
    com.gtp.go.weather.sharephoto.b.g localg;
    if ((paramInt1 == this.z) && (this.A.equals(paramString)))
    {
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        break label409;
      }
      this.e.remove(this.ae);
      paramString = new ArrayList();
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localg = (com.gtp.go.weather.sharephoto.b.g)((Iterator)localObject).next();
        if (localg.g() == 2) {
          paramString.add(localg);
        }
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (com.gtp.go.weather.sharephoto.b.g)paramString.next();
        this.e.remove(localObject);
      }
      paramString = paramArrayList.iterator();
    }
    label409:
    label443:
    for (;;)
    {
      if (paramString.hasNext())
      {
        paramArrayList = (com.gtp.go.weather.sharephoto.b.g)paramString.next();
        if (paramArrayList != null)
        {
          localObject = this.e.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localg = (com.gtp.go.weather.sharephoto.b.g)((Iterator)localObject).next();
              if (localg.a() == paramArrayList.a()) {
                if ((localg.c() != paramArrayList.c()) || (localg.d() != paramArrayList.d()))
                {
                  localg.a(paramArrayList.c());
                  localg.b(paramArrayList.d());
                  paramInt1 = 1;
                }
              }
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (paramInt1 != 0) {
            break label443;
          }
          this.e.add(paramArrayList);
          break;
          paramString = this.d.iterator();
          while (paramString.hasNext())
          {
            paramArrayList = (com.gtp.go.weather.sharephoto.b.g)paramString.next();
            this.e.add(paramArrayList);
          }
          com.gtp.go.weather.sharephoto.d.n.a(this.e);
          if ((this.z == 1) && (this.af)) {
            this.e.add(0, this.ae);
          }
          this.a.notifyDataSetChanged();
          for (;;)
          {
            this.K.setVisibility(4);
            this.C = false;
            if (this.E)
            {
              new Handler().post(new v(this));
              this.E = false;
            }
            return;
            if (paramArrayList == null) {
              Toast.makeText(getApplicationContext(), getString(2131165748), 0).show();
            }
          }
          paramInt1 = 1;
          continue;
          paramInt1 = 0;
        }
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList, boolean paramBoolean)
  {
    e(false);
    this.Z = -1;
    if ((paramInt1 == this.z) && (this.A.equals(paramString)))
    {
      paramInt1 = 0;
      if (paramBoolean)
      {
        this.d.clear();
        this.e.clear();
        paramInt1 = 1;
      }
      if (paramArrayList == null) {
        break label654;
      }
      if (!paramArrayList.isEmpty()) {
        break label117;
      }
      this.d.clear();
      this.e.clear();
      d(true);
      paramInt1 = 1;
      if (paramInt1 != 0) {
        this.a.notifyDataSetChanged();
      }
    }
    if (this.F)
    {
      this.N.c();
      this.F = false;
    }
    return;
    label117:
    i();
    this.D = paramInt2;
    Object localObject;
    com.gtp.go.weather.sharephoto.b.g localg;
    if (!this.e.isEmpty())
    {
      this.e.remove(this.ae);
      paramString = new ArrayList();
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localg = (com.gtp.go.weather.sharephoto.b.g)((Iterator)localObject).next();
        if (localg.g() == 2) {
          paramString.add(localg);
        }
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (com.gtp.go.weather.sharephoto.b.g)paramString.next();
        this.e.remove(localObject);
      }
    }
    this.d.clear();
    paramString = paramArrayList.iterator();
    label257:
    while (paramString.hasNext())
    {
      paramArrayList = (com.gtp.go.weather.sharephoto.b.g)paramString.next();
      if (paramArrayList != null) {
        switch (paramArrayList.g())
        {
        default: 
          break;
        case 1: 
          paramInt2 = 0;
          localObject = this.e.iterator();
          do
          {
            paramInt1 = paramInt2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localg = (com.gtp.go.weather.sharephoto.b.g)((Iterator)localObject).next();
          } while (localg.a() != paramArrayList.a());
          paramInt1 = 1;
          if ((localg.c() == paramArrayList.c()) && (localg.d() == paramArrayList.d())) {
            break label693;
          }
          localg.a(paramArrayList.c());
          localg.b(paramArrayList.d());
          paramInt1 = 1;
        }
      }
    }
    label654:
    label693:
    for (;;)
    {
      if (paramInt1 != 0) {
        break label257;
      }
      this.e.add(0, paramArrayList);
      break label257;
      this.d.add(paramArrayList);
      break label257;
      paramString = this.d.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (com.gtp.go.weather.sharephoto.b.g)paramString.next();
        this.e.add(paramArrayList);
      }
      com.gtp.go.weather.sharephoto.d.n.a(this.e);
      if ((this.z == 1) && (this.af)) {
        this.e.add(0, this.ae);
      }
      paramInt2 = 1;
      if (this.D > 1)
      {
        paramInt1 = paramInt2;
        if (this.ac == null) {
          break;
        }
        this.ac.setVisibility(8);
        paramInt1 = paramInt2;
        break;
      }
      paramInt1 = paramInt2;
      if (this.D != 1) {
        break;
      }
      paramInt1 = paramInt2;
      if (this.e.isEmpty()) {
        break;
      }
      if (this.e.size() > 2)
      {
        c(false);
        paramInt1 = paramInt2;
        if (this.ac == null) {
          break;
        }
        this.ac.setVisibility(8);
        paramInt1 = paramInt2;
        break;
      }
      this.K.setVisibility(4);
      if (this.ab != null)
      {
        this.ac = this.ab.inflate();
        this.ab = null;
      }
      this.ac.setVisibility(0);
      paramInt1 = paramInt2;
      break;
      if (this.e.isEmpty())
      {
        d(true);
        break;
      }
      Toast.makeText(getApplicationContext(), getString(2131165748), 0).show();
      break;
    }
  }
  
  public void a(int paramInt, String paramString, ArrayList paramArrayList)
  {
    if ((paramInt == this.z) && (this.A.equals(paramString)))
    {
      if ((paramArrayList != null) && ((!paramArrayList.isEmpty()) || (!this.e.isEmpty())))
      {
        this.e.clear();
        paramString = paramArrayList.iterator();
        int i1;
        for (paramInt = 1; paramString.hasNext(); paramInt = i1)
        {
          com.gtp.go.weather.sharephoto.b.g localg = (com.gtp.go.weather.sharephoto.b.g)paramString.next();
          i1 = paramInt;
          if (localg != null)
          {
            i1 = paramInt;
            if (localg.f() > paramInt) {
              i1 = localg.f();
            }
          }
          this.e.add(localg);
        }
        com.gtp.go.weather.sharephoto.d.n.a(this.e);
        if ((this.z == 1) && (this.af)) {
          this.e.add(0, this.ae);
        }
        this.D = paramInt;
        this.a.notifyDataSetChanged();
      }
      boolean bool = com.gtp.a.a.c.d.b(getApplicationContext());
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        break label266;
      }
      this.S = true;
      if (!bool)
      {
        d(false);
        e(false);
      }
      if ((!bool) || (!this.S)) {
        break label278;
      }
      this.F = true;
      this.N.a(true);
      this.O.setVisibility(0);
      this.O.a(true);
      this.c.a(0, this.z, this.A, this.e);
    }
    label266:
    label278:
    while (!this.F)
    {
      return;
      i();
      e(false);
      break;
    }
    this.N.c();
    this.F = false;
  }
  
  public void a(View paramView, int paramInt, com.gtp.go.weather.sharephoto.b.g paramg)
  {
    Object localObject4;
    View localView1;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    View localView2;
    TextView localTextView3;
    int i1;
    int i2;
    if (paramg != null)
    {
      localObject4 = paramView.findViewById(2131231871);
      localView1 = paramView.findViewById(2131231874);
      localImageView = (ImageView)paramView.findViewById(2131231873);
      localObject1 = paramView.findViewById(2131231876);
      localObject2 = (TextView)paramView.findViewById(2131231875);
      localTextView1 = (TextView)paramView.findViewById(2131231877);
      localTextView2 = (TextView)paramView.findViewById(2131231878);
      localView2 = paramView.findViewById(2131231879);
      localTextView3 = (TextView)paramView.findViewById(2131231880);
      localObject3 = paramView.findViewById(2131231872);
      ((View)localObject4).setOnClickListener(new w(this, paramg));
      paramView = paramg.m();
      localTextView3.setText(paramView);
      localObject4 = (LinearLayout.LayoutParams)localView1.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).width = this.h;
      i1 = this.h;
      i2 = paramg.B();
      if (paramg.A() == 0) {
        break label317;
      }
    }
    label317:
    for (paramInt = paramg.A();; paramInt = 1)
    {
      ((LinearLayout.LayoutParams)localObject4).height = (i2 * i1 / paramInt);
      if ((this.z != 1) || (!this.af) || (paramg.a() != -10000L)) {
        break label330;
      }
      ((View)localObject3).setVisibility(0);
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((View)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localView1.setBackgroundResource(2130838889);
      localView1.setVisibility(4);
      localImageView.setVisibility(0);
      localTextView3.setTextColor(e().getColor(2131361814));
      localTextView3.setCompoundDrawablesWithIntrinsicBounds(2130838391, 0, 0, 0);
      localImageView.setImageResource(2130838390);
      localView2.setVisibility(8);
      if (TextUtils.isEmpty(paramView)) {
        break;
      }
      localTextView3.setVisibility(0);
      return;
    }
    localTextView3.setVisibility(8);
    return;
    label330:
    ((View)localObject3).setVisibility(8);
    ((View)localObject1).setVisibility(0);
    localTextView3.setTextColor(e().getColor(2131361813));
    localTextView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    localImageView.setImageResource(2130838394);
    ((TextView)localObject2).setVisibility(0);
    ((TextView)localObject2).setText(paramg.l());
    localView1.setLayoutParams((ViewGroup.LayoutParams)localObject4);
    Object localObject1 = c(paramg);
    localView1.setTag(localObject1);
    Object localObject2 = d(paramg);
    localImageView.setTag(localObject2);
    Object localObject3 = paramg.y();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = this.g.a(getApplicationContext(), (String)localObject3, (String)localObject1, (String)localObject2, new x(this, paramg));
      if (localObject1 != null)
      {
        localView1.setBackgroundDrawable((Drawable)localObject1);
        localView1.setVisibility(0);
        localImageView.setVisibility(4);
        localTextView1.setText(String.valueOf(paramg.d()));
        localTextView1.setOnClickListener(new y(this, paramg));
        localTextView2.setText(String.valueOf(paramg.c()));
        localTextView2.setOnClickListener(new n(this, paramg));
        if (!paramg.h()) {
          break label632;
        }
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(2130838407, 0, 0, 0);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramView)) {
        break label646;
      }
      localTextView3.setVisibility(0);
      localView2.setVisibility(0);
      return;
      localView1.setBackgroundResource(2130838889);
      localView1.setVisibility(4);
      localImageView.setVisibility(0);
      break;
      localView1.setBackgroundResource(2130838889);
      localView1.setVisibility(4);
      localImageView.setVisibility(0);
      a(paramg);
      break;
      label632:
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(2130838406, 0, 0, 0);
    }
    label646:
    localTextView3.setVisibility(8);
    localView2.setVisibility(8);
  }
  
  public void a(com.jiubang.core.c.a.a parama) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Toast.makeText(getApplicationContext(), getString(2131166351), 0).show();
      return;
    }
    Toast.makeText(getApplicationContext(), getString(2131166352), 0).show();
  }
  
  public void b()
  {
    com.gtp.a.a.b.c.a("pull_photo", "4-> onRefresh");
    this.O.a(true);
    this.Q.scrollTo(0, 0);
    b(1800L);
    a(1800L);
    this.Q.setText(2131166342);
    if (com.gau.go.launcherex.gowidget.weather.util.r.c(getApplicationContext()))
    {
      this.F = true;
      this.B = false;
      this.c.a(0, this.z, this.A, this.e);
      return;
    }
    this.N.c();
    Toast.makeText(getApplicationContext(), getString(2131165748), 0).show();
  }
  
  public void b(float paramFloat)
  {
    com.gtp.a.a.b.c.a("pull_photo", "3-> onPulling.pullPercentag = " + paramFloat);
    this.O.a(paramFloat);
    float f1 = 2.0F * paramFloat + (1.0F - paramFloat) * paramFloat + 0.6F;
    paramFloat = f1;
    if (f1 > 1.0F) {
      paramFloat = 1.0F;
    }
    this.Q.scrollTo(0, (int)((1.0F - paramFloat) * this.Q.getHeight()));
  }
  
  public void b(com.jiubang.core.c.a.a parama) {}
  
  public void c(com.jiubang.core.c.a.a parama)
  {
    String str;
    if (parama != null)
    {
      str = parama.a;
      if (!TextUtils.isEmpty(str)) {
        break label22;
      }
    }
    label22:
    com.gtp.go.weather.sharephoto.b.g localg;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        str = null;
        break;
        localIterator = this.e.iterator();
      }
      localg = (com.gtp.go.weather.sharephoto.b.g)localIterator.next();
    } while ((localg == null) || (!localg.x().equals(str)));
    localg.m(parama.a());
    if (parama.d != null) {
      this.g.a().put(parama.a(), new SoftReference(new BitmapDrawable((Bitmap)parama.d)));
    }
    b(localg);
  }
  
  public void d(com.jiubang.core.c.a.a parama) {}
  
  protected void f()
  {
    setContentView(2130903256);
    this.b = ((MultiColumnListView)findViewById(2131231800));
    this.b.setClickable(false);
    this.b.setFocusable(false);
    this.g = new b();
    this.i = com.gtp.go.weather.sharephoto.c.d.a(getApplicationContext());
    this.a = new com.jiubang.pla.a.b(getLayoutInflater(), this);
    this.K = getLayoutInflater().inflate(2130903257, null);
    this.L = this.K.findViewById(2131231820);
    this.L.setVisibility(4);
    this.M = this.K.findViewById(2131231821);
    this.M.setVisibility(4);
    this.b.e(this.K);
    this.a.a(this.e);
    this.b.a(this.a);
    this.b.a(this);
    this.ab = ((ViewStub)findViewById(2131231801));
    this.j = ((ViewGroup)findViewById(2131231799));
    this.k = ((ImageView)findViewById(2131231806));
    this.k.setOnClickListener(this);
    this.l = ((TextView)findViewById(2131231807));
    this.l.setOnClickListener(this);
    this.m = findViewById(2131231808);
    this.m.setOnClickListener(this);
    this.n = ((ImageView)findViewById(2131231809));
    this.n.setOnClickListener(this);
    this.o = ((Button)findViewById(2131231804));
    this.o.setOnClickListener(this);
    this.p = ((ImageView)findViewById(2131231811));
    this.p.setOnClickListener(this);
    this.t = ((ImageView)findViewById(2131231812));
    this.q = findViewById(2131230810);
    this.r = ((TextView)findViewById(2131231803));
    this.s = findViewById(2131231805);
    this.J = findViewById(2131231239);
    this.O = ((LineRefreshView)findViewById(2131231819));
    this.P = findViewById(2131231814);
    this.Q = ((TextView)findViewById(2131231815));
    this.O.a(0.0F);
    this.Q.setVisibility(4);
    this.R = ((PhotoTouchRefresh)findViewById(2131231798));
    this.N = new an(this.R);
    this.N.a(this);
    this.T = findViewById(2131231816);
    this.T.setVisibility(8);
    this.U = ((TextView)findViewById(2131231817));
    this.V = findViewById(2131231818);
    this.V.setOnClickListener(this);
    getWindow().setFormat(-3);
    Object localObject1 = e().getDisplayMetrics();
    this.h = (Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels) / 2 - (int)(((DisplayMetrics)localObject1).density * 2.0F));
    localObject1 = f.a(getApplicationContext()).d();
    Object localObject2 = new ab(this, null);
    ((ab)localObject2).a = e().getString(2131166344);
    this.x.add(localObject2);
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeatherBean)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        ab localab = new ab(this, null);
        localab.a = ((WeatherBean)localObject2).d();
        localab.b = ((WeatherBean)localObject2).c();
        this.x.add(localab);
      }
    }
    this.y = LayoutInflater.from(getApplicationContext());
    this.w = new aa(this, null);
    this.v = new ListView(getApplicationContext());
    this.v.setCacheColorHint(0);
    this.v.setBackgroundResource(2130838146);
    this.v.setDivider(e().getDrawable(2130838147));
    this.v.setOnItemClickListener(this);
    this.v.setAlwaysDrawnWithCacheEnabled(true);
    this.v.setScrollBarStyle(33554432);
    this.v.setAdapter(this.w);
    this.u = new Dialog(this, 2131492884);
    this.u.setContentView(this.v);
    this.u.setCanceledOnTouchOutside(true);
    localObject1 = this.u.getWindow();
    ((Window)localObject1).setGravity(51);
    localObject2 = ((Window)localObject1).getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = ((int)(e().getDimension(2131427619) - e().getDisplayMetrics().density * 2.0F));
    ((WindowManager.LayoutParams)localObject2).width = ((int)e().getDimension(2131427706));
    ((WindowManager.LayoutParams)localObject2).height = -2;
    ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    ((Window)localObject1).setWindowAnimations(2131492875);
    this.f = new z(this, null);
    localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_FAVOUR_OR_BACKCOUNT");
    ((IntentFilter)localObject1).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_USER_PHOTO");
    ((IntentFilter)localObject1).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    registerReceiver(this.f, (IntentFilter)localObject1);
    this.W = com.gtp.go.weather.sharephoto.a.g.a(getApplicationContext()).c();
    this.W.a(this);
    this.ad = new com.jiubang.core.c.a.b(getApplicationContext());
    this.ad.a(this);
    this.c = new ad(getApplicationContext());
    this.c.a(this);
    this.c.a(this.ad);
    this.c.a(this.z, this.A);
    e(true);
    this.G = new com.gtp.go.weather.sharephoto.takephoto.aa(this);
    m.a(getApplicationContext());
    m.a();
    if (!com.gtp.go.weather.sharephoto.d.n.a(getApplicationContext())) {
      b(false);
    }
    this.I = new com.gtp.go.weather.sharephoto.award.k(getApplicationContext());
    this.H = new com.gtp.go.weather.sharephoto.award.r(this, this.I);
    this.I.a(this.ag);
    this.I.b(true);
    this.I.a(true);
    this.aa = new i(this, this.t);
    this.aa.b();
    if (!com.gau.go.launcherex.gowidget.statistics.y.a()) {
      Toast.makeText(getApplicationContext(), getString(2131166354), 0).show();
    }
    this.af = com.gtp.go.weather.sharephoto.d.n.c(getApplicationContext());
    this.ae = new com.gtp.go.weather.sharephoto.b.g();
    this.ae.a(-10000L);
    this.ae.j(300);
    this.ae.k(250);
    this.ae.e(getString(2131165859));
  }
  
  public void g()
  {
    int i2 = 1;
    c(true);
    this.E = true;
    int i1;
    if (!this.B) {
      if (!this.C)
      {
        this.C = true;
        if (this.Z == -1) {
          this.Z = this.D;
        }
        if (this.Z > 1) {
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      this.Z -= 1;
      if (this.Z > 0)
      {
        Iterator localIterator = this.e.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (((com.gtp.go.weather.sharephoto.b.g)localIterator.next()).f() != this.Z);
      }
      for (i1 = 1; (i1 == 0) || (this.Z <= 0); i1 = 0)
      {
        if (this.Z > 0) {
          if (com.gau.go.launcherex.gowidget.weather.util.r.c(getApplicationContext()))
          {
            this.c.a(this.Z, this.z, this.A, this.e);
            i1 = 0;
            com.gtp.a.a.b.c.a("PhotoActivity", "请求页数 mRequestPage = " + this.Z);
            label194:
            if ((this.B) || (i1 != 0))
            {
              if ((!this.B) || (this.e.isEmpty())) {
                break label423;
              }
              if (this.e.size() <= 2) {
                break label381;
              }
              c(false);
              if (this.ac != null) {
                this.ac.setVisibility(8);
              }
            }
          }
        }
        for (;;)
        {
          this.C = false;
          com.gtp.a.a.b.c.a("PhotoActivity", "图片类型为" + this.z + "的数据已加载完全: " + this.B);
          new Handler().post(new u(this));
          this.E = false;
          return;
          Toast.makeText(getApplicationContext(), getString(2131165748), 0).show();
          i1 = i2;
          break;
          for (this.B = true;; this.B = true)
          {
            i1 = 0;
            break;
          }
          com.gtp.a.a.b.c.a("PhotoActivity", "正在获取下一页数据");
          i1 = 0;
          break label194;
          label381:
          this.K.setVisibility(4);
          if (this.ab != null)
          {
            this.ac = this.ab.inflate();
            this.ab = null;
          }
          this.ac.setVisibility(0);
          continue;
          label423:
          this.K.setVisibility(4);
        }
      }
    }
  }
  
  public void g_()
  {
    com.gtp.a.a.b.c.a("pull_photo", "5-> onStopRefresh");
    this.O.a(false);
    this.O.setVisibility(4);
    b(0L);
    a(0L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.G.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.k)) {
      j();
    }
    do
    {
      return;
      if ((paramView.equals(this.l)) || (paramView.equals(this.m)))
      {
        if (this.u.isShowing())
        {
          this.u.dismiss();
          return;
        }
        this.u.show();
        return;
      }
      if ((paramView.equals(this.n)) || (paramView.equals(this.o)))
      {
        if (com.gtp.go.weather.sharephoto.d.n.a(getApplicationContext()))
        {
          if (this.T.getVisibility() == 0) {
            this.T.setVisibility(8);
          }
          this.G.a();
          com.gau.go.launcherex.gowidget.statistics.r.a(getApplicationContext()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(117, "click_photo"));
          return;
        }
        h();
        return;
      }
      if (paramView.equals(this.p))
      {
        if (com.gtp.go.weather.sharephoto.d.n.a(getApplicationContext()))
        {
          this.t.setVisibility(4);
          startActivity(new Intent(this, UserPhotosActivity.class));
          com.gau.go.launcherex.gowidget.statistics.r.a(getApplicationContext()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(117, "click_picture_head"));
          return;
        }
        h();
        return;
      }
    } while ((!paramView.equals(this.V)) || (this.T.getVisibility() != 0));
    this.T.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.e.clear();
    this.a.a();
    this.x.clear();
    unregisterReceiver(this.f);
    this.g.b();
    this.H.c();
    this.I.a();
    this.W.b();
    this.aa.a();
    this.ad.a(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.u.dismiss();
    this.S = true;
    int i1;
    if (paramInt == 0)
    {
      paramAdapterView = "";
      i1 = 1;
      if ((i1 != this.z) || (!paramAdapterView.equals(this.A)))
      {
        this.z = i1;
        this.A = paramAdapterView;
        this.a.a();
        this.a.notifyDataSetChanged();
        this.l.setText(((ab)this.x.get(paramInt)).a);
        this.B = false;
        this.C = false;
        this.K.setVisibility(4);
        e(true);
        this.c.a(this.z, this.A);
        if (this.ac != null) {
          this.ac.setVisibility(8);
        }
        this.Z = -1;
        switch (i1)
        {
        }
      }
    }
    for (;;)
    {
      if (this.E)
      {
        new Handler().post(new t(this));
        this.E = false;
      }
      if (this.F)
      {
        this.N.c();
        this.F = false;
      }
      return;
      i1 = 2;
      paramAdapterView = ((ab)this.x.get(paramInt)).b;
      break;
      com.gau.go.launcherex.gowidget.statistics.r.a(getApplicationContext()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(117, "click_picture_well_chosen "));
      continue;
      com.gau.go.launcherex.gowidget.statistics.r.a(getApplicationContext()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(117, "click_picture_city"));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      j();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.H.b();
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance().activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance().activityStop(this);
    this.H.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/PhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */