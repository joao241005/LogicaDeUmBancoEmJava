package co.bank;
import java.util.List;
import java.util.ArrayList;

public class Bank {
    private String ag;

    private int LastAccout = 1;
    private List<Accout> accouts;

    public Bank(String ag){
        this.ag = ag;
        this.accouts = new ArrayList<>();
    }

    public List<Accout> getAccouts(){
        return accouts;
    }

    public void InsertAccout(Accout accout){
        accouts.add(accout);
    }

    public Accout generateAccout(String name){
        Accout accout = new Accout(ag,"" + LastAccout,name);
        LastAccout++;
        return accout;
    }

    public void ImprimirTotal(){

        double total = 0;
        for(Accout accout: accouts){
           double b = accout.getSaldo();
           total += b;
        }
        System.out.println("Banco Possui : R$ " + total);
    }


}
