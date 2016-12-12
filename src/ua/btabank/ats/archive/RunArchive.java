package ua.btabank.ats.archive;


import java.io.File;
import java.util.ArrayList;

public class RunArchive {
    private  final String pathToFiles = "D:\\INFO\\GNA\\ARCH\\";
    private ArrayList<String> filesToZipList = new ArrayList<String>();
    private ArrayList<String> directoryList = new ArrayList<String>();
    public ArrayList<String> getFilesToZipList() {
        return filesToZipList;
    }




    public  void setFilesToZipList(ArrayList<String> filesToZipList) {
        this.filesToZipList = filesToZipList;
    }

    public String getPathToFiles() {
        return pathToFiles;
    }

    public  ArrayList<String> showDirectoryName(String folder){
        ArrayList<String> dir = new ArrayList<>();
        File directory = new File(folder);
        File[] paths = directory.listFiles();

        for( File x : paths){
            if (x.isDirectory() && String.valueOf(x).length() == 25 ) {

                dir.add(String.valueOf(x));
            }

        }

        return dir;
    }



    public  ArrayList<String> showFilesName(String folder){
        ArrayList<String> files = new ArrayList<>();
        File directory = new File(folder);
        File[] paths = directory.listFiles();

        for( File x : paths){
            if (x.isFile()) {
                files.add(String.valueOf(x));
            }

        }

        return files;
    }





    public RunArchive(){
        runArchive();
    }



    public  void runArchive(){
        System.out.println("Создание zip-архива");

// массив файлов для сжатия
       /* String[] filesToZip = new String[2];

        filesToZip[0] = "D:\\INFO\\GNA\\@F02632172314359845BE016.XML";

        filesToZip[1] = "D:\\INFO\\GNA\\@F02632172314359845BE002.XML";*/

        byte[] buffer = new byte[2048];



        setDirectoryList((showDirectoryName(getPathToFiles())));




        for (String x : getDirectoryList()){
            System.out.println(x);

            String zipFileName = x.concat("\\example.zip");
            setFilesToZipList((showFilesName(x)));

            ArchiveClass.pack(getFilesToZipList(), zipFileName, buffer);
        }












// имя полученного архива

        //String zipFileName = "D:\\INFO\\GNA\\example.zip";

        //ArchiveClass.pack(filesToZip, zipFileName, buffer);

      //  ArchiveClass.pack(getFilesToZipList(), zipFileName, buffer);
    }


    public ArrayList<String> getDirectoryList() {
        return directoryList;
    }

    public void setDirectoryList(ArrayList<String> directoryList) {
        this.directoryList = directoryList;
    }
}
