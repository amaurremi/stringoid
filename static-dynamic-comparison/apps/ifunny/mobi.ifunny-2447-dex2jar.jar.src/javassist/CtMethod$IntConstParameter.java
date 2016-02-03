package javassist;

import javassist.bytecode.Bytecode;

class CtMethod$IntConstParameter
        extends CtMethod.ConstParameter {
    int param;

    CtMethod$IntConstParameter(int paramInt) {
        this.param = paramInt;
    }

    int compile(Bytecode paramBytecode) {
        paramBytecode.addIconst(this.param);
        return 1;
    }

    String constDescriptor() {
        return "([Ljava/lang/Object;I)V";
    }

    String descriptor() {
        return "([Ljava/lang/Object;I)Ljava/lang/Object;";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtMethod$IntConstParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */