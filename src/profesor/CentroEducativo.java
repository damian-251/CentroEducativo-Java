package profesor;

/* 
Tareas pendientes:
 -Clase alumno
 -Aviso en las opciones del treemap vacio donde se requiera
 -Mirar los filtros de la anterior práctica
 -Mostrar correctamente el listado de asignaturas
 -Revisar el mantenimiento de asignaturas del Profesor


 */
import java.util.Scanner;
import java.util.TreeMap;

public class CentroEducativo {

    public static TreeMap<String, Persona> lista = new TreeMap<String, Persona>();
    public static TreeMap<String, String> tmEEEE = new TreeMap<String, String>();//Map con entidades bancarias
    public static TreeMap<String, String> tmEEEESSSS = new TreeMap<String, String>();//Map con sucursales bancarias
    public static TreeMap<String, String> tmCC = new TreeMap<String, String>();//Map con nombres de cursos
    public static TreeMap<String, String> tmASIGNA = new TreeMap<String, String>();//Map con curso+asignatura

    private static String curso;
    private static double pagoPorHoraExtra;

    public static String getCurso() {
        return curso;
    }

    public static void setCurso(String curso) {
        CentroEducativo.curso = curso;
    }

    public static double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }

    public static void setPagoPorHoraExtra(double pagoPorHoraExtra) {
        CentroEducativo.pagoPorHoraExtra = pagoPorHoraExtra;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // CARGA DE LAS VARIABLES GLOBALES DE LA APLICACIÓN    
        Cuenta.cargaEntidadesBancarias(tmEEEE);
        Cuenta.cargaSucursalesBancarias(tmEEEESSSS);
        TablaCursos.cargaCursos(tmCC);
        TablaCursos.cargaCursosAsignaturas(tmASIGNA);

        //asignar el atributo estático Curso. NO FILTRAMOS RESULTADO
        System.out.print("Curso: ");
        curso = sc.nextLine();
        CentroEducativo.setCurso(curso);
        System.out.println();

        //asignar el atributo estático pagoPorHoraExtra FILTRAMOS QUE SEA DOUBLE Y ADMITIR ". o ,"
        boolean correcto = false;

        do {
            System.out.print("Importe Horas Extra: ");
            String simporte = sc.nextLine();
            int posicion = simporte.indexOf(',');//si ha introducido , como separador lo cambia por punto
            if (posicion != -1) {
                simporte = simporte.replace(',', '.');
            }
            try {
                double importe = Double.parseDouble(simporte);
                CentroEducativo.setPagoPorHoraExtra(importe);
                System.out.println();
                correcto = true;
            } catch (Exception e) {
                System.out.println("error en caracteres Importe Horas Extra");
                sc.nextLine();
            }
        } while (!correcto);

        String repetir = "";

        int opcion = 0;
        boolean salida = false;

        do {

            System.out.print("\n***************    MENÚ PRINCIPAL    *************** "
                    + "\n1. MANTENIMIENTO ALUMNOS"
                    + "\n2. MANTENIMIENTO PROFESORES"
                    + "\n3. LISTADO DE NOMBRES DE PROFESORES Y ALUMNOS "
                    + "\n4. LISTADO DE NOMBRES DE PROFESORES "
                    + "\n5. LISTADO DE NOMBRES DE ALUMNOS "
                    + "\n0. FIN DE LA APLICACIÓN "
                    + "\n   Opción seleccionada: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    boolean salidaAlumno = false;
                    do {
                        System.out.print("\n***************    MENÚ MANTENIMIENTO ALUMNOS    *************** "
                                + "\n1. ALTA DE UN ALUMNO"
                                + "\n2. BAJA DE UN ALUMNO"
                                + "\n3. CONSULTA DE DATOS PERSONALES DE UN ALUMNO "
                                + "\n4. INTRODUCIR NOTAS DE UNA ASIGNATURA Y EVALUACIÓN A TODOS LOS MATRICULADOS "
                                + "\n5. LISTADO DE NOMBRES DE ALUMNOS DE UN GRUPO. DATOS PERSONALES "
                                + "\n6. LISTADO DE ALUMNOS MATRICULADOS EN UNA ASIGNATURA"
                                + "\n7. LISTADO DE BOLETINES DE NOTAS DE UNA EVALUACIÓN Y CURSO "
                                + "\n0. VUELTA AL MENÚ PRINCIPAL "
                                + "\n   Opción seleccionada: ");
                        opcion = sc.nextInt();
                        sc.nextLine();

                        switch (opcion) {
                            case 1: // ALTA DE UN ALUMNO
                                do {
                                    Persona a = new Alumno();
                                    a.pideDatos();
                                    if (lista.containsKey(a.getApellidos() + " " + a.getNombre())) {
                                        System.out.println("Este nombre ya existe, no puedo grabarlo");
                                    } else {
                                        lista.put(a.getApellidos() + " " + a.getNombre(), a);
                                    }

                                    System.out.print("¿Desea continuar? s=Sí: ");
                                    repetir = sc.nextLine();
                                } while (repetir.equalsIgnoreCase("s") == true);

                                break;

                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:

                                break;
                            case 7:

                                break;
                            case 0:
                                salidaAlumno = true;
                                break;
                            default:
                                System.out.println("La opción no es correcta");
                                break;

                        }
                    } while (!salidaAlumno);
                    break;
                case 2:
                    boolean salidaProfesor = false;
                    do {
                        System.out.print("\n***************    MENÚ MANTENIMIENTO DE PROFESORES    *************** "
                                + "\n1. ALTA DE UN PROFESOR"
                                + "\n2. BAJA DE UN PROFESOR"
                                + "\n3. CONSULTA DE DATOS PERSONALES DE UN PROFESOR "
                                + "\n4. INTRODUCIR HORAS EXTRAORDINARIAS DE UN MES "
                                + "\n5. LISTADO DE PROFESORES. DATOS PERSONALES "
                                + "\n6. LISTADO DE PROFESORES. CLASES QUE IMPARTEN "
                                + "\n7. LISTADO DE NÓMINAS DE UN MES "
                                + "\n8. MANTENIMIENTO DE ASIGNATURAS IMPARTIDAS POR CADA PROFESOR "
                                + "\n0. VUELTA AL MENÚ PRINCIPAL"
                                + "\n   Opción seleccionada: ");
                        opcion = sc.nextInt();
                        sc.nextLine();

                        switch (opcion) {
                            case 1: //ALTA DE UN PROFESOR
                                do {
                                    Persona p = new Profesor();
                                    p.pideDatos();
                                    if (lista.containsKey(p.getApellidos() + " " + p.getNombre())) {
                                        System.out.println("Este nombre ya existe, no puedo grabarlo");
                                    } else {
                                        lista.put(p.getApellidos() + " " + p.getNombre(), p);
                                    }

                                    System.out.print("¿Desea continuar? s=Sí: ");
                                    repetir = sc.nextLine();
                                } while (repetir.equalsIgnoreCase("s") == true);
                                break;

                            case 2: // BAJA DE UN PROFESOR
                                if (lista.isEmpty()) {
                                    System.out.println("La lista está vacía");
                                    break;
                                } else {

                                    do {

                                        do {

                                            try {
                                                System.out.print("Nombre profesor: ");
                                                String nom = sc.nextLine();
                                                System.out.print("Apellidos profesor: ");
                                                String ape = sc.nextLine();
                                                if (lista.containsKey(ape + " " + nom) == false) {

                                                    throw new Exception("El profesor introducido no existe");
                                                    
                                                } else if (lista.get(ape + " " + nom) instanceof Alumno) {
                                                    throw new Exception("Has seleccionada un alumno");
                                                } else {

                                                    lista.remove(ape + " " + nom);
                                                    correcto = true;
                                                }

                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                correcto = false;
                                                break;
                                            }
                                        } while (!correcto);

                                        System.out.print("¿Desea continuar? s=Sí: ");
                                        repetir = sc.nextLine();

                                    } while (repetir.equalsIgnoreCase("s") == true);
                                }
                                break;

                            case 3: //CONSULTA DE DATOS PERSONALES DE UN PROFESOR

                                do {
                                    try {
                                        System.out.print("Nombre profesor: ");
                                        String nom = sc.nextLine();
                                        System.out.print("Apellidos profesor: ");
                                        String ape = sc.nextLine();

                                        if (lista.containsKey(ape + " " + nom) == false
                                                || lista.get(ape + " " + nom) instanceof Alumno) {

                                            correcto = true;
                                            throw new Exception("El profesor introducido no existe");

                                        }
                                        System.out.println(lista.get(ape + " " + nom).toString());

                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }

                                    System.out.print("¿Desea continuar? s=Sí: ");
                                    repetir = sc.nextLine();
                                } while (repetir.equalsIgnoreCase("s") == true);

                                break;
                            case 4: //INTRODUCIR HORAS EXTRAORDINARIAS DE UN MES
                                int mes;
                                int horas = 0;
                                do {
                                    System.out.print("Introducir mes (1=Enero, 12=Diciembre): ");
                                    mes = sc.nextInt();
                                    sc.nextLine();

                                    for (Persona valor : lista.values()) {

                                        if (valor instanceof Profesor) {

                                            System.out.println(valor.getNombre());
                                            System.out.println(valor.getApellidos());
                                            System.out.print("Horas extra: ");
                                            horas = sc.nextInt();
                                            sc.nextLine();
                                            ((Profesor) valor).setHorasExtra(horas, mes - 1);
                                        }

                                    }

                                    System.out.print("¿Desea continuar? s=Sí: ");
                                    repetir = sc.nextLine();

                                } while (repetir.equalsIgnoreCase("s") == true);

                                break;
                            case 5: //LISTADO DE PROFESORES. DATOS PERSONALES

                                for (Persona valor : lista.values()) {

                                    if (valor instanceof Profesor) {

                                        System.out.println(valor.toString());
                                    }
                                }

                                break;

                            case 6: //LISTADO DE PROFESORES. CLASES QUE IMPARTEN
                                System.out.println("Listado de asignaturas por profesor ");
                                for (Persona valor : lista.values()) {
                                    if (valor instanceof Profesor) {
                                        System.out.println(valor.getNombre());
                                        System.out.println(valor.getApellidos());

                                        ((Profesor) valor).imprimeAsignaturas();

                                        System.out.println("");
                                    }

                                }
                                break;

                            case 7: //LISTADO DE NÓMINAS DE UN MES
                                System.out.print("Nóminas del mes: ");
                                mes = sc.nextInt();
                                sc.nextLine();

                                for (Persona valor : lista.values()) {

                                    if (valor instanceof Profesor) {

                                        System.out.println(((Profesor) valor).imprimirNominas(mes - 1));
                                    }

                                }

                                break;

                            case 8: //MANTENIMIENTO DE ASIGNATURAS IMPARTIDAS POR CADA PROFESOR

                                System.out.println("Mantenimiento de asignaturas");
                                System.out.println("Seleccione un profesor: ");
                                System.out.print("Nombre profesor: ");
                                String nom = sc.nextLine();
                                System.out.print("Apellidos profesor: ");
                                String ape = sc.nextLine();
                                System.out.println(lista.get(ape + " " + nom).toString());

                                System.out.print("Mantenimiento de asignaturas: "
                                        + "\nSeleccione una opción "
                                        + "\n1. Añadir asignaturas"
                                        + "\n2. Quitar asignaturas"
                                        + "\n0. Salir "
                                        + "\n Opción seleccionada: ");
                                opcion = sc.nextInt();
                                sc.nextLine();

                                switch (opcion) {
                                    case 1:
                                        ((Profesor) lista.get(ape + " " + nom)).asignaturasProfesor(tmASIGNA);

                                        break;
                                    case 2:

                                        System.out.print("¿Qué asignatura desea eliminar?: ");
                                        String asignatura = sc.nextLine();

                                        ((Profesor) lista.get(ape + " " + nom)).eliminaAsignatura(asignatura);

                                        break;

                                    case 0:
                                        break;

                                }

                                break;
                            case 0:
                                salidaProfesor = true;
                                break;
                            default:
                                System.out.println("La opción no es correcta");
                                break;

                        }
                    } while (!salidaProfesor);
                    break;
                case 3: //LISTADO DE NOMBRES DE PROFESORES Y ALUMNOS

                    for (Persona valor : lista.values()) {

                        if (valor instanceof Profesor) {
                            System.out.println("Profesor " + valor.getApellidos()
                                    + ", " + valor.getNombre());

                        } else if (valor instanceof Alumno) {
                            System.out.println("Alumno " + valor.getApellidos()
                                    + ", " + valor.getNombre());

                        }

                    }

                    break;

                case 4: //LISTADO DE NOMBRES DE PROFESORES
                    for (Persona valor : lista.values()) {

                        if (valor instanceof Profesor) {
                            System.out.println(valor.getApellidos()
                                    + ", " + valor.getNombre());

                        }
                    }

                    break;

                case 5: //LISTADO DE NOMBRES DE ALUMNOS
                    for (Persona valor : lista.values()) {
                        if (valor instanceof Alumno) {
                            System.out.println(valor.getApellidos()
                                    + ", " + valor.getNombre());

                        }

                    }
                    break;
                case 0:
                    salida = true;
                    break;
                default:
                    System.out.println("La opción no es correcta");
                    break;

            }

        } while (!salida);

        /*do {

            System.out.println("\n -- SELECCIONE UNA OPCIÓN: -- ");
            System.out.println("1. ALTA DE UN PROFESOR");
            System.out.println("2. BAJA DE UN PROFESOR");
            System.out.println("3. CONSULTA DE DATOS PERSONALES DE UN PROFESOR");
            System.out.println("4. INTRODUCIR HORAS EXTRAORDINARIAS DE UN MES");
            System.out.println("5. LISTADO DE PROFESORES. DATOS PERSONALES");
            System.out.println("6. LISTADO DE PROFESORES. CLASES QUE IMPARTEN");
            System.out.println("7. LISTADO DE NÓMINAS DE UN MES");
            System.out.println("8. MANTENIMIENTO DE ASIGNATURAS IMPARTIDAS POR CADA PROFESOR");
            System.out.println("0. SALIR DEL PROGRAMA");
            System.out.print("\nOPCIÓN SELECCINADA: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    do {
                        Persona p = new Profesor();
                        p.pideDatos();
                        if (lista.containsKey(p.getApellidos() + " " + p.getNombre())) {
                            System.out.println("Este nombre ya existe, no puedo grabarlo");
                        } else {
                            lista.put(p.getApellidos() + " " + p.getNombre(), p);
                        }

                        System.out.print("¿Desea continuar? s=Sí: ");
                        repetir = sc.nextLine();
                    } while (repetir.equalsIgnoreCase("s") == true);

                    break;

                case 2: //Baja de profesor
                    if (lista.isEmpty()) {
                        System.out.println("La lista está vacía");
                        break;
                    } else {

                        do {

                            do {

                                try {
                                    System.out.print("Nombre profesor: ");
                                    String nom = sc.nextLine();
                                    System.out.print("Apellidos profesor: ");
                                    String ape = sc.nextLine();
                                    if (lista.containsKey(ape + " " + nom) == false) {

                                    correcto = true;
                                    throw new Exception("El profesor introducido no existe");

                                } else {

                                    lista.remove(ape + " " + nom);
                                    correcto = true;
                                }

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    correcto = false;
                                }
                            } while (!correcto);

                            System.out.print("¿Desea continuar? s=Sí: ");
                            repetir = sc.nextLine();
                        } while (repetir.equalsIgnoreCase("s") == true);

                        break;

                    }

                case 3:
                    do {
                        System.out.print("Nombre profesor: ");
                        String nom = sc.nextLine();
                        System.out.print("Apellidos profesor: ");
                        String ape = sc.nextLine();
                        System.out.println(lista.get(ape + " " + nom).toString());

                        System.out.print("¿Desea continuar? s=Sí: ");
                        repetir = sc.nextLine();
                    } while (repetir.equalsIgnoreCase("s") == true);
                    break;

                case 4: //Pedir las horas extra

                    int mes;
                    int horas = 0;
                    do {
                        System.out.print("Introducir mes (1=Enero, 12=Diciembre): ");
                        mes = sc.nextInt();
                        sc.nextLine();

                        for (Persona valor : lista.values()) {
                            System.out.println(valor.getNombre());
                            System.out.println(valor.getApellidos());
                            System.out.print("Horas extra: ");
                            horas = sc.nextInt();
                            sc.nextLine();
                            ((Profesor) valor).setHorasExtra(horas, mes - 1);

                        }

                        System.out.print("¿Desea continuar? s=Sí: ");
                        repetir = sc.nextLine();

                    } while (repetir.equalsIgnoreCase("s") == true);
                    break;

                case 5: //Listado de profesores

                    for (Persona valor : lista.values()) {

                        System.out.println(valor.toString());
                    }

                    break;

                case 6:
                    System.out.println("Listado de asignaturas por profesor ");
                    for (Persona valor : lista.values()) {
                        System.out.println(valor.getNombre());
                        System.out.println(valor.getApellidos());

                        ((Profesor) valor).imprimeAsignaturas();

                        System.out.println("");

                    }

                    break;

                case 7: //LISTADO DE NÓMINAS DE UN MES
                    System.out.print("Nóminas del mes: ");
                    mes = sc.nextInt();
                    sc.nextLine();

                    for (Persona valor : lista.values()) {

                        System.out.println(((Profesor) valor).imprimirNominas(mes - 1));

                    }

                    break;

                case 8: //Añadir asignaturas
                    System.out.println("Mantenimiento de asignaturas");
                    System.out.println("Seleccione un profesor: ");
                    System.out.print("Nombre profesor: ");
                    String nom = sc.nextLine();
                    System.out.print("Apellidos profesor: ");
                    String ape = sc.nextLine();
                    System.out.println(lista.get(ape + " " + nom).toString());

                    System.out.print("Mantenimiento de asignaturas: "
                            + "\nSeleccione una opción "
                            + "\n1. Añadir asignaturas"
                            + "\n2. Quitar asignaturas"
                            + "\n0. Salir "
                            + "\n Opción seleccionada:");
                    opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {
                        case 1:
                            ((Profesor) lista.get(ape + " " + nom)).asignaturasProfesor(tmASIGNA);

                            break;
                        case 2:

                            System.out.print("¿Qué asignatura desea eliminar?: ");
                            String asignatura = sc.nextLine();

                            ((Profesor) lista.get(ape + " " + nom)).eliminaAsignatura(asignatura);

                            break;

                        case 0:
                            break;

                    }

                    break;
            }
        } while (opcion != 0); */
    }
}
