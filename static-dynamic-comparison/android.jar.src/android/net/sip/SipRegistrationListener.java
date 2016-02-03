package android.net.sip;

public abstract interface SipRegistrationListener {
    public abstract void onRegistering(String paramString);

    public abstract void onRegistrationDone(String paramString, long paramLong);

    public abstract void onRegistrationFailed(String paramString1, int paramInt, String paramString2);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/sip/SipRegistrationListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */