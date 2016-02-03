/*    */
package android.net;
/*    */ 
/*    */

import java.util.Set;

/*    */
/*    */ public class UrlQuerySanitizer {
    /*  6 */   public class ParameterValuePair {
        public ParameterValuePair(String parameter, String value) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public String mParameter;
        /*    */     public String mValue;
/*    */
    }

    /*    */
/*    */   public static abstract interface ValueSanitizer {
        public abstract String sanitize(String paramString);
    }

    /*    */
/*    */   public static class IllegalCharacterValueSanitizer implements UrlQuerySanitizer.ValueSanitizer {
        public static final int SPACE_OK = 1;
        /*    */     public static final int OTHER_WHITESPACE_OK = 2;

        /*    */
/* 17 */
        public IllegalCharacterValueSanitizer(int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public String sanitize(String value) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int NON_7_BIT_ASCII_OK = 4;
        /*    */     public static final int DQUOTE_OK = 8;
        /*    */     public static final int SQUOTE_OK = 16;
        /*    */     public static final int LT_OK = 32;
        /*    */     public static final int GT_OK = 64;
        /*    */     public static final int AMP_OK = 128;
        /*    */     public static final int PCT_OK = 256;
        /*    */     public static final int NUL_OK = 512;
        /*    */     public static final int SCRIPT_URL_OK = 1024;
        /*    */     public static final int ALL_OK = 2047;
        /*    */     public static final int ALL_WHITESPACE_OK = 3;
        /*    */     public static final int ALL_ILLEGAL = 0;
        /*    */     public static final int ALL_BUT_NUL_LEGAL = 1535;
        /*    */     public static final int ALL_BUT_WHITESPACE_LEGAL = 1532;
        /*    */     public static final int URL_LEGAL = 404;
        /*    */     public static final int URL_AND_SPACE_LEGAL = 405;
        /*    */     public static final int AMP_LEGAL = 128;
        /*    */     public static final int AMP_AND_SPACE_LEGAL = 129;
        /*    */     public static final int SPACE_LEGAL = 1;
        /*    */     public static final int ALL_BUT_NUL_AND_ANGLE_BRACKETS_LEGAL = 1439;
/*    */
    }

    /*    */
/* 42 */
    public UrlQuerySanitizer() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public UrlQuerySanitizer(String url) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public ValueSanitizer getUnregisteredParameterValueSanitizer() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void setUnregisteredParameterValueSanitizer(ValueSanitizer sanitizer) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public static final ValueSanitizer getAllIllegal() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public static final ValueSanitizer getAllButNulLegal() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public static final ValueSanitizer getAllButWhitespaceLegal() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public static final ValueSanitizer getUrlLegal() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public static final ValueSanitizer getUrlAndSpaceLegal() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public static final ValueSanitizer getAmpLegal() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public static final ValueSanitizer getAmpAndSpaceLegal() {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public static final ValueSanitizer getSpaceLegal() {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public static final ValueSanitizer getAllButNulAndAngleBracketsLegal() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void parseUrl(String url) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void parseQuery(String query) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public Set<String> getParameterSet() {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public java.util.List<ParameterValuePair> getParameterList() {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public boolean hasParameter(String parameter) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public String getValue(String parameter) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void registerParameter(String parameter, ValueSanitizer valueSanitizer) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public void registerParameters(String[] parameters, ValueSanitizer valueSanitizer) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public void setAllowUnregisteredParamaters(boolean allowUnregisteredParamaters) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public boolean getAllowUnregisteredParamaters() {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void setPreferFirstRepeatedParameter(boolean preferFirstRepeatedParameter) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public boolean getPreferFirstRepeatedParameter() {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    protected void parseEntry(String parameter, String value) {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    protected void addSanitizedEntry(String parameter, String value) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public ValueSanitizer getValueSanitizer(String parameter) {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public ValueSanitizer getEffectiveValueSanitizer(String parameter) {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public String unescape(String string) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    protected boolean isHexDigit(char c) {
        throw new RuntimeException("Stub!");
    }

    /* 73 */
    protected int decodeHexDigit(char c) {
        throw new RuntimeException("Stub!");
    }

    /* 74 */
    protected void clear() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/UrlQuerySanitizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */