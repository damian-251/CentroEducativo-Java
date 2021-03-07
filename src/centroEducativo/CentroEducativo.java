package centroEducativo;

/**
 * @author Damian Martin Delgado
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

        //--------------------------------------------------------------------------------------------------------------------------------
        // D A T O S    I N I C I A L E S   P A R A   P R U E B A S///////////////////////////////////
        Profesor profe = new Profesor(1500.0, 10.0, "ES2400811152680006077615", "Luis", "Rodriguez Parla", "calle1",
                "03203", "Elche", "11111111H", "12/12/1980");
        String key = profe.getApellidos() + " " + profe.getNombre();//la clave para el TreeMaps
        lista.put(key, profe);
        profe = new Profesor(1600.0, 10.0, "ES2400811152680006077615", "Ramiro", "Gutierrez Pascual", "calle3",
                "03204", "Elche", "22222222J", "10/10/1985");
        key = profe.getApellidos() + " " + profe.getNombre();//la clave para el TreeMaps
        lista.put(key, profe);
        profe = new Profesor(1800.0, 10.0, "ES2400811152680006077615", "Julian", "Herrero Pertusa", "calle2",
                "03204", "Elche", "33333333P", "10/07/1979");
        key = profe.getApellidos() + " " + profe.getNombre();//la clave para el TreeMaps
        lista.put(key, profe);
        profe = new Profesor(1600.0, 10.0, "ES2400811152680006077615", "Marta", "Valero Cuenca",
                "avda Santapola, 12", "03203", "Elche", "21309422Z", "03/06/1970");
        key = profe.getApellidos() + " " + profe.getNombre();//la clave para el TreeMaps
        lista.put(key, profe);

        // Alumno(String curso, String nombre, String apellidos, String calle, String codigoPostal, String ciudad, 
//                 String dni, String fechaNacimiento) 
        Alumno alum = new Alumno("1S", "Manuela", "Fuentes Gil", "avda Alicante, 26", "03203", "Elche",
                "21309422Z", "03/06/2000");
        TreeMap<String, Notas> tmAsignaturasAlumno = new TreeMap<String, Notas>();
        Notas notas = new Notas();
        tmAsignaturasAlumno.put("1SPROGRAM", new Notas());
        tmAsignaturasAlumno.put("1SENTORNOS", new Notas());
        tmAsignaturasAlumno.put("1SLENGMAR", new Notas());
        tmAsignaturasAlumno.put("1SFOL", new Notas());
        tmAsignaturasAlumno.put("1SINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        key = alum.getApellidos() + " " + alum.getNombre();//la clave para el TreeMaps
        lista.put(key, alum);

        alum = new Alumno("1S", "Antonio", "Serrano Gil", "Hospital, 24", "03203", "Elche",
                "21309422Z", "03/06/2001");
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        tmAsignaturasAlumno.put("1SPROGRAM", new Notas());
        tmAsignaturasAlumno.put("1SENTORNOS", new Notas());
        tmAsignaturasAlumno.put("1SLENGMAR", new Notas());
        tmAsignaturasAlumno.put("1SFOL", new Notas());
        tmAsignaturasAlumno.put("1SINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        key = alum.getApellidos() + " " + alum.getNombre();//la clave para el TreeMaps
        lista.put(key, alum);

        alum = new Alumno("1S", "Antonio", "Grande Ruizm", "Hospital, 22", "03203", "Elche",
                "21309422Z", "03/05/1999");
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        tmAsignaturasAlumno.put("1SPROGRAM", new Notas());
        tmAsignaturasAlumno.put("1SENTORNOS", new Notas());
        tmAsignaturasAlumno.put("1SLENGMAR", new Notas());
        tmAsignaturasAlumno.put("1SFOL", new Notas());
        tmAsignaturasAlumno.put("1SINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        key = alum.getApellidos() + ", " + alum.getNombre();//la clave para el TreeMaps
        lista.put(key, alum);

        alum = new Alumno("1S", "Ana", "Ruiz Ruiz", "Plza Mayor, 2", "03203", "Elche",
                "21309422Z", "03/05/1999");
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        tmAsignaturasAlumno.put("1SPROGRAM", new Notas());
        tmAsignaturasAlumno.put("2SENTORCLI", new Notas());
        tmAsignaturasAlumno.put("2SENTORSER", new Notas());
        tmAsignaturasAlumno.put("2SFOL", new Notas());
        tmAsignaturasAlumno.put("2SINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        key = alum.getApellidos() + " " + alum.getNombre();//la clave para el TreeMaps
        lista.put(key, alum);

        alum = new Alumno("1W", "Luis", "Tormo Pascual", "Navas, 22", "03203", "Elche",
                "21309422Z", "13/10/2000");
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        tmAsignaturasAlumno.put("1WPROGRAM", new Notas());
        tmAsignaturasAlumno.put("1WENTORNOS", new Notas());
        tmAsignaturasAlumno.put("1WLENGMAR", new Notas());
        tmAsignaturasAlumno.put("1WFOL", new Notas());
        tmAsignaturasAlumno.put("1WINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        key = alum.getApellidos() + " " + alum.getNombre();//la clave para el TreeMaps
        lista.put(key, alum);

        alum = new Alumno("1W", "Luisa", "Miralles Ruiz", "Romerales, 22", "03203", "Elche",
                "21309422Z", "06/03/2001");
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        key = alum.getApellidos() + " " + alum.getNombre();//la clave para el TreeMaps
        tmAsignaturasAlumno.put("1WPROGRAM", new Notas());
        tmAsignaturasAlumno.put("1WENTORNOS", new Notas());
        tmAsignaturasAlumno.put("1WLENGMAR", new Notas());
        tmAsignaturasAlumno.put("1WFOL", new Notas());
        tmAsignaturasAlumno.put("1WINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        lista.put(key, alum);

        alum = new Alumno("1W", "Jose", "Galiano Montesinos", "C Novelda, 22", "02565", "Elche",
                "21309422Z", "06/03/1994");
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        key = alum.getApellidos() + " " + alum.getNombre();//la clave para el TreeMaps
        notas = new Notas();
        tmAsignaturasAlumno.put("1WPROGRAM", new Notas());
        tmAsignaturasAlumno.put("1WENTORNOS", new Notas());
        tmAsignaturasAlumno.put("1WLENGMAR", new Notas());
        tmAsignaturasAlumno.put("1WFOL", new Notas());
        tmAsignaturasAlumno.put("1WINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        lista.put(key, alum);

        alum = new Alumno("1E", "Paula", "Gonzalez", "C Sainz Baranda, 22", "02565", "Elche",
                "21309422Z", "06/03/1994");
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        key = alum.getApellidos() + " " + alum.getNombre();//la clave para el TreeMaps
        notas = new Notas();
        tmAsignaturasAlumno.put("1EREDES", new Notas());
        tmAsignaturasAlumno.put("1EOFIMA", new Notas());
        tmAsignaturasAlumno.put("1ESISOP", new Notas());
        tmAsignaturasAlumno.put("1EFOL", new Notas());
        tmAsignaturasAlumno.put("1EINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        lista.put(key, alum);

        alum = new Alumno("1E", "Cristina", "Martinez", "carrer desconegut, 22", "02565", "Elche",
                "21309422Z", "06/03/1994");
        tmAsignaturasAlumno = new TreeMap<String, Notas>();
        key = alum.getApellidos() + " " + alum.getNombre();//la clave para el TreeMaps
        notas = new Notas();
        tmAsignaturasAlumno.put("1EREDES", new Notas());
        tmAsignaturasAlumno.put("1EOFIMA", new Notas());
        tmAsignaturasAlumno.put("1ESISOP", new Notas());
        tmAsignaturasAlumno.put("1EFOL", new Notas());
        tmAsignaturasAlumno.put("1EINGLES", new Notas());
        alum.setTmAsignaturasAlumno(tmAsignaturasAlumno);
        lista.put(key, alum);

        String nombreEvalua[] = {"Primera Evaluacion", "Segunda Evaluacion", "Tercera evaluacion",
            "Evaluacion ordinaria", "Evaluacion extraordinaria"};

//-----------------------------------------------------------------------------------------------------------------        
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
                System.out.println("Error en caracteres Importe Horas Extra");
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

                            case 2: //BAJA DE UN ALUMNO
                                if (lista.isEmpty()) {
                                    System.out.println("La lista está vacía");
                                    break;
                                } else {

                                    do {

                                        do {

                                            try {
                                                System.out.print("Nombre alumno: ");
                                                String nom = sc.nextLine();
                                                System.out.print("Apellidos alumno: ");
                                                String ape = sc.nextLine();
                                                if (lista.containsKey(ape + " " + nom) == false) {

                                                    throw new Exception("El alumno introducido no existe");

                                                } else if (lista.get(ape + " " + nom) instanceof Profesor) {
                                                    throw new Exception("Has seleccionada un profesor");
                                                } else {

                                                    lista.remove(ape + " " + nom);
                                                    correcto = true;
                                                    System.out.println("Alumno eliminado");
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

                            case 3: //CONSULTA DE DATOS PERSONALES DE UN ALUMNO
                                do {
                                    try {
                                        System.out.print("Nombre alumno: ");
                                        String nom = sc.nextLine();
                                        System.out.print("Apellidos alumno: ");
                                        String ape = sc.nextLine();

                                        if (lista.containsKey(ape + " " + nom) == false
                                                || lista.get(ape + " " + nom) instanceof Profesor) {

                                            throw new Exception("El alumno introducido no existe");

                                        }
                                        System.out.println(lista.get(ape + " " + nom).toString());

                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }

                                    System.out.print("¿Desea continuar? s=Sí: ");
                                    repetir = sc.nextLine();
                                } while (repetir.equalsIgnoreCase("s") == true);

                                break;

                            case 4: //INTRODUCIR NOTAS DE UNA ASIGNATURA Y EVALUCACIÓN A TODOS LOS MATRICULADOS
                                correcto = false;
                                do {
                                    do {
                                        try {

                                            System.out.print("Seleccione la asignatura deseada: ");
                                            String asignatura = sc.nextLine();

                                            if (tmASIGNA.containsKey(asignatura) == false) {
                                                throw new Exception("La asignatura no existe");

                                            }

                                            System.out.print("Seleccione la evaluación ");
                                            int evaluacion = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("Evaluación seleccionada: "
                                                    + nombreEvalua[evaluacion - 1]);

                                            System.out.println("Introduzca las notas: ");

                                            for (Persona valor : lista.values()) {

                                                if (valor instanceof Alumno
                                                        && ((Alumno) valor).getTmAsignaturasAlumno().containsKey(asignatura)) {

                                                    System.out.print(valor.getApellidos() + ", "
                                                            + valor.getNombre() + ": ");
                                                    int nota = sc.nextInt();

                                                    ((Alumno) valor).setEvaluacion(asignatura, evaluacion, nota);
                                                    //System.out.println(tmAsignaturasAlumno.get(asignatura).getNotas(evaluacion));
                                                    sc.nextLine();

                                                }

                                            }
                                            correcto = true;

                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                            correcto = false;
                                        }
                                    } while (!correcto);

                                    System.out.print("¿Desea evaluar otra asignatura? S=Sí Otro = No ");
                                    repetir = sc.nextLine();
                                } while (repetir.equalsIgnoreCase("s") == true);

                                break;

                            case 5: //LISTADO DE ALUMNOS DE UN GRUPO. DATOS PERSONALES.

                                System.out.print("Seleccione un curso: ");
                                String cursoAlumno = sc.nextLine();

                                for (Persona valor : lista.values()) {

                                    if (valor instanceof Alumno) {

                                        if (((Alumno) valor).getCurso().equals(cursoAlumno)) {

                                            System.out.println(valor.toString());
                                        }
                                    }
                                }

                                break;

                            case 6: //LISTADO DE LOS ALUMNOS MATRICULADOS EN UNA ASIGNATURA

                                System.out.print("Seleccione una asignatura: ");
                                String asignatura = sc.nextLine();

                                for (Persona valor : lista.values()) {

                                    if (valor instanceof Alumno
                                            && ((Alumno) valor).getTmAsignaturasAlumno().containsKey(asignatura)) {

                                        System.out.println(valor.toString());
                                    }

                                }

                                break;

                            case 7: //LISTADO DE BOLETINES DE NOTAS DE UNA EVALUACIÓN Y CURSO
                                do {
                                    do {
                                        correcto = false;
                                        try {
                                            System.out.print("Seleccione evaluación: (entre 1 y "
                                                    + notas.notas.length + "): ");
                                            int evaluacion = sc.nextInt();
                                            sc.nextLine();

                                            if (evaluacion < 0 || evaluacion > notas.notas.length) {
                                                throw new Exception("La evaluación debe estar entre 1 y "
                                                        + notas.notas.length + ".");
                                            }

                                            System.out.println("Evaluación seleccionada: "
                                                    + nombreEvalua[evaluacion - 1]);

                                            System.out.print("Seleccione curso: ");
                                            cursoAlumno = sc.nextLine();
                                            if (tmCC.containsKey(cursoAlumno) == false) {

                                                throw new Exception("El curso introducido no existe");

                                            }

                                            for (Persona valor : lista.values()) {

                                                if (valor instanceof Alumno) {

                                                    if (((Alumno) valor).getCurso().equals(cursoAlumno)) {

                                                        System.out.print(((Alumno) valor).boletinNotas(evaluacion));

                                                    }
                                                }
                                            }
                                            correcto = true;

                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                            correcto = false;
                                        }
                                    } while (!correcto);

                                    System.out.print("¿Desea ver el boletín de otra evaluación y/o curso? S=Sí Otro=No: ");
                                    repetir = sc.nextLine();

                                } while (repetir.equalsIgnoreCase("s"));

                                break;
                            case 0: //VUELTA AL MENÚ PRINCIPAL
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

                                    System.out.print("¿Desea continuar dar de alta otro profesor? s=Sí Otro=No: ");
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
                                                    System.out.println("Profesor eliminado");
                                                }

                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                correcto = false;
                                                break;
                                            }
                                        } while (!correcto);

                                        System.out.print("¿Desea dar de baja otro profesor? s=Sí otro=No: ");
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
                                        System.out.println("");
                                    }

                                }

                                break;

                            case 8: //MANTENIMIENTO DE ASIGNATURAS IMPARTIDAS POR CADA PROFESOR
                                do {
                                    correcto = false;

                                    try {
                                        System.out.println("Mantenimiento de asignaturas");
                                        System.out.println("Seleccione un profesor ");
                                        System.out.print("Nombre profesor: ");
                                        String nom = sc.nextLine();
                                        System.out.print("Apellidos profesor: ");
                                        String ape = sc.nextLine();

                                        if (lista.containsKey(ape + " " + nom) == false) {
                                            throw new Exception("El profesor introducido no existe");
                                        }

                                        if (lista.get(ape + " " + nom) instanceof Alumno) {
                                            throw new Exception("Has seleccionado un alumno");
                                        }

                                        System.out.println(lista.get(ape + " " + nom).toString());

                                        System.out.print("Mantenimiento de asignaturas: "
                                                + "\nSeleccione una opción "
                                                + "\n1. Añadir asignaturas"
                                                + "\n2. Quitar asignaturas"
                                                + "\n0. Salir "
                                                + "\n Opción seleccionada: ");
                                        opcion = sc.nextInt();
                                        sc.nextLine();
                                        correcto = true;

                                        switch (opcion) {
                                            case 1:
                                                do {
                                                    ((Profesor) lista.get(ape + " " + nom)).asignaturasProfesor(tmASIGNA);
                                                    System.out.print("¿Desea agregar más asignaturas? S=Sí Otro=No: ");
                                                    repetir = sc.nextLine();
                                                } while (repetir.equalsIgnoreCase("s"));
                                                break;
                                            case 2:
                                                do {
                                                    System.out.print("¿Qué asignatura desea eliminar?: ");
                                                    String asignatura = sc.nextLine();

                                                    ((Profesor) lista.get(ape + " " + nom)).eliminaAsignatura(asignatura);
                                                    System.out.print("¿Desea eliminar más asignaturas? S=Sí Otro=No: ");
                                                    repetir = sc.nextLine();
                                                } while (repetir.equalsIgnoreCase("s"));

                                                break;

                                            case 0:
                                                break;

                                        }

                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                } while (!correcto);

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
                            System.out.println("(P) " + valor.getApellidos()
                                    + ", " + valor.getNombre());

                        } else if (valor instanceof Alumno) {
                            System.out.println("(A)" + " (" + ((Alumno) valor).getCurso()
                                    + ") "
                                    + valor.getApellidos()
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

    }
}
