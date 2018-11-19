public class FrogSimulation {

    private int goalDistance;
    private int maxHops;

    public FrogSimulation(int dist, int numHops){
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance(){
        return (int)(Math.random()*10 + 1);
    }

    public boolean simulate(){
        int pos = 0;
        for(int i = 0; i < maxHops; i++){
            pos += hopDistance();
            if(pos < 0){
                return false;
            }
            if(pos >= goalDistance){
                return true;
            }
        }
        return false;
    }

    public double runSimulations(int num){
        int total = num;
        int success = 0;
        while(num > 0){
            if(simulate()){
                success++;
            }
            num--;
        }
        return (double) success / (double) total;
    }
}
