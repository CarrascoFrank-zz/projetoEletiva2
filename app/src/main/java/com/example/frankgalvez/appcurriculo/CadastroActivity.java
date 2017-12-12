package com.example.frankgalvez.appcurriculo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextnome;
    private EditText editTextEndereco;
    private EditText editTextEstado;
    private EditText editTextCidade;
    private EditText editTextTelefone;
    private EditText editTextEmail;
    private Button buttonGravar;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextnome = (EditText) findViewById(R.id.id_editTextName);
        editTextEndereco = (EditText) findViewById(R.id.id_editTextEndereco);
        editTextEstado = (EditText) findViewById(R.id.id_EditTextCidade);
        editTextCidade = (EditText) findViewById(R.id.id_EditTextCidade);
        editTextTelefone = (EditText) findViewById(R.id.id_editTextTelefone);
        editTextEmail = (EditText) findViewById(R.id.id_editTextEmail);
        buttonGravar = (Button) findViewById(R.id.id_buttonGravar);

        buttonGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (editTextnome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext()," Favor Preencher um nome",Toast.LENGTH_LONG).show();
                }
                if (editTextEndereco.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext()," Favor Preencher um endereco",Toast.LENGTH_LONG).show();
                }
                if (editTextEstado.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext()," Favor Preencher um Estado",Toast.LENGTH_LONG).show();
                }if (editTextCidade.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext()," Favor Preencher um Cidade",Toast.LENGTH_LONG).show();
                }if (editTextTelefone.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext()," Favor Preencher um telefone",Toast.LENGTH_LONG).show();
                }if (editTextEmail.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext()," Favor Preencher um email",Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("nome", editTextnome.getText().toString());
                    editor.putString("endereco", editTextEndereco.getText().toString());
                    editor.putString("estado", editTextEstado.getText().toString());
                    editor.putString("cidade", editTextCidade.getText().toString());
                    editor.putString("telefone", editTextTelefone.getText().toString());
                    editor.putString("email", editTextEmail.getText().toString());
                    editor.commit();

                    Toast.makeText(getApplicationContext(), "Dados Salvos ! ", Toast.LENGTH_LONG).show();

                    editTextnome.setText(editTextnome.getText().toString());
                    editTextEndereco.setText(editTextEndereco.getText().toString());
                    editTextEstado.setText(editTextEstado.getText().toString());
                    editTextCidade.setText(editTextCidade.getText().toString());
                    editTextTelefone.setText(editTextTelefone.getText().toString());
                    editTextEmail.setText(editTextEmail.getText().toString());
                }


            }
        });

        //recuperando os dados do sharedpreference.

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if(sharedPreferences.contains("nome")){

            String nome = sharedPreferences.getString("nome", "nome nao definido");
            editTextnome.setText(nome);
            String endereco = sharedPreferences.getString("endereco","nome nao definido");
            editTextEndereco.setText(endereco);
            String estado = sharedPreferences.getString("estado","nome nao definido");
            editTextEstado.setText(estado);
            String cidade = sharedPreferences.getString("cidade","nome nao definido");
            editTextCidade.setText(cidade);
            String telefone = sharedPreferences.getString("telefone","nome nao definido");
            editTextTelefone.setText(telefone);
            String email = sharedPreferences.getString("email","nome nao definido");
            editTextEmail.setText(email);

        }else{
            //retorno caso ele nao tenha o nome no sharedpreference

            Toast.makeText(getApplicationContext(), "dados nao encontrados", Toast.LENGTH_LONG).show();

        }



    }
}
