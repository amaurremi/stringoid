package com.ideashower.readitlater.views.gallery;

import android.graphics.Matrix;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;

public class j
{
  private final k a;
  private final f b = new f();
  private final long c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private final float h;
  private final boolean i;
  private final boolean j;
  private final boolean k;
  private final AccelerateDecelerateInterpolator l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private boolean r = false;
  
  public j(f paramf, k paramk, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, float paramFloat4, boolean paramBoolean2, float paramFloat5, boolean paramBoolean3)
  {
    this.b.a(paramf);
    this.c = SystemClock.uptimeMillis();
    this.a = paramk;
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
    this.i = paramBoolean1;
    this.g = paramFloat4;
    this.j = paramBoolean2;
    this.h = paramFloat5;
    this.k = paramBoolean3;
    this.l = new AccelerateDecelerateInterpolator();
  }
  
  private static float a(float paramFloat, float[] paramArrayOfFloat)
  {
    float f1;
    if (paramFloat > paramArrayOfFloat[1]) {
      f1 = paramArrayOfFloat[1];
    }
    do
    {
      return f1;
      f1 = paramFloat;
    } while (paramFloat >= paramArrayOfFloat[0]);
    return paramArrayOfFloat[0];
  }
  
  public static j a(f paramf, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, k paramk)
  {
    Object localObject = paramf.a();
    float f1 = ((g)localObject).a;
    float f2 = ((g)localObject).b;
    float f5 = ((g)localObject).c;
    float f3 = ((g)localObject).a + ((g)localObject).d / 2.0F;
    float f4 = ((g)localObject).b + ((g)localObject).e / 2.0F;
    float[] arrayOfFloat;
    label132:
    boolean bool1;
    label190:
    boolean bool2;
    label210:
    boolean bool3;
    if (((g)localObject).c > paramFloat2)
    {
      if (paramFloat2 == ((g)localObject).c) {
        break label282;
      }
      f2 = ((g)localObject).f * paramFloat2;
      float f6 = ((g)localObject).g * paramFloat2;
      f1 = f3 - f2 / 2.0F;
      paramFloat1 = f4 - f6 / 2.0F;
      arrayOfFloat = a(f2, paramFloat3);
      localObject = a(f6, paramFloat4);
      paramFloat3 = f1;
      f2 = a(paramFloat3, arrayOfFloat);
      f1 = a(paramFloat1, (float[])localObject);
      if ((paramFloat2 == f5) && (f2 == paramFloat3) && (f1 == paramFloat1)) {
        break label339;
      }
      paramFloat4 = Math.abs(f2 - paramFloat3);
      if (f2 - paramFloat3 >= 0.0F) {
        break label314;
      }
      bool1 = true;
      paramFloat3 = Math.abs(f1 - paramFloat1);
      if (f1 - paramFloat1 >= 0.0F) {
        break label320;
      }
      bool2 = true;
      paramFloat1 = paramFloat2 / f5;
      if (paramFloat1 >= 1.0F) {
        break label326;
      }
      bool3 = true;
      label224:
      if (!bool3) {
        break label332;
      }
    }
    label282:
    label314:
    label320:
    label326:
    label332:
    for (paramFloat1 = 1.0F - paramFloat1;; paramFloat1 -= 1.0F)
    {
      return new j(paramf, paramk, f3, f4, paramFloat4, bool1, paramFloat3, bool2, paramFloat1, bool3);
      if (((g)localObject).c < paramFloat1)
      {
        paramFloat2 = paramFloat1;
        break;
      }
      paramFloat2 = ((g)localObject).c;
      break;
      arrayOfFloat = a(((g)localObject).d, paramFloat3);
      localObject = a(((g)localObject).e, paramFloat4);
      paramFloat1 = f2;
      paramFloat3 = f1;
      break label132;
      bool1 = false;
      break label190;
      bool2 = false;
      break label210;
      bool3 = false;
      break label224;
    }
    label339:
    return null;
  }
  
  private static float[] a(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    float[] tmp5_4 = arrayOfFloat;
    tmp5_4[0] = 0.0F;
    float[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0.0F;
    tmp9_5;
    paramFloat1 -= paramFloat2;
    if (paramFloat1 > 0.0F) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      arrayOfFloat[0] = (0.0F - paramFloat1);
      arrayOfFloat[1] = 0.0F;
      return arrayOfFloat;
    }
    arrayOfFloat[0] = (Math.abs(paramFloat1) / 2.0F);
    arrayOfFloat[1] = arrayOfFloat[0];
    return arrayOfFloat;
  }
  
  public void a()
  {
    this.r = true;
  }
  
  public void a(Matrix paramMatrix)
  {
    paramMatrix.set(this.b);
    this.p = ((float)(SystemClock.uptimeMillis() - this.c) / 180.0F);
    this.q = this.l.getInterpolation(this.p);
    if ((this.p >= 1.0F) || (this.r))
    {
      this.m = this.f;
      this.n = this.g;
      this.o = this.h;
      if (this.a != null) {
        this.a.a(this);
      }
      if (!this.i) {
        break label240;
      }
      f1 = 0.0F - this.m;
      label110:
      this.m = f1;
      if (!this.j) {
        break label248;
      }
      f1 = 0.0F - this.n;
      label129:
      this.n = f1;
      if (!this.k) {
        break label256;
      }
    }
    label240:
    label248:
    label256:
    for (float f1 = 1.0F - this.o;; f1 = this.o + 1.0F)
    {
      this.o = f1;
      paramMatrix.postTranslate(this.m, this.n);
      paramMatrix.postScale(this.o, this.o, this.d + this.m, this.e + this.n);
      return;
      this.m = (this.q * this.f);
      this.n = (this.q * this.g);
      this.o = (this.q * this.h);
      break;
      f1 = this.m;
      break label110;
      f1 = this.n;
      break label129;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/gallery/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */