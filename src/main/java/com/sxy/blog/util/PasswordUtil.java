package com.sxy.blog.util;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PasswordUtil {
    public String Encrypt(String password) {
        return BCrypt.withDefaults().hashToString(10, password.toCharArray());
    }

    public Boolean Decrypt(String password,String hashString) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashString).verified;
    }
}
