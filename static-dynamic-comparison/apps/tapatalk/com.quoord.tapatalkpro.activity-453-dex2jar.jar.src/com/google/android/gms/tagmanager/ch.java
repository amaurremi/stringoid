package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch
        extends dc {
    private static final String ID = a.ag.toString();
    private static final String Zb = b.cF.toString();

    public ch() {
        super(ID);
    }

    protected boolean a(String paramString1, String paramString2, Map<String, d.a> paramMap) {
        if (dh.n((d.a) paramMap.get(Zb)).booleanValue()) {
        }
        for (int i = 66; ; i = 64) {
            try {
                boolean bool = Pattern.compile(paramString2, i).matcher(paramString1).find();
                return bool;
            } catch (PatternSyntaxException paramString1) {
                return false;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */