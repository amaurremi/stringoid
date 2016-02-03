package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.util.Map;

public class PkParams {
    public static String SK_ALGORITHM = "";
    public static String SK_EXPONENT = "";
    public static String SK_MODULUS = "";
    public static String SK_VERSION = "";
    private Map<String, Boolean> a;

    public String getAlgorithm() {
        return SK_ALGORITHM;
    }

    public Map<String, Boolean> getDeviceIdMaskMap() {
        return this.a;
    }

    public String getExponent() {
        return SK_EXPONENT;
    }

    public String getModulus() {
        return SK_MODULUS;
    }

    public String getVersion() {
        return SK_VERSION;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        paramMap = (Map) paramMap.get("pk");
        SK_VERSION = InternalSDKUtil.getStringFromMap(paramMap, "ver");
        if (SK_VERSION.equals("")) {
            Log.internal("[InMobi]-4.5.1", "Key ver has illegal value");
            throw new IllegalArgumentException();
        }
        SK_ALGORITHM = InternalSDKUtil.getStringFromMap(paramMap, "alg");
        if (SK_ALGORITHM.equals("")) {
            Log.internal("[InMobi]-4.5.1", "Key alg has illegal value");
            throw new IllegalArgumentException();
        }
        if (SK_ALGORITHM.equalsIgnoreCase("rsa")) {
            paramMap = (Map) paramMap.get("val");
            SK_EXPONENT = InternalSDKUtil.getStringFromMap(paramMap, "e");
            SK_MODULUS = InternalSDKUtil.getStringFromMap(paramMap, "m");
            if (SK_MODULUS.equals("")) {
                Log.internal("[InMobi]-4.5.1", "Key m has illegal value");
                throw new IllegalArgumentException();
            }
            if (SK_EXPONENT.equals("")) {
                Log.internal("[InMobi]-4.5.1", "Key e has illegal value");
                throw new IllegalArgumentException();
            }
            if (!InternalSDKUtil.isHexString(SK_EXPONENT)) {
                Log.internal("[InMobi]-4.5.1", "Key e has illegal value");
                throw new IllegalArgumentException();
            }
            if (!InternalSDKUtil.isHexString(SK_MODULUS)) {
                Log.internal("[InMobi]-4.5.1", "Key m has illegal value");
                throw new IllegalArgumentException();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/configs/PkParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */