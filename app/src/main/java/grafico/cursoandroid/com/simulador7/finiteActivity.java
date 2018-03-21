package grafico.cursoandroid.com.simulador7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class finiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finite);
        Bundle extra = getIntent().getExtras();
        String nome = (String) extra.get("name");
        String valor = (String) extra.get("value");

        TextView nome1 = (TextView) findViewById(R.id.finitenome);
        EditText valor1 = (EditText)findViewById(R.id.finiteval);

        nome1.setText(nome);
        valor1.setText(valor);
    }
}
