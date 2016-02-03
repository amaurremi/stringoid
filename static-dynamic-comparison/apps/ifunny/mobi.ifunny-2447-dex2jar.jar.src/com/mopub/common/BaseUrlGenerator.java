package com.mopub.common;

import android.net.Uri;
import com.mopub.common.util.Strings;

public abstract class BaseUrlGenerator {
    private static final String IFA_PREFIX = "ifa:";
    private static final String SHA_PREFIX = "sha:";
    private boolean mFirstParam;
    private StringBuilder mStringBuilder;

    private String getParamDelimiter() {
        if (this.mFirstParam) {
            this.mFirstParam = false;
            return "?";
        }
        return "&";
    }

    protected void addParam(String paramString1, String paramString2) {
        if ((paramString2 == null) || (Strings.isEmpty(paramString2))) {
            return;
        }
        this.mStringBuilder.append(getParamDelimiter());
        this.mStringBuilder.append(paramString1);
        this.mStringBuilder.append("=");
        this.mStringBuilder.append(Uri.encode(paramString2));
    }

    public abstract String generateUrlString(String paramString);

    protected String getFinalUrlString() {
        return this.mStringBuilder.toString();
    }

    protected void initUrlString(String paramString1, String paramString2) {
        this.mStringBuilder = new StringBuilder("http://" + paramString1 + paramString2);
        this.mFirstParam = true;
    }

    protected void setApiVersion(String paramString) {
        addParam("v", paramString);
    }

    protected void setAppVersion(String paramString) {
        addParam("av", paramString);
    }

    protected void setDeviceInfo(String... paramVarArgs) {
        StringBuilder localStringBuilder = new StringBuilder();
        if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
            return;
        }
        int i = 0;
        while (i < paramVarArgs.length - 1) {
            localStringBuilder.append(paramVarArgs[i]).append(",");
            i += 1;
        }
        localStringBuilder.append(paramVarArgs[(paramVarArgs.length - 1)]);
        addParam("dn", localStringBuilder.toString());
    }

    protected void setDoNotTrack(boolean paramBoolean) {
        if (paramBoolean) {
            addParam("dnt", "1");
        }
    }

    protected void setExternalStoragePermission(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (String str = "1"; ; str = "0") {
            addParam("android_perms_ext_storage", str);
            return;
        }
    }

    protected void setUdid(String paramString) {
        addParam("udid", paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/BaseUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */