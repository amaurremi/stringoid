package com.appbrain.a;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cmn.aa;
import cmn.q;
import cmn.w;
import cmn.x;
import com.appbrain.d.c;
import com.appbrain.d.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class at
{
  public static final g[] a = { new g(-12303292, -15658735, -1118482, -12207149, -12736838, -1, -1, -10967038), new g(-1, -1118482, -13421773, -12207149, -12736838, -1, -1, -10967038), new g(-2565928, -2565928, -13421773, -10967038, -10967038, -1, -1, -10967038), new g(-13224394, -13224394, -1, -16738603, -16738603, 0, -1, -37373), new g(-16738603, -16738603, -1, -2796288, -2796288, -1, -1, -10967038), new g(-1, -1, -16777216, -10967038, -10967038, -1, -1, -37373), new g(-34304, -2135038, -1, -2031540, -2031540, -1, -1, 51712), new g(-5869824, -4223184, -1, 43520, 43520, -1, -1, 53363), new g(-5895168, -4244944, -1, -60672, -60672, -1, -1, -4105646), new g(-16744682, -14314952, -1, -15897058, -15897058, -1, -1, -13049514), new g(-15252318, -13876104, -1, -16308633, -16308633, -1, -1, -10057779), new g(-12384921, -10868616, -1, -9695070, -9695070, -1, -1, -6004531), new g(-1710619, -3618873, -12435134, -1, -1, -1, -12435134, -3223858), new g(-1, -1, -12435134, -856091, -856091, -4609383, -12435134, -1645868) };
  public static e[] b = { new l(), new m(), new b(), new k() };
  private static final Random c = new Random();
  private static final int[] d = { 3 };
  
  public static int a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 4)
    {
      if ((paramBoolean) || (!d(i))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return ((Integer)localArrayList.get(c.nextInt(localArrayList.size()))).intValue();
  }
  
  public static ShapeDrawable a(int paramInt)
  {
    Object localObject = new Path();
    RectF localRectF = new RectF();
    ((Path)localObject).moveTo(0.0F, 24.0F);
    localRectF.set(22.0F, 2.0F, 66.0F, 46.0F);
    ((Path)localObject).arcTo(localRectF, 180.0F, 180.0F);
    ((Path)localObject).moveTo(88.0F, 24.0F);
    localRectF.set(78.0F, 78.0F, 88.0F, 88.0F);
    ((Path)localObject).arcTo(localRectF, 0.0F, 90.0F);
    localRectF.set(0.0F, 78.0F, 10.0F, 88.0F);
    ((Path)localObject).arcTo(localRectF, 90.0F, 90.0F);
    ((Path)localObject).lineTo(0.0F, 24.0F);
    ((Path)localObject).close();
    localRectF.set(30.0F, 10.0F, 58.0F, 38.0F);
    ((Path)localObject).arcTo(localRectF, 0.0F, -180.0F);
    ((Path)localObject).close();
    ((Path)localObject).moveTo(32.0F, 40.0F);
    ((Path)localObject).lineTo(32.0F, 73.0F);
    ((Path)localObject).lineTo(61.0F, 56.5F);
    ((Path)localObject).close();
    localObject = new ShapeDrawable(new PathShape((Path)localObject, 88.0F, 88.0F));
    ((ShapeDrawable)localObject).setIntrinsicHeight(q.b(44.0F));
    ((ShapeDrawable)localObject).setIntrinsicWidth(q.b(44.0F));
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt);
    return (ShapeDrawable)localObject;
  }
  
  public static ShapeDrawable b(int paramInt)
  {
    Object localObject = new Path();
    ((Path)localObject).moveTo(14.0F, 7.0F);
    ((Path)localObject).lineTo(23.0F, 7.0F);
    ((Path)localObject).lineTo(23.0F, 19.0F);
    ((Path)localObject).lineTo(29.0F, 19.0F);
    ((Path)localObject).lineTo(19.0F, 30.0F);
    ((Path)localObject).lineTo(9.0F, 19.0F);
    ((Path)localObject).lineTo(14.0F, 19.0F);
    ((Path)localObject).close();
    localObject = new ShapeDrawable(new PathShape((Path)localObject, 38.0F, 38.0F));
    ((ShapeDrawable)localObject).setIntrinsicHeight(q.b(48.0F));
    ((ShapeDrawable)localObject).setIntrinsicWidth(q.b(48.0F));
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt);
    return (ShapeDrawable)localObject;
  }
  
  public static int c(int paramInt)
  {
    return 0xFF000000 | (paramInt & 0xFF0000) * 2 / 3 & 0xFF0000 | (paramInt & 0xFF00) * 2 / 3 & 0xFF00 | (paramInt & 0xFF) * 2 / 3 & 0xFF;
  }
  
  public static boolean d(int paramInt)
  {
    return Arrays.binarySearch(d, paramInt) >= 0;
  }
  
  public static j e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new f();
    case 1: 
      return new c();
    case 2: 
      return new n();
    }
    return new i();
  }
  
  public static final class a
  {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final at.g e;
    public final View.OnClickListener f;
    
    protected a(String paramString1, String paramString2, String paramString3, String paramString4, at.g paramg, View.OnClickListener paramOnClickListener)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramg;
      this.f = paramOnClickListener;
    }
  }
  
  public static final class b
    implements at.e
  {
    public final View a(Context paramContext, at.d paramd)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      int i = q.b(10.0F);
      int j = q.b(30.0F);
      int k = q.b(16.0F);
      localLinearLayout.setOrientation(0);
      Object localObject1 = new x(paramContext);
      ((x)localObject1).setMaxLines(2);
      ((x)localObject1).setText(paramd.a);
      ((x)localObject1).setTextSize(13.0F);
      ((x)localObject1).setPadding(q.b(12.0F), q.b(6.0F), q.b(6.0F), q.b(6.0F));
      ((x)localObject1).setTextColor(paramd.c.c);
      ((x)localObject1).setTypeface(Typeface.SERIF);
      Object localObject2 = new az(this, paramd, k, i, j);
      cmn.a.a().a(localLinearLayout, new LayerDrawable(new Drawable[] { new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramd.c.a, paramd.c.b }), localObject2 }));
      localObject2 = new LinearLayout.LayoutParams(0, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 17;
      ((LinearLayout.LayoutParams)localObject2).weight = 2.0F;
      ((LinearLayout.LayoutParams)localObject2).leftMargin = (q.b(4.0F) + i);
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new Button(paramContext);
      localObject2 = new w(paramContext);
      i = 0;
      while (i < 2)
      {
        Button localButton = new Button[] { localObject2, localObject1 }[i];
        Object localObject3 = com.appbrain.d.a.a(paramContext, 0.5F, paramd.c.f);
        ((com.appbrain.d.a)localObject3).a().setStrokeWidth(q.a(1.4F));
        ((com.appbrain.d.a)localObject3).setShaderFactory(new ba(this, paramd));
        localObject3 = new InsetDrawable(c.a(paramContext, (Drawable)localObject3, new bb(this, (com.appbrain.d.a)localObject3)), q.b(6.0F));
        cmn.a.a().a(localButton, (Drawable)localObject3);
        at.a(localButton, paramd);
        localButton.setTextSize(13.0F);
        localButton.setPadding(q.b(12.0F), q.b(12.0F), q.b(12.0F), q.b(12.0F));
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(1);
      paramd = new LinearLayout.LayoutParams(-2, -2);
      paramd.gravity = 17;
      paramContext.addView((View)localObject2, paramd);
      paramd = new LinearLayout.LayoutParams(0, -2);
      paramd.weight = 1.0F;
      paramd.leftMargin = q.b(2.0F);
      paramd.rightMargin = (q.b(2.0F) + j);
      paramd.topMargin = q.b(2.0F);
      paramd.bottomMargin = q.b(2.0F);
      paramd.gravity = 17;
      localLinearLayout.addView(paramContext, paramd);
      localLinearLayout.setWeightSum(3.0F);
      return at.a(localLinearLayout, (Button)localObject2, (Button)localObject1);
    }
  }
  
  public static final class c
    implements at.j
  {
    public final int a()
    {
      return at.a().nextInt(at.a.length);
    }
    
    public final View a(Context paramContext, at.a parama)
    {
      at.g localg = new at.g();
      RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = q.b(50.0F);
      Object localObject1 = new LinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(0);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      cmn.a.a().a(localRelativeLayout, new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { localg.a, localg.b }));
      localObject2 = new ImageView(paramContext);
      ((ImageView)localObject2).setImageDrawable(new h(paramContext, parama.c));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(q.b(38.0F), q.b(38.0F));
      localLayoutParams.gravity = 17;
      localLayoutParams.leftMargin = q.b(4.0F);
      localLayoutParams.rightMargin = q.b(4.0F);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localObject2 = new LinearLayout(paramContext);
      ((LinearLayout)localObject2).setOrientation(1);
      x localx = new x(paramContext);
      localx.setMaxLines(1);
      localx.setTypeface(localx.getTypeface(), 1);
      localx.setText(parama.a);
      localx.setTextSize(0, q.a(12.0F));
      localx.setTextColor(localg.c);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout)localObject2).addView(localx, localLayoutParams);
      localx = new x(paramContext);
      localx.setMaxLines(2);
      localx.setText(parama.b);
      localx.setTextSize(0, q.a(9.0F));
      localx.setTextColor(localg.c);
      ((LinearLayout)localObject2).addView(localx, localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 19;
      localLayoutParams.weight = 2.0F;
      localLayoutParams.leftMargin = q.b(4.0F);
      localLayoutParams.rightMargin = q.b(4.0F);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localObject1 = at.a(paramContext, localg, at.b(localg.g), (View)localObject1);
      ((at.h)localObject1).c.setPadding(q.b(10.0F), 0, q.b(10.0F), 0);
      ((at.h)localObject1).b.setPadding(0, 0, 0, 0);
      ((at.h)localObject1).b.getLayoutParams().width = q.b(38.0F);
      ((at.h)localObject1).b.getLayoutParams().height = q.b(38.0F);
      ((at.h)localObject1).a.setOnClickListener(parama.f);
      parama = new com.appbrain.d.a(new RectShape());
      parama.a().setColor(at.c(localg.e));
      parama.a().setStrokeWidth(q.b(1.0F));
      parama.setShaderFactory(new bc(this, localg));
      cmn.a.a().a(((at.h)localObject1).a, c.b(paramContext, parama));
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.rightMargin = q.b(6.0F);
      paramContext.addRule(11);
      paramContext.addRule(15);
      localRelativeLayout.addView(((at.h)localObject1).a, paramContext);
      return localRelativeLayout;
    }
  }
  
  public static final class d
  {
    public final String a;
    public final String b;
    public final at.g c;
    public final int d;
    public final View.OnClickListener e;
    
    public d(String paramString1, String paramString2, at.g paramg, int paramInt, View.OnClickListener paramOnClickListener)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramg;
      this.d = paramInt;
      this.e = paramOnClickListener;
    }
  }
  
  public static abstract interface e
  {
    public abstract View a(Context paramContext, at.d paramd);
  }
  
  public static final class f
    implements at.j
  {
    public final int a()
    {
      return at.a().nextInt(at.a.length);
    }
    
    public final View a(Context paramContext, at.a parama)
    {
      Object localObject1 = new at.g();
      RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = q.b(50.0F);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(0);
      localRelativeLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new ShapeDrawable(new RectShape());
      ((ShapeDrawable)localObject2).setShaderFactory(new bd(this));
      cmn.a.a().a(localRelativeLayout, (Drawable)localObject2);
      localObject2 = new ImageView(paramContext);
      ((ImageView)localObject2).setImageDrawable(new h(paramContext, parama.c));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(q.b(38.0F), q.b(38.0F));
      localLayoutParams.gravity = 17;
      localLayoutParams.leftMargin = q.b(4.0F);
      localLayoutParams.rightMargin = q.b(4.0F);
      localLinearLayout.addView((View)localObject2, localLayoutParams);
      localObject2 = new LinearLayout(paramContext);
      ((LinearLayout)localObject2).setOrientation(1);
      x localx = new x(paramContext);
      localx.setMaxLines(1);
      localx.setTypeface(localx.getTypeface(), 1);
      localx.setText(parama.a);
      localx.setTextSize(0, q.a(16.0F));
      localx.setTextColor(((at.g)localObject1).c);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout)localObject2).addView(localx, localLayoutParams);
      localx = new x(paramContext);
      localx.setMaxLines(1);
      localx.setText(parama.b);
      localx.setTextSize(0, q.a(13.0F));
      localx.setTextColor(((at.g)localObject1).c);
      ((LinearLayout)localObject2).addView(localx, localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 19;
      localLayoutParams.weight = 2.0F;
      localLayoutParams.topMargin = q.b(2.0F);
      localLayoutParams.leftMargin = q.b(4.0F);
      localLayoutParams.rightMargin = q.b(4.0F);
      localLayoutParams.bottomMargin = q.b(4.0F);
      localLinearLayout.addView((View)localObject2, localLayoutParams);
      localObject1 = at.a(paramContext, (at.g)localObject1, at.a(((at.g)localObject1).g), localLinearLayout);
      ((at.h)localObject1).c.setPadding(q.b(10.0F), 0, q.b(10.0F), 0);
      ((at.h)localObject1).b.getLayoutParams().width = q.b(50.0F);
      ((at.h)localObject1).b.getLayoutParams().height = q.b(50.0F);
      ((at.h)localObject1).a.setOnClickListener(parama.f);
      parama = new com.appbrain.d.a(new RectShape());
      parama.a().setColor(-10908144);
      parama.a().setStrokeWidth(q.b(1.0F));
      parama.setShaderFactory(new be(this));
      cmn.a.a().a(((at.h)localObject1).a, c.b(paramContext, parama));
      paramContext = new RelativeLayout.LayoutParams(-2, -1);
      paramContext.addRule(11);
      localRelativeLayout.addView(((at.h)localObject1).a, paramContext);
      return localRelativeLayout;
    }
  }
  
  public static final class g
  {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    
    public g()
    {
      this.a = -14474461;
      this.b = -13421773;
      this.c = -1;
      this.d = -14653729;
      this.e = -14653729;
      this.f = -14257944;
      this.g = -1;
    }
    
    public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
      this.g = paramInt7;
      this.h = paramInt8;
    }
  }
  
  private static final class h
  {
    LinearLayout a;
    ImageView b;
    TextView c;
  }
  
  public static final class i
    implements at.j
  {
    public final int a()
    {
      return 0;
    }
    
    public final View a(Context paramContext, at.a parama)
    {
      paramContext = new ImageView(paramContext);
      aa.a(paramContext, parama.d, new bf(this, paramContext, parama));
      return paramContext;
    }
  }
  
  public static abstract interface j
  {
    public abstract int a();
    
    public abstract View a(Context paramContext, at.a parama);
  }
  
  public static final class k
    implements at.e
  {
    public final View a(Context paramContext, at.d paramd)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      Object localObject1 = new x(paramContext);
      ((x)localObject1).setMaxLines(1);
      ((x)localObject1).setText(paramd.a);
      ((x)localObject1).setTextSize(13.0F);
      ((x)localObject1).setPadding(q.b(2.0F), q.b(2.0F), q.b(2.0F), 0);
      ((x)localObject1).setTextColor(paramd.c.c);
      int j = paramd.c.b;
      int i = j;
      if (j == paramd.c.a) {
        i = paramd.c.a & 0xFF000000 | (int)(0.95D * (paramd.c.a & 0xFF0000)) & 0xFF0000 | (int)(0.95D * (paramd.c.a & 0xFF00)) & 0xFF00 | (int)(0.95D * (paramd.c.a & 0xFF)) & 0xFF;
      }
      Object localObject2 = new bg(this, paramd.c.a, i, paramd);
      cmn.a.a().a(localLinearLayout, (Drawable)localObject2);
      localObject2 = new LinearLayout.LayoutParams(-2, q.b(20.0F));
      ((LinearLayout.LayoutParams)localObject2).gravity = 17;
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new Button(paramContext);
      localObject2 = new w(paramContext);
      i = 0;
      while (i < 2)
      {
        Button localButton = new Button[] { localObject2, localObject1 }[i];
        Object localObject3 = com.appbrain.d.a.a(paramContext, 0.5F, paramd.c.f);
        ((com.appbrain.d.a)localObject3).a().setStrokeWidth(q.a(1.0F));
        ((com.appbrain.d.a)localObject3).setShaderFactory(new bh(this, paramd));
        localObject3 = new InsetDrawable(c.b(paramContext, (Drawable)localObject3), 2);
        cmn.a.a().a(localButton, (Drawable)localObject3);
        at.a(localButton, paramd);
        localButton.setTextSize(12.0F);
        localButton.setPadding(q.b(4.0F), q.b(4.0F), q.b(4.0F), q.b(4.0F));
        i += 1;
      }
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.leftMargin = q.b(2.0F);
      paramContext.rightMargin = q.b(2.0F);
      paramContext.topMargin = 0;
      paramContext.bottomMargin = q.b(2.0F);
      paramContext.gravity = 17;
      localLinearLayout.addView((View)localObject2, paramContext);
      return at.a(localLinearLayout, (Button)localObject2, (Button)localObject1);
    }
  }
  
  public static final class l
    implements at.e
  {
    public final View a(Context paramContext, at.d paramd)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(0);
      Object localObject1 = new x(paramContext);
      ((x)localObject1).setMaxLines(2);
      ((x)localObject1).setText(paramd.a);
      ((x)localObject1).setTextSize(13.0F);
      ((x)localObject1).setPadding(6, 6, 6, 6);
      ((x)localObject1).setTextColor(paramd.c.c);
      cmn.a.a().a(localLinearLayout, new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramd.c.a, paramd.c.b }));
      Object localObject2 = new LinearLayout.LayoutParams(0, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 17;
      ((LinearLayout.LayoutParams)localObject2).weight = 2.0F;
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new Button(paramContext);
      localObject2 = new w(paramContext);
      int i = 0;
      while (i < 2)
      {
        Button localButton = new Button[] { localObject2, localObject1 }[i];
        Object localObject3 = com.appbrain.d.a.a(paramContext, 2.0F, paramd.c.f);
        ((com.appbrain.d.a)localObject3).setShaderFactory(new bi(this, paramd));
        localObject3 = c.b(paramContext, (Drawable)localObject3);
        cmn.a.a().a(localButton, (Drawable)localObject3);
        at.a(localButton, paramd);
        localButton.setTextSize(13.0F);
        localButton.setPadding(8, 8, 8, 8);
        i += 1;
      }
      paramContext = new LinearLayout.LayoutParams(0, -2);
      paramContext.weight = 1.0F;
      paramContext.leftMargin = 4;
      paramContext.rightMargin = 4;
      paramContext.topMargin = 4;
      paramContext.bottomMargin = 4;
      paramContext.gravity = 16;
      localLinearLayout.addView((View)localObject2, paramContext);
      localLinearLayout.setWeightSum(3.0F);
      return at.a(localLinearLayout, (Button)localObject2, (Button)localObject1);
    }
  }
  
  public static final class m
    implements at.e
  {
    public final View a(Context paramContext, at.d paramd)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(0);
      Object localObject1 = new x(paramContext);
      ((x)localObject1).setMaxLines(2);
      ((x)localObject1).setText(paramd.a);
      ((x)localObject1).setTextSize(13.0F);
      ((x)localObject1).setPadding(q.b(12.0F), q.b(6.0F), q.b(12.0F), q.b(6.0F));
      ((x)localObject1).setTextColor(paramd.c.c);
      ((x)localObject1).setTypeface(Typeface.SERIF);
      cmn.a.a().a(localLinearLayout, new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramd.c.a, paramd.c.b }));
      Object localObject2 = new LinearLayout.LayoutParams(0, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 17;
      ((LinearLayout.LayoutParams)localObject2).weight = 7.0F;
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new Button(paramContext);
      localObject2 = new w(paramContext);
      int i = 0;
      while (i < 2)
      {
        Button localButton = new Button[] { localObject2, localObject1 }[i];
        Object localObject3 = com.appbrain.d.a.a(paramContext, 0.5F, paramd.c.f);
        ((com.appbrain.d.a)localObject3).a().setStrokeWidth(q.a(3.0F));
        ((com.appbrain.d.a)localObject3).setShaderFactory(new bj(this, paramd));
        localObject3 = c.b(paramContext, (Drawable)localObject3);
        cmn.a.a().a(localButton, (Drawable)localObject3);
        at.a(localButton, paramd);
        localButton.setTextSize(13.0F);
        localButton.setPadding(q.b(6.0F), q.b(6.0F), q.b(6.0F), q.b(6.0F));
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(1);
      paramd = new LinearLayout.LayoutParams(-2, -2);
      paramd.gravity = 17;
      paramContext.addView((View)localObject2, paramd);
      paramd = new LinearLayout.LayoutParams(0, -2);
      paramd.weight = 3.0F;
      paramd.leftMargin = q.b(2.0F);
      paramd.rightMargin = q.b(2.0F);
      paramd.topMargin = q.b(2.0F);
      paramd.bottomMargin = q.b(2.0F);
      paramd.gravity = 17;
      localLinearLayout.addView(paramContext, paramd);
      localLinearLayout.setWeightSum(10.0F);
      return at.a(localLinearLayout, (Button)localObject2, (Button)localObject1);
    }
  }
  
  public static final class n
    implements at.j
  {
    public final int a()
    {
      return at.a().nextInt(at.a.length);
    }
    
    public final View a(Context paramContext, at.a parama)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = q.b(60.0F);
      Object localObject1 = new LinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(0);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      cmn.a.a().a(localRelativeLayout, new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { parama.e.a, parama.e.b }));
      localObject2 = new ImageView(paramContext);
      ((ImageView)localObject2).setImageDrawable(new h(paramContext, parama.c));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(q.b(40.0F), q.b(40.0F));
      localLayoutParams.gravity = 17;
      localLayoutParams.leftMargin = q.b(4.0F);
      localLayoutParams.rightMargin = q.b(4.0F);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localObject2 = new LinearLayout(paramContext);
      ((LinearLayout)localObject2).setOrientation(1);
      x localx = new x(paramContext);
      localx.setMaxLines(1);
      localx.setText(parama.a);
      localx.setTextSize(0, q.a(16.0F));
      localx.setTextColor(parama.e.c);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout)localObject2).addView(localx, localLayoutParams);
      localx = new x(paramContext);
      localx.setMaxLines(1);
      localx.setText(parama.b);
      localx.setTextSize(0, q.a(13.0F));
      localx.setTextColor(parama.e.c);
      ((LinearLayout)localObject2).addView(localx, localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 19;
      localLayoutParams.weight = 2.0F;
      localLayoutParams.leftMargin = q.b(4.0F);
      localLayoutParams.rightMargin = q.b(4.0F);
      localLayoutParams.topMargin = q.b(2.0F);
      localLayoutParams.bottomMargin = q.b(2.0F);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localObject1 = at.a(paramContext, parama.e, at.a(parama.e.g), (View)localObject1);
      ((at.h)localObject1).b.getLayoutParams().width = q.b(60.0F);
      ((at.h)localObject1).a.setOnClickListener(parama.f);
      localObject2 = new com.appbrain.d.a(new RectShape());
      ((com.appbrain.d.a)localObject2).a().setColor(at.c(parama.e.e));
      ((com.appbrain.d.a)localObject2).a().setStrokeWidth(q.b(1.0F));
      ((com.appbrain.d.a)localObject2).setShaderFactory(new bk(this, parama));
      cmn.a.a().a(((at.h)localObject1).a, c.b(paramContext, (Drawable)localObject2));
      paramContext = new RelativeLayout.LayoutParams(-2, -1);
      paramContext.addRule(11);
      ((at.h)localObject1).a.setLayoutParams(paramContext);
      localRelativeLayout.addView(((at.h)localObject1).a);
      return localRelativeLayout;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */