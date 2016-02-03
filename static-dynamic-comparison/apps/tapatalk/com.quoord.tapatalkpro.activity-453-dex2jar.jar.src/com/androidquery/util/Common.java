package com.androidquery.util;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.androidquery.AQuery;
import com.androidquery.callback.BitmapAjaxCallback;

import java.io.File;
import java.util.Comparator;

public class Common
        implements Comparator<File>, Runnable, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, AdapterView.OnItemSelectedListener, TextWatcher {
    protected static final int CLEAN_CACHE = 2;
    protected static final int STORE_FILE = 1;
    private boolean fallback;
    private boolean galleryListen = false;
    private AdapterView.OnItemSelectedListener galleryListener;
    private Object handler;
    private int lastBottom;
    private String method;
    private int methodId;
    private AbsListView.OnScrollListener osl;
    private Object[] params;
    private int scrollState = 0;
    private Class<?>[] sig;

    private void checkScrolledBottom(AbsListView paramAbsListView, int paramInt) {
        int i = paramAbsListView.getCount();
        int j = paramAbsListView.getLastVisiblePosition();
        if ((paramInt == 0) && (i == j + 1)) {
            if (j != this.lastBottom) {
                this.lastBottom = j;
                invoke(new Object[]{paramAbsListView, Integer.valueOf(paramInt)});
            }
            return;
        }
        this.lastBottom = -1;
    }

    private Object invoke(Object... paramVarArgs) {
        if (this.method != null) {
            if (this.params != null) {
                paramVarArgs = this.params;
            }
            Object localObject2 = this.handler;
            Object localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = this;
            }
            return AQUtility.invokeHandler(localObject1, this.method, this.fallback, true, this.sig, paramVarArgs);
        }
        if (this.methodId != 0) {
            switch (this.methodId) {
            }
        }
        for (; ; ) {
            return null;
            AQUtility.cleanCache((File) this.params[0], ((Long) this.params[1]).longValue(), ((Long) this.params[2]).longValue());
            continue;
            AQUtility.store((File) this.params[0], (byte[]) this.params[1]);
        }
    }

    private void onScrollStateChanged(ExpandableListView paramExpandableListView, int paramInt) {
        paramExpandableListView.setTag(1090453508, Integer.valueOf(paramInt));
        int i;
        int j;
        ExpandableListAdapter localExpandableListAdapter;
        if (paramInt == 0) {
            i = paramExpandableListView.getFirstVisiblePosition();
            j = paramExpandableListView.getLastVisiblePosition();
            localExpandableListAdapter = paramExpandableListView.getExpandableListAdapter();
            paramInt = 0;
        }
        int k;
        int m;
        View localView;
        for (; ; ) {
            if (paramInt > j - i) {
                return;
            }
            long l = paramExpandableListView.getExpandableListPosition(paramInt + i);
            k = ExpandableListView.getPackedPositionGroup(l);
            m = ExpandableListView.getPackedPositionChild(l);
            if (k >= 0) {
                localView = paramExpandableListView.getChildAt(paramInt);
                Long localLong = (Long) localView.getTag(1090453508);
                if ((localLong != null) && (localLong.longValue() == l)) {
                    if (m != -1) {
                        break;
                    }
                    localExpandableListAdapter.getGroupView(k, paramExpandableListView.isGroupExpanded(k), localView, paramExpandableListView);
                    localView.setTag(1090453508, null);
                }
            }
            paramInt += 1;
        }
        if (m == localExpandableListAdapter.getChildrenCount(k) - 1) {
        }
        for (boolean bool = true; ; bool = false) {
            localExpandableListAdapter.getChildView(k, m, bool, localView, paramExpandableListView);
            break;
        }
    }

    private void onScrollStateChanged2(AbsListView paramAbsListView, int paramInt) {
        paramAbsListView.setTag(1090453508, Integer.valueOf(paramInt));
        int i;
        int j;
        ListAdapter localListAdapter;
        if (paramInt == 0) {
            i = paramAbsListView.getFirstVisiblePosition();
            j = paramAbsListView.getLastVisiblePosition();
            localListAdapter = (ListAdapter) paramAbsListView.getAdapter();
            paramInt = 0;
        }
        for (; ; ) {
            if (paramInt > j - i) {
                return;
            }
            long l = paramInt + i;
            View localView = paramAbsListView.getChildAt(paramInt);
            if ((Number) localView.getTag(1090453508) != null) {
                localListAdapter.getView((int) l, localView, paramAbsListView);
                localView.setTag(1090453508, null);
            }
            paramInt += 1;
        }
    }

    public static boolean shouldDelay(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, String paramString) {
        if ((paramString == null) || (BitmapAjaxCallback.isMemoryCached(paramString))) {
            return false;
        }
        paramString = (AbsListView) paramViewGroup;
        if ((AbsListView.OnScrollListener) paramViewGroup.getTag(1090453506) == null) {
            Common localCommon = new Common();
            paramString.setOnScrollListener(localCommon);
            paramViewGroup.setTag(1090453506, localCommon);
        }
        paramString = (Integer) paramString.getTag(1090453508);
        if ((paramString == null) || (paramString.intValue() == 0) || (paramString.intValue() == 1)) {
            return false;
        }
        long l = paramInt2;
        if ((paramViewGroup instanceof ExpandableListView)) {
            l = ExpandableListView.getPackedPositionForChild(paramInt1, paramInt2);
        }
        paramView.setTag(1090453508, Long.valueOf(l));
        return true;
    }

    public static boolean shouldDelay(int paramInt, View paramView, ViewGroup paramViewGroup, String paramString) {
        if ((paramViewGroup instanceof Gallery)) {
            return shouldDelayGallery(paramInt, paramView, paramViewGroup, paramString);
        }
        return shouldDelay(-2, paramInt, paramView, paramViewGroup, paramString);
    }

    public static boolean shouldDelay(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat, boolean paramBoolean) {
        return shouldDelay(-1, paramView, paramViewGroup, paramString);
    }

    private static boolean shouldDelayGallery(int paramInt, View paramView, ViewGroup paramViewGroup, String paramString) {
        if ((paramString == null) || (BitmapAjaxCallback.isMemoryCached(paramString))) {
            return false;
        }
        Gallery localGallery = (Gallery) paramViewGroup;
        paramString = (Integer) localGallery.getTag(1090453508);
        paramViewGroup = paramString;
        if (paramString == null) {
            paramViewGroup = Integer.valueOf(0);
            localGallery.setTag(1090453508, Integer.valueOf(0));
            localGallery.setCallbackDuringFling(false);
            new Common().listen(localGallery);
        }
        int i = localGallery.getFirstVisiblePosition();
        i = (localGallery.getLastVisiblePosition() - i) / 2 + 1;
        int k = paramViewGroup.intValue() - i;
        int m = paramViewGroup.intValue() + i;
        int j = k;
        i = m;
        if (k < 0) {
            i = m - k;
            j = 0;
        }
        if ((paramInt >= j) && (paramInt <= i)) {
            paramView.setTag(1090453508, Integer.valueOf(paramInt));
            return false;
        }
        paramView.setTag(1090453508, null);
        return true;
    }

    public static void showProgress(Object paramObject, String paramString, boolean paramBoolean) {
        View localView;
        ProgressBar localProgressBar;
        if (paramObject != null) {
            if (!(paramObject instanceof View)) {
                break label112;
            }
            localView = (View) paramObject;
            localProgressBar = null;
            if ((paramObject instanceof ProgressBar)) {
                localProgressBar = (ProgressBar) paramObject;
            }
            if (!paramBoolean) {
                break label65;
            }
            localView.setTag(1090453505, paramString);
            localView.setVisibility(0);
            if (localProgressBar != null) {
                localProgressBar.setProgress(0);
                localProgressBar.setMax(100);
            }
        }
        label65:
        label112:
        do {
            do {
                do {
                    do {
                        return;
                        paramObject = localView.getTag(1090453505);
                    } while ((paramObject != null) && (!paramObject.equals(paramString)));
                    localView.setTag(1090453505, null);
                } while ((localProgressBar != null) && (!localProgressBar.isIndeterminate()));
                localView.setVisibility(8);
                return;
                if ((paramObject instanceof Dialog)) {
                    paramObject = (Dialog) paramObject;
                    paramString = new AQuery(((Dialog) paramObject).getContext());
                    if (paramBoolean) {
                        paramString.show((Dialog) paramObject);
                        return;
                    }
                    paramString.dismiss((Dialog) paramObject);
                    return;
                }
            } while (!(paramObject instanceof Activity));
            paramObject = (Activity) paramObject;
            ((Activity) paramObject).setProgressBarIndeterminateVisibility(paramBoolean);
            ((Activity) paramObject).setProgressBarVisibility(paramBoolean);
        } while (!paramBoolean);
        ((Activity) paramObject).setProgress(0);
    }

    public void afterTextChanged(Editable paramEditable) {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public int compare(File paramFile1, File paramFile2) {
        long l1 = paramFile1.lastModified();
        long l2 = paramFile2.lastModified();
        if (l2 > l1) {
            return 1;
        }
        if (l2 == l1) {
            return 0;
        }
        return -1;
    }

    public Common forward(Object paramObject, String paramString, boolean paramBoolean, Class<?>[] paramArrayOfClass) {
        this.handler = paramObject;
        this.method = paramString;
        this.fallback = paramBoolean;
        this.sig = paramArrayOfClass;
        return this;
    }

    public void forward(AbsListView.OnScrollListener paramOnScrollListener) {
        this.osl = paramOnScrollListener;
    }

    public int getScrollState() {
        return this.scrollState;
    }

    public void listen(Gallery paramGallery) {
        this.galleryListener = paramGallery.getOnItemSelectedListener();
        this.galleryListen = true;
        paramGallery.setOnItemSelectedListener(this);
    }

    public Common method(int paramInt, Object... paramVarArgs) {
        this.methodId = paramInt;
        this.params = paramVarArgs;
        return this;
    }

    public void onClick(View paramView) {
        invoke(new Object[]{paramView});
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        invoke(new Object[]{paramAdapterView, paramView, Integer.valueOf(paramInt), Long.valueOf(paramLong)});
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        invoke(new Object[]{paramAdapterView, paramView, Integer.valueOf(paramInt), Long.valueOf(paramLong)});
        if (this.galleryListener != null) {
            this.galleryListener.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
        }
        int i;
        int j;
        if ((this.galleryListen) && (((Integer) paramAdapterView.getTag(1090453508)).intValue() != paramInt)) {
            paramView = paramAdapterView.getAdapter();
            paramAdapterView.setTag(1090453508, Integer.valueOf(paramInt));
            i = paramAdapterView.getChildCount();
            j = paramAdapterView.getFirstVisiblePosition();
            paramInt = 0;
        }
        for (; ; ) {
            if (paramInt >= i) {
                return;
            }
            View localView = paramAdapterView.getChildAt(paramInt);
            int k = j + paramInt;
            Integer localInteger = (Integer) localView.getTag(1090453508);
            if ((localInteger == null) || (localInteger.intValue() != k)) {
                paramView.getView(k, localView, paramAdapterView);
            }
            paramInt += 1;
        }
    }

    public boolean onLongClick(View paramView) {
        boolean bool = false;
        paramView = invoke(new Object[]{paramView});
        if ((paramView instanceof Boolean)) {
            bool = ((Boolean) paramView).booleanValue();
        }
        return bool;
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView) {
        if (this.galleryListener != null) {
            this.galleryListener.onNothingSelected(paramAdapterView);
        }
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
        checkScrolledBottom(paramAbsListView, this.scrollState);
        if (this.osl != null) {
            this.osl.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
        }
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
        this.scrollState = paramInt;
        checkScrolledBottom(paramAbsListView, paramInt);
        if ((paramAbsListView instanceof ExpandableListView)) {
            onScrollStateChanged((ExpandableListView) paramAbsListView, paramInt);
        }
        for (; ; ) {
            if (this.osl != null) {
                this.osl.onScrollStateChanged(paramAbsListView, paramInt);
            }
            return;
            onScrollStateChanged2(paramAbsListView, paramInt);
        }
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        invoke(new Object[]{paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3)});
    }

    public void run() {
        invoke(new Object[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/util/Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */