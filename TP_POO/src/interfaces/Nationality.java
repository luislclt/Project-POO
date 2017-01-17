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

    @Override
    public String getNationality() {
        return this.nationality;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return  nationality;
    }
    
}
