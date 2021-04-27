package tasktracking.controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HomeController {
    @FXML

    public void handleCreatorButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("profile");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Profile ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
    @FXML

    public void handleGeneralWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("generalwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า generalwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
    @FXML

    public void handleRegularWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("regularwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า regularwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
    @FXML

    public void handleForwardWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("forwardwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า forwardwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML

    public void handleProjectWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("projectwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า projectwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML public void initialize(){
        String fs = File.separator;
        String dir = System.getProperty("user.dir")+fs+"classes"+fs+"List";
        String filename = dir+fs+"GeneralList.txt";
        String filename2 = dir+fs+"RegularList.txt";
        String filename3 = dir+fs+"ForwardList.txt";
        String filename4 = dir+fs+"ProjectList.txt";
        String filename5 = dir+fs+"RegularDayOfWeek.txt";
        File file = new File(dir);
        BufferedWriter bufferedWriter = null;
        try{
            if(!file.exists()){
                file.mkdirs();
                File myFile = new File(filename);
                File myFile2 = new File(filename2);
                File myFile3 = new File(filename3);
                File myFile4 = new File(filename4);
                File myFile5 = new File(filename5);
                myFile.createNewFile();
                myFile2.createNewFile();
                myFile3.createNewFile();
                myFile4.createNewFile();
                myFile5.createNewFile();
                bufferedWriter = new BufferedWriter(new FileWriter(filename));
                bufferedWriter.write("1179,GeneralWork01,1,10,10,20,20,2020-03-01,math");
                bufferedWriter.newLine();
                bufferedWriter.write("3358,GeneralWork02,4,6,0,18,0,2020-03-18,eng");
                bufferedWriter.newLine();
                bufferedWriter.write("4365,GeneralWork03,2,0,0,18,0,2021-03-25,sci");
                bufferedWriter.newLine();
                bufferedWriter.write("3040,GeneralWork04,0,6,0,23,0,2021-03-31,-");
                bufferedWriter.newLine();
                bufferedWriter.write("8351,GeneralWork05,4,0,0,18,0,2022-03-10,-");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter = new BufferedWriter(new FileWriter(filename2));
                bufferedWriter.write("1179,RegularWork01,0,1,1,2,2,2019-03-01,math");
                bufferedWriter.newLine();
                bufferedWriter.write("3358,RegularWork02,1,2,2,3,3,2019-03-14,eng");
                bufferedWriter.newLine();
                bufferedWriter.write("4365,RegularWork03,2,3,3,4,4,2021-03-11,sci");
                bufferedWriter.newLine();
                bufferedWriter.write("3040,RegularWork04,3,4,4,5,5,2022-03-31,-");
                bufferedWriter.newLine();
                bufferedWriter.write("8351,RegularWork05,4,5,5,6,6,2025-03-13,-");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter = new BufferedWriter(new FileWriter(filename3));
                bufferedWriter.write("1179,ForwardWork01,earth,0,0,0,1,1,2020-12-17,eng");
                bufferedWriter.newLine();
                bufferedWriter.write("3358,ForwardWork02,poo,1,1,1,2,2,2019-10-23,sci");
                bufferedWriter.newLine();
                bufferedWriter.write("4365,ForwardWork03,non,2,2,2,3,3,2021-03-29,math");
                bufferedWriter.newLine();
                bufferedWriter.write("3040,ForwardWork04,poom,3,4,4,5,5,2026-06-26,-");
                bufferedWriter.newLine();
                bufferedWriter.write("8351,ForwardWork05,pung,4,6,6,7,7,2028-03-28,-");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter = new BufferedWriter(new FileWriter(filename4));
                bufferedWriter.write("1179,ProjectWork01,korn1,0,0,0,0,0,2021-03-11,2021-03-11,math");
                bufferedWriter.newLine();
                bufferedWriter.write("3358,ProjectWork02,korn2,1,0,0,0,0,2020-09-16,2020-09-16,eng");
                bufferedWriter.newLine();
                bufferedWriter.write("4365,ProjectWork03,korn3,3,0,0,0,0,2023-03-16,2023-03-16,sci");
                bufferedWriter.newLine();
                bufferedWriter.write("3040,ProjectWork04,korn4,3,0,0,0,0,2021-03-19,2021-03-19,-");
                bufferedWriter.newLine();
                bufferedWriter.write("8351,ProjectWork05,korn5,4,0,0,0,0,2025-03-12,2025-03-12,-\n");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter = new BufferedWriter(new FileWriter(filename5));
                bufferedWriter.write("1179,2019-03-01,true,true,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("3358,2019-03-14,false,false,true,true,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("4365,2021-03-12,false,false,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("3040,2021-03-30,false,false,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("8351,2021-03-14,false,false,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("3588,2021-03-10,false,false,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("4,2021-03-13,false,false,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("1179,2019-03-01,true,true,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("3358,2019-03-14,false,false,true,true,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("4365,2021-03-11,false,false,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("3040,2022-03-31,false,false,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.write("8351,2025-03-13,false,false,false,false,false,false");
                bufferedWriter.newLine();
                bufferedWriter.flush();


                if(bufferedWriter != null) bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

