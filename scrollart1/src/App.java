import java.util.Random;

public class App {
        static final String sign1 = "*";
        static final String sign2 = "+";
        static final String sign3 = "#";
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int num = rand.nextInt(3);
        while(true){
            int numSpaces = rand.nextInt(120);
            if(num == 0){
            System.out.print(sign1);
            for(int s = 0; s < numSpaces; s++){
            }
            } else if(num == 1){
                System.out.print(sign2);
            } else{
                System.out.print(sign3);
            }
            for(int s = 0; s < numSpaces; s++){
                System.out.print(" ");
            }
            num = rand.nextInt(3);
        }
    }
}
