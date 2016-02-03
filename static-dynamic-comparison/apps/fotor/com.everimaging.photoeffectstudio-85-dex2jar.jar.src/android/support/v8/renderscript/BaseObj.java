package android.support.v8.renderscript;

public class BaseObj {
    private boolean mDestroyed;
    private int mID;
    RenderScript mRS;

    BaseObj(int paramInt, RenderScript paramRenderScript) {
        paramRenderScript.validate();
        this.mRS = paramRenderScript;
        this.mID = paramInt;
        this.mDestroyed = false;
    }

    void checkValid() {
        if ((this.mID == 0) && (getNObj() == null)) {
            throw new RSIllegalArgumentException("Invalid object.");
        }
    }

    public void destroy() {
        try {
            if (this.mDestroyed) {
                throw new RSInvalidStateException("Object already destroyed.");
            }
        } finally {
        }
        this.mDestroyed = true;
        this.mRS.nObjDestroy(this.mID);
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (getClass() != paramObject.getClass()) {
                return false;
            }
            paramObject = (BaseObj) paramObject;
        } while (this.mID == ((BaseObj) paramObject).mID);
        return false;
    }

    protected void finalize()
            throws Throwable {
        if (!this.mDestroyed) {
            if ((this.mID != 0) && (this.mRS.isAlive())) {
                this.mRS.nObjDestroy(this.mID);
            }
            this.mRS = null;
            this.mID = 0;
            this.mDestroyed = true;
        }
        super.finalize();
    }

    int getID(RenderScript paramRenderScript) {
        this.mRS.validate();
        if (RenderScript.isNative) {
            RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker) paramRenderScript;
            if (getNObj() != null) {
                return getNObj().hashCode();
            }
        }
        if (this.mDestroyed) {
            throw new RSInvalidStateException("using a destroyed object.");
        }
        if (this.mID == 0) {
            throw new RSRuntimeException("Internal error: Object id 0.");
        }
        if ((paramRenderScript != null) && (paramRenderScript != this.mRS)) {
            throw new RSInvalidStateException("using object with mismatched context.");
        }
        return this.mID;
    }

    android.renderscript.BaseObj getNObj() {
        return null;
    }

    public int hashCode() {
        return this.mID;
    }

    void setID(int paramInt) {
        if (this.mID != 0) {
            throw new RSRuntimeException("Internal Error, reset of object ID.");
        }
        this.mID = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/BaseObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */