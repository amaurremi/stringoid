package com.skplanet.tad.v2.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.skplanet.tad.v2.content.a;

public class TextBannerView
  extends LinearLayout
{
  private static float i;
  public int[][] a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private RelativeLayout e;
  private LinearLayout f;
  private LinearLayout g;
  private RelativeLayout h;
  
  public TextBannerView(Context paramContext, a parama)
  {
    super(paramContext);
    Object localObject1 = { -526345, -4408132 };
    Object localObject2 = { -13290187, -16119286 };
    Object localObject3 = { 65254, -3097195 };
    int[] arrayOfInt1 = { -1209051, -4168922 };
    int[] arrayOfInt2 = { -4049348, -8053984 };
    int[] arrayOfInt3 = { -10766603, -13336912 };
    this.a = new int[][] { localObject1, localObject2, localObject3, arrayOfInt1, { 62197, -661782 }, arrayOfInt2, { -5935532, -10733786 }, { -1376272, -2691621 }, { -1509890, -5654590 }, arrayOfInt3, { -4168458, -8114504 } };
    this.b = new TextView(paramContext);
    this.c = new TextView(paramContext);
    this.d = new ImageView(paramContext);
    this.e = new RelativeLayout(paramContext);
    this.f = new LinearLayout(paramContext);
    this.g = new LinearLayout(paramContext);
    this.h = new RelativeLayout(paramContext);
    setOrientation(0);
    this.f.setOrientation(1);
    i = paramContext.getResources().getDisplayMetrics().density;
    this.b.setText(parama.j());
    this.b.setTextSize(1, 20.0F);
    this.b.setTextColor(parama.g());
    this.c.setText(parama.k());
    this.c.setTextSize(1, 15.0F);
    this.c.setTextColor(parama.h());
    this.c.setSelected(true);
    this.c.setSingleLine(true);
    this.c.setEnabled(true);
    this.c.setFocusable(true);
    this.c.setMarqueeRepeatLimit(-1);
    this.c.setHorizontallyScrolling(true);
    this.c.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    paramContext = new RelativeLayout.LayoutParams((int)(40.0F * i), (int)(40.0F * i));
    localObject1 = a(parama.q()[0], 10);
    this.d.setImageBitmap((Bitmap)localObject1);
    paramContext.setMargins(a(7), a(5), a(7), a(5));
    this.e.addView(this.d, paramContext);
    paramContext = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.a[parama.l()]);
    paramContext.setShape(0);
    paramContext.setGradientType(0);
    paramContext.setCornerRadius(0.0F);
    setBackgroundDrawable(paramContext);
    paramContext = new LinearLayout.LayoutParams((int)(53.0F * i), -1);
    parama = new LinearLayout.LayoutParams((int)(267.0F * i), -1);
    localObject2 = new LinearLayout.LayoutParams(-1, (int)(26.0F * i));
    localObject1 = new LinearLayout.LayoutParams(-1, (int)(24.0F * i));
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    this.g.addView(this.b, (ViewGroup.LayoutParams)localObject3);
    this.f.addView(this.g, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout.LayoutParams((int)(260.0F * i), -2);
    this.h.addView(this.c, (ViewGroup.LayoutParams)localObject2);
    this.f.addView(this.h, (ViewGroup.LayoutParams)localObject1);
    addView(this.e, paramContext);
    addView(this.f, parama);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    RectF localRectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    float f1 = paramInt;
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  public int a(int paramInt)
  {
    return (int)(paramInt * i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/view/TextBannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */