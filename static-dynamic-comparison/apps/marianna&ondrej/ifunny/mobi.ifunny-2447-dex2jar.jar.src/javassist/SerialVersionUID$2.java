package javassist;

import java.util.Comparator;

import javassist.bytecode.MethodInfo;

final class SerialVersionUID$2
        implements Comparator {
    public int compare(Object paramObject1, Object paramObject2) {
        paramObject1 = (CtConstructor) paramObject1;
        paramObject2 = (CtConstructor) paramObject2;
        return ((CtConstructor) paramObject1).getMethodInfo2().getDescriptor().compareTo(((CtConstructor) paramObject2).getMethodInfo2().getDescriptor());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/SerialVersionUID$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */