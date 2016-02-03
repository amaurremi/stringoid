package javassist.bytecode.analysis;

import java.util.NoSuchElementException;

class IntQueue {
    private IntQueue.Entry head;
    private IntQueue.Entry tail;

    void add(int paramInt) {
        IntQueue.Entry localEntry = new IntQueue.Entry(paramInt, null);
        if (this.tail != null) {
            IntQueue.Entry.access$102(this.tail, localEntry);
        }
        this.tail = localEntry;
        if (this.head == null) {
            this.head = localEntry;
        }
    }

    boolean isEmpty() {
        return this.head == null;
    }

    int take() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        int i = IntQueue.Entry.access$200(this.head);
        this.head = IntQueue.Entry.access$100(this.head);
        if (this.head == null) {
            this.tail = null;
        }
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/IntQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */