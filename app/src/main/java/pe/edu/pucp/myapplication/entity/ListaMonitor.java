package pe.edu.pucp.myapplication.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaMonitor {

    public static ArrayList<Monitor> listaMonitor = new ArrayList<>();

    public static ArrayList<Monitor> getlistamonitor(){return listaMonitor;}

    public static ArrayList<String> descripcionMonitor = new ArrayList<>();

    public static ArrayList<Monitor> returnList(){
        return listaMonitor;
    }

    public static void addMonitor(Monitor monitor){
        listaMonitor.add(monitor);
    }

    public static void deleteMonitor(Monitor monitor){
        listaMonitor.remove(monitor);
    }


    private static String marcaValue(int i){
        String marcas[] = new String[]{
                "Apple", "ASUS", "DELL", "HP", "MSI", "Microsoft"
        };
        return marcas[i];
    }

    private static String pulgadasValue(int i){
        String pulgadas[] = new String[]{
                "14","17","20","24"
        };
        return pulgadas[i];
    }



    public static boolean existMonitor(String activo){
        for(Monitor i : listaMonitor){
            if(i.getActivo().equalsIgnoreCase(activo)){
                return true;
            }
        }
        return false;
    }

    public static Monitor findMonitorSave(String activo){
        Monitor ret = null;
        //String msg="nada";
        for(Monitor i : listaMonitor){
            //msg=i.getActivo()+" !=? "+activo;
            if(i.getActivo().equals(activo)){
                //msg="Paso";
                return i;
            }
        }
        return new Monitor("ERROR","0","0",0,0, "No");
    }

    public static ArrayList<String> searchMonitor(String activo){
        ArrayList<String> ret = new ArrayList<>();
        String desc = "";
        for(Monitor i : listaMonitor){
            if(i.getActivo().equalsIgnoreCase(activo)){
                desc="";
                desc+="Activo: "+i.getActivo()+"\n";
                desc+="PC: "+ i.getPcActivo()+"\n";
                desc+="Marca: "+marcaValue(Integer.parseInt(i.getMarca()))+"\n";
                desc+="Pulgadas: "+pulgadasValue(i.getPulgadas())+"\n";
                desc+="A??o: "+i.getAno()+"\n";
                desc+="Modelo: "+i.getModelo()+"\n";
                ret.add(desc);
                return ret;
            }
        }
        return ret;
    }

    public static ArrayList<String> retDescpMonitores(){
        ArrayList<String> lista = new ArrayList<>();
        String desc = "";
        for(Monitor i : listaMonitor){
            desc="";
            desc+="Activo: "+i.getActivo()+"\n";
            desc+="PC: "+ i.getPcActivo()+"\n";
            desc+="Marca: "+marcaValue(Integer.parseInt(i.getMarca()))+"\n";
            desc+="Pulgadas: "+pulgadasValue(i.getPulgadas())+"\n";
            desc+="A??o: "+i.getAno()+"\n";
            desc+="Modelo: "+i.getModelo()+"\n";
            lista.add(desc);
        }
        return lista;
    }

    public static void updateMonitor(String activo, Monitor monitor){

        for(Monitor i : listaMonitor){
            if(i.getActivo().equalsIgnoreCase(activo)){
                i.setActivo(monitor.getActivo());
                i.setPcActivo(monitor.getPcActivo());
                i.setAno(monitor.getAno());
                i.setModelo(monitor.getModelo());
                i.setPulgadas(monitor.getPulgadas());
                i.setMarca(monitor.getMarca());
                break;
            }
        }
    }

    public static void eliminarMonitor(Monitor monitor){
        listaMonitor.remove(monitor);
    }

}