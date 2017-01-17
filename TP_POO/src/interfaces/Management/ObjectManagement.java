package interfaces.Management;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class ObjectManagement implements ObjectManagementContract{
    
    private final Object objects[];
    
    /**
     * Construtor que permite a instanciação da classe por valor DEFAULT_SIZE
     */
    public ObjectManagement() {
        this.objects = new Object[DEFAULT_SIZE];
    }
    
    /**
     * Construtor que permite a instanciação da classe por coleção de objectos
     * @param o uma coleção de objectos
     */
    public ObjectManagement(Object[] o) {
        this.objects = o;
    }
    
    /**
     * Construtor que permite a instanciação da classe definindo valor maxSize
     * @param maxSize número máximo de elementos permitidos no vetor
     */
    public ObjectManagement(int maxSize) {
        this.objects = new Object[maxSize];
    }
    
    /**
     * Método responsável por inserir um objeto do vetor de objetos
     * @param o - objeto a inserir no vetor
     * @return valor que sinaliza o sucesso/insucesso da operação
     */
    @Override
    public boolean addObject(Object o) {
        int tamanho = this.size();
        if (tamanho == this.objects.length) {
            return false;
        } else {
            this.objects[tamanho] = o;
            return true;
        }
    }
    
    /**
     * Método responsável por remover um objeto do vetor de objetos.
     * @param i - índice correspondente ao elemento a eliminar
     * @return o objeto eliminado
     */
    @Override
    public Object removeObject(int i) {
        Object remover = this.objects[i];
        for (int j = i; j < this.size() - 1; j++) {
            this.objects[j] = this.objects[j + 1];
        }
        this.objects[this.size()-1] = null;
        return remover;
    }
    
    /**
     * Método responsável por retornar um objeto existente numa determinada posição do vetor de objetos.
     * @param i - índice do elemento a devolver
     * @return objeto do tipo Object
     */
    @Override
    public Object getObject(int i) {
        return this.objects[i];
    }
    
    /**
     * Método responsável por encontrar um objeto no vetor de objetos
     * @param o - objeto a procurar no vetor
     * @return o índice do objeto no vetor. No caso do elemento não existir, deverá ser retornado o valor -1
     */
    @Override
    public int findObject(Object o) {
        for (int i = 0; i < this.size(); i++) {
            if (this.objects[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Método responsável por retornar o número de elementos no vetor de objetos
     * @return índice do elemento a devolver
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
    
}
