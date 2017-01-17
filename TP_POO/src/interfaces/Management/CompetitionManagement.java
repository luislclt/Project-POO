package interfaces.Management;

import interfaces.Competition;
import interfaces.CompetitionContract;
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
public class CompetitionManagement implements CompetitionManagementContract{
    
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
     * Método {getCompetition} responsável por retornar uma Competição
    * tendo por base o nome e o ano dessa mesma Competição
     * @param competitionName
     * @param year
     * @return 
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
     * Método {getGamesScheduled} responsável por retornar uma coleção de jogos agendados
     * tendo por base a Competição e um intervalo de datas
     * @param competition
     * @param date1
     * @param date2
     * @return 
     */
    @Override
    public FixtureManagementContract getGamesScheduled(CompetitionContract competition, LocalDateTime date1, LocalDateTime date2) {
        
        
        
        
        /*
        Competition competitionByPosition = null;
        Competition competitionArg = (Competition) competition;
        
        for (int i = 0; i < this.size(); i++) {
            
            competitionByPosition = (Competition) this.getObject(i);
            if(competitionByPosition.getCaption().equals(competitionArg.getCaption())
                    && competitionByPosition.getYear() >= date1.getYear() && competitionByPosition.getYear() <= date2.getYear()){
                
                //Team team = competitionByPosition  
            }  
        }*/
        
        /*
        TeamContract team = null;
        
        for (int i = 0; i < this.size(); i++) {
            
            team = (TeamContract) this.getObject(i);
            //System.out.println("\n --> this.getObject(i) TeamContract team name"+team.getName());
            if(team.getName().equals(arg0)){
                //System.out.println("\n TeamManagement --> getTeam("+arg0+" ) --> retorno TeamContract -> nameTeam : "+team.getName());
                return team;
            }
        }
        */
        
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método {getGamesEnded} responsável por retornar uma coleção de jogos terminados 
     * tendo por base a Competição e um intervalo de datas
     * @param competition
     * @param date1
     * @param date2
     * @return 
     */
    @Override
    public FixtureManagementContract getGamesEnded(CompetitionContract competition, LocalDateTime date1, LocalDateTime date2) {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método insere um {Object objeto} de {CompetitionManagement}
     * @param newObject {Object objeto} a inserir no vetor
     * @return valor booleano sucesso ou insucesso(Vetor cheio)
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
     * Método remove um {Object objeto} do vetor {CompetitionManagement}
     * @param position indice correspondente ao elemento a remover
     * @return o {bject objeto} removido
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
     * Método retorna um objeto existente numa determinada posição do vetor
     * @param position indice do elemento a devolver
     * @return objeto do tipo Object
     */
    @Override
    public Object getObject(int position) {
        return this.objects[position];
    }
    
    /**
     * Método para encontrar um {Object objeto} no vetor de {CompetitionManagement}
     * @param obj objeto a procurar no vetor
     * @return o indice do objeto no vetor. No caso do elemento não existir, deverá ser retornado o valor -1
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
     * Método retorna o número de elementos no CompetitionManagement
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
     * Método imprime todos os objectos da coleção
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
