
package pethotel.beans;


public class Pet {
    
    //clase pet apenas serve para identificar o pet, não tendo outro motivo para mudança
    //princio do "S"olid
    
    
    // atributos privados para que uma clase não consiga mexer em outra
    private int id;
    private String tutor, nome, sexo, idade, peso, castrado, dataCuidados, cuidadosEspeciais, medicamentos;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getTutor() {
    return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
 
    public String getCastrado() {
        return castrado;
    }

    public void setCastrado(String castrado) {
        this.castrado = castrado;
    }

    public String getDataCuidados() {
        return dataCuidados;
    }

    public void setDataCuidados(String dataCuidados) {
        this.dataCuidados = dataCuidados;
    }

    public String getCuidadosEspeciais() {
        return cuidadosEspeciais;
    }

    public void setCuidadosEspeciais(String cuidadosEspeciais) {
        this.cuidadosEspeciais = cuidadosEspeciais;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    
    


   
    
}
