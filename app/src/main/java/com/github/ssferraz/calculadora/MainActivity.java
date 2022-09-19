package com.github.ssferraz.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.ssferraz.calculadora.databinding.ActivityMainBinding;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button1.setOnClickListener(v -> binding.textViewResultado.append("1"));
        binding.button2.setOnClickListener(v -> binding.textViewResultado.append("2"));
        binding.button3.setOnClickListener(v-> binding.textViewResultado.append("3"));
        binding.button4.setOnClickListener(v-> binding.textViewResultado.append("4"));
        binding.button5.setOnClickListener(v -> binding.textViewResultado.append("5"));
        binding.button6.setOnClickListener(v -> binding.textViewResultado.append("6"));
        binding.button7.setOnClickListener(v -> binding.textViewResultado.append("7"));
        binding.button8.setOnClickListener(v -> binding.textViewResultado.append("8"));
        binding.button9.setOnClickListener(v -> binding.textViewResultado.append("9"));
        binding.button0.setOnClickListener(v -> binding.textViewResultado.append("0"));

        binding.buttonSomar.setOnClickListener(v -> binding.textViewResultado.append("+"));
        binding.buttonSubtrair.setOnClickListener(v -> binding.textViewResultado.append("-"));
        binding.buttonMultiplicar.setOnClickListener(v -> binding.textViewResultado.append("*"));
        binding.buttonDividir.setOnClickListener(v -> binding.textViewResultado.append("/"));

        TextView textViewResultado = binding.textViewResultado;
        TextView textViewResultado2 = binding.textViewResultado2;
        Button buttonIgual = binding.buttonIgual;
        buttonIgual.setOnClickListener(v -> {
            textViewResultado2.setText("");
            try{
                String textView = binding.textViewResultado.getText().toString();
                Expression expression = new ExpressionBuilder(textView).build();
                double resultado = expression.evaluate();
                long longResult = (long) resultado;
                if(resultado == (double) longResult){
                    textViewResultado.setText((CharSequence) String.valueOf(longResult));
                } else {
                    textViewResultado.setText((CharSequence) String.valueOf(resultado));
                }
            } catch (Exception e){
                textViewResultado2.setText("Expressão inválida");
                textViewResultado.setText("");
            }
        });

    }

    public void limpar(View view){
        Button limpar = binding.limpar;
        TextView textViewResultado = binding.textViewResultado;
        TextView textViewResultado2 = binding.textViewResultado2;
        textViewResultado.setText("");
        textViewResultado2.setText("");
    }

}