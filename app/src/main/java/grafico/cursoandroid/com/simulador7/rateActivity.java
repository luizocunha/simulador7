package grafico.cursoandroid.com.simulador7;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import br.ufjf.mmc.jynacore.systemdynamics.Rate;

public class rateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
       // Bundle extra = getIntent().getExtras();
      //  String nome = (String) extra.get("name");
      //  String expressao = (String) extra.get("value");
      //  String valor = (String) extra.get("exp");

        TextView nome1 = (TextView) findViewById(R.id.finitenome);
        TextView expressao1 = (TextView)findViewById(R.id.rateex);
     //   EditText valor1 = (EditText)findViewById(R.id.rateval);
        Rate rate = Main2Activity.rateSelecionada;

        nome1.setText(rate.getName());
        expressao1.setText(rate.getExpression().toString());
      //  valor1.setText(rate.getExpression().toString());
    }
}
