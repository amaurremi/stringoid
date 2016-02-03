package javassist;

import javassist.bytecode.Bytecode;

class CtMethod$StringConstParameter
        extends CtMethod.ConstParameter {
    String param;

    CtMethod$StringConstParameter(String paramString) {
        this.param = paramString;
    }

    int compile(Bytecode paramBytecode) {
        paramBytecode.addLdc(this.param);
        return 1;
    }

    String constDescriptor() {
        return "([Ljava/lang/Object;Ljava/lang/String;)V";
    }

    String descriptor() {
        return "([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtMethod$StringConstParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */