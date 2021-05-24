import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pesca {
    public static FileReader read;

    FileWriter writter;

    public Pesca() throws IOException {
    }

    public void write(String string) throws IOException {
        read = new FileReader("C:\\Users\\alumne-DAM\\Desktop\\ejercicio_pesca\\Resource\\Files\\ejemplo.txt");
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
            writter = new FileWriter("C:\\Users\\alumne-DAM\\Desktop\\ejercicio_pesca\\Resource\\Files\\ejemplo.txt");
            writter.write(documento + "\n#" + string + "#");
            writter.close();
        }
        read.close();
    }

    public void borrarUsuario(String usuario) throws IOException {
        read = new FileReader("C:\\Users\\alumne-DAM\\Desktop\\ejercicio_pesca\\Resource\\Files\\ejemplo.txt");
        String documento="";
        String string="";
        int valor = read.read();
        boolean separator = true;
        boolean comprobador = false;
        boolean firts= true;
        while (valor!=-1){
            while (valor!='\n' && valor!=-1){
                if (valor!=35 && valor!=-1 || firts==true){
                    string = string + (char)valor;
                    firts=false;
                } else {
                    string = string + (char)valor;
                    separator = false;
                }
                valor = read.read();
            }
            if (valor == 10){
                string = string + (char)valor;
                valor = read.read();
            }
            separator = true;
            if (string.equals( '#' + usuario + '#' + '\n') || (string.equals( '#' + usuario + '#' + '\r' + "\n") ||(string.equals( '#' + usuario + '#')))){

            } else {
                documento+=string;
            }
            string="";
        }
        read.close();
        writter = new FileWriter("C:\\Users\\alumne-DAM\\Desktop\\ejercicio_pesca\\Resource\\Files\\ejemplo.txt");
        writter.write(documento);
        writter.close();
    }

    public void read() throws IOException {
        String string="";
        int valor= read.read();
        boolean separator = true;
        while (valor!=-1){
            while (separator){
                if (valor!=35 && valor!=-1) {
                    string= string + (char)valor;
                }else {
                    separator = false;
                }
                valor = read.read();
            }
            separator = true;
            System.out.print(string + " ");
            string="";
        }
        read.close();
    }

    public void leerPesquera() throws IOException {
        read = new FileReader("C:\\Users\\alumne-DAM\\Desktop\\ejercicio_pesca\\Resource\\Files\\mediterrania.txt");
        int valor = read.read();
        boolean separador=true;
        String linea="";
        String campo="";
        String campo1="";
        String campo2="";
        String campo3="";
        String campo4="";
        int contador=0;
        while (valor!=-1){
            if (valor == '\n' || valor == '\r') {
                valor = read.read();
            }
            while (valor!='\n' && valor!='\r' && valor!=-1){
                while (separador){
                    if (valor!=35 && valor!=-1){
                        campo+=(char)valor;
                    } else{
                        separador = false;
                    }
                    linea+=(char)valor;
                    valor = read.read();
                }
                separador=true;
                switch (contador){
                    case 1:
                        campo1=campo;
                        break;
                    case 2:
                        campo2=campo;
                        break;
                    case 3:
                        campo3=campo;
                        break;
                    case 4:
                        campo4=campo;
                        break;
                }
                System.out.println(campo4);
                campo="";
                if (contador==4){
                    contador=0;
                }
                contador++;
            }
            linea="";
            System.out.println(linea);
        }
        read.close();
    }

    public boolean comprobarUsuario(String stringComprobador) throws IOException {
        read = new FileReader("C:\\Users\\alumne-DAM\\Desktop\\ejercicio_pesca\\Resource\\Files\\ejemplo.txt");
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
            System.out.print(string + " ");
            if (string.equals(stringComprobador)){
                comprobador=true;
            } else {

            }
            string="";
        }
        read.close();
        return comprobador;
    }

    public static void main(String[] args) throws IOException {
        Pesca p = new Pesca();
        //p.write("Luis");
        //p.borrarUsuario("Adan");
        p.leerPesquera();
    }
}
