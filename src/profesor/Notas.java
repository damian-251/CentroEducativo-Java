package profesor;

public class Notas {

    public int notas[];

    Notas() {
        notas = new int[5];
    }

    public int getNotas(int evaluacion) {
        return notas[evaluacion-1];
    }

    public void setNotas(int evaluacion, int nota) {
        this.notas[evaluacion-1] = nota;
    }
    
    

}
