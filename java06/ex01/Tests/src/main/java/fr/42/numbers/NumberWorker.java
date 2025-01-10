package numbers;
public class NumberWorker {

    class IllegalNumberException extends RuntimeException{
        public IllegalNumberException () {
            super("illegal Number ");
        }
    }

    public boolean isPrime(int number) {
        if( number < 2 )
            throw new IllegalNumberException();
        for(int i = 2; i < number; i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public int digitsSum(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
