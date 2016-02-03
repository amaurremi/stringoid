package com.mobisystems.mobiscanner.controller;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;

public class g
  extends Animation
{
  private final DocumentListFragment azB;
  private View azC;
  private LinearLayout.LayoutParams azD;
  private int azE;
  private int azF;
  private boolean azG = false;
  private boolean azH = false;
  private int azI;
  private int azJ;
  private View azK;
  private LinearLayout.LayoutParams azL;
  private boolean azM;
  private int azN;
  
  public g(DocumentListFragment paramDocumentListFragment, View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.azB = paramDocumentListFragment;
    setDuration(paramInt1);
    this.azC = paramView;
    this.azD = ((LinearLayout.LayoutParams)paramView.getLayoutParams());
    this.azE = paramInt2;
    this.azF = paramInt3;
    this.azG = paramBoolean1;
    if (this.azG)
    {
      this.azK = this.azB.getView().findViewById(2131165544);
      this.azL = ((LinearLayout.LayoutParams)this.azK.getLayoutParams());
      this.azI = this.azL.bottomMargin;
      this.azJ = (this.azI + (paramInt3 - paramInt2));
    }
    this.azM = paramBoolean2;
    this.azN = this.azE;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      i = this.azE + (int)((this.azF - this.azE) * paramFloat);
      this.azD.height = i;
      this.azC.requestLayout();
      if (this.azM)
      {
        j = this.azN;
        this.azB.mListView.smoothScrollBy(j - i, 0);
        this.azN = i;
      }
      if (this.azG)
      {
        this.azL.bottomMargin = (this.azI + (int)((this.azJ - this.azI) * paramFloat));
        this.azK.requestLayout();
      }
    }
    while (this.azH)
    {
      int i;
      int j;
      return;
    }
    this.azD.height = this.azF;
    this.azC.requestLayout();
    if (this.azM) {
      this.azB.mListView.smoothScrollBy(this.azN - this.azF, 1);
    }
    if (this.azG)
    {
      this.azL.bottomMargin = this.azJ;
      this.azK.requestLayout();
    }
    this.azH = true;
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */