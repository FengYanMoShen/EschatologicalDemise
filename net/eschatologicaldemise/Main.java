package net.eschatologicaldemise;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import javax.crypto.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    static Thread thread1 = new Thread();// 添加一个新线程
    static Thread thread2 = new Thread();// 添加一个新线程
    static Thread thread3 = new Thread();// 添加一个新线程
    private static String programmer = "FengYanMoShen";// 程序员："FengYanMoShen"

    private static final String SHUTDOWN_TITLE = "Eschatological Demise - shutting down!";// 关闭窗口时的标题

    private static String MainIconPath = "assets/Icon.jpg";// 程序窗口的图标

    static void author(String programmer){
        System.out.println(programmer);// 打印 programmer
    }

    static void WindowEventLauncher(){
        ImageIcon icon = new ImageIcon(MainIconPath);// 新建一个ImageIcon对象，指定图标文件的路径
        Image image = icon.getImage();// 获取ImageIcon的Image对象

        JFrame jFrame = new JFrame("Eschatological Demise");// 新建窗口和添加窗口的标题
          jFrame.setIconImage(image);// 设置窗口的图标
          jFrame.setSize(800, 600);// 设置窗口大小
          jFrame.setLocationRelativeTo(null);// 将窗口居中显示
          jFrame.setVisible(true);// 设置窗口可见
          //jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);// 开启全屏模式
          //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口关闭时程序终止
          jFrame.addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent e) {
                  jFrame.setTitle(SHUTDOWN_TITLE); // 修改窗口标题成"Eschatological Demise - shutting down!"
                  System.exit(0);// 处理窗口关闭事件,终止当前正在运行的Java虚拟机，并传递一个退出状态码0给操作系统，表示正常退出。
              }
          });
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
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

        thread1.start();// 线程1启动
        thread2.start();// 线程2启动
        thread3.start();// 线程3启动
        System.out.println("hello world!");
        author(programmer);// 打印 programmer

        WindowEventLauncher();
    }
}
