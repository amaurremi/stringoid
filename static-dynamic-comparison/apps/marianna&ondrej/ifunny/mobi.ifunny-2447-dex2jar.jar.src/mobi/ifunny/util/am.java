package mobi.ifunny.util;

import android.text.LoginFilter.UsernameFilterGeneric;

public class am
        extends LoginFilter.UsernameFilterGeneric {
    public am() {
        super(false);
    }

    public boolean isAllowed(char paramChar) {
        return (('0' <= paramChar) && (paramChar <= '9')) || (('a' <= paramChar) && (paramChar <= 'z')) || (('A' <= paramChar) && (paramChar <= 'Z')) || (paramChar == '_');
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */