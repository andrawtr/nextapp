package com.skripsi.andra;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class cekvalidTest {

    @Test
    public void valemailWhenEmailIsEmptyThenReturnEmailWajibDiisi() {
        String email = "";
        String expected = "Email wajib diisi";
        String result = cekvalid.valemail(email);
        assertEquals(expected, result);
    }

    @Test
    public void valemailWhenEmailIsNotValidThenReturnAlamatEmailTidakValid() {
        String email = "john@gmail";
        String expected = "Alamat Email tidak valid";
        String actual = cekvalid.valemail(email);
        assertEquals(expected, actual);
    }
    @Test
    public void valemailWhenEmailIsValidThenReturntrue() {
        String email = "john@gmail.com";
        String expected = "true";
        String actual = cekvalid.valemail(email);
        assertEquals(expected, actual);
    }
}