package com.mopub.nativeads;

import android.database.DataSetObserver;
import android.widget.Adapter;

class MoPubAdAdapter$2
        extends DataSetObserver {
    MoPubAdAdapter$2(MoPubAdAdapter paramMoPubAdAdapter) {
    }

    public void onChanged() {
        MoPubAdAdapter.access$200(this.this$0).setItemCount(MoPubAdAdapter.access$100(this.this$0).getCount());
        this.this$0.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.this$0.notifyDataSetInvalidated();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubAdAdapter$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */