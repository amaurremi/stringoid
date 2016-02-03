package com.bluebird.mobile.tools.view;

import android.view.View;
import java.util.Collection;
import java.util.Iterator;

public class VisibilityUtils
{
  private static VisibilityUtils instance;
  
  public static VisibilityUtils getInstance()
  {
    if (instance == null) {
      instance = new VisibilityUtils();
    }
    return instance;
  }
  
  public void goneAll(Collection<? extends View> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((View)paramCollection.next()).setVisibility(8);
    }
  }
  
  public void goneView(View paramView)
  {
    paramView.setVisibility(8);
  }
  
  public void invisibleAll(Collection<? extends View> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((View)paramCollection.next()).setVisibility(4);
    }
  }
  
  public void invisibleView(View paramView)
  {
    paramView.setVisibility(4);
  }
  
  public void showAll(Collection<? extends View> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((View)paramCollection.next()).setVisibility(0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/view/VisibilityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */