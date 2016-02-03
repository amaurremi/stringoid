package retrofit.client;

public final class Header {
    private final String name;
    private final String value;

    public Header(String paramString1, String paramString2) {
        this.name = paramString1;
        this.value = paramString2;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (Header) paramObject;
            if (this.name != null) {
                if (this.name.equals(((Header) paramObject).name)) {
                }
            } else {
                while (((Header) paramObject).name != null) {
                    return false;
                }
            }
            if (this.value == null) {
                break;
            }
        } while (this.value.equals(((Header) paramObject).value));
        for (; ; ) {
            return false;
            if (((Header) paramObject).value == null) {
                break;
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int j = 0;
        if (this.name != null) {
        }
        for (int i = this.name.hashCode(); ; i = 0) {
            if (this.value != null) {
                j = this.value.hashCode();
            }
            return i * 31 + j;
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.name != null) {
            str = this.name;
            localStringBuilder = localStringBuilder.append(str).append(": ");
            if (this.value == null) {
                break label58;
            }
        }
        label58:
        for (String str = this.value; ; str = "") {
            return str;
            str = "";
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/client/Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */