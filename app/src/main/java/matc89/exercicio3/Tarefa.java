package matc89.exercicio3;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.io.Serializable;

class Tarefa implements Comparable<Tarefa>,Parcelable,Serializable {
    private String descricao;
    private int prioridade;

    Tarefa(String descricao, int prioridade) {
        this.setDescricao(descricao);
        this.setPrioridade(prioridade);
    }

    void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    String getDescricao() {
        return descricao;
    }

    int getPrioridade() {
        return prioridade;
    }

    @Override
    public int compareTo( @NonNull Tarefa outro) {
        if(this.getPrioridade() < outro.getPrioridade()) {
            return -1;
        }
        if(this.getPrioridade() > outro.getPrioridade()) {
            return 1;
        }
        return 0;
    }


    //Implementação de parcelable para onSaveInstance/onRestoreInstance sem resultado.
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeInt(this.describeContents());
        out.writeSerializable(this);
    }
    public static final Parcelable.Creator<Tarefa> CREATOR = new Parcelable.Creator<Tarefa>() {
        public Tarefa createFromParcel(Parcel in) {
            return new Tarefa(in);
        }

        public Tarefa[] newArray(int size) {
            return new Tarefa[size];
        }
    };
    private Tarefa(Parcel in) {
        descricao = in.readString();
        prioridade = in.readInt();
    }


}