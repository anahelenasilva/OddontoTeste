package app.com.oddonto.oddontoteste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import app.com.oddonto.oddontoteste.helper.BaseActivity;

public class DetalheEmpresa extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_empresa);

        Intent intent = getIntent();
        String message = intent.getStringExtra("Clinica");
        TextView nomeClinica = (TextView)findViewById(R.id.nome);
        TextView enderecoClinica = (TextView)findViewById(R.id.endereco);
        TextView telefoneClinica = (TextView)findViewById(R.id.telefone);

        if (message.equals("1")) {
            nomeClinica.setText(R.string.Clinica1);
            enderecoClinica.setText(R.string.EnderecoClinica1);
            telefoneClinica.setText(R.string.TelefoneClinica1);
        }
        else {
            nomeClinica.setText(R.string.Clinica2);
            enderecoClinica.setText(R.string.EnderecoClinica2);
            telefoneClinica.setText(R.string.TelefoneClinica2);
        }
    }
}
