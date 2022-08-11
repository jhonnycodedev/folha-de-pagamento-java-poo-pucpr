
package folhapagamento;

// classe de atributos de filhos dependentes;

public abstract class Dependente {
    private int idade;

 //-----------------------------------------------------------------------------------------------------------------------------------------//    
    
//inicio metodosconstrutores; 
    
    public Dependente(int idade) {
        this.idade = idade;
    }
//fim metodos construtores;  
    
    
 //-----------------------------------------------------------------------------------------------------------------------------------------//   
    
// inicio de metodos de acesso a tributos privados;    
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

 // fim de metodos de acesso a tributos privados;    
    
    
  //-----------------------------------------------------------------------------------------------------------------------------------------//   
    
}//fim classe;
    
    
    
