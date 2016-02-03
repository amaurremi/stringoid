package com.facebook.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;

import java.util.HashSet;

abstract class NativeProtocol$NativeAppInfo {
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    private static final HashSet<String> validAppSignatureHashes = ;

    private static HashSet<String> buildAppSignatureHashes() {
        HashSet localHashSet = new HashSet();
        localHashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
        localHashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
        localHashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
        return localHashSet;
    }

    protected abstract String getPackage();

    public boolean validateSignature(Context paramContext, String paramString) {
        String str = Build.BRAND;
        int i = paramContext.getApplicationInfo().flags;
        if ((str.startsWith("generic")) && ((i & 0x2) != 0)) {
        }
        for (; ; ) {
            return true;
            try {
                paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
                paramContext = paramContext.signatures;
                int j = paramContext.length;
                i = 0;
                for (; ; ) {
                    if (i >= j) {
                        break label89;
                    }
                    paramString = Utility.sha1hash(paramContext[i].toByteArray());
                    if (validAppSignatureHashes.contains(paramString)) {
                        break;
                    }
                    i += 1;
                }
                return false;
            } catch (PackageManager.NameNotFoundException paramContext) {
                return false;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/NativeProtocol$NativeAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */