package grafico.cursoandroid.com.simulador7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.util.Map;

import br.ufjf.mmc.jynacore.systemdynamics.FiniteStock;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsItem;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsModel;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsModelStorer;
import br.ufjf.mmc.jynacore.systemdynamics.impl.DefaultFiniteStock;
import br.ufjf.mmc.jynacore.systemdynamics.impl.DefaultSystemDynamicsModelStorerJDOM;

public class finiteActivity extends AppCompatActivity {
    private EditText valor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finite);

        FiniteStock finite = Main2Activity.estoqueSelecionado;
        Button salvar = (Button) findViewById(R.id.buttonsavefinite);

        TextView nome1 = (TextView) findViewById(R.id.finitenome);
         valor1 = (EditText)findViewById(R.id.finiteval);

        nome1.setText(finite.getName());
        valor1.setText(finite.getInitialValue().toString());

        //finite.setInitialValue(20.0);

        /*SystemDynamicsModelStorer storer = new DefaultSystemDynamicsModelStorerJDOM();
        SystemDynamicsModel modelSD = null;

        try {
            modelSD = storer.loadFromFile(file2);
        } catch (Exception e) {
            Log.e("Ruim", e.toString());
        }*/

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Main2Activity.estoqueSelecionado.setInitialValue(Double.parseDouble(valor1.getText().toString()));
            }
        });
    }
}
