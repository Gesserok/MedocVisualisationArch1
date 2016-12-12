package ua.btabank.ats.archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Anton on 09.12.2016.
 */
public class FolderZip {


    public FolderZip(String source_dir, String zip_file){
        try {
            Zip(source_dir, zip_file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //private FolderZip(){}
    private void Zip(String source_dir, String zip_file) throws Exception
    {
        // Cоздание объекта ZipOutputStream из FileOutputStream
        FileOutputStream fout = new FileOutputStream(zip_file);
        ZipOutputStream zout = new ZipOutputStream(fout);
        // Определение кодировки
       // zout.setEncoding("CP866");




        // Создание объекта File object архивируемой директории
        File fileSource = new File(source_dir);



        addDirectory(zout, fileSource);

        // Закрываем ZipOutputStream
        zout.close();

        System.out.println("Zip файл создан!");
    }
    private void addDirectory(ZipOutputStream zout, File fileSource)
            throws Exception
    {

        File[] files = fileSource.listFiles();




        System.out.println("Добавление директории <" + fileSource.getName() + ">");
        for(int i = 0; i < files.length; i++) {
            // Если file является директорией, то рекурсивно вызываем
            // метод addDirectory
            if(files[i].isDirectory() && files[i].getName().length() == 8) {
                addDirectory(zout, files[i]);
                continue;
            }
            System.out.println("Добавление файла <" + files[i].getName() + ">");

            FileInputStream fis = new FileInputStream(files[i]);

            zout.putNextEntry(new ZipEntry(files[i].getPath()));

            byte[] buffer = new byte[4048];
            int length;
            while((length = fis.read(buffer)) > 0)
                zout.write(buffer, 0, length);
            // Закрываем ZipOutputStream и InputStream
            zout.closeEntry();
            fis.close();
        }
    }

}
