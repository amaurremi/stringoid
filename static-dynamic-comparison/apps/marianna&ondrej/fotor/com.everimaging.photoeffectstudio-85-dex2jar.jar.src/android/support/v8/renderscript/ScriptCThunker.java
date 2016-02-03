package android.support.v8.renderscript;

import android.content.res.Resources;
import android.renderscript.RSRuntimeException;
import android.renderscript.Script.FieldID;
import android.renderscript.Script.KernelID;
import android.renderscript.ScriptC;

class ScriptCThunker
        extends ScriptC {
    private static final String TAG = "ScriptC";

    protected ScriptCThunker(RenderScriptThunker paramRenderScriptThunker, Resources paramResources, int paramInt) {
        super(paramRenderScriptThunker.mN, paramResources, paramInt);
    }

    void thunkBindAllocation(Allocation paramAllocation, int paramInt) {
        android.renderscript.Allocation localAllocation = null;
        if (paramAllocation != null) {
            localAllocation = ((AllocationThunker) paramAllocation).mN;
        }
        try {
            bindAllocation(localAllocation, paramInt);
            return;
        } catch (RSRuntimeException paramAllocation) {
            throw ExceptionThunker.convertException(paramAllocation);
        }
    }

    Script.FieldID thunkCreateFieldID(int paramInt, Element paramElement) {
        try {
            paramElement = createFieldID(paramInt, ((ElementThunker) paramElement).getNObj());
            return paramElement;
        } catch (RSRuntimeException paramElement) {
            throw ExceptionThunker.convertException(paramElement);
        }
    }

    Script.KernelID thunkCreateKernelID(int paramInt1, int paramInt2, Element paramElement1, Element paramElement2) {
        android.renderscript.Element localElement = null;
        if (paramElement1 != null) {
        }
        for (paramElement1 = ((ElementThunker) paramElement1).mN; ; paramElement1 = null) {
            if (paramElement2 != null) {
                localElement = ((ElementThunker) paramElement2).mN;
            }
            try {
                paramElement1 = createKernelID(paramInt1, paramInt2, paramElement1, localElement);
                return paramElement1;
            } catch (RSRuntimeException paramElement1) {
                throw ExceptionThunker.convertException(paramElement1);
            }
        }
    }

    void thunkForEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker) {
        android.renderscript.FieldPacker localFieldPacker = null;
        if (paramAllocation1 != null) {
        }
        for (paramAllocation1 = ((AllocationThunker) paramAllocation1).mN; ; paramAllocation1 = null) {
            if (paramAllocation2 != null) {
            }
            for (paramAllocation2 = ((AllocationThunker) paramAllocation2).mN; ; paramAllocation2 = null) {
                if (paramFieldPacker != null) {
                }
                try {
                    localFieldPacker = new android.renderscript.FieldPacker(paramFieldPacker.getData());
                    forEach(paramInt, paramAllocation1, paramAllocation2, localFieldPacker);
                    return;
                } catch (RSRuntimeException paramAllocation1) {
                    throw ExceptionThunker.convertException(paramAllocation1);
                }
            }
        }
    }

    void thunkForEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker, Script.LaunchOptions paramLaunchOptions) {
        Object localObject = null;
        if (paramLaunchOptions != null) {
        }
        for (; ; ) {
            try {
                android.renderscript.Script.LaunchOptions localLaunchOptions2 = new android.renderscript.Script.LaunchOptions();
                if (paramLaunchOptions.getXEnd() > 0) {
                    localLaunchOptions2.setX(paramLaunchOptions.getXStart(), paramLaunchOptions.getXEnd());
                }
                if (paramLaunchOptions.getYEnd() > 0) {
                    localLaunchOptions2.setY(paramLaunchOptions.getYStart(), paramLaunchOptions.getYEnd());
                }
                localLaunchOptions1 = localLaunchOptions2;
                if (paramLaunchOptions.getZEnd() > 0) {
                    localLaunchOptions2.setZ(paramLaunchOptions.getZStart(), paramLaunchOptions.getZEnd());
                    localLaunchOptions1 = localLaunchOptions2;
                }
                if (paramAllocation1 == null) {
                    break label167;
                }
                paramAllocation1 = ((AllocationThunker) paramAllocation1).mN;
                if (paramAllocation2 != null) {
                    paramAllocation2 = ((AllocationThunker) paramAllocation2).mN;
                    paramLaunchOptions = (Script.LaunchOptions) localObject;
                    if (paramFieldPacker != null) {
                        paramLaunchOptions = new android.renderscript.FieldPacker(paramFieldPacker.getData());
                    }
                    forEach(paramInt, paramAllocation1, paramAllocation2, paramLaunchOptions, localLaunchOptions1);
                    return;
                }
            } catch (RSRuntimeException paramAllocation1) {
                throw ExceptionThunker.convertException(paramAllocation1);
            }
            paramAllocation2 = null;
            continue;
            label167:
            paramAllocation1 = null;
            continue;
            android.renderscript.Script.LaunchOptions localLaunchOptions1 = null;
        }
    }

    void thunkInvoke(int paramInt) {
        try {
            invoke(paramInt);
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    void thunkInvoke(int paramInt, FieldPacker paramFieldPacker) {
        try {
            invoke(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()));
            return;
        } catch (RSRuntimeException paramFieldPacker) {
            throw ExceptionThunker.convertException(paramFieldPacker);
        }
    }

    void thunkSetTimeZone(String paramString) {
        try {
            setTimeZone(paramString);
            return;
        } catch (RSRuntimeException paramString) {
            throw ExceptionThunker.convertException(paramString);
        }
    }

    void thunkSetVar(int paramInt, double paramDouble) {
        try {
            setVar(paramInt, paramDouble);
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    void thunkSetVar(int paramInt, float paramFloat) {
        try {
            setVar(paramInt, paramFloat);
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    void thunkSetVar(int paramInt1, int paramInt2) {
        try {
            setVar(paramInt1, paramInt2);
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    void thunkSetVar(int paramInt, long paramLong) {
        try {
            setVar(paramInt, paramLong);
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }

    void thunkSetVar(int paramInt, BaseObj paramBaseObj) {
        if (paramBaseObj == null) {
            try {
                setVar(paramInt, 0);
                return;
            } catch (RSRuntimeException paramBaseObj) {
                throw ExceptionThunker.convertException(paramBaseObj);
            }
        }
        try {
            setVar(paramInt, paramBaseObj.getNObj());
            return;
        } catch (RSRuntimeException paramBaseObj) {
            throw ExceptionThunker.convertException(paramBaseObj);
        }
    }

    void thunkSetVar(int paramInt, FieldPacker paramFieldPacker) {
        try {
            setVar(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()));
            return;
        } catch (RSRuntimeException paramFieldPacker) {
            throw ExceptionThunker.convertException(paramFieldPacker);
        }
    }

    void thunkSetVar(int paramInt, FieldPacker paramFieldPacker, Element paramElement, int[] paramArrayOfInt) {
        try {
            setVar(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()), ((ElementThunker) paramElement).mN, paramArrayOfInt);
            return;
        } catch (RSRuntimeException paramFieldPacker) {
            throw ExceptionThunker.convertException(paramFieldPacker);
        }
    }

    void thunkSetVar(int paramInt, boolean paramBoolean) {
        try {
            setVar(paramInt, paramBoolean);
            return;
        } catch (RSRuntimeException localRSRuntimeException) {
            throw ExceptionThunker.convertException(localRSRuntimeException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ScriptCThunker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */