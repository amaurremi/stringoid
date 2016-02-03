package com.magmamobile.mmusia.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.parser.data.ItemNews;
import com.magmamobile.mmusia.views.ImageViewEx;
import com.magmamobile.mmusia.views.ItemView;
import java.text.SimpleDateFormat;

public class NewsListAdapterEx
  extends BaseAdapter
{
  private SimpleDateFormat formaterDate = new SimpleDateFormat("yyyy-MM-dd");
  private Context mContext = null;
  private ItemNews[] myDatas = null;
  
  public NewsListAdapterEx(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int getCount()
  {
    return this.myDatas.length;
  }
  
  public ItemNews getItem(int paramInt)
  {
    return this.myDatas[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ItemView(this.mContext).getRootView();
      paramViewGroup = new ViewHolder();
      paramViewGroup.linearItem = ((LinearLayout)paramView.findViewById(MMUSIA.RES_ID_ITEM_LINEARITEM));
      paramViewGroup.txtTitle = ((TextView)paramView.findViewById(MMUSIA.RES_ID_ITEM_TITLE));
      paramViewGroup.txtDate = ((TextView)paramView.findViewById(MMUSIA.RES_ID_ITEM_DATE));
      paramViewGroup.txtDesc = ((TextView)paramView.findViewById(MMUSIA.RES_ID_ITEM_DESC));
      paramViewGroup.img = ((ImageViewEx)paramView.findViewById(MMUSIA.RES_ID_ITEM_IMG));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.linearItem.setVisibility(0);
      ItemNews localItemNews = this.myDatas[paramInt];
      paramViewGroup.txtTitle.setText(localItemNews.NewsTitle);
      paramViewGroup.txtDesc.setText(localItemNews.NewsDesc);
      paramViewGroup.txtDate.setText(this.formaterDate.format(localItemNews.NewsDate));
      paramViewGroup.img.setImageDrawable(MCommon.getAssetDrawable((Activity)this.mContext, "mussianews32.png"));
      if (!localItemNews.imgUrl.equals(""))
      {
        paramViewGroup.img.setRemoteURI(localItemNews.imgUrl);
        paramViewGroup.img.loadImage(this.mContext);
      }
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  public void setData(ItemNews[] paramArrayOfItemNews)
  {
    this.myDatas = paramArrayOfItemNews;
  }
  
  public static class ViewHolder
  {
    ImageViewEx img;
    LinearLayout linearItem;
    TextView txtDate;
    TextView txtDesc;
    TextView txtTitle;
  }
  
  public static class ViewHolderLoading
  {
    TextView txtTitle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/adapters/NewsListAdapterEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */