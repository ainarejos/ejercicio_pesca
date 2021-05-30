import java.io.*;
import java.util.Scanner;

public class Pesca {

    FileWriter writter;

    public Pesca() {
    }

    // Pendiente de cambiar.
    public void registrarUsuario(String string) throws IOException {
        FileReader read = new FileReader("Resource/Files/usuaris.txt");
        int valor = read.read();
        String documento="";
        while (valor!=-1){
            documento = documento + (char)valor;
            valor= read.read();
        }
        read.close();
        if (this.comprobarUsuario(string)){
            System.out.println("\nUsuario ya registrado");
        } else {
            writter = new FileWriter("Resource/Files/usuaris.txt");
            writter.write(documento + "#" + string + "#\n");
            System.out.println("Usuario registrado correctamente");
            writter.close();
        }
        read.close();
    }

    // Pendiente de cambio.
    public void registrarPez(String string) throws IOException {
        FileReader read = new FileReader("Resource/Files/yaregistrados.txt");
        int valor = read.read();
        String documento="";
        while (valor!=-1){
            documento = documento + (char)valor;
            valor= read.read();
        }
        read.close();
        if (this.comprobarUsuario(string)){
            System.out.println("\nUsuario ya registrado");
        } else {
            writter = new FileWriter("Resource/Files/yaregistrados.txt");
            writter.write(documento + "#" + string + "#\n");
            writter.close();
        }
        read.close();
    }

    // Pendiente de cambiar
    public void borrarUsuario(String usuario) throws IOException {
        FileReader read = new FileReader("Resource/Files/usuaris.txt");
        String documento="";
        String string="";
        int valor = read.read();
        boolean firts= true;
        while (valor!=-1){
            while (valor!='\n' && valor!=-1){
                if (valor!=35 && valor!=-1 || firts){
                    string = string + (char)valor;
                    firts=false;
                } else {
                    string = string + (char)valor;
                }
                valor = read.read();
            }
            if (valor == 10){
                string = string + (char)valor;
                valor = read.read();
            }
            if (string.equals( '#' + usuario + '#' + '\n') || (string.equals( '#' + usuario + '#' + '\r' + "\n") ||(string.equals( '#' + usuario + '#')))){

            } else {
                documento+=string;
            }
            string="";
        }
        read.close();
        FileWriter writter = new FileWriter("Resource/Files/usuaris.txt");
        writter.write(documento);
        writter.close();
    }

    // Pendiete de optimizar.
    public void Pescar(String usuario, String path) throws IOException {
        FileReader read = new FileReader(path);
        int valor = read.read();
        boolean separador=true;
        boolean encontrado=true;
        String linea="";
        String campo="";
        double random= Math.random();
        String campo1="";
        double campo2=0.00;
        double campo3=0.00;
        double campo4=0.00;
        int contador=0;

        while (valor!=-1 && encontrado){
            if (valor == '\n' || valor == '\r' && encontrado) {
                valor = read.read();
                valor = read.read();
            }
            while (valor!='\n' && valor!='\r' && valor!=-1){
                while (separador){
                    if (valor!=35 && valor!=-1){
                        campo+=(char)valor;
                    } else{
                        separador = false;
                        contador++;
                    }
                    linea+=(char)valor;
                    valor = read.read();
                }
                separador=true;
                switch (contador){
                    case 2:
                        campo1=campo;
                        break;
                    case 3:
                        campo2=Double.parseDouble(campo);
                        break;
                    case 4:
                        campo3=Double.parseDouble(campo);
                        break;
                    case 5:
                        campo4=Double.parseDouble(campo);
                        break;
                }
                campo="";
                if (contador==5){
                    contador=0;
                }
            }
            if (campo2>random){
                double peso= Math.random()*(campo4-campo3)+campo3;
                System.out.println(usuario + " ha pescado: " + campo1 + " con un peso de: " + peso);
                this.añadirRegistro(usuario, campo1, peso);
                encontrado=false;
            }
            linea="";
        }
        read.close();
    }

    // Pendiente de cambiar.
    public void añadirRegistro(String usuario, String pez, double peso) throws IOException {
        FileReader read = new FileReader("Resource/Files/registres.txt");
        int valor = read.read();
        String documento="";
        while (valor!=-1){
            documento = documento + (char)valor;
            valor= read.read();
        }
        writter = new FileWriter("Resource/Files/registres.txt");
        writter.write(documento + "#" + pez + "#" + usuario + "#" + peso + "#\n");
        writter.close();
        read.close();
    }

    public void estadisticasGlobales(String usuario) throws IOException {
        FileReader read = new FileReader("Resource/Files/registres.txt");
        int valor = read.read();
        boolean separador=true;
        boolean encontrado=true;
        String linea="";
        String campo="";
        double random= Math.random();
        String campo1="";
        String campo2="";
        double campo3=0.00;
        double campo_top=0.00;
        int contador=0;

        while (valor!=-1){
            if (valor == '\n' || valor == '\r' && encontrado) {
                valor = read.read();
            }
            while (valor!='\n' && valor!='\r' && valor!=-1){
                while (separador){
                    if (valor!=35 && valor!=-1){
                        campo+=(char)valor;
                    } else{
                        separador = false;
                        contador++;
                    }
                    linea+=(char)valor;
                    valor = read.read();
                }
                separador=true;
                switch (contador){
                    case 2:
                        campo1=campo;
                        break;
                    case 3:
                        campo2=campo;
                        break;
                    case 4:
                        campo3=Double.parseDouble(campo);
                        break;
                }
                campo="";
                if (contador==4){
                    contador=0;
                }
            }
            if (this.comprobarPez(campo1)){
            } else {
                FileReader read2 = new FileReader("Resource/Files/registres.txt");
                int valor_2 = read2.read();
                boolean separador_2=true;
                boolean encontrado_2=true;
                String linea_2="";
                String campo_2="";
                double random_2= Math.random();
                String campo1_2="";
                String campo2_2="";
                double campo3_2=0.00;
                int contador_2=0;
                while (valor_2!=-1){
                    if (valor_2 == '\n' || valor_2 == '\r') {
                        valor_2 = read2.read();
                    }
                    while (valor_2!='\n' && valor_2!='\r' && valor_2!=-1){
                        while (separador_2){
                            if (valor_2!=35 && valor_2!=-1){
                                campo_2+=(char)valor_2;
                            } else{
                                separador_2 = false;
                                contador_2++;
                            }
                            linea_2+=(char)valor_2;
                            valor_2 = read2.read();
                        }
                        separador_2=true;
                        switch (contador_2){
                            case 2:
                                campo1_2=campo_2;
                                break;
                            case 3:
                                campo2_2=campo_2;
                                break;
                            case 4:
                                campo3_2=Double.parseDouble(campo_2);
                                break;
                        }
                        campo_2="";
                        if (contador_2==4){
                            contador_2=0;
                        }
                    }
                    if (campo1.equals(campo1_2) && campo3_2>campo_top){
                        campo_top=campo3_2;
                    }
                    linea_2="";
                }
                read2.close();
                this.registrarPez(campo1);
                if (usuario==null){
                    System.out.println("Pez:" + campo1 + " peso: " +  campo_top + " pescado por " + campo2);
                } else if (campo2.equals(usuario)){
                    System.out.println("Pez:" + campo1 + " peso: " +  campo_top + " pescado por " + campo2);
                } else {
                }
            }
            campo_top=0;
            linea="";
        }
        FileWriter borrar = new FileWriter("Resource/Files/yaregistrados.txt");
        read.close();
    }

    public boolean comprobarUsuario(String stringComprobador) throws IOException {
        FileReader read = new FileReader("Resource/Files/usuaris.txt");
        String string="";
        int valor= read.read();
        boolean separator = true;
        boolean comprobador = false;
        boolean first=true;
        while (valor!=-1){
            while (separator){
                if (valor!=35 && valor!=-1 || first) {
                    string = string + (char)valor;
                    first=false;
                }else {
                    separator = false;
                }
                valor = read.read();
            }
            separator = true;
            if (string.equals(stringComprobador)){
                comprobador=true;
            } else {

            }
            string="";
        }
        read.close();
        return comprobador;
    }


    public boolean comprobarPez(String stringComprobador) throws IOException {
        FileReader read = new FileReader("Resource/Files/yaregistrados.txt");
        String string="";
        int valor= read.read();
        boolean separator = true;
        boolean comprobador = false;
        boolean first=true;
        while (valor!=-1){
            while (separator){
                if (valor!=35 && valor!=-1) {
                    string = string + (char)valor;
                    first=false;
                }else {
                    separator = false;
                }
                valor = read.read();
            }
            separator = true;
            if (string.equals(stringComprobador)){
                comprobador=true;
            } else {
            }
            string="";
        }
        read.close();
        return comprobador;
    }

    public void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String usuario;
        System.out.println("##########################\n#        Pesca           #\n##########################\n" +
                "1 - Alta d'usuari\n2 - Baixa d'usuari\n3 - Pescar en una pesquera\n4 - Estadistiques per usuari\n" +
                "5 - Estedistiques globals\n6 - Sortir del programa\n##########################\nElije una opcion: ");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Introuzca el nombre del usuario: ");
                usuario = sc2.nextLine();
                this.registrarUsuario(usuario);
                this.menu();
                break;
            case 2:
                System.out.println("Introuzca el nombre del usuario: ");
                usuario = sc2.nextLine();
                this.borrarUsuario(usuario);
                this.menu();
                break;
            case 3:
                System.out.println("Introuzca el nombre del usuario: ");
                usuario = sc2.nextLine();
                if (comprobarUsuario(usuario)){
                    this.subMenu(usuario);
                } else {
                    System.out.println("Usuario no registrado");
                }
                this.menu();
                break;
            case 4:
                System.out.println("Introuzca el nombre del usuario: ");
                usuario = sc2.nextLine();
                this.estadisticasGlobales(usuario);
                this.menu();
                break;
            case 5:
                this.estadisticasGlobales(null);
                this.menu();
                break;
            case 6:
                System.out.println("Cerrando el programa");
                break;
            default:
                System.out.println("Elija una opcion valida");
                this.menu();
        }
    }

    public void subMenu(String usuario) throws IOException {
        String pathMediterranio = "Resource/Files/mediterrania.txt";
        String pathFlorida = "Resource/Files/florida.txt";
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("1 - Pescar en el mediterranio\n2 - Pescar en florida\n3 - Volver al menu\n" +
                "--------------------\nElije una zona donde pescar:");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                this.Pescar(usuario, pathMediterranio);
                this.menu();
                break;
            case 2:
                this.Pescar(usuario, pathFlorida);
                this.menu();
                break;
            case 3:
                System.out.println("Volviendo al menu");
                this.menu();
            default:
                System.out.println("Introduzca una opcion correcta");
                this.subMenu(usuario);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        Pesca p = new Pesca();
        p.menu();
    }
}