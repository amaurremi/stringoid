package com.magmamobile.game.BubbleBlast.activities.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.magmamobile.game.BubbleBlast.utils.ScoreloopManager.BestScoresRetreiver.Result;

public class ScoreloopScoresAdapter
  extends BaseAdapter
{
  private ScoreloopManager.BestScoresRetreiver.Result[] apiData = null;
  private Context mContext = null;
  private LayoutInflater mInflater;
  
  public ScoreloopScoresAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.apiData == null) {
      return 0;
    }
    return this.apiData.length;
  }
  
  public ScoreloopManager.BestScoresRetreiver.Result getItem(int paramInt)
  {
    return this.apiData[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130903052, null);
      paramViewGroup = new ViewHolder();
      paramViewGroup.user = ((TextView)paramView.findViewById(2131099701));
      paramViewGroup.score = ((TextView)paramView.findViewById(2131099675));
      paramViewGroup.img = ((ImageView)paramView.findViewById(2131099700));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ScoreloopManager.BestScoresRetreiver.Result localResult = this.apiData[paramInt];
      localResult.tag = paramViewGroup;
      paramViewGroup.item = localResult;
      update(localResult);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  public void setData(ScoreloopManager.BestScoresRetreiver.Result[] paramArrayOfResult)
  {
    this.apiData = paramArrayOfResult;
  }
  
  public void update(ScoreloopManager.BestScoresRetreiver.Result paramResult)
  {
    ViewHolder localViewHolder = (ViewHolder)paramResult.tag;
    if (localViewHolder == null) {}
    while (localViewHolder.item != paramResult) {
      return;
    }
    localViewHolder.user.setText(paramResult.label);
    localViewHolder.score.setText(paramResult.score);
    if (paramResult.you)
    {
      localViewHolder.img.setImageBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130837516));
      return;
    }
    localViewHolder.img.setImageBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130837531));
  }
  
  public static class ViewHolder
  {
    ImageView img;
    Object item;
    TextView score;
    TextView user;
  }
  
  public static class ViewHolderLoading
  {
    TextView txtTitle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/adapters/ScoreloopScoresAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */