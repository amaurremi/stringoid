package com.inmobi.commons.cache;

import com.inmobi.commons.internal.Log;

import java.util.TimerTask;

class RetryMechanism$a
        extends TimerTask {
    RetryMechanism$a(RetryMechanism paramRetryMechanism, RetryMechanism.RetryRunnable paramRetryRunnable) {
    }

    public void run() {
        try {
            this.a.run();
            this.a.completed();
            return;
        } catch (Exception localException) {
            RetryMechanism.a(this.b);
            if (RetryMechanism.b(this.b) > RetryMechanism.c(this.b)) {
                Log.internal("[InMobi]-4.5.1", "Exception occured while running retry mechanism and will the limit for retrying has been reached.");
                this.a.completed();
                return;
            }
            Log.internal("[InMobi]-4.5.1", "Exception occured while running retry mechanism and will retry in " + RetryMechanism.b(this.b) * RetryMechanism.d(this.b) + " ms");
            RetryMechanism.a(this.b, this.a, RetryMechanism.b(this.b) * RetryMechanism.d(this.b));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/cache/RetryMechanism$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */