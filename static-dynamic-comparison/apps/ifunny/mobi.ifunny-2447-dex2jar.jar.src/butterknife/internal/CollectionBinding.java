package butterknife.internal;

final class CollectionBinding
        implements Binding {
    private final CollectionBinding.Kind kind;
    private final String name;
    private final boolean required;
    private final String type;

    CollectionBinding(String paramString1, String paramString2, CollectionBinding.Kind paramKind, boolean paramBoolean) {
        this.name = paramString1;
        this.type = paramString2;
        this.kind = paramKind;
        this.required = paramBoolean;
    }

    public String getDescription() {
        return "field '" + this.name + "'";
    }

    public CollectionBinding.Kind getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public boolean isRequired() {
        return this.required;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/internal/CollectionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */