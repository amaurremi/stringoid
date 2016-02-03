package javassist.bytecode;

class CodeAttribute$LdcEntry {
    int index;
    LdcEntry next;
    int where;

    static byte[] doit(byte[] paramArrayOfByte, LdcEntry paramLdcEntry, ExceptionTable paramExceptionTable, CodeAttribute paramCodeAttribute) {
        byte[] arrayOfByte = paramArrayOfByte;
        if (paramLdcEntry != null) {
            arrayOfByte = CodeIterator.changeLdcToLdcW(paramArrayOfByte, paramExceptionTable, paramCodeAttribute, paramLdcEntry);
        }
        return arrayOfByte;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeAttribute$LdcEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */