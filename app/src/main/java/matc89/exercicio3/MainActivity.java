package matc89.exercicio3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    ListView Lista;
    TarefaAdapter adapter;
    ArrayList<Tarefa> tarefas;
    EditText descricao;
    EditText prioridade;
    Button remover;
    String desc;
    int prio;
    Tarefa tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        descricao= (EditText) findViewById(R.id.editDescricao);
        prioridade= (EditText) findViewById(R.id.editPrioridade);
        Lista = (ListView) findViewById(R.id.listView);
        remover = (Button)findViewById(R.id.buttonRemover);
        remover.setEnabled(false);

        tarefas = new ArrayList<>();
        adapter = new TarefaAdapter(this,tarefas);
        Lista.setAdapter(adapter);

        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tarefa tarefadel = (Tarefa) parent.getItemAtPosition(position);
                tarefas.remove(tarefadel);
                adapter.notifyDataSetChanged();
                if(tarefas.isEmpty())
                    remover.setEnabled(false);
            }
        });

    }

    public void adicionar(View v){
        desc = descricao.getText().toString();
        prio = Integer.parseInt(prioridade.getText().toString());
        if(!DescricaoRepetida(desc)){
            if(!Prioridadeinvalida(prio)){
                tarefa = new Tarefa(desc,prio);
                tarefas.add(tarefa);
                Collections.sort(tarefas);
                adapter.notifyDataSetChanged();
                remover.setEnabled(true);
            }
            else
                Toast.makeText(this, "A prioridade deve estar entre 1 e 10.", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Tarefa já cadastrada.", Toast.LENGTH_SHORT).show();
    }

    public void remover(View v){
        tarefas.remove(0);
        adapter.notifyDataSetChanged();
        if(tarefas.isEmpty())
            remover.setEnabled(false);
    }

    private boolean DescricaoRepetida(String desc){
        for(Tarefa obj : tarefas){
            if(desc.equalsIgnoreCase(obj.getDescricao()))
                return true;
        }
        return false;
    }

    private boolean Prioridadeinvalida(int prio){
        if(prio < 1 || prio > 10)
            return true;
        else
            return false;
    }

    /*
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("lista",tarefas);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        tarefas = savedInstanceState.getParcelableArrayList("lista");
    }
    */



}
