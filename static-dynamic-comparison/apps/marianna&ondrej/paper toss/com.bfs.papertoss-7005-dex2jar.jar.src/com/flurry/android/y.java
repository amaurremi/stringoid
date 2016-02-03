package com.flurry.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

final class y
  extends RelativeLayout
{
  private u a;
  private p b;
  private int c;
  
  public y(Context paramContext, u paramu, p paramp, e parame, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.a = paramu;
    this.b = paramp;
    paramu = paramp.b;
    this.c = paramInt;
    switch (this.c)
    {
    }
    for (;;)
    {
      setFocusable(true);
      return;
      if (paramBoolean) {
        a(paramContext, parame, paramu, false);
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label101;
        }
        a(paramContext, parame, paramu, false);
        break;
        a(paramContext, parame, paramu, true);
      }
      label101:
      a(paramContext, parame, paramu, true);
    }
  }
  
  private void a(Context paramContext, e parame, v paramv, boolean paramBoolean)
  {
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    c localc = parame.d;
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setId(1);
    parame = paramv.h;
    Object localObject1;
    if (parame != null)
    {
      parame = parame.e;
      localObject1 = BitmapFactory.decodeByteArray(parame, 0, parame.length);
      if (localObject1 == null) {
        ah.a("FlurryAgent", "Ad with bad image: " + paramv.d + ", data: " + parame);
      }
      if (localObject1 != null)
      {
        parame = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        Object localObject2 = new Canvas(parame);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        RectF localRectF = new RectF(localRect);
        float f = r.a(paramContext, 8);
        localPaint.setAntiAlias(true);
        ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
        localPaint.setColor(-16777216);
        ((Canvas)localObject2).drawRoundRect(localRectF, f, f, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        ((Canvas)localObject2).drawBitmap((Bitmap)localObject1, localRect, localRect, localPaint);
        if (Integer.parseInt(Build.VERSION.SDK) <= 4) {
          break label924;
        }
        localObject2 = new BlurMaskFilter(3.0F, BlurMaskFilter.Blur.OUTER);
        localObject1 = new Paint();
        ((Paint)localObject1).setMaskFilter((MaskFilter)localObject2);
        localObject2 = new int[2];
        localObject1 = parame.extractAlpha((Paint)localObject1, (int[])localObject2).copy(Bitmap.Config.ARGB_8888, true);
        new Canvas((Bitmap)localObject1).drawBitmap(parame, -localObject2[0], -localObject2[1], null);
        parame = (e)localObject1;
      }
    }
    label826:
    label924:
    for (;;)
    {
      localImageView.setImageBitmap(parame);
      r.a(paramContext, localImageView, r.a(paramContext, localc.m), r.a(paramContext, localc.n));
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      parame = this.a.a(localc.c);
      if (parame != null)
      {
        parame = parame.e;
        parame = BitmapFactory.decodeByteArray(parame, 0, parame.length);
        if (NinePatch.isNinePatchChunk(parame.getNinePatchChunk()))
        {
          parame = new NinePatchDrawable(parame, parame.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
          setBackgroundDrawable(parame);
        }
      }
      else
      {
        parame = new TextView(paramContext);
        parame.setId(5);
        parame.setPadding(0, 0, 0, 0);
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setId(3);
        ((TextView)localObject1).setPadding(0, 0, 0, 0);
        if (!paramBoolean) {
          break label826;
        }
        parame.setTextColor(localc.f);
        parame.setTextSize(localc.e);
        parame.setText(new String("• " + localc.b));
        parame.setTypeface(Typeface.create(localc.d, 0));
        ((TextView)localObject1).setTextColor(localc.i);
        ((TextView)localObject1).setTextSize(localc.h);
        ((TextView)localObject1).setTypeface(Typeface.create(localc.g, 0));
        ((TextView)localObject1).setText(paramv.d);
      }
      for (;;)
      {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        paramv = new RelativeLayout.LayoutParams(-1, -2);
        addView(new ImageView(paramContext), paramv);
        int i = localc.q;
        int j = localc.o;
        int k = localc.m;
        paramContext = new RelativeLayout.LayoutParams(-2, -2);
        paramContext.addRule(9);
        paramContext.setMargins(localc.o, localc.p, i - (j << 1) - k, 0);
        addView(localImageView, paramContext);
        paramContext = new RelativeLayout.LayoutParams(-2, -2);
        paramContext.addRule(6, localImageView.getId());
        paramContext.addRule(1, localImageView.getId());
        paramContext.setMargins(0, 0, 0, 0);
        addView(parame, paramContext);
        paramContext = new RelativeLayout.LayoutParams(-2, -2);
        paramContext.addRule(1, localImageView.getId());
        paramContext.addRule(3, parame.getId());
        paramContext.setMargins(0, -2, 0, 0);
        addView((View)localObject1, paramContext);
        return;
        parame = new BitmapDrawable(parame);
        break;
        parame.setId(3);
        parame.setText(paramv.d);
        parame.setTextColor(localc.i);
        parame.setTextSize(localc.h);
        parame.setTypeface(Typeface.create(localc.g, 0));
        ((TextView)localObject1).setId(4);
        ((TextView)localObject1).setText(paramv.c);
        ((TextView)localObject1).setTextColor(localc.l);
        ((TextView)localObject1).setTextSize(localc.k);
        ((TextView)localObject1).setTypeface(Typeface.create(localc.j, 0));
      }
    }
  }
  
  final p a()
  {
    return this.b;
  }
  
  final void a(p paramp)
  {
    this.b = paramp;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */