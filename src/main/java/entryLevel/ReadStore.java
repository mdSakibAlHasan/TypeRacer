package entryLevel;

import java.io.*;
import java.util.Vector;

public class ReadStore {
    Vector<String> nameArray = new Vector<>();
    Vector<String> passArray = new Vector<>();
    private File file = new File("F:\\3rd Semister\\demo1\\pass.txt");


    private void loadMap() throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }

        String name, password;
        while (true)
        {
            try {
                if ((name = br.readLine()) == null)
                    break;
                password = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            nameArray.add(name);
            passArray.add(password);

        }

        br.close();
    }

    public void writeInFile(String userName, String password)
    {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file,true));

            out.write(userName+"\n");
            out.write(password+"\n");

            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Vector<String> getUserNameVector()
    {
        try {
            loadMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nameArray;
    }
}
