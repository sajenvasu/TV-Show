import java.util.*;
import java.io.*;

public class TV_Show{

    static String file_name = "show.txt";
    static String show_name;
    static int episode;
    static int season;
    static Scanner SC = new Scanner(System.in);

    public static void main(String[] args){ 
        Open_File();
        Show_Data();
        Menu();
        UP_MSG();
        Show_Data();
    }

    public static void Change_Data(int key){

        if (key == 0){
            System.out.print("Enter Show Name\n>> ");
            show_name = SC.nextLine();
            System.out.print("\nEnter Season Number\n>> ");
            season = SC.nextInt();
            System.out.print("\nEnter Episode Number\n>> ");
            episode = SC.nextInt();
        }else{

            System.out.println("\nChange Settings:");
            System.out.println("1) Name of the Show");
            System.out.println("2) Season of the Show");
            System.out.println("3) Episode of the Show");
            System.out.print("4) Reset\nEnter Number >> ");
            String choice = SC.nextLine();

            if (choice.equals("1")){
                System.out.print("\nEnter Show Name\n>> ");
                show_name = SC.nextLine();
            }else if(choice.equals("2")){
                System.out.print("\nEnter Season Number\n>> ");
                season = SC.nextInt();
            }else if (choice.equals("3")){
                System.out.print("\nEnter Episode Number\n>> ");
                episode = SC.nextInt();
            }else if (choice.equals("4")){
                System.out.print("\nEnter Show Name\n>> ");
                show_name = SC.nextLine();
                season = 1;
                episode = 1;
            }else{
                System.out.println("Please choose a valid option!");
            }
        }

    }

    public static void UP_MSG(){

        if (show_name.length() > 8 && show_name.length() < 16){
            System.out.print("\n|-----------------------|");
            System.out.print("\n|     Updated List\t|\n");
        }else if(show_name.length() > 16){
            System.out.print("\n|-------------------------------|");
            System.out.print("\n|         Updated List\t\t|\n");
        }else{
            System.out.print("\n|---------------|");
            System.out.print("\n| Updated List \t|\n");
        }
    }

    public static void Show_Data(){
    	
        if (show_name.length() > 8 && show_name.length() < 16){
            System.out.println("|-----------------------|");
            System.out.println("|Name: " + show_name + "\t|");
            System.out.println("|Season: " + season + "\t\t|");
            System.out.println("|Episode: " + episode + "\t\t|");
            System.out.println("|-----------------------|");
        }else if (show_name.length() > 16) {
            System.out.println("|-------------------------------|");
            System.out.println("|Name: " + show_name + "\t|");
            System.out.println("|Season: " + season + "\t\t\t|");
            System.out.println("|Episode: " + episode + "\t\t\t|");
            System.out.println("|-------------------------------|");
        }else{
            System.out.println("|---------------|");
            System.out.println("|Name: " + show_name + "\t|");
            System.out.println("|Season: " + season + "\t|");
            System.out.println("|Episode: " + episode + "\t|");
            System.out.println("|---------------|");

        }
    }

    public static void Menu(){
    	
        System.out.print("\nMenu:\n1) Next Episode\n2) Next Season\n3) Change Show Information\n4) Exit\nEnter Number >> ");
        String choice = SC.nextLine();

        if (choice.equals("1")){
            episode = episode + 1;
            Write_File();
        }else if (choice.equals("2")){
            season = season + 1;
            episode = 1;
            Write_File();
        }else if (choice.equals("3")){
            Change_Data(5);
            Write_File();
        }else if (choice.equals("4")){
            
        }else{
            System.out.println("Please choose a valid option!");
        }
    }

    public static void Read_File(){

        try (BufferedReader br = new BufferedReader(new FileReader(file_name))){
            String str = ""; 
            while ((str = br.readLine()) != null){ 
                // System.out.println(str);
                String[] Arr = str.split(",");
                show_name = Arr[0];
                season = Integer.parseInt(Arr[1]);
                episode = Integer.parseInt(Arr[2]);
            }
        }catch(IOException e){
            System.out.println("Error:\n");
            
        }
    }

    public static void Write_File(){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_name))){
            bw.write(show_name + "," + season + "," + episode);
            bw.close();
        }catch (Exception ex){
            System.out.println("Error: Updating a File\n");
        }
    }

    public static void Open_File(){
    	
        File F = new File(file_name);
        boolean EX = F.exists();

        if (EX == true){
            Read_File();            
        }else{
            Change_Data(0);
            Write_File();
            System.out.println("");
        }
    }

}
