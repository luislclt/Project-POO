package interfaces.Management;

import interfaces.Competition;
import interfaces.CompetitionContract;
import interfaces.FixtureContract;
import interfaces.StatusGame;
import java.time.LocalDateTime;
import java.util.Arrays;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class CompetitionManagement implements CompetitionManagementContract, java.io.Serializable{
    
    private final Competition objects[]; //Object
    
    /**
     * Construtor que permite a instanciação da classe por valor DEFAULT_SIZE
     */
    public CompetitionManagement() {
        this.objects = new Competition[DEFAULT_SIZE];
    }
    
    /**
     * Construtor que permite a instanciação da classe por coleção de objectos
     * @param o uma coleção de objectos
     */
    public CompetitionManagement(Competition[] o) {
        this.objects = o;
    }
    
    /**
     * Construtor que permite a instanciação da classe definindo valor maxSize
     * @param maxSize número máximo de elementos permitidos no vetor
     */
    public CompetitionManagement(int maxSize) {
        this.objects = new Competition[maxSize];
    }
    
    /**
     * Método responsável por retornar uma Competição tendo por base o nome e o ano dessa mesma Competição
     * @param competitionName - o nome da competição
     * @param year - o ano/epoca da competição
     * @return uma competição
     */
    @Override
    public CompetitionContract getCompetition(String competitionName, int year) {
        
        Competition competition = null;
        
        for (int i = 0; i < this.size(); i++) {
            
            competition = (Competition) (CompetitionContract) this.getObject(i);
            if(competition.getCaption().equals(competitionName) && competition.getYear() == year){
                return (CompetitionContract) competition;
            }
        }
        return (CompetitionContract) competition;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar uma coleção de jogos agendados tendo por base a Competição e um intervalo de datas
     * @param competition - a competição
     * @param date1 - data inicial
     * @param date2 - data final
     * @return uma coleção de jogos
     */
    @Override
    public FixtureManagementContract getGamesScheduled(CompetitionContract competition, LocalDateTime date1, LocalDateTime date2) {
        
        Competition competitionArg = (Competition) competition; // tem acesso aos extra metedos do Competition
        FixtureManagementContract fixtureManagementRETORNO = null;
        
        for (int i = 0; i < this.size(); i++) { // procura nas competitions para encontrar a competition enviada pelo metedo
            
            Competition competitionByPosition = (Competition) this.getObject(i); // posicao i da competitionManagement
            if(competitionByPosition.getCaption().equals(competitionArg.getCaption())){ // competitionByPosition == competition
                
                if( competitionByPosition.getYear() >= date1.getYear() && competitionByPosition.getYear() <= date2.getYear()){
                    
                    //if(competitionByPosition) // comparar com mes e dias
                    FixtureManagement fixtureManagement = (FixtureManagement) competitionByPosition.getFixture();
                    
                    fixtureManagementRETORNO = new FixtureManagement(fixtureManagement.size()+1);
                    
                    for (int j = 0; j < fixtureManagement.size(); j++) { // procura nos fixtures os jogos agendados

                        FixtureContract fixture = (FixtureContract) fixtureManagement.getObject(j); // posicao j da fixture 

                        if(fixture.getStatus() == StatusGame.TIMED){ // estado do fixture a TIMED --> Scheduled
                            
                            fixtureManagementRETORNO.addObject(fixture); // adiciona os fixtures TIMED
                            
                        }
                    }
                }
            }       
        }
        
        return fixtureManagementRETORNO;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar uma coleção de jogos terminados tendo por base a Competição e um intervalo de datas
     * @param competition - a competição
     * @param date1 - data inicial
     * @param date2 - data final
     * @return uma coleção de jogos
     */
    @Override
    public FixtureManagementContract getGamesEnded(CompetitionContract competition, LocalDateTime date1, LocalDateTime date2) {
        
        Competition competitionArg = (Competition) competition; // tem acesso aos extra metedos do Competition
        FixtureManagementContract fixtureManagementRETORNO = null;
        
        for (int i = 0; i < this.size(); i++) { // procura nas competitions para encontrar a competition enviada pelo metedo
            
            Competition competitionByPosition = (Competition) this.getObject(i); // posicao i da competitionManagement
            if(competitionByPosition.getCaption().equals(competitionArg.getCaption())){ // competitionByPosition == competition
                
                if( competitionByPosition.getYear() >= date1.getYear() && competitionByPosition.getYear() <= date2.getYear()){
                    
                    //if(competitionByPosition) // comparar com mes e dias
                    FixtureManagement fixtureManagement = (FixtureManagement) competitionByPosition.getFixture();
                    
                    fixtureManagementRETORNO = new FixtureManagement(fixtureManagement.size()+1);
                    
                    for (int j = 0; j < fixtureManagement.size(); j++) { // procura nos fixtures os jogos agendados

                        FixtureContract fixture = (FixtureContract) fixtureManagement.getObject(j); // posicao j da fixture 

                        if(fixture.getStatus() == StatusGame.FINISHED){ // estado do fixture a FINISHED --> Ended
                            
                            fixtureManagementRETORNO.addObject(fixture); // adiciona os fixtures FINISHED
                            
                        }
                    }
                }
            }       
        }
        
        return fixtureManagementRETORNO;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por inserir um objeto do vetor de objetos.
     * @param newObject - objeto a inserir no vetor
     * @return Valor que sinaliza o sucesso/insucesso da operação
     */
    @Override
    public boolean addObject(Object newObject) {
        int tamanho = this.size();
        if (tamanho == this.objects.length) {
            return false;
        } else {
            this.objects[tamanho] = (Competition) newObject;
            return true;
        }
    }
    
    /**
     * Método responsável por remover um objeto do vetor de objetos.
     * @param position - índice correspondente ao elemento a eliminar
     * @return o objeto eliminado
     */
    @Override
    public Object removeObject(int position) {
        Object remover = this.objects[position];
        for (int j = position; j < this.size() - 1; j++) {
            this.objects[j] = this.objects[j + 1];
        }
        this.objects[this.size()-1] = null;
        return remover;
    }
    
    /**
     * Método responsável por retornar um objeto existente numa determinada posição do vetor de objetos.
     * @param position - índice do elemento a devolver
     * @return objeto do tipo Object
     */
    @Override
    public Object getObject(int position) {
        return this.objects[position];
    }
    
    /**
     * Método responsável por encontrar um objeto no vetor de objetos
     * @param obj - objeto a procurar no vetor
     * @return o índice do objeto no vetor. No caso do elemento não existir, deverá ser retornado o valor -1
     */
    @Override
    public int findObject(Object obj) {
        for (int i = 0; i < this.size(); i++) {
            if (this.objects[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Método responsável por retornar o número de elementos na Competição
     * @return o número de posições, mas não nulas
     */
    public int size() {
        int i = 0;
        while (this.objects[i] != null && i < this.objects.length) {
            i++;
        }
        return i;
    }
    
    /**
     * Método responsável por imprimir todos os objectos da coleção de competições
     * @return retorna a String 
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" ");
        for (int i = 0; i < this.size(); i++) {
            str.append(this.getObject(i).toString()).append(" \n");
        }

        return str.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Arrays.deepHashCode(this.objects);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompetitionManagement other = (CompetitionManagement) obj;
        if (!Arrays.deepEquals(this.objects, other.objects)) {
            return false;
        }
        return true;
    }
    
}
