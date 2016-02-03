package com.google.android.gms.a;

import android.text.TextUtils;

import java.util.Map;

class bi
        implements Runnable {
    bi(bh parambh, Map paramMap) {
    }

    public void run() {
        bh.a(this.b, this.a);
        if (TextUtils.isEmpty((CharSequence) this.a.get("&cid"))) {
            this.a.put("&cid", al.a().a("&cid"));
        }
        if ((c.a(bh.a(this.b)).c()) || (bh.b(this.b, this.a))) {
            return;
        }
        if (!TextUtils.isEmpty(bh.b(this.b))) {
            bl.a().a(true);
            this.a.putAll(new j().d(bh.b(this.b)).a());
            bl.a().a(false);
            bh.a(this.b, null);
        }
        bh.c(this.b, this.a);
        Map localMap = br.a(this.a);
        bh.d(this.b).a(localMap, Long.valueOf((String) this.a.get("&ht")).longValue(), bh.d(this.b, this.a), bh.c(this.b));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */