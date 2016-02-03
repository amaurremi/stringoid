package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class MoPubAdAdapter$4
        implements AdapterView.OnItemClickListener {
    MoPubAdAdapter$4(MoPubAdAdapter paramMoPubAdAdapter, AdapterView.OnItemClickListener paramOnItemClickListener) {
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (!MoPubAdAdapter.access$200(this.this$0).isAd(paramInt)) {
            this.val$listener.onItemClick(paramAdapterView, paramView, MoPubAdAdapter.access$200(this.this$0).getOriginalPosition(paramInt), paramLong);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubAdAdapter$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */