import java.io.*;

public class Main {
    public static void main(String[] args) {
        String s = "";
        try(FileReader reader = new FileReader("input.txt"))
        {
            int c;
            while ((c = reader.read())!=-1){
                s += (char) c;
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        String [] s2 = new String[s.length()];
        s2 = s.split("");
        String operations = "";

        String minus = "";
        String plus = "";
        String umnojit = "";

        for (int i = 0; i < s2.length; i++){

            switch (s2[i])
            {
                case "*":
                    operations += " * ";
                    break;
                case "-":
                    operations += " - ";
                    break;
                case "+":
                    operations += " + ";
                    break;
                default:
                    operations += s2[i];
            }
        }

        String [] operations2 = operations.split(" ");
        for (int i = 0; i < operations2.length; i++){

            switch (operations2[i])
            {
                case "*":
                    umnojit += Integer.toString(i) + " ";
                    break;
                case "-":
                    minus += Integer.toString(i) + " ";
                    break;
                case "+":
                    plus += Integer.toString(i) + " ";
                    break;
            }
        }

        String [] minus2 = minus.split(" ");
        String [] plus2 = plus.split(" ");
        String [] umnojit2 = umnojit.split(" ");
        int answer = 0;

        int i = 0;
        while (umnojit2[umnojit2.length-1] != "0" && umnojit2[0] != ""){
            int num = Integer.parseInt(umnojit2[i]);
            int res = Integer.parseInt(operations2[num-1]) * Integer.parseInt(operations2[num+1]);
            operations2[num] = Integer.toString(res);
            operations2[num-1] = Integer.toString(res);
            operations2[num+1] = Integer.toString(res);
            umnojit2[i] = "0";
            i++;
            answer = num;
        }

        i = 0;
        while (plus2[plus2.length-1] != "0" && plus2[0] != ""){
            int num = Integer.parseInt(plus2[i]);
            int res =  Integer.parseInt(operations2[num-1]) - Integer.parseInt(operations2[num+1]);
            operations2[num] = Integer.toString(res);
            operations2[num-1] = Integer.toString(res);
            operations2[num+1] = Integer.toString(res);
            plus2[i] = "0";
            i++;
            answer = num;
        }

        i = 0;
        while (minus2[minus2.length-1] != "0" && minus2[0] != ""){
            int num = Integer.parseInt(minus2[i]);
            int res =  Integer.parseInt(operations2[num-1]) - Integer.parseInt(operations2[num+1]);
            operations2[num] = Integer.toString(res);
            operations2[num-1] = Integer.toString(res);
            operations2[num+1] = Integer.toString(res);
            minus2[i] = "0";
            i++;
            answer = num;
        }

        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            writer.write(operations2[answer]);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}