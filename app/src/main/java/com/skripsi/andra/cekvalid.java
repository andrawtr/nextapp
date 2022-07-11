package com.skripsi.andra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class cekvalid {

    public static String valemail(String email) {
        String buatcekemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.length() < 1) {
            return "Email wajib diisi";
        } else {
            if (email.trim().matches(buatcekemail)) {
                return "true";
            } else {
                return "Alamat Email tidak valid";
            }
        }
    }
    public static String valpass(String pass){
        if (pass.length() < 6) {
            return "Password Minimal 6 Karakter";
        } else {
            return "true";
        }
    }
    public static String valnama(String nama){
        if (nama.length() < 1) {
            return "Nama harus diisi";
        } else {
            return "true";
        }
    }



}
