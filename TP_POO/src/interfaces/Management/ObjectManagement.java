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
     * Método insere um {Object objeto} de {ObjectManagement}
     * @param o {Object objeto} a inserir no vetor
     * @return valor booleano sucesso ou insucesso(Vetor cheio)
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
     * Método remove um {Object objeto} do vetor {ObjectManagement}
     * @param i indice correspondente ao elemento a remover
     * @return o {bject objeto} removido
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
     * Método retorna um objeto existente numa determinada posição do vetor
     * @param i indice do elemento a devolver
     * @return objeto do tipo Object
     */
    @Override
    public Object getObject(int i) {
        return this.objects[i];
    }
    
    /**
     * Método para encontrar um {Object objeto} no vetor de {ObjectManagement}
     * @param o objeto a procurar no vetor
     * @return o indice do objeto no vetor. No caso do elemento não existir, deverá ser retornado o valor -1
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
    
}
