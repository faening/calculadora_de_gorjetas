package com.course.android.calculadoradegorjeta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

// @SuppressWarnings("FieldCanBeLocal");
public class MainActivity extends AppCompatActivity {
    private TextView ref_valorPedido, ref_valorTotalpedido, ref_valorTotalGorjeta, ref_valorTotalGeral;
    private SeekBar ref_percentualGorjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref_valorPedido = findViewById(R.id.InputValorPedido);
        ref_valorTotalpedido = findViewById(R.id.TxtResultadoTotalPedido);
        ref_valorTotalGorjeta = findViewById(R.id.TxtResultadoTotalGorjeta);
        ref_percentualGorjeta = findViewById(R.id.SeekbarPercentualGorjeta);
        ref_valorTotalGeral = findViewById(R.id.TxtResultadoTotalGeral);

        ref_percentualGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            Double valorPedido = ref_valorPedido.getText().toString().isEmpty() ? 0.0 : Double.parseDouble(ref_valorPedido.getText().toString());

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (valorPedido <= 0.0) {
                    Toast.makeText(getApplicationContext(),
                            "Oporra, informa o valor do pedido ai caralho...",
                            Toast.LENGTH_LONG
                    ).show();
                }

                // Calcular valor da gorjeta
                Double gorjeta = Double.parseDouble(ref_valorPedido.getText().toString()) * ref_percentualGorjeta.getProgress() / 100.0;
                ref_valorTotalGorjeta.setText(gorjeta.toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Calcular o valor total do pedido
                Double totalGeral = Double.parseDouble( ref_valorTotalGeral.getText().toString() + ref_valorTotalGorjeta);
                ref_valorTotalGeral.setText(totalGeral.toString());
            }
        });

    }

}