package com.appbrain.a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cmn.ai;
import cmn.aj;
import cmn.ap;
import com.appbrain.e;
import com.appbrain.f;
import java.util.Arrays;
import java.util.Locale;

public final class j
  implements f
{
  private static ai a;
  private static ai b;
  private final Activity c;
  private String d;
  private boolean e;
  private LinearLayout f;
  private LayerDrawable g;
  private boolean h;
  private b i;
  private boolean j;
  
  public j(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  private View a(int paramInt, View paramView, int[] paramArrayOfInt, boolean paramBoolean)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.c);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(paramInt, paramInt));
    Object localObject = cmn.a.a();
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setShaderFactory(new q(this, paramArrayOfInt));
    ((cmn.a)localObject).a(paramView, com.appbrain.d.a.a(this.c, localShapeDrawable));
    int k;
    if (paramBoolean)
    {
      k = (paramInt - (int)Math.sqrt(Math.pow(paramInt, 2.0D) / 2.0D)) / 2;
      paramView.setPadding(k, k, k, k);
    }
    if (((paramArrayOfInt[0] & 0xFF000000) == -16777216) && ((paramArrayOfInt[1] & 0xFF000000) == -16777216))
    {
      k = aj.b(5.0F);
      paramInt += k;
      paramArrayOfInt = new View(this.c);
      localObject = new ViewGroup.MarginLayoutParams(paramInt, paramInt);
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(-k / 2, k, 0, 0);
      paramArrayOfInt.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new ShapeDrawable(new OvalShape());
      ((ShapeDrawable)localObject).setShaderFactory(new s(this, k));
      cmn.a.a().a(paramArrayOfInt, (Drawable)localObject);
      localFrameLayout.addView(paramArrayOfInt);
    }
    localFrameLayout.addView(paramView);
    return localFrameLayout;
  }
  
  private static int b(int paramInt)
  {
    int k = (int)Math.sqrt(Math.pow(paramInt, 2.0D) / 2.0D);
    paramInt /= 2;
    return k / 2 + paramInt;
  }
  
  private void e()
  {
    Object localObject1 = this.c.getResources().getConfiguration();
    Object localObject4;
    Object localObject2;
    Object localObject3;
    label132:
    label284:
    int m;
    label297:
    float f1;
    if (((Configuration)localObject1).orientation == 2)
    {
      k = 1;
      localObject4 = ((Configuration)localObject1).locale.getLanguage();
      localObject2 = t.a().a(-8343745, -8343745).a(-1117707).b(0).a();
      localObject3 = t.a().a(-4991873, -7819699).a(-1).b(-10716373).a();
      Object localObject5 = t.a().a(-8289919, -12895429).a(-1).b(-14540254).a();
      if (!this.e) {
        break label1318;
      }
      localObject1 = t.a().a(-1117707, -3618614).a(-13224394).a();
      localObject3 = new t(new w((byte)0).a((u)localObject1).b((u)localObject2).c((u)localObject3).d((u)localObject5), (byte)0);
      int n = aj.b(20.0F);
      int i1 = aj.b(24.0F);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(n, i1, n, i1);
      localObject2 = new TextView(this.c);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((TextView)localObject2).setTextColor(((t)localObject3).b.c);
      ((TextView)localObject2).setTextSize(20.0F);
      ((TextView)localObject2).setTypeface(((TextView)localObject2).getTypeface(), 1);
      ((TextView)localObject2).setGravity(1);
      if (!ao.a().c()) {
        break label1342;
      }
      localObject1 = g.a(13, (String)localObject4);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (k == 0) {
        break label1350;
      }
      m = 0;
      localObject5 = new LinearLayout.LayoutParams(m, -2);
      if (k == 0) {
        break label1356;
      }
      f1 = 1.0F;
      label315:
      ((LinearLayout.LayoutParams)localObject5).weight = f1;
      ((LinearLayout.LayoutParams)localObject5).bottomMargin = i1;
      ((LinearLayout.LayoutParams)localObject5).gravity = 1;
      localObject1 = new TextView(this.c);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((TextView)localObject1).setTextColor(((t)localObject3).c.c);
      ((TextView)localObject1).setTextSize(18.0F);
      localObject5 = cmn.a.a();
      m = aj.b(3.0F);
      Object localObject7 = ((t)localObject3).c;
      i1 = aj.b(1.0F);
      Object localObject8 = new float[8];
      Object localObject6 = new float[8];
      float[] arrayOfFloat = new float[8];
      Arrays.fill((float[])localObject8, aj.a(8.0F));
      Arrays.fill((float[])localObject6, localObject8[0] - m);
      Arrays.fill(arrayOfFloat, localObject8[0] - i1);
      localObject6 = new ShapeDrawable(new RoundRectShape((float[])localObject6, null, null));
      ((ShapeDrawable)localObject6).setShaderFactory(new n(this, (u)localObject7));
      ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape((float[])localObject8, null, null));
      localShapeDrawable.getPaint().setColor(((u)localObject7).b);
      localObject7 = new ShapeDrawable(new RoundRectShape((float[])localObject8, new RectF(i1, i1, i1, i1), arrayOfFloat));
      ((ShapeDrawable)localObject7).setShaderFactory(new p(this, m));
      localObject7 = new LayerDrawable(new ShapeDrawable[] { localShapeDrawable, localObject7, localObject6 });
      ((LayerDrawable)localObject7).setLayerInset(2, m, m, m, m);
      ((ShapeDrawable)localObject6).setPadding(aj.b(15.0F), aj.b(15.0F), aj.b(15.0F), aj.b(15.0F));
      ((cmn.a)localObject5).a((View)localObject1, (Drawable)localObject7);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setText(g.a(5, (String)localObject4));
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(10);
      ((RelativeLayout.LayoutParams)localObject7).addRule(9);
      localObject6 = new Button(this.c);
      ((Button)localObject6).setText(g.a(0, (String)localObject4));
      ((Button)localObject6).setTextColor(((t)localObject3).d.c);
      ((Button)localObject6).setTextSize(20.0F);
      ((Button)localObject6).setTypeface(((Button)localObject6).getTypeface(), 1);
      ((Button)localObject6).setGravity(17);
      ((Button)localObject6).setOnClickListener(new k(this));
      ((Button)localObject6).getViewTreeObserver().addOnGlobalLayoutListener(new l(this, (Button)localObject6));
      localObject5 = a(aj.b(120.0F), (View)localObject6, ((t)localObject3).d.a, true);
      ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(12);
      ((RelativeLayout.LayoutParams)localObject7).addRule(11);
      localObject8 = new Button(this.c);
      ((Button)localObject8).setTextColor(((t)localObject3).e.c);
      ((Button)localObject8).setTypeface(((Button)localObject8).getTypeface(), 1);
      ((Button)localObject8).setOnClickListener(new m(this));
      localObject4 = g.a(10, (String)localObject4);
      ((Button)localObject8).setTextSize(ap.a((String)localObject4, 80, 80, Math.min(((String)localObject4).split("\t").length, 3), 16.0F, ((Button)localObject8).getPaint(), ((Button)localObject8).getTypeface()));
      ((Button)localObject8).setText((CharSequence)localObject4);
      localObject4 = a(aj.b(80.0F), (View)localObject8, ((t)localObject3).e.a, false);
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      m = b(((Button)localObject6).getLayoutParams().width) + b(((Button)localObject8).getLayoutParams().width);
      localObject7 = new LinearLayout.LayoutParams(aj.b(18.0F) + m, m - aj.b(20.0F));
      if (k == 0) {
        break label1361;
      }
      m = aj.b(20.0F);
      label1040:
      ((LinearLayout.LayoutParams)localObject7).leftMargin = m;
      localObject6 = new RelativeLayout(this.c);
      ((RelativeLayout)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      ((RelativeLayout)localObject6).setGravity(17);
      ((RelativeLayout)localObject6).addView((View)localObject4);
      ((RelativeLayout)localObject6).addView((View)localObject5);
      localObject5 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject5).setMargins(n, 0, n, 0);
      localObject4 = new LinearLayout(this.c);
      ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((LinearLayout)localObject4).setGravity(1);
      ((LinearLayout)localObject4).addView((View)localObject1);
      ((LinearLayout)localObject4).addView((View)localObject6);
      if (k == 0) {
        break label1366;
      }
    }
    label1318:
    label1342:
    label1350:
    label1356:
    label1361:
    label1366:
    for (int k = 0;; k = 1)
    {
      ((LinearLayout)localObject4).setOrientation(k);
      localObject1 = new Drawable[2];
      localObject1[0] = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, ((t)localObject3).b.a);
      localObject3 = new ShapeDrawable(new OvalShape());
      ((ShapeDrawable)localObject3).setShaderFactory(new r(this));
      localObject1[1] = localObject3;
      localObject1[1].setAlpha(0);
      this.g = new LayerDrawable((Drawable[])localObject1);
      this.f = new LinearLayout(this.c);
      this.f.setOrientation(1);
      cmn.a.a().a(this.f, this.g);
      this.f.addView((View)localObject2);
      this.f.addView((View)localObject4);
      this.c.setContentView(this.f);
      return;
      k = 0;
      break;
      localObject1 = t.a().a(-12303292, -15592942).a(-1).a();
      break label132;
      localObject1 = "AppLift SDK requires changes to your proguard config as detailed in the documentation!";
      break label284;
      m = -2;
      break label297;
      f1 = 0.0F;
      break label315;
      m = 0;
      break label1040;
    }
  }
  
  public final void a()
  {
    e();
  }
  
  public final void a(Bundle paramBundle)
  {
    int k = 1;
    this.c.getWindow().setFormat(1);
    this.c.requestWindowFeature(1);
    e.a(this.c);
    Object localObject = this.c.getIntent();
    com.appbrain.a locala;
    if (localObject != null)
    {
      this.j = ((Intent)localObject).getBooleanExtra("maybe", false);
      this.d = ((Intent)localObject).getStringExtra("ana");
      locala = (com.appbrain.a)((Intent)localObject).getSerializableExtra("adop");
      if (locala.b() == com.appbrain.b.b)
      {
        bool = true;
        this.e = bool;
      }
    }
    for (boolean bool = locala.c();; bool = false)
    {
      this.i = b.a((Intent)localObject);
      e();
      if (paramBundle == null)
      {
        paramBundle = this.c;
        localObject = new i().a("more_apps").a(bool).b(this.j);
        if (!this.e) {
          break label197;
        }
      }
      for (;;)
      {
        h.a(paramBundle, ((i)localObject).a(k).toString());
        if (b != null) {
          b.a(this.c);
        }
        return;
        bool = false;
        break;
        label197:
        k = 0;
      }
    }
  }
  
  public final boolean a(int paramInt)
  {
    return false;
  }
  
  public final void b()
  {
    if (a != null) {
      a.a(Boolean.valueOf(this.h));
    }
  }
  
  public final void b(Bundle paramBundle) {}
  
  public final boolean c()
  {
    return true;
  }
  
  public final void d() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */