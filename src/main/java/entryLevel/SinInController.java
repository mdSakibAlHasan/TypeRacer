package entryLevel;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SinInController {
    private String userName, pass;
    Vector<String> nameArray = new Vector<>();
    Vector<String> passArray = new Vector<>();


    public SinInController(String userName, String password)
    {
        this.userName = userName;
        this.pass = password;
    }

    public boolean isUser()
    {
        loadMap();

        String str1,str2;
                for(int i=0;i<nameArray.size();i++) {
                    str1 = nameArray.get(i);
                    str2 = passArray.get(i);
                    if (str1.equals(userName) && str2.equals(pass)) {
                        return true;
                    }
                }


        return false;
    }

    private void loadMap()
    {
        File file = new File("F:\\3rd Semister\\demo1\\pass.txt");

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
    }

}
