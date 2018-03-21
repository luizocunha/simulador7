package grafico.cursoandroid.com.simulador7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.ufjf.mmc.jynacore.JynaSimulableModel;
import br.ufjf.mmc.jynacore.JynaSimulation;
import br.ufjf.mmc.jynacore.JynaSimulationData;
import br.ufjf.mmc.jynacore.JynaSimulationProfile;
import br.ufjf.mmc.jynacore.impl.DefaultSimulationData2;
import br.ufjf.mmc.jynacore.impl.DefaultSimulationProfile;
import br.ufjf.mmc.jynacore.systemdynamics.FiniteStock;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsItem;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsModel;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsModelStorer;
import br.ufjf.mmc.jynacore.systemdynamics.impl.DefaultSystemDynamicsModelStorerJDOM;
import br.ufjf.mmc.jynacore.systemdynamics.simulator.impl.DefaultSystemDynamicsEulerMethod;
import br.ufjf.mmc.jynacore.systemdynamics.simulator.impl.DefaultSystemDynamicsSimulation;


public class MainActivity extends AppCompatActivity {

    private List<String> minhaLista;

    private JynaSimulationProfile profile;
    private JynaSimulationData data;
    private JynaSimulation simulation;
    private DefaultSystemDynamicsEulerMethod method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minhaLista = new ArrayList<String>();

            String secStore = System.getenv("SECONDARY_STORAGE");
            File sdCard = new File(secStore);
        File modelsDir = new File(sdCard,"/modelos");
            final File[] list = modelsDir.listFiles();


        for( int i=0; i< list.length; i++)
        {
            minhaLista.add( list[i].getName() );
        }

        int x = minhaLista.size();

        ListView lv= (ListView) findViewById(R.id.listaid);
        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                minhaLista
        );

       lv.setAdapter(adaptador);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("x", i);
                intent.putExtra("file", list[i]);
                startActivity(intent);
            }
        });

    }
}
