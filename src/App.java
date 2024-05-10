import java.util.InputMismatchException;
import java.util.Scanner;

/*Nombre: Steven Alejandro Alvarez Avendaño
 * Nº Carnet: 2024-1675U
 * 1m7-S           09/05/2024
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        boolean continuar=true;
        System.out.println("\nBienvenido al sistema de inventario, ¿Que desea realizar hoy? ");
        String[] productos=null;
        while (continuar) {
            System.out.println("<----------Menu---------->");
            System.out.println("1- Registrar producto");
            System.out.println("2- Buscar producto");
            System.out.println("3- Salir");
            System.out.print("\nIngrese el numero indice de la accion a realizar: ");
            String opt=sc.nextLine();

            switch (opt) {
                case "1":
                    productos=PedirNumeroProductos(sc);
                    break;
                case "2":
                    if (productos==null) {
                        System.out.println("Aun no hay producto agregados......");
                    }else {
                        System.out.print("\nIngrese el nombre del producto a buscar: ");
                        String nombreProducto=sc.next();
                        buscarProducto(productos, nombreProducto);
                    }
                    break;
                case "3":
                    System.out.println("\nBye");
                    continuar=false;
                    break;
                default:
                    System.out.println("Opcion invalida.....");
                    break;
            }
        }
    
        
    }

    public static String[] PedirNumeroProductos(Scanner sc){
        String productos[]=null;
        //Manejo de excepciones try catch para pedir al usuario la cantidad de productos a registrar y evitar que sea un valor incorrecto
        try {
            System.out.print("Cantidad de productos a ingresar: ");
            int n=sc.nextInt();
            if (n>1) {
                productos=new String[n];
            } else {
                System.out.println("La cantidad de producto a ingresar debe ser mayor a 1");
            }
        } catch (InputMismatchException e) {
            System.out.println("Solo se aceptan valores enteros....");
            sc.next();
        }
        if (productos == null) {
            // en caso de haber una excepcion de un arreglo nulo, se retorna en 0 para que no quede en nulo y se cumpla la condicion y vuelva a pedir el valor
            return new String[0];
        }
        return PedirProductos(sc, productos);
    }

    public static String[] PedirProductos(Scanner sc, String productos[]){
        for (int i = 0; i < productos.length; i++) {
            System.out.print("\nIngrese el nombre del producto"+"("+(i+1)+"/"+productos.length+")"+": ");
            productos[i]=sc.next();
        }return productos;
    }

    public static void buscarProducto(String productos[], String nombreProducto){
        /*este es el metodo de Busqueda Lineal, sin embargo no voy a retornar nada, sino de un solo mando el mensaje aqui mismo de si se encontro o no se encontro
        sin embargo es el esqueleto del metodo de busqueda lineal :)*/
        boolean encontrado=false;   
        for (int i = 0; i < productos.length; i++) {
            String valor=productos[i];
            if (valor.equalsIgnoreCase(nombreProducto)) {
                System.out.println("El producto"+valor+"se encuentra en el inventario en la posicion "+(i+1) );
                encontrado=true;
            }
        }
        if (encontrado==false) {
            System.out.println("Producto no encontrado......");
        }
    }
}

