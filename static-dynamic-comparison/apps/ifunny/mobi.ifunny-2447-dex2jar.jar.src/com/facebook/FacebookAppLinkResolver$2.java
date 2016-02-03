package com.facebook;

import a.d;
import a.e;
import a.s;
import android.net.Uri;
import com.facebook.model.GraphObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FacebookAppLinkResolver$2
        implements Request.Callback {
    FacebookAppLinkResolver$2(FacebookAppLinkResolver paramFacebookAppLinkResolver, s params, Map paramMap, HashSet paramHashSet) {
    }

    public void onCompleted(Response paramResponse) {
        Object localObject1 = paramResponse.getError();
        if (localObject1 != null) {
            this.val$taskCompletionSource.b(((FacebookRequestError) localObject1).getException());
            return;
        }
        paramResponse = paramResponse.getGraphObject();
        if (paramResponse != null) {
        }
        for (paramResponse = paramResponse.getInnerJSONObject(); paramResponse == null; paramResponse = null) {
            this.val$taskCompletionSource.b(this.val$appLinkResults);
            return;
        }
        localObject1 = this.val$urisToRequest.iterator();
        Uri localUri;
        do {
            if (!((Iterator) localObject1).hasNext()) {
                break;
            }
            localUri = (Uri) ((Iterator) localObject1).next();
        } while (!paramResponse.has(localUri.toString()));
        for (; ; ) {
            int i;
            try {
                ???=paramResponse.getJSONObject(localUri.toString()).getJSONObject("app_links");
                Object localObject4 = ((JSONObject) ? ??).getJSONArray("android");
                int j = ((JSONArray) localObject4).length();
                ArrayList localArrayList = new ArrayList(j);
                i = 0;
                if (i < j) {
                    e locale = FacebookAppLinkResolver.access$000(((JSONArray) localObject4).getJSONObject(i));
                    if (locale == null) {
                        break label273;
                    }
                    localArrayList.add(locale);
                    break label273;
                }
                localObject4 = new d(localUri, localArrayList, FacebookAppLinkResolver.access$100(localUri, (JSONObject) ? ? ?))
                ;
                this.val$appLinkResults.put(localUri, localObject4);
                synchronized (FacebookAppLinkResolver.access$200(this.this$0)) {
                    FacebookAppLinkResolver.access$200(this.this$0).put(localUri, localObject4);
                }
            } catch (JSONException localJSONException) {
            }
            this.val$taskCompletionSource.b(this.val$appLinkResults);
            return;
            label273:
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/FacebookAppLinkResolver$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */