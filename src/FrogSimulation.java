public class FrogSimulation {

    private int goalDistance;
    private int maxHops;
    private String result = "";

    public FrogSimulation(int dist, int numHops){
        goalDistance = dist;
        maxHops = numHops;
        result += "Goal: " + goalDistance + ", Hops:   ";
    }

    private int hopDistance(){
        int num = (int)((Math.random()*25) - 5);
        result += num + "   ";
        return num;
    }

    public boolean simulate(){
        int pos = 0;
        for(int i = 0; i < maxHops; i++){
            pos += hopDistance();
            if(pos < 0){
                result += "        Failed Reached Negative Distance";
                return false;
            }
            if(pos >= goalDistance){
                result += "        Success Final Distance: " + pos;
                return true;
            }
        }
        result += "        Failed Final Distance: " + pos;
        return false;

    }

    public double runSimulations(int num){
        int total = num;
        int success = 0;
        while(num > 0){
            if(simulate()){
                success++;
            }
            System.out.println(result);
            result = "Goal: " + goalDistance + ", Hops:   ";
            num--;
        }
        return (double) success / total;
    }
}
