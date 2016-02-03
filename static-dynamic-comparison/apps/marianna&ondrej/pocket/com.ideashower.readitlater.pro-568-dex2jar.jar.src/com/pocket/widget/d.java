package com.pocket.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class d
{
  public static TextView a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramContext = (TextView)LayoutInflater.from(paramContext).inflate(2130903178, paramViewGroup, false);
    paramContext.setText(paramInt);
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */