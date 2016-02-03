package javassist.bytecode;

public class SignatureAttribute$TypeArgument {
    SignatureAttribute.ObjectType arg;
    char wildcard;

    SignatureAttribute$TypeArgument(SignatureAttribute.ObjectType paramObjectType, char paramChar) {
        this.arg = paramObjectType;
        this.wildcard = paramChar;
    }

    public char getKind() {
        return this.wildcard;
    }

    public SignatureAttribute.ObjectType getType() {
        return this.arg;
    }

    public boolean isWildcard() {
        return this.wildcard != ' ';
    }

    public String toString() {
        Object localObject;
        if (this.wildcard == '*') {
            localObject = "?";
        }
        String str;
        do {
            return (String) localObject;
            str = this.arg.toString();
            localObject = str;
        } while (this.wildcard == ' ');
        if (this.wildcard == '+') {
            return "? extends " + str;
        }
        return "? super " + str;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute$TypeArgument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */