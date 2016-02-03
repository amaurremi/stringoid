package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.logging.MoPubLog;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class NativeViewHolder {
    TextView callToActionView;
    ImageView iconImageView;
    ImageView mainImageView;
    TextView textView;
    TextView titleView;

    private void addTextView(TextView paramTextView, String paramString) {
        if (paramTextView == null) {
            MoPubLog.d("Attempted to add text (" + paramString + ") to null TextView.");
            return;
        }
        paramTextView.setText(null);
        if (paramString == null) {
            MoPubLog.d("Attempted to set TextView contents to null.");
            return;
        }
        paramTextView.setText(paramString);
    }

    static NativeViewHolder fromViewBinder(View paramView, ViewBinder paramViewBinder) {
        NativeViewHolder localNativeViewHolder = new NativeViewHolder();
        try {
            localNativeViewHolder.titleView = ((TextView) paramView.findViewById(paramViewBinder.titleId));
            localNativeViewHolder.textView = ((TextView) paramView.findViewById(paramViewBinder.textId));
            localNativeViewHolder.callToActionView = ((TextView) paramView.findViewById(paramViewBinder.callToActionId));
            localNativeViewHolder.mainImageView = ((ImageView) paramView.findViewById(paramViewBinder.mainImageId));
            localNativeViewHolder.iconImageView = ((ImageView) paramView.findViewById(paramViewBinder.iconImageId));
            return localNativeViewHolder;
        } catch (ClassCastException paramView) {
            MoPubLog.d("Could not cast View from id in ViewBinder to expected View type", paramView);
        }
        return null;
    }

    void update(NativeResponse paramNativeResponse) {
        addTextView(this.titleView, paramNativeResponse.getTitle());
        addTextView(this.textView, paramNativeResponse.getText());
        addTextView(this.callToActionView, paramNativeResponse.getCallToAction());
        paramNativeResponse.loadMainImage(this.mainImageView);
        paramNativeResponse.loadIconImage(this.iconImageView);
    }

    void updateExtras(View paramView, NativeResponse paramNativeResponse, ViewBinder paramViewBinder) {
        Iterator localIterator = paramViewBinder.extras.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            View localView = paramView.findViewById(((Integer) paramViewBinder.extras.get(str)).intValue());
            Object localObject = paramNativeResponse.getExtra(str);
            if ((localView instanceof ImageView)) {
                ((ImageView) localView).setImageDrawable(null);
                paramNativeResponse.loadExtrasImage(str, (ImageView) localView);
            } else if ((localView instanceof TextView)) {
                ((TextView) localView).setText(null);
                if ((localObject instanceof String)) {
                    addTextView((TextView) localView, (String) localObject);
                }
            } else {
                MoPubLog.d("View bound to " + str + " should be an instance of TextView or ImageView.");
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */