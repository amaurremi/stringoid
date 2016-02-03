package javassist.bytecode.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subroutine {
    private Set access = new HashSet();
    private List callers = new ArrayList();
    private int start;

    public Subroutine(int paramInt1, int paramInt2) {
        this.start = paramInt1;
        this.callers.add(new Integer(paramInt2));
    }

    public void access(int paramInt) {
        this.access.add(new Integer(paramInt));
    }

    public Collection accessed() {
        return this.access;
    }

    public void addCaller(int paramInt) {
        this.callers.add(new Integer(paramInt));
    }

    public Collection callers() {
        return this.callers;
    }

    public boolean isAccessed(int paramInt) {
        return this.access.contains(new Integer(paramInt));
    }

    public int start() {
        return this.start;
    }

    public String toString() {
        return "start = " + this.start + " callers = " + this.callers.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/Subroutine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */