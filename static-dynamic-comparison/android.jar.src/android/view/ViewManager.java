package android.view;

public abstract interface ViewManager {
    public abstract void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams);

    public abstract void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams);

    public abstract void removeView(View paramView);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/ViewManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */