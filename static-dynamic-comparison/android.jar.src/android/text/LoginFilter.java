/*    */
package android.text;

/*    */
/*    */ public abstract class LoginFilter
/*    */ implements InputFilter
/*    */ {
    /*    */   public static class UsernameFilterGMail extends LoginFilter
/*    */ {
        /*  8 */
        public UsernameFilterGMail() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public UsernameFilterGMail(boolean appendInvalid) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public boolean isAllowed(char c) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static class UsernameFilterGeneric
/*    */ extends LoginFilter {
        /* 15 */
        public UsernameFilterGeneric() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public UsernameFilterGeneric(boolean appendInvalid) {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public boolean isAllowed(char c) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static class PasswordFilterGMail
/*    */ extends LoginFilter {
        /* 22 */
        public PasswordFilterGMail() {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public PasswordFilterGMail(boolean appendInvalid) {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public boolean isAllowed(char c) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 26 */   LoginFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void onStart() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void onInvalidCharacter(char c) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void onStop() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    public abstract boolean isAllowed(char paramChar);
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/LoginFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */