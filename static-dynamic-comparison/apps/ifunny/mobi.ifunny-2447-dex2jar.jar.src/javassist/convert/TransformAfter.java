package javassist.convert;

import javassist.CtMethod;
import javassist.bytecode.CodeIterator;

public class TransformAfter
        extends TransformBefore {
    public TransformAfter(Transformer paramTransformer, CtMethod paramCtMethod1, CtMethod paramCtMethod2) {
        super(paramTransformer, paramCtMethod1, paramCtMethod2);
    }

    protected int match2(int paramInt, CodeIterator paramCodeIterator) {
        paramCodeIterator.move(paramInt);
        paramCodeIterator.insert(this.saveCode);
        paramCodeIterator.insert(this.loadCode);
        paramCodeIterator.setMark(paramCodeIterator.insertGap(3));
        paramCodeIterator.insert(this.loadCode);
        paramInt = paramCodeIterator.next();
        int i = paramCodeIterator.getMark();
        paramCodeIterator.writeByte(paramCodeIterator.byteAt(paramInt), i);
        paramCodeIterator.write16bit(paramCodeIterator.u16bitAt(paramInt + 1), i + 1);
        paramCodeIterator.writeByte(184, paramInt);
        paramCodeIterator.write16bit(this.newIndex, paramInt + 1);
        paramCodeIterator.move(i);
        return paramCodeIterator.next();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformAfter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */