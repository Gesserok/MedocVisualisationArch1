package ua.btabank.ats.archive;



public class FolderZipThread extends Thread {

    public FolderZipThread(){
        super();
    }

    public void run(){

        FolderZip runFolderZip = new FolderZip("D:\\INFO\\GNA\\ARCH", "arch.zip");

    }

}