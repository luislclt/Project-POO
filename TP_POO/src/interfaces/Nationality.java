package interfaces;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class Nationality implements NationalityContract, java.io.Serializable{
    
    private final String nationality;
    
    public Nationality(String nationality){
        this.nationality = nationality;
    }
    
    /**
     * Método responsável por retornar a nacioalidade de um jogador
     * @return a nacionalidade de um jogador
     */
    @Override
    public String getNationality() {
        return this.nationality;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por retornar a nacionalidade de um jogador
     * @return String nacionalidade
     */
    @Override
    public String toString() {
        return  nationality;
    }
    
}
