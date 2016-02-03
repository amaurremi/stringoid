package com.jiubang.playsdk.detail.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.jiubang.playsdk.e;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.main.BitmapBean;
import java.util.ArrayList;

public class n
  extends BaseAdapter
{
  private Context a;
  private ArrayList b;
  private int c;
  
  public n(Context paramContext, ArrayList paramArrayList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramArrayList;
    this.c = paramInt;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.b != null) {
      return (BitmapBean)this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new KPNetworkImageView(this.a);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(this.c, -1));
    }
    for (;;)
    {
      paramViewGroup = (KPNetworkImageView)paramView;
      BitmapBean localBitmapBean = (BitmapBean)getItem(paramInt);
      if (localBitmapBean != null)
      {
        Bitmap localBitmap = localBitmapBean.a();
        if (localBitmap != null)
        {
          paramViewGroup.setImageBitmap(localBitmap);
          paramViewGroup.a("");
          paramViewGroup.a(0);
        }
      }
      else
      {
        return paramView;
      }
      paramViewGroup.a(localBitmapBean.b());
      paramViewGroup.a(e.g);
      return paramView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */