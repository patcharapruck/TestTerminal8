package testwork.com.testterminal8.view;

public class WordsModelClass {

    int Num=0,Status=0;
    String Woed;

    public WordsModelClass(String woed ,int num,int status){
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
