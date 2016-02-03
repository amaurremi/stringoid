package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public abstract class NewFragmentStatePagerAdapter
        extends PagerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapter";
    public Activity mContext;
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments = new ArrayList();
    private long[] mItemIds = new long[0];
    private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();

    public NewFragmentStatePagerAdapter(FragmentManager paramFragmentManager, Activity paramActivity) {
        this.mContext = paramActivity;
        this.mFragmentManager = paramFragmentManager;
        this.mItemIds = new long[getCount()];
        int i = 0;
        for (; ; ) {
            if (i >= this.mItemIds.length) {
                return;
            }
            this.mItemIds[i] = getItemId(i);
            i += 1;
        }
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        try {
            paramViewGroup = (Fragment) paramObject;
            if (this.mCurTransaction == null) {
                this.mCurTransaction = this.mFragmentManager.beginTransaction();
            }
            paramInt = getItemPosition(paramObject);
            if (paramInt >= 0) {
            }
            for (; ; ) {
                if (this.mSavedState.size() > paramInt) {
                    this.mSavedState.set(paramInt, this.mFragmentManager.saveFragmentInstanceState(paramViewGroup));
                    this.mFragments.set(paramInt, null);
                    this.mCurTransaction.remove(paramViewGroup);
                    return;
                }
                this.mSavedState.add(null);
            }
            return;
        } catch (Exception paramViewGroup) {
        }
    }

    public void finishUpdate(ViewGroup paramViewGroup) {
        try {
            if (this.mCurTransaction != null) {
                this.mCurTransaction.commitAllowingStateLoss();
                this.mCurTransaction = null;
                this.mFragmentManager.executePendingTransactions();
            }
            return;
        } catch (Exception paramViewGroup) {
            paramViewGroup.printStackTrace();
        }
    }

    public abstract Fragment getItem(int paramInt);

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        if (this.mFragments.size() > paramInt) {
            localFragment = (Fragment) this.mFragments.get(paramInt);
            if (localFragment != null) {
                return localFragment;
            }
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        Fragment localFragment = getItem(paramInt);
        if (this.mSavedState.size() > paramInt) {
            Fragment.SavedState localSavedState = (Fragment.SavedState) this.mSavedState.get(paramInt);
            if (localSavedState != null) {
                localFragment.setInitialSavedState(localSavedState);
            }
        }
        for (; ; ) {
            if (this.mFragments.size() > paramInt) {
                localFragment.setMenuVisibility(false);
                this.mFragments.set(paramInt, localFragment);
                if (this.mFragmentManager.findFragmentByTag(localFragment.hashCode()) == null) {
                    this.mCurTransaction.add(paramViewGroup.getId(), localFragment, localFragment.hashCode());
                }
                return localFragment;
            }
            this.mFragments.add(null);
        }
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        return ((Fragment) paramObject).getView() == paramView;
    }

    public void notifyDataSetChanged() {
        long[] arrayOfLong = new long[getCount()];
        int i = 0;
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        int j;
        for (; ; ) {
            if (i >= arrayOfLong.length) {
                if (!Arrays.equals(this.mItemIds, arrayOfLong)) {
                    localArrayList1 = new ArrayList();
                    localArrayList2 = new ArrayList();
                    j = 0;
                    if (j < this.mItemIds.length) {
                        break;
                    }
                    this.mItemIds = arrayOfLong;
                    this.mSavedState = localArrayList1;
                    this.mFragments = localArrayList2;
                }
                super.notifyDataSetChanged();
                return;
            }
            arrayOfLong[i] = getItemId(i);
            i += 1;
        }
        int k = -2;
        i = 0;
        label102:
        label111:
        Object localObject;
        if (i >= arrayOfLong.length) {
            i = k;
            if (i >= 0) {
                if (j < this.mSavedState.size()) {
                    localObject = (Fragment.SavedState) this.mSavedState.get(j);
                    if (localObject != null) {
                        label144:
                        if (localArrayList1.size() <= i) {
                            break label240;
                        }
                        localArrayList1.set(i, localObject);
                    }
                }
                if (j < this.mFragments.size()) {
                    localObject = (Fragment) this.mFragments.get(j);
                    if (localObject == null) {
                    }
                }
            }
        }
        for (; ; ) {
            if (localArrayList2.size() > i) {
                localArrayList2.set(i, localObject);
                j += 1;
                break;
                if (this.mItemIds[j] == arrayOfLong[i]) {
                    break label111;
                }
                i += 1;
                break label102;
                label240:
                localArrayList1.add(null);
                break label144;
            }
            localArrayList2.add(null);
        }
    }

    public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {
        if (paramParcelable != null) {
        }
        try {
            paramParcelable = (Bundle) paramParcelable;
            paramParcelable.setClassLoader(paramClassLoader);
            this.mItemIds = paramParcelable.getLongArray("itemids");
            if (this.mItemIds == null) {
                this.mItemIds = new long[0];
            }
            paramClassLoader = paramParcelable.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            int i;
            if (paramClassLoader != null) {
                i = 0;
                if (i < paramClassLoader.length) {
                }
            } else {
                paramClassLoader = paramParcelable.keySet().iterator();
            }
            for (; ; ) {
                if (!paramClassLoader.hasNext()) {
                    return;
                    this.mSavedState.add((Fragment.SavedState) paramClassLoader[i]);
                    i += 1;
                    break;
                }
                String str = (String) paramClassLoader.next();
                if (str.startsWith("f")) {
                    i = Integer.parseInt(str.substring(1));
                    Fragment localFragment = this.mFragmentManager.getFragment(paramParcelable, str);
                    if (localFragment != null) {
                        for (; ; ) {
                            if (this.mFragments.size() > i) {
                                localFragment.setMenuVisibility(false);
                                this.mFragments.set(i, localFragment);
                                break;
                            }
                            this.mFragments.add(null);
                        }
                    }
                    Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                }
            }
            return;
        } catch (Exception paramParcelable) {
        }
    }

    public Parcelable saveState() {
        for (; ; ) {
            try {
                localBundle = new Bundle();
                if (this.mItemIds.length > 0) {
                    localBundle.putLongArray("itemids", this.mItemIds);
                }
                if (this.mSavedState.size() <= 0) {
                    break label134;
                }
                localObject = new Fragment.SavedState[this.mSavedState.size()];
                this.mSavedState.toArray((Object[]) localObject);
                localBundle.putParcelableArray("states", (Parcelable[]) localObject);
            } catch (Exception localException) {
                Bundle localBundle;
                Object localObject;
                String str;
                return null;
            }
            if (i >= this.mFragments.size()) {
                return localBundle;
            }
            localObject = (Fragment) this.mFragments.get(i);
            if (localObject != null) {
                str = "f" + i;
                this.mFragmentManager.putFragment(localBundle, str, (Fragment) localObject);
            }
            i += 1;
            continue;
            label134:
            int i = 0;
        }
    }

    public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        paramViewGroup = (Fragment) paramObject;
        if (paramViewGroup != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(false);
            }
            if (paramViewGroup != null) {
                paramViewGroup.setMenuVisibility(true);
            }
            this.mCurrentPrimaryItem = paramViewGroup;
        }
    }

    public void startUpdate(ViewGroup paramViewGroup) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/NewFragmentStatePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */