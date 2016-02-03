package com.pioong.global;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class RecycleUtils
{
  public static void recursiveRecycle(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setBackgroundDrawable(null);
    ViewGroup localViewGroup;
    int j;
    int i;
    if ((paramView instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)paramView;
      j = localViewGroup.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        if (!(paramView instanceof AdapterView)) {
          localViewGroup.removeAllViews();
        }
        if ((paramView instanceof ImageView)) {
          ((ImageView)paramView).setImageDrawable(null);
        }
        return;
      }
      recursiveRecycle(localViewGroup.getChildAt(i));
      i += 1;
    }
  }
  
  public static void recursiveRecycle(List<WeakReference<View>> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      recursiveRecycle((View)((WeakReference)paramList.next()).get());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/global/RecycleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */