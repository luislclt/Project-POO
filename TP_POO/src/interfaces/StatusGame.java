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
public enum StatusGame implements Status{
    
    FINISHED, TIMED, IN_PLAY, CANCELED, POSTPONED;
    
    /**
     * Método que retorna uma representação textual do estado de um jogo
     * 
     * @param status da representação textual
     * * FINISHED, TIMED, IN_PLAY
     * @return representação textual do status
     */
    public static String getStatusGame(StatusGame status){
        switch(status){
            case FINISHED:
                return "FINISHED";
            case TIMED: 
                return "TIMED";
            case IN_PLAY:
                return "IN PLAY";
            default:
                return "Inválido";
        }
    }
    
}
