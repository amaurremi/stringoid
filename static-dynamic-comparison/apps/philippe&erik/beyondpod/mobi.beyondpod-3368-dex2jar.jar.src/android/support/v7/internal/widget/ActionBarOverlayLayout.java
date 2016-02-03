package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarOverlayLayout
  extends FrameLayout
{
  static final int[] mActionBarSizeAttr = { R.attr.actionBarSize };
  private ActionBar mActionBar;
  private View mActionBarBottom;
  private int mActionBarHeight;
  private View mActionBarTop;
  private ActionBarView mActionView;
  private ActionBarContainer mContainerView;
  private View mContent;
  private final Rect mZeroRect = new Rect(0, 0, 0, 0);
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private boolean applyInsets(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool2 = false;
    paramView = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (paramView.leftMargin != paramRect.left)
      {
        bool1 = true;
        paramView.leftMargin = paramRect.left;
      }
    }
    paramBoolean1 = bool1;
    if (paramBoolean2)
    {
      paramBoolean1 = bool1;
      if (paramView.topMargin != paramRect.top)
      {
        paramBoolean1 = true;
        paramView.topMargin = paramRect.top;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      paramBoolean2 = paramBoolean1;
      if (paramView.rightMargin != paramRect.right)
      {
        paramBoolean2 = true;
        paramView.rightMargin = paramRect.right;
      }
    }
    paramBoolean1 = paramBoolean2;
    if (paramBoolean3)
    {
      paramBoolean1 = paramBoolean2;
      if (paramView.bottomMargin != paramRect.bottom)
      {
        paramBoolean1 = true;
        paramView.bottomMargin = paramRect.bottom;
      }
    }
    return paramBoolean1;
  }
  
  private void init(Context paramContext)
  {
    paramContext = getContext().getTheme().obtainStyledAttributes(mActionBarSizeAttr);
    this.mActionBarHeight = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
  }
  
  void pullChildren()
  {
    if (this.mContent == null)
    {
      this.mContent = findViewById(R.id.action_bar_activity_content);
      if (this.mContent == null) {
        this.mContent = findViewById(16908290);
      }
      this.mActionBarTop = findViewById(R.id.top_action_bar);
      this.mContainerView = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      this.mActionView = ((ActionBarView)findViewById(R.id.action_bar));
      this.mActionBarBottom = findViewById(R.id.split_action_bar);
    }
  }
  
  public void setActionBar(ActionBar paramActionBar)
  {
    this.mActionBar = paramActionBar;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/internal/widget/ActionBarOverlayLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */