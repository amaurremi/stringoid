package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PixelXorXfermode;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.common.util.b;
import com.mobisystems.mobiscanner.common.util.h;
import com.mobisystems.mobiscanner.controller.ac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CropImageView
  extends RecyclingPhotoView
{
  private List<b> aDz;
  private List<Rect> aKA;
  private float aKB = 1.0F;
  private Drawable aKC;
  private int aKD = 0;
  private List<Point> aKE;
  private List<Point> aKF = new ArrayList(8);
  private List<Point> aKG = new ArrayList(4);
  private Matrix aKH = new Matrix();
  private float[] aKI = new float[9];
  private Rect aKJ = new Rect();
  private Bitmap aKK;
  private Canvas aKL;
  private Paint aKM;
  private Paint aKN;
  private Matrix aKO = new Matrix();
  private b aKP;
  private Matrix aKQ = new Matrix();
  private boolean aKR = false;
  private int aKS;
  private int aKT;
  private Paint aKU;
  private float aKV = 0.0F;
  private Paint aKW;
  private List<Point> aKX = new ArrayList(4);
  private int aKY = -1;
  private float[] aKZ = new float[8];
  private Paint aKy;
  private Paint aKz;
  private Matrix aLa = new Matrix();
  private float aLb;
  private boolean aLc = false;
  private float aLd = 0.0F;
  private Paint aLe;
  private Paint aLf;
  private Paint aLg;
  private boolean aLh;
  private Paint aLi;
  private int aLj = -1;
  private float aLk = 0.0F;
  private float aLl = 0.0F;
  private int aLm = 0;
  private int aLn = 0;
  private int aLo = -1;
  private int aLp = 0;
  private int aLq = 0;
  private float aLr;
  private ac axP;
  private final c mLog = new c(this);
  
  public CropImageView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private Paint JF()
  {
    if (this.aKy == null)
    {
      this.aKy = new Paint();
      this.aKy.setColor(Color.rgb(59, 213, 255));
      this.aKy.setTextSize(10.0F);
      this.aKy.setStrokeWidth(d.c(getContext(), 2));
      this.aKy.setAntiAlias(true);
    }
    return this.aKy;
  }
  
  private Paint JG()
  {
    if (this.aLi == null)
    {
      this.aLi = new Paint();
      this.aLi.setColor(Color.rgb(239, 228, 176));
      this.aLi.setTextSize(10.0F);
      this.aLi.setStrokeWidth(d.c(getContext(), 2));
      this.aLi.setAntiAlias(true);
    }
    return this.aLi;
  }
  
  private Paint JH()
  {
    if (this.aKN == null)
    {
      this.aKN = new Paint();
      this.aKN.setColor(Color.rgb(255, 255, 255));
      this.aKN.setStrokeWidth(d.c(getContext(), 2));
      this.aKN.setAntiAlias(true);
    }
    return this.aKN;
  }
  
  private Paint JI()
  {
    if (this.aLf == null)
    {
      this.aLf = new Paint();
      this.aLf.setColor(Color.rgb(59, 213, 255));
      this.aLf.setStrokeWidth(d.c(getContext(), 1));
      this.aLf.setAntiAlias(true);
    }
    return this.aLf;
  }
  
  private Paint JJ()
  {
    if (this.aLg == null)
    {
      this.aLg = new Paint();
      this.aLg.setColor(-1);
      this.aLg.setStyle(Paint.Style.STROKE);
      this.aLg.setStrokeWidth(d.c(getContext(), 2));
      this.aLg.setAntiAlias(true);
    }
    return this.aLg;
  }
  
  private Paint JK()
  {
    if (this.aLe == null)
    {
      this.aLe = new Paint();
      this.aLe.setColor(Color.rgb(255, 255, 255));
      this.aLe.setStrokeWidth(d.c(getContext(), 1));
      this.aLe.setAntiAlias(true);
    }
    return this.aLe;
  }
  
  private Paint JL()
  {
    if (this.aKM == null)
    {
      this.aKM = new Paint();
      this.aKM.setXfermode(new PixelXorXfermode(-1));
      this.aKM.setAntiAlias(true);
      this.aKM.setStyle(Paint.Style.STROKE);
      this.aKM.setStrokeWidth(d.c(getContext(), 1));
    }
    return this.aKM;
  }
  
  private Paint JM()
  {
    if (this.aKW == null)
    {
      this.aKW = new Paint();
      this.aKW.setAntiAlias(true);
      this.aKW.setStyle(Paint.Style.STROKE);
      this.aKW.setStrokeWidth(d.c(getContext(), 1));
      this.aKW.setColor(Color.rgb(0, 0, 0));
      this.aKW.setAntiAlias(true);
    }
    return this.aKW;
  }
  
  private Paint JN()
  {
    if (this.aKz == null)
    {
      this.aKz = new Paint();
      this.aKz.setColor(Color.rgb(0, 255, 0));
      this.aKz.setStrokeWidth(d.c(getContext(), 1));
      this.aKz.setAntiAlias(true);
    }
    return this.aKz;
  }
  
  private Paint JO()
  {
    if (this.aKU == null)
    {
      this.aKU = new Paint();
      int i = getResources().getColor(2131427368);
      this.aKU.setColor(i);
      this.aKU.setAntiAlias(true);
    }
    return this.aKU;
  }
  
  private Drawable JP()
  {
    if (this.aKC == null)
    {
      this.aKC = getContext().getResources().getDrawable(2130837660);
      this.aKD = (d.c(getContext(), 30) / 2);
    }
    return this.aKC;
  }
  
  private void JQ()
  {
    this.aKF.clear();
    int i = 0;
    while (i < 4)
    {
      this.aKF.add(i, new Point((Point)this.aKE.get(i)));
      i += 1;
    }
    JS();
    invalidate();
  }
  
  private void JS()
  {
    if (this.aKF.size() > 4)
    {
      JU();
      return;
    }
    JT();
  }
  
  private void JT()
  {
    List localList = this.aKF;
    int i = ((Point)this.aKF.get(0)).x;
    i = (((Point)this.aKF.get(1)).x + i) / 2;
    int j = ((Point)this.aKF.get(0)).y;
    localList.add(4, new Point(i, (((Point)this.aKF.get(1)).y + j) / 2));
    localList = this.aKF;
    i = ((Point)this.aKF.get(1)).x;
    i = (((Point)this.aKF.get(2)).x + i) / 2;
    j = ((Point)this.aKF.get(1)).y;
    localList.add(5, new Point(i, (((Point)this.aKF.get(2)).y + j) / 2));
    localList = this.aKF;
    i = ((Point)this.aKF.get(2)).x;
    i = (((Point)this.aKF.get(3)).x + i) / 2;
    j = ((Point)this.aKF.get(2)).y;
    localList.add(6, new Point(i, (((Point)this.aKF.get(3)).y + j) / 2));
    localList = this.aKF;
    i = ((Point)this.aKF.get(3)).x;
    i = (((Point)this.aKF.get(0)).x + i) / 2;
    j = ((Point)this.aKF.get(3)).y;
    localList.add(7, new Point(i, (((Point)this.aKF.get(0)).y + j) / 2));
  }
  
  private void JU()
  {
    List localList = this.aKF;
    int i = ((Point)this.aKF.get(0)).x;
    i = (((Point)this.aKF.get(1)).x + i) / 2;
    int j = ((Point)this.aKF.get(0)).y;
    localList.set(4, new Point(i, (((Point)this.aKF.get(1)).y + j) / 2));
    localList = this.aKF;
    i = ((Point)this.aKF.get(1)).x;
    i = (((Point)this.aKF.get(2)).x + i) / 2;
    j = ((Point)this.aKF.get(1)).y;
    localList.set(5, new Point(i, (((Point)this.aKF.get(2)).y + j) / 2));
    localList = this.aKF;
    i = ((Point)this.aKF.get(2)).x;
    i = (((Point)this.aKF.get(3)).x + i) / 2;
    j = ((Point)this.aKF.get(2)).y;
    localList.set(6, new Point(i, (((Point)this.aKF.get(3)).y + j) / 2));
    localList = this.aKF;
    i = ((Point)this.aKF.get(3)).x;
    i = (((Point)this.aKF.get(0)).x + i) / 2;
    j = ((Point)this.aKF.get(3)).y;
    localList.set(7, new Point(i, (((Point)this.aKF.get(0)).y + j) / 2));
  }
  
  private boolean JX()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return true;
    }
    float f1 = this.aKI[2];
    float f2 = this.aKI[5];
    float f3 = this.aKI[0];
    float f4 = this.aKI[4];
    ac.q(this.aKE);
    float f5 = ((Point)this.aKE.get(0)).x;
    float f6 = this.aKB;
    float f7 = ((Point)this.aKE.get(0)).y;
    float f8 = this.aKB;
    float f9 = ((Point)this.aKE.get(1)).x;
    float f10 = this.aKB;
    float f11 = ((Point)this.aKE.get(1)).y;
    float f12 = this.aKB;
    float f13 = ((Point)this.aKE.get(2)).x;
    float f14 = this.aKB;
    float f15 = ((Point)this.aKE.get(2)).y;
    float f16 = this.aKB;
    float f17 = ((Point)this.aKE.get(3)).x;
    float f18 = this.aKB;
    float f19 = ((Point)this.aKE.get(3)).y;
    float f20 = this.aKB;
    float[] arrayOfFloat = b(d.a(this.axP, t(this.aKE)));
    Matrix localMatrix = new Matrix();
    localMatrix.setPolyToPoly(new float[] { f5 * f6 * f3 + f1, f7 * f8 * f4 + f2, f9 * f10 * f3 + f1, f11 * f12 * f4 + f2, f13 * f14 * f3 + f1, f15 * f16 * f4 + f2, f17 * f18 * f3 + f1, f19 * f20 * f4 + f2 }, 0, arrayOfFloat, 0, 4);
    boolean bool = d.a(localMatrix, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.aLh = bool;
    return bool;
  }
  
  private void O(int paramInt1, int paramInt2)
  {
    Object localObject1 = getDrawable();
    if ((localObject1 instanceof BitmapDrawable))
    {
      float f1 = this.aKI[0];
      int i = (int)(d.c(getContext(), 100) / f1);
      if (this.aKK == null)
      {
        this.aKK = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        this.aKL = new Canvas(this.aKK);
      }
      this.aKL.drawARGB(0, 0, 0, 0);
      Object localObject2 = ((BitmapDrawable)localObject1).getBitmap();
      localObject1 = new Path();
      ((Path)localObject1).addCircle(this.aKK.getWidth() / 2, this.aKK.getHeight() / 2, this.aKK.getWidth() / 2, Path.Direction.CW);
      this.aKL.clipPath((Path)localObject1);
      this.aKL.drawARGB(255, 0, 0, 0);
      int j = (int)(paramInt1 * this.aKB - i / 2);
      int k = (int)(paramInt2 * this.aKB - i / 2);
      int m = (int)(paramInt1 * this.aKB + i / 2);
      int n = (int)(paramInt2 * this.aKB + i / 2);
      Rect localRect = new Rect(Math.max(0, j), Math.max(0, k), Math.min(((Bitmap)localObject2).getWidth(), m), Math.min(((Bitmap)localObject2).getHeight(), n));
      int i1 = localRect.left;
      int i2 = localRect.top;
      int i3 = localRect.right;
      int i4 = localRect.bottom;
      localObject1 = null;
      float f2;
      float f3;
      float f4;
      if (this.aLj < 4)
      {
        this.aKL.drawBitmap((Bitmap)localObject2, localRect, new Rect(i1 - j, i2 - k, this.aKK.getWidth() - (m - i3), this.aKK.getHeight() - (n - i4)), (Paint)localObject1);
        paramInt1 = (int)(paramInt1 * this.aKB - i / 2);
        paramInt2 = (int)(paramInt2 * this.aKB - i / 2);
        i = (int)(((Point)this.aKF.get(0)).x * this.aKB - paramInt1);
        j = (int)(((Point)this.aKF.get(0)).y * this.aKB - paramInt2);
        k = (int)(((Point)this.aKF.get(1)).x * this.aKB - paramInt1);
        m = (int)(((Point)this.aKF.get(1)).y * this.aKB - paramInt2);
        n = (int)(((Point)this.aKF.get(2)).x * this.aKB - paramInt1);
        i1 = (int)(((Point)this.aKF.get(2)).y * this.aKB - paramInt2);
        i2 = (int)(((Point)this.aKF.get(3)).x * this.aKB - paramInt1);
        i3 = (int)(((Point)this.aKF.get(3)).y * this.aKB - paramInt2);
        localObject2 = this.aKL;
        f1 = i;
        f2 = j;
        f3 = k;
        f4 = m;
        if ((this.aLj != 0) && (this.aLj != 1) && (this.aLj != 4)) {
          break label1128;
        }
        localObject1 = JK();
        label674:
        ((Canvas)localObject2).drawLine(f1, f2, f3, f4, (Paint)localObject1);
        localObject2 = this.aKL;
        f1 = k;
        f2 = m;
        f3 = n;
        f4 = i1;
        if ((this.aLj != 1) && (this.aLj != 2) && (this.aLj != 5)) {
          break label1137;
        }
        localObject1 = JK();
        label745:
        ((Canvas)localObject2).drawLine(f1, f2, f3, f4, (Paint)localObject1);
        localObject2 = this.aKL;
        f1 = n;
        f2 = i1;
        f3 = i2;
        f4 = i3;
        if ((this.aLj != 2) && (this.aLj != 3) && (this.aLj != 6)) {
          break label1146;
        }
        localObject1 = JK();
        label817:
        ((Canvas)localObject2).drawLine(f1, f2, f3, f4, (Paint)localObject1);
        localObject2 = this.aKL;
        f1 = i2;
        f2 = i3;
        f3 = i;
        f4 = j;
        if ((this.aLj != 3) && (this.aLj != 0) && (this.aLj != 7)) {
          break label1155;
        }
      }
      label1128:
      label1137:
      label1146:
      label1155:
      for (localObject1 = JK();; localObject1 = JI())
      {
        ((Canvas)localObject2).drawLine(f1, f2, f3, f4, (Paint)localObject1);
        if ((this.aDz == null) || (this.aLj <= 3)) {
          break label1164;
        }
        localObject1 = this.aDz.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (b)((Iterator)localObject1).next();
          double d1 = ((b)localObject2).DR();
          double d2 = this.aKB;
          double d3 = paramInt1;
          double d4 = ((b)localObject2).DQ();
          double d5 = this.aKB;
          double d6 = paramInt2;
          double d7 = ((b)localObject2).DP();
          double d8 = this.aKB;
          double d9 = paramInt1;
          double d10 = ((b)localObject2).DO();
          double d11 = this.aKB;
          double d12 = paramInt2;
          localObject2 = new float[4];
          localObject2[0] = ((float)(d1 * d2 - d3));
          localObject2[1] = ((float)(d4 * d5 - d6));
          localObject2[2] = ((float)(d7 * d8 - d9));
          localObject2[3] = ((float)(d10 * d11 - d12));
          this.aKL.drawLine(localObject2[0], localObject2[1], localObject2[2], localObject2[3], JN());
        }
        localObject1 = new Paint();
        ((Paint)localObject1).setAlpha(128);
        break;
        localObject1 = JI();
        break label674;
        localObject1 = JI();
        break label745;
        localObject1 = JI();
        break label817;
      }
      label1164:
      this.aKL.drawCircle(this.aKK.getWidth() / 2, this.aKK.getHeight() / 2, this.aKK.getWidth() / 2, JJ());
      this.aKL.drawLine(this.aKK.getWidth() / 2 - 10, this.aKK.getHeight() / 2, this.aKK.getWidth() / 2 + 10, this.aKK.getHeight() / 2, JH());
      this.aKL.drawLine(this.aKK.getWidth() / 2, this.aKK.getHeight() / 2 - 10, this.aKK.getWidth() / 2, this.aKK.getHeight() / 2 + 10, JH());
    }
  }
  
  private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if (paramDouble3 / paramDouble1 * paramDouble2 < paramDouble4) {
      return paramDouble3 / paramDouble1;
    }
    return paramDouble4 / paramDouble2;
  }
  
  private float[] a(float[] paramArrayOfFloat, double paramDouble, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = ((float)(paramArrayOfFloat[i] * paramDouble + paramInt1));
      arrayOfFloat[(i + 1)] = ((float)(paramArrayOfFloat[(i + 1)] * paramDouble + paramInt2));
      i += 2;
    }
    return arrayOfFloat;
  }
  
  private float[] b(float[] paramArrayOfFloat)
  {
    int m = (int)Math.abs(paramArrayOfFloat[0] - paramArrayOfFloat[2]);
    int k = (int)Math.abs(paramArrayOfFloat[1] - paramArrayOfFloat[7]);
    int i = getWidth();
    int j = getHeight();
    double d = a(m, k, i, j);
    m = (int)(m * d);
    k = (int)(k * d);
    this.aKS = ((i - m) / 2);
    this.aKT = ((j - k) / 2);
    return a(paramArrayOfFloat, d, this.aKS, this.aKT);
  }
  
  private void bu(boolean paramBoolean)
  {
    float f1 = this.aKI[2];
    float f2 = this.aKI[5];
    float f3 = this.aKI[0];
    float f4 = this.aKI[4];
    ac.q(this.aKE);
    float f5 = ((Point)this.aKE.get(0)).x;
    float f6 = this.aKB;
    float f7 = ((Point)this.aKE.get(0)).y;
    float f8 = this.aKB;
    float f9 = ((Point)this.aKE.get(1)).x;
    float f10 = this.aKB;
    float f11 = ((Point)this.aKE.get(1)).y;
    float f12 = this.aKB;
    float f13 = ((Point)this.aKE.get(2)).x;
    float f14 = this.aKB;
    float f15 = ((Point)this.aKE.get(2)).y;
    float f16 = this.aKB;
    float f17 = ((Point)this.aKE.get(3)).x;
    float f18 = this.aKB;
    float f19 = ((Point)this.aKE.get(3)).y;
    float f20 = this.aKB;
    if ((paramBoolean) && (this.aLd > 0.0F)) {}
    for (this.aKZ = d.b(this.aLd, 100);; this.aKZ = d.a(this.axP, t(this.aKE)))
    {
      this.aKZ = b(this.aKZ);
      Object localObject = this.aKZ;
      localObject = new a(new float[] { f5 * f6 * f3 + f1, f7 * f8 * f4 + f2, f9 * f10 * f3 + f1, f11 * f12 * f4 + f2, f13 * f14 * f3 + f1, f15 * f16 * f4 + f2, f17 * f18 * f3 + f1, f19 * f20 * f4 + f2 }, (float[])localObject, paramBoolean);
      ((a)localObject).setDuration(500L);
      startAnimation((Animation)localObject);
      return;
    }
  }
  
  private void init(Context paramContext)
  {
    this.aKC = paramContext.getResources().getDrawable(2130837660);
    this.aLb = paramContext.getResources().getDisplayMetrics().density;
    this.aKD = (d.c(paramContext, 30) / 2);
    int i = 0;
    while (i < 4)
    {
      this.aKX.add(new Point());
      this.aKG.add(new Point());
      i += 1;
    }
  }
  
  private List<Point> t(List<Point> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new Point((Point)paramList.next()));
    }
    return localArrayList;
  }
  
  public void C(float paramFloat)
  {
    this.aLd = paramFloat;
  }
  
  public void GY()
  {
    this.aKE = new ArrayList(4);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      int i = localDrawable.getIntrinsicWidth();
      int j = localDrawable.getIntrinsicHeight();
      this.aKE.add(new Point(0, 0));
      this.aKE.add(new Point((int)(i / this.aKB), 0));
      this.aKE.add(new Point((int)(i / this.aKB), (int)(j / this.aKB)));
      this.aKE.add(new Point(0, (int)(j / this.aKB)));
      JQ();
      if (this.aKP != null) {
        this.aKP.r(this.aKE);
      }
    }
    this.aLh = true;
  }
  
  public List<Point> JR()
  {
    return this.aKE;
  }
  
  public boolean JV()
  {
    if (!JX())
    {
      Toast.makeText(getContext(), 2131296985, 0).show();
      return false;
    }
    clearAnimation();
    this.aKV = 0.0F;
    JM().setAlpha(0);
    this.aKR = true;
    bu(true);
    return true;
  }
  
  public void JW()
  {
    clearAnimation();
    this.aKR = false;
    this.aKV = 1.0F;
    bu(false);
    invalidate();
  }
  
  public void T(float paramFloat)
  {
    this.aKB = paramFloat;
    this.mLog.dl("setResultScale = " + this.aKB);
  }
  
  public void a(b paramb)
  {
    this.aKP = paramb;
  }
  
  public void e(h paramh)
  {
    if (paramh == null) {}
    do
    {
      return;
      this.aKE = new ArrayList(4);
      int i = 0;
      while (i < 4)
      {
        this.aKE.add(i, new Point((Point)paramh.vh().get(i)));
        i += 1;
      }
      JQ();
      if (this.aKP != null) {
        this.aKP.r(this.aKE);
      }
    } while (JX());
    Toast.makeText(getContext(), 2131296985, 0).show();
  }
  
  public void f(h paramh)
  {
    float f1 = this.aKI[2];
    float f2 = this.aKI[5];
    float f3 = this.aKI[0];
    float f4 = this.aKI[4];
    paramh = paramh.vh();
    int i = 0;
    while (i < paramh.size())
    {
      ((Point)this.aKE.get(i)).set(((Point)paramh.get(i)).x, ((Point)paramh.get(i)).y);
      i += 1;
    }
    JQ();
    ac.q(this.aKE);
    float f5 = ((Point)this.aKE.get(0)).x;
    float f6 = this.aKB;
    float f7 = ((Point)this.aKE.get(0)).y;
    float f8 = this.aKB;
    float f9 = ((Point)this.aKE.get(1)).x;
    float f10 = this.aKB;
    float f11 = ((Point)this.aKE.get(1)).y;
    float f12 = this.aKB;
    float f13 = ((Point)this.aKE.get(2)).x;
    float f14 = this.aKB;
    float f15 = ((Point)this.aKE.get(2)).y;
    float f16 = this.aKB;
    float f17 = ((Point)this.aKE.get(3)).x;
    float f18 = this.aKB;
    float f19 = ((Point)this.aKE.get(3)).y;
    float f20 = this.aKB;
    ac.q(paramh);
    paramh = t(paramh);
    this.aKZ = this.axP.n(paramh);
    this.mLog.dl("resetQuad before dst  = " + Arrays.toString(this.aKZ));
    this.aKZ = b(this.aKZ);
    paramh = this.aKQ;
    float[] arrayOfFloat = this.aKZ;
    paramh.setPolyToPoly(new float[] { f5 * f6 * f3 + f1, f7 * f8 * f4 + f2, f9 * f10 * f3 + f1, f11 * f12 * f4 + f2, f13 * f14 * f3 + f1, f15 * f16 * f4 + f2, f17 * f18 * f3 + f1, f19 * f20 * f4 + f2 }, 0, arrayOfFloat, 0, 4);
    invalidate();
  }
  
  public void i(ac paramac)
  {
    this.axP = paramac;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    paramCanvas.concat(this.aKQ);
    super.onDraw(paramCanvas);
    if (this.aKF.size() == 0)
    {
      this.aKH.set(getImageMatrix());
      this.aKH.getValues(this.aKI);
      paramCanvas.restoreToCount(i);
      return;
    }
    paramCanvas.restoreToCount(i);
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    int j = paramCanvas.getHeight();
    int m = paramCanvas.getWidth();
    float f1 = this.aKS;
    paramCanvas.drawRect(0.0F, 0.0F, this.aKV * f1, j, JO());
    paramCanvas.drawRect(m - this.aKS * this.aKV, 0.0F, m, j, JO());
    f1 = m;
    float f2 = this.aKT;
    paramCanvas.drawRect(0.0F, 0.0F, f1, this.aKV * f2, JO());
    paramCanvas.drawRect(0.0F, j - this.aKT * this.aKV, m, getHeight(), JO());
    int n;
    int i2;
    int i1;
    if (this.aKR) {
      if (this.aLc)
      {
        n = d.c(getContext(), 20);
        i2 = (m - this.aKS * 2) / 2 + this.aKS;
        i1 = (j - this.aKT * 2) / 2 + this.aKT;
        paramCanvas.drawLine(i2, this.aKT, i2, j - this.aKT, JM());
        paramCanvas.drawLine(this.aKS, i1, m - this.aKS, i1, JM());
        i = 1;
        while (n * i + i2 < m - this.aKS)
        {
          paramCanvas.drawLine(n * i + i2, this.aKT, n * i + i2, j - this.aKT, JM());
          paramCanvas.drawLine(i2 - n * i, this.aKT, i2 - n * i, j - this.aKT, JM());
          i += 1;
        }
        i = 1;
        while (n * i + i1 < j - this.aKT)
        {
          paramCanvas.drawLine(this.aKS, n * i + i1, m - this.aKS, n * i + i1, JM());
          paramCanvas.drawLine(this.aKS, i1 - n * i, m - this.aKS, i1 - n * i, JM());
          i += 1;
        }
        paramCanvas.drawLine(this.aKS, this.aKT, m - this.aKS, this.aKT, JM());
        paramCanvas.drawLine(m - this.aKS, this.aKT, m - this.aKS, j - this.aKT, JM());
        paramCanvas.drawLine(this.aKS, j - this.aKT, m - this.aKS, j - this.aKT, JM());
        paramCanvas.drawLine(this.aKS, j - this.aKT, this.aKS, this.aKT, JM());
        i = (m - this.aKS * 2) / 3;
        i = this.aKS + i;
        n = (j - this.aKT * 2) / 3;
        n = this.aKT + n;
        m = (m - this.aKS * 2) * 2 / 3;
        m = this.aKS + m;
        j = (j - this.aKT * 2) * 2 / 3;
        j = this.aKT + j;
        ((Point)this.aKX.get(0)).x = i;
        ((Point)this.aKX.get(0)).y = n;
        ((Point)this.aKX.get(1)).x = m;
        ((Point)this.aKX.get(1)).y = n;
        ((Point)this.aKX.get(2)).x = i;
        ((Point)this.aKX.get(2)).y = j;
        ((Point)this.aKX.get(3)).x = m;
        ((Point)this.aKX.get(3)).y = j;
      }
    }
    int i3;
    int i4;
    int i5;
    int i6;
    do
    {
      do
      {
        paramCanvas.restoreToCount(k);
        return;
        i = 0;
        while (i <= 3)
        {
          n = (m - this.aKS * 2) * i / 3 + this.aKS;
          paramCanvas.drawLine(n, this.aKT, n, j - this.aKT, JM());
          n = (j - this.aKT * 2) * i / 3 + this.aKT;
          paramCanvas.drawLine(this.aKS, n, m - this.aKS, n, JM());
          i += 1;
        }
        break;
      } while (this.aKV > 0.0F);
      this.aKH.set(getImageMatrix());
      this.aKH.getValues(this.aKI);
      paramCanvas.concat(this.aKH);
      f1 = this.aKI[0];
      paramCanvas.getClipBounds(this.aKJ);
      this.aKJ.inset(-this.aKD, -this.aKD);
      paramCanvas.clipRect(this.aKJ, Region.Op.REPLACE);
      m = (int)(((Point)this.aKF.get(0)).x * this.aKB);
      n = (int)(((Point)this.aKF.get(0)).y * this.aKB);
      i1 = (int)(((Point)this.aKF.get(1)).x * this.aKB);
      i2 = (int)(((Point)this.aKF.get(1)).y * this.aKB);
      i3 = (int)(((Point)this.aKF.get(2)).x * this.aKB);
      i4 = (int)(((Point)this.aKF.get(2)).y * this.aKB);
      i5 = (int)(((Point)this.aKF.get(3)).x * this.aKB);
      i6 = (int)(((Point)this.aKF.get(3)).y * this.aKB);
    } while ((this.aKF == null) || (this.aKF.size() <= 0));
    f2 = m;
    float f3 = n;
    float f4 = i1;
    float f5 = i2;
    Object localObject;
    if (this.aLh) {
      if ((this.aLj == 0) || (this.aLj == 1) || (this.aLj == 4))
      {
        localObject = JH();
        label1383:
        paramCanvas.drawLine(f2, f3, f4, f5, (Paint)localObject);
        f2 = i1;
        f3 = i2;
        f4 = i3;
        f5 = i4;
        if (!this.aLh) {
          break label2114;
        }
        if ((this.aLj != 1) && (this.aLj != 2) && (this.aLj != 5)) {
          break label2105;
        }
        localObject = JH();
        label1452:
        paramCanvas.drawLine(f2, f3, f4, f5, (Paint)localObject);
        f2 = i3;
        f3 = i4;
        f4 = i5;
        f5 = i6;
        if (!this.aLh) {
          break label2132;
        }
        if ((this.aLj != 2) && (this.aLj != 3) && (this.aLj != 6)) {
          break label2123;
        }
        localObject = JH();
        label1522:
        paramCanvas.drawLine(f2, f3, f4, f5, (Paint)localObject);
        f2 = i5;
        f3 = i6;
        f4 = m;
        f5 = n;
        if (!this.aLh) {
          break label2150;
        }
        if ((this.aLj != 3) && (this.aLj != 0) && (this.aLj != 7)) {
          break label2141;
        }
        localObject = JH();
      }
    }
    for (;;)
    {
      paramCanvas.drawLine(f2, f3, f4, f5, (Paint)localObject);
      if (this.aLj >= 0) {
        break label2159;
      }
      localObject = JP();
      if (localObject == null) {
        break;
      }
      i = (int)(this.aKD / f1);
      ((Drawable)localObject).setBounds(m - i, n - i, m + i, n + i);
      ((Drawable)localObject).draw(paramCanvas);
      ((Drawable)localObject).setBounds(i1 - i, i2 - i, i1 + i, i2 + i);
      ((Drawable)localObject).draw(paramCanvas);
      ((Drawable)localObject).setBounds(i3 - i, i4 - i, i3 + i, i4 + i);
      ((Drawable)localObject).draw(paramCanvas);
      ((Drawable)localObject).setBounds(i5 - i, i6 - i, i5 + i, i6 + i);
      ((Drawable)localObject).draw(paramCanvas);
      j = (int)(((Point)this.aKF.get(4)).x * this.aKB);
      m = (int)(((Point)this.aKF.get(4)).y * this.aKB);
      n = (int)(((Point)this.aKF.get(5)).x * this.aKB);
      i1 = (int)(((Point)this.aKF.get(5)).y * this.aKB);
      i2 = (int)(((Point)this.aKF.get(6)).x * this.aKB);
      i3 = (int)(((Point)this.aKF.get(6)).y * this.aKB);
      i4 = (int)(((Point)this.aKF.get(7)).x * this.aKB);
      i5 = (int)(((Point)this.aKF.get(7)).y * this.aKB);
      ((Drawable)localObject).setBounds(j - i, m - i, j + i, m + i);
      ((Drawable)localObject).draw(paramCanvas);
      ((Drawable)localObject).setBounds(n - i, i1 - i, n + i, i1 + i);
      ((Drawable)localObject).draw(paramCanvas);
      ((Drawable)localObject).setBounds(i2 - i, i3 - i, i2 + i, i3 + i);
      ((Drawable)localObject).draw(paramCanvas);
      ((Drawable)localObject).setBounds(i4 - i, i5 - i, i4 + i, i5 + i);
      ((Drawable)localObject).draw(paramCanvas);
      break;
      localObject = JF();
      break label1383;
      localObject = JG();
      break label1383;
      label2105:
      localObject = JF();
      break label1452;
      label2114:
      localObject = JG();
      break label1452;
      label2123:
      localObject = JF();
      break label1522;
      label2132:
      localObject = JG();
      break label1522;
      label2141:
      localObject = JF();
      continue;
      label2150:
      localObject = JG();
    }
    for (;;)
    {
      try
      {
        label2159:
        localObject = this.axP.n(new ArrayList(this.aKF.subList(0, 4)));
        f1 = (float)(d.a(localObject[0], localObject[1], localObject[2], localObject[3]) / d.a(localObject[2], localObject[3], localObject[4], localObject[5]));
        if (d.a((float[])localObject)) {
          break;
        }
        throw new RuntimeException();
      }
      catch (RuntimeException localRuntimeException)
      {
        i = 1;
        if (i >= 3) {
          break label3565;
        }
      }
      paramCanvas.drawLine((i1 - m) * i / 3 + m, (i2 - n) * i / 3 + n, (i3 - i5) * i / 3 + i5, (i4 - i6) * i / 3 + i6, JL());
      paramCanvas.drawLine((i5 - m) * i / 3 + m, (i6 - n) * i / 3 + n, (i3 - i1) * i / 3 + i1, (i4 - i2) * i / 3 + i2, JL());
      i += 1;
    }
    f2 = ((Point)this.aKF.get(0)).x;
    f3 = ((Point)this.aKF.get(0)).y;
    f4 = ((Point)this.aKF.get(1)).x;
    f5 = ((Point)this.aKF.get(1)).y;
    float f6 = ((Point)this.aKF.get(2)).x;
    float f7 = ((Point)this.aKF.get(2)).y;
    float f8 = ((Point)this.aKF.get(3)).x;
    float f9 = ((Point)this.aKF.get(3)).y;
    this.aKO.reset();
    this.aKO.setPolyToPoly(localRuntimeException, 0, new float[] { f2, f3, f4, f5, f6, f7, f8, f9 }, 0, 4);
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = localRuntimeException[0];
    arrayOfFloat[1] = localRuntimeException[1];
    arrayOfFloat[2] = localRuntimeException[2];
    arrayOfFloat[3] = localRuntimeException[3];
    arrayOfFloat[4] = localRuntimeException[4];
    arrayOfFloat[5] = localRuntimeException[5];
    arrayOfFloat[6] = localRuntimeException[6];
    arrayOfFloat[7] = localRuntimeException[7];
    arrayOfFloat[0] = ((localRuntimeException[2] + localRuntimeException[0]) / 2.0F);
    arrayOfFloat[1] = ((localRuntimeException[1] + localRuntimeException[3]) / 2.0F - 0);
    arrayOfFloat[2] = ((localRuntimeException[6] + localRuntimeException[4]) / 2.0F);
    arrayOfFloat[3] = ((localRuntimeException[7] + localRuntimeException[5]) / 2.0F + 0);
    this.aKO.mapPoints(arrayOfFloat);
    paramCanvas.drawLine(arrayOfFloat[0] * this.aKB, arrayOfFloat[1] * this.aKB, arrayOfFloat[2] * this.aKB, arrayOfFloat[3] * this.aKB, JL());
    i = d.c(getContext(), 10);
    if (f1 > 1.0F) {
      i = (int)(i * f1);
    }
    for (;;)
    {
      int i7 = (int)((localRuntimeException[2] + localRuntimeException[0]) / 2.0F);
      j = 1;
      while (i * j + i7 < localRuntimeException[2])
      {
        arrayOfFloat[0] = (i * j + i7);
        localRuntimeException[1] -= 0;
        arrayOfFloat[2] = (i * j + i7);
        arrayOfFloat[3] = (localRuntimeException[7] + 0);
        this.aKO.mapPoints(arrayOfFloat);
        f2 = arrayOfFloat[0];
        f3 = this.aKB;
        f4 = arrayOfFloat[1];
        f5 = this.aKB;
        f6 = arrayOfFloat[2];
        f7 = this.aKB;
        f8 = arrayOfFloat[3];
        paramCanvas.drawLine(f3 * f2, f5 * f4, f7 * f6, this.aKB * f8, JL());
        arrayOfFloat[0] = (i7 - i * j);
        localRuntimeException[1] -= 0;
        arrayOfFloat[2] = (i7 - i * j);
        arrayOfFloat[3] = (localRuntimeException[7] + 0);
        this.aKO.mapPoints(arrayOfFloat);
        f2 = arrayOfFloat[0];
        f3 = this.aKB;
        f4 = arrayOfFloat[1];
        f5 = this.aKB;
        f6 = arrayOfFloat[2];
        f7 = this.aKB;
        f8 = arrayOfFloat[3];
        paramCanvas.drawLine(f3 * f2, f5 * f4, f7 * f6, this.aKB * f8, JL());
        j += 1;
      }
      arrayOfFloat[0] = ((localRuntimeException[0] + localRuntimeException[6]) / 2.0F - 0);
      arrayOfFloat[1] = ((localRuntimeException[7] + localRuntimeException[1]) / 2.0F);
      arrayOfFloat[2] = ((localRuntimeException[4] + localRuntimeException[2]) / 2.0F + 0);
      arrayOfFloat[3] = ((localRuntimeException[3] + localRuntimeException[5]) / 2.0F);
      this.aKO.mapPoints(arrayOfFloat);
      paramCanvas.drawLine(arrayOfFloat[0] * this.aKB, arrayOfFloat[1] * this.aKB, arrayOfFloat[2] * this.aKB, arrayOfFloat[3] * this.aKB, JL());
      i = d.c(getContext(), 10);
      if (f1 < 1.0F) {
        i = (int)(i / f1);
      }
      for (;;)
      {
        i7 = (int)((localRuntimeException[5] + localRuntimeException[1]) / 2.0F);
        j = 1;
        while (i * j + i7 < localRuntimeException[5])
        {
          localRuntimeException[0] -= 0;
          arrayOfFloat[1] = (i * j + i7);
          localRuntimeException[2] += 0;
          arrayOfFloat[3] = (i * j + i7);
          this.aKO.mapPoints(arrayOfFloat);
          f1 = arrayOfFloat[0];
          f2 = this.aKB;
          f3 = arrayOfFloat[1];
          f4 = this.aKB;
          f5 = arrayOfFloat[2];
          f6 = this.aKB;
          f7 = arrayOfFloat[3];
          paramCanvas.drawLine(f2 * f1, f4 * f3, f6 * f5, this.aKB * f7, JL());
          localRuntimeException[0] -= 0;
          arrayOfFloat[1] = (i7 - i * j);
          localRuntimeException[2] += 0;
          arrayOfFloat[3] = (i7 - i * j);
          this.aKO.mapPoints(arrayOfFloat);
          f1 = arrayOfFloat[0];
          f2 = this.aKB;
          f3 = arrayOfFloat[1];
          f4 = this.aKB;
          f5 = arrayOfFloat[2];
          f6 = this.aKB;
          f7 = arrayOfFloat[3];
          paramCanvas.drawLine(f2 * f1, f4 * f3, f6 * f5, this.aKB * f7, JL());
          j += 1;
        }
        label3565:
        paramCanvas.drawBitmap(this.aKK, 0.0F, 0.0F, null);
        break;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f4 = this.aKI[2];
    float f2 = this.aKI[5];
    float f5 = this.aKI[0];
    float f3 = this.aKI[4];
    float f6;
    float f1;
    label413:
    float f7;
    float f8;
    float f9;
    float f10;
    label1214:
    Object localObject1;
    if (this.aKR)
    {
      f6 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
        do
        {
          return super.onTouchEvent(paramMotionEvent);
          if (f6 >= ((Point)this.aKX.get(0)).x) {
            break label413;
          }
          if (f1 >= ((Point)this.aKX.get(0)).y) {
            break;
          }
          this.aKY = 0;
        } while (this.aKY <= -1);
        this.aLc = true;
        this.aLk = f6;
        this.aLl = f1;
        paramMotionEvent = new float[4];
        switch (this.aKY)
        {
        }
        for (;;)
        {
          if ((this.aKY > 3) && (this.aKY != 9999))
          {
            this.aLm = ((int)((paramMotionEvent[0] + paramMotionEvent[2]) / 2.0F));
            this.aLn = ((int)((paramMotionEvent[1] + paramMotionEvent[3]) / 2.0F));
            this.aLp = ((int)Math.abs((paramMotionEvent[0] - paramMotionEvent[2]) / 2.0F));
            this.aLq = ((int)Math.abs((paramMotionEvent[1] - paramMotionEvent[3]) / 2.0F));
          }
          i = 0;
          while (i < this.aKG.size())
          {
            ((Point)this.aKG.get(i)).set(((Point)this.aKE.get(i)).x, ((Point)this.aKE.get(i)).y);
            i += 1;
          }
          if (f1 > ((Point)this.aKX.get(2)).y)
          {
            this.aKY = 3;
            break;
          }
          this.aKY = 7;
          break;
          if (f6 > ((Point)this.aKX.get(1)).x)
          {
            if (f1 < ((Point)this.aKX.get(0)).y)
            {
              this.aKY = 1;
              break;
            }
            if (f1 > ((Point)this.aKX.get(2)).y)
            {
              this.aKY = 2;
              break;
            }
            this.aKY = 5;
            break;
          }
          if (f1 < ((Point)this.aKX.get(0)).y)
          {
            this.aKY = 4;
            break;
          }
          if (f1 > ((Point)this.aKX.get(2)).y)
          {
            this.aKY = 6;
            break;
          }
          this.aKY = 9999;
          this.aLr = Math.abs((this.aKZ[0] - this.aKZ[2]) / (this.aKZ[1] - this.aKZ[7]));
          break;
          this.aLm = ((int)this.aKZ[(this.aKY * 2)]);
          this.aLn = ((int)this.aKZ[(this.aKY * 2 + 1)]);
          continue;
          paramMotionEvent[0] = this.aKZ[0];
          paramMotionEvent[1] = this.aKZ[1];
          paramMotionEvent[2] = this.aKZ[2];
          paramMotionEvent[3] = this.aKZ[3];
          continue;
          paramMotionEvent[0] = this.aKZ[2];
          paramMotionEvent[1] = this.aKZ[3];
          paramMotionEvent[2] = this.aKZ[4];
          paramMotionEvent[3] = this.aKZ[5];
          continue;
          paramMotionEvent[0] = this.aKZ[4];
          paramMotionEvent[1] = this.aKZ[5];
          paramMotionEvent[2] = this.aKZ[6];
          paramMotionEvent[3] = this.aKZ[7];
          continue;
          paramMotionEvent[0] = this.aKZ[6];
          paramMotionEvent[1] = this.aKZ[7];
          paramMotionEvent[2] = this.aKZ[0];
          paramMotionEvent[3] = this.aKZ[1];
        }
        this.aKQ.invert(this.aLa);
        invalidate();
        return true;
      case 2: 
        f6 = (f6 - this.aLk) / this.aLb;
        f7 = (f1 - this.aLl) / this.aLb;
        f8 = this.aLm - f6;
        f9 = this.aLn - f7;
        f1 = this.aLr;
        switch (this.aKY)
        {
        default: 
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            ac.q(this.aKG);
            f6 = ((Point)this.aKG.get(0)).x;
            f7 = this.aKB;
            f8 = ((Point)this.aKG.get(0)).y;
            f9 = this.aKB;
            f10 = ((Point)this.aKG.get(1)).x;
            float f11 = this.aKB;
            float f12 = ((Point)this.aKG.get(1)).y;
            float f13 = this.aKB;
            float f14 = ((Point)this.aKG.get(2)).x;
            float f15 = this.aKB;
            float f16 = ((Point)this.aKG.get(2)).y;
            float f17 = this.aKB;
            float f18 = ((Point)this.aKG.get(3)).x;
            float f19 = this.aKB;
            float f20 = ((Point)this.aKG.get(3)).y;
            float f21 = this.aKB;
            if (this.aKY != 9999) {
              break;
            }
            this.aKZ = d.b(f1, 100);
            if (this.aKP != null) {
              this.aKP.B(f1);
            }
            this.aKZ = b(this.aKZ);
            paramMotionEvent = this.aKQ;
            localObject1 = this.aKZ;
            paramMotionEvent.setPolyToPoly(new float[] { f6 * f7 * f5 + f4, f8 * f9 * f3 + f2, f10 * f11 * f5 + f4, f12 * f13 * f3 + f2, f14 * f15 * f5 + f4, f16 * f17 * f3 + f2, f18 * f19 * f5 + f4, f20 * f21 * f3 + f2 }, 0, (float[])localObject1, 0, 4);
            invalidate();
            return true;
            paramMotionEvent = new float[2];
            paramMotionEvent[0] = f8;
            paramMotionEvent[1] = f9;
            this.aLa.mapPoints(paramMotionEvent);
            ((Point)this.aKG.get(this.aKY)).x = ((int)((paramMotionEvent[0] - f4) / (this.aKB * f5)));
            ((Point)this.aKG.get(this.aKY)).y = ((int)((paramMotionEvent[1] - f2) / (this.aKB * f3)));
          }
        case 4: 
        case 6: 
          paramMotionEvent = new float[4];
          paramMotionEvent[0] = (this.aLm - this.aLp);
          paramMotionEvent[1] = f9;
          paramMotionEvent[2] = (this.aLm + this.aLp);
          paramMotionEvent[3] = f9;
          this.aLa.mapPoints(paramMotionEvent);
          if (this.aKY != 6) {}
          break;
        }
        break;
      }
    }
    for (int i = 2;; i = 0)
    {
      ((Point)this.aKG.get(i)).x = ((int)((paramMotionEvent[0] - f4) / (this.aKB * f5)));
      ((Point)this.aKG.get(i)).y = ((int)((paramMotionEvent[1] - f2) / (this.aKB * f3)));
      ((Point)this.aKG.get(i + 1)).x = ((int)((paramMotionEvent[2] - f4) / (this.aKB * f5)));
      ((Point)this.aKG.get(i + 1)).y = ((int)((paramMotionEvent[3] - f2) / (this.aKB * f3)));
      break;
      paramMotionEvent = new float[4];
      paramMotionEvent[0] = f8;
      paramMotionEvent[1] = (this.aLn - this.aLq);
      paramMotionEvent[2] = f8;
      paramMotionEvent[3] = (this.aLn + this.aLq);
      this.aLa.mapPoints(paramMotionEvent);
      int j;
      if (this.aKY == 7) {
        j = 3;
      }
      for (i = 0;; i = 2)
      {
        ((Point)this.aKG.get(j)).x = ((int)((paramMotionEvent[0] - f4) / (this.aKB * f5)));
        ((Point)this.aKG.get(j)).y = ((int)((paramMotionEvent[1] - f2) / (this.aKB * f3)));
        ((Point)this.aKG.get(i)).x = ((int)((paramMotionEvent[2] - f4) / (this.aKB * f5)));
        ((Point)this.aKG.get(i)).y = ((int)((paramMotionEvent[3] - f2) / (this.aKB * f3)));
        break;
        f6 = Math.abs(f6) - Math.abs(f7);
        f1 = f6 / d.c(getContext(), 100);
        if (f6 > 0.0F)
        {
          f1 = this.aLr + f1 * this.aLr;
          break;
        }
        f6 = this.aLr;
        f7 = this.aLr;
        f1 = f6 + Math.min(f1, 1.0F) * f7 / 2.0F;
        break;
        this.aKZ = d.a(this.axP, t(this.aKG));
        break label1214;
        i = 0;
        while (i < this.aKG.size())
        {
          ((Point)this.aKE.get(i)).set(((Point)this.aKG.get(i)).x, ((Point)this.aKG.get(i)).y);
          i += 1;
        }
        if (this.aKP != null) {
          this.aKP.r(this.aKE);
        }
        f1 = Math.abs((this.aKZ[0] - this.aKZ[2]) / (this.aKZ[1] - this.aKZ[7]));
        if (9999 == this.aKY) {
          if (this.aLr != f1)
          {
            this.aLd = f1;
            if (this.aKP != null) {
              this.aKP.B(f1);
            }
          }
        }
        for (;;)
        {
          this.aLc = false;
          this.aKY = -1;
          JQ();
          return true;
          this.aLd = 0.0F;
          if (this.aKP != null) {
            this.aKP.B(f1);
          }
        }
        if (this.aKF == null) {
          return super.onTouchEvent(paramMotionEvent);
        }
        f1 = (paramMotionEvent.getX() - f4) / (this.aKB * f5);
        f2 = (paramMotionEvent.getY() - f2) / (this.aKB * f3);
        double d1;
        double d2;
        float[] arrayOfFloat;
        switch (paramMotionEvent.getAction())
        {
        default: 
        case 0: 
        case 2: 
          do
          {
            return super.onTouchEvent(paramMotionEvent);
            JQ();
            i = 0;
            d1 = Double.MAX_VALUE;
            j = -1;
            while (i < this.aKF.size())
            {
              paramMotionEvent = (Point)this.aKF.get(i);
              double d3 = d.a(f1, f2, paramMotionEvent.x, paramMotionEvent.y);
              d2 = d1;
              if (d3 < d1)
              {
                j = i;
                d2 = d3;
              }
              i += 1;
              d1 = d2;
            }
            if (j >= 0)
            {
              paramMotionEvent = (Point)this.aKF.get(j);
              this.aLj = j;
              O(paramMotionEvent.x, paramMotionEvent.y);
              this.aLk = f1;
              this.aLl = f2;
              this.aLm = paramMotionEvent.x;
              this.aLn = paramMotionEvent.y;
            }
            return true;
          } while (this.aLj < 0);
          f1 -= this.aLk;
          f2 -= this.aLl;
          if (this.aLj < 4)
          {
            paramMotionEvent = (Point)this.aKF.get(this.aLj);
            i = this.aLm;
            paramMotionEvent.x = ((int)f1 + i);
            paramMotionEvent.y = (this.aLn + (int)f2);
            O(paramMotionEvent.x, paramMotionEvent.y);
            JS();
            invalidate();
            return true;
          }
          arrayOfFloat = new float[2];
          arrayOfFloat[0] = this.aLm;
          arrayOfFloat[1] = this.aLn;
          f1 = this.aLm + f1;
          f2 = this.aLn + f2;
          paramMotionEvent = new Rect((int)f1 - 10, (int)f2 - 10, (int)f1 + 10, (int)(10.0F + f2));
          d1 = Double.MAX_VALUE;
          j = -1;
          i = 0;
          label2603:
          if (i < this.aKA.size())
          {
            if (!Rect.intersects((Rect)this.aKA.get(i), paramMotionEvent)) {
              break label4271;
            }
            localObject1 = (b)this.aDz.get(i);
            localObject1 = ac.b(new Point((int)((b)localObject1).DR(), (int)((b)localObject1).DQ()), new Point((int)((b)localObject1).DP(), (int)((b)localObject1).DO()), new Point(this.aLm, this.aLn), new Point((int)f1, (int)f2));
            d2 = d.a(((Point)localObject1).x, ((Point)localObject1).y, f1, f2);
            if (d2 >= d1) {
              break label4271;
            }
            j = i;
            d1 = d2;
          }
          break;
        }
        label2827:
        label4271:
        for (;;)
        {
          i += 1;
          break label2603;
          Object localObject2;
          Object localObject3;
          Point localPoint1;
          Point localPoint2;
          int k;
          if (j >= 0)
          {
            paramMotionEvent = null;
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localPoint1 = null;
            switch (this.aLj)
            {
            default: 
              localPoint2 = null;
              b localb = (b)this.aDz.get(j);
              localPoint2 = ac.b(new Point((int)localb.DR(), (int)localb.DQ()), new Point((int)localb.DP(), (int)localb.DO()), localPoint2, paramMotionEvent);
              localObject1 = ac.b(new Point((int)localb.DR(), (int)localb.DQ()), new Point((int)localb.DP(), (int)localb.DO()), (Point)localObject1, (Point)localObject2);
              d1 = ac.a(paramMotionEvent, localPoint2, localPoint2, (Point)localObject1);
              d2 = ac.a(localPoint2, (Point)localObject1, (Point)localObject1, (Point)localObject2);
              if ((d1 > 30.0D) && (d2 > 30.0D) && (localObject3 != null) && (localPoint1 != null))
              {
                ((Point)localObject3).set(localPoint2.x, localPoint2.y);
                localPoint1.set(((Point)localObject1).x, ((Point)localObject1).y);
                k = 1;
                i = k;
                if (this.aLo != j)
                {
                  performHapticFeedback(0, 2);
                  this.aLo = j;
                }
              }
              break;
            }
          }
          for (i = k;; i = 0)
          {
            if (i == 0)
            {
              this.aLo = -1;
              paramMotionEvent = new float[2];
              paramMotionEvent[0] = f1;
              paramMotionEvent[1] = f2;
              localObject1 = d.a(this.axP, new ArrayList(this.aKE));
              f3 = ((Point)this.aKE.get(0)).x;
              f4 = ((Point)this.aKE.get(0)).y;
              f5 = ((Point)this.aKE.get(1)).x;
              f6 = ((Point)this.aKE.get(1)).y;
              f7 = ((Point)this.aKE.get(2)).x;
              f8 = ((Point)this.aKE.get(2)).y;
              f9 = ((Point)this.aKE.get(3)).x;
              f10 = ((Point)this.aKE.get(3)).y;
              localObject2 = new Matrix();
              ((Matrix)localObject2).setPolyToPoly(new float[] { f3, f4, f5, f6, f7, f8, f9, f10 }, 0, (float[])localObject1, 0, 4);
              ((Matrix)localObject2).mapPoints(arrayOfFloat);
              ((Matrix)localObject2).mapPoints(paramMotionEvent);
              localObject3 = new Matrix();
              ((Matrix)localObject2).invert((Matrix)localObject3);
              switch (this.aLj - 4)
              {
              }
            }
            for (;;)
            {
              O((int)f1, (int)f2);
              break;
              localPoint2 = (Point)this.aKE.get(0);
              paramMotionEvent = (Point)this.aKE.get(3);
              localObject1 = (Point)this.aKE.get(1);
              localObject2 = (Point)this.aKE.get(2);
              localObject3 = (Point)this.aKF.get(0);
              localPoint1 = (Point)this.aKF.get(1);
              break label2827;
              localPoint2 = (Point)this.aKE.get(1);
              paramMotionEvent = (Point)this.aKE.get(0);
              localObject1 = (Point)this.aKE.get(2);
              localObject2 = (Point)this.aKE.get(3);
              localObject3 = (Point)this.aKF.get(1);
              localPoint1 = (Point)this.aKF.get(2);
              break label2827;
              localPoint2 = (Point)this.aKE.get(2);
              paramMotionEvent = (Point)this.aKE.get(1);
              localObject1 = (Point)this.aKE.get(3);
              localObject2 = (Point)this.aKE.get(0);
              localObject3 = (Point)this.aKF.get(2);
              localPoint1 = (Point)this.aKF.get(3);
              break label2827;
              localPoint2 = (Point)this.aKE.get(0);
              paramMotionEvent = (Point)this.aKE.get(1);
              localObject1 = (Point)this.aKE.get(3);
              localObject2 = (Point)this.aKE.get(2);
              localObject3 = (Point)this.aKF.get(0);
              localPoint1 = (Point)this.aKF.get(3);
              break label2827;
              localObject1[1] += paramMotionEvent[1] - arrayOfFloat[1];
              localObject1[3] += paramMotionEvent[1] - arrayOfFloat[1];
              ((Matrix)localObject3).mapPoints((float[])localObject1);
              ((Point)this.aKF.get(0)).set((int)localObject1[0], (int)localObject1[1]);
              ((Point)this.aKF.get(1)).set((int)localObject1[2], (int)localObject1[3]);
              continue;
              localObject1[5] += paramMotionEvent[1] - arrayOfFloat[1];
              localObject1[7] += paramMotionEvent[1] - arrayOfFloat[1];
              ((Matrix)localObject3).mapPoints((float[])localObject1);
              ((Point)this.aKF.get(2)).set((int)localObject1[4], (int)localObject1[5]);
              ((Point)this.aKF.get(3)).set((int)localObject1[6], (int)localObject1[7]);
              continue;
              localObject1[2] += paramMotionEvent[0] - arrayOfFloat[0];
              localObject1[4] += paramMotionEvent[0] - arrayOfFloat[0];
              ((Matrix)localObject3).mapPoints((float[])localObject1);
              ((Point)this.aKF.get(1)).set((int)localObject1[2], (int)localObject1[3]);
              ((Point)this.aKF.get(2)).set((int)localObject1[4], (int)localObject1[5]);
              continue;
              localObject1[0] += paramMotionEvent[0] - arrayOfFloat[0];
              localObject1[6] += paramMotionEvent[0] - arrayOfFloat[0];
              ((Matrix)localObject3).mapPoints((float[])localObject1);
              ((Point)this.aKF.get(0)).set((int)localObject1[0], (int)localObject1[1]);
              ((Point)this.aKF.get(3)).set((int)localObject1[6], (int)localObject1[7]);
            }
            this.aLj = -1;
            i = 0;
            while (i < 4)
            {
              this.aKE.set(i, new Point((Point)this.aKF.get(i)));
              i += 1;
            }
            JS();
            if (this.aKP != null) {
              this.aKP.r(this.aKE);
            }
            this.aLd = 0.0F;
            invalidate();
            if (!JX()) {
              Toast.makeText(getContext(), 2131296985, 0).show();
            }
            return true;
          }
        }
        j = 1;
      }
    }
  }
  
  public void s(List<b> paramList)
  {
    this.aDz = paramList;
    this.aKA = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      this.aKA.add(new Rect((int)Math.min(localb.DR(), localb.DP()), (int)Math.min(localb.DQ(), localb.DO()), (int)Math.max(localb.DR(), localb.DP()), (int)Math.max(localb.DQ(), localb.DO())));
    }
  }
  
  private class a
    extends Animation
  {
    private final float[] aLs;
    private final float[] aLt;
    private final boolean aLu;
    private boolean azH = false;
    
    a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean)
    {
      this.aLs = Arrays.copyOf(paramArrayOfFloat1, paramArrayOfFloat1.length);
      this.aLt = Arrays.copyOf(paramArrayOfFloat2, paramArrayOfFloat2.length);
      this.aLu = paramBoolean;
      if (this.aLu) {
        CropImageView.a(CropImageView.this, 0.0F);
      }
      for (;;)
      {
        CropImageView.a(CropImageView.this).setXfermode(null);
        CropImageView.b(CropImageView.this).reset();
        return;
        CropImageView.a(CropImageView.this, 1.0F);
      }
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      if (paramFloat < 1.0F)
      {
        float f1 = paramFloat;
        if (!this.aLu) {
          f1 = 1.0F - paramFloat;
        }
        paramFloat = this.aLs[0];
        float f2 = this.aLs[0];
        float f3 = this.aLt[0];
        float f4 = this.aLs[1];
        float f5 = this.aLs[1];
        float f6 = this.aLt[1];
        float f7 = this.aLs[2];
        float f8 = this.aLs[2];
        float f9 = this.aLt[2];
        float f10 = this.aLs[3];
        float f11 = this.aLs[3];
        float f12 = this.aLt[3];
        float f13 = this.aLs[4];
        float f14 = this.aLs[4];
        float f15 = this.aLt[4];
        float f16 = this.aLs[5];
        float f17 = this.aLs[5];
        float f18 = this.aLt[5];
        float f19 = this.aLs[6];
        float f20 = this.aLs[6];
        float f21 = this.aLt[6];
        float f22 = this.aLs[7];
        float f23 = this.aLs[7];
        float f24 = this.aLt[7];
        CropImageView.b(CropImageView.this).setPolyToPoly(this.aLs, 0, new float[] { paramFloat - (f2 - f3) * f1, f4 - (f5 - f6) * f1, f7 - (f8 - f9) * f1, f10 - (f11 - f12) * f1, f13 - (f14 - f15) * f1, f16 - (f17 - f18) * f1, f19 - (f20 - f21) * f1, f22 - (f23 - f24) * f1 }, 0, 4);
        CropImageView.a(CropImageView.this, f1);
        CropImageView.a(CropImageView.this).setAlpha((int)(255.0F * f1));
      }
      for (;;)
      {
        CropImageView.this.invalidate();
        return;
        if (!this.azH)
        {
          this.azH = true;
          if (this.aLu)
          {
            CropImageView.b(CropImageView.this).setPolyToPoly(this.aLs, 0, this.aLt, 0, 4);
            CropImageView.a(CropImageView.this, 1.0F);
            CropImageView.a(CropImageView.this).setAlpha(255);
            CropImageView.a(CropImageView.this).setXfermode(new PixelXorXfermode(-1));
          }
          else
          {
            CropImageView.b(CropImageView.this).reset();
            CropImageView.a(CropImageView.this, 0.0F);
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void B(float paramFloat);
    
    public abstract void r(List<Point> paramList);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/CropImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */