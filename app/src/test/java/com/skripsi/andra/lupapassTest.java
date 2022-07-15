package com.skripsi.andra;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class lupapassTest {

    @Test
    public void cekemailWhenEmailIsValidThenReturnTrue() {
        String email = "john@gmail.com";
        String result = cekvalid.valemail(email);
        assertEquals("true", result);
    }

    @Test
    public void cekemailWhenEmailIsInvalidThenReturnFalse() {
        String email = "john@gmail";
        String result = cekvalid.valemail(email);
        assertEquals("Alamat Email tidak valid", result);
    }
}