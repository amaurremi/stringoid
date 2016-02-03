package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@ii
public class gr {
    public static PublicKey a(String paramString) {
        try {
            paramString = Base64.decode(paramString, 0);
            paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
            return paramString;
        } catch (NoSuchAlgorithmException paramString) {
            throw new RuntimeException(paramString);
        } catch (InvalidKeySpecException paramString) {
            mx.b("Invalid key specification.");
            throw new IllegalArgumentException(paramString);
        }
    }

    public static boolean a(String paramString1, String paramString2, String paramString3) {
        if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
            mx.b("Purchase verification failed: missing data.");
            return false;
        }
        return a(a(paramString1), paramString2, paramString3);
    }

    public static boolean a(PublicKey paramPublicKey, String paramString1, String paramString2) {
        try {
            Signature localSignature = Signature.getInstance("SHA1withRSA");
            localSignature.initVerify(paramPublicKey);
            localSignature.update(paramString1.getBytes());
            if (!localSignature.verify(Base64.decode(paramString2, 0))) {
                mx.b("Signature verification failed.");
                return false;
            }
            return true;
        } catch (NoSuchAlgorithmException paramPublicKey) {
            mx.b("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException paramPublicKey) {
            mx.b("Invalid key specification.");
            return false;
        } catch (SignatureException paramPublicKey) {
            mx.b("Signature exception.");
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */