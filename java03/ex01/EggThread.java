public class EggThread extends Thread {
    private Integer iteration;
    private Resource resource;

    EggThread(Integer iteration, Resource resource){
        this.iteration = iteration;
        this.resource = resource;
    }

    @Override
    public void run(){
        for(int i = 0; i < iteration.intValue(); i++) {
            resource.Egg();
        }
    }

}
