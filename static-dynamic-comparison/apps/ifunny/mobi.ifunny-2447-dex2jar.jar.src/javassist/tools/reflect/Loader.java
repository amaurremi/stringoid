package javassist.tools.reflect;

import javassist.ClassPool;

public class Loader
        extends javassist.Loader {
    protected Reflection reflection;

    public Loader() {
        delegateLoadingOf("javassist.tools.reflect.Loader");
        this.reflection = new Reflection();
        addTranslator(ClassPool.getDefault(), this.reflection);
    }

    public static void main(String[] paramArrayOfString) {
        new Loader().run(paramArrayOfString);
    }

    public boolean makeReflective(String paramString1, String paramString2, String paramString3) {
        return this.reflection.makeReflective(paramString1, paramString2, paramString3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/Loader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */