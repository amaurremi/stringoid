/*   */
package android.text.style;

/*   */
/*   */ public abstract interface TabStopSpan
/*   */ extends ParagraphStyle {
    /*   */
    public abstract int getTabStop();

    /*   */
/*   */   public static class Standard implements TabStopSpan {
        /* 8 */
        public Standard(int where) {
            throw new RuntimeException("Stub!");
        }

        /* 9 */
        public int getTabStop() {
            throw new RuntimeException("Stub!");
        }
/*   */
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/TabStopSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */