package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.actionbarsherlock.R.attr;

public class IcsListPopupWindow
{
  private static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private ListAdapter mAdapter;
  private Context mContext;
  private View mDropDownAnchorView;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  private DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private Handler mHandler = new Handler();
  private final ListSelectorHider mHideSelector = new ListSelectorHider(null);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mListItemExpandMaximum = Integer.MAX_VALUE;
  private boolean mModal;
  private DataSetObserver mObserver;
  private final PopupWindowCompat mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable(null);
  private final PopupScrollListener mScrollListener = new PopupScrollListener(null);
  private Rect mTempRect = new Rect();
  private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor(null);
  
  public IcsListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public IcsListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.mContext = paramContext;
    this.mPopup = new PopupWindowCompat(paramContext, paramAttributeSet, paramInt);
    this.mPopup.setInputMethodMode(1);
  }
  
  public IcsListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    if (Build.VERSION.SDK_INT < 11) {}
    for (this.mPopup = new PopupWindowCompat(new ContextThemeWrapper(paramContext, paramInt2), paramAttributeSet, paramInt1);; this.mPopup = new PopupWindowCompat(paramContext, paramAttributeSet, paramInt1, paramInt2))
    {
      this.mPopup.setInputMethodMode(1);
      return;
    }
  }
  
  private int buildDropDown()
  {
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label212:
    int i;
    int j;
    if (this.mDropDownList == null)
    {
      localObject2 = this.mContext;
      if (!this.mModal)
      {
        bool1 = true;
        this.mDropDownList = new DropDownListView((Context)localObject2, bool1);
        if (this.mDropDownListHighlight != null) {
          this.mDropDownList.setSelector(this.mDropDownListHighlight);
        }
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = IcsListPopupWindow.this.mDropDownList;
              if (paramAnonymousAdapterView != null) {
                IcsListPopupWindow.DropDownListView.access$502(paramAnonymousAdapterView, false);
              }
            }
          }
          
          public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        if (this.mItemSelectedListener != null) {
          this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
        }
        localObject1 = this.mDropDownList;
        localView = this.mPromptView;
        if (localView == null) {
          break label524;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.mPromptPosition)
        {
        default: 
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, Integer.MIN_VALUE), 0);
          localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          i = localView.getMeasuredHeight();
          j = ((LinearLayout.LayoutParams)localObject1).topMargin;
          i = ((LinearLayout.LayoutParams)localObject1).bottomMargin + (i + j);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      this.mPopup.setContentView((View)localObject1);
      for (;;)
      {
        label272:
        localObject1 = this.mPopup.getBackground();
        int k;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top;
          k = this.mTempRect.bottom;
          if (!this.mDropDownVerticalOffsetSet) {
            this.mDropDownVerticalOffset = (-this.mTempRect.top);
          }
          j += k;
        }
        for (;;)
        {
          if (this.mPopup.getInputMethodMode() == 2) {}
          for (bool1 = bool2;; bool1 = false)
          {
            k = getMaxAvailableHeight(this.mDropDownAnchorView, this.mDropDownVerticalOffset, bool1);
            if (this.mDropDownHeight != -1) {
              break label485;
            }
            return k + j;
            bool1 = false;
            break;
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            ((LinearLayout)localObject2).addView(localView);
            break label212;
            ((LinearLayout)localObject2).addView(localView);
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            break label212;
            localObject1 = (ViewGroup)this.mPopup.getContentView();
            localObject1 = this.mPromptView;
            if (localObject1 == null) {
              break label519;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight();
            j = ((LinearLayout.LayoutParams)localObject2).topMargin;
            i = ((LinearLayout.LayoutParams)localObject2).bottomMargin + (i + j);
            break label272;
          }
          label485:
          int m = measureHeightOfChildren(0, 0, -1, k - i, -1);
          k = i;
          if (m > 0) {
            k = i + j;
          }
          return m + k;
          j = 0;
        }
        label519:
        i = 0;
      }
      label524:
      i = 0;
    }
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = localRect.bottom;
    if (paramBoolean) {
      i = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    i = Math.max(i - (arrayOfInt[1] + paramView.getHeight()) - paramInt, arrayOfInt[1] - localRect.top + paramInt);
    paramInt = i;
    if (this.mPopup.getBackground() != null)
    {
      this.mPopup.getBackground().getPadding(this.mTempRect);
      paramInt = i - (this.mTempRect.top + this.mTempRect.bottom);
    }
    return paramInt;
  }
  
  private boolean isInputMethodNotNeeded()
  {
    return this.mPopup.getInputMethodMode() == 2;
  }
  
  private int measureHeightOfChildren(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i1 = 0;
    Object localObject = this.mAdapter;
    if (localObject == null)
    {
      paramInt1 = this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
      return paramInt1;
    }
    int i2 = this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
    int j;
    label78:
    int i;
    int k;
    int m;
    int n;
    if ((this.mDropDownList.getDividerHeight() > 0) && (this.mDropDownList.getDivider() != null))
    {
      j = this.mDropDownList.getDividerHeight();
      i = i2;
      k = i1;
      m = paramInt2;
      n = paramInt3;
      if (paramInt3 == -1)
      {
        n = ((ListAdapter)localObject).getCount() - 1;
        m = paramInt2;
        k = i1;
        i = i2;
      }
    }
    for (;;)
    {
      if (m > n) {
        break label283;
      }
      localObject = this.mAdapter.getView(m, null, this.mDropDownList);
      if (this.mDropDownList.getCacheColorHint() != 0) {
        ((View)localObject).setDrawingCacheBackgroundColor(this.mDropDownList.getCacheColorHint());
      }
      measureScrapChild((View)localObject, m, paramInt1);
      paramInt2 = i;
      if (m > 0) {
        paramInt2 = i + j;
      }
      i = paramInt2 + ((View)localObject).getMeasuredHeight();
      if (i >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 < 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (m <= paramInt5) {
          break;
        }
        paramInt1 = paramInt4;
        if (k <= 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (i == paramInt4) {
          break;
        }
        return k;
        j = 0;
        break label78;
      }
      paramInt2 = k;
      if (paramInt5 >= 0)
      {
        paramInt2 = k;
        if (m >= paramInt5) {
          paramInt2 = i;
        }
      }
      m += 1;
      k = paramInt2;
    }
    label283:
    return i;
  }
  
  private void measureScrapChild(View paramView, int paramInt1, int paramInt2)
  {
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams1);
    }
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, this.mDropDownList.getPaddingLeft() + this.mDropDownList.getPaddingRight(), localLayoutParams1.width);
    paramInt1 = localLayoutParams1.height;
    if (paramInt1 > 0) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt2, paramInt1);
      return;
    }
  }
  
  public void clearListSelection()
  {
    DropDownListView localDropDownListView = this.mDropDownList;
    if (localDropDownListView != null)
    {
      DropDownListView.access$502(localDropDownListView, true);
      localDropDownListView.requestLayout();
    }
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
    if (this.mPromptView != null)
    {
      ViewParent localViewParent = this.mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.mPromptView);
      }
    }
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  public ListView getListView()
  {
    return this.mDropDownList;
  }
  
  public boolean isShowing()
  {
    return this.mPopup.isShowing();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new PopupDataSetObserver(null);
    }
    for (;;)
    {
      this.mAdapter = paramListAdapter;
      if (this.mAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.mDropDownList != null) {
        this.mDropDownList.setAdapter(this.mAdapter);
      }
      return;
      if (this.mAdapter != null) {
        this.mAdapter.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public void setAnchorView(View paramView)
  {
    this.mDropDownAnchorView = paramView;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.mPopup.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.mDropDownWidth = (this.mTempRect.left + this.mTempRect.right + paramInt);
      return;
    }
    this.mDropDownWidth = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  public void setModal(boolean paramBoolean)
  {
    this.mModal = true;
    this.mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public void setPromptPosition(int paramInt)
  {
    this.mPromptPosition = paramInt;
  }
  
  public void setSelection(int paramInt)
  {
    DropDownListView localDropDownListView = this.mDropDownList;
    if ((isShowing()) && (localDropDownListView != null))
    {
      DropDownListView.access$502(localDropDownListView, false);
      localDropDownListView.setSelection(paramInt);
      if (localDropDownListView.getChoiceMode() != 0) {
        localDropDownListView.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public void show()
  {
    int n = 0;
    int k = 0;
    int m = -1;
    int j = buildDropDown();
    boolean bool = isInputMethodNotNeeded();
    int i;
    if (this.mPopup.isShowing())
    {
      label52:
      PopupWindowCompat localPopupWindowCompat;
      if (this.mDropDownWidth == -1)
      {
        i = -1;
        if (this.mDropDownHeight != -1) {
          break label175;
        }
        if (!bool) {
          break label139;
        }
        if (!bool) {
          break label149;
        }
        localPopupWindowCompat = this.mPopup;
        if (this.mDropDownWidth != -1) {
          break label144;
        }
        k = m;
        label74:
        localPopupWindowCompat.setWindowLayoutMode(k, 0);
      }
      for (;;)
      {
        this.mPopup.setOutsideTouchable(true);
        this.mPopup.update(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, i, j);
        return;
        if (this.mDropDownWidth == -2)
        {
          i = this.mDropDownAnchorView.getWidth();
          break;
        }
        i = this.mDropDownWidth;
        break;
        label139:
        j = -1;
        break label52;
        label144:
        k = 0;
        break label74;
        label149:
        localPopupWindowCompat = this.mPopup;
        if (this.mDropDownWidth == -1) {
          k = -1;
        }
        localPopupWindowCompat.setWindowLayoutMode(k, -1);
        continue;
        label175:
        if (this.mDropDownHeight != -2) {
          j = this.mDropDownHeight;
        }
      }
    }
    if (this.mDropDownWidth == -1)
    {
      i = -1;
      label202:
      if (this.mDropDownHeight != -1) {
        break label352;
      }
      j = -1;
    }
    for (;;)
    {
      this.mPopup.setWindowLayoutMode(i, j);
      this.mPopup.setOutsideTouchable(true);
      this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
      this.mPopup.showAsDropDown(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
      this.mDropDownList.setSelection(-1);
      if ((!this.mModal) || (this.mDropDownList.isInTouchMode())) {
        clearListSelection();
      }
      if (this.mModal) {
        break;
      }
      this.mHandler.post(this.mHideSelector);
      return;
      if (this.mDropDownWidth == -2)
      {
        this.mPopup.setWidth(this.mDropDownAnchorView.getWidth());
        i = 0;
        break label202;
      }
      this.mPopup.setWidth(this.mDropDownWidth);
      i = 0;
      break label202;
      label352:
      if (this.mDropDownHeight == -2)
      {
        this.mPopup.setHeight(j);
        j = n;
      }
      else
      {
        this.mPopup.setHeight(this.mDropDownHeight);
        j = n;
      }
    }
  }
  
  private static class DropDownListView
    extends ListView
  {
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    
    public DropDownListView(Context paramContext, boolean paramBoolean)
    {
      super(null, R.attr.dropDownListViewStyle);
      this.mHijackFocus = paramBoolean;
      setCacheColorHint(0);
    }
    
    public boolean hasFocus()
    {
      return (this.mHijackFocus) || (super.hasFocus());
    }
    
    public boolean hasWindowFocus()
    {
      return (this.mHijackFocus) || (super.hasWindowFocus());
    }
    
    public boolean isFocused()
    {
      return (this.mHijackFocus) || (super.isFocused());
    }
    
    public boolean isInTouchMode()
    {
      return ((this.mHijackFocus) && (this.mListSelectionHidden)) || (super.isInTouchMode());
    }
  }
  
  private class ListSelectorHider
    implements Runnable
  {
    private ListSelectorHider() {}
    
    public void run()
    {
      IcsListPopupWindow.this.clearListSelection();
    }
  }
  
  private class PopupDataSetObserver
    extends DataSetObserver
  {
    private PopupDataSetObserver() {}
    
    public void onChanged()
    {
      if (IcsListPopupWindow.this.isShowing()) {
        IcsListPopupWindow.this.show();
      }
    }
    
    public void onInvalidated()
    {
      IcsListPopupWindow.this.dismiss();
    }
  }
  
  private class PopupScrollListener
    implements AbsListView.OnScrollListener
  {
    private PopupScrollListener() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!IcsListPopupWindow.this.isInputMethodNotNeeded()) && (IcsListPopupWindow.this.mPopup.getContentView() != null))
      {
        IcsListPopupWindow.this.mHandler.removeCallbacks(IcsListPopupWindow.this.mResizePopupRunnable);
        IcsListPopupWindow.this.mResizePopupRunnable.run();
      }
    }
  }
  
  private class PopupTouchInterceptor
    implements View.OnTouchListener
  {
    private PopupTouchInterceptor() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (IcsListPopupWindow.this.mPopup != null) && (IcsListPopupWindow.this.mPopup.isShowing()) && (j >= 0) && (j < IcsListPopupWindow.this.mPopup.getWidth()) && (k >= 0) && (k < IcsListPopupWindow.this.mPopup.getHeight())) {
        IcsListPopupWindow.this.mHandler.postDelayed(IcsListPopupWindow.this.mResizePopupRunnable, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          IcsListPopupWindow.this.mHandler.removeCallbacks(IcsListPopupWindow.this.mResizePopupRunnable);
        }
      }
    }
  }
  
  private class ResizePopupRunnable
    implements Runnable
  {
    private ResizePopupRunnable() {}
    
    public void run()
    {
      if ((IcsListPopupWindow.this.mDropDownList != null) && (IcsListPopupWindow.this.mDropDownList.getCount() > IcsListPopupWindow.this.mDropDownList.getChildCount()) && (IcsListPopupWindow.this.mDropDownList.getChildCount() <= IcsListPopupWindow.this.mListItemExpandMaximum))
      {
        IcsListPopupWindow.this.mPopup.setInputMethodMode(2);
        IcsListPopupWindow.this.show();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/widget/IcsListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */