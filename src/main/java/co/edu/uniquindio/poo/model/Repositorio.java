package co.edu.uniquindio.poo.model;
import java.util.Scanner;

/*
Repositorio para la reutilización de fucniones
*/

public class Repositorio {

    //Función para ingresar una cadena de texto
    public static String ingresarTexto(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        String texto = sc.nextLine();
        return texto;
    }

    //Función para ingresar un numero entero
    public static int ingresarInt(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        int numero = sc.nextInt();
        return numero;
    }

    //Función para ingresar un número decimal
    public static double ingresarDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        double numero = sc.nextDouble();
        return numero;
    }

    //Función para ingresar un valor booleano
    public static boolean ingresarValorBooleano(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        boolean valor = sc.nextBoolean();
        return valor;


    }

    //Funcion para ingresar un float
    public static float ingresarFloat(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        float numero = sc.nextFloat();
        return numero;
    }

    // Función para ingresar un byte
    public static byte ingresarByte(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        byte numero = sc.nextByte();
        return numero;

    }
    // Función para ingresar un short
    public static short ingresarShort(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        short numero = sc.nextShort();
        return numero;
    }
    // Función para ingresar un long
    public static long ingresarLong(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        long numero = sc.nextLong();
        return numero;
    }
}
