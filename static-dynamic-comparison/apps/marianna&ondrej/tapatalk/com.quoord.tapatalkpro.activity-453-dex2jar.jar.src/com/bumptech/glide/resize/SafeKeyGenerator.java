package com.bumptech.glide.resize;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.bumptech.glide.resize.load.Downsampler;
import com.bumptech.glide.resize.load.Transformation;
import com.bumptech.glide.util.Util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SafeKeyGenerator {
    private final ByteBuffer byteBuffer = ByteBuffer.allocate(8);
    private final LoadIdPool loadIdPool = new LoadIdPool();
    private final Map<LoadId, String> loadIdToSafeHash = new HashMap();
    private MessageDigest messageDigest;

    public SafeKeyGenerator() {
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
            return;
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        }
    }

    public String getSafeKey(String paramString, Transformation paramTransformation, Downsampler paramDownsampler, int paramInt1, int paramInt2) {
        paramDownsampler = this.loadIdPool.get(paramString, paramTransformation.getId(), paramDownsampler.getId(), paramInt1, paramInt2);
        paramString = (String) this.loadIdToSafeHash.get(paramDownsampler);
        if (paramString == null) {
            try {
                paramTransformation = paramDownsampler.generateSafeKey();
                paramString = paramTransformation;
            } catch (UnsupportedEncodingException paramTransformation) {
                for (; ; ) {
                    paramTransformation.printStackTrace();
                }
            }
            this.loadIdToSafeHash.put(paramDownsampler, paramString);
            return paramString;
        }
        this.loadIdPool.offer(paramDownsampler);
        return paramString;
    }

    private class LoadId {
        private String downsamplerId;
        private int height;
        private String id;
        private String transformationId;
        private int width;

        private LoadId() {
        }

        public boolean equals(Object paramObject) {
            if (this == paramObject) {
            }
            do {
                return true;
                if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                    return false;
                }
                paramObject = (LoadId) paramObject;
                if (this.height != ((LoadId) paramObject).height) {
                    return false;
                }
                if (this.width != ((LoadId) paramObject).width) {
                    return false;
                }
                if (!this.downsamplerId.equals(((LoadId) paramObject).downsamplerId)) {
                    return false;
                }
                if (!this.id.equals(((LoadId) paramObject).id)) {
                    return false;
                }
            } while (this.transformationId.equals(((LoadId) paramObject).transformationId));
            return false;
        }

        public String generateSafeKey()
                throws UnsupportedEncodingException {
            SafeKeyGenerator.this.messageDigest.update(this.id.getBytes("UTF-8"));
            SafeKeyGenerator.this.messageDigest.update(this.transformationId.getBytes("UTF-8"));
            SafeKeyGenerator.this.messageDigest.update(this.downsamplerId.getBytes("UTF-8"));
            SafeKeyGenerator.this.byteBuffer.position(0);
            SafeKeyGenerator.this.byteBuffer.putInt(this.width);
            SafeKeyGenerator.this.byteBuffer.putInt(this.height);
            SafeKeyGenerator.this.messageDigest.update(SafeKeyGenerator.this.byteBuffer.array());
            return Util.sha256BytesToHex(SafeKeyGenerator.this.messageDigest.digest());
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31 + this.transformationId.hashCode()) * 31 + this.downsamplerId.hashCode()) * 31 + this.width) * 31 + this.height;
        }

        public void init(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {
            this.id = paramString1;
            this.transformationId = paramString2;
            this.downsamplerId = paramString3;
            this.width = paramInt1;
            this.height = paramInt2;
        }
    }

    private class LoadIdPool {
        private static final int MAX_SIZE = 20;
        private Queue<SafeKeyGenerator.LoadId> loadIdQueue;

        @TargetApi(9)
        public LoadIdPool() {
            if (Build.VERSION.SDK_INT >= 9) {
                this.loadIdQueue = new ArrayDeque(20);
                return;
            }
            this.loadIdQueue = new LinkedList();
        }

        public SafeKeyGenerator.LoadId get(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {
            SafeKeyGenerator.LoadId localLoadId2 = (SafeKeyGenerator.LoadId) this.loadIdQueue.poll();
            SafeKeyGenerator.LoadId localLoadId1 = localLoadId2;
            if (localLoadId2 == null) {
                localLoadId1 = new SafeKeyGenerator.LoadId(SafeKeyGenerator.this, null);
            }
            localLoadId1.init(paramString1, paramString2, paramString3, paramInt1, paramInt2);
            return localLoadId1;
        }

        public void offer(SafeKeyGenerator.LoadId paramLoadId) {
            if (this.loadIdQueue.size() < 20) {
                this.loadIdQueue.offer(paramLoadId);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/SafeKeyGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */