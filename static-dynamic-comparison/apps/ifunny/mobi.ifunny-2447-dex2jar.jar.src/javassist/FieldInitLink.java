package javassist;

class FieldInitLink {
    CtField field;
    CtField.Initializer init;
    FieldInitLink next = null;

    FieldInitLink(CtField paramCtField, CtField.Initializer paramInitializer) {
        this.field = paramCtField;
        this.init = paramInitializer;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/FieldInitLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */