package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class hq
{
  public static String a(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if (paramAttributeSet == null) {
      paramString1 = null;
    }
    for (;;)
    {
      paramAttributeSet = paramString1;
      String str1;
      String str2;
      if (paramString1 != null)
      {
        paramAttributeSet = paramString1;
        if (paramString1.startsWith("@string/"))
        {
          paramAttributeSet = paramString1;
          if (paramBoolean1)
          {
            str1 = paramString1.substring("@string/".length());
            str2 = paramContext.getPackageName();
            paramAttributeSet = new TypedValue();
          }
        }
      }
      try
      {
        paramContext.getResources().getValue(str2 + ":string/" + str1, paramAttributeSet, true);
        if (paramAttributeSet.string != null)
        {
          paramAttributeSet = paramAttributeSet.string.toString();
          if ((paramBoolean2) && (paramAttributeSet == null)) {
            Log.w(paramString3, "Required XML attribute \"" + paramString2 + "\" missing");
          }
          return paramAttributeSet;
          paramString1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
        }
      }
      catch (Resources.NotFoundException paramContext)
      {
        for (;;)
        {
          Log.w(paramString3, "Could not find resource for " + paramString2 + ": " + paramString1);
          continue;
          Log.w(paramString3, "Resource " + paramString2 + " was not a string: " + paramAttributeSet);
          paramAttributeSet = paramString1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */