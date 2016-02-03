package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class ac
        extends aj {
    private static final String ID = a.Y.toString();
    private static final String XQ = b.bi.toString();
    private static final String XR = b.di.toString();
    private static final String XS = b.cH.toString();
    private static final String XT = b.dq.toString();

    public ac() {
        super(ID, new String[]{XQ});
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        Object localObject = (d.a) paramMap.get(XQ);
        if ((localObject == null) || (localObject == dh.lT())) {
            return dh.lT();
        }
        String str2 = dh.j((d.a) localObject);
        localObject = (d.a) paramMap.get(XS);
        String str1;
        if (localObject == null) {
            str1 = "text";
            localObject = (d.a) paramMap.get(XT);
            if (localObject != null) {
                break label148;
            }
            localObject = "base16";
            label75:
            paramMap = (d.a) paramMap.get(XR);
            if ((paramMap == null) || (!dh.n(paramMap).booleanValue())) {
                break label322;
            }
        }
        label148:
        label257:
        label296:
        label322:
        for (int i = 3; ; i = 2) {
            for (; ; ) {
                try {
                    if ("text".equals(str1)) {
                        paramMap = str2.getBytes();
                        if (!"base16".equals(localObject)) {
                            break label257;
                        }
                        paramMap = j.d(paramMap);
                        return dh.r(paramMap);
                        str1 = dh.j((d.a) localObject);
                        break;
                        localObject = dh.j((d.a) localObject);
                        break label75;
                    }
                    if ("base16".equals(str1)) {
                        paramMap = j.bm(str2);
                        continue;
                    }
                    if ("base64".equals(str1)) {
                        paramMap = Base64.decode(str2, i);
                        continue;
                    }
                    if ("base64url".equals(str1)) {
                        paramMap = Base64.decode(str2, i | 0x8);
                        continue;
                    }
                    bh.w("Encode: unknown input format: " + str1);
                    paramMap = dh.lT();
                    return paramMap;
                } catch (IllegalArgumentException paramMap) {
                    bh.w("Encode: invalid input:");
                    return dh.lT();
                }
                if ("base64".equals(localObject)) {
                    paramMap = Base64.encodeToString(paramMap, i);
                } else {
                    if (!"base64url".equals(localObject)) {
                        break label296;
                    }
                    paramMap = Base64.encodeToString(paramMap, i | 0x8);
                }
            }
            bh.w("Encode: unknown output format: " + (String) localObject);
            return dh.lT();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */