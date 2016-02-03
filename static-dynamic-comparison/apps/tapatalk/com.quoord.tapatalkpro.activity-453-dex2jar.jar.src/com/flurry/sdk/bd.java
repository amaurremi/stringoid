package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;

import java.util.Iterator;
import java.util.List;

public final class bd
        implements bf {
    private static final String a = bd.class.getSimpleName();

    private boolean a(String paramString1, String paramString2, bc parambc) {
        boolean bool2 = false;
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (parambc == null)) {
            return false;
        }
        boolean bool1 = bool2;
        try {
            if (!TextUtils.isEmpty(parambc.c())) {
                Class.forName(parambc.c());
                bool1 = true;
            }
        } catch (ClassNotFoundException localClassNotFoundException) {
            for (; ; ) {
                eo.a(6, a, "failed to find third party ad provider api with exception: ", localClassNotFoundException);
                bool1 = bool2;
            }
        } catch (ExceptionInInitializerError localExceptionInInitializerError) {
            for (; ; ) {
                eo.a(6, a, "failed to initialize third party ad provider api with exception: ", localExceptionInInitializerError);
                bool1 = bool2;
            }
        } catch (LinkageError localLinkageError) {
            for (; ; ) {
                eo.a(6, a, "failed to link third party ad provider api with exception: ", localLinkageError);
                bool1 = bool2;
            }
            eo.a(3, a, paramString1 + ": package=\"" + paramString2 + "\": apk has ad provider library with name=\"" + parambc.a() + "\" and version=\"" + parambc.b() + "\" or higher");
        }
        if (!bool1) {
            eo.b(a, paramString1 + ": package=\"" + paramString2 + "\": apk should include ad provider library with name=\"" + parambc.a() + "\" and version=\"" + parambc.b() + "\" or higher");
            return bool1;
        }
        return bool1;
    }

    public boolean a(Context paramContext, bj parambj) {
        if (parambj == null) {
        }
        String str;
        do {
            do {
                return false;
                str = parambj.a();
            } while (TextUtils.isEmpty(str));
            parambj = parambj.b();
        } while (parambj == null);
        paramContext = paramContext.getPackageName();
        parambj = parambj.iterator();
        boolean bool = true;
        if (parambj.hasNext()) {
            if (a(str, paramContext, (bc) parambj.next())) {
                break label78;
            }
            bool = false;
        }
        label78:
        for (; ; ) {
            break;
            return bool;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */