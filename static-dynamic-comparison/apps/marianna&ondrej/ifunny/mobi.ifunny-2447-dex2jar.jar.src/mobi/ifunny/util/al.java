package mobi.ifunny.util;

import android.text.LoginFilter.UsernameFilterGeneric;

public class al
        extends LoginFilter.UsernameFilterGeneric {
    public al() {
        super(false);
    }

    public boolean isAllowed(char paramChar) {
        return (paramChar != '\r') && (paramChar != '\n');
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */