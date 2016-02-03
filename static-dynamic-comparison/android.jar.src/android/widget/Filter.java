/*    */
package android.widget;

/*    */
/*    */ public abstract class Filter {
    public static abstract interface FilterListener {
        public abstract void onFilterComplete(int paramInt);
/*    */
    }

    /*    */
/*  6 */   protected static class FilterResults {
        public FilterResults() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */     public Object values;
        /*    */
/*    */     public int count;
/*    */
    }

    /*    */
/* 14 */
    public Filter() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final void filter(CharSequence constraint) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public final void filter(CharSequence constraint, FilterListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    protected abstract FilterResults performFiltering(CharSequence paramCharSequence);

    /*    */
    protected abstract void publishResults(CharSequence paramCharSequence, FilterResults paramFilterResults);

    /* 19 */
    public CharSequence convertResultToString(Object resultValue) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/Filter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */