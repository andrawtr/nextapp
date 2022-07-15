package com.skripsi.andra;
import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class signupTest {

    @Test
    public void ceknamaWhenNameIsValidThenReturnTrue() {
        String nama = "John";
        String result = cekvalid.valnama(nama);
        assertEquals("true", result);
    }

    @Test
    public void ceknamaWhenNameIsInvalidThenReturnFalse() {
        String nama = "";
        String result = cekvalid.valnama(nama);
        assertEquals("Nama harus diisi", result);
    }

    @Test
    public void cekPassWhenPasswordIsValidThenReturnTrue() {
        String password = "123456";
        String result = cekvalid.valpass(password);
        assertEquals("true", result);
    }

    @Test
    public void cekPassWhenPasswordIsInvalidThenReturnErrorMessage() {
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
    public void cekemailWhenEmailIsInvalidThenReturnErrorMessage() {
        String email = "john";
        String expected = "Alamat Email tidak valid";

        String actual = cekvalid.valemail(email);

        assertEquals(expected, actual);
    }
}