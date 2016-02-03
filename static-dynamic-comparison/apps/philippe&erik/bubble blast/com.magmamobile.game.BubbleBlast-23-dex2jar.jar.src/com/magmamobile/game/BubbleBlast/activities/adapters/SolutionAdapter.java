package com.magmamobile.game.BubbleBlast.activities.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.utils.solutions.Solution;
import com.magmamobile.game.BubbleBlast.utils.solutions.SolutionItem;

public class SolutionAdapter
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private Solution sol;
  private Typeface tf;
  
  public SolutionAdapter(Context paramContext, Solution paramSolution)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.tf = modCommon.getTypeFace(paramContext, paramContext.getString(2131034112));
    this.sol = paramSolution;
  }
  
  public int getCount()
  {
    return this.sol.solutions.length;
  }
  
  public SolutionItem getItem(int paramInt)
  {
    return this.sol.solutions[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130903051, null);
      paramViewGroup = new ViewHolder();
      paramViewGroup.txtText = ((TextView)paramView.findViewById(2131099698));
      paramViewGroup.txtText.setTypeface(this.tf);
      paramViewGroup.img = ((ImageView)paramView.findViewById(2131099697));
      paramView.setTag(paramViewGroup);
    }
    while (paramInt >= getCount())
    {
      paramViewGroup.txtText.setText(this.mContext.getString(2131034118));
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
    SolutionItem localSolutionItem = getItem(paramInt);
    paramViewGroup.txtText.setText("#" + (paramInt + 1) + ") " + this.mContext.getString(2131034236) + " : " + localSolutionItem.touches + "\n" + localSolutionItem.solution);
    paramViewGroup.img.setImageResource(2130837517);
    return paramView;
  }
  
  public static class ViewHolder
  {
    ImageView img;
    TextView txtText;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/adapters/SolutionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */