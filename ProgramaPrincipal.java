/*
 * ALUNO: JHONNY GUIMARÃES;
 * ATP PROGRAMAÇÃO ORIENTADA Á OBJETOS;
 * PROGRAMA PRINCIPAL (MAIN);
 * PROJETO FOLHA DE PAGAMENTO;
 */
package folhapagamento;




import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;

import java.util.Scanner;



public class ProgramaPrincipal {
       

    
//-----------------------------------------------------------------------------------------------------------------------------------------//
    
    public static void main(String[] args) {
        
        try{
        
        Calendar cal = Calendar.getInstance();
        int Atual = cal.get(Calendar.YEAR);
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Dependente> filhos = new ArrayList<> ();
        
    
        System.out.println("----------------------------------");
        System.out.println("--------FOLHA DE PAGAMENTO--------");
        System.out.println("----------------------------------\n");
         
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite a quantidade de funcionários: ");
           
        int qtaFunc = teclado.nextInt();teclado.nextLine();
            
        System.out.println(" ");
            
               
//-----------------------------------------------------------------------------------------------------------------------------------------//

    // Recebendo dados do cliente;
    // variaveis de dados armazenados;
    
        int cont = 0;
        
    // inicio de laço de repetição para armazenamento de dados dos funcionários;
    
        while (cont < qtaFunc){
            
            
            System.out.println("---------- Funcionário " + cont + " ---------");
            System.out.println("----------------------------------");
            System.out.print("Nome do Funcionário: ");
            String Nome = teclado.nextLine();
              
            System.out.print("Informe o código do Funcionário: ");
            int Codigo = teclado.nextInt();teclado.nextLine();
                
            System.out.print("Salário do Funcionário: ");
            double Salariobase = (double) teclado.nextDouble();
            System.out.println(" ");
            
            System.out.println("'Digite a data de contratação' \n");
            
            System.out.print("Digite o dia: ");
            int Dia = teclado.nextInt(); teclado.nextLine();
                if(Dia > 31 || Dia == 0){System.out.println("Quantidade não permitida");break;}
                
            System.out.print("Digite o mês: ");
            int Mes = teclado.nextInt(); teclado.nextLine();
                if(Mes > 12 || Mes < 1 ){System.out.println("Quantidade não permitida");break;}
                
            System.out.print("Digite o ano: ");
            int Ano = teclado.nextInt(); teclado.nextLine();
                if(Ano > Atual || Ano == 0){System.out.println("Quantidade não permitida");break;}
                              
            System.out.println("Informe o tipo de Funcionário:"); // tipo do funcionario ao qual pertencente;
            System.out.println("1 - Conscursado ou 2 - Temporário");
            System.out.print("Tipo :");
            int Tipo = teclado.nextInt(); teclado.nextLine();
                if(Tipo == 1 || Tipo == 2){}
                else{System.out.println("'Valor incorreto, digite 1 - Conscursado ou 2 - Temporário'");break;}
            
            System.out.print("Você possui filhos? quantos? ");
            int numfilhos = teclado.nextInt();teclado.nextLine();
            
           
//-----------------------------------------------------------------------------------------------------------------------------------------//            
            

            if (numfilhos > 0){
            
                
                //inicio de sub-laço de repetição para armazenamento de dados dos dependentes;
            
                int j = 0;
            
                while( j  < numfilhos){
                    
                    
                    System.out.print("Digite a idade do filho N°" + j + ": ");
                    int idade = teclado.nextInt();teclado.nextLine();
                
                    Dependente idadedependente = new Dependente (idade) {};
                    filhos.add(idadedependente);
                    
                    j++;
                
                }
                
                // fim de sublaço de repetição (while);
                
            }
            
            else{
                System.out.println("OK!");
            }
//-----------------------------------------------------------------------------------------------------------------------------------------// 

           
        // separando os dados por tipo de funcionário;
            
            // funcionario Concursado;
            
            if ( Tipo == 1){
            
                Funcionario concursado =  new FuncionarioConcursado( Nome, Codigo, (float) Salariobase, Dia, Mes, Ano);
                funcionarios.add(concursado);
                System.out.println(" ");
                
                    
                if (numfilhos > 0){
                    for ( Dependente x : filhos){
                          concursado.adddependente(x);
                        
                    }
                }  
                
            } 
            
            //funcionário Temporário;
            
            else{
                 
                Funcionario temporario = new FuncionarioTemporario( Nome, Codigo, Salariobase, Dia, Mes, Ano);
                funcionarios.add(temporario);
                System.out.println(" ");
                
               
                
                if (numfilhos > 0){
                    for ( Dependente x : filhos){
                        temporario.adddependente(x);
                        
                    } 
                }
                
            }   
            cont++;
        }
        // fim de laço de repetição principal(while);
        
//-----------------------------------------------------------------------------------------------------------------------------------------//         
    // laços de repetição de listas armazenadas, com metodos de retorno inbutidos das respectivas classes;
        
        for(Funcionario func: funcionarios){
            func.imprimeHolerite();func.bonusportempo();func.bonusporfilho();
            
        }
    // fim de laços (for);  
    
 //-----------------------------------------------------------------------------------------------------------------------------------------//    
    }catch(InputMismatchException erro){ System.out.println("Você digitou letras ou simbolos ao invés de números, tente novamente! ");}
            
    
    
    finally{System.out.println(" ");System.out.println("--------------- FIM ---------------");}
    
}//fim de void main;
    
}// fim de classe;

