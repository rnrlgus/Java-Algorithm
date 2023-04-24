import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        BigInteger answer = new BigInteger(N);
        answer = answer.multiply(new BigInteger("2"));
        answer = answer.subtract(new BigInteger("2"));

        System.out.println(!N.equals("1")? answer : 1);
    }

}
