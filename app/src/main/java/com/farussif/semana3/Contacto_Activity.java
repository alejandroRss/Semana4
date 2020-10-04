package com.farussif.semana3;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.MessageQueue;
import android.text.Html;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto_Activity extends AppCompatActivity {

    //Inicializar variables

    EditText et_Subject,et_Message,et_from;
    Button bt_send;
    String sEmail,sPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        androidx.appcompat.widget.Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        miActionBar.setLogo(R.drawable.dog_paw);
        setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Asignar variables

        et_Subject = findViewById(R.id.et_subject);
        et_Message = findViewById(R.id.et_message);
        et_from = findViewById(R.id.et_from);
        bt_send = findViewById(R.id.bt_send);



        //Credenciales email
        sEmail = "pruebamailp4@gmail.com";
        sPassword = "prueba_12345";

        bt_send.setOnClickListener(v -> {

            if (et_Subject.getText().toString().isEmpty()){
                Toast.makeText(this,"Campo Nombre Vacío",Toast.LENGTH_LONG).show();
            }else{
                if (et_Message.getText().toString().isEmpty()){
                Toast.makeText(this,"Campo Observaciones Vacío",Toast.LENGTH_LONG).show();
            }else{
                    if (et_from.getText().toString().isEmpty()){
                        Toast.makeText(this,"Campo Correo Vacío",Toast.LENGTH_LONG).show();

                    }else {
                        if (!validarEmail(et_from.getText().toString())){

                            et_from.setError("Correo no válido");
                        }else{
                            //Inicializar Propiedades

                            Properties properties = new Properties();
                            properties.put("mail.smtp.auth","true");
                            properties.put("mail.smtp.starttls.enable","true");
                            properties.put("mail.smtp.host","smtp.gmail.com");
                            properties.put("mail.smtp.port","587");

                            //Inciar sesion
                            javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
                                @Override
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(sEmail,sPassword);
                                }
                            });



                            try {
                                //Inicializar contenido email
                                Message message = new MimeMessage(session);

                                //Sender email
                                message.setFrom(new InternetAddress(sEmail));
                                //Recipient email
                                message.addRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(sEmail));
                                message.addRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(et_from.getText().toString().trim()));
                                //Email subject-from
                                message.setSubject("Comentario de usuario: "+et_Subject.getText().toString().trim());
                                //Email message
                                message.setText(et_Message.getText().toString().trim());
                                //From



                                //Sen email
                                new  SendMail().execute(message);

                                //Send email

                            } catch (MessagingException e) {
                                e.printStackTrace();
                            }

                        }


                    }

                }
            }







        });




    }

    private class SendMail extends AsyncTask<Message,String,String> {
        //Inicializar progress dialog
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Crear y mostrar process dialog
            progressDialog = ProgressDialog.show(Contacto_Activity.this,
                    "Por favor espere.","Enviando correo...",true);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                //Cuando lo completa
                Transport.send(messages[0]);
                return "Enviado";
            } catch (MessagingException e) {
                //Cuando hay error
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Dismiss progress dialog
            progressDialog.dismiss();

            if (s.equals("Enviado")){

                AlertDialog.Builder builder = new AlertDialog.Builder(Contacto_Activity.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color = '#509324'>Hecho</font>"));

                builder.setMessage("Correo enviado correctamente, recibirá copia de sus comentarios al correo insertado");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //Limpiar y editar texto
                        et_Message.setText("");
                        et_Subject.setText("");
                        et_from.setText("");
                    }
                });
                //Mostrar alert dialog
                builder.show();
            }else {
                Toast.makeText(getApplicationContext(), "Algo está mal", Toast.LENGTH_SHORT).show();

            }
        }
    }
    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}