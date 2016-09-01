package app.com.oddonto.oddontoteste;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.TextView;

import app.com.oddonto.oddontoteste.dialog.ExitDialog;
import app.com.oddonto.oddontoteste.helper.BaseActivity;

public class MainActivity extends BaseActivity implements ExitDialog.ExitDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(R.layout.cmp_search_bar);
        }
    }

    @Override
    public void onBackPressed() {
        ExitDialog exitDialog = new ExitDialog();
        exitDialog.show(getFragmentManager(), "bananadescascada");
    }

    @Override
    public void onExit() {
        finish();
    }

    public void btnVerClinica1_Click(View view) {
        Intent detalhesEmpresa = new Intent(this, DetalheEmpresa.class);
        detalhesEmpresa.putExtra("Clinica", "1");
        startActivity(detalhesEmpresa);

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    //Executar Serviço
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        *//*TextView textView = (TextView)findViewById(R.id.TextoQualquer);
                        textView.setText("Pruuu");*//*

                        //Toast.makeText(MainActivity.this, "teste", Toast.LENGTH_LONG).show();

                        *//*Toast toast = new Toast(MainActivity.this);
                        toast.setView(getLayoutInflater().inflate(R.layout.nome_qualquer, null));
                        toast.show();*//*
                    }
                });
            }
        }).start();*/

       /* EditText txtInput = (EditText)findViewById(R.id.txtInput);
        OutroServico outroServico = new OutroServico();
        outroServico.execute(txtInput.getText().toString());*/
    }

    public void btnVerClinica2_Click(View view) {
        Intent detalhesEmpresa = new Intent(this, DetalheEmpresa.class); //chamada explícita
        //Intent detalhesEmpresa = new Intent("app.com.oddonto.oddontoteste.DetalheEmpresa");
        detalhesEmpresa.putExtra("Clinica", "2");
        startActivity(detalhesEmpresa);
    }

    public void btnLigarClinica_Click(View view) {
        TextView telefone = (TextView)view;
        String numeroTelefone = telefone.getText().toString();

        String uri = "tel:" + numeroTelefone.trim();
        Intent intent = new Intent(Intent.ACTION_DIAL); //chamada implícita
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public class OutroServico extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            TextView textView = (TextView)findViewById(R.id.textoExibir);
            textView.setText("Carregando...");
        }

        @Override
        protected String doInBackground(String... strings) { // String... strings = quantos parâmetros quiser
            String msg = strings[0];

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return msg;
        }

        @Override
        protected void onPostExecute(final String s) {
            super.onPostExecute(s);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView textoExibir = (TextView)findViewById(R.id.textoExibir);
                    textoExibir.setText(s);
                }
            });
        }
    }
}
