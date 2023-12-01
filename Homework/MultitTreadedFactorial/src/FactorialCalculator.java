import java.math.BigInteger;

class FactorialTask implements Runnable {
    private final int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        BigInteger result = calculateFactorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }

    private BigInteger calculateFactorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}

public class FactorialCalculator {
    public static void main(String[] args) {
        int numCalculations = 10; // Кількість обчислень факторіалу

        for (int i = 1; i <= numCalculations; i++) {
            FactorialTask task = new FactorialTask(i);
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
