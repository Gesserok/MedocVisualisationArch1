package ua.btabank.ats.archive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.Deflater;
public class ArchiveClass {

    public static void pack(ArrayList<String> filesToZip,
                            String zipFileName, byte[] buffer) {

        try {

            ZipOutputStream jos =

                    new ZipOutputStream(

                            new FileOutputStream(zipFileName));

// метод сжатия

            jos.setLevel(Deflater.DEFAULT_COMPRESSION);

            for (String x : filesToZip) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(x);

                jos.putNextEntry(new ZipEntry(x));

                FileInputStream in =

                        new FileInputStream(x);

                int len;

                while ((len = in.read(buffer)) > 0)

                    jos.write(buffer, 0, len);

                jos.closeEntry();

                in.close();

            }

            jos.close();

        } catch (IllegalArgumentException e) {

            e.printStackTrace();

            System.err.println("Некорректный аргумент");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

            System.err.println("Файл не найден");

        } catch (IOException e) {

            e.printStackTrace();

            System.err.println("Ошибка доступа");

        }

    }


 /*  public static void pack(String[] filesToZip,
                            String zipFileName, byte[] buffer) {

        try {

            ZipOutputStream jos =

                    new ZipOutputStream(

                            new FileOutputStream(zipFileName));

// метод сжатия

            jos.setLevel(Deflater.DEFAULT_COMPRESSION);

            for (String x : filesToZip) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(x);

                jos.putNextEntry(new ZipEntry(x));

                FileInputStream in =

                        new FileInputStream(x);

                int len;

                while ((len = in.read(buffer)) > 0)

                    jos.write(buffer, 0, len);

                jos.closeEntry();

                in.close();

            }

            jos.close();

        } catch (IllegalArgumentException e) {

            e.printStackTrace();

            System.err.println("Некорректный аргумент");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

            System.err.println("Файл не найден");

        } catch (IOException e) {

            e.printStackTrace();

            System.err.println("Ошибка доступа");

        }

    }*/


}
