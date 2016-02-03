package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class MoPubAdAdapter$5
        implements AdapterView.OnItemLongClickListener {
    MoPubAdAdapter$5(MoPubAdAdapter paramMoPubAdAdapter, AdapterView.OnItemLongClickListener paramOnItemLongClickListener) {
    }

    public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        return (this.this$0.isAd(paramInt)) || (this.val$listener.onItemLongClick(paramAdapterView, paramView, MoPubAdAdapter.access$200(this.this$0).getOriginalPosition(paramInt), paramLong));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubAdAdapter$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */