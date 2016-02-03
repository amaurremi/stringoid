package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TabHost;

public class ReclickableTabHost
  extends TabHost
{
  private a aGk;
  
  public ReclickableTabHost(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReclickableTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(a parama)
  {
    this.aGk = parama;
  }
  
  public void setCurrentTab(int paramInt)
  {
    if (paramInt == getCurrentTab())
    {
      Log.d("", "clicked index = " + paramInt);
      if (this.aGk != null) {
        this.aGk.gg(paramInt);
      }
      return;
    }
    super.setCurrentTab(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void gg(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ReclickableTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */