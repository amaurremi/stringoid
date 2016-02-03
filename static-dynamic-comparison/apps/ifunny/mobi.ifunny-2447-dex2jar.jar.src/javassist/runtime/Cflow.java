package javassist.runtime;

public class Cflow
        extends ThreadLocal {
    public void enter() {
        ((Cflow.Depth) get()).inc();
    }

    public void exit() {
        ((Cflow.Depth) get()).dec();
    }

    protected Object initialValue() {
        try {
            Cflow.Depth localDepth = new Cflow.Depth();
            return localDepth;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public int value() {
        return ((Cflow.Depth) get()).get();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/runtime/Cflow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */