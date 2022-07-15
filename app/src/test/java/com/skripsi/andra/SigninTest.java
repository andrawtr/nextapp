package com.skripsi.andra;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SigninTest {

    @Test
    public void cekpassWhenPasswordIsValidThenReturnTrue() {
        String password = "123456";
        String result = cekvalid.valpass(password);
        assertEquals("true", result);
    }

    @Test
    public void cekpassWhenPasswordIsInvalidThenReturnFalse() {
        String password = "12345";
        String expected = "Password Minimal 6 Karakter";

        String actual = cekvalid.valpass(password);

        assertEquals(expected, actual);
    }

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