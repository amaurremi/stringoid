package android.widget;

public abstract interface SectionIndexer {
    public abstract Object[] getSections();

    public abstract int getPositionForSection(int paramInt);

    public abstract int getSectionForPosition(int paramInt);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/SectionIndexer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */