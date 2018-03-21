package grafico.cursoandroid.com.simulador7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class informationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Bundle extra = getIntent().getExtras();
        String nome = (String) extra.get("name");

        TextView nome1 = (TextView) findViewById(R.id.finitenome);

        nome1.setText(nome);
    }
}
