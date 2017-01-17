package interfaces.Management;

import interfaces.Standing;
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
public class StandingsManagement implements StandingsManagementContract{
    
    private final Standing objects[]; //Object
    
    /**
     * Construtor que permite a instanciação da classe por valor DEFAULT_SIZE
     */
    public StandingsManagement() {
        this.objects = new Standing[DEFAULT_SIZE];
    }
    
    /**
     * Construtor que permite a instanciação da classe por coleção de objectos
     * @param o uma coleção de objectos
     */
    public StandingsManagement(Standing[] o) {
        this.objects = o;
    }
    
    /**
     * Construtor que permite a instanciação da classe definindo valor maxSize
     * @param maxSize número máximo de elementos permitidos no vetor
     */
    public StandingsManagement(int maxSize) {
        this.objects = new Standing[maxSize];
    }
    
    /**
     * Método {getTeam} responsável por retornar um equipa tendo por base o nome
     * @param arg0 nome
     * @return equipa
     */
    @Override
    public TeamContract getTeam(String arg0) {
        
        TeamContract team = null;
        
        for (int i = 0; i < this.size(); i++) {
            
            Standing standing = (Standing) this.getObject(i);
            
            if(standing.getTeamName().equals(arg0)){
                
                team = standing.getTeam();
                
                return team;
            }
        }
        
        return team;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método insere um {Object objeto} de {ObjectManagement}
     * @param newObject {Object objeto} a inserir no vetor
     * @return valor booleano sucesso ou insucesso(Vetor cheio)
     */
    @Override
    public boolean addObject(Object newObject) {
        int tamanho = this.size();
        if (tamanho == this.objects.length) {
            return false;
        } else {
            this.objects[tamanho] = (Standing) newObject;
            return true;
        }
    }
    
    /**
     * Método remove um {Object objeto} do vetor {ObjectManagement}
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
     * Método para encontrar um {Object objeto} no vetor de {ObjectManagement}
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
     * Método retorna o número de elementos no ObjectManagement
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
        int hash = 7;
        hash = 71 * hash + Arrays.deepHashCode(this.objects);
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
        final StandingsManagement other = (StandingsManagement) obj;
        if (!Arrays.deepEquals(this.objects, other.objects)) {
            return false;
        }
        return true;
    }
    
    
}
