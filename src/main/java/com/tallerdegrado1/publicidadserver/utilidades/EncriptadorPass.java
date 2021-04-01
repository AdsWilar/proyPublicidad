package com.tallerdegrado1.publicidadserver.utilidades;

import org.mindrot.jbcrypt.BCrypt;

public class EncriptadorPass {


    private EncriptadorPass() {
        throw new IllegalStateException("Can't instantiate this class");
    }

    /**
     encripta la password
     */
    public static String hashPassword(String plainTextPassword) {
        String salt = BCrypt.gensalt(WORKLOAD);
        return BCrypt.hashpw(plainTextPassword, salt);
    }

    /**
     validacion de la contrasenia y el login
     */
    public static Boolean checkPassword(String plainTextPassword, String storedHash) {
        if (null == storedHash || !storedHash.startsWith("$2a$"))
            throw new IllegalArgumentException("Invalid hash provided for comparison");
        return BCrypt.checkpw(plainTextPassword, storedHash);
    }

    private static final Integer WORKLOAD = 12;


}
