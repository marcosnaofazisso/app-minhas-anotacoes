package com.example.minhasanotacoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editAnotacao.getText().toString().equals("")) {
                    Snackbar.make(v, "Digite uma anotação primeiro!", Snackbar.LENGTH_LONG).show();
                } else {
                    //Salvar Anotação
                    preferencias.salvarAnotacao(editAnotacao.getText().toString());
                    Snackbar.make(v, "Anotação salva com sucesso :D", Snackbar.LENGTH_LONG).show();

                }

            }
        });

        //Recuperar Anotação
        String anotacao = preferencias.recuperarAnotacao();
        if(!anotacao.equals("")) {
            editAnotacao.setText(anotacao);

        }


    }

}
