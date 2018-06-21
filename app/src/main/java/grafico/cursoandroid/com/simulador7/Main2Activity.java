package grafico.cursoandroid.com.simulador7;

import android.content.Intent;
import android.os.Parcelable;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.ufjf.mmc.jynacore.JynaSimulation;
import br.ufjf.mmc.jynacore.JynaSimulationData;
import br.ufjf.mmc.jynacore.JynaSimulationProfile;
import br.ufjf.mmc.jynacore.systemdynamics.FiniteStock;
import br.ufjf.mmc.jynacore.systemdynamics.InfiniteStock;
import br.ufjf.mmc.jynacore.systemdynamics.Information;
import br.ufjf.mmc.jynacore.systemdynamics.Rate;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsItem;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsModel;
import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsModelStorer;
import br.ufjf.mmc.jynacore.systemdynamics.Variable;
import br.ufjf.mmc.jynacore.systemdynamics.impl.DefaultSystemDynamicsModelStorerJDOM;
import br.ufjf.mmc.jynacore.systemdynamics.impl.DefaultVariable;
import br.ufjf.mmc.jynacore.systemdynamics.simulator.impl.DefaultSystemDynamicsEulerMethod;


public class Main2Activity extends AppCompatActivity {
    private JynaSimulationProfile profile;
    private JynaSimulationData data;
    private JynaSimulation simulation;
    private DefaultSystemDynamicsEulerMethod method;
    List<SystemDynamicsItem> chaveselementos = new ArrayList<>();
    List<String> nomeElemento = new ArrayList<>();
    List<SystemDynamicsItem> elementos = new ArrayList<>();
    List<ItemDeListaDeElementosDS> listaElementos = new ArrayList<>();
    public static FiniteStock estoqueSelecionado;
    public static Variable variavelSelecionada;
    public static Rate rateSelecionada;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        Log.i("teste", "onCreate: lista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extra = getIntent().getExtras();
       final File file2 = (File) extra.get("file");

        try {

            SystemDynamicsModelStorer storer = new DefaultSystemDynamicsModelStorerJDOM();

            final SystemDynamicsModel modelSD = storer.loadFromFile(file2);

            for (Map.Entry<String, SystemDynamicsItem> verbete : modelSD.getItems().entrySet()) {
                String chave = verbete.getKey();
                SystemDynamicsItem item = verbete.getValue();

                if (item instanceof Variable) {
                    listaElementos.add(new ItemDeListaDeElementosDS(
                            item.getName(),
                            "[VARIABLE]",
                            R.drawable.escola1,
                            item
                    ));
                    nomeElemento.add(item.getName());
                    nomeElemento.add("[VARIABLE]  " + ((Variable) item).getExpression());
                   // imagens[x]=R.drawable.escola1;

                } else if (item instanceof FiniteStock) {
                    listaElementos.add(new ItemDeListaDeElementosDS(
                            item.getName(),
                            "[STOCK]",
                            0,
                            item
                    ));                   nomeElemento.add(item.getName());
                    nomeElemento.add("[STOKE]  " + ((FiniteStock) item).getInitialValue());
                   // imagens[x]=R.drawable.escola1;

                } else if (item instanceof InfiniteStock) {
                    listaElementos.add(new ItemDeListaDeElementosDS(
                            item.getName(),
                            "[CLOUD]",
                            0,
                            item
                    ));
                    nomeElemento.add(item.getName());
                    nomeElemento.add("[INFSTOKE]  ");
                   // imagens[x]=R.drawable.escola1;

                } else if (item instanceof Rate) {
                    listaElementos.add(new ItemDeListaDeElementosDS(
                            item.getName(),
                            "[RATE]",
                            0,
                            item
                    ));
                    nomeElemento.add(item.getName());
                    nomeElemento.add("[RATE]  " + ((Rate) item).getExpression());
                   // imagens[x]=R.drawable.escola1;

                } else if (item instanceof Information) {
                    listaElementos.add(new ItemDeListaDeElementosDS(
                            item.getName(),
                            "[INFO]",
                            0,
                            item
                    ));
                    nomeElemento.add(item.getName());
                    nomeElemento.add("[INF]  ");
                   // imagens[x]=R.drawable.escola1;

                } else {
                    listaElementos.add(new ItemDeListaDeElementosDS(
                            item.getName(),
                            "[???]",
                            0,
                            item
                    ));
                    nomeElemento.add(item.getName());
                    nomeElemento.add("[???]  ");
                  //  imagens[x]=R.drawable.escola1;
                }

                chaveselementos.add(item);

            }


          /*  ListView gv= (ListView) findViewById(R.id.listView);
            final ArrayAdapter<String> adaptador= new ArrayAdapter<String>(
                    getBaseContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    elementos
            );
            gv.setAdapter(adaptador);*/


            ListView lista = (ListView) findViewById(R.id.listelementos);
            //final ArrayList<ItemDeListaDeElementosDS> alista = adicionarelementos();
            final ArrayAdapter adapter = new SDArrayAdapter(this, listaElementos);
            lista.setAdapter(adapter);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Log.i("SELECTED: ",chaveselementos.get(i).getClass().toString() );

                    if(chaveselementos.get(i) instanceof Variable)
                    {

                        Intent iAux = new Intent(Main2Activity.this, AuxiliaryActivity.class);
                        Variable variable = (Variable) chaveselementos.get(i);
                        variavelSelecionada = variable;
                      //  iAux.putExtra("name", variable.getName());
                      //  iAux.putExtra("value", variable.getValue());
                       // iAux.putExtra("exp", variable.getExpression().toString());
                        startActivity(iAux);

                    }

                 else if(chaveselementos.get(i) instanceof FiniteStock)
                    {

                        Intent iAux = new Intent(Main2Activity.this, finiteActivity.class);
                        FiniteStock finite = (FiniteStock) chaveselementos.get(i);
                        estoqueSelecionado = finite;
                        startActivity(iAux);

                    }

                   else if(chaveselementos.get(i) instanceof InfiniteStock)
                    {

                        Intent iAux = new Intent(Main2Activity.this, InfiniteActivity.class);
                        InfiniteStock infinite = (InfiniteStock) chaveselementos.get(i);
                        iAux.putExtra("name", infinite.getName());
                        startActivity(iAux);

                    }
                   else if(chaveselementos.get(i) instanceof Information)
                    {

                        Intent iAux = new Intent(Main2Activity.this, informationActivity.class);
                        Information information = (Information) chaveselementos.get(i);
                        iAux.putExtra("name", information.getName());
                        startActivity(iAux);

                    }
                   else if(chaveselementos.get(i) instanceof Rate)
                    {

                        Intent iAux = new Intent(Main2Activity.this, rateActivity.class);
                        Rate rate = (Rate) chaveselementos.get(i);
                        rateSelecionada = rate;
                       // iAux.putExtra("name", rate.getName());
                        //iAux.putExtra("exp", rate.getValue());
                       // iAux.putExtra("value", rate.getExpression().toString());
                        startActivity(iAux);

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), " tipo desconhecido",Toast.LENGTH_LONG).show();

                    }

                }
            });

        } catch (Exception e) {
            Log.e("Ruim", e.toString());        }

    }
  /*  private ArrayList<ItemDeListaDeElementosDS> adicionarelementos() {
        ArrayList<ItemDeListaDeElementosDS> oselementos = new ArrayList<ItemDeListaDeElementosDS>();

       String Elementos[]= nomeElemento.toArray(new String[nomeElemento.size()]);

        int n= (nomeElemento.size()+1)/2;
        //x=0;

        for (int k=0;k<n;k++) {

          //  ItemDeListaDeElementosDS e = new ItemDeListaDeElementosDS(Elementos[x], Elementos[x + 1], imagens[k]);
         //  x=x+2;

         //   oselementos.add(e);
        }

        return oselementos;
    }*/


}
