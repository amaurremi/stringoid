package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.UserMetadata;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class o
        extends l<UserMetadata> {
    public o(String paramString, int paramInt) {
        super(paramString, a(paramString), Collections.emptyList(), paramInt);
    }

    private static String a(String paramString1, String paramString2) {
        return paramString1 + "." + paramString2;
    }

    private static Collection<String> a(String paramString) {
        return Arrays.asList(new String[]{a(paramString, "permissionId"), a(paramString, "displayName"), a(paramString, "picture"), a(paramString, "isAuthenticatedUser"), a(paramString, "emailAddress")});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */