package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

class MoPubCustomEventNative$MoPubForwardingNativeAd
        extends BaseForwardingNativeAd {
    MoPubCustomEventNative$MoPubForwardingNativeAd(String paramString) {
        if (paramString == null) {
            throw new IllegalArgumentException("Json String cannot be null");
        }
        JSONObject localJSONObject = new JSONObject(new JSONTokener(paramString));
        if (!containsRequiredKeys(localJSONObject)) {
            throw new IllegalArgumentException("JSONObject did not contain required keys.");
        }
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext()) {
            paramString = (String) localIterator.next();
            NativeResponse.Parameter localParameter = NativeResponse.Parameter.from(paramString);
            if (localParameter != null) {
                try {
                    addInstanceVariable(localParameter, localJSONObject.opt(paramString));
                } catch (ClassCastException localClassCastException) {
                    throw new IllegalArgumentException("JSONObject key (" + paramString + ") contained unexpected value.");
                }
            } else {
                addExtra(paramString, localClassCastException.opt(paramString));
            }
        }
    }

    private void addImpressionTrackers(Object paramObject) {
        if (!(paramObject instanceof JSONArray)) {
            throw new ClassCastException("Expected impression trackers of type JSONArray.");
        }
        paramObject = (JSONArray) paramObject;
        int i = 0;
        for (; ; ) {
            if (i < ((JSONArray) paramObject).length()) {
                try {
                    addImpressionTracker(((JSONArray) paramObject).getString(i));
                    i += 1;
                } catch (JSONException localJSONException) {
                    for (; ; ) {
                        MoPubLog.d("Unable to parse impression trackers.");
                    }
                }
            }
        }
    }

    private void addInstanceVariable(NativeResponse.Parameter paramParameter, Object paramObject) {
        for (; ; ) {
            try {
                switch (MoPubCustomEventNative
                .2.$SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[paramParameter.ordinal()])
                {
                    case 1:
                        MoPubLog.d("Unable to add JSON key to internal mapping: " + paramParameter.name);
                        return;
                }
            } catch (ClassCastException paramObject) {
                if (paramParameter.required) {
                    continue;
                }
                MoPubLog.d("Ignoring class cast exception for optional key: " + paramParameter.name);
                return;
                setIconImageUrl((String) paramObject);
                return;
                addImpressionTrackers(paramObject);
                return;
                setClickDestinationUrl((String) paramObject);
                return;
                setCallToAction((String) paramObject);
                return;
                setTitle((String) paramObject);
                return;
                setText((String) paramObject);
                return;
                setStarRating(Numbers.parseDouble(paramObject));
                return;
                throw ((Throwable) paramObject);
            }
            setMainImageUrl((String) paramObject);
            return;
        }
    }

    private boolean containsRequiredKeys(JSONObject paramJSONObject) {
        HashSet localHashSet = new HashSet();
        paramJSONObject = paramJSONObject.keys();
        while (paramJSONObject.hasNext()) {
            localHashSet.add(paramJSONObject.next());
        }
        return localHashSet.containsAll(NativeResponse.Parameter.requiredKeys);
    }

    private boolean isImageKey(String paramString) {
        return (paramString != null) && (paramString.toLowerCase().endsWith("image"));
    }

    List<String> getAllImageUrls() {
        ArrayList localArrayList = new ArrayList();
        if (getMainImageUrl() != null) {
            localArrayList.add(getMainImageUrl());
        }
        if (getIconImageUrl() != null) {
            localArrayList.add(getIconImageUrl());
        }
        localArrayList.addAll(getExtrasImageUrls());
        return localArrayList;
    }

    List<String> getExtrasImageUrls() {
        ArrayList localArrayList = new ArrayList(getExtras().size());
        Iterator localIterator = getExtras().entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            if ((isImageKey((String) localEntry.getKey())) && ((localEntry.getValue() instanceof String))) {
                localArrayList.add((String) localEntry.getValue());
            }
        }
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubCustomEventNative$MoPubForwardingNativeAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */