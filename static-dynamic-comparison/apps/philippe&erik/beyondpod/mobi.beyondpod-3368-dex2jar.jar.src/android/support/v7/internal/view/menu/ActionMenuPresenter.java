package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.integer;
import android.support.v7.appcompat.R.layout;
import android.support.v7.internal.view.ActionBarPolicy;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageButton;
import java.util.ArrayList;

public class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  private static final String TAG = "ActionMenuPresenter";
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  private ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  private View mOverflowButton;
  private OverflowPopup mOverflowPopup;
  final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback(null);
  private OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private View mScrapActionButtonView;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    Object localObject;
    if (localViewGroup == null)
    {
      localObject = null;
      return (View)localObject;
    }
    int j = localViewGroup.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label74;
      }
      View localView = localViewGroup.getChildAt(i);
      if ((localView instanceof MenuView.ItemView))
      {
        localObject = localView;
        if (((MenuView.ItemView)localView).getItemData() == paramMenuItem) {
          break;
        }
      }
      i += 1;
    }
    label74:
    return null;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize(paramMenuItemImpl, 0);
    paramMenuItemImpl = (ActionMenuView)this.mMenuView;
    ((ActionMenuItemView)paramItemView).setItemInvoker(paramMenuItemImpl);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton) {
      return false;
    }
    return super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems()
  {
    ArrayList localArrayList = this.mMenu.getVisibleItems();
    int i6 = localArrayList.size();
    int i = this.mMaxItems;
    int i4 = this.mActionItemWidthLimit;
    int i7 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    int j = 0;
    int m = 0;
    int i2 = 0;
    int n = 0;
    int k = 0;
    int i1;
    if (k < i6)
    {
      localObject1 = (MenuItemImpl)localArrayList.get(k);
      if (((MenuItemImpl)localObject1).requiresActionButton()) {
        j += 1;
      }
      for (;;)
      {
        i1 = i;
        if (this.mExpandedActionViewsExclusive)
        {
          i1 = i;
          if (((MenuItemImpl)localObject1).isActionViewExpanded()) {
            i1 = 0;
          }
        }
        k += 1;
        i = i1;
        break;
        if (((MenuItemImpl)localObject1).requestsActionButton()) {
          m += 1;
        } else {
          n = 1;
        }
      }
    }
    k = i;
    if (this.mReserveOverflow) {
      if (n == 0)
      {
        k = i;
        if (j + m <= i) {}
      }
      else
      {
        k = i - 1;
      }
    }
    k -= j;
    Object localObject1 = this.mActionButtonGroups;
    ((SparseBooleanArray)localObject1).clear();
    int i3 = 0;
    j = 0;
    if (this.mStrictWidthLimit)
    {
      j = i4 / this.mMinCellSize;
      i = this.mMinCellSize;
      i3 = this.mMinCellSize + i4 % i / j;
    }
    i = 0;
    m = i4;
    i4 = i;
    i = i2;
    if (i4 < i6)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(i4);
      Object localObject2;
      if (localMenuItemImpl.requiresActionButton())
      {
        localObject2 = getItemView(localMenuItemImpl, this.mScrapActionButtonView, localViewGroup);
        if (this.mScrapActionButtonView == null) {
          this.mScrapActionButtonView = ((View)localObject2);
        }
        if (this.mStrictWidthLimit)
        {
          j -= ActionMenuView.measureChildForCells((View)localObject2, i3, j, i7, 0);
          label310:
          i2 = ((View)localObject2).getMeasuredWidth();
          n = m - i2;
          i1 = i;
          if (i == 0) {
            i1 = i2;
          }
          i = localMenuItemImpl.getGroupId();
          if (i != 0) {
            ((SparseBooleanArray)localObject1).put(i, true);
          }
          localMenuItemImpl.setIsActionButton(true);
          i5 = k;
          i2 = j;
        }
      }
      do
      {
        i4 += 1;
        j = i2;
        i = i1;
        k = i5;
        m = n;
        break;
        ((View)localObject2).measure(i7, i7);
        break label310;
        i2 = j;
        i1 = i;
        i5 = k;
        n = m;
      } while (!localMenuItemImpl.requestsActionButton());
      int i5 = localMenuItemImpl.getGroupId();
      boolean bool = ((SparseBooleanArray)localObject1).get(i5);
      int i8;
      label463:
      int i9;
      if (((k > 0) || (bool)) && (m > 0) && ((!this.mStrictWidthLimit) || (j > 0)))
      {
        i8 = 1;
        i2 = j;
        i1 = i;
        i9 = i8;
        n = m;
        if (i8 != 0)
        {
          localObject2 = getItemView(localMenuItemImpl, this.mScrapActionButtonView, localViewGroup);
          if (this.mScrapActionButtonView == null) {
            this.mScrapActionButtonView = ((View)localObject2);
          }
          if (!this.mStrictWidthLimit) {
            break label647;
          }
          i1 = ActionMenuView.measureChildForCells((View)localObject2, i3, j, i7, 0);
          n = j - i1;
          j = n;
          if (i1 == 0)
          {
            i8 = 0;
            j = n;
          }
          label549:
          i2 = ((View)localObject2).getMeasuredWidth();
          n = m - i2;
          i1 = i;
          if (i == 0) {
            i1 = i2;
          }
          if (!this.mStrictWidthLimit) {
            break label664;
          }
          if (n < 0) {
            break label659;
          }
          i = 1;
          label588:
          i9 = i8 & i;
          i2 = j;
        }
        if ((i9 == 0) || (i5 == 0)) {
          break label691;
        }
        ((SparseBooleanArray)localObject1).put(i5, true);
        i = k;
      }
      label647:
      label659:
      label664:
      label691:
      do
      {
        j = i;
        if (i9 != 0) {
          j = i - 1;
        }
        localMenuItemImpl.setIsActionButton(i9);
        i5 = j;
        break;
        i8 = 0;
        break label463;
        ((View)localObject2).measure(i7, i7);
        break label549;
        i = 0;
        break label588;
        if (n + i1 > 0) {}
        for (i = 1;; i = 0)
        {
          i9 = i8 & i;
          i2 = j;
          break;
        }
        i = k;
      } while (!bool);
      ((SparseBooleanArray)localObject1).put(i5, false);
      j = 0;
      for (;;)
      {
        i = k;
        if (j >= i4) {
          break;
        }
        localObject2 = (MenuItemImpl)localArrayList.get(j);
        i = k;
        if (((MenuItemImpl)localObject2).getGroupId() == i5)
        {
          i = k;
          if (((MenuItemImpl)localObject2).isActionButton()) {
            i = k + 1;
          }
          ((MenuItemImpl)localObject2).setIsActionButton(false);
        }
        j += 1;
        k = i;
      }
    }
    return true;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.hasCollapsibleActionView()))
    {
      localView = paramView;
      if (!(paramView instanceof ActionMenuItemView)) {
        localView = null;
      }
      localView = super.getItemView(paramMenuItemImpl, localView, paramViewGroup);
    }
    if (paramMenuItemImpl.isActionViewExpanded()) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      paramMenuItemImpl = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramMenuItemImpl.checkLayoutParams(paramView)) {
        localView.setLayoutParams(paramMenuItemImpl.generateLayoutParams(paramView));
      }
      return localView;
    }
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getMenuView(paramViewGroup);
    ((ActionMenuView)paramViewGroup).setPresenter(this);
    return paramViewGroup;
  }
  
  public boolean hideOverflowMenu()
  {
    if ((this.mPostedOpenRunnable != null) && (this.mMenuView != null))
    {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      return true;
    }
    OverflowPopup localOverflowPopup = this.mOverflowPopup;
    if (localOverflowPopup != null)
    {
      localOverflowPopup.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean hideSubMenus()
  {
    if (this.mActionButtonPopup != null)
    {
      this.mActionButtonPopup.dismiss();
      return true;
    }
    return false;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    super.initForMenu(paramContext, paramMenuBuilder);
    paramMenuBuilder = paramContext.getResources();
    paramContext = ActionBarPolicy.get(paramContext);
    if (!this.mReserveOverflowSet) {
      this.mReserveOverflow = paramContext.showsOverflowMenuButton();
    }
    if (!this.mWidthLimitSet) {
      this.mWidthLimit = paramContext.getEmbeddedMenuWidthLimit();
    }
    if (!this.mMaxItemsSet) {
      this.mMaxItems = paramContext.getMaxActionButtons();
    }
    int i = this.mWidthLimit;
    if (this.mReserveOverflow)
    {
      if (this.mOverflowButton == null)
      {
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      }
      i -= this.mOverflowButton.getMeasuredWidth();
    }
    for (;;)
    {
      this.mActionItemWidthLimit = i;
      this.mMinCellSize = ((int)(56.0F * paramMenuBuilder.getDisplayMetrics().density));
      this.mScrapActionButtonView = null;
      return;
      this.mOverflowButton = null;
    }
  }
  
  public boolean isOverflowMenuShowing()
  {
    return (this.mOverflowPopup != null) && (this.mOverflowPopup.isShowing());
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mMaxItemsSet) {
      this.mMaxItems = this.mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
    }
    if (this.mMenu != null) {
      this.mMenu.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    if (paramParcelable.openSubMenuId > 0)
    {
      paramParcelable = this.mMenu.findItem(paramParcelable.openSubMenuId);
      if (paramParcelable != null) {
        onSubMenuSelected((SubMenuBuilder)paramParcelable.getSubMenu());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.openSubMenuId = this.mOpenSubMenuId;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {}
    do
    {
      return false;
      for (localObject = paramSubMenuBuilder; ((SubMenuBuilder)localObject).getParentMenu() != this.mMenu; localObject = (SubMenuBuilder)((SubMenuBuilder)localObject).getParentMenu()) {}
      if (findViewForItem(((SubMenuBuilder)localObject).getItem()) != null) {
        break;
      }
    } while (this.mOverflowButton == null);
    Object localObject = this.mOverflowButton;
    this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
    this.mActionButtonPopup = new ActionButtonSubmenu(paramSubMenuBuilder);
    this.mActionButtonPopup.show(null);
    super.onSubMenuSelected(paramSubMenuBuilder);
    return true;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.onSubMenuSelected(null);
      return;
    }
    this.mMenu.close(false);
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt)
  {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    if ((this.mReserveOverflow) && (!isOverflowMenuShowing()) && (this.mMenu != null) && (this.mMenuView != null) && (this.mPostedOpenRunnable == null))
    {
      this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
      return true;
    }
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    super.updateMenuView(paramBoolean);
    if (this.mMenuView == null) {
      return;
    }
    Object localObject;
    int j;
    int i;
    if (this.mMenu != null)
    {
      localObject = this.mMenu.getActionItems();
      j = ((ArrayList)localObject).size();
      i = 0;
      while (i < j)
      {
        ActionProvider localActionProvider = ((MenuItemImpl)((ArrayList)localObject).get(i)).getSupportActionProvider();
        if (localActionProvider != null) {
          localActionProvider.setSubUiVisibilityListener(this);
        }
        i += 1;
      }
    }
    if (this.mMenu != null)
    {
      localObject = this.mMenu.getNonActionItems();
      j = 0;
      i = j;
      if (this.mReserveOverflow)
      {
        i = j;
        if (localObject != null)
        {
          i = ((ArrayList)localObject).size();
          if (i != 1) {
            break label247;
          }
          if (((MenuItemImpl)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label242;
          }
          i = 1;
        }
      }
      label136:
      if (i == 0) {
        break label261;
      }
      if (this.mOverflowButton == null) {
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
      }
      localObject = (ViewGroup)this.mOverflowButton.getParent();
      if (localObject != this.mMenuView)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.mOverflowButton);
        }
        localObject = (ActionMenuView)this.mMenuView;
        ((ActionMenuView)localObject).addView(this.mOverflowButton, ((ActionMenuView)localObject).generateOverflowButtonLayoutParams());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
      return;
      localObject = null;
      break;
      label242:
      i = 0;
      break label136;
      label247:
      if (i > 0) {}
      for (i = 1;; i = 0) {
        break;
      }
      label261:
      if ((this.mOverflowButton != null) && (this.mOverflowButton.getParent() == this.mMenuView)) {
        ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
      }
    }
  }
  
  private class ActionButtonSubmenu
    extends MenuDialogHelper
  {
    public ActionButtonSubmenu(SubMenuBuilder paramSubMenuBuilder)
    {
      super();
      ActionMenuPresenter.this.setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      super.onDismiss(paramDialogInterface);
      ActionMenuPresenter.access$202(ActionMenuPresenter.this, null);
      ActionMenuPresenter.this.mOpenSubMenuId = 0;
    }
  }
  
  private class OpenOverflowRunnable
    implements Runnable
  {
    private ActionMenuPresenter.OverflowPopup mPopup;
    
    public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup paramOverflowPopup)
    {
      this.mPopup = paramOverflowPopup;
    }
    
    public void run()
    {
      ActionMenuPresenter.this.mMenu.changeMenuMode();
      View localView = (View)ActionMenuPresenter.this.mMenuView;
      if ((localView != null) && (localView.getWindowToken() != null) && (this.mPopup.tryShow())) {
        ActionMenuPresenter.access$102(ActionMenuPresenter.this, this.mPopup);
      }
      ActionMenuPresenter.access$302(ActionMenuPresenter.this, null);
    }
  }
  
  private class OverflowMenuButton
    extends ImageButton
    implements ActionMenuView.ActionMenuChildView
  {
    public OverflowMenuButton(Context paramContext)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
    }
    
    public boolean needsDividerAfter()
    {
      return false;
    }
    
    public boolean needsDividerBefore()
    {
      return false;
    }
    
    public boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }
  }
  
  private class OverflowPopup
    extends MenuPopupHelper
  {
    public OverflowPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
    {
      super(paramMenuBuilder, paramView, paramBoolean);
      setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    public void onDismiss()
    {
      super.onDismiss();
      ActionMenuPresenter.this.mMenu.close();
      ActionMenuPresenter.access$102(ActionMenuPresenter.this, null);
    }
  }
  
  private class PopupPresenterCallback
    implements MenuPresenter.Callback
  {
    private PopupPresenterCallback() {}
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if ((paramMenuBuilder instanceof SubMenuBuilder)) {
        ((SubMenuBuilder)paramMenuBuilder).getRootMenu().close(false);
      }
    }
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder == null) {
        return false;
      }
      ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
      return false;
    }
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ActionMenuPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ActionMenuPresenter.SavedState(paramAnonymousParcel);
      }
      
      public ActionMenuPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ActionMenuPresenter.SavedState[paramAnonymousInt];
      }
    };
    public int openSubMenuId;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.openSubMenuId = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.openSubMenuId);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/internal/view/menu/ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */