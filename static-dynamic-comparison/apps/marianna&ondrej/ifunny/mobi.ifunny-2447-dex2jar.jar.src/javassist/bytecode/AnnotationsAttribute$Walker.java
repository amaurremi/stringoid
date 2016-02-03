package javassist.bytecode;

class AnnotationsAttribute$Walker {
    byte[] info;

    AnnotationsAttribute$Walker(byte[] paramArrayOfByte) {
        this.info = paramArrayOfByte;
    }

    final int annotation(int paramInt) {
        return annotation(paramInt + 4, ByteArray.readU16bit(this.info, paramInt), ByteArray.readU16bit(this.info, paramInt + 2));
    }

    int annotation(int paramInt1, int paramInt2, int paramInt3) {
        int i = 0;
        paramInt2 = paramInt1;
        paramInt1 = i;
        while (paramInt1 < paramInt3) {
            paramInt2 = memberValuePair(paramInt2);
            paramInt1 += 1;
        }
        return paramInt2;
    }

    final int annotationArray(int paramInt) {
        return annotationArray(paramInt + 2, ByteArray.readU16bit(this.info, paramInt));
    }

    int annotationArray(int paramInt1, int paramInt2) {
        int j = 0;
        int i = paramInt1;
        paramInt1 = j;
        while (paramInt1 < paramInt2) {
            i = annotation(i);
            paramInt1 += 1;
        }
        return i;
    }

    final void annotationArray() {
        annotationArray(0);
    }

    int annotationMemberValue(int paramInt) {
        return annotation(paramInt);
    }

    int arrayMemberValue(int paramInt1, int paramInt2) {
        int j = 0;
        int i = paramInt1;
        paramInt1 = j;
        while (paramInt1 < paramInt2) {
            i = memberValue(i);
            paramInt1 += 1;
        }
        return i;
    }

    void classMemberValue(int paramInt1, int paramInt2) {
    }

    void constValueMember(int paramInt1, int paramInt2) {
    }

    void enumMemberValue(int paramInt1, int paramInt2, int paramInt3) {
    }

    final int memberValue(int paramInt) {
        int i = this.info[paramInt] & 0xFF;
        if (i == 101) {
            enumMemberValue(paramInt, ByteArray.readU16bit(this.info, paramInt + 1), ByteArray.readU16bit(this.info, paramInt + 3));
            return paramInt + 5;
        }
        if (i == 99) {
            classMemberValue(paramInt, ByteArray.readU16bit(this.info, paramInt + 1));
            return paramInt + 3;
        }
        if (i == 64) {
            return annotationMemberValue(paramInt + 1);
        }
        if (i == 91) {
            return arrayMemberValue(paramInt + 3, ByteArray.readU16bit(this.info, paramInt + 1));
        }
        constValueMember(i, ByteArray.readU16bit(this.info, paramInt + 1));
        return paramInt + 3;
    }

    final int memberValuePair(int paramInt) {
        return memberValuePair(paramInt + 2, ByteArray.readU16bit(this.info, paramInt));
    }

    int memberValuePair(int paramInt1, int paramInt2) {
        return memberValue(paramInt1);
    }

    final void parameters() {
        parameters(this.info[0] & 0xFF, 1);
    }

    void parameters(int paramInt1, int paramInt2) {
        int j = 0;
        int i = paramInt2;
        paramInt2 = j;
        while (paramInt2 < paramInt1) {
            i = annotationArray(i);
            paramInt2 += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/AnnotationsAttribute$Walker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */