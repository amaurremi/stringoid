package javassist.bytecode;

class StackMapTable$Shifter
        extends StackMapTable.Walker {
    private boolean exclusive;
    private int gap;
    private int position;
    private StackMapTable stackMap;
    private byte[] updatedInfo;
    private int where;

    public StackMapTable$Shifter(StackMapTable paramStackMapTable, int paramInt1, int paramInt2, boolean paramBoolean) {
        super(paramStackMapTable);
        this.stackMap = paramStackMapTable;
        this.where = paramInt1;
        this.gap = paramInt2;
        this.position = 0;
        this.updatedInfo = null;
        this.exclusive = paramBoolean;
    }

    private static byte[] insertGap(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        int k = paramArrayOfByte.length;
        byte[] arrayOfByte = new byte[k + paramInt2];
        int i = 0;
        if (i < k) {
            if (i < paramInt1) {
            }
            for (int j = 0; ; j = paramInt2) {
                arrayOfByte[(j + i)] = paramArrayOfByte[i];
                i += 1;
                break;
            }
        }
        return arrayOfByte;
    }

    private void update(int paramInt1, int paramInt2) {
        int j = 1;
        int k = this.position;
        int i;
        if (k == 0) {
            i = 0;
            this.position = (i + (k + paramInt2));
            if (!this.exclusive) {
                break label100;
            }
            if ((k >= this.where) || (this.where > this.position)) {
                break label95;
            }
            i = j;
        }
        for (; ; ) {
            if (i != 0) {
                ByteArray.write16bit(this.gap + paramInt2, this.info, paramInt1 + 1);
                this.position += this.gap;
            }
            return;
            i = 1;
            break;
            label95:
            i = 0;
            continue;
            label100:
            if (k <= this.where) {
                i = j;
                if (this.where < this.position) {
                }
            } else {
                i = 0;
            }
        }
    }

    private void update(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int j = 1;
        int k = this.position;
        int i;
        if (k == 0) {
            i = 0;
            this.position = (i + (k + paramInt2));
            if (!this.exclusive) {
                break label116;
            }
            if ((k >= this.where) || (this.where > this.position)) {
                break label110;
            }
            i = j;
        }
        for (; ; ) {
            if (i != 0) {
                i = this.gap + paramInt2;
                this.position += this.gap;
                if (i >= 64) {
                    break label146;
                }
                this.info[paramInt1] = ((byte) (i + paramInt3));
            }
            return;
            i = 1;
            break;
            label110:
            i = 0;
            continue;
            label116:
            if (k <= this.where) {
                i = j;
                if (this.where < this.position) {
                }
            } else {
                i = 0;
            }
        }
        label146:
        if (paramInt2 < 64) {
            byte[] arrayOfByte = insertGap(this.info, paramInt1, 2);
            arrayOfByte[paramInt1] = ((byte) paramInt4);
            ByteArray.write16bit(i, arrayOfByte, paramInt1 + 1);
            this.updatedInfo = arrayOfByte;
            return;
        }
        ByteArray.write16bit(i, this.info, paramInt1 + 1);
    }

    public void appendFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        update(paramInt1, paramInt2);
    }

    public void chopFrame(int paramInt1, int paramInt2, int paramInt3) {
        update(paramInt1, paramInt2);
    }

    public void doit() {
        parse();
        if (this.updatedInfo != null) {
            this.stackMap.set(this.updatedInfo);
        }
    }

    public void fullFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4) {
        update(paramInt1, paramInt2);
    }

    public void sameFrame(int paramInt1, int paramInt2) {
        update(paramInt1, paramInt2, 0, 251);
    }

    public void sameLocals(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        update(paramInt1, paramInt2, 64, 247);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable$Shifter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */