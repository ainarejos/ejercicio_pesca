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
        read = new FileReader("Resource/Files/ejemplo.txt");
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
            writter = new FileWriter("Resource/Files/ejemplo.txt");
            writter.write(documento + "\n#" + string + "#");
            writter.close();
        }
        read.close();
    }

    public void borrarUsuario(String usuario) throws IOException {
        read = new FileReader("Resource/Files/ejemplo.txt");
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
        writter = new FileWriter("Resource/Files/ejemplo.txt");
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
        read = new FileReader("Resource/Files/mediterrania.txt");
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
                System.out.println("Has pescado: " + campo1 + " con un peso de: " + peso);
                this.añadirRegistro("Manolo", campo1, peso);
                encontrado=false;
            }
            linea="";
        }
        read.close();
    }

    public void añadirRegistro(String usuario, String pez, double peso) throws IOException {
        read = new FileReader("Resource/Files/registres.txt");
        int valor = read.read();
        String documento="";
        while (valor!=-1){
            documento = documento + (char)valor;
            valor= read.read();
        }
        writter = new FileWriter("Resource/Files/registres.txt");
        writter.write(documento + "\n#" + pez + "#" + usuario + "#" + peso + "#");
        writter.close();
        read.close();
    }

    public void estadisticasGlobales() throws IOException {
        read = new FileReader("Resource/Files/registres.txt");
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
            // Aqui el segundo reader
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
                // Aqui el segundo reader
                if (campo1.equals(campo1_2) && campo3_2>campo_top){
                    campo_top=campo3_2;
                }
                linea_2="";
            }
            read2.close();
            System.out.println(campo_top);
            campo_top=0;
            linea="";
        }
        read.close();
    }


    public boolean comprobarUsuario(String stringComprobador) throws IOException {
        read = new FileReader("Resource/Files/ejemplo.txt");
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
        p.estadisticasGlobales();
    }
}
