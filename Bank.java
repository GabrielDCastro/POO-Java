package javaapplication1;

public class contabanco {
    //atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    //métodos personalizados
    public void estado(){
        System.out.println("-------------------------------------");
        System.out.println("Conta "+this.getNumConta());
        System.out.println("Tipo "+this.getTipo());
        System.out.println("Dono "+this.getDono());
        System.out.println("Saldo "+this.getSaldo());
        System.out.println("Status "+this.getStatus());
    }
    
    public void abrirConta(String tipo){
        this.setTipo(tipo);
        this.setStatus(true);
        if (tipo == "CC"){
            this.setSaldo(50);//tanto essa forma quanto a de baixo estão corretas
        }else if(tipo=="CP"){
            this.saldo=150;//mas a de cima é "mais correta"
        }
    }
    public void fecharConta(){
        if (this.getSaldo()>0){
            System.out.println("Não pode fehcar pq tem money");
        }
        else if (this.getSaldo()<0){
            System.out.println("Não pode fehcar pq tem divida, safado");
        }else{
            this.setStatus(false);
            System.out.println("Conta fechada");
        }
    }
    public void depositar(float valor){
        if (this.getStatus()){//se o status for verdadeiro dá bom
            //this.saldo=this.saldo+valor; forma menor certa
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito feito na conta do " +this.getDono());
        }else{
            System.out.println("Conta não existe");
        }
    }
    public void sacar(float valor){
        if(this.getStatus()){
            if(this.getSaldo()>=valor){
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado na conta de " + this.getDono());
            }else{
                System.out.println("Saldo insuficiente");
            }
        }else{
            System.out.println("Conta não existe");
        }
        
    }
    public void pagarMensal(){
        int v=0;
        if (this.getTipo() == "CC"){
            v=12;
        }else if(this.getTipo() == "CP"){
            v=20;
        }
        if(this.getStatus()){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga");
        }else{
            System.out.println("Conta não existe");
        }
        
    }
    //Métodos especiais]
    //construtor
    public contabanco(){
        this.saldo=0;
        this.status=false;
        //sempre que criar uma nova conta ela vira sempre com saldo 0 e status falso
    }
    //setter
    public void setNumConta(int numConta){
        this.numConta =numConta;
    }
    //getter
    public int getNumConta(){
        return this.numConta;
    } 
    
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
