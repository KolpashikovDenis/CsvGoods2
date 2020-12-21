package psb.kdv;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

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

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(mwbList.get(0))), "windows-1251"));
        String line = br.readLine();
        while((line = br.readLine()) != null) {
            String s[] = line.split(";");
            String Articul = s[0];
            String Name = s[1].trim();
            double Leftover = Double.parseDouble(s[2].trim());
            double CostPrice = Double.parseDouble(s[3].trim());
            double CostAmount = Double.parseDouble(s[4].trim());

            BufferedReader brr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(barList.get(0))), "windows-1251"));
            String lline = br.readLine();
            while((lline = br.readLine()) != null){
                String ss[] = line.split(";");
                String NomenclatureWBMW = ss[0].trim();
                String WarehouseCity = ss[1].trim();
                int Count = Integer.parseInt(ss[2].trim());
                if(Articul.equals(NomenclatureWBMW)){

                }
            }
        }
    }
}
