package com.troll.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class LazyFileAdapterPhoto
  extends BaseAdapter
{
  static final float[] DIMENSIONS_PORTRAIT = { 280.0F, 420.0F };
  private static LayoutInflater inflater = null;
  private Activity activity;
  public ImageStaticLoader imageLoader;
  Context mContext;
  Vector<ImageView> mySDCardImages;
  
  public LazyFileAdapterPhoto(Activity paramActivity, Context paramContext, Vector<ImageView> paramVector)
  {
    this.mContext = paramContext;
    this.activity = paramActivity;
    this.mySDCardImages = paramVector;
    if (paramVector != null)
    {
      inflater = (LayoutInflater)this.activity.getSystemService("layout_inflater");
      this.imageLoader = new ImageStaticLoader(this.activity.getApplicationContext());
    }
  }
  
  public List<ImageView> addListItem(List<ImageView> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext())
      {
        notifyDataSetChanged();
        return this.mySDCardImages;
      }
      ImageView localImageView = (ImageView)paramList.next();
      this.mySDCardImages.add(localImageView);
    }
  }
  
  public int getCount()
  {
    return this.mySDCardImages.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ImageView(this.mContext);
      float f = this.mContext.getResources().getDisplayMetrics().density;
      paramView.setLayoutParams(new AbsListView.LayoutParams((int)(DIMENSIONS_PORTRAIT[0] * f + 20.0F) / 2, (int)(DIMENSIONS_PORTRAIT[1] * f + 0.5F) / 3));
      paramView.setPadding(1, 1, 1, 1);
    }
    for (;;)
    {
      paramView.setImageDrawable(((ImageView)this.mySDCardImages.get(paramInt)).getDrawable());
      return paramView;
      paramView = (ImageView)paramView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/adapter/LazyFileAdapterPhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */