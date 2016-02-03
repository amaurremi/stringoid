package com.troll.face;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CropOptionAdapter
  extends ArrayAdapter<CropOption>
{
  private LayoutInflater mInflater;
  private ArrayList<CropOption> mOptions;
  
  public CropOptionAdapter(Context paramContext, ArrayList<CropOption> paramArrayList)
  {
    super(paramContext, 2130903041, paramArrayList);
    this.mOptions = paramArrayList;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.mInflater.inflate(2130903041, null);
    }
    paramView = (CropOption)this.mOptions.get(paramInt);
    if (paramView != null)
    {
      ((ImageView)paramViewGroup.findViewById(2131165188)).setImageDrawable(paramView.icon);
      ((TextView)paramViewGroup.findViewById(2131165189)).setText(paramView.title);
      return paramViewGroup;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/CropOptionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */