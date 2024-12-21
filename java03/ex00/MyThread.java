public class MyThread  implements Runnable{
    private String answer = null;
    private Integer numberOfTime = null;
        public MyThread(String answer, Integer numberOfTime) {
            this.answer = answer;
            this.numberOfTime = numberOfTime;
        }
        @Override
        public void run() {
            try {
                for(int i = 0; i < numberOfTime ;i++) {
                    System.out.println(this.answer);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
}
