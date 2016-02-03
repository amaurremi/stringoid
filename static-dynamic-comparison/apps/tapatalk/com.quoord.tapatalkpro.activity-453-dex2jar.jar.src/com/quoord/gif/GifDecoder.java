package com.quoord.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class GifDecoder {
    private static final int MaxStackSize = 4096;
    public static final int STATUS_FINISH = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARSING = 0;
    private ArrayList<Bitmap> _clearBmps = new ArrayList();
    private int[] act;
    private GifAction action = null;
    private int bgColor;
    private int bgIndex;
    private byte[] block = new byte['Ā'];
    private int blockSize = 0;
    private GifFrame currentFrame = null;
    private Bitmap currentimage;
    private int delay = 0;
    private int dispose = 0;
    private int frameCount;
    private int[] gct;
    private boolean gctFlag;
    private int gctSize;
    private byte[] gifData = null;
    private GifFrame gifFrame;
    public int height;
    private int ih;
    private InputStream in;
    private boolean interlace;
    private boolean isShow = false;
    private int iw;
    private int ix;
    private int iy;
    private int lastBgColor;
    private int lastDispose = 0;
    private Bitmap lastImage;
    private int[] lct;
    private boolean lctFlag;
    private int lctSize;
    private int loopCount = 1;
    private int lrh;
    private int lrw;
    private int lrx;
    private int lry;
    private int maxHeight = 90;
    private int maxWidth = 90;
    private int pixelAspect;
    private byte[] pixelStack;
    private byte[] pixels;
    private short[] prefix;
    private int status;
    private byte[] suffix;
    private int transIndex;
    private boolean transparency = false;
    public int width;

    public GifDecoder(InputStream paramInputStream, GifAction paramGifAction) {
        this.in = paramInputStream;
        this.action = paramGifAction;
    }

    public GifDecoder(byte[] paramArrayOfByte, GifAction paramGifAction) {
        this.gifData = paramArrayOfByte;
        this.action = paramGifAction;
    }

    private void decodeImageData() {
        int i11 = this.iw * this.ih;
        if ((this.pixels == null) || (this.pixels.length < i11)) {
            this.pixels = new byte[i11];
        }
        if (this.prefix == null) {
            this.prefix = new short['က'];
        }
        if (this.suffix == null) {
            this.suffix = new byte['က'];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte['ခ'];
        }
        int i12 = read();
        int i13 = 1 << i12;
        int i6 = i13 + 2;
        int i1 = -1;
        int m = i12 + 1;
        int k = (1 << m) - 1;
        int i = 0;
        int i5;
        int i7;
        int i4;
        int i2;
        int i8;
        int i3;
        if (i >= i13) {
            i5 = 0;
            i7 = 0;
            i4 = 0;
            n = 0;
            i2 = 0;
            i8 = 0;
            i3 = 0;
            j = 0;
            i = i1;
            i1 = i2;
        }
        label156:
        label163:
        label230:
        label271:
        int i10;
        int i9;
        for (; ; ) {
            if (i8 >= i11) {
            }
            do {
                do {
                    if (i3 < i11) {
                        break label621;
                    }
                    return;
                    this.prefix[i] = 0;
                    this.suffix[i] = ((byte) i);
                    i += 1;
                    break;
                    if (j != 0) {
                        break label638;
                    }
                    if (n >= m) {
                        break label271;
                    }
                    i2 = i4;
                    if (i4 != 0) {
                        break label230;
                    }
                    i2 = readBlock();
                } while (i2 <= 0);
                i5 = 0;
                i1 += ((this.block[i5] & 0xFF) << n);
                n += 8;
                i5 += 1;
                i4 = i2 - 1;
                break label156;
                i2 = i1 & k;
                i10 = i1 >> m;
                i9 = n - m;
            } while ((i2 > i6) || (i2 == i13 + 1));
            if (i2 == i13) {
                m = i12 + 1;
                k = (1 << m) - 1;
                i6 = i13 + 2;
                i = -1;
                n = i9;
                i1 = i10;
            } else {
                if (i != -1) {
                    break label389;
                }
                this.pixelStack[j] = this.suffix[i2];
                i = i2;
                j += 1;
                n = i9;
                i1 = i10;
                i7 = i2;
            }
        }
        label389:
        int n = i2;
        i1 = j;
        if (i2 == i6) {
            this.pixelStack[j] = ((byte) i7);
            n = i;
            i1 = j + 1;
        }
        for (; ; ) {
            if (n <= i13) {
                i7 = this.suffix[n] & 0xFF;
                if (i6 < 4096) {
                    break label483;
                }
                break;
            }
            this.pixelStack[i1] = this.suffix[n];
            n = this.prefix[n];
            i1 += 1;
        }
        label483:
        byte[] arrayOfByte = this.pixelStack;
        n = i1 + 1;
        arrayOfByte[i1] = ((byte) i7);
        this.prefix[i6] = ((short) i);
        this.suffix[i6] = ((byte) i7);
        i6 += 1;
        i = k;
        int j = m;
        if ((i6 & k) == 0) {
            i = k;
            j = m;
            if (i6 < 4096) {
                j = m + 1;
                i = k + i6;
            }
        }
        m = n;
        i1 = i10;
        k = i;
        n = i9;
        for (; ; ) {
            i9 = m - 1;
            this.pixels[i3] = this.pixelStack[i9];
            i8 += 1;
            i3 += 1;
            m = j;
            i = i2;
            j = i9;
            break;
            label621:
            this.pixels[i3] = 0;
            i3 += 1;
            break label163;
            label638:
            i9 = j;
            j = m;
            i2 = i;
            m = i9;
        }
    }

    private boolean err() {
        return this.status != 0;
    }

    private void init() {
        this.status = 0;
        this.frameCount = 0;
        this.gifFrame = null;
        this.gct = null;
        this.lct = null;
    }

    private int read() {
        try {
            int i = this.in.read();
            return i;
        } catch (Exception localException) {
            this.status = 1;
        }
        return 0;
    }

    private int readBlock() {
        this.blockSize = read();
        int j = 0;
        int i = 0;
        if (this.blockSize > 0) {
        }
        for (; ; ) {
            try {
                j = this.blockSize;
                if (i < j) {
                    continue;
                }
            } catch (Exception localException) {
                localException.printStackTrace();
                continue;
            }
            j = i;
            if (i < this.blockSize) {
                this.status = 1;
                j = i;
            }
            return j;
            j = this.in.read(this.block, i, this.blockSize - i);
            if (j != -1) {
                i += j;
            }
        }
    }

    private int readByte() {
        this.in = new ByteArrayInputStream(this.gifData);
        this.gifData = null;
        return readStream();
    }

    private int[] readColorTable(int paramInt) {
        int k = paramInt * 3;
        Object localObject = null;
        byte[] arrayOfByte = new byte[k];
        int i = 0;
        int j;
        try {
            j = this.in.read(arrayOfByte);
            i = j;
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
            arrayOfInt = new int['Ā'];
            j = 0;
            i = 0;
        }
        if (i < k) {
            this.status = 1;
            return (int[]) localObject;
        }
        for (; ; ) {
            int[] arrayOfInt;
            localObject = arrayOfInt;
            if (i >= paramInt) {
                break;
            }
            k = j + 1;
            j = arrayOfByte[j];
            int m = k + 1;
            arrayOfInt[i] = (0xFF000000 | (j & 0xFF) << 16 | (arrayOfByte[k] & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
            j = m + 1;
            i += 1;
        }
    }

    private void readContents() {
        int i = 0;
        if ((i != 0) || (err())) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this._clearBmps.size()) {
                this.currentimage = null;
                this.lastImage = null;
                return;
                switch (read()) {
                    case 0:
                    default:
                        this.status = 1;
                        break;
                    case 44:
                        readImage();
                        break;
                    case 33:
                        switch (read()) {
                            default:
                                skip();
                                break;
                            case 249:
                                readGraphicControlExt();
                                break;
                            case 255:
                                readBlock();
                                localObject = "";
                                int j = 0;
                                for (; ; ) {
                                    if (j >= 11) {
                                        if (!((String) localObject).equals("NETSCAPE2.0")) {
                                            break label206;
                                        }
                                        readNetscapeExt();
                                        break;
                                    }
                                    localObject = localObject + (char) this.block[j];
                                    j += 1;
                                }
                                skip();
                        }
                        break;
                    case 59:
                        label206:
                        i = 1;
                        break;
                }
            }
            Object localObject = (Bitmap) this._clearBmps.get(i);
            if ((localObject != null) && (!((Bitmap) localObject).isRecycled())) {
                ((Bitmap) localObject).recycle();
            }
            i += 1;
        }
    }

    private void readGraphicControlExt() {
        boolean bool = true;
        read();
        int i = read();
        this.dispose = ((i & 0x1C) >> 2);
        if (this.dispose == 0) {
            this.dispose = 1;
        }
        if ((i & 0x1) != 0) {
        }
        for (; ; ) {
            this.transparency = bool;
            this.delay = (readShort() * 10);
            if (this.delay < 100) {
                this.delay = 100;
            }
            this.transIndex = read();
            read();
            return;
            bool = false;
        }
    }

    private void readHeader() {
        String str = "";
        int i = 0;
        if (i >= 6) {
            if (str.startsWith("GIF")) {
                break label56;
            }
            this.status = 1;
        }
        label56:
        do {
            return;
            str = str + (char) read();
            i += 1;
            break;
            readLSD();
        } while ((!this.gctFlag) || (err()));
        this.gct = readColorTable(this.gctSize);
        this.bgColor = this.gct[this.bgIndex];
    }

    private void readImage() {
        this.ix = readShort();
        this.iy = readShort();
        this.iw = readShort();
        this.ih = readShort();
        int i = read();
        boolean bool;
        if ((i & 0x80) != 0) {
            bool = true;
            this.lctFlag = bool;
            if ((i & 0x40) == 0) {
                break label157;
            }
            bool = true;
            label61:
            this.interlace = bool;
            this.lctSize = (2 << (i & 0x7));
            if (!this.lctFlag) {
                break label162;
            }
            this.lct = readColorTable(this.lctSize);
            this.act = this.lct;
            label103:
            i = 0;
            if (this.transparency) {
                i = this.act[this.transIndex];
                this.act[this.transIndex] = 0;
            }
            if (this.act == null) {
                this.status = 1;
            }
            if (!err()) {
                break label189;
            }
        }
        label157:
        label162:
        label189:
        do {
            return;
            bool = false;
            break;
            bool = false;
            break label61;
            this.act = this.gct;
            if (this.bgIndex != this.transIndex) {
                break label103;
            }
            this.bgColor = 0;
            break label103;
            decodeImageData();
            skip();
        } while (err());
        this.frameCount += 1;
        this.currentimage = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
        setPixels();
        Bitmap localBitmap;
        if ((this.width > this.maxWidth) && (this.height > this.maxWidth)) {
            localBitmap = Bitmap.createScaledBitmap(this.currentimage, 90, 90, true);
            if (this.gifFrame == null) {
                this.gifFrame = new GifFrame(localBitmap, this.delay);
                this.currentFrame = this.gifFrame;
                this._clearBmps.add(this.currentimage);
            }
        }
        for (; ; ) {
            if (this.transparency) {
                this.act[this.transIndex] = i;
            }
            resetFrame();
            this.action.parseOk(true, this.frameCount);
            return;
            for (localGifFrame = this.gifFrame; ; localGifFrame = localGifFrame.nextFrame) {
                if (localGifFrame.nextFrame == null) {
                    localGifFrame.nextFrame = new GifFrame(localBitmap, this.delay);
                    break;
                }
            }
            if (this.gifFrame != null) {
                break label429;
            }
            this.gifFrame = new GifFrame(this.currentimage, this.delay);
            this.currentFrame = this.gifFrame;
        }
        label429:
        for (GifFrame localGifFrame = this.gifFrame; ; localGifFrame = localGifFrame.nextFrame) {
            if (localGifFrame.nextFrame == null) {
                localGifFrame.nextFrame = new GifFrame(this.currentimage, this.delay);
                break;
            }
        }
    }

    private void readLSD() {
        this.width = readShort();
        this.height = readShort();
        int i = read();
        if ((i & 0x80) != 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.gctFlag = bool;
            this.gctSize = (2 << (i & 0x7));
            this.bgIndex = read();
            this.pixelAspect = read();
            return;
        }
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            if (this.block[0] == 1) {
                int i = this.block[1];
                this.loopCount = ((this.block[2] & 0xFF) << 8 | i & 0xFF);
            }
        } while ((this.blockSize > 0) && (!err()));
    }

    private int readShort() {
        return read() | read() << 8;
    }

    private int readStream() {
        init();
        if (this.in != null) {
            readHeader();
            if (!err()) {
                readContents();
                if (this.frameCount < 0) {
                    this.status = 1;
                    this.action.parseOk(false, -1);
                }
            }
        }
        for (; ; ) {
            try {
                this.in.close();
                return this.status;
                this.status = -1;
                this.action.parseOk(true, -1);
                continue;
                this.action.parseOk(false, -1);
                continue;
            } catch (Exception localException) {
                localException.printStackTrace();
                continue;
            }
            this.status = 2;
            this.action.parseOk(false, -1);
        }
    }

    private void resetFrame() {
        this.lastDispose = this.dispose;
        this.lrx = this.ix;
        this.lry = this.iy;
        this.lrw = this.iw;
        this.lrh = this.ih;
        this.lastImage = this.currentimage;
        this.lastBgColor = this.bgColor;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.lct = null;
    }

    private void setPixels() {
        int[] arrayOfInt = new int[this.width * this.height];
        if (this.lastDispose > 0) {
            if (this.lastDispose == 3) {
                i = this.frameCount - 2;
                if (i <= 0) {
                    break label176;
                }
                this.lastImage = getFrameImage(i - 1);
            }
            if (this.lastImage != null) {
                if ((this.width <= this.maxWidth) || (this.height <= this.maxHeight)) {
                    break label239;
                }
                this.lastImage.getPixels(arrayOfInt, 0, this.maxWidth, 0, 0, this.maxWidth, this.maxHeight);
                if (this.lastDispose == 2) {
                    i = 0;
                    if (!this.transparency) {
                        i = this.lastBgColor;
                    }
                    j = 0;
                    if (j < this.lrh) {
                        break label184;
                    }
                }
            }
        }
        int n;
        int m;
        int i1;
        int k;
        label176:
        label184:
        label239:
        do {
            n = 1;
            m = 8;
            i1 = 0;
            k = 0;
            if (k < this.ih) {
                break label350;
            }
            this.currentimage = Bitmap.createBitmap(arrayOfInt, this.width, this.height, Bitmap.Config.ARGB_4444);
            return;
            this.lastImage = null;
            break;
            m = (this.lry + j) * this.maxWidth + this.lrx;
            n = this.lrw;
            k = m;
            for (; ; ) {
                if (k >= m + n) {
                    j += 1;
                    break;
                }
                arrayOfInt[k] = i;
                k += 1;
            }
            this.lastImage.getPixels(arrayOfInt, 0, this.width, 0, 0, this.width, this.height);
        } while (this.lastDispose != 2);
        int i = 0;
        if (!this.transparency) {
            i = this.lastBgColor;
        }
        int j = 0;
        label287:
        if (j < this.lrh) {
            m = (this.lry + j) * this.width + this.lrx;
            n = this.lrw;
            k = m;
        }
        for (; ; ) {
            if (k >= m + n) {
                j += 1;
                break label287;
                break;
            }
            arrayOfInt[k] = i;
            k += 1;
        }
        label350:
        int i3 = k;
        i = i1;
        j = m;
        int i2 = n;
        if (this.interlace) {
            i = i1;
            j = m;
            i2 = n;
            if (i1 >= this.ih) {
                i2 = n + 1;
            }
        }
        switch (i2) {
            default:
                j = m;
                i = i1;
                label430:
                i3 = i;
                i += j;
                m = i3 + this.iy;
                if (m < this.height) {
                    i3 = m * this.width;
                    i1 = i3 + this.ix;
                    n = i1 + this.iw;
                    m = n;
                    if (this.width + i3 < n) {
                        m = i3 + this.width;
                    }
                    n = k * this.iw;
                }
                break;
        }
        for (; ; ) {
            if (i1 >= m) {
                k += 1;
                i1 = i;
                m = j;
                n = i2;
                break;
                i = 4;
                j = m;
                break label430;
                i = 2;
                j = 4;
                break label430;
                i = 1;
                j = 2;
                break label430;
            }
            i3 = this.pixels[n];
            i3 = this.act[(i3 & 0xFF)];
            if (i3 != 0) {
                arrayOfInt[i1] = i3;
            }
            i1 += 1;
            n += 1;
        }
    }

    private void skip() {
        do {
            readBlock();
        } while ((this.blockSize > 0) && (!err()));
    }

    public void free() {
        GifFrame localGifFrame = this.gifFrame;
        for (; ; ) {
            if ((localGifFrame != null) || (this.in != null)) {
            }
            try {
                this.in.close();
                this.in = null;
                this.gifData = null;
                this.pixels = null;
                System.gc();
                return;
                if (!localGifFrame.image.isRecycled()) {
                    localGifFrame.image.recycle();
                }
                localGifFrame.image = null;
                this.gifFrame = this.gifFrame.nextFrame;
                localGifFrame = this.gifFrame;
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
        }
    }

    public GifFrame getCurrentFrame() {
        return this.currentFrame;
    }

    public int getDelay(int paramInt) {
        this.delay = -1;
        if ((paramInt >= 0) && (paramInt < this.frameCount)) {
            GifFrame localGifFrame = getFrame(paramInt);
            if (localGifFrame != null) {
                this.delay = localGifFrame.delay;
            }
        }
        return this.delay;
    }

    public int[] getDelays() {
        GifFrame localGifFrame = this.gifFrame;
        int[] arrayOfInt = new int[this.frameCount];
        int i = 0;
        for (; ; ) {
            if ((localGifFrame == null) || (i >= this.frameCount)) {
                return arrayOfInt;
            }
            arrayOfInt[i] = localGifFrame.delay;
            localGifFrame = localGifFrame.nextFrame;
            i += 1;
        }
    }

    public GifFrame getFrame(int paramInt) {
        GifFrame localGifFrame1 = this.gifFrame;
        int i = 0;
        for (; ; ) {
            GifFrame localGifFrame2;
            if (localGifFrame1 == null) {
                localGifFrame2 = null;
            }
            do {
                return localGifFrame2;
                localGifFrame2 = localGifFrame1;
            } while (i == paramInt);
            localGifFrame1 = localGifFrame1.nextFrame;
            i += 1;
        }
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public Bitmap getFrameImage(int paramInt) {
        GifFrame localGifFrame = getFrame(paramInt);
        if (localGifFrame == null) {
            return null;
        }
        return localGifFrame.image;
    }

    public Bitmap getImage() {
        return getFrameImage(0);
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public int getStatus() {
        return this.status;
    }

    public GifFrame next() {
        if (!this.isShow) {
            this.isShow = true;
            return this.gifFrame;
        }
        if (this.status == 0) {
            if (this.currentFrame.nextFrame != null) {
                this.currentFrame = this.currentFrame.nextFrame;
            }
        }
        for (; ; ) {
            return this.currentFrame;
            this.currentFrame = this.currentFrame.nextFrame;
            if (this.currentFrame == null) {
                this.currentFrame = this.gifFrame;
            }
        }
    }

    public boolean parseOk() {
        return this.status == -1;
    }

    public void reset() {
        this.currentFrame = this.gifFrame;
    }

    public void run() {
        if (this.in != null) {
            readStream();
        }
        while (this.gifData == null) {
            return;
        }
        readByte();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/gif/GifDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */