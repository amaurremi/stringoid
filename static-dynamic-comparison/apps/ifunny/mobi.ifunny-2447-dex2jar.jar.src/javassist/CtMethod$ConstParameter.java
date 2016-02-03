package javassist;

import javassist.bytecode.Bytecode;

public class CtMethod$ConstParameter {
    static String defaultConstDescriptor() {
        return "([Ljava/lang/Object;)V";
    }

    static String defaultDescriptor() {
        return "([Ljava/lang/Object;)Ljava/lang/Object;";
    }

    public static ConstParameter integer(int paramInt) {
        return new CtMethod.IntConstParameter(paramInt);
    }

    public static ConstParameter integer(long paramLong) {
        return new CtMethod.LongConstParameter(paramLong);
    }

    public static ConstParameter string(String paramString) {
        return new CtMethod.StringConstParameter(paramString);
    }

    int compile(Bytecode paramBytecode) {
        return 0;
    }

    String constDescriptor() {
        return defaultConstDescriptor();
    }

    String descriptor() {
        return defaultDescriptor();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtMethod$ConstParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */