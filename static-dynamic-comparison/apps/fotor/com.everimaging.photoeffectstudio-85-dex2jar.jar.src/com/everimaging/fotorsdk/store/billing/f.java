package com.everimaging.fotorsdk.store.billing;

import android.text.TextUtils;
import android.util.Log;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class f {
    public static PublicKey a(String paramString) {
        try {
            paramString = a.a(paramString);
            paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
            return paramString;
        } catch (NoSuchAlgorithmException paramString) {
            throw new RuntimeException(paramString);
        } catch (InvalidKeySpecException paramString) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            throw new IllegalArgumentException(paramString);
        } catch (Base64DecoderException paramString) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            throw new IllegalArgumentException(paramString);
        }
    }

    public static boolean a(String paramString1, String paramString2, String paramString3) {
        if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
            Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
            return false;
        }
        return a(a(paramString1), paramString2, paramString3);
    }

    public static boolean a(PublicKey paramPublicKey, String paramString1, String paramString2) {
        try {
            Signature localSignature = Signature.getInstance("SHA1withRSA");
            localSignature.initVerify(paramPublicKey);
            localSignature.update(paramString1.getBytes());
            if (!localSignature.verify(a.a(paramString2))) {
                Log.e("IABUtil/Security", "Signature verification failed.");
                return false;
            }
            return true;
        } catch (NoSuchAlgorithmException paramPublicKey) {
            Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException paramPublicKey) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            return false;
        } catch (SignatureException paramPublicKey) {
            Log.e("IABUtil/Security", "Signature exception.");
            return false;
        } catch (Base64DecoderException paramPublicKey) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/billing/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */