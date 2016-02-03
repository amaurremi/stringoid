package javassist;

import javassist.bytecode.Bytecode;

class CtMethod$LongConstParameter
        extends CtMethod.ConstParameter {
    long param;

    CtMethod$LongConstParameter(long paramLong) {
        this.param = paramLong;
    }

    int compile(Bytecode paramBytecode) {
        paramBytecode.addLconst(this.param);
        return 2;
    }

    String constDescriptor() {
        return "([Ljava/lang/Object;J)V";
    }

    String descriptor() {
        return "([Ljava/lang/Object;J)Ljava/lang/Object;";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtMethod$LongConstParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */