package mobi.ifunny.util;

import android.text.LoginFilter.UsernameFilterGeneric;

import java.util.regex.Pattern;

public class ak
        extends LoginFilter.UsernameFilterGeneric {
    public ak() {
        super(false);
    }

    public boolean isAllowed(char paramChar) {
        return Pattern.matches("\\S", String.valueOf(paramChar));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */