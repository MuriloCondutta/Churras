package br.com.murilocondutta.churras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Quantidade de convidados
    private EditText qtdeHomem;
    private EditText qtdeMulher;
    private EditText qtdeCrianca;

    // Outros elementos
    private Button calcular;
    private TextView resultado;

    // Váriavel para resultado final
    private int qtdeCarnes;

    // Quantidades bases
    private static final int CARNES_HOMEM = 350;
    private static final int CARNES_MULHER = 300;
    private static final int CARNES_CRIANCA = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qtdeHomem = findViewById(R.id.edtHomens);
        qtdeMulher = findViewById(R.id.edtMulheres);
        qtdeCrianca = findViewById(R.id.edtCrianças);

        calcular = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.txtResultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (qtdeHomem.getText().length() == 0 || qtdeHomem.getText().equals("")){

                    Toast.makeText(MainActivity.this, "Há erros de valores!", Toast.LENGTH_SHORT).show();

                } else if (qtdeMulher.getText().length() == 0 || qtdeMulher.getText().equals("")){

                    Toast.makeText(MainActivity.this, "Há erros de valores!", Toast.LENGTH_SHORT).show();

                } else if (qtdeCrianca.getText().length() == 0 || qtdeCrianca.getText().equals("")){

                    Toast.makeText(MainActivity.this, "Há erros de valores!", Toast.LENGTH_SHORT).show();

                } else {

                    qtdeCarnes = CARNES_HOMEM * Integer.valueOf(qtdeHomem.getText().toString());
                    qtdeCarnes += CARNES_MULHER * Integer.valueOf(qtdeMulher.getText().toString());
                    qtdeCarnes += CARNES_CRIANCA * Integer.valueOf(qtdeCrianca.getText().toString());

                    resultado.setText("Deverá ser comprado " + qtdeCarnes + "g de carne.");

                }

            }
        });

    }
}
