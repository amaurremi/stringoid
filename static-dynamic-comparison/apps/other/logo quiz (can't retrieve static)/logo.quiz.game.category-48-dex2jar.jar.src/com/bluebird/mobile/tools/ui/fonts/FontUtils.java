package com.bluebird.mobile.tools.ui.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

public class FontUtils
{
  public static void setFont(TextView paramTextView, String paramString, Context paramContext)
  {
    try
    {
      paramTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), paramString));
      return;
    }
    catch (Exception paramTextView)
    {
      Log.e("FontUtils", "Error in setting font", paramTextView);
    }
  }
  
  public static void setFont(Collection<? extends TextView> paramCollection, String paramString, Context paramContext)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      setFont((TextView)paramCollection.next(), paramString, paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/ui/fonts/FontUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */