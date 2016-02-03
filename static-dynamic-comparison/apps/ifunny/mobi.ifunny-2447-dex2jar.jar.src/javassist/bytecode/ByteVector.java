package javassist.bytecode;

class ByteVector
        implements Cloneable {
    private byte[] buffer = new byte[64];
    private int size = 0;

    public void add(int paramInt) {
        addGap(1);
        this.buffer[(this.size - 1)] = ((byte) paramInt);
    }

    public void add(int paramInt1, int paramInt2) {
        addGap(2);
        this.buffer[(this.size - 2)] = ((byte) paramInt1);
        this.buffer[(this.size - 1)] = ((byte) paramInt2);
    }

    public void add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        addGap(4);
        this.buffer[(this.size - 4)] = ((byte) paramInt1);
        this.buffer[(this.size - 3)] = ((byte) paramInt2);
        this.buffer[(this.size - 2)] = ((byte) paramInt3);
        this.buffer[(this.size - 1)] = ((byte) paramInt4);
    }

    public void addGap(int paramInt) {
        if (this.size + paramInt > this.buffer.length) {
            int j = this.size << 1;
            int i = j;
            if (j < this.size + paramInt) {
                i = this.size + paramInt;
            }
            byte[] arrayOfByte = new byte[i];
            System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.size);
            this.buffer = arrayOfByte;
        }
        this.size += paramInt;
    }

    public Object clone() {
        ByteVector localByteVector = (ByteVector) super.clone();
        localByteVector.buffer = ((byte[]) this.buffer.clone());
        return localByteVector;
    }

    public final byte[] copy() {
        byte[] arrayOfByte = new byte[this.size];
        System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.size);
        return arrayOfByte;
    }

    public final int getSize() {
        return this.size;
    }

    public int read(int paramInt) {
        if ((paramInt < 0) || (this.size <= paramInt)) {
            throw new ArrayIndexOutOfBoundsException(paramInt);
        }
        return this.buffer[paramInt];
    }

    public void write(int paramInt1, int paramInt2) {
        if ((paramInt1 < 0) || (this.size <= paramInt1)) {
            throw new ArrayIndexOutOfBoundsException(paramInt1);
        }
        this.buffer[paramInt1] = ((byte) paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ByteVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */