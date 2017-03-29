package com.iekh0813.nc.framework;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TypesConverter {
    protected TypesConverter() {
    }

    public static BigDecimal bigIntegerToBigDecimal(BigInteger number) {
        if (number == null) {
            return null;
        } else {
            return new BigDecimal(number);
        }
    }

    public static BigInteger bigDecimalToBigInteger(BigDecimal number) {
        if (number == null) {
            return null;
        } else {
            return number.toBigInteger();
        }
    }

    public static String nullToString(String str) {
        if (str == null) {
            str = "";
        }
        return str;
    }

    public static String boolToString(boolean val) {
        if (val) return "YES";
        else return "NO";
    }

    public static boolean stringToBoolean(String str) {
        if (str.equalsIgnoreCase("1") || str.equalsIgnoreCase("TRUE") || str.equalsIgnoreCase("YES")) return true;
        else if (str.equalsIgnoreCase("0") || str.equalsIgnoreCase("FALSE") || str.equalsIgnoreCase("NO")) return false;
        else throw new IllegalArgumentException("Argument " + str + " is not applicable to this operation");
    }

}