package com.bluebird.mobile.tools.commonutils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class DimensionUtil
{
  public static int dip(int paramInt, Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commonutils/DimensionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */