/*   */
package android.text;

/*   */
/*   */ public abstract interface Spannable extends Spanned {
    public abstract void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3);

    /*   */
/*   */
    public abstract void removeSpan(Object paramObject);

    /*   */
/* 7 */   public static class Factory {
        public Factory() {
            throw new RuntimeException("Stub!");
        }

        /* 8 */
        public static Factory getInstance() {
            throw new RuntimeException("Stub!");
        }

        /* 9 */
        public Spannable newSpannable(CharSequence source) {
            throw new RuntimeException("Stub!");
        }
/*   */
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/Spannable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */