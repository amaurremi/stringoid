package android.support.v8.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.renderscript.RSRuntimeException;

class AllocationThunker
        extends Allocation {
    static BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();
    android.renderscript.Allocation mN;

    static {
        mBitmapOptions.inScaled = false;
    }

    AllocationThunker(RenderScript paramRenderScript, Type paramType, int paramInt, android.renderscript.Allocation paramAllocation) {
        super(0, paramRenderScript, paramType, paramInt);
        this.mType = paramType;
        this.mUsage = paramInt;
        this.mN = paramAllocation;
    }

    static android.renderscript.Allocation.MipmapControl convertMipmapControl(Allocation.MipmapControl paramMipmapControl) {
        switch (paramMipmapControl) {
            default:
                return null;
            case???:
            return android.renderscript.Allocation.MipmapControl.MIPMAP_NONE;
            case???:
            return android.renderscript.Allocation.MipmapControl.MIPMAP_FULL;
        }
        return android.renderscript.Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE;
    }

    public static Allocation createCubemapFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, Allocation.MipmapControl paramMipmapControl, int paramInt) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        try {
            paramBitmap = android.renderscript.Allocation.createCubemapFromBitmap(localRenderScriptThunker.mN, paramBitmap, convertMipmapControl(paramMipmapControl), paramInt);
            paramRenderScript = new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramBitmap.getType()), paramInt, paramBitmap);
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript paramRenderScript, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Allocation.MipmapControl paramMipmapControl, int paramInt) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        try {
            paramBitmap1 = android.renderscript.Allocation.createCubemapFromCubeFaces(localRenderScriptThunker.mN, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, paramBitmap5, paramBitmap6, convertMipmapControl(paramMipmapControl), paramInt);
            paramRenderScript = new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramBitmap1.getType()), paramInt, paramBitmap1);
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public static Allocation createFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, Allocation.MipmapControl paramMipmapControl, int paramInt) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        try {
            paramBitmap = android.renderscript.Allocation.createFromBitmap(localRenderScriptThunker.mN, paramBitmap, convertMipmapControl(paramMipmapControl), paramInt);
            paramRenderScript = new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramBitmap.getType()), paramInt, paramBitmap);
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public static Allocation createFromBitmapResource(RenderScript paramRenderScript, Resources paramResources, int paramInt1, Allocation.MipmapControl paramMipmapControl, int paramInt2) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        try {
            paramResources = android.renderscript.Allocation.createFromBitmapResource(localRenderScriptThunker.mN, paramResources, paramInt1, convertMipmapControl(paramMipmapControl), paramInt2);
            paramRenderScript = new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramResources.getType()), paramInt2, paramResources);
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public static Allocation createFromString(RenderScript paramRenderScript, String paramString, int paramInt) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        try {
            paramString = android.renderscript.Allocation.createFromString(localRenderScriptThunker.mN, paramString, paramInt);
            paramRenderScript = new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramString.getType()), paramInt, paramString);
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public static Allocation createSized(RenderScript paramRenderScript, Element paramElement, int paramInt1, int paramInt2) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        ElementThunker localElementThunker = (ElementThunker) paramElement;
        try {
            paramElement = android.renderscript.Allocation.createSized(localRenderScriptThunker.mN, (android.renderscript.Element) paramElement.getNObj(), paramInt1, paramInt2);
            paramRenderScript = new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramElement.getType()), paramInt2, paramElement);
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public static Allocation createTyped(RenderScript paramRenderScript, Type paramType, Allocation.MipmapControl paramMipmapControl, int paramInt) {
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        TypeThunker localTypeThunker = (TypeThunker) paramType;
        try {
            paramRenderScript = new AllocationThunker(paramRenderScript, paramType, paramInt, android.renderscript.Allocation.createTyped(localRenderScriptThunker.mN, localTypeThunker.mN, convertMipmapControl(paramMipmapControl), paramInt));
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    public void copy1DRangeFrom(int paramInt1, int paramInt2, Allocation paramAllocation, int paramInt3) {
        try {
            paramAllocation = (AllocationThunker) paramAllocation;
            this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramAllocation.mN, paramInt3);
            return;
        } catch (RSRuntimeException paramAllocation) {
            throw ExceptionThunker.convertException(paramAllocation);
        }
    }

    public void copy1DRangeFrom(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {
        try {
            this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramArrayOfByte);
            return;
        } catch (RSRuntimeException paramArrayOfByte) {
            throw ExceptionThunker.convertException(paramArrayOfByte);
        }
    }

    public void copy1DRangeFrom(int paramInt1, int paramInt2, float[] paramArrayOfFloat) {
        try {
            this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramArrayOfFloat);
            return;
        } catch (RSRuntimeException paramArrayOfFloat) {
            throw ExceptionThunker.convertException(paramArrayOfFloat);
        }
    }

    public void copy1DRangeFrom(int paramInt1, int paramInt2, int[] paramArrayOfInt) {
        try {
            this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramArrayOfInt);
            return;
        } catch (RSRuntimeException paramArrayOfInt) {
            throw ExceptionThunker.convertException(paramArrayOfInt);
        }
    }

    public void copy1DRangeFrom(int paramInt1, int paramInt2, short[] paramArrayOfShort) {
        try {
            this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramArrayOfShort);
            return;
        } catch (RSRuntimeException paramArrayOfShort) {
            throw ExceptionThunker.convertException(paramArrayOfShort);
        }
    }

    public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {
        try {
            this.mN.copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfByte);
            return;
        } catch (RSRuntimeException paramArrayOfByte) {
            throw ExceptionThunker.convertException(paramArrayOfByte);
        }
    }

    public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, float[] paramArrayOfFloat) {
        try {
            this.mN.copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfFloat);
            return;
        } catch (RSRuntimeException paramArrayOfFloat) {
            throw ExceptionThunker.convertException(paramArrayOfFloat);
        }
    }

    public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, int[] paramArrayOfInt) {
        try {
            this.mN.copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfInt);
            return;
        } catch (RSRuntimeException paramArrayOfInt) {
            throw ExceptionThunker.convertException(paramArrayOfInt);
        }
    }

    public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, short[] paramArrayOfShort) {
        try {
            this.mN.copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfShort);
            return;
        } catch (RSRuntimeException paramArrayOfShort) {
            throw ExceptionThunker.convertException(paramArrayOfShort);
        }
    }

    public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Allocation paramAllocation, int paramInt5, int paramInt6) {
        try {
            paramAllocation = (AllocationThunker) paramAllocation;
            this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramAllocation.mN, paramInt5, paramInt6);
            return;
        } catch (RSRuntimeException paramAllocation) {
            throw ExceptionThunker.convertException(paramAllocation);
        }
    }

    public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte) {
        try {
            this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
            return;
        } catch (RSRuntimeException paramArrayOfByte) {
            throw ExceptionThunker.convertException(paramArrayOfByte);
        }
    }

    public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat) {
        try {
            this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat);
            return;
        } catch (RSRuntimeException paramArrayOfFloat) {
            throw ExceptionThunker.convertException(paramArrayOfFloat);
        }
    }

    public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt) {
        try {
            this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
            return;
        } catch (RSRuntimeException paramArrayOfInt) {
            throw ExceptionThunker.convertException(paramArrayOfInt);
        }
    }

    public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort) {
        try {
            this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfShort);
            return;
        } catch (RSRuntimeException paramArrayOfShort) {
            throw ExceptionThunker.convertException(paramArrayOfShort);
        }
    }

    public void copy2DRangeFrom(int paramInt1, int paramInt2, Bitmap paramBitmap) {
        try {
            this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramBitmap);
            return;
        } catch (RSRuntimeException paramBitmap) {
            throw ExceptionThunker.convertException(paramBitmap);
        }
    }

    public void copyFrom(Bitmap paramBitmap) {
        try {
            this.mN.copyFrom(paramBitmap);
            return;
        } catch (RSRuntimeException paramBitmap) {
            throw ExceptionThunker.convertException(paramBitmap);
        }
    }

    public void copyFrom(Allocation paramAllocation) {
        paramAllocation = (AllocationThunker) paramAllocation;
        try {
            this.mN.copyFrom(paramAllocation.mN);
            return;
        } catch (RSRuntimeException paramAllocation) {
            throw ExceptionThunker.convertException(paramAllocation);
        }
    }

    public void copyFrom(byte[] paramArrayOfByte) {
        try {
            this.mN.copyFrom(paramArrayOfByte);
            return;
        } catch (RSRuntimeException paramArrayOfByte) {
            throw ExceptionThunker.convertException(paramArrayOfByte);
        }
    }

    public void copyFrom(float[] paramArrayOfFloat) {
        try {
            this.mN.copyFrom(paramArrayOfFloat);
            return;
        } catch (RSRuntimeException paramArrayOfFloat) {
            throw ExceptionThunker.convertException(paramArrayOfFloat);
        }
    }

    public void copyFrom(int[] paramArrayOfInt) {
        try {
            this.mN.copyFrom(paramArrayOfInt);
            return;
        } catch (RSRuntimeException paramArrayOfInt) {
            throw ExceptionThunker.convertException(paramArrayOfInt);
        }
    }

    public void copyFrom(BaseObj[] paramArrayOfBaseObj) {
        if (paramArrayOfBaseObj == null) {
            return;
        }
        android.renderscript.BaseObj[] arrayOfBaseObj = new android.renderscript.BaseObj[paramArrayOfBaseObj.length];
        int i = 0;
        while (i < paramArrayOfBaseObj.length) {
            arrayOfBaseObj[i] = paramArrayOfBaseObj[i].getNObj();
            i += 1;
        }
        try {
            this.mN.copyFrom(arrayOfBaseObj);
            return;
        } catch (RSRuntimeException paramArrayOfBaseObj) {
            throw ExceptionThunker.convertException(paramArrayOfBaseObj);
        }
    }

    public void copyFrom(short[] paramArrayOfShort) {
        try {
            this.mN.copyFrom(paramArrayOfShort);
            return;
        } catch (RSRuntimeException paramArrayOfShort) {
            throw ExceptionThunker.convertException(paramArrayOfShort);
        }
    }

    public void copyFromUnchecked(byte[] paramArrayOfByte) {
        try {
            this.mN.copyFromUnchecked(paramArrayOfByte);
            return;
        } catch (RSRuntimeException paramArrayOfByte) {
            throw ExceptionThunker.convertException(paramArrayOfByte);
        }
    }

    public void copyFromUnchecked(float[] paramArrayOfFloat) {
        try {
            this.mN.copyFromUnchecked(paramArrayOfFloat);
            return;
        } catch (RSRuntimeException paramArrayOfFloat) {
            throw ExceptionThunker.convertException(paramArrayOfFloat);
        }
    }

    public void copyFromUnchecked(int[] paramArrayOfInt) {
        try {
            this.mN.copyFromUnchecked(paramArrayOfInt);
            return;
        } catch (RSRuntimeException paramArrayOfInt) {
            throw ExceptionThunker.convertException(paramArrayOfInt);
        }
    }

    public void copyFromUnchecked(short[] paramArrayOfShort) {
        try {
            this.mN.copyFromUnchecked(paramArrayOfShort);
            return;
        } catch (RSRuntimeException paramArrayOfShort) {
            throw ExceptionThunker.convertException(paramArrayOfShort);
        }
    }

    public void copyTo(Bitmap paramBitmap) {
        try {
            this.mN.copyTo(paramBitmap);
            return;
        } catch (RSRuntimeException paramBitmap) {
            throw ExceptionThunker.convertException(paramBitmap);
        }
    }

    public void copyTo(byte[] paramArrayOfByte) {
        try {
            this.mN.copyTo(paramArrayOfByte);
            return;
        } catch (RSRuntimeException paramArrayOfByte) {
            throw ExceptionThunker.convertException(paramArrayOfByte);
        }
    }

    public void copyTo(float[] paramArrayOfFloat) {
        try {
            this.mN.copyTo(paramArrayOfFloat);
            return;
        } catch (RSRuntimeException paramArrayOfFloat) {
            throw ExceptionThunker.convertException(paramArrayOfFloat);
        }
    }

    public void copyTo(int[] paramArrayOfInt) {
        try {
            this.mN.copyTo(paramArrayOfInt);
            return;
        } catch (RSRuntimeException paramArrayOfInt) {
            throw ExceptionThunker.convertException(paramArrayOfInt);
        }
    }

    public void copyTo(short[] paramArrayOfShort) {
        try {
            this.mN.copyTo(paramArrayOfShort);
            return;
        } catch (RSRuntimeException paramArrayOfShort) {
            throw ExceptionThunker.convertException(paramArrayOfShort);
        }
    }

    public void generateMipmaps() {
        try {
            this.mN.generateMipmaps();
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
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

    public Element getElement() {
        return getType().getElement();
    }

    android.renderscript.Allocation getNObj() {
        return this.mN;
    }

    public Type getType() {
        return TypeThunker.find(this.mN.getType());
    }

    public int getUsage() {
        try {
            int i = this.mN.getUsage();
            return i;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public void ioReceive() {
        try {
            this.mN.ioReceive();
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public void ioSend() {
        try {
            this.mN.ioSend();
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    public void setFromFieldPacker(int paramInt1, int paramInt2, FieldPacker paramFieldPacker) {
        try {
            paramFieldPacker = new android.renderscript.FieldPacker(paramFieldPacker.getData());
            this.mN.setFromFieldPacker(paramInt1, paramInt2, paramFieldPacker);
            return;
        } catch (RSRuntimeException paramFieldPacker) {
            throw ExceptionThunker.convertException(paramFieldPacker);
        }
    }

    public void setFromFieldPacker(int paramInt, FieldPacker paramFieldPacker) {
        try {
            paramFieldPacker = new android.renderscript.FieldPacker(paramFieldPacker.getData());
            this.mN.setFromFieldPacker(paramInt, paramFieldPacker);
            return;
        } catch (RSRuntimeException paramFieldPacker) {
            throw ExceptionThunker.convertException(paramFieldPacker);
        }
    }

    public void syncAll(int paramInt) {
        try {
            this.mN.syncAll(paramInt);
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/AllocationThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */