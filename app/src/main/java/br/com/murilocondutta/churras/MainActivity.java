package br.com.murilocondutta.churras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText pessoas;
    private Button calcular;
    private TextView resultado;
    private int quantidadeCarnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoas = findViewById(R.id.edtPessoas);
        calcular = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.txtResultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quantidadeCarnes = Integer.valueOf(pessoas.getText().toString()) * 350;

                resultado.setText("Deverá ser comprado " + quantidadeCarnes + "g de carne.");

            }
        });

    }
}
