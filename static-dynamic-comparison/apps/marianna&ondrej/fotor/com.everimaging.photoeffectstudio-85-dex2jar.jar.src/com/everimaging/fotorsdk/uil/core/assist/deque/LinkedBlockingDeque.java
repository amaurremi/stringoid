package com.everimaging.fotorsdk.uil.core.assist.deque;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E>
        extends AbstractQueue<E>
        implements a<E>, Serializable {
    private final int capacity;
    private transient int count;
    transient c<E> first;
    transient c<E> last;
    final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = this.lock.newCondition();
    private final Condition notFull = this.lock.newCondition();

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int paramInt) {
        if (paramInt <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = paramInt;
    }

    private boolean linkFirst(c<E> paramc) {
        if (this.count >= this.capacity) {
            return false;
        }
        c localc = this.first;
        paramc.c = localc;
        this.first = paramc;
        if (this.last == null) {
            this.last = paramc;
        }
        for (; ; ) {
            this.count += 1;
            this.notEmpty.signal();
            return true;
            localc.b = paramc;
        }
    }

    private boolean linkLast(c<E> paramc) {
        if (this.count >= this.capacity) {
            return false;
        }
        c localc = this.last;
        paramc.b = localc;
        this.last = paramc;
        if (this.first == null) {
            this.first = paramc;
        }
        for (; ; ) {
            this.count += 1;
            this.notEmpty.signal();
            return true;
            localc.c = paramc;
        }
    }

    private E unlinkFirst() {
        c localc1 = this.first;
        if (localc1 == null) {
            return null;
        }
        c localc2 = localc1.c;
        Object localObject = localc1.a;
        localc1.a = null;
        localc1.c = localc1;
        this.first = localc2;
        if (localc2 == null) {
            this.last = null;
        }
        for (; ; ) {
            this.count -= 1;
            this.notFull.signal();
            return (E) localObject;
            localc2.b = null;
        }
    }

    private E unlinkLast() {
        c localc1 = this.last;
        if (localc1 == null) {
            return null;
        }
        c localc2 = localc1.b;
        Object localObject = localc1.a;
        localc1.a = null;
        localc1.b = localc1;
        this.last = localc2;
        if (localc2 == null) {
            this.first = null;
        }
        for (; ; ) {
            this.count -= 1;
            this.notFull.signal();
            return (E) localObject;
            localc2.c = null;
        }
    }

    public boolean add(E paramE) {
        addLast(paramE);
        return true;
    }

    public void addLast(E paramE) {
        if (!offerLast(paramE)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void clear() {
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            c localc;
            for (Object localObject1 = this.first; localObject1 != null; localObject1 = localc) {
                ((c) localObject1).a = null;
                localc = ((c) localObject1).c;
                ((c) localObject1).b = null;
                ((c) localObject1).c = null;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
            return;
        } finally {
            localReentrantLock.unlock();
        }
    }

    public boolean contains(Object paramObject) {
        if (paramObject == null) {
            return false;
        }
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            for (c localc = this.first; localc != null; localc = localc.c) {
                boolean bool = paramObject.equals(localc.a);
                if (bool) {
                    return true;
                }
            }
            return false;
        } finally {
            localReentrantLock.unlock();
        }
    }

    public int drainTo(Collection<? super E> paramCollection) {
        return drainTo(paramCollection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> paramCollection, int paramInt) {
        if (paramCollection == null) {
            throw new NullPointerException();
        }
        if (paramCollection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            int i = Math.min(paramInt, this.count);
            paramInt = 0;
            while (paramInt < i) {
                paramCollection.add(this.first.a);
                unlinkFirst();
                paramInt += 1;
            }
            return i;
        } finally {
            localReentrantLock.unlock();
        }
    }

    public E element() {
        return (E) getFirst();
    }

    public E getFirst() {
        Object localObject = peekFirst();
        if (localObject == null) {
            throw new NoSuchElementException();
        }
        return (E) localObject;
    }

    public Iterator<E> iterator() {
        return new b(null);
    }

    public boolean offer(E paramE) {
        return offerLast(paramE);
    }

    public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
            throws InterruptedException {
        return offerLast(paramE, paramLong, paramTimeUnit);
    }

    public boolean offerFirst(E paramE) {
        if (paramE == null) {
            throw new NullPointerException();
        }
        c localc = new c(paramE);
        paramE = this.lock;
        paramE.lock();
        try {
            boolean bool = linkFirst(localc);
            return bool;
        } finally {
            paramE.unlock();
        }
    }

    public boolean offerLast(E paramE) {
        if (paramE == null) {
            throw new NullPointerException();
        }
        c localc = new c(paramE);
        paramE = this.lock;
        paramE.lock();
        try {
            boolean bool = linkLast(localc);
            return bool;
        } finally {
            paramE.unlock();
        }
    }

    public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
            throws InterruptedException {
        if (paramE == null) {
            throw new NullPointerException();
        }
        paramE = new c(paramE);
        paramLong = paramTimeUnit.toNanos(paramLong);
        paramTimeUnit = this.lock;
        paramTimeUnit.lockInterruptibly();
        try {
            for (; ; ) {
                boolean bool = linkLast(paramE);
                if (bool) {
                    break;
                }
                if (paramLong <= 0L) {
                    return false;
                }
                paramLong = this.notFull.awaitNanos(paramLong);
            }
            return true;
        } finally {
            paramTimeUnit.unlock();
        }
    }

    public E peek() {
        return (E) peekFirst();
    }

    /* Error */
    public E peekFirst() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 46	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
        //   4: astore_2
        //   5: aload_2
        //   6: invokevirtual 107	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   9: aload_0
        //   10: getfield 65	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:first	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
        //   13: astore_1
        //   14: aload_1
        //   15: ifnonnull +11 -> 26
        //   18: aconst_null
        //   19: astore_1
        //   20: aload_2
        //   21: invokevirtual 113	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   24: aload_1
        //   25: areturn
        //   26: aload_0
        //   27: getfield 65	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:first	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
        //   30: getfield 84	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c:a	Ljava/lang/Object;
        //   33: astore_1
        //   34: goto -14 -> 20
        //   37: astore_1
        //   38: aload_2
        //   39: invokevirtual 113	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   42: aload_1
        //   43: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	44	0	this	LinkedBlockingDeque
        //   13	21	1	localObject1	Object
        //   37	6	1	localObject2	Object
        //   4	35	2	localReentrantLock	ReentrantLock
        // Exception table:
        //   from	to	target	type
        //   9	14	37	finally
        //   26	34	37	finally
    }

    public E poll() {
        return (E) pollFirst();
    }

    public E poll(long paramLong, TimeUnit paramTimeUnit)
            throws InterruptedException {
        return (E) pollFirst(paramLong, paramTimeUnit);
    }

    public E pollFirst() {
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            Object localObject1 = unlinkFirst();
            return (E) localObject1;
        } finally {
            localReentrantLock.unlock();
        }
    }

    public E pollFirst(long paramLong, TimeUnit paramTimeUnit)
            throws InterruptedException {
        paramLong = paramTimeUnit.toNanos(paramLong);
        paramTimeUnit = this.lock;
        paramTimeUnit.lockInterruptibly();
        try {
            Object localObject1;
            for (; ; ) {
                localObject1 = unlinkFirst();
                if (localObject1 != null) {
                    break;
                }
                if (paramLong <= 0L) {
                    return null;
                }
                paramLong = this.notEmpty.awaitNanos(paramLong);
            }
            return (E) localObject1;
        } finally {
            paramTimeUnit.unlock();
        }
    }

    public void put(E paramE)
            throws InterruptedException {
        putLast(paramE);
    }

    /* Error */
    public void putLast(E paramE)
            throws InterruptedException {
        // Byte code:
        //   0: aload_1
        //   1: ifnonnull +11 -> 12
        //   4: new 127	java/lang/NullPointerException
        //   7: dup
        //   8: invokespecial 128	java/lang/NullPointerException:<init>	()V
        //   11: athrow
        //   12: new 19	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c
        //   15: dup
        //   16: aload_1
        //   17: invokespecial 168	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c:<init>	(Ljava/lang/Object;)V
        //   20: astore_2
        //   21: aload_0
        //   22: getfield 46	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
        //   25: astore_1
        //   26: aload_1
        //   27: invokevirtual 107	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   30: aload_0
        //   31: aload_2
        //   32: invokespecial 172	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:linkLast	(Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;)Z
        //   35: ifne +22 -> 57
        //   38: aload_0
        //   39: getfield 54	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:notFull	Ljava/util/concurrent/locks/Condition;
        //   42: invokeinterface 200 1 0
        //   47: goto -17 -> 30
        //   50: astore_2
        //   51: aload_1
        //   52: invokevirtual 113	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   55: aload_2
        //   56: athrow
        //   57: aload_1
        //   58: invokevirtual 113	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   61: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	62	0	this	LinkedBlockingDeque
        //   0	62	1	paramE	E
        //   20	12	2	localc	c
        //   50	6	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   30	47	50	finally
    }

    public int remainingCapacity() {
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            int i = this.capacity;
            int j = this.count;
            return i - j;
        } finally {
            localReentrantLock.unlock();
        }
    }

    public E remove() {
        return (E) removeFirst();
    }

    public boolean remove(Object paramObject) {
        return removeFirstOccurrence(paramObject);
    }

    public E removeFirst() {
        Object localObject = pollFirst();
        if (localObject == null) {
            throw new NoSuchElementException();
        }
        return (E) localObject;
    }

    public boolean removeFirstOccurrence(Object paramObject) {
        if (paramObject == null) {
            return false;
        }
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            for (c localc = this.first; localc != null; localc = localc.c) {
                if (paramObject.equals(localc.a)) {
                    unlink(localc);
                    return true;
                }
            }
            return false;
        } finally {
            localReentrantLock.unlock();
        }
    }

    public int size() {
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            int i = this.count;
            return i;
        } finally {
            localReentrantLock.unlock();
        }
    }

    public E take()
            throws InterruptedException {
        return (E) takeFirst();
    }

    public E takeFirst()
            throws InterruptedException {
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            for (; ; ) {
                Object localObject = unlinkFirst();
                if (localObject != null) {
                    break;
                }
                this.notEmpty.await();
            }
        } finally {
            localReentrantLock.unlock();
        }
        return?;
    }

    public Object[] toArray() {
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        try {
            Object[] arrayOfObject = new Object[this.count];
            int i = 0;
            c localc = this.first;
            while (localc != null) {
                arrayOfObject[i] = localc.a;
                localc = localc.c;
                i += 1;
            }
            return arrayOfObject;
        } finally {
            localReentrantLock.unlock();
        }
    }

    public <T> T[] toArray(T[] paramArrayOfT) {
        ReentrantLock localReentrantLock = this.lock;
        localReentrantLock.lock();
        Object localObject = paramArrayOfT;
        try {
            if (paramArrayOfT.length < this.count) {
                localObject = (Object[]) Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.count);
            }
            int i = 0;
            paramArrayOfT = this.first;
            while (paramArrayOfT != null) {
                localObject[i] = paramArrayOfT.a;
                paramArrayOfT = paramArrayOfT.c;
                i += 1;
            }
            if (localObject.length > i) {
                localObject[i] = null;
            }
            return (T[]) localObject;
        } finally {
            localReentrantLock.unlock();
        }
    }

    /* Error */
    public String toString() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 46	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
        //   4: astore 4
        //   6: aload 4
        //   8: invokevirtual 107	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   11: aload_0
        //   12: getfield 65	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:first	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
        //   15: astore_1
        //   16: aload_1
        //   17: ifnonnull +11 -> 28
        //   20: aload 4
        //   22: invokevirtual 113	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   25: ldc -13
        //   27: areturn
        //   28: new 245	java/lang/StringBuilder
        //   31: dup
        //   32: invokespecial 246	java/lang/StringBuilder:<init>	()V
        //   35: astore 5
        //   37: aload 5
        //   39: bipush 91
        //   41: invokevirtual 250	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   44: pop
        //   45: aload_1
        //   46: getfield 84	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c:a	Ljava/lang/Object;
        //   49: astore_3
        //   50: aload_3
        //   51: astore_2
        //   52: aload_3
        //   53: aload_0
        //   54: if_acmpne +6 -> 60
        //   57: ldc -4
        //   59: astore_2
        //   60: aload 5
        //   62: aload_2
        //   63: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   66: pop
        //   67: aload_1
        //   68: getfield 67	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c:c	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
        //   71: astore_1
        //   72: aload_1
        //   73: ifnonnull +21 -> 94
        //   76: aload 5
        //   78: bipush 93
        //   80: invokevirtual 250	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   83: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   86: astore_1
        //   87: aload 4
        //   89: invokevirtual 113	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   92: aload_1
        //   93: areturn
        //   94: aload 5
        //   96: bipush 44
        //   98: invokevirtual 250	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   101: bipush 32
        //   103: invokevirtual 250	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   106: pop
        //   107: goto -62 -> 45
        //   110: astore_1
        //   111: aload 4
        //   113: invokevirtual 113	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   116: aload_1
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	LinkedBlockingDeque
        //   15	78	1	localObject1	Object
        //   110	7	1	localObject2	Object
        //   51	12	2	localObject3	Object
        //   49	4	3	localObject4	Object
        //   4	108	4	localReentrantLock	ReentrantLock
        //   35	60	5	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   11	16	110	finally
        //   28	45	110	finally
        //   45	50	110	finally
        //   60	72	110	finally
        //   76	87	110	finally
        //   94	107	110	finally
    }

    void unlink(c<E> paramc) {
        c localc1 = paramc.b;
        c localc2 = paramc.c;
        if (localc1 == null) {
            unlinkFirst();
            return;
        }
        if (localc2 == null) {
            unlinkLast();
            return;
        }
        localc1.c = localc2;
        localc2.b = localc1;
        paramc.a = null;
        this.count -= 1;
        this.notFull.signal();
    }

    private abstract class a
            implements Iterator<E> {
        LinkedBlockingDeque.c<E> a;
        E b;
        private LinkedBlockingDeque.c<E> d;

        /* Error */
        a() {
            // Byte code:
            //   0: aload_0
            //   1: aload_1
            //   2: putfield 22	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:c	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque;
            //   5: aload_0
            //   6: invokespecial 25	java/lang/Object:<init>	()V
            //   9: aload_1
            //   10: getfield 29	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   13: astore_2
            //   14: aload_2
            //   15: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
            //   18: aload_0
            //   19: aload_0
            //   20: invokevirtual 36	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:a	()Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   23: putfield 38	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:a	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   26: aload_0
            //   27: getfield 38	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:a	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   30: ifnonnull +15 -> 45
            //   33: aconst_null
            //   34: astore_1
            //   35: aload_0
            //   36: aload_1
            //   37: putfield 40	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:b	Ljava/lang/Object;
            //   40: aload_2
            //   41: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   44: return
            //   45: aload_0
            //   46: getfield 38	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:a	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   49: getfield 47	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c:a	Ljava/lang/Object;
            //   52: astore_1
            //   53: goto -18 -> 35
            //   56: astore_1
            //   57: aload_2
            //   58: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   61: aload_1
            //   62: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	63	0	this	a
            //   0	63	1	this$1	LinkedBlockingDeque
            //   13	45	2	localReentrantLock	ReentrantLock
            // Exception table:
            //   from	to	target	type
            //   18	33	56	finally
            //   35	40	56	finally
            //   45	53	56	finally
        }

        private LinkedBlockingDeque.c<E> b(LinkedBlockingDeque.c<E> paramc) {
            for (; ; ) {
                LinkedBlockingDeque.c localc = a(paramc);
                Object localObject;
                if (localc == null) {
                    localObject = null;
                }
                do {
                    return (LinkedBlockingDeque.c<E>) localObject;
                    localObject = localc;
                } while (localc.a != null);
                if (localc == paramc) {
                    return a();
                }
                paramc = localc;
            }
        }

        abstract LinkedBlockingDeque.c<E> a();

        abstract LinkedBlockingDeque.c<E> a(LinkedBlockingDeque.c<E> paramc);

        /* Error */
        void b() {
            // Byte code:
            //   0: aload_0
            //   1: getfield 22	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:c	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque;
            //   4: getfield 29	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
            //   7: astore_2
            //   8: aload_2
            //   9: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
            //   12: aload_0
            //   13: aload_0
            //   14: aload_0
            //   15: getfield 38	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:a	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   18: invokespecial 55	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:b	(Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;)Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   21: putfield 38	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:a	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   24: aload_0
            //   25: getfield 38	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:a	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   28: ifnonnull +15 -> 43
            //   31: aconst_null
            //   32: astore_1
            //   33: aload_0
            //   34: aload_1
            //   35: putfield 40	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:b	Ljava/lang/Object;
            //   38: aload_2
            //   39: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   42: return
            //   43: aload_0
            //   44: getfield 38	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$a:a	Lcom/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c;
            //   47: getfield 47	com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque$c:a	Ljava/lang/Object;
            //   50: astore_1
            //   51: goto -18 -> 33
            //   54: astore_1
            //   55: aload_2
            //   56: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
            //   59: aload_1
            //   60: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	61	0	this	a
            //   32	19	1	localObject1	Object
            //   54	6	1	localObject2	Object
            //   7	49	2	localReentrantLock	ReentrantLock
            // Exception table:
            //   from	to	target	type
            //   12	31	54	finally
            //   33	38	54	finally
            //   43	51	54	finally
        }

        public boolean hasNext() {
            return this.a != null;
        }

        public E next() {
            if (this.a == null) {
                throw new NoSuchElementException();
            }
            this.d = this.a;
            Object localObject = this.b;
            b();
            return (E) localObject;
        }

        public void remove() {
            LinkedBlockingDeque.c localc = this.d;
            if (localc == null) {
                throw new IllegalStateException();
            }
            this.d = null;
            ReentrantLock localReentrantLock = LinkedBlockingDeque.this.lock;
            localReentrantLock.lock();
            try {
                if (localc.a != null) {
                    LinkedBlockingDeque.this.unlink(localc);
                }
                return;
            } finally {
                localReentrantLock.unlock();
            }
        }
    }

    private class b
            extends LinkedBlockingDeque.a {
        private b() {
            super();
        }

        LinkedBlockingDeque.c<E> a() {
            return LinkedBlockingDeque.this.first;
        }

        LinkedBlockingDeque.c<E> a(LinkedBlockingDeque.c<E> paramc) {
            return paramc.c;
        }
    }

    static final class c<E> {
        E a;
        c<E> b;
        c<E> c;

        c(E paramE) {
            this.a = paramE;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/assist/deque/LinkedBlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */