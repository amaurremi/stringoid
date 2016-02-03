package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

class SpinnerICS
  extends AbsSpinnerICS
  implements DialogInterface.OnClickListener
{
  private static final int MAX_ITEMS_MEASURED = 15;
  static final int MODE_DIALOG = 0;
  static final int MODE_DROPDOWN = 1;
  private static final int MODE_THEME = -1;
  private static final String TAG = "Spinner";
  int mDropDownWidth;
  private int mGravity;
  private SpinnerPopup mPopup;
  private DropDownAdapter mTempAdapter;
  private Rect mTempRect = new Rect();
  
  SpinnerICS(Context paramContext)
  {
    this(paramContext, null);
  }
  
  SpinnerICS(Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }
  
  SpinnerICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  SpinnerICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  SpinnerICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Spinner, paramInt1, 0);
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = localTypedArray.getInt(7, 0);
    }
    switch (i)
    {
    }
    for (;;)
    {
      this.mGravity = localTypedArray.getInt(0, 17);
      this.mPopup.setPromptText(localTypedArray.getString(6));
      localTypedArray.recycle();
      if (this.mTempAdapter != null)
      {
        this.mPopup.setAdapter(this.mTempAdapter);
        this.mTempAdapter = null;
      }
      return;
      this.mPopup = new DialogPopup(null);
      continue;
      paramContext = new DropdownPopup(paramContext, paramAttributeSet, paramInt1);
      this.mDropDownWidth = localTypedArray.getLayoutDimension(3, -2);
      paramContext.setBackgroundDrawable(localTypedArray.getDrawable(2));
      paramInt1 = localTypedArray.getDimensionPixelOffset(5, 0);
      if (paramInt1 != 0) {
        paramContext.setVerticalOffset(paramInt1);
      }
      paramInt1 = localTypedArray.getDimensionPixelOffset(4, 0);
      if (paramInt1 != 0) {
        paramContext.setHorizontalOffset(paramInt1);
      }
      this.mPopup = paramContext;
    }
  }
  
  private View makeAndAddView(int paramInt)
  {
    if (!this.mDataChanged)
    {
      localView = this.mRecycler.get(paramInt);
      if (localView != null)
      {
        setUpChild(localView);
        return localView;
      }
    }
    View localView = this.mAdapter.getView(paramInt, null, this);
    setUpChild(localView);
    return localView;
  }
  
  private void setUpChild(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = generateDefaultLayoutParams();
    }
    addViewInLayout(paramView, 0, localLayoutParams1);
    paramView.setSelected(hasFocus());
    int i = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, localLayoutParams1.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, localLayoutParams1.width), i);
    i = this.mSpinnerPadding.top + (getMeasuredHeight() - this.mSpinnerPadding.bottom - this.mSpinnerPadding.top - paramView.getMeasuredHeight()) / 2;
    int j = paramView.getMeasuredHeight();
    paramView.layout(0, i, 0 + paramView.getMeasuredWidth(), i + j);
  }
  
  public int getBaseline()
  {
    int j = -1;
    Object localObject2 = null;
    Object localObject1;
    if (getChildCount() > 0) {
      localObject1 = getChildAt(0);
    }
    for (;;)
    {
      int i = j;
      if (localObject1 != null)
      {
        int k = ((View)localObject1).getBaseline();
        i = j;
        if (k >= 0) {
          i = ((View)localObject1).getTop() + k;
        }
      }
      return i;
      localObject1 = localObject2;
      if (this.mAdapter != null)
      {
        localObject1 = localObject2;
        if (this.mAdapter.getCount() > 0)
        {
          localObject1 = makeAndAddView(0);
          this.mRecycler.put(0, (View)localObject1);
          removeAllViewsInLayout();
        }
      }
    }
  }
  
  public CharSequence getPrompt()
  {
    return this.mPopup.getHintText();
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
    int i = this.mSpinnerPadding.left;
    int j = getRight() - getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      resetList();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    recycleAllViews();
    removeAllViewsInLayout();
    this.mFirstPosition = this.mSelectedPosition;
    View localView = makeAndAddView(this.mSelectedPosition);
    int k = localView.getMeasuredWidth();
    paramInt = i;
    switch (this.mGravity & 0x7)
    {
    }
    for (;;)
    {
      localView.offsetLeftAndRight(paramInt);
      this.mRecycler.clear();
      invalidate();
      checkSelectionChanged();
      this.mDataChanged = false;
      this.mNeedSync = false;
      setNextSelectedPositionInt(this.mSelectedPosition);
      return;
      paramInt = j / 2 + i - k / 2;
      continue;
      paramInt = i + j - k;
    }
  }
  
  int measureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int j;
    if (paramSpinnerAdapter == null) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      i = 0;
      View localView = null;
      int k = 0;
      int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
      j = Math.max(0, getSelectedItemPosition());
      int i3 = Math.min(paramSpinnerAdapter.getCount(), j + 15);
      j = Math.max(0, j - (15 - (i3 - j)));
      while (j < i3)
      {
        int n = paramSpinnerAdapter.getItemViewType(j);
        int m = k;
        if (n != k)
        {
          m = n;
          localView = null;
        }
        localView = paramSpinnerAdapter.getView(j, localView, this);
        if (localView.getLayoutParams() == null) {
          localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        localView.measure(i1, i2);
        i = Math.max(i, localView.getMeasuredWidth());
        j += 1;
        k = m;
      }
      j = i;
    } while (paramDrawable == null);
    paramDrawable.getPadding(this.mTempRect);
    return i + (this.mTempRect.left + this.mTempRect.right);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    setSelection(paramInt);
    paramDialogInterface.dismiss();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {
      this.mPopup.dismiss();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = true;
    layout(0, false);
    this.mInLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean performClick()
  {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = true;
      bool1 = bool2;
      if (!this.mPopup.isShowing())
      {
        this.mPopup.show();
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(paramSpinnerAdapter);
    if (this.mPopup != null)
    {
      this.mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter));
      return;
    }
    this.mTempAdapter = new DropDownAdapter(paramSpinnerAdapter);
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      int i = paramInt;
      if ((paramInt & 0x7) == 0) {
        i = paramInt | 0x3;
      }
      this.mGravity = i;
      requestLayout();
    }
  }
  
  public void setOnItemClickListener(AdapterViewICS.OnItemClickListener paramOnItemClickListener)
  {
    throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
  }
  
  void setOnItemClickListenerInt(AdapterViewICS.OnItemClickListener paramOnItemClickListener)
  {
    super.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    this.mPopup.setPromptText(paramCharSequence);
  }
  
  public void setPromptId(int paramInt)
  {
    setPrompt(getContext().getText(paramInt));
  }
  
  private class DialogPopup
    implements SpinnerICS.SpinnerPopup, DialogInterface.OnClickListener
  {
    private ListAdapter mListAdapter;
    private AlertDialog mPopup;
    private CharSequence mPrompt;
    
    private DialogPopup() {}
    
    public void dismiss()
    {
      this.mPopup.dismiss();
      this.mPopup = null;
    }
    
    public CharSequence getHintText()
    {
      return this.mPrompt;
    }
    
    public boolean isShowing()
    {
      if (this.mPopup != null) {
        return this.mPopup.isShowing();
      }
      return false;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      SpinnerICS.this.setSelection(paramInt);
      if (SpinnerICS.this.mOnItemClickListener != null) {
        SpinnerICS.this.performItemClick(null, paramInt, this.mListAdapter.getItemId(paramInt));
      }
      dismiss();
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      this.mListAdapter = paramListAdapter;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mPrompt = paramCharSequence;
    }
    
    public void show()
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(SpinnerICS.this.getContext());
      if (this.mPrompt != null) {
        localBuilder.setTitle(this.mPrompt);
      }
      this.mPopup = localBuilder.setSingleChoiceItems(this.mListAdapter, SpinnerICS.this.getSelectedItemPosition(), this).show();
    }
  }
  
  private static class DropDownAdapter
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;
    
    public DropDownAdapter(SpinnerAdapter paramSpinnerAdapter)
    {
      this.mAdapter = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.mListAdapter = ((ListAdapter)paramSpinnerAdapter);
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      if (this.mAdapter == null) {
        return 0;
      }
      return this.mAdapter.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.mAdapter == null) {
        return null;
      }
      return this.mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      if (this.mAdapter == null) {
        return null;
      }
      return this.mAdapter.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      if (this.mAdapter == null) {
        return -1L;
      }
      return this.mAdapter.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      return (this.mAdapter != null) && (this.mAdapter.hasStableIds());
    }
    
    public boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.mAdapter != null) {
        this.mAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.mAdapter != null) {
        this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  private class DropdownPopup
    extends ListPopupWindow
    implements SpinnerICS.SpinnerPopup
  {
    private ListAdapter mAdapter;
    private CharSequence mHintText;
    
    public DropdownPopup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setAnchorView(SpinnerICS.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterViewICS.OnItemClickListenerWrapper(SpinnerICS.this, new AdapterViewICS.OnItemClickListener()
      {
        public void onItemClick(AdapterViewICS paramAnonymousAdapterViewICS, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          SpinnerICS.this.setSelection(paramAnonymousInt);
          if (SpinnerICS.this.mOnItemClickListener != null) {
            SpinnerICS.this.performItemClick(paramAnonymousView, paramAnonymousInt, SpinnerICS.DropdownPopup.this.mAdapter.getItemId(paramAnonymousInt));
          }
          SpinnerICS.DropdownPopup.this.dismiss();
        }
      }));
    }
    
    public CharSequence getHintText()
    {
      return this.mHintText;
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.mAdapter = paramListAdapter;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mHintText = paramCharSequence;
    }
    
    public void show()
    {
      int j = SpinnerICS.this.getPaddingLeft();
      int i;
      if (SpinnerICS.this.mDropDownWidth == -2)
      {
        i = SpinnerICS.this.getWidth();
        int k = SpinnerICS.this.getPaddingRight();
        setContentWidth(Math.max(SpinnerICS.this.measureContentWidth((SpinnerAdapter)this.mAdapter, getBackground()), i - j - k));
      }
      for (;;)
      {
        Drawable localDrawable = getBackground();
        i = 0;
        if (localDrawable != null)
        {
          localDrawable.getPadding(SpinnerICS.this.mTempRect);
          i = -SpinnerICS.this.mTempRect.left;
        }
        setHorizontalOffset(i + j);
        setInputMethodMode(2);
        super.show();
        getListView().setChoiceMode(1);
        setSelection(SpinnerICS.this.getSelectedItemPosition());
        return;
        if (SpinnerICS.this.mDropDownWidth == -1) {
          setContentWidth(SpinnerICS.this.getWidth() - j - SpinnerICS.this.getPaddingRight());
        } else {
          setContentWidth(SpinnerICS.this.mDropDownWidth);
        }
      }
    }
  }
  
  private static abstract interface SpinnerPopup
  {
    public abstract void dismiss();
    
    public abstract CharSequence getHintText();
    
    public abstract boolean isShowing();
    
    public abstract void setAdapter(ListAdapter paramListAdapter);
    
    public abstract void setPromptText(CharSequence paramCharSequence);
    
    public abstract void show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v7/internal/widget/SpinnerICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */