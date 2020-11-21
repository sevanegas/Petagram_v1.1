package com.sevanegas.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.AsyncPlayer;
import android.media.MediaCas;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sevanegas.petagram.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    Session session = null;
    ProgressDialog progressDialog = null;
    Context context = null;
    EditText editText, editText3, editText4;
    String edit,edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar ActionBar = findViewById(R.id.actionbar);
        setSupportActionBar(ActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.tvNombre);
        editText3 = (EditText) findViewById(R.id.tvEmail);
        editText4 = (EditText) findViewById(R.id.tvDescripcion);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 edit = editText.getText().toString();
                 edit1 =editText3.getText().toString();
                 edit2 = editText4.getText().toString();


                Properties properties =System.getProperties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");

                session = Session.getDefaultInstance(properties, new Authenticator()  {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        /* La persona que vaya a utilizar la aplicacion, puede cambiar este correo por el personal, o simplemente dejarlo asi */
                        return new PasswordAuthentication("petegram.correo@gmail.com","Petegramcorreo12*");
                    }
                });

                progressDialog = ProgressDialog.show(context,"","Enviando Correo...",true);
                RetreiveFeedTask retreiveFeedTask  =new RetreiveFeedTask();
                retreiveFeedTask.execute();

            }

            class RetreiveFeedTask extends AsyncTask<String, Void, String>{

                @Override
                protected String doInBackground(String... params) {

                   try {
                        Message message =new MimeMessage(session);
                        message.setFrom(new InternetAddress("testfrom354@gmail.com"));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("petegram.correo@gmail.com"));
                        message.setSubject("Habla con nosotros");
                        message.setText("Nombre : " + edit + "\nCorreo : "+ edit1   + "\nMensaje : "  + edit2);
                        Transport.send(message);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(String s) {
                    progressDialog.dismiss();
                    editText3.setText("");
                    editText.setText("");
                    editText4.setText("");
                    Toast.makeText(getApplicationContext(),"Correo enviado", Toast.LENGTH_LONG).show();

                }
            }
        });



    }
}