package Funs;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Peticiones {

    public Peticiones() {
    }

    // IMPORTS
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Pedir algo al usuario
     *
     * @return string
     * @throws IOException BufferedReader
     */
    public String pedirAlgo() throws IOException {
        String data;
        do {
            data = br.readLine();
            if (data.trim().equals(""))
                System.out.println("Debes de introducir algo!");
        } while (data.trim().equals(""));
        return data;
    }

    /**
     * Pedir algo al usuario con una frase
     *
     * @param frase String que quieres que se muestre
     * @return string resultado del usuario
     * @throws IOException BufferedReader
     */
    public String pedirAlgo(String frase) throws IOException {
        String data;
        do {
            System.out.println(frase);
            data = br.readLine();
        } while (data.trim().equals(""));
        return data;
    }

    /**
     * Array String unidimensional con opciones para elegir ()
     *
     * @param opciones Array de opciones
     * @return Opción elegida
     * @throws IOException BufferedReader
     */
    @NotNull
    public String eligeOpciones(@NotNull String... opciones) throws IOException {
        while (true) {
            String algo = pedirAlgo();
            for (String data : opciones) {
                if (data.equalsIgnoreCase(algo))
                    return data;
            }
            System.out.println("Opción inválida < ");
            for (String data : opciones) {
                System.out.print("[" + data + "] ");
            }
            System.out.println(">");
        }
    }

    /**
     * Array String multidimensional con opciones para elegir retornando la primera
     *
     * @param opciones Array Multidimensional con las opciones
     * @return La posición 0 del array de la opción seleccionada
     * @throws IOException BufferedReader
     */
    public String eligeOpciones(@NotNull String[]... opciones) throws IOException {
        while (true) {
            String algo = pedirAlgo();
            for (String[] data : opciones) {
                for (String parm : data) {
                    if (parm.equalsIgnoreCase(algo))
                        return data[0];
                }
            }
            System.out.print("Opción inválida < ");
            for (String[] data : opciones) {
                int i = 0;
                for (String parm : data) {
                    System.out.print("[ ");
                    System.out.print(parm + (i++ >= data.length ? " ] " : " | "));
                }
            }
            System.out.println(">");
        }
    }

    /**
     * Pedir algo al usuario y comprobar si coincide con algo del array pasado
     *
     * @param opciones Opciones que quieres que coincidan
     * @return boolean si coincide
     * @throws IOException BufferedReader
     */
    public boolean validaOpciones(@NotNull String... opciones) throws IOException {
        String algo = pedirAlgo();
        for (String data : opciones) {
            if (data.equalsIgnoreCase(algo))
                return true;
        }
        return false;

    }

    /**
     * Pedir un int
     *
     * @return int
     * @throws IOException BufferedReader
     */
    public int pedirInt() throws IOException {
        String cantS = pedirAlgo();
        return Integer.parseInt(cantS);
    }

    /**
     * Pedir un long
     *
     * @return long
     * @throws IOException BufferedReader
     */
    public long pedirLong() throws IOException {
        String cantS = pedirAlgo();
        return Integer.parseInt(cantS);
    }

    /**
     * Pedir int con mínimo
     *
     * @param min mínimo incluido
     * @return int
     * @throws IOException BufferedReader
     */
    public int pedirMin(int min) throws IOException {
        boolean exit = false;
        int num = 0;
        while (!exit) {
            num = pedirInt();
            if (num >= min)
                exit = true;
            else
                System.out.println("Número inválido (Mínimo " + min + ")");
        }
        return num;
    }

    /**
     * Pedir int con mínimo y máximo
     *
     * @param min Mínimo incluido
     * @param max Máximo incluido
     * @return int
     * @throws IOException BufferedReader
     */
    public int pedirNum(int min, int max) throws IOException {
        boolean exit = false;
        int num = 0;
        while (!exit) {
            num = pedirInt();
            if (num <= max & num >= min)
                exit = true;
            else
                System.out.println("Número inválido, debe ser entre " + min + " i " + max + " incluidos");
        }
        return num;
    }

    /**
     * Pedir long con mínimo
     *
     * @param min int incluido
     * @return long
     * @throws IOException BufferedReader
     */
    public long pedirLong(int min) throws IOException {
        boolean exit = false;
        long num = 0;
        while (!exit) {
            num = pedirLong();
            if (num >= min)
                exit = true;
            else
                System.out.println("Número inválido (Mínimo " + min + ")");
        }
        return num;
    }

    /**
     * Pedir long con frase y mínimo
     *
     * @param frase Frase para el usuario
     * @param min   int incluido
     * @return long
     * @throws IOException BufferedReader
     */
    public long pedirLong(String frase, int min) throws IOException {
        boolean exit = false;
        long num = 0;
        while (!exit) {
            System.out.println(frase);
            num = pedirLong();
            if (num >= min)
                exit = true;
        }
        return num;
    }

    /**
     * Pedir un número con mínimo y máximo con frase
     *
     * @param frase Frase para mostrar al usuario
     * @param min   Mínimo incluido
     * @param max   Máximo incluido
     * @return int
     * @throws IOException BufferedReader
     */
    public int pedirNum(String frase, int min, int max) throws IOException {
        boolean exit = false;
        int num = 0;
        while (!exit) {
            System.out.println(frase);
            num = pedirInt();
            if (num <= max & num >= min)
                exit = true;
        }
        return num;
    }

    /**
     * Pedir int con mínimo y una frase
     *
     * @param frase Frase que muestra al usuario
     * @param min   Mínimo incluido
     * @return número
     * @throws IOException BufferedReader
     */
    public int pedirNum(String frase, int min) throws IOException {
        boolean salir = false;
        int num;
        do {
            System.out.println(frase);
            num = pedirInt();
            if (num >= min)
                salir = true;
        } while (!salir);
        return num;
    }

    /**
     * Sumar valores de un array
     *
     * @param array Valores a sumar
     * @return resultado suma
     */
    @Contract
    public int sumarArray(@NotNull int... array) {
        int r = 0;
        for (int i : array) {
            r += i;
        }
        return r;
    }


    /**
     * Número a día de mes
     *
     * @param num número de mes
     * @return nombre del mes o null
     */
    public String nameMes(int num) {
        String mes;
        switch (num) {
            case 1:
                mes = "enero";
                break;
            case 2:
                mes = "febrero";
                break;
            case 3:
                mes = "marzo";
                break;
            case 4:
                mes = "abril";
                break;
            case 5:
                mes = "mayo";
                break;
            case 6:
                mes = "junio";
                break;
            case 7:
                mes = "julio";
                break;
            case 8:
                mes = "agosto";
                break;
            case 9:
                mes = "septiembre";
                break;
            case 10:
                mes = "octubre";
                break;
            case 11:
                mes = "noviembre";
                break;
            case 12:
                mes = "diciembre";
                break;
            default:
                mes = null;
                break;
        }
        return mes;
    }
}
