package com.pocket.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ideashower.readitlater.activity.ay;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.ThemedIconButton;
import java.util.ArrayList;
import java.util.Iterator;

public class an
  extends BaseAdapter
{
  public ArrayList a = new ArrayList();
  LayoutInflater b;
  
  public an(al paramal, Context paramContext)
  {
    this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public boolean a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((a)localIterator.next()).g == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.b.inflate(al.b(this.c), paramViewGroup, false);
    paramViewGroup = (a)this.a.get(paramInt);
    Object localObject = (ThemedIconButton)paramView.findViewById(2131230995);
    TextView localTextView = (TextView)paramView.findViewById(2131230996);
    RadioButton localRadioButton = (RadioButton)paramView.findViewById(2131230997);
    if (paramViewGroup.e != -1) {
      ((ThemedIconButton)localObject).setImageResource(paramViewGroup.e);
    }
    for (;;)
    {
      localTextView.setText(paramViewGroup.c);
      localTextView.setTag(Integer.valueOf(paramViewGroup.g));
      if ((al.c(this.c)) && (((ay)paramViewGroup).a)) {
        localRadioButton.toggle();
      }
      return paramView;
      ((ThemedIconButton)localObject).setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)localTextView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j.a(0.0F);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */