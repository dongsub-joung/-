// Get data
// Save(buff) data
// Refresh(merge) data, when "반납" react.
public class volume{
    public final ZERO= -1;
    private int[100] vol;
    
    public void setVol(){
        for(int i=0; i<100; i++) vol[i]= 0;
    }

    public void mergingData(){
        // save files
    }

    // (searching own book) When voume is above zero, block a 대출 btn
    public void inforceZero(int index){
        // GUI: Event Handler
        // Another way: Making "Up && Down btn" and set minimum value as "0" 
    }

    public void turnOn_ZERO(){
        int current_state= vol[index];
        if (current_state == 0) {
            // Show at searching bar -1 code
            print(ZERO);
        } else {
            // Show at searching bar "stock voume"
            print(current_state);
        }
    }
}