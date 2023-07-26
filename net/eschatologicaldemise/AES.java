package net.eschatologicaldemise;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class AES {
    public static void m() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 生成ECC密钥对
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1"); // 使用secp256r1曲线
        keyGen.initialize(ecSpec);
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // 生成AES密钥
        KeyGenerator aesKeyGen = KeyGenerator.getInstance("AES");
        aesKeyGen.init(256); // 使用256位AES密钥
        SecretKey aesKey = aesKeyGen.generateKey();

        // 使用ECC公钥对AES密钥进行加密
        Cipher eccCipher = Cipher.getInstance("ECIES");
        eccCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedAesKey = eccCipher.doFinal(aesKey.getEncoded());

        // 使用AES密钥对数据进行加密
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
        String plaintext = "Hello, ECC and AES!";
        byte[] encryptedData = aesCipher.doFinal(plaintext.getBytes());

        // 打印加密后的数据和加密的AES密钥
        System.out.println("Encrypted Data: " + new String(encryptedData));
        System.out.println("Encrypted AES Key: " + new String(encryptedAesKey));

        // 使用ECC私钥解密AES密钥
        eccCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedAesKey = eccCipher.doFinal(encryptedAesKey);

        // 使用解密后的AES密钥对数据进行解密
        aesCipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptedAesKey, "AES"));
        byte[] decryptedData = aesCipher.doFinal(encryptedData);

        // 打印解密后的数据
        System.out.println("Decrypted Data: " + new String(decryptedData));
    }
}
