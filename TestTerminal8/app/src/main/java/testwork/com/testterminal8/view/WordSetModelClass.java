package testwork.com.testterminal8.view;

public class WordSetModelClass {

    int Num=0,Status=0;
    String Woed;

    public WordSetModelClass(String woed , int num, int status){
        this.Num = num;
        this.Status = status;
        this.Woed = woed;
    }

    public int getNum() {
        return Num;
    }

    public int getStatus() {
        return Status;
    }

    public String getWoed() {
        return Woed;
    }
}
