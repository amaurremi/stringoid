package com.appbrain.a;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cmn.aj;
import com.appbrain.b;
import java.util.Locale;
import java.util.Random;

public class bc
{
  private static final Class[] a = { bq.class, br.class, bs.class };
  private static final bd[] b = { new bd(-8343745, false, 0), new bd(-82174, true, 0) };
  private static final String c = bc.class.getName();
  private static final String d = c + ".ImpressionCounted";
  private static final String e = c + ".Selected";
  private static final String f = c + ".Light";
  private static final String g = c + ".Starburst";
  private static final String h = c + ".Layout";
  private static final String i = c + ".Button";
  private final Context j;
  private final Runnable k;
  private final boolean l;
  private final boolean m;
  private final int n;
  private final int o;
  private final bg p;
  private final String q;
  private final Random r = new Random();
  private boolean s;
  private int t;
  
  public bc(Context paramContext, Bundle paramBundle, com.appbrain.a parama, bg parambg, boolean paramBoolean, Runnable paramRunnable)
  {
    this.j = paramContext;
    this.k = paramRunnable;
    this.p = parambg;
    boolean bool;
    label65:
    label112:
    int i1;
    label135:
    int i3;
    int i4;
    if (paramBundle == null)
    {
      this.s = false;
      this.t = -1;
      if (parama == null)
      {
        paramContext = null;
        if (paramContext != b.b) {
          break label225;
        }
        bool = true;
        this.l = bool;
        this.m = this.r.nextBoolean();
        this.n = this.r.nextInt(a.length);
        this.o = this.r.nextInt(b.length);
        paramContext = new i().a("single_app");
        if (!this.l) {
          break label319;
        }
        i1 = 1;
        i3 = this.n;
        i4 = this.o;
        if (!this.m) {
          break label325;
        }
      }
    }
    for (;;)
    {
      this.q = paramContext.a(i1 + ((i3 & 0xF) << 4) + ((i4 & 0xF) << 8) + (i2 << 12) + ((this.p.ordinal() & 0xF) << 16)).a(parama.c()).b(paramBoolean).toString();
      return;
      paramContext = parama.b();
      break;
      label225:
      if (paramContext == b.c)
      {
        bool = false;
        break label65;
      }
      bool = this.r.nextBoolean();
      break label65;
      this.s = paramBundle.getBoolean(d);
      this.t = paramBundle.getInt(e);
      this.l = paramBundle.getBoolean(f);
      this.m = paramBundle.getBoolean(g);
      this.n = paramBundle.getInt(h);
      this.o = paramBundle.getInt(i);
      break label112;
      label319:
      i1 = 0;
      break label135;
      label325:
      i2 = 0;
    }
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Object localObject = new Paint();
    ((Paint)localObject).setColor(paramInt2);
    ((Paint)localObject).setStrokeWidth(aj.b(1.5F));
    ((Paint)localObject).setAntiAlias(true);
    localObject = new bm(this, new OvalShape(), (Paint)localObject);
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt1);
    ((ShapeDrawable)localObject).setIntrinsicWidth(aj.b(28.0F));
    ((ShapeDrawable)localObject).setIntrinsicHeight(aj.b(28.0F));
    return (Drawable)localObject;
  }
  
  private Drawable a(int paramInt, boolean paramBoolean)
  {
    RectF localRectF = new RectF();
    int i2 = aj.b(2.0F);
    if (paramBoolean) {}
    for (int i1 = aj.b(3.0F);; i1 = 0)
    {
      int i3 = aj.b(1.0F);
      Paint localPaint1 = new Paint();
      localPaint1.setColor(paramInt);
      Paint localPaint2 = new Paint();
      localPaint2.setColor(-1);
      if (paramBoolean) {
        localPaint2.setShadowLayer(i1, 0.0F, 0.0F, -16777216);
      }
      return new bl(this, localRectF, i1, i2, localPaint2, i1 + i3, localPaint1);
    }
  }
  
  private Drawable b()
  {
    if (!this.m)
    {
      if (this.l) {}
      for (i1 = -1442840576;; i1 = -1426063361) {
        return new ColorDrawable(i1);
      }
    }
    Object localObject = cmn.a.a().a(this.j);
    localObject = Bitmap.createBitmap(((Point)localObject).x / 5 + 256, ((Point)localObject).y / 5 + 256, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).eraseColor(52224);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    RectF localRectF = new RectF(-((Bitmap)localObject).getWidth() * 0.5F, -((Bitmap)localObject).getHeight() * 0.5F, ((Bitmap)localObject).getWidth() * 1.5F, ((Bitmap)localObject).getHeight() * 1.5F);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(-133694);
    int i1 = 0;
    while (i1 < 360)
    {
      localCanvas.drawArc(localRectF, i1, 6.0F, true, localPaint);
      i1 += 12;
    }
    return new BitmapDrawable(this.j.getResources(), (Bitmap)localObject);
  }
  
  private bf c()
  {
    try
    {
      bf localbf = (bf)a[this.n].newInstance();
      return localbf;
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public final View a()
  {
    Object localObject2 = this.j.getResources().getConfiguration();
    Object localObject1 = ((Configuration)localObject2).locale.getLanguage();
    int i2;
    label43:
    be localbe;
    Object localObject3;
    int i3;
    label325:
    int i4;
    label337:
    int i5;
    if (((Configuration)localObject2).orientation == 2)
    {
      i1 = 1;
      if (!this.l) {
        break label1168;
      }
      i2 = -16777216;
      localObject2 = c();
      localbe = new be(this);
      localbe.a = new ProgressBar(this.j);
      localbe.b = new TextView(this.j);
      localbe.b.setVisibility(8);
      localObject3 = cmn.a.a();
      Object localObject4 = localbe.b;
      float f1 = aj.b(4.0F);
      Object localObject5 = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
      ((ShapeDrawable)localObject5).getPaint().setColor(-1954001);
      ((cmn.a)localObject3).a((View)localObject4, com.appbrain.d.a.a(this.j, (Drawable)localObject5));
      localbe.b.setTextColor(-1);
      localbe.b.setText(g.a(1, (String)localObject1).toUpperCase());
      localbe.b.setTextSize(16.0F);
      localbe.b.setPadding(aj.b(8.0F), aj.b(4.0F), aj.b(8.0F), aj.b(4.0F));
      localbe.b.setTypeface(localbe.b.getTypeface(), 1);
      localbe.c = new ImageView(this.j);
      localObject3 = localbe.c;
      if (!this.l) {
        break label1173;
      }
      i3 = -4605768;
      if (!this.l) {
        break label1179;
      }
      i4 = -10724517;
      if (!this.l) {
        break label1187;
      }
      i5 = -1;
      label347:
      localObject4 = new StateListDrawable();
      localObject5 = a(i4, i5);
      ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject5);
      localObject5 = a(i3, i5);
      ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject5);
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject4);
      localbe.c.setOnClickListener(new bi(this));
      localbe.d = new TextView(this.j);
      localbe.d.setVisibility(8);
      localbe.d.setTypeface(localbe.d.getTypeface(), 1);
      localbe.d.setTextColor(i2);
      localbe.d.setTextSize(22.0F);
      localbe.f = new bh(this.j);
      localbe.f.setVisibility(8);
      if (((bf)localObject2).a()) {
        localbe.f.a();
      }
      localbe.e = new TextView(this.j);
      localbe.e.setVisibility(8);
      localbe.e.setTextColor(i2);
      localbe.e.setTextSize(16.0F);
      if (Build.VERSION.SDK_INT >= 16) {
        localbe.e.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      localbe.g = new TextView(this.j);
      localbe.g.setVisibility(8);
      localbe.g.setGravity(16);
      localbe.g.setTextColor(-1);
      localbe.g.setTypeface(localbe.g.getTypeface(), 1);
      localbe.g.setTextSize(18.0F);
      localbe.g.setText(g.a(3, (String)localObject1).toUpperCase());
      localbe.g.setCompoundDrawablePadding(aj.b(8.0F));
      localObject3 = localbe.g;
      localObject4 = b[this.o];
      if (bd.a((bd)localObject4)) {
        cmn.a.a().a((View)localObject3);
      }
      localObject5 = new float[3];
      Color.colorToHSV(bd.b((bd)localObject4), (float[])localObject5);
      localObject5[2] *= 0.75F;
      i3 = Color.HSVToColor((float[])localObject5);
      localObject5 = new StateListDrawable();
      Drawable localDrawable = a(i3, bd.a((bd)localObject4));
      ((StateListDrawable)localObject5).addState(new int[] { 16842919 }, localDrawable);
      localObject4 = a(bd.b((bd)localObject4), bd.a((bd)localObject4));
      ((StateListDrawable)localObject5).addState(new int[0], (Drawable)localObject4);
      cmn.a.a().a((View)localObject3, (Drawable)localObject5);
      localObject3 = bv.a(-1);
      ((Drawable)localObject3).setBounds(0, 0, aj.b(32.0F), aj.b(32.0F));
      localbe.g.setCompoundDrawables((Drawable)localObject3, null, null, null);
      localbe.g.setPadding(aj.b(16.0F), aj.b(12.0F), aj.b(16.0F), aj.b(12.0F));
      localbe.h = new TextView(this.j);
      localbe.h.setVisibility(8);
      localbe.h.setTextColor(i2);
      localbe.h.setTextSize(11.0F);
      localbe.h.setText(g.a(11, (String)localObject1));
      if (i1 == 0) {
        break label1194;
      }
      localObject1 = ((bf)localObject2).b(this.j, localbe);
      label996:
      if (!this.l) {
        break label1212;
      }
    }
    label1168:
    label1173:
    label1179:
    label1187:
    label1194:
    label1212:
    for (int i1 = -1;; i1 = -14540254)
    {
      ((ViewGroup)localObject1).setBackgroundColor(i1);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject3 = new LayoutTransition();
        ((LayoutTransition)localObject3).setDuration(200L);
        ((LayoutTransition)localObject3).setStartDelay(2, 0L);
        ((LayoutTransition)localObject3).setStartDelay(3, 0L);
        ((LayoutTransition)localObject3).setStartDelay(0, 0L);
        ((LayoutTransition)localObject3).setStartDelay(1, 0L);
        ((ViewGroup)localObject1).setLayoutTransition((LayoutTransition)localObject3);
      }
      localObject3 = new LinearLayout(this.j);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      cmn.a.a().a((View)localObject3, b());
      ((LinearLayout)localObject3).setPadding(aj.b(24.0F), 0, aj.b(24.0F), 0);
      ((LinearLayout)localObject3).addView((View)localObject1);
      ((LinearLayout)localObject3).setClickable(true);
      bt.a(this.j, new bj(this, localbe, (bf)localObject2));
      return (View)localObject3;
      i1 = 0;
      break;
      i2 = -1;
      break label43;
      i3 = -1;
      break label325;
      i4 = -7829368;
      break label337;
      i5 = -16777216;
      break label347;
      localObject1 = ((bf)localObject2).a(this.j, localbe);
      break label996;
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    paramBundle.putInt(e, this.t);
    paramBundle.putBoolean(f, this.l);
    paramBundle.putBoolean(g, this.m);
    paramBundle.putInt(h, this.n);
    paramBundle.putInt(i, this.o);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */