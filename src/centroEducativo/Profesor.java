package centroEducativo;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Profesor extends Persona {

    private static String curso;

    private double sueldoBase;
    private int[] horasExtra = new int[12];
    private double tipoIRPF;
    private String cuentaIBAN;
    private TreeMap<String, String> tmAsignaturas = new TreeMap<>(); //Asigntatuas que imparte.

    public Profesor() {
        super();
    }

    public Profesor(double sueldoBase, double tipoIRPF,
            String cuentaIBAN,
            String nombre, String apellidos, String calle, String codigoPostal,
            String ciudad, String dni, String fechaNacimiento) {

        super(nombre, apellidos, calle, codigoPostal, ciudad, dni,
                fechaNacimiento);

        this.sueldoBase = sueldoBase;
        this.tipoIRPF = tipoIRPF;
        this.cuentaIBAN = cuentaIBAN;
    }

    @Override
    public void pideDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("PROFESOR");
        super.pideDatos();

        boolean correcto = false;
        do {
            try {
                System.out.print("Sueldo base: ");
                String sueldoBase_s = sc.nextLine();
                sueldoBase_s = sueldoBase_s.replace(',', '.');
                sueldoBase = Double.parseDouble(sueldoBase_s);
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto");
                correcto = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            try {
                System.out.print("Tipo de IRPF: ");
                String tipoIRPF_s = sc.nextLine();
                tipoIRPF_s = tipoIRPF_s.replace(',', '.');

                tipoIRPF = Double.parseDouble(tipoIRPF_s);
                correcto = true;
                if (tipoIRPF < 0 || tipoIRPF > 100) {
                    throw new Exception("El tipo de IRPF tiene que estar entre 0 y 100");
                }

            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto");
                correcto = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        correcto = false;
        do {
            try {
                System.out.print("Cuenta IBAN: ");
                cuentaIBAN = sc.nextLine();
                Cuenta.filtroCuenta(cuentaIBAN);
                cuentaIBAN = cuentaIBAN.replaceAll("\\s+", "");
                //Eliminamos los espacios que se hayan introducido
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("Caracteres incorrectos");
                correcto = false;
            } catch (NumberFormatException e) {
                System.out.println("Caracteres incorrectos");
                correcto = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" -- PROFESOR --");
        sb.append(super.toString());

        sb.append("\nSueldo base: ");
        sb.append(sueldoBase);
        sb.append("\nTipo IRPF: ");
        sb.append(tipoIRPF);
        sb.append("\nCuenta IBAN: ");
        sb.append(cuentaIBAN);

        return sb.toString();

    }

    public String imprimirNominas(int mes) {
        String nombreMes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
            "Junio", "Julio", "Agosto", "Septiembre",
            "Octubre", "Noviembre", "Diciembre"};
        String resultado = "";
        resultado = "Nombre: " + super.getNombre()
                + "\nDNI: " + super.getDni()
                + "\nCurso:" + CentroEducativo.getCurso()
                + "\nNómina del mes: " + nombreMes[mes]
                + "\nSueldo Base : " + sueldoBase
                + "\nHoras extra: " + horasExtra[mes]
                + "\nTipo de IRPF: " + tipoIRPF
                + "\nCódigo IBAN: " + cuentaIBAN
                + "\nSueldo Bruto: " + calcularSueldoBruto(mes)
                + "\nRetención por IRPF: " + calcularRetencionIRPF(mes)
                + "\nSueldo neto: " + calcularSueldoMes(mes);

        return resultado;

    }

    public void asignaturasProfesor(TreeMap<String, String> tmASIGNA) {
        //Se introducen las asignaturas que va a impartir el profesor.

        Scanner sc = new Scanner(System.in);
        String asignatura;
        System.out.print("Código Asignatura: ");
        asignatura = sc.nextLine();
        if (tmASIGNA.containsKey(asignatura)) {
            tmAsignaturas.put(asignatura, tmASIGNA.get(asignatura));
        } else {

            System.out.println("La asignatura no existe");

        }
        //Vemos si la asignatura está y si está lo añadimos a la array que tiene el profesor.

    }

    public void eliminaAsignatura(String asignaturaCode) {

        if (tmAsignaturas.containsKey(asignaturaCode)) {
            tmAsignaturas.remove(asignaturaCode);
        } else {

            System.out.println("La asignatura no existe");

        }

    }

    public void imprimeAsignaturas() {

        for (String asignatura : tmAsignaturas.keySet()) {

            System.out.println(" (" + asignatura + ") " + 
                    tmAsignaturas.get(asignatura));

        }

        //Imprime las asignaturas impartidas por el profesor
    }

    public double calcularImporteHorasExtra(int mes) {
        return this.horasExtra[mes] * CentroEducativo.getPagoPorHoraExtra();

    }

    public double calcularSueldoBruto(int mes) {
        double importe = sueldoBase + calcularImporteHorasExtra(mes);
        return importe;

    }

    public double calcularRetencionIRPF(int mes) {
        double importe = calcularSueldoBruto(mes) * tipoIRPF / 100;
        return importe;
    }

    public double calcularSueldoMes(int mes) {

        return calcularSueldoBruto(mes) - calcularRetencionIRPF(mes);

    }

    // GETTERS AND SETTERS
    public static String getCurso() {
        return curso;
    }

    public static void setCurso(String curso) {
        Profesor.curso = curso;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getHorasExtra(int mes) {
        return horasExtra[mes];
    }

    public void setHorasExtra(int horasExtra, int mes) {
        this.horasExtra[mes] = horasExtra;
    }

    public double getTipoIRPF() {
        return tipoIRPF;
    }

    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    public String getCuentaIBAN() {
        return cuentaIBAN;
    }

    public void setCuentaIBAN(String cuentaIBAN) {
        this.cuentaIBAN = cuentaIBAN;
    }

    public TreeMap<String, String> getTmAsignaturas() {
        return tmAsignaturas;
    }

    public void setTmAsignaturas(TreeMap<String, String> tmAsignaturas) {
        this.tmAsignaturas = tmAsignaturas;
    }

}
