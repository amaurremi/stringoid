package mobi.ifunny.search;

import android.support.v4.app.Fragment;
import android.support.v4.app.q;

import java.util.ArrayList;

import mobi.ifunny.fragment.d;

public class m
        extends d {
    private String a;

    public m(q paramq) {
        super(paramq);
    }

    public a a(int paramInt) {
        if ((paramInt >= 0) && (paramInt < a().size())) {
            return (a) a().get(paramInt);
        }
        return null;
    }

    public void a(String paramString) {
        this.a = paramString;
        int i = 0;
        while (i < getCount()) {
            a locala = a(i);
            if (locala != null) {
                locala.a(paramString);
            }
            i += 1;
        }
    }

    public int getCount() {
        return 2;
    }

    public Fragment getItem(int paramInt) {
        switch (paramInt) {
            default:
                throw new IllegalArgumentException();
        }
        for (Object localObject = new h(); ; localObject = new i()) {
            ((a) localObject).a(this.a);
            return (Fragment) localObject;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */