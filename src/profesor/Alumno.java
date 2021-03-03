package profesor;

import java.util.Scanner;
import java.util.TreeMap;

public class Alumno extends Persona {

    private String curso;//comprobar su existencia en Treemaps tmCursos
    private TreeMap<String, Notas> tmAsignaturasAlumno = new TreeMap<>();

    public Alumno(String curso, String nombre, String apellidos, String calle,
            String codigoPostal, String ciudad, String dni, String fechaNacimiento) {
        super(nombre, apellidos, calle, codigoPostal, ciudad, dni, fechaNacimiento);
        this.curso = curso;
    }

    public Alumno() {
        super();
    }

    @Override
    public void pideDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ALUMNO");
        super.pideDatos();

        do {
            System.out.print("Curso: ");
            curso = sc.nextLine();
            comprobarCurso();
            if (comprobarCurso() == false) {
                System.out.println("El curso no está en la lista");
            }
        } while (comprobarCurso() == false);

        System.out.println("Asignaturas matriculadas ");
        String repetir;
        String asignatura;

        do {
            do {
                System.out.print("Código asignatura: ");
                asignatura = sc.nextLine();
                if (comprobarAsignatura(asignatura) == false) {
                    System.out.println("La asignatura no es correcta");
                }
            } while (comprobarAsignatura(asignatura) == false);
            Notas n = new Notas();
            tmAsignaturasAlumno.put(asignatura, n);
            System.out.print("¿Desea añadir más asignaturas? S=Sí Otro = No: ");
            repetir = sc.nextLine();
        } while (repetir.equalsIgnoreCase("s") == true);
        
        /* xception in thread "main" java.lang.NullPointerException:
        Cannot invoke "java.util.TreeMap.put(Object, Object)" because 
        "this.tmAsignaturasAlumno" is null
	at profesor.Alumno.pideDatos(Alumno.java:49)
	at profesor.CentroEducativo.main(CentroEducativo.java:118) 
        */

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" -- ALUMNO --");
        sb.append(super.toString());
        sb.append("\nCurso: ");
        sb.append(curso);
        return sb.toString();

    }

    public String boletinNotas(String curso, int evaluacion) {
        StringBuilder sb = new StringBuilder("Boletín de Notas");
        for (String valor : tmAsignaturasAlumno.keySet()) {

            sb.append(valor);
            sb.append(": ");
            sb.append(tmAsignaturasAlumno.get(valor).getNotas(evaluacion));

        }
        return sb.toString();
    }

    public boolean comprobarCurso() {
        return CentroEducativo.tmCC.containsKey(this.curso);
    }

    public boolean comprobarAsignatura(String asignatura) {

        return CentroEducativo.tmASIGNA.containsKey(asignatura);
        

    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public TreeMap<String, Notas> getTmAsignaturasAlumno() {
        return tmAsignaturasAlumno;
    }

    public void setTmAsignaturasAlumno(TreeMap<String, Notas> tmAsignaturasAlumno) {
        this.tmAsignaturasAlumno = tmAsignaturasAlumno;
    }

    public class Notas {

        public int notas[];

        Notas() {
            notas = new int[5];
            //notas = new int[]{0,0,0,0,0};
        }

        public int getNotas(int evaluacion) {
            return notas[evaluacion - 1];
        }

        public void setNotas(int evaluacion, int nota) {
            this.notas[evaluacion - 1] = nota;
        }

    }

}
