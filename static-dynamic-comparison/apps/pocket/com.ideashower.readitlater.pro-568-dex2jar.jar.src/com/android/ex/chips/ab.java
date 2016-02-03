package com.android.ex.chips;

import android.content.Context;
import android.text.util.Rfc822Token;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ab
  extends ArrayAdapter
{
  private int a;
  private final LayoutInflater b;
  
  public ab(Context paramContext, int paramInt, aa paramaa)
  {
    super(paramContext, paramInt, new aa[] { paramaa });
    this.b = LayoutInflater.from(paramContext);
    this.a = paramInt;
  }
  
  private View a()
  {
    return this.b.inflate(this.a, null);
  }
  
  private void a(View paramView, Context paramContext, aa paramaa)
  {
    paramContext = (TextView)paramView.findViewById(16908310);
    ImageView localImageView = (ImageView)paramView.findViewById(16908294);
    paramContext.setText(paramaa.b());
    paramContext.setVisibility(0);
    localImageView.setVisibility(0);
    ((TextView)paramView.findViewById(16908308)).setText(android.text.util.Rfc822Tokenizer.tokenize(paramaa.c())[0].getAddress());
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = a();
    }
    a(paramViewGroup, paramViewGroup.getContext(), (aa)getItem(paramInt));
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */