package highScore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Read_score {
    private String fileName = "F:\\3rd Semister\\TypeRacer\\high.txt";
    private int size=0;
    private User allUser[] = new User[7];
    private File file;

    public User[] userDetails() throws IOException, ClassNotFoundException{
        file = new File(fileName);

        if(!(file.isFile())){         //there is no history
            return allUser;
        }

        else {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            List<User> userList = (List<User>) in.readObject();
            size = userList.size();
            in.close();

            for (int i = 0; i < userList.size(); i++)
                allUser[i] = userList.get(i);

            return allUser;
        }
    }

    public int getSize(){
        return  size;
    }

}