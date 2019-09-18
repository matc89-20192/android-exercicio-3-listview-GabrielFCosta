package matc89.exercicio3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    ListView Lista;
    TarefaAdapter adapter;
    ArrayList<Tarefa> tarefas;
    EditText descricao;
    EditText prioridade;
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
        tarefas = new ArrayList<>();
        adapter = new TarefaAdapter(this,tarefas);
        Lista.setAdapter(adapter);
    }

    public void adicionar(View v){
        desc = descricao.getText().toString();
        prio = Integer.parseInt(prioridade.getText().toString());
        tarefa = new Tarefa(desc,prio);
        tarefas.add(tarefa);
        Collections.sort(tarefas);
        adapter.notifyDataSetChanged();
    }

    //Verificar isso
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



}
