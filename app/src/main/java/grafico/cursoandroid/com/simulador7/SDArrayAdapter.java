package grafico.cursoandroid.com.simulador7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.mmc.jynacore.systemdynamics.SystemDynamicsItem;

public class SDArrayAdapter extends ArrayAdapter<ItemDeListaDeElementosDS> {
    private final Context context;
    private final List<ItemDeListaDeElementosDS> elementos;
    public SDArrayAdapter(Context context, List<ItemDeListaDeElementosDS> elementos) {
        //super(context,);
        super(context, R.layout.listaelementos, elementos);
        this.context = context;
        this.elementos = elementos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listaelementos, parent, false);
        TextView nomeelemento = (TextView) rowView.findViewById(R.id.elemento);
        TextView valorelemento1 = (TextView) rowView.findViewById(R.id.valorelemento);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);
        nomeelemento.setText(elementos.get(position).getElemento());
        valorelemento1.setText(elementos.get(position).getValorelemento());
        imagem.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }
}