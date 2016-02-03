package android.widget;

public abstract interface HeterogeneousExpandableList {
    public abstract int getGroupType(int paramInt);

    public abstract int getChildType(int paramInt1, int paramInt2);

    public abstract int getGroupTypeCount();

    public abstract int getChildTypeCount();
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/HeterogeneousExpandableList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */