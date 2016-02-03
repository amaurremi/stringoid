package butterknife.internal;

final class ViewBinding
        implements Binding {
    private final String name;
    private final boolean required;
    private final String type;

    ViewBinding(String paramString1, String paramString2, boolean paramBoolean) {
        this.name = paramString1;
        this.type = paramString2;
        this.required = paramBoolean;
    }

    public String getDescription() {
        return "field '" + this.name + "'";
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/internal/ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */