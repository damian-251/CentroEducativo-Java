package centroEducativo;

public class Notas {

    public int notas[] = new int[5];

    Notas() {
        //notas = new int[]{0,0,0,0,0};
    }

    public int getNotas(int evaluacion) {
        return notas[evaluacion - 1];
    }

    public void setNotas(int evaluacion, int nota) {
        this.notas[evaluacion - 1] = nota;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }
    
    

}
