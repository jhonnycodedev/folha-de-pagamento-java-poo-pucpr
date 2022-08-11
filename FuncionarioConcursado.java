
package folhapagamento;

// Classe de Funcionários Concursados;


public class FuncionarioConcursado extends Funcionario {
    
    private int bonus_filho = 100;// para caso mude o valor do bonus por filho;
    private int bonus_tempo = 200;//para caso mude o valor do bonus por tempo;
    
//-----------------------------------------------------------------------------------------------------------------------------------------//
    
    //inicio metodos de imporatação de construtores;

    public FuncionarioConcursado(String Nome, int Codigo, double Salariobase, int Dia, int Mes, int Ano) {
        super(Nome, Codigo, Salariobase, Dia, Mes, Ano);
    }
    public FuncionarioConcursado(int restoano, int restomes, double adicional, double bonus){
        super ( restoano, restomes, adicional, bonus);
    } 
    
    //fim metodos de imporatação de construtores;
    
//-----------------------------------------------------------------------------------------------------------------------------------------//   
    

    // inicio metodo que imprime dados do funcionário;
    
    @Override
    public void imprimeHolerite(){
        
        this.restoano = this.anoAtual - this.Ano;
        this.restomes = this.mesAtual - this.Mes;
        
        
        int i = Math.abs(this.restomes);
        if (i > 0 & this.restoano > 0){
            System.out.println(" ");
            System.out.println("---- FUNCIONÁRIO CONCURSADO N° " + this.Codigo + "----");
            System.out.println("NOME: " + this.Nome);
            System.out.printf("SALÁRIO: %.2f", this.Salariobase);
            System.out.println(" ");
            System.out.println("DATA DE CONTRATAÇÃO: " + this.Dia + "/" + this.Mes + "/" + this.Ano);
        }
            if( i == 0 & this.restoano == 0){System.out.println("TEMPO DE CONTRATAÇÃO: " + this.Dia + "dias");}
            else{System.out.println("TEMPO DE CONTRATAÇÃO: "+ this.restoano + " anos e " + i + " meses.");}
            
        
    }
   
    // fim metodo metodo que imprime dados do funcionário;
       
    //-----------------------------------------------------------------------------------------// 
    
    // inicio metodo que retorna o valor de bonificação por tempo trabalhado;    
    
    @Override
    public void bonusportempo(){
        
        this.restoano = this.anoAtual - this.Ano;
        this.restomes = this.mesAtual - this.Mes;
        
        this.adicional = this.restoano * bonus_tempo;
        
        System.out.printf("BONIFICAÇÃO POR TEMPO DE SERVIÇO R$: %.2f", this.adicional);
        System.out.println(" ");
        
    }    
        
        
    @Override
    public void bonusporfilho(){
        
      
        double soma = 0;
        int somafilho = 1;
        
        for(Dependente cont: this.filhos){
            if (cont.getIdade() <= 21){
                soma = soma + somafilho;
            }
            
            if (soma > 5){break;}
            
        }
        
        if (soma == 5){
            System.out.println("-----------------------ATENÇÃO------------------------");
            System.out.println("Sua cobertura é de apenas 5 filhos menores de 21 anos!");
            System.out.println("------------------------------------------------------");
        }
            
        System.out.printf("BENIFICIO POR FILHOS, TOTAL R$: %.2f ", soma * bonus_filho);
        System.out.println(" ");
        
        this.bonus = this.Salariobase + this.adicional + (soma * bonus_filho) ; 
            
        System.out.printf("TOTAL DE VALORES A RECEBER R$: %.2f ", this.bonus);
        System.out.println(" ");
        System.out.println(" ");    
        
    }  
    
    
    // fim metodo que retorna o valor de bonificação por tempo trabalhado;
    
    //-----------------------------------------------------------------------------------------//  
    
    // inicio metodo de limite de filhos;
    
    @Override
    public void adddependente(Dependente idadedependente){
        this.filhos.add(idadedependente);
       
    }
    
    // fim metodo de limite de filhos;
    
//-----------------------------------------------------------------------------------------------------------------------------------------//      
}//fim classe;
    
