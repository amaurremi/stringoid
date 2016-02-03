package com.venticake.retrica.editor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

public class EditorHeadButtonLayout
  extends RelativeLayout
{
  private boolean a;
  
  public EditorHeadButtonLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public EditorHeadButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EditorHeadButtonLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isSelected()
  {
    return this.a;
  }
  
  @SuppressLint({"NewApi"})
  public void setSelected(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (this.a) {}
    for (float f = 1.0F; Build.VERSION.SDK_INT < 11; f = 0.5F)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(f, f);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      startAnimation(localAlphaAnimation);
      return;
    }
    setAlpha(f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/editor/EditorHeadButtonLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */