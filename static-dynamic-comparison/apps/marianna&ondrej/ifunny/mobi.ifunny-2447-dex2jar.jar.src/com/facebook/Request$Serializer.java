package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.facebook.internal.Logger;

import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

class Request$Serializer
        implements Request.KeyValueSerializer {
    private boolean firstWrite = true;
    private final Logger logger;
    private final OutputStream outputStream;

    public Request$Serializer(OutputStream paramOutputStream, Logger paramLogger) {
        this.outputStream = paramOutputStream;
        this.logger = paramLogger;
    }

    public void write(String paramString, Object... paramVarArgs) {
        if (this.firstWrite) {
            this.outputStream.write("--".getBytes());
            this.outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
            this.outputStream.write("\r\n".getBytes());
            this.firstWrite = false;
        }
        this.outputStream.write(String.format(paramString, paramVarArgs).getBytes());
    }

    public void writeBitmap(String paramString, Bitmap paramBitmap) {
        writeContentDisposition(paramString, paramString, "image/png");
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
        writeLine("", new Object[0]);
        writeRecordBoundary();
        if (this.logger != null) {
            this.logger.appendKeyValue("    " + paramString, "<Image>");
        }
    }

    public void writeBytes(String paramString, byte[] paramArrayOfByte) {
        writeContentDisposition(paramString, paramString, "content/unknown");
        this.outputStream.write(paramArrayOfByte);
        writeLine("", new Object[0]);
        writeRecordBoundary();
        if (this.logger != null) {
            this.logger.appendKeyValue("    " + paramString, String.format("<Data: %d>", new Object[]{Integer.valueOf(paramArrayOfByte.length)}));
        }
    }

    public void writeContentDisposition(String paramString1, String paramString2, String paramString3) {
        write("Content-Disposition: form-data; name=\"%s\"", new Object[]{paramString1});
        if (paramString2 != null) {
            write("; filename=\"%s\"", new Object[]{paramString2});
        }
        writeLine("", new Object[0]);
        if (paramString3 != null) {
            writeLine("%s: %s", new Object[]{"Content-Type", paramString3});
        }
        writeLine("", new Object[0]);
    }

    public void writeFile(String paramString1, ParcelFileDescriptor paramParcelFileDescriptor, String paramString2) {
        Object localObject2 = null;
        localObject1 = paramString2;
        if (paramString2 == null) {
            localObject1 = "content/unknown";
        }
        writeContentDisposition(paramString1, paramString1, (String) localObject1);
        int j;
        if ((this.outputStream instanceof ProgressNoopOutputStream)) {
            ((ProgressNoopOutputStream) this.outputStream).addProgress(paramParcelFileDescriptor.getStatSize());
            j = 0;
            label49:
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + paramString1, String.format("<Data: %d>", new Object[]{Integer.valueOf(j)}));
            }
            return;
        }
        try {
            paramParcelFileDescriptor = new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor);
        } finally {
            try {
                paramString2 = new BufferedInputStream(paramParcelFileDescriptor);
            } finally {
                int i;
                label142:
                label211:
                localObject1 = null;
                paramString2 = paramParcelFileDescriptor;
                paramParcelFileDescriptor = (ParcelFileDescriptor) localObject1;
            }
            try {
                localObject1 = new byte[' '];
                i = 0;
                j = paramString2.read((byte[]) localObject1);
                if (j != -1) {
                    this.outputStream.write((byte[]) localObject1, 0, j);
                    i += j;
                    break label142;
                }
                if (paramString2 != null) {
                    paramString2.close();
                }
                j = i;
                if (paramParcelFileDescriptor == null) {
                    break label49;
                }
                paramParcelFileDescriptor.close();
                j = i;
                break label49;
            } finally {
                localObject1 = paramParcelFileDescriptor;
                paramParcelFileDescriptor = paramString2;
                paramString2 = (String) localObject1;
                break label211;
            }
            paramString1 =finally;
            paramParcelFileDescriptor = null;
            paramString2 = (String) localObject2;
            if (paramParcelFileDescriptor != null) {
                paramParcelFileDescriptor.close();
            }
            if (paramString2 != null) {
                paramString2.close();
            }
            throw paramString1;
        }
    }

    public void writeFile(String paramString, Request.ParcelFileDescriptorWithMimeType paramParcelFileDescriptorWithMimeType) {
        writeFile(paramString, paramParcelFileDescriptorWithMimeType.getFileDescriptor(), paramParcelFileDescriptorWithMimeType.getMimeType());
    }

    public void writeLine(String paramString, Object... paramVarArgs) {
        write(paramString, paramVarArgs);
        write("\r\n", new Object[0]);
    }

    public void writeObject(String paramString, Object paramObject, Request paramRequest) {
        if ((this.outputStream instanceof RequestOutputStream)) {
            ((RequestOutputStream) this.outputStream).setCurrentRequest(paramRequest);
        }
        if (Request.access$100(paramObject)) {
            writeString(paramString, Request.access$200(paramObject));
            return;
        }
        if ((paramObject instanceof Bitmap)) {
            writeBitmap(paramString, (Bitmap) paramObject);
            return;
        }
        if ((paramObject instanceof byte[])) {
            writeBytes(paramString, (byte[]) paramObject);
            return;
        }
        if ((paramObject instanceof ParcelFileDescriptor)) {
            writeFile(paramString, (ParcelFileDescriptor) paramObject, null);
            return;
        }
        if ((paramObject instanceof Request.ParcelFileDescriptorWithMimeType)) {
            writeFile(paramString, (Request.ParcelFileDescriptorWithMimeType) paramObject);
            return;
        }
        throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
    }

    public void writeRecordBoundary() {
        writeLine("--%s", new Object[]{"3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"});
    }

    public void writeRequestsAsJson(String paramString, JSONArray paramJSONArray, Collection<Request> paramCollection) {
        if (!(this.outputStream instanceof RequestOutputStream)) {
            writeString(paramString, paramJSONArray.toString());
        }
        do {
            return;
            RequestOutputStream localRequestOutputStream = (RequestOutputStream) this.outputStream;
            writeContentDisposition(paramString, null, null);
            write("[", new Object[0]);
            paramCollection = paramCollection.iterator();
            int i = 0;
            if (paramCollection.hasNext()) {
                Request localRequest = (Request) paramCollection.next();
                JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
                localRequestOutputStream.setCurrentRequest(localRequest);
                if (i > 0) {
                    write(",%s", new Object[]{localJSONObject.toString()});
                }
                for (; ; ) {
                    i += 1;
                    break;
                    write("%s", new Object[]{localJSONObject.toString()});
                }
            }
            write("]", new Object[0]);
        } while (this.logger == null);
        this.logger.appendKeyValue("    " + paramString, paramJSONArray.toString());
    }

    public void writeString(String paramString1, String paramString2) {
        writeContentDisposition(paramString1, null, null);
        writeLine("%s", new Object[]{paramString2});
        writeRecordBoundary();
        if (this.logger != null) {
            this.logger.appendKeyValue("    " + paramString1, paramString2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Request$Serializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */