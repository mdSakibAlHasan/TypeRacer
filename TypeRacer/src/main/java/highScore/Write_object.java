package highScore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;


public class Write_object {
    private String fileName = "F:\\3rd Semister\\TypeRacer\\high.txt";
    private int size;


    public void writeDetails(String name, int speed) {
        try {
            Read_score score = new Read_score();
            User allUser[] = score.userDetails();
            size = score.getSize();

            allUser[size] = new User(name, speed);        //new user in game

            sort2(allUser);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            List<User> userList = new ArrayList<>();

            for (int i = 0; i <= size && i < 5; i++)
                userList.add(allUser[i]);


            out.writeObject(userList);
            out.close();

            for (int i = 0; i <= size; i++) {
                System.out.println(allUser[i].getName() + "    " + allUser[i].getTime());
            }
        }catch (IOException e){
            System.out.println(e);
        }catch (ClassNotFoundException e){
            System.out.println(e);

         }



}

    public void sort2(User allUser[]){

        for(int i=0;i<=size;i++){
            for(int j=0;j<=size;j++){
                if (allUser[i].getTime() < allUser[j].getTime()) {
                    allUser[6] = allUser[i];
                    allUser[i] = allUser[j];
                    allUser[j] = allUser[6];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Read_score read_score = new Read_score();
       User user[] =  read_score.userDetails();

       for(int i=0;i< read_score.getSize();i++){
           System.out.println("fgfg "+user[i].getName()+"  "+user[i].getTime());
       }

    }

}

