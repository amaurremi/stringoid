package android.support.v8.renderscript;

import android.renderscript.Element.Builder;
import android.renderscript.RSRuntimeException;

class ElementThunker
        extends Element {
    android.renderscript.Element mN;

    ElementThunker(RenderScript paramRenderScript, android.renderscript.Element paramElement) {
        super(0, paramRenderScript);
        this.mN = paramElement;
    }

    static android.renderscript.Element.DataKind convertKind(Element.DataKind paramDataKind) {
        switch (1. $SwitchMap$android$support$v8$renderscript$Element$DataKind[paramDataKind.ordinal()])
        {
            default:
                return null;
            case 1:
                return android.renderscript.Element.DataKind.USER;
            case 2:
                return android.renderscript.Element.DataKind.PIXEL_L;
            case 3:
                return android.renderscript.Element.DataKind.PIXEL_A;
            case 4:
                return android.renderscript.Element.DataKind.PIXEL_LA;
            case 5:
                return android.renderscript.Element.DataKind.PIXEL_RGB;
        }
        return android.renderscript.Element.DataKind.PIXEL_RGBA;
    }

    static android.renderscript.Element.DataType convertType(Element.DataType paramDataType) {
        switch (paramDataType) {
            default:
                return null;
            case???:
            return android.renderscript.Element.DataType.NONE;
            case???:
            return android.renderscript.Element.DataType.FLOAT_32;
            case???:
            return android.renderscript.Element.DataType.FLOAT_64;
            case???:
            return android.renderscript.Element.DataType.SIGNED_8;
            case???:
            return android.renderscript.Element.DataType.SIGNED_16;
            case???:
            return android.renderscript.Element.DataType.SIGNED_32;
            case???:
            return android.renderscript.Element.DataType.SIGNED_64;
            case???:
            return android.renderscript.Element.DataType.UNSIGNED_8;
            case???:
            return android.renderscript.Element.DataType.UNSIGNED_16;
            case???:
            return android.renderscript.Element.DataType.UNSIGNED_32;
            case???:
            return android.renderscript.Element.DataType.UNSIGNED_64;
            case???:
            return android.renderscript.Element.DataType.BOOLEAN;
            case???:
            return android.renderscript.Element.DataType.MATRIX_4X4;
            case???:
            return android.renderscript.Element.DataType.MATRIX_3X3;
            case???:
            return android.renderscript.Element.DataType.MATRIX_2X2;
            case???:
            return android.renderscript.Element.DataType.RS_ELEMENT;
            case???:
            return android.renderscript.Element.DataType.RS_TYPE;
            case???:
            return android.renderscript.Element.DataType.RS_ALLOCATION;
            case???:
            return android.renderscript.Element.DataType.RS_SAMPLER;
        }
        return android.renderscript.Element.DataType.RS_SCRIPT;
    }

    static Element create(RenderScript paramRenderScript, Element.DataType paramDataType) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        for (; ; ) {
            try {
                switch (paramDataType) {
                    case???:
                    return new ElementThunker(paramRenderScript, paramDataType);
                }
            } catch (RSRuntimeException paramRenderScript) {
                throw ExceptionThunker.convertException(paramRenderScript);
            }
            paramDataType = android.renderscript.Element.F32(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.F64(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.I8(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.I16(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.I32(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.I64(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.U8(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.U16(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.U32(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.U64(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.BOOLEAN(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.MATRIX_4X4(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.MATRIX_3X3(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.MATRIX_2X2(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.ELEMENT(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.TYPE(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.ALLOCATION(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.SAMPLER(localRenderScriptThunker.mN);
            continue;
            paramDataType = android.renderscript.Element.SCRIPT(localRenderScriptThunker.mN);
            continue;
            paramDataType = null;
        }
    }

    public static Element createPixel(RenderScript paramRenderScript, Element.DataType paramDataType, Element.DataKind paramDataKind) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        try {
            paramRenderScript = new ElementThunker(paramRenderScript, android.renderscript.Element.createPixel(localRenderScriptThunker.mN, convertType(paramDataType), convertKind(paramDataKind)));
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public static Element createVector(RenderScript paramRenderScript, Element.DataType paramDataType, int paramInt) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        try {
            paramRenderScript = new ElementThunker(paramRenderScript, android.renderscript.Element.createVector(localRenderScriptThunker.mN, convertType(paramDataType), paramInt));
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public int getBytesSize() {
        try {
            int i = this.mN.getBytesSize();
            return i;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public Element.DataKind getDataKind() {
        return this.mKind;
    }

    public Element.DataType getDataType() {
        return this.mType;
    }

    android.renderscript.Element getNObj() {
        return this.mN;
    }

    public Element getSubElement(int paramInt) {
        try {
            ElementThunker localElementThunker = new ElementThunker(this.mRS, this.mN.getSubElement(paramInt));
            return localElementThunker;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public int getSubElementArraySize(int paramInt) {
        try {
            paramInt = this.mN.getSubElementArraySize(paramInt);
            return paramInt;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public int getSubElementCount() {
        try {
            int i = this.mN.getSubElementCount();
            return i;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public String getSubElementName(int paramInt) {
        try {
            String str = this.mN.getSubElementName(paramInt);
            return str;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public int getSubElementOffsetBytes(int paramInt) {
        try {
            paramInt = this.mN.getSubElementOffsetBytes(paramInt);
            return paramInt;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public int getVectorSize() {
        try {
            int i = this.mN.getVectorSize();
            return i;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public boolean isCompatible(Element paramElement) {
        paramElement = (ElementThunker) paramElement;
        try {
            boolean bool = paramElement.mN.isCompatible(this.mN);
            return bool;
        } catch (RSRuntimeException paramElement) {
            throw ExceptionThunker.convertException(paramElement);
        }
    }

    public boolean isComplex() {
        try {
            boolean bool = this.mN.isComplex();
            return bool;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    static class BuilderThunker {
        Element.Builder mN;

        public BuilderThunker(RenderScript paramRenderScript) {
            paramRenderScript = (RenderScriptThunker) paramRenderScript;
            try {
                this.mN = new Element.Builder(paramRenderScript.mN);
                return;
            } catch (RSRuntimeException paramRenderScript) {
                throw ExceptionThunker.convertException(paramRenderScript);
            }
        }

        public void add(Element paramElement, String paramString, int paramInt) {
            paramElement = (ElementThunker) paramElement;
            try {
                this.mN.add(paramElement.mN, paramString, paramInt);
                return;
            } catch (RSRuntimeException paramElement) {
                throw ExceptionThunker.convertException(paramElement);
            }
        }

        public Element create(RenderScript paramRenderScript) {
            try {
                paramRenderScript = new ElementThunker(paramRenderScript, this.mN.create());
                return paramRenderScript;
            } catch (RSRuntimeException paramRenderScript) {
                throw ExceptionThunker.convertException(paramRenderScript);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ElementThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */