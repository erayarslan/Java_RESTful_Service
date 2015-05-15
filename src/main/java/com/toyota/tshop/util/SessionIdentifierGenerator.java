package com.toyota.tshop.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SessionIdentifierGenerator {
    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}
