/**
 * Activity principal - cálculo
 */

package br.com.murilocondutta.churras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // Quantidade de convidados
    private EditText qtdeHomem;
    private EditText qtdeMulher;
    private EditText qtdeCrianca;

    // Carnes
    private CheckBox carneCOsso;
    private CheckBox carneSOsso;
    private CheckBox frango;
    private CheckBox linguica;

    private int tiposCarneSelecionados;

    // Outros elementos
    private Button calcular;
    private TextView resultado;

    // Váriavel para resultado final
    private Double qtdeCarneCOsso;
    private Double qtdeCarneSOsso;
    private Double qtdeFrango;
    private Double qtdeLinguica;

    private Double qtdeTotalCarnes;

    // Quantidades bases
    private static final double CARNES_HOMEM = 650.00;
    private static final double CARNES_MULHER = 600.00;
    private static final double CARNES_CRIANCA = 500.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Cálculo");

        qtdeHomem = findViewById(R.id.edtHomens);
        qtdeMulher = findViewById(R.id.edtMulheres);
        qtdeCrianca = findViewById(R.id.edtCrianças);

        carneCOsso = findViewById(R.id.cbCarneCOsso);
        carneSOsso = findViewById(R.id.cbCarneSOsso);
        frango = findViewById(R.id.cbFrango);
        linguica = findViewById(R.id.cbLinguica);

        calcular = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.txtResultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Pessoas
                if (qtdeHomem.getText().length() == 0 || qtdeHomem.getText().equals("")){

                    Toast.makeText(MainActivity.this, "Há erros de valores!", Toast.LENGTH_SHORT).show();

                } else if (qtdeMulher.getText().length() == 0 || qtdeMulher.getText().equals("")){

                    Toast.makeText(MainActivity.this, "Há erros de valores!", Toast.LENGTH_SHORT).show();

                } else if (qtdeCrianca.getText().length() == 0 || qtdeCrianca.getText().equals("")){

                    Toast.makeText(MainActivity.this, "Há erros de valores!", Toast.LENGTH_SHORT).show();

                } else {

                    // Carnes

                    // Verifica quantidade de tipos de carnes selecionados
                    tiposCarneSelecionados = 0;

                    if (carneCOsso.isChecked()){

                        tiposCarneSelecionados += 1;

                    }

                    if (carneSOsso.isChecked()){

                        tiposCarneSelecionados += 1;

                    }

                    if (frango.isChecked()){

                        tiposCarneSelecionados += 1;

                    }
                    if (linguica.isChecked()){

                        tiposCarneSelecionados += 1;

                    }

                    // Se há mais de um tipo, reduz a quantidade base de carne por pessoa

                    qtdeCarneCOsso = 0.0;
                    qtdeCarneSOsso = 0.0;
                    qtdeFrango = 0.0;
                    qtdeLinguica = 0.0;

                    if (tiposCarneSelecionados > 0){

                        if (tiposCarneSelecionados >= 2){

                            if (carneCOsso.isChecked()){

                                qtdeCarneCOsso = ((CARNES_HOMEM) * 0.5) * Integer.valueOf(qtdeHomem.getText().toString());
                                qtdeCarneCOsso +=((CARNES_MULHER) * 0.5) * Integer.valueOf(qtdeMulher.getText().toString());
                                qtdeCarneCOsso += ((CARNES_CRIANCA) * 0.5) * Integer.valueOf(qtdeCrianca.getText().toString());

                            }

                            if (carneSOsso.isChecked()){

                                qtdeCarneSOsso = ((CARNES_HOMEM) * 0.3) * Integer.valueOf(qtdeHomem.getText().toString());
                                qtdeCarneSOsso += ((CARNES_MULHER) * 0.3) * Integer.valueOf(qtdeMulher.getText().toString());
                                qtdeCarneSOsso += ((CARNES_CRIANCA) * 0.3) * Integer.valueOf(qtdeCrianca.getText().toString());

                            }

                            if (frango.isChecked()){

                                qtdeFrango = ((CARNES_HOMEM) * 0.3) * Integer.valueOf(qtdeHomem.getText().toString());
                                qtdeFrango += ((CARNES_MULHER) * 0.3) * Integer.valueOf(qtdeMulher.getText().toString());
                                qtdeFrango += ((CARNES_CRIANCA) * 0.3) * Integer.valueOf(qtdeCrianca.getText().toString());

                            }
                            if (linguica.isChecked()){

                                qtdeLinguica = ((CARNES_HOMEM) * 0.3) * Integer.valueOf(qtdeHomem.getText().toString());
                                qtdeLinguica += ((CARNES_MULHER) * 0.3) * Integer.valueOf(qtdeMulher.getText().toString());
                                qtdeLinguica += ((CARNES_CRIANCA) * 0.3) * Integer.valueOf(qtdeCrianca.getText().toString());

                            }

                        } else if (tiposCarneSelecionados == 1){

                            // Mostra o resultado pelo que foi selecionado
                            if (carneCOsso.isChecked()){

                                qtdeCarneCOsso = (CARNES_HOMEM * Integer.valueOf(qtdeHomem.getText().toString())) * 1.1;
                                qtdeCarneCOsso += (CARNES_MULHER * Integer.valueOf(qtdeMulher.getText().toString())) * 1.1;
                                qtdeCarneCOsso += (CARNES_CRIANCA * Integer.valueOf(qtdeCrianca.getText().toString())) * 1.1;

                            }

                            if (carneSOsso.isChecked()){

                                qtdeCarneSOsso = CARNES_HOMEM * Integer.valueOf(qtdeHomem.getText().toString());
                                qtdeCarneSOsso += CARNES_MULHER * Integer.valueOf(qtdeMulher.getText().toString());
                                qtdeCarneSOsso += CARNES_CRIANCA * Integer.valueOf(qtdeCrianca.getText().toString());

                            }

                            if (frango.isChecked()){

                                qtdeFrango = CARNES_HOMEM * Integer.valueOf(qtdeHomem.getText().toString());
                                qtdeFrango += CARNES_MULHER * Integer.valueOf(qtdeMulher.getText().toString());
                                qtdeFrango += CARNES_CRIANCA * Integer.valueOf(qtdeCrianca.getText().toString());

                            }
                            if (linguica.isChecked()){

                                qtdeLinguica = CARNES_HOMEM * Integer.valueOf(qtdeHomem.getText().toString());
                                qtdeLinguica += CARNES_MULHER * Integer.valueOf(qtdeMulher.getText().toString());
                                qtdeLinguica += CARNES_CRIANCA * Integer.valueOf(qtdeCrianca.getText().toString());

                            }

                        }

                        qtdeTotalCarnes = qtdeCarneCOsso + qtdeCarneSOsso + qtdeFrango + qtdeLinguica;

                        resultado.setText("A quantidade é a seguinte: \n"
                                +  "carne com osso: " + String.format("%.2f", qtdeCarneCOsso) + "g \n"
                                +   "carne sem osso: " + String.format("%.2f", qtdeCarneSOsso) + "g \n"
                                +   "frango (coxa, ...): " + String.format("%.2f", qtdeFrango) + "g \n"
                                +   "linguiça ou salsicha: " + String.format("%.2f", qtdeLinguica) + "g \n \n"
                                +   "total de carnes: " + String.format("%.2f", qtdeTotalCarnes) + "g \n");

                    } // Fim com tipos selecionados
                      else {

                        Toast.makeText(MainActivity.this, "Não há tipos de carnes selecionados", Toast.LENGTH_SHORT).show();

                    } // Fim carnes

                } // Fim pessoas

            }
        });

    }
}
