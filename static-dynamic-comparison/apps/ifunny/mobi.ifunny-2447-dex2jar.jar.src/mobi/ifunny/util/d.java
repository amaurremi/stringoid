package mobi.ifunny.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class d<E>
        extends LinkedList<E> {
    private static final long serialVersionUID = 6862741210680879258L;
    private int a;

    public d(int paramInt) {
        this.a = paramInt;
    }

    public int a() {
        return this.a;
    }

    public void a(E paramE) {
        add(paramE);
    }

    public boolean add(E paramE) {
        if (b()) {
            removeRange(0, size() - this.a + 1);
        }
        return super.add(paramE);
    }

    public boolean addAll(Collection<? extends E> paramCollection) {
        int i = 0;
        if (paramCollection.isEmpty()) {
            return false;
        }
        if (this.a != -1) {
            if ((this.a >= 0) && (paramCollection.size() > this.a)) {
                Iterator localIterator = paramCollection.iterator();
                clear();
                int j = paramCollection.size();
                int k = this.a;
                while (localIterator.hasNext()) {
                    paramCollection = localIterator.next();
                    if (i >= j - k) {
                        add(paramCollection);
                    }
                    i += 1;
                }
                return true;
            }
            i = size() + paramCollection.size();
            if (i > this.a) {
                removeRange(0, i - this.a + 1);
            }
        }
        return super.addAll(paramCollection);
    }

    public boolean b() {
        if (this.a == -1) {
        }
        while ((this.a < 0) || (size() < this.a)) {
            return false;
        }
        return true;
    }

    public E c() {
        return (E) remove(size() - 1);
    }

    public E d() {
        return (E) get(size() - 1);
    }

    public boolean offer(E paramE) {
        return add(paramE);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */