package javassist.bytecode;

class SignatureAttribute$Cursor {
    int position = 0;

    int indexOf(String paramString, int paramInt) {
        paramInt = paramString.indexOf(paramInt, this.position);
        if (paramInt < 0) {
            throw SignatureAttribute.access$000(paramString);
        }
        this.position = (paramInt + 1);
        return paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$Cursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */