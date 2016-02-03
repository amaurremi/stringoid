package javassist.convert;

import javassist.CannotCompileException;
import javassist.CodeConverter.ArrayAccessReplacementMethodNames;
import javassist.CtClass;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.CodeIterator.Gap;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.analysis.Analyzer;
import javassist.bytecode.analysis.Frame;
import javassist.bytecode.analysis.Type;

public final class TransformAccessArrayField
        extends Transformer {
    private Frame[] frames;
    private final String methodClassname;
    private final CodeConverter.ArrayAccessReplacementMethodNames names;
    private int offset;

    public TransformAccessArrayField(Transformer paramTransformer, String paramString, CodeConverter.ArrayAccessReplacementMethodNames paramArrayAccessReplacementMethodNames) {
        super(paramTransformer);
        this.methodClassname = paramString;
        this.names = paramArrayAccessReplacementMethodNames;
    }

    private Frame getFrame(int paramInt) {
        return this.frames[(paramInt - this.offset)];
    }

    private String getLoadReplacementSignature(int paramInt) {
        switch (paramInt) {
            default:
                throw new BadBytecode(paramInt);
            case 50:
                return "(Ljava/lang/Object;I)Ljava/lang/Object;";
            case 51:
                return "(Ljava/lang/Object;I)B";
            case 52:
                return "(Ljava/lang/Object;I)C";
            case 49:
                return "(Ljava/lang/Object;I)D";
            case 48:
                return "(Ljava/lang/Object;I)F";
            case 46:
                return "(Ljava/lang/Object;I)I";
            case 53:
                return "(Ljava/lang/Object;I)S";
        }
        return "(Ljava/lang/Object;I)J";
    }

    private String getMethodName(int paramInt) {
        String str;
        switch (paramInt) {
            default:
                str = null;
        }
        while (str.equals("")) {
            return null;
            str = this.names.objectRead();
            continue;
            str = this.names.byteOrBooleanRead();
            continue;
            str = this.names.charRead();
            continue;
            str = this.names.doubleRead();
            continue;
            str = this.names.floatRead();
            continue;
            str = this.names.intRead();
            continue;
            str = this.names.shortRead();
            continue;
            str = this.names.longRead();
            continue;
            str = this.names.objectWrite();
            continue;
            str = this.names.byteOrBooleanWrite();
            continue;
            str = this.names.charWrite();
            continue;
            str = this.names.doubleWrite();
            continue;
            str = this.names.floatWrite();
            continue;
            str = this.names.intWrite();
            continue;
            str = this.names.shortWrite();
            continue;
            str = this.names.longWrite();
        }
        return str;
    }

    private String getStoreReplacementSignature(int paramInt) {
        switch (paramInt) {
            default:
                throw new BadBytecode(paramInt);
            case 83:
                return "(Ljava/lang/Object;ILjava/lang/Object;)V";
            case 84:
                return "(Ljava/lang/Object;IB)V";
            case 85:
                return "(Ljava/lang/Object;IC)V";
            case 82:
                return "(Ljava/lang/Object;ID)V";
            case 81:
                return "(Ljava/lang/Object;IF)V";
            case 79:
                return "(Ljava/lang/Object;II)V";
            case 86:
                return "(Ljava/lang/Object;IS)V";
        }
        return "(Ljava/lang/Object;IJ)V";
    }

    private String getTopType(int paramInt) {
        Object localObject = getFrame(paramInt);
        if (localObject == null) {
        }
        do {
            return null;
            localObject = ((Frame) localObject).peek().getCtClass();
        } while (localObject == null);
        return Descriptor.toJvmName((CtClass) localObject);
    }

    private void initFrames(CtClass paramCtClass, MethodInfo paramMethodInfo) {
        if (this.frames == null) {
            this.frames = new Analyzer().analyze(paramCtClass, paramMethodInfo);
            this.offset = 0;
        }
    }

    private int replace(ConstPool paramConstPool, CodeIterator paramCodeIterator, int paramInt1, int paramInt2, String paramString) {
        CodeIterator.Gap localGap = null;
        String str = getMethodName(paramInt2);
        Object localObject;
        if (str != null) {
            localObject = localGap;
            if (paramInt2 != 50) {
                break label58;
            }
            localObject = getTopType(paramCodeIterator.lookAhead());
            if (localObject != null) {
            }
        } else {
            return paramInt1;
        }
        if ("java/lang/Object".equals(localObject)) {
            localObject = localGap;
        }
        for (; ; ) {
            label58:
            paramCodeIterator.writeByte(0, paramInt1);
            if (localObject != null) {
            }
            for (paramInt2 = 5; ; paramInt2 = 2) {
                localGap = paramCodeIterator.insertGapAt(paramInt1, paramInt2, false);
                paramInt1 = localGap.position;
                paramInt2 = paramConstPool.addMethodrefInfo(paramConstPool.addClassInfo(this.methodClassname), str, paramString);
                paramCodeIterator.writeByte(184, paramInt1);
                paramCodeIterator.write16bit(paramInt2, paramInt1 + 1);
                if (localObject != null) {
                    paramInt2 = paramConstPool.addClassInfo((String) localObject);
                    paramCodeIterator.writeByte(192, paramInt1 + 3);
                    paramCodeIterator.write16bit(paramInt2, paramInt1 + 4);
                }
                return updatePos(paramInt1, localGap.length);
            }
        }
    }

    private int updatePos(int paramInt1, int paramInt2) {
        if (this.offset > -1) {
            this.offset += paramInt2;
        }
        return paramInt1 + paramInt2;
    }

    public void clean() {
        this.frames = null;
        this.offset = -1;
    }

    public void initialize(ConstPool paramConstPool, CtClass paramCtClass, MethodInfo paramMethodInfo) {
        CodeIterator localCodeIterator = paramMethodInfo.getCodeAttribute().iterator();
        break label80;
        label9:
        if (localCodeIterator.hasNext()) {
        }
        for (; ; ) {
            int i;
            int j;
            try {
                i = localCodeIterator.next();
                j = localCodeIterator.byteAt(i);
                if (j != 50) {
                    break label158;
                }
                initFrames(paramCtClass, paramMethodInfo);
            } catch (Exception paramConstPool) {
                throw new CannotCompileException(paramConstPool);
            }
            replace(paramConstPool, localCodeIterator, i, j, getLoadReplacementSignature(j));
            break label9;
            label80:
            if ((j != 83) && (j != 84) && (j != 85) && (j != 82) && (j != 81) && (j != 79) && (j != 80) && (j != 86)) {
                break label9;
            }
            replace(paramConstPool, localCodeIterator, i, j, getStoreReplacementSignature(j));
            break label9;
            return;
            label158:
            if ((j != 50) && (j != 51) && (j != 52) && (j != 49) && (j != 48) && (j != 46) && (j != 47)) {
                if (j != 53) {
                    break;
                }
            }
        }
    }

    public int transform(CtClass paramCtClass, int paramInt, CodeIterator paramCodeIterator, ConstPool paramConstPool) {
        return paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformAccessArrayField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */