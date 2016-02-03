package javassist.runtime;

class Cflow$Depth {
    private int depth = 0;

    void dec() {
        this.depth -= 1;
    }

    int get() {
        return this.depth;
    }

    void inc() {
        this.depth += 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/runtime/Cflow$Depth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */