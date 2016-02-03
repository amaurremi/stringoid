package com.everimaging.fotorsdk.uil.core.assist.deque;

public class LIFOLinkedBlockingDeque<T>
        extends LinkedBlockingDeque<T> {
    public boolean offer(T paramT) {
        return super.offerFirst(paramT);
    }

    public T remove() {
        return (T) super.removeFirst();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/assist/deque/LIFOLinkedBlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */