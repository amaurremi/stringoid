package com.mobeta.android.dslv;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class d
  extends b
{
  private int mDropDownLayout;
  private LayoutInflater mInflater;
  private int mLayout;
  
  public d(Context paramContext, int paramInt1, Cursor paramCursor, int paramInt2)
  {
    super(paramContext, paramCursor, paramInt2);
    this.mDropDownLayout = paramInt1;
    this.mLayout = paramInt1;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.mInflater.inflate(this.mDropDownLayout, paramViewGroup, false);
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.mInflater.inflate(this.mLayout, paramViewGroup, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobeta/android/dslv/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */