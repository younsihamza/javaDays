public class Mythread extends Thread{
    private Resource resource;
    private Integer startProsition;
    private Integer endPosition;

    public Mythread(Resource resource, Integer startProsition, Integer endPosition) {
        this.resource       = resource;
        this.startProsition = startProsition;
        this.endPosition    = endPosition;
    }
    @Override
    public void run() {
        resource.sumArray(startProsition, endPosition);
    }

}
