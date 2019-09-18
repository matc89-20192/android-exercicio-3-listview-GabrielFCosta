package matc89.exercicio3;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;

class TarefaAdapter extends ArrayAdapter<Tarefa> {

   // private ArrayList<Tarefa> taskList;
  //  private Context mContext;

    TarefaAdapter(Context act, ArrayList<Tarefa> tarefas) {
        super(act,0,tarefas);
        //taskList = tarefas;
       // mContext = act;
    }

    @Override
    @NonNull public View getView(int position, View convertView, @NonNull  ViewGroup parent) {

        View view = convertView;

        //Tarefa tarefa = taskList.get(position);
        Tarefa tarefa = getItem(position);
        if(tarefa != null) {
            if (view == null){
                LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(android.R.layout.simple_list_item_2, null);
                //view = LayoutInflater.from(mContext).inflate(R.layout.tarefa_adapter,parent,false);
            }
            /*
            TextView desc = view.findViewById(R.id.desc);
            desc.setText(tarefa.getDescricao());
            TextView prio = view.findViewById(R.id.prio);
            String aux = "Prioridade: " + String.format(Locale.getDefault(),"%d",tarefa.getPrioridade());
            prio.setText(aux);
            */
            TextView text1 = (TextView)view.findViewById(android.R.id.text1);
            TextView text2 = (TextView)view.findViewById(android.R.id.text2);
            text1.setText(tarefa.getDescricao());
            String aux = "Prioridade: " + String.format(Locale.getDefault(),"%d",tarefa.getPrioridade());
            text2.setText(aux);

        }
        return view;

    }
}
