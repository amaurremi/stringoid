package com.quoord.tapatalkpro.ui.nested;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeAdapter
        extends BaseAdapter
        implements SectionIndexer {
    protected PieceStateRoster pieces = new PieceStateRoster(null);

    public void addAdapter(ListAdapter paramListAdapter) {
        this.pieces.add(paramListAdapter);
        paramListAdapter.registerDataSetObserver(new CascadeDataSetObserver(null));
    }

    public void addView(View paramView) {
        addView(paramView, false);
    }

    public void addView(View paramView, boolean paramBoolean) {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(paramView);
        addViews(localArrayList, paramBoolean);
    }

    public void addViews(List<View> paramList) {
        addViews(paramList, false);
    }

    public void addViews(List<View> paramList, boolean paramBoolean) {
        if (paramBoolean) {
            addAdapter(new EnabledSackAdapter(paramList));
            return;
        }
        addAdapter(new SackOfViewsAdapter(paramList));
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public ListAdapter getAdapter(int paramInt) {
        Iterator localIterator = getPieces().iterator();
        for (; ; ) {
            ListAdapter localListAdapter;
            if (!localIterator.hasNext()) {
                localListAdapter = null;
            }
            int i;
            do {
                return localListAdapter;
                localListAdapter = (ListAdapter) localIterator.next();
                i = localListAdapter.getCount();
            } while (paramInt < i);
            paramInt -= i;
        }
    }

    public int getCount() {
        int i = 0;
        Iterator localIterator = getPieces().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return i;
            }
            i += ((ListAdapter) localIterator.next()).getCount();
        }
    }

    public Object getItem(int paramInt) {
        Iterator localIterator = getPieces().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return null;
            }
            ListAdapter localListAdapter = (ListAdapter) localIterator.next();
            int i = localListAdapter.getCount();
            if (paramInt < i) {
                return localListAdapter.getItem(paramInt);
            }
            paramInt -= i;
        }
    }

    public long getItemId(int paramInt) {
        Iterator localIterator = getPieces().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return -1L;
            }
            ListAdapter localListAdapter = (ListAdapter) localIterator.next();
            int i = localListAdapter.getCount();
            if (paramInt < i) {
                return localListAdapter.getItemId(paramInt);
            }
            paramInt -= i;
        }
    }

    public int getItemViewType(int paramInt) {
        int j = 0;
        Iterator localIterator = this.pieces.getRawPieces().iterator();
        int i = paramInt;
        paramInt = j;
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return -1;
            }
            PieceState localPieceState = (PieceState) localIterator.next();
            j = i;
            if (localPieceState.isActive) {
                j = localPieceState.adapter.getCount();
                if (i < j) {
                    return paramInt + localPieceState.adapter.getItemViewType(i);
                }
                j = i - j;
            }
            paramInt += localPieceState.adapter.getViewTypeCount();
            i = j;
        }
    }

    protected List<ListAdapter> getPieces() {
        return this.pieces.getPieces();
    }

    public int getPositionForSection(int paramInt) {
        int j = 0;
        Iterator localIterator = getPieces().iterator();
        int i = paramInt;
        paramInt = j;
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return 0;
            }
            ListAdapter localListAdapter = (ListAdapter) localIterator.next();
            j = i;
            if ((localListAdapter instanceof SectionIndexer)) {
                Object[] arrayOfObject = ((SectionIndexer) localListAdapter).getSections();
                int k = 0;
                if (arrayOfObject != null) {
                    k = arrayOfObject.length;
                }
                if (i < k) {
                    return ((SectionIndexer) localListAdapter).getPositionForSection(i) + paramInt;
                }
                j = i;
                if (arrayOfObject != null) {
                    j = i - k;
                }
            }
            paramInt += localListAdapter.getCount();
            i = j;
        }
    }

    public int getSectionForPosition(int paramInt) {
        int i = 0;
        Iterator localIterator = getPieces().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
            }
            Object localObject;
            int k;
            do {
                return 0;
                localObject = (ListAdapter) localIterator.next();
                k = ((ListAdapter) localObject).getCount();
                if (paramInt >= k) {
                    break;
                }
            } while (!(localObject instanceof SectionIndexer));
            return ((SectionIndexer) localObject).getSectionForPosition(paramInt) + i;
            int j = i;
            if ((localObject instanceof SectionIndexer)) {
                localObject = ((SectionIndexer) localObject).getSections();
                j = i;
                if (localObject != null) {
                    j = i + localObject.length;
                }
            }
            paramInt -= k;
            i = j;
        }
    }

    public Object[] getSections() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = getPieces().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                if (localArrayList.size() != 0) {
                    break;
                }
                return new String[0];
            }
            Object localObject = (ListAdapter) localIterator.next();
            if ((localObject instanceof SectionIndexer)) {
                localObject = ((SectionIndexer) localObject).getSections();
                if (localObject != null) {
                    Collections.addAll(localArrayList, (Object[]) localObject);
                }
            }
        }
        return localArrayList.toArray(new Object[0]);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Iterator localIterator = getPieces().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return null;
            }
            ListAdapter localListAdapter = (ListAdapter) localIterator.next();
            int i = localListAdapter.getCount();
            if (paramInt < i) {
                return localListAdapter.getView(paramInt, paramView, paramViewGroup);
            }
            paramInt -= i;
        }
    }

    public int getViewTypeCount() {
        int i = 0;
        Iterator localIterator = this.pieces.getRawPieces().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return Math.max(i, 1);
            }
            i += ((PieceState) localIterator.next()).adapter.getViewTypeCount();
        }
    }

    public boolean isEnabled(int paramInt) {
        Iterator localIterator = getPieces().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return false;
            }
            ListAdapter localListAdapter = (ListAdapter) localIterator.next();
            int i = localListAdapter.getCount();
            if (paramInt < i) {
                return localListAdapter.isEnabled(paramInt);
            }
            paramInt -= i;
        }
    }

    public void setActive(View paramView, boolean paramBoolean) {
        this.pieces.setActive(paramView, paramBoolean);
        notifyDataSetChanged();
    }

    public void setActive(ListAdapter paramListAdapter, boolean paramBoolean) {
        this.pieces.setActive(paramListAdapter, paramBoolean);
        notifyDataSetChanged();
    }

    private class CascadeDataSetObserver
            extends DataSetObserver {
        private CascadeDataSetObserver() {
        }

        public void onChanged() {
            MergeAdapter.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            MergeAdapter.this.notifyDataSetInvalidated();
        }
    }

    private static class EnabledSackAdapter
            extends SackOfViewsAdapter {
        public EnabledSackAdapter(List<View> paramList) {
            super();
        }

        public boolean areAllItemsEnabled() {
            return true;
        }

        public boolean isEnabled(int paramInt) {
            return true;
        }
    }

    private static class PieceState {
        ListAdapter adapter;
        boolean isActive = true;

        PieceState(ListAdapter paramListAdapter, boolean paramBoolean) {
            this.adapter = paramListAdapter;
            this.isActive = paramBoolean;
        }
    }

    private static class PieceStateRoster {
        protected ArrayList<ListAdapter> active = null;
        protected ArrayList<MergeAdapter.PieceState> pieces = new ArrayList();

        void add(ListAdapter paramListAdapter) {
            this.pieces.add(new MergeAdapter.PieceState(paramListAdapter, true));
        }

        List<ListAdapter> getPieces() {
            Iterator localIterator;
            if (this.active == null) {
                this.active = new ArrayList();
                localIterator = this.pieces.iterator();
            }
            for (; ; ) {
                if (!localIterator.hasNext()) {
                    return this.active;
                }
                MergeAdapter.PieceState localPieceState = (MergeAdapter.PieceState) localIterator.next();
                if (localPieceState.isActive) {
                    this.active.add(localPieceState.adapter);
                }
            }
        }

        List<MergeAdapter.PieceState> getRawPieces() {
            return this.pieces;
        }

        void setActive(View paramView, boolean paramBoolean) {
            Iterator localIterator = this.pieces.iterator();
            MergeAdapter.PieceState localPieceState;
            do {
                if (!localIterator.hasNext()) {
                    return;
                }
                localPieceState = (MergeAdapter.PieceState) localIterator.next();
            }
            while ((!(localPieceState.adapter instanceof SackOfViewsAdapter)) || (!((SackOfViewsAdapter) localPieceState.adapter).hasView(paramView)));
            localPieceState.isActive = paramBoolean;
            this.active = null;
        }

        void setActive(ListAdapter paramListAdapter, boolean paramBoolean) {
            Iterator localIterator = this.pieces.iterator();
            MergeAdapter.PieceState localPieceState;
            do {
                if (!localIterator.hasNext()) {
                    return;
                }
                localPieceState = (MergeAdapter.PieceState) localIterator.next();
            } while (localPieceState.adapter != paramListAdapter);
            localPieceState.isActive = paramBoolean;
            this.active = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/nested/MergeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */