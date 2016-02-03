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
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cmn.a;
import cmn.q;
import com.appbrain.AdOptions;
import com.appbrain.AdOptions.Theme;
import com.appbrain.d.c;
import java.util.Locale;
import java.util.Random;

public class ae
{
  private static final Class[] a = { an.class, ao.class, ap.class };
  private static final a[] b = { new a(-8343745, false, 0), new a(-82174, true, 0) };
  private static final String c = ae.class.getName();
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
  private final int p;
  private final String q;
  private final Random r = new Random();
  private boolean s;
  private int t;
  
  public ae(Context paramContext, Bundle paramBundle, AdOptions paramAdOptions, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    this.j = paramContext;
    this.k = paramRunnable;
    this.p = paramInt;
    boolean bool;
    label65:
    label112:
    label135:
    int i2;
    int i3;
    if (paramBundle == null)
    {
      this.s = false;
      this.t = -1;
      if (paramAdOptions == null)
      {
        paramContext = null;
        if (paramContext != AdOptions.Theme.LIGHT) {
          break label224;
        }
        bool = true;
        this.l = bool;
        this.m = this.r.nextBoolean();
        this.n = this.r.nextInt(a.length);
        this.o = this.r.nextInt(b.length);
        paramContext = new bt.a().a("single_app");
        if (!this.l) {
          break label318;
        }
        paramInt = 1;
        i2 = this.n;
        i3 = this.o;
        if (!this.m) {
          break label324;
        }
      }
    }
    for (;;)
    {
      this.q = paramContext.a(paramInt + ((i2 & 0xF) << 4) + ((i3 & 0xF) << 8) + (i1 << 12) + ((this.p - 1 & 0xF) << 16)).a(paramAdOptions.isSmart()).b(paramBoolean).toString();
      return;
      paramContext = paramAdOptions.getTheme();
      break;
      label224:
      if (paramContext == AdOptions.Theme.DARK)
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
      label318:
      paramInt = 0;
      break label135;
      label324:
      i1 = 0;
    }
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Object localObject = new Paint();
    ((Paint)localObject).setColor(paramInt2);
    ((Paint)localObject).setStrokeWidth(q.b(1.5F));
    ((Paint)localObject).setAntiAlias(true);
    localObject = new aj(this, new OvalShape(), (Paint)localObject);
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt1);
    ((ShapeDrawable)localObject).setIntrinsicWidth(q.b(28.0F));
    ((ShapeDrawable)localObject).setIntrinsicHeight(q.b(28.0F));
    return (Drawable)localObject;
  }
  
  private Drawable a(int paramInt, boolean paramBoolean)
  {
    RectF localRectF = new RectF();
    int i2 = q.b(2.0F);
    if (paramBoolean) {}
    for (int i1 = q.b(3.0F);; i1 = 0)
    {
      int i3 = q.b(1.0F);
      Paint localPaint1 = new Paint();
      localPaint1.setColor(paramInt);
      Paint localPaint2 = new Paint();
      localPaint2.setColor(-1);
      if (paramBoolean) {
        localPaint2.setShadowLayer(i1, 0.0F, 0.0F, -16777216);
      }
      return new ai(this, localRectF, i1, i2, localPaint2, i1 + i3, localPaint1);
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
    Object localObject = a.a().a(this.j);
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
  
  private c c()
  {
    try
    {
      c localc = (c)a[this.n].newInstance();
      return localc;
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
    b localb;
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
      localb = new b();
      localb.a = new ProgressBar(this.j);
      localb.b = new TextView(this.j);
      localb.b.setVisibility(8);
      localObject3 = a.a();
      Object localObject4 = localb.b;
      float f1 = q.b(4.0F);
      Object localObject5 = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
      ((ShapeDrawable)localObject5).getPaint().setColor(-1954001);
      ((a)localObject3).a((View)localObject4, c.a(this.j, (Drawable)localObject5));
      localb.b.setTextColor(-1);
      localb.b.setText(bs.a(1, (String)localObject1).toUpperCase());
      localb.b.setTextSize(16.0F);
      localb.b.setPadding(q.b(8.0F), q.b(4.0F), q.b(8.0F), q.b(4.0F));
      localb.b.setTypeface(localb.b.getTypeface(), 1);
      localb.c = new ImageView(this.j);
      localObject3 = localb.c;
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
      localb.c.setOnClickListener(new af(this));
      localb.d = new TextView(this.j);
      localb.d.setVisibility(8);
      localb.d.setTypeface(localb.d.getTypeface(), 1);
      localb.d.setTextColor(i2);
      localb.d.setTextSize(22.0F);
      localb.f = new e(this.j);
      localb.f.setVisibility(8);
      if (((c)localObject2).a()) {
        localb.f.a();
      }
      localb.e = new TextView(this.j);
      localb.e.setVisibility(8);
      localb.e.setTextColor(i2);
      localb.e.setTextSize(16.0F);
      if (Build.VERSION.SDK_INT >= 16) {
        localb.e.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      localb.g = new TextView(this.j);
      localb.g.setVisibility(8);
      localb.g.setGravity(16);
      localb.g.setTextColor(-1);
      localb.g.setTypeface(localb.g.getTypeface(), 1);
      localb.g.setTextSize(18.0F);
      localb.g.setText(bs.a(3, (String)localObject1).toUpperCase());
      localb.g.setCompoundDrawablePadding(q.b(8.0F));
      localObject3 = localb.g;
      localObject4 = b[this.o];
      if (a.a((a)localObject4)) {
        a.a().a((View)localObject3);
      }
      localObject5 = new float[3];
      Color.colorToHSV(a.b((a)localObject4), (float[])localObject5);
      localObject5[2] *= 0.75F;
      i3 = Color.HSVToColor((float[])localObject5);
      localObject5 = new StateListDrawable();
      Drawable localDrawable = a(i3, a.a((a)localObject4));
      ((StateListDrawable)localObject5).addState(new int[] { 16842919 }, localDrawable);
      localObject4 = a(a.b((a)localObject4), a.a((a)localObject4));
      ((StateListDrawable)localObject5).addState(new int[0], (Drawable)localObject4);
      a.a().a((View)localObject3, (Drawable)localObject5);
      localObject3 = at.a(-1);
      ((Drawable)localObject3).setBounds(0, 0, q.b(32.0F), q.b(32.0F));
      localb.g.setCompoundDrawables((Drawable)localObject3, null, null, null);
      localb.g.setPadding(q.b(16.0F), q.b(12.0F), q.b(16.0F), q.b(12.0F));
      localb.h = new TextView(this.j);
      localb.h.setVisibility(8);
      localb.h.setTextColor(i2);
      localb.h.setTextSize(11.0F);
      localb.h.setText(bs.a(11, (String)localObject1));
      if (i1 == 0) {
        break label1194;
      }
      localObject1 = ((c)localObject2).b(this.j, localb);
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
      a.a().a((View)localObject3, b());
      ((LinearLayout)localObject3).setPadding(q.b(24.0F), 0, q.b(24.0F), 0);
      ((LinearLayout)localObject3).addView((View)localObject1);
      ((LinearLayout)localObject3).setClickable(true);
      ar.a(this.j, new ag(this, localb, (c)localObject2));
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
      localObject1 = ((c)localObject2).a(this.j, localb);
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
  
  private static final class a
  {
    private final int a;
    private final boolean b;
    
    private a(int paramInt, boolean paramBoolean)
    {
      this.a = paramInt;
      this.b = paramBoolean;
    }
  }
  
  public final class b
  {
    public ProgressBar a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public ae.e f;
    public TextView g;
    public TextView h;
    
    public b() {}
  }
  
  public static abstract interface c
  {
    public abstract ViewGroup a(Context paramContext, ae.b paramb);
    
    public abstract boolean a();
    
    public abstract ViewGroup b(Context paramContext, ae.b paramb);
  }
  
  public static enum d {}
  
  private static final class e
    extends ImageView
  {
    private float a;
    private int b;
    
    public e(Context paramContext)
    {
      super();
    }
    
    public final void a()
    {
      this.a = 2.05F;
    }
    
    public final void b()
    {
      this.b = 20;
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      if (this.a == 0.0F)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = (int)(paramInt2 / this.a);
      setMeasuredDimension(paramInt2, paramInt1);
      paramInt2 = paramInt2 * this.b / 100;
      paramInt1 = paramInt1 * this.b / 100;
      setPadding(paramInt2, paramInt1, paramInt2, paramInt1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */