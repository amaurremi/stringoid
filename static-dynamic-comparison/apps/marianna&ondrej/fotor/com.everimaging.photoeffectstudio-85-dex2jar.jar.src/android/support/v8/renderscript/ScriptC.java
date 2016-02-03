package android.support.v8.renderscript;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ScriptC
        extends Script {
    private static final String TAG = "ScriptC";

    protected ScriptC(int paramInt, RenderScript paramRenderScript) {
        super(paramInt, paramRenderScript);
    }

    protected ScriptC(RenderScript paramRenderScript, Resources paramResources, int paramInt) {
        super(0, paramRenderScript);
        if (RenderScript.isNative) {
            this.mT = new ScriptCThunker((RenderScriptThunker) paramRenderScript, paramResources, paramInt);
            return;
        }
        paramInt = internalCreate(paramRenderScript, paramResources, paramInt);
        if (paramInt == 0) {
            throw new RSRuntimeException("Loading of ScriptC script failed.");
        }
        setID(paramInt);
    }

    private static int internalCreate(RenderScript paramRenderScript, Resources paramResources, int paramInt) {
        try {
            InputStream localInputStream = paramResources.openRawResource(paramInt);
            for (; ; ) {
                try {
                    localObject = new byte['Ѐ'];
                    i = 0;
                    j = localObject.length - i;
                    if (j != 0) {
                        break label144;
                    }
                    byte[] arrayOfByte = new byte[localObject.length * 2];
                    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
                    j = arrayOfByte.length - i;
                    localObject = arrayOfByte;
                    j = localInputStream.read((byte[]) localObject, i, j);
                    if (j > 0) {
                    }
                } finally {
                    Object localObject;
                    int i;
                    int j;
                    localInputStream.close();
                }
                try {
                    localInputStream.close();
                    paramInt = paramRenderScript.nScriptCCreate(paramResources.getResourceEntryName(paramInt), paramRenderScript.getApplicationContext().getCacheDir().toString(), (byte[]) localObject, i);
                    return paramInt;
                } catch (IOException paramRenderScript) {
                    throw new Resources.NotFoundException();
                }
                i = j + i;
            }
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v8/renderscript/ScriptC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */