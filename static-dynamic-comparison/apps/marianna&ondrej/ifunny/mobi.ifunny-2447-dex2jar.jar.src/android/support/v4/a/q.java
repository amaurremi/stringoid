package android.support.v4.a;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

class q {
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;

    q(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver) {
        this.a = paramIntentFilter;
        this.b = paramBroadcastReceiver;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("Receiver{");
        localStringBuilder.append(this.b);
        localStringBuilder.append(" filter=");
        localStringBuilder.append(this.a);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */