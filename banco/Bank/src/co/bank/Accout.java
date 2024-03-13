package co.bank;

public class Accout {
    private String ag;
    private String cc;
    private String name;
    private double saldo;

    private static final int MAX_LENGTH = 12;

    private Log logger;

    public Accout(String ag,String cc, String name){
        this.ag = ag;
        this.cc = cc;
        setname(name);
        logger = new Log();
    }

    //FUNÇÃO SACAR DINHEIRO
    public boolean Sacar(double value){

        if(saldo < value){
            logger.out("SAQUE - R$" + value + " seu saldo atual e de: "+ saldo);
            return false;
        }
        saldo -= value;
        logger.out("SAQUE - R$" + value + " Sua conta agora é de R$" + saldo);
        return true;
    }
    public  void setname(String name){
            if (name.length() > MAX_LENGTH){
                this.name = name.substring(0,MAX_LENGTH);

            }else {
                this.name = name;
            }
        System.out.println(this.name);
    }

    //FUNÇÃO DEPOSITAR DINHEIRO
    public boolean Deposito(double value){
        saldo += value;
        logger.out("DEPOSITO - R$" + value +" SUA CONTA AGORA E DE R$" + saldo);
        return true;
    }

    public double getSaldo(){
        return saldo;
    }

    @Override
    public String toString(){
        return "A conta " + this.name + " Agência: " + this.ag + "/" + this.cc + " possui : R$ " + saldo;
    }
}




