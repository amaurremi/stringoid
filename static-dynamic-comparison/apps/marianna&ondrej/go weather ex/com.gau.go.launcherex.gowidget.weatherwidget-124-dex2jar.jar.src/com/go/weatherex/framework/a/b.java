package com.go.weatherex.framework.a;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gtp.a.a.b.c;

public class b
  implements a
{
  private static final SparseArray a = new SparseArray(3);
  private static final a b = new b();
  
  private Typeface a(Context paramContext, int paramInt1, int paramInt2)
  {
    SparseArray localSparseArray = (SparseArray)a.get(paramInt1);
    if (localSparseArray == null)
    {
      localSparseArray = new SparseArray(4);
      a.put(paramInt1, localSparseArray);
    }
    for (;;)
    {
      Typeface localTypeface2 = (Typeface)localSparseArray.get(paramInt2);
      Typeface localTypeface1 = localTypeface2;
      if (localTypeface2 == null)
      {
        localTypeface1 = b(paramContext, paramInt1, paramInt2);
        localSparseArray.put(paramInt2, localTypeface1);
      }
      return localTypeface1;
    }
  }
  
  public static a a()
  {
    return b;
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView, paramInt1, paramInt2);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof TextView)) {
          a((TextView)localView, paramInt1, paramInt2);
        }
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, boolean paramBoolean)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView, paramInt, paramBoolean);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof TextView)) {
          a((TextView)localView, paramInt, paramBoolean);
        }
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTypeface(a(paramTextView.getContext(), paramInt1, paramInt2), paramInt2);
  }
  
  private void a(TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (paramTextView.getTypeface() != null) {
        i = paramTextView.getTypeface().getStyle();
      }
    }
    paramTextView.setTypeface(a(paramTextView.getContext(), paramInt, i), i);
  }
  
  private Typeface b(Context paramContext, int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("fontType : " + paramInt1 + " has not be defined yet");
    case 1: 
      paramContext = Typeface.defaultFromStyle(paramInt2);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      c.a("FontManagerImpl", "typeface.getStyle: " + paramContext.getStyle() + " ,loadTypeface" + paramInt1 + " cost time: " + (l2 - l1));
      return paramContext;
      paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Thin.ttf");
      continue;
      paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Light.ttf");
      continue;
      if (paramInt2 == 3) {
        paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-BoldItalic.ttf");
      } else if (paramInt2 == 1) {
        paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Bold.ttf");
      } else if (paramInt2 == 2) {
        paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Italic.ttf");
      } else {
        paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Regular.ttf");
      }
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof TextView)) {
      a((TextView)paramView, paramInt1, paramInt2);
    }
    while (!(paramView instanceof ViewGroup)) {
      return;
    }
    a((ViewGroup)paramView, paramInt1, paramInt2);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if ((paramView instanceof TextView)) {
      a((TextView)paramView, paramInt, paramBoolean);
    }
    while (!(paramView instanceof ViewGroup)) {
      return;
    }
    a((ViewGroup)paramView, paramInt, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/framework/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */