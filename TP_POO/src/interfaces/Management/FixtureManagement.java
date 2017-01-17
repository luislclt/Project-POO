package interfaces.Management;

import interfaces.Fixture;
import interfaces.FixtureContract;
import interfaces.Team;
import interfaces.TeamContract;
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
public class FixtureManagement implements FixtureManagementContract, java.io.Serializable{
    
    private final Fixture objects[]; //Object
    
    /**
     * Construtor que permite a instanciação da classe por valor DEFAULT_SIZE
     */
    public FixtureManagement() {
        this.objects = new Fixture[DEFAULT_SIZE];
    }
    
    /**
     * Construtor que permite a instanciação da classe por coleção de objectos
     * @param o uma coleção de objectos
     */
    public FixtureManagement(Fixture[] o) {
        this.objects = o;
    }
    
    /**
     * Construtor que permite a instanciação da classe definindo valor maxSize
     * @param maxSize número máximo de elementos permitidos no vetor
     */
    public FixtureManagement(int maxSize) {
        this.objects = new Fixture[maxSize];
    }
    
    /**
     * Método responsável por retornar um jogo tendo por base a semana do jogo, e as equipas que participam no jogo
     * @param arg0 - a semana do jogo
     * @param arg1 - equipa da casa
     * @param arg2 - equipa visitante
     * @return um dado jogo
     */
    @Override
    public FixtureContract getFixture(int arg0, TeamContract arg1, TeamContract arg2) {
        
        //FixtureManagementContract fixtureManagement = (FixtureManagementContract) getObject(0);
        Fixture fixture = null;
        for (int i = 0; i < this.size(); i++) {
            
            fixture = (Fixture) this.getObject(i);
            //System.out.println("\n --> this.getObject(i) TeamContract team name"+team.getName());
            if(fixture.getMatchday() == arg0){
                
                Team team1 = (Team) fixture.getHomeTeam();
                
                if(team1.getName().equals(arg1.getName())){
                    
                    Team team2 = (Team) fixture.getAwayTeam();
                    
                    if(team2.getName().equals(arg2.getName())){
                        
                        return (FixtureContract) this.getObject(i);
                    } 
                }
            }
        }
        return fixture;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por inserir um objeto numa coleção de jogos
     * @param newObject - objeto a inserir no vetor
     * @return valor booleano sucesso ou insucesso(Vetor cheio)
     */
    @Override
    public boolean addObject(Object newObject) {
        int tamanho = this.size();
        if (tamanho == this.objects.length) {
            return false;
        } else {
            this.objects[tamanho] = (Fixture) newObject;
            return true;
        }
    }
    
    /**
     * Método responsável por remover um objeto do vetor de jogos
     * @param position - indice correspondente ao elemento a remover
     * @return o objeto removido
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
     * Método responsável por retornar um objeto existente numa determinada posição do vetor
     * @param position - indice do elemento a devolver
     * @return o objeto
     */
    @Override
    public Object getObject(int position) {
        return this.objects[position];
    }
    
    /**
     * Método responsável por encontrar um objeto no vetor de jogos
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
     * Método responsável por retornar o número de elementos na coleção de jogos
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
     * Método responsável por imprimir todos os objectos da coleção
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
        hash = 73 * hash + Arrays.deepHashCode(this.objects);
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
        final FixtureManagement other = (FixtureManagement) obj;
        if (!Arrays.deepEquals(this.objects, other.objects)) {
            return false;
        }
        return true;
    }
    
    
    
}
