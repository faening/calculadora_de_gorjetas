package com.course.android.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText rec_valorPedido;
    private TextView rec_valorTotalPedido, rec_valorTotalGorjeta;
    private SeekBar rec_percentualGorjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rec_valorPedido = findViewById(R.id.InputValorPedido);
        rec_percentualGorjeta = findViewById(R.id.SeekbarPercentualGorjeta);
        rec_valorTotalPedido = findViewById(R.id.TxtResultadoTotalPedido);
        rec_valorTotalGorjeta = findViewById(R.id.TxtResultadoTotalGorjeta);

        // Total -> Pedido
        Double valorPedido = Double.parseDouble(rec_valorPedido.getText().toString());

        if (valorPedido > 0.0) {
            rec_valorTotalPedido.setText(rec_valorPedido.getText().toString());
        }

        // Total -> Gorjeta
        rec_percentualGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (valorPedido <= 0.0) {
                    rec_valorTotalGorjeta.setText("0.00");
                } else {
                    rec_valorTotalGorjeta.setText(String.valueOf(i));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Total -> Total geral

    }

}