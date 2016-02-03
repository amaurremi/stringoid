package javassist;

import java.util.Comparator;

final class SerialVersionUID$1
        implements Comparator {
    public int compare(Object paramObject1, Object paramObject2) {
        paramObject1 = (CtField) paramObject1;
        paramObject2 = (CtField) paramObject2;
        return ((CtField) paramObject1).getName().compareTo(((CtField) paramObject2).getName());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/SerialVersionUID$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */