import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pesca {
    FileReader read = new FileReader("C:\\Users\\alumne-DAM\\Documents\\accessing-data-jpa\\ejercicio_Simulador_Pesca\\Resource\\Files\\ejemplo.txt");
    //FileWriter writter = new FileWriter("C:\\Users\\alumne-DAM\\Documents\\accessing-data-jpa\\ejercicio_Simulador_Pesca\\Resource\\Files\\ejemplo.txt");

    public Pesca() throws IOException {
    }

//    public void write() throws IOException {
//        writter.write("Prueba");
//        writter.close();
//    }
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

    public static void main(String[] args) throws IOException {
        Pesca p = new Pesca();
        //p.write();
        p.read();
    }
}
