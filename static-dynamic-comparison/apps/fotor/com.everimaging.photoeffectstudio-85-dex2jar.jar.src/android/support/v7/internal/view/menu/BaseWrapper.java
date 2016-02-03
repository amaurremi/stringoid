package android.support.v7.internal.view.menu;

class BaseWrapper<T> {
    final T mWrappedObject;

    BaseWrapper(T paramT) {
        if (paramT == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = paramT;
    }

    public T getWrappedObject() {
        return (T) this.mWrappedObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/internal/view/menu/BaseWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */