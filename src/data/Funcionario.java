
package data;
    // Clásse
public class Funcionario {
    // ( Comentários )
    
    //Atributos da classe
    
    private String matricula;
    private String nome;
    private String cargo;
    private double salario;
    
  // Construtor da Classe

    public Funcionario() {
    }
 
  // Método getter e setter  

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
    
    
}
