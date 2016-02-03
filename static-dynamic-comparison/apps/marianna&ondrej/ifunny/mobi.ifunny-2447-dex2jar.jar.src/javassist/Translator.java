package javassist;

public abstract interface Translator {
    public abstract void onLoad(ClassPool paramClassPool, String paramString);

    public abstract void start(ClassPool paramClassPool);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/Translator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */