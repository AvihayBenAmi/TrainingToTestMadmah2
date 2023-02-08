public class Bucket {
    private int capacity;
    private int current;

    public Bucket() {
        this.capacity = capacity;
        this.current = current;
    }

    public String toString(){
        return "The current state for the bucket: "+this.current+" of "+this.capacity+" liters.";
    }
    public boolean isEmpty(){
        boolean answer=false;
        if(this.current==0){
            answer=true;
        }
        return answer;
    }
    public boolean isFull(){
        boolean answer=false;
        if(this.current==this.capacity){
            answer=true;
        }
        return answer;
    }
    public float precent(){
        float answer=0;
        answer=this.current/this.capacity*100;
        return answer;
    }
    public boolean addLitre(){
        boolean answer=false;
        if(!isFull()){
            this.current++;
            answer=true;
        }
        return answer;
    }
    public int addLitrs(int amount){
        int answer=0;
        int temp=0;
        if(this.current+amount<=this.capacity){
            this.current=this.current+amount;
        }
        else{
            temp=this.capacity-this.current;
            this.capacity=this.capacity+temp;
            answer=amount-temp;
        }
        return answer;
    }
    public boolean spill(){
        boolean answer=false;
        if(this.current!=0){
           this.current=0;
           answer=true;
        }
        return answer;
    }
    public boolean spill(int amount){
        boolean answer=false;
        if(this.current-amount>=0){
            this.current=this.current-amount;
            answer=true;
        }
        return answer;
    }
    public void fill(){
        this.current=this.capacity;
    }
    public void fill(Bucket other){
        int temp=this.capacity-this.current;
        if(temp<=other.current){
            this.current=this.capacity;
            other.current=other.current-temp;
        }
        else{
            this.current= other.current;
            other.current=0;
        }
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getCurrent(){
        return current;
    }
}
