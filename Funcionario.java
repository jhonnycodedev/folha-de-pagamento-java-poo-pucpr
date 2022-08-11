
package folhapagamento;

import java.util.ArrayList;
import java.util.Calendar;

// Classe Principal de atributos globais dos Funcionarios(Super);

public abstract class  Funcionario {
        protected ArrayList<Dependente> filhos = new ArrayList<>(); // lista de filhos;
        
        String Nome;
        int Codigo;
        double Salariobase;
        int Dia;
        int Mes;
        int Ano;
        int restoano;
        int restomes;
        public int mesAtual;
        public int anoAtual;
        double adicional;
        double bonus;
        int qtafilhos;
        
//-----------------------------------------------------------------------------------------------------------------------------------------//
    
       
    // inicio a contrutores de acesso;
    
       
    public  Funcionario(String Nome, int Codigo, double Salariobase, int Dia, int Mes, int Ano) {
        this.Nome = Nome;
        this.Codigo = Codigo;
        this.Salariobase = Salariobase;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Ano = Ano;
        
    }

    public Funcionario(int restoano, int restomes, double adicional, double bonus) {
        this.restoano = restoano;
        this.restomes = restomes;
        this.adicional = adicional;
        this.bonus = bonus;
    }

    public Funcionario(int qtafilhos) {
        this.qtafilhos = qtafilhos;
    }
    
    
    //fim de construtores de acesso;
    
  
//-----------------------------------------------------------------------------------------------------------------------------------------//
    
    // inicio dos metodos de acesso a tributos privados;
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public double getSalariobase() {
        return Salariobase;
    }

    public void setSalariobase(double Salariobase) {
        this.Salariobase = Salariobase;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getQtafilhos() {
        return qtafilhos;
    }

    public void setQtafilhos(int qtafilhos) {
        this.qtafilhos = qtafilhos;
    }

    public int getRestoano() {
        return restoano;
    }

    public void setRestoano(int restoano) {
        this.restoano = restoano;
    }

    public int getRestomes() {
        return restomes;
    }

    public void setRestomes(int restomes) {
        this.restomes = restomes;
    }

    public double getAdicional() {
        return adicional;
    }

    public void setAdicional(double adicional) {
        this.adicional = adicional;
    }

    public ArrayList<Dependente> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<Dependente> filhos) {
        this.filhos = filhos;
    }

   
    
    // fim dos metodos de acesso a tributos privados;
   
//-----------------------------------------------------------------------------------------------------------------------------------------//
    //importando datas atuais para calculo de bonificação;
    {   
    Calendar cal = Calendar.getInstance();
        this.mesAtual = cal.get(Calendar.MONTH) + 1;
        this.anoAtual = cal.get(Calendar.YEAR);
    } 
    // fim de importação;
    
    //-----------------------------------------------------------------------------------------------------------------------------------------// 
    
    // inicio do metodo de impressão padrão para subclasses;
    
     public abstract void imprimeHolerite();
    
    // fim do metodo de impressão padrão para subclasses;
    
//-----------------------------------------------------------------------------------------------------------------------------------------// 

    // inicio do metodo de impressão padrão de bonificação para subclasses;
    
    public abstract void bonusportempo();
    
    // fim do metodo de impressão padrão de bonificaçãopara subclasses;    

 
//-----------------------------------------------------------------------------------------------------------------------------------------//   
    
    // inicio metodo de limite de filhos;
    
    public abstract void adddependente(Dependente idadedependente);
    
    // fim metodo de limite de filhos;

   
    public abstract void bonusporfilho();
    
    
    
    
}//fim classe;   

    
    
    
    
    
    
    
    
    
    

