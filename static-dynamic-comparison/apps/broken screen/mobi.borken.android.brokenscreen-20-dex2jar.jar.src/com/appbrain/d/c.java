package com.appbrain.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;

public class c
  extends LayerDrawable
{
  private int a = -1;
  private float[] b;
  private ColorFilter c;
  private ColorFilter d;
  private ColorFilter e;
  private ColorFilter f;
  
  public c(Drawable[] paramArrayOfDrawable, float[] paramArrayOfFloat)
  {
    super(paramArrayOfDrawable);
    this.b = paramArrayOfFloat;
    a();
  }
  
  private static Drawable a(Drawable paramDrawable, Context paramContext)
  {
    if ((paramDrawable instanceof GradientDrawable)) {
      return new e(paramDrawable.getConstantState().newDrawable(paramContext.getResources()));
    }
    return f.a(paramDrawable, paramContext.getResources());
  }
  
  public static c a(Context paramContext, Drawable paramDrawable)
  {
    return b(paramContext, paramDrawable);
  }
  
  public static c a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    paramContext = a(paramDrawable1, paramContext);
    paramDrawable1 = b();
    return new d(new Drawable[] { paramContext }, paramDrawable1, paramDrawable2);
  }
  
  private void a()
  {
    int j = 0;
    float[] arrayOfFloat = new float[this.b.length];
    System.arraycopy(this.b, 0, arrayOfFloat, 0, arrayOfFloat.length);
    int i = 0;
    int k;
    while (i < 3)
    {
      k = i * 5;
      arrayOfFloat[k] = ((float)(arrayOfFloat[k] * 1.25D));
      k = i * 5 + 1;
      arrayOfFloat[k] = ((float)(arrayOfFloat[k] * 1.25D));
      k = i * 5 + 2;
      arrayOfFloat[k] = ((float)(arrayOfFloat[k] * 1.25D));
      i += 1;
    }
    this.d = new ColorMatrixColorFilter(arrayOfFloat);
    System.arraycopy(this.b, 0, arrayOfFloat, 0, arrayOfFloat.length);
    i = 0;
    while (i < 3)
    {
      k = i * 5;
      arrayOfFloat[k] = ((float)(arrayOfFloat[k] * 0.8D));
      k = i * 5 + 1;
      arrayOfFloat[k] = ((float)(arrayOfFloat[k] * 0.8D));
      k = i * 5 + 2;
      arrayOfFloat[k] = ((float)(arrayOfFloat[k] * 0.8D));
      i += 1;
    }
    this.e = new ColorMatrixColorFilter(arrayOfFloat);
    System.arraycopy(this.b, 0, arrayOfFloat, 0, arrayOfFloat.length);
    i = j;
    while (i < 3)
    {
      float f1 = (this.b[i] + this.b[(i + 5)] + this.b[(i + 10)]) / 3.0F;
      arrayOfFloat[i] = ((arrayOfFloat[i] - f1) / 2.0F + f1);
      arrayOfFloat[(i + 5)] = ((arrayOfFloat[(i + 5)] - f1) / 2.0F + f1);
      arrayOfFloat[(i + 10)] = (f1 + (arrayOfFloat[(i + 10)] - f1) / 2.0F);
      i += 1;
    }
    this.f = new ColorMatrixColorFilter(arrayOfFloat);
    this.c = new ColorMatrixColorFilter(this.b);
    a(getState());
  }
  
  private void a(int[] paramArrayOfInt)
  {
    ColorFilter localColorFilter = this.c;
    int k = paramArrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfInt[i];
      if (m == 16842910) {
        j = 1;
      }
      if (m == 16842919) {
        localColorFilter = this.e;
      }
      if ((m == 16842908) || (m == 16842913)) {
        localColorFilter = this.d;
      }
      i += 1;
    }
    if (j == 0) {
      localColorFilter = this.f;
    }
    if (this.a != -1) {}
    for (paramArrayOfInt = getDrawable(this.a);; paramArrayOfInt = this)
    {
      paramArrayOfInt.setColorFilter(localColorFilter);
      invalidateSelf();
      return;
    }
  }
  
  public static c b(Context paramContext, Drawable paramDrawable)
  {
    paramContext = a(paramDrawable, paramContext);
    paramDrawable = b();
    return new c(new Drawable[] { paramContext }, paramDrawable);
  }
  
  private static float[] b()
  {
    float[] arrayOfFloat = new float[20];
    arrayOfFloat[18] = 1.0F;
    int i = Color.blue(-1);
    int j = Color.red(-1);
    int k = Color.green(-1);
    arrayOfFloat[0] = (j / 255.0F);
    arrayOfFloat[6] = (k / 255.0F);
    arrayOfFloat[12] = (i / 255.0F);
    return arrayOfFloat;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    a(paramArrayOfInt);
    return super.onStateChange(paramArrayOfInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */