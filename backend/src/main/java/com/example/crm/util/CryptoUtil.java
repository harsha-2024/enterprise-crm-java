package com.example.crm.util;

import javax.crypto.Cipher; import javax.crypto.spec.GCMParameterSpec; import javax.crypto.spec.SecretKeySpec; import java.security.SecureRandom; import java.util.Base64;

public class CryptoUtil { private static final String ALGO = "AES"; private static final String CIPHER = "AES/GCM/NoPadding"; private static final int GCM_TAG = 128; private static final SecureRandom RNG = new SecureRandom(); private final byte[] key;
  public CryptoUtil(String key32){ this.key = key32.getBytes(); }
  public String encrypt(String plaintext){ try { byte[] iv = new byte[12]; RNG.nextBytes(iv); Cipher c = Cipher.getInstance(CIPHER); c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, ALGO), new GCMParameterSpec(GCM_TAG, iv)); byte[] enc = c.doFinal(plaintext.getBytes()); byte[] out = new byte[iv.length+enc.length]; System.arraycopy(iv,0,out,0,iv.length); System.arraycopy(enc,0,out,iv.length,enc.length); return Base64.getEncoder().encodeToString(out);} catch(Exception e){ throw new RuntimeException(e);} }
  public String decrypt(String b64){ try { byte[] in = Base64.getDecoder().decode(b64); byte[] iv = new byte[12]; System.arraycopy(in,0,iv,0,12); byte[] enc = new byte[in.length-12]; System.arraycopy(in,12,enc,0,enc.length); Cipher c = Cipher.getInstance(CIPHER); c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, ALGO), new GCMParameterSpec(GCM_TAG, iv)); return new String(c.doFinal(enc)); } catch(Exception e){ throw new RuntimeException(e);} }
}
