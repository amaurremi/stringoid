package com.facebook.ads.internal;

import android.os.AsyncTask;
import com.facebook.ads.AdError;

class AdRequest$1
        extends AsyncTask<Void, Void, AdRequest.AdRequestResponse> {
    AdRequest$1(AdRequest paramAdRequest) {
    }

    protected AdRequest.AdRequestResponse doInBackground(Void... paramVarArgs) {
        return this.this$0.executeConnectionAndWait();
    }

    protected void onPostExecute(AdRequest.AdRequestResponse paramAdRequestResponse) {
        if (paramAdRequestResponse == null) {
            AdRequest.access$000(this.this$0).onError(AdError.INTERNAL_ERROR);
            return;
        }
        if (paramAdRequestResponse.error != null) {
            AdRequest.access$000(this.this$0).onError(paramAdRequestResponse.error);
            return;
        }
        paramAdRequestResponse = AdResponse.parseResponse(AdRequest.access$100(this.this$0), paramAdRequestResponse.body);
        AdRequest.access$000(this.this$0).onCompleted(paramAdRequestResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdRequest$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */