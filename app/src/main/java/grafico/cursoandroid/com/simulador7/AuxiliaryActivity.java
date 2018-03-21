package grafico.cursoandroid.com.simulador7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AuxiliaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliary);
        Bundle extra = getIntent().getExtras();
        String nome = (String) extra.get("name");
        String expressao = (String) extra.get("value");
        String valor = (String) extra.get("exp");

        TextView nome1 = (TextView) findViewById(R.id.finitenome);
        TextView expressao1 = (TextView)findViewById(R.id.auxiex);
        EditText valor1 = (EditText)findViewById(R.id.auxival);

        nome1.setText(nome);
        expressao1.setText(expressao);
        valor1.setText(valor);

    }
}
