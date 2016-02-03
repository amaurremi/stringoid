package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;

import java.util.Iterator;
import java.util.List;

class PlacementData {
    private static final int MAX_ADS = 200;
    public static final int NOT_FOUND = -1;
    private final NativeAdData[] mAdDataObjects = new NativeAdData['È'];
    private final int[] mAdjustedAdPositions = new int['È'];
    private int mDesiredCount = 0;
    private final int[] mDesiredInsertionPositions = new int['È'];
    private final int[] mDesiredOriginalPositions = new int['È'];
    private final int[] mOriginalAdPositions = new int['È'];
    private int mPlacedCount = 0;

    private PlacementData(int[] paramArrayOfInt) {
        this.mDesiredCount = Math.min(paramArrayOfInt.length, 200);
        System.arraycopy(paramArrayOfInt, 0, this.mDesiredInsertionPositions, 0, this.mDesiredCount);
        System.arraycopy(paramArrayOfInt, 0, this.mDesiredOriginalPositions, 0, this.mDesiredCount);
    }

    private static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3) {
        paramInt2 -= 1;
        while (paramInt1 <= paramInt2) {
            int i = paramInt1 + paramInt2 >>> 1;
            int j = paramArrayOfInt[i];
            if (j < paramInt3) {
                paramInt1 = i + 1;
            } else if (j > paramInt3) {
                paramInt2 = i - 1;
            } else {
                return i;
            }
        }
        return paramInt1 ^ 0xFFFFFFFF;
    }

    private static int binarySearchFirstEquals(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
        paramInt1 = binarySearch(paramArrayOfInt, 0, paramInt1, paramInt2);
        if (paramInt1 < 0) {
            return paramInt1 ^ 0xFFFFFFFF;
        }
        paramInt2 = paramArrayOfInt[paramInt1];
        while ((paramInt1 >= 0) && (paramArrayOfInt[paramInt1] == paramInt2)) {
            paramInt1 -= 1;
        }
        return paramInt1 + 1;
    }

    private static int binarySearchGreaterThan(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
        paramInt2 = binarySearch(paramArrayOfInt, 0, paramInt1, paramInt2);
        int i;
        if (paramInt2 < 0) {
            i = paramInt2 ^ 0xFFFFFFFF;
            return i;
        }
        int j = paramArrayOfInt[paramInt2];
        for (; ; ) {
            i = paramInt2;
            if (paramInt2 >= paramInt1) {
                break;
            }
            i = paramInt2;
            if (paramArrayOfInt[paramInt2] != j) {
                break;
            }
            paramInt2 += 1;
        }
    }

    static PlacementData empty() {
        return new PlacementData(new int[0]);
    }

    static PlacementData fromAdPositioning(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        int i = 0;
        Object localObject = paramMoPubClientPositioning.getFixedPositions();
        int n = paramMoPubClientPositioning.getRepeatingInterval();
        if (n == Integer.MAX_VALUE) {
        }
        int j;
        int m;
        for (int k = ((List) localObject).size(); ; k = 200) {
            paramMoPubClientPositioning = new int[k];
            localObject = ((List) localObject).iterator();
            j = 0;
            for (; ; ) {
                m = i;
                if (!((Iterator) localObject).hasNext()) {
                    break;
                }
                j = ((Integer) ((Iterator) localObject).next()).intValue() - i;
                paramMoPubClientPositioning[i] = j;
                i += 1;
            }
        }
        while (m < k) {
            j = j + n - 1;
            paramMoPubClientPositioning[m] = j;
            m += 1;
        }
        return new PlacementData(paramMoPubClientPositioning);
    }

    void clearAds() {
        if (this.mPlacedCount == 0) {
            return;
        }
        clearAdsInRange(0, this.mAdjustedAdPositions[(this.mPlacedCount - 1)] + 1);
    }

    int clearAdsInRange(int paramInt1, int paramInt2) {
        int m = 0;
        int[] arrayOfInt1 = new int[this.mPlacedCount];
        int[] arrayOfInt2 = new int[this.mPlacedCount];
        int j = 0;
        int i = 0;
        if (j < this.mPlacedCount) {
            int n = this.mOriginalAdPositions[j];
            int i1 = this.mAdjustedAdPositions[j];
            int k;
            if ((paramInt1 <= i1) && (i1 < paramInt2)) {
                arrayOfInt1[i] = n;
                arrayOfInt2[i] = (i1 - i);
                this.mAdDataObjects[j].getAd().destroy();
                this.mAdDataObjects[j] = null;
                k = i + 1;
            }
            for (; ; ) {
                j += 1;
                i = k;
                break;
                k = i;
                if (i > 0) {
                    k = j - i;
                    this.mOriginalAdPositions[k] = n;
                    this.mAdjustedAdPositions[k] = (i1 - i);
                    this.mAdDataObjects[k] = this.mAdDataObjects[j];
                    k = i;
                }
            }
        }
        if (i == 0) {
            return 0;
        }
        paramInt1 = arrayOfInt2[0];
        j = binarySearchFirstEquals(this.mDesiredInsertionPositions, this.mDesiredCount, paramInt1);
        paramInt1 = this.mDesiredCount - 1;
        for (; ; ) {
            paramInt2 = m;
            if (paramInt1 < j) {
                break;
            }
            this.mDesiredOriginalPositions[(paramInt1 + i)] = this.mDesiredOriginalPositions[paramInt1];
            this.mDesiredInsertionPositions[(paramInt1 + i)] = (this.mDesiredInsertionPositions[paramInt1] - i);
            paramInt1 -= 1;
        }
        while (paramInt2 < i) {
            this.mDesiredOriginalPositions[(j + paramInt2)] = arrayOfInt1[paramInt2];
            this.mDesiredInsertionPositions[(j + paramInt2)] = arrayOfInt2[paramInt2];
            paramInt2 += 1;
        }
        this.mDesiredCount += i;
        this.mPlacedCount -= i;
        return i;
    }

    int getAdjustedCount(int paramInt) {
        if (paramInt == 0) {
            return 0;
        }
        return getAdjustedPosition(paramInt - 1) + 1;
    }

    int getAdjustedPosition(int paramInt) {
        return binarySearchGreaterThan(this.mOriginalAdPositions, this.mPlacedCount, paramInt) + paramInt;
    }

    int getOriginalCount(int paramInt) {
        int i = -1;
        if (paramInt == 0) {
            paramInt = 0;
        }
        int j;
        do {
            return paramInt;
            j = getOriginalPosition(paramInt - 1);
            paramInt = i;
        } while (j == -1);
        return j + 1;
    }

    int getOriginalPosition(int paramInt) {
        int i = binarySearch(this.mAdjustedAdPositions, 0, this.mPlacedCount, paramInt);
        if (i < 0) {
            return paramInt - (i ^ 0xFFFFFFFF);
        }
        return -1;
    }

    NativeAdData getPlacedAd(int paramInt) {
        paramInt = binarySearch(this.mAdjustedAdPositions, 0, this.mPlacedCount, paramInt);
        if (paramInt < 0) {
            return null;
        }
        return this.mAdDataObjects[paramInt];
    }

    int[] getPlacedAdPositions() {
        int[] arrayOfInt = new int[this.mPlacedCount];
        System.arraycopy(this.mAdjustedAdPositions, 0, arrayOfInt, 0, this.mPlacedCount);
        return arrayOfInt;
    }

    void insertItem(int paramInt) {
        int i = binarySearchFirstEquals(this.mDesiredOriginalPositions, this.mDesiredCount, paramInt);
        int[] arrayOfInt;
        while (i < this.mDesiredCount) {
            arrayOfInt = this.mDesiredOriginalPositions;
            arrayOfInt[i] += 1;
            arrayOfInt = this.mDesiredInsertionPositions;
            arrayOfInt[i] += 1;
            i += 1;
        }
        paramInt = binarySearchFirstEquals(this.mOriginalAdPositions, this.mPlacedCount, paramInt);
        while (paramInt < this.mPlacedCount) {
            arrayOfInt = this.mOriginalAdPositions;
            arrayOfInt[paramInt] += 1;
            arrayOfInt = this.mAdjustedAdPositions;
            arrayOfInt[paramInt] += 1;
            paramInt += 1;
        }
    }

    boolean isPlacedAd(int paramInt) {
        boolean bool = false;
        if (binarySearch(this.mAdjustedAdPositions, 0, this.mPlacedCount, paramInt) >= 0) {
            bool = true;
        }
        return bool;
    }

    void moveItem(int paramInt1, int paramInt2) {
        removeItem(paramInt1);
        insertItem(paramInt2);
    }

    int nextInsertionPosition(int paramInt) {
        paramInt = binarySearchGreaterThan(this.mDesiredInsertionPositions, this.mDesiredCount, paramInt);
        if (paramInt == this.mDesiredCount) {
            return -1;
        }
        return this.mDesiredInsertionPositions[paramInt];
    }

    void placeAd(int paramInt, NativeAdData paramNativeAdData) {
        int i = binarySearchFirstEquals(this.mDesiredInsertionPositions, this.mDesiredCount, paramInt);
        if ((i == this.mDesiredCount) || (this.mDesiredInsertionPositions[i] != paramInt)) {
            MoPubLog.w("Attempted to insert an ad at an invalid position");
        }
        for (; ; ) {
            return;
            int k = this.mDesiredOriginalPositions[i];
            int j = binarySearchGreaterThan(this.mOriginalAdPositions, this.mPlacedCount, k);
            if (j < this.mPlacedCount) {
                int m = this.mPlacedCount - j;
                System.arraycopy(this.mOriginalAdPositions, j, this.mOriginalAdPositions, j + 1, m);
                System.arraycopy(this.mAdjustedAdPositions, j, this.mAdjustedAdPositions, j + 1, m);
                System.arraycopy(this.mAdDataObjects, j, this.mAdDataObjects, j + 1, m);
            }
            this.mOriginalAdPositions[j] = k;
            this.mAdjustedAdPositions[j] = paramInt;
            this.mAdDataObjects[j] = paramNativeAdData;
            this.mPlacedCount += 1;
            paramInt = this.mDesiredCount - i - 1;
            System.arraycopy(this.mDesiredInsertionPositions, i + 1, this.mDesiredInsertionPositions, i, paramInt);
            System.arraycopy(this.mDesiredOriginalPositions, i + 1, this.mDesiredOriginalPositions, i, paramInt);
            this.mDesiredCount -= 1;
            paramInt = i;
            while (paramInt < this.mDesiredCount) {
                paramNativeAdData = this.mDesiredInsertionPositions;
                paramNativeAdData[paramInt] += 1;
                paramInt += 1;
            }
            paramInt = j + 1;
            while (paramInt < this.mPlacedCount) {
                paramNativeAdData = this.mAdjustedAdPositions;
                paramNativeAdData[paramInt] += 1;
                paramInt += 1;
            }
        }
    }

    int previousInsertionPosition(int paramInt) {
        paramInt = binarySearchFirstEquals(this.mDesiredInsertionPositions, this.mDesiredCount, paramInt);
        if (paramInt == 0) {
            return -1;
        }
        return this.mDesiredInsertionPositions[(paramInt - 1)];
    }

    void removeItem(int paramInt) {
        int i = binarySearchGreaterThan(this.mDesiredOriginalPositions, this.mDesiredCount, paramInt);
        int[] arrayOfInt;
        while (i < this.mDesiredCount) {
            arrayOfInt = this.mDesiredOriginalPositions;
            arrayOfInt[i] -= 1;
            arrayOfInt = this.mDesiredInsertionPositions;
            arrayOfInt[i] -= 1;
            i += 1;
        }
        paramInt = binarySearchGreaterThan(this.mOriginalAdPositions, this.mPlacedCount, paramInt);
        while (paramInt < this.mPlacedCount) {
            arrayOfInt = this.mOriginalAdPositions;
            arrayOfInt[paramInt] -= 1;
            arrayOfInt = this.mAdjustedAdPositions;
            arrayOfInt[paramInt] -= 1;
            paramInt += 1;
        }
    }

    boolean shouldPlaceAd(int paramInt) {
        boolean bool = false;
        if (binarySearch(this.mDesiredInsertionPositions, 0, this.mDesiredCount, paramInt) >= 0) {
            bool = true;
        }
        return bool;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/PlacementData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */