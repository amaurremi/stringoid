package com.bubble.mobile.language.support;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import java.util.ArrayList;
import java.util.List;

public class LanguageUtils
{
  public static List<LocaleCodes> getLocaleCodes(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    paramContext = ((Resources)localObject).obtainTypedArray(R.array.locale_codes);
    localObject = ((Resources)localObject).obtainTypedArray(R.array.locale_drawable);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramContext.length())
    {
      localArrayList.add(new LocaleCodes(i, paramContext.getString(i), ((TypedArray)localObject).getDrawable(i)));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/mobile/language/support/LanguageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */