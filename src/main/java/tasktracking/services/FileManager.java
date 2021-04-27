package tasktracking.services;

import java.io.*;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import javafx.scene.control.DatePicker;
import tasktracking.models.*;

public class FileManager {

    public ArrayList<GeneralWork> readFileGenaralList() {
        ArrayList<GeneralWork> generalWorks = new ArrayList<>();
        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile() + "/classes/List/GeneralList.txt");

            System.out.println(file1.getAbsoluteFile());
           
            buffer = new BufferedReader(new FileReader(file1));

            ArrayList<Integer> number = new ArrayList<>();
            Random r = new Random();
            r.setSeed(191);
            for(int i=0;i<=10000;i++){
                number.add(r.nextInt(10000));
            }
            System.out.println(number);

            String a = null;

            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String count = data[0];
                String jobName = data[1];
                String priority = data[2];
                String hour1 = data[3];
                String minute1 = data[4];
                String hour2 = data[5];
                String minute2 = data[6];
                String date = data[7];
                String category = data[8];
                System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]+" "+data[6]+" "+data[7]+" "+data[8]);

                generalWorks.add(new GeneralWork(Integer.parseInt(count),jobName,Integer.parseInt(priority),Integer.parseInt(hour1),Integer.parseInt(minute1),Integer.parseInt(hour2),Integer.parseInt(minute2),LocalDate.parse(date),category));
            }
            System.out.println();
            //System.out.println(generalWorks.get(0).showCategory());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return generalWorks;
    }

    public void saveFileGeneralList(GeneralWork general){
        try {
            //System.out.println("///////////////         saveFileGeneralList");
            //File file1 = new File("src\\main\\resources\\List\\GeneralList.txt");
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/GeneralList.txt");
            FileWriter fileWriter = new FileWriter(file1, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(general.test());
            writer.newLine();
            writer.flush();
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editFileGeneralList(int count, String jobName, String priority, String hour1, String minute1, String hour2, String minute2, DatePicker date, String category){
        try {
            //System.out.println("///////////////         editFileGeneralList");
            //File file1 = new File("src\\main\\resources\\List\\GeneralList.txt");
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/GeneralList.txt");
            BufferedReader buffer = new BufferedReader(new FileReader(file1));

            RandomAccessFile raf = new RandomAccessFile(file1, "rw");
            boolean found = false;
            String lineString = "";
            String[] data = null;
            while ((lineString = raf.readLine()) != null) {
                //System.out.println("+++++++++++"+lineString);
                data = lineString.split(",");
                int count1 = Integer.parseInt(data[0]);

                if (count1 == count) {
                    found = true;
                    break;
                }
            }

            if(found == true){
                String check = "";
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);

                while ((lineString = raf.readLine()) != null) {
                    //System.out.println("///////////////"+lineString);
                    data = lineString.split(",");
                    check = data[0];

                    if(check.equals(String.valueOf(count))){
                        if(category.trim().equals("")){
                            lineString = count+","+jobName+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date.getValue()+","+"-";
                        }else {
                            lineString = count+","+jobName+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date.getValue()+","+category;
                        }
                    }

                    tmpraf.writeBytes(lineString);
                    tmpraf.writeBytes(System.lineSeparator());

                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                //System.out.println("updated. ");
            }else{
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
            //System.out.println();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (NumberFormatException nef) {
            nef.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void deleteFileGeneralList(int count){
        try {
            // Get the name of the contact to be updated
            // from the Command line argument
            String newName = String.valueOf(count);

            String nameNumberString;
            String name;
            long number;
            int index;

            // Using file pointer creating the file.
            File file = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/GeneralList.txt");


            if (!file.exists()) {

                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.
            RandomAccessFile raf
                    = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Checking whether the name of contact exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // splitting the string to get name and
                // number
                String[] lineSplit = nameNumberString.split(",");

                // separating name and number.
                name = lineSplit[0];

                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }

            // Delete the contact if record exists.
            if (found == true) {

                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);
                while (raf.getFilePointer() < raf.length()) {
                    nameNumberString = raf.readLine();
                    index = nameNumberString.indexOf(',');
                    name = nameNumberString.substring(0, index);
                    if (name.equals(newName)) {
                        continue;
                    }
                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer()
                        < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                //System.out.println(" Friend deleted. ");
            }
            else {
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
        }

        catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<String> checkCategoryGeneralList(){

        List<String> aa = new ArrayList<>();
        Set<String> bb ;

        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/GeneralList.txt");
            //File file1 = new File("src\\main\\resources\\List\\GeneralList.txt");

            //File file = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/GeneralList.txt");
            //System.out.println(file1);
            buffer = new BufferedReader(new FileReader(file1));
            String a = null;
            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String category = data[8];
                aa.add(data[8]);
                //System.out.println(data[7]);
            }
            aa = aa.stream().distinct().collect(Collectors.toList());
            //System.out.println(aa);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return (ArrayList<String>) aa;
    }

    /////

    public ArrayList<RegularWork> readFileRegularList() {
        ArrayList<RegularWork> regularWorks = new ArrayList<>();
        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile() + "/classes/List/RegularList.txt");
            //File file1 = new File("src\\main\\resources\\List\\RegularList.txt");
            System.out.println(file1.getAbsoluteFile());

            buffer = new BufferedReader(new FileReader(file1));

            ArrayList<Integer> number = new ArrayList<>();
            Random r = new Random();
            r.setSeed(191);
            for(int i=0;i<=10000;i++){
                number.add(r.nextInt(10000));
            }
            System.out.println(number);

            String a = null;

            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String count = data[0];
                String jobName = data[1];
                String priority = data[2];
                String hour1 = data[3];
                String minute1 = data[4];
                String hour2 = data[5];
                String minute2 = data[6];
                String date = data[7];
                String category = data[8];
                System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]+" "+data[6]+" "+data[7]+" "+data[8]);

                regularWorks.add(new RegularWork(Integer.parseInt(count),jobName,Integer.parseInt(priority),Integer.parseInt(hour1),Integer.parseInt(minute1),Integer.parseInt(hour2),Integer.parseInt(minute2),LocalDate.parse(date),category));
            }
            System.out.println();
            //System.out.println(regularWorks.get(0).showCategory());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return regularWorks;
    }

    public void saveFileRegularList(RegularWork regular){
        try {
            //File file1 = new File("src\\main\\resources\\List\\RegularList.txt");
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/RegularList.txt");
            FileWriter fileWriter = new FileWriter(file1, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(regular.test());
            writer.newLine();
            writer.flush();
            writer.close();
            saveRegularDayOfWeek(regular);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editFileRegularList(int count,String jobName,String priority,String hour1,String minute1,String hour2,String minute2,DatePicker date,String category){
        try {
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/RegularList.txt");
            BufferedReader buffer = new BufferedReader(new FileReader(file1));

            RandomAccessFile raf = new RandomAccessFile(file1, "rw");
            boolean found = false;
            String lineString = "";
            String[] data = null;
            while ((lineString = raf.readLine()) != null) {
                //System.out.println("+++++++++++"+lineString);
                data = lineString.split(",");
                int count1 = Integer.parseInt(data[0]);

                if (count1 == count) {
                    found = true;
                    break;
                }
            }

            if(found == true){
                String check = "";
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);

                while ((lineString = raf.readLine()) != null) {
                    //System.out.println("///////////////"+lineString);
                    int index = lineString.indexOf(',');
                    check = lineString.substring(0,index);

                    if(check.equals(String.valueOf(count))){
                        if(category.trim().equals("")){
                            lineString = count+","+jobName+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date.getValue()+","+"-";
                        }else {
                            lineString = count+","+jobName+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date.getValue()+","+category;
                        }
                    }

                    tmpraf.writeBytes(lineString);
                    tmpraf.writeBytes(System.lineSeparator());

                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                //System.out.println("updated. ");
            }else{
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
            //System.out.println();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (NumberFormatException nef) {
            nef.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void deleteFileRegularList(int count){
        try {
            String newName = String.valueOf(count);

            String nameNumberString;
            String name;
            long number;
            int index;

            File file = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/RegularList.txt");


            if (!file.exists()) {

                file.createNewFile();
            }

            RandomAccessFile raf
                    = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {

                nameNumberString = raf.readLine();
                String[] lineSplit = nameNumberString.split(",");
                name = lineSplit[0];

                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }

            if (found == true) {

                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);
                while (raf.getFilePointer() < raf.length()) {
                    nameNumberString = raf.readLine();
                    index = nameNumberString.indexOf(',');
                    name = nameNumberString.substring(0, index);
                    if (name.equals(newName)) {
                        continue;
                    }
                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer()
                        < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
            }
            else {
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
        }

        catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<String> checkCategoryRegularList(){

        List<String> aa = new ArrayList<>();
        Set<String> bb ;

        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/RegularList.txt");
            //File file1 = new File("src\\main\\resources\\List\\GeneralList.txt");

            //File file = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/GeneralList.txt");
            //System.out.println(file1);
            buffer = new BufferedReader(new FileReader(file1));
            String a = null;
            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String category = data[8];
                aa.add(data[8]);
                //System.out.println(data[7]);
            }
            aa = aa.stream().distinct().collect(Collectors.toList());
            //System.out.println(aa);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return (ArrayList<String>) aa;
    }

    public ArrayList<RegularDayofWeek> readFileRegularDayOfWeek(int count) {
        ArrayList<RegularDayofWeek> regularDayofWeeks = new ArrayList<>();
        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile() + "/classes/List/RegularDayOfWeek.txt");
            //System.out.println(file1.getAbsoluteFile());
            buffer = new BufferedReader(new FileReader(file1));
            String a = null;

            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String index= data[0];
                String date = data[1];
                String status1 = data[2];
                String status2 = data[3];
                String status3 = data[4];
                String status4 = data[5];
                String status5 = data[6];
                String status6 = data[7];
                if(Integer.parseInt(index) == count){
                    System.out.println(index);
                    for(int i=0;i<6;i++){
                        regularDayofWeeks.add(new RegularDayofWeek(LocalDate.parse(date).plusDays(i+1)));
                        regularDayofWeeks.get(i).showDate();
                    }
                    regularDayofWeeks.get(0).setStatus2(Boolean.parseBoolean(status1));
                    regularDayofWeeks.get(1).setStatus2(Boolean.parseBoolean(status2));
                    regularDayofWeeks.get(2).setStatus2(Boolean.parseBoolean(status3));
                    regularDayofWeeks.get(3).setStatus2(Boolean.parseBoolean(status4));
                    regularDayofWeeks.get(4).setStatus2(Boolean.parseBoolean(status5));
                    regularDayofWeeks.get(5).setStatus2(Boolean.parseBoolean(status6));

                }
            }
            System.out.println();
            //System.out.println(generalWorks.get(0).showCategory());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return regularDayofWeeks;
    }

    public void editRegularDayOfWeek(RegularWork regularWork){
        try {
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/RegularDayOfWeek.txt");
            //BufferedReader buffer = new BufferedReader(new FileReader(file1));
            RandomAccessFile raf = new RandomAccessFile(file1, "rw");
            boolean found = false;
            String lineString = "";
            String[] data = null;
            while ((lineString = raf.readLine()) != null) {
                //System.out.println("+++++++++++"+lineString);
                data = lineString.split(",");
                int count1 = Integer.parseInt(data[0]);

                if (count1 == regularWork.showCount()) {
                    found = true;
                    break;
                }
            }

            if(found == true){
                String check = "";
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);

                while ((lineString = raf.readLine()) != null) {
                    int index = lineString.indexOf(',');
                    check = lineString.substring(0,index);

                    if(regularWork.showCount()==Integer.parseInt(check)){
                        lineString = check+","+regularWork.showDateStart().toString()+","+regularWork.showDayOfWeeks().get(0).getStatus()+","+regularWork.showDayOfWeeks().get(1).getStatus()+","+regularWork.showDayOfWeeks().get(2).getStatus()
                                +","+regularWork.showDayOfWeeks().get(3).getStatus()+","+regularWork.showDayOfWeeks().get(4).getStatus()+","+regularWork.showDayOfWeeks().get(5).getStatus();
                    }
                    tmpraf.writeBytes(lineString);
                    tmpraf.writeBytes(System.lineSeparator());

                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                //System.out.println("updated. ");
            }else{
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
            //System.out.println();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (NumberFormatException nef) {
            nef.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void saveRegularDayOfWeek(RegularWork regular){
        try {
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/RegularDayOfWeek.txt");
            FileWriter fileWriter = new FileWriter(file1, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(regular.test1());
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /////

    public ArrayList<ForwardWork> readFileForwardList() {
        ArrayList<ForwardWork> forwardWorks = new ArrayList<>();
        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile() + "/classes/List/ForwardList.txt");
            System.out.println(file1.getAbsoluteFile());
            buffer = new BufferedReader(new FileReader(file1));

            ArrayList<Integer> number = new ArrayList<>();
            Random r = new Random();
            r.setSeed(191);
            for(int i=0;i<=10000;i++){
                number.add(r.nextInt(10000));
            }
            System.out.println(number);

            String a = null;

            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String count = data[0];
                String jobName = data[1];
                String responsibleMan = data[2];
                String priority = data[3];
                String hour1 = data[4];
                String minute1 = data[5];
                String hour2 = data[6];
                String minute2 = data[7];
                String date = data[8];
                String category = data[9];
                System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]+" "+data[6]+" "+data[7]+" "+data[8]+" "+data[9]);

                forwardWorks.add(new ForwardWork(Integer.parseInt(count),jobName,responsibleMan,Integer.parseInt(priority),Integer.parseInt(hour1),Integer.parseInt(minute1),Integer.parseInt(hour2),Integer.parseInt(minute2),LocalDate.parse(date),category));
            }
            System.out.println();
            //System.out.println(generalWorks.get(0).showCategory());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return forwardWorks;
    }

    public void saveFileForwardList(ForwardWork forward){
        try {
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/ForwardList.txt");
            FileWriter fileWriter = new FileWriter(file1, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(forward.test());
            writer.newLine();
            writer.flush();
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editFileForwardList(int count, String jobName,String responsibleMan,String priority, String hour1, String minute1, String hour2, String minute2, DatePicker date, String category){
        try {
            //System.out.println("///////////////         editFileGeneralList");
            //File file1 = new File("src\\main\\resources\\List\\GeneralList.txt");
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/ForwardList.txt");
            RandomAccessFile raf = new RandomAccessFile(file1, "rw");
            boolean found = false;
            String lineString = "";
            String[] data = null;
            while ((lineString = raf.readLine()) != null) {
                data = lineString.split(",");
                int count1 = Integer.parseInt(data[0]);

                if (count1 == count) {
                    found = true;
                    break;
                }
            }

            if(found == true){
                String check = "";
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);

                while ((lineString = raf.readLine()) != null) {
                    //System.out.println("///////////////"+lineString);
                    data = lineString.split(",");
                    check = data[0];

                    if(check.equals(String.valueOf(count))){
                        if(category.trim().equals("")){
                            lineString = count+","+jobName+","+responsibleMan+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date.getValue()+","+"-";
                        }else {
                            lineString = count+","+jobName+","+responsibleMan+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date.getValue()+","+category;
                        }
                    }

                    tmpraf.writeBytes(lineString);
                    tmpraf.writeBytes(System.lineSeparator());

                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                //System.out.println("updated. ");
            }else{
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
            //System.out.println();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (NumberFormatException nef) {
            nef.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void deleteFileForwardList(int count){
        try {
            String newName = String.valueOf(count);

            String nameNumberString;
            String name;
            long number;
            int index;

            File file = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/ForwardList.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit = nameNumberString.split(",");
                name = lineSplit[0];
                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }
            if (found == true) {
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);
                while (raf.getFilePointer() < raf.length()) {
                    nameNumberString = raf.readLine();
                    index = nameNumberString.indexOf(',');
                    name = nameNumberString.substring(0, index);
                    if (name.equals(newName)) {
                        continue;
                    }
                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
            }
            else {
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
        }

        catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<String> checkCategoryForwardList(){

        List<String> aa = new ArrayList<>();
        Set<String> bb ;

        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/ForwardList.txt");
            buffer = new BufferedReader(new FileReader(file1));
            String a = null;
            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String category = data[9];
                aa.add(data[9]);
            }
            aa = aa.stream().distinct().collect(Collectors.toList());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return (ArrayList<String>) aa;
    }

    /////

    public ArrayList<ProjectWork> readFileProjectList() {
        ArrayList<ProjectWork> projectWorks = new ArrayList<>();
        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile() + "/classes/List/ProjectList.txt");
            System.out.println(file1.getAbsoluteFile());
            buffer = new BufferedReader(new FileReader(file1));

            ArrayList<Integer> number = new ArrayList<>();
            Random r = new Random();
            r.setSeed(191);
            for(int i=0;i<=10000;i++){
                number.add(r.nextInt(10000));
            }
            System.out.println(number);

            String a = null;
            int index = 0;
            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String count = data[0];
                String jobName = data[1];
                String projectLeader = data[2];
                String priority = data[3];
                String hour1 = data[4];
                String minute1 = data[5];
                String hour2 = data[6];
                String minute2 = data[7];
                String dateStart = data[8];
                String dateEnd = data[9];
                String category = data[10];

                System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]+" "+data[6]+" "+data[7]+" "+data[8]+" "+data[9]+" "+data[10]);

                projectWorks.add(new ProjectWork(Integer.parseInt(count),jobName,projectLeader,Integer.parseInt(priority),Integer.parseInt(hour1),Integer.parseInt(minute1),Integer.parseInt(hour2),Integer.parseInt(minute2),LocalDate.parse(dateStart),category));
                projectWorks.get(index).setDateEnd(LocalDate.parse(dateEnd));
                index++;
            }
            System.out.println();
            //System.out.println(generalWorks.get(0).showCategory());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return projectWorks;
    }

    public void saveFileProjectList(ProjectWork project){
        try {
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/ProjectList.txt");
            FileWriter fileWriter = new FileWriter(file1, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(project.test());
            writer.newLine();
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editFileProjectList(int count, String jobName,String projectLeader,String priority, String hour1, String minute1, String hour2, String minute2, DatePicker datestart, DatePicker dateend,String category){
        try {
            //System.out.println("///////////////         editFileGeneralList");
            //File file1 = new File("src\\main\\resources\\List\\GeneralList.txt");
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/ProjectList.txt");
            RandomAccessFile raf = new RandomAccessFile(file1, "rw");
            boolean found = false;
            String lineString = "";
            String[] data = null;
            while ((lineString = raf.readLine()) != null) {
                data = lineString.split(",");
                int count1 = Integer.parseInt(data[0]);

                if (count1 == count) {
                    found = true;
                    break;
                }
            }

            if(found == true){
                String check = "";
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);

                while ((lineString = raf.readLine()) != null) {
                    //System.out.println("///////////////"+lineString);
                    data = lineString.split(",");
                    check = data[0];

                    if(check.equals(String.valueOf(count))){
                        if(category.trim().equals("")){
                            lineString = count+","+jobName+","+projectLeader+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+datestart.getValue()+","+dateend.getValue()+","+"-";
                        }else {
                            lineString = count+","+jobName+","+projectLeader+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+datestart.getValue()+","+dateend.getValue()+","+category;
                        }
                    }

                    tmpraf.writeBytes(lineString);
                    tmpraf.writeBytes(System.lineSeparator());

                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                //System.out.println("updated. ");
            }else{
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
            //System.out.println();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (NumberFormatException nef) {
            nef.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void deleteFileProjectList(int count){
        try {
            String newName = String.valueOf(count);

            String nameNumberString;
            String name;
            long number;
            int index;

            File file = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/ProjectList.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit = nameNumberString.split(",");
                name = lineSplit[0];
                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }
            if (found == true) {
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);
                while (raf.getFilePointer() < raf.length()) {
                    nameNumberString = raf.readLine();
                    index = nameNumberString.indexOf(',');
                    name = nameNumberString.substring(0, index);
                    if (name.equals(newName)) {
                        continue;
                    }
                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
            }
            else {
                raf.close();
                System.out.println(" Input name" + " does not exists. ");
            }
        }

        catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<String> checkCategoryProjectList(){

        List<String> aa = new ArrayList<>();
        Set<String> bb ;

        BufferedReader buffer = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            File file1 = new File(new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/classes/List/ProjectList.txt");
            buffer = new BufferedReader(new FileReader(file1));
            String a = null;
            while ((a = buffer.readLine()) != null){
                String[] data = a.split(",");
                String category = data[10];
                aa.add(data[10]);
            }
            aa = aa.stream().distinct().collect(Collectors.toList());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        }
        return (ArrayList<String>) aa;
    }

    public boolean checkFileNameGeneral(String name){
        ArrayList<GeneralWork> allGeneralWork = readFileGenaralList();
        for (GeneralWork g : allGeneralWork){
            if (g.showJobName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean checkFileNameRegular(String name){
        ArrayList<RegularWork> allRegularWork = readFileRegularList();
        for (RegularWork g : allRegularWork){
            if (g.showJobName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean checkFileNameForward(String name){
        ArrayList<ForwardWork> allForwardWork = readFileForwardList();
        for (ForwardWork g : allForwardWork){
            if (g.showJobName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean checkFileNameProject(String name){
        ArrayList<ProjectWork> allProjectWork = readFileProjectList();
        for (ProjectWork g : allProjectWork){
            if (g.showJobName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
