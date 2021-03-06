package centroEducativo;

import java.util.Scanner;

public class Persona {

    private String nombre;
    private String apellidos;
    private String calle;
    private String codigoPostal;
    private String ciudad;
    private String dni;
    private String fechaNacimiento; // DD/MM/YYYY

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String calle,
            String codigoPostal, String ciudad, String dni,
            String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void pideDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        apellidos = sc.nextLine();
        System.out.print("Dirección: ");
        calle = sc.nextLine();
        System.out.print("Código Postal: ");
        codigoPostal = sc.nextLine();
        System.out.print("Ciudad: ");
        ciudad = sc.nextLine();

        boolean correcto = false;

        do {
            try {
                System.out.print("DNI: ");
                dni = sc.nextLine();
                verificaDNI(dni);
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Caracteres incorrectos");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            try {
                System.out.print("Fecha de Nacimiento (DD/MM/YYYY): ");
                fechaNacimiento = sc.nextLine();
                verificaFecha(fechaNacimiento);
                correcto = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nApellidos: ");
        sb.append(apellidos);
        sb.append("\nDirección: ");
        sb.append(calle);
        sb.append("\nCódigo postal: ");
        sb.append(codigoPostal);
        sb.append("\nCiudad: ");
        sb.append(ciudad);
        sb.append("\nDNI: ");
        sb.append(dni);
        sb.append("\nFecha de nacimiento: ");
        sb.append(fechaNacimiento);
        return sb.toString();

    }

    public static void verificaDNI(String dni) throws Exception {
        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        String letraDNI = dni.substring(dni.length() - 1);
        String numeroDNI = dni.substring(0, dni.length() - 1);

        int numero = Integer.parseInt(numeroDNI);
        int resto = numero % 23;
        String letraObtenida = letrasDni.substring(resto, resto + 1);
        String letraMinuscula = letraObtenida.toLowerCase();
        if (letraDNI.compareTo(letraObtenida) == 0
                || letraDNI.compareTo(letraMinuscula) == 0) {
        } else {
            throw new Exception("Letra incorrecta");
        }
    }

    public static void verificaFecha(String fecha) throws Exception {

        int dia = 0, mes = 0, año = 0;
        String sDia, sMes, sAño;

        if (fecha.length() == 10 && fecha.charAt(2) == '/' && fecha.charAt(5) == '/') {
            //correcto = true;
        } else {
            throw new Exception("Formato de fecha incorrecto");
        }
        //filtramos que los caracteres son números

        for (int i = 0; i <= 9; i++) {
            if (i != 2 && i != 5) {
                if (fecha.charAt(i) < '0' || fecha.charAt(i) > '9') {
                    throw new Exception("Núeros incorrectos");
                }
            }
        }

        sDia = fecha.substring(0, 2);
        sMes = fecha.substring(3, 5);
        sAño = fecha.substring(6, 10);
        dia = Integer.parseInt(sDia);
        mes = Integer.parseInt(sMes);
        año = Integer.parseInt(sAño);

        //los números son correctos. Falta saber si la fecha es válida
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia < 1 || dia > 31) {
                    throw new Exception("El mes debe tener entre 1 y 31 días");
                }
                break;
            case 2:
                int max = 28;
                if ((año % 4 == 0) && ((año % 100 != 0) || (año % 400 != 0))) {
                    max = 29;
                }
                if (dia < 1 || dia > max) {
                    throw new Exception("Febrero, días incorrectos");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia < 1 || dia > 30) {
                    throw new Exception("El mes debe tener entre 1 y 30 días");
                }
                break;
            default:
                throw new Exception("Mes incorrecto");
        }

    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
