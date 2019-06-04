package net.bitgeekenvironments.dkz_tools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Caesar_Cipher extends AppCompatActivity implements View.OnClickListener {
    EditText keytxt, encode, decode, values;
    Button toEncode, toDecode;
    //private String values = "abcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar__cipher);
        keytxt=findViewById(R.id.et_key);
        encode=findViewById(R.id.et_code);
        decode=findViewById(R.id.et_decode);
        values=findViewById(R.id.et_values);
        toEncode=findViewById(R.id.btn_encode);
        toDecode=findViewById(R.id.btn_decode);
        toEncode.setOnClickListener(this);
        toDecode.setOnClickListener(this);
    }


    public void encode(){
        try {
            Integer.parseInt(keytxt.getText().toString());
            encode.setText(Encode(decode.getText().toString(), Integer.parseInt(keytxt.getText().toString())));
        } catch(NumberFormatException e1) {
            //JOptionPane.showMessageDialog(this, "Enter digits only");
        }
    }

    public void decode(){
        try {
            Integer.parseInt(keytxt.getText().toString());
            decode.setText(Decode(encode.getText().toString(), Integer.parseInt(keytxt.getText().toString())));
        } catch(NumberFormatException e1) {
            //JOptionPane.showMessageDialog(this, "Enter digits only");
        }
    }

    private String Encode(String text, int key) {
        char charEnc;
        int valEnc;
        int newEnc;
        String encrypted = "";
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            charEnc = text.charAt(i);
            String valu=values.getText().toString();
            valEnc = valu.indexOf(charEnc);
            newEnc = (key + valEnc) % valu.length();
            encrypted += valu.charAt(newEnc);
        }
        return encrypted.toUpperCase();
    }

    private String Decode(String text, int key) {
        char charEnc;
        int valEnc;
        int newEnc;
        String decoded = "";
        String valu=values.getText().toString();
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            charEnc = text.charAt(i);
            valEnc = valu.indexOf(charEnc);
            newEnc = (valEnc - key) % valu.length();
            // check for negative
            if (newEnc < 0) {
                newEnc += Math.abs(valu.length());
            }
            decoded += valu.charAt(newEnc);
        }
        return decoded.toUpperCase();
    }

    @Override
    public void onClick(View v) {
        if(v==toDecode){
            decode();
        }
        if(v==toEncode){
            encode();
        }
    }
}