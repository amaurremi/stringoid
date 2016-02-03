package com.bubble.mobile.language.support;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class LanguageSpinnerAdapter
  extends ArrayAdapter<Drawable>
{
  protected final Activity context;
  protected final Drawable[] names;
  
  public LanguageSpinnerAdapter(Activity paramActivity, Drawable[] paramArrayOfDrawable)
  {
    super(paramActivity, R.layout.language_spinner_image, paramArrayOfDrawable);
    this.context = paramActivity;
    this.names = paramArrayOfDrawable;
  }
  
  private View getImageView(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = this.context.getLayoutInflater().inflate(R.layout.language_spinner_image, null, true);
      paramView.setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
      paramViewGroup = new ViewHolder();
      paramViewGroup.imageView = ((ImageView)paramView.findViewById(R.id.flagIcon));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.imageView.setImageDrawable(this.names[paramInt1]);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getImageView(paramInt, paramView, paramViewGroup, 20);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getImageView(paramInt, paramView, paramViewGroup, 0);
  }
  
  static class ViewHolder
  {
    public ImageView imageView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/mobile/language/support/LanguageSpinnerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */