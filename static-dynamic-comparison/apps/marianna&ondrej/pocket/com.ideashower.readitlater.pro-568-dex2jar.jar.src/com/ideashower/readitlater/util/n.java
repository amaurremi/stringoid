package com.ideashower.readitlater.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.widget.TextView;

public class n
{
  private static int a;
  
  public static int a(Context paramContext)
  {
    if (a != 0) {
      return a;
    }
    try
    {
      a = ((TextView)LayoutInflater.from(paramContext).inflate(2130903090, null, false)).getTextColors().getDefaultColor();
      return a;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a = -1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */