package android.support.v4.view.a;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

class o
        implements v {
    o(n paramn, j paramj) {
    }

    public Object a(int paramInt) {
        a locala = this.a.a(paramInt);
        if (locala == null) {
            return null;
        }
        return locala.a();
    }

    public List<Object> a(String paramString, int paramInt) {
        paramString = this.a.a(paramString, paramInt);
        ArrayList localArrayList = new ArrayList();
        int i = paramString.size();
        paramInt = 0;
        while (paramInt < i) {
            localArrayList.add(((a) paramString.get(paramInt)).a());
            paramInt += 1;
        }
        return localArrayList;
    }

    public boolean a(int paramInt1, int paramInt2, Bundle paramBundle) {
        return this.a.a(paramInt1, paramInt2, paramBundle);
    }

    public Object b(int paramInt) {
        a locala = this.a.b(paramInt);
        if (locala == null) {
            return null;
        }
        return locala.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */