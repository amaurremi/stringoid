package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.appcompat.R.attr;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class ListPopupWindow
{
  private static final boolean DEBUG = false;
  private static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int FILL_PARENT = -1;
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private static final String TAG = "ListPopupWindow";
  public static final int WRAP_CONTENT = -2;
  private ListAdapter mAdapter;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  private View mDropDownAnchorView;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  private DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private boolean mForceIgnoreOutsideTouch = false;
  private Handler mHandler = new Handler();
  private final ListSelectorHider mHideSelector = new ListSelectorHider(null);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mLayoutDirection;
  int mListItemExpandMaximum = Integer.MAX_VALUE;
  private boolean mModal;
  private DataSetObserver mObserver;
  private PopupWindow mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable(null);
  private final PopupScrollListener mScrollListener = new PopupScrollListener(null);
  private Runnable mShowDropDownRunnable;
  private Rect mTempRect = new Rect();
  private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor(null);
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.mContext = paramContext;
    this.mPopup = new PopupWindow(paramContext, paramAttributeSet, paramInt);
    this.mPopup.setInputMethodMode(1);
    paramContext = this.mContext.getResources().getConfiguration().locale;
  }
  
  private int buildDropDown()
  {
    int j = 0;
    int i = 0;
    Object localObject3;
    Object localObject2;
    View localView;
    Object localObject1;
    label260:
    label313:
    int k;
    if (this.mDropDownList == null)
    {
      localObject3 = this.mContext;
      this.mShowDropDownRunnable = new Runnable()
      {
        public void run()
        {
          View localView = ListPopupWindow.this.getAnchorView();
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
        }
      };
      if (!this.mModal)
      {
        bool = true;
        this.mDropDownList = new DropDownListView((Context)localObject3, bool);
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
              paramAnonymousAdapterView = ListPopupWindow.this.mDropDownList;
              if (paramAnonymousAdapterView != null) {
                ListPopupWindow.DropDownListView.access$502(paramAnonymousAdapterView, false);
              }
            }
          }
          
          public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        if (this.mItemSelectedListener != null) {
          this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
        }
        localObject2 = this.mDropDownList;
        localView = this.mPromptView;
        localObject1 = localObject2;
        if (localView != null)
        {
          localObject1 = new LinearLayout((Context)localObject3);
          ((LinearLayout)localObject1).setOrientation(1);
          localObject3 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        }
        switch (this.mPromptPosition)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + this.mPromptPosition);
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, Integer.MIN_VALUE), 0);
          localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          i = localView.getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
          this.mPopup.setContentView((View)localObject1);
          k = 0;
          localObject1 = this.mPopup.getBackground();
          if (localObject1 != null)
          {
            ((Drawable)localObject1).getPadding(this.mTempRect);
            j = this.mTempRect.top + this.mTempRect.bottom;
            k = j;
            if (!this.mDropDownVerticalOffsetSet)
            {
              this.mDropDownVerticalOffset = (-this.mTempRect.top);
              k = j;
            }
            label378:
            if (this.mPopup.getInputMethodMode() != 2) {
              break label538;
            }
          }
          break;
        }
      }
    }
    int m;
    label538:
    for (boolean bool = true;; bool = false)
    {
      m = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, bool);
      if ((!this.mDropDownAlwaysVisible) && (this.mDropDownHeight != -1)) {
        break label544;
      }
      return m + k;
      bool = false;
      break;
      ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((LinearLayout)localObject1).addView(localView);
      break label260;
      ((LinearLayout)localObject1).addView(localView);
      ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      break label260;
      localObject1 = (ViewGroup)this.mPopup.getContentView();
      localObject1 = this.mPromptView;
      i = j;
      if (localObject1 == null) {
        break label313;
      }
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      i = ((View)localObject1).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
      break label313;
      this.mTempRect.setEmpty();
      break label378;
    }
    label544:
    switch (this.mDropDownWidth)
    {
    default: 
      j = View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
    }
    for (;;)
    {
      m = this.mDropDownList.measureHeightOfChildrenCompat(j, 0, -1, m - i, -1);
      j = i;
      if (m > 0) {
        j = i + k;
      }
      return m + j;
      j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
      continue;
      j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
    }
  }
  
  private void removePromptView()
  {
    if (this.mPromptView != null)
    {
      ViewParent localViewParent = this.mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.mPromptView);
      }
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
    removePromptView();
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  public View getAnchorView()
  {
    return this.mDropDownAnchorView;
  }
  
  public int getAnimationStyle()
  {
    return this.mPopup.getAnimationStyle();
  }
  
  public Drawable getBackground()
  {
    return this.mPopup.getBackground();
  }
  
  public int getHeight()
  {
    return this.mDropDownHeight;
  }
  
  public int getHorizontalOffset()
  {
    return this.mDropDownHorizontalOffset;
  }
  
  public int getInputMethodMode()
  {
    return this.mPopup.getInputMethodMode();
  }
  
  public ListView getListView()
  {
    return this.mDropDownList;
  }
  
  public int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
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
  
  public int getPromptPosition()
  {
    return this.mPromptPosition;
  }
  
  public Object getSelectedItem()
  {
    if (!isShowing()) {
      return null;
    }
    return this.mDropDownList.getSelectedItem();
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {
      return Long.MIN_VALUE;
    }
    return this.mDropDownList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {
      return -1;
    }
    return this.mDropDownList.getSelectedItemPosition();
  }
  
  public View getSelectedView()
  {
    if (!isShowing()) {
      return null;
    }
    return this.mDropDownList.getSelectedView();
  }
  
  public int getSoftInputMode()
  {
    return this.mPopup.getSoftInputMode();
  }
  
  public int getVerticalOffset()
  {
    if (!this.mDropDownVerticalOffsetSet) {
      return 0;
    }
    return this.mDropDownVerticalOffset;
  }
  
  public int getWidth()
  {
    return this.mDropDownWidth;
  }
  
  public boolean isDropDownAlwaysVisible()
  {
    return this.mDropDownAlwaysVisible;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    return this.mPopup.getInputMethodMode() == 2;
  }
  
  public boolean isModal()
  {
    return this.mModal;
  }
  
  public boolean isShowing()
  {
    return this.mPopup.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int m;
    int k;
    int i;
    int j;
    if ((isShowing()) && (paramInt != 62) && ((this.mDropDownList.getSelectedItemPosition() >= 0) || ((paramInt != 66) && (paramInt != 23))))
    {
      m = this.mDropDownList.getSelectedItemPosition();
      ListAdapter localListAdapter;
      if (!this.mPopup.isAboveAnchor())
      {
        k = 1;
        localListAdapter = this.mAdapter;
        i = Integer.MAX_VALUE;
        j = Integer.MIN_VALUE;
        if (localListAdapter != null)
        {
          boolean bool = localListAdapter.areAllItemsEnabled();
          if (!bool) {
            break label167;
          }
          i = 0;
          label92:
          if (!bool) {
            break label180;
          }
        }
      }
      label167:
      label180:
      for (j = localListAdapter.getCount() - 1;; j = this.mDropDownList.lookForSelectablePosition(localListAdapter.getCount() - 1, false))
      {
        if (((k == 0) || (paramInt != 19) || (m > i)) && ((k != 0) || (paramInt != 20) || (m < j))) {
          break label202;
        }
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
        k = 0;
        break;
        i = this.mDropDownList.lookForSelectablePosition(0, true);
        break label92;
      }
      label202:
      DropDownListView.access$502(this.mDropDownList, false);
      if (!this.mDropDownList.onKeyDown(paramInt, paramKeyEvent)) {
        break label290;
      }
      this.mPopup.setInputMethodMode(2);
      this.mDropDownList.requestFocusFromTouch();
      show();
      switch (paramInt)
      {
      }
    }
    label290:
    do
    {
      do
      {
        return false;
        if ((k == 0) || (paramInt != 20)) {
          break;
        }
      } while (m != j);
      return true;
    } while ((k != 0) || (paramInt != 19) || (m != i));
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((isShowing()) && (this.mDropDownList.getSelectedItemPosition() >= 0))
    {
      boolean bool = this.mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if (bool) {}
      switch (paramInt)
      {
      default: 
        return bool;
      }
      dismiss();
      return bool;
    }
    return false;
  }
  
  public boolean performItemClick(int paramInt)
  {
    if (isShowing())
    {
      if (this.mItemClickListener != null)
      {
        DropDownListView localDropDownListView = this.mDropDownList;
        View localView = localDropDownListView.getChildAt(paramInt - localDropDownListView.getFirstVisiblePosition());
        ListAdapter localListAdapter = localDropDownListView.getAdapter();
        this.mItemClickListener.onItemClick(localDropDownListView, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
      return true;
    }
    return false;
  }
  
  public void postShow()
  {
    this.mHandler.post(this.mShowDropDownRunnable);
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
  
  public void setAnimationStyle(int paramInt)
  {
    this.mPopup.setAnimationStyle(paramInt);
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
    setWidth(paramInt);
  }
  
  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    this.mDropDownAlwaysVisible = paramBoolean;
  }
  
  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    this.mForceIgnoreOutsideTouch = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    this.mDropDownHeight = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  void setListItemExpandMax(int paramInt)
  {
    this.mListItemExpandMaximum = paramInt;
  }
  
  public void setListSelector(Drawable paramDrawable)
  {
    this.mDropDownListHighlight = paramDrawable;
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
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.mItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setPromptPosition(int paramInt)
  {
    this.mPromptPosition = paramInt;
  }
  
  public void setPromptView(View paramView)
  {
    boolean bool = isShowing();
    if (bool) {
      removePromptView();
    }
    this.mPromptView = paramView;
    if (bool) {
      show();
    }
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
  
  public void setSoftInputMode(int paramInt)
  {
    this.mPopup.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt)
  {
    this.mDropDownWidth = paramInt;
  }
  
  public void show()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int k = -1;
    int j = buildDropDown();
    int i = 0;
    int m = 0;
    boolean bool3 = isInputMethodNotNeeded();
    label57:
    PopupWindow localPopupWindow;
    if (this.mPopup.isShowing())
    {
      if (this.mDropDownWidth == -1)
      {
        i = -1;
        if (this.mDropDownHeight != -1) {
          break label212;
        }
        if (!bool3) {
          break label171;
        }
        if (!bool3) {
          break label181;
        }
        localPopupWindow = this.mPopup;
        if (this.mDropDownWidth != -1) {
          break label176;
        }
        label76:
        localPopupWindow.setWindowLayoutMode(k, 0);
      }
      for (;;)
      {
        localPopupWindow = this.mPopup;
        bool1 = bool2;
        if (!this.mForceIgnoreOutsideTouch)
        {
          bool1 = bool2;
          if (!this.mDropDownAlwaysVisible) {
            bool1 = true;
          }
        }
        localPopupWindow.setOutsideTouchable(bool1);
        this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, i, j);
        return;
        if (this.mDropDownWidth == -2)
        {
          i = getAnchorView().getWidth();
          break;
        }
        i = this.mDropDownWidth;
        break;
        label171:
        j = -1;
        break label57;
        label176:
        k = 0;
        break label76;
        label181:
        localPopupWindow = this.mPopup;
        if (this.mDropDownWidth == -1) {}
        for (k = -1;; k = 0)
        {
          localPopupWindow.setWindowLayoutMode(k, -1);
          break;
        }
        label212:
        if (this.mDropDownHeight != -2) {
          j = this.mDropDownHeight;
        }
      }
    }
    if (this.mDropDownWidth == -1)
    {
      i = -1;
      label242:
      if (this.mDropDownHeight != -1) {
        break label407;
      }
      j = -1;
      label252:
      this.mPopup.setWindowLayoutMode(i, j);
      localPopupWindow = this.mPopup;
      if ((this.mForceIgnoreOutsideTouch) || (this.mDropDownAlwaysVisible)) {
        break label447;
      }
    }
    for (;;)
    {
      localPopupWindow.setOutsideTouchable(bool1);
      this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
      this.mPopup.showAsDropDown(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
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
        this.mPopup.setWidth(getAnchorView().getWidth());
        break label242;
      }
      this.mPopup.setWidth(this.mDropDownWidth);
      break label242;
      label407:
      if (this.mDropDownHeight == -2)
      {
        this.mPopup.setHeight(j);
        j = m;
        break label252;
      }
      this.mPopup.setHeight(this.mDropDownHeight);
      j = m;
      break label252;
      label447:
      bool1 = false;
    }
  }
  
  private static class DropDownListView
    extends ListView
  {
    public static final int INVALID_POSITION = -1;
    static final int NO_POSITION = -1;
    private static final String TAG = "ListPopupWindow.DropDownListView";
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    
    public DropDownListView(Context paramContext, boolean paramBoolean)
    {
      super(null, R.attr.dropDownListViewStyle);
      this.mHijackFocus = paramBoolean;
      setCacheColorHint(0);
    }
    
    private int lookForSelectablePosition(int paramInt, boolean paramBoolean)
    {
      ListAdapter localListAdapter = getAdapter();
      if ((localListAdapter == null) || (isInTouchMode())) {}
      int j;
      do
      {
        int i;
        do
        {
          return -1;
          j = localListAdapter.getCount();
          if (getAdapter().areAllItemsEnabled()) {
            break;
          }
          if (paramBoolean)
          {
            paramInt = Math.max(0, paramInt);
            for (;;)
            {
              i = paramInt;
              if (paramInt >= j) {
                break;
              }
              i = paramInt;
              if (localListAdapter.isEnabled(paramInt)) {
                break;
              }
              paramInt += 1;
            }
          }
          paramInt = Math.min(paramInt, j - 1);
          for (;;)
          {
            i = paramInt;
            if (paramInt < 0) {
              break;
            }
            i = paramInt;
            if (localListAdapter.isEnabled(paramInt)) {
              break;
            }
            paramInt -= 1;
          }
        } while ((i < 0) || (i >= j));
        return i;
      } while ((paramInt < 0) || (paramInt >= j));
      return paramInt;
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
    
    final int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      paramInt2 = getListPaddingTop();
      paramInt3 = getListPaddingBottom();
      getListPaddingLeft();
      getListPaddingRight();
      int i = getDividerHeight();
      Object localObject = getDivider();
      ListAdapter localListAdapter = getAdapter();
      if (localListAdapter == null)
      {
        paramInt2 += paramInt3;
        return paramInt2;
      }
      paramInt3 = paramInt2 + paramInt3;
      label63:
      int m;
      int i1;
      int j;
      if ((i > 0) && (localObject != null))
      {
        paramInt2 = 0;
        localObject = null;
        m = 0;
        i1 = localListAdapter.getCount();
        j = 0;
      }
      for (;;)
      {
        if (j >= i1) {
          return paramInt3;
        }
        int n = localListAdapter.getItemViewType(j);
        int k = m;
        if (n != m)
        {
          localObject = null;
          k = n;
        }
        localObject = localListAdapter.getView(j, (View)localObject, this);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
        if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
        for (m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; m = View.MeasureSpec.makeMeasureSpec(0, 0))
        {
          ((View)localObject).measure(paramInt1, m);
          m = paramInt3;
          if (j > 0) {
            m = paramInt3 + i;
          }
          paramInt3 = m + ((View)localObject).getMeasuredHeight();
          if (paramInt3 < paramInt4) {
            break label243;
          }
          if ((paramInt5 >= 0) && (j > paramInt5) && (paramInt2 > 0) && (paramInt3 != paramInt4)) {
            break;
          }
          return paramInt4;
          i = 0;
          break label63;
        }
        label243:
        m = paramInt2;
        if (paramInt5 >= 0)
        {
          m = paramInt2;
          if (j >= paramInt5) {
            m = paramInt3;
          }
        }
        j += 1;
        paramInt2 = m;
        m = k;
      }
      return paramInt3;
    }
  }
  
  private class ListSelectorHider
    implements Runnable
  {
    private ListSelectorHider() {}
    
    public void run()
    {
      ListPopupWindow.this.clearListSelection();
    }
  }
  
  private class PopupDataSetObserver
    extends DataSetObserver
  {
    private PopupDataSetObserver() {}
    
    public void onChanged()
    {
      if (ListPopupWindow.this.isShowing()) {
        ListPopupWindow.this.show();
      }
    }
    
    public void onInvalidated()
    {
      ListPopupWindow.this.dismiss();
    }
  }
  
  private class PopupScrollListener
    implements AbsListView.OnScrollListener
  {
    private PopupScrollListener() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.mPopup.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
        ListPopupWindow.this.mResizePopupRunnable.run();
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
      if ((i == 0) && (ListPopupWindow.this.mPopup != null) && (ListPopupWindow.this.mPopup.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.mPopup.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.mPopup.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
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
      if ((ListPopupWindow.this.mDropDownList != null) && (ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount()) && (ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum))
      {
        ListPopupWindow.this.mPopup.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v7/internal/widget/ListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */