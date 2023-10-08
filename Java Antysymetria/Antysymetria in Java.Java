import java.util.*;

public class Antysymetria
{
    public static boolean antisymmetry(String data_input)
    {
        //sprawdzamy, czy napis jest antysymetryczny
        int len = data_input.length();
        for(int i = 0;i < len;i++)
            if(data_input.charAt(i) == data_input.charAt(len - 1 - i))
                return false;
        return true;
    }
    public static int amount_antisymmetry_fragments(String data_input, ArrayList<String> output)
    {
        int count = 0;
        //przechodzimy przez wszystkie możliwe podnapisy
        for(int i = 0; i < data_input.length();i++)
        {
            for (int j = i + 1; j < data_input.length() + 1; j++)
            //sprawdzamy, czy podnapis o indeksach (i, j) jest antysymetryczny
            {
                //Метод substring() возвращает подстроку строки между двумя индексами, или от одного индекса и до конца строки
                String sub = data_input.substring(i, j);
                if(antisymmetry(sub)) {
                    count++;
                    output.add(sub);
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of the string > ");
        int length = input.nextInt();
        System.out.println("Enter your number > ");
        String data_input = input.nextLine();
        data_input = input.nextLine();
        while (data_input.length() != length) {
            System.out.println("The string you entered is not the correct length. Please, try again > ");
            data_input = input.nextLine();
        }
        //example = "11001011" //7
        ArrayList<String> output = new ArrayList<String>();
        //System.out.println(antisymmetrics(data_input));
        System.out.println("Amount of antisymmetry fragments > " + amount_antisymmetry_fragments(data_input, output));
        System.out.print("Antisymmetric fragments > " + output);
    }
}
