package javassist;

import java.util.Comparator;

import javassist.bytecode.MethodInfo;

final class SerialVersionUID$3
        implements Comparator {
    public int compare(Object paramObject1, Object paramObject2) {
        paramObject1 = (CtMethod) paramObject1;
        paramObject2 = (CtMethod) paramObject2;
        int j = ((CtMethod) paramObject1).getName().compareTo(((CtMethod) paramObject2).getName());
        int i = j;
        if (j == 0) {
            i = ((CtMethod) paramObject1).getMethodInfo2().getDescriptor().compareTo(((CtMethod) paramObject2).getMethodInfo2().getDescriptor());
        }
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/SerialVersionUID$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */