public class Resource {
    private Boolean isEgg;
    
    Resource(){
        isEgg = true;
    }
    public synchronized void Egg(){
        try{
            while(!isEgg) {
                wait();
            }
            System.out.println("EGG");
            isEgg = false;
            notify();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized void Hen(){
        try{
            while(isEgg) {
                wait();
            }
            System.out.println("HEN");
            isEgg = true;
            notify();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
