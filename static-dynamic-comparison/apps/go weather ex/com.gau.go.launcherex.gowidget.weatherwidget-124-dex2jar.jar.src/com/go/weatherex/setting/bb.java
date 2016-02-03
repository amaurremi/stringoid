package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.b;
import com.gau.go.launcherex.gowidget.weather.globalview.i;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.r;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.view.VerticalStretchLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class bb
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String[] al = { "notification_style_default_black", "notification_style_default_white" };
  private CheckBox A;
  private View B;
  private View C;
  private CheckBox D;
  private VerticalStretchLayout E;
  private View F;
  private TextView G;
  private TextView H;
  private TextView I;
  private View J;
  private TextView K;
  private TextView L;
  private TextView M;
  private View N;
  private TextView O;
  private TextView P;
  private TextView Q;
  private View R;
  private View S;
  private CheckBox T;
  private VerticalStretchLayout U;
  private View V;
  private TextView W;
  private TextView X;
  private TextView Y;
  private View Z;
  public int a;
  private TextView aa;
  private TextView ab;
  private TextView ac;
  private View ad;
  private TextView ae;
  private TextView af;
  private TextView ag;
  private int[] ah;
  private String[] ai;
  private int aj;
  private String[] ak;
  private boolean am = true;
  private int an;
  private int ao;
  private int ap;
  private int aq;
  private int ar;
  private BroadcastReceiver as;
  private t at;
  private i au;
  private BroadcastReceiver av;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  public int i;
  public int j;
  public String k;
  private e l;
  private f m;
  private TextView n;
  private View o;
  private View p;
  private CheckBox q;
  private VerticalStretchLayout r;
  private TextView s;
  private TextView t;
  private View u;
  private CheckBox v;
  private View w;
  private CheckBox x;
  private View y;
  private View z;
  
  private int a(int paramInt)
  {
    if ((paramInt < 5) || (paramInt > 14)) {
      return 4;
    }
    return paramInt - 5;
  }
  
  private int a(String paramString)
  {
    if (paramString.equals("notification_style_default")) {}
    while ((paramString.equals("notification_style_default_black")) || (!paramString.equals("notification_style_default_white"))) {
      return 0;
    }
    return 1;
  }
  
  private void a(int paramInt1, int paramInt2, r[] paramArrayOfr)
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfr.length;
    int i1 = 0;
    if (i1 < i3)
    {
      com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      locala.a = paramArrayOfr[i1].b;
      locala.c = paramArrayOfr[i1];
      if (paramInt2 == i1) {}
      for (boolean bool = true;; bool = false)
      {
        locala.b = bool;
        localArrayList.add(locala);
        i1 += 1;
        break;
      }
    }
    paramArrayOfr = u();
    paramArrayOfr.b(paramInt1);
    paramArrayOfr.a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    paramArrayOfr.c(paramInt1);
    paramArrayOfr.a(new bh(this));
    paramArrayOfr.a();
  }
  
  private void a(int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfCharSequence.length;
    int i1 = 0;
    if (i1 < i3)
    {
      localObject = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).a = paramArrayOfCharSequence[i1].toString();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).c = Integer.valueOf(i1);
      if (paramInt2 == i1) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).b = bool;
        localArrayList.add(localObject);
        i1 += 1;
        break;
      }
    }
    Object localObject = u();
    ((t)localObject).b(paramInt1);
    ((t)localObject).a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    ((t)localObject).c(paramInt1);
    ((t)localObject).a(new bi(this, paramArrayOfCharSequence));
    ((t)localObject).a();
  }
  
  private void a(int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence, int[] paramArrayOfInt)
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfInt.length;
    int i1 = 0;
    if (i1 < i3)
    {
      localObject = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).a = paramArrayOfCharSequence[i1].toString();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).c = Integer.valueOf(i1);
      if (paramInt2 == i1) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).b = bool;
        localArrayList.add(localObject);
        i1 += 1;
        break;
      }
    }
    Object localObject = u();
    ((t)localObject).b(paramInt1);
    ((t)localObject).a(localArrayList);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    ((t)localObject).c(paramInt1);
    ((t)localObject).a(new bj(this, paramArrayOfInt, paramArrayOfCharSequence));
    ((t)localObject).a();
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i1 = 4;
    i locali = n();
    locali.a(2131166227);
    locali.a(paramArrayList);
    if (paramArrayList.size() > 4) {}
    for (;;)
    {
      locali.b(i1);
      locali.a(new be(this));
      locali.a();
      return;
      i1 = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.V.setClickable(paramBoolean);
    this.Z.setClickable(paramBoolean);
    if (paramBoolean)
    {
      this.X.setTextColor(this.an);
      this.W.setTextColor(this.an);
      this.Y.setTextColor(this.ao);
      this.X.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.aq, 0);
      this.aa.setTextColor(this.an);
      this.ab.setTextColor(this.an);
      this.ac.setTextColor(this.ao);
      this.aa.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.aq, 0);
      this.ae.setTextColor(this.an);
      this.af.setTextColor(this.an);
      this.ag.setTextColor(this.ao);
      this.ae.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.aq, 0);
      s();
      return;
    }
    this.X.setTextColor(this.ap);
    this.W.setTextColor(this.ap);
    this.Y.setTextColor(this.ap);
    this.X.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ar, 0);
    this.aa.setTextColor(this.ap);
    this.ab.setTextColor(this.ap);
    this.ac.setTextColor(this.ap);
    this.aa.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ar, 0);
    this.ae.setTextColor(this.ap);
    this.af.setTextColor(this.ap);
    this.ag.setTextColor(this.ap);
    this.ae.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ar, 0);
  }
  
  private int b(int paramInt)
  {
    paramInt = com.gau.go.launcherex.gowidget.weather.util.q.a(paramInt);
    if ((paramInt < 3) || (paramInt > 8)) {
      return 2;
    }
    return paramInt - 3;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.s.setTextColor(this.an);
      this.t.setTextColor(this.ao);
      return;
    }
    this.s.setTextColor(this.ap);
    this.t.setTextColor(this.ap);
  }
  
  private void c(boolean paramBoolean)
  {
    this.F.setClickable(paramBoolean);
    this.J.setClickable(paramBoolean);
    this.N.setClickable(paramBoolean);
    if (paramBoolean)
    {
      this.G.setTextColor(this.an);
      this.H.setTextColor(this.an);
      this.I.setTextColor(this.ao);
      this.G.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.aq, 0);
      this.K.setTextColor(this.an);
      this.L.setTextColor(this.an);
      this.M.setTextColor(this.ao);
      this.K.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.aq, 0);
      this.P.setTextColor(this.an);
      this.O.setTextColor(this.an);
      this.Q.setTextColor(this.ao);
      this.P.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.aq, 0);
      return;
    }
    this.G.setTextColor(this.ap);
    this.H.setTextColor(this.ap);
    this.I.setTextColor(this.ap);
    this.G.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ar, 0);
    this.K.setTextColor(this.ap);
    this.L.setTextColor(this.ap);
    this.M.setTextColor(this.ap);
    this.K.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ar, 0);
    this.P.setTextColor(this.ap);
    this.O.setTextColor(this.ap);
    this.Q.setTextColor(this.ap);
    this.P.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ar, 0);
  }
  
  private int d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 10)) {
      return 9;
    }
    return paramInt + 5;
  }
  
  private void d()
  {
    boolean bool2 = true;
    com.gau.go.launcherex.gowidget.weather.model.q localq = this.l.a();
    this.a = localq.D;
    Object localObject;
    label69:
    label120:
    label158:
    label193:
    label224:
    label368:
    label522:
    label538:
    label560:
    label649:
    int i1;
    if (this.v != null)
    {
      localObject = this.v;
      if (this.a == 1)
      {
        bool1 = true;
        ((CheckBox)localObject).setChecked(bool1);
      }
    }
    else
    {
      this.b = localq.s;
      if (this.b != 1) {
        break label782;
      }
      bool1 = true;
      b(bool1);
      this.k = localq.F;
      if (this.k == null) {
        this.k = "";
      }
      if (this.x != null)
      {
        localObject = this.x;
        if (this.b != 1) {
          break label787;
        }
        bool1 = true;
        ((CheckBox)localObject).setChecked(bool1);
      }
      this.c = localq.t;
      if (this.q != null)
      {
        localObject = this.q;
        if (this.c != 1) {
          break label792;
        }
        bool1 = true;
        ((CheckBox)localObject).setChecked(bool1);
        if (!this.q.isChecked()) {}
      }
      this.d = localq.u;
      if (this.d != 1) {
        break label797;
      }
      bool1 = true;
      if (this.D != null) {
        this.D.setChecked(bool1);
      }
      c(bool1);
      if (!bool1) {
        break label802;
      }
      this.E.b();
      this.e = localq.v;
      this.f = localq.w;
      if (localq.g != 2) {
        break label812;
      }
      localObject = new String[10];
      localObject[0] = "5°F";
      localObject[1] = "6°F";
      localObject[2] = "7°F";
      localObject[3] = "8°F";
      localObject[4] = "9°F";
      localObject[5] = "10°F";
      localObject[6] = "11°F";
      localObject[7] = "12°F";
      localObject[8] = "13°F";
      localObject[9] = "14°F";
      this.G.setText(localObject[a(this.e)]);
      this.K.setText(localObject[a(this.f)]);
      this.g = localq.m;
      this.i = localq.o;
      this.j = localq.p;
      this.h = localq.n;
      if (this.h == null) {
        this.h = "";
      }
      if ((this.h.equals("")) || (this.m.a(this.h) == null))
      {
        localObject = this.m.d();
        if (((ArrayList)localObject).size() > 0)
        {
          localObject = (WeatherBean)((ArrayList)localObject).get(0);
          this.h = ((WeatherBean)localObject).c();
          this.i = ((WeatherBean)localObject).e();
          this.l.a(this.h, this.i);
        }
      }
      localObject = this.T;
      if (this.g != 1) {
        break label900;
      }
      bool1 = true;
      ((CheckBox)localObject).setChecked(bool1);
      if (this.g != 1) {
        break label905;
      }
      bool1 = true;
      a(bool1);
      if (!this.T.isChecked()) {
        break label910;
      }
      this.U.b();
      localObject = (WeatherBean)this.m.c().get(this.h);
      if (localObject != null)
      {
        if ((this.i != 2) && ((((WeatherBean)localObject).e() == 1) || (((WeatherBean)localObject).q() != -1))) {
          break label920;
        }
        this.i = 2;
        this.X.setText(String.format(getText(2131166127).toString(), new Object[] { ((WeatherBean)localObject).d() }));
      }
      int i2 = this.ah.length;
      i1 = 0;
      label657:
      if (i1 < i2)
      {
        if (this.j != this.ah[i1]) {
          break label935;
        }
        this.aa.setText(this.ai[this.j]);
      }
      this.ak = new String[] { getString(2131166257), getString(2131166258) };
      this.aj = a(localq.C);
      this.ae.setText(this.ak[this.aj]);
      if (localq.z != 1) {
        break label942;
      }
    }
    label782:
    label787:
    label792:
    label797:
    label802:
    label812:
    label900:
    label905:
    label910:
    label920:
    label935:
    label942:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.am = bool1;
      this.A.setChecked(this.am);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
      bool1 = false;
      break label120;
      bool1 = false;
      break label158;
      bool1 = false;
      break label193;
      this.E.a();
      break label224;
      localObject = new String[6];
      localObject[0] = "3°C";
      localObject[1] = "4°C";
      localObject[2] = "5°C";
      localObject[3] = "6°C";
      localObject[4] = "7°C";
      localObject[5] = "8°C";
      this.G.setText(localObject[b(this.e)]);
      this.K.setText(localObject[b(this.f)]);
      break label368;
      bool1 = false;
      break label522;
      bool1 = false;
      break label538;
      this.U.a();
      break label560;
      this.X.setText(((WeatherBean)localObject).d());
      break label649;
      i1 += 1;
      break label657;
    }
  }
  
  private int e(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      paramInt = 5;
    }
    for (;;)
    {
      return com.gau.go.launcherex.gowidget.weather.util.q.b(paramInt);
      paramInt += 3;
    }
  }
  
  private void j()
  {
    int i3 = 0;
    com.gau.go.launcherex.gowidget.weather.model.q localq = this.l.a();
    String[] arrayOfString;
    ArrayList localArrayList;
    int i4;
    int i2;
    if (localq.g == 2)
    {
      i1 = a(localq.v);
      arrayOfString = new String[10];
      arrayOfString[0] = "5°F";
      arrayOfString[1] = "6°F";
      arrayOfString[2] = "7°F";
      arrayOfString[3] = "8°F";
      arrayOfString[4] = "9°F";
      arrayOfString[5] = "10°F";
      arrayOfString[6] = "11°F";
      arrayOfString[7] = "12°F";
      arrayOfString[8] = "13°F";
      arrayOfString[9] = "14°F";
      localArrayList = new ArrayList();
      i4 = arrayOfString.length;
      i2 = 0;
      label127:
      if (i2 >= i4) {
        break label258;
      }
      localObject = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).a = arrayOfString[i2];
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).c = Integer.valueOf(i2);
      if (i1 != i2) {
        break label252;
      }
    }
    label252:
    for (boolean bool = true;; bool = false)
    {
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).b = bool;
      localArrayList.add(localObject);
      i2 += 1;
      break label127;
      i1 = b(localq.v);
      arrayOfString = new String[6];
      arrayOfString[0] = "3°C";
      arrayOfString[1] = "4°C";
      arrayOfString[2] = "5°C";
      arrayOfString[3] = "6°C";
      arrayOfString[4] = "7°C";
      arrayOfString[5] = "8°C";
      break;
    }
    label258:
    Object localObject = u();
    ((t)localObject).b(2131166216);
    ((t)localObject).a(localArrayList);
    int i1 = i3;
    if (i4 > 4) {
      i1 = 4;
    }
    ((t)localObject).c(i1);
    ((t)localObject).a(new bc(this, localq, arrayOfString));
    ((t)localObject).a();
  }
  
  private void k()
  {
    int i3 = 0;
    com.gau.go.launcherex.gowidget.weather.model.q localq = this.l.a();
    String[] arrayOfString;
    ArrayList localArrayList;
    int i4;
    int i2;
    if (localq.g == 2)
    {
      i1 = a(localq.w);
      arrayOfString = new String[10];
      arrayOfString[0] = "5°F";
      arrayOfString[1] = "6°F";
      arrayOfString[2] = "7°F";
      arrayOfString[3] = "8°F";
      arrayOfString[4] = "9°F";
      arrayOfString[5] = "10°F";
      arrayOfString[6] = "11°F";
      arrayOfString[7] = "12°F";
      arrayOfString[8] = "13°F";
      arrayOfString[9] = "14°F";
      localArrayList = new ArrayList();
      i4 = arrayOfString.length;
      i2 = 0;
      label127:
      if (i2 >= i4) {
        break label258;
      }
      localObject = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).a = arrayOfString[i2];
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).c = Integer.valueOf(i2);
      if (i1 != i2) {
        break label252;
      }
    }
    label252:
    for (boolean bool = true;; bool = false)
    {
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).b = bool;
      localArrayList.add(localObject);
      i2 += 1;
      break label127;
      i1 = b(localq.w);
      arrayOfString = new String[6];
      arrayOfString[0] = "3°C";
      arrayOfString[1] = "4°C";
      arrayOfString[2] = "5°C";
      arrayOfString[3] = "6°C";
      arrayOfString[4] = "7°C";
      arrayOfString[5] = "8°C";
      break;
    }
    label258:
    Object localObject = u();
    ((t)localObject).b(2131166218);
    ((t)localObject).a(localArrayList);
    int i1 = i3;
    if (i4 > 4) {
      i1 = 4;
    }
    ((t)localObject).c(i1);
    ((t)localObject).a(new bd(this, localq, arrayOfString));
    ((t)localObject).a();
  }
  
  private void l()
  {
    Object localObject = this.k;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (!((String)localObject).contains("#")) {}
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i1;
      try
      {
        localObject = ((String)localObject).split("#");
        localArrayList = new ArrayList();
        Iterator localIterator = this.m.d().iterator();
        if (!localIterator.hasNext()) {
          break label203;
        }
        WeatherBean localWeatherBean = (WeatherBean)localIterator.next();
        if (localWeatherBean == null) {
          continue;
        }
        com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
        locala.a = localWeatherBean.d();
        locala.c = localWeatherBean.c();
        locala.b = true;
        if ((localObject != null) && (localObject.length > 0))
        {
          i1 = 0;
          if (i1 < localObject.length)
          {
            if ((TextUtils.isEmpty(localObject[i1])) || (!localWeatherBean.c().equals(localObject[i1]))) {
              break label196;
            }
            locala.b = false;
          }
        }
        localArrayList.add(locala);
        continue;
      }
      catch (Exception localException)
      {
        if (com.gtp.a.a.b.c.a()) {
          localException.printStackTrace();
        }
        arrayOfString = null;
        continue;
      }
      String[] arrayOfString = { arrayOfString };
      continue;
      label196:
      i1 += 1;
      continue;
      label203:
      a(localArrayList);
      return;
      arrayOfString = null;
    }
  }
  
  private void m()
  {
    Object localObject1 = this.l.a().K;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (!((String)localObject1).contains("#")) {}
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i1;
      try
      {
        localObject1 = ((String)localObject1).split("#");
        localArrayList = new ArrayList();
        Iterator localIterator = this.m.d().iterator();
        if (!localIterator.hasNext()) {
          break label195;
        }
        WeatherBean localWeatherBean = (WeatherBean)localIterator.next();
        com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
        locala.a = localWeatherBean.d();
        locala.c = localWeatherBean.c();
        locala.b = true;
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          i1 = 0;
          if (i1 < localObject1.length)
          {
            if (!localWeatherBean.c().equals(localObject1[i1])) {
              break label188;
            }
            locala.b = false;
          }
        }
        localArrayList.add(locala);
        continue;
      }
      catch (Exception localException)
      {
        if (com.gtp.a.a.b.c.a()) {
          localException.printStackTrace();
        }
        localObject2 = null;
        continue;
      }
      Object localObject2 = { localObject2 };
      continue;
      label188:
      i1 += 1;
      continue;
      label195:
      localObject2 = n();
      ((i)localObject2).a(2131166123);
      ((i)localObject2).a(localArrayList);
      ((i)localObject2).b(Math.min(4, localArrayList.size()));
      ((i)localObject2).a(new bf(this));
      ((i)localObject2).a();
      return;
      localObject2 = null;
    }
  }
  
  private i n()
  {
    if (this.au == null) {
      this.au = new i(getActivity());
    }
    return this.au;
  }
  
  private void o()
  {
    Object localObject1 = this.h;
    int i5 = this.i;
    ArrayList localArrayList = this.m.d();
    int i2 = localArrayList.size();
    int i1;
    Object localObject2;
    label64:
    WeatherBean localWeatherBean;
    label136:
    int i3;
    if (i2 != 0)
    {
      i1 = 0;
      if (i1 < localArrayList.size())
      {
        localObject2 = (WeatherBean)localArrayList.get(i1);
        if (((WeatherBean)localObject2).e() != 3) {
          break label356;
        }
        i1 = 0;
        if (i1 < i2)
        {
          localWeatherBean = (WeatherBean)localArrayList.get(i1);
          if (((WeatherBean)localObject2).q() >= localWeatherBean.q()) {
            break label296;
          }
          localWeatherBean = new WeatherBean();
          localWeatherBean.a(1);
          localWeatherBean.c(((WeatherBean)localObject2).c());
          localWeatherBean.e(((WeatherBean)localObject2).d());
          localArrayList.add(i1, localWeatherBean);
        }
      }
      int i6 = localArrayList.size();
      localObject2 = new r[i6];
      i2 = -1;
      i3 = 0;
      i1 = 0;
      label156:
      if (i1 < i6)
      {
        localWeatherBean = (WeatherBean)localArrayList.get(i1);
        localObject2[i1] = new r();
        if (localWeatherBean.e() != 1)
        {
          localObject2[i1].b = String.format(getText(2131166127).toString(), new Object[] { localWeatherBean.d() });
          localObject2[i1].c = 2;
          label233:
          localObject2[i1].a = localWeatherBean.c();
          if ((!localWeatherBean.c().equals(localObject1)) || (i3 != 0)) {
            break label471;
          }
          if ((localWeatherBean.e() == 1) || (i5 != 2)) {
            break label386;
          }
          i2 = 1;
          i3 = i1;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      int i4 = i3;
      i3 = i2;
      i2 = i4;
      break label156;
      label296:
      if (i1 == i2 - 1)
      {
        localWeatherBean = new WeatherBean();
        localWeatherBean.a(1);
        localWeatherBean.c(((WeatherBean)localObject2).c());
        localWeatherBean.e(((WeatherBean)localObject2).d());
        localArrayList.add(localWeatherBean);
        break label136;
      }
      i1 += 1;
      break label64;
      label356:
      i1 += 1;
      break;
      localObject2[i1].b = localWeatherBean.d();
      localObject2[i1].c = 1;
      break label233;
      label386:
      if (localWeatherBean.e() == 1)
      {
        i2 = 1;
        i3 = i1;
        continue;
        a(2131166122, i2, (r[])localObject2);
        return;
        localObject1 = new r[1];
        localObject1[0] = new r();
        localObject1[0].b = this.h;
        localObject1[0].a = this.h;
        localObject1[0].c = 1;
        a(2131166122, 0, (r[])localObject1);
      }
      else
      {
        label471:
        i4 = i2;
        i2 = i3;
        i3 = i4;
      }
    }
  }
  
  private void p()
  {
    int i2 = this.ah.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        if (this.j == this.ah[i1]) {
          a(2131166128, i1, this.ai, this.ah);
        }
      }
      else {
        return;
      }
      i1 += 1;
    }
  }
  
  private void q()
  {
    b localb = new b(getActivity());
    localb.b(2131166487);
    localb.c(2131166229);
    localb.a(new bg(this));
    localb.b();
  }
  
  private void r()
  {
    this.l.a(this.g, this.j, this.h, this.i, al[this.aj]);
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", 1);
    localIntent.putExtra("notify_on_or_off", this.g);
    getActivity().startService(localIntent);
  }
  
  private void s()
  {
    if ((this.l.a().C.equals("notification_style_default")) && (this.av == null))
    {
      IntentFilter localIntentFilter = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_STATUS_BAR_MATCHED");
      this.av = new bl(this);
      getActivity().registerReceiver(this.av, localIntentFilter);
    }
  }
  
  private void t()
  {
    if (this.av != null)
    {
      getActivity().unregisterReceiver(this.av);
      this.av = null;
    }
  }
  
  private t u()
  {
    if (this.at == null) {
      this.at = new t(getActivity());
    }
    return this.at;
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    a(this.n, 4, true);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = com.gau.go.launcherex.gowidget.weather.c.c.a(getActivity().getApplicationContext());
    this.l = paramBundle.f();
    this.m = paramBundle.h();
    this.n = ((TextView)c(2131231145));
    this.n.setText(2131166106);
    this.o = c(2131231196);
    this.o.setOnClickListener(this);
    this.an = getResources().getColor(2131361899);
    this.ao = getResources().getColor(2131361901);
    this.ap = getResources().getColor(2131361901);
    this.aq = 2130838496;
    this.ar = 2130838496;
    this.u = c(2131231466);
    this.u.setOnClickListener(this);
    this.v = ((CheckBox)c(2131231467));
    this.v.setOnCheckedChangeListener(this);
    if (y.p(getActivity()))
    {
      this.u.setVisibility(0);
      this.u.setVisibility(8);
      this.w = c(2131231485);
      this.w.setOnClickListener(this);
      this.x = ((CheckBox)c(2131231487));
      this.x.setOnCheckedChangeListener(this);
      this.p = c(2131231463);
      this.p.setOnClickListener(this);
      this.q = ((CheckBox)c(2131231465));
      this.q.setOnCheckedChangeListener(this);
      this.r = ((VerticalStretchLayout)c(2131231460));
      this.r.setOnClickListener(this);
      this.s = ((TextView)c(2131231461));
      this.t = ((TextView)c(2131231462));
      this.B = c(2131231468);
      this.B.setOnClickListener(this);
      this.D = ((CheckBox)c(2131231470));
      this.D.setOnCheckedChangeListener(this);
      this.C = c(2131231469);
      this.R = c(2131231471);
      if (!com.gau.go.launcherex.gowidget.c.a.e) {
        break label1017;
      }
      this.C.setVisibility(0);
      label408:
      this.E = ((VerticalStretchLayout)c(2131231472));
      this.F = c(2131231477);
      this.F.setOnClickListener(this);
      this.G = ((TextView)c(2131231480));
      this.H = ((TextView)c(2131231478));
      this.I = ((TextView)c(2131231479));
      this.J = c(2131231473);
      this.J.setOnClickListener(this);
      this.K = ((TextView)c(2131231476));
      this.L = ((TextView)c(2131231474));
      this.M = ((TextView)c(2131231475));
      this.O = ((TextView)c(2131231482));
      this.N = c(2131231481);
      this.N.setOnClickListener(this);
      this.P = ((TextView)c(2131231484));
      this.Q = ((TextView)c(2131231483));
      this.R.setVisibility(8);
      this.D.setVisibility(0);
      this.D.setEnabled(true);
      this.S = c(2131231445);
      this.S.setOnClickListener(this);
      this.T = ((CheckBox)c(2131231446));
      this.T.setOnCheckedChangeListener(this);
      this.U = ((VerticalStretchLayout)c(2131231447));
      this.W = ((TextView)c(2131231449));
      this.V = c(2131231448);
      this.V.setOnClickListener(this);
      this.X = ((TextView)c(2131231451));
      this.Y = ((TextView)c(2131231450));
      this.ai = com.gau.go.launcherex.gowidget.weather.util.c.c(getActivity());
      this.ah = getResources().getIntArray(2131558443);
      this.Z = c(2131231452);
      this.Z.setOnClickListener(this);
      this.aa = ((TextView)c(2131231455));
      this.ab = ((TextView)c(2131231453));
      this.ac = ((TextView)c(2131231454));
      this.ad = c(2131231456);
      this.ad.setOnClickListener(this);
      this.ae = ((TextView)c(2131231459));
      this.af = ((TextView)c(2131231457));
      this.ag = ((TextView)c(2131231458));
      this.y = c(2131231488);
      this.y.setOnClickListener(this);
      this.A = ((CheckBox)c(2131231490));
      this.A.setOnCheckedChangeListener(this);
      this.z = c(2131231489);
      if (!com.gau.go.launcherex.gowidget.c.a.c) {
        break label1028;
      }
      this.z.setVisibility(0);
    }
    for (;;)
    {
      d();
      this.as = new bk(this, null);
      paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
      getActivity().registerReceiver(this.as, paramBundle);
      b();
      return;
      this.u.setVisibility(8);
      break;
      label1017:
      this.C.setVisibility(4);
      break label408;
      label1028:
      this.z.setVisibility(4);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 1;
    int i4 = 1;
    int i5 = 1;
    int i6 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.v)) {
      if (paramBoolean) {
        if (this.a != i1)
        {
          this.a = i1;
          this.l.a(WeatherContentProvider.g, "setting_key", "weather_assistant_switch", "setting_value", i1);
        }
      }
    }
    label313:
    label401:
    label409:
    do
    {
      for (;;)
      {
        return;
        i1 = 0;
        break;
        if (paramCompoundButton.equals(this.x))
        {
          if (paramBoolean) {}
          for (i1 = i2; this.b != i1; i1 = 0)
          {
            this.b = i1;
            this.l.o(this.b);
            this.l.a(WeatherContentProvider.g, "setting_key", "weather_focecast_switch", "setting_value", this.b);
            return;
          }
        }
        else
        {
          if (paramCompoundButton.equals(this.q))
          {
            if (paramBoolean) {}
            for (i1 = i3;; i1 = 0)
            {
              if (this.c != i1)
              {
                this.c = i1;
                this.l.p(this.c);
                this.l.a(WeatherContentProvider.g, "setting_key", "weather_warning_switch", "setting_value", this.c);
              }
              b(paramBoolean);
              if (paramBoolean) {
                break;
              }
              q();
              return;
            }
          }
          if (paramCompoundButton.equals(this.D))
          {
            if (paramBoolean) {}
            for (i1 = i4; this.d != i1; i1 = 0)
            {
              this.d = i1;
              c(paramBoolean);
              this.l.q(this.d);
              this.l.a(WeatherContentProvider.g, "setting_key", "temp_change", "setting_value", this.d);
              if (!paramBoolean) {
                break label313;
              }
              this.E.d();
              return;
            }
            continue;
            this.E.c();
          }
          else
          {
            if (!paramCompoundButton.equals(this.T)) {
              break label409;
            }
            if (paramBoolean) {}
            for (i1 = i5; this.g != i1; i1 = 0)
            {
              this.g = i1;
              a(paramBoolean);
              r();
              this.l.a(WeatherContentProvider.g, "setting_key", "notify", "setting_value", this.g);
              if (!paramBoolean) {
                break label401;
              }
              this.U.d();
              return;
            }
          }
        }
      }
      this.U.c();
      return;
    } while ((!paramCompoundButton.equals(this.A)) || (this.am == paramBoolean));
    this.am = paramBoolean;
    if (paramBoolean) {}
    for (i1 = i6;; i1 = 0)
    {
      this.l.a(WeatherContentProvider.g, "setting_key", "notification_sound", "setting_value", i1);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.o)) {
      h();
    }
    do
    {
      return;
      if (paramView.equals(this.u))
      {
        this.v.toggle();
        return;
      }
      if (paramView.equals(this.w))
      {
        this.x.toggle();
        return;
      }
      if (paramView.equals(this.p))
      {
        this.q.toggle();
        return;
      }
      if (paramView.equals(this.r))
      {
        l();
        return;
      }
      if (paramView.equals(this.B))
      {
        if (com.gau.go.launcherex.gowidget.c.a.e)
        {
          com.gau.go.launcherex.gowidget.c.a.e = false;
          this.C.setVisibility(8);
          paramView = GoWidgetApplication.c(getActivity().getApplicationContext()).a().edit();
          paramView.putBoolean("key_new_feature_temp_change", false);
          paramView.commit();
        }
        this.D.toggle();
        return;
      }
      if (paramView.equals(this.F))
      {
        j();
        return;
      }
      if (paramView.equals(this.J))
      {
        k();
        return;
      }
      if (paramView.equals(this.N))
      {
        m();
        return;
      }
      if (paramView.equals(this.S))
      {
        this.T.toggle();
        return;
      }
      if (paramView.equals(this.y))
      {
        if (com.gau.go.launcherex.gowidget.c.a.c)
        {
          com.gau.go.launcherex.gowidget.c.a.c = false;
          this.z.setVisibility(8);
          paramView = GoWidgetApplication.c(getActivity().getApplicationContext()).a().edit();
          paramView.putBoolean("setting_notification_sound", false);
          paramView.commit();
        }
        this.A.toggle();
        return;
      }
      if (paramView.equals(this.V))
      {
        o();
        return;
      }
      if (paramView.equals(this.Z))
      {
        p();
        return;
      }
    } while (!paramView.equals(this.ad));
    a(2131166255, this.aj, this.ak);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903155, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.as != null)
    {
      getActivity().unregisterReceiver(this.as);
      this.as = null;
    }
    t();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */