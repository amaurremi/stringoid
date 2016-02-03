package com.androidwasabi.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

class AdManager$FileListAdapter
  extends ArrayAdapter<AdManager.AdItem>
{
  private Context context;
  private ArrayList<AdManager.AdItem> items;
  private int resourceId;
  
  public AdManager$FileListAdapter(Context paramContext, int paramInt, ArrayList<AdManager.AdItem> paramArrayList)
  {
    super(paramContext, paramInt, paramArrayList);
    this.items = paramArrayList;
    this.context = paramContext;
    this.resourceId = paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(this.resourceId, null);
    }
    try
    {
      paramView = (AdManager.AdItem)this.items.get(paramInt);
      if (paramView != null)
      {
        Object localObject = (ImageView)paramViewGroup.findViewById(R.id.ad_image);
        if (localObject != null)
        {
          Bitmap localBitmap = AdManager.imageLoader.getImage(paramView.image);
          if (localBitmap != null) {
            ((ImageView)localObject).setImageBitmap(localBitmap);
          }
        }
        localObject = (TextView)paramViewGroup.findViewById(R.id.ad_name);
        if (localObject != null) {
          ((TextView)localObject).setText(paramView.name);
        }
        localObject = (TextView)paramViewGroup.findViewById(R.id.ad_description);
        if (localObject != null) {
          ((TextView)localObject).setText(paramView.description);
        }
        paramViewGroup.setTag(new String[] { paramView.url, paramView.directlink });
      }
      return paramViewGroup;
    }
    catch (Exception paramView) {}
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$FileListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */