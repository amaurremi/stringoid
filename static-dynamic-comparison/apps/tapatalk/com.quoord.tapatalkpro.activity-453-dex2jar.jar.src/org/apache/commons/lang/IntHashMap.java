package org.apache.commons.lang;

class IntHashMap {
    private transient int count;
    private final float loadFactor;
    private transient Entry[] table;
    private int threshold;

    public IntHashMap() {
        this(20, 0.75F);
    }

    public IntHashMap(int paramInt) {
        this(paramInt, 0.75F);
    }

    public IntHashMap(int paramInt, float paramFloat) {
        if (paramInt < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + paramInt);
        }
        if (paramFloat <= 0.0F) {
            throw new IllegalArgumentException("Illegal Load: " + paramFloat);
        }
        int i = paramInt;
        if (paramInt == 0) {
            i = 1;
        }
        this.loadFactor = paramFloat;
        this.table = new Entry[i];
        this.threshold = ((int) (i * paramFloat));
    }

    public void clear() {
        try {
            Entry[] arrayOfEntry = this.table;
            int i = arrayOfEntry.length;
            for (; ; ) {
                i -= 1;
                if (i < 0) {
                    break;
                }
                arrayOfEntry[i] = null;
            }
            this.count = 0;
        } finally {
        }
    }

    public boolean contains(Object paramObject) {
        if (paramObject == null) {
            throw new NullPointerException();
        }
        Entry[] arrayOfEntry = this.table;
        int j;
        for (int i = arrayOfEntry.length; ; i = j) {
            j = i - 1;
            if (i <= 0) {
                break;
            }
            for (Entry localEntry = arrayOfEntry[j]; localEntry != null; localEntry = localEntry.next) {
                if (localEntry.value.equals(paramObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsKey(int paramInt) {
        Object localObject = this.table;
        for (localObject = localObject[((0x7FFFFFFF & paramInt) % localObject.length)]; localObject != null; localObject = ((Entry) localObject).next) {
            if (((Entry) localObject).hash == paramInt) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object paramObject) {
        return contains(paramObject);
    }

    public Object get(int paramInt) {
        Object localObject = this.table;
        for (localObject = localObject[((0x7FFFFFFF & paramInt) % localObject.length)]; localObject != null; localObject = ((Entry) localObject).next) {
            if (((Entry) localObject).hash == paramInt) {
                return ((Entry) localObject).value;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public Object put(int paramInt, Object paramObject) {
        Object localObject2 = this.table;
        int i = (paramInt & 0x7FFFFFFF) % localObject2.length;
        for (Object localObject1 = localObject2[i]; localObject1 != null; localObject1 = ((Entry) localObject1).next) {
            if (((Entry) localObject1).hash == paramInt) {
                localObject2 = ((Entry) localObject1).value;
                ((Entry) localObject1).value = paramObject;
                return localObject2;
            }
        }
        localObject1 = localObject2;
        if (this.count >= this.threshold) {
            rehash();
            localObject1 = this.table;
            i = (paramInt & 0x7FFFFFFF) % localObject1.length;
        }
        localObject1[i] = new Entry(paramInt, paramInt, paramObject, localObject1[i]);
        this.count += 1;
        return null;
    }

    protected void rehash() {
        int i = this.table.length;
        Entry[] arrayOfEntry1 = this.table;
        int k = i * 2 + 1;
        Entry[] arrayOfEntry2 = new Entry[k];
        this.threshold = ((int) (k * this.loadFactor));
        this.table = arrayOfEntry2;
        for (; ; ) {
            int j = i - 1;
            if (i <= 0) {
                break;
            }
            Entry localEntry;
            for (Object localObject = arrayOfEntry1[j]; localObject != null; localObject = localEntry) {
                localEntry = ((Entry) localObject).next;
                i = (((Entry) localObject).hash & 0x7FFFFFFF) % k;
                ((Entry) localObject).next = arrayOfEntry2[i];
                arrayOfEntry2[i] = localObject;
            }
            i = j;
        }
    }

    public Object remove(int paramInt) {
        Entry[] arrayOfEntry = this.table;
        int i = (0x7FFFFFFF & paramInt) % arrayOfEntry.length;
        Entry localEntry = arrayOfEntry[i];
        Object localObject = null;
        while (localEntry != null) {
            if (localEntry.hash == paramInt) {
                if (localObject != null) {
                    ((Entry) localObject).next = localEntry.next;
                }
                for (; ; ) {
                    this.count -= 1;
                    localObject = localEntry.value;
                    localEntry.value = null;
                    return localObject;
                    arrayOfEntry[i] = localEntry.next;
                }
            }
            localObject = localEntry;
            localEntry = localEntry.next;
        }
        return null;
    }

    public int size() {
        return this.count;
    }

    private static class Entry {
        final int hash;
        final int key;
        Entry next;
        Object value;

        protected Entry(int paramInt1, int paramInt2, Object paramObject, Entry paramEntry) {
            this.hash = paramInt1;
            this.key = paramInt2;
            this.value = paramObject;
            this.next = paramEntry;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/IntHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */