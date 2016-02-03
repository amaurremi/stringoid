package javassist.bytecode.analysis;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javassist.CtClass;

public class MultiType
        extends Type {
    private boolean changed = false;
    private Map interfaces;
    private MultiType mergeSource;
    private Type potentialClass;
    private Type resolved;

    public MultiType(Map paramMap) {
        this(paramMap, null);
    }

    public MultiType(Map paramMap, Type paramType) {
        super(null);
        this.interfaces = paramMap;
        this.potentialClass = paramType;
    }

    private Map getAllMultiInterfaces(MultiType paramMultiType) {
        HashMap localHashMap = new HashMap();
        paramMultiType = paramMultiType.interfaces.values().iterator();
        while (paramMultiType.hasNext()) {
            CtClass localCtClass = (CtClass) paramMultiType.next();
            localHashMap.put(localCtClass.getName(), localCtClass);
            getAllInterfaces(localCtClass, localHashMap);
        }
        return localHashMap;
    }

    private boolean inMergeSource(MultiType paramMultiType) {
        while (paramMultiType != null) {
            if (paramMultiType == this) {
                return true;
            }
            paramMultiType = paramMultiType.mergeSource;
        }
        return false;
    }

    private Map mergeMultiAndSingle(MultiType paramMultiType, Type paramType) {
        return findCommonInterfaces(getAllMultiInterfaces(paramMultiType), getAllInterfaces(paramType.getCtClass(), null));
    }

    private Map mergeMultiInterfaces(MultiType paramMultiType1, MultiType paramMultiType2) {
        return findCommonInterfaces(getAllMultiInterfaces(paramMultiType1), getAllMultiInterfaces(paramMultiType2));
    }

    private void propogateResolved() {
        for (MultiType localMultiType = this.mergeSource; localMultiType != null; localMultiType = localMultiType.mergeSource) {
            localMultiType.resolved = this.resolved;
        }
    }

    private void propogateState() {
        for (MultiType localMultiType = this.mergeSource; localMultiType != null; localMultiType = localMultiType.mergeSource) {
            localMultiType.interfaces = this.interfaces;
            localMultiType.potentialClass = this.potentialClass;
        }
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof MultiType)) {
        }
        do {
            return false;
            paramObject = (MultiType) paramObject;
            if (this.resolved != null) {
                return this.resolved.equals(((MultiType) paramObject).resolved);
            }
        } while (((MultiType) paramObject).resolved != null);
        return this.interfaces.keySet().equals(((MultiType) paramObject).interfaces.keySet());
    }

    public Type getComponent() {
        return null;
    }

    public CtClass getCtClass() {
        if (this.resolved != null) {
            return this.resolved.getCtClass();
        }
        return Type.OBJECT.getCtClass();
    }

    public int getSize() {
        return 1;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isAssignableFrom(Type paramType) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean isAssignableTo(Type paramType) {
        if (this.resolved != null) {
            return paramType.isAssignableFrom(this.resolved);
        }
        if (Type.OBJECT.equals(paramType)) {
            return true;
        }
        if ((this.potentialClass != null) && (!paramType.isAssignableFrom(this.potentialClass))) {
            this.potentialClass = null;
        }
        paramType = mergeMultiAndSingle(this, paramType);
        if ((paramType.size() == 1) && (this.potentialClass == null)) {
            this.resolved = Type.get((CtClass) paramType.values().iterator().next());
            propogateResolved();
            return true;
        }
        if (paramType.size() >= 1) {
            this.interfaces = paramType;
            propogateState();
            return true;
        }
        if (this.potentialClass != null) {
            this.resolved = this.potentialClass;
            propogateResolved();
            return true;
        }
        return false;
    }

    public boolean isReference() {
        return true;
    }

    public Type merge(Type paramType) {
        if (this == paramType) {
        }
        do {
            do {
                return this;
            } while (paramType == UNINIT);
            if (paramType == BOGUS) {
                return BOGUS;
            }
        } while (paramType == null);
        if (this.resolved != null) {
            return this.resolved.merge(paramType);
        }
        Object localObject2;
        Object localObject1;
        if (this.potentialClass != null) {
            localObject2 = this.potentialClass.merge(paramType);
            if ((!((Type) localObject2).equals(this.potentialClass)) || (((Type) localObject2).popChanged())) {
                localObject1 = localObject2;
                if (Type.OBJECT.equals(localObject2)) {
                    localObject1 = null;
                }
                this.potentialClass = ((Type) localObject1);
                this.changed = true;
            }
        }
        if ((paramType instanceof MultiType)) {
            localObject2 = (MultiType) paramType;
            if (((MultiType) localObject2).resolved != null) {
                paramType = mergeMultiAndSingle(this, ((MultiType) localObject2).resolved);
                if ((paramType.size() <= 1) && ((paramType.size() != 1) || (this.potentialClass == null))) {
                    break label284;
                }
                if (paramType.size() == this.interfaces.size()) {
                    break label230;
                }
                this.changed = true;
            }
        }
        for (; ; ) {
            this.interfaces = paramType;
            propogateState();
            return this;
            localObject1 = mergeMultiInterfaces((MultiType) localObject2, this);
            paramType = (Type) localObject1;
            if (inMergeSource((MultiType) localObject2)) {
                break;
            }
            this.mergeSource = ((MultiType) localObject2);
            paramType = (Type) localObject1;
            break;
            paramType = mergeMultiAndSingle(this, paramType);
            break;
            label230:
            if (!this.changed) {
                localObject1 = paramType.keySet().iterator();
                while (((Iterator) localObject1).hasNext()) {
                    if (!this.interfaces.containsKey(((Iterator) localObject1).next())) {
                        this.changed = true;
                    }
                }
            }
        }
        label284:
        if (paramType.size() == 1) {
            this.resolved = Type.get((CtClass) paramType.values().iterator().next());
        }
        for (; ; ) {
            propogateResolved();
            return this.resolved;
            if (this.potentialClass != null) {
                this.resolved = this.potentialClass;
            } else {
                this.resolved = OBJECT;
            }
        }
    }

    boolean popChanged() {
        boolean bool = this.changed;
        this.changed = false;
        return bool;
    }

    public String toString() {
        if (this.resolved != null) {
            return this.resolved.toString();
        }
        StringBuffer localStringBuffer = new StringBuffer("{");
        Iterator localIterator = this.interfaces.keySet().iterator();
        while (localIterator.hasNext()) {
            localStringBuffer.append(localIterator.next());
            localStringBuffer.append(", ");
        }
        localStringBuffer.setLength(localStringBuffer.length() - 2);
        if (this.potentialClass != null) {
            localStringBuffer.append(", *").append(this.potentialClass.toString());
        }
        localStringBuffer.append("}");
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/MultiType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */