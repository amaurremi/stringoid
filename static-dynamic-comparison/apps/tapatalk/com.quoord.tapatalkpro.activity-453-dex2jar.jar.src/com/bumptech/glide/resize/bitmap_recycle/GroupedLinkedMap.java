package com.bumptech.glide.resize.bitmap_recycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> head = new LinkedEntry();
    private final Map<K, LinkedEntry<K, V>> keyToEntry = new HashMap();

    private void makeHead(LinkedEntry<K, V> paramLinkedEntry) {
        removeEntry(paramLinkedEntry);
        paramLinkedEntry.prev = this.head;
        paramLinkedEntry.next = this.head.next;
        updateEntry(paramLinkedEntry);
    }

    private void makeTail(LinkedEntry<K, V> paramLinkedEntry) {
        removeEntry(paramLinkedEntry);
        paramLinkedEntry.prev = this.head.prev;
        paramLinkedEntry.next = this.head;
        updateEntry(paramLinkedEntry);
    }

    private static void removeEntry(LinkedEntry paramLinkedEntry) {
        paramLinkedEntry.prev.next = paramLinkedEntry.next;
        paramLinkedEntry.next.prev = paramLinkedEntry.prev;
    }

    private static void updateEntry(LinkedEntry paramLinkedEntry) {
        paramLinkedEntry.next.prev = paramLinkedEntry;
        paramLinkedEntry.prev.next = paramLinkedEntry;
    }

    public V get(K paramK) {
        LinkedEntry localLinkedEntry = (LinkedEntry) this.keyToEntry.get(paramK);
        if (localLinkedEntry == null) {
            localLinkedEntry = new LinkedEntry(paramK);
            this.keyToEntry.put(paramK, localLinkedEntry);
        }
        for (paramK = localLinkedEntry; ; paramK = localLinkedEntry) {
            makeHead(paramK);
            return (V) paramK.removeLast();
            paramK.offer();
        }
    }

    public void put(K paramK, V paramV) {
        LinkedEntry localLinkedEntry = (LinkedEntry) this.keyToEntry.get(paramK);
        if (localLinkedEntry == null) {
            localLinkedEntry = new LinkedEntry(paramK);
            makeTail(localLinkedEntry);
            this.keyToEntry.put(paramK, localLinkedEntry);
        }
        for (paramK = localLinkedEntry; ; paramK = localLinkedEntry) {
            paramK.add(paramV);
            return;
            paramK.offer();
        }
    }

    public V removeLast() {
        for (LinkedEntry localLinkedEntry = this.head.prev; ; localLinkedEntry = localLinkedEntry.prev) {
            Object localObject1;
            if (localLinkedEntry == this.head) {
                localObject1 = null;
            }
            Object localObject2;
            do {
                return (V) localObject1;
                localObject2 = localLinkedEntry.removeLast();
                localObject1 = localObject2;
            } while (localObject2 != null);
            removeEntry(localLinkedEntry);
            this.keyToEntry.remove(localLinkedEntry.key);
            ((Poolable) localLinkedEntry.key).offer();
        }
    }

    public String toString() {
        String str = "GroupedLinkedMap( ";
        Object localObject = this.head.next;
        int i = 0;
        for (; ; ) {
            if (localObject == this.head) {
                localObject = str;
                if (i != 0) {
                    localObject = str.substring(0, str.length() - 2);
                }
                return localObject + " )";
            }
            i = 1;
            str = str + "{" + ((LinkedEntry) localObject).key + ":" + ((LinkedEntry) localObject).size() + "}, ";
            localObject = ((LinkedEntry) localObject).next;
        }
    }

    private static class LinkedEntry<K, V> {
        private final K key;
        LinkedEntry<K, V> next = this;
        LinkedEntry<K, V> prev = this;
        private List<V> values;

        public LinkedEntry() {
            this(null);
        }

        public LinkedEntry(K paramK) {
            this.key = paramK;
        }

        public void add(V paramV) {
            if (this.values == null) {
                this.values = new ArrayList();
            }
            this.values.add(paramV);
        }

        public V removeLast() {
            int i = size();
            if (i > 0) {
                return (V) this.values.remove(i - 1);
            }
            return null;
        }

        public int size() {
            if (this.values != null) {
                return this.values.size();
            }
            return 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/bitmap_recycle/GroupedLinkedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */