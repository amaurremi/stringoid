package javassist.compiler;

import javassist.CtClass;
import javassist.bytecode.MethodInfo;

public class MemberResolver$Method {
    public CtClass declaring;
    public MethodInfo info;
    public int notmatch;

    public MemberResolver$Method(CtClass paramCtClass, MethodInfo paramMethodInfo, int paramInt) {
        this.declaring = paramCtClass;
        this.info = paramMethodInfo;
        this.notmatch = paramInt;
    }

    public boolean isStatic() {
        return (this.info.getAccessFlags() & 0x8) != 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/MemberResolver$Method.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */