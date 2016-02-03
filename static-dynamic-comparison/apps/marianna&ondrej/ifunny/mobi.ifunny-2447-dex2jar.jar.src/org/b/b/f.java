package org.b.b;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class f
        extends a {
    LinkedList<ByteBuffer> a = new LinkedList();
    int b = -1;
    private int c;
    private byte[] d = new byte[8];
    private ByteBuffer e = ByteBuffer.wrap(this.d);
    private final int f;

    public f(int paramInt) {
        this.f = paramInt;
    }

    private boolean a(ByteBuffer paramByteBuffer) {
        if (this.a.size() == 1) {
            if (this.b >= 0) {
                paramByteBuffer.position(0);
                paramByteBuffer.limit(0);
                this.b = paramByteBuffer.capacity();
                return false;
            }
            this.a.removeFirst();
            return false;
        }
        this.a.removeFirst();
        return true;
    }

    private void b(int paramInt) {
        Iterator localIterator = this.a.iterator();
        int j = 0;
        int i = paramInt;
        paramInt = j;
        while (localIterator.hasNext()) {
            ByteBuffer localByteBuffer = (ByteBuffer) localIterator.next();
            if (i <= localByteBuffer.remaining()) {
                j = localByteBuffer.position();
                localByteBuffer.get(this.d, paramInt, i);
                localByteBuffer.position(j);
                return;
            }
            j = localByteBuffer.remaining();
            int k = localByteBuffer.position();
            localByteBuffer.get(this.d, paramInt, j);
            localByteBuffer.position(k);
            i -= j;
            paramInt += j;
        }
        throw new d();
    }

    private ByteBuffer c(int paramInt) {
        try {
            ByteBuffer localByteBuffer1 = (ByteBuffer) this.a.getFirst();
            if (localByteBuffer1 == null) {
                throw new d();
            }
        } catch (NoSuchElementException localNoSuchElementException) {
            ByteBuffer localByteBuffer2;
            for (; ; ) {
                localByteBuffer2 = null;
            }
            if (paramInt <= localByteBuffer2.remaining()) {
                this.c = paramInt;
                return localByteBuffer2;
            }
            b(paramInt);
            this.c = paramInt;
        }
        return this.e;
    }

    public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        if (this.a.isEmpty()) {
            return 0;
        }
        int j = paramInt2;
        int i = paramInt1;
        paramInt1 = j;
        ByteBuffer localByteBuffer;
        do {
            localByteBuffer = (ByteBuffer) this.a.getFirst();
            if (paramInt1 < localByteBuffer.remaining()) {
                localByteBuffer.get(paramArrayOfByte, i, paramInt1);
                a(paramInt1);
                return paramInt2;
            }
            int k = localByteBuffer.remaining();
            localByteBuffer.get(paramArrayOfByte, i, k);
            a(k);
            j = paramInt1 - k;
            i += k;
            paramInt1 = j;
        } while (a(localByteBuffer));
        return paramInt2 - j;
    }

    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean) {
        if (paramBoolean) {
            if ((this.b > 0) && (((ByteBuffer) this.a.getLast()).remaining() == 0)) {
                this.a.add(this.a.size() - 1, ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
                return;
            }
            this.a.addLast(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
            this.b = -1;
            return;
        }
        try {
            ByteBuffer localByteBuffer1 = (ByteBuffer) this.a.getLast();
            if (paramInt2 <= this.b) {
                i = localByteBuffer1.position();
                localByteBuffer1.position(localByteBuffer1.limit());
                localByteBuffer1.limit(localByteBuffer1.limit() + paramInt2);
                localByteBuffer1.put(paramArrayOfByte, paramInt1, paramInt2);
                localByteBuffer1.position(i);
                this.b = (localByteBuffer1.capacity() - localByteBuffer1.limit());
                return;
            }
        } catch (NoSuchElementException localNoSuchElementException) {
            for (; ; ) {
                localByteBuffer2 = null;
            }
            int j = paramInt1;
            int i = paramInt2;
            if (this.b > 0) {
                i = localByteBuffer2.position();
                localByteBuffer2.position(localByteBuffer2.limit());
                localByteBuffer2.limit(localByteBuffer2.limit() + this.b);
                localByteBuffer2.put(paramArrayOfByte, paramInt1, this.b);
                localByteBuffer2.position(i);
                j = paramInt1 + this.b;
                i = paramInt2 - this.b;
                this.b = 0;
            }
            paramInt1 = Math.max(i, this.f);
            ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramInt1);
            localByteBuffer2.put(paramArrayOfByte, j, i);
            localByteBuffer2.limit(i);
            localByteBuffer2.position(0);
            this.a.addLast(localByteBuffer2);
            this.b = (paramInt1 - i);
        }
    }

    public boolean a(b paramb, int paramInt) {
        Object localObject = null;
        try {
            ByteBuffer localByteBuffer = (ByteBuffer) this.a.getFirst();
            localObject = localByteBuffer;
        } catch (NoSuchElementException localNoSuchElementException) {
            int i;
            int j;
            for (; ; ) {
            }
        }
        if (localObject == null) {
            throw new d();
        }
        if (((ByteBuffer) localObject).remaining() < paramInt) {
            return false;
        }
        i = ((ByteBuffer) localObject).position();
        j = ((ByteBuffer) localObject).limit();
        try {
            ((ByteBuffer) localObject).limit(i + paramInt);
            paramb.a((ByteBuffer) localObject, true);
            a(paramInt);
            return true;
        } finally {
            ((ByteBuffer) localObject).limit(j);
            ((ByteBuffer) localObject).position(i);
            if (((ByteBuffer) localObject).remaining() == 0) {
                a((ByteBuffer) localObject);
            }
        }
    }

    public byte b() {
        try {
            ByteBuffer localByteBuffer1 = (ByteBuffer) this.a.getFirst();
            if ((localByteBuffer1 == null) || (localByteBuffer1.remaining() == 0)) {
                throw new d();
            }
        } catch (NoSuchElementException localNoSuchElementException) {
            ByteBuffer localByteBuffer2;
            for (; ; ) {
                localByteBuffer2 = null;
            }
            byte b1 = localByteBuffer2.get();
            a();
            if (localByteBuffer2.remaining() == 0) {
                a(localByteBuffer2);
            }
            return b1;
        }
    }

    public void c() {
        if (this.a.isEmpty()) {
            return;
        }
        int i = this.c;
        ByteBuffer localByteBuffer = (ByteBuffer) this.a.getFirst();
        if (i < localByteBuffer.remaining()) {
            localByteBuffer.position(i + localByteBuffer.position());
        }
        for (; ; ) {
            a(this.c);
            this.c = 0;
            return;
            i -= localByteBuffer.remaining();
            localByteBuffer.position(localByteBuffer.position() + localByteBuffer.remaining());
            if (a(localByteBuffer)) {
                break;
            }
        }
    }

    public void close() {
    }

    public byte d() {
        ByteBuffer localByteBuffer = c(1);
        return localByteBuffer.get(localByteBuffer.position());
    }

    public short e() {
        ByteBuffer localByteBuffer = c(2);
        return localByteBuffer.getShort(localByteBuffer.position());
    }

    public int f() {
        ByteBuffer localByteBuffer = c(4);
        return localByteBuffer.getInt(localByteBuffer.position());
    }

    public long g() {
        ByteBuffer localByteBuffer = c(8);
        return localByteBuffer.getLong(localByteBuffer.position());
    }

    public float h() {
        ByteBuffer localByteBuffer = c(4);
        return localByteBuffer.getFloat(localByteBuffer.position());
    }

    public double i() {
        ByteBuffer localByteBuffer = c(8);
        return localByteBuffer.getDouble(localByteBuffer.position());
    }

    public void j() {
        if (this.b >= 0) {
            ByteBuffer localByteBuffer = (ByteBuffer) this.a.getLast();
            this.a.clear();
            localByteBuffer.position(0);
            localByteBuffer.limit(0);
            this.a.addLast(localByteBuffer);
            this.b = localByteBuffer.capacity();
            return;
        }
        this.a.clear();
        this.b = -1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */