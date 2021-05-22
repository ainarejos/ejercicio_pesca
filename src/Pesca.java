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
        read = new FileReader("C:\\Users\\adani\\IdeaProjects\\ejercicio_pesca\\Resource\\Files\\ejemplo.txt");
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
            writter = new FileWriter("C:\\Users\\adani\\IdeaProjects\\ejercicio_pesca\\Resource\\Files\\ejemplo.txt");
            writter.write(documento + "\n#" + string + "#");
            writter.close();
        }
        read.close();
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


    public boolean comprobarUsuario(String stringComprobador) throws IOException {
        read = new FileReader("C:\\Users\\adani\\IdeaProjects\\ejercicio_pesca\\Resource\\Files\\ejemplo.txt");
        String string="";
        int valor= read.read();
        boolean separator = true;
        boolean comprobador = false;
        while (valor!=-1){
            while (separator){
                if (valor!=35 && valor!=-1) {
                    string = string + (char)valor;
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

    public void registrarUsuario(String usuario){
        Usuario user = new Usuario(usuario);


    }
    public static void main(String[] args) throws IOException {
        Pesca p = new Pesca();
        p.write("Gustavo");
//        if (p.comprobarUsuario("Diego")){
//            System.out.println("Joshua gay");
//        }
    }
}
