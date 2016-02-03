package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.logging.MoPubLog;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

import org.apache.http.Header;

@Deprecated
class AdLoadTask$LegacyCustomEventAdLoadTask
        extends AdLoadTask {
    private Header mHeader;

    public AdLoadTask$LegacyCustomEventAdLoadTask(AdViewController paramAdViewController, Header paramHeader) {
        super(paramAdViewController);
        this.mHeader = paramHeader;
    }

    void cleanup() {
        this.mHeader = null;
    }

    void execute() {
        Object localObject = (AdViewController) this.mWeakAdViewController.get();
        if ((localObject == null) || (((AdViewController) localObject).isDestroyed())) {
            return;
        }
        ((AdViewController) localObject).setNotLoading();
        localObject = ((AdViewController) localObject).getMoPubView();
        if (this.mHeader == null) {
            MoPubLog.i("Couldn't call custom method because the server did not specify one.");
            ((MoPubView) localObject).loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        String str = this.mHeader.getValue();
        MoPubLog.i("Trying to call method named " + str);
        Activity localActivity = ((MoPubView) localObject).getActivity();
        try {
            localActivity.getClass().getMethod(str, new Class[]{MoPubView.class}).invoke(localActivity, new Object[]{localObject});
            return;
        } catch (NoSuchMethodException localNoSuchMethodException) {
            MoPubLog.d("Couldn't perform custom method named " + str + "(MoPubView view) because your activity class has no such method");
            ((MoPubView) localObject).loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        } catch (Exception localException) {
            MoPubLog.d("Couldn't perform custom method named " + str);
            ((MoPubView) localObject).loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    @Deprecated
    Header getHeader() {
        return this.mHeader;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdLoadTask$LegacyCustomEventAdLoadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */