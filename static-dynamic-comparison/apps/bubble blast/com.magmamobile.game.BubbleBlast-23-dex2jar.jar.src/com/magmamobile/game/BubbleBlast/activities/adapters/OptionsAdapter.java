package com.magmamobile.game.BubbleBlast.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class OptionsAdapter
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  public ArrayList<CustomItemList> myDatas = new ArrayList();
  
  public OptionsAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.myDatas.size();
  }
  
  public CustomItemList getItem(int paramInt)
  {
    return (CustomItemList)this.myDatas.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130903050, null);
      paramViewGroup = new ViewHolder();
      paramViewGroup.txtText = ((TextView)paramView.findViewById(2131099698));
      paramViewGroup.img = ((ImageView)paramView.findViewById(2131099697));
      paramView.setTag(paramViewGroup);
    }
    while (paramInt >= this.myDatas.size())
    {
      paramViewGroup.txtText.setText(this.mContext.getString(2131034118));
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
    CustomItemList localCustomItemList = (CustomItemList)this.myDatas.get(paramInt);
    paramViewGroup.txtText.setText(localCustomItemList.text);
    paramViewGroup.img.setImageBitmap(localCustomItemList.bm);
    return paramView;
  }
  
  public static class ViewHolder
  {
    ImageView img;
    TextView txtText;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/adapters/OptionsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */