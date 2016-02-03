package com.google.android.gms.plus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class PlusOneDummyView
  extends FrameLayout
{
  public static final String TAG = "PlusOneDummyView";
  
  public PlusOneDummyView(Context paramContext, int paramInt)
  {
    super(paramContext);
    paramContext = new Button(paramContext);
    paramContext.setEnabled(false);
    paramContext.setBackgroundDrawable(jT().a(paramInt));
    Point localPoint = cY(paramInt);
    addView(paramContext, new FrameLayout.LayoutParams(localPoint.x, localPoint.y, 17));
  }
  
  private Point cY(int paramInt)
  {
    int j = 24;
    int i = 20;
    Point localPoint = new Point();
    switch (paramInt)
    {
    default: 
      paramInt = 38;
      i = 24;
    }
    for (;;)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      float f1 = TypedValue.applyDimension(1, paramInt, localDisplayMetrics);
      float f2 = TypedValue.applyDimension(1, i, localDisplayMetrics);
      localPoint.x = ((int)(f1 + 0.5D));
      localPoint.y = ((int)(f2 + 0.5D));
      return localPoint;
      paramInt = 32;
      continue;
      i = 14;
      paramInt = j;
      continue;
      paramInt = 50;
    }
  }
  
  private f jT()
  {
    Object localObject2 = new d(getContext(), null);
    Object localObject1 = localObject2;
    if (!((f)localObject2).a()) {
      localObject1 = new e(getContext(), null);
    }
    localObject2 = localObject1;
    if (!((f)localObject1).a()) {
      localObject2 = new c(getContext(), null);
    }
    return (f)localObject2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/PlusOneDummyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */