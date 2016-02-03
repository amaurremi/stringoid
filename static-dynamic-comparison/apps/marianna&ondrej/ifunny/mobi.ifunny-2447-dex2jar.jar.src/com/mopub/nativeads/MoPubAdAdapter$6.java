package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class MoPubAdAdapter$6
        implements AdapterView.OnItemSelectedListener {
    MoPubAdAdapter$6(MoPubAdAdapter paramMoPubAdAdapter, AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (!this.this$0.isAd(paramInt)) {
            this.val$listener.onItemSelected(paramAdapterView, paramView, MoPubAdAdapter.access$200(this.this$0).getOriginalPosition(paramInt), paramLong);
        }
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView) {
        this.val$listener.onNothingSelected(paramAdapterView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubAdAdapter$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */