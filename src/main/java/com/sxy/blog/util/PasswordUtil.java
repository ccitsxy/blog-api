package com.sxy.blog.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public final class PasswordUtil {

    // 加密
    public static String Encrypt(String password) {
        return BCrypt.withDefaults().hashToString(10, password.toCharArray());
    }
    // 解密
    public static Boolean Decrypt(String password, String hashString) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashString).verified;
    }
}
