package profesor;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class Cuenta {

    public static void filtroCuenta(String numeroCuenta) throws Exception {
        //método para validar el IBAN
        
        /*IBAN Validos
        ES57 2100 4231 7146 5465 5151
        ES61 0049 1111 8154 5365 5151
        
        https://www.gabilos.com/textocalculadoradccuenta.htm
        
        */
        
        

        int suma_A;
        int suma_B;
        int suma_D;
        int resto_C;
        int resto_E;

        numeroCuenta = numeroCuenta.replaceAll("\\s+", ""); //Eliminamos los espacios

        //System.out.println(IBAN);
        if (numeroCuenta.length() != 24) {

            throw new Exception("El código IBAN tiene que tener 24 caracteres "
                    + "\nFormato: ESXX XXXX XXXX XX XXXXXXXXXX");

            //ES4521004231791234789898
        }

        if (numeroCuenta.substring(0, 2).equals("ES") == false) {

            throw new Exception("El código IBAN debe empezar por ES");
        }

        //Seleccionamos las primeras cuatro cifras
        String cadena1 = numeroCuenta.substring(0, 4);

        //Entidad Bancaria --------------------------------------------------
        String entidad = numeroCuenta.substring(4, 8);

        if (CentroEducativo.tmEEEE.containsKey(entidad)) {
            //banco = tmEEEE.get(banco);
            //System.out.println("banco: " + banco);
        } else {
            
            throw new Exception ("La entidad no está en la lista");
            
        }
        
            suma_A = Integer.parseInt(numeroCuenta.substring(4, 5)) * 4
                    + Integer.parseInt(numeroCuenta.substring(5, 6)) * 8
                    + Integer.parseInt(numeroCuenta.substring(6, 7)) * 5
                    + Integer.parseInt(numeroCuenta.substring(7, 8)) * 10;

        //Entidad Bancaria ___________________________________________________
        // Sucursal bancaria _____________________________________________________
        String sucursal = numeroCuenta.substring(4, 12);

        if (CentroEducativo.tmEEEESSSS.containsKey(sucursal)) {
            //System.out.println("La sucursal no está en la lista");
        }else {
        
            throw new Exception ("La sucursal no está en la lista");
        
        }
  
            suma_B = Integer.parseInt(numeroCuenta.substring(8, 9)) * 9
                    + Integer.parseInt(numeroCuenta.substring(9, 10)) * 7
                    + Integer.parseInt(numeroCuenta.substring(10, 11)) * 3
                    + Integer.parseInt(numeroCuenta.substring(11, 12)) * 6;

 

        resto_C = ((suma_A + suma_B) % 11);

        int digito1;

        switch (11 - resto_C) {
            case 10:
                digito1 = 1;
                break;
            case 11:
                digito1 = 11;
                break;
            default:
                digito1 = 11 - resto_C;
                break;
        }
     
            suma_D
                    = Integer.parseInt(numeroCuenta.substring(14, 15)) * 1
                    + Integer.parseInt(numeroCuenta.substring(15, 16)) * 2
                    + Integer.parseInt(numeroCuenta.substring(16, 17)) * 4
                    + Integer.parseInt(numeroCuenta.substring(17, 18)) * 8
                    + Integer.parseInt(numeroCuenta.substring(18, 19)) * 5
                    + Integer.parseInt(numeroCuenta.substring(19, 20)) * 10
                    + Integer.parseInt(numeroCuenta.substring(20, 21)) * 9
                    + Integer.parseInt(numeroCuenta.substring(21, 22)) * 7
                    + Integer.parseInt(numeroCuenta.substring(22, 23)) * 3
                    + Integer.parseInt(numeroCuenta.substring(23, 24)) * 6;

            String ultimo = numeroCuenta.substring(21, 22);

        resto_E = suma_D % 11;
        int digito2;

        switch (11 - resto_E) {
            case 10:
                digito2 = 1;
                break;
            case 11:
                digito2 = 11;
                break;
            default:
                digito2 = 11 - resto_E;
                break;
        }

        StringBuilder iban = new StringBuilder(numeroCuenta);

        String codEs = "142800";

        iban.delete(0, 4);

        iban.append(codEs);

        String iban_ES = iban.toString();

        BigInteger iban_integer = new BigInteger(iban_ES);

        BigInteger resto_R = iban_integer.remainder(BigInteger.valueOf(97));

        int digito3 = 98 - resto_R.intValue();

        //Pasamos a String los distintos dígitos de control y los comparamos con la cadena introducida
        String digito1S = String.valueOf(digito1);
        String digito2S = String.valueOf(digito2);
        String digito3S = String.valueOf(digito3);

        //Comparación con la cadena que hemos Introducido
        if (digito1S.equals(numeroCuenta.substring(12, 13))
                && digito2S.equals(numeroCuenta.substring(13, 14))
                && digito3S.equals(numeroCuenta.substring(2, 4))
                && CentroEducativo.tmEEEE.containsKey(entidad)
                && CentroEducativo.tmEEEESSSS.containsKey(sucursal)) {

            System.out.println("El código IBAN es correcto");
        } else {
            throw new Exception ("El código IBAN no es correcto");
        }

    }

    public static void cargaEntidadesBancarias(TreeMap<String, String> tmEEEE) {
        tmEEEE.put("2100", "Caixabank");
        tmEEEE.put("0081", "Banco Sabadell");
        tmEEEE.put("1465", "ING Bank");
        tmEEEE.put("0081", "Banco Sabadell");
        tmEEEE.put("2038", "Bankia");
        tmEEEE.put("0049", "Banco Santander");

    }

    public static void cargaSucursalesBancarias(TreeMap<String, String> tmEEEESSSS) {

        tmEEEESSSS.put("21004231", "Elche Urbana 1");
        tmEEEESSSS.put("21004232", "Elche Urbana 2");
        tmEEEESSSS.put("21004233", "Elche Urbana 3");
        tmEEEESSSS.put("21004234", "Elche Urbana 4");
        tmEEEESSSS.put("21003894", "Elche Urbana 5");
        tmEEEESSSS.put("00816781", "Elche Urbana 1");
        tmEEEESSSS.put("00816782", "Elche Urbana 3");
        tmEEEESSSS.put("00816783", "Elche Urbana 3");
        tmEEEESSSS.put("00816784", "Elche Urbana 4");
        tmEEEESSSS.put("14654561", "Elche Urbana 1");
        tmEEEESSSS.put("14654562", "Elche Urbana 2");
        tmEEEESSSS.put("00811152", "Elche Urbana 1");
        tmEEEESSSS.put("00811153", "Elche Urbana 2");
        tmEEEESSSS.put("00811152", "Elche Urbana 3");
        tmEEEESSSS.put("20384441", "Elche Urbana 1");
        tmEEEESSSS.put("00492221", "Elche Urbana 1");
        tmEEEESSSS.put("00492222", "Elche Urbana 2");
        tmEEEESSSS.put("00491111", "Elche Urbana 1");

    }

}
