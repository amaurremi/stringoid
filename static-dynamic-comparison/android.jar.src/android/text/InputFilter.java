/*    */
package android.text;

/*    */
/*    */ public abstract interface InputFilter {
    /*    */
    public abstract CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4);

    /*    */
/*    */   public static class AllCaps implements InputFilter {
        /*  7 */
        public AllCaps() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static class LengthFilter
/*    */ implements InputFilter {
        /* 13 */
        public LengthFilter(int max) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/InputFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */