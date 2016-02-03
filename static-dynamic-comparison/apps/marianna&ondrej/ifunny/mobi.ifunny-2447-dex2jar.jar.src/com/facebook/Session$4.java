package com.facebook;

import java.util.Iterator;
import java.util.List;

class Session$4
        implements Runnable {
    Session$4(Session paramSession, SessionState paramSessionState, Exception paramException) {
    }

    public void run() {
        synchronized (Session.access$1200(this.this$0)) {
            Iterator localIterator = Session.access$1200(this.this$0).iterator();
            if (localIterator.hasNext()) {
                Session .4 .1 local1 = new Session .4 .1 (this, (Session.StatusCallback) localIterator.next());
                Session.access$1400(Session.access$1300(this.this$0), local1);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */