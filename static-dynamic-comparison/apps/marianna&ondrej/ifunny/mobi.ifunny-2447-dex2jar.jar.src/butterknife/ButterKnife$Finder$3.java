package butterknife;

import android.app.Dialog;
import android.view.View;

enum ButterKnife$Finder$3 {
    ButterKnife$Finder$3() {
        super(paramString,paramInt,null);
    }

    public View findOptionalView(Object paramObject, int paramInt) {
        return ((Dialog) paramObject).findViewById(paramInt);
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/ButterKnife$Finder$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */