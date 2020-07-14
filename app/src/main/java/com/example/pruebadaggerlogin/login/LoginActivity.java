package com.example.pruebadaggerlogin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebadaggerlogin.R;
import com.example.pruebadaggerlogin.root.App;

import javax.inject.Inject;

import dagger.Module;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View{

    @Inject
    LoginActivityMVP.Presenter presenter;

    EditText etName, etApellido;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        etName = findViewById(R.id.et_login_nombre);
        etApellido = findViewById(R.id.et_login_apellido);
        btnEntrar = findViewById(R.id.btn_login_entrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);

        //Si el usuario se ha logeado  previamente, precargar los datos
        //presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return this.etName.getText().toString();
    }

    @Override
    public String getLastName() {
        return this.etApellido.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error, el usuario no está disponible", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Error, nombre y apellido son necesarios", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSaved() {
        Toast.makeText(this, "¡Usuario guardado correctamente!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String firstName) {
        this.etName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.etApellido.setText(lastName);
    }
}
