
package folhapagamento;

// Classe de funcionarios temporários;


public class FuncionarioTemporario extends Funcionario {
    
    
    private int beneficio_filho = 50;// para caso mude o valor do bonus por filho;
    private int bonus_tempo = 15;//para caso mude o valor do bonus por tempo;
    private double plr;
    
 //-----------------------------------------------------------------------------------------------------------------------------------------//
    
    //inicio metodos de imporatação de construtores;
    
    public FuncionarioTemporario(String Nome, int Codigo, double Salariobase, int Dia, int Mes, int Ano) {
        super(Nome, Codigo, Salariobase, Dia, Mes, Ano);
    }
    public FuncionarioTemporario(int restoano, int restomes, double adicional, double bonus){
        super ( restoano, restomes, adicional, bonus);
      
    }

    //fim metodos de imporatação de construtores;
    
//-----------------------------------------------------------------------------------------------------------------------------------------//   
    

    // // inicio metodo que imprime dados do funcionário

    @Override
    public void imprimeHolerite(){
        
        this.restoano = this.anoAtual - this.Ano;
        this.restomes = this.mesAtual - this.Mes;
        
        int i = Math.abs(this.restomes);
        
        if (i > 0 & this.restoano > 0 || i == 0 & this.restoano > 0 || i > 0 & this.restoano == 0 ){
            System.out.println(" ");
            System.out.println("---- FUNCIONÁRIO TEMPORÁRIO N° " + this.Codigo + " ----");
            System.out.println("NOME: " + this.Nome);
            System.out.printf("SALÁRIO: %.2f", this.Salariobase);
            System.out.println(" ");
            System.out.println("DATA DE CONTRATAÇÃO: " + this.Dia + "/" + this.Mes + "/" + this.Ano);
        }    
            if( i == 0 & this.restoano == 0){System.out.println("TEMPO DE CONTRATAÇÃO: " + this.Dia + "dias");}
            else{System.out.println("TEMPO DE CONTRATAÇÃO: "+ this.restoano + " e " + i + " meses. ");}
       
    } 
    
    // fim metodo metodo que imprime dados do funcionário;
    
    //-----------------------------------------------------------------------------------------//  
    
    
    // inicio metodo que retorna o valor de bonificação por tempo trabalhado;
   
    @Override
    public void bonusportempo(){
        
        this.restoano = this.anoAtual - this.Ano;
        this.restomes = this.mesAtual - this.Mes;
        int i = Math.abs(this.restomes);
        
       
        if (i > 0 & this.restoano == 0){
            this.adicional = i * bonus_tempo;
            System.out.printf("BONIFICAÇÃO POR TEMPO DE SERVÇO R$: %.2f ", this.adicional);
            System.out.println(" ");
        }
        
        if (i == 0 & this.restoano > 0 ){
            double acumulado = this.restoano * 12;
            
            plr = acumulado * bonus_tempo;
            
            System.out.printf("BONIFICAÇÃO POR TEMPO DE SERVÇO: %.2f ", plr); 
            System.out.println(" ");
        }
        
        if( i > 0 & this.restoano > 0){
            
            double acumulado = this.restoano * 12;
            
            plr = (acumulado + i) * bonus_tempo;
            
            System.out.printf("BONIFICAÇÃO POR TEMPO DE SERVÇO: %.2f ", plr); 
            System.out.println(" ");
            
        }
    }  
        
    // fim metodo que retorna o valor de bonificação por tempo trabalhado;
    
//-----------------------------------------------------------------------------------------//
    
    // inicio metodo que retorna o valor de bonificação de até 5 filhos;
    
    @Override
    public void bonusporfilho(){
        
      
        double soma = 0;
        int somafilho = 1;
        
        for(Dependente cont: this.filhos){
            if (cont.getIdade() <= 18){
                soma = soma + somafilho;
            }
            
            if (soma > 5){break;}
            
        }
        
        if (soma == 5){
            System.out.println("-----------------------ATENÇÃO------------------------");
            System.out.println("Sua cobertura é de apenas 5 filhos menores de 18 anos!");
            System.out.println("------------------------------------------------------");
        }
            
        System.out.printf("BENIFICIO POR FILHOS, TOTAL R$: %.2f ", soma * beneficio_filho);
        System.out.println(" ");
        
        this.bonus = this.Salariobase + this.adicional + (soma * beneficio_filho) ; 
            
        System.out.printf("TOTAL DE VALORES A RECEBER R$: %.2f ", this.bonus + plr);
        System.out.println(" ");
        System.out.println(" ");    
        
    }  
     
    // fim metodo que retorna o valor de bonificação de até 5 filhos;
    
    //-----------------------------------------------------------------------------------------//  
    
    // inicio de metodo que adicona filhos na arraylist filhos da classe funcionario;
    @Override
    public void adddependente(Dependente idadedependente){
        this.filhos.add(idadedependente);
    }
    // fim metodo de adicona filhos na arraylist filhos da classe funcionario;
    
    //-----------------------------------------------------------------------------------------------------------------------------------------//
    
}//fim classe;