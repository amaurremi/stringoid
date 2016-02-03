package mobi.ifunny.main;

import android.os.AsyncTask;
import com.google.android.gms.gcm.a;

import java.io.IOException;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.d;

class g
        extends AsyncTask<Void, Void, Void> {
    g(f paramf) {
    }

    protected Void a(Void... paramVarArgs) {
        paramVarArgs = IFunnyApplication.a;
        try {
            String str = a.a(paramVarArgs).a(new String[]{"604665798400"});
            f.a(this.a, paramVarArgs, str);
            f.a(paramVarArgs, str);
            return null;
        } catch (IOException paramVarArgs) {
            for (; ; ) {
                d.c(f.o, "Register GCM", paramVarArgs);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */