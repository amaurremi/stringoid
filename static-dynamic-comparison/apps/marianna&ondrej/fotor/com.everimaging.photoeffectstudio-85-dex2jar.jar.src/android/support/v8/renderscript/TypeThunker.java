package android.support.v8.renderscript;

import android.renderscript.RSRuntimeException;
import android.renderscript.Type.Builder;

import java.util.HashMap;

class TypeThunker
        extends Type {
    static HashMap<android.renderscript.Type, Type> mMap = new HashMap();
    android.renderscript.Type mN;

    /* Error */
    TypeThunker(RenderScript arg1, android.renderscript.Type paramType) {
        // Byte code:
        //   0: aload_0
        //   1: iconst_0
        //   2: aload_1
        //   3: invokespecial 25	android/support/v8/renderscript/Type:<init>	(ILandroid/support/v8/renderscript/RenderScript;)V
        //   6: aload_0
        //   7: aload_2
        //   8: putfield 27	android/support/v8/renderscript/TypeThunker:mN	Landroid/renderscript/Type;
        //   11: aload_0
        //   12: invokevirtual 30	android/support/v8/renderscript/TypeThunker:internalCalc	()V
        //   15: aload_0
        //   16: new 32	android/support/v8/renderscript/ElementThunker
        //   19: dup
        //   20: aload_1
        //   21: aload_2
        //   22: invokevirtual 38	android/renderscript/Type:getElement	()Landroid/renderscript/Element;
        //   25: invokespecial 41	android/support/v8/renderscript/ElementThunker:<init>	(Landroid/support/v8/renderscript/RenderScript;Landroid/renderscript/Element;)V
        //   28: putfield 45	android/support/v8/renderscript/TypeThunker:mElement	Landroid/support/v8/renderscript/Element;
        //   31: getstatic 18	android/support/v8/renderscript/TypeThunker:mMap	Ljava/util/HashMap;
        //   34: astore_1
        //   35: aload_1
        //   36: monitorenter
        //   37: getstatic 18	android/support/v8/renderscript/TypeThunker:mMap	Ljava/util/HashMap;
        //   40: aload_0
        //   41: getfield 27	android/support/v8/renderscript/TypeThunker:mN	Landroid/renderscript/Type;
        //   44: aload_0
        //   45: invokevirtual 49	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   48: pop
        //   49: aload_1
        //   50: monitorexit
        //   51: return
        //   52: astore_1
        //   53: aload_1
        //   54: invokestatic 55	android/support/v8/renderscript/ExceptionThunker:convertException	(Ljava/lang/RuntimeException;)Ljava/lang/RuntimeException;
        //   57: athrow
        //   58: astore_2
        //   59: aload_1
        //   60: monitorexit
        //   61: aload_2
        //   62: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	63	0	this	TypeThunker
        //   0	63	2	paramType	android.renderscript.Type
        // Exception table:
        //   from	to	target	type
        //   11	31	52	android/renderscript/RSRuntimeException
        //   37	51	58	finally
        //   59	61	58	finally
    }

    static Type create(RenderScript paramRenderScript, Element paramElement, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4) {
        paramElement = (ElementThunker) paramElement;
        RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
        try {
            paramElement = new Type.Builder(localRenderScriptThunker.mN, paramElement.mN);
            if (paramInt1 > 0) {
                paramElement.setX(paramInt1);
            }
            if (paramInt2 > 0) {
                paramElement.setY(paramInt2);
            }
            if (paramInt3 > 0) {
                paramElement.setZ(paramInt3);
            }
            if (paramBoolean1) {
                paramElement.setMipmaps(paramBoolean1);
            }
            if (paramBoolean2) {
                paramElement.setFaces(paramBoolean2);
            }
            if (paramInt4 > 0) {
                paramElement.setYuvFormat(paramInt4);
            }
            paramRenderScript = new TypeThunker(paramRenderScript, paramElement.create());
            paramRenderScript.internalCalc();
            return paramRenderScript;
        } catch (RSRuntimeException paramRenderScript) {
            throw ExceptionThunker.convertException(paramRenderScript);
        }
    }

    static Type find(android.renderscript.Type paramType) {
        return (Type) mMap.get(paramType);
    }

    android.renderscript.Type getNObj() {
        return this.mN;
    }

    void internalCalc() {
        this.mDimX = this.mN.getX();
        this.mDimY = this.mN.getY();
        this.mDimZ = this.mN.getZ();
        this.mDimFaces = this.mN.hasFaces();
        this.mDimMipmaps = this.mN.hasMipmaps();
        this.mDimYuv = this.mN.getYuv();
        calcElementCount();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/TypeThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */