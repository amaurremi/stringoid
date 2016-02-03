package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView
        extends GridView {
    private static final String TAG = "HeaderGridView";
    private ArrayList<FixedViewInfo> mHeaderViewInfos = new ArrayList();

    public HeaderGridView(Context paramContext) {
        super(paramContext);
        initHeaderGridView();
    }

    public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        initHeaderGridView();
    }

    public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initHeaderGridView();
    }

    private void initHeaderGridView() {
        super.setClipChildren(false);
    }

    private void removeFixedViewInfo(View paramView, ArrayList<FixedViewInfo> paramArrayList) {
        int j = paramArrayList.size();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return;
            }
            if (((FixedViewInfo) paramArrayList.get(i)).view == paramView) {
                paramArrayList.remove(i);
                return;
            }
            i += 1;
        }
    }

    public void addHeaderView(View paramView) {
        addHeaderView(paramView, null, true);
    }

    public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean) {
        ListAdapter localListAdapter = getAdapter();
        if ((localListAdapter != null) && (!(localListAdapter instanceof HeaderViewGridAdapter))) {
            throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        }
        FixedViewInfo localFixedViewInfo = new FixedViewInfo(null);
        FullWidthFixedViewLayout localFullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
        localFullWidthFixedViewLayout.addView(paramView);
        localFixedViewInfo.view = paramView;
        localFixedViewInfo.viewContainer = localFullWidthFixedViewLayout;
        localFixedViewInfo.data = paramObject;
        localFixedViewInfo.isSelectable = paramBoolean;
        this.mHeaderViewInfos.add(localFixedViewInfo);
        if (localListAdapter != null) {
            ((HeaderViewGridAdapter) localListAdapter).notifyDataSetChanged();
        }
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        ListAdapter localListAdapter = getAdapter();
        if ((localListAdapter != null) && ((localListAdapter instanceof HeaderViewGridAdapter))) {
            ((HeaderViewGridAdapter) localListAdapter).setNumColumns(getNumColumns());
        }
    }

    public boolean removeHeaderView(View paramView) {
        if (this.mHeaderViewInfos.size() > 0) {
            boolean bool2 = false;
            ListAdapter localListAdapter = getAdapter();
            boolean bool1 = bool2;
            if (localListAdapter != null) {
                bool1 = bool2;
                if (((HeaderViewGridAdapter) localListAdapter).removeHeader(paramView)) {
                    bool1 = true;
                }
            }
            removeFixedViewInfo(paramView, this.mHeaderViewInfos);
            return bool1;
        }
        return false;
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        if (this.mHeaderViewInfos.size() > 0) {
            paramListAdapter = new HeaderViewGridAdapter(this.mHeaderViewInfos, paramListAdapter);
            int i = getNumColumns();
            if (i > 1) {
                paramListAdapter.setNumColumns(i);
            }
            super.setAdapter(paramListAdapter);
            return;
        }
        super.setAdapter(paramListAdapter);
    }

    public void setClipChildren(boolean paramBoolean) {
    }

    private static class FixedViewInfo {
        public Object data;
        public boolean isSelectable;
        public View view;
        public ViewGroup viewContainer;
    }

    private class FullWidthFixedViewLayout
            extends FrameLayout {
        public FullWidthFixedViewLayout(Context paramContext) {
            super();
        }

        protected void onMeasure(int paramInt1, int paramInt2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft() - HeaderGridView.this.getPaddingRight(), View.MeasureSpec.getMode(paramInt1)), paramInt2);
        }
    }

    private static class HeaderViewGridAdapter
            implements WrapperListAdapter, Filterable {
        private final ListAdapter mAdapter;
        boolean mAreAllFixedViewsSelectable;
        private final DataSetObservable mDataSetObservable = new DataSetObservable();
        ArrayList<HeaderGridView.FixedViewInfo> mHeaderViewInfos;
        private final boolean mIsFilterable;
        private int mNumColumns = 1;

        public HeaderViewGridAdapter(ArrayList<HeaderGridView.FixedViewInfo> paramArrayList, ListAdapter paramListAdapter) {
            this.mAdapter = paramListAdapter;
            this.mIsFilterable = (paramListAdapter instanceof Filterable);
            if (paramArrayList == null) {
                throw new IllegalArgumentException("headerViewInfos cannot be null");
            }
            this.mHeaderViewInfos = paramArrayList;
            this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos);
        }

        private boolean areAllListInfosSelectable(ArrayList<HeaderGridView.FixedViewInfo> paramArrayList) {
            if (paramArrayList != null) {
                paramArrayList = paramArrayList.iterator();
            }
            do {
                if (!paramArrayList.hasNext()) {
                    return true;
                }
            } while (((HeaderGridView.FixedViewInfo) paramArrayList.next()).isSelectable);
            return false;
        }

        public boolean areAllItemsEnabled() {
            return (this.mAdapter == null) || ((this.mAreAllFixedViewsSelectable) && (this.mAdapter.areAllItemsEnabled()));
        }

        public int getCount() {
            if (this.mAdapter != null) {
                return getHeadersCount() * this.mNumColumns + this.mAdapter.getCount();
            }
            return getHeadersCount() * this.mNumColumns;
        }

        public Filter getFilter() {
            if (this.mIsFilterable) {
                return ((Filterable) this.mAdapter).getFilter();
            }
            return null;
        }

        public int getHeadersCount() {
            return this.mHeaderViewInfos.size();
        }

        public Object getItem(int paramInt) {
            int i = getHeadersCount() * this.mNumColumns;
            if (paramInt < i) {
                if (paramInt % this.mNumColumns == 0) {
                    return ((HeaderGridView.FixedViewInfo) this.mHeaderViewInfos.get(paramInt / this.mNumColumns)).data;
                }
                return null;
            }
            i = paramInt - i;
            if ((this.mAdapter != null) && (i < this.mAdapter.getCount())) {
                return this.mAdapter.getItem(i);
            }
            throw new ArrayIndexOutOfBoundsException(paramInt);
        }

        public long getItemId(int paramInt) {
            int i = getHeadersCount() * this.mNumColumns;
            if ((this.mAdapter != null) && (paramInt >= i)) {
                paramInt -= i;
                if (paramInt < this.mAdapter.getCount()) {
                    return this.mAdapter.getItemId(paramInt);
                }
            }
            return -1L;
        }

        public int getItemViewType(int paramInt) {
            int i = getHeadersCount() * this.mNumColumns;
            if ((paramInt < i) && (paramInt % this.mNumColumns != 0)) {
                if (this.mAdapter != null) {
                    return this.mAdapter.getViewTypeCount();
                }
                return 1;
            }
            if ((this.mAdapter != null) && (paramInt >= i)) {
                paramInt -= i;
                if (paramInt < this.mAdapter.getCount()) {
                    return this.mAdapter.getItemViewType(paramInt);
                }
            }
            return -2;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            int i = getHeadersCount() * this.mNumColumns;
            if (paramInt < i) {
                ViewGroup localViewGroup = ((HeaderGridView.FixedViewInfo) this.mHeaderViewInfos.get(paramInt / this.mNumColumns)).viewContainer;
                if (paramInt % this.mNumColumns == 0) {
                    return localViewGroup;
                }
                View localView = paramView;
                if (paramView == null) {
                    localView = new View(paramViewGroup.getContext());
                }
                localView.setVisibility(4);
                localView.setMinimumHeight(localViewGroup.getHeight());
                return localView;
            }
            i = paramInt - i;
            if ((this.mAdapter != null) && (i < this.mAdapter.getCount())) {
                return this.mAdapter.getView(i, paramView, paramViewGroup);
            }
            throw new ArrayIndexOutOfBoundsException(paramInt);
        }

        public int getViewTypeCount() {
            if (this.mAdapter != null) {
                return this.mAdapter.getViewTypeCount() + 1;
            }
            return 2;
        }

        public ListAdapter getWrappedAdapter() {
            return this.mAdapter;
        }

        public boolean hasStableIds() {
            if (this.mAdapter != null) {
                return this.mAdapter.hasStableIds();
            }
            return false;
        }

        public boolean isEmpty() {
            return ((this.mAdapter == null) || (this.mAdapter.isEmpty())) && (getHeadersCount() == 0);
        }

        public boolean isEnabled(int paramInt) {
            int i = getHeadersCount() * this.mNumColumns;
            if (paramInt < i) {
                return (paramInt % this.mNumColumns == 0) && (((HeaderGridView.FixedViewInfo) this.mHeaderViewInfos.get(paramInt / this.mNumColumns)).isSelectable);
            }
            i = paramInt - i;
            if ((this.mAdapter != null) && (i < this.mAdapter.getCount())) {
                return this.mAdapter.isEnabled(i);
            }
            throw new ArrayIndexOutOfBoundsException(paramInt);
        }

        public void notifyDataSetChanged() {
            this.mDataSetObservable.notifyChanged();
        }

        public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {
            this.mDataSetObservable.registerObserver(paramDataSetObserver);
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(paramDataSetObserver);
            }
        }

        public boolean removeHeader(View paramView) {
            int i = 0;
            for (; ; ) {
                if (i >= this.mHeaderViewInfos.size()) {
                    return false;
                }
                if (((HeaderGridView.FixedViewInfo) this.mHeaderViewInfos.get(i)).view == paramView) {
                    this.mHeaderViewInfos.remove(i);
                    this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos);
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
                i += 1;
            }
        }

        public void setNumColumns(int paramInt) {
            if (paramInt < 1) {
                throw new IllegalArgumentException("Number of columns must be 1 or more");
            }
            if (this.mNumColumns != paramInt) {
                this.mNumColumns = paramInt;
                notifyDataSetChanged();
            }
        }

        public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
            this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/HeaderGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */