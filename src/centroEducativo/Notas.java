
package centroEducativo;

public class Notas {
    
    public int notas[];

        Notas() {
        this.notas = new int[5];
            //notas = new int[]{0,0,0,0,0};
        }

        public int getNotas(int evaluacion) {
            return notas[evaluacion - 1];
        }

        public void setNotas(int evaluacion, int nota) {
            this.notas[evaluacion - 1] = nota;
        }
    
}
