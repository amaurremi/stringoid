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
import com.magmamobile.mmusia.parser.data.ItemMoreGames;
import com.magmamobile.mmusia.views.ImageViewEx;
import com.magmamobile.mmusia.views.ItemMoreGameView;

public class MoreGamesListAdapterEx
  extends BaseAdapter
{
  private Context mContext = null;
  private ItemMoreGames[] myDatas = null;
  
  public MoreGamesListAdapterEx(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int getCount()
  {
    return this.myDatas.length;
  }
  
  public ItemMoreGames getItem(int paramInt)
  {
    return this.myDatas[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ItemMoreGames localItemMoreGames;
    if (paramView == null)
    {
      paramView = new ItemMoreGameView(this.mContext).getRootView();
      paramViewGroup = new ViewHolder();
      paramViewGroup.linearItem = ((LinearLayout)paramView.findViewById(MMUSIA.RES_ID_ITEM_LINEARITEM));
      paramViewGroup.txtTitle = ((TextView)paramView.findViewById(MMUSIA.RES_ID_ITEM_TITLE));
      paramViewGroup.txtFree = ((TextView)paramView.findViewById(MMUSIA.RES_ID_MOREGAMES_ITEM_FREE));
      paramViewGroup.img = ((ImageViewEx)paramView.findViewById(MMUSIA.RES_ID_ITEM_IMG));
      paramView.setTag(paramViewGroup);
      paramViewGroup.linearItem.setVisibility(0);
      localItemMoreGames = this.myDatas[paramInt];
      paramViewGroup.txtTitle.setText(localItemMoreGames.title);
      paramViewGroup.img.setImageDrawable(MCommon.getAssetDrawable((Activity)this.mContext, "mussianews32.png"));
      if (localItemMoreGames.free != 1) {
        break label202;
      }
      paramViewGroup.txtFree.setText("Free");
    }
    for (;;)
    {
      if (!localItemMoreGames.urlImg.equals(""))
      {
        paramViewGroup.img.setRemoteURI(localItemMoreGames.urlImg);
        paramViewGroup.img.loadImage(this.mContext);
      }
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
      label202:
      paramViewGroup.txtFree.setText("");
    }
  }
  
  public void setData(ItemMoreGames[] paramArrayOfItemMoreGames)
  {
    this.myDatas = paramArrayOfItemMoreGames;
  }
  
  public static class ViewHolder
  {
    ImageViewEx img;
    LinearLayout linearItem;
    TextView txtFree;
    TextView txtTitle;
  }
  
  public static class ViewHolderLoading
  {
    TextView txtTitle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/adapters/MoreGamesListAdapterEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */