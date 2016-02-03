/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class ArrayAdapter<T> extends BaseAdapter implements Filterable {
    /*  6 */
    public ArrayAdapter(Context context, int textViewResourceId) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ArrayAdapter(Context context, int resource, int textViewResourceId) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public ArrayAdapter(Context context, int textViewResourceId, T[] objects) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public ArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public ArrayAdapter(Context context, int textViewResourceId, java.util.List<T> objects) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public ArrayAdapter(Context context, int resource, int textViewResourceId, java.util.List<T> objects) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void add(T object) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void addAll(java.util.Collection<? extends T> collection) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void addAll(T... items) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void insert(T object, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void remove(T object) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void clear() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void sort(java.util.Comparator<? super T> comparator) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void notifyDataSetChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setNotifyOnChange(boolean notifyOnChange) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getCount() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public T getItem(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getPosition(T item) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public long getItemId(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setDropDownViewResource(int resource) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public android.view.View getDropDownView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public static ArrayAdapter<CharSequence> createFromResource(Context context, int textArrayResId, int textViewResId) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public Filter getFilter() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ArrayAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */