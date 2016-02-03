package android.support.v4.app;

import android.view.View;
import com.actionbarsherlock.ActionBarSherlock.OnCreatePanelMenuListener;
import com.actionbarsherlock.ActionBarSherlock.OnMenuItemSelectedListener;
import com.actionbarsherlock.ActionBarSherlock.OnPreparePanelListener;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

public abstract class Watson
  extends FragmentActivity
  implements ActionBarSherlock.OnCreatePanelMenuListener, ActionBarSherlock.OnMenuItemSelectedListener, ActionBarSherlock.OnPreparePanelListener
{
  private static final String TAG = "Watson";
  private ArrayList<Fragment> mCreatedMenus;
  
  public abstract MenuInflater getSupportMenuInflater();
  
  public abstract boolean onCreateOptionsMenu(Menu paramMenu);
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    int m = 0;
    int k = 0;
    Object localObject;
    int i;
    int j;
    if (paramInt == 0)
    {
      m = onCreateOptionsMenu(paramMenu);
      MenuInflater localMenuInflater = getSupportMenuInflater();
      localObject = null;
      ArrayList localArrayList = null;
      if (this.mFragments.mAdded != null)
      {
        i = 0;
        paramInt = 0;
        j = paramInt;
        localObject = localArrayList;
        if (i >= this.mFragments.mAdded.size()) {
          break label164;
        }
        localObject = (Fragment)this.mFragments.mAdded.get(i);
        if ((localObject == null) || (((Fragment)localObject).mHidden) || (!((Fragment)localObject).mHasMenu) || (!((Fragment)localObject).mMenuVisible) || (!(localObject instanceof OnCreateOptionsMenuListener))) {
          break label241;
        }
        ((OnCreateOptionsMenuListener)localObject).onCreateOptionsMenu(paramMenu, localMenuInflater);
        if (localArrayList != null) {
          break label238;
        }
        localArrayList = new ArrayList();
        label144:
        localArrayList.add(localObject);
        paramInt = 1;
      }
    }
    label164:
    label238:
    label241:
    for (;;)
    {
      i += 1;
      break;
      j = 0;
      if (this.mCreatedMenus != null)
      {
        paramInt = k;
        while (paramInt < this.mCreatedMenus.size())
        {
          paramMenu = (Fragment)this.mCreatedMenus.get(paramInt);
          if ((localObject == null) || (!((ArrayList)localObject).contains(paramMenu))) {
            paramMenu.onDestroyOptionsMenu();
          }
          paramInt += 1;
        }
      }
      this.mCreatedMenus = ((ArrayList)localObject);
      m |= j;
      return m;
      break label144;
    }
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 0)
    {
      if (!onOptionsItemSelected(paramMenuItem)) {
        break label22;
      }
      bool1 = true;
    }
    label22:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (this.mFragments.mAdded == null);
    paramInt = 0;
    for (;;)
    {
      bool1 = bool2;
      if (paramInt >= this.mFragments.mAdded.size()) {
        break;
      }
      Fragment localFragment = (Fragment)this.mFragments.mAdded.get(paramInt);
      if ((localFragment != null) && (!localFragment.mHidden) && (localFragment.mHasMenu) && (localFragment.mMenuVisible) && ((localFragment instanceof OnOptionsItemSelectedListener)) && (((OnOptionsItemSelectedListener)localFragment).onOptionsItemSelected(paramMenuItem))) {
        return true;
      }
      paramInt += 1;
    }
  }
  
  public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem);
  
  public abstract boolean onPrepareOptionsMenu(Menu paramMenu);
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    int k = 0;
    if (paramInt == 0)
    {
      k = onPrepareOptionsMenu(paramMenu);
      if (this.mFragments.mAdded != null)
      {
        int i = 0;
        for (paramInt = 0;; paramInt = j)
        {
          j = paramInt;
          if (i >= this.mFragments.mAdded.size()) {
            break;
          }
          paramView = (Fragment)this.mFragments.mAdded.get(i);
          j = paramInt;
          if (paramView != null)
          {
            j = paramInt;
            if (!paramView.mHidden)
            {
              j = paramInt;
              if (paramView.mHasMenu)
              {
                j = paramInt;
                if (paramView.mMenuVisible)
                {
                  j = paramInt;
                  if ((paramView instanceof OnPrepareOptionsMenuListener))
                  {
                    j = 1;
                    ((OnPrepareOptionsMenuListener)paramView).onPrepareOptionsMenu(paramMenu);
                  }
                }
              }
            }
          }
          i += 1;
        }
      }
      int j = 0;
      k = (k | j) & paramMenu.hasVisibleItems();
    }
    return k;
  }
  
  public static abstract interface OnCreateOptionsMenuListener
  {
    public abstract void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater);
  }
  
  public static abstract interface OnOptionsItemSelectedListener
  {
    public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem);
  }
  
  public static abstract interface OnPrepareOptionsMenuListener
  {
    public abstract void onPrepareOptionsMenu(Menu paramMenu);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/app/Watson.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */