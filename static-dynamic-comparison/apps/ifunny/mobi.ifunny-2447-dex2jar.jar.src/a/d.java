package a;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

public class d {
    private Uri a;
    private List<e> b;
    private Uri c;

    public d(Uri paramUri1, List<e> paramList, Uri paramUri2) {
        this.a = paramUri1;
        paramUri1 = paramList;
        if (paramList == null) {
            paramUri1 = Collections.emptyList();
        }
        this.b = paramUri1;
        this.c = paramUri2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */