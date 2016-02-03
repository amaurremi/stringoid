package com.google.android.gms.internal;

import java.io.IOException;

public class ks
        extends IOException {
    public ks(String paramString) {
        super(paramString);
    }

    static ks mA() {
        return new ks("CodedInputStream encountered a malformed varint.");
    }

    static ks mB() {
        return new ks("Protocol message contained an invalid tag (zero).");
    }

    static ks mC() {
        return new ks("Protocol message end-group tag did not match expected tag.");
    }

    static ks mD() {
        return new ks("Protocol message tag had invalid wire type.");
    }

    static ks mE() {
        return new ks("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static ks my() {
        return new ks("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static ks mz() {
        return new ks("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */