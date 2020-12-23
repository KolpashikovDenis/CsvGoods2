package psb.kdv;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Properties ini = new Properties();
        ini.load(new FileInputStream((new File("settings.ini"))));

        String baseDir = ini.getProperty("BaseFolder");
        String mwb = ini.getProperty("MyWarehouseFolder");
        String barcodes = ini.getProperty("GoodsBarcodeFolder");
        String finals = ini.getProperty("ConsolidatedFolder");

        Path mwbPath = Paths.get(baseDir, mwb);
        Path barcodesPath = Paths.get(baseDir, barcodes);
        Path finalsDir = Paths.get(baseDir, finals);

        List<String> mwbList = new ArrayList<String>();
        File[] fArray = new File(String.valueOf(mwbPath)).listFiles();
        for(File file: fArray){
            mwbList.add(file.toString());
        }
        Collections.reverse(mwbList);

        List<String> barList = new ArrayList<String> ();
        fArray = new File(String.valueOf(barcodesPath)).listFiles();
        for(File file: fArray){
            barList.add(file.toString());
        }
        Collections.reverse(barList);

        List<String> cities = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        BufferedReader brr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(barList.get(0))), "utf-8"));
        String lline = brr.readLine();
        while((lline = brr.readLine()) != null){
            list.add(lline);
            String s[] = lline.split(";");
            cities.add(s[1].trim());
        }
        Set<String> uniqueCities = new HashSet<String>(cities);

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(mwbList.get(0))), "windows-1251"));
        String line = br.readLine();
        while((line = br.readLine()) != null) {
            String s[] = line.split(";");
            String Articul = s[0];
            String Name = s[1].trim();
            double Leftover = Double.parseDouble(s[2].trim());
            double CostPrice = Double.parseDouble(s[3].trim());
            double CostAmount = Double.parseDouble(s[4].trim());

            for(String ln: list){
                String[] ss = ln.split(";");
                String NomenclatureWBMW = ss[0].trim();
                String WarehouseCity = ss[1].trim();
                int count = Integer.parseInt(ss[2].trim());
                System.out.println("-");
            }

//            BufferedReader brr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(barList.get(0))), "windows-1251"));
//            String lline = br.readLine();
//            while((lline = br.readLine()) != null){
//                String ss[] = lline.split(";");
//                String NomenclatureWBMW = ss[0].trim();
//                String WarehouseCity = ss[1].trim();
//                double Count = Double.parseDouble(ss[2].trim());
//                if(Articul.equals(NomenclatureWBMW)){
//                    System.out.println(lline);
//                }
//            }
        }
    }
}
