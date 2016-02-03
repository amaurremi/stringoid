package com.magmamobile.mmusia.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.parser.data.ItemAppUpdate;
import com.magmamobile.mmusia.views.ItemView;
import java.text.SimpleDateFormat;

public class UpdatesListAdapterEx
  extends BaseAdapter
{
  private SimpleDateFormat formaterDate = new SimpleDateFormat("yyyy-MM-dd");
  private Context mContext = null;
  private ItemAppUpdate[] myDatas = null;
  
  public UpdatesListAdapterEx(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int getCount()
  {
    return this.myDatas.length;
  }
  
  public ItemAppUpdate getItem(int paramInt)
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
      paramViewGroup.img = ((ImageView)paramView.findViewById(MMUSIA.RES_ID_ITEM_IMG));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.linearItem.setVisibility(0);
      ItemAppUpdate localItemAppUpdate = this.myDatas[paramInt];
      paramViewGroup.txtTitle.setText(localItemAppUpdate.Name);
      paramViewGroup.txtDesc.setText(localItemAppUpdate.VersionName);
      paramViewGroup.txtDate.setText(this.formaterDate.format(localItemAppUpdate.UpdateDate));
      paramViewGroup.img.setImageDrawable(MCommon.getAssetDrawable((Activity)this.mContext, "mussiamarket32.png"));
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  public void setData(ItemAppUpdate[] paramArrayOfItemAppUpdate)
  {
    this.myDatas = paramArrayOfItemAppUpdate;
  }
  
  public static class ViewHolder
  {
    ImageView img;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/adapters/UpdatesListAdapterEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */