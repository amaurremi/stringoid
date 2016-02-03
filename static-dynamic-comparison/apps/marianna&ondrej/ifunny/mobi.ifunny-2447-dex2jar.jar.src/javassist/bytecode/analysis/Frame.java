package javassist.bytecode.analysis;

public class Frame {
    private boolean jsrMerged;
    private Type[] locals;
    private boolean retMerged;
    private Type[] stack;
    private int top;

    public Frame(int paramInt1, int paramInt2) {
        this.locals = new Type[paramInt1];
        this.stack = new Type[paramInt2];
    }

    public void clearStack() {
        this.top = 0;
    }

    public Frame copy() {
        Frame localFrame = new Frame(this.locals.length, this.stack.length);
        System.arraycopy(this.locals, 0, localFrame.locals, 0, this.locals.length);
        System.arraycopy(this.stack, 0, localFrame.stack, 0, this.stack.length);
        localFrame.top = this.top;
        return localFrame;
    }

    public Frame copyStack() {
        Frame localFrame = new Frame(this.locals.length, this.stack.length);
        System.arraycopy(this.stack, 0, localFrame.stack, 0, this.stack.length);
        localFrame.top = this.top;
        return localFrame;
    }

    public Type getLocal(int paramInt) {
        return this.locals[paramInt];
    }

    public Type getStack(int paramInt) {
        return this.stack[paramInt];
    }

    public int getTopIndex() {
        return this.top - 1;
    }

    boolean isJsrMerged() {
        return this.jsrMerged;
    }

    boolean isRetMerged() {
        return this.retMerged;
    }

    public int localsLength() {
        return this.locals.length;
    }

    public boolean merge(Frame paramFrame) {
        int j = 0;
        int i = 0;
        if (j < this.locals.length) {
            if (this.locals[j] != null) {
                Type localType1 = this.locals[j];
                Type localType2 = localType1.merge(paramFrame.locals[j]);
                this.locals[j] = localType2;
                if ((!localType2.equals(localType1)) || (localType2.popChanged())) {
                    i = 1;
                }
            }
            for (; ; ) {
                j += 1;
                break;
                if (paramFrame.locals[j] != null) {
                    this.locals[j] = paramFrame.locals[j];
                    i = 1;
                }
            }
        }
        return mergeStack(paramFrame) | i;
    }

    public boolean mergeStack(Frame paramFrame) {
        int i = 0;
        if (this.top != paramFrame.top) {
            throw new RuntimeException("Operand stacks could not be merged, they are different sizes!");
        }
        boolean bool2;
        for (boolean bool1 = false; i < this.top; bool1 = bool2) {
            bool2 = bool1;
            if (this.stack[i] != null) {
                Type localType1 = this.stack[i];
                Type localType2 = localType1.merge(paramFrame.stack[i]);
                if (localType2 == Type.BOGUS) {
                    throw new RuntimeException("Operand stacks could not be merged due to differing primitive types: pos = " + i);
                }
                this.stack[i] = localType2;
                if (localType2.equals(localType1)) {
                    bool2 = bool1;
                    if (!localType2.popChanged()) {
                    }
                } else {
                    bool2 = true;
                }
            }
            i += 1;
        }
        return bool1;
    }

    public Type peek() {
        if (this.top < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return this.stack[(this.top - 1)];
    }

    public Type pop() {
        if (this.top < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        Type[] arrayOfType = this.stack;
        int i = this.top - 1;
        this.top = i;
        return arrayOfType[i];
    }

    public void push(Type paramType) {
        Type[] arrayOfType = this.stack;
        int i = this.top;
        this.top = (i + 1);
        arrayOfType[i] = paramType;
    }

    void setJsrMerged(boolean paramBoolean) {
        this.jsrMerged = paramBoolean;
    }

    public void setLocal(int paramInt, Type paramType) {
        this.locals[paramInt] = paramType;
    }

    void setRetMerged(boolean paramBoolean) {
        this.retMerged = paramBoolean;
    }

    public void setStack(int paramInt, Type paramType) {
        this.stack[paramInt] = paramType;
    }

    public String toString() {
        int j = 0;
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("locals = [");
        int i = 0;
        if (i < this.locals.length) {
            if (this.locals[i] == null) {
            }
            for (String str = "empty"; ; str = this.locals[i].toString()) {
                localStringBuffer.append(str);
                if (i < this.locals.length - 1) {
                    localStringBuffer.append(", ");
                }
                i += 1;
                break;
            }
        }
        localStringBuffer.append("] stack = [");
        i = j;
        while (i < this.top) {
            localStringBuffer.append(this.stack[i]);
            if (i < this.top - 1) {
                localStringBuffer.append(", ");
            }
            i += 1;
        }
        localStringBuffer.append("]");
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */