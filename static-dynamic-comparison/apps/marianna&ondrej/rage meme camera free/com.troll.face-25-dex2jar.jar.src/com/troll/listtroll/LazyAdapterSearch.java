package com.troll.listtroll;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class LazyAdapterSearch
  extends BaseAdapter
{
  private static LayoutInflater inflater = null;
  private Activity activity;
  List<TeamItem> itemFeed = new ArrayList();
  public int lastItem = 30;
  private Context mContext;
  
  public LazyAdapterSearch(Activity paramActivity, List<TeamItem> paramList, Context paramContext)
  {
    this.activity = paramActivity;
    this.mContext = paramContext;
    if (paramList != null)
    {
      this.itemFeed = paramList;
      inflater = (LayoutInflater)this.activity.getSystemService("layout_inflater");
    }
  }
  
  public int getCount()
  {
    return this.itemFeed.size();
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
    View localView = paramView;
    if (paramView == null) {
      localView = inflater.inflate(2130903047, paramViewGroup, false);
    }
    new TeamItem();
    paramView = (TeamItem)this.itemFeed.get(paramInt);
    paramViewGroup = (ImageView)localView.findViewById(2131165206);
    try
    {
      paramViewGroup.setImageResource(paramView.getImage().intValue());
      return localView;
    }
    catch (Exception paramView) {}
    return localView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/listtroll/LazyAdapterSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */