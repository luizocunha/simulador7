package grafico.cursoandroid.com.simulador7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.ufjf.mmc.jynacore.expression.Expression;
import br.ufjf.mmc.jynacore.systemdynamics.Variable;

public class AuxiliaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliary);
      //  Bundle extra = getIntent().getExtras();
       // String nome = (String) extra.get("name");
       // String expressao = (String) extra.get("value");
       // String valor = (String) extra.get("exp");

        Variable variable = Main2Activity.variavelSelecionada;

        TextView nome1 = (TextView) findViewById(R.id.finitenome);
     //   TextView expressao1 = (TextView)findViewById(R.id.auxiex);
        final EditText valor1 = (EditText)findViewById(R.id.auxival);

        nome1.setText(variable.getName().toString());
     //   expressao1.setText(expressao);
        valor1.setText(variable.getExpression().toString());

        Button salvar = (Button) findViewById(R.id.salvarauxi);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Main2Activity.variavelSelecionada.setExpression((Expression) (valor1.getText()));
            }
        });

    }
}
