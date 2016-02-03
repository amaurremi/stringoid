package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.AsyncTask;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.common.util.BitmapNative;
import com.mobisystems.mobiscanner.common.util.b;
import com.mobisystems.mobiscanner.common.util.f;
import com.mobisystems.mobiscanner.common.util.h;
import com.mobisystems.mobiscanner.image.Image;
import com.mobisystems.mobiscanner.image.Image.RestrictMemory;
import com.mobisystems.mobiscanner.image.Image.a;
import com.mobisystems.mobiscanner.image.ImageOrientation;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.view.HistogramView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ac
{
  private double aDh;
  private double aDi;
  private double aDj;
  private double aDk;
  List<f> aDl;
  private double aDm;
  private double aDn;
  Image aDo;
  private ad aDp;
  private Bitmap aDq;
  private long aDr = 0L;
  private int aDs = 0;
  private int[] aDt;
  private int aDu;
  private int aDv;
  private long axO = -1L;
  private Context mContext;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  
  ac(Image paramImage, Context paramContext, ad paramad, long paramLong)
  {
    this(paramImage, paramContext, paramad, paramLong, false);
  }
  
  ac(Image paramImage, Context paramContext, ad paramad, long paramLong, boolean paramBoolean)
  {
    this.aDo = paramImage;
    this.mContext = paramContext;
    this.aDp = paramad;
    this.axO = paramLong;
    bc(paramBoolean);
    a(this.aDo.HW().Id());
  }
  
  private void Gn()
  {
    this.aDu = this.aDq.getWidth();
    this.aDv = this.aDq.getHeight();
    if (this.aDp != null) {
      this.aDp.El();
    }
  }
  
  private int M(int paramInt1, int paramInt2)
  {
    if (this.aDq != null)
    {
      int i;
      if (paramInt1 < 0)
      {
        i = 0;
        if (paramInt2 >= 0) {
          break label98;
        }
        paramInt1 = 0;
      }
      for (;;)
      {
        i = this.aDq.getPixel(i, paramInt1);
        paramInt1 = Color.red(i);
        paramInt2 = Color.green(i);
        i = Color.blue(i);
        double d = paramInt1;
        return (int)(paramInt2 * 0.59D + d * 0.3D + i * 0.11D);
        i = paramInt1;
        if (paramInt1 < this.aDu) {
          break;
        }
        i = this.aDu - 1;
        break;
        label98:
        paramInt1 = paramInt2;
        if (paramInt2 >= this.aDv) {
          paramInt1 = this.aDv - 1;
        }
      }
    }
    return -1;
  }
  
  private double a(Point paramPoint1, Point paramPoint2)
  {
    return Math.sqrt(Math.pow(paramPoint1.x - paramPoint2.x, 2.0D) + Math.pow(paramPoint1.y - paramPoint2.y, 2.0D));
  }
  
  public static double a(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4)
  {
    double d2 = Math.abs(Math.atan2(paramPoint1.y - paramPoint2.y, paramPoint1.x - paramPoint2.x) - Math.atan2(paramPoint3.y - paramPoint4.y, paramPoint3.x - paramPoint4.x)) * 180.0D / 3.141592653589793D;
    double d1 = d2;
    if (d2 > 180.0D) {
      d1 = d2 - 180.0D;
    }
    d2 = d1;
    if (d1 > 90.0D) {
      d2 = 180.0D - d1;
    }
    return d2;
  }
  
  private Bitmap a(Image paramImage)
  {
    paramImage = paramImage.c(2048, 2048, null, Image.RestrictMemory.aHy);
    int j = paramImage.getWidth();
    int i = paramImage.getHeight();
    j = (int)(j / 2.0F);
    i = (int)(i / 2.0F);
    try
    {
      Bitmap localBitmap = Bitmap.createScaledBitmap(paramImage, j, i, true);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.mLog.dl("out of memory while creating scaled bitmap !");
      localOutOfMemoryError.printStackTrace();
    }
    return paramImage;
  }
  
  private List<Point> a(List<Point> paramList, double paramDouble1, double paramDouble2)
  {
    double d1 = ((Point)paramList.get(0)).x;
    double d2 = ((Point)paramList.get(0)).y;
    double d3 = ((Point)paramList.get(1)).x;
    double d4 = ((Point)paramList.get(1)).y;
    double d5 = ((Point)paramList.get(2)).x;
    double d6 = ((Point)paramList.get(2)).y;
    double d7 = ((Point)paramList.get(3)).x;
    double d8 = ((Point)paramList.get(3)).y;
    paramDouble1 /= 2.0D;
    double d9 = paramDouble2 / 2.0D;
    paramList = new ArrayList();
    paramList.add(new Point((int)(d1 - paramDouble1), (int)(paramDouble2 - d2 - d9)));
    paramList.add(new Point((int)(d3 - paramDouble1), (int)(paramDouble2 - d4 - d9)));
    paramList.add(new Point((int)(d5 - paramDouble1), (int)(paramDouble2 - d6 - d9)));
    paramList.add(new Point((int)(d7 - paramDouble1), (int)(paramDouble2 - d8 - d9)));
    return paramList;
  }
  
  private List<f> a(List<f> paramList, Jama.Matrix paramMatrix)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (f)paramList.next();
      localObject = paramMatrix.c(new Jama.Matrix(new double[][] { { ((f)localObject).x, ((f)localObject).y, ((f)localObject).z } }).h());
      localArrayList.add(new f(((Jama.Matrix)localObject).a(0, 0), ((Jama.Matrix)localObject).a(1, 0), ((Jama.Matrix)localObject).a(2, 0)));
    }
    return localArrayList;
  }
  
  private List<h> a(List<b> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    this.mLog.dl("findPossibleRectangles edgesCount = " + paramList.size() + "; filter = " + paramBoolean);
    if (paramList.size() > 20) {}
    int[] arrayOfInt;
    int i1;
    int j;
    b localb1;
    for (int i = 20;; i = paramList.size())
    {
      arrayOfInt = new int[4];
      i1 = this.aDu * this.aDv / 10;
      j = 0;
      for (;;)
      {
        if (j >= i - 3) {
          break label1025;
        }
        localb1 = (b)paramList.get(j);
        if ((!paramBoolean) || (!b(localb1))) {
          break;
        }
        j += 1;
      }
    }
    arrayOfInt[0] = j;
    Point localPoint1 = new Point((int)localb1.DR(), (int)localb1.DQ());
    Point localPoint2 = new Point((int)localb1.DP(), (int)localb1.DO());
    int k = j + 1;
    label204:
    b localb2;
    if (k < i - 2)
    {
      localb2 = (b)paramList.get(k);
      if ((!paramBoolean) || (!b(localb2))) {
        break label248;
      }
    }
    label248:
    Point localPoint3;
    Point localPoint4;
    do
    {
      k += 1;
      break label204;
      break;
      localPoint3 = new Point((int)localb2.DR(), (int)localb2.DQ());
      localPoint4 = new Point((int)localb2.DP(), (int)localb2.DO());
    } while (a(localPoint1, localPoint2, localPoint3, localPoint4) < 30.0D);
    arrayOfInt[1] = k;
    int m = j + 1;
    label320:
    if (m < i - 1) {
      if ((m != arrayOfInt[0]) && (m != arrayOfInt[1])) {
        break label356;
      }
    }
    label356:
    b localb3;
    Point localPoint5;
    Point localPoint6;
    do
    {
      do
      {
        m += 1;
        break label320;
        break;
        localb3 = (b)paramList.get(m);
      } while ((paramBoolean) && (b(localb3)));
      localPoint5 = new Point((int)localb3.DR(), (int)localb3.DQ());
      localPoint6 = new Point((int)localb3.DP(), (int)localb3.DO());
    } while (a(localPoint3, localPoint4, localPoint5, localPoint6) < 30.0D);
    arrayOfInt[2] = m;
    int n = j + 1;
    label454:
    if (n < i) {
      if ((n != arrayOfInt[0]) && (n != arrayOfInt[1]) && (n != arrayOfInt[2])) {
        break label497;
      }
    }
    for (;;)
    {
      n += 1;
      break label454;
      break;
      label497:
      Object localObject2 = (b)paramList.get(n);
      if ((!paramBoolean) || (!b((b)localObject2)))
      {
        Point localPoint9 = new Point((int)((b)localObject2).DR(), (int)((b)localObject2).DQ());
        Object localObject3 = new Point((int)((b)localObject2).DP(), (int)((b)localObject2).DO());
        double d1 = a(localPoint1, localPoint2, localPoint9, (Point)localObject3);
        double d2 = a(localPoint5, localPoint6, localPoint9, (Point)localObject3);
        if ((d1 >= 30.0D) && (d2 >= 30.0D))
        {
          arrayOfInt[3] = n;
          Object localObject1 = b(localPoint1, localPoint2, localPoint3, localPoint4);
          Point localPoint7 = b(localPoint3, localPoint4, localPoint5, localPoint6);
          Point localPoint8 = b(localPoint5, localPoint6, localPoint9, (Point)localObject3);
          localPoint9 = b(localPoint9, (Point)localObject3, localPoint1, localPoint2);
          int i2 = (int)a((Point)localObject1, localPoint9);
          int i3 = (int)a((Point)localObject1, localPoint7);
          int i4 = (int)a(localPoint7, localPoint8);
          int i5 = (int)a(localPoint8, localPoint9);
          if ((i2 >= i3 / 5) && (i2 >= i5 / 5) && (i3 >= i2 / 5) && (i3 >= i4 / 5) && (i4 >= i3 / 5) && (i4 >= i5 / 5) && (i5 >= i2 / 5) && (i5 >= i4 / 5) && (a(localb1.DR(), localb1.DQ(), localb1.DP(), localb1.DO(), (Point)localObject1, localPoint9)) && (a(localb2.DR(), localb2.DQ(), localb2.DP(), localb2.DO(), (Point)localObject1, localPoint7)) && (a(localb3.DR(), localb3.DQ(), localb3.DP(), localb3.DO(), localPoint7, localPoint8)) && (a(((b)localObject2).DR(), ((b)localObject2).DQ(), ((b)localObject2).DP(), ((b)localObject2).DO(), localPoint8, localPoint9)))
          {
            localObject3 = new ArrayList(4);
            ((ArrayList)localObject3).add(localb1);
            ((ArrayList)localObject3).add(localb2);
            ((ArrayList)localObject3).add(localb3);
            ((ArrayList)localObject3).add(localObject2);
            localObject2 = new ArrayList(4);
            ((ArrayList)localObject2).add(localObject1);
            ((ArrayList)localObject2).add(localPoint7);
            ((ArrayList)localObject2).add(localPoint8);
            ((ArrayList)localObject2).add(localPoint9);
            localObject1 = new h((ArrayList)localObject3, (List)localObject2);
            if (((h)localObject1).Ea() > i1) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    label1025:
    Collections.sort(localArrayList, Collections.reverseOrder());
    return localArrayList;
  }
  
  private void a(ImageOrientation paramImageOrientation)
  {
    switch (2.aDw[paramImageOrientation.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.aDs = 180;
      return;
    case 2: 
      this.aDs = 90;
      return;
    }
    this.aDs = 270;
  }
  
  private boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, Point paramPoint1, Point paramPoint2)
  {
    paramDouble2 = Math.min(paramDouble1, paramDouble3);
    paramDouble1 = Math.max(paramDouble1, paramDouble3);
    paramDouble3 = Math.min(paramPoint1.x, paramPoint2.x);
    paramDouble4 = Math.max(paramPoint1.x, paramPoint2.x);
    return (paramDouble1 >= paramDouble3) && (paramDouble2 <= paramDouble4);
  }
  
  private Bitmap[] a(long paramLong, int paramInt)
  {
    int i3 = (int)(paramLong / 4096L);
    int m = (int)(paramLong % 4096L);
    int j;
    Bitmap[] arrayOfBitmap;
    label38:
    int i;
    label50:
    int n;
    int i4;
    int k;
    label70:
    label85:
    Object localObject;
    int i1;
    if (m != 0)
    {
      j = 1;
      arrayOfBitmap = new Bitmap[i3 + j];
      if (paramInt <= 0) {
        break label490;
      }
      if (paramInt > 4096)
      {
        i = 4096;
        n = i / 2;
        i4 = i3 + j;
        k = 0;
        j = n;
        if (k < i4)
        {
          if (k == 0)
          {
            i2 = 0;
            if (i2 < i4)
            {
              localObject = arrayOfBitmap[i2];
              if (localObject == null) {
                break label475;
              }
              n = j;
              i1 = i;
            }
          }
          try
          {
            ((Bitmap)localObject).recycle();
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            StringBuilder localStringBuilder;
            i1 -= n;
            if (n <= 1) {
              break label450;
            }
          }
          n = j;
          i1 = i;
          this.mLog.dl("libjpeg create bitmap idx = " + k);
          n = j;
          i1 = i;
          localObject = this.mLog;
          n = j;
          i1 = i;
          localStringBuilder = new StringBuilder().append("libjpeg create bitmap width = ");
          if (k < i3) {
            break label506;
          }
          i2 = m;
          label204:
          n = j;
          i1 = i;
          ((com.mobisystems.mobiscanner.common.c)localObject).dl(i2 + " ; height = " + i);
          if (k < i3) {
            break label514;
          }
        }
      }
    }
    label450:
    label475:
    label490:
    label497:
    label506:
    label514:
    for (int i2 = m;; i2 = 4096)
    {
      n = j;
      i1 = i;
      localObject = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
      n = j;
      i1 = i;
      new Canvas((Bitmap)localObject).drawARGB(255, 255 / (k + 1), 255 / (k + 1), 255 / (k + 1));
      if ((k == i4 - 1) && (j > 1) && (i < paramInt))
      {
        k = i + j;
        i = k;
        if (k > paramInt) {
          i = paramInt;
        }
        n = j;
        i1 = i;
        j /= 2;
        k = -1;
        n = j;
        i1 = i;
        this.mLog.dl("libjpeg continue ");
      }
      else
      {
        arrayOfBitmap[k] = localObject;
        break label497;
        for (i = n / 2;; i = n + 2)
        {
          this.mLog.dl("libjpeg out of memory");
          k = -1;
          j = i;
          i = i1;
          break;
        }
        this.aDr = i;
        return arrayOfBitmap;
        i = paramInt;
        break label50;
        i2 += 1;
        break label85;
        j = 0;
        break;
        paramInt = 4096;
        break label38;
      }
      k += 1;
      break label70;
      i2 = 4096;
      break label204;
    }
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4)
  {
    Jama.Matrix localMatrix1 = new Jama.Matrix(new double[][] { { paramPoint1.x, paramPoint1.y }, { paramPoint2.x, paramPoint2.y } });
    Jama.Matrix localMatrix2 = new Jama.Matrix(new double[][] { { paramPoint1.x, 1.0D }, { paramPoint2.x, 1.0D } });
    Object localObject1 = new Jama.Matrix(new double[][] { { paramPoint3.x, paramPoint3.y }, { paramPoint4.x, paramPoint4.y } });
    double d1 = paramPoint3.x;
    double d2 = paramPoint4.x;
    Object localObject2 = new Jama.Matrix(new double[][] { { d1, 1.0D }, { d2, 1.0D } });
    d1 = localMatrix1.b();
    d2 = localMatrix2.b();
    double d3 = ((Jama.Matrix)localObject1).b();
    double d4 = ((Jama.Matrix)localObject2).b();
    localMatrix1 = new Jama.Matrix(new double[][] { { d1, d2 }, { d3, d4 } });
    localMatrix2 = new Jama.Matrix(new double[][] { { paramPoint1.x, 1.0D }, { paramPoint2.x, 1.0D } });
    d1 = paramPoint1.y;
    localObject1 = new double[] { paramPoint2.y, 1.0D };
    localObject1 = new Jama.Matrix(new double[][] { { d1, 1.0D }, localObject1 });
    d1 = paramPoint3.x;
    localObject2 = new double[] { paramPoint4.x, 1.0D };
    localObject2 = new Jama.Matrix(new double[][] { { d1, 1.0D }, localObject2 });
    d1 = paramPoint3.y;
    d2 = paramPoint4.y;
    Jama.Matrix localMatrix3 = new Jama.Matrix(new double[][] { { d1, 1.0D }, { d2, 1.0D } });
    localMatrix2 = new Jama.Matrix(new double[][] { { localMatrix2.b(), ((Jama.Matrix)localObject1).b() }, { ((Jama.Matrix)localObject2).b(), localMatrix3.b() } });
    d1 = localMatrix1.b() / localMatrix2.b();
    d2 = paramPoint1.x;
    d3 = paramPoint1.y;
    d4 = paramPoint2.x;
    double d5 = paramPoint2.y;
    localMatrix1 = new Jama.Matrix(new double[][] { { d2, d3 }, { d4, d5 } });
    paramPoint1 = new Jama.Matrix(new double[][] { { paramPoint1.y, 1.0D }, { paramPoint2.y, 1.0D } });
    d2 = paramPoint3.x;
    d3 = paramPoint3.y;
    d4 = paramPoint4.x;
    d5 = paramPoint4.y;
    paramPoint2 = new Jama.Matrix(new double[][] { { d2, d3 }, { d4, d5 } });
    paramPoint3 = new Jama.Matrix(new double[][] { { paramPoint3.y, 1.0D }, { paramPoint4.y, 1.0D } });
    d2 = localMatrix1.b();
    d3 = paramPoint1.b();
    d4 = paramPoint2.b();
    d5 = paramPoint3.b();
    d2 = new Jama.Matrix(new double[][] { { d2, d3 }, { d4, d5 } }).b() / localMatrix2.b();
    return new Point((int)d1, (int)d2);
  }
  
  private boolean b(b paramb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.aDt != null)
    {
      double d1 = paramb.DR();
      double d2 = paramb.DQ();
      double d3 = paramb.DP();
      double d4 = paramb.DO();
      int i = M((int)d1, (int)d2);
      int j = M((int)d3, (int)d4);
      if ((i <= this.aDt[0]) || (i >= this.aDt[1]))
      {
        bool1 = bool2;
        if (j > this.aDt[0])
        {
          bool1 = bool2;
          if (j >= this.aDt[1]) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void bc(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      new c(null).execute(new Image[] { this.aDo });
      return;
    }
    this.aDq = a(this.aDo);
    Gn();
  }
  
  private List<f> o(List<Point> paramList)
  {
    Object localObject = p(paramList);
    double d1 = ((Jama.Matrix)localObject).a(0, 0);
    double d2 = ((Jama.Matrix)localObject).a(1, 0);
    double d3 = 1.0D - d1 + d2;
    localObject = new f(((Point)paramList.get(0)).x, ((Point)paramList.get(0)).y, this.aDh);
    f localf1 = new f(((Point)paramList.get(1)).x * d1, ((Point)paramList.get(1)).y * d1, this.aDh * d1);
    f localf2 = new f(((Point)paramList.get(2)).x * d2, ((Point)paramList.get(2)).y * d2, this.aDh * d2);
    paramList = new f(((Point)paramList.get(3)).x * d3, ((Point)paramList.get(3)).y * d3, this.aDh * d3);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(localf1);
    localArrayList.add(localf2);
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  private Jama.Matrix p(List<Point> paramList)
  {
    double d1 = ((Point)paramList.get(0)).x;
    double d2 = ((Point)paramList.get(0)).y;
    double d3 = ((Point)paramList.get(1)).x;
    double d4 = ((Point)paramList.get(1)).y;
    double d8 = ((Point)paramList.get(2)).x;
    double d7 = ((Point)paramList.get(2)).y;
    double d5 = ((Point)paramList.get(3)).x;
    double d6 = ((Point)paramList.get(3)).y;
    d8 = -d8;
    paramList = new double[] { d4, -d7, d6 };
    Object localObject1 = { 1.0D, -1.0D, 1.0D };
    paramList = new Jama.Matrix(new double[][] { { d3, d8, d5 }, paramList, localObject1 });
    localObject1 = new double[] { d2 };
    Object localObject2 = { 1.0D };
    paramList = paramList.a(new Jama.Matrix(new double[][] { { d1 }, localObject1, localObject2 }));
    d7 = paramList.a(2, 0);
    double d9 = paramList.a(0, 0);
    localObject1 = new Jama.Matrix(new double[][] { { d1 }, { d2 } }).b(new Jama.Matrix(new double[][] { { d5 }, { d6 } }).a(d7)).h();
    localObject2 = new double[] { d2 };
    localObject2 = new Jama.Matrix(new double[][] { { d1 }, localObject2 });
    double[] arrayOfDouble = { d4 };
    localObject1 = ((Jama.Matrix)localObject1).c(((Jama.Matrix)localObject2).b(new Jama.Matrix(new double[][] { { d3 }, arrayOfDouble }).a(d9)));
    d8 = (1.0D - d7) * (1.0D - d9);
    d9 = -((d2 - d9 * d4) * (d2 - d7 * d6) + (d1 - d7 * d5) * (d1 - d9 * d3)) / d8;
    this.mLog.dl("fSquared = " + d9 + " ; mResult = " + ((Jama.Matrix)localObject1).a(0, 0) / d8 + " ; labdas = " + d8);
    this.aDh = Math.sqrt(Math.abs(d9));
    d1 = Math.sqrt(Math.pow(d1 - d3, 2.0D) + Math.pow(d2 - d4, 2.0D)) / Math.sqrt(Math.pow(d1 - d7 * d5, 2.0D) + Math.pow(d2 - d7 * d6, 2.0D) + Math.pow(1.0D - d7, 2.0D) * d9);
    this.mLog.dl("ratio = " + d1);
    return paramList;
  }
  
  public static void q(List<Point> paramList)
  {
    Collections.sort(paramList, new Comparator()
    {
      public int b(Point paramAnonymousPoint1, Point paramAnonymousPoint2)
      {
        return (int)Math.signum(paramAnonymousPoint1.y - paramAnonymousPoint2.y);
      }
    });
    Point localPoint1 = (Point)paramList.get(0);
    Point localPoint2 = (Point)paramList.get(1);
    Point localPoint3 = (Point)paramList.get(2);
    Point localPoint4 = (Point)paramList.get(3);
    if (localPoint1.x > localPoint2.x)
    {
      paramList.set(0, localPoint2);
      paramList.set(1, localPoint1);
    }
    if (localPoint3.x < localPoint4.x)
    {
      paramList.set(2, localPoint4);
      paramList.set(3, localPoint3);
    }
  }
  
  public void a(h paramh, float paramFloat)
  {
    this.aDq.recycle();
    this.aDq = null;
    System.gc();
    if (paramh == null) {}
    Object localObject1;
    label616:
    label668:
    do
    {
      return;
      paramh = new h(paramh);
      Bitmap localBitmap = this.aDo.b(4096, 4096, null, Image.RestrictMemory.aHw);
      int i = localBitmap.getWidth();
      int j = localBitmap.getHeight();
      paramh = new ArrayList(paramh.vh());
      q(paramh);
      localObject1 = new float[8];
      localObject1[0] = ((Point)paramh.get(0)).x;
      localObject1[1] = ((Point)paramh.get(0)).y;
      localObject1[2] = ((Point)paramh.get(1)).x;
      localObject1[3] = ((Point)paramh.get(1)).y;
      localObject1[4] = ((Point)paramh.get(2)).x;
      localObject1[5] = ((Point)paramh.get(2)).y;
      localObject1[6] = ((Point)paramh.get(3)).x;
      localObject1[7] = ((Point)paramh.get(3)).y;
      android.graphics.Matrix localMatrix1;
      int k;
      if (paramFloat > 0.0F)
      {
        paramh = d.b(paramFloat, Math.min(this.aDu / 2, this.aDv / 2));
        localMatrix1 = new android.graphics.Matrix();
        localMatrix1.reset();
        localMatrix1.setPolyToPoly((float[])localObject1, 0, paramh, 0, 4);
        if (0L < this.axO) {
          new bg(this.axO, localMatrix1, null).execute(new Void[0]);
        }
        paramFloat = i / this.aDu;
        if ((this.aDs == 90) || (this.aDs == 270)) {
          paramFloat = i / this.aDv;
        }
        localMatrix1.reset();
        localMatrix1.setRotate(-this.aDs, this.aDu / 2, this.aDv / 2);
        localMatrix1.mapPoints((float[])localObject1);
        localMatrix1.mapPoints(paramh);
        if ((this.aDs == 90) || (this.aDs == 270))
        {
          localMatrix1.reset();
          k = Math.abs(this.aDv - this.aDu) / 2;
          localMatrix1.setTranslate(k, -k);
          localMatrix1.mapPoints((float[])localObject1);
          localMatrix1.mapPoints(paramh);
        }
        localMatrix1.reset();
        localMatrix1.postScale(paramFloat, paramFloat);
        localMatrix1.mapPoints((float[])localObject1);
        localMatrix1.mapPoints(paramh);
        this.mLog.dl("after src points = " + Arrays.toString((float[])localObject1));
        this.mLog.dl("after dst points = " + Arrays.toString(paramh));
        localMatrix1.reset();
        localMatrix1.setPolyToPoly((float[])localObject1, 0, paramh, 0, 4);
        if (this.aDs != 90) {
          break label616;
        }
        localMatrix1.postTranslate(0.0F, -paramh[3]);
      }
      for (;;)
      {
        if (d.a(localMatrix1, i, j)) {
          break label668;
        }
        this.mLog.dl("cannot crop");
        return;
        paramh = d.a(this, paramh);
        break;
        if (this.aDs == 270) {
          localMatrix1.postTranslate(-paramh[6], 0.0F);
        } else if (this.aDs == 180) {
          localMatrix1.postTranslate(-paramh[4], -paramh[5]);
        }
      }
      double d1 = a(new Point((int)paramh[0], (int)paramh[1]), new Point((int)paramh[2], (int)paramh[3]));
      double d2 = a(new Point((int)paramh[2], (int)paramh[3]), new Point((int)paramh[4], (int)paramh[5]));
      localObject1 = d.ag(this.mContext);
      i = (int)d2;
      j = (int)d1;
      if ((this.aDs == 90) || (this.aDs == 270))
      {
        i = (int)d1;
        j = (int)d2;
      }
      paramh = new Paint();
      paramh.setFilterBitmap(true);
      localObject1 = ((File)localObject1).getAbsolutePath();
      BitmapNative.createCompress(j, i, 90, (String)localObject1);
      int m = i;
      if (m > 0)
      {
        Bitmap[] arrayOfBitmap = a(j, m);
        float[] arrayOfFloat = new float[9];
        k = m;
        while (k >= this.aDr)
        {
          android.graphics.Matrix localMatrix2 = new android.graphics.Matrix(localMatrix1);
          localMatrix2.postTranslate(0.0F, -(i - k));
          int i3 = arrayOfBitmap.length;
          i1 = 0;
          m = 0;
          n = 0;
          while (n < i3)
          {
            Object localObject2 = arrayOfBitmap[n];
            int i2 = ((Bitmap)localObject2).getWidth();
            int i4 = ((Bitmap)localObject2).getHeight();
            this.mLog.dl(" bitmap width =  " + i2 + "height = " + i4);
            localObject2 = new Canvas((Bitmap)localObject2);
            this.mLog.dl(" bitmap currentX translation = " + -i1);
            localMatrix2.getValues(arrayOfFloat);
            this.mLog.dl(" bitmap matrix transX= " + arrayOfFloat[2] + " ; transY = " + arrayOfFloat[5]);
            localMatrix2.postTranslate(-i1, 0.0F);
            m += i1;
            ((Canvas)localObject2).drawBitmap(localBitmap, localMatrix2, paramh);
            n += 1;
            i1 = i2;
          }
          BitmapNative.sendBitmap(arrayOfBitmap);
          k = (int)(k - this.aDr);
          this.mLog.dl(" bitmap remainingHeight=  " + k);
          this.mLog.dl(" bitmap last row translation = " + -m);
        }
        int i1 = arrayOfBitmap.length;
        int n = 0;
        for (;;)
        {
          m = k;
          if (n >= i1) {
            break;
          }
          arrayOfBitmap[n].recycle();
          n += 1;
        }
      }
      localBitmap.recycle();
      long l1 = System.nanoTime();
      this.mLog.dl("libjpeg createJPEG start " + l1);
      BitmapNative.finishCompress();
      long l2 = System.nanoTime();
      this.mLog.dl("libjpeg createJPEG end" + l2);
      this.mLog.dl("libjpeg createJPEG total " + (l2 - l1));
    } while (0L >= this.axO);
    paramh = new DocumentModel();
    paramh.b(this.axO, (String)localObject1, false);
    paramh.a(this.axO, this.aDo.HW().Ic());
  }
  
  public void a(HistogramView paramHistogramView)
  {
    this.aDt = new int[2];
    int[] arrayOfInt = BitmapNative.calcHistogram(this.aDq, this.aDt);
    this.mLog.dl("computed Borders = " + Arrays.toString(this.aDt));
    if (paramHistogramView != null)
    {
      paramHistogramView.b(arrayOfInt);
      paramHistogramView.invalidate();
    }
  }
  
  public float[] a(List<Point> paramList, int paramInt1, int paramInt2)
  {
    q(paramList);
    this.aDl = o(a(paramList, paramInt1, paramInt2));
    paramList = (f)this.aDl.get(0);
    double d1 = -paramList.x;
    double d2 = -paramList.y;
    paramList = new double[] { 0.0D, 0.0D, 1.0D, -paramList.z };
    Object localObject1 = new Jama.Matrix(new double[][] { { 1.0D, 0.0D, 0.0D, d1 }, { 0.0D, 1.0D, 0.0D, d2 }, paramList, { 0.0D, 0.0D, 0.0D, 1.0D } });
    paramList = new ArrayList();
    Object localObject2 = this.aDl.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (f)((Iterator)localObject2).next();
      localObject3 = ((Jama.Matrix)localObject1).c(new Jama.Matrix(new double[][] { { ((f)localObject3).x, ((f)localObject3).y, ((f)localObject3).z, 1.0D } }).h());
      paramList.add(new f(((Jama.Matrix)localObject3).a(0, 0), ((Jama.Matrix)localObject3).a(1, 0), ((Jama.Matrix)localObject3).a(2, 0)));
    }
    localObject1 = (f)paramList.get(1);
    this.aDk = Math.asin(((f)localObject1).y / Math.sqrt(((f)localObject1).x * ((f)localObject1).x + ((f)localObject1).y * ((f)localObject1).y));
    localObject1 = new double[] { Math.cos(this.aDk), Math.sin(this.aDk), 0.0D };
    d1 = -Math.sin(this.aDk);
    d2 = Math.cos(this.aDk);
    localObject2 = new double[] { 0.0D, 0.0D, 1.0D };
    paramList = a(paramList, new Jama.Matrix(new double[][] { localObject1, { d1, d2, 0.0D }, localObject2 }));
    localObject1 = (f)paramList.get(1);
    this.aDj = (-Math.asin(((f)localObject1).z / Math.sqrt(((f)localObject1).x * ((f)localObject1).x + ((f)localObject1).z * ((f)localObject1).z)));
    paramList = a(paramList, new Jama.Matrix(new double[][] { { Math.cos(this.aDj), 0.0D, -Math.sin(this.aDj) }, { 0.0D, 1.0D, 0.0D }, { Math.sin(this.aDj), 0.0D, Math.cos(this.aDj) } }));
    localObject1 = (f)paramList.get(3);
    this.aDi = (-Math.asin(((f)localObject1).z / Math.sqrt(((f)localObject1).y * ((f)localObject1).y + ((f)localObject1).z * ((f)localObject1).z)));
    localObject1 = a(paramList, new Jama.Matrix(new double[][] { { 1.0D, 0.0D, 0.0D }, { 0.0D, Math.cos(this.aDi), Math.sin(this.aDi) }, { 0.0D, -Math.sin(this.aDi), Math.cos(this.aDi) } }));
    paramList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (f)((Iterator)localObject1).next();
      paramList.add(new Point((int)((f)localObject2).x, (int)((f)localObject2).y));
    }
    return new float[] { ((Point)paramList.get(0)).x, Math.abs(((Point)paramList.get(0)).y), ((Point)paramList.get(1)).x, Math.abs(((Point)paramList.get(1)).y), ((Point)paramList.get(1)).x, Math.abs(((Point)paramList.get(2)).y), ((Point)paramList.get(0)).x, Math.abs(((Point)paramList.get(3)).y) };
  }
  
  public void b(h paramh)
  {
    a(paramh, 0.0F);
  }
  
  public void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    new a(paramBoolean1, paramBoolean2).execute(new Void[0]);
  }
  
  public float[] n(List<Point> paramList)
  {
    return a(paramList, this.aDu, this.aDv);
  }
  
  private class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private List<h> aDA;
    private boolean aDx;
    private boolean aDy;
    private List<b> aDz;
    
    a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.aDx = paramBoolean1;
      this.aDy = paramBoolean2;
    }
    
    protected Boolean d(Void... paramVarArgs)
    {
      paramVarArgs = new DocumentModel();
      if (paramVarArgs.aj(ac.b(ac.this)).Jx() > 0)
      {
        this.aDz = paramVarArgs.aJ(ac.b(ac.this));
        if (this.aDz == null) {
          this.aDz = new ArrayList(0);
        }
        paramVarArgs = paramVarArgs.aI(ac.b(ac.this));
        if (paramVarArgs != null)
        {
          this.aDA = new ArrayList(1);
          this.aDA.add(paramVarArgs);
        }
        for (;;)
        {
          return Boolean.valueOf(true);
          this.aDA = ac.a(ac.this, this.aDz, this.aDx);
        }
      }
      return Boolean.valueOf(false);
    }
    
    protected void f(Boolean paramBoolean)
    {
      if (paramBoolean.booleanValue())
      {
        if (ac.c(ac.this) != null) {
          ac.c(ac.this).a(Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, this.aDz, ac.d(ac.this));
        }
        if (ac.c(ac.this) != null) {
          ac.c(ac.this).m(this.aDA);
        }
        return;
      }
      new ac.b(ac.this, this.aDx, this.aDy).execute(new Void[0]);
    }
  }
  
  private class b
    extends AsyncTask<Void, Void, Void>
  {
    double[] aDC;
    private final boolean aDx;
    private final boolean aDy;
    
    b(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.aDx = paramBoolean1;
      this.aDy = paramBoolean2;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      if (this.aDy) {
        ac.this.a(null);
      }
      long l1 = System.nanoTime();
      ac.e(ac.this).dl("libjpeg LSD start " + l1);
      this.aDC = BitmapNative.LineSegmentDetection(ac.f(ac.this), 0.8D, 0.6D, 2.0D, 22.5D, 0.0D, 0.7D, 1024);
      long l2 = System.nanoTime();
      ac.e(ac.this).dl("libjpeg LSD end" + l2);
      ac.e(ac.this).dl("libjpeg LSD total" + (l2 - l1));
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      double d2 = 0.0D;
      double d1 = 0.0D;
      paramVoid = null;
      int i;
      double d4;
      double d3;
      if (this.aDC != null)
      {
        ac.a(ac.this, Double.MAX_VALUE);
        ac.b(ac.this, Double.MAX_VALUE);
        int j = this.aDC.length / 7;
        paramVoid = new ArrayList(j);
        i = 0;
        d1 = 0.0D;
        d2 = 0.0D;
        if (i < j)
        {
          double d5 = this.aDC[(i * 7)];
          double d6 = this.aDC[(i * 7 + 1)];
          double d7 = this.aDC[(i * 7 + 2)];
          double d8 = this.aDC[(i * 7 + 3)];
          d4 = this.aDC[(i * 7 + 4)];
          d3 = this.aDC[(i * 7 + 5)];
          paramVoid.add(new b(d5, d6, d7, d8, d4, d3, this.aDC[(i * 7 + 6)]));
          if (d4 <= d2) {
            break label454;
          }
          d2 = d4;
        }
      }
      label454:
      for (;;)
      {
        if (d4 < ac.g(ac.this)) {
          ac.a(ac.this, d4);
        }
        if (d3 > d1) {
          d1 = d3;
        }
        for (;;)
        {
          if (d3 < ac.h(ac.this)) {
            ac.b(ac.this, d3);
          }
          i += 1;
          break;
          ac.e(ac.this).dl("maxP = " + d1 + " ; minP = " + ac.h(ac.this));
          Collections.sort(paramVoid, Collections.reverseOrder());
          for (;;)
          {
            if (ac.c(ac.this) != null) {
              ac.c(ac.this).a(ac.g(ac.this), d2, ac.h(ac.this), d1, paramVoid, ac.d(ac.this));
            }
            paramVoid = ac.a(ac.this, paramVoid, this.aDx);
            ac.e(ac.this).dl("quadInfos.size = " + paramVoid.size());
            if (ac.c(ac.this) != null) {
              ac.c(ac.this).m(paramVoid);
            }
            return;
            ac.e(ac.this).dl("libjpeg res is NULL ! ");
          }
        }
      }
    }
  }
  
  private class c
    extends AsyncTask<Image, Void, Bitmap>
  {
    private c() {}
    
    protected Bitmap a(Image... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      return ac.a(ac.this, paramVarArgs);
    }
    
    protected void d(Bitmap paramBitmap)
    {
      ac.a(ac.this, paramBitmap);
      ac.a(ac.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */