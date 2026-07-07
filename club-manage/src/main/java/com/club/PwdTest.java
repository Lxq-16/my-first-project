package com.club;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwdTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 明文固定123456
        String newEncryptPwd = encoder.encode("123456");
        System.out.println("新密码密文：" + newEncryptPwd);
    }
}