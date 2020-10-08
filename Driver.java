import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment3 {
    public static void main(String[] args) throws IOException {
        Pair p;
        Student s;
        int a;
        BufferedReader reader;
        if(args[1].compareTo("SCBST")==0){
            try {
                HashTable1 h2 = new HashTable1<Pair<String, String>, Student>(Integer.parseInt(args[0]));
                reader = new BufferedReader(new FileReader(args[2]));
                String line = reader.readLine();
                while (line != null) {
                    String[] tokens = line.split(" ");
                    switch (tokens[0]) {
                        case "insert":
                            p = new Pair<String, String>(tokens[1], tokens[2]);
                            s = new Student(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                            a= h2.insert(p,s);
                            if(a!=-1) {
                                System.out.println(a);
                                break;
                            }
                            else {
                                System.out.println("E");
                                break;
                            }
                        case "update":
                            p = new Pair<String, String>(tokens[1], tokens[2]);
                            s = new Student(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                             a= h2.update(p,s);
                            if(a!=-1) {
                                System.out.println(a);
                                break;
                            }
                            else {
                                System.out.println("E");
                                break;
                            }
                        case "delete":
                            p = new Pair<String, String>(tokens[1], tokens[2]);
                            a= h2.delete(p);
                            if(a!=-1) {
                                System.out.println(a);
                                break;
                            }
                            else {
                                System.out.println("E");
                                break;
                            }
                        case "contains":
                            p = new Pair<String, String>(tokens[1], tokens[2]);
                            if (h2.contains(p)) {
                                System.out.println("T");
                                break;
                            } else {
                                System.out.println("F");
                                break;
                            }
                        case "get":
                            try {
                                p = new Pair<String, String>(tokens[1], tokens[2]);
                                s = (Student) h2.get(p);
                                System.out.println(s.fname + " " + s.lname + " " + s.hostel + " " + s.department + " " + s.cgpa);
                                //h2.display();
                                break;
                            } catch (NotFoundException e) {
                                System.out.println("E");
                                break;
                            }
                        case "address":
                            try {
                                p = new Pair<String, String>(tokens[1], tokens[2]);
                                System.out.println(h2.address(p));
                                break;
                            } catch (NotFoundException e) {
                                System.out.println("E");
                                break;
                            }

                    }
                    line = reader.readLine();
                }
                reader.close();
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        else{
            try {
                HashTable2 h2 = new HashTable2<Pair<String, String>, Student>(Integer.parseInt(args[0]));
                reader = new BufferedReader(new FileReader(args[2]));
                String line = reader.readLine();
                while (line != null) {
                    String[] tokens = line.split(" ");
                    switch (tokens[0]) {
                        case "insert":
                            p = new Pair<String, String>(tokens[1], tokens[2]);
                            s = new Student(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                            a= h2.insert(p,s);
                            if(a!=-1) {
                                System.out.println(a);
                                break;
                            }
                            else {
                                System.out.println("E");
                                break;
                            }
                        case "update":
                            p = new Pair<String, String>(tokens[1], tokens[2]);
                            s = new Student(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                            a= h2.update(p,s);
                            if(a!=-1) {
                                System.out.println(a);
                                break;
                            }
                            else {
                                System.out.println("E");
                                break;
                            }
                        case "delete":
                            p = new Pair<String, String>(tokens[1], tokens[2]);
                            a= h2.delete(p);
                            if(a!=-1) {
                                System.out.println(a);
                                break;
                            }
                            else {
                                System.out.println("E");
                                break;
                            }
                        case "contains":
                            p = new Pair<String, String>(tokens[1], tokens[2]);
                            if (h2.contains(p)) {
                                System.out.println("T");
                                break;
                            } else {
                                System.out.println("F");
                                break;
                            }
                        case "get":
                            try {
                                p = new Pair<String, String>(tokens[1], tokens[2]);
                                s = (Student) h2.get(p);
                                System.out.println(s.fname + " " + s.lname + " " + s.hostel + " " + s.department + " " + s.cgpa);
                                //h2.display();
                                break;
                            } catch (NotFoundException e) {
                                System.out.println("E");
                                break;
                            }
                        case "address":
                            try {
                                p = new Pair<String, String>(tokens[1], tokens[2]);
                                System.out.println(h2.address(p));
                                break;
                            } catch (NotFoundException e) {
                                System.out.println("E");
                                break;
                            }
                    }
                    line = reader.readLine();
                }
                reader.close();
            }
             catch(FileNotFoundException e){
                        e.printStackTrace();
                    } catch(IOException e){
                        e.printStackTrace();
                    }
                }
    }
}


