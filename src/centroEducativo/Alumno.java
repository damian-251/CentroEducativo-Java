package centroEducativo;

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

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" -- ALUMNO --");
        sb.append(super.toString());
        sb.append("\nCurso: ");
        sb.append(curso);
        return sb.toString();

    }

    public String boletinNotas(int evaluacion) {
        StringBuilder sb = new StringBuilder("\nBoletín de Notas\n");

        sb.append(super.getApellidos());
        sb.append(", ");
        sb.append(super.getNombre());

        for (String valor : tmAsignaturasAlumno.keySet()) {

            sb.append("\n");
            sb.append(valor);
            sb.append(": ");
            sb.append(tmAsignaturasAlumno.get(valor).getNotas(evaluacion));

        }
        sb.append("\n");
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

    public void setEvaluacion(String asignatura, int evaluacion, int nota) {

        tmAsignaturasAlumno.get(asignatura).setNotas(evaluacion, nota);

    }

    public void setTmAsignaturasAlumno(TreeMap<String, Notas> tmAsignaturasAlumno) {
        this.tmAsignaturasAlumno = tmAsignaturasAlumno;
    }
    
    

}
